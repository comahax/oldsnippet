<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/inc/listhead.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>
		<s:text name="title_upload" />
		</title>
		<script language="JavaScript" type="text/JavaScript">

   	 	</script>
	</head>
	<body onload="loadforiframe1();">
		<s:form name="formList" id="formList" action="uapreqfile_listUpload.do"
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
						<div class="title_name">
							<s:text name="title_upload" />
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
									<th><s:text name="reqtype" />:</th>
									<td align="left">
										<j:selector id="_req_type" name="param._se_req_type" definition="$IB_REQ_UAP" cssClass="input" mode="selector" condition="_ssw_dictid:_1" />
									</td>
									<th><s:text name="validbillcyc" />:</th>
									<td align="left">
										<s:textfield cssClass="Wdate" name="param._ne_validbillcyc" id="validbillcyc" readonly="true" onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
									</td>								
									<th><s:text name="state"/>:</th>
									<td>
										<j:selector id="form._se_state" name="param._ne_state" definition="REQ_STATE" cssClass="input" mode="selector" />
									</td>
								</tr>
								<tr>
									<td colspan="6" align="right">
										<input type="button" class="l_bt48_gray"
												value="<s:text name="btn_sendupload"/>"
												onmouseover="this.className='l_bt48'"
												onmouseout="this.className='l_bt48_gray'"
												onclick="doNew('/fee/billing/uapreqfile_newUpload.do')" />
										<s:i18n name="public">
											<input type="button" class="bt48_gray"
												value="<s:text name="button_search"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doQuery()" />
											<input type="button" class="bt48_gray"
												value="<s:text name="button_deny"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doCancel('/fee/billing/uapreqfile_updateReq.do','<s:text name="cancelinfo"/>')" />
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
										<td title="<s:text name="list_title_select"/>">
						                    <s:checkbox name="allbox" onclick="checkAll();" cssClass="table_checkbox"/>
						                </td>
						                <td nowrap><j:orderByImg href="javascript:doOrderby('logid')"><s:text name="logid"/></j:orderByImg></td>
										<td nowrap><j:orderByImg href="javascript:doOrderby('req_type')"><s:text name="reqtype"/></j:orderByImg></td>
										<td nowrap><j:orderByImg href="javascript:doOrderby('validbillcyc')"><s:text name="validbillcyc"/></j:orderByImg></td>
										<td nowrap><j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg></td>
										<td nowrap><j:orderByImg href="javascript:doOrderby('remark')"><s:text name="remark"/></j:orderByImg></td>
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
					                     <td>
					                     	<input type="checkbox" name="param._selectitem" value="<s:property value='#item.logid'/>" onclick="checkOne();" cssClass="table_checkbox"/>
					                     </td>
					                    <td nowrap><s:property value='#item.logid'/></td>
										<td nowrap><j:code2Name definition="$IB_REQ_UAP" dbFlag="BILL" code="req_type" /></td>	
										<td nowrap><s:property value="#item.validbillcyc"/></td>
										<td nowrap><j:code2Name definition="REQ_STATE" dbFlag="BILL" code="state" /></td>	
										<td nowrap><s:property value='#item.remark'/></td>					
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