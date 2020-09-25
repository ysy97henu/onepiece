package com.yinsy.onepiece.common.util;

import com.yinsy.onepiece.common.base.BaseException;
import org.springframework.util.StringUtils;

/**
 * 扩展工具类：字符串工具类扩展
 * 继承：Spring提供的StringUtils
 *
 * @author yinsongyuan
 */
public class ExtendStringUtils extends StringUtils {

    /**
     * 首字母大写
     */
    public static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * 下划线转换为驼峰
     */
    public static String camelCaseName(String underscoreName) {
        if (!underscoreName.contains("_")) {
            return underscoreName;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < underscoreName.length(); i++) {
            char ch = underscoreName.charAt(i);
            if (flag) {
                ch -= 32;
                flag = false;
            }
            if ("_".charAt(0) == ch) {
                flag = true;
            } else {
                if (flag) {
                    result.append(Character.toUpperCase(ch));
                    flag = false;
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    /**
     * 数据库类型->JAVA类型
     *
     * @param dbType 数据库类型
     * @return JAVA类型
     */
    public static String dataTypeToJavaType(String dbType) {
        String javaType = null;
        switch (dbType) {
            case "bigint":
                javaType = "Long";
                break;
            case "int":
                javaType = "Integer";
                break;
            case "tinyint":
                javaType = "Boolean";
                break;
            case "varchar":
                javaType = "String";
                break;
            case "timestamp":
                javaType = "Timestamp";
                break;
            default:
                throw new BaseException("不可识别的数据库类型");
        }
        return javaType;
    }
}

