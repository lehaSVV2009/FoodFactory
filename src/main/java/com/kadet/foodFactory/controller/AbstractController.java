package com.kadet.foodFactory.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 11.10.13
 * Time: 1:04
 * To change this template use File | Settings | File Templates.
 */
public class AbstractController {

    protected void redirectToJsp (HttpServletRequest request, HttpServletResponse response, String jspUrl) throws ServletException, IOException {
        request.getRequestDispatcher(jspUrl).forward(request, response);
    }

    protected void sendHtmlPage(HttpServletResponse response, String htmlPage) throws IOException {
        adjustResponse(response);
        PrintWriter out = response.getWriter();
        out.print(htmlPage);
        out.close();
    }

    protected void adjustResponse (HttpServletResponse response) {
        response.setContentType("text/html; charset=Windows-1251");
    }

}
