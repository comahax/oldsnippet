<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" /></title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
		function ev_check() {
            return checkval(window);
        }
		
    	function doQuery(cmdQuery){
			trimAllSpaces();
			resetPage();
			if(cmdQuery != null && cmdQuery !="")
			formList.action = contextPath + cmdQuery;
			formList.submit();
		}
		function trimAllSpaces() {
			for(var i=0;i<document.forms[0].elements.length;i++) {
				if(formList.elements[i].type=='text') {
					formList.elements[i].value=trim(formList.elements[i].value);
				}
			}
		}

	
		</script>
	</head>

	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="netway_list.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<s:hidden name="flag"/>
				<aa:zone name="hiddenZone">
					<s:hidden name="param._orderby" />
					<s:hidden name="param._desc" />
					<s:hidden name="param._pageno" />
					<s:hidden name="param._pagesize" />
					<s:hidden name="param.queryAll" />
					<input type="hidden" name="_rowcount"
						value="<s:property value="dp.rowCount" />" />
				</aa:zone>

				<!--##################################添加标题内容，里面可以放置按钮##################################################-->
				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="channel" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpList"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n> </span>
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

				<!--#################################添加标题内容，里面可以放置按钮###################################################-->
				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="center">
								<s:text name="wayid" />:
							</td>
							<td align="left">
							<j:selector cssStyle="style_input" name="param._sk_wayid" definition="#WAY" readonly="true" 
							condition="waytype:EC;waysubtype:NET;cityid:${dBAccessUser.cityid}"/>
							</td>
							<td align="center">
								<s:text name="wayname" />:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_wayname" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="waysubtype" />:
							</td>
							<td align="left">
							<j:selector name="param._se_waysubtype" definition="NETWAYSUBTYPE" />
							</td>
							<td align="center">
								<s:text name="waystate" />:
							</td>
							<td align="left">
								<j:selector definition="$CH_VALIDFLAG" name="param._ne_waystate" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="cityid" />:
							</td>
							<td align="left">
							
								<j:selector definition="CITYNAME" name="param._se_cityid"
									mode="selector" value="${dBAccessUser.cityid }" disabled="true"/>
							</td>
							<td align="center">
								&nbsp
							</td>
							<td align="left">
							&nbsp
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:i18n name="public">
									<!--按钮的左中右位置分别为 form_table_left、form_table_center、form_table_right-->
									<input type="button" id="btnQuery" name="btnQuery"
										class="button_Query" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="查询"
										onClick="doQuery('/channel/netway_list.do');">
									<input type="button" id="btnNew" name="btnNew"
										class="button_New" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_new"/>"
										onClick="doNew('/channel/netway_new.do')">
									<input type="button" id="btnDelete" name="btnDelete"
										class="button_Delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_delete"/>"
										onClick="doDelete('/channel/netway_delete.do')">
									
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
										<j:orderByImg href="javascript:doOrderby('wayid')">
											<s:text name="wayid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayname')">
											<s:text name="wayname" />
										</j:orderByImg>
									</td>
									
									<td>
										<s:text name="waysubtype" />
									</td>
									<td>
										<s:text name="upperwayid" />
									</td>
									<td>
										<s:text name="cityid" />
									</td>
									<td>
										<s:text name="starttime" />
									</td>
									<td>
										<s:text name="bchlevel" />
									</td>
									<td>
										<s:text name="waystate" />
									</td>
									<td>
										<s:text name="address"/>
									</td>
									<td>
										<s:text name="creditlevel"/>
									</td>
									<td>
									<s:text name="taxcertificate"/>
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<td>
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="wayid"/>" onclick="checkOne();">
										</td>
										<td>
											<a href='<s:url action="/channel/netway_edit.do">
					                         <s:param name="param._pk" value="wayid"/>
					                     	</s:url>'><s:property value="wayid" /></a>
										</td>
										<td>
											<s:property value="wayname" />
										</td>
										
										<td>
											<j:code2Name definition="NETWAYSUBTYPE" code="waysubtype" />
										</td>
										<td>
											<j:code2Name code="upperwayid" definition="#WAY" />
										</td>
										<td>
											<j:code2Name code="cityid" definition="CITYNAME" />
										</td>
										 <td> <s:date name="starttime" format="yyyy-MM-dd" /></td>
										<td>
											<j:code2Name code="bchlevel" definition="$CH_BCHLEVEL" />
										</td>
										<td>
											<j:code2Name code="waystate" definition="$CH_VALIDFLAG" />
										</td>
										 <td>
										<s:property value="address" />
									</td>
									<td>
									<j:code2Name code="creditlevel" definition="$CH_CREDITLEVEL" />
									</td>
									<td>
									<s:property value="taxcertificate" />
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
