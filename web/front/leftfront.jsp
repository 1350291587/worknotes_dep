<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/business.inc" %>

<%@ page import="java.util.List,
                 com.source11.worknotes.business.WorknoteBD,
                 com.source11.worknotes.domain.Tokey,
                 com.source11.worknotes.domain.CodeRef"%>

<%
    Tokey tokey=(Tokey)session.getAttribute("tokey");
    List worknoteList=WorknoteBD.getNotCloseListByReporterPID(tokey.getPersonid());
%>
<c:set var="worknoteList" value="<%=worknoteList%>" />
<c:set var="length" value="<%=worknoteList.size()%>" scope="page"/>
<c:set var="resultlist" value="<%=CodeRef.getListByType((short)1300)%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>日志管理系统</title>

<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>

<div align="center">
<br><br>
  <p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${tokey.username}"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;待处理日志一览表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
共有 <c:out value="${length}"/>记录 </p>
  <table width="600" border="1" cellpadding="0" cellspacing="1">
    <tr>
      <td bgcolor="#7ba2e7"><div align="center"><strong>ID</strong></div></td>
      <td bgcolor="#7ba2e7"><div align="center"><strong>当前状态</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center"><strong>工作日期</strong></div></td>
      <td bgcolor="#7ba2e7"><div align="center"><strong>&nbsp;</strong></div></td>
    </tr>
    <c:forEach items="${worknoteList}" var="worknote">

        <tr>
            <td width="236" align="center"><a href='/front/worknotedetail.jsp?worknoteid=<c:out value="${worknote.pk_worknoteID}" />'><c:out value="${worknote.pk_worknoteID}" /></a></td>
            <td width="236" align="center">
            <c:forEach var="coderef" items="${resultlist}">
                    <c:choose>
                        <c:when test="${coderef.codeId == worknote.resultID}">${coderef.codeShow}</c:when>
                    </c:choose>
                </c:forEach>
            </td>
            <td align="center"><c:out value="${worknote.workDate}" /></td>
            <td width="259" align="center"><a href='/front/worknoteupdate.jsp?worknoteid=<c:out value="${worknote.pk_worknoteID}" />'>修改</a></td>
        </tr>

    </c:forEach>

  </table>



  <p>&nbsp;</p>
</div>
</body>
</html>
