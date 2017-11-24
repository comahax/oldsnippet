<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="roleset" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function doReturn(cmdReturn) {
        	formList.action = contextPath + cmdReturn;
        	formList.submit();
        }
    </script>
	</head>

	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="role_rolesetlist.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<%
					//下面的控件给Action提供数据，用来分页
				%>
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="base" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n>
						</span>
					</div>
				</div>

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
						<tr>
							<td align="center">
								<s:text name="opercode" />
								:
							</td>
							<td>
								<s:textfield class="style_input" name="param._se_orgid" />
							</td>
							<td></td>
							<td></td>
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
										onClick="doQuery('/base/role_list.do');">

									
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);" 
                    	   				onmouseout="buttonout(this);" onfocus="buttonover(this)" 
                    	   				onblur="buttonout(this)"
                           				value="<s:text name="button_return"/>" 
                           				onclick="doReturn('/base/operator_list.do')">
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
									<s:i18n name="public">
										<td title="<s:text name="list_title_select"/>">
											<input type="checkbox" name="allbox" onclick="checkAll();" />
										</td>
									</s:i18n>
									<td>
										<a href="javascript:doOrderby('roleid')"><s:text
												name="roleid" />
										</a>
									</td>
									<td>
										<a href="javascript:doOrderby('rolename')"><s:text
												name="rolename" />
										</a>
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<%-- 复合主键用“|”间隔开 --%>
										<td>
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="roleid"/>" onclick="checkOne();">
										</td>
										<td>
											<a
												href='<s:url action="role_edit.do">
	                         <s:param name="param._pk" value="roleid"/>
	                     	</s:url>'>
												<s:property value="roleid" /> </a>
										</td>
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
				
				<div class="table_div">
        			<table class="table_normal">
            			<tr>
                			<td width="100%" align="right">
                   				<s:i18n name="public">
                    				<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                          		 	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                         		  	value="<s:text name="button_save"/>" onclick="doSave('/base/operrole_save.do')"/>
								</s:i18n>
               				 </td>
            			</tr>
        			</table>
    			</div>
			</s:form>
		</div>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
	</body>
</html>
