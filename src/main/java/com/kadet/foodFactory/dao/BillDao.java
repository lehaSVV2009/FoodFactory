package com.kadet.foodFactory.dao;

import com.kadet.foodFactory.entity.Bill;
import com.kadet.foodFactory.entity.Provider;

import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:19
 * To change this template use File | Settings | File Templates.
 */
public interface BillDao extends AbstractDao<Bill> {

    public List<Bill> getPriceList (Provider provider, Date today);

}
