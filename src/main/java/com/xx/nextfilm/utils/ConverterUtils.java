package com.xx.nextfilm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CuiH on 2016/5/15.
 */
public class ConverterUtils {

    public static String convertDateToString(Date date) {
        if (date == null) return null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(date);

        return str;
    }

    public static Date convertStringToDate(String str) {
        if (null != str && !"".equals(str)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sdf.parse(str);
                return date;
            } catch(Exception e) {

                return null;
            }
        } else {

            return null;
        }
    }


    public static String convertDateTimeToString(Date datetime) {
        if (datetime == null) return null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str = sdf.format(datetime);

        return str.replace(" ", "T");
    }

    public static Date convertStringToDateTime(String str) {
        if (null != str && !"".equals(str)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date datetime = sdf.parse(str.replace("T", " "));
                return datetime;
            } catch(Exception e) {

                return null;
            }
        } else {

            return null;
        }
    }


    public static String convertStringToGender(String str) {
        if (str != null) {
            if (str.equals("0")) {
                return "女";
            } else if (str.equals("1")){
                return "男";
            } else {
                return "保密";
            }
        } else {
            return null;
        }
    }

    public static String convertGenderToString(String gender) {
        if (gender != null) {
            if (gender.equals("男")) {
                return "1";
            } else if (gender.equals("女")){
                return "0";
            } else {
                return "8";
            }
        } else {
            return null;
        }
    }


    // 待实现
    public static String convertCityToCityCode(String city) {
        return "100000";
    }

    // 待实现
    public static String convertCityCodeToCity(String cityCode) {
        return "广州";
    }


    public static String convertShortToString(Short s) {
        return ""+s;
    }

    public static Short convertStringToShort(String str) {
        if (null != str && !"".equals(str)) {
            try {
                Short s = Short.parseShort(str);
                return s;
            } catch (Exception e) {
                return 0;
            }
        } else {
            return 0;
        }
    }


    public static String convertDoubleToString(Double d) {
        return ""+d;
    }

    public static Double convertStringToDouble(String str) {
        if (null != str && !"".equals(str)) {
            try {
                Double d = Double.parseDouble(str);
                return d;
            } catch (Exception e) {
                return 0.0;
            }
        } else {
            return 0.0;
        }
    }

}
