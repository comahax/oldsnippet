<%@ page language="java" contentType="text/html;charset=utf-8"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A2B" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<% 
    String ID_1 = "4D1A2BBT1";
    String ID_2 = "4D1A2BBT2";
    String ID_3 = "4D1A2BBT3";

%>
<html>
<head>
    <title><bean:message bundle="accounting" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {

            return checkval(window);
        }
        function startup(url,step,region,Run,RunF,confirmway) {
			if(confm(step,region) && toRun(step,Run,RunF,confirmway)){
				var startupUrl = contextPath + "/commons/startup.jsp";
				var arg = new Array();
				var hWnd = window.showModalDialog(startupUrl, arg, "dialogWidth:600px; dialogHeight:230px; status:no;resizable:yes;");
				if (hWnd != null && hWnd != "") {
					formList.action =  url + '&_KEY=' + step + '&_STARTRSN=' + hWnd;
					formList.submit();
					formList.action = contextPath + '/fee/accounting.do?CMD=LIST';	
				}	
			}			
		}	
		function confm(step,region,batchnum) {
			var message = "确认启动" + region;
			if(batchnum != null){
				message = "确认启动[" + batchnum + "]个地市的";
			}
			if(step == 'USR'){ 
				return confirm(message + "用户出帐!") 			
 			}
			if(step == 'ACC'){ 
				return confirm(message + "帐户出帐!") 			
 			}
			if(step == 'CFM'){ 
				return confirm(message + "出帐确认!") 			
 			}
 			if(step == 'WOF'){ 
				return confirm(message + "销帐信控!") 			
 			}
		}
    	function batchstartup(url,step,item) {
 			var sis = eval("document.formList." + item);
			var TO = true;
    		if (forincheck(TO,sis,step)){
    			var arg = new Array();
    			var startupUrl = contextPath + "/commons/startup.jsp";
				var hWnd = window.showModalDialog(startupUrl, arg, "dialogWidth:600px; dialogHeight:230px; status:no;resizable:yes;");
				if (hWnd != null && hWnd != "") {
					formList.action =  contextPath + url + '&_KEY=' + step + '&_STARTRSN=' + hWnd;
					formList.submit();
					formList.action = contextPath + '/fee/accounting.do?CMD=LIST';	    			
				}    			
    		}  								
		}
		function showLog(cityid,billingphase,ruleid,batchnum,validbillcyc) {
			var batchnum = document.formList._se_batchnum.value
			var validbillcyc = document.formList._ne_validbillcyc.value			
 			
    		if (cityid != null && "" != cityid && ruleid != null && "" != ruleid
    				&& batchnum != null && "" != batchnum && validbillcyc != null && "" != validbillcyc){
    			var url =  contextPath + '/fee/accounting.do?CMD=SHOWLOG' + '&_BATCHNUM=' + batchnum + '&_CITYID=' + cityid + '&_VALIDBILLCYC=' + validbillcyc + '&_BILLINGPHASE=' + billingphase + '&_RULEID=' + ruleid;    
				var arg = new Array();
    			var hWnd = window.showModalDialog(url, arg, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
    		}  								
		}
		
		function forincheck(TO,sis,step){
			var batchnum = 0;
		    if (sis != null) {
		        if (sis.length != null) {
		            for (var i = 0; i < sis.length; i++) {
		                if (sis[i].type == 'checkbox') {
		                    if (sis[i].checked){
		                        TO = false;
		                        batchnum++;
		                    }    
		                }
		            }
		        } else {
		            if (sis.type == 'checkbox') {
		                if (sis.checked){
		                    TO = false;
		                    batchnum++;
		                }    
		            }
		        }
		    }
		
		    if (TO) {
		        alert(msgNoSelected);
		        return false;
		    }
		
		    if (!confm(step,'',batchnum)) {
		        return false;
		    }
		    return true;
		}
		function toRun(step,isRun,isRunF,confirmway){
        	if(step == 'USR'){         	
        		if(isRunF != 9){
					alert('<bean:message bundle="bltouchrule" key="msg_16" />'); return false;
				}
        		if(isRun == 1 || isRun == 2){
		        	alert('该步骤已处于 [可启动] 或者 [启动中]!'); return false;	
				}	
 			}
			if(step == 'ACC'){ 
				if(isRunF != 3){
					alert('<bean:message bundle="bltouchrule" key="msg_11" />'); return false;
				} else if(isRun == 1 || isRun == 2){
		        	alert('<bean:message bundle="bltouchrule" key="runned" />'); return false; 
		        }	        				
 			}
			if(step == 'CFM'){ 
				if(isRunF != 3){
					alert('<bean:message bundle="bltouchrule" key="msg_12" />'); return false;
				} else if(isRun == 1 || isRun == 2){
		        	alert('<bean:message bundle="bltouchrule" key="runned" />'); return false;		        		
		        } else if(isRun == 3 || isRun == 4){
		        	alert('出帐确认已完成不能启动,出帐确认出错不能启动!'); return false;		        		
		        }	        			
 			}
 			if(step == 'WOF'){ 
 				if(confirmway != null && confirmway == 1){
	        		alert('<bean:message bundle="bltouchrule" key="isconfirmway" />'); return false;	        	
	        	} else if(isRunF != 3){
	        		alert('<bean:message bundle="bltouchrule" key="msg_14" />'); return false;	
	        	} else if(isRun == 1 || isRun == 2){
		        	alert('<bean:message bundle="bltouchrule" key="runned" />'); return false;		        		
		        }	
 			}
	        return true;       	
        	     	
        }
		
    </script>
</head>

<body onload="loadforiframe1();">

<html:form action="/fee/accounting.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
	<html:hidden property="_ne_validbillcyc"/>
    <html:hidden property="_se_batchnum"/>
    <html:hidden property="regiongroup"/>

	

	<div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>
	
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
        	<tr class="table_style_head">
                <td>完成情况</td>
                <td><bean:message bundle="bltouchrule" key="region"/></td>
             	<td>固定费</td>
             	<td>预处理确认</td>
             	<td>固定费确认</td>
             	
                <td>用户出帐</td> 
                <td class="form_table_left">
                	<input type="checkbox" name="allbox1" onclick="checkAll(null,'_selectitem1','allbox1');" class="table_checkbox"> 
                	<a href="javascript:batchstartup('/fee/accounting.do?CMD=BATCHSTARTUP','USR','_selectitem1')">启动</a>
	            </td>
               
                <td>帐户出帐</td>
                <td class="form_table_left">
                	<input type="checkbox" name="allbox2" onclick="checkAll(null,'_selectitem2','allbox2');" class="table_checkbox"> 
                	<a href="javascript:batchstartup('/fee/accounting.do?CMD=BATCHSTARTUP','ACC','_selectitem2')">启动</a>
				</td>
            
                <td>出帐确认</td>
                <td class="form_table_left">
                	<input type="checkbox" name="allbox3" onclick="checkAll(null,'_selectitem3','allbox3');" class="table_checkbox"> 
                	<a href="javascript:batchstartup('/fee/accounting.do?CMD=BATCHSTARTUP','CFM','_selectitem3')">启动</a>
           		</td>
                <td>销帐信控</td>
                <td class="form_table_left">
                	<input type="checkbox" name="allbox4" onclick="checkAll(null,'_selectitem4','allbox4');" class="table_checkbox"> 
                	<a href="javascript:batchstartup('/fee/accounting.do?CMD=BATCHSTARTUP','WOF','_selectitem4')">启动</a>
                </td>
            </tr>
            <tr class="table_style_content" align="center">																					
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>								
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>								
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>			                 		                    								
			</tr>
            <c:forEach var="item" items="${requestScope.LIST}">
                 <c:url value="/fee/accounting.do?CMD=STARTUP" var="urlContent">  
	                <c:param name="PK" value="${item.btrvo.ruleid}"/>
	                <c:param name="_CITYID" value="${item.cityid}"/>	                     
	             </c:url>
                 <tr class="table_style_content" align="center">
                 	
                 	<td><s:Code2Name code="${item.vbcvo.state}" definition="$IB_BILLCYCSTATE"/></td> 
                	
                	<td><c:out value='${item.cityname}'/></td>
                	<c:choose>
                        <c:when test="${!empty item.message}">
                            <td colspan="11"><font color="red"><c:out value='${item.message}'/></font></td>
                        </c:when>
                        <c:otherwise>							
		             		<td style="cursor:hand;" onclick="showLog('<c:out value='${item.cityid}'/>','101','<c:out value='${item.btrvo.ruleid}'/>','<c:out value='${item.btrvo.batchnum}'/>','<c:out value='${item.btrvo.validbillcyc}'/>');" >
		             			<img src="<%= contextPath %>/images/fee/billing/supervise/status<c:out value='${item.btrvo.fixstate}'/>.gif" />
		             		</td>
		             		<td style="cursor:hand;" onclick="showLog('<c:out value='${item.cityid}'/>','100','<c:out value='${item.btrvo.ruleid}'/>','999','<c:out value='${item.btrvo.validbillcyc}'/>');" >
		             			<img src="<%= contextPath %>/images/fee/billing/supervise/status<c:out value='${item.btrvo.prmcfmstate}'/>.gif" />
		             		</td>
		             		<td style="cursor:hand;" onclick="showLog('<c:out value='${item.cityid}'/>','1011','<c:out value='${item.btrvo.ruleid}'/>','999','<c:out value='${item.btrvo.validbillcyc}'/>');" >
		             			<img src="<%= contextPath %>/images/fee/billing/supervise/status<c:out value='${item.btrvo.fixcfmstate}'/>.gif" />
		             		</td>              		
		             		<td style="cursor:hand;" onclick="showLog('<c:out value='${item.cityid}'/>','102','<c:out value='${item.btrvo.ruleid}'/>','<c:out value='${item.btrvo.batchnum}'/>','<c:out value='${item.btrvo.validbillcyc}'/>');" >
		             			<img src="<%= contextPath %>/images/fee/billing/supervise/status<c:out value='${item.btrvo.usrbillstate}'/>.gif" />
		             		</td> 
		             		<td >
		             			<input type="checkbox" name="_selectitem1" value="<c:out value='${item.btrvo.ruleid}|${item.cityid}' />"
		                               onclick="checkOne(null,'_selectitem1','allbox1');" class="table_checkbox">
		                        <a href="javascript:startup('<c:out value="${urlContent}"/>','USR','<c:out value="${item.cityname}"/>','<c:out value="${item.btrvo.usrbillstate}"/>','<c:out value="${(item.btrvo.fixcfmstate + 0) * (item.btrvo.prmcfmstate + 0)}"/>')">启动</a>
		                    </td> 
		                    
		                    
		                    
		                    
		                    
		                    
		                                			
		             		<td style="cursor:hand;" onclick="showLog('<c:out value='${item.cityid}'/>','103','<c:out value='${item.btrvo.ruleid}'/>','<c:out value='${item.btrvo.batchnum}'/>','<c:out value='${item.btrvo.validbillcyc}'/>');" >
		             			<img src="<%= contextPath %>/images/fee/billing/supervise/status<c:out value='${item.btrvo.accbillstate}'/>.gif" />
		             		</td> 
		             		<td>
		             			<input type="checkbox" name="_selectitem2" value="<c:out value='${item.btrvo.ruleid}|${item.cityid}' />"
		                               onclick="checkOne(null,'_selectitem2','allbox2');" class="table_checkbox">	
		                               <a href="javascript:startup('<c:out value="${urlContent}"/>','ACC','<c:out value="${item.cityname}"/>','<c:out value="${item.btrvo.accbillstate}"/>','<c:out value="${item.btrvo.usrbillstate}"/>')">启动</a>
		                    </td>   
		                    
		                    
		                    
		                    
		                              	
		             		<td style="cursor:hand;" onclick="showLog('<c:out value='${item.cityid}'/>','104','<c:out value='${item.btrvo.ruleid}'/>','<c:out value='${item.btrvo.batchnum}'/>','<c:out value='${item.btrvo.validbillcyc}'/>');" >
		             			<img src="<%= contextPath %>/images/fee/billing/supervise/status<c:out value='${item.btrvo.cfmbillstate}'/>.gif" />
		             		</td> 
		             		<td >
		             			<input type="checkbox" name="_selectitem3" value="<c:out value='${item.btrvo.ruleid}|${item.cityid}' />"
		                               onclick="checkOne(null,'_selectitem3','allbox3');" class="table_checkbox">
		                               <a href="javascript:startup('<c:out value="${urlContent}"/>','CFM','<c:out value="${item.cityname}"/>','<c:out value="${item.btrvo.cfmbillstate}"/>','<c:out value="${item.btrvo.accbillstate}"/>')">启动</a>
		                    </td>             	
		             		<td style="cursor:hand;" onclick="showLog('<c:out value='${item.cityid}'/>','105','<c:out value='${item.btrvo.ruleid}'/>','<c:out value='${item.btrvo.batchnum}'/>','<c:out value='${item.btrvo.validbillcyc}'/>');">
		             			<img src="<%= contextPath %>/images/fee/billing/supervise/status<c:out value='${item.btrvo.woffstate}'/>.gif" />
		             		</td> 
		             		<td > 
		             			<input type="checkbox" name="_selectitem4" value="<c:out value='${item.btrvo.ruleid}|${item.cityid}' />"
		                               onclick="checkOne(null,'_selectitem4','allbox4');" class="table_checkbox">
		                              <a href="javascript:startup('<c:out value="${urlContent}"/>','WOF','<c:out value="${item.cityname}"/>','<c:out value="${item.btrvo.woffstate}"/>','<c:out value="${item.btrvo.cfmbillstate}"/>','<c:out value="${item.btrvo.confirmway}"/>')">启动</a>	       
		                    </td>
                        </c:otherwise>
                    </c:choose>
                	
                 </tr>
             </c:forEach>
        </table>
    </div>
    </div>
</html:form>
<script type="text/javascript">
	setInterval("autoRefresh()",1000*60*3);
</script>
</body>
</html>





























