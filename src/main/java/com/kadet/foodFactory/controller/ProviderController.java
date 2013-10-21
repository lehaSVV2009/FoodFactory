package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.dao.ProviderDao;
import com.kadet.foodFactory.dao.daoImpl.ProviderDaoImpl;
import com.kadet.foodFactory.entity.Provider;
import com.kadet.foodFactory.util.DataStrings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class ProviderController extends AbstractController implements EditingController {

    private ProviderDao providerDao = new ProviderDaoImpl();

    public final static String SUCCEED = "SUCCEED";

    public final static String ADD_PROVIDER_PROVIDER_NAME = "addProvider.providerName";
    public final static String ADD_PROVIDER_PROVIDER_ADDRESS = "addProvider.providerAddress";
    public final static String ADD_PROVIDER_PROVIDER_PHONE = "addProvider.providerPhone";

    public final static String UPDATE_PROVIDER_PROVIDER_ID = "updateProvider.providerId";
    public final static String UPDATE_PROVIDER_PROVIDER_NAME = "updateProvider.providerName";
    public final static String UPDATE_PROVIDER_PROVIDER_ADDRESS = "updateProvider.providerAddress";
    public final static String UPDATE_PROVIDER_PROVIDER_PHONE = "updateProvider.providerPhone";

    public final static String REMOVE_PROVIDER_PROVIDER_ID = "removeProvider.providerId";



    private Random random = new Random();

    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String providerName = request.getParameter(ADD_PROVIDER_PROVIDER_NAME);
        String providerAddress = request.getParameter(ADD_PROVIDER_PROVIDER_ADDRESS);
        String providerPhone = request.getParameter(ADD_PROVIDER_PROVIDER_PHONE);
        Provider provider = new Provider();
        provider.setIdProvider(random.nextInt(5000));
        provider.setName(providerName);
        provider.setAddress(providerAddress);
        provider.setPhone(providerPhone);
        provider.setCode(String.valueOf(random.nextInt(500000)));
        int succeed = providerDao.save(provider);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.PROVIDER_PATH);
    }

    @Override
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Integer idProvider
                = Integer.parseInt(request.getParameter(REMOVE_PROVIDER_PROVIDER_ID));
        Provider provider = new Provider();
        provider.setIdProvider(idProvider);
        int succeed = providerDao.delete(provider);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.PROVIDER_PATH);
    }

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        redirectToJsp(request, response, DataStrings.PROVIDER_PATH);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Integer idProduct
                = Integer.parseInt(request.getParameter(UPDATE_PROVIDER_PROVIDER_ID));
        String newName
                = request.getParameter(UPDATE_PROVIDER_PROVIDER_NAME);
        String newAddress
                = request.getParameter(UPDATE_PROVIDER_PROVIDER_ADDRESS);
        String newPhone
                = request.getParameter(UPDATE_PROVIDER_PROVIDER_PHONE);
        Provider provider = providerDao.findById(idProduct);
        if (newName != null && !newName.trim().isEmpty()) {
            provider.setName(newName);
        }
        if (newAddress != null && !newAddress.trim().isEmpty()) {
            provider.setAddress(newAddress);
        }
        if (newPhone != null && !newPhone.trim().isEmpty()) {
            provider.setPhone(newPhone);
        }
        int succeed = providerDao.update(provider);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.PROVIDER_PATH);
    }

}
