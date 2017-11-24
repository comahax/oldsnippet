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
    
<!--     限制于本地操作 -->
<form id="loginForm" action="<%=request.getContextPath() %>/index/login.do" onsubmit="javascript:checkForm();" method="post">	
    <div style="padding-top:0px; margin:40px auto 0; width:305px;">
        <dl class="login_formTable clearfix">
            <dd>
                <i class="icon-club ico_login_user"></i>
                   <input id="svrnum" name="svrnum" type="text" size="60" maxlength="40" class="" style="width:246px;"onfocus="javascript:if(this.value=='员工账号'){this.value='';this.className='white'}" onblur="javascript:if(this.value==''){this.value='员工账号';this.className=''}" value="员工账号">
            </dd>
            
            <dd>
                <a href="javascript:login()" class="login_btn_blue"></a>
            </dd>
        </dl>
    </div>
</form>

<!-- 用于单点登录 -->
<!-- <form id="loginForm" action="<%=request.getContextPath() %>/index/login.do" onsubmit="javascript:checkForm();" method="post">	 -->
<!--     <div style="padding-top:0px; margin:40px auto 0; width:305px;"> -->
<!--         <dl class="login_formTable clearfix"> -->
<!--             <dd> -->
<!--                 <i class="icon-club ico_login_user"></i> -->
<!--                    <input id="staffid" name="staffid" type="text" size="60" maxlength="40" class="" style="width:246px;"onfocus="javascript:if(this.value=='员工账号'){this.value='';this.className='white'}" onblur="javascript:if(this.value==''){this.value='员工账号';this.className=''}" value="员工账号"> -->
<!--             </dd> -->
<!--              <dd> -->
<!--                 <i class="icon-club ico_login_password"></i> -->
<!-- 				<input type="text"  value="密&nbsp;&nbsp;码" id="tx" style="width:246px;"/> -->
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
    tx.val('密  码');
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
	//if(isNull(staffid) || staffid=="员工账号" || isNull(password) || password=="密&nbsp;&nbsp;码"){
		//return false;
	//}
    if(isNull(svrnum) || svrnum=="员工账号"){
    	alert("员工账号不能为空！");
		return false;
    }
	return true;
}

function login(){
//登陆时判断地址  用于单点登录
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
// 		alert("请从服务导航点击链接进行登录");
// 		window.location="<%=request.getContextPath()%>/login.jsp";
// 	}
	//用于本地测试
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