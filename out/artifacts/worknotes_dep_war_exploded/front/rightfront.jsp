<%@ page contentType="text/html; charset=gbk" language="java"%>

<%@include  file="/inc/jstlinclude.inc" %>
<%@include  file="/inc/business.inc" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>日志管理系统</title>
<style type="text/css">
<!--
.STYLE3 {color: 7ba2e7}
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
        <td width="183" height="25" background="/images/menuxp/shang1.gif"  ><strong>录入管理系统</strong></td>
      </tr>
      <tr >
        <td height="25"><div align="left">
          <table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8">
              <td width="18" height="25">&nbsp;</td>
                  <td width="165"  class="menuxp2ji2">&nbsp;
                  <div align="left"><a href="/front/leftfront.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; 工作空间</a></div></td>
                </tr>
          </table>
        </div></td>
      </tr>
      <tr  >
        <td ><div align="left">
          <table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8">
              <td width="18" height="25">&nbsp;</td>
                  <td width="165" class="menuxp2ji2">&nbsp;
                  <div align="left"><a href="/front/fillworknote.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; 日志录入</a></div></td>
                </tr>
          </table>
        </div></td>
      </tr>
      <tr  >
        <td ><div align="left">
          <table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8">
              <td width="18" height="25">&nbsp;</td>
                  <td width="165" class="menuxp2ji2">&nbsp;
                  <div align="left"><a href="/front/searchworknote.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; 日志查询</a></div></td>
                </tr>
          </table>
        </div></td>
      </tr>
      <tr  >
        <td ><div align="left">
          <table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8">
              <td width="18" height="25">&nbsp;</td>
                  <td width="165" class="menuxp2ji2">&nbsp;
                  <div align="left"><a href="/search/searchlist.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; 日志检索</a></div></td>
                </tr>
          </table>
        </div></td>
      </tr>
      <tr  >
        <td ><div align="left">
          <table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8">
              <td width="18" height="25">&nbsp;</td>
                  <td width="165" class="menuxp2ji2">&nbsp;
                  <div align="left"><a href="/search/examinelist.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; 日志审核</a></div></td>
                </tr>
          </table>
        </div></td>
      </tr>
      <tr  >
        <td ><div align="left">
          <table width="183" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D7DEF8">
              <td width="18" height="25">&nbsp;</td>
                  <td width="165" class="menuxp2ji2">&nbsp;
                  <div align="left"><a href="/front/changepw.jsp" target="mainFrame">&nbsp;&nbsp;&nbsp; 密码修改</a></div></td>
                </tr>
          </table>
        </div></td>
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
