package com.kadet.foodFactory.controller;

import com.kadet.foodFactory.dao.ProductDao;
import com.kadet.foodFactory.dao.daoImpl.ProductDaoImpl;
import com.kadet.foodFactory.entity.Product;
import com.kadet.foodFactory.util.DataStrings;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class ProductController extends AbstractController implements EditingController {

    public final static String ADD_PRODUCT_PRODUCT_GROUP_ID = "addProduct.productGroupId";
    public final static String ADD_PRODUCT_PRODUCT_NAME= "addProduct.productName";

    public final static String REMOVE_PRODUCT_PRODUCT_ID = "removeProduct.productId";

    public final static String UPDATE_PRODUCT_PRODUCT_ID = "updateProduct.productId";
    public final static String UPDATE_PRODUCT_PRODUCT_NAME = "updateProduct.productName";

    public final static String SUCCEED = "SUCCEED";

    private ProductDao productDao = new ProductDaoImpl();
    private Random random = new Random();

    @Override
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        Integer productGroupId
                = Integer.parseInt(request.getParameter(ADD_PRODUCT_PRODUCT_GROUP_ID));
        String productName
                = request.getParameter(ADD_PRODUCT_PRODUCT_NAME);
        Product product = new Product();
        product.setProductGroup_Id(productGroupId);
        product.setName(productName);
        product.setIdProduct(random.nextInt(5000));
        int succeed = productDao.save(product);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.PRODUCT_PATH);
    }

    @Override
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        Integer idProduct
                = Integer.parseInt(request.getParameter(REMOVE_PRODUCT_PRODUCT_ID));
        Product product = new Product();
        product.setIdProduct(idProduct);
        int succeed = productDao.delete(product);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.PRODUCT_PATH);
    }

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        redirectToJsp(request, response, DataStrings.PRODUCT_PATH);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        Integer idProduct
                = Integer.parseInt(request.getParameter(UPDATE_PRODUCT_PRODUCT_ID));
        String newName
                = request.getParameter(UPDATE_PRODUCT_PRODUCT_NAME);
        Product product = productDao.findById(idProduct);
        product.setName(newName);
        int succeed = productDao.update(product);
        request.setAttribute(SUCCEED, succeed);
        redirectToJsp(request, response, DataStrings.PRODUCT_PATH);
    }

}
