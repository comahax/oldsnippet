//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="operation"){
		//rtn = '<input type="button" class="btn_blue" value="查看详情" onclick="openDtl(\''+contextRootPath+'/adpay/detail.do?parameter.sumid='+oRecord.sumid+'\')" >\n';
		if(oRecord.state == "WAITSUBMIT"){
			rtn = '<input type="button" class="btn_blue" value="提交" onclick="f_submitState(\''+oRecord.state+'\','+oRecord.sumid+')" >';
		}			
		else if(oRecord.state == "CONFIRMED"){
			rtn = '<input type="button" class="btn_blue" value="支付" onclick="f_submitState(\''+oRecord.state+'\','+oRecord.sumid+')" >';
		}else {
			//rtn = '<input type="button" class="btn_blue" value="提交" disabled="disabled">';
			rtn = "";
		}
	}else if(oColumnSet.key=="beginTime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="endTime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="submitTime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="confirmTime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="sumid"){
		rtn = "<a href=\"javascript:openDtl('"+ contextRootPath +"/adpay/detail.do?parameter.sumid="+ oData +"');\" >"+ oData +"</a>";
	}
	return rtn;
}
//表格刷新之后
var successFncn = function(jsonObj){
	if (jsonObj.datas.length > 0){
		setMdfBtn(false);//恢复屏蔽
	}
	changeStyle();
}

var openDtl=function(url){
	openDlg(url,"垫资单明细",800,500,true);
};

var doQuery = function() {
	if($("#sumid").val()!=""){
		if(isNaN($("#sumid").val())){
			f_showEMsg("垫资汇总单号必须为数字");
			$("#sumid").val("");
			return ;
		}
		if($("#sumid").val().indexOf(".")>-1){
			f_showEMsg("垫资汇总单号必须为整数");
			$("#sumid").val("");
			return ;
		}
	}
	setMdfBtn(true);//屏蔽按钮
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() { 
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	$("#btnExport").click(f_exportExcel);
	//生成日期下拉
	initDate("createTimeFrom");
	initDate("createTimeTo");
	doQuery();
});

var changeStyle = function(){
	$('#showTbl .btn_blue').hover(function() {
		this.className='btn_blue_02';
	}, function() {
		this.className='btn_blue';
	});
}

//修改按钮的属性
var setMdfBtn = function(setBln){
	$("#btnQuery").attr("disabled",setBln);//屏蔽按钮
}

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
				alert("操作成功");//"提交成功"
				doQuery();
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

function f_exportExcel(){
	if($("#sumid").val()!=""){
		if(isNaN($("#sumid").val())){
			f_showEMsg("垫资汇总单号必须为数字");
			$("#sumid").val("");
			return ;
		}
		if($("#sumid").val().indexOf(".")>-1){
			f_showEMsg("垫资汇总单号必须为整数");
			$("#sumid").val("");
			return ;
		}
	}
	sumbitExportExcel("exportExcel.do","content");
}