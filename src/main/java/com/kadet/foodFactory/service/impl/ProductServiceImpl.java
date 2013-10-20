package com.kadet.foodFactory.service.impl;

import com.kadet.foodFactory.dao.ProductDao;
import com.kadet.foodFactory.dao.daoImpl.ProductDaoImpl;
import com.kadet.foodFactory.entity.Product;
import com.kadet.foodFactory.service.ProductService;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 21.10.13
 * Time: 2:18
 * To change this template use File | Settings | File Templates.
 */
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> findAllWithRecipes() {
        return productDao.findAllWithRecipes();
    }

    @Override
    public Map<Product, Integer> findMostLowCalorie(int productsNumber) {
        return productDao.findMostLowCalorie(productsNumber);
    }
}
