<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<% String ID_ADD = "CH_PW_SYSTEMROLE"; %>

<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
    	var contextPath = '<%=contextPath%>';
        function ev_check() {
        	addfield('form.roleid', '<s:text name="roleid"/>', 'c', false, 16);
            return checkval(window);
        }
        function doQueryTree(){
        	var _sk_opername = formList._sk_opername.value;
        	var url = contextPath + "/base/operrole_operrolelist.do?param._desc=0";
        	formList.action = url;
        	formList.submit();
        }
        
        function doBatchSave(){
        	if(isCheck()){
        		if(ev_check()){
		        	var url = contextPath + "/base/operrole_batchsave.do";
		        	formList.action = url;
		        	formList.submit();
	        	}
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
	        	alert('操作员列表至少选择一项!');
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
		
		function doRoleSelect(){
        	var url="<%=contextPath%>/base/role_roleselect.do";
        	var rtn=window.showModalDialog(url , self , "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
        	if (rtn != null && rtn.length) {
        		document.all('form.roleid').value = rtn;
        		return rtn;
        	}
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
<div class="table_container">
<s:form action="operrole_operrolelist.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">

    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>

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
				<td align="right"><s:text name="roleid"/>:&nbsp</td>
				<td align="left">
                    <s:textfield class="style_input" name="form.roleid" readonly="true"/><input type="button" class="picker_button" value="..." onClick="doRoleSelect();"/>
                    <font color=red>*</font>
                </td>
			</tr>
			<tr>
				<td align="right"><s:text name="operid"/>:&nbsp</td>
				<td>
					<div class="table_div">
						<div class="table_normal">
						<table class="table_style">
			  			<tr class="table_style_head">
							<td>
								<input type="checkbox" name="allbox" onclick="checkAll();"/>
			  				 </td>
			  				 <td>
			  				 	工号
			  				 </td>
			  				 <td>
			  				 	姓名
			  				 </td>
			  			</tr>
			  			<s:iterator value="dp.datas">
							<tr class="table_style_content" align="center"
								onMouseMove="this.bgColor='F0F5F9'"
								onMouseOut="this.bgColor='#ffffff'">
								<%-- 复合主键用“|”间隔开 --%>
								<td>
									<input type="checkbox" name="_selectitem"
										value="<s:property value="operid"/>" onclick="checkOne();">
								</td>
								<td>
									<s:property value="operid" />
								</td>
								<td>
									<s:property value="opername" />
								</td>
							</tr>
						</s:iterator>
						<tr>
							<td colspan="3">
								<%@ include file="/common/pageNav.jsp"%>
							</td>
						</tr>
			  			<tr class="table_button_list1">
			  				<td colspan="3">
			  				工号查询:<s:textfield cssStyle="style_input" name="_sk_opername" />
				  				<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="查询" onClick="doQueryTree();">
                            </td>
			  			</tr>
		  				</table>
			  		</div>
				</td>
			</tr>
			</table>
			<div class="table_div">
			<table class="table_button_list">
			<tr>
				<td colspan="2" align="right">
					<j:purChk permid="<%=ID_ADD%>">
					<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="保存" onclick="doBatchSave();"/>
                    </j:purChk>
					<input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="返回" onclick="doReturn('/base/operrole_list.do');">
				</td>
			</tr>
		</table>
		</div>
	</div>
</s:form>
</div>
</body>
</html>


