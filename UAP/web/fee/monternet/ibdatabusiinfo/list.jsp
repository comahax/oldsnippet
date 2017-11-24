<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/inc/listhead.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>
		<s:text name="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
		
			function doExcel(url){
				if($("input[name='param._selectitem']:checked:eq(0)").val()==undefined){
					setExcelOutPage(url);
				}else{
					$("input[name='param.startindex']").val("1");
					$("input[name='param.endindex']").val("1");
					formList.action = contextPath + url;
					formList.submit();
				}
			}
		
			function doExcelOut(url) {
				$("#propertys").val("billcycle,spCode,opCode,port,chargingtype,fee,acctitemIdlv1,acctitemIdlv2");
				doExcel(url);
	    	} 
			function doFeeExcelOut(url) {
				if($("#_ne_billcycle").val()==""){
					alert("<s:text name="exportError"/>");
					return false ;
				}
				$("#propertys").val("acctitemIdlv1,acctitemIdlv2");
				doExcel(url);
	    	} 
   	 	</script>
	</head>
	<body onload="loadforiframe1();">
		<s:form name="formList" id="formList" action="/fee/billing/databusiinfo_doList.do"
			theme="simple">
			<aa:zone name="hiddenZone">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" value="20" />
				<s:hidden name="param.queryAll" />
                <s:hidden name="param.startindex" />
				<s:hidden name="param.endindex" />
				<s:hidden name="param.propertys" id="propertys" />
				
				<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />" />
				<input type="hidden" id="maxRowCount" value="20" />
				<!--change it if you need-->
				<input type="hidden" name="ajaxFlag" id="ajaxFlag" />
			</aa:zone>
			<div class="widgetL">
				<div class="wCenter">
					<div class="content">
						<div class="title_name">
							<s:text name="titleList" />
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
						            <td class="content_table_td_left"><s:text name="billcycle"/>:</td>
						            <td class="content_table_td_right">
						                <s:textfield cssClass="Wdate" name="param._ne_billcycle" id="_ne_billcycle" onfocus="WdatePicker({skin:'default',readOnly:false,dateFmt:'yyyyMM'})"/>
						            </td>
						            <td class="content_table_td_left"><s:text name="chargingtype"/>:</td>
						            <td class="content_table_td_right">
						                <s:select name="param._ne_chargingtype" list="#{'':'',0:'包月',1:'点播'}" cssClass="input" label="abc" listKey="key" listValue="value" headerValue="" />
						            </td>
						       </tr>
						       <tr>     
						            <td class="content_table_td_left"><s:text name="spCode"/>:</td>
						            <td class="content_table_td_right">
						                <s:textfield cssClass="form_text" name="param._se_spCode" />
						            </td>
						            <td class="content_table_td_left"><s:text name="opCode"/>:</td>
						            <td class="content_table_td_right">
						                <s:textfield cssClass="form_text" name="param._se_opCode" />
						            </td>
						       <tr/>
						       </tr>     
						            <td class="content_table_td_left"><s:text name="port"/>:</td>
						            <td class="content_table_td_right">
						                <s:textfield cssClass="form_text" name="param._sew_port" />
						            </td>
						            <td class="content_table_td_left"><s:text name="acctitemIdlv2"/>:</td>
						            <td class="content_table_td_right">
						                <s:textfield cssClass="form_text" name="param._ne_acctitemIdlv2" />
						            </td>
						        </tr>

								<tr>
									<td colspan="6" align="right">
										<s:i18n name="public">
											<input type="button" class="bt48_gray"
												value="<s:text name="button_search"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doQuery('/fee/billing/databusiinfo_doList.do')" />
										</s:i18n>
										<input type="button" class="bt48_gray"
												value="<s:text name="button_export"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doExcelOut('/fee/billing/databusiinfo_excel.do?target=${requestScope.target}')" />	
											<input type="button" class="button_8"
												value="<s:text name="exportFeeInfo"/>"
												onmouseover="this.className='bt48_5'"
												onmouseout="this.className='button_8'"
												onclick="doFeeExcelOut('/fee/billing/databusiinfo_excel.do?target=${requestScope.target}')" />
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
						                <td>
						                    <s:text name="seq"/>
						                </td>
						                <td>
						                    <s:text name="billcycle"/>
						                </td>
						                <td>
						                    <s:text name="spCode"/>
						                </td>
						                <td>
						                    <s:text name="opCode"/>
						                </td>
						                <td>
						                    <s:text name="port"/>
						                </td>
						                <td>
						                    <s:text name="chargingtype"/>
						                </td>
						                <td>
						                    <s:text name="fee" />
						                </td>
						                <td>
						                    <s:text name="acctitemIdlv1" />
						                </td>
						                <td>
						                    <s:text name="acctitemIdlv2" />
						                </td>
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
				                     	<input type="checkbox" name="param._selectitem" value="<s:property value="billcycle + '|' + chargingtype + '|' + filetype + '|' + opCode + '|' + port + '|' + spCode"/>" onclick="checkOne();" cssClass="table_checkbox"/>
				                     </td>
				                     <td><s:property value="#status.index + 1"/></td>
				                     <td><s:property value="billcycle"/></td>
				                     <td><s:property value="spCode"/></td>
				                     <td><s:property value="opCode"/></td>
				                     <td><s:property value="port"/></td>
				                     <td><j:code2Name definition="UAP_CHARGING_TYPE" code="chargingtype"/></td>
				                     <td><s:property value="fee" /></td>
				                     <td><s:property value="acctitemIdlv1" /></td>
				                     <td><s:property value="acctitemIdlv2" /></td>		
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