//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ

var doSubmit=function(){
	//��Ļ��ť
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//ʹ�ý�����ʾ����
	_o_li = f_showPlan("�����У����Ժ�");
	$('#btnQuery').attr("disabled",true);
	return true;
}
var doConfirm=function(){
	if (!taskId || taskId==''){
		alert('������Ϣ����Ϊ��!');
		return false;
	}
	//��Ļ��ť
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//ʹ�ý�����ʾ����
	_o_li = f_showPlan("�����У����Ժ�");
	$('#btnConfirm').attr("disabled",true);
	//���ýӿ�
	$.ajax({
		type: "GET",	//�ύ��ʽ
		url:'/communi/finishPendingTask.do?parameter.advinfoid='+taskId ,
		cache: false,		//��ʹ��IE����
		dataType: "json",	
		success: function(json){
			//debugger;
			if (json["isSuccess"]){
				alert('ȷ�ϳɹ�!')
			}else{
				alert('ȷ��ʧ��:'+ json.message);
				$('#btnConfirm').attr("disabled",false);
			}//if
			if (_o_li != null){
				_o_li.close();
			}//if
		}//success
	});
}
$(document).ready(function() { 
	//�󶨰�ť
	$('#btnQuery').attr("disabled",false);
	//������������
	getMouthSelect($("#selMonth"),3);
	//ע�뷽��
	$('#btnConfirm').click(doConfirm);
});