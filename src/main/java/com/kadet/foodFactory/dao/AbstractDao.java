package com.kadet.foodFactory.dao;

import com.kadet.foodFactory.entity.Entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 0:38
 * To change this template use File | Settings | File Templates.
 */
public interface AbstractDao <E extends Entity> {

    E findById (Object id);
    E findByEntity (E entity);
    int save (E entity);
    int update (E entity);
    int delete (E entity);
    List<E> findAll ();

}