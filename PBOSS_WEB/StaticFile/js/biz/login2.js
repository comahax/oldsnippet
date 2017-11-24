/**
 *µÇÂ¼ 
 */
function login2(){
	sendRequest();
}

var _o_li = null; 
function sendRequest(){
	var a = {
			dataType:'json',
			success:handleResponse
		}
		_o_li = f_showPlan("ÕýÔÚµÇÂ¼ÖÐ£¬ÇëÉÔºò¡£");
		document.LoginForm.action="/login.do";
		$('#LoginForm').ajaxSubmit(a);
		//sendAjaxReuqest($("#LoginForm"),a);
}
function handleResponse(json){
	if(!json.isSuccess){
		if(_o_li != null)
			_o_li.close();
		if(json.message)
			f_showMsg(json.message);
		$('#back').trigger('click');
	}
	else{
		f_jumpToURL(json.rtnObject);
	}
}