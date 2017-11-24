<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="1A1A3C" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<%
    String ID_1 = "1A1A3CBT1";
%>
<html>
<head>
    <title><bean:message bundle="cicsload" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function doCicsLoad( url ){
        	if( confirm('<bean:message bundle="cicsload" key="activeBkcicsload"/>') ){
        		document.formList.action = contextPath + url;
        		document.formList.submit();
        	}
        }
    </script>
</head>

<body>
<div class="table_container">
<html:form action="/fee/commons/cicsload.do?CMD=CICSLOAD" styleId="formList" method="post" onsubmit="return ev_check();">

    <div class="table_div"> 
        <table class="top_table">
            <tr>
				<td><bean:message bundle="cicsload" key="titleList"/></td>
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
                     <s:PurChk controlid="<%=ID_1%>">
                        <input type="button" name="cicsload"  class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="cicsload" key="cicsload"/>" onClick="doCicsLoad('/fee/commons/cicsload.do?CMD=CICSLOAD')"/>
                    </s:PurChk>
               </td>	
			</tr>
		</table>
	</div>
</html:form>
</div>
</body>
</html>
