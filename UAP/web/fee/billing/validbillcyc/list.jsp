<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/listhead.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>
		<s:text name="title" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_region', '<s:text name="region"/>', 'i', true, 5);
            addfield('param._ne_validbillcyc', '<s:text name="validbillcyc"/>', 'l', true, 8);
            return checkval(window);
        }
    </script>
	</head>
	<body>
		<s:form name="formList" id="formList" action="validbillcyc_list.do"
			theme="simple">
			<aa:zone name="hiddenZone">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />

				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />
				<input type="hidden" id="maxRowCount" value="10" />
				<!--change it if you need-->
				<input type="hidden" name="ajaxFlag" id="ajaxFlag" />
			</aa:zone>
			<div class="widgetL">
				<div class="wCenter">
					<div class="content">
						<aa:zone name="errorZone">
							<div class="error_text">
								<s:actionerror />
								<s:actionmessage />
							</div>
						</aa:zone>
						<div class="title_name">
							<s:text name="title" />
						</div>
						
						<div class="search2">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th align="left"><s:text name="region"/>:</th>
									<td align="left">
										<j:selector definition="#CITYCOMPANY" dbFlag="BILL" cssClass="input" readonly="true" name="param._ne_region"  mode="morecheck"/>
									</td>
									<th><s:text name="validbillcyc" />:</th>
									<td align="left">
										<s:textfield cssClass="input" name="param._ne_validbillcyc" id="validbillcyc" readonly="true" onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
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
												value="<s:text name="button_new"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doNew('/fee/billing/validbillcyc_new.do')" />
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
									<td nowrap><s:text name="region"/></td>
									<td nowrap><j:orderByImg href="javascript:doOrderby('validbillcyc')"><s:text name="validbillcyc"/></j:orderByImg></td>
									<td nowrap><s:text name="state"/></td>
									<td nowrap><s:text name="begindate"/></td>
									<td nowrap><s:text name="enddate"/></td>
									<td nowrap><s:text name="billcyccode"/></td>
									<td nowrap><s:text name="descinfo"/></td>
								</tr>
								</thead>
								
								<tbody>
								<s:iterator value="dp.datas" id="dp.datas" status="status">
						        <s:if test="#status.odd">
									<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
								</s:if>
								<s:else>
									<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
								</s:else>
								        <td nowrap><j:code2Name definition="CITYIDCODE" code="region" /></td>										             		
										<td nowrap><a href='<s:url action="validbillcyc_edit.do"><s:param name="param._pk" value="validbillcyc|region"/></s:url>'>
										<s:property value="validbillcyc"/></a></td>
										<td nowrap><j:code2Name definition="$IB_BILLCYCSTATE" dbFlag="BILL" code="state" /></td>
										<td nowrap><s:date name="begindate" format="yyyy-MM-dd HH:mm:ss" /></td>
							            <td nowrap><s:date name="enddate" format="yyyy-MM-dd HH:mm:ss" /></td>
										<td nowrap><s:property value="billcyccode" /></td>
										<td nowrap><s:property value="descinfo" /></td>
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