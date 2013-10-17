package com.kadet.foodFactory.dao.daoImpl;

import com.kadet.foodFactory.dao.AuthorDao;
import com.kadet.foodFactory.entity.Author;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 17.10.13
 * Time: 3:24
 * To change this template use File | Settings | File Templates.
 */
public class AuthorDaoImpl extends AbstractDaoImpl<Author> implements AuthorDao {

    private final static String AUTHOR_TABLE_NAME = "Author";

    private final static String[] COLUMN_NAMES = {
            "idAuthor",
            "code",
            "surname",
            "name",
            "country",
            "year"
    };

    private final static Class[] COLUMN_TYPES = {
            Integer.class,
            String.class,
            String.class,
            String.class,
            String.class,
            Integer.class
    };

    private static final Integer ID_COLUMN = 0;


    @Override
    protected String getTableName() {
        return AUTHOR_TABLE_NAME;
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
    protected Author createInstance() {
        return new Author();
    }

    @Override
    protected Object getValue(Integer columnNum, Author entity) {
        switch (columnNum) {
            case 0:
                return entity.getIdAuthor();
            case 1:
                return entity.getCode();
            case 2:
                return entity.getSurname();
            case 3:
                return entity.getName();
            case 4:
                return entity.getCountry();
            case 5:
                return entity.getYear();
        }
        return null;
    }

    @Override
    protected void setEntityColumn(Author entity, int columnNum, Object value) {
        switch (columnNum) {
            case 0:
                entity.setIdAuthor((Integer) value);
                return;
            case 1:
                entity.setCode((String) value);
                return;
            case 2:
                entity.setSurname((String) value);
                return;
            case 3:
                entity.setName((String) value);
                return;
            case 4:
                entity.setCountry((String) value);
                return;
            case 5:
                entity.setYear((Integer) value);
                return;
        }
    }
}
