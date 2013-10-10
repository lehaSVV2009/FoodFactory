package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.model.Recipe;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class RecipeController extends AbstractController implements Editable<Recipe>{

    @Override
    public boolean add(Recipe element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean remove(Recipe element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Recipe get(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update(int id, Recipe element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
