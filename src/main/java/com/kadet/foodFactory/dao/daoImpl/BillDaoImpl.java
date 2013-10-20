package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.BillDao;
import com.kadet.foodFactory.entity.Bill;
import com.kadet.foodFactory.entity.Ingredient;
import com.kadet.foodFactory.entity.Provider;
import com.kadet.foodFactory.util.MysqlManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:23
 * To change this template use File | Settings | File Templates.
 */
public class BillDaoImpl extends AbstractDaoImpl<Bill> implements BillDao {

    private final static String BILL_TABLE_NAME = "Bill";

    private final static String[] COLUMN_NAMES = {
            "idBill",
            "price",
            "receiptDate",
            "Provider_id",
            "Ingredient_id"
    };

    private final static Class[] COLUMN_TYPES = {
            Integer.class,
            Double.class,
            Date.class,
            Integer.class,
            Integer.class
    };

    private static final Integer ID_COLUMN = 0;

    @Override
    protected String getTableName() {
        return BILL_TABLE_NAME;
    }

    @Override
    protected String[] getColumnNames() {
        return COLUMN_NAMES;
    }

    @Override
    protected Integer getIdColumnNum() {
        return ID_COLUMN;
    }

    @Override
    protected Class[] getColumnTypes() {
        return COLUMN_TYPES;
    }

    @Override
    protected Object getValue(Integer columnNum, Bill entity) {
        switch (columnNum) {
            case 0:
                return entity.getIdBill();
            case 1:
                return entity.getPrice();
            case 2:
                return entity.getReceiptDate();
            case 3:
                return entity.getProvider_id();
            case 4:
                return entity.getIngredient_id();
        }
        return null;
    }

    @Override
    protected Bill createInstance() {
        return new Bill();
    }

    @Override
    protected void setEntityColumn(Bill entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0:
                entity.setIdBill((Integer) value);
                return;
            case 1:
                entity.setPrice((Double) value);
                return;
            case 2:
                entity.setReceiptDate((Date) value);
                return;
            case 3:
                entity.setProvider_id((Integer) value);
                return;
            case 4:
                entity.setIngredient_id((Integer) value);
                return;
        }
    }

    private List<Bill> getPriceListFromResultSet (ResultSet resultSet) throws SQLException {
        List<Bill> priceList = new ArrayList<Bill>();
        while (resultSet.next()) {
            Bill bill = new Bill();
            bill.setIdBill(resultSet.getInt("idBill"));
            bill.setPrice(resultSet.getDouble("price"));
            bill.setReceiptDate(resultSet.getDate("billDate"));

            Provider provider = new Provider();
            provider.setIdProvider(resultSet.getInt("providerId"));
            provider.setName(resultSet.getString("providerName"));
            provider.setCode(resultSet.getString("providerCode"));
            provider.setAddress(resultSet.getString("providerAddress"));
            provider.setPhone(resultSet.getString("providerPhone"));

            Ingredient ingredient = new Ingredient();
            ingredient.setIdIngredient(resultSet.getInt("ingredientId"));
            ingredient.setName(resultSet.getString("ingredientName"));
            bill.setProvider(provider);
            bill.setIngredient(ingredient);
            priceList.add(bill);
        }
        return priceList;
    }


    @Override
    public List<Bill> getPriceList(Provider provider, Date today) {
        List<Bill> result = new ArrayList<Bill>();
        String query = new StringBuilder()
                .append("select\n")
                .append("bill.idBill,\n")
                .append("bill.price,\n")
                .append("max(bill.receiptDate) as billDate,\n")
                .append("provider.idProvider as providerId,\n")
                .append("provider.name as providerName,\n")
                .append("provider.code as providerCode,\n")
                .append("provider.address as providerAddress,\n")
                .append("provider.phone as providerPhone,\n")
                .append("ingredient.idIngredient as ingredientId,\n")
                .append("ingredient.name as ingredientName \n")
                .append("from bill\n")
                .append("join provider\n")
                .append("  on bill.provider_id = provider.idProvider\n")
                .append("join ingredient\n")
                .append("  on bill.ingredient_id = ingredient.idIngredient\n")
                .append("where bill.receiptDate < \"")
                .append(today)
                .append("\" \n")
                .append("group by bill.ingredient_id, bill.provider_id\n")
                .append("having bill.provider_id = ")
                .append(provider.getIdProvider())
                .toString();
        try {
            Connection connection = MysqlManager.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            result
                    = getPriceListFromResultSet(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            result.clear();
            MysqlManager.log(e);
        }
        return result;
    }
}
