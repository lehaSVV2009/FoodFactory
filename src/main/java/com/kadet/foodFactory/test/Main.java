package com.kadet.foodFactory.test;

import com.kadet.foodFactory.dao.ProductDao;
import com.kadet.foodFactory.dao.daoImpl.ProductDaoImpl;
import com.kadet.foodFactory.entity.Product;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 0:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {

        ProductDao productDao = new ProductDaoImpl();
        Product product = new Product();
        product.setIdProduct(1);
        product.setName("name1");
        product.setProductGroup_Id(1);
//        System.out.println(productDao.save(product));
        product.setName("name1");
        product.setProductGroup_Id(1);
        System.out.println(productDao.update(product));
        System.out.println(productDao.findAll());
        System.out.println(productDao.findByEntity(new Product()));
        System.out.println(productDao.findById(new Product()));



        /*System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/foodFactory", "root", "root");

            statement = connection.createStatement();

            statement.executeUpdate("insert into Provider values (1, \"01232\", \"name1\", \"address1\", \"123121\");");



        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }




        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }*/



    }

}
