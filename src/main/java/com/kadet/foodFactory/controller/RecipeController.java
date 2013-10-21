package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.dao.RecipeDao;
import com.kadet.foodFactory.dao.daoImpl.RecipeDaoImpl;
import com.kadet.foodFactory.entity.Recipe;
import com.kadet.foodFactory.util.DataStrings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class RecipeController extends AbstractController implements EditingController {

    public final static String SUCCEED = "SUCCEED";

    public final static String ADD_RECIPE_RECIPE_NAME = "addRecipe.recipeName";
    public final static String ADD_RECIPE_RECIPE_DESCRIPTION = "addRecipe.recipeDescription";
    public final static String ADD_RECIPE_PRODUCT_ID = "addRecipe.productId";

    public final static String UPDATE_RECIPE_RECIPE_NAME = "updateRecipe.recipeName";
    public final static String UPDATE_RECIPE_RECIPE_DESCRIPTION = "updateRecipe.recipeDescription";
    public final static String UPDATE_RECIPE_RECIPE_ID = "updateRecipe.recipeId";

    public final static String REMOVE_RECIPE_RECIPE_ID = "removeRecipe.recipeId";

    private RecipeDao recipeDao = new RecipeDaoImpl();

    private Random random = new Random();

    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String recipeName
                = request.getParameter(ADD_RECIPE_RECIPE_NAME);
        String recipeDescription
                = request.getParameter(ADD_RECIPE_RECIPE_DESCRIPTION);
        Integer idProduct
                = Integer.parseInt(request.getParameter(ADD_RECIPE_PRODUCT_ID));
        Recipe recipe = new Recipe();
        recipe.setIdRecipe(random.nextInt(5000));
        recipe.setProduct_id(idProduct);
        recipe.setNumber(String.valueOf(random.nextInt(500000)));
        recipe.setName(recipeName);
        recipe.setDescription(recipeDescription);
        int succeed = recipeDao.save(recipe);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.RECIPE_PATH);
    }

    @Override
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Integer idRecipe
                = Integer.parseInt(request.getParameter(REMOVE_RECIPE_RECIPE_ID));
        Recipe recipe = new Recipe();
        recipe.setIdRecipe(idRecipe);
        int succeed = recipeDao.delete(recipe);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.RECIPE_PATH);
    }

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        redirectToJsp(request, response, DataStrings.RECIPE_PATH);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Integer idRecipe
                = Integer.parseInt(request.getParameter(UPDATE_RECIPE_RECIPE_ID));
        String newName
                = request.getParameter(UPDATE_RECIPE_RECIPE_NAME);
        String newDescription
                = request.getParameter(UPDATE_RECIPE_RECIPE_DESCRIPTION);
        Recipe recipe = recipeDao.findById(idRecipe);
        if (newName != null && !newName.trim().isEmpty()) {
            recipe.setName(newName);
        }
        if (newDescription != null && !newDescription.trim().isEmpty()) {
            recipe.setDescription(newDescription);
        }
        int succeed = recipeDao.update(recipe);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.RECIPE_PATH);
    }

}
