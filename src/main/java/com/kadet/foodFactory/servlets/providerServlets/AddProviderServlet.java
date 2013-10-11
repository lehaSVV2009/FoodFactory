package com.kadet.foodFactory.servlets.providerServlets;

import com.kadet.foodFactory.controller.ProductController;
import com.kadet.foodFactory.controller.ProviderController;
import com.kadet.foodFactory.servlets.AddServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 2:28
 * To change this template use File | Settings | File Templates.
 */
public class AddProviderServlet extends AddServlet {

    @Override
    protected void initController() {
        controller = new ProviderController();
    }
}
