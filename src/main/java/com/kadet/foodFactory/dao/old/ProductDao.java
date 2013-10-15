package com.kadet.foodFactory.dao.old;

import com.kadet.foodFactory.entity.Product;


/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 1:58
 * To change this template use File | Settings | File Templates.
 */
public class ProductDao extends BaseDao<Product> {

    private final static String TABLE_NAME = "product";

    private final Integer idRow = 1;

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String[] getColumnNames() {
        return new String[] {
                "idProduct",
                "name",
                "ProductGroup_id"
        };
    }

    @Override
    protected Class[] getColumnClasses() {
        return new Class[] {
                Integer.class,
                String.class,
                Integer.class
        };
    }

    @Override
    protected Object getColumnValue(Product entity, int columnNumber) {
        switch (columnNumber) {
            case 0 : return entity.getIdProduct();
            case 1 : return entity.getName();
            case 2 : return entity.getProductGroup_Id();
            default : return "BadColumnNumber";
        }
    }

    @Override
    protected void setColumnValue(Product entity, int columnNumber, Object value) {
        switch (columnNumber) {
            case 0 : entity.setIdProduct((Integer) value);
            case 1 : entity.setName((String) value);
            case 2 : entity.setProductGroup_Id((Integer) value);
            default : return;
        }
    }

    @Override
    protected Product createInstance() {
        return new Product();
    }

    @Override
    protected int idRow() {
        return idRow;
    }

}
