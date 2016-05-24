package com.xx.nextfilm.utils;

import java.text.SimpleDateFormat;

/**
 * Created by CuiH on 2016/5/23.
 */
public class ValidatorUtils {

    public static boolean isDateValid(String str) {
        if (null != str && !"".equals(str)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                sdf.parse(str);
                return true;
            } catch(Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }


    // 待实现
    public static boolean isCityValid(String str) {
        if (null != str && !"".equals(str)) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isShortValid(String str) {
        if (null != str && !"".equals(str)) {
            try {
                Short s = Short.parseShort(str);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }


    public static boolean isDoubleValid(String str) {
        if (null != str && !"".equals(str)) {
            try {
                Double d = Double.parseDouble(str);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }



}
