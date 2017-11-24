<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@page import="java.util.Date"%>

<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><s:text name="title" />
		</title>
	</head>

	<body>
		<div class="table_container">
			<s:form action="/fee/billing/billinglog_supervise.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
				
				<s:hidden name="_ne_validbillcyc" />
				<s:hidden name="_se_batchnum" />
			
				
				<div class="table_div">
					<table class="top_table">
						<tr>					 		
							<td>
								<j:code2Name definition="BILLSTEP" code="#request.BILLINGPHASE" />							
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
				
	<div class="table_div">        
        <table class="form_table">   
            <tr>
                <td width="150" class="form_table_right"><s:text name="region"/>: </td>
                <td class="form_table_left" colspan="3">
                	<j:code2Name definition="CITYCOMPANY" code="#request._CITYID" />              
                </td>
            </tr>
            <tr>           	                                   
                <td class="form_table_right"><s:text name="starttime" />:</td>
                
				<td class="form_table_left">
					
						<s:if test="#request.BILLINGPHASE == '101'">	
						 	<s:date name="#request._BRTVO.fixstime" format="yyyy-MM-dd HH:mm:ss"/>
						</s:if>
						<s:if test="#request.BILLINGPHASE == '102'">
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>	
							
						</s:if>								
						<s:if test="#request.BILLINGPHASE == '103'">
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>									
															
						</s:if>								
						<s:if test="#request.BILLINGPHASE == '104'">
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>								
														
						</s:if>	
						<s:if test="#request.BILLINGPHASE == '105'">									
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>
														
						</s:if>
						<s:if test="#request.BILLINGPHASE == '100'">									
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>
														
						</s:if>
						<s:if test="#request.BILLINGPHASE == '1011'">									
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>
														
						</s:if>	
						<s:if test="#request.BILLINGPHASE == '80'">									
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>
													
						</s:if>
						<s:if test="#request.BILLINGPHASE == '75'">									
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>
														
						</s:if>
						<s:if test="#request.BILLINGPHASE == '1010'">									
							<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss"/>
												
						</s:if>					
					
				</td> 
				<td class="form_table_right"><s:text name="endtime" />:</td>
				<td class="form_table_left">
					
						<s:if test="#request.BILLINGPHASE == '101'">									
							<s:date name="#request._BRTVO.fixetime" format="yyyy-MM-dd HH:mm:ss"/>
												
						</s:if>
						<s:if test="#request.BILLINGPHASE == '102'">									
							<s:date name="#request._BRTVO.usrbilletime" format="yyyy-MM-dd HH:mm:ss"/>
																		
						</s:if>								
						<s:if test="#request.BILLINGPHASE == '103'">									
							<s:date name="#request._BRTVO.accbilletime" format="yyyy-MM-dd HH:mm:ss"/>
															
						</s:if>								
						<s:if test="#request.BILLINGPHASE == '104'">									
							<s:date name="#request._BRTVO.cfmbilletime" format="yyyy-MM-dd HH:mm:ss"/>
														
						</s:if>	
						<s:if test="#request.BILLINGPHASE == '105'">									
							<s:date name="#request._BRTVO.woffetime" format="yyyy-MM-dd HH:mm:ss"/>
														
						</s:if>	
						<s:if test="#request.BILLINGPHASE == '100'">									
							<s:date name="#request._BRTVO.prmcfmtime" format="yyyy-MM-dd HH:mm:ss"/>
														
						</s:if>
						<s:if test="#request.BILLINGPHASE == '1011'">									
							<s:date name="#request._BRTVO.fixcfmtime" format="yyyy-MM-dd HH:mm:ss"/>
														
						</s:if>	
						<s:if test="#request.BILLINGPHASE == '80'">									
							<s:date name="#request._BRTVO.reduceetime" format="yyyy-MM-dd HH:mm:ss"/>														
						</s:if>
						<s:if test="#request.BILLINGPHASE == '75'">									
							<s:date name="#request._BRTVO.nullrecetime" format="yyyy-MM-dd HH:mm:ss"/>
												
						</s:if>
						<s:if test="#request.BILLINGPHASE == '1010'">									
							<s:date name="#request._BRTVO.dgfixfeeetime" format="yyyy-MM-dd HH:mm:ss"/>														
						</s:if>					
					
				</td>        
            </tr>
        </table>
    </div>
    		
		<div class="table_div">
		<div class="table_LongTable">
			<table class="table_style" ID="Table2">
				<tr class="table_style_head">
						
					<td>状态</td>
					<td>步骤</td>
					<td><s:text name="starttime" /></td>
					<td><s:text name="endtime" /></td>
					<td><s:text name="processcnt" /></td>
					<td><s:text name="processamt" /></td>
				</tr>
				<s:iterator var="item" value="#request.LIST">
					<tr class="table_style_content" align="center">
						<td><img src="<%= contextPath %>/images/fee/billing/supervise/status<s:property value='#item.status'/>.gif" /></td>  					
						
							<s:if test="#request.BILLINGPHASE == '101' || BILLINGPHASE == '1010'">																																	
								<td><j:code2Name definition="FIXSUBPHASE" code="#item.subphase" /></td>										
							</s:if>
							<s:elseif test="#request.BILLINGPHASE == '102'">									
								<td><j:code2Name definition="USRSUBPHASE" code="#item.subphase" /></td>
							</s:elseif>											
							<s:elseif test="#request.BILLINGPHASE == '103'">														
								<td><j:code2Name definition="ACCSUBPHASE" code="#item.subphase" /></td>	
							</s:elseif>								
							<s:elseif test="#request.BILLINGPHASE == '104'">									
								<td><j:code2Name definition="CFMSUBPHASE" code="#item.subphase" /></td>						
							</s:elseif>
							<s:else>
								<td><s:property value="#item.subphase"/></td>
							</s:else>
							
							
						<td><s:date name="#item.starttime" format="yyyy-MM-dd HH:mm:ss"/></td>
						<td><s:date name="#item.endtime" format="yyyy-MM-dd HH:mm:ss"/></td>
						<td><s:property value="#item.processcnt+0"/></td>
						<td><s:property value="#item.processamt+0"/></td> 		
							<!-- <fmt:formatNumber type="currency" value="#item.processamt+0"/> -->
												
					</tr>
				</s:iterator>
			</table>
		</div>
	    </div>				
				
	</s:form>
	</div>
</body>
</html>
