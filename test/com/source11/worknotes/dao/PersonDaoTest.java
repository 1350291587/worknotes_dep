package com.source11.worknotes.dao;

import junit.framework.TestCase;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.List;

import com.source11.worknotes.domain.Person;
import com.source11.worknotes.common.DAORuntimeException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2007-5-29
 * Time: 13:04:50
 * To change this template use File | Settings | File Templates.
 */
public class PersonDaoTest extends TestCase{
    PersonDao persondao1;
    PersonDao persondao2;
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
        String insert0="INSERT INTO person_main (nameSpell, personName, workID,FK_presidentID," +
                "personTypeID, positionID, birthday,SexID,phone1,phone2,memo, workStatusID, " +
                "Status, UpdateTime, CreateTime, will1, will2) " +
                "VALUES ('zhangsan','张三','5107 03 020',13,3,6,'1982-01-18',1,'13801381380','08162229969'," +
                "'fdsfdasfdsfdsf',2,0,CURRENT_TIMESTAMP,'2006-11-25 22:20:54','中国',NULL);";

        String insert1="INSERT INTO person_main (nameSpell, personName, workID,FK_presidentID," +
                "personTypeID, positionID, birthday,SexID,phone1,phone2,memo, workStatusID, " +
                "Status, UpdateTime, CreateTime, will1, will2) " +
                "VALUES ('lisi','李四','5101 01 023',14,7,3," +
                "'1976-12-13',5,'74591234','0755212566','工作时间不准做',3,0," +
                "CURRENT_TIMESTAMP,'2006-11-25 22:20:54',NULL,'人民');";

        String delete1="delete from person_main where 1=1;";

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
        persondao1=DaoFactory.createPersonDao();
        persondao2=DaoFactory.createPersonDao();

    }

    public void tearDown(){
        persondao1=null;
        persondao2=null;
    }

    public void testGetDetailbyPID() throws SQLException {
        Person person;

        String namespell[]={"zhangsan","lisi"};
        String personName[]={"张三","李四"};
        String workID[]={"5107 03 020","5101 01 023"};
        int inspector[]={13,14};
        short persontypeid[]={3,7};
        short positionid[]={6,3};
        String birthDay[]={"1982-01-18","1976-12-13"};
        short sexid[]={1,5};
        String phone1[]={"13801381380","74591234"};
        String phone2[]={"08162229969","0755212566"};
        String memo[]={"fdsfdasfdsfdsf","工作时间不准做"};
        short workStatusid[]={2,3};
        String will1[]={"中国",null};
        String will2[]={null,"人民"};

        for (int i=0;i<2;i++){
            String search="select * from person_main where namespell='"+namespell[i]+"' and personName='"+personName[i]+"' and status=0";

            ResultSet rs=st.executeQuery(search);

            if(rs.next()){
                int personid=rs.getInt(1);

                person=persondao1.getDetail(personid);

                assertEquals(namespell[i],person.getNameSpell());
                assertEquals(personName[i],person.getPersonName());
                assertEquals(workID[i],person.getWorkID());
                assertEquals(inspector[i],person.getFk_presidentID());
                assertEquals(persontypeid[i],person.getPersonTypeID());
                assertEquals(positionid[i],person.getPositionID());
                assertEquals(birthDay[i],person.getBirthday());
                assertEquals(sexid[i],person.getSexID());
                assertEquals(phone1[i],person.getPhone1());
                assertEquals(phone2[i],person.getPhone2());
                assertEquals(memo[i],person.getMemo());
                assertEquals(workStatusid[i],person.getWorkStatusID());
                assertEquals(will1[i],person.getWill1());
                assertEquals(will2[i],person.getWill2());

            }
        }
    }

    public void testCreate() throws SQLException {
        // 删除person表中所有数据
        String delete="delete from person_main";
        st.execute(delete);

        // 准备2套测试数据
        Person person[]=new Person[2];
        person[0]=new Person();
        person[1]=new Person();

        String namespell[]={"zhangsan","lisi"};
        String personName[]={"张三","李四"};
        String workID[]={"5107 03 020","5101 01 023"};
        int inspector[]={13,14};
        short persontypeid[]={3,7};
        short positionid[]={6,3};
        String birthDay[]={"1982-01-18","1976-12-13"};
        short sexid[]={1,5};
        String phone1[]={"13801381380","74591234"};
        String phone2[]={"08162229969","0755212566"};
        String memo[]={"fdsfdasfdsfdsf","工作时间不准做"};
        short workStatusid[]={2,3};
        String will1[]={"中国",null};
        String will2[]={null,"人民"};

        for(int i=0;i<2;i++){
            person[i].setNameSpell(namespell[i]);
            person[i].setPersonName(personName[i]);
            person[i].setWorkID(workID[i]);
            person[i].setFk_presidentID(inspector[i]);
            person[i].setPersonTypeID(persontypeid[i]);
            person[i].setPositionID(positionid[i]);
            person[i].setBirthday(birthDay[i]);
            person[i].setSexID(sexid[i]);
            person[i].setPhone1(phone1[i]);
            person[i].setPhone2(phone2[i]);
            person[i].setMemo(memo[i]);
            person[i].setWorkStatusID(workStatusid[i]);
            person[i].setWill1(will1[i]);
            person[i].setWill2(will2[i]);
        }

        // 执行插入操作
        persondao1.create(person[0]);
        persondao2.create(person[1]);

        // 数据对比
        for (int i=0;i<2;i++){
            String search="select * from person_main where namespell='"+namespell[i]+"' and personName='"+personName[i]+"' and status=0";

            ResultSet rs=st.executeQuery(search);

            if(rs.next()){
                assertEquals(namespell[i],rs.getString(2));
                assertEquals(personName[i],rs.getString(3));
                assertEquals(workID[i],rs.getString(4));
                assertEquals(inspector[i],rs.getInt(5));
                assertEquals(persontypeid[i],rs.getShort(6));
                assertEquals(positionid[i],rs.getShort(7));
                assertEquals(birthDay[i],rs.getString(8));
                assertEquals(sexid[i],rs.getShort(9));
                assertEquals(phone1[i],rs.getString(10));
                assertEquals(phone2[i],rs.getString(11));
                assertEquals(memo[i],rs.getString(12));
                assertEquals(workStatusid[i],rs.getShort(13));
                assertEquals(will1[i],rs.getString(17));
                assertEquals(will2[i],rs.getString(18));

            }
        }

    }

    public void testUpdate() throws SQLException {
        // 准备2套测试数据
        Person person[]=new Person[2];
        person[0]=new Person();
        person[1]=new Person();

        int personid[]=new int[2];
        String namespell[]={"wangwu","lufeng"};
        String personName[]={"王五","吕酆"};
        String workID[]={"5101 04 030","5108 02 002"};
        int inspector[]={14,13};
        short persontypeid[]={-1,3};
        short positionid[]={2,0};
        String birthDay[]={"1984-11-20","1978-02-03"};
        short sexid[]={0,1};
        String phone1[]={"7755","139-139-1111"};
        String phone2[]={"(0816)230-1922","001-111-1423"};
        String memo[]={null,"工作测试内容<br>"};
        short workStatusid[]={0,-1};
        String will1[]={null,"中华人民共和国"};
        String will2[]={"毛泽东",null};

        for(int i=0;i<2;i++){
            person[i].setNameSpell(namespell[i]);
            person[i].setPersonName(personName[i]);
            person[i].setWorkID(workID[i]);
            person[i].setFk_presidentID(inspector[i]);
            person[i].setPersonTypeID(persontypeid[i]);
            person[i].setPositionID(positionid[i]);
            person[i].setBirthday(birthDay[i]);
            person[i].setSexID(sexid[i]);
            person[i].setPhone1(phone1[i]);
            person[i].setPhone2(phone2[i]);
            person[i].setMemo(memo[i]);
            person[i].setWorkStatusID(workStatusid[i]);
            person[i].setWill1(will1[i]);
            person[i].setWill2(will2[i]);
        }

        //获取personid
        for (int i=0;i<2;i++){
            String search="select * from person_main where namespell='"+namespell[i]+"' and personName='"+personName[i]+"' and status=0";

            ResultSet rs=st.executeQuery(search);

            if(rs.next()){
                personid[i]=rs.getInt(1);

            }
        }

        // 执行插入操作
        persondao1.update(person[0]);
        persondao2.update(person[1]);

        // 数据对比
        for (int i=0;i<2;i++){
            String search="select * from person_main where namespell='"+namespell[i]+"' and personName='"+personName[i]+"' and status=0";

            ResultSet rs=st.executeQuery(search);

            if(rs.next()){

                assertEquals(personid[i],rs.getInt(1));
                assertEquals(namespell[i],rs.getString(2));
                assertEquals(personName[i],rs.getString(3));
                assertEquals(workID[i],rs.getString(4));
                assertEquals(inspector[i],rs.getInt(5));
                assertEquals(persontypeid[i],rs.getShort(6));
                assertEquals(positionid[i],rs.getShort(7));
                assertEquals(birthDay[i],rs.getString(8));
                assertEquals(sexid[i],rs.getShort(9));
                assertEquals(phone1[i],rs.getString(10));
                assertEquals(phone2[i],rs.getString(11));
                assertEquals(memo[i],rs.getString(12));
                assertEquals(workStatusid[i],rs.getShort(13));
                assertEquals(will1[i],rs.getString(17));
                assertEquals(will2[i],rs.getString(18));

            }
        }
    }

    public void testGetList(){
        // 准备2套测试数据
        Person person[];

        String namespell[]={"zhangsan","lisi"};
        String personName[]={"张三","李四"};
        String workID[]={"5107 03 020","5101 01 023"};
        int inspector[]={13,14};
        short persontypeid[]={3,7};
        short positionid[]={6,3};
        String birthDay[]={"1982-01-18","1976-12-13"};
        short sexid[]={1,5};
        String phone1[]={"13801381380","74591234"};
        String phone2[]={"08162229969","0755212566"};
        String memo[]={"fdsfdasfdsfdsf","工作时间不准做"};
        short workStatusid[]={2,3};
        String will1[]={"中国",null};
        String will2[]={null,"人民"};

        // 执行查询
        List list=persondao1.getListAll();

        assertEquals(2,list.size());

        person=new Person[2];

        // 数据对比
        for (int i=0;i<2;i++){
            person[i]=(Person)list.get(i);
            assertEquals(namespell[i],person[i].getNameSpell());
            assertEquals(personName[i],person[i].getPersonName());
            assertEquals(workID[i],person[i].getWorkID());
            assertEquals(inspector[i],person[i].getFk_presidentID());
            assertEquals(persontypeid[i],person[i].getPersonTypeID());
            assertEquals(positionid[i],person[i].getPositionID());
            assertEquals(birthDay[i],person[i].getBirthday());
            assertEquals(sexid[i],person[i].getSexID());
            assertEquals(phone1[i],person[i].getPhone1());
            assertEquals(phone2[i],person[i].getPhone2());
            assertEquals(memo[i],person[i].getMemo());
            assertEquals(workStatusid[i],person[i].getWorkStatusID());
            assertEquals(will1[i],person[i].getWill1());
            assertEquals(will2[i],person[i].getWill2());
        }
    }

    public void testDelete() throws SQLException {
        String namespell[]={"zhangsan","lisi"};
        String personName[]={"张三","李四"};

        int personid[]=new int[2];

        //获取personid
        for (int i=0;i<2;i++){
            String search="select * from person_main where namespell='"+namespell[i]+"' and personName='"+personName[i]+"' and status=0";

            ResultSet rs=st.executeQuery(search);

            if(rs.next()){
                personid[i]=rs.getInt(1);

            }
        }

        persondao1.delete(personid[0]);
        persondao2.delete(personid[1]);

        for (int i=0;i<2;i++){
            String search="select * from person_main where namespell='"+namespell[i]+"' and personName='"+personName[i]+"' and status=0";
            ResultSet rs=st.executeQuery(search);

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


    public static void main(String[] args) {
        junit.textui.TestRunner.run(PersonDaoTest.class);
    }
}
