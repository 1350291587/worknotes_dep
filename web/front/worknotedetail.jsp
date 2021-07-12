<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/recorder.inc" %>

<%@ page import="com.source11.worknotes.business.WorknoteBD,
                 com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.business.PersonBD,
                 com.source11.worknotes.domain.Worknote,
                 com.source11.worknotes.business.SearchDate"%>

<%
    Worknote worknote = WorknoteBD.getWorknoteByWID(Long.parseLong(request.getParameter("worknoteid")));
    SearchDate searchdate= new SearchDate(worknote);
%>
<c:set var="worknote" value="<%=worknote%>" />
<c:set var="workstatuslist" value="<%=CodeRef.getListByType((short)1100)%>" scope="page"/>
<c:set var="resultlist" value="<%=CodeRef.getListByType((short)1300)%>" scope="page"/>
<c:set var="year" value="<%=searchdate.getThisWNYear()%>" scope="page"/>
<c:set var="month" value="<%=searchdate.getThisWNMonth()%>" scope="page"/>
<c:set var="day" value="<%=searchdate.getThisWNDay()%>" scope="page"/>
<c:set var="personlist" value="<%=PersonBD.getAllPerson()%>" scope="page"/>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>工作日志详情</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../js/common.js"></script>
</head>

<body>
<p align="center">工作日志详情一览
<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${tokey.username}"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前状态：
<c:forEach var="coderef" items="${resultlist}">
    <c:choose>
        <c:when test="${coderef.codeId == worknote.resultID}">
            ${coderef.codeShow}
        </c:when>
    </c:choose>
</c:forEach>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
更新时间：<c:out value="${worknote.updateTime}"/>
</p>

<table width="700" border="1" align="center" cellpadding="0" cellspacing="1" >


  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> 工作状态 </div></td>
    <td width="200">&nbsp;
            <c:forEach var="coderef" items="${workstatuslist}">
            <c:choose>
                <c:when test="${coderef.codeId == worknote.workstateID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
            </c:forEach>
    </td>
    <td width="100">&nbsp;工作日期</td>
    <td >&nbsp;<c:out value="${year}"/>年<c:out value="${month}"/>月<c:out value="${day}"/>日</td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> 计划完成情况</div></td>
    <td colspan="3" width="570"><textarea name="todayaim" cols="80" rows="6" readonly><c:out value="${worknote.todayAim}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> 计划外任务完成情况</div></td>
    <td colspan="3"><textarea name="todayaim" cols="80" rows="6" readonly><c:out value="${worknote.outPlan}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> 存在的问题</div></td>
    <td colspan="3"><textarea name="todayaim" cols="80" rows="4" readonly><c:out value="${worknote.helping}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> 明日计划</div></td>
    <td colspan="3"><textarea name="todayaim" cols="80" rows="6" readonly><c:out value="${worknote.tomorrowPlan}"/></textarea>
    </td>
  </tr>
</table>
<center>
<br>
    <c:choose>
        <c:when test="${worknote.resultID == 0}">
            &nbsp;
        </c:when>
        <c:otherwise>
            <input type="button" name="Submit" value="修改" onClick="javascript:location.href='worknoteupdate.jsp?worknoteid=<c:out value="${worknote.pk_worknoteID}" />'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </c:otherwise>
    </c:choose>

    <input type="button" value="返回" onClick='history.go(-1)'>
</center>
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
