//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前

var doSubmit=function(){
	//屏幕按钮
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//使用进步提示功能
	_o_li = f_showPlan("处理中，请稍候。");
	$('#btnQuery').attr("disabled",true);
	return true;
}
var doConfirm=function(){
	if (!taskId || taskId==''){
		alert('待办信息不能为空!');
		return false;
	}
	//屏幕按钮
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//使用进步提示功能
	_o_li = f_showPlan("处理中，请稍候。");
	$('#btnConfirm').attr("disabled",true);
	//调用接口
	$.ajax({
		type: "GET",	//提交方式
		url:'/communi/finishPendingTask.do?parameter.advinfoid='+taskId ,
		cache: false,		//不使用IE缓存
		dataType: "json",	
		success: function(json){
			//debugger;
			if (json["isSuccess"]){
				alert('确认成功!')
			}else{
				alert('确认失败:'+ json.message);
				$('#btnConfirm').attr("disabled",false);
			}//if
			if (_o_li != null){
				_o_li.close();
			}//if
		}//success
	});
}
$(document).ready(function() { 
	//绑定按钮
	$('#btnQuery').attr("disabled",false);
	//生成日期下拉
	getMouthSelect($("#selMonth"),3);
	//注入方法
	$('#btnConfirm').click(doConfirm);
});