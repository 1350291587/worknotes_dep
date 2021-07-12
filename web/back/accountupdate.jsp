<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/admin.inc" %>

<%@ page import="com.source11.worknotes.business.AccountBD,
                 com.source11.worknotes.business.PersonBD,
                 com.source11.worknotes.domain.CodeRef"%>

<c:set var="account" value="<%=AccountBD.getAccount(Integer.parseInt(request.getParameter("account_id")))%>" scope="page" />

<c:set var="accountList" value="<%=AccountBD.getAllAccount()%>" />
<c:set var="personList" value="<%=PersonBD.getAllPerson() %>" />
<c:set var="roleList" value="<%=CodeRef.getListByType((short)3100)%>" scope="page"/>
<c:set var="workstatusList" value="<%=CodeRef.getListByType((short)3200)%>" scope="page"/>
<c:set var="length" value="<%=AccountBD.getAllAccount().size()%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>人员基本信息</title>

<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>
<div align="center">
  <p>账号信息更新</p>
  <br><br>
  <form name="accountupdate" action="/accountctl?command=Update" method="post">
  <table width="500" border="1" cellpadding="0" cellspacing="1" >
    <tr align="left">
      <td height="25" colspan="2"> &nbsp;
      <c:forEach var="person_pr" items="${personList}">
        <c:choose>
                <c:when test="${person_pr.pk_personID == account.fk_personID}">
                  ${person_pr.personName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  ${person_pr.workID}
                </c:when>
            </c:choose>
      </c:forEach>
</td>
    </tr>
    <tr align="left">
      <td width="130" bgcolor="#7ba2e7">账号</td>
      <td>&nbsp;<input type="text" name="user_id" value="<c:out value="${account.pk_userid}"/>"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">密码</td>
      <td><input type="hidden" name="pass_old" value="<c:out value="${account.password}"/>">
&nbsp;<input type="password" name="pass_wd" value="<c:out value="${account.password}"/>"> </td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">操作类别</td>
      <td>&nbsp;<select name="roleid">
      <c:forEach var="coderef" items="${roleList}">
        <option value="${coderef.codeId}"
        <c:choose>
                <c:when test="${coderef.codeId == account.fk_role}">
                 selected
                </c:when>
                <c:otherwise>
                 &nbsp;
                </c:otherwise>
            </c:choose>
      > ${coderef.codeShow}</option>
      </c:forEach>
    </select></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">启用状态</td>
      <td>&nbsp;<c:forEach var="coderef" items="${workstatusList}">
        <input type="radio" name="workstatusid" value="${coderef.codeId}"
        <c:choose>
                <c:when test="${coderef.codeId == account.workstatus}">
                 checked
                </c:when>
                <c:otherwise>
                 &nbsp;
                </c:otherwise>
            </c:choose>
      >${coderef.codeShow} &nbsp;
      </c:forEach></td>
    </tr>

  </table>
  <p>
    <input type="hidden" name="account_id" value="<c:out value="${account.pk_accountID}"/>" >
    <input type="hidden" name="person_id" value="<c:out value="${account.fk_personID}"/>" >
    <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="返回" onClick='jumpto("/back/accountlist.jsp")'>
</p>
</form>
</div>
</body>
</html>
