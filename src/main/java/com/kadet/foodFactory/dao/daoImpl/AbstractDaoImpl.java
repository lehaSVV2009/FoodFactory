package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.AbstractDao;
import com.kadet.foodFactory.entity.Entity;
import com.kadet.foodFactory.util.MysqlManager;

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

    public E findById (Object id) {
        return (E) id;
    }

    public E findByEntity (E entity) {
        return entity;
    }

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
            int lastPreparedStatementIndex = getColumnNames().length + 1;
            setPreparedStatementTypes(
                    statement,
                    getValue(getIdColumnNum(), entity),
                    lastPreparedStatementIndex,
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
        if (Date.class.equals(columnType)) {
            statement.setDate(columnIndex, (Date) value);
            return;
        }
    }

    public int delete (Object id) {
        return -1;
    }

    public List<E> findAll () {
        return new ArrayList<E>();
    }


    abstract protected String getTableName ();

    abstract protected String[] getColumnNames ();

    abstract protected String getIdColumnName ();

    abstract protected Integer getIdColumnNum ();

    abstract protected Class getIdColumnType ();

    abstract protected Class[] getColumnTypes ();

    abstract protected Object getValue(Integer columnNum, E entity);

}
