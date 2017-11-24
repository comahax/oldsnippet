/**
 *登录 
 */
var timeout = null;
function login(){
	if(checkInput()){
		//document.LoginForm.submit();
		sendRequest();
	}
}
var _o_li = null; 
function sendRequest(){
	var a = {
			dataType:'json',
			success:handleResponse
		}
		_o_li = f_showPlan("正在登录中，请稍候。");
		document.LoginForm.action="/login.do";
		$('#LoginForm').ajaxSubmit(a);
		//sendAjaxReuqest($("#LoginForm"),a);
		timeout = window.setTimeout(function(){
			//alert("开始计时");
			if(_o_li != null)
				_o_li.close();
			f_showEMsg("连接超时，请稍后再试！");
		},
		60*1000);
}
function handleResponse(json){
	//alert(json.message);
	if(timeout!=null){
		//alert("计时器要关闭啦！");
		window.clearTimeout(timeout);
		//alert("计时器关闭！");
	}
	$('.validateCodePic').css("display","none");
	if(!json.isSuccess){
		if(_o_li != null)
			_o_li.close();
		$('#anotherPic').trigger('click');
		f_showMsg(json.message);
	}
	else{
		f_jumpToURL(json.rtnObject);
	}		
	$('.validateCodePic').css("display","block");
}

/**
 * 检查输入信息是否正确
 */
function checkInput(){
	var b_s = true;
	var m = f_getValueById('officeTel');
	var s = f_getValueById('inputCode');
	var f = f_getValueById('fixedPW');
	var a = f_getValueById('authType');
	if(f_isNullOrEmpty(m)){//|| !f_isMobile(m)
		//f_showMsg("请输入正确的移动手机号码。");		
		f_showMsg("请输入手机号码。");
		b_s = false;
		return b_s;
	}
	if(m.length!=11){
		f_showMsg("手机号码必须为11位。");
		b_s = false;
		return b_s;
	}
	if(a=="SecAuth" && f_isNullOrEmpty(s)){
		f_showMsg("请输入随机短信验证码。");
		b_s = false;
		return b_s;
	}
	if(a=="SimpAuth" && f_isNullOrEmpty(f)){
		f_showMsg("请输入密码。");
		b_s = false;
		return b_s;
	}
	return b_s;
}