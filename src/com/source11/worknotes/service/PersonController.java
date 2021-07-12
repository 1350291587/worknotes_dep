package com.source11.worknotes.service;

import com.source11.worknotes.domain.Person;
import com.source11.worknotes.util.UtilCommon;
import com.source11.worknotes.business.PersonBD;
import com.solidisc.web.ModuleController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Person 的服务器控制类。
 */
public class PersonController extends ModuleController{

    /**
     * 人员信息更新
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionUpdate(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{
        Person person=new Person();

        String birth_year="0000"+req.getParameter("year");
        birth_year=birth_year.substring(birth_year.length()-4,birth_year.length());
        ;
        String birth_month="00"+req.getParameter("month");
        birth_month=birth_month.substring(birth_month.length()-2,birth_month.length());
        String birth_day="00"+req.getParameter("day");
        birth_day=birth_day.substring(birth_day.length()-2,birth_day.length());

        String birthday = birth_year+"-"+birth_month+"-"+birth_day;

        person.setPk_personID(Integer.parseInt(req.getParameter("person_id")));
        person.setNameSpell(req.getParameter("nameSpell"));
        person.setPersonName(UtilCommon.getGBK(req.getParameter("personName")));
        person.setBirthday(birthday);
        person.setFk_presidentID(Integer.parseInt(req.getParameter("presidentid")));
        person.setMemo(UtilCommon.getGBK(req.getParameter("memo")));
        person.setPersonTypeID(Short.parseShort(req.getParameter("persontypeid")));
        person.setPhone1(req.getParameter("phone1"));
        person.setPhone2(req.getParameter("phone2"));
        person.setPositionID(Short.parseShort(req.getParameter("positionid")));
        person.setSexID(Short.parseShort(req.getParameter("sexid")));
        person.setWorkID(req.getParameter("workid"));
        person.setWorkStatusID(Short.parseShort(req.getParameter("workstatusid")));

//        System.out.println("person namespell: "+person.getNameSpell());
//        System.out.println("person personid: "+person.getPk_personID());
//        System.out.println("person name: "+person.getPersonName());
//        System.out.println("person workid: "+person.getWorkID());
//        System.out.println("person presidentid: "+person.getFk_presidentID());
//        System.out.println("person birthday: "+person.getBirthday());
//        System.out.println("person typeid: "+person.getPersonTypeID());
//        System.out.println("person phone1: "+person.getPhone1());
//        System.out.println("person phone2: "+person.getPhone2());
//        System.out.println("person positionid: "+person.getPositionID());
//        System.out.println("person sexid: "+person.getSexID());
//        System.out.println("person workstatusid: "+person.getWorkStatusID());
//        System.out.println("person memo: "+person.getMemo());

        PersonBD.updatePerson(person);

        req.getRequestDispatcher("/back/personlist.jsp").forward(req,response);

    }

    /**
     * 人员信息创建
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionCreate(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{
        Person person=new Person();

        String birth_year="0000"+req.getParameter("year");
        birth_year=birth_year.substring(birth_year.length()-4,birth_year.length());
        ;
        String birth_month="00"+req.getParameter("month");
        birth_month=birth_month.substring(birth_month.length()-2,birth_month.length());
        String birth_day="00"+req.getParameter("day");
        birth_day=birth_day.substring(birth_day.length()-2,birth_day.length());

        String birthday = birth_year+"-"+birth_month+"-"+birth_day;

        System.out.println("birthday= " + birthday);

        person.setNameSpell(req.getParameter("nameSpell"));
        person.setPersonName(UtilCommon.getGBK(req.getParameter("personName")));
        person.setBirthday(birthday);
        person.setFk_presidentID(Integer.parseInt(req.getParameter("presidentid")));
        person.setMemo(UtilCommon.getGBK(req.getParameter("memo")));
        person.setPersonTypeID(Short.parseShort(req.getParameter("persontypeid")));
        person.setPhone1(req.getParameter("phone1"));
        person.setPhone2(req.getParameter("phone2"));
        person.setPositionID(Short.parseShort(req.getParameter("positionid")));
        person.setSexID(Short.parseShort(req.getParameter("sexid")));
        person.setWorkID(req.getParameter("workid"));
        person.setWorkStatusID(Short.parseShort(req.getParameter("workstatusid")));

//        System.out.println("person namespell: "+person.getNameSpell());
//        System.out.println("person personid: "+person.getPk_personID());
//        System.out.println("person name: "+person.getPersonName());
//        System.out.println("person workid: "+person.getWorkID());
//        System.out.println("person presidentid: "+person.getFk_presidentID());
//        System.out.println("person birthday: "+person.getBirthday());
//        System.out.println("person typeid: "+person.getPersonTypeID());
//        System.out.println("person phone1: "+person.getPhone1());
//        System.out.println("person phone2: "+person.getPhone2());
//        System.out.println("person positionid: "+person.getPositionID());
//        System.out.println("person sexid: "+person.getSexID());
//        System.out.println("person workstatusid: "+person.getWorkStatusID());
//        System.out.println("person memo: "+person.getMemo());

        PersonBD.createPerson(person);

        req.getRequestDispatcher("/back/personlist.jsp").forward(req,response);

    }


}
