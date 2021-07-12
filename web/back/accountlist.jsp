<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/admin.inc" %>

<%@ page import="com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.business.AccountBD,
                 com.source11.worknotes.business.PersonBD"%>

<c:set var="accountList" value="<%=AccountBD.getAllAccount()%>" />
<c:set var="personList" value="<%=PersonBD.getAllPerson() %>" />
<c:set var="roleList" value="<%=CodeRef.getListByType((short)3100)%>" scope="page"/>
<c:set var="workstatusList" value="<%=CodeRef.getListByType((short)3200)%>" scope="page"/>
<c:set var="length" value="<%=AccountBD.getAllAccount().size()%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��̨ϵͳ�û��ʺ�</title>

<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>
<div align="center">
  <p>ϵͳ�û��ʺ�һ��
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  ��<c:out value="${length}"/>��
  </p>
   <p><a href="/back/accountadd.jsp">����µ��˺�</a></p>
  <table width="600" border="1" cellpadding="0" cellspacing="1" >
    <tr>
      <td bgcolor="#7ba2e7" ><div align="center"><strong>�ʺ�</strong></div></td>
      <td bgcolor="#7ba2e7" ><div align="center"><strong>�� ��</strong></div></td>
      <td bgcolor="#7ba2e7" ><div align="center"><strong>�������</strong></div></td>
      <td bgcolor="#7ba2e7" ><div align="center"><strong>����״̬</strong></div></td>
      <td bgcolor="#7ba2e7" >&nbsp;</td>
    </tr>

    <c:forEach items="${accountList}" var="account">
        <tr>
            <td align="center"><c:out value="${account.pk_userid}" /></td>
            <td align="center"><c:out value="${person.personName}" />
            <c:forEach var="person" items="${personList}">
            <c:choose>
                <c:when test="${person.pk_personID == account.fk_personID}">
                ${person.personName} - ${person.workID}
                </c:when>
            </c:choose>
            </c:forEach>
            </td>
            <td align="center">
            <c:forEach var="coderef" items="${roleList}">
            <c:choose>
                <c:when test="${coderef.codeId == account.fk_role}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
            </c:forEach>
            </td>
            <td align="center">
            <c:forEach var="coderef" items="${workstatusList}">
            <c:choose>
                <c:when test="${coderef.codeId == account.workstatus}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
            </c:forEach>
            </td>
            <td><div align="center"><a href="/back/accountupdate.jsp?account_id=<c:out value="${account.pk_accountID}"/>">�鿴</a></div></td>
        </tr>
    </c:forEach>

  </table>

</div>
</body>
</html>
