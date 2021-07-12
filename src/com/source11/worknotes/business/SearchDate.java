package com.source11.worknotes.business;

import com.source11.worknotes.domain.Worknote;

/**
 * 针对Worknote的业务处理内。
 * 主要功能是：
 * 分解工作日志中 工作日期的年、月、日。
 */
public class SearchDate {
    // 工作日期的 year、month、day。
    private String thisWNYear;
    private String thisWNMonth;
    private String thisWNDay;

    public String getThisWNDay() {
        return thisWNDay;
    }

    public String getThisWNMonth() {
        return thisWNMonth;
    }

    public String getThisWNYear() {
        return thisWNYear;
    }

    /**
     * 装载worknote信息。
     * @param worknote 指定的工作日志对象
     */
    public SearchDate(Worknote worknote){
        thisWNYear = worknote.getWorkDate().substring(0,4);
        thisWNMonth = worknote.getWorkDate().substring(5,7);
        thisWNDay = worknote.getWorkDate().substring(8,10);        
    }

}
