var doSubmit=function(){
	//��Ļ��ť
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//ʹ�ý�����ʾ����
	if (window.confirm('��ȷ��Ҫ����˳�������')){
		_o_li = f_showPlan("�����У����Ժ�");
		return true;
	}
	return false;
}
$(document).ready(function() { 
	//�󶨰�ť
	//��ʾ�ڼ����˵�����
	//f_showMenu(3,1,0)

	if (errMap.length>0) showError(errMap);

		//���������
		var requiredSet = [
			{name:"apply.description",desc:"�˳�ԭ��",typeDesc:"�˳�ԭ����Ϊ�ա��������в��ܳ���300�֣�",type:"notNull",checkNullType:"length",checkValue:600},

			{name:"vaildateCode",desc:"��֤��",typeDesc:"��֤�벻��Ϊ��",type:"notNull"}
		]
		//setValidation(frmID,requiredSet) -- frmIDֻ��ΪForm ID��requiredSet - ����
		var va = setValidation("frmSubmit",requiredSet);
});