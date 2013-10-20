package com.kadet.foodFactory.service;

import com.kadet.foodFactory.entity.Bill;
import com.kadet.foodFactory.entity.Provider;

import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 21.10.13
 * Time: 2:21
 * To change this template use File | Settings | File Templates.
 */
public interface BillService {

    public List<Bill> getPriceList(Provider provider, Date today);

}
