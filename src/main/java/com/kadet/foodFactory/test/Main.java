package com.kadet.foodFactory.test;

import com.kadet.foodFactory.dao.RecipeDao;
import com.kadet.foodFactory.dao.daoImpl.RecipeDaoImpl;
import com.kadet.foodFactory.entity.Recipe;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 0:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        RecipeDao productGroupDao = new RecipeDaoImpl();
        Recipe productGroup = new Recipe();
        productGroup.setIdRecipe(1);
        productGroup.setName("name1");
        productGroup.setNumber("num1");
        productGroup.setDescription("desc1");
        productGroup.setProduct_id(2);
        Recipe productGroup2 = new Recipe();
        productGroup2.setIdRecipe(2);
        productGroup2.setName("name2");
        productGroup2.setNumber("num2");
        productGroup2.setDescription("desc2");
        productGroup2.setProduct_id(2);
        System.out.println(productGroupDao.save(productGroup));
        System.out.println(productGroupDao.save(productGroup2));

        System.out.println(productGroupDao.findAll());

        System.out.println(productGroupDao.findById(1));

        Recipe productGroupCopy = new Recipe();
        productGroupCopy.setIdRecipe(2);
        System.out.println(productGroupDao.findByEntity(productGroupCopy));

        System.out.println(productGroupDao.delete(productGroup));

    }

}
