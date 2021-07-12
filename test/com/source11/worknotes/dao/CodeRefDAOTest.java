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
        //初始化 code_ref表

        String delete="delete from code_ref where 1=1";
        String insert1="INSERT INTO `code_ref` (`CodeType`, `CodeID`, `CodeShow`, `ShowNative`, `memo`, `Status`) VALUES \n" +
                "  (1100,0,'代码开发','coding','代码开发',0)";
        String insert2="INSERT INTO `code_ref` (`CodeType`, `CodeID`, `CodeShow`, `ShowNative`, `memo`, `Status`) VALUES \n" +
                "  (1100,1,'需求分析','request','需求分析',0);";
        String insert3="INSERT INTO `code_ref` (`CodeType`, `CodeID`, `CodeShow`, `ShowNative`, `memo`, `Status`) VALUES \n" +
                "  (1100,2,'系统设计','design','系统设计',0);";
        try {
            st.execute(delete);
            st.execute(insert1);
            st.execute(insert2);
            st.execute(insert3);

        } catch (SQLException ex) {
            ex.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //初始化 CodeRefDao测试对象
        codeRefDao1=DaoFactory.createCodeRefDao();
        codeRefDao2=DaoFactory.createCodeRefDao();
    }

    public void tearDown(){
        //清除 变更的数据库数据

        //清除 CodeRefDao测试对象
        codeRefDao1=null;
        codeRefDao2=null;
    }

    public void testGetCodeRef(){
        //获取指定的数据对象
        CodeRef coderef1=codeRefDao1.getCodeRef((short)1100,(short)0);
        CodeRef coderef2=codeRefDao1.getCodeRef((short)1100,(short)2);

        //进行数据对比   coderef1
        assertEquals(1100,coderef1.getCodeType());
        assertEquals(0,coderef1.getCodeId());
        assertEquals("代码开发",coderef1.getCodeShow());
        assertEquals("coding",coderef1.getShowNative());
        assertEquals("代码开发",coderef1.getMemo());

        //进行数据对比   coderef2
        assertEquals(1100,coderef2.getCodeType());
        assertEquals(2,coderef2.getCodeId());
        assertEquals("系统设计",coderef2.getCodeShow());
        assertEquals("design",coderef2.getShowNative());
        assertEquals("系统设计",coderef2.getMemo());


    }

    public void testGetListAll(){
        //测试数据准备
        short codeType[]={1100,1100,1100};
        short codeId[]={0,1,2};
        String codeShow[]={"代码开发","需求分析","系统设计"};
        String showNative[]={"coding","request","design"};
        String memo[]={"代码开发","需求分析","系统设计"};
        CodeRef coderef;

        //获取待测试的数据
        List list=codeRefDao1.getListAll();
        int count=list.size();

        //测试实施
        for (int i=0;i<count;i++){
            coderef=(CodeRef)list.get(i);
            //进行数据对比   coderef1
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
