package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.entity.Bill;
import com.kadet.foodFactory.entity.Product;
import com.kadet.foodFactory.entity.Provider;
import com.kadet.foodFactory.service.BillService;
import com.kadet.foodFactory.service.ProductService;
import com.kadet.foodFactory.service.ProviderService;
import com.kadet.foodFactory.service.impl.BillServiceImpl;
import com.kadet.foodFactory.service.impl.ProductServiceImpl;
import com.kadet.foodFactory.service.impl.ProviderServiceImpl;
import com.kadet.foodFactory.util.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
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

    private ProductService productService = new ProductServiceImpl();
    private BillService billService = new BillServiceImpl();
    private ProviderService providerService = new ProviderServiceImpl();

    public static final String PRODUCTS_PARAM = "PRODUCTS_WITH_RECIPES";
    public static final String MOST_LOW_CALORIE_PRODUCTS = "MOST_LOW_CALORIE_PRODUCTS";
    public static final String PRICE_LIST = "PRICE_LIST";
    public static final String PROVIDER = "PROVIDER";

    public static ShowController getInstance () {
        if (controller == null) {
            controller = new ShowController();
        }
        return controller;
    }

    public void showDishesRecipes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Product> productsWithRecipes = productService.findAllWithRecipes();
        request.setAttribute(PRODUCTS_PARAM, productsWithRecipes);
        redirectToJsp(request, response, "showDishesRecipes.jsp");
    }

    public void showMostLowCalorieDish (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int productsNum;
        try {
            productsNum = Integer.parseInt(request.getParameter("productsNumber"));
        } catch (NumberFormatException nfe) {
            productsNum = 5;
        }
        Map<Product, Integer> mostLowCalorieProducts = productService.findMostLowCalorie(productsNum);
        request.setAttribute(MOST_LOW_CALORIE_PRODUCTS, mostLowCalorieProducts);
        redirectToJsp(request, response, "showMostLowCalorieDish.jsp");
    }

    public void showPriceList (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Integer providerId;
        try {
            providerId = Integer.parseInt(request.getParameter("price_list.idProvider"));
        } catch (NumberFormatException nfe) {
            providerId = 1;
        }
        Provider provider = providerService.findById(providerId);
        List<Bill> priceList = billService.getPriceList(provider, new Date(System.currentTimeMillis()));
        request.setAttribute(PROVIDER, provider);
        request.setAttribute(PRICE_LIST, priceList);
        redirectToJsp(request, response, "showPriceList.jsp");
    }

}
