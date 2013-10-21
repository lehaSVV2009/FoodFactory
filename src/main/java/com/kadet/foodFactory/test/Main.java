package com.kadet.foodFactory.test;

import com.kadet.foodFactory.dao.BillDao;
import com.kadet.foodFactory.dao.ProductDao;
import com.kadet.foodFactory.dao.ProviderDao;
import com.kadet.foodFactory.dao.RecipeDao;
import com.kadet.foodFactory.dao.daoImpl.BillDaoImpl;
import com.kadet.foodFactory.dao.daoImpl.ProductDaoImpl;
import com.kadet.foodFactory.dao.daoImpl.ProviderDaoImpl;
import com.kadet.foodFactory.dao.daoImpl.RecipeDaoImpl;
import com.kadet.foodFactory.entity.Bill;
import com.kadet.foodFactory.entity.Product;
import com.kadet.foodFactory.entity.Provider;
import com.kadet.foodFactory.entity.Recipe;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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
        List<Product> products = productDao.findAllWithRecipes();
        for (Product product : products) {
            System.out.println(product.getIdProduct());
            System.out.println(product.getProductGroup_Id());
            System.out.println(product.getName());
            System.out.println(product.getRecipes());
        }

        Map<Product, Integer> map = productDao.findMostLowCalorie(5);
        for (Product key : map.keySet()) {
            System.out.println("product: " + key.getName() + "\ncalories: " + map.get(key));
        }

        ProviderDao providerDao = new ProviderDaoImpl();
        BillDao billDao = new BillDaoImpl();
        List<Provider> providers = providerDao.findAll();
        for (Provider provider : providers) {
            List<Bill> priceList = billDao.getPriceList(provider, new Date(System.currentTimeMillis()));
            for (Bill bill : priceList) {
                System.out.println("Bill{" +
                        "idBill=" + bill.getIdBill() +
                        ", price=" + bill.getPrice() +
                        ", receiptDate=" + bill.getReceiptDate() +
                        ", provider=" + bill.getProvider().getName() +
                        ", provider=" + bill.getProvider().getCode() +
                        ", provider=" + bill.getProvider().getAddress() +
                        ", provider=" + bill.getProvider().getPhone() +
                        ", provider=" + bill.getProvider().getIdProvider() +
                        ", ingredient=" + bill.getIngredient().getName() +
                        '}');
            }
        }



        /*RecipeDao productGroupDao = new RecipeDaoImpl();
        Recipe productGroup = new Recipe();
        productGroup.setIdRecipe(1);
        productGroup.setName("name1");
        productGroup.setNumber("num1");
        productGroup.setDescription("desc1");
        productGroup.setProduct_id(2);
        Recipe productGroup2 = new Recipe();
        productGroup2.setIdRecipe(2);
        productGroup2.setName("name2");
        productGroup2.setNumber("num2");
        productGroup2.setDescription("desc2");
        productGroup2.setProduct_id(2);
        System.out.println(productGroupDao.save(productGroup));
        System.out.println(productGroupDao.save(productGroup2));

        System.out.println(productGroupDao.findAll());

        System.out.println(productGroupDao.findById(1));

        Recipe productGroupCopy = new Recipe();
        productGroupCopy.setIdRecipe(2);
        System.out.println(productGroupDao.findByEntity(productGroupCopy));

        System.out.println(productGroupDao.delete(productGroup));
*/    }

}
