package com.source11.worknotes.dao.ibatis;

import com.source11.worknotes.dao.WorknoteDao;
import com.source11.worknotes.domain.Worknote;
import com.source11.worknotes.domain.WNSearchVO;
import com.ibatis.dao.client.DaoManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2007-5-29
 * Time: 16:12:28
 * To change this template use File | Settings | File Templates.
 */
public class WorknoteSqlMapDao  extends BaseSqlMapDao implements WorknoteDao{

    public WorknoteSqlMapDao(DaoManager daoManager) {
        super(daoManager);
    }


    public void create(Worknote worknote) {
        update("insertWorknote", worknote);
    }

    public void update(Worknote worknote) {
        update("updateWorknote", worknote);
    }

    public void delete(long worknoteid) {
        update("deleteWorknote", Long.valueOf(worknoteid));
    }

    public Worknote getDetailByWID(long worknoteid) {
        List list= queryForList("getWorknotebyWID",Long.valueOf(worknoteid));
        if (list.size()==0) return null;
        return (Worknote)list.get(0);
    }

    public Worknote getDetailByPID$DATE(int personid, String workdate) {
        Worknote worknote=new Worknote();
        worknote.setFk_personID(personid);
        worknote.setWorkDate(workdate);
        List list=queryForList("getWorknotebyPID$DATE",worknote);
        if (list.size()==0) return null;
        return (Worknote)list.get(0);
    }

    public List getListByPID(int personid) {
        return queryForList("getListByPID", Integer.valueOf(personid));    }

    public List getListByDate(String startDate, String endDate) {
        WNSearchVO wnsearch=new WNSearchVO();
        wnsearch.setStartdate(startDate);
        wnsearch.setEnddate(endDate);
        return queryForList("getListByDATE", wnsearch);    }

    public List getListByPID$DATE(int personid, String startDate, String endDate) {
        WNSearchVO wnsearch=new WNSearchVO();
        wnsearch.setPersonid(personid);
        wnsearch.setStartdate(startDate);
        wnsearch.setEnddate(endDate);
        return queryForList("getListByPID$DATE", wnsearch);
    }

    public List getList(){
        return queryForList("getListAll", null);
    }
}

