package com.source11.worknotes.business;

import com.source11.worknotes.domain.Person;

/**
 * ���Person��ҵ����
 * ��Ҫ�����ǣ�
 * �ֽ������е� �ꡢ�¡���
 */
public class BirthDate {

    // ָ��person������year��month��day��
    private String birthYear;
    private String birthMonth;
    private String birthDay;

    public  String getBirthDay() {
        return birthDay;
    }

    public  String getBirthMonth() {
        return birthMonth;
    }

    public  String getBirthYear() {
        return birthYear;
    }

    /**
     * װ��person��Ϣ��
     * @param person ָ����person����
     */
    public BirthDate(Person person){
        birthYear=person.getBirthday().substring(0,4);
        birthMonth=person.getBirthday().substring(5,7);
        birthDay=person.getBirthday().substring(8,10);
    }

}
