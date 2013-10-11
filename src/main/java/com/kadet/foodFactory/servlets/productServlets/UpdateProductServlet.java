package com.kadet.foodFactory.servlets.productServlets;

import com.kadet.foodFactory.controller.ProductController;
import com.kadet.foodFactory.servlets.UpdateServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 2:29
 * To change this template use File | Settings | File Templates.
 */
public class UpdateProductServlet extends UpdateServlet {

    @Override
    protected void initController() {
        controller = new ProductController();
    }
}
