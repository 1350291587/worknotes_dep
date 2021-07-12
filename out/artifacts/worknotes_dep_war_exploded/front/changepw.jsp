<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/business.inc" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改密码</title>
<link href="/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="/js/common.js"></script>
</head>

<body>
<div align="center">
  <p>密码修改</p>
  <br><br><br>

  <form name="changepw" action="/accountctl?command=ChangePwd" method="post" onSubmit="return pwdCheck();">
  <table width="380" border="1" cellpadding="0" cellspacing="1">
    <tr align="left">
      <td width="100" bgcolor="#7ba2e7">密码</td>
      <td width="250"><input name="passwd1" type="password" size="40" maxlength="40"></td>
    </tr>
    <tr align="left">
      <td bgcolor="#7ba2e7"><div align="left">重复密码</div></td>
      <td><div align="left">
        <input name="passwd2" type="password" size="40" maxlength="40">
      </div></td>
    </tr>
  </table>
  <p>
    <input type="submit" name="Submit" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" name="comeback" value="返回" onClick="javascript:location.href='/front/leftfront.jsp'" >
  </p>
</form>
</div>
<hr>
<br>
 密码修改完毕 !
</body>
</html>
