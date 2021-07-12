package com.source11.worknotes.domain;

import com.source11.worknotes.dao.PersonDao;
import com.source11.worknotes.dao.DaoFactory;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * ������ҳ������д��ݵ����ơ�
 * ��Ҫ��������Ϣ�У��˺�ID����ԱID����Ա��������¼ʱ�䣬�˺ż��𣬿��ñ�־��
 */
public class Tokey {
    // ���ڸ�ʽ
    private SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int personid;
    private String userid;
    private boolean flag;
    private String createDate;  // ����ʱ�䣨��ʽ��yyyy-MM-dd HH:mm:ss��
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
     * ���ݸ������˺���Ϣ������һ�����ơ�
     * @param account ������˺���Ϣ��
     */
    public Tokey(Account account){
        PersonDao persondao=DaoFactory.createPersonDao();
        Person person=persondao.getDetail(account.getFk_personID());
        flag=true;
        username=person.getPersonName();
        level=account.getFk_role();
        personid=account.getFk_personID();
        createDate=formatter.format(new Date());  //��ȡ��ǰʱ�䣻
        userid=account.getPk_userid();
        fk_inspectorPID=person.getFk_presidentID();
    }

}
