
	//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
	//@@声用一定要在使用之前
	var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
		var rtn = oData;
	    if(oColumnSet.key=="id"){
			rtn = "<a href=\"Load.do?user.id="+ oData +"\" >"+ oData +"</a>";
		}
	    if(oColumnSet.key=="oprtime"){
			rtn = handlerdate(oData, 1);
		}
		return rtn;
	}
	var doQuery = function() {
		//验证输入
//		if ($("#opnname").val() == ""){
//			alert("请输入业务名称");
//			return;
//		}
		if ($("#realrewardtype").val() == ""){
			alert("请选择酬金类型");
			return;
		}
		//修改部分：只对页面相关的量进行修改
		$("#showTbl").queryTable(optin);
	}
	
	function f_exportExcel(){
		sumbitExportExcel("rewardVerifiedExcel.do","content");
	}

	$(document).ready(function() { 
		//绑定按钮
		dTable = getTable($("#showTbl"),optin);
		var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
		_tBodyMark.hide();

		//导出文件
		$("#btnExportExcel").click(f_exportExcel);
		
		$("#btnQuery").click(doQuery);
		$('#btnQuery').attr("disabled",false);
		//生成日期下拉
		getMouthSelect($("#selMonth"),3);
		//ac
		cusAc($("#opnname"),$("#opnid"),{type:operation})	
		//<!-- 显示第几个菜单内容 -->
		//f_showMenu(4,2,1);
		//打开页面默认查询
		doQuery();
	});