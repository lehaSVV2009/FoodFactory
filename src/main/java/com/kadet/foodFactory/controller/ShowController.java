package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.util.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 3:38
 * To change this template use File | Settings | File Templates.
 */
public class ShowController extends AbstractController {

    private static ShowController controller;

    public static ShowController getInstance () {
        if (controller == null) {
            controller = new ShowController();
        }
        return controller;
    }

    public void showDishesRecipes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        redirectToJsp(request, response, "showDishesRecipes.jsp");
    }

    public void showMostLowCalorieDish (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        redirectToJsp(request, response, "showMostLowCalorieDish.jsp");
    }

    public void showPriceList (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String dateString = request.getParameter("price_list.date");
        Date date = DateConverter.stringToDate(dateString);
        System.out.println(date);
        redirectToJsp(request, response, "showPriceList.jsp");
    }

}
