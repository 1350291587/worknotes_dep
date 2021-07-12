package com.source11.worknotes.business;

import com.source11.worknotes.common.Source11Common;
import com.source11.worknotes.domain.Tokey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Vector;

/**
 * ҳ���ѯ��������ֽ��ࡣ
 * ��Ҫ�����ǣ�
 * 1. �ֽ��ѯ�����е� ��ʼ���ڣ��ꡢ�¡��գ����������ڣ��ꡢ�¡��գ�
 * 2. �ֽ��ѯ�����е� ��Ա�ڲ���š���־����״̬��š�
 */
public class SearchQueryWN implements Source11Common{
    // ҵ��ʹ�õĳ�������
    private final static int PERSONID_SEC_MIN=-1;
    private final static short RESULT_SEC_MIN=-10;

    // ��ѯ�����ڣ���ʼ���ڣ��������ڣ�����ʽ(YYYY-MM-dd)
    private String startDate = DATE_MIN;
    private  String endDate = DATE_MAX;

    // ��ѯ���ڵ� �꣨YYYY�����£�MM�����գ�dd��
    private  String year_from ="2006";
    private  String month_from ="01";
    private  String day_from ="01";
    private  String year_to ="2025";
    private  String month_to ="12";
    private  String day_to ="31";

    // �������Ҫ��Ĺ�����־�б�
    private List list;

    // ��Ա�ڲ���ţ����С���㣬�ʹ���������Ա��
    private int personID=PERSONID_SEC_MIN;
    // ������־״̬�����С��10,�ʹ�������״̬��
    private short resultID=RESULT_SEC_MIN;


    /**
     * ����ҳ���ѯ���������
     * �����в����ֽ�
     * @param request  �������
     */
    public void setRequest(HttpServletRequest request){
        // �ж��Ƿ��д��������
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
     * ����ҳ���ѯ���������
     * �����в����ֽ⡣
     * ע������������У���������Ա�ڲ���ź���־����״̬��š�
     * @param request  �������
     */
    public void setRequestNoPid(HttpServletRequest request){

        HttpSession session=request.getSession();
        Tokey tokey=(Tokey)session.getAttribute("tokey");

        // �ж��Ƿ��д��������
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
     * ������з��ϲ�ѯ�����Ĺ�����־��
     * @return  worknote������б�
     */
    public List getResultWorknoteList(){
        return list;
    }

}
