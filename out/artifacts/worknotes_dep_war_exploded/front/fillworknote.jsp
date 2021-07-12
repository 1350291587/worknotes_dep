<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/recorder.inc" %>

<%@ page import="com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.domain.Tokey"%>

<%
    String now=((Tokey)session.getAttribute("tokey")).getCreateDate();
%>
<c:set var="workstatuslist" value="<%=CodeRef.getListByType((short)1100)%>" scope="page"/>
<c:set var="year" value="<%=now.substring(0,4)%>" scope="page"/>
<c:set var="month" value="<%=now.substring(5,7)%>" scope="page"/>
<c:set var="day" value="<%=now.substring(8,10)%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>¼�빤����־</title>

<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>
<br>
<p>��־¼��</p>
<br>
<br>
<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${tokey.username}"/> &nbsp;&nbsp;��¼ʱ�� <c:out value="${tokey.createDate}"/> </p>
<form name="fill_worknote" action="/worknotectl?command=Create" method="post">
<table width="700" border="1" align="center" cellpadding="0" cellspacing="1">


  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> ����״̬ </div></td>
    <td >&nbsp;<select name="working">
            <c:forEach var="coderef" items="${workstatuslist}">
            <option value="${coderef.codeId}" >${coderef.codeShow}</option>
            </c:forEach>
        </select>

    </td>
    <td width="100">&nbsp;��������</td>
    <td >&nbsp;<select name="_year">
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
    </select>��<select name="_month">
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
      ��
      <select name="_day">
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
      ��</td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> �ƻ�������</div></td>
    <td colspan="3" width="570">    <textarea name="todayaim" cols="80" rows="6">1.
2.
3.
4.
5.
6.</textarea></td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> �ƻ�������������</div></td>
    <td colspan="3"><textarea name="outplan" cols="80" rows="4">1.
2.
3.
4.</textarea>
    &nbsp;</td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> ���ڵ�����</div></td>
    <td colspan="3"><textarea name="helping" cols="80" rows="4">1.
2.
3.
4.</textarea></td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> ���ռƻ�</div></td>
    <td colspan="3"><textarea name="tomorrowplan" cols="80" rows="6">1.
2.
3.
4.
5.
6.</textarea></td>
  </tr>
</table>
<p align="center">
  <input type="hidden" name="fk_personID" value="<c:out value="${tokey.personid}"/>" >
  <input type="hidden" name="FK_inspectorPID" value="<c:out value="${tokey.fk_inspectorPID}"/>" >
  <input type="hidden" name="resultID" value="1">
  <input type="submit" name="Submit" value="�ύ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" name="reset" value="����">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" value="����" onClick='jumpto("/front/leftfront.jsp")'>
</p>
</form>
</body>
</html>
