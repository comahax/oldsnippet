//Pbossͨ����֤�������
/**
* ͨ������Form��֤����
* frmID - ��ID,requiredSet - ��������
*/
var setValidation=function(frmID,requiredSet){
		
	var errShow = function(errMap){
		//��ʾ������Ϣ
		var s="";
		for (var i=0;i<errMap.length;i++){
			s+=errMap[i].checkSetObj.typeDesc +"<br>"
		}
		f_showEMsg(s);
	}//���������ʹ��֮ǰ

	var setOptn = {
		noShowStart:1,
		//ȫ����ʾ
		showAllErrors:true,
		allErrsFn:errShow	//�����Ҫ�����Fn
	}
	return $("#"+frmID).validation(requiredSet,setOptn);
}