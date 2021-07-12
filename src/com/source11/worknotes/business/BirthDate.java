package com.source11.worknotes.business;

import com.source11.worknotes.domain.Person;

/**
 * 针对Person的业务处理。
 * 主要功能是：
 * 分解生日中的 年、月、日
 */
public class BirthDate {

    // 指定person的生日year、month、day。
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
     * 装载person信息。
     * @param person 指定的person对象
     */
    public BirthDate(Person person){
        birthYear=person.getBirthday().substring(0,4);
        birthMonth=person.getBirthday().substring(5,7);
        birthDay=person.getBirthday().substring(8,10);
    }

}
