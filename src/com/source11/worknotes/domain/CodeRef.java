package com.source11.worknotes.domain;

import com.source11.worknotes.dao.DaoFactory;

import java.util.List;
import java.util.Iterator;
import java.util.Vector;
import java.io.Serializable;

/**
 * �������������ֵ�
 */
public class CodeRef implements Serializable {
    private static List list;
    private short codeType;
    private short codeId;
    private String codeShow;
    private String showNative;
    private String memo;

    static {
        list = DaoFactory.createCodeRefDao().getListAll();
    }

    public static List getAll(){
        return list;
    }

    public static CodeRef getCodeRef(short codetype,short codeid){
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            CodeRef coderef = (CodeRef)iterator.next();
            if ((coderef.getCodeType()==codetype)&&(coderef.getCodeId()==codeid)){
                return coderef;
            }
        }
        return null;
    }

    /**
     * ���ݸ����Ĵ����ţ���ø����͵�ȫ�������ֵ䡣
     * @param codetype �����š�
     * @return  ����Ҫ��������б�
     */
    public static List getListByType(short codetype){
        List listtype=new Vector();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            CodeRef coderef = (CodeRef)iterator.next();
            if (coderef.getCodeType()==codetype){
                listtype.add(coderef);
            }
        }
        return listtype;
    }

    public void setCodeId(short codeId) {
        this.codeId = codeId;
    }

    public void setCodeShow(String codeShow) {
        this.codeShow = codeShow;
    }

    public void setCodeType(short codeType) {
        this.codeType = codeType;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setShowNative(String showNative) {
        this.showNative = showNative;
    }

    public CodeRef(){

    }

    public short getCodeType() {
        return codeType;
    }

    public short getCodeId() {
        return codeId;
    }

    public String getCodeShow() {
        return codeShow;
    }

    public String getShowNative() {
        return showNative;
    }

    public String getMemo() {
        return memo;
    }


}
