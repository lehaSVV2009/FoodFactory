package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.util.DataStrings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class ProductController extends AbstractController implements EditingController {

    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        redirectToJsp(request, response, DataStrings.PRODUCT_PATH);
    }

    @Override
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        redirectToJsp(request, response, DataStrings.PRODUCT_PATH);
    }

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        redirectToJsp(request, response, DataStrings.PRODUCT_PATH);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        redirectToJsp(request, response, DataStrings.PRODUCT_PATH);
    }
}
