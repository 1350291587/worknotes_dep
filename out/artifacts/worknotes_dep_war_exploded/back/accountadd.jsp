<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/admin.inc" %>

<%@ page import="com.source11.worknotes.business.AccountBD,
                 com.source11.worknotes.business.PersonBD,
                 com.source11.worknotes.domain.CodeRef"%>

<c:set var="accountList" value="<%=AccountBD.getAllAccount()%>" />
<c:set var="personList" value="<%=PersonBD.getNormalPersonList() %>" />
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
  <p>新账号添加</p>
  <br><br>
  <form name="accountCreate" action="/accountctl?command=Create" method="post">
  <table width="500" border="1" cellpadding="0" cellspacing="1">
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7">人员姓名</td>
	  <td>&nbsp;<select name="person_id">
      <c:forEach var="person" items="${personList}">
        <option value="${person.pk_personID}" >${person.personName} - ${person.workID}</option>
      </c:forEach>
    </select>
	  </td>
    </tr>
    <tr align="left">
      <td width="130" bgcolor="#7ba2e7">账号</td>
      <td>&nbsp;<input type="text" name="user_id"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">密码</td>
      <td>&nbsp;<input type="password" name="pass_wd"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">操作类别</td>
      <td>&nbsp;<select name="roleid">
      <c:forEach var="coderef" items="${roleList}">
        <option value="${coderef.codeId}" > ${coderef.codeShow}</option>
      </c:forEach>
    </select></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">启用状态</td>
      <td><c:forEach var="coderef" items="${workstatusList}">
        <input type="radio" name="workstatusid" value="${coderef.codeId}"
        <c:choose>
                <c:when test="${coderef.codeId == 0}">
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
  <p><input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="返回" onClick='jumpto("/back/accountlist.jsp")'>
</p>
</form>
</div>
</body>
</html>
