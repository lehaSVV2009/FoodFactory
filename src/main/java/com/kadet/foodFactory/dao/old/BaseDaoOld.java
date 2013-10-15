package com.kadet.foodFactory.dao.old;


import com.kadet.foodFactory.util.MysqlManager;
import com.kadet.foodFactory.entity.Entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 1:55
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseDaoOld<T extends Entity> {

    public List<T> getAll() {

        List<T> result = new ArrayList<T>();
        String query = "SELECT * FROM " + getTableName();
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            result = listFromResultSet(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            MysqlManager.log(e);
        }
        return result;
    }

    protected List<T> listFromResultSet(ResultSet resultSet) throws SQLException {
        List<T> result = new ArrayList<T>();
        while (resultSet.next()) {
            T entity = createInstance();
            Class[] columnTypes = getColumnClasses();
            for (int columnNumber = 0; columnNumber < columnTypes.length; ++columnNumber) {
                setColumnValue(
                        entity,
                        columnNumber,
                        castResultByType(columnTypes[columnNumber], resultSet, columnNumber)
                );
            }
            result.add(entity);
        }
        return result;
    }

    /**
     * cast returned by ResultSet object to definite type (class)
     *
     * @param type
     * @param resultSet
     * @param columnNumber
     * @return
     * @throws SQLException
     */
    private Object castResultByType(Class type, ResultSet resultSet, Integer columnNumber) throws SQLException {
        if (String.class.equals(type)) {
            return resultSet
                    .getString(getColumnNames()[columnNumber]);
        } else if (Integer.class.equals(type)) {
            return resultSet
                    .getInt(getColumnNames()[columnNumber]);
        } else if (Date.class.equals(type)) {
            return resultSet
                    .getDate(getColumnNames()[columnNumber]);
        }
        return resultSet.getObject(getColumnNames()[columnNumber]);
    }

    public T find(Object id) {
        List<T> content = this.getAll();
        for (T item : content) {
            if (id.equals(getId(item))) {
                return item;
            }
        }
        return null;
    }

    public T find(T entity) {
        List<T> content = this.getAll();
        for (T item : content) {
            if (getId(item)
                    .equals(getId(entity))) {
                return item;
            }
        }
        return null;
    }


    private String createDeleteQuery (String tableName, String idColumnName) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM ")
                .append(tableName)
                .append(" WHERE ")
                .append(idColumnName)
                .append(" = ?");
        return query.toString();
    }

    public int remove(T entity) {
        int result = -1;
        String query = createDeleteQuery(getTableName(), getColumnNames()[idRow()]);
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            setPreparedStatementTypes(
                    statement,
                    getId(entity),
                    getIdType(),
                    idRow()
            );
            result = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            result = -1;
            MysqlManager.log(e);
        }
        return result;
    }


    protected void setPreparedStatementTypes (PreparedStatement preparedStatement, Object value, Class type, Integer columnNumber) throws SQLException {
        if (String.class.equals(type)) {
            preparedStatement
                    .setString(columnNumber + 1, (String) value);
        } else if (Integer.class.equals(type)) {
            preparedStatement
                    .setInt(columnNumber + 1, (Integer) value);
        } else if (Date.class.equals(type)) {
            preparedStatement
                    .setDate(columnNumber + 1, (Date) value);
        } else {
            preparedStatement
                    .setObject(columnNumber + 1, value);
        }
    }


    private String createSaveQuery (String tableName, String []columnNames) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ")
                .append(tableName)
                .append("(")
                .append(columnNames[0]);
        for (int columnNum = 1; columnNum < columnNames.length; columnNum++) {
            query.append(", ")
                    .append(columnNames[columnNum]);
        }
        query.append(") VALUES(?");
        for (int columnNum = 1; columnNum < columnNames.length; columnNum++) {
            query.append(",?");
        }
        query.append(")");
        return query.toString();
    }

    public int save(T entity) {
        int result = -1;
        String []columnNames = getColumnNames();
        String query = createSaveQuery(getTableName(), columnNames);
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            for (int columnNum = 0; columnNum < columnNames.length; columnNum++) {
                setPreparedStatementTypes(
                        statement,
                        getColumnValue(entity, columnNum),
                        getColumnClasses()[columnNum],
                        columnNum
                );
            }
            result = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            result = -1;
            MysqlManager.log(e);
        }
        return result;
    }

    private String createUpdateQuery (String tableName, String []columnNames, String idColumnName) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ")
                .append(tableName)
                .append(" SET ")
                .append(columnNames[0])
                .append(" = ? ");
        for (int i = 1; i < columnNames.length; i++) {
            query.append(", ");
            query.append(columnNames[i]);
            query.append(" = ? ");
        }
        query.append(" WHERE ");
        query.append(idColumnName);
        query.append(" = ?");
        return query.toString();
    }

    public int update(T entity) {
        int result = -1;
        String []columnNames = getColumnNames();
        String query = createUpdateQuery(getTableName(), getColumnNames(), getColumnNames()[idRow()]);
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            for (int columnNumber = 0; columnNumber < columnNames.length; columnNumber++) {
                setPreparedStatementTypes(
                        statement,
                        getColumnValue(entity, columnNumber),
                        getColumnClasses()[columnNumber],
                        columnNumber
                );
//                setObjectToRes(getColumnClasses()[columnNumber], statement, columnNumber + 1, getColumnValue(entity, columnNumber));
            }
            result = statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            result = -1;
            MysqlManager.log(e);
        }
        return result;
    }


    protected void setObjectToRes(Class type, PreparedStatement prest, Integer i, Object value) throws SQLException {
        if (String.class.equals(type)) {
            prest.setString(i, (String) value);
        } else if (Integer.class.equals(type)) {
            prest.setInt(i, (Integer) value);
        } else if (Date.class.equals(type)) {
            prest.setDate(i, (Date) value);
        }
    }


    protected abstract String getTableName();

    protected abstract String[] getColumnNames();

    protected abstract Class[] getColumnClasses();

    protected abstract Object getColumnValue(T entity, int columnNumber);

    protected abstract void setColumnValue(T entity, int columnNumber, Object value);

    protected abstract T createInstance();

    protected abstract int idRow();

    protected Object getId (T entity) {
        return getColumnValue(entity, idRow());
    }

    protected Class getIdType() {
        return getColumnClasses()[idRow()];
    }
}

