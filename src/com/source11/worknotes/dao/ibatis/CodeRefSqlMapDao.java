package com.source11.worknotes.dao.ibatis;

import com.ibatis.dao.client.DaoManager;
import com.source11.worknotes.domain.CodeRef;
import com.source11.worknotes.dao.CodeRefDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2007-5-4
 * Time: 11:14:40
 * To change this template use File | Settings | File Templates.
 */
public class CodeRefSqlMapDao extends BaseSqlMapDao implements CodeRefDao {

    public CodeRefSqlMapDao(DaoManager daoManager) {
        super(daoManager);
    }

    public CodeRef getCodeRef(short codeType, short codeId) {
        CodeRef coderef = new CodeRef();
        coderef.setCodeType(codeType);
        coderef.setCodeId(codeId);

        return (CodeRef) queryForObject("getCodeRef",coderef);}

    public List getListAll() {
        return queryForList("getAllCodeRef", null);
    }
}
