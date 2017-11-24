<%@page import="com.asisinfo.staff.WebConstant"%>
<%@page language="java" contentType="text/html; charset=GBK"%>
<%@page import="java.util.ResourceBundle"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/reset.css" />
    <link rel="stylesheet" type="text/css" href="css/main.css" />
    
    <script type="text/javascript" src="js/jquery-1.9.0.js"></script>
    <script type="text/javascript" src="js/string-util.js"></script>
</head>
<style>
    html, html body{
        overflow: hidden
    }
</style>
<body class="login_content" >
<%
	Cookie cookie = new Cookie("iPlanetDirectoryPro","AQIC5wM2LY4Sfcy7UB5CvbckB7TqgDF22YB3Mad+9Vclp+k=@AAJTSQACMDU=#");
	response.addCookie(cookie);
 %>
<div>
    <div class="login_top">
        <div class="login-logo-position" >
             <div class="login-logo"></div>
        </div>
    </div>
    
<!--     �����ڱ��ز��� -->
<form id="loginForm" action="<%=request.getContextPath() %>/index/login.do" onsubmit="javascript:checkForm();" method="post">	
    <div style="padding-top:0px; margin:40px auto 0; width:305px;">
        <dl class="login_formTable clearfix">
            <dd>
                <i class="icon-club ico_login_user"></i>
                   <input id="svrnum" name="svrnum" type="text" size="60" maxlength="40" class="" style="width:246px;"onfocus="javascript:if(this.value=='Ա���˺�'){this.value='';this.className='white'}" onblur="javascript:if(this.value==''){this.value='Ա���˺�';this.className=''}" value="Ա���˺�">
            </dd>
            
            <dd>
                <a href="javascript:login()" class="login_btn_blue"></a>
            </dd>
        </dl>
    </div>
</form>

<!-- ���ڵ����¼ -->
<!-- <form id="loginForm" action="<%=request.getContextPath() %>/index/login.do" onsubmit="javascript:checkForm();" method="post">	 -->
<!--     <div style="padding-top:0px; margin:40px auto 0; width:305px;"> -->
<!--         <dl class="login_formTable clearfix"> -->
<!--             <dd> -->
<!--                 <i class="icon-club ico_login_user"></i> -->
<!--                    <input id="staffid" name="staffid" type="text" size="60" maxlength="40" class="" style="width:246px;"onfocus="javascript:if(this.value=='Ա���˺�'){this.value='';this.className='white'}" onblur="javascript:if(this.value==''){this.value='Ա���˺�';this.className=''}" value="Ա���˺�"> -->
<!--             </dd> -->
<!--              <dd> -->
<!--                 <i class="icon-club ico_login_password"></i> -->
<!-- 				<input type="text"  value="��&nbsp;&nbsp;��" id="tx" style="width:246px;"/> -->
<!--                	<input type="password" id="password" name="password" size="60" maxlength="30" style="width:246px;display: none" value=""> -->
<!--             </dd> -->
<!--             <dd> -->
<!--                 <a href="javascript:login()" class="login_btn_blue"></a> -->
<!--             </dd> -->
<!--         </dl> -->
<!--     </div> -->
<!-- </form> -->

</div>
<input type="hidden" id="staffname" name="staffname" />
</div>

<script type="text/javascript">

jQuery.fn.inputChange = function(callback){
    this.bind("propertychange", function(e){
        if(e.originalEvent.propertyName == "value"){
            $(this).keyup();
        }
    });
    this.bind("keyup",callback);
    return( this );
};
$('#tx').focus(function(){
    var tx=$('#tx');var password=$('#password');
    tx.hide();
    password.show();
    password.addClass('white');
    password.value = "";
    password.focus();
});
$('#password').blur(function(){
    var password=$('#password'); var tx=$('#tx');
    if(password.val()!== "") return;
    password.hide().removeClass('white');
    tx.show();
    tx.val('��  ��');
});
$('#password').inputChange(function(){
    var $this = $(this);
    if($this.val() !== '') {
        $this.removeClass('white');
    }
    else {
        $this.addClass('white');
    }
});
$('#staffid').inputChange(function(){
    var $this = $(this);
    if($this.val() !== '') {
        $this.removeClass('white');
    }
    else {
        $this.addClass('white');
    }
});

$('#svrnum').inputChange(function(){
    var $this = $(this);
    if($this.val() !== '') {
        $this.removeClass('white');
    }
    else {
        $this.addClass('white');
    }
});

function checkForm(){
	//var staffid = $("#staffid").val();
	//var password = $("#password").val();
 	var svrnum = $("#svrnum").val();
	//var loginperm= $("#loginperm").val();
	//if(isNull(staffid) || staffid=="Ա���˺�" || isNull(password) || password=="��&nbsp;&nbsp;��"){
		//return false;
	//}
    if(isNull(svrnum) || svrnum=="Ա���˺�"){
    	alert("Ա���˺Ų���Ϊ�գ�");
		return false;
    }
	return true;
}

function login(){
//��½ʱ�жϵ�ַ  ���ڵ����¼
// 	if(checkForm()){
// 		var params = $("#loginForm").serialize();
// 		$.post("<%=request.getContextPath()%>/index/login.do",params,function(data){
// 			if(data.retFlag){
// 				window.location="<%=request.getContextPath()%>/index/index.do";
// 			}else{
// 				alert(data.msg);
// 				window.location="<%=request.getContextPath()%>/login.jsp";
// 			}
// 		},"json");
// 	}else{
// 		alert("��ӷ��񵼺�������ӽ��е�¼");
// 		window.location="<%=request.getContextPath()%>/login.jsp";
// 	}
	//���ڱ��ز���
	if(checkForm()){
		var params = $("#loginForm").serialize();
		$.post("<%=request.getContextPath()%>/index/login.do",params,function(data){
			if(data.retFlag){
				window.location="<%=request.getContextPath()%>/index/index.do";
			}else{
				alert(data.msg);
				window.location="<%=request.getContextPath()%>/login.jsp";
			}
		},"json");
}

}
window.document.onkeydown=function(evt){
	  evt = window.event || evt;
	   if (evt.keyCode == 13){
		   login();
	   }
	}

</script>
</body>
</html>