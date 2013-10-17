package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.ProviderDao;
import com.kadet.foodFactory.entity.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:28
 * To change this template use File | Settings | File Templates.
 */
public class ProviderDaoImpl extends AbstractDaoImpl<Provider> implements ProviderDao {

    private final static String PROVIDER_TABLE_NAME = "Provider";

    private final static String[] COLUMN_NAMES = {
            "idProvider",
            "code",
            "name",
            "address",
            "phone"
    };

    private final static Class[] COLUMN_TYPES = {
            Integer.class,
            String.class,
            String.class,
            String.class,
            String.class
    };

    private static final Integer ID_COLUMN = 0;


    @Override
    protected String getTableName() {
        return PROVIDER_TABLE_NAME;
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
    protected Object getValue(Integer columnNum, Provider entity) {
        switch (columnNum) {
            case 0 : return entity.getIdProvider();
            case 1 : return entity.getCode();
            case 2 : return entity.getName();
            case 3 : return entity.getAddress();
            case 4 : return entity.getPhone();
        }
        return null;
    }

    @Override
    protected Provider createInstance() {
        return new Provider();
    }

    @Override
    protected void setEntityColumn(Provider entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0 : entity.setIdProvider((Integer) value);
                return;
            case 1 : entity.setCode((String) value);
                return;
            case 2 : entity.setName((String) value);
                return;
            case 3 : entity.setAddress((String) value);
                return;
            case 4 : entity.setPhone((String) value);
                return;
        }
    }
}
