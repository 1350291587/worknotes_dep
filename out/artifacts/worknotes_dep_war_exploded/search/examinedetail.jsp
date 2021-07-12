<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/review.inc" %>

<%@ page import="java.util.List,
                 com.source11.worknotes.business.WorknoteBD,
                 com.source11.worknotes.domain.Worknote,
                 com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.business.PersonBD,
                 com.source11.worknotes.business.SearchDate"%>

<%
    String wid = request.getParameter("worknoteid");
    int nwid = Integer.parseInt(wid);
    Worknote worknote = WorknoteBD.getWorknoteByWID(nwid);
    SearchDate searchdate= new SearchDate(worknote);
%>

<c:set var="worknote" value="<%=WorknoteBD.getWorknoteByWID(nwid)%>" />
<c:set var="workstatuslist" value="<%=CodeRef.getListByType((short)1100)%>" scope="page"/>
<c:set var="year" value="<%=searchdate.getThisWNYear()%>" scope="page"/>
<c:set var="month" value="<%=searchdate.getThisWNMonth()%>" scope="page"/>
<c:set var="day" value="<%=searchdate.getThisWNDay()%>" scope="page"/>
<c:set var="personlist" value="<%=PersonBD.getAllPerson()%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��˹�����־</title>
<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>
<p align="center"><c:forEach var="person" items="${personlist}">
                    <c:choose>
                        <c:when test="${person.pk_personID == worknote.fk_personID}">${person.personName}</c:when>
                    </c:choose>
                </c:forEach>&nbsp;&nbsp;&nbsp;&nbsp;
������־����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
����ʱ�䣺<c:out value="${worknote.updateTime}"/></p>

<form name="fill_worknote" action="/worknotectl?command=Review" method="post">
<table width="700" border="1" align="center" cellpadding="0" cellspacing="1">


  <tr>
    <td width="130" bgcolor="#7ba2e7"><div align="center"> ����״̬ </div></td>
    <td width="200">&nbsp;
            <c:forEach var="coderef" items="${workstatuslist}">
            <c:choose>
                <c:when test="${coderef.codeId == worknote.workstateID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
            </c:forEach>
    </td>
    <td width="100">&nbsp;��������</td>
    <td >&nbsp;<c:out value="${year}"/>��<c:out value="${month}"/>��<c:out value="${day}"/>��</td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7" align="center" >�ƻ�������</td>
    <td colspan="3" width="570"><textarea name="todayaim" cols="80" rows="6" readonly><c:out value="${worknote.todayAim}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7" align="center" >�ƻ�������������</td>
    <td colspan="3"><textarea name="outplan" cols="80" rows="4" readonly><c:out value="${worknote.outPlan}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7"  align="center">���ڵ�����</td>
    <td colspan="3"><textarea name="helping" cols="80" rows="4" readonly><c:out value="${worknote.helping}"/></textarea>
    </td>
  </tr>
  <tr>
    <td width="130" bgcolor="#7ba2e7" align="center" >���ռƻ�</td>
    <td colspan="3"><textarea name="tomorrowplan" cols="80" rows="6" readonly><c:out value="${worknote.tomorrowPlan}"/></textarea>
    </td>
  </tr>
  <tr>
      <td align="center" bgcolor="#7ba2e7">���<br>
	  <td  colspan="3"><textarea name="comment" cols="80" rows="3"><c:out value="${worknote.comment}"/></textarea></td>
    </tr>
<tr> 
		<td bgcolor="#7ba2e7" align="center" >����</td>
	  <td colspan="3" align="left">&nbsp;
	<input type="radio" name="resultID" value="-1" checked>
	����
	<input type="radio" name="resultID" value="0" >ͨ��	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
	��ˣ� <c:out value="${tokey.username}"/>	</td>
	</tr>	
</table>
<p align="center">
  <input type="hidden" name="worknoteid" value="<c:out value="${worknote.pk_worknoteID}"/>" >
  <input type="hidden" name="working" value="<c:out value="${worknote.workstateID}"/>" >
  <input type="hidden" name="fk_personID" value="<c:out value="${worknote.fk_personID}"/>" >
  <input type="hidden" name="workDate" value="<c:out value="${worknote.workDate}"/>" >
  <input type="hidden" name="FK_inspectorPID" value="<c:out value="${worknote.FK_inspectorPID}"/>">
  <input type="hidden" name="will1" value="<c:out value="${worknote.will1}"/>">
  <input type="hidden" name="will2" value="<c:out value="${worknote.will2}"/>">

  <input type="submit" name="Submit" value="�ύ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;<input type="button" value="����" onClick='history.go(-1)'>
</p>
</form>
<p align="center">&nbsp;</p>
</body>
</html>
