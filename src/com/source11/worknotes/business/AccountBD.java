package com.source11.worknotes.business;

import com.source11.worknotes.dao.DaoFactory;
import com.source11.worknotes.dao.AccountDao;
import com.source11.worknotes.domain.Account;

import java.util.List;
import java.util.Iterator;

/**
 * 针对Account的业务代理类。
 * 主要功能是：
 * 1. 进行业务逻辑的处理
 * 2. 对持久层获取的数据进行数据过滤。
 */
public class AccountBD {

    /**
     * 获得一个AccountDao的实现体，用来进行DAO层访问。
     */
    private static AccountDao accountdao=DaoFactory.createAccountDao();

    /**
     * 获得所有的Account信息
     * @return 全部账号
     */
    public static List getAllAccount(){
        return accountdao.getList();
    }

    /**
     * 获得指定person的全部使用的账号。
     * @param personid 指定的person内部编号
     * @return 所有符合要求的account
     */
    public static List getListByPersonID(int personid){
        return accountdao.getListByPID(personid);
    }

    /**
     * 根据指定的用户名和密码，获得对应的账号信息。
     * @param user 指定的登录账号
     * @param pass 登录口令
     * @return 符合要求的账号信息
     */
    public static Account getAccount(String user,String pass){
        return accountdao.getDetailbyUSR$PWD(user,pass);
    }

    /**
     * 根据指定的账号记录流水号，获得指定的账号信息。
     * @param accountid 账号的记录流水号
     * @return 符合要求的账号信息。
     */
    public static Account getAccount(int accountid){
        return accountdao.getDetailbyAccountID(accountid);
    }

    /**
     * 账号信息更新。
     * 1. 如果修改后的登录账号在数据库中不存在（也就是没有其他人使用该账号），
     * 就可以修改，否则不允许。
     * 2. 如果密码没有变更过，就不执行密码的变更，
     * 否则执行密码的变更。
     * 注：因为密码在数据库中保存是加密的（且不可逆），所以必须这么处理。
     * @param account
     * @param passwd
     */
    public static void updateAccount(Account account,String passwd){
        List list=accountdao.getList();
        // 判断是否存在账号相同的其他元素。
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Account account1=(Account)iterator.next();
            // 判断accountid不同的元素，userid是否相同
            if (account1.getPk_userid().equals(account.getPk_userid())&&
                    account1.getPk_accountID()!=account.getPk_accountID()){
                return;
            }
        }

        // 判断密码是否更新。
        if (account.getPassword().equals(passwd)){
            // 密码没有更新
            accountdao.updateNoPass(account);
        }else{
            // 密码已经更新
            accountdao.update(account);
        }
    }

    /**
     * 创建一个新的账号信息。
     * 注：如果在数据库中已经存在相同的账号，就不保存了。
     * @param account
     */
    public static void createAccount(Account account){
        List list=accountdao.getList();
        // 判断是否存在账号相同的元素。
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            if (((Account)iterator.next()).getPk_userid().equals(account.getPk_userid())){
                return;
            }
        }
        accountdao.creat(account);
    }

}
