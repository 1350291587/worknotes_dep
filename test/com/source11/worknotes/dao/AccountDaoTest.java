package com.source11.worknotes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;
import com.source11.worknotes.domain.Account;
import com.source11.worknotes.common.DAORuntimeException;
import com.source11.worknotes.common.Source11Common;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2006-11-24
 * Time: 10:03:49
 * To change this template use File | Settings | File Templates.
 */
public class AccountDaoTest extends TestCase implements Source11Common{
    AccountDao accountdao1;
    AccountDao accountdao2;
    private static Statement st;

    static{
        Properties props=new Properties();
        props.put("useUnicode","true");
        props.put("characterEncoding","gb2312");

        try {
            st=new MysqlDS().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setUp(){
        String insert0="INSERT INTO `account_main` (`PK_UserID`, `password`, `FK_PersonID`,  `FK_role`, "+
                        "`workStatus`, `Status`, `CreateTime`, `UpdateTime`, `will1`, `will2`) " +
                        "VALUES ('zhangsan',password('123'),13,2,1,0,CURRENT_TIMESTAMP,'2006-11-25 22:20:54','中国',NULL)";
        String insert1="INSERT INTO `account_main` (`PK_UserID`, `password`, `FK_PersonID`, `FK_role`, " +
                        "`workStatus`, `Status`, `CreateTime`, `UpdateTime`, `will1`, `will2`) " +
                        "VALUES ('lisi',password('123456'),1,3,0,0,'2007-01-20 16:08:40','2007-05-11 02:12:38',NULL,'人民')";
        String delete1="delete from account_main ";
        try {
            Properties props=new Properties();
            props.put("useUnicode","true");
            props.put("characterEncoding","gb2312");

            Statement st=new MysqlDS().getConnection().createStatement();
            st.execute(delete1);
            st.execute(insert0);
            st.execute(insert1);

        } catch (SQLException ex) {
            ex.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        accountdao1=DaoFactory.createAccountDao();
        accountdao2=DaoFactory.createAccountDao();

    }

    public void tearDown(){
        accountdao1=null;
        accountdao2=null;
    }

    public void testGetDetailbyUSR$PWD() throws SQLException {
        String userid="zhangsan";
        String passwd="123";
        String userid1=null;
        String userid2=null;
        String passwd1=null;
        String passwd2=null;

        short workstatus1=1;
        short workstatus2=0;
        short role1=2;
        short role2=3;

        int personid1=13;
        int personid2=1;

        String will11="中国";
        String will12=null;
        String will21=null;
        String will22="人民";

        String sql="select * from account_main where PK_UserID='"+userid+"' and password=password('"+passwd+"') and status="+ENABLE;
        ResultSet rs=st.executeQuery(sql);

        if (rs==null) throw new DAORuntimeException("can not find this record !");

        try {
            if (!rs.next()) throw new DAORuntimeException("can not find this record !");
            userid1=rs.getString(2);
            passwd1=rs.getString(3);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        Account account1=accountdao1.getDetailbyUSR$PWD(userid,passwd);
        assertEquals(userid1,account1.getPk_userid());
        assertEquals(passwd1,account1.getPassword());
        assertEquals(workstatus1,account1.getWorkstatus());
        assertEquals(role1,account1.getFk_role());
        assertEquals(personid1,account1.getFk_personID());
        assertEquals(will11,account1.getWill1());
        assertEquals(will21,account1.getWill2());

        userid="lisi";
        passwd="123456";

        sql="select * from account_main where PK_UserID='"+userid+"' and password=password('"+passwd+"') and status="+ENABLE;
        rs=st.executeQuery(sql);

        if (rs==null) throw new DAORuntimeException("can not find this record !");

        try {
            if (!rs.next()) throw new DAORuntimeException("can not find this record !");
            userid2=rs.getString(2);
            passwd2=rs.getString(3);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        account1=accountdao2.getDetailbyUSR$PWD(userid,passwd);
        assertEquals(userid2,account1.getPk_userid());
        assertEquals(passwd2,account1.getPassword());
        assertEquals(workstatus2,account1.getWorkstatus());
        assertEquals(role2,account1.getFk_role());
        assertEquals(personid2,account1.getFk_personID());
        assertEquals(will12,account1.getWill1());
        assertEquals(will22,account1.getWill2());



    }

    public void testGetList(){
        String[] userid={"lisi","zhangsan"};
        String[] passwd={"123456","123"};
        short[] workstatus={0,1};
        short[] role={3,2};
        int[] personid={1,13};
        String[] will1={null,"中国"};
        String[] will2={"人民",null};

        List list=accountdao1.getList();

        assertEquals(2,list.size());

        for (int indicator=0;indicator<list.size();indicator++){
            Account account1=(Account)list.get(indicator);
            assertEquals(userid[indicator],account1.getPk_userid());
            assertEquals(workstatus[indicator],account1.getWorkstatus());
            assertEquals(role[indicator],account1.getFk_role());
            assertEquals(personid[indicator],account1.getFk_personID());
            assertEquals(will1[indicator],account1.getWill1());
            assertEquals(will2[indicator],account1.getWill2());
        }
    }

    public void testCreate() throws SQLException {
        // 数据初始化
        String[] userid={"zhangsan","lisi"};
        String[] passwd={"123","123456"};
        short[] workstatus={1,0};
        short[] role={2,3};
        int[] personid={13,1};
        String[] will1={"中国",null};
        String[] will2={null,"人民"};

        Account account[]=new Account[2];
        account[0]=new Account();
        account[1]=new Account();

        for (int i=0;i<2;i++){
            account[i].setFk_personID(personid[i]);
            account[i].setFk_role(role[i]);
            account[i].setPassword(passwd[i]);
            account[i].setPk_userid(userid[i]);
            account[i].setWill1(will1[i]);
            account[i].setWill2(will2[i]);
            account[i].setWorkstatus(workstatus[i]);
        }

        String delete1="delete from account_main";

        st.execute(delete1);

        accountdao1.creat(account[0]);
        accountdao2.creat(account[1]);

        for (int i=0;i<2;i++){
            String sql="select * from account_main where PK_UserID='"+userid[i]+"' and password=password('"+passwd[i]+"') and status="+ENABLE;
            ResultSet rs=st.executeQuery(sql);

            if (rs==null) throw new DAORuntimeException("can not find this record !");

            try {
                if (!rs.next()) throw new DAORuntimeException("can not find this record !");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            Account account1=accountdao1.getDetailbyUSR$PWD(userid[i],passwd[i]);
            assertEquals(userid[i],account1.getPk_userid());
            assertEquals(workstatus[i],account1.getWorkstatus());
            assertEquals(role[i],account1.getFk_role());
            assertEquals(personid[i],account1.getFk_personID());
            assertEquals(will1[i],account1.getWill1());
            assertEquals(will2[i],account1.getWill2());


        }
    }

    public void testUpdate() throws SQLException {

        String insert0="INSERT INTO `account_main` (`PK_UserID`, `password`, `FK_PersonID`,  `FK_role`, "+
                        "`workStatus`, `Status`, `CreateTime`, `UpdateTime`, `will1`, `will2`) " +
                        "VALUES ('zhangsan',password('123'),13,2,1,0,CURRENT_TIMESTAMP,'2006-11-25 22:20:54','中国',NULL)";
        String insert1="INSERT INTO `account_main` (`PK_UserID`, `password`, `FK_PersonID`, `FK_role`, " +
                        "`workStatus`, `Status`, `CreateTime`, `UpdateTime`, `will1`, `will2`) " +
                        "VALUES ('lisi',password('123456'),1,3,0,0,'2007-01-20 16:08:40','2007-05-11 02:12:38',NULL,'人民')";
        String delete1="delete from account_main ";

        try {
            Properties props=new Properties();
            props.put("useUnicode","true");
            props.put("characterEncoding","gb2312");

            Statement st=new MysqlDS().getConnection().createStatement();
            st.execute(delete1);
            st.execute(insert0);
            st.execute(insert1);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        // 数据初始化
        String[] userid={"zhangsan","lisi"};
        String[] passwd={"123","123456"};
        short[] workstatus={2,3};
        short[] role={1,0};
        String[] will1={null,"中华人民共和国"};
        String[] will2={"人民完税",null};

        Account account[]=new Account[2];
        account[0]=new Account();
        account[1]=new Account();

        for (int i=0;i<2;i++){
            String sql="select * from account_main where PK_UserID='"+userid[i]+"' and password=password('"+passwd[i]+"') and status="+ENABLE;
            ResultSet rs=st.executeQuery(sql);

            if (rs==null) throw new DAORuntimeException("can not find this record !");

            try {
                if (!rs.next()) throw new DAORuntimeException("can not find this record !");
                // 获取该账号的ID。
                account[i].setPk_accountID(rs.getInt(1));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        passwd[0]="_free";
        passwd[0]="@kknd_#";

        // 装载新的变更数据。
        for (int i=0;i<2;i++){
            account[i].setFk_role(role[i]);
            account[i].setPassword(passwd[i]);
            account[i].setPk_userid(userid[i]);
            account[i].setWill1(will1[i]);
            account[i].setWill2(will2[i]);
            account[i].setWorkstatus(workstatus[i]);
        }

        accountdao1.update(account[0]);
        accountdao2.update(account[1]);

        for (int i=0;i<2;i++){
            String sql="select * from account_main where PK_UserID='"+userid[i]+"' and password=password('"+passwd[i]+"') and status="+ENABLE;
            ResultSet rs=st.executeQuery(sql);

            if (rs==null) throw new DAORuntimeException("can not find this record !");

            try {
                if (!rs.next()) throw new DAORuntimeException("can not find this record !");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            Account account1=accountdao1.getDetailbyUSR$PWD(userid[i],passwd[i]);
            assertEquals(userid[i],account1.getPk_userid());
            assertEquals(workstatus[i],account1.getWorkstatus());
            assertEquals(role[i],account1.getFk_role());
            assertEquals(will1[i],account1.getWill1());
            assertEquals(will2[i],account1.getWill2());

        }
    }

    public void testDelete() throws SQLException {
        String[] userid={"zhangsan","lisi"};
        Account account[]=new Account[2];
        account[0]=new Account();
        account[1]=new Account();

        account[0].setPk_userid(userid[0]);
        account[1].setPk_userid(userid[1]);

        accountdao1.deleteAccount(userid[0]);
        accountdao2.deleteAccount(userid[1]);

        for (int i=0;i<2;i++){
            String sql="select * from account_main where PK_UserID='"+userid[i]+"' and status="+ENABLE;
            ResultSet rs=st.executeQuery(sql);

            try {
                if (rs.next()){
                    throw new DAORuntimeException("can not delete this record !");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DAORuntimeException("database check error !");
            }

        }

    }

    public void testGetListByPID() throws SQLException {
        String insert2="INSERT INTO `account_main` (`PK_UserID`, `password`, `FK_PersonID`, `FK_role`, " +
                                "`workStatus`, `Status`, `CreateTime`, `UpdateTime`, `will1`, `will2`) " +
                                "VALUES ('lisi','_free',13,3,0,0,'2007-01-20 16:08:40','2007-05-11 02:12:38',NULL,'人民')";
        st.execute(insert2);
        String userid[]={"lisi","zhangsan"};
        String passwd[]={"_free","123"};
        Account account[]=new Account[2];
        account[0]= new Account();
        account[1]= new Account();

        List list=accountdao1.getListByPID(13);

        assertEquals(2,list.size());

        for(int i=0;i<2;i++){
            account[i]=(Account)list.get(i);

            assertEquals(userid[i],account[i].getPk_userid());
        }
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(AccountDaoTest.class);
    }
}
