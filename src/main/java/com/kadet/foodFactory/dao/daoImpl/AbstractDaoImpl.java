package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.AbstractDao;
import com.kadet.foodFactory.entity.Entity;
import com.kadet.foodFactory.util.MysqlManager;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 0:43
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDaoImpl<E extends Entity> implements AbstractDao<E> {

    public int save (E entity) {
        int result = -1;
        String query = createSaveQuery(
                getTableName(),
                getColumnNames()
        );
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(query);
            setPreparedStatement(
                    statement,
                    entity,
                    getColumnNames(),
                    getColumnTypes()
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

    private String createSaveQuery (String tableName, String []columnNames) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ")
             .append(tableName)
             .append("(")
             .append(columnNames[0]);
        for (int columnNum = 1; columnNum < columnNames.length; ++columnNum) {
            query.append(", ")
                 .append(columnNames[columnNum]);
        }
        query.append(") VALUES(?");
        for (int columnNum = 1; columnNum < columnNames.length; ++columnNum) {
            query.append(",?");
        }
        query.append(")");
        return query.toString();
    }

    public int update (E entity) {
        int result = -1;
        String query = createUpdateQuery(
                getTableName(),
                getColumnNames(),
                getIdColumnName()
        );
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(query);
            setPreparedStatement(
                    statement,
                    entity,
                    getColumnNames(),
                    getColumnTypes()
            );
            int idPreparedStatementIndex = getColumnNames().length + 1;
            setPreparedStatementTypes(
                    statement,
                    getValue(getIdColumnNum(), entity),
                    idPreparedStatementIndex,
                    getIdColumnType()
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

    private String createUpdateQuery (String tableName, String []columnNames, String idColumnName) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ")
             .append(tableName)
             .append(" SET ")
             .append(columnNames[0])
             .append(" = ? ");
        for (int columnNum = 1; columnNum < columnNames.length; ++columnNum) {
            query.append(", ")
                 .append(columnNames[columnNum])
                 .append(" = ? ");
        }
        query.append(" WHERE ")
             .append(idColumnName)
             .append(" = ?");
        return query.toString();
    }

    private void setPreparedStatement (PreparedStatement statement, E entity, String []columnNames, Class []columnTypes) throws SQLException {
        for (int columnNum = 0; columnNum < columnNames.length; ++columnNum) {
            int columnIndex = columnNum + 1;
            setPreparedStatementTypes(
                    statement,
                    getValue(columnNum, entity),
                    columnIndex,
                    columnTypes[columnNum]
            );
        }
    }

    private void setPreparedStatementTypes (PreparedStatement statement, Object value, Integer columnIndex, Class columnType) throws SQLException {
        if (String.class.equals(columnType)) {
            statement.setString(columnIndex, (String) value);
            return;
        }
        if (Integer.class.equals(columnType)) {
            statement.setInt(columnIndex, (Integer) value);
            return;
        }
        if (Double.class.equals(columnType)) {
            statement.setDouble(columnIndex, (Double) value);
        }
        if (Date.class.equals(columnType)) {
            statement.setDate(columnIndex, (Date) value);
            return;
        }
    }

    public E findByEntity (E entity) {
        List<E> content = findAll();
        int idColumn = getIdColumnNum();
        Object id = getValue(idColumn, entity);
        for (E contentEntity : content) {
            Object contentEntityId = getValue(idColumn, contentEntity);
            if (id.equals(contentEntityId)) {
                return contentEntity;
            }
        }
        return null;
    }

    public E findById (Object id) {
        List<E> content = findAll();
        for (E entity : content) {
            Object entityId
                    = getValue(getIdColumnNum(), entity);
            if (id.equals(entityId)) {
                return entity;
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
             .append(" = ? ");
        return query.toString();
    }

    public int delete (E entity) {
        int result = -1;
        String query = createDeleteQuery(getTableName(), getIdColumnName());
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(query);
            int statementIndex = 1;
            setPreparedStatementTypes(
                    statement,
                    getValue(getIdColumnNum(), entity),
                    statementIndex,
                    getIdColumnType()
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

    public List<E> findAll () {
        List<E> result = new ArrayList<E>();
        String query = createSelectAllQuery(getTableName());
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            result
                    = getAllFromResultSet(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            result.clear();
            MysqlManager.log(e);
        }
        return result;
    }

    private String createSelectAllQuery (String tableName) {
        return new StringBuilder()
                .append("SELECT * FROM ")
                .append(tableName)
                .toString();
    }

    private List<E> getAllFromResultSet (ResultSet resultSet) throws SQLException {
        List<E> result = new ArrayList<E>();
        Class[] columnTypes = getColumnTypes();
        String[] columnNames = getColumnNames();
        while (resultSet.next()) {
            E entity = createInstance();
            for (int columnNum = 0; columnNum < columnTypes.length; ++columnNum) {
                setEntityColumn(
                        entity,
                        columnNum,
                        getColumnFromResultSet(resultSet, columnTypes[columnNum], columnNames[columnNum])
                );
            }
            result.add(entity);
        }
        return result;
    }

    private Object getColumnFromResultSet (ResultSet resultSet, Class columnType, String columnName) throws SQLException {
        if (String.class.equals(columnType)) {
            return resultSet
                    .getString(columnName);
        }
        if (Integer.class.equals(columnType)) {
            return resultSet
                    .getInt(columnName);
        }
        if (Double.class.equals(columnType)) {
            return resultSet
                    .getDouble(columnName);
        }
        if (Date.class.equals(columnType)) {
            return resultSet
                    .getDate(columnName);
        }
        return new Object();
    }

    private Class getIdColumnType() {
        return getColumnTypes()[getIdColumnNum()];
    }

    private String getIdColumnName() {
        return getColumnNames()[getIdColumnNum()];
    }


    abstract protected String getTableName ();

    abstract protected String[] getColumnNames ();

    abstract protected Integer getIdColumnNum ();

    abstract protected Class[] getColumnTypes ();

    abstract protected Object getValue (Integer columnNum, E entity);

    abstract protected E createInstance ();

    abstract protected void setEntityColumn (E entity, int columnNum, Object value);

}
