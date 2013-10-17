package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.RecipeDao;
import com.kadet.foodFactory.entity.Recipe;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:28
 * To change this template use File | Settings | File Templates.
 */
public class RecipeDaoImpl extends AbstractDaoImpl<Recipe> implements RecipeDao {

    private final static String RECIPE_TABLE_NAME = "Recipe";

    private final static String[] COLUMN_NAMES = {
            "idRecipe",
            "Product_id",
            "number",
            "name",
            "description"
    };

    private final static Class[] COLUMN_TYPES = {
            Integer.class,
            Integer.class,
            String.class,
            String.class,
            String.class
    };

    private static final Integer ID_COLUMN = 0;



    @Override
    protected String getTableName() {
        return RECIPE_TABLE_NAME;
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
    protected Object getValue(Integer columnNum, Recipe entity) {
        switch (columnNum) {
            case 0 : return entity.getIdRecipe();
            case 1 : return entity.getProduct_id();
            case 2 : return entity.getNumber();
            case 3 : return entity.getName();
            case 4 : return entity.getDescription();
        }
        return null;
    }

    @Override
    protected Recipe createInstance() {
        return new Recipe();
    }

    @Override
    protected void setEntityColumn(Recipe entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0 : entity.setIdRecipe((Integer) value);
                return;
            case 1 : entity.setProduct_id((Integer) value);
                return;
            case 2 : entity.setNumber((String) value);
                return;
            case 3 : entity.setName((String) value);
                return;
            case 4 : entity.setDescription((String) value);
                return;
        }
    }
}
