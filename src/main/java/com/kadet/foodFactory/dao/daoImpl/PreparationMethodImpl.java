package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.PreparationMethodDao;
import com.kadet.foodFactory.entity.PreparationMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:26
 * To change this template use File | Settings | File Templates.
 */
public class PreparationMethodImpl extends AbstractDaoImpl<PreparationMethod> implements PreparationMethodDao {

    private final static String PREPARATION_METHOD_TABLE_NAME = "PreparationMethod";

    private final static String[] COLUMN_NAMES = {
            "idPreparationMethod",
            "code",
            "name"
    };

    private final static Class[] COLUMN_TYPES = {
            Integer.class,
            String.class,
            String.class
    };

    private static final Integer ID_COLUMN = 0;

    @Override
    protected String getTableName() {
        return PREPARATION_METHOD_TABLE_NAME;
    }

    @Override
    protected String[] getColumnNames() {
        return COLUMN_NAMES;
    }

    @Override
    protected Integer getIdColumnNum() {
        return ID_COLUMN;
    }

    @Override
    protected Class[] getColumnTypes() {
        return COLUMN_TYPES;
    }


    @Override
    protected Object getValue(Integer columnNum, PreparationMethod entity) {
        switch (columnNum) {
            case 0:
                return entity.getIdPreparationMethod();
            case 1:
                return entity.getCode();
            case 2:
                return entity.getName();
        }
        return null;
    }

    @Override
    protected PreparationMethod createInstance() {
        return new PreparationMethod();
    }

    @Override
    protected void setEntityColumn(PreparationMethod entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0:
                entity.setIdPreparationMethod((Integer) value);
                return;
            case 1:
                entity.setCode((String) value);
                return;
            case 2:
                entity.setName((String) value);
                return;
        }
    }
}
