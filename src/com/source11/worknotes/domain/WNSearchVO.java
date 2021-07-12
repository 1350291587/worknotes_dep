package com.source11.worknotes.domain;

/**
 * DAO层worknotes查询用值传递对象。用来传递日期范围（起始日期，结束日期）
 * 因为工作日志只有一个工作日期。而如果要查询指定日期范围的数据，就不能用Worknote对象。
 */
public class WNSearchVO {
    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    private int personid;       // 人员内部编号
    private String startdate;   // 查询起始日期（格式：yyyy-MM-dd ）
    private String enddate;     // 查询结束日期（格式：yyyy-MM-dd ）


}
