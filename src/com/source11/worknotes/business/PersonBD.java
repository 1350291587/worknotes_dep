package com.source11.worknotes.business;

import com.source11.worknotes.dao.DaoFactory;
import com.source11.worknotes.dao.PersonDao;
import com.source11.worknotes.domain.Person;

import java.util.List;
import java.util.Iterator;

/**
 * 针对Person的业务代理类。
 * 主要功能是：
 * 1. 进行业务逻辑的处理
 * 2. 对持久层获取的数据进行数据过滤。
 */
public class PersonBD {

    private static short STATUS_NORMAL=0;
    /**
     * 获得一个PersonDao的实现体，用来进行DAO层访问。
     */
    private static PersonDao persondao=DaoFactory.createPersonDao();

    /**
     * 获得数据库中所有的人员简历。
     * @return 全部人员信息列表
     */
    public static List getAllPerson(){
        return persondao.getListAll();
    }

    /**
     * 获得数据库中所有工作状态正常的人员名单
     * @return 符合要求的人员列表。
     */
    public static List getNormalPersonList(){
        List list = persondao.getListAll();

        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            if (((Person)iterator.next()).getWorkStatusID() != STATUS_NORMAL){
                iterator.remove();
            }
        }

        return list;

    }

    /**
     * 根据指定记录流水号，获得对应的人员简历。
     * @param personid 记录流水号。
     * @return  指定的个人信息
     */
    public static Person getDetalByPID(int personid){
        return persondao.getDetail(personid);
    }

    /**
     * 更新人员简历。
     * 更新的关键索引是personid
     * @param person 待更新的个人信息。
     */
    public static void updatePerson(Person person){
        persondao.update(person);
    }

    /**
     * 创建指定的人员简历。
     * 允许重复的人员信息。
     * @param person  新的个人信息。
     */
    public static void createPerson(Person person){
        persondao.create(person);
    }

}
