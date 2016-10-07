package cn.fireworkstudio.admin.util;

import cn.fireworkstudio.admin.constant.StringConstant;

import java.util.List;

/**
 * Copyright: 2016 FireworkStudio
 * *
 * Author:  Daniel Kong
 * Desc:    String utility
 */
public class StringUtils {

    /**
     * Get valid string
     *
     * @param str input string
     * @return processed string
     */
    public static String getValidString(String str) {
        return (str == null) ? StringConstant.EMPTY_STRING : str;
    }

    /**
     * Check if string is empty
     *
     * @param str input string
     * @return if empty return true
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * Check if string is not empty
     *
     * @param str input string
     * @return if not empty return true
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Concat string from array list
     *
     * @param strList         string list
     * @param concatCharacter concat character
     * @return processed string
     */
    public static String concatStrFromList(List<String> strList, String concatCharacter) {
        if (concatCharacter == null)
            concatCharacter = StringConstant.DEFAULT_STRING_SEPARATOR;

        if (strList != null && !strList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = strList.size();

            for (int i = 0; i < size; ++i) {
                sb.append(strList.get(i));
                if (i < size - 1)
                    sb.append(concatCharacter);
            }
            return sb.toString();
        }
        return StringConstant.EMPTY_STRING;
    }
}
