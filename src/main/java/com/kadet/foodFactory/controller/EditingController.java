package com.kadet.foodFactory.controller;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 1:07
 * To change this template use File | Settings | File Templates.
 */
public interface EditingController {

    void add (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
    void remove (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
    void get (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
    void update (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
