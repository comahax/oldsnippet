<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D3C2B2B" />
</jsp:include>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "4D3C2B2BBT1";
	String ID_2 = "4D3C2B2BBT2";
	String ID_3 = "4D3C2B2BBT3";
	
%>
<html>
	<head>
		<title><s:Code2Name code="${_STEPNAME}" definition="#SUBTASKNAME" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
		</script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/taskstate.do?CMD=SHOWLOG"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				
				
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">
			

				<div class="table_div">
					<table class="top_table">
						<tr>							
							<td>
								<s:Code2Name code="${_STEPNAME}" definition="#SUBTASKNAME" />
							</td>
							
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
			                 <input type="button" class="query" onmouseover="buttonover(this);"
			                      	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                   		value="¹Ø±Õ" onClick="window.close();"/>			          
			               </td> 	
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
					<table class="table_style" ID="Table2">
						
						<tr class="table_style_head">
							<td><bean:message bundle="taskstate" key="taskid"/></td>	
							<td><bean:message bundle="taskstate" key="ownertaskid"/></td>	
							<td><bean:message bundle="taskstate" key="starttime"/></td>	
							<td><bean:message bundle="taskstate" key="endtime"/></td>	
							<td><bean:message bundle="taskstate" key="state"/></td>	
                  				
							
						</tr>
						<c:forEach var="item" items="${requestScope.LIST.datas}">							
							<tr class="table_style_content" align="center">															
								<td><c:out value="${item.taskid}" /></td>
								<td><c:out value="${item.ownertaskid}" /></td>
								
								<td><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.starttime}" /></td>
								<td><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.endtime}" /></td>
								<td><s:Code2Name code="${item.state}"
											definition="$CH_MONTASKSTATE" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="table_div">
					<s:PageNav dpName="LIST" />
				</div>
			</html:form>
		</div>
	</body>
</html>
