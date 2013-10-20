package com.kadet.foodFactory.service;

import com.kadet.foodFactory.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 21.10.13
 * Time: 2:18
 * To change this template use File | Settings | File Templates.
 */
public interface ProductService {

    public List<Product> findAllWithRecipes ();
    public Map<Product, Integer> findMostLowCalorie (int productsNumber);

}
