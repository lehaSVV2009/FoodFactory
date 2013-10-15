/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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


/**
 *
 * @author Fox
 */
public abstract class BaseDao <T extends Entity> {

    public ArrayList<T> get() {
        ArrayList<T> content = new ArrayList<T>();
        String query = "SELECT * FROM " + getTableName();
        try
        {
            Connection conn = MysqlManager.getInstance().getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                T ex = createInstance();
                for(int i=0; i<getColumnNames().length; i++) {
                    setColumnValue(ex, i, getObjectFromRes(getColumnClasses()[i],rs,i));
                }
                content.add(ex);
            }
            rs.close();
            st.close();
            conn.close();
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        return content;
    }

    public T find(Object id) {
        ArrayList<T> content = get();
        for(T item : content) {
            if(getColumnValue(item, idRow()-1).equals(id)) {
                return item;
            }
        }
        return null;
    }

    public T find(T entity) {
        ArrayList<T> content = get();
        for(T item : content) {
            if(getColumnValue(item, idRow()-1).equals(getColumnValue(entity, idRow()-1))) {
                return item;
            }
        }
        return null;
    }

    public int remove(T entity) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM ");
        query.append(getTableName());
        query.append(" WHERE ");
        query.append(getColumnNames()[idRow()-1]);
        query.append(" = ?");

        try
        {
            Connection conn = MysqlManager.getInstance().getConnection();
            PreparedStatement  st = conn.prepareStatement(query.toString());
            setObjectToRes(getColumnClasses()[idRow()-1], st, idRow(), getColumnValue(entity, idRow()-1));
            //System.out.println(query.toString());
            int res = st.executeUpdate();
            st.close();
            conn.close();
            return res;
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
            return -1;
        }
    }


    public int save(T entity) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ");
        query.append(getTableName());
        query.append("(");
        query.append(getColumnNames()[0]);
        for(int i = 1; i < getColumnClasses().length; i++) {
            query.append(", ");
            query.append(getColumnNames()[i]);
        }
        query.append(") VALUES(?");
        for(int i = 1; i < getColumnClasses().length; i++) {
            query.append(",?");
        }
        query.append(")");
        try
        {
            Connection conn = MysqlManager.getInstance().getConnection();
            PreparedStatement  st = conn.prepareStatement(query.toString());
            for(int i=0; i<getColumnNames().length; i++) {
                setObjectToRes(getColumnClasses()[i], st, i+1, getColumnValue(entity, i));
            }
            //System.out.println(query.toString());
            int res = st.executeUpdate();
            st.close();
            conn.close();
            return res;
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
            return -1;
        }
    }

    public int update(T entity) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ");
        query.append(getTableName());
        query.append(" SET ");
        query.append(getColumnNames()[0]);
        query.append(" = ? ");
        for(int i = 1; i < getColumnClasses().length; i++) {
            query.append(", ");
            query.append(getColumnNames()[i]);
            query.append(" = ? ");
        }
        query.append(" WHERE ");
        query.append(getColumnNames()[idRow()-1]);
        query.append(" = ?");

        try
        {
            Connection conn = MysqlManager.getInstance().getConnection();
            PreparedStatement  st = conn.prepareStatement(query.toString());
            for(int i=0; i<getColumnNames().length; i++) {
                setObjectToRes(getColumnClasses()[i], st, i+1, getColumnValue(entity, i));
            }
            setObjectToRes(getColumnClasses()[idRow()-1], st, getColumnNames().length+1, getColumnValue(entity, idRow()-1));
            //System.out.println(query.toString());
            int res = st.executeUpdate();
            st.close();
            conn.close();
            return res;
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
            return -1;
        }
    }


    protected Object getObjectFromRes(Class type,ResultSet rs, Integer i) throws SQLException {
        if(String.class.equals(type)) {
            return rs.getString(getColumnNames()[i]);
        } else if(Integer.class.equals(type)) {
            return rs.getInt(getColumnNames()[i]);
        } else if(Date.class.equals(type)) {
            return rs.getDate(getColumnNames()[i]);
        }
        return null;
    }

    protected void setObjectToRes(Class type,PreparedStatement prest, Integer i,Object value) throws SQLException {
        if(String.class.equals(type)) {
            prest.setString(i,(String)value);
        } else if(Integer.class.equals(type)) {
            prest.setInt(i,(Integer)value);
        } else if(Date.class.equals(type)) {
            prest.setDate(i,(Date)value);
        }
    }

    protected abstract String getTableName();

    protected abstract String[] getColumnNames();

    protected abstract Class[] getColumnClasses();

    protected abstract Object getColumnValue(T entity, int columnNumber);

    protected abstract void setColumnValue(T entity, int columnNumber, Object value);

    protected abstract T createInstance();

    protected abstract int idRow();

}
