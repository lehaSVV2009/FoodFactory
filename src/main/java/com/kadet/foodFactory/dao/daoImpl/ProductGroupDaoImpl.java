package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.ProductDao;
import com.kadet.foodFactory.dao.ProductGroupDao;
import com.kadet.foodFactory.entity.ProductGroup;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:27
 * To change this template use File | Settings | File Templates.
 */
public class ProductGroupDaoImpl extends AbstractDaoImpl<ProductGroup> implements ProductGroupDao {

    private final static String PRODUCT_GROUP_TABLE_NAME = "ProductGroup";

    private final static String[] COLUMN_NAMES = {
            "idProductGroup",
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
        return PRODUCT_GROUP_TABLE_NAME;
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
    protected Object getValue(Integer columnNum, ProductGroup entity) {
        switch (columnNum) {
            case 0 : return entity.getIdProductGroup();
            case 1 : return entity.getCode();
            case 2 : return entity.getName();
        }
        return null;
    }

    @Override
    protected ProductGroup createInstance() {
        return new ProductGroup();
    }

    @Override
    protected void setEntityColumn(ProductGroup entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0 : entity.setIdProductGroup((Integer) value);
                return;
            case 1 : entity.setCode((String) value);
                return;
            case 2 : entity.setName((String) value);
                return;
        }
    }
}
