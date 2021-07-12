<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/recorder.inc" %>

<%@ page import="com.source11.worknotes.domain.CodeRef,
                 com.source11.worknotes.business.SearchQueryWN"%>

<%
    SearchQueryWN searchQuery= new SearchQueryWN();
    searchQuery.setRequestNoPid(request);

%>

<c:set var="length" value="<%=searchQuery.getResultWorknoteList().size()%>" scope="page"/>
<c:set var="worknoteList" value="<%=searchQuery.getResultWorknoteList()%>" />
<c:set var="year_from" value="<%=searchQuery.getYear_from()%>" />
<c:set var="month_from" value="<%=searchQuery.getMonth_from()%>" />
<c:set var="day_from" value="<%=searchQuery.getDay_from()%>" />
<c:set var="year_to" value="<%=searchQuery.getYear_to()%>" />
<c:set var="month_to" value="<%=searchQuery.getMonth_to()%>" />
<c:set var="day_to" value="<%=searchQuery.getDay_to()%>" />

<c:set var="resultlist" value="<%=CodeRef.getListByType((short)1300)%>" scope="page"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>查询工作日志</title>


<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>

</head>

<body>
<div align="center">
  <p>工作日志查询&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有 <c:out value="${length}"/>记录 </p>
  <br>
  <form name="search" action="searchworknote.jsp" method="post">
  <table width="600" border="0" cellpadding="0" cellspacing="1">
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
    </select>年
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
    </select>月
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
    </select>日 --
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
          </select>年
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
    </select>月
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
    </select>日&nbsp;
      <input type="submit" name="Submit" value="搜索" ></td>
    </tr>
  </table>
  </form>
  <!-- 这儿插入查询结果 -->
<hr>
<br>
 <table width="600" border="1" cellpadding="0" cellspacing="1">
    <tr>
      <td width="269" bgcolor="#7ba2e7"><div align="center"><strong>ID</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center"><strong>工作日期</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center"><strong>录入时间</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center"><strong>当前状态</strong></div></td>
      <td width="322" bgcolor="#7ba2e7"><div align="center">&nbsp;</div></td>
    </tr>
    <c:forEach items="${worknoteList}" var="worknote">

        <tr>
            <td width="236" align="center"><c:out value="${worknote.pk_worknoteID}" /></td>
            <td align="center"><c:out value="${worknote.workDate}" /></td>
            <td align="center"><c:out value="${worknote.updateTime}" /></td>
            <td width="236" align="center">
            <c:forEach var="coderef" items="${resultlist}">
            <c:choose>
                <c:when test="${coderef.codeId == worknote.resultID}">
                ${coderef.codeShow}
                </c:when>
            </c:choose>
            </c:forEach>
            </td>
            <td width="259" align="center"><a href='/front/worknotedetail.jsp?worknoteid=<c:out value="${worknote.pk_worknoteID}" />'>详情</a></td>
        </tr>

    </c:forEach>
  </table>
</div>
</body>
</html>
