<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '32');
            return checkval(window);
        }
        
		function doNew(str) {
   		 	formList.action ="<%=contextPath%>/promotion/rewardstd_new.do?pk=" + str;
   			formList.submit();
		}
		
		function forincheck(TO,sis,msg){
    	if (sis != null) {
        	if (sis.length != null) {
           		for (var i = 0; i < sis.length; i++) {
                	var e = sis[i];
                	if (e.type == 'checkbox') {
                    	if (e.checked)
                        	TO = false;
                	}
            	}
        	} else {
            	var e = sis;
            		if (e.type == 'checkbox') {
                		if (e.checked)
                    		TO = false;
            		}
        		}
    		}
   			if (TO) {
        		alert(msgNoSelected);
        		return false;
    		}

   			if (!confirm(msg)) {
        		return false;
    		}
    		return true;
		}

		function doDelete(str, str1){
			var TO = true;
   			var sis = formList.all("param._selectitem");   
    		if (forincheck(TO,sis,msgConfirmDelete)){    
				formList.action ="<%=contextPath%>/promotion/rewardstd_delete.do?pk="+ str + "&pk1=" + str1;
				formList.submit();
			}else{
				formList.action ="<%=contextPath%>/promotion/rewardstd_list.do?pk="+ str + "&pk1=" + str1;
				formList.submit();
			}
		}
		
		function doQuery(str, str1){
			formList.action ="<%=contextPath%>/promotion/rewardstd_list.do?pk=" + str + "&pk1=" + str1;
			formList.submit();
		}
		
		function doReturn(str, str1){
			formList.action ="<%=contextPath%>/promotion/ppzlnrule_list.do?param._pk=" + str + "&isActive=" +str1;
			formList.submit();
		}
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="rewardstd_list.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<%
				//下面的控件给Action提供数据，用来分页
				%>
				<aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<s:hidden name="form.ruleid" />
				<s:hidden name="form.pid" />
				<s:hidden name="form.isEnabled" />
				<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="promotion" /> </span>
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
								<s:text name="comcategory" />
								:
							</td>
							<td align="left">
								<j:selector definition="$IM_FXCOMCATEGORY" mode="picker" 
									name="param._se_comcategory" cssStyle="style_input" />
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
										onClick="doQuery(document.all['form.ruleid'].value, document.all['form.pid'].value);loadforiframe();">
								<s:if test="form.isEnabled=='isActive'">
									<input type="button" id="btnNew" name="btnNew"
										class="button_New" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_new"/>"
										onClick="doNew(document.all['form.pid'].value)" disabled="true">

									<input type="button" id="btnDelete" name="btnDelete"
										class="button_Delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_delete"/>"
										onClick="doDelete(document.all['form.ruleid'].value, document.all['form.pid'].value);loadforiframe();" disabled="true">
								</s:if>
								<s:else>
									<input type="button" id="btnNew" name="btnNew"
										class="button_New" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_new"/>"
										onClick="doNew(document.all['form.pid'].value)">

									<input type="button" id="btnDelete" name="btnDelete"
										class="button_Delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_delete"/>"
										onClick="doDelete(document.all['form.ruleid'].value, document.all['form.pid'].value);loadforiframe();">
								</s:else>
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_6" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="返回方案规则"
										onclick="doReturn(document.all['form.pid'].value,document.all['form.isEnabled'].value)">
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
										<td width="15px" title="<s:text name="list_title_select"/>">
											<input type="checkbox" name="allbox" onclick="checkAll();" />
										</td>
									</s:i18n>
									<td>
										<j:orderByImg href="javascript:doOrderby('ruleid')">
											<s:text name="ruleid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('comcategory')">
											<s:text name="comcategory" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('comcategory')">
											<s:text name="comcategoryname" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('reward')">
											<s:text name="reward" />
										</j:orderByImg>
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<%-- 复合主键用“|”间隔开 --%>
										<td>
											<s:hidden value="ruleid" />
											<s:hidden value="pid" />
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="comcategory + '|' + ruleid"/>"
												onclick="checkOne();">
										</td>
										<td>
											<s:if test="form.isEnabled=='isActive'">
												<s:property value="ruleid" />
											</s:if>
											<s:else>
											<a
												href='<s:url action="rewardstd_edit.do">
	                        					<s:param name="param._pk" value="comcategory + '|' + ruleid"/>
	                         					<s:param name="param.pid" value="form.pid"/>
	                     						</s:url>'>
												<s:property value="ruleid" /></a>
											</s:else>
										</td>
										<td>
											<s:property value="comcategory" />
										</td>
										<td>
											<j:code2Name definition='$IM_FXCOMCATEGORY'
												code="comcategory" />
										</td>
										<td>
											<s:i18n name="public">
												<s:property value="%{getText('format.double',{reward})}" />
											</s:i18n>
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
		</div>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
	</body>
</html>
