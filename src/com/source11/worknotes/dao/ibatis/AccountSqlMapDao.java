package com.source11.worknotes.dao.ibatis;

import com.ibatis.dao.client.DaoManager;
import com.source11.worknotes.dao.AccountDao;
import com.source11.worknotes.domain.Account;

import java.util.List;

public class AccountSqlMapDao extends BaseSqlMapDao implements AccountDao {

    public AccountSqlMapDao(DaoManager daoManager) {
        super(daoManager);
    }

    public void creat(Account account) {
        update("insertAccount", account);
    }

    public void update(Account account) {
        update("updateAccount", account);
    }

    public void updateNoPass(Account account) {
        update("updateAccountNoPass", account);
    }

    public void changePwd(Account account) {
        update("updatePassword", account);
    }

    public void deleteAccount(String userid) {
        update("deleteAccount", userid);
    }

    public List getListByPID(int fk_personID) {
        return queryForList("getAccountbyPID", Integer.valueOf(fk_personID));
    }

    public Account getDetailbyUSR$PWD(String userid, String passwd) {
        Account account = new Account();
        account.setPk_userid(userid);
        account.setPassword(passwd);
        List list=queryForList("getAccountByUsernameAndPassword",account);
        if (list.size()==0) return null;
        return (Account)list.get(0);
    }

    public Account getDetailbyAccountID(int accountid) {
        return (Account)queryForObject("getAccountByAccountID",Integer.valueOf(accountid));
    }

    public List getList() {
        return queryForList("getAccountAll", null);
    }
}
