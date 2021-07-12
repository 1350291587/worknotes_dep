package com.source11.worknotes.domain;

import java.io.Serializable;

/**
 * 日志录入账户 VO
 */
public class Account implements Serializable {
    private int pk_accountID;
    private String pk_userid;
    private String password;
    private short workstatus;
    private int fk_personID;
    private short fk_role;
    private String will1;
    private String will2;

    public String getPk_userid() {
        return pk_userid;
    }

    public void setPk_userid(String pk_userid) {
        this.pk_userid = pk_userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFk_personID() {
        return fk_personID;
    }

    public void setFk_personID(int fk_personID) {
        this.fk_personID = fk_personID;
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



    public short getWorkstatus() {
        return workstatus;
    }

    public void setWorkstatus(short workstatus) {
        this.workstatus = workstatus;
    }

    public short getFk_role() {
        return fk_role;
    }

    public void setFk_role(short fk_role) {
        this.fk_role = fk_role;
    }

    public int getPk_accountID() {
        return pk_accountID;
    }

    public void setPk_accountID(int pk_accountID) {
        this.pk_accountID = pk_accountID;
    }

}
