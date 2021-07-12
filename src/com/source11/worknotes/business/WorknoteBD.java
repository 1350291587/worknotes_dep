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
 * ���Account��ҵ������ࡣ
 * ��Ҫ�����ǣ�
 * 1. ����ҵ���߼��Ĵ���
 * 2. �Գ־ò��ȡ�����ݽ������ݹ��ˡ�
 */
public class WorknoteBD implements Source11Common{
    // ҵ��ʹ�õĳ�������
    private final static short RESULT_PASS=0;
    private final static int PERSONID_SEC_MIN=-1;
    private final static short RESULT_SEC_MIN=-10;
    /**
     * ���һ��AccountDao��ʵ���壬��������DAO����ʡ�
     */
    private static WorknoteDao worknotedao=DaoFactory.createWorknoteDao();

    /**
     * ��ѯָ����Ա�����д���û�н����Ĺ�����־��
     * @param personid ָ�����ڲ���Ա��š�
     * @return ���з���Ҫ���worknote�б�
     */
    public static List getNotCloseListByReporterPID(int personid){
        List list = worknotedao.getListByPID(personid);
        // �޳�״̬�ǡ��ϸ񡱵����м�¼��
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            if (((Worknote)iterator.next()).getResultID() == RESULT_PASS){
                iterator.remove();
            }
        }
        return list;

    }

    /**
     * ��ѯ��ָ����Ա��˵ģ����д���״̬Ϊδ��˵Ĺ�����־��
     * @param inspectorID  ָ������������Ա�ڲ���š�
     * @return  ���з���Ҫ���worknote�б�
     */
    public static List getNotCloseListByInspectorPID(int inspectorID){
        List list = worknotedao.getList();
        // �޳�״̬�ǡ��ϸ񡱻���Ա����inspectorID �����м�¼��
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Worknote worknote=((Worknote)iterator.next());
            if (worknote.getResultID()==RESULT_PASS || worknote.getFK_inspectorPID()!=inspectorID){
                iterator.remove();
            }
        }
        return list;

    }

    /**
     * ��ѯָ����Ա��ָ��ʱ��׶ε�ȫ��������־��
     * @param personid  ָ����Ա���ڲ���š�
     * @param startdate  ��ѯ��ʼ���ڣ���ʽ��YYYY-MM-dd��
     * @param enddate    ��ѯ�������ڣ���ʽ��YYYY-MM-dd��
     * @return   ����Ҫ��Ĺ�����־�б�
     */
    public static List getListByPID$DATE(int personid,String startdate,String enddate){

        if (personid<PERSONID_SEC_MIN){
            return worknotedao.getListByDate(startdate,enddate);

        }else{
            return worknotedao.getListByPID$DATE(personid,startdate,enddate);

        }

    }

    /**
     * ����ָ���Ĺ�����־�ڲ���ˮ�ţ����ָ���Ĺ�����־��ϸ��Ϣ��
     * @param worknoteid ָ�����ڲ���ˮ�š�
     * @return   ������־��ϸ��Ϣ��
     */
    public static Worknote getWorknoteByWID(long worknoteid){
        return worknotedao.getDetailByWID(worknoteid);

    }

    /**
     * ������Ա��š���־����״̬�����ڷ�Χ����ѯ���з���Ҫ�����־��Ϣ��
     * @param personid  ������ԱID�����С���㣬�ʹ���������Ա��
     * @param resultid   ��־����״̬�����С��-9,�ʹ���ȫ��״̬��
     * @param startdate  ��ѯ��ʼ���ڣ���ʽ��YYYY-MM-dd��
     * @param enddate    ��ѯ�������ڣ���ʽ��YYYY-MM-dd��
     * @return  ����Ҫ�����־�б�
     */
    public static List getListByPID$ResultID(int personid,short resultid,String startdate,String enddate){
        List list=null;
        // ��� PID С���㣬��ȡ�����˵����ݣ�����ȡָ����Ա�����ݡ�
        if (personid<=PERSONID_SEC_MIN)  list=worknotedao.getListByDate(startdate,enddate);
        else list=worknotedao.getListByPID$DATE(personid,startdate,enddate);
        // ��� ����״̬С��-10,��ȡ���е�����״̬������ȡָ��������״̬��
        if (resultid<=RESULT_SEC_MIN) {
            return list;
        }else{
            // �޳�����������״̬��������Ϣ��
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                if (((Worknote)iterator.next()).getResultID()!=resultid){
                    iterator.remove();
                }
            }
            return list;
        }
    }

    /**
     * ����һ��������־��¼��
     * ע1: ����������ڱȵ�ǰ���������豣�档
     * ע2: ������ڷ��Ϲ������ڵļ�¼�����豣�档
     * @param worknote
     */
    public static void createWorknote(Worknote worknote){

        worknote.setWorkDate(UtilCommon.getValidDate(worknote.getWorkDate()));

        // ����������ڱȵ�ǰ����������¼�롣
        if (worknote.getWorkDate()==null||Date.valueOf(worknote.getWorkDate()).after(new java.util.Date())){
            return ;
        }
        // ����������ڷǷ�������¼�롣
        String date1=Date.valueOf(worknote.getWorkDate()).toString();
        if (!Date.valueOf(worknote.getWorkDate()).toString().equals(worknote.getWorkDate())){
            return ;
        }

        // ����������ڲ����ڣ�������ӡ�
        if (worknotedao.getDetailByPID$DATE(worknote.getFk_personID(),worknote.getWorkDate())==null){
            worknotedao.create(worknote);
        }

    }

    /**
     * ����ָ���Ĺ�����־��¼��
     * @param worknote ���޸ĵĹ�����־��
     */
    public static void updateWorknote(Worknote worknote){
        worknotedao.update(worknote);
    }


}
