package com.android.predict.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by orien on 2017/12/25.
 */

public class ModelValueUtils {

    public static class ClassInfo {
        String type;
        String name;
        Object value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public static List<ClassInfo> getFiledsInfo(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        List<ClassInfo> list = new ArrayList<>();
        for (Field field : fields) {
            ClassInfo info = new ClassInfo();
            info.type = field.getType().toString();
            info.name = field.getName();
            info.value = getFieldValueByName(field.getName(), o);
            list.add(info);
        }
        return list;
    }

    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1);
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter);
            return method.invoke(o);
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] getFiledNames(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }
}
