var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="createtime"){
		rtn = handlerdate(oData, 2);
	}
	return rtn;
}
//页面初始化完成时调用
$(document).ready(function() {
	$("#showResdetsTbl").queryTable(optin);
})

function f_submitState(stateValue,sumidValue){
	if("WAITSUBMIT"==stateValue || "CONFIRMED"==stateValue){
		var _o_li = f_showPlan("处理中，请稍候。");
		var successFunction = function(msg){
			if(msg.retCode>100){
				_o_li.close();
				//f_showEMsg("该汇总单不是”待提交状态“或“已确认状态”!");//"该汇总单不是”待提交状态“!"
				f_showEMsg(msg.message);
				return;
			}else if(msg.isSuccess){
				_o_li.close();
				alert("操作成功");
				if("WAITSUBMIT"==stateValue){
					$("#stateTd").html("待确认");
				}else{//"CONFIRMED"==stateValue
					$("#stateTd").html("待支付");
				}				
				return;
			}else{
				f_showEMsg("系统忙，请稍后再试!");
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