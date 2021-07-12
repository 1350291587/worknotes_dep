<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>系统登录</title>
<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="js/common.js"></script>
</head>

<body>
<div align="center">
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <table width="300" height="150" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" valign="top" bgcolor="#CCCCCC"><table width="300" height="150" border="0" cellpadding="0" cellspacing="1">
        <tr>
          <td align="center" valign="middle" bgcolor="#FFFFFF">
		  <form name="login" method="post" action="/accountctl?command=Logon" onSubmit="return formCheck();" >
            <table width="200" height="100" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td colspan="2">&nbsp;</td>
                </tr>
              <tr>
                <td width="68" align="right">用户名：</td>
                <td width="132"><input name="user_name" type="text" size="12"></td>
              </tr>
              <tr>
                <td colspan="2">&nbsp;</td>
                </tr>
              <tr>
                <td align="right">密码：</td>
                <td><input name="pass_word" type="password" size="12"></td>
              </tr>
              <tr>
                <td colspan="2">&nbsp;</td>
                </tr>
              <tr align="center">
                <td colspan="2"><select name="Select" size="1">
                  <option value="front/frontindex.jsp" selected>日志管理</option>
                  <option value="back/backindex.jsp">系统维护</option>
                </select>&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                </tr>
              <tr>
                <td align="center" colspan="2">
                <input type="submit" name="submit" value="登陆"> </td>
              </tr>
            </table>
            </form>
			</td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>
<hr>

<c:choose>
    <c:when test="${empty requestScope.errmsg}">
        <p>Welcome Member !</p>
    </c:when>
    <c:otherwise>
        <span class="style1"><c:out value="${requestScope.errmsg}" /></span>
    </c:otherwise>
</c:choose>

</body>
</html>
