package com.kadet.foodFactory.servlets.recipeServlets;

import com.kadet.foodFactory.controller.ProductController;
import com.kadet.foodFactory.controller.RecipeController;
import com.kadet.foodFactory.servlets.GetServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 2:29
 * To change this template use File | Settings | File Templates.
 */
public class GetRecipeServlet extends GetServlet {

    @Override
    protected void initController() {
        controller = new RecipeController();
    }
}
