<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A3CAA" />
</jsp:include>
<%
    String ID_1 = "4D6F1A3CAABT1";
    String ID_2 = "4D6F1A3CAABT2";
    String ID_3 = "4D6F1A3CAABT3";
%>
<html:html>
<head>
    <title><bean:message bundle="acctset" key="theUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('acctsetid', '<bean:message bundle="acctset" key="acctsetid"/>', 'l', false, 14);
            addfield('acctid', '<bean:message bundle="acctset" key="acctid"/>', 'l', false, 14);
            return checkval(window);
        }
        function doQueryAcctSet(){
			var url;
			var acctidObj = formItem.all("acctid");
			if( acctidObj==null ) return false;
			url = "<%=contextPath%>/fee/woff/acctset.do?CMD=LISTACCTSET&_que_acctid="+acctidObj.value;
			window.showModalDialog(url,"","dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
        }
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/acctset.do?CMD=SAVE" styleId="formItem" method="post" onsubmit="return ev_checkval();">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_acctsetid"/>
    <html:hidden property="_ne_acctid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="acctset" key="custMsg"/></td>
		</table>
	</div>	
	<div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>
	
	<div class="table_div">	
        <table class="form_table">
        	<tr>
				<td align=left colspan=6><bean:message bundle="fee" key="redStarExplain"/></td>
			</tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acctset" key="acctsetid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
                    		<s:zoom definition="#WOFF-ACCT" property="acctsetid" styleClass="form_input_1x" condition="acctlevel:0"/>
                        </c:when>
                        <c:otherwise>
                    		<s:zoom definition="#WOFF-ACCT" property="acctsetid" styleClass="form_input_1x" condition="acctlevel:0" showonly="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acctset" key="acctid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
							<s:zoom definition="#WOFF-ACCT" property="acctid" styleClass="form_input_1x" condition="_nne_acctlevel:0"/>
                        </c:when>
                        <c:otherwise>
							<s:zoom definition="#WOFF-ACCT" property="acctid" styleClass="form_input_1x" condition="_nne_acctlevel:0" showonly="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                    <input type="button" class="button_2" value="<bean:message bundle="acctset" key="listSet"/>" onclick="doQueryAcctSet();">
                    <bean:message bundle="acctset" key="exp"/>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                	<s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/fee/woff/acctset.do?CMD=SAVE')"/>
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_3%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/fee/woff/acctset.do?CMD=LIST')">
                	</s:PurChk>
                </td>
            </tr>
        </table>
    </div>
    
</html:form>
</div>
</body>
</html:html>
