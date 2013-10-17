package com.kadet.foodFactory.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 4:02
 * To change this template use File | Settings | File Templates.
 */
public class ProductGroup implements Entity {

    private Integer idProductGroup;
    private String code;
    private String name;

    public Integer getIdProductGroup() {
        return idProductGroup;
    }

    public void setIdProductGroup(Integer idProductGroup) {
        this.idProductGroup = idProductGroup;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
