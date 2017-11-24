<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
	<head>
		<title>配送单资源明细
		</title>
		<script language="JavaScript" type="text/JavaScript">
		function ev_check() {
			return checkval(window);
		}
		
		function doExport(){
			formList.action="<%=contextPath%>/sales/disform_exportExcel.do";
    		formList.submit();
    		formList.action="<%=contextPath%>/sales/disform_showrecord.do";
		}
		</script>
	</head>
	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		
		<div class="table_container">
			<s:form action="disform_showrecord.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				
				<s:hidden name="form.recid" />
				<s:hidden name="form.orderid" />
				
				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />
			

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="sales" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h">配送单资源明细
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
				
				<aa:zone name="listZone">
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align="right">
								<s:text name="recid" />:
							</td>
							<td align="left">
								<s:property value="form.recid" />
							</td>
							<td align="right">
								<s:text name="orderid" />:
							</td>
							<td align="left">
								<s:property value="form.orderid" />
							</td>
						   <td>
						   	 <input type="button" class="button_4" onmouseover="buttonover(this);"
			                      	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                   		value="导出EXCEL" onClick="doExport();"/>
			                 <input type="button" class="button_2" onmouseover="buttonover(this);"
			                      	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                   		value="返回" onClick="doReturn('/sales/disform_list.do')"/>			          
			               </td> 	
						</tr>
					</table>
				</div>

				<div class="table_div">
						<div class="table_LongTable">
							<table class="table_style">
								<tr class="table_style_head">
						
							<td><s:text name="detid" /></td>	
							<td><s:text name="comcategory" /></td>	
							<td><s:text name="comid" /></td>	
							<td><s:text name="comid1" /></td>	
							<td><s:text name="batchno" /></td>
							<td><s:text name="boxnum" /></td>
							<td><s:text name="comresid" /></td>
							
						</tr>
						<s:iterator value="dp.datas">						
							<tr class="table_style_content" align="center">
							<td>
								<s:property value="detid" />
							</td>
							<td>
								<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory" />
							</td>
							<td>
								<s:property value="comid" />
							</td>
							<td>
								<j:code2Name definition="#COMSYSTEM" code="comid" />
							</td>
							<td>
								<s:property value="batchno" />
							</td>
							<td>
								<s:property value="boxnum" />
							</td>
							<td>
								<s:property value="comresid" />
							</td>														
							</tr>
						</s:iterator>
					</table>
				</div>
				<div class="table_div">
						<%@ include file="/common/pageNav.jsp"%>
					</div>
				</aa:zone>
			</s:form>
		</div>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
	</body>
</html>
