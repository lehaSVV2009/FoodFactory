package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.ProductDao;
import com.kadet.foodFactory.entity.Product;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public class ProductDaoImpl extends AbstractDaoImpl<Product> implements ProductDao {

    private final static String PRODUCT_TABLE_NAME = "Product";

    private final static String[] COLUMN_NAMES = {
            "idProduct",
            "name",
            "ProductGroup_id"
    };

    private final static Class[] COLUMN_TYPES = {
            Integer.class,
            String.class,
            Integer.class
    };

    private static final Integer ID_COLUMN = 0;

    @Override
    protected String getTableName() {
        return PRODUCT_TABLE_NAME;
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
    protected Product createInstance() {
        return new Product();
    }

    @Override
    protected Object getValue(Integer columnNum, Product entity) {
        switch (columnNum) {
            case 0 : return entity.getIdProduct();
            case 1 : return entity.getName();
            case 2 : return entity.getProductGroup_Id();
        }
        return null;
    }

    @Override
    protected void setEntityColumn(Product entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0 : entity.setIdProduct((Integer) value);
                return;
            case 1 : entity.setName((String) value);
                return;
            case 2 : entity.setProductGroup_Id((Integer) value);
                return;
        }
    }

}