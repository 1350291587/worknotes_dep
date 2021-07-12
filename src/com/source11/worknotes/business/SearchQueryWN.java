package com.source11.worknotes.business;

import com.source11.worknotes.common.Source11Common;
import com.source11.worknotes.domain.Tokey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Vector;

/**
 * 页面查询请求参数分解类。
 * 主要功能是：
 * 1. 分解查询请求中的 开始日期（年、月、日），结束日期（年、月、日）
 * 2. 分解查询请求中的 人员内部编号、日志处理状态编号。
 */
public class SearchQueryWN implements Source11Common{
    // 业务使用的常量定义
    private final static int PERSONID_SEC_MIN=-1;
    private final static short RESULT_SEC_MIN=-10;

    // 查询用日期（开始日期，结束日期），格式(YYYY-MM-dd)
    private String startDate = DATE_MIN;
    private  String endDate = DATE_MAX;

    // 查询日期的 年（YYYY）、月（MM）、日（dd）
    private  String year_from ="2006";
    private  String month_from ="01";
    private  String day_from ="01";
    private  String year_to ="2025";
    private  String month_to ="12";
    private  String day_to ="31";

    // 保存符合要求的工作日志列表。
    private List list;

    // 人员内部编号，如果小于零，就代表所有人员。
    private int personID=PERSONID_SEC_MIN;
    // 工作日志状态，如果小于10,就代表所有状态。
    private short resultID=RESULT_SEC_MIN;


    /**
     * 设置页面查询的请求对象。
     * 并进行参数分解
     * @param request  请求对象。
     */
    public void setRequest(HttpServletRequest request){
        // 判断是否有传入参数。
        if(request.getParameter("year_from")!=null){
            year_from=request.getParameter("year_from");
            year_to=request.getParameter("year_to");

            month_from="00"+request.getParameter("month_from");
            month_from=month_from.substring(month_from.length()-2,month_from.length());
            day_from="00"+request.getParameter("day_from");
            day_from=day_from.substring(day_from.length()-2,day_from.length());
            month_to="00"+request.getParameter("month_to");
            month_to=month_to.substring(month_to.length()-2,month_to.length());
            day_to="00"+request.getParameter("day_to");
            day_to=day_to.substring(day_to.length()-2,day_to.length());

            startDate = year_from+"-"+month_from+"-"+day_from;
            endDate = year_to+"-"+month_to+"-"+day_to;

            personID=Integer.parseInt(request.getParameter("person_id"));
            resultID=Short.parseShort(request.getParameter("result_id"));

        }else{
            startDate = DATE_MIN;
            endDate = DATE_MAX;
            year_from ="2006";
            month_from ="01";
            day_from ="01";
            year_to ="2019";
            month_to ="12";
            day_to ="31";

            startDate = year_from+"-"+month_from+"-"+day_from;
            endDate = year_to+"-"+month_to+"-"+day_to;

            personID=PERSONID_SEC_MIN;
            resultID=RESULT_SEC_MIN;
        }

       list=WorknoteBD.getListByPID$ResultID(personID,resultID,startDate,endDate);

    }

    /**
     * 设置页面查询的请求对象。
     * 并进行参数分解。
     * 注：该请求对象中，不包含人员内部编号和日志处理状态编号。
     * @param request  请求对象。
     */
    public void setRequestNoPid(HttpServletRequest request){

        HttpSession session=request.getSession();
        Tokey tokey=(Tokey)session.getAttribute("tokey");

        // 判断是否有传入参数。
        if(request.getParameter("year_from")!=null){
            year_from=request.getParameter("year_from");
            year_to=request.getParameter("year_to");

            month_from="00"+request.getParameter("month_from");
            month_from=month_from.substring(month_from.length()-2,month_from.length());
            day_from="00"+request.getParameter("day_from");
            day_from=day_from.substring(day_from.length()-2,day_from.length());
            month_to="00"+request.getParameter("month_to");
            month_to=month_to.substring(month_to.length()-2,month_to.length());
            day_to="00"+request.getParameter("day_to");
            day_to=day_to.substring(day_to.length()-2,day_to.length());

            startDate = year_from+"-"+month_from+"-"+day_from;
            endDate = year_to+"-"+month_to+"-"+day_to;

        }else{
            startDate = DATE_MIN;
            endDate = DATE_MAX;
            year_from ="2006";
            month_from ="01";
            day_from ="01";
            year_to ="2019";
            month_to ="12";
            day_to ="31";

            startDate = year_from+"-"+month_from+"-"+day_from;
            endDate = year_to+"-"+month_to+"-"+day_to;

        }
        list=WorknoteBD.getListByPID$DATE(tokey.getPersonid(),startDate,endDate);

    }


    public String getDay_from() {
        return day_from;
    }

    public String getDay_to() {
        return day_to;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getMonth_from() {
        return month_from;
    }

    public String getMonth_to() {
        return month_to;
    }

    public int getPersonID() {
        return personID;
    }

    public short getResultID() {
        return resultID;
    }

    public String getYear_to() {
        return year_to;
    }

    public String getYear_from() {
        return year_from;
    }

    public String getStartDate() {
        return startDate;
    }

    /**
     * 获得所有符合查询条件的工作日志。
     * @return  worknote对象的列表
     */
    public List getResultWorknoteList(){
        return list;
    }

}
