<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/admin.inc" %>

<%@ page import="com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.business.PersonBD"%>

<c:set var="typeList" value="<%=CodeRef.getListByType((short)2200)%>" scope="page"/>
<c:set var="statusList" value="<%=CodeRef.getListByType((short)2300)%>" scope="page"/>
<c:set var="positionList" value="<%=CodeRef.getListByType((short)2400)%>" scope="page"/>
<c:set var="personList" value="<%=PersonBD.getAllPerson()%>" scope="page"/>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>人员基本信息</title>

<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>
<div align="center">
  <p>添加新人员信息</p>
  <br><br>
  <form name="personadd" action="/personctl?command=Create" method="post">
  <table width="500" border="1" cellpadding="0" cellspacing="1">
    <tr align="left">
      <td width="130" bgcolor="#7ba2e7">姓名拼写</td>
      <td width="450">&nbsp;<input type="text" name="nameSpell"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">姓名</td>
      <td>&nbsp;<input type="text" name="personName"></td>
    </tr>
	<td height="25" bgcolor="#7ba2e7">工 号</td>
      <td height="20">&nbsp;<input type="text" name="workid" value="5107 01 020"></td>
    </tr>
	    <tr align="left">
      <td height="25" bgcolor="#7ba2e7">部门主管</td>
      <td height="20">&nbsp;<select name="presidentid">
      <c:forEach var="person_pr" items="${personList}">
        <option value="${person_pr.pk_personID}" >${person_pr.personName}</option>
      </c:forEach>
    </select></td>
    <tr align="left">
      <td bgcolor="#7ba2e7">人员类型</td>
      <td>&nbsp;<select name="persontypeid">
      <c:forEach var="coderef" items="${typeList}">
        <option value="${coderef.codeId}" >${coderef.codeShow}</option>
      </c:forEach>
    </select></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">职位</td>
      <td>&nbsp;<select name="positionid">
      <c:forEach var="coderef" items="${positionList}">
        <option value="${coderef.codeId}" >${coderef.codeShow}</option>
      </c:forEach>
    </select></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">生日</td>
      <td>&nbsp;<input name="year" type="text" value="19" size="4" maxlength="4" >
      年
	  <input name="month" type="text" size="2" maxlength="2">
	  月
	  <input name="day" type="text" size="2" maxlength="2">
	  日</td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">性别</td>
      <td>&nbsp;<input type="radio" name="sexid" value="0" checked >
      男 <input type="radio" name="sexid" value="1"> 女
	  </td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">电话一</td>
      <td>&nbsp;<input type="text" name="phone1"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">电话二</td>
      <td>&nbsp;<input type="text" name="phone2"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">工作状态</td>
      <td>&nbsp;<select name="workstatusid">
      <c:forEach var="coderef" items="${statusList}">
        <option value="${coderef.codeId}" >${coderef.codeShow}</option>
      </c:forEach>
    </select>
    </td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">备 注</td>
      <td><textarea name="memo" cols="55" rows="4"></textarea></td>
    </tr>
  </table>
  <p><input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="返回" onClick='jumpto("personlist.jsp")'>
</p>
</form>
</div>
</body>
</html>
