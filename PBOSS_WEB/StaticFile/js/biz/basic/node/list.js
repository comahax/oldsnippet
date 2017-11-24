var doSubmit=function(){
	//屏幕按钮
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	
	//使用进步提示功能
	_o_li = f_showPlan("处理中，请稍候。");
	return true;
}
var clickSubmit =function(){
	//手工调用验证事件
	var chk = $("#frmSubmit").triggerHandler("check");
	if (chk){
		var ok= function(box){
			box.close();
			$("#frmSubmit").submit();
		}
		confirmDlg('您确定要提出修改申请吗？','请确认：',ok);
	}
}
$(document).ready(function() { 
	//绑定按钮
	//显示第几个菜单内容
	//f_showMenu(2,1,0);

	if (errMap.length>0) showError(errMap);

		//必填项控制
		var requiredSet = [
			{name:"apply.principal",desc:"负责人姓名",typeDesc:"负责人姓名不能为空",type:"notNull"},
			{name:"apply.principaltel",desc:"移动电话",typeDesc:"移动电话只能是移动的号码",type:"mobile"},
			{name:"apply.principalphone",desc:"固定电话",typeDesc:"固定电话格式错",type:"phone",typeCheck:true},
			{name:"apply.principalemail",desc:"电子信箱",typeDesc:"电子信箱格式错",type:"email",typeCheck:true},
			
			{name:"apply.wayname",desc:"渠道名称",typeDesc:"渠道名称不能为空",type:"notNull"},
			{name:"apply.address",desc:"详细地址",typeDesc:"详细地址不能为空",type:"notNull"},
			{name:"apply.recpers",desc:"收货联系人",typeDesc:"收货联系人不能为空",type:"notNull"},
			{name:"apply.recconntel",desc:"收货联系号码",typeDesc:"收货联系号码不能为空",type:"notNull"},
			{name:"apply.reccertno",desc:"收货人证件号",typeDesc:"收货人证件号",type:"notNull"},
			{name:"apply.sendaddr",desc:"送货地址",typeDesc:"送货地址不能为空",type:"notNull"},

			{name:"apply.acctfid",desc:"开户人身份证号码",typeDesc:"开户人身份证号必须是身份证格式",type:"idcard"},
			{name:"apply.acctname",desc:"酬金支付帐号名称",typeDesc:"酬金支付帐号名称不能为空",type:"notNull"},
			{name:"apply.bankname",desc:"酬金支付开户银行",typeDesc:"酬金支付开户银行不能为空",type:"notNull"},
			{name:"apply.acctno",desc:"酬金支付银行账号",typeDesc:"酬金支付银行账号不能为空",type:"notNull"},
			{name:"apply.deacctname",desc:"卡类购销划扣帐号名称",typeDesc:"卡类购销划扣帐号名称不能为空",type:"notNull"},
			{name:"apply.debankname",desc:"卡类购销划扣开户银行",typeDesc:"卡类购销划扣开户银行不能为空",type:"notNull"},
			{name:"apply.deacctno",desc:"卡类购销划扣银行账号",typeDesc:"卡类购销划扣银行账号不能为空",type:"notNull"},

			{name:"vaildateCode",desc:"验证码",typeDesc:"验证码不能为空",type:"notNull"}
		]
		//setValidation(frmID,requiredSet) -- frmID只能为Form ID，requiredSet - 数组
		var va = setValidation("frmSubmit",requiredSet);

	
	//ac
	cusAc($("#bankname"),$("#debankid"),{type:jaacDBBank})
});