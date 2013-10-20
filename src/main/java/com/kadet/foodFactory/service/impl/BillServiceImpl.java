package com.kadet.foodFactory.service.impl;

import com.kadet.foodFactory.dao.BillDao;
import com.kadet.foodFactory.dao.daoImpl.BillDaoImpl;
import com.kadet.foodFactory.entity.Bill;
import com.kadet.foodFactory.entity.Provider;
import com.kadet.foodFactory.service.BillService;

import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 21.10.13
 * Time: 2:22
 * To change this template use File | Settings | File Templates.
 */
public class BillServiceImpl implements BillService{

    private BillDao billDao = new BillDaoImpl();

    @Override
    public List<Bill> getPriceList(Provider provider, Date today) {
        return billDao.getPriceList(provider, today);
    }
}
