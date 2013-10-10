package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.model.Product;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class ProductController extends AbstractController implements Editable<Product> {

    @Override
    public boolean add(Product element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean remove(Product element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Product get(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update(int id, Product element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
