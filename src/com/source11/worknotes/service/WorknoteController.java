package com.source11.worknotes.service;

import com.solidisc.web.ModuleController;
import com.source11.worknotes.domain.Worknote;
import com.source11.worknotes.util.UtilCommon;
import com.source11.worknotes.business.WorknoteBD;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Worknote 的服务器控制类。
 */
public class WorknoteController extends ModuleController{

    /**
     * 工资日志更新
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionUpdate(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{
        Worknote worknote=new Worknote();
        worknote.setPk_worknoteID(Long.parseLong(req.getParameter("worknoteid")));
        worknote.setFk_personID(Integer.parseInt(req.getParameter("fk_personID")));
        worknote.setWorkstateID(Short.parseShort(req.getParameter("working")));
        worknote.setTodayAim(UtilCommon.getGBK(req.getParameter("todayaim")));
        worknote.setOutPlan(UtilCommon.getGBK(req.getParameter("outplan")));
        worknote.setHelping(UtilCommon.getGBK(req.getParameter("helping")));
        worknote.setTomorrowPlan(UtilCommon.getGBK(req.getParameter("tomorrowplan")));
        worknote.setWorkDate(req.getParameter("workDate"));
        worknote.setResultID(Short.parseShort(req.getParameter("resultID")));
        worknote.setFK_inspectorPID(Integer.parseInt(req.getParameter("FK_inspectorPID")));
        worknote.setComment(UtilCommon.getGBK(req.getParameter("comment")));
        worknote.setWill1(UtilCommon.getGBK(req.getParameter("will1")));
        worknote.setWill2(UtilCommon.getGBK(req.getParameter("will2")));

//        System.out.println("worknote id: "+worknote.getPk_worknoteID());
//        System.out.println("worknote personid: "+worknote.getFk_personID());
//        System.out.println("worknote status: "+worknote.getWorkstateID());
//        System.out.println("worknote todayaim: "+worknote.getTodayAim());
//        System.out.println("worknote outplay: "+worknote.getOutPlan());
//        System.out.println("worknote helping: "+worknote.getHelping());
//        System.out.println("worknote tomorrow: "+worknote.getTomorrowPlan());
//        System.out.println("worknote date: "+worknote.getWorkDate());
//        System.out.println("worknote result: "+worknote.getResultID());
//        System.out.println("worknote inspector: "+worknote.getFK_inspectorPID());
//        System.out.println("worknote comment: "+worknote.getComment());
//        System.out.println("worknote will1: "+worknote.getWill1());
//        System.out.println("worknote will2: "+worknote.getWill2());

        WorknoteBD.updateWorknote(worknote);

        req.getRequestDispatcher("/front/leftfront.jsp").forward(req,response);
    }

    /**
     * 工作日志创建
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionCreate(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{
        Worknote worknote=new Worknote();
        worknote.setFk_personID(Integer.parseInt(req.getParameter("fk_personID")));
        worknote.setWorkstateID(Short.parseShort(req.getParameter("working")));
        worknote.setTodayAim(UtilCommon.getGBK(req.getParameter("todayaim")));
        worknote.setOutPlan(UtilCommon.getGBK(req.getParameter("outplan")));
        worknote.setHelping(UtilCommon.getGBK(req.getParameter("helping")));
        worknote.setTomorrowPlan(UtilCommon.getGBK(req.getParameter("tomorrowplan")));
        worknote.setWorkDate(req.getParameter("_year")+"-"+req.getParameter("_month")+"-"+req.getParameter("_day"));
        worknote.setFK_inspectorPID(Integer.parseInt(req.getParameter("FK_inspectorPID")));
        worknote.setResultID(Short.parseShort(req.getParameter("resultID")));

//        System.out.println("worknote personid: "+worknote.getFk_personID());
//        System.out.println("worknote status: "+worknote.getWorkstateID());
//        System.out.println("worknote todayaim: "+worknote.getTodayAim());
//        System.out.println("worknote outplay: "+worknote.getOutPlan());
//        System.out.println("worknote helping: "+worknote.getHelping());
//        System.out.println("worknote tomorrow: "+worknote.getTomorrowPlan());
//        System.out.println("worknote date: "+worknote.getWorkDate());
//        System.out.println("worknote result: "+worknote.getResultID());
//        System.out.println("worknote inspector: "+worknote.getFK_inspectorPID());
//        System.out.println("worknote comment: "+worknote.getComment());
//        System.out.println("worknote will1: "+worknote.getWill1());
//        System.out.println("worknote will2: "+worknote.getWill2());

        WorknoteBD.createWorknote(worknote);

        req.getRequestDispatcher("/front/leftfront.jsp").forward(req,response);
    }

    /**
     * 工作日志审核。
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionReview(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{
        Worknote worknote=new Worknote();
        worknote.setPk_worknoteID(Long.parseLong(req.getParameter("worknoteid")));
        worknote.setFk_personID(Integer.parseInt(req.getParameter("fk_personID")));
        worknote.setWorkstateID(Short.parseShort(req.getParameter("working")));
        worknote.setTodayAim(UtilCommon.getGBK(req.getParameter("todayaim")));
        worknote.setOutPlan(UtilCommon.getGBK(req.getParameter("outplan")));
        worknote.setHelping(UtilCommon.getGBK(req.getParameter("helping")));
        worknote.setTomorrowPlan(UtilCommon.getGBK(req.getParameter("tomorrowplan")));
        worknote.setWorkDate(req.getParameter("workDate"));
        worknote.setResultID(Short.parseShort(req.getParameter("resultID")));
        worknote.setFK_inspectorPID(Integer.parseInt(req.getParameter("FK_inspectorPID")));
        worknote.setComment(UtilCommon.getGBK(req.getParameter("comment")));
        worknote.setWill1(UtilCommon.getGBK(req.getParameter("will1")));
        worknote.setWill2(UtilCommon.getGBK(req.getParameter("will2")));

//        System.out.println("worknote id: "+worknote.getPk_worknoteID());
//        System.out.println("worknote personid: "+worknote.getFk_personID());
//        System.out.println("worknote status: "+worknote.getWorkstateID());
//        System.out.println("worknote todayaim: "+worknote.getTodayAim());
//        System.out.println("worknote outplay: "+worknote.getOutPlan());
//        System.out.println("worknote helping: "+worknote.getHelping());
//        System.out.println("worknote tomorrow: "+worknote.getTomorrowPlan());
//        System.out.println("worknote date: "+worknote.getWorkDate());
//        System.out.println("worknote result: "+worknote.getResultID());
//        System.out.println("worknote inspector: "+worknote.getFK_inspectorPID());
//        System.out.println("worknote comment: "+worknote.getComment());
//        System.out.println("worknote will1: "+worknote.getWill1());
//        System.out.println("worknote will2: "+worknote.getWill2());

        WorknoteBD.updateWorknote(worknote);

        req.getRequestDispatcher("/search/examinelist.jsp").forward(req,response);
    }
}