
//���ò�ѯ
var doQuery = function() { 
		//sumbitExportExcel(contextRootPath+"/gdView/paymentAjax.do","content");
	frmQuery.submit();

}

//ҳ���ʼ�����ʱ����
$(document).ready(function() { 
	$("#btnQuery").click(doQuery);
		//������������
	getMouthSelect($("#selMonth"),12); 
	//��ʼ�����ڲ��
//	initDate("rewardmonth");
});
