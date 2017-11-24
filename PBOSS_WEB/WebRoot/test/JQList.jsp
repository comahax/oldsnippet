<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
<%@ include file="/common/meta_allcss.jsp"%>
	</head>
	<body>
		<form name="fmQuery" id="fmQuery" action="test/ajaxQuery.do">
        	<input name="query" type="text" id="query" size="5" maxlength="5" />
        	 <input name="btnQuery" type="button" id="btnQuery" value="按钮" />
        </form>
		<div id="showTbl" style="width:600px;"></div>
        <div id="navigation"></div>
	</body>
</html>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/jquery.form.js" ></script> 
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.debug.js" ></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
// 查询显示列信息
//var showCols = ${ShowCols}//取后台列设置类数组，对应如下
var showCols = [{"dataKey":"code","key":"code","name":"code","width":"10%"},{"dataKey":"name","key":"name","name":"用户名","width":"20%"}]

	var doQuery = function() {
//		var ajaxOpn = { 
//			target:'#rslTbl',
//			dataType:'json',
//			success:function(josnObj) { 
//				if (!josnObj["isSuccess"]) {
//					alert(josnObj["message"]);
//					return;
//				}
//				//构建配置对象
//				var optin = {
//					cols:cols,
//					showCols:showCols,
//					queryFrom: $("#fmQuery"),
//					datas:josnObj["datas"]
//				}
//				$("#showTbl").queryTable(optin);
//			}
//			
//		}; 
		//$("#fmQuery").ajaxSubmit(ajaxOpn);
		//alert(json.totalRecords)
				//构建配置对象
				var optin = {
					//cols:cols,
					tableClass:"",//表格的CSS
					tHeadClass:"",//表头的CSS
					tBodyClass:"",//表内CSS
					showCols:showCols,//显示列
					fmtLink:fmtLink,//用户自定义单元格内容
					pageNo:1,//手动定义页码和页内大小(页码为初始化页码)
					pageSize:2,//页内大小
					navigation:$("#navigation"),//翻页位置 jq对象
					queryFrom: $("#fmQuery")//查询表单
				}
				$("#showTbl").queryTable(optin);
	}

	//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象
	var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
		var rtn = oData;
	    if(oColumnSet.key=="id"){
			rtn = "<a href=\"Load.do?user.id="+ oData +"\" >"+ oData +"</a>";
		}
		if(oColumnSet.key=="name"){
			if(oRecord.code=='1')
				rtn="<font color='red'>"+oData +"</font>"
		}
		return rtn;
	}
	$(document).ready(function() { 
		//绑定按钮
		$("#btnQuery").click(doQuery);
	});
//-->
</SCRIPT>