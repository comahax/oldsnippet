<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%
	String rootId = (String)request.getAttribute("rootId");
	String rootName = (String)request.getAttribute("rootName");
	String topChildrenURL = (String)request.getAttribute("topChildrenURL" );
	String queryText =(String)request.getAttribute("queryText" );
%>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
    	var contextPath = '<%=contextPath%>';
        function ev_check() {
            return checkval(window);
        }
        function doQueryTree(){
        	var queryText = formList.queryText.value;
        	var queryRole = formList.queryRole.value;
        	var url = contextPath + "/base/operfunction_batchlist.do?param._desc=0";
        	if(queryText == null || queryText == ''){
        	}else{
        		url += "&queryText="+queryText;
        	}
        	if(queryRole == null || queryRole == ''){
        	}else{
        		url += "&queryRole="+queryRole;
        	}
        	
        	formList.action = url;
        	formList.submit();
        }
        
        function doBatchSave(){
        	if(isCheck()){
	        	var url = contextPath + "/base/operfunction_batchsave.do";
	        	formList.action = url;
	        	formList.submit();
        	}
        }
        
        function isCheck(){
        	var sisOper = document.all("_selectitem");
        	var flagOper = false;
        	if (sisOper.length != null) {
		            for (var i = 0; i < sisOper.length; i++) {
		                var e = sisOper[i];
		                if (e.type == 'checkbox') {
		                	if(e.checked){
								flagOper = true;
								break;                	
		                	}
		                }
		            }
	        } else {
	            var e = sisOper;
	            if (e.type == 'checkbox') {
	                if(e.checked){
							flagOper = true;                	
	                }
	            }
	        }
	        if(flagOper == false){
	        	alert('工号列表至少选择一项!');
	        	return false;
	        }
	        
	        var sisCheck = document.all("_selectitem_checkbox");
        	var flagCheck = false;
        	if (sisCheck.length != null) {
		            for (var i = 0; i < sisCheck.length; i++) {
		                var e = sisCheck[i];
		                if (e.type == 'checkbox') {
		                	if(e.checked){
								flagCheck = true;
								break;                	
		                	}
		                }
		            }
	        } else {
	            var e = sisCheck;
	            if (e.type == 'checkbox') {
	                if(e.checked){
							flagCheck = true;                	
	                }
	            }
	        }
	        if(flagCheck == false){
	        	alert('菜单树列表至少选择一项!');
	        	return false;
	        }
	        
	        return true;
        }
        
        
        
        function checkAll(FO,BO,CO) {
		    if (FO == null) {
		        FO = "document.formList";
		    }else{
		    	FO = "document." + FO;
		    }
		    if (BO == null) {
		        BO = "_selectitem";
		    }
		    if (CO == null) {
		    	CO = FO + ".allbox";
		    	}else{
		    	CO = FO + "." + CO;
		    	}
		    var sis = eval(FO).all(BO);
		    
		    if (sis != null) {
		        if (sis.length != null) {
		            for (var i = 0; i < sis.length; i++) {
		                var e = sis[i];
		                if (e.type == 'checkbox') {
		                    e.checked = eval(CO).checked;
		                    /*
		                    if (e.checked)
		                        hL(e);
		                    else
		                        dL(e);
		                        */
		                }
		            }
		        } else {
		            var e = sis;
		            if (e.type == 'checkbox') {
		                e.checked = eval(CO).checked;
		                /*
		                if (e.checked)
		                    hL(e);
		                else
		                    dL(e);
		                    */
		            }
		        }
		    }
		}
		function checkOne(FO,BO,CO) {
		    if (FO == null) {
		        FO = "document.formList";
		    }else{
		    	FO = "document." + FO;
		    }
		    if (BO == null) {
		        BO = "getElementsByName('_selectitem')";
		    }
		    if (CO == null) {
		    	CO = FO + ".allbox";
		    	}else{
		    	CO = FO + "." + CO;
		    	}
		
		    var TB = TO = 0;
		    var sis = eval("document.getElementsByName('_selectitem')");
		    if (sis != null) {
		        if (sis.length != null) {
		            for (var i = 0; i < sis.length; i++) {
		                var e = sis[i];
		                if (e.type == 'checkbox') {
		                    TB++;
		                    if (e.checked)
		                        TO++;
		                }
		            }
		            if (TO == TB){
		                eval(CO).checked = true;
		                }
		            else{
		                eval(CO).checked = false;
		                }
		        } else {
		            var e = sis;
		            if (e.type == 'checkbox') {
		                eval(CO).checked = e.checked;
		            }
		        }
		    }
		}
		function doReturn(cmdReturn) {
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
    </script>
	<script type="text/javascript" src="<%= contextPath %>/js/dtree.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xtree.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xmlextras.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xloadtree.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/table.css" />
	<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/xtree.css" />
	<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/button.css" />
	<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/dtree.css" />
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="operfunction_batchlist.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">

	<s:hidden name="param._orderby" />
	<s:hidden name="param._desc" />
	<s:hidden name="param._pageno" />
	<s:hidden name="param._pagesize" />
	<s:hidden name="param.queryAll" />
	<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />" />

	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="base"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
	<div class="table_div">
		<table class="table_normal">
			<tr>
				<td>授权菜单</td>
				<td>工号列表</td>
			</tr>
			<tr>
				<td>
					<table class="table_normal">
						<tr>	
							<td>
						        <script type="text/javascript">        			
						       		var queryText ="<%=queryText%>";
									<%if(rootId!=null && !"非法数据".equals(rootName)) { %>
										var tree = new WebFXLoadTree("<%=rootName%>","<%=topChildrenURL%>","");
									<% }else { %>							
										var tree = new WebFXLoadTree("<%=rootName%>","<%=topChildrenURL%>");
									<%}%>
									document.write(tree);
									if(queryText!="" && queryText!="null" && queryText!=null)
										tree.expandAllover();
			        			</script>
			  				 </td>
			  			</tr>
			  			<tr>
			  				<td>
			  				菜单名称:<s:textfield cssStyle="style_input" name="queryText" />
				  				<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="查询" onClick="doQueryTree();">
                            </td>
			  			</tr>
		  			</table>
				</td>
				<td valign="top">
					<div class="table_div">
						<table class="table_style">
							<tr class="table_button_list1">
								<td colspan="3">
									工号或名称:
									<s:textfield cssStyle="style_input" name="queryRole"/>									
									<input type="button" id="btnQueryRole" name="btnQuery"
										class="button_Query" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="查询"
										onClick="doQueryRole();" disabled="true">
								</td>
							</tr>
						</table>
						<span id="showTbl"></span>
						<table class="page_table">
							<tr valign=middle>
								<td align=right height=30 id="navigation">
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="授权" onclick="doBatchSave();"/>
					<input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="返回" onclick="doReturn('/base/operfunction_list.do');">
				</td>
			</tr>
		</table>
	</div>
</s:form>
<form action="/base/operfunction_batchJSONlist.do" method="POST" id="frmQuery">
	<s:hidden name="param.queryAll" />
	<s:hidden name="queryRole" />
	<input type="hidden" id ="setPagesize" value="<s:property value="param._pagesize" />"/>	
</form>
</body>
<script type="text/javascript" src="/js/jquery.extend.js" ></script>
<script type="text/javascript" src="/js/jquery.table/jquery.table.pboss.js" ></script>
<SCRIPT type="text/javascript">
<!--
//@@声用一定要在使用之前
//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
var fmtLink = function(elCell, oRecord, oData,oColumnSet,row) { 
	var rtn = oData;
	if(oColumnSet.key=="sel"){
		rtn = '<input type="checkbox" name="_selectitem" value="'+ oRecord.operid +'" onclick="checkOne();">';
	}

	row.attr("dd","cc");
	return rtn;
}

// 查询显示列信息
var showCols = ${ShowCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin = {
	//CSS
	tableID:"jqTbl",
	tableClass:"table_style",//表格的CSS
	tHeadClass:"table_style_head",//表头的CSS
	tBodyClass:"table_style_content",//表内CSS
			
	showCols:showCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageNo:<s:property value="param._pageno" />,//指定第几页
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$('#btnQueryRole'),
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};


var doQuery = function() {
	var sPageSize = $("#frmQuery > #setPagesize").val();
	sPageSize = parseInt(sPageSize);
	if ($.isNumber(sPageSize)) optin.pageSize = sPageSize;
	$("#showTbl").queryTable(optin);
}
var doQueryRole = function(){
	var queryRole = $("input[name=queryRole]");

	//赋新查询值
	$("#frmQuery > #queryRole").val(queryRole.val());
	$("#frmQuery > #setPagesize").val("20");
	//alert(queryPage.val());
	doQuery();
}

$(document).ready(function() { 
	//绑定按钮
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQueryRole");
	//打开页面默认查询
	//页面启动按钮
	//queryBtn.attr("disabled",false);
	doQuery();
});//增加新的onload方法


//-->
</SCRIPT>
</html>


