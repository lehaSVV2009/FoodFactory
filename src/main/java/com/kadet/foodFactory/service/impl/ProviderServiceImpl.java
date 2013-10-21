package com.kadet.foodFactory.service.impl;

import com.kadet.foodFactory.dao.ProviderDao;
import com.kadet.foodFactory.dao.daoImpl.ProviderDaoImpl;
import com.kadet.foodFactory.entity.Provider;
import com.kadet.foodFactory.service.ProviderService;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 21.10.13
 * Time: 3:26
 * To change this template use File | Settings | File Templates.
 */
public class ProviderServiceImpl implements ProviderService{

    private ProviderDao providerDao = new ProviderDaoImpl();

    @Override
    public Provider findById(Integer providerId) {
        return providerDao.findById(providerId);
    }
}
