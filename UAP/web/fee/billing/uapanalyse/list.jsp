<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/inc/listhead.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>
		<s:text name="title" />
		</title>
		
		<script language="JavaScript" type="text/JavaScript">
			function doExcelOut(url) {			
        		setExcelOutPage(url);        
       		}
   	 	</script>
	</head>
	<body onload="loadforiframe1()">
		<s:form name="formList" id="formList" action="uapanalyse_list.do"
			theme="simple">
			<aa:zone name="hiddenZone">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<s:hidden name="param.startindex" />
				<s:hidden name="param.endindex" />

				<input type="hidden" name="param._ne_logid" value="${requestScope.logid}"/>
				<input type="hidden" name="param._ne_rule_id" value="${requestScope.req_type}"/>
				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />
				<input type="hidden" id="maxRowCount" value="10" />
				<!--change it if you need-->
				<input type="hidden" name="ajaxFlag" id="ajaxFlag" />
			</aa:zone>
			<div class="widgetL">
					<div class="content">
						<!-- 导出功能按钮 begin -->
						<div class="search2">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="8" align="right">											
										<s:i18n name="public">
											<input type="button" class="bt48_gray"
												value="<s:text name="button_export"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doExcelOut('/fee/billing/uapanalyse_excel.do?description=${requestScope.description}')" />
										</s:i18n>
									</td>
								</tr>
							</table>
						</div>
						<!-- 导出功能按钮 end -->
						<div class="list_table overflow_scroll"  style="OVERFLOW-Y:HIDDEN; width=100%;">
						<!-- width根据实际的宽度设置如： width=100%、width=2000px -->
							<table width="100%" border="0" cellspacing="0" cellpadding="0" >
								<thead>
									<tr>
										<td nowrap><s:text name="areqtype"/></td>
										<s:if test="%{#request.description == '费项' || #request.description == '无主原因' || #request.description == '账单类型'}">
											<td nowrap><s:text name="%{#request.description}"/></td>
										</s:if>
										<td nowrap><s:text name="avalidbillcyc"/></td>
										<td nowrap><s:text name="cmpmonth"/></td>
										<td nowrap><s:text name="thismnthcount"/></td>
										<td nowrap><s:text name="slastmnthcount"/></td>
										<td nowrap><s:text name="thismnthamt"/></td>
										<td nowrap><s:text name="slastmnthamt"/></td>
										<td nowrap><s:text name="countchgrate"/></td>
										<td nowrap><s:text name="amtchgrate"/></td>
										<td nowrap><s:text name="atime"/></td>
										<td nowrap><s:text name="remark"/></td>
									</tr>
								</thead>
								
								<tbody>
								<s:iterator value="#request.LIST.datas" var="item" status="status">
						        <s:if test="#status.odd">
									<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
								</s:if>
								<s:else>
									<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
								</s:else>
										<td nowrap><j:code2Name definition="$IB_REQ_UAP" dbFlag="BILL" code="${requestScope.req_type}" /></td>
										<s:if test="#request.description == '费项'">
											<td nowrap>
												<s:property value="#item.key_column"/>&nbsp;
												<j:code2Name definition="#WOFF-ACCT" dbFlag="BILL" code="#item.key_column" />
											</td>
										</s:if>
										<s:if test="#request.description == '无主原因' || #request.description == '账单类型'">
											<td nowrap><s:property value="#item.key_column"/></td>
										</s:if>
										<td nowrap><s:property value="#item.validbillcyc"/></td>
										<td nowrap><s:property value="#item.cmp_month"/></td>
										<td nowrap><s:property value="#item.curcnt"/></td>
										<td nowrap><s:property value="#item.cmpcnt"/></td>
										<td nowrap><fmt:formatNumber value="${item.curamt/100}" type="currency" /></td>
										<td nowrap><fmt:formatNumber value="${item.cmpamt/100}" type="currency" /></td>
										<td nowrap><fmt:formatNumber value="${item.chgrate_count*100}" pattern="#0.00" />%</td>
										<td nowrap><fmt:formatNumber value="${item.chgrate_amt*100}" pattern="#0.00" />%</td>
										<td nowrap><s:date format="yyyy-MM-dd HH:mm:ss" name="#item.uptime"/></td>
										<td nowrap><s:property value="#item.remark"/></td>			
								</s:iterator>
		                        </tr>
								</tbody>
							</table>
						</div>
						<%@ include file="/common/pageNav.jsp"%>
					</div>

			</div>
		</s:form>
	</body>
</html>