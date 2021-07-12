package com.source11.worknotes.dao;

import com.source11.worknotes.domain.CodeRef;

import java.util.List;


/**
 * ���������ֵ�DAO
 */
public interface CodeRefDao {

    /**
     * �����ݿ��л�ȡָ����������������ĳ���
     * @param codeType ��������
     * @param codeId   ��������
     * @return ָ���Ĳ������� CodeRef
     */
    public CodeRef getCodeRef(short codeType,short codeId);

    /**
     * ������ݿ��е�ȫ�����ݳ���
     * @return ������������ڶ����С�
     */
    public List getListAll();
}
