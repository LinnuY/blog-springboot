package org.linuy.blog.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LongTeng
 * @date 2022/05/10
 **/
public class JsonUtils {

    public static String toJsonString(Object obj) {
        StringBuilder sb = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        for (Field declaredField : clazz.getDeclaredFields()) {
            try {
                declaredField.setAccessible(true);
                Object value = declaredField.get(obj);
                sb.append(declaredField.getName()).append(":");
                if (value == null) {
                    sb.append("null");
                } else if (value instanceof Date) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    sb.append("\"").append(simpleDateFormat.format((Date) declaredField.get(obj))).append("\"");
                } else if (value instanceof String) {
                    sb.append("\"").append(value).append("\"");
                } else if (value instanceof List<?>) {
                    for (Object listObj : ((List<?>) value)) {
                        sb.append("[").append(toJsonString(listObj)).append("]");
                    }
                } else if (value instanceof Map<?, ?>) {
                    sb.append(value);
                } else {
                    sb.append(value);
                }
                sb.append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (sb.lastIndexOf(",") != -1) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
