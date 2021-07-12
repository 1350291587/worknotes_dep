package com.source11.worknotes.dao;

import com.source11.worknotes.domain.Person;

import java.util.List;

/**
 * 个人简历的DAO 
 */
public interface PersonDao {

    /**
     * 该方法得到一个Person类型的javabean对象参数，
     * 并通过该javabean对象的get方法得到具体的值，经过预处理后插入到数据库
     * @param person 通过将页面请求得到的值使用set方法装入该类型的javabean后得到
     */
     public  void create(Person person);

     /**
     * 该方法得到一个person类型的javabean对象参数，
     * 并通过该javabean对象的get方法得到具体的值，经过预处理后修改数据库对应的值
     * @param person 通过将页面请求得到的值使用set方法装入该类型的javabean后得到
     */
     public  void update(Person person);

     /**
     * 该方法得到一个person类型的javabean对象参数，
     * 并通过该javabean对象的get方法得到关键字段，将它作为条件删除数据库对应的记录
     * @param personID 通过将页面请求得到的值使用set方法装入该类型的javabean后得到
     */
     public  void delete(int personID);

    /**
     * 该方法得到一个long类型的字段参数，
     * 将它作为条件查找数据库对应的记录
     * 将得到结果通过set方法装入person类型的javabean
     * @param personID 通过页面请求得到的人员编号
     * @return person类型的javabean，其中包含查询得到的结果
     */
     public  Person getDetail(int personID);

    /**
     * 该方法定义了一个List类型的向量
     * 通过查询数据库得到数据集，并依靠循环和set方法逐条放入一个person类型的javabean对象
     * 再将每次循环得到javabean对象装入一个list对象
     * @return  List类型的对象，包含得到的记录列表
     */
     public  List getListAll();
}
