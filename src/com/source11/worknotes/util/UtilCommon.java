package com.source11.worknotes.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.io.UnsupportedEncodingException;

/**
 * ���ù����ࡣ�ṩ�����Ĵ�������
 */
public class UtilCommon {


    /**
     * ����һ��ָ�����ȵ��ַ���
     * @param len ϣ�����ص��ַ����ĳ���
     * @param element ������ɷ����ַ������ַ�
     * @return ����Ϊlen��ȫ����elementָ�����ַ���ɵ��ַ���
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
     * �ж����������Ƿ���ͬһ��
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
     * ���ܣ���ϵͳʱ��ת��Ϊ����Ϊ14���ַ�
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
     * ��ҳ���д�������ݽ����ַ���ת��
     * @param str ��������ַ���
     * @return  ����GBK��ʽ���ַ�����
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

        // �����ʽ���� yyyy-mm-dd ����  yyyy-m-d
        if (index1!=4) return null;
        if (index2<6 || index2>7) return null;

        String year = "0000"+datestr.substring(0,index1);
        String month = "00"+datestr.substring(index1+1,index2);
        String day = "00"+datestr.substring(index2+1);

        year=year.substring(year.length()-4,year.length());
        month=month.substring(month.length()-2,month.length());
        day=day.substring(day.length()-2,day.length());

        try{
            // ����ꡢ�¡��ն��������־ͷ��� null
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
