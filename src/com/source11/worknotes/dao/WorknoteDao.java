package com.source11.worknotes.dao;

import com.source11.worknotes.domain.Worknote;
import java.util.List;

/**
 * 工作日志DAO
 */
public interface WorknoteDao {

    /**
     * 根据当前的Worknote 对象在数据库中创建持久数据。
     * @param worknote 传入的Worknote对象（vo）
     */
    public void create(Worknote worknote);

    /**
     * 更新当前的工作日志数据。
     * @param worknote 指定的Worknote对象
     */
    public void update(Worknote worknote);

     /**
      * 根据指定的记录wid,从数据库中删除指定的 Worknote对象
      * @param worknoteid 待删除的Worknote记录id
      */
    public void delete(long worknoteid);

     /**
      * 根据指定id,从数据库中取得详细信息
      * @param worknoteid 待查询的Worknote记录id
      * @return 指定的Worknote对象
      */
    public Worknote getDetailByWID(long worknoteid);

     /**
      * 根据人员编号和工作日期,从数据库中取得详细信息
      * @param personid 待查询的Worknote记录id
      * @param workdate 待查询的工作日期
      * @return 指定的Worknote对象
      */
    public Worknote getDetailByPID$DATE(int personid,String workdate);

     /**
      * 根据人员编号，从数据库中取得所有符合要求的Worknote数据。
      * @param personid 待查询的人员ID
      * @return 指定的Worknote对象的列表
      */
    public List getListByPID(int personid);

    /**
     * 根据工作时间段，从数据库中取得所有符合要求的Worknote数据。
     * @param startDate 待查询的Worknote记录startDate
     * @param endDate  待查询的Worknote记录endDate
     * @return 指定的Worknote对象的列表
     */
    public List getListByDate(String startDate,String endDate);

     /**
      * 根据人员编号、工作时间段，从数据库中取得所有符合要求的Worknote数据。
      * @param personid 代查询的Worknote记录id
      * @param startDate 待查询的Worknote记录startDate
      * @param endDate  待查询的Worknote记录endDate
      * @return 指定的Worknote对象的列表
      */
    public List getListByPID$DATE(int personid,String startDate,String endDate);

    /**
     * 从数据库中取得 所有的Worknote数据。
     * @return 取得的Worknote对象的列表。
     */
    public List getList();
}
