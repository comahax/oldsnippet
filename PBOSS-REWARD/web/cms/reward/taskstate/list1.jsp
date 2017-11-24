<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_MON";
%>
<html>
<head>
    <title><bean:message bundle="billstatus" key="title1"/></title>
    <base target="_self">
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {                    
            return checkval(window);   
        } 
        
        function showLog(step,region){
        	var rewardmonth = formList._se_rewardmonth.value;
        	var url = contextPath + '/cms/reward/taskstate.do?CMD=SHOWLOG' + '&_TASKID=' + step + '&_REGION=' + region + '&_REWARDMONTH=' + rewardmonth;
       		var hWnd = window.showModalDialog(url,new Array(),"dialogWidth:750px; dialogHeight:300px; status:no;resizable:yes;");
        }
        
        function doBatchstartup() {
        	var rewardmonth = formList._se_rewardmonth.value;
        	
        	var ischeck = false;
        	if(document.all._selectitem != null){
				if(document.all._selectitem.length != null ){				
					for( j = 0; j < document.all._selectitem.length; j++ ) {
						if( document.all._selectitem[j].checked == true ) {		
							ischeck = true;
							break;
						}														
					}											
				}else{		
					ischeck = document.all._selectitem.checked;					
				}
			}
			if(!ischeck){
				alert('请选择确认的记录！');
				return;
			}
			
			if(confirm('是否启动?')){
				formList.action =  contextPath + '/cms/reward/taskstate.do?CMD=BATCHSTARTUP'; //+ '&_TASKID=' + step + '&_REGION=' + region + '&_REWARDMONTH=' + rewardmonth;   	    
				formList.submit();
			} 			
		}
		
		function goMain(){
			formList.action =  contextPath + '/cms/reward/taskstate.do?CMD=SET';  
			formList.submit();
		}	
        
     
    </script>
    <style type="text/css">
	    .point {
			background:url(images/accounting/point77.JPG) no-repeat 0px 0px;text-align:center;
		}
	</style>
</head>

<body onload="loadforiframe1();">
<div class="table_container">
<html:form action="/cms/reward/taskstate.do?CMD=SHOWPROC" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>	
	<html:hidden property="_se_rewardmonth"/>
	<html:hidden property="rewardmonth"/>
	<html:hidden property="cityid"/>
	<html:hidden property="_se_cityid"/>
	<html:hidden property="taskid"/>
	<html:hidden property="year"/>
	<html:hidden property="month"/>
	
	
	 <div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="taskstate" key="subtitle"/></td>			 
            	
            </tr>
        </table>
    </div>   
    <div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>  
	<div class="table_div">
		<table class="table_button_list">
			<tr>
			<td>
				<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
				<c:forEach var="item" items="${requestScope.LIST}">
					<c:forEach var="stat" items="${item.statusdata}">
						<c:if test="${stat.mainState eq 0 or stat.mainState eq -1}">
							<c:set var="mState" value="${stat.mainState}" />
						</c:if>
					</c:forEach>
				</c:forEach>
				<c:choose>
				<c:when test="${mState eq 0 or mState eq -1}">
					<input type="button" class="button_2" onmouseover="buttonover(this);" 
                 	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                    value="启动" onclick="doBatchstartup();"/>
				</c:when>
				<c:otherwise>
				<input type="button" class="button_2" onmouseover="buttonover(this);" 
                 	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                    value="启动" onclick="doBatchstartup();" disabled="true"/>
				</c:otherwise>
               </c:choose>
               </s:RewardPurChk>
                <input type="button" class="query" onmouseover="buttonover(this);"
			        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			        value="返回" onClick="goMain();"/>
			</td> 	
			</tr>
		</table>
	</div>   
	<div class="table_div" style="text-align:left;">
		<span class="point" style="width:750px;height:20px;padding:9px 0 0 500px;margin-top:0px;">
		</span>
	</div>
    <div class="table_div" style="text-align: left;">
        <table class="table2">	
        <c:forEach var="item" items="${requestScope.LIST}">      		       	
            <tr>
            	<td width="10px"></td>
            		
            	<td>
            		<input type="checkbox" name="_selectitem" value="<c:out value='${item.region}' />" onclick="" class="table_checkbox">
            	</td>
            	
            	<td class="location" width="30px">
            	<s:Code2Name code="${item.region}" definition="#CITYIDNUM2NMAME" />:
            	</td>
            	<c:forEach var="stat" items="${item.statusdata}">
            		
            		<c:if test="${stat.subphase ne 0}">
            		
            		<td class="jiantou0"></td>
            		</c:if>
            		
            		<td style="cursor:hand;" onclick="showLog('<c:out value='${stat.stepname}'/>','<c:out value='${item.region}'/>');" class="mycolor_<c:out value="${stat.status + 0}"/>"><s:Code2Name code="${stat.stepname}" definition="#SUBTASKNAME" /></td>
            	</c:forEach>		
            </tr> 
            <tr>
              	<td height="10px"></td>			
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	
				<td></td>	  
				<td></td>	
				<td></td>
				<td></td>	
				<td></td>
				<td></td>	
				<td></td> 
				<td></td>	
				<td></td>             
            </tr>
             
        </c:forEach>        
        </table>
    </div>
<br><br><br>
</html:form>
</div>
</body>
</html>





























