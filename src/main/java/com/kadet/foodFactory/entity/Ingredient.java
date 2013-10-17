package com.kadet.foodFactory.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 3:59
 * To change this template use File | Settings | File Templates.
 */
public class Ingredient implements Entity {

    private Integer idIngredient;
    private Integer Provider_id;
    private String name;
    private Integer caloriesNumPerGram;

    public Integer getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Integer idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Integer getProvider_id() {
        return Provider_id;
    }

    public void setProvider_id(Integer provider_id) {
        Provider_id = provider_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCaloriesNumPerGram() {
        return caloriesNumPerGram;
    }

    public void setCaloriesNumPerGram(Integer caloriesNumPerGram) {
        this.caloriesNumPerGram = caloriesNumPerGram;
    }
}
