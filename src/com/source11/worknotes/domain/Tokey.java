package com.source11.worknotes.domain;

import com.source11.worknotes.dao.PersonDao;
import com.source11.worknotes.dao.DaoFactory;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 用来在页面访问中传递的令牌。
 * 主要包含的信息有：账号ID，人员ID，人员姓名，登录时间，账号级别，可用标志。
 */
public class Tokey {
    // 日期格式
    private SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int personid;
    private String userid;
    private boolean flag;
    private String createDate;  // 创建时间（格式：yyyy-MM-dd HH:mm:ss）
    private String username;
    private short level;

    private int fk_inspectorPID;

    public int getPersonid() {
        return personid;
    }

    public String getUserid() {
        return userid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public boolean isFlag() {
        return flag;
    }


    public short getLevel() {
        return level;
    }

    public String getUsername() {
        return username;
    }

    public int getFk_inspectorPID() {
        return fk_inspectorPID;
    }

    public boolean isValid(){
        return flag;
    }

    public void disable(){
        flag=false;
    }

    /**
     * 根据给定的账号信息，创建一个令牌。
     * @param account 传入的账号信息。
     */
    public Tokey(Account account){
        PersonDao persondao=DaoFactory.createPersonDao();
        Person person=persondao.getDetail(account.getFk_personID());
        flag=true;
        username=person.getPersonName();
        level=account.getFk_role();
        personid=account.getFk_personID();
        createDate=formatter.format(new Date());  //获取当前时间；
        userid=account.getPk_userid();
        fk_inspectorPID=person.getFk_presidentID();
    }

}
