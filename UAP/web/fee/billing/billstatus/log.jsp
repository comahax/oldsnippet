<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "4D3C2B2BBT1";
	String ID_2 = "4D3C2B2BBT2";
	String ID_3 = "4D3C2B2BBT3";
%>
<html>
	<head>
		<base target="_self" /> 
		<title><j:code2Name definition="SUBPHASENAME" code="#request['_STEPNAME']" /></title>		
		<script language="JavaScript" type="text/JavaScript">
			function ev_check() {
             return checkval(window);
        }
        
		</script>
	</head>

	<body onload="loadforiframe();" style="border:1px solid #ccc;">
		<div class="table_container">
			
			<s:form action="/fee/billing/billstatus_showlog.do" 
			 key="formList" cssStyle="formList"  theme="simple" method="post" onsubmit="return ev_check();">
				
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:set value="#request._PHASE" name="phase"/>
				<s:set value="#request._REGIONGROUP" name="region"/>	
				<s:set value="#request._VALIDBILLCYC" name="validbillcyc"/>		
				
				<input type="hidden" name="_rowcount" value="<s:property value='dp.rowCount'/>"/>				
				
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>								
								<j:code2Name code="#request._STEPNAME" definition="SUBPHASENAME" />									
							</td>
				
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text">
						<s:actionerror />		
						<s:actionmessage />				
					</table>
				</div>
			<!--  
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button" class="query"  value="关闭" onClick="window.close();" />									
							</td>
						</tr>
					</table>
				</div>
		   -->
				<div class="table_div">
						<table class="form_table">
						
							<tr>
							    <td class="form_table_left"><s:text name="region" />: <s:property value="#request._CITYID"/></td>  
								<td class="form_table_left">
									<s:text name="starttime" />:									
									<s:property value="#request['_STARTTIME']"/>
								</td>
								<td class="form_table_left">
									<s:text name="endtime" />:									
									<s:property value="#request['_ENDTIME']"/>
								</td>
							</tr>
						</table>
				</div>


				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">

							<tr class="table_style_head">
								<td>
									<s:text name="logid" />
								</td>
								<td>
									<s:text name="validbillcyc" />
								</td>
								<td>
									<s:text name="phase" />
								</td>
								<td>
									<s:text name="subphase" />
								</td>
								<td>
									<s:text name="intime" />
								</td>
								<td>
									<s:text name="reasult" />
								</td>


							</tr>
							<s:iterator var="item" value="dp.datas">

								<tr class="table_style_content" align="center">
									<td>
										<s:property value="#item.logid" />
									</td>
									<td>
										<s:property value="#item.validbillcyc" />
									</td>
									<td>
										<s:property value="#item.phase" />										
										<j:code2Name code="#item.phase + 0" definition="SUBPHASENAME" />
									</td>
									<td>
										<s:property value="#item.subphase" />
										<j:code2Name code="#item.phase + #item.subphase" definition="SUBPHASENAME" />											
									</td>
									<td>
										<s:date name="#item.intime" format="yyyy-MM-dd HH:mm:ss" />										
									</td>
									<td>
										<s:property value="#item.result" />
									</td>
								</tr>

							</s:iterator>
						</table>
					</div>
					<div class="table_div">							
						<script language="JavaScript" type="text/JavaScript"> 				
							var action =document.formList.action;					
							var url =action + "?_PHASE=${phase}&_REGIONGROUP=${region}&_VALIDBILLCYC=${validbillcyc}";
								
							document.formList.action = url;		
								 
						</script>
						<%@ include file="/common/pageNav.jsp" %>										
					</div>
			</s:form>
		</div>
	</body>
</html>
