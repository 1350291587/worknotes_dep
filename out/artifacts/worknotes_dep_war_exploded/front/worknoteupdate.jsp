<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/recorder.inc" %>

<%@ page import="com.source11.worknotes.business.WorknoteBD,
                 com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.business.PersonBD,
                 com.source11.worknotes.business.SearchDate,
                 com.source11.worknotes.domain.Worknote"%>

<%
    Worknote worknote = WorknoteBD.getWorknoteByWID(Long.parseLong(request.getParameter("worknoteid")));
    SearchDate searchDate = new SearchDate(worknote);
%>
<c:set var="worknote" value="<%=worknote%>" />
<c:set var="workstatuslist" value="<%=CodeRef.getListByType((short)1100)%>" scope="page"/>
<c:set var="year" value="<%=searchDate.getThisWNYear()%>" scope="page"/>
<c:set var="month" value="<%=searchDate.getThisWNMonth()%>" scope="page"/>
<c:set var="day" value="<%=searchDate.getThisWNDay()%>" scope="page"/>
<c:set var="personlist" value="<%=PersonBD.getAllPerson()%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改工作日志</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../js/common.js"></script>
</head>

<body>

<p align="center">工作日志修改</p>
<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${tokey.username}"/> &nbsp;&nbsp;登录时间 <c:out value="${tokey.createDate}"/> </p>
<form name="fill_worknote" action="/worknotectl?command=Update" method="post">
<table width="700" border="1" align="center" cellpadding="0" cellspacing="1">


  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> 工作状态 </div></td>
    <td >&nbsp;<select name="working">
            <c:forEach var="coderef" items="${workstatuslist}">
            <option value="${coderef.codeId}"
            <c:choose>
                <c:when test="${coderef.codeId == worknote.workstateID}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${coderef.codeShow}</option>
            </c:forEach>
        </select></td>
    <td width="100">&nbsp;工作日期</td>
    <td >&nbsp;
    <select name="_year" disabled>
      <c:forEach begin="2006" end="2025" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${year == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>
    年
    <select name="_month" disabled>
        <c:forEach begin="1" end="12" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${month == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>
    月
    <select name="_day" disabled>
        <c:forEach begin="1" end="31" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${day == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>
    日
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7" align="center" >计划完成情况</td>
    <td colspan="3" width="570"><textarea name="todayaim" cols="80" rows="6" ><c:out value="${worknote.todayAim}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7" align="center" >计划外任务完成情况</td>
    <td colspan="3"><textarea name="outplan" cols="80" rows="6"><c:out value="${worknote.outPlan}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"  align="center">存在的问题</td>
    <td colspan="3"><textarea name="helping" cols="80" rows="4"><c:out value="${worknote.helping}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7" align="center" >明日计划</td>
    <td colspan="3"><textarea name="tomorrowplan" cols="80" rows="6"><c:out value="${worknote.tomorrowPlan}"/></textarea>
    </td>
  </tr>
</table>
<p align="center">
  <input type="hidden" name="worknoteid" value="<c:out value="${worknote.pk_worknoteID}"/>" >
  <input type="hidden" name="fk_personID" value="<c:out value="${worknote.fk_personID}"/>" >
  <input type="hidden" name="workDate" value="<c:out value="${worknote.workDate}"/>" >
  <input type="hidden" name="comment" value="<c:out value="${worknote.comment}"/>">
  <input type="hidden" name="FK_inspectorPID" value="<c:out value="${worknote.FK_inspectorPID}"/>">
  <input type="hidden" name="resultID" value="1">
  <input type="hidden" name="will1" value="<c:out value="${worknote.will1}"/>">
  <input type="hidden" name="will2" value="<c:out value="${worknote.will2}"/>">

  <input type="submit" name="Submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;<input type="button" value="返回" onClick='history.go(-1)'>
</p>
</form>

<hr>
	<table width="700" border="1" align="center" cellpadding="0" cellspacing="0" >
    <tr>
      <td height="40" align="left" colspan="4"><textarea name="todayaim" cols="80" rows="4" readonly><c:out value="${worknote.comment}"/></textarea>
    </td>
    <td width="200" align="center">
    审核 <br>
    <c:forEach var="person" items="${personlist}">
        <c:choose>
            <c:when test="${person.pk_personID == worknote.FK_inspectorPID}">${person.personName}</c:when>
        </c:choose>
    </c:forEach>
    </td>
    </tr>
  </table>

</body>
</html>
