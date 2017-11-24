<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B1A20" />
</jsp:include>

<html:html>
<head>
    <title></title>
</head>
<body>
<div class="table_container">
<html:form action="/zifee/yxplan.do?CMD=SAVE" styleId="formItem" method="post">
    

	<div class="table_div">

		<table class="top_table" border=0>
			<tr> 
				<td>
					<bean:message bundle="yxplan" key="tip"/>:
				</td>
			</tr>
		</table>
		</div>
		
	<div class="table_div">
		<table width="100%" class="error_text">
	        <html:errors/><s:Msg />
	   	</table>
	</div>	


<div class="table_div">	
      <table class="form_table">
      	  <tr><td  align="left"><div class="field-require"><bean:message bundle="yxplan" key="remark1"/></div></td></tr>
          <tr><td  align="left"><div class="field-require"><bean:message bundle="yxplan" key="remark2"/></div></td></tr>
          <tr><td  align="left"><div class="field-require"><bean:message bundle="yxplan" key="remark3"/></div></td></tr>
       </table>
    </div>

</html:form>
</div>`
</body>
</html:html>
