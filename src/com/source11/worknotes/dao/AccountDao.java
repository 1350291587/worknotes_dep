package com.source11.worknotes.dao;

import com.source11.worknotes.domain.Account;

import java.util.List;

/**
 * 日志录入账户的DAO 
 */
public interface AccountDao {
    /**
     * 将account对象的数据保存到数据库中
     * @param account 传入的Account 对象（VO）
     */
    public void creat(Account account);

    /**
     * 根据当前的Account对象，更新指定的数据
     * @param account 指定的Accont对象
     */
    public void update(Account account);

    /**
     * 根据当前的Account对象，更新指定的数据，不包括密码。
     * @param account 指定的Accont对象
     */
    public void updateNoPass(Account account);


    /**
     * 根据当前的Account对象，修改登录口令。
     * @param account 指定的Accont对象
     */
    public void changePwd(Account account);

    /**
     * 根据指定的记录id，从数据库中删除指定的Account数据。
     * @param userid 待删除的Account记录ID
     */
    public void deleteAccount(String userid);

    /**
     * 根据指定的人员id，从数据库中取得该人员所有的账号。
     * @param fk_personID  待查询的Account记录ID
     * @return 返回取得的Account 对象的队列。
     */
    public List getListByPID(int fk_personID);

    /**
     * 根据提供的用户名和密码，从数据库中取得详细信息。
     * @param userid  待查询的系统账户ID
     * @param passwd  待查询的账户密码
     * @return 如果找到符合的记录就返回相应的Account对象，否则返回null
     */
    public Account getDetailbyUSR$PWD(String userid,String passwd);

    /**
     * 根据提供的用户名和密码，从数据库中取得详细信息。
     * @param accountid  待查询的系统账户ID
     * @return 如果找到符合的记录就返回相应的Account对象，否则返回null
     */
    public Account getDetailbyAccountID(int accountid);

    /**
     * 从数据库中取得 所有的Account数据。
     * @return 返回取得的Account 对象的队列。
     */
    public List getList();
}
