package com.source11.worknotes.dao;

import com.source11.worknotes.dao.ibatis.DaoConfig;

/**
 * DAO对象静态工厂类.
 *
 */
public class DaoFactory {
    static int flag=2;

    public static  AccountDao createAccountDao(){

        if (flag==2)
            return (AccountDao) DaoConfig.getDaoManager().getDao(AccountDao.class);

        return null;
    }

    public static  CodeRefDao createCodeRefDao(){

        if (flag==2)
            return (CodeRefDao) DaoConfig.getDaoManager().getDao(CodeRefDao.class);

       return null;
    }

    public static PersonDao createPersonDao(){
        if (flag==2)
            return (PersonDao) DaoConfig.getDaoManager().getDao(PersonDao.class);
        return null;
    }

    public static WorknoteDao createWorknoteDao(){
        if (flag==2){
            return (WorknoteDao) DaoConfig.getDaoManager().getDao(WorknoteDao.class);
        }
        return null;
    }

}
