package com.source11.worknotes.dao.ibatis;

import com.source11.worknotes.dao.PersonDao;
import com.source11.worknotes.domain.Person;
import com.ibatis.dao.client.DaoManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2007-5-29
 * Time: 13:08:52
 * To change this template use File | Settings | File Templates.
 */
public class PersonSqlMapDao extends BaseSqlMapDao implements PersonDao{
    public PersonSqlMapDao(DaoManager daoManager){
        super(daoManager);
    }

    public void create(Person person) {
        update("insertPerson", person);
    }

    public void update(Person person) {
        update("updatePerson", person);
    }

    public void delete(int personID) {
        update("deletePerson", Integer.valueOf(personID));
    }

    public Person getDetail(int personID) {
        return (Person)queryForObject("getPersonByPID",Integer.valueOf(personID));
    }

    public List getListAll() {
        return queryForList("getPersonAll", null);    }
}
