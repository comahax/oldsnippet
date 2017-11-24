var doSubmit=function(){
	//屏幕按钮
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//使用进步提示功能
	if (window.confirm('您确定要提出退出申请吗？')){
		_o_li = f_showPlan("处理中，请稍候。");
		return true;
	}
	return false;
}
$(document).ready(function() { 
	//绑定按钮
	//显示第几个菜单内容
	//f_showMenu(3,1,0)

	if (errMap.length>0) showError(errMap);

		//必填项控制
		var requiredSet = [
			{name:"apply.description",desc:"退出原因",typeDesc:"退出原因不能为空。且字数有不能超过300字！",type:"notNull",checkNullType:"length",checkValue:600},

			{name:"vaildateCode",desc:"验证码",typeDesc:"验证码不能为空",type:"notNull"}
		]
		//setValidation(frmID,requiredSet) -- frmID只能为Form ID，requiredSet - 数组
		var va = setValidation("frmSubmit",requiredSet);
});