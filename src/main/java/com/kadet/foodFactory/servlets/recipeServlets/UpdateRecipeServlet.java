package com.kadet.foodFactory.servlets.recipeServlets;

import com.kadet.foodFactory.controller.RecipeController;
import com.kadet.foodFactory.servlets.UpdateServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 2:29
 * To change this template use File | Settings | File Templates.
 */
public class UpdateRecipeServlet extends UpdateServlet {

    @Override
    protected void initController() {
        controller = new RecipeController();
    }
}
