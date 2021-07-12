package com.source11.worknotes.business;

import com.source11.worknotes.dao.DaoFactory;
import com.source11.worknotes.dao.AccountDao;
import com.source11.worknotes.domain.Account;

import java.util.List;
import java.util.Iterator;

/**
 * ���Account��ҵ������ࡣ
 * ��Ҫ�����ǣ�
 * 1. ����ҵ���߼��Ĵ���
 * 2. �Գ־ò��ȡ�����ݽ������ݹ��ˡ�
 */
public class AccountBD {

    /**
     * ���һ��AccountDao��ʵ���壬��������DAO����ʡ�
     */
    private static AccountDao accountdao=DaoFactory.createAccountDao();

    /**
     * ������е�Account��Ϣ
     * @return ȫ���˺�
     */
    public static List getAllAccount(){
        return accountdao.getList();
    }

    /**
     * ���ָ��person��ȫ��ʹ�õ��˺š�
     * @param personid ָ����person�ڲ����
     * @return ���з���Ҫ���account
     */
    public static List getListByPersonID(int personid){
        return accountdao.getListByPID(personid);
    }

    /**
     * ����ָ�����û��������룬��ö�Ӧ���˺���Ϣ��
     * @param user ָ���ĵ�¼�˺�
     * @param pass ��¼����
     * @return ����Ҫ����˺���Ϣ
     */
    public static Account getAccount(String user,String pass){
        return accountdao.getDetailbyUSR$PWD(user,pass);
    }

    /**
     * ����ָ�����˺ż�¼��ˮ�ţ����ָ�����˺���Ϣ��
     * @param accountid �˺ŵļ�¼��ˮ��
     * @return ����Ҫ����˺���Ϣ��
     */
    public static Account getAccount(int accountid){
        return accountdao.getDetailbyAccountID(accountid);
    }

    /**
     * �˺���Ϣ���¡�
     * 1. ����޸ĺ�ĵ�¼�˺������ݿ��в����ڣ�Ҳ����û��������ʹ�ø��˺ţ���
     * �Ϳ����޸ģ���������
     * 2. �������û�б�������Ͳ�ִ������ı����
     * ����ִ������ı����
     * ע����Ϊ���������ݿ��б����Ǽ��ܵģ��Ҳ����棩�����Ա�����ô����
     * @param account
     * @param passwd
     */
    public static void updateAccount(Account account,String passwd){
        List list=accountdao.getList();
        // �ж��Ƿ�����˺���ͬ������Ԫ�ء�
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Account account1=(Account)iterator.next();
            // �ж�accountid��ͬ��Ԫ�أ�userid�Ƿ���ͬ
            if (account1.getPk_userid().equals(account.getPk_userid())&&
                    account1.getPk_accountID()!=account.getPk_accountID()){
                return;
            }
        }

        // �ж������Ƿ���¡�
        if (account.getPassword().equals(passwd)){
            // ����û�и���
            accountdao.updateNoPass(account);
        }else{
            // �����Ѿ�����
            accountdao.update(account);
        }
    }

    /**
     * ����һ���µ��˺���Ϣ��
     * ע����������ݿ����Ѿ�������ͬ���˺ţ��Ͳ������ˡ�
     * @param account
     */
    public static void createAccount(Account account){
        List list=accountdao.getList();
        // �ж��Ƿ�����˺���ͬ��Ԫ�ء�
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            if (((Account)iterator.next()).getPk_userid().equals(account.getPk_userid())){
                return;
            }
        }
        accountdao.creat(account);
    }

}
