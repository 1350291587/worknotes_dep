package com.source11.worknotes.dao;

import com.source11.worknotes.domain.Person;

import java.util.List;

/**
 * ���˼�����DAO 
 */
public interface PersonDao {

    /**
     * �÷����õ�һ��Person���͵�javabean���������
     * ��ͨ����javabean�����get�����õ������ֵ������Ԥ�������뵽���ݿ�
     * @param person ͨ����ҳ������õ���ֵʹ��set����װ������͵�javabean��õ�
     */
     public  void create(Person person);

     /**
     * �÷����õ�һ��person���͵�javabean���������
     * ��ͨ����javabean�����get�����õ������ֵ������Ԥ������޸����ݿ��Ӧ��ֵ
     * @param person ͨ����ҳ������õ���ֵʹ��set����װ������͵�javabean��õ�
     */
     public  void update(Person person);

     /**
     * �÷����õ�һ��person���͵�javabean���������
     * ��ͨ����javabean�����get�����õ��ؼ��ֶΣ�������Ϊ����ɾ�����ݿ��Ӧ�ļ�¼
     * @param personID ͨ����ҳ������õ���ֵʹ��set����װ������͵�javabean��õ�
     */
     public  void delete(int personID);

    /**
     * �÷����õ�һ��long���͵��ֶβ�����
     * ������Ϊ�����������ݿ��Ӧ�ļ�¼
     * ���õ����ͨ��set����װ��person���͵�javabean
     * @param personID ͨ��ҳ������õ�����Ա���
     * @return person���͵�javabean�����а�����ѯ�õ��Ľ��
     */
     public  Person getDetail(int personID);

    /**
     * �÷���������һ��List���͵�����
     * ͨ����ѯ���ݿ�õ����ݼ���������ѭ����set������������һ��person���͵�javabean����
     * �ٽ�ÿ��ѭ���õ�javabean����װ��һ��list����
     * @return  List���͵Ķ��󣬰����õ��ļ�¼�б�
     */
     public  List getListAll();
}
