<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/admin.inc" %>

<%@ page import="com.source11.worknotes.business.PersonBD,
                 com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.domain.Person,
                 com.source11.worknotes.business.BirthDate"%>


<%
    Person person = PersonBD.getDetalByPID(Integer.parseInt(request.getParameter("person_id")));
    BirthDate birthdate=new BirthDate(person);
%>
<c:set var="person" value="<%=person%>" scope="page" />

<c:set var="year" value="<%=birthdate.getBirthMonth()%>" />
<c:set var="month" value="<%=birthdate.getBirthMonth()%>" />
<c:set var="day" value="<%=birthdate.getBirthDay()%>" />

<c:set var="sexList" value="<%=CodeRef.getListByType((short)2100)%>" scope="page"/>
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
  <p>人员基本信息修正</p>
  <br><br>
  <form name="personupdate" action="/personctl?command=Update" method="post">
  <table width="500" border="1" cellpadding="0" cellspacing="1">
    <tr align="left">
      <td width="130" height="25" bgcolor="#7ba2e7"> <div align="left">人员编号 </div></td>
      <td width="450">&nbsp;<c:out value="${person.pk_personID}"/></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">姓名拼写</td>
      <td>&nbsp;<input type="text" name="nameSpell" value="<c:out value="${person.nameSpell}"/>"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">姓名</td>
      <td>&nbsp;<input type="text" name="personName" value="<c:out value="${person.personName}"/>"></td>
    </tr>
	    <tr align="left">
      <td height="25" bgcolor="#7ba2e7">工 号</td>
      <td height="20">&nbsp;<input type="text" name="workid"  value="<c:out value="${person.workID}"/>"></td>
    </tr>	
	    <tr align="left">
      <td height="25" bgcolor="#7ba2e7">部门主管</td>
      <td height="20">&nbsp;<select name="presidentid">
      <c:forEach var="person_pr" items="${personList}">
        <option value="${person_pr.pk_personID}"
            <c:choose>
                <c:when test="${person_pr.pk_personID == person.fk_presidentID}">
                 selected
                </c:when>
                <c:otherwise>
                 &nbsp;
                </c:otherwise>
            </c:choose>
      >${person_pr.personName}</option>
      </c:forEach>
    </select></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">人员类型</td>
      <td>&nbsp;<select name="persontypeid">
      <c:forEach var="coderef" items="${typeList}">
        <option value="${coderef.codeId}"
            <c:choose>
                <c:when test="${coderef.codeId == person.personTypeID}">
                 selected
                </c:when>
                <c:otherwise>
                 &nbsp;
                </c:otherwise>
            </c:choose>
      >${coderef.codeShow}</option>
      </c:forEach>
    </select></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">职位</td>
      <td>&nbsp;<select name="positionid">
      <c:forEach var="coderef" items="${positionList}">
        <option value="${coderef.codeId}"
            <c:choose>
                <c:when test="${coderef.codeId == person.positionID}">
                 selected
                </c:when>
                <c:otherwise>
                 &nbsp;
                </c:otherwise>
            </c:choose>
      >${coderef.codeShow}</option>
      </c:forEach>
    </select></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">生日</td>
      <td>&nbsp;<input name="year" type="text" value="<c:out value="${year}"/>" size="4" maxlength="4" >
      年
	  <input name="month" type="text" value="<c:out value="${month}"/>" size="2" maxlength="2">
	  月
	  <input name="day" type="text" value="<c:out value="${day}"/>" size="2" maxlength="2">
	  日
      </td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">性别</td>
      <td>&nbsp;
      <c:forEach var="coderef" items="${sexList}">
        <input type="radio" name="sexid" value="${coderef.codeId}"
            <c:choose>
                <c:when test="${coderef.codeId == person.sexID}">
                 checked
                </c:when>
                <c:otherwise>
                 &nbsp;
                </c:otherwise>
            </c:choose>
      >${coderef.codeShow} &nbsp;
      </c:forEach>
	  </td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">电话一</td>
      <td>&nbsp;<input type="text" name="phone1" value="<c:out value="${person.phone1}"/>"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">电话二</td>
      <td>&nbsp;<input type="text" name="phone2" value="<c:out value="${person.phone2}"/>"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">工作状态</td>
      <td>&nbsp;
    <c:forEach var="coderef" items="${statusList}">
        <input type="radio" name="workstatusid" value="${coderef.codeId}"
            <c:choose>
                <c:when test="${coderef.codeId == person.workStatusID}">
                 checked
                </c:when>
                <c:otherwise>
                 &nbsp;
                </c:otherwise>
            </c:choose>
      >${coderef.codeShow} &nbsp;
      </c:forEach>

    </td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7">备 注</td>
      <td>&nbsp;<textarea name="memo" cols="55" rows="4"><c:out value="${person.memo}"/></textarea></td>
    </tr>
  </table>
  <p>
    <input type="hidden" name="person_id" value="<c:out value="${person.pk_personID}"/>" >

    <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="返回" onClick='jumpto("/back/persondetail.jsp?person_id=<c:out value="${person.pk_personID}" />")'>
</p>
</form>
</div>
</body>
</html>
