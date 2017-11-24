/**
 *登录 
 */
//onSubmit事件
var _o_li;
var doSubmit=function(){
	//屏幕按钮
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//使用进步提示功能
	_o_li = f_showPlan("处理中，请稍候。");
	return true;
}
$(document).ready(function() {
	if (errMap.length>0) showError(errMap);
	//验证框配置
	
		//必填项控制
		var requiredSet = [
			{name:"apply.principal",desc:"姓名",typeDesc:"姓名为必填项",type:"notNull"},
			{name:"apply.principaltel",desc:"移动电话",typeDesc:"移动电话必须为移动手机",type:"mobile"},
			{name:"apply.principalphone",desc:"办公电话",typeDesc:"办公电话格式错",type:"phone",typeCheck:true},
			{name:"apply.principalemail",desc:"电子邮箱",typeDesc:"电子邮箱格式错",type:"email",typeCheck:true},

			{name:"apply.wayname",desc:"网点名称",typeDesc:"网点名称为必填项",type:"notNull"},
			{name:"apply.address",desc:"网点地址",typeDesc:"网点地址为必填项",type:"notNull"},
			{name:"apply.cityid",desc:"归属地",typeDesc:"归属地必须选择",type:"notNull"},
			//{name:"apply.bankname",desc:"开户银行",typeDesc:"开户银行为必填项",type:"notNull"},
			//{name:"apply.acctno",desc:"银行帐号",typeDesc:"银行帐号为必填项",type:"notNull"},
			{name:"apply.acctfid",desc:"开户人身份证号",typeDesc:"开户人身份证号必须是身份证格式",type:"idcard"}
			,{name:"vaildateCode",desc:"验证码",typeDesc:"验证码必填项",type:"notNull"}
		]
		//setValidation(frmID,requiredSet) -- frmID只能为Form ID，requiredSet - 数组
		var va = setValidation("frmRegister",requiredSet);
});