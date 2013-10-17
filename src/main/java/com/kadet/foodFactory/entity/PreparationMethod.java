package com.kadet.foodFactory.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 4:01
 * To change this template use File | Settings | File Templates.
 */
public class PreparationMethod implements Entity {

    private Integer idPreparationMethod;
    private String code;
    private String name;

    public Integer getIdPreparationMethod() {
        return idPreparationMethod;
    }

    public void setIdPreparationMethod(Integer idPreparationMethod) {
        this.idPreparationMethod = idPreparationMethod;
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

    @Override
    public String toString() {
        return "PreparationMethod{" +
                "idPreparationMethod=" + idPreparationMethod +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
