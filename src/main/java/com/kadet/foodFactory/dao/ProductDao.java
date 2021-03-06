package com.kadet.foodFactory.dao;

import com.kadet.foodFactory.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDao extends AbstractDao<Product> {

    public List<Product> findAllWithRecipes ();
    public Map<Product, Integer> findMostLowCalorie (int productsNumber);

}
