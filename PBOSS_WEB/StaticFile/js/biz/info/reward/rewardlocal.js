//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前

var doSubmit=function(){
	//屏幕按钮
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//必填判断
	//使用进步提示功能
	_o_li = f_showPlan("处理中，请稍候。");
	$('#btnQuery').attr("disabled",true);
	return true;
}
var doSelRptType=function(){
	if (this.value==TYPEDTL){//本地酬金明细，参数固定，修改请注意
		$('#mobleLocal').show();
	}else{
		$('#mobleLocal').hide();
	}
}//do
var doDtlPage=function(page){
	$("#pageNo").val(page);
	$('#frmQuery').submit();
};
var doReset =function(){
	$("#rewardtype").val('');
	$('#opermobile').val('');
	$('#mobleLocal').hide();

}
$(document).ready(function() { 
	//绑定按钮
	$('#btnQuery').attr("disabled",false);
	$('#btnRest').attr("disabled",false);
	$("#btnRest").click(doReset);
	//生成日期下拉
	getMouthSelect($("#selMonth"),6);
	
	var cou=$("#selMonth option").length
	if(cou>6){
		cou=cou-6;
		$("#selMonth option").each(function(){
			if(cou>0){
				$(this).remove();
				cou--;
			}
		});
	}
	//必填项控制
	var requiredSet = [
		{name:"parameter.month",desc:"结算月份",typeDesc:"结算月份不能为空",type:"notNull"},
		{name:"parameter.rewardtype",desc:"报表类型",typeDesc:"报表类型必须选择",type:"notNull"}
	]
	//setValidation(frmID,requiredSet) -- frmID只能为Form ID，requiredSet - 数组
	var va = setValidation("frmQuery",requiredSet);
	$("#rewardtype").change(doSelRptType);
	
});