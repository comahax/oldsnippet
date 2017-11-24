var doQuery = function() {
	//修改部分：只对页面相关的量进行修改
	var optin = {
		//showCols:showCols,//显示列
		pageSize:3,//页内大小
		//navigation:$("#navigation"),//翻页位置 jq对象
		queryFrom: $("#frmQuery"),//查询表单
		unableBtu:$('#btnQuery'),
		//自定义表格生成
		getTbaleFn:setTable,//提取表格函数
		getTbodyFn:setBody
	};
	$("#showRtsl").queryTable(optin);
}

var setTable = function ($div,_optn){
	var shTable = $div.find("#showTbl");
	shTable.hide();
	$div.find("#markTbl").html("数据加载中...");
	$div.find("#markTbl").show();
	$div.show();
	//
	$div.find("#allMsg").hide();
	return shTable;
}
var setBody = function (jsonObjs,shTable,$div,jsonAllObj){
	var jsonSize = jsonObjs.length;
	if (jsonSize<1) {
		$div.find("#markTbl").html("没有数据!");
		return;
	}
	$div.find("#markTbl").hide();
	//提取总分
	var allMark = jsonAllObj.allMark;
	var allMsgObj = $div.find("#allMsg");
	//allMsgObj.find("#msgValue").html(allMark);
	allMsgObj.show()
	//设置表格
	//var showdtl = shTable.find("td")
	var showdtl = shTable;
	var newRow=null;
	showdtl.empty();
	for (var i=0;i< jsonSize;i++){
		newRow=null;
		var useObj = $("#datas").clone();
		useObj.css("float","left");
		//if (i < (jsonSize-1)) 
		//useObj.css("margin-right","8px");
		useObj.css("margin-bottom","5px");
		useObj.removeAttr("id");//删除ID属性,以免引起获取冲突
		useObj.show();
		useObj.appendTo(showdtl);
		//设置数据
		var useTrObj = useObj.find("#context");
		var firstTr = useObj.find("tr:first");//查找第一行
		firstTr.find("#exmnname").html("考核名称");
		firstTr.find("#exmnnameValue").html(jsonObjs[i].exmnname);
		
		firstTr.find("#exmnmark").html("考核总分");
		firstTr.find("#exmnmarkValue").html(jsonObjs[i].exmnmark);
		var jsonDtlList = jsonObjs[i].dtlList;

		for (var j=0;j<jsonDtlList.length;j++){
			newRow = useTrObj.clone();
			newRow.show();
			newRow.find("#showName1").html(jsonDtlList[j].exmnstdname);
			newRow.find("#showValue1").html(jsonDtlList[j].exmnmark);
			//愚蠢实现方法
			j++;
			if (j<jsonDtlList.length){
				newRow.find("#showName2").html(jsonDtlList[j].exmnstdname);
				newRow.find("#showValue2").html(jsonDtlList[j].exmnmark);
			}
			j++;
			if (j<jsonDtlList.length){
				newRow.find("#showName3").html(jsonDtlList[j].exmnstdname);
				newRow.find("#showValue3").html(jsonDtlList[j].exmnmark);
			}
			j++;
			if (j<jsonDtlList.length){
				newRow.find("#showName4").html(jsonDtlList[j].exmnstdname);
				newRow.find("#showValue4").html(jsonDtlList[j].exmnmark);
			}
			newRow.appendTo(useObj);
		}//明细遍列
		//使用新的方法遍列明细


		useTrObj = null;
	}//for

	useObj = null,newRow =null;

	//debugger;	
	shTable.show();
}
$(document).ready(function() { 
	//<!-- 显示第几个菜单内容 -->
	//f_showMenu(5,0,0)
	//生成日期下拉
	getMouthSelect($("#selMonth"),3);
	//默认查当然月
	doQuery();
});