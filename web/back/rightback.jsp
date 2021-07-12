<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/admin.inc" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>系统维护</title>
<style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
.STYLE1 {color: #7ba2e7}
-->
</style>
<head>
<script language="javascript" src="/js/common.js"></script>
<link href="/css/menuxp.css" rel="stylesheet" type="text/css">
<link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="197" border="0" align="left" cellpadding="5" cellspacing="0">
  <tr>
    <td width="183"><table width="177" border="0" cellpadding="0" cellspacing="0" class="menuxplink">
      <tr>
        <td width="183" height="25" background="/images/menuxp/shang1.gif"  >&nbsp;&nbsp;<strong>系统管理员</strong></td>
      </tr>
      <tr >
        <td height="25"><table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8">
              <td width="18" height="25">&nbsp;</td>
              <td width="165"  class="menuxp2ji2">&nbsp;
                <div align="left"><a href="/back/personlist.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; 用户的基本信息</a></div></td>
            </tr>
        </table></td>
      </tr>
      <tr  >
        <td ><table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8">
              <td width="18" height="25">&nbsp;</td>
              <td width="165" class="menuxp2ji2">&nbsp;
                <div align="left"><a href="/back/accountlist.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; 系统用户账号</a></div></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="183" border="0" cellpadding="0" cellspacing="0" >
      <tr>
        <td width="183" height="25" background="/images/menuxp/shang1.gif" class="menuxplink">&nbsp;&nbsp;<strong>个人面板</strong></td>
      </tr>

        <td height="25" ><table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8" >
              <td width="18" height="25">&nbsp;</td>
             <td width="169" class="menuxp2ji2">&nbsp;
               <div align="left"><a href="/back/changepw.jsp" target="mainFrame"><span class="STYLE1">&nbsp;&nbsp;&nbsp; 修改密码</span></a></div></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>

    <tr>
    <td><div align="center"><a href="/accountctl?command=Logout" target="_top">退出系统</a></div></td>

  </tr>
   <tr>
  <td height="300" align="center">&nbsp; </td>
  </tr>
  <tr>
    <td align="center">
    <c:out value="${errmsg}" />
    </td>
  </tr>
  <tr>
    <td>
    <c:out value="${loginTime}" />
    </td>
  </tr>
</table>
</td>
  </tr>
 </table>
</body>
</html>
