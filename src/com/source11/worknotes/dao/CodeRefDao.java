package com.source11.worknotes.dao;

import com.source11.worknotes.domain.CodeRef;

import java.util.List;


/**
 * 常量引用字典DAO
 */
public interface CodeRefDao {

    /**
     * 从数据库中获取指定参数分类和索引的常量
     * @param codeType 参数分类
     * @param codeId   参数索引
     * @return 指定的参数对象 CodeRef
     */
    public CodeRef getCodeRef(short codeType,short codeId);

    /**
     * 获得数据库中的全部数据常量
     * @return 将常量对象放在队列中。
     */
    public List getListAll();
}
