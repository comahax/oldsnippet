var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="createtime"){
		rtn = handlerdate(oData, 2);
	}
	return rtn;
}
//ҳ���ʼ�����ʱ����
$(document).ready(function() {
	$("#showResdetsTbl").queryTable(optin);
})

function f_submitState(stateValue,sumidValue){
	if("WAITSUBMIT"==stateValue || "CONFIRMED"==stateValue){
		var _o_li = f_showPlan("�����У����Ժ�");
		var successFunction = function(msg){
			if(msg.retCode>100){
				_o_li.close();
				//f_showEMsg("�û��ܵ����ǡ����ύ״̬������ȷ��״̬��!");//"�û��ܵ����ǡ����ύ״̬��!"
				f_showEMsg(msg.message);
				return;
			}else if(msg.isSuccess){
				_o_li.close();
				alert("�����ɹ�");
				if("WAITSUBMIT"==stateValue){
					$("#stateTd").html("��ȷ��");
				}else{//"CONFIRMED"==stateValue
					$("#stateTd").html("��֧��");
				}				
				return;
			}else{
				f_showEMsg("ϵͳæ�����Ժ�����!");
			}
		}
		$.ajax({
	   type:"POST",
	   url:"ajaxSubmit.do",
	   data:{"parameter.sumid":sumidValue,"parameter.state":stateValue},
	   dataType:"json",
	   success:successFunction
		});
	}
}