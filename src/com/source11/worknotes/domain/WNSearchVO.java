package com.source11.worknotes.domain;

/**
 * DAO��worknotes��ѯ��ֵ���ݶ��������������ڷ�Χ����ʼ���ڣ��������ڣ�
 * ��Ϊ������־ֻ��һ���������ڡ������Ҫ��ѯָ�����ڷ�Χ�����ݣ��Ͳ�����Worknote����
 */
public class WNSearchVO {
    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    private int personid;       // ��Ա�ڲ����
    private String startdate;   // ��ѯ��ʼ���ڣ���ʽ��yyyy-MM-dd ��
    private String enddate;     // ��ѯ�������ڣ���ʽ��yyyy-MM-dd ��


}
