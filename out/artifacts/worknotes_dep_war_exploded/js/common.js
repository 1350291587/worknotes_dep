function jumpto(pagename) {
	window.navigate(pagename);
}

function formCheck() {
    if (document.login.user_name.value == "") /**�ж��Ƿ���д������*/
    {
        alert("�������¼�˺� !");/**������ʾ����*/
        return false;
    }

    if ( document.login.pass_word.value=="") /**�ж��Ƿ���д����*/
    {
        alert("�������¼���� !");
        return false;
    }

}

function pwdCheck(){
    if (document.changepw.passwd1.value == "")
    {
        alert("���벻��Ϊ�� !");
        return false;
    }

    if (document.changepw.passwd1.value != document.changepw.passwd2.value)
    {
        alert("������������벻�� !");
        return false;
    }
}