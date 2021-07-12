package com.source11.worknotes.service;

import com.solidisc.web.ModuleController;
import com.source11.worknotes.dao.DaoFactory;
import com.source11.worknotes.dao.AccountDao;
import com.source11.worknotes.domain.Account;
import com.source11.worknotes.domain.Tokey;
import com.source11.worknotes.domain.CodeRef;
import com.source11.worknotes.business.AccountBD;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Account 的服务器控制类。
 */
public class AccountController extends ModuleController{
    private final static short WORKSTATUS_OK=0;
    private static AccountDao accountdao=DaoFactory.createAccountDao();

    /**
     * 完成用户登录的所有服务器端处理
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionLogon(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{

        String user=req.getParameter("user_name");
        String pass=req.getParameter("pass_word");
        String selecturl=req.getParameter("Select");

//        System.out.println("user= "+user);
//        System.out.println("pass= "+pass);

        Account account=AccountBD.getAccount(user,pass);
        // 判断账号、密码是否合法
        if (account==null) {
            String flag="用户名或密码不正确! ";
            req.setAttribute("errmsg",flag);
            //跳转到初始页面。
            req.getRequestDispatcher("index.jsp").forward(req,response);

        }else{
            //判断账号的工作状态是否“正常“
            if(account.getWorkstatus() == WORKSTATUS_OK ){
                HttpSession session=req.getSession();
                Tokey tokey = new Tokey(account);
                String loginTime="登录时间"+tokey.getCreateDate();
                session.setAttribute("tokey",tokey);
                session.setAttribute("loginTime",loginTime);
                session.setAttribute("codelist",CodeRef.getAll());
                String flag="正常登录! ";
                session.setAttribute("errmsg",flag);
                req.getRequestDispatcher(selecturl).forward(req,response);
            }else{
                String flag="你的账号已经被暂停使用 !  请与管理员联系 ";
                req.setAttribute("errmsg",flag);
                req.getRequestDispatcher("index.jsp").forward(req,response);
            }
        }
    }

    /**
     * 处理用户登出系统。
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionLogout(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{

        // 清除令牌
        HttpSession session=req.getSession();
        Tokey tokey = (Tokey)session.getAttribute("tokey");
        tokey.disable();
        tokey=null;
        session.removeAttribute("tokey");
        // 跳转到初始页面。
        req.getRequestDispatcher("index.jsp").forward(req,response);
    }

    /**
     * 修改日志管理用户的密码。
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionChangePwd(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{
        HttpSession session=req.getSession();
        Tokey tokey = (Tokey)session.getAttribute("tokey");

        String passwd=req.getParameter("passwd1");
        System.out.println("new pass: "+passwd);

        Account account = new Account();
        account.setPk_userid(tokey.getUserid());
        account.setPassword(passwd);

        accountdao.changePwd(account);

        String flag="登录密码修改完成 ! ";
        session.setAttribute("errmsg",flag);
        req.getRequestDispatcher("/front/leftfront.jsp").forward(req,response);

    }

    /**
     * 修改系统管理用户的密码。
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionChangePwdBk(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{
        HttpSession session=req.getSession();
        Tokey tokey = (Tokey)session.getAttribute("tokey");

        String passwd=req.getParameter("passwd1");
        System.out.println("new pass: "+passwd);

        Account account = new Account();
        account.setPk_userid(tokey.getUserid());
        account.setPassword(passwd);

        accountdao.changePwd(account);

        String flag="系统密码修改完成 ! ";
        session.setAttribute("errmsg",flag);
        req.getRequestDispatcher("/back/leftback.jsp").forward(req,response);

    }

    /**
     * 更新用户信息。
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionUpdate(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{

        String oldPasswd=req.getParameter("pass_old");
        Account account=new Account();
        account.setPk_accountID(Integer.parseInt(req.getParameter("account_id")));
        account.setFk_personID(Integer.parseInt(req.getParameter("person_id")));
        account.setPk_userid(req.getParameter("user_id"));
        account.setPassword(req.getParameter("pass_wd"));
        account.setFk_role(Short.parseShort(req.getParameter("roleid")));
        account.setWorkstatus(Short.parseShort(req.getParameter("workstatusid")));

//        System.out.println("account accountid: "+account.getPk_accountID());
//        System.out.println("account userid: "+account.getPk_userid());
//        System.out.println("account passwd: "+account.getPassword());
//        System.out.println("account oldpass:"+oldPasswd);
//        System.out.println("account personid: "+account.getFk_personID());
//        System.out.println("account roleid: "+account.getFk_role());
//        System.out.println("account workstatusid: "+account.getWorkstatus());

        AccountBD.updateAccount(account,oldPasswd);

        HttpSession session=req.getSession();
        String flag="账号修改完毕 ! ";
        session.setAttribute("errmsg",flag);
        req.getRequestDispatcher("/back/accountlist.jsp").forward(req,response);

    }

    /**
     * 创建用户信息。
     * @param req
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void actionCreate(HttpServletRequest req,
                                    HttpServletResponse response)
            throws IOException,ServletException{

        Account account=new Account();
        account.setFk_personID(Integer.parseInt(req.getParameter("person_id")));
        account.setPk_userid(req.getParameter("user_id"));
        account.setPassword(req.getParameter("pass_wd"));
        account.setFk_role(Short.parseShort(req.getParameter("roleid")));
        account.setWorkstatus(Short.parseShort(req.getParameter("workstatusid")));

//        System.out.println("account userid: "+account.getPk_userid());
//        System.out.println("account passwd: "+account.getPassword());
//        System.out.println("account personid: "+account.getFk_personID());
//        System.out.println("account roleid: "+account.getFk_role());
//        System.out.println("account workstatusid: "+account.getWorkstatus());

        AccountBD.createAccount(account);

        HttpSession session=req.getSession();
        String flag="账号添加完毕 ! ";
        session.setAttribute("errmsg",flag);
        req.getRequestDispatcher("/back/accountlist.jsp").forward(req,response);
    }
}