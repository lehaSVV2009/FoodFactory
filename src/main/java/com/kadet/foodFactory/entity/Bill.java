package com.kadet.foodFactory.entity;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 4:03
 * To change this template use File | Settings | File Templates.
 *
 * Накладная - договор поставщика и покупателя
 */
public class Bill implements Entity {

    private Integer idBill;
    private Double price;
    private Date receiptDate;
    private Integer Provider_id;
    private Integer Ingredient_id;

    private Provider provider;
    private Ingredient ingredient;

    public Integer getIdBill() {
        return idBill;
    }

    public void setIdBill(Integer idBill) {
        this.idBill = idBill;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getProvider_id() {
        return Provider_id;
    }

    public void setProvider_id(Integer provider_id) {
        Provider_id = provider_id;
    }

    public Integer getIngredient_id() {
        return Ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        Ingredient_id = ingredient_id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}

