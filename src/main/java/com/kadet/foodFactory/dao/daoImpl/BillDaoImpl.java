package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.BillDao;
import com.kadet.foodFactory.entity.Bill;

import java.sql.Date;
import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:23
 * To change this template use File | Settings | File Templates.
 */
public class BillDaoImpl extends AbstractDaoImpl<Bill> implements BillDao {

    private final static String BILL_TABLE_NAME = "Bill";

    private final static String[] COLUMN_NAMES = {
            "idBill",
            "price",
            "receiptDate",
            "Provider_id",
            "Ingredient_id"
    };

    private final static Class[] COLUMN_TYPES = {
            Integer.class,
            Double.class,
            Date.class,
            Integer.class,
            Integer.class
    };

    private static final Integer ID_COLUMN = 0;

    @Override
    protected String getTableName() {
        return BILL_TABLE_NAME;
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
    protected Object getValue(Integer columnNum, Bill entity) {
        switch (columnNum) {
            case 0:
                return entity.getIdBill();
            case 1:
                return entity.getPrice();
            case 2:
                return entity.getReceiptDate();
            case 3:
                return entity.getProvider_id();
            case 4:
                return entity.getIngredient_id();
        }
        return null;
    }

    @Override
    protected Bill createInstance() {
        return new Bill();
    }

    @Override
    protected void setEntityColumn(Bill entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0:
                entity.setIdBill((Integer) value);
                return;
            case 1:
                entity.setPrice((Double) value);
                return;
            case 2:
                entity.setReceiptDate((Date) value);
                return;
            case 3:
                entity.setProvider_id((Integer) value);
                return;
            case 4:
                entity.setIngredient_id((Integer) value);
                return;
        }
    }
}
