package com.android.predict.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by orien on 2017/12/25.
 */

public class ModelValueUtils {

    public static class ClassInfo {
        String type;
        String name;
        String value;

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

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static List<ClassInfo> getFiledsInfo(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        List<ClassInfo> list = new ArrayList<>();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            ClassInfo info = new ClassInfo();
            info.type = field.getType().toString();
            info.name = field.getName();
            Object value = null;
            String fieldName = field.getName();
            try {
                String getter;
                if (fieldName.startsWith("is")) {
                    String firstLetter = fieldName.substring(2, 3);
                    getter = "is" + firstLetter.toUpperCase() + fieldName.substring(3);
                } else {
                    String firstLetter = fieldName.substring(0, 1);
                    getter = "get" + firstLetter.toUpperCase() + fieldName.substring(1);
                }
                Method method = o.getClass().getMethod(getter);
                value = method.invoke(o);
            } catch (Exception e) {

            }
            info.value = getValueString(value);
            list.add(info);
        }
        return list;
    }

    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String getter;

            if (fieldName.startsWith("is")) {
                String firstLetter = fieldName.substring(2, 3);
                getter = "get" + firstLetter.toUpperCase() + fieldName.substring(1);
            } else {
                String firstLetter = fieldName.substring(0, 1);
                getter = "get" + firstLetter.toUpperCase() + fieldName.substring(3);
            }
            Method method = o.getClass().getMethod(getter);
            return method.invoke(o);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<String> getFiledNames(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }


    public static String getValueString(Object value) {
        if (value instanceof Boolean) {
            return ((Boolean) value) ? "1" : "0";
        } else {
            return value == null ? "0" : value.toString();
        }
    }

}
