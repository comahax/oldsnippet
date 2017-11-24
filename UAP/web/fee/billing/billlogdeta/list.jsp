<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/inc/listhead.inc"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>
		<s:text name="title1" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
			function doExcelOut(url) {			
        		setExcelOutPage(url);        
        }  
   	 	</script>
	</head>
	<body onload="loadforiframe1();">
		<s:form name="formList" id="formList" action="billlogdeta_list.do"
			theme="simple">
			<aa:zone name="hiddenZone">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<s:hidden name="param.startindex" />
				<s:hidden name="param.endindex" />
				<input type="hidden" name="_rowcount"
					value="<s:property value="#request.LIST.rowCount" />" />
				<input type="hidden" id="maxRowCount" value="10" />
				<!--change it if you need-->
				<input type="hidden" name="ajaxFlag" id="ajaxFlag" />
			</aa:zone>
			<div class="widgetL">
				<div class="wCenter">
					<div class="content">
						<div class="title_name">
							<s:text name="title1" />
						</div>
						<aa:zone name="errorZone">
							<div class="error_text">
								<s:actionerror />
								<s:actionmessage />
							</div>
						</aa:zone>
						
						<div class="search2">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th><s:text name="validbillcyc" />:</th>
									<td align="left">
										<s:textfield cssClass="Wdate" name="form._ne_validbillcyc" id="validbillcyc" readonly="true" onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
									</td>
									
									<th><s:text name="process"/>:</th>
									<td>
										<j:selector id="form._sk_subphase" name="form._sk_subphase" definition="$IB_WL_RHBILLLOGDETA" cssClass="input" mode="selector" />
									</td>
								</tr>
								<tr>
									<td colspan="4" align="right">
										<s:i18n name="public">
											<input type="button" class="bt48_gray"
												value="<s:text name="button_search"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doQuery()" />
											<input type="button" class="bt48_gray"
												value="<s:text name="button_excelout"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doExcelOut('/fee/billing/billlogdeta_excel.do')" />
										</s:i18n>
									</td>
								</tr>
							</table>
						</div>

						<div class="list_table overflow_scroll"  style="OVERFLOW-Y:HIDDEN; width=100%;">
						<!-- width根据实际的宽度设置如： width=100%、width=2000px -->
							<table width="100%" border="0" cellspacing="0" cellpadding="0" >
								<thead>
									<tr>
										<td nowrap><s:text name="validbillcyc"/></td>
										<td nowrap><s:text name="subphase"/></td>
										<td nowrap><s:text name="acctid"/></td>
										<td nowrap><s:text name="acctname"/></td>
										<td nowrap><s:text name="acctamt"/></td>
										<td nowrap><s:text name="acctcount"/></td>
									</tr>
								</thead>
								
								<tbody>
								<s:iterator value="#request.LIST.datas"  var="item" status="status">
						        <s:if test="#status.odd">
									<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
								</s:if>
								<s:else>
									<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
								</s:else>
								
										<td nowrap><s:property value="#item.validbillcyc"/></td>	
										<td nowrap>
											<s:property value="#item.subphase"/> <j:code2Name definition="$IB_WL_RHBILLLOGDETA" code="#item.subphase"/>
										</td>
										<td nowrap><s:property value="#item.acctid"/></td>
										<td nowrap><j:code2Name definition="#WOFF-ACCT" dbFlag="BILL" code="acctid" /></td>
										<td nowrap><fmt:formatNumber value="${item.acctamt}" type="currency" /></td>
										<td nowrap><s:property value="#item.acctcount"/></td>							
								</s:iterator>
		                        </tr>
								</tbody>
							</table>
						</div>
						<%@ include file="/common/pageNav.jsp"%>
					</div>
				</div>
			</div>
		</s:form>

	</body>
</html>