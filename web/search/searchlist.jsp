<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/business.inc" %>

<%@ page import="java.util.List,
                 com.source11.worknotes.business.SearchQueryWN,
                 com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.business.PersonBD"%>

<%
    SearchQueryWN searchQuery=new SearchQueryWN();
    searchQuery.setRequest(request);
%>

<c:set var="resultlist" value="<%=CodeRef.getListByType((short)1300)%>" scope="page"/>
<c:set var="personlist" value="<%=PersonBD.getAllPerson()%>" scope="page"/>

<c:set var="length" value="<%=searchQuery.getResultWorknoteList().size()%>" scope="page"/>
<c:set var="worknoteList" value="<%=searchQuery.getResultWorknoteList()%>" />
<c:set var="year_from" value="<%=searchQuery.getYear_from()%>" />
<c:set var="month_from" value="<%=searchQuery.getMonth_from()%>" />
<c:set var="day_from" value="<%=searchQuery.getDay_from()%>" />
<c:set var="year_to" value="<%=searchQuery.getYear_to()%>" />
<c:set var="month_to" value="<%=searchQuery.getMonth_to()%>" />
<c:set var="day_to" value="<%=searchQuery.getDay_to()%>" />

<c:set var="person_id" value="<%=searchQuery.getPersonID()%>" />
<c:set var="result_id" value="<%=searchQuery.getResultID()%>" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��ѯ������־</title>


<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>

</head>

<body>
<div align="center">
  <p>������־��ѯ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���� <c:out value="${length}"/>��¼ </p>
  <br>
  <form name="search" action="/search/searchlist.jsp" method="post">
  <table width="700" border="0" cellpadding="0" cellspacing="1">
    <tr>
      <td>
      <select name="year_from" >
      <c:forEach begin="2006" end="2025" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${year_from == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>��
    <select name="month_from" >
        <c:forEach begin="1" end="12" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${month_from == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>��
    <select name="day_from" >
        <c:forEach begin="1" end="31" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${day_from == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>�� --
    <select name="year_to" >
      <c:forEach begin="2006" end="2025" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${year_to == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>��
    <select name="month_to" >
        <c:forEach begin="1" end="12" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${month_to == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>��
    <select name="day_to" >
        <c:forEach begin="1" end="31" var="indicator">
            <option value="${indicator}"
            <c:choose>
                <c:when test="${day_to == indicator}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            >${indicator}</option>
        </c:forEach>
    </select>��&nbsp;

        <select name="person_id">
          <option value="-99" >ȫ����Ա</option>
          <c:forEach var="person" items="${personlist}">
            <option value="${person.pk_personID}"
            <c:choose>
                <c:when test="${person_id == person.pk_personID}">
                selected
                </c:when>
            <c:otherwise>
                &nbsp;
            </c:otherwise>
            </c:choose>
            > ${person.personName}</option>
          </c:forEach>
        </select>
        <select name="result_id">
            <option value="-99" >ȫ��״̬</option>
            <c:forEach var="coderef" items="${resultlist}" >
                <option value="${coderef.codeId}"
                <c:choose>
                    <c:when test="${result_id == coderef.codeId}">
                        selected
                    </c:when>
                    <c:otherwise>
                        &nbsp;
                     </c:otherwise>
                </c:choose>
                > ${coderef.codeShow}</option>
            </c:forEach>
        </select>
        &nbsp;
      <input type="submit" name="Submit" value="����" ></td>
    </tr>
  </table>
  </form>
  <hr>
  <br>
  <table width="700" border="1" cellpadding="0" cellspacing="1">
    <tr>
      <td width="269" bgcolor="#7ba2e7"><div align="center"><strong>NO.</strong></div></td>
      <td width="269" bgcolor="#7ba2e7"><div align="center"><strong>�� ��</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center"><strong>��������</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center"><strong>����ʱ��</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center"><strong>״̬</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center"><strong>�鿴</strong></div></td>
    </tr>
        <c:forEach items="${worknoteList}" var="worknote">
            <tr>
                <td align="center"><c:out value="${worknote.pk_worknoteID}" /></td>
                <td align="center">
                <c:forEach var="person" items="${personlist}">
                    <c:choose>
                        <c:when test="${person.pk_personID == worknote.fk_personID}">${person.personName}</c:when>
                    </c:choose>
                </c:forEach>
                </td>
                <td align="center"><c:out value="${worknote.workDate}" /></td>
                <td align="center"><c:out value="${worknote.updateTime}" /></td>
                <td align="center">
                <c:forEach var="coderef" items="${resultlist}">
                    <c:choose>
                        <c:when test="${coderef.codeId == worknote.resultID}">${coderef.codeShow}</c:when>
                    </c:choose>
                </c:forEach>
                </td>
                <td width="259" align="center"><a href='/search/worknotedetail.jsp?worknoteid=<c:out value="${worknote.pk_worknoteID}" />'>����</a></td>
            </tr>
        </c:forEach>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;  </p>
</div>
</body>
</html>
