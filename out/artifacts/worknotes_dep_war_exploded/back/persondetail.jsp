<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/admin.inc" %>

<%@ page import="com.source11.worknotes.business.PersonBD,
                 com.source11.worknotes.domain.Person,
                 com.source11.worknotes.domain.CodeRef"%>

<c:set var="person"value="<%=PersonBD.getDetalByPID(Integer.parseInt(request.getParameter("person_id")))%>" scope="page"/>
<c:set var="sexList" value="<%=CodeRef.getListByType((short)2100)%>" scope="page"/>
<c:set var="typeList" value="<%=CodeRef.getListByType((short)2200)%>" scope="page"/>
<c:set var="statusList" value="<%=CodeRef.getListByType((short)2300)%>" scope="page"/>
<c:set var="positionList" value="<%=CodeRef.getListByType((short)2400)%>" scope="page"/>
<c:set var="personList" value="<%=PersonBD.getAllPerson()%>" scope="page"/>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��Ա������Ϣ</title>

<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>
<div align="center">
  <p>��Ա��Ϣ����</p>
  <br><br>
  <table width="500" border="1" cellpadding="0" cellspacing="1">
    <tr align="left">
      <td width="130" height="25" bgcolor="#7ba2e7"><div align="left">�ڲ���� </div></td>
      <td width="450" align="left">&nbsp;<c:out value="${person.pk_personID}" /></td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">����ƴд </div></td>
      <td height="10" align="left">&nbsp;<c:out value="${person.nameSpell}" /></td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">�� �� </div></td>
      <td height="20" align="left">&nbsp;<c:out value="${person.personName}" /></td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">�� ��</div></td>
      <td height="20" align="left">&nbsp;<c:out value="${person.workID}" /></td>
    </tr>
	    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">��������</div></td>
      <td height="20" align="left">&nbsp;
      <c:forEach var="person_pr" items="${personList}">
            <c:choose>
                <c:when test="${person_pr.pk_personID == person.fk_presidentID}">
                ${person_pr.personName}
                </c:when>
            </c:choose>
      </c:forEach>
    </td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">��Ա���� </div></td>
      <td height="10" align="left">&nbsp;
      <c:forEach var="coderef" items="${typeList}">
            <c:choose>
                <c:when test="${coderef.codeId == person.personTypeID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
      </c:forEach>
</td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">ְ λ </div></td>
      <td height="10" align="left">&nbsp;
      <c:forEach var="coderef" items="${positionList}">
            <c:choose>
                <c:when test="${coderef.codeId == person.positionID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
      </c:forEach>
    </td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">�� �� </div></td>
      <td height="10" align="left">&nbsp;<c:out value="${person.birthday}" /></td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">�� �� </div></td>
      <td height="15" align="left">&nbsp;
      <c:forEach var="coderef" items="${sexList}">
            <c:choose>
                <c:when test="${coderef.codeId == person.sexID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
      </c:forEach>
    </td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">�绰һ</div></td>
      <td height="10" align="left">&nbsp;<c:out value="${person.phone1}" /></td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">�绰��</div></td>
      <td height="10" align="left">&nbsp;<c:out value="${person.phone2}" /></td>
    </tr>
    <tr align="left">
      <td height="25" bgcolor="#7ba2e7"> <div align="left">����״̬ </div></td>
      <td height="10" align="left">&nbsp;
      <c:forEach var="coderef" items="${statusList}">
            <c:choose>
                <c:when test="${coderef.codeId == person.workStatusID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
      </c:forEach>
      </td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7" > <div align="left">�� ע</div></td>
      <td align="left">&nbsp;<textarea name="memo" cols="55" rows="4" readonly><c:out value="${person.memo}" />
      </textarea></td>
    </tr>
  </table>
  <p><input type="button" value="�޸�" onClick='jumpto("personupdate.jsp?person_id=<c:out value="${person.pk_personID}" />")'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="����" onClick='jumpto("personlist.jsp")'>
</p>
</div>
</body>
</html>
