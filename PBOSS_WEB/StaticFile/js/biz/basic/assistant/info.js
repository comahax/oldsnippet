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
	//绑定按钮
	//显示第几个菜单内容
	//f_showMenu(4,1,0);

	if (errMap.length>0) showError(errMap);
	//初始化日期插件
	initDate("intime");
	initDateByYear("birthday","-70:0");

		//必填项控制
		var requiredSet = [
			{name:"apply.employeename",desc:"姓名",typeDesc:"姓名为必填项",type:"notNull"},
			{name:"apply.cardid",desc:"身份证号",typeDesc:"身份证号必须是身份证格式",type:"idcard"},
			{name:"apply.telephone",desc:"联系电话",typeDesc:"联系电话格式错",type:"phone"},
			{name:"apply.ofcphone",desc:"公司专用联系号码",typeDesc:"公司专用联系号码格式错",type:"phone"},
			{name:"apply.pvtemail",desc:"个人电子信箱",typeDesc:"个人电子信箱格式错",type:"email",typeCheck:true},
			{name:"apply.ofcemail",desc:"公司专用电子邮箱",typeDesc:"公司专用电子邮箱格式错",type:"email",typeCheck:true},

			{name:"apply.officetel",desc:"公务机号码",typeDesc:"公务机号码格式错",type:"phone"},
			{name:"apply.intime",desc:"入职时间",typeDesc:"入职时间为必填项",type:"notNull"},
			{name:"apply.contacttype",desc:"劳动关系",typeDesc:"入职时间为必填项",type:"notNull"},
			{name:"apply.employtype",desc:"用工性质",typeDesc:"用工性质为必填项",type:"notNull"},
			{name:"apply.empstatus",desc:"用工状态",typeDesc:"用工状态为必填项",type:"notNull"},

			{name:"vaildateCode",desc:"验证码",typeDesc:"验证码必填项",type:"notNull"}
		]
		//setValidation(frmID,requiredSet) -- frmID只能为Form ID，requiredSet - 数组
		var va = setValidation("frmSubmit",requiredSet);
});