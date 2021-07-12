package com.source11.worknotes.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.io.UnsupportedEncodingException;

/**
 * 常用工具类。提供公共的处理方法。
 */
public class UtilCommon {


    /**
     * 构造一个指定长度的字符串
     * @param len 希望返回的字符串的长度
     * @param element 用于组成返回字符串的字符
     * @return 长度为len，全部由element指定的字符组成的字符串
     */
    public static String space(int len, char element){
        if (len < 1){
            return "";
        }

        char elements[] = new char[len];
        for (int i = 0; i < len; i++){
            elements[i] = element;
        }
        return new String(elements);
    }

    /**
     * 判断两个日期是否是同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isTheSameDay(java.util.Date date1, java.util.Date date2){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 功能：把系统时间转化为长度为14的字符
     * @return executeTime
     */
    public static String getExecuteTime(){
        String executeTime = "";
        java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
        executeTime = executeTime + time;
        //formate timestamp:yyyymmddhhmmss(yyyy:year;mm:month;dd:day;hh:hour;mm:minute;
        //ss:seconds)
        executeTime = executeTime.substring(0, 4) + executeTime.substring(5, 7)
                      + executeTime.substring(8, 10) + executeTime.substring(11, 13)
                      + executeTime.substring(14, 16) + executeTime.substring(17, 19);
        return executeTime;
    }

    /**
     * 将页面中传入的数据进行字符集转换
     * @param str 待传入的字符串
     * @return  返回GBK格式的字符串。
     */
    public static String getGBK(String str){
        String result=null;
            if (str!=null){
                try {
                    return new String(str.getBytes("8859_1"), "GBK");
                }catch(UnsupportedEncodingException ex){
                    ex.printStackTrace();
                    return null;
                }
            }
        return result;
    }

    public static String getValidDate(String datestr){

        int index1=datestr.indexOf(45);
        int index2=datestr.indexOf(45,index1+1);

        // 如果格式不是 yyyy-mm-dd 或者  yyyy-m-d
        if (index1!=4) return null;
        if (index2<6 || index2>7) return null;

        String year = "0000"+datestr.substring(0,index1);
        String month = "00"+datestr.substring(index1+1,index2);
        String day = "00"+datestr.substring(index2+1);

        year=year.substring(year.length()-4,year.length());
        month=month.substring(month.length()-2,month.length());
        day=day.substring(day.length()-2,day.length());

        try{
            // 如果年、月、日都不是数字就返回 null
            Integer.parseInt(year);
            Integer.parseInt(month);
            Integer.parseInt(day);
        }catch (NumberFormatException ex){
            return null;
        }

        String date=year+"-"+month+"-"+day; 
        return date;

    }


}
