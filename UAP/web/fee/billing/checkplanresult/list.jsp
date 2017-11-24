<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/listhead.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
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
	<body>
		<s:form name="formList" id="formList" action="checkplanresult_list.do"
			theme="simple">
			<aa:zone name="hiddenZone">
			    <s:hidden name="param._ne_logid" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
                <s:hidden name="param.startindex" />
				<s:hidden name="param.endindex" />
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
							<s:text name="title" />
						</div>
						
						<div class="search2">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								
								<tr>
								    <td align="left"><aa:zone name="errorZone">
										<div class="error_text">
											<s:actionerror />
											<s:actionmessage />
										</div>
									</aa:zone></td>
									<td colspan="8" align="right">										
										<s:i18n name="public">
											<input type="button" class="bt48_gray"
												value="<s:text name="button_export"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doExcelOut('/fee/billing/checkplanresult_excel.do?target=${requestScope.target}')" />
											
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
										<td nowrap><s:text name="logid"/></td>         
                                        <td nowrap><s:text name="validbillcyc"/></td>  
                                        <td nowrap><s:text name="batch"/></td>         
                                        <td nowrap><s:text name="prodid"/></td>        
                                        <td nowrap><s:text name="prodname"/></td>      
                                        <td nowrap><s:text name="servnumber"/></td>    
                                        <td nowrap><s:text name="subsid"/></td>        
                                        <td nowrap><s:text name="status"/></td>        
                                        <td nowrap><s:text name="useddays"/></td>      
                                        <td nowrap><s:text name="tariffitemid"/></td>  
                                        <td nowrap><s:text name="acctid"/></td>        
                                        <td nowrap><s:text name="prodfee"/></td>        
                                        <td nowrap><s:text name="receivable"/></td>       
                                        <td nowrap><s:text name="adjust"/></td>       
                                        <td nowrap><s:text name="paiclup"/></td>    
                                        <td nowrap><s:text name="planlist"/></td>      
                                        <td nowrap><s:text name="rulelist"/></td>      
                                        <td nowrap><s:text name="paicluplist"/></td>
                                        <td nowrap><s:text name="resulttype"/></td>  
                                        <td nowrap><s:text name="checkresult"/></td>
								</tr>
								</thead>
								
								<tbody>
								<s:iterator value="dp.datas" id="dp.datas" status="line">
						        <s:if test="#line.odd">
									<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
								</s:if>
								<s:else>
									<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
								</s:else>
										<td nowrap><s:property value="logid"/></td>         
                                        <td nowrap><s:property value="validbillcyc"/></td>  
                                        <td nowrap><s:property value="batch"/></td>         
                                        <td nowrap><s:property value="prodid"/></td>        
                                        <td nowrap><s:property value="prodname"/></td>      
                                        <td nowrap><s:property value="servnumber"/></td>    
                                        <td nowrap><s:property value="subsid"/></td>        
                                        <td nowrap><s:property value="status"/></td>        
                                        <td nowrap><s:property value="useddays"/></td>      
                                        <td nowrap><s:property value="tariffitemid"/></td>  
                                        <td nowrap><j:code2Name definition="#WOFF-ACCT" code="acctid" /></td>        
                                        <td nowrap><s:property value="prodfee"/></td>        
                                        <td nowrap><s:property value="receivable"/></td>       
                                        <td nowrap><s:property value="adjust"/></td>         
                                        <td nowrap><s:property value="paiclup"/></td>  
                                        <td nowrap><s:property value="planlist"/></td>      
                                        <td nowrap><s:property value="rulelist"/></td>      
                                        <td nowrap><s:property value="paicluplist"/></td> 
                                        <td nowrap><j:code2Name definition="CHECKPLAN_RESULTTYPE" code="resulttype" /></td>  
                                        <td nowrap><s:property value="checkresult"/></td>   
                                        
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