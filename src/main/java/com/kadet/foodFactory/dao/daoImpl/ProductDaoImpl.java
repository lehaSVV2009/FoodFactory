package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.ProductDao;
import com.kadet.foodFactory.entity.Product;
import com.kadet.foodFactory.entity.Recipe;
import com.kadet.foodFactory.util.MysqlManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            case 0:
                return entity.getIdProduct();
            case 1:
                return entity.getName();
            case 2:
                return entity.getProductGroup_Id();
        }
        return null;
    }

    @Override
    protected void setEntityColumn(Product entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0:
                entity.setIdProduct((Integer) value);
                return;
            case 1:
                entity.setName((String) value);
                return;
            case 2:
                entity.setProductGroup_Id((Integer) value);
                return;
        }
    }

    private Product getProductFromListById (List<Product> products, Integer idProduct) {
        for (Product product : products) {
            if (product.getIdProduct() == idProduct) {
                return product;
            }
        }
        return null;
    }

    private List<Product> getAllWithRecipesFromResultSet (ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        while (resultSet.next()) {
            Integer productId = resultSet.getInt(COLUMN_NAMES[0]);
            String productName = resultSet.getString(COLUMN_NAMES[1]);
            Integer ProductGroup_id = resultSet.getInt(COLUMN_NAMES[2]);
            Product product = getProductFromListById(products, productId);
            if (product == null) {
                product = new Product();
                product.setIdProduct(productId);
                product.setName(productName);
                product.setProductGroup_Id(ProductGroup_id);
                products.add(product);
            }
            Recipe recipe = new Recipe();
            recipe.setIdRecipe(resultSet.getInt("idRecipe"));
            recipe.setProduct_id(resultSet.getInt("Product_id"));
            recipe.setNumber(resultSet.getString("recipeNumber"));
            recipe.setName(resultSet.getString("recipeName"));
            recipe.setDescription(resultSet.getString("recipeDescription"));
            product.getRecipes().add(recipe);
        }
        return products;
    }

    @Override
    public List<Product> findAllWithRecipes() {

        List<Product> result = new ArrayList<Product>();
        String query = "select product.idProduct, product.name, product.ProductGroup_id, recipe.idRecipe, recipe.product_id, recipe.number as recipeNumber, recipe.name as recipeName, recipe.description as recipeDescription from product, recipe where product.idProduct = recipe.Product_id;";
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            result
                    = getAllWithRecipesFromResultSet(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            result.clear();
            MysqlManager.log(e);
        }
        return result;
    }

    private Map<Product, Integer> getMostLowCalorieFromResultSet (ResultSet resultSet) throws SQLException {
        Map<Product, Integer> map = new HashMap<Product, Integer>();
        while (resultSet.next()) {
            Integer calories = resultSet.getInt("calories");
            Product product = new Product();
            product.setIdProduct(resultSet.getInt("idProduct"));
            product.setName(resultSet.getString("name"));
            product.setProductGroup_Id(resultSet.getInt("ProductGroup_id"));
            map.put(product, calories);
        }
        return map;
    }

    @Override
    public Map<Product, Integer> findMostLowCalorie(int productsNumber) {
        Map<Product, Integer> result = new HashMap<Product, Integer>();
        String query = new StringBuilder()
                .append("select\n")
                .append(" sum(gramNum * caloriesNumPerGram) as calories,\n")
                .append(" product.idProduct,\n")
                .append(" product.name,\n")
                .append(" product.ProductGroup_id\n")
                .append("from recipe_ingredient\n")
                .append("join ingredient\n")
                .append(" on recipe_ingredient.ingredient_id = ingredient.idIngredient\n")
                .append("join recipe\n")
                .append(" on recipe_ingredient.recipe_id = recipe.idRecipe\n")
                .append("join product\n")
                .append(" on recipe.product_Id = product.IdProduct\n")
                .append("group by recipe_id\n")
                .append("order by calories\n")
                .append(" limit ")
                .append(productsNumber)
                .toString();
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            result
                    = getMostLowCalorieFromResultSet(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            result.clear();
            MysqlManager.log(e);
        }
        return result;
    }


}