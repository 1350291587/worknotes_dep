package com.source11.worknotes.dao;

import com.source11.worknotes.domain.Account;

import java.util.List;

/**
 * ��־¼���˻���DAO 
 */
public interface AccountDao {
    /**
     * ��account��������ݱ��浽���ݿ���
     * @param account �����Account ����VO��
     */
    public void creat(Account account);

    /**
     * ���ݵ�ǰ��Account���󣬸���ָ��������
     * @param account ָ����Accont����
     */
    public void update(Account account);

    /**
     * ���ݵ�ǰ��Account���󣬸���ָ�������ݣ����������롣
     * @param account ָ����Accont����
     */
    public void updateNoPass(Account account);


    /**
     * ���ݵ�ǰ��Account�����޸ĵ�¼���
     * @param account ָ����Accont����
     */
    public void changePwd(Account account);

    /**
     * ����ָ���ļ�¼id�������ݿ���ɾ��ָ����Account���ݡ�
     * @param userid ��ɾ����Account��¼ID
     */
    public void deleteAccount(String userid);

    /**
     * ����ָ������Աid�������ݿ���ȡ�ø���Ա���е��˺š�
     * @param fk_personID  ����ѯ��Account��¼ID
     * @return ����ȡ�õ�Account ����Ķ��С�
     */
    public List getListByPID(int fk_personID);

    /**
     * �����ṩ���û��������룬�����ݿ���ȡ����ϸ��Ϣ��
     * @param userid  ����ѯ��ϵͳ�˻�ID
     * @param passwd  ����ѯ���˻�����
     * @return ����ҵ����ϵļ�¼�ͷ�����Ӧ��Account���󣬷��򷵻�null
     */
    public Account getDetailbyUSR$PWD(String userid,String passwd);

    /**
     * �����ṩ���û��������룬�����ݿ���ȡ����ϸ��Ϣ��
     * @param accountid  ����ѯ��ϵͳ�˻�ID
     * @return ����ҵ����ϵļ�¼�ͷ�����Ӧ��Account���󣬷��򷵻�null
     */
    public Account getDetailbyAccountID(int accountid);

    /**
     * �����ݿ���ȡ�� ���е�Account���ݡ�
     * @return ����ȡ�õ�Account ����Ķ��С�
     */
    public List getList();
}
