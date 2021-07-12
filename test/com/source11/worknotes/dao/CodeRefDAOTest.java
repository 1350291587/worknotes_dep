package com.source11.worknotes.dao;

import junit.framework.TestCase;
import com.source11.worknotes.domain.CodeRef;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2007-1-19
 * Time: 11:15:05
 * To change this template use File | Settings | File Templates.
 */
public class CodeRefDAOTest extends TestCase{
    CodeRefDao codeRefDao1;
    CodeRefDao codeRefDao2;

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
        //��ʼ�� code_ref��

        String delete="delete from code_ref where 1=1";
        String insert1="INSERT INTO `code_ref` (`CodeType`, `CodeID`, `CodeShow`, `ShowNative`, `memo`, `Status`) VALUES \n" +
                "  (1100,0,'���뿪��','coding','���뿪��',0)";
        String insert2="INSERT INTO `code_ref` (`CodeType`, `CodeID`, `CodeShow`, `ShowNative`, `memo`, `Status`) VALUES \n" +
                "  (1100,1,'�������','request','�������',0);";
        String insert3="INSERT INTO `code_ref` (`CodeType`, `CodeID`, `CodeShow`, `ShowNative`, `memo`, `Status`) VALUES \n" +
                "  (1100,2,'ϵͳ���','design','ϵͳ���',0);";
        try {
            st.execute(delete);
            st.execute(insert1);
            st.execute(insert2);
            st.execute(insert3);

        } catch (SQLException ex) {
            ex.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //��ʼ�� CodeRefDao���Զ���
        codeRefDao1=DaoFactory.createCodeRefDao();
        codeRefDao2=DaoFactory.createCodeRefDao();
    }

    public void tearDown(){
        //��� ��������ݿ�����

        //��� CodeRefDao���Զ���
        codeRefDao1=null;
        codeRefDao2=null;
    }

    public void testGetCodeRef(){
        //��ȡָ�������ݶ���
        CodeRef coderef1=codeRefDao1.getCodeRef((short)1100,(short)0);
        CodeRef coderef2=codeRefDao1.getCodeRef((short)1100,(short)2);

        //�������ݶԱ�   coderef1
        assertEquals(1100,coderef1.getCodeType());
        assertEquals(0,coderef1.getCodeId());
        assertEquals("���뿪��",coderef1.getCodeShow());
        assertEquals("coding",coderef1.getShowNative());
        assertEquals("���뿪��",coderef1.getMemo());

        //�������ݶԱ�   coderef2
        assertEquals(1100,coderef2.getCodeType());
        assertEquals(2,coderef2.getCodeId());
        assertEquals("ϵͳ���",coderef2.getCodeShow());
        assertEquals("design",coderef2.getShowNative());
        assertEquals("ϵͳ���",coderef2.getMemo());


    }

    public void testGetListAll(){
        //��������׼��
        short codeType[]={1100,1100,1100};
        short codeId[]={0,1,2};
        String codeShow[]={"���뿪��","�������","ϵͳ���"};
        String showNative[]={"coding","request","design"};
        String memo[]={"���뿪��","�������","ϵͳ���"};
        CodeRef coderef;

        //��ȡ�����Ե�����
        List list=codeRefDao1.getListAll();
        int count=list.size();

        //����ʵʩ
        for (int i=0;i<count;i++){
            coderef=(CodeRef)list.get(i);
            //�������ݶԱ�   coderef1
            assertEquals(codeType[i],coderef.getCodeType());
            assertEquals(codeId[i],coderef.getCodeId());
            assertEquals(codeShow[i],coderef.getCodeShow());
            assertEquals(showNative[i],coderef.getShowNative());
            assertEquals(memo[i],coderef.getMemo());
        }


    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(CodeRefDAOTest.class);
    }

}
