package com.source11.worknotes.domain;

import com.source11.worknotes.dao.DaoFactory;
import com.source11.worknotes.dao.PersonDao;

import java.io.Serializable;
import java.util.List;


/**
 * 人员基本信息 VO
 */
public class Person implements Serializable{
    private int pk_personID;
    private String nameSpell;
    private String personName;
    private String workID;
	private int fk_presidentID;
    private short personTypeID;
    private short positionID;
    private String birthday;
    private short sexID;
    private String phone1;
    private String phone2;
    private String memo;
    private short workStatusID;
    private String will1;
    private String will2;

    public int getPk_personID() {
        return pk_personID;
    }

    public void setPk_personID(int pk_personID) {
        this.pk_personID = pk_personID;
    }

    public String getNameSpell() {
        return nameSpell;
    }

    public void setNameSpell(String personNameSpell) {
        this.nameSpell = personNameSpell;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public short getPersonTypeID() {
        return personTypeID;
    }

    public void setPersonTypeID(short personTypeID) {
        this.personTypeID = personTypeID;
    }

    public short getPositionID() {
        return positionID;
    }

    public void setPositionID(short position) {
        this.positionID = position;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public short getSexID() {
        return sexID;
    }

    public void setSexID(short sexID) {
        this.sexID = sexID;
    }



    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone_number) {
        this.phone1 = phone_number;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone_number) {
        this.phone2 = phone_number;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public short getWorkStatusID() {
        return workStatusID;
    }

    public void setWorkStatusID(short workStatusID) {
        this.workStatusID = workStatusID;
    }

    public String getWill1() {
        return will1;
    }

    public void setWill1(String will1) {
        this.will1 = will1;
    }

    public String getWill2() {
        return will2;
    }

    public void setWill2(String will2) {
        this.will2 = will2;
    }

    public int getFk_presidentID() {
        return fk_presidentID;
    }

    public void setFk_presidentID(int fk_presidentid) {
        this.fk_presidentID = fk_presidentid;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }
}

