package com.source11.worknotes.business;

import com.source11.worknotes.dao.WorknoteDao;
import com.source11.worknotes.dao.DaoFactory;
import com.source11.worknotes.domain.Worknote;
import com.source11.worknotes.common.Source11Common;
import com.source11.worknotes.util.UtilCommon;

import java.util.List;
import java.util.Iterator;
import java.sql.Date;

/**
 * 针对Account的业务代理类。
 * 主要功能是：
 * 1. 进行业务逻辑的处理
 * 2. 对持久层获取的数据进行数据过滤。
 */
public class WorknoteBD implements Source11Common{
    // 业务使用的常量定义
    private final static short RESULT_PASS=0;
    private final static int PERSONID_SEC_MIN=-1;
    private final static short RESULT_SEC_MIN=-10;
    /**
     * 获得一个AccountDao的实现体，用来进行DAO层访问。
     */
    private static WorknoteDao worknotedao=DaoFactory.createWorknoteDao();

    /**
     * 查询指定人员的所有处理没有结束的工作日志。
     * @param personid 指定的内部人员编号。
     * @return 所有符合要求的worknote列表。
     */
    public static List getNotCloseListByReporterPID(int personid){
        List list = worknotedao.getListByPID(personid);
        // 剔除状态是“合格”的所有记录。
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            if (((Worknote)iterator.next()).getResultID() == RESULT_PASS){
                iterator.remove();
            }
        }
        return list;

    }

    /**
     * 查询由指定人员审核的，所有处理状态为未审核的工作日志。
     * @param inspectorID  指定的评审人人员内部编号。
     * @return  所有符合要求的worknote列表。
     */
    public static List getNotCloseListByInspectorPID(int inspectorID){
        List list = worknotedao.getList();
        // 剔除状态是“合格”或检查员不是inspectorID 的所有记录。
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Worknote worknote=((Worknote)iterator.next());
            if (worknote.getResultID()==RESULT_PASS || worknote.getFK_inspectorPID()!=inspectorID){
                iterator.remove();
            }
        }
        return list;

    }

    /**
     * 查询指定人员在指定时间阶段的全部工作日志。
     * @param personid  指定人员的内部编号。
     * @param startdate  查询起始日期（格式：YYYY-MM-dd）
     * @param enddate    查询结束日期（格式：YYYY-MM-dd）
     * @return   符合要求的工作日志列表
     */
    public static List getListByPID$DATE(int personid,String startdate,String enddate){

        if (personid<PERSONID_SEC_MIN){
            return worknotedao.getListByDate(startdate,enddate);

        }else{
            return worknotedao.getListByPID$DATE(personid,startdate,enddate);

        }

    }

    /**
     * 根据指定的工作日志内部流水号，获得指定的工作日志详细信息。
     * @param worknoteid 指定的内部流水号。
     * @return   工作日志详细信息。
     */
    public static Worknote getWorknoteByWID(long worknoteid){
        return worknotedao.getDetailByWID(worknoteid);

    }

    /**
     * 根据人员编号、日志处理状态、日期范围，查询所有符合要求的日志信息。
     * @param personid  工作人员ID，如果小于零，就代表所有人员。
     * @param resultid   日志处理状态、如果小于-9,就代表全部状态。
     * @param startdate  查询起始日期（格式：YYYY-MM-dd）
     * @param enddate    查询结束日期（格式：YYYY-MM-dd）
     * @return  符合要求的日志列表
     */
    public static List getListByPID$ResultID(int personid,short resultid,String startdate,String enddate){
        List list=null;
        // 如果 PID 小于零，就取所有人的数据，否则取指定人员的数据。
        if (personid<=PERSONID_SEC_MIN)  list=worknotedao.getListByDate(startdate,enddate);
        else list=worknotedao.getListByPID$DATE(personid,startdate,enddate);
        // 如果 评审状态小于-10,就取所有的评审状态，否则取指定的评审状态。
        if (resultid<=RESULT_SEC_MIN) {
            return list;
        }else{
            // 剔除队列中所有状态不符的信息。
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                if (((Worknote)iterator.next()).getResultID()!=resultid){
                    iterator.remove();
                }
            }
            return list;
        }
    }

    /**
     * 创建一条工作日志记录。
     * 注1: 如果工作日期比当前日期晚，不予保存。
     * 注2: 如果存在符合工作日期的记录，不予保存。
     * @param worknote
     */
    public static void createWorknote(Worknote worknote){

        worknote.setWorkDate(UtilCommon.getValidDate(worknote.getWorkDate()));

        // 如果工作日期比当前日期晚，不予录入。
        if (worknote.getWorkDate()==null||Date.valueOf(worknote.getWorkDate()).after(new java.util.Date())){
            return ;
        }
        // 如果工作日期非法，不予录入。
        String date1=Date.valueOf(worknote.getWorkDate()).toString();
        if (!Date.valueOf(worknote.getWorkDate()).toString().equals(worknote.getWorkDate())){
            return ;
        }

        // 如果工作日期不存在，可以添加。
        if (worknotedao.getDetailByPID$DATE(worknote.getFk_personID(),worknote.getWorkDate())==null){
            worknotedao.create(worknote);
        }

    }

    /**
     * 更新指定的工作日志记录。
     * @param worknote 待修改的工作日志。
     */
    public static void updateWorknote(Worknote worknote){
        worknotedao.update(worknote);
    }


}
