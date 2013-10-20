package com.kadet.foodFactory.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 1:15
 * To change this template use File | Settings | File Templates.
 */
public class Product implements Entity {

    private Integer idProduct;
    private String name;
    private Integer ProductGroup_Id;
    private List<Recipe> recipes;

    public Product () {
        this.recipes = new ArrayList<Recipe>();
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductGroup_Id() {
        return ProductGroup_Id;
    }

    public void setProductGroup_Id(Integer productGroup_Id) {
        this.ProductGroup_Id = productGroup_Id;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", ProductGroup_Id=" + ProductGroup_Id +
                '}';
    }
}
