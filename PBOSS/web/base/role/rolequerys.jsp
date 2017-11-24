<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><s:text name="roleselect" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function selectCode(code,name) {
    	    var a = new Array(2);
    	    a[0] =code; 
    	    a[1] =name;
    	    
    		window.returnValue = a[0]; 
			window.close();
    	}
    	function doSelect(){
        	formList.action="<%=contextPath%>/base/role_rolequerys.do";
        	formList.submit();
        }
    </script>
    <style>
.table_style_content {
	
}
.table_style_content td {
	border-right:#FFFFFF inset 2px;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #D7D7D7;
	font-family: "宋体";
	font-size: 12px;
	font-weight: normal;
	font-color: #666666;
	height: 24px;
	vertical-align: middle;
	<!--text-align:center;-->
	padding:0px 8px 0px 8px;
	word-break:break-all;
	white-space:nowrap;
}
</style>
	</head>

	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
			<s:form action="role_rolequerys.do" key="formList" cssStyle="formList"
				theme="simple" >
				<%
					//下面的控件给Action提供数据，用来分页
				%>
				<aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>

				<aa:zone name="errorZone">
					<div class="error_text">
						<table class="error_text">
							<s:actionerror />
							<s:actionmessage />
						</table>
					</div>
				</aa:zone>

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="center">
								<s:text name="roleid" />
								:
							</td>
							<td align="left">
								<s:textfield class="style_input" name="param._se_roleid" />
							</td>
							<td align="center">
								<s:text name="rolename" />
								:
							</td>
							<td align="left">
								<s:textfield class="style_input" name="param._sk_rolename" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:i18n name="public">
									<input type="button" id="btnQuery" name="btnQuery"
										class="button_Query" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_search"/>"
										onClick="doSelect();">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>

				<aa:zone name="listZone">
					<div class="table_div">
						<div class="table_LongTable">
							<table class="table_style">
								<tr class="table_style_head">
									<td><s:text name="roleid" /></td>
									<td><s:text name="rolename" /></td>
								</tr>
								<tr class="table_style_content" align="center"
									onMouseMove="this.bgColor='F0F5F9'"
									onMouseOut="this.bgColor='#ffffff'">
									<td>
										<a href="javascript:selectCode( '' ,'');"> 空值 </a>
									</td>
									<td>
										&nbsp;
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<td><a
											href="javascript:selectCode('<s:property value="roleid"/>','<s:property value="rolename"/>');"><s:property value="roleid" /></a></td>
										<td>
											<s:property value="rolename" />
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>
					<div class="table_div">
						<%@ include file="/common/pageNav.jsp"%>
					</div>
				</aa:zone>
			</s:form>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
	</body>
</html>
