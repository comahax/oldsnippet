<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param._se_tmplid','<s:text name="tmplid"/>', 'd', true, 6);
        	addfield('param._sk_tmplname','<s:text name="mplname"/>', 'c', true, 50);
        	addfield('param._se_gatheringmode','<s:text name="gatheringmode"/>', 'c', true, 32);
        	addfield('param._se_state','<s:text name="state"/>', 'c', true, 32);
        	
            return checkval(window);
        }
        
        function doUpdate(cmd) {
     	  formList.action = contextPath + cmd;
      	  formList.submit();
		}
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="elmttmpl_list.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />

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
								<s:text name="tmplid" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._se_tmplid" />
							</td>
							<td align="center">
								<s:text name="tmplname" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_tmplname" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="gatheringmode" />
								:
							</td>
							<td align="left">
								<j:selector definition="$CH_GATHERINGMODE"
									name="param._se_gatheringmode" cssStyle="select" />
							</td>
							<td align="center">
								<s:text name="state" />
								:
							</td>
							<td align="left">
								<j:selector definition="$CH_KHSTATE" name="param._se_state"
									cssStyle="select" />
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
										onClick="doQuery('/promotion/elmttmpl_list.do');">

									<input type="button" id="btnNew" name="btnNew"
										class="button_New" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_new"/>"
										onClick="doNew('/promotion/elmttmpl_new.do')">

									<input type="button" id="btnDelete" name="btnDelete"
										class="button_Delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_delete"/>"
										onClick="doDelete('/promotion/elmttmpl_delete.do')">
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
										<j:orderByImg href="javascript:doOrderby('tmplid')">
											<s:text name="tmplid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('tmplname')">
											<s:text name="tmplname" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('gatheringmode')">
											<s:text name="gatheringmode" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('state')">
											<s:text name="state" />
										</j:orderByImg>
									</td>
									<td>
										<s:text name="operate" />
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<td>
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="tmplid"/>" onclick="checkOne();">
										</td>
										<td>
											<a
												href='<s:url action="elmttmpl_edit.do">
	                         <s:param name="param._pk" value="tmplid"/>
	                     	</s:url>'>
												<s:property value="tmplid" /> </a>
										</td>
										<td>
											<s:property value="tmplname" />
										</td>
										<td>
											<j:code2Name definition="$CH_GATHERINGMODE"
												code="gatheringmode" />
										</td>
										<td>
											<j:code2Name definition="$CH_KHSTATE" code="state" />
										</td>
										<s:if test="state==1">
											<td width="50px">
												<input type="button" id="btnUpdate" name="btnUpdate"
													class="button_2" onmouseover="buttonover(this);"
													onmouseout="buttonout(this);" onfocus="buttonover(this)"
													onblur="buttonout(this)" value="Ê§Ð§"
													onClick="doUpdate('/promotion/elmttmpl_update.do?form.tmplid=<s:property value="tmplid"/>')">
											</td>
										</s:if>
										<s:else>
											<td width="50px">
												<input type="button" id="btnUpdate1" name="btnUpdate1"
													class="button_2" onmouseover="buttonover(this);"
													onmouseout="buttonout(this);" onfocus="buttonover(this)"
													onblur="buttonout(this)" value="ÉúÐ§"
													onClick="doUpdate('/promotion/elmttmpl_update.do?form.tmplid=<s:property value="tmplid"/>')">
											</td>
										</s:else>
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
