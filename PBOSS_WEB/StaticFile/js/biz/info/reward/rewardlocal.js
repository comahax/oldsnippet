//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ

var doSubmit=function(){
	//��Ļ��ť
//	$("input:[type=submit]").each(function(i){
//		this.disabled = true;
//	});
	//�����ж�
	//ʹ�ý�����ʾ����
	_o_li = f_showPlan("�����У����Ժ�");
	$('#btnQuery').attr("disabled",true);
	return true;
}
var doSelRptType=function(){
	if (this.value==TYPEDTL){//���س����ϸ�������̶����޸���ע��
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
	//�󶨰�ť
	$('#btnQuery').attr("disabled",false);
	$('#btnRest').attr("disabled",false);
	$("#btnRest").click(doReset);
	//������������
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
	//���������
	var requiredSet = [
		{name:"parameter.month",desc:"�����·�",typeDesc:"�����·ݲ���Ϊ��",type:"notNull"},
		{name:"parameter.rewardtype",desc:"��������",typeDesc:"�������ͱ���ѡ��",type:"notNull"}
	]
	//setValidation(frmID,requiredSet) -- frmIDֻ��ΪForm ID��requiredSet - ����
	var va = setValidation("frmQuery",requiredSet);
	$("#rewardtype").change(doSelRptType);
	
});