package com.source11.worknotes.dao;

import junit.framework.TestCase;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.List;

import com.source11.worknotes.domain.Worknote;
import com.source11.worknotes.common.DAORuntimeException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2007-5-29
 * Time: 15:35:03
 * To change this template use File | Settings | File Templates.
 */
public class WorknotesDaoTest extends TestCase{
    WorknoteDao worknotedao1;
    WorknoteDao worknotedao2;
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
        String insert0= "INSERT INTO worknote_main (FK_personID, workstateID, todayAim, " +
                "outPlan, helping, tomorrowPlan, workDate, resultID, FK_inspectorPID, " +
                "comment, Status, UpdateTime, CreateTime, will1, will2) " +
                "VALUES (1000,5,'����ļƻ�','�ƻ�������','���ڵ�����','����ļƻ�'," +
                "'2007-05-29',0,100,'����ͨ��',0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "'�й�',null)";

        String insert1= "INSERT INTO worknote_main (FK_personID, workstateID, todayAim, " +
                "outPlan, helping, tomorrowPlan, workDate, resultID, FK_inspectorPID, " +
                "comment, Status, UpdateTime, CreateTime, will1, will2) " +
                "VALUES (2000,0,'1.�����Ѿ����','û��','������','����'," +
                "'2005-01-31',2,200,'������ͨ��',0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "null,'����')";

        String delete1="delete from worknote_main ";

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
        worknotedao1=DaoFactory.createWorknoteDao();
        worknotedao2=DaoFactory.createWorknoteDao();

    }

    public void tearDown(){
        worknotedao1=null;
        worknotedao2=null;
    }

    public void testGetAll(){
        // ��������׼��
        int personID[]={1000,2000};
        short workstatus[]={5,0};
        String todayAim[]={"����ļƻ�","1.�����Ѿ����"};
        String outPlan[]={"�ƻ�������","û��"};
        String helping[]={"���ڵ�����","������"};
        String tomorrowPlan[]={"����ļƻ�","����"};
        String workDate[]={"2007-05-29","2005-01-31"};
        short resultID[]={0,2};
        int inspectorID[]={100,200};
        String comment[]={"����ͨ��","������ͨ��"};
        String will1[]={"�й�",null};
        String will2[]={null,"����"};

        //��ȡ�����Ե�����
        List list=worknotedao1.getList();
        assertEquals(2,list.size());
        // ��ѯ�����ݱȶ�
        for (int i=0;i<2;i++){
            Worknote worknote=(Worknote)list.get(i);
            assertEquals(personID[i],worknote.getFk_personID());
            assertEquals(workstatus[i],worknote.getWorkstateID());
            assertEquals(todayAim[i],worknote.getTodayAim());
            assertEquals(outPlan[i],worknote.getOutPlan());
            assertEquals(helping[i],worknote.getHelping());
            assertEquals(tomorrowPlan[i],worknote.getTomorrowPlan());
            assertEquals(workDate[i],worknote.getWorkDate());
            assertEquals(resultID[i],worknote.getResultID());
            assertEquals(inspectorID[i],worknote.getFK_inspectorPID());
            assertEquals(comment[i],worknote.getComment());
            assertEquals(will1[i],worknote.getWill1());
            assertEquals(will2[i],worknote.getWill2());

        }

    }

    public void testGetListByPID$DATA() throws SQLException {
        String insert3= "INSERT INTO worknote_main (FK_personID, workstateID, todayAim, " +
                "outPlan, helping, tomorrowPlan, workDate, resultID, FK_inspectorPID, " +
                "comment, Status, UpdateTime, CreateTime, will1, will2) " +
                "V" +
                "ALUES (1000,0,'1.�����Ѿ����','û��','������','����'," +
                "'2007-05-30',2,200,'������ͨ��',0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "null,'����')";
        String insert4= "INSERT INTO worknote_main (FK_personID, workstateID, todayAim, " +
                "outPlan, helping, tomorrowPlan, workDate, resultID, FK_inspectorPID, " +
                "comment, Status, UpdateTime, CreateTime, will1, will2) " +
                "VALUES (1000,0,'1.�����Ѿ����','û��','������','����'," +
                "'2007-05-31',2,200,'������ͨ��',0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "null,'����')";
        String insert5= "INSERT INTO worknote_main (FK_personID, workstateID, todayAim, " +
                "outPlan, helping, tomorrowPlan, workDate, resultID, FK_inspectorPID, " +
                "comment, Status, UpdateTime, CreateTime, will1, will2) " +
                "VALUES (1000,0,'1.�����Ѿ����','û��','������','����'," +
                "'2007-05-28',2,200,'������ͨ��',0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "null,'����')";
        st.execute(insert3);
        st.execute(insert4);
        st.execute(insert5);

        // ��������׼��
        short workstatus[]={0,5};
        String todayAim[]={"1.�����Ѿ����","����ļƻ�"};
        String outPlan[]={"û��","�ƻ�������"};
        String helping[]={"������","���ڵ�����"};
        String tomorrowPlan[]={"����","����ļƻ�"};
        String workDate[]={"2007-05-30","2007-05-29"};
        short resultID[]={2,0};
        int inspectorID[]={200,100};
        String comment[]={"������ͨ��","����ͨ��"};
        String will1[]={null,"�й�"};
        String will2[]={"����",null};

        //��ȡ�����Ե�����
        List list=worknotedao1.getListByPID$DATE(1000,"2007-05-29","2007-05-30");

        assertEquals(2,list.size());
        // ��ѯ�����ݱȶ�
        for (int i=0;i<2;i++){
            Worknote worknote=(Worknote)list.get(i);
            assertEquals(workstatus[i],worknote.getWorkstateID());
            assertEquals(todayAim[i],worknote.getTodayAim());
            assertEquals(outPlan[i],worknote.getOutPlan());
            assertEquals(helping[i],worknote.getHelping());
            assertEquals(tomorrowPlan[i],worknote.getTomorrowPlan());
            assertEquals(workDate[i],worknote.getWorkDate());
            assertEquals(resultID[i],worknote.getResultID());
            assertEquals(inspectorID[i],worknote.getFK_inspectorPID());
            assertEquals(comment[i],worknote.getComment());
            assertEquals(will1[i],worknote.getWill1());
            assertEquals(will2[i],worknote.getWill2());

        }
    }

    public void testGetDetailByPID$DATE(){
        // ��������׼��
        int personID[]={1000,2000};
        short workstatus[]={5,0};
        String todayAim[]={"����ļƻ�","1.�����Ѿ����"};
        String outPlan[]={"�ƻ�������","û��"};
        String helping[]={"���ڵ�����","������"};
        String tomorrowPlan[]={"����ļƻ�","����"};
        String workDate[]={"2007-05-29","2005-01-31"};
        short resultID[]={0,2};
        int inspectorID[]={100,200};
        String comment[]={"����ͨ��","������ͨ��"};
        String will1[]={"�й�",null};
        String will2[]={null,"����"};

        Worknote worknote[]=new Worknote[2];
        worknote[0]=worknotedao1.getDetailByPID$DATE(personID[0],workDate[0]);
        worknote[1]=worknotedao2.getDetailByPID$DATE(personID[1],workDate[1]);

        for (int i=0;i<2;i++){
            assertEquals(personID[i],worknote[i].getFk_personID());
            assertEquals(workstatus[i],worknote[i].getWorkstateID());
            assertEquals(todayAim[i],worknote[i].getTodayAim());
            assertEquals(outPlan[i],worknote[i].getOutPlan());
            assertEquals(helping[i],worknote[i].getHelping());
            assertEquals(tomorrowPlan[i],worknote[i].getTomorrowPlan());
            assertEquals(workDate[i],worknote[i].getWorkDate());
            assertEquals(resultID[i],worknote[i].getResultID());
            assertEquals(inspectorID[i],worknote[i].getFK_inspectorPID());
            assertEquals(comment[i],worknote[i].getComment());
            assertEquals(will1[i],worknote[i].getWill1());
            assertEquals(will2[i],worknote[i].getWill2());

        }


    }

    public void testGetDetailByWID() throws SQLException {
        // ��������׼��
        long worknoteID[]={0,1};
        int personID[]={1000,2000};
        short workstatus[]={5,0};
        String todayAim[]={"����ļƻ�","1.�����Ѿ����"};
        String outPlan[]={"�ƻ�������","û��"};
        String helping[]={"���ڵ�����","������"};
        String tomorrowPlan[]={"����ļƻ�","����"};
        String workDate[]={"2007-05-29","2005-01-31"};
        short resultID[]={0,2};
        int inspectorID[]={100,200};
        String comment[]={"����ͨ��","������ͨ��"};
        String will1[]={"�й�",null};
        String will2[]={null,"����"};

        for (int i=0;i<2;i++){
            String search="select * from worknote_main where FK_personID='"+personID[i]+"' and workDate='"+workDate[i]+"' and status=0";
            ResultSet rs=st.executeQuery(search);
            if(rs.next()){
                worknoteID[i]=rs.getLong(1);
            }
        }

        Worknote worknote[]=new Worknote[2];
        worknote[0]=worknotedao1.getDetailByWID(worknoteID[0]);
        worknote[1]=worknotedao2.getDetailByWID(worknoteID[1]);

        for (int i=0;i<2;i++){
            assertEquals(personID[i],worknote[i].getFk_personID());
            assertEquals(workstatus[i],worknote[i].getWorkstateID());
            assertEquals(todayAim[i],worknote[i].getTodayAim());
            assertEquals(outPlan[i],worknote[i].getOutPlan());
            assertEquals(helping[i],worknote[i].getHelping());
            assertEquals(tomorrowPlan[i],worknote[i].getTomorrowPlan());
            assertEquals(workDate[i],worknote[i].getWorkDate());
            assertEquals(resultID[i],worknote[i].getResultID());
            assertEquals(inspectorID[i],worknote[i].getFK_inspectorPID());
            assertEquals(comment[i],worknote[i].getComment());
            assertEquals(will1[i],worknote[i].getWill1());
            assertEquals(will2[i],worknote[i].getWill2());

        }
    }

    public void testCreate() throws SQLException {
        // ��������׼��
        String deleteSql="delete from worknote_main";
        st.execute(deleteSql);

        int personID[]={100,200};
        short workstatus[]={1,2};
        String todayAim[]={"�ƻ�","���"};
        String outPlan[]={"outs","not"};
        String helping[]={"����","��"};
        String tomorrowPlan[]={"����","�����ƻ�"};
        String workDate[]={"2006-04-28","2007-12-31"};
        short resultID[]={-1,0};
        int inspectorID[]={101,201};
        String comment[]={"����","����"};
        String will1[]={null,"����"};
        String will2[]={"�й�",null};

        Worknote worknote[]=new Worknote[2];

        for(int i=0;i<2;i++){
            worknote[i]=new Worknote();
            worknote[i].setFk_personID(personID[i]);
            worknote[i].setWorkstateID(workstatus[i]);
            worknote[i].setTodayAim(todayAim[i]);
            worknote[i].setOutPlan(outPlan[i]);
            worknote[i].setHelping(helping[i]);
            worknote[i].setTomorrowPlan(tomorrowPlan[i]);
            worknote[i].setWorkDate(workDate[i]);
            worknote[i].setResultID(resultID[i]);
            worknote[i].setFK_inspectorPID(inspectorID[i]);
            worknote[i].setComment(comment[i]);
            worknote[i].setWill1(will1[i]);
            worknote[i].setWill2(will2[i]);
        }

        worknotedao1.create(worknote[0]);
        worknotedao2.create(worknote[1]);

        for (int i=0;i<2;i++){
            String search="select * from worknote_main where FK_personID='"+personID[i]+"' and workDate='"+workDate[i]+"' and status=0";
            ResultSet rs=st.executeQuery(search);
            try {
                if (rs.next()){
                    assertEquals(personID[i],rs.getInt(2));
                    assertEquals(workstatus[i],rs.getShort(3));
                    assertEquals(todayAim[i],rs.getString(4));
                    assertEquals(outPlan[i],rs.getString(5));
                    assertEquals(helping[i],rs.getString(6));
                    assertEquals(tomorrowPlan[i],rs.getString(7));
                    assertEquals(workDate[i],rs.getString(8));
                    assertEquals(resultID[i],rs.getShort(9));
                    assertEquals(inspectorID[i],rs.getShort(10));
                    assertEquals(comment[i],rs.getString(11));
                    assertEquals(will1[i],rs.getString(15));
                    assertEquals(will2[i],rs.getString(16));
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DAORuntimeException("database check error !");
            }
        }

    }

    public void testUpdate() throws SQLException {
        // ��������׼��
        long worknoteID[]={0,1};
        int personID[]={1000,2000};
        short workstatus[]={1,2};
        String todayAim[]={"�ƻ�","���"};
        String outPlan[]={"outs","not"};
        String helping[]={"����","��"};
        String tomorrowPlan[]={"����","�����ƻ�"};
        String workDate[]={"2007-05-29","2005-01-31"};
        short resultID[]={-1,0};
        int inspectorID[]={101,201};
        String comment[]={"����","����"};
        String will1[]={null,"����"};
        String will2[]={"�й�",null};
    for (int i=0;i<2;i++){
            String search="select * from worknote_main where FK_personID='"+personID[i]+"' and workDate='"+workDate[i]+"' and status=0";
            ResultSet rs=st.executeQuery(search);
            if(rs.next()){
                worknoteID[i]=rs.getLong(1);
            }
        }

        Worknote worknote[]=new Worknote[2];

        for(int i=0;i<2;i++){
            worknote[i]=new Worknote();
            worknote[i].setPk_worknoteID(worknoteID[i]);
            worknote[i].setFk_personID(personID[i]);
            worknote[i].setWorkstateID(workstatus[i]);
            worknote[i].setTodayAim(todayAim[i]);
            worknote[i].setOutPlan(outPlan[i]);
            worknote[i].setHelping(helping[i]);
            worknote[i].setTomorrowPlan(tomorrowPlan[i]);
            worknote[i].setWorkDate(workDate[i]);
            worknote[i].setResultID(resultID[i]);
            worknote[i].setFK_inspectorPID(inspectorID[i]);
            worknote[i].setComment(comment[i]);
            worknote[i].setWill1(will1[i]);
            worknote[i].setWill2(will2[i]);
        }

        worknotedao1.update(worknote[0]);
        worknotedao2.update(worknote[1]);

        for (int i=0;i<2;i++){
            String search="select * from worknote_main where FK_personID='"+personID[i]+"' and workDate='"+workDate[i]+"' and status=0";
            ResultSet rs=st.executeQuery(search);
            try {
                if (rs.next()){
                    assertEquals(personID[i],rs.getInt(2));
                    assertEquals(workstatus[i],rs.getShort(3));
                    assertEquals(todayAim[i],rs.getString(4));
                    assertEquals(outPlan[i],rs.getString(5));
                    assertEquals(helping[i],rs.getString(6));
                    assertEquals(tomorrowPlan[i],rs.getString(7));
                    assertEquals(workDate[i],rs.getString(8));
                    assertEquals(resultID[i],rs.getShort(9));
                    assertEquals(inspectorID[i],rs.getShort(10));
                    assertEquals(comment[i],rs.getString(11));
                    assertEquals(will1[i],rs.getString(15));
                    assertEquals(will2[i],rs.getString(16));
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DAORuntimeException("database check error !");
            }
        }

    }

    public void testDelete() throws SQLException {
        int personID[]={1000,2000};
        String workDate[]={"2007-05-29","2005-01-31"};
        long worknoteid[]=new long[2];

        Worknote worknote[]=new Worknote[2];
        worknote[0]=new Worknote();
        worknote[1]=new Worknote();

        worknote[0].setFk_personID(personID[0]);
        worknote[1].setFk_personID(personID[1]);
        worknote[0].setWorkDate(workDate[0]);
        worknote[1].setWorkDate(workDate[1]);

        for (int i=0;i<2;i++){
            String search="select * from worknote_main where FK_personID='"+personID[i]+"' and workDate='"+workDate[i]+"' and status=0";
            ResultSet rs=st.executeQuery(search);
            if(rs.next()){
                worknoteid[i]=rs.getLong(1);
            }
        }

        worknotedao1.delete(worknoteid[0]);
        worknotedao2.delete(worknoteid[1]);

        for (int i=0;i<2;i++){
            String search="select * from worknote_main where FK_personID='"+personID[i]+"' and workDate='"+workDate[i]+"' and status=0";
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
        junit.textui.TestRunner.run(WorknotesDaoTest.class);
    }

}
