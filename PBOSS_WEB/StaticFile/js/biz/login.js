/**
 *��¼ 
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
		_o_li = f_showPlan("���ڵ�¼�У����Ժ�");
		document.LoginForm.action="/login.do";
		$('#LoginForm').ajaxSubmit(a);
		//sendAjaxReuqest($("#LoginForm"),a);
		timeout = window.setTimeout(function(){
			//alert("��ʼ��ʱ");
			if(_o_li != null)
				_o_li.close();
			f_showEMsg("���ӳ�ʱ�����Ժ����ԣ�");
		},
		60*1000);
}
function handleResponse(json){
	//alert(json.message);
	if(timeout!=null){
		//alert("��ʱ��Ҫ�ر�����");
		window.clearTimeout(timeout);
		//alert("��ʱ���رգ�");
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
 * ���������Ϣ�Ƿ���ȷ
 */
function checkInput(){
	var b_s = true;
	var m = f_getValueById('officeTel');
	var s = f_getValueById('inputCode');
	var f = f_getValueById('fixedPW');
	var a = f_getValueById('authType');
	if(f_isNullOrEmpty(m)){//|| !f_isMobile(m)
		//f_showMsg("��������ȷ���ƶ��ֻ����롣");		
		f_showMsg("�������ֻ����롣");
		b_s = false;
		return b_s;
	}
	if(m.length!=11){
		f_showMsg("�ֻ��������Ϊ11λ��");
		b_s = false;
		return b_s;
	}
	if(a=="SecAuth" && f_isNullOrEmpty(s)){
		f_showMsg("���������������֤�롣");
		b_s = false;
		return b_s;
	}
	if(a=="SimpAuth" && f_isNullOrEmpty(f)){
		f_showMsg("���������롣");
		b_s = false;
		return b_s;
	}
	return b_s;
}