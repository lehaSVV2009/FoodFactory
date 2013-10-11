package com.kadet.foodFactory.servlets;

import com.kadet.foodFactory.controller.EditingController;

import javax.servlet.http.HttpServlet;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 3:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractEditingServlet extends HttpServlet{

    protected EditingController controller;

    /**
     * Обязательно в нем инициализировать поле controller.
     */
    protected abstract void initController ();

}
