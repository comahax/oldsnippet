/**
 *��¼ 
 */
//onSubmit�¼�
var _o_li;
var doSubmit=function(){
	//��Ļ��ť
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//ʹ�ý�����ʾ����
	_o_li = f_showPlan("�����У����Ժ�");
	return true;
}
$(document).ready(function() {
	if (errMap.length>0) showError(errMap);
	//��֤������
	
		//���������
		var requiredSet = [
			{name:"apply.principal",desc:"����",typeDesc:"����Ϊ������",type:"notNull"},
			{name:"apply.principaltel",desc:"�ƶ��绰",typeDesc:"�ƶ��绰����Ϊ�ƶ��ֻ�",type:"mobile"},
			{name:"apply.principalphone",desc:"�칫�绰",typeDesc:"�칫�绰��ʽ��",type:"phone",typeCheck:true},
			{name:"apply.principalemail",desc:"��������",typeDesc:"���������ʽ��",type:"email",typeCheck:true},

			{name:"apply.wayname",desc:"��������",typeDesc:"��������Ϊ������",type:"notNull"},
			{name:"apply.address",desc:"�����ַ",typeDesc:"�����ַΪ������",type:"notNull"},
			{name:"apply.cityid",desc:"������",typeDesc:"�����ر���ѡ��",type:"notNull"},
			//{name:"apply.bankname",desc:"��������",typeDesc:"��������Ϊ������",type:"notNull"},
			//{name:"apply.acctno",desc:"�����ʺ�",typeDesc:"�����ʺ�Ϊ������",type:"notNull"},
			{name:"apply.acctfid",desc:"���������֤��",typeDesc:"���������֤�ű��������֤��ʽ",type:"idcard"}
			,{name:"vaildateCode",desc:"��֤��",typeDesc:"��֤�������",type:"notNull"}
		]
		//setValidation(frmID,requiredSet) -- frmIDֻ��ΪForm ID��requiredSet - ����
		var va = setValidation("frmRegister",requiredSet);
});