var doSubmit=function(){
	//��Ļ��ť
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	
	//ʹ�ý�����ʾ����
	_o_li = f_showPlan("�����У����Ժ�");
	return true;
}
var clickSubmit =function(){
	//�ֹ�������֤�¼�
	var chk = $("#frmSubmit").triggerHandler("check");
	if (chk){
		var ok= function(box){
			box.close();
			$("#frmSubmit").submit();
		}
		confirmDlg('��ȷ��Ҫ����޸�������','��ȷ�ϣ�',ok);
	}
}
$(document).ready(function() { 
	//�󶨰�ť
	//��ʾ�ڼ����˵�����
	//f_showMenu(2,1,0);

	if (errMap.length>0) showError(errMap);

		//���������
		var requiredSet = [
			{name:"apply.principal",desc:"����������",typeDesc:"��������������Ϊ��",type:"notNull"},
			{name:"apply.principaltel",desc:"�ƶ��绰",typeDesc:"�ƶ��绰ֻ�����ƶ��ĺ���",type:"mobile"},
			{name:"apply.principalphone",desc:"�̶��绰",typeDesc:"�̶��绰��ʽ��",type:"phone",typeCheck:true},
			{name:"apply.principalemail",desc:"��������",typeDesc:"���������ʽ��",type:"email",typeCheck:true},
			
			{name:"apply.wayname",desc:"��������",typeDesc:"�������Ʋ���Ϊ��",type:"notNull"},
			{name:"apply.address",desc:"��ϸ��ַ",typeDesc:"��ϸ��ַ����Ϊ��",type:"notNull"},
			{name:"apply.recpers",desc:"�ջ���ϵ��",typeDesc:"�ջ���ϵ�˲���Ϊ��",type:"notNull"},
			{name:"apply.recconntel",desc:"�ջ���ϵ����",typeDesc:"�ջ���ϵ���벻��Ϊ��",type:"notNull"},
			{name:"apply.reccertno",desc:"�ջ���֤����",typeDesc:"�ջ���֤����",type:"notNull"},
			{name:"apply.sendaddr",desc:"�ͻ���ַ",typeDesc:"�ͻ���ַ����Ϊ��",type:"notNull"},

			{name:"apply.acctfid",desc:"���������֤����",typeDesc:"���������֤�ű��������֤��ʽ",type:"idcard"},
			{name:"apply.acctname",desc:"���֧���ʺ�����",typeDesc:"���֧���ʺ����Ʋ���Ϊ��",type:"notNull"},
			{name:"apply.bankname",desc:"���֧����������",typeDesc:"���֧���������в���Ϊ��",type:"notNull"},
			{name:"apply.acctno",desc:"���֧�������˺�",typeDesc:"���֧�������˺Ų���Ϊ��",type:"notNull"},
			{name:"apply.deacctname",desc:"���๺�������ʺ�����",typeDesc:"���๺�������ʺ����Ʋ���Ϊ��",type:"notNull"},
			{name:"apply.debankname",desc:"���๺�����ۿ�������",typeDesc:"���๺�����ۿ������в���Ϊ��",type:"notNull"},
			{name:"apply.deacctno",desc:"���๺�����������˺�",typeDesc:"���๺�����������˺Ų���Ϊ��",type:"notNull"},

			{name:"vaildateCode",desc:"��֤��",typeDesc:"��֤�벻��Ϊ��",type:"notNull"}
		]
		//setValidation(frmID,requiredSet) -- frmIDֻ��ΪForm ID��requiredSet - ����
		var va = setValidation("frmSubmit",requiredSet);

	
	//ac
	cusAc($("#bankname"),$("#debankid"),{type:jaacDBBank})
});