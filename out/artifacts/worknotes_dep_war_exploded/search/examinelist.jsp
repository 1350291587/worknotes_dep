<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/review.inc" %>

<%@ page import="java.util.List,
                 com.source11.worknotes.business.WorknoteBD,
                 com.source11.worknotes.domain.Tokey,
                 com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.business.PersonBD"%>

<%
    List worknoteList=WorknoteBD.getNotCloseListByInspectorPID(((Tokey)session.
            getAttribute("tokey")).getPersonid());
%>

<c:set var="worknoteList" value="<%=worknoteList%>" />
<c:set var="resultlist" value="<%=CodeRef.getListByType((short)1300)%>" scope="page"/>
<c:set var="personlist" value="<%=PersonBD.getAllPerson()%>" scope="page"/>
<c:set var="length" value="<%=worknoteList.size()%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>审核工作日志</title>


<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>

</head>

<body>
<div align="center">
  <p>待审核工作日志一览表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有 <c:out value="${length}"/>记录 </p>
  <br>

  <br>
  <table width="700" border="1" cellpadding="0" cellspacing="1">
    <tr>
      <td width="135" bgcolor="#7ba2e7"><div align="center"><strong>ID</strong></div></td>
      <td width="182" bgcolor="#7ba2e7"><div align="center"><strong>日志日期</strong></div></td>
      <td width="182" bgcolor="#7ba2e7"><div align="center"><strong>姓名</strong></div></td>
      <td width="156" bgcolor="#7ba2e7"><div align="center"><strong>状态</strong></div></td>
      <td width="182" bgcolor="#7ba2e7"> <div align="center"><strong>修改日期 </strong></div></td>
      <td width="112" bgcolor="#7ba2e7"><div align="center"><strong>&nbsp;</strong></div></td>
    </tr>
        <c:forEach items="${worknoteList}" var="worknote">
            <tr>
                <td align="center"><c:out value="${worknote.pk_worknoteID}" /></td>
                <td align="center"><c:out value="${worknote.workDate}" /></td>
                <td align="center">
                <c:forEach var="person" items="${personlist}">
                    <c:choose>
                        <c:when test="${person.pk_personID == worknote.fk_personID}">${person.personName}</c:when>
                    </c:choose>
                </c:forEach>
                </td>
                <td align="center">
                <c:forEach var="coderef" items="${resultlist}">
                    <c:choose>
                        <c:when test="${coderef.codeId == worknote.resultID}">${coderef.codeShow}</c:when>
                    </c:choose>
                </c:forEach>
                </td>
                <td align="center"><c:out value="${worknote.updateTime}" /></td>

                <td width="259" align="center"><a href='/search/examinedetail.jsp?worknoteid=<c:out value="${worknote.pk_worknoteID}" />'>审核</a></td>
            </tr>
        </c:forEach>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;  </p>
</div>
</body>
</html>
