<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%

 %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>
<html:html>
<head>
	<title>全部发布</title>
	<script language="JavaScript">
		function checkProcess(){
			var systemflag=document.getElementById('systemflag').value;
			var rewardmonth=document.getElementById('rewardmonth').value;
			var isflag=document.getElementById('isflag').value;
			var wayid=document.getElementById('wayid').value;
			var chainhead=document.getElementById('chainhead').value;
			var countyid=document.getElementById('countyid').value;
			var taskid=document.getElementById('taskid').value;
			var sin_opnid=document.getElementById('sin_opnid').value;
			var mobile=document.getElementById('mobile').value;
	        formItem.buttonProcess.disabled=true;
	      	window.location.href="<%= contextPath%>/cms/cityrecord4issue/batch.do?beanname=com.sunrise.boss.ui.cms.cityrecord.Cityrecord4IssueTaskBean&systemflag="+systemflag+"&rewardmonth="+rewardmonth+
	      	"&isflag="+isflag+"&wayid="+wayid+"&chainhead="+chainhead+"&mobile="+mobile+"&countyid="+countyid+"&sin_opnid="+sin_opnid;                                                                                        
		}
		function doReturnList(){
    		formItem.action="<%=contextPath%>/cms/cityrecord.do?CMD=SHOW";
			formItem.submit();
    	}
    	function doTxt(){
    		formItem.action="<%=contextPath%>/cms/cityrecord.do?CMD=DOWNLOAD";
			formItem.submit();
    	}	
    </script>
</head>
<body  onload＝" loadforiframe()">
<div class="table_container">
	<html:form action="/cms/cityrecord4issue/batch.do" styleId="formItem" method="post" >
	<input type="hidden" name="systemflag"  id="systemflag"  value="<c:out value='${requestScope.systemflag}' />">
	<input type="hidden" name="rewardmonth"  id="rewardmonth"  value="<c:out value='${requestScope.rewardmonth}' />">
	<input type="hidden" name="isflag"  id="isflag"  value="<c:out value='${requestScope.isflag}' />">
	<input type="hidden" name="wayid"  id="wayid"  value="<c:out value='${requestScope.wayid}' />">
	<input type="hidden" name="chainhead"  id="chainhead"  value="<c:out value='${requestScope.chainhead}' />">
	<input type="hidden" name="countyid"  id="countyid"  value="<c:out value='${requestScope.countyid}' />">
	<input type="hidden" name="taskid"  id="taskid"  value="<c:out value='${requestScope.taskid}' />">
	<input type="hidden" name="sin_opnid" id="sin_opnid" value="<c:out value='${requestScope.sin_opnid}' />"/>
	<input type="hidden" name="mobile" id="mobile" value="<c:out value='${requestScope.mobile}' />"/>
	<input type="hidden" name="disabled"  id="disabled"  value="<c:out value='${requestScope.disabled}' />">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							全部发布
						</td>
					</tr>
				</table>
		    </div>
			<div class="table_div">
			<table width="100%" class="error_text">
	        	<s:Msg />
	   		</table>
	   		</div>
	   		<div class="table_div">


		</div>
		<iframe
				src="<%=contextPath%>/cms/cityrecord/all.jsp?beanname=com.sunrise.boss.ui.cms.cityrecord.Cityrecord4IssueTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" value="确定" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" 
								<c:if test="${requestScope.disabled eq 'true' }">
								disabled="true"
								</c:if>
								onClick="checkProcess()" />
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturnList()">
                           	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="结果导出" class="button_4"
                           		onclick="doTxt()">
                           	 
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
