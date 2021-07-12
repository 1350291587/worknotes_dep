function jumpto(pagename) {
	window.navigate(pagename);
}

function formCheck() {
    if (document.login.user_name.value == "") /**判断是否填写了姓名*/
    {
        alert("请输入登录账号 !");/**弹出提示窗口*/
        return false;
    }

    if ( document.login.pass_word.value=="") /**判断是否填写密码*/
    {
        alert("请输入登录口令 !");
        return false;
    }

}

function pwdCheck(){
    if (document.changepw.passwd1.value == "")
    {
        alert("密码不能为空 !");
        return false;
    }

    if (document.changepw.passwd1.value != document.changepw.passwd2.value)
    {
        alert("两次输入的密码不符 !");
        return false;
    }
}