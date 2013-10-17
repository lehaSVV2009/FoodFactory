package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.IngredientDao;
import com.kadet.foodFactory.entity.Ingredient;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:26
 * To change this template use File | Settings | File Templates.
 */
public class IngredientDaoImpl extends AbstractDaoImpl<Ingredient> implements IngredientDao {

    private final static String INGREDIENT_TABLE_NAME = "Ingredient";

    private final static String[] COLUMN_NAMES = {
            "idIngredient",
            "Provider_id",
            "name",
            "caloriesNumPerGram"
    };

    private final static Class[] COLUMN_TYPES = {
            Integer.class,
            Integer.class,
            String.class,
            Integer.class
    };

    private static final Integer ID_COLUMN = 0;


    @Override
    protected String getTableName() {
        return INGREDIENT_TABLE_NAME;
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
    protected Object getValue(Integer columnNum, Ingredient entity) {
        switch (columnNum) {
            case 0:
                return entity.getIdIngredient();
            case 1:
                return entity.getProvider_id();
            case 2:
                return entity.getName();
            case 3:
                return entity.getCaloriesNumPerGram();
        }
        return null;
    }

    @Override
    protected Ingredient createInstance() {
        return new Ingredient();
    }

    @Override
    protected void setEntityColumn(Ingredient entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0:
                entity.setIdIngredient((Integer) value);
                return;
            case 1:
                entity.setProvider_id((Integer) value);
                return;
            case 2:
                entity.setName((String) value);
                return;
            case 3:
                entity.setCaloriesNumPerGram((Integer) value);
                return;
        }
    }
}
