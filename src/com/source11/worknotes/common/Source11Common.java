package com.source11.worknotes.common;

/**
 * 公用常量接口
 */
public interface Source11Common{
    // 创建字符串常量
    public final static byte DISABLE=1;
    public final static byte ENABLE=0;
    public final static String SPACE="";

    public final static String NO_DATE = "0000-00-00 ";
    public final static String START_TIME_OF_DAY = "00:00:00";
    public final static String END_TIME_OF_DAY = "23:59:59.99";

    public final static String DATE_MAX = "2025-12-31";
    public final static String DATE_MIN = "2006-01-01";

    public static int DIALOG_STATE_HIDE=0;

    public static short INDEX_WORKNOTE_WORKINGORDER=1100;
    public static short INDEX_WORKNOTE_WORKINGTIME=1200;
    public static short INDEX_WORKNOTE_REVIEWRESULT=1300;

    public static short INDEX_PERSON_SEX=2100;
    public static short INDEX_PERSON_TYPE=2200;
    public static short INDEX_PERSON_WORKSTATUS=2300;
    public static short INDEX_PERSON_POSITION=2400;

    

}