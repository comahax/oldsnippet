<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="com.sunrise.boss.ui.resmanage.common.MainprodTreeBean" %>
<%@ include file="/inc/listhead.inc"%>

<%
	String selectType = request.getParameter("selectType");
	selectType = StringUtils.isBlank(selectType) ? "1":selectType;
%>


<script type="text/javascript" src="<%=contextPath%>/js/dtree.js"></script>
<html>
	<head>
		<base target="_self" />
		<title><bean:message bundle="title" key="selectMainprod" /></title>
		<script type="text/javascript">
			var contextPath = '<%=contextPath%>/';
		</script>

		<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/table.css" />
		<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/xtree.css" />
		<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/button.css" />
		<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/dtree.css" />
	</head>
	<style>
	.waytree_div {
		width:323px;
		height: 300px;
		overflow: auto;
		padding-left: 20px
	}
</style>
	<body onload="selectDefault();">
		<div class="table_div">
			<table class="top_table">
				<tr>
					<td>
						<bean:message bundle="title" key="selectMainprod" />
					</td>
				</tr>
			</table>
		</div>

		<div class="table_div">
			<table width="100%" class="error_text">
				<s:Msg />
			</table>
		</div>
		
		<div class="table_div">
			<div class="tree_style">
				<script type="text/javascript">
       			<%
       				MainprodTreeBean treeBean = new MainprodTreeBean();
       				treeBean.setSelectType(selectType);
       				out.print(treeBean.getMainprodTree(request));
       			%>
        		</script>
			</div>
		</div>
		
		<div class="table_div">
			<table class="table_button_list">
				<tr>
					<td>
						<%
						if(selectType.equals("1")){
						%>
						<input type="button" onmouseover="buttonover(this);"
							onmouseout="buttonout(this);" name="btnCancel"
							onfocus="buttonover(this)" onblur="buttonout(this)"
							value='<bean:message bundle="public" key="button_cancel" />'
							class="submit" onclick="cancel();">
						<%
						}else{
						%>
						<input type="button" onmouseover="buttonover(this);"
							onmouseout="buttonout(this);" name="btnCancel"
							onfocus="buttonover(this)" onblur="buttonout(this)"
							value='<bean:message bundle="public" key="button_sure" />'
							class="submit" onclick="btnSubmit();">
						<input type="button" onmouseover="buttonover(this);"
							onmouseout="buttonout(this);" name="btnCancel"
							onfocus="buttonover(this)" onblur="buttonout(this)"
							value='<bean:message bundle="public" key="button_clear" />'
							class="submit" onclick="clearValue();">
						<input type="button" onmouseover="buttonover(this);"
							onmouseout="buttonout(this);" name="btnCancel"
							onfocus="buttonover(this)" onblur="buttonout(this)"
							value='<bean:message bundle="public" key="button_close" />'
							class="submit" onclick="cancel();">
						<% }%>
					</td>
				</tr>
			</table>
		</div>

	</body>
	<script type="text/javascript">	
	
	//******************** 单选或空值 ********************//
	function selectMainprod(mainprodInfo) {	
			window.returnValue = mainprodInfo;		
			window.close();
	}	
	
	//********************* 多选用 ***********************//
	function btnSubmit(){
		var prodidValue = "";
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for(var i=0; i<len; i++){
			if((el[i].type=="checkbox") && (el[i].name=="prodid_checkbox")){
				if(el[i].checked==true){
					if(el[i].value!=""){
						prodidValue+=","+el[i].value;
					}
				}
			}
		} 
		window.returnValue = prodidValue;		
		window.close();
	}
	
	function clearValue() {
		window.returnValue = "clear";		
		window.close();
	}
	
		
	//********************* 取消/关闭 ********************//
	function cancel() {
		window.returnValue = null;		
		window.close();
	}
	
	
	//********* 用于多选情况，页面加载时，勾选默认值 ***********//
	function selectDefault(){
		var array = window.dialogArguments;
		var defaultValue = array[0];
		if(typeof(defaultValue) != undefined && defaultValue != null && defaultValue != ''){
			d.openAll(); // 当默认值不为空时，展开树 
			defaultValue = ","+defaultValue+","; // 前后加逗号，方便下面判断
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for(var i=0; i<len; i++){
				if(el[i].type=="checkbox" && el[i].name=="prodid_checkbox"){
					if(defaultValue.indexOf(","+el[i].id+",") != -1){// 使用复选框的id做标识
						el[i].checked = true;
					}
				}
			} 
		}
	}
	
</script>
</html>
