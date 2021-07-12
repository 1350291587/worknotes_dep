<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/admin.inc" %>

<%@ page import="com.source11.worknotes.business.PersonBD,
                 com.source11.worknotes.domain.CodeRef"%>

<c:set var="personList" value="<%=PersonBD.getAllPerson()%>" />

<c:set var="sexList" value="<%=CodeRef.getListByType((short)2100)%>" scope="page"/>
<c:set var="typeList" value="<%=CodeRef.getListByType((short)2200)%>" scope="page"/>
<c:set var="statusList" value="<%=CodeRef.getListByType((short)2300)%>" scope="page"/>
<c:set var="positionList" value="<%=CodeRef.getListByType((short)2400)%>" scope="page"/>

<c:set var="length" value="<%=PersonBD.getAllPerson().size()%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��̨ϵͳ�û��ʺ�</title>

<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>
<div align="center">
  <p>��Ա������Ϣһ����
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  ��<c:out value="${length}"/>��
</p>

    <p><a href="/back/personadd.jsp">�����Ա������Ϣ</a></p>
  <table width="600" border="1" cellpadding="0" cellspacing="1" >
    <tr>
      <td bgcolor="#7ba2e7"><div align="center"><strong>�� ��</strong></div></td>
      <td bgcolor="#7ba2e7"><div align="center"><strong>�� ��</strong></div></td>
      <td bgcolor="#7ba2e7"><div align="center"><strong>ְ λ</strong></div></td>
      <td bgcolor="#7ba2e7"><div align="center"><strong>��Ա����</strong></div></td>
      <td bgcolor="#7ba2e7"><div align="center"><strong>״̬</strong></div></td>
      <td bgcolor="#7ba2e7">&nbsp;</td>
    </tr>

    <c:forEach items="${personList}" var="person">

        <tr>
            <td align="center"><c:out value="${person.workID}" /></td>
            <td align="center"><c:out value="${person.personName}" /></td>
            <td align="center">
            <c:forEach var="coderef" items="${positionList}">
            <c:choose>
                <c:when test="${coderef.codeId == person.positionID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
            </c:forEach>

            </td>
            <td align="center">
            <c:forEach var="coderef" items="${typeList}">
            <c:choose>
                <c:when test="${coderef.codeId == person.personTypeID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
            </c:forEach>
            </td>

            <td align="center">
            <c:forEach var="coderef" items="${statusList}">
            <c:choose>
                <c:when test="${coderef.codeId == person.workStatusID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
            </c:forEach>
            </td>
            <td><div align="center"><a href="/back/persondetail.jsp?person_id=<c:out value="${person.pk_personID}"/>">�鿴</a></div></td>
        </tr>
    </c:forEach>

  </table>

</div>
</body>
</html>
