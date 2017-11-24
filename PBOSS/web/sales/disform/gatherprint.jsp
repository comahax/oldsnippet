<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.jop.ui.User"%>
<%@ page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%
			User user = (User) request.getSession().getAttribute(
			WebConstant.SESSION_ATTRIBUTE_USER);
	String cityid = com.sunrise.jop.infrastructure.db.CityMappingUtil
			.getCityNo(user.getCityid());
%>
<html>
	<head>
		<title>中国移动广东公司<j:code2Name code="<%=cityid%>" definition="$region" />分公司业务用品配送单
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
			addfield('form.recename', '<s:text name="recename"/>', 'c', true, 32);
			addfield('form.recetel', '<s:text name="recetel"/>', 'c', true, 12);
			addfield('form.receadd', '<s:text name="receadd"/>', 'c', true, 256);
			addfield('form.discomcode', '<s:text name="discomcode"/>', 'c', true, 18);
			addfield('form.disstate', '<s:text name="disstate"/>', 'c', true, 10);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 256);
            return checkval(window);
        }
        
        function doSave(str) {
    		var ret = ev_checkval();   
    		if ( ret ) {
        		formList.action = "<%=contextPath%>/sales/disform_save.do?form.recid=" + str;
        		formList.submit();
    		}
    		return false;
		}
		
		function doPrint(){
			if(confirm('确认打印')){ 
				var bodyHtml  = window.document.body.innerHTML;
				var prnhtml=document.getElementById('printPart').innerHTML;
				window.document.body.innerHTML=prnhtml; 
				window.print();
				window.document.body.innerHTML = bodyHtml;
			}
		}
		
    </script>
	</head>
	<body>
		<s:form action="disform_edit.do" cssStyle="formList" key="formList"
			method="post" theme="simple" onsubmit="return ev_checkval();">

			<s:hidden name="CMD" />
			<s:hidden name="param._orderby" />
			<s:hidden name="param._desc" />
			<s:hidden name="param._pageno" />
			<s:hidden name="param._pagesize" />
			<s:hidden name="param._pk" />

			<input type="hidden" name="_rowcount"
				value="<s:property value="dp.rowCount" />" />

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td width="100%" align="center">
							<input type="button" id="btnPrint" name="btnPrint"
								class="button_2" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" onfocus="buttonover(this)"
								onblur="buttonout(this)" value="打印" onclick="doPrint();">
							<input type="button" id="btnClose" name="btnClose"
								class="button_Back" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" onfocus="buttonover(this)"
								onblur="buttonout(this)" value="返回" onclick="doReturn('/sales/disform_gather.do');">
						</td>
					</tr>
				</table>
			</div>
			<div class="table_container">
				<div id="printPart">
					<div class="table_div">
						<table class="table_print_title">
							<tr>
								<td>
									中国移动广东公司<j:code2Name code="<%=cityid%>" definition="$region" />分公司业务用品配送汇总单
								</td>
							</tr>
						</table>
					</div>
					<br>
					<br>
					<div class="table_div">
						<table class="table_print">
							<tr>
								<td align="right">
									<s:text name="discomcodename" />
									:&nbsp
								</td>
								<td align="left">
									<j:code2Name definition="#WAY" code="form.discomcode" />
								</td>
									<td align="right">
									<s:text name="contactname" />
									:&nbsp
								</td>
								<td align="left">
									<s:property value="form.recename" />
								</td>
							</tr>
							<tr>
								<td align="right">
									<s:text name="outadd" />
									:&nbsp
								</td>
								<td align="left">
									<j:code2Name definition="#CNTYCOMPANY" code="form.countyid" />仓库
								</td>
								<td align="right">
									<s:text name="disadd" />
									:&nbsp
								</td>
								<td align="left">
									<j:code2Name definition="#CNTYCOMPANY" code="form.countyid" />社会网点
								</td>
							</tr>
							<tr>
								<td align="right">
									创建时间
									:&nbsp
								</td>
								<td align="left" colspan="3">
									<s:property value="form.gathercreatetime" />
								</td>
							</tr>
						</table>
					</div>
					<br>
					<aa:zone name="listZone">
						<div class="table_div">
							<table class="table_print_style">
								<tr class="table_style_print_head">
									<td width="3%">
										序号
									</td>
									<td width="39%">
										<s:text name="comname" />
									</td>
									<td width="3%">
										<s:text name="orderamt" />
									</td>
									<td width="3%">
										<s:text name="comprice" />
									</td>
									<td width="13%">
										<s:text name="orincomprice" />
									</td>
									<td width="13%">
										<s:text name="sellprice" />
									</td>
									<td width="13%">
										<s:text name="orinsellprice" />
									</td>
									<td width="13%">
										<s:text name="memo" />
									</td>
								</tr>
								<s:iterator value="dp.datas" status="state">
									<tr class="table_style_print" align="center">
										<%-- 复合主键用“|”间隔开 --%>
										<td>
											 <s:text name="#state.count"/>
										</td>
										<td>
											<j:code2Name definition="#COM"
												code="comid" />
										</td>
										<td>
											<s:property value="num" />
										</td>
										<td>
											<s:i18n name="public">
												<s:text name="format.double">
													<s:param value="%{comprice/100}" />
												</s:text>
											</s:i18n>
										</td>
										<td>
											<s:i18n name="public">
												<s:text name="format.double">
													<s:param value="%{orincomprice/100}" />
												</s:text>
											</s:i18n>
										</td>
										<td>
											<s:i18n name="public">
												<s:text name="format.double">
													<s:param value="%{sellprice}" />
												</s:text>
											</s:i18n>
										</td>
										<td>
											<s:i18n name="public">
												<s:text name="format.double">
													<s:param value="%{orinsellprice}" />
												</s:text>
											</s:i18n>
										</td>
										<td>
											<s:property value="memo" />
										</td>
									</tr>
								</s:iterator>
								<tr class="table_style_print" align="center">
									<td colspan="2">
										合计:
									</td>
									<td>
										<s:property value="form.totalnum" />
									</td>
									<td>
									</td>
									<td>
										<s:i18n name="public">
											<s:text name="format.double">
												<s:param value="%{form.totalorincomprice/100}" />
											</s:text>
										</s:i18n>
									</td>
									<td>
									</td>
									<td>	
										<s:i18n name="public">
											<s:text name="format.double">
												<s:param value="%{form.totalorinsellprice}" />
											</s:text>
										</s:i18n>
									</td>
								</tr>
							</table>
						</div>
						<div class="table_div">
						<table class="table_print">
							<tr>
								<td align="center" width="50%">
									注:金额单位(元)
								</td>
								<td>
								</td>
							</tr>
						</table>
						</div>
						<div class="table_div">
							<div class="table_positon">
								<table class="table_print">
									<tr>
										<td align="right" width="10%">
											<s:text name="storesman" />
											:&nbsp
										</td>
										<td align="left" width="10%">
											<s:property value="form.storesman" />
										</td>
										<td align="right">
											<s:text name="outtime" />
											:&nbsp
										</td>
										<td align="left" width="10%" colspan="2">
											<s:date name="form.outtime" format="yyyy-MM-dd HH:mm:ss" />
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
									</tr>
									<tr>
										<td align="right" width="10%">
											审核人
											:&nbsp;
										</td>
										<td align="left" width="10%">
										</td>
										<td align="right" width="10%">
											审核时间
											:&nbsp;
										</td>
										<td align="left" width="10%">
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
									</tr>
									<tr>
										<td align="right" width="10%">
											收货人 :&nbsp
										</td>
										<td align="left" width="10%">
										</td>
										<td align="right" width="10%">
											收货日期 :&nbsp
										</td>
										<td align="left" width="10%">
										</td>
									</tr>
								</table>
							</div>
						</div>

					</aa:zone>
				</div>
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
