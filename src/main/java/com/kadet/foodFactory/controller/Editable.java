package com.kadet.foodFactory.controller;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 1:07
 * To change this template use File | Settings | File Templates.
 */
public interface Editable <T>{

    boolean add (T element);
    boolean remove (T element);
    T get (int id);
    boolean update (int id, T element);

}
