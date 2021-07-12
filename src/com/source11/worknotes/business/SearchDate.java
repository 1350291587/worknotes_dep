package com.source11.worknotes.business;

import com.source11.worknotes.domain.Worknote;

/**
 * ���Worknote��ҵ�����ڡ�
 * ��Ҫ�����ǣ�
 * �ֽ⹤����־�� �������ڵ��ꡢ�¡��ա�
 */
public class SearchDate {
    // �������ڵ� year��month��day��
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
     * װ��worknote��Ϣ��
     * @param worknote ָ���Ĺ�����־����
     */
    public SearchDate(Worknote worknote){
        thisWNYear = worknote.getWorkDate().substring(0,4);
        thisWNMonth = worknote.getWorkDate().substring(5,7);
        thisWNDay = worknote.getWorkDate().substring(8,10);        
    }

}
