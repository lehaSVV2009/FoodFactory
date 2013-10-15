package com.kadet.foodFactory.util;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 15.10.13
 * Time: 3:01
 * To change this template use File | Settings | File Templates.
 */
public final class ReflectionGenerator {

    public static String[] getColumnNamesFromFields(Class cl) {
        Field[]classFields = cl.getDeclaredFields();
        String[] columnNames = new String[classFields.length];
        for (int fieldId = 0; fieldId < classFields.length; ++fieldId) {
            columnNames[fieldId] = classFields[fieldId].getName();
        }
        return columnNames;
    }

    public static Class[] getColumnTypesFromFields(Class cl) {
        Field[]classFields = cl.getDeclaredFields();
        Class[] columnTypes = new Class[classFields.length];
        for (int fieldId = 0; fieldId < classFields.length; ++fieldId) {
            columnTypes[fieldId] = classFields[fieldId].getType();
        }
        return columnTypes;
    }


}
