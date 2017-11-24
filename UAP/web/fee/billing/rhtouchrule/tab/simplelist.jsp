<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "4D3C2B2BBT1";
	String ID_2 = "4D3C2B2BBT2";
	String ID_3 = "4D3C2B2BBT3";	
%>
<html>
	<head>
		<title><s:text name="titleList" /></title> 		
		<base target="_self">
		<script language="JavaScript" type="text/JavaScript">
			var step_fun = "<s:property value='#request.BILLINGPHASE' />";						
	        function ev_check() {
	        	
				return checkval(window);
	        } 
	    
	        function chkstart() {
	        	if(step_fun == 106 || step_fun == 50 || step_fun == 80 || step_fun == 75 
    					|| step_fun == 102 || step_fun == 103 || step_fun == 104 || step_fun == 105 ){    					          
			    	document.formList.simplebt.disabled = false;			          	
    			}    			
	        }
	        
	        
	        
	        function startup() {	        	
	        	        	
	        	if(checkStartupState()){
	        	 alert("当前状态不允许重复启动！");
	        	 var checkStatus = document.getElementById("simplebt");	
	        	 checkStatus.disabled = true;
	        	 return ;	        
	        	}
				if(confirm('是否启动' + '<j:code2Name definition="BILLSTEP" code="#request.BILLINGPHASE" />?' )){
					var arg = new Array();
		    		var startupUrl =  "<%=contextPath%>/common/startup.jsp";
					var hWnd = window.showModalDialog(startupUrl, arg, "dialogWidth:600px; dialogHeight:230px; status:no;resizable:yes;");
					
					/**
						50-FIXC 固定费确认
						106-PRECFM 通信费确认
						75-NUL  无主回捞
						80-RED	账单优惠
						102-URS 用户出账
						103-ACC 账户出账
						104-CFM 出账确认
						105-WOF 销账信控
					**/
					if (hWnd != null && hWnd != "") {
						var key = 'ERRORSTEP'; // PRECFM
						if(step_fun == 50)  key = 'FIXC';if(step_fun == 106)  key = 'PRECFM';
						if(step_fun == 75)  key = 'NUL';if(step_fun == 80)  key = 'RED';
						if(step_fun == 102)  key = 'USR';if(step_fun == 103)  key = 'ACC';
						if(step_fun == 104)  key = 'CFM';if(step_fun == 105)  key = 'WOF';					
						formList.action =  contextPath + '/fee/billing/rhtouchrule_startup.do?_KEY=' + key + '&_STARTRSN=' + hWnd;
						formList.submit();
						formList.action = contextPath + '/fee/billing/rhtouchrule_simpleinfo.do';    			
						    			
		    		}  
		    		
		    		// 更新状态后刷新饼图		    	
		    		window.parent.document.all.loadframe2.autoRefresh();
				} 
	    										
			}
			// 检查启动状态 
			// 0-未启动 1-可启动 2- 启动中  3- 已完成 4-出错
			function checkStartupState(){
				
				var phase = "<s:property value='#request.BILLINGPHASE'/>";
				var startupstate = "";
				if(phase == '101'){					
					startupstate ="<s:property value='#request._BRTVO.fixstate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '102'){
					startupstate ="<s:property value='#request._BRTVO.usrbillstate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '103'){
					startupstate ="<s:property value='#request._BRTVO.accbillstate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '104'){
					startupstate ="<s:property value='#request._BRTVO.cfmbillstate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '105'){
					startupstate ="<s:property value='#request._BRTVO.woffstate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '50'){
					startupstate ="<s:property value='#request._BRTVO.fixcfmstate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '106'){ //51 被占用 现改为106
					startupstate ="<s:property value='#request._BRTVO.precfmstate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '1010'){
					startupstate ="<s:property value='#request._BRTVO.dgfixfeestate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '75'){
					startupstate ="<s:property value='#request._BRTVO.nullrecstate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}else if(phase == '80'){
					startupstate ="<s:property value='#request._BRTVO.reducestate + 0' />";
					if(startupstate == '' || startupstate == '0' || startupstate == '1' || startupstate == '4'){
						return false;
					}
				}
				return true;
				
			}
			
			
    </script>
	</head>

	<body onload="chkstart();" style="border:1px solid #ccc;" scroll="no">

			<s:form action="/fee/billing/rhtouchrule_simpleinfo.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				
		
				<s:hidden name="form._ne_validbillcyc" />
				<s:hidden name="form.regiongroup" />
				<s:hidden name="form.step" /> 

			

				<div class="table_div">
					<table class="top_table">
						<tr>							
							<td>
								<j:code2Name definition="SUBPHASENAME" code="#request.BILLINGPHASE" />
								<s:if test="#request.BILLINGPHASE=='102' || #request.BILLINGPHASE=='103'">
								(备注：子步骤记录数和金额的含义为处理到当前步骤时，应收的总记录数和总金额)
								</s:if>
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
			            	<td class="form_table_left"><s:text name="region" />: <s:property value="form.regiongroup"/></td>    	                                   
			                <td class="form_table_left"><s:text name="starttime" />:							
								
									<s:if test="#request.BILLINGPHASE ==  '101'">	
										<s:date name="#request._BRTVO.fixstime" format="yyyy-MM-dd HH:mm:ss" />								
														
									</s:if>
									<s:elseif test="#request.BILLINGPHASE ==  '102'">	
										<s:date name="#request._BRTVO.usrbillstime" format="yyyy-MM-dd HH:mm:ss" />								
																						
									</s:elseif>								
									<s:elseif test="#request.BILLINGPHASE ==  '103'">
										<s:date name="#request._BRTVO.accbillstime" format="yyyy-MM-dd HH:mm:ss" />										
																	
									</s:elseif>								
									<s:elseif test="#request.BILLINGPHASE ==  '104'">
										<s:date name="#request._BRTVO.cfmbillstime" format="yyyy-MM-dd HH:mm:ss" />										
																		
									</s:elseif>	
									<s:elseif test="#request.BILLINGPHASE ==  '105'">
										<s:date name="#request._BRTVO.wofftime" format="yyyy-MM-dd HH:mm:ss" />										
																	
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '106'">	<!-- 51 已被占用 现改为106 precfmtime-->
										<s:date name="#request._BRTVO.precfmtime" format="yyyy-MM-dd HH:mm:ss" />									
																
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '50'">
										<s:date name="#request._BRTVO.fixcfmtime" format="yyyy-MM-dd HH:mm:ss" />										
																
									</s:elseif>	
									<s:elseif test="#request.BILLINGPHASE ==  '75'">
										<s:date name="#request._BRTVO.nullrecstime" format="yyyy-MM-dd HH:mm:ss" />										
																		
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '1010'">	
										<s:date name="#request._BRTVO.dgfixfeestime" format="yyyy-MM-dd HH:mm:ss" />									
																	
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '80'">
										<s:date name="#request._BRTVO.reducestime" format="yyyy-MM-dd HH:mm:ss" />										
																		
									</s:elseif>					
								
							</td> 
							<td class="form_table_left"><s:text name="endtime" />:
								
									<s:if test="#request.BILLINGPHASE ==  '101'">							
											
										<s:date name="#request._BRTVO.fixetime" format="yyyy-MM-dd HH:mm:ss" />	
										</td>
										
										<td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.fixstate + 0" definition="BACKACCTSTATE"/>					
									</s:if>
									<s:elseif test="#request.BILLINGPHASE ==  '102'">
										<s:date name="#request._BRTVO.usrbilletime" format="yyyy-MM-dd HH:mm:ss" />										
											
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.usrbillstate + 0" definition="BACKACCTSTATE"/>												
									</s:elseif>								
									<s:elseif test="#request.BILLINGPHASE ==  '103'">	
										<s:date name="#request._BRTVO.accbilletime" format="yyyy-MM-dd HH:mm:ss" />									
											
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.accbillstate + 0" definition="BACKACCTSTATE"/>							
									</s:elseif>								
									<s:elseif test="#request.BILLINGPHASE ==  '104'">
										<s:date name="#request._BRTVO.cfmbilletime" format="yyyy-MM-dd HH:mm:ss" />							
											
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.cfmbillstate + 0" definition="BACKACCTSTATE"/>							
									</s:elseif>	
									<s:elseif test="#request.BILLINGPHASE ==  '105'">
										<s:date name="#request._BRTVO.woffetime" format="yyyy-MM-dd HH:mm:ss" />									
										
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.woffstate + 0" definition="BACKACCTSTATE"/>								
									</s:elseif>	
									<s:elseif test="#request.BILLINGPHASE ==  '106'"> <!-- 51 已被占用 现改为106 -->
										<s:date name="#request._BRTVO.precfmtime" format="yyyy-MM-dd HH:mm:ss" />									
										
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.precfmstate + 0" definition="BACKACCTSTATE"/>							
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '50'">
										<s:date name="#request._BRTVO.fixcfmtime" format="yyyy-MM-dd HH:mm:ss" />									
										
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.fixcfmstate + 0" definition="BACKACCTSTATE"/>								
									</s:elseif>	
									<s:elseif test="#request.BILLINGPHASE ==  '1010'">
										<s:date name="#request._BRTVO.dgfixfeeetime" format="yyyy-MM-dd HH:mm:ss" />									
										
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.dgfixfeestate + 0" definition="BACKACCTSTATE"/>								
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '75'">
										<s:date name="#request._BRTVO.nullrecetime" format="yyyy-MM-dd HH:mm:ss" />									
										
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.nullrecstate + 0" definition="BACKACCTSTATE"/>								
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '80'">
										<s:date name="#request._BRTVO.reduceetime" format="yyyy-MM-dd HH:mm:ss" />
										</td><td class="form_table_left">状态:
										<j:code2Name code="#request._BRTVO.reducestate + 0" definition="BACKACCTSTATE"/>								
									</s:elseif>					
								
							</td>   
							<td class="form_table_right">
							    <j:purChk permid="MONITORSTATUS_START" disableChild="true">
									<input type="button" class="query"  id="simplebt" value="启动" onclick="startup();" disabled="disabled"/>
		                        </j:purChk>
							</td>      
			            </tr>
			        </table>
			    </div>
				<div class="table_div">
					<div class="table_LongTable">
					<table class="table_style" ID="Table2">
					
						<tr class="table_style_head">											
							<td>子步骤</td>
							<td><s:text name="starttime" /></td>
							<td><s:text name="endtime" /></td>
							<td><s:text name="processcnt" /></td>
							<td><s:text name="processamt" /></td>
							<td>状态</td>
						</tr>
			
						
						<s:iterator var="item" value="#request.LIST">						
							<tr class="table_style_content" align="center">												
								
									<s:if test="#request.BILLINGPHASE ==  '101' or BILLINGPHASE eq '1010'">																																	
										<td><j:code2Name definition="FIXSUBPHASE" code="#item.subphase" /></td>										
									</s:if>
									<s:elseif test="#request.BILLINGPHASE ==  '102'">									
										<td><j:code2Name definition="USRSUBPHASE" code="#item.subphase" /></td>
									</s:elseif>											
									<s:elseif test="#request.BILLINGPHASE ==  '103'">														
										<td><j:code2Name definition="ACCSUBPHASE" code="#item.subphase" /></td>	
									</s:elseif>								
									<s:elseif test="#request.BILLINGPHASE ==  '104'">									
										<!--  <td><j:code2Name definition="CFMSUBPHASE" code="#item.subphase" /></td>		-->		
										<td><j:code2Name definition="CZCFM" code="#item.subphase" /></td>		
									</s:elseif>
									<!-- 2013-12-28 begin -->
									<s:elseif test="#request.BILLINGPHASE ==  '105'">									
										<td><j:code2Name definition="WOFFCFM" code="#item.subphase" /></td>						
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '50'">									
										<td><j:code2Name definition="FIXFEECFM" code="#item.subphase" /></td>						
									</s:elseif>
									<s:elseif test="#request.BILLINGPHASE ==  '106'">	<!-- 51 已被占用 现改为106 -->								
										<td><j:code2Name definition="TXFCFM" code="#item.subphase" /></td>						
									</s:elseif>
									<!-- 2013-12-28 end -->
									<s:else>
										<td><s:property value="#item.subphase"/></td>
									</s:else>
									
								<td><s:date name="#item.starttime" format="yyyy-MM-dd HH:mm:ss"/></td>
								<td><s:date name="#item.endtime" format="yyyy-MM-dd HH:mm:ss"/></td>
								<td><s:property value="#item.processcnt + 0"/></td>
								<td><fmt:formatNumber value="${item.processamt + 0}" type="currency" />	</td>									
								<td><j:code2Name definition="BACKACCTSTATE" dbFlag="BILL" code="#item.status + 0" /></td>													
							</tr>
						</s:iterator>
			
					</table>
				</div>
				</div>
				<div style="height:20px"></div>
				<div class="table_div">
					<table class="top_table">
						<tr>							
							<td>出帐启动日志查询</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
					<table class="table_style" ID="Table2">
					
						<tr class="table_style_head">																			
							<td><s:text name="validbillcyc"/></td>
							<td><s:text name="startstep"/></td>	
							<td><s:text name="starttime"/></td>							
							<td><s:text name="opercode"/></td>	
                  			<td><s:text name="startrsn"/></td>                  											
						</tr>	
			
						
						<s:iterator var="item" value="#request.LIST2">							
							<tr class="table_style_content" align="center">												
								<td><s:property value="#item.validbillcyc" /></td>								
								<td><j:code2Name code="#item.startstep" definition="BILLSTEP"/></td>
								<td><s:date name="#item.starttime" format="yyyy-MM-dd HH:mm:ss" /></td>								
								<td><s:property value="#item.opercode" /></td>
								<td><s:property value="#item.startrsn" /></td>															
							</tr>
						</s:iterator>
			
					</table>
				</div>
				</div>
			</s:form>
	</body>
</html>
