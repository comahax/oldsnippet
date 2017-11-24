<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/listhead.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>
		<s:text name="title" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_req_type', '<s:text name="req_type"/>', 'c', true, 5);
            addfield('param._ne_state', '<s:text name="state"/>', 'l', true, 8);
			addfield('param._de_req_time', '<s:text name="req_time"/>', 'd', true, 8);
            return checkval(window);
        }
        
        function doDeny(cmdDelete) {
            var msg = "确定要作废这些请求吗？";
		    var TO = true;
		    var sis = formList.all("param._selectitem");   
		    if (forincheck(TO,sis,msg)){    
		    	formList.action = contextPath + cmdDelete;
		    	formList.submit();    	
		    
		    }
         }
         function doView(cmdUrl) {
             document.getElementById("IFRM_MAIN").style.display = "";
             IFRM_MAIN.location.href = contextPath + cmdUrl;
             document.body.scrollTop = 500;
         }
    </script>
	</head>
	<body>
		<s:form name="formList" id="formList" action="/fee/billing/uapreq_list.do"
			theme="simple">
			<aa:zone name="hiddenZone">
				<s:hidden name="param._orderby" value="logid"/>
				<s:hidden name="param._desc" value="1"/>
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param.queryAll" />
				<input type="hidden" name="target" value="${requestScope.target}"/>

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
						<aa:zone name="errorZone">
							<div class="error_text">
								<s:actionerror />
								<s:actionmessage />
							</div>
						</aa:zone>
						<div class="search2">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th align="left"><s:text name="req_type"/>:</th>
									<td align="left">
										<j:selector definition="$IB_REQ_UAP" cssClass="input" readonly="true" name="param._se_req_type"  condition="_ssw_dictid:10__"/>
									</td>
									<th align="left"><s:text name="state" />:</th>
									<td align="left">
										<j:selector definition="REQ_STATE" cssClass="input" readonly="true" name="param._ne_state" />	
									</td>
								</tr><tr>
									<th align="left"><s:text name="req_time" />>=:</th>
									<td align="left">
										<s:textfield cssClass="Wdate" name="param._dnl_req_time" id="dnl_req_time" readonly="true" onfocus="WdatePicker({skin:'default',dateFmt:'yyyy-MM-dd HH:mm:ss'})"></s:textfield>
									</td>
									<th align="left"><s:text name="req_time" /><=:</th>
									<td align="left">
										<s:textfield cssClass="Wdate" name="param._dnm_req_time" id="dnm_req_time" readonly="true" onfocus="WdatePicker({skin:'default',dateFmt:'yyyy-MM-dd HH:mm:ss'})"></s:textfield>
									</td>
								</tr>
								<tr>
									<td colspan="8" align="right">
										<span style="color:red"><s:text name="tips" /></span>
											<input type="button" class="l_bt48_gray"
												value="<s:text name="button_new"/>"
												onmouseover="this.className='l_bt48'"
												onmouseout="this.className='l_bt48_gray'"
												onclick="doNew('/fee/billing/uapreq_new.do?target=${requestScope.target}')" />
										<s:i18n name="public">
											<input type="button" class="bt48_gray"
												value="<s:text name="button_search"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doQuery('/fee/billing/uapreq_list.do?target=${requestScope.target}')" />
											<input type="button" class="bt48_gray"
												value="<s:text name="button_deny"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doDeny('/fee/billing/uapreq_deny.do?target=${requestScope.target}')" />
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
								    <td rowrap align="center">
                                      <input type="checkbox" name="allbox" onClick="checkAll();" class="table_checkbox" />
                                    </td>
									<td nowrap><s:text name="req_type"/></td>
									<td nowrap><s:text name="req_time"/></td>
									<td nowrap><s:text name="state"/></td>
									<td nowrap><s:text name="operator"/></td>
									<td nowrap><s:text name="remark"/></td>
									<td nowrap><s:text name="checkresult"/></td>
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
										<td  rowrap align="center">
                                  		 <input type="checkbox" name="param._selectitem" value="<s:property value='logid'/>" onclick="checkOne()" class="table_checkbox"/>&nbsp;
                                   		 <input type="hidden" id="logid" value="<s:property value='logid'/>"  />
                               			</td>
								        <td nowrap><j:code2Name definition="$IB_REQ_UAP" code="req_type" /></td>
										<td nowrap><s:date name="req_time" format="yyyy-MM-dd HH:mm:ss" /></td>
										<td nowrap><j:code2Name definition="REQ_STATE" code="state" /></td>
										<td nowrap><s:property value="operator" /></td>
										<td nowrap><s:property value="remark" /></td>
										<s:if test="req_type == '1001' || req_type == '1002' ">
										    <s:url var="url" action="rhfixfeecresult_list.do" includeContext="false"> 
										        <s:param name="target" value="{#request.target}"/>
										    	<s:param name="logid" value="logid"/>
										    </s:url>
										</s:if>
										<s:else>
										    <s:url var="url" action="checkplanresult_list.do" includeContext="false">   
										       <s:param name="target" value="{#request.target}"/>
										       <s:param name="logid" value="logid"/>
										    </s:url>
										</s:else>
										
										<td nowrap>
										    <s:if test="state == 2 || state == 3">
										    <input type="button" class="bt48_gray"
												value="<s:text name="button_view"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"	
												onclick="doView('<s:property value='url'/>')" />
										    </s:if>
										    <s:else>
										    <input type="button" class="bt48_gray" disabled="true"	
												value="<s:text name="button_view"/>"
												onmouseover="this.className='bt48'"
												onmouseout="this.className='bt48_gray'"
												onclick="doView('<s:property value='url'/>')" />
											</s:else>
										</td>
										
								</s:iterator>
		                        </tr>
								</tbody>
							</table>
						</div>
						<%@ include file="/common/pageNav.jsp"%>
					</div>

				</div>
			</div>
			<iframe frameborder="0" scrolling="no" class="loadframe" name="IFRM_MAIN" id="IFRM_MAIN" style="display:none" width="100%" height="100%"></iframe>
		</s:form>
	</body>
</html>