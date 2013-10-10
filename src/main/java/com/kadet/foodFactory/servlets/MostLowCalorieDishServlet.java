package com.kadet.foodFactory.servlets;

import com.kadet.foodFactory.controller.ShowController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 3:39
 * To change this template use File | Settings | File Templates.
 */
public class MostLowCalorieDishServlet extends HttpServlet{

    private ShowController controller = ShowController.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            controller.showMostLowCalorieDish(request, response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
