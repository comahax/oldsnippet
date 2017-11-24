//表格配置数组
alert(222);
var optin = {
	showCols:showCols,//显示列
	pageSize:5,//页内大小
	fmtLink:fmtLink,
	navigation:$("#navigation"),//翻页位置 jq对象
	width:"100%",
	showTable:false,
	queryFrom: $("#queryReply")//查询表单
};

function doQuery(){
alert(123);
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() {
	doQuery();
});