package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.model.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class ProviderController extends AbstractController implements Editable<Provider>{

    @Override
    public boolean add(Provider element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean remove(Provider element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Provider get(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean update(int id, Provider element) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
