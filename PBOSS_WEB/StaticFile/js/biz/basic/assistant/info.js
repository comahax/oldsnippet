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
	//�󶨰�ť
	//��ʾ�ڼ����˵�����
	//f_showMenu(4,1,0);

	if (errMap.length>0) showError(errMap);
	//��ʼ�����ڲ��
	initDate("intime");
	initDateByYear("birthday","-70:0");

		//���������
		var requiredSet = [
			{name:"apply.employeename",desc:"����",typeDesc:"����Ϊ������",type:"notNull"},
			{name:"apply.cardid",desc:"���֤��",typeDesc:"���֤�ű��������֤��ʽ",type:"idcard"},
			{name:"apply.telephone",desc:"��ϵ�绰",typeDesc:"��ϵ�绰��ʽ��",type:"phone"},
			{name:"apply.ofcphone",desc:"��˾ר����ϵ����",typeDesc:"��˾ר����ϵ�����ʽ��",type:"phone"},
			{name:"apply.pvtemail",desc:"���˵�������",typeDesc:"���˵��������ʽ��",type:"email",typeCheck:true},
			{name:"apply.ofcemail",desc:"��˾ר�õ�������",typeDesc:"��˾ר�õ��������ʽ��",type:"email",typeCheck:true},

			{name:"apply.officetel",desc:"���������",typeDesc:"����������ʽ��",type:"phone"},
			{name:"apply.intime",desc:"��ְʱ��",typeDesc:"��ְʱ��Ϊ������",type:"notNull"},
			{name:"apply.contacttype",desc:"�Ͷ���ϵ",typeDesc:"��ְʱ��Ϊ������",type:"notNull"},
			{name:"apply.employtype",desc:"�ù�����",typeDesc:"�ù�����Ϊ������",type:"notNull"},
			{name:"apply.empstatus",desc:"�ù�״̬",typeDesc:"�ù�״̬Ϊ������",type:"notNull"},

			{name:"vaildateCode",desc:"��֤��",typeDesc:"��֤�������",type:"notNull"}
		]
		//setValidation(frmID,requiredSet) -- frmIDֻ��ΪForm ID��requiredSet - ����
		var va = setValidation("frmSubmit",requiredSet);
});