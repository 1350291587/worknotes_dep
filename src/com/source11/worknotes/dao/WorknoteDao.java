package com.source11.worknotes.dao;

import com.source11.worknotes.domain.Worknote;
import java.util.List;

/**
 * ������־DAO
 */
public interface WorknoteDao {

    /**
     * ���ݵ�ǰ��Worknote ���������ݿ��д����־����ݡ�
     * @param worknote �����Worknote����vo��
     */
    public void create(Worknote worknote);

    /**
     * ���µ�ǰ�Ĺ�����־���ݡ�
     * @param worknote ָ����Worknote����
     */
    public void update(Worknote worknote);

     /**
      * ����ָ���ļ�¼wid,�����ݿ���ɾ��ָ���� Worknote����
      * @param worknoteid ��ɾ����Worknote��¼id
      */
    public void delete(long worknoteid);

     /**
      * ����ָ��id,�����ݿ���ȡ����ϸ��Ϣ
      * @param worknoteid ����ѯ��Worknote��¼id
      * @return ָ����Worknote����
      */
    public Worknote getDetailByWID(long worknoteid);

     /**
      * ������Ա��ź͹�������,�����ݿ���ȡ����ϸ��Ϣ
      * @param personid ����ѯ��Worknote��¼id
      * @param workdate ����ѯ�Ĺ�������
      * @return ָ����Worknote����
      */
    public Worknote getDetailByPID$DATE(int personid,String workdate);

     /**
      * ������Ա��ţ������ݿ���ȡ�����з���Ҫ���Worknote���ݡ�
      * @param personid ����ѯ����ԱID
      * @return ָ����Worknote������б�
      */
    public List getListByPID(int personid);

    /**
     * ���ݹ���ʱ��Σ������ݿ���ȡ�����з���Ҫ���Worknote���ݡ�
     * @param startDate ����ѯ��Worknote��¼startDate
     * @param endDate  ����ѯ��Worknote��¼endDate
     * @return ָ����Worknote������б�
     */
    public List getListByDate(String startDate,String endDate);

     /**
      * ������Ա��š�����ʱ��Σ������ݿ���ȡ�����з���Ҫ���Worknote���ݡ�
      * @param personid ����ѯ��Worknote��¼id
      * @param startDate ����ѯ��Worknote��¼startDate
      * @param endDate  ����ѯ��Worknote��¼endDate
      * @return ָ����Worknote������б�
      */
    public List getListByPID$DATE(int personid,String startDate,String endDate);

    /**
     * �����ݿ���ȡ�� ���е�Worknote���ݡ�
     * @return ȡ�õ�Worknote������б�
     */
    public List getList();
}
