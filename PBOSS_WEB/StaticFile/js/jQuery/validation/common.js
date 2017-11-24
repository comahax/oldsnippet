//Pboss通用验证处理过程
/**
* 通用设置Form验证方法
* frmID - 表单ID,requiredSet - 配置数据
*/
var setValidation=function(frmID,requiredSet){
		
	var errShow = function(errMap){
		//显示错误信息
		var s="";
		for (var i=0;i<errMap.length;i++){
			s+=errMap[i].checkSetObj.typeDesc +"<br>"
		}
		f_showEMsg(s);
	}//定义必须在使用之前

	var setOptn = {
		noShowStart:1,
		//全部显示
		showAllErrors:true,
		allErrsFn:errShow	//出错后要处理的Fn
	}
	return $("#"+frmID).validation(requiredSet,setOptn);
}