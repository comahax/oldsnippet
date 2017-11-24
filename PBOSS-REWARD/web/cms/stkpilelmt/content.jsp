<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B6F1AAA" />
</jsp:include>
<%
	String ID_1 = "2B6F1AAABT1";
%>
<html:html>
<head>
    <title><bean:message bundle="stkpilelmt" key="title"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
    	var msgErrorPilelmt = '<bean:message bundle="stkpilelmt" key="msgErrorPilelmt"/>';
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="stkpilelmt" key="wayid"/>', 'c', false, 18);
            addfield('resourcetype', '<bean:message bundle="stkpilelmt" key="resourcetype"/>', 'l', false, 10);
            addfield('lesatlimit', '<bean:message bundle="stkpilelmt" key="lesatlimit"/>', 'i', true, 8);
            addfield('mostlimit', '<bean:message bundle="stkpilelmt" key="mostlimit"/>', 'i', true, 8);
            
            if (checkval(window)) {
            	var min = formItem.lesatlimit.value*1;
            	var max = formItem.mostlimit.value*1;
            	if (min > max) {
            		alert(msgErrorPilelmt);
            		return false;
            	}
            	return true;
            }
            return false;
        }
        
        
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/stkpilelmt.do?CMD=SAVE" styleId="formItem" method="post">
	
    <html:hidden property="cmdState"/>
	<html:hidden property="id"/>
	
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
	
	<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'SAVE')}"/>
	<c:set var="newState" scope="request" value="${requestScope['/cms/stkpilelmt/StkpilelmtForm'].cmdState eq 'NEW'}"/>
	
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="stkpilelmt" key="subtitle"/>
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
        	<tr>
                <td width="20%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stkpilelmt" key="wayid"/>:</div>
                </td>
                <td width="75%" align="left" class="form_table_left">
                	<c:choose>
                		<c:when test="${newState}">
                			<html:text styleClass="form_input_1x" property="wayid" onclick="showSelectWay(this)"/>
                		</c:when>
                		<c:otherwise>
                			<html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                		</c:otherwise>
                	</c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stkpilelmt" key="resourcetype"/>:</div>
                </td>
                <td width="75%" align="left" class="form_table_left">
	      			<c:choose>
                		<c:when test="${newState}">
                			<html:select property="resourcetype" styleClass="form_select_on">
								<option value=""></option>
                    			<s:Options definition="$IM_RESOURCETYPE"/>
                    		</html:select>
                		</c:when>
                		<c:otherwise>
                			<html:select property="resourcetype" styleClass="form_select_on" disabled="true">
								<option value=""></option>
                    			<s:Options definition="$IM_RESOURCETYPE"/>
                    		</html:select>
                		</c:otherwise>
                	</c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stkpilelmt" key="lesatlimit"/>:</div>
                </td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                		<c:when test="${edtState}">
                			<html:text styleClass="form_input_1x" property="lesatlimit" maxlength="8"/>
                		</c:when>
                		<c:otherwise>
                			<html:text styleClass="form_input_1x" property="lesatlimit" disabled="true"/>
                		</c:otherwise>
                	</c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="stkpilelmt" key="mostlimit"/>:</div>
                </td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                		<c:when test="${edtState}">
                			<html:text styleClass="form_input_1x" property="mostlimit" maxlength="8"/>
                		</c:when>
                		<c:otherwise>
                			<html:text styleClass="form_input_1x" property="mostlimit" disabled="true"/>
                		</c:otherwise>
                	</c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                	<s:PurChk controlid="<%=ID_1%>">
                		<input type="button" name="btnSave" value="<bean:message bundle="public" key="button_save"/>" class="save"
	                    	   	onclick="doSave('/cms/stkpilelmt.do?CMD=SAVE')">
	                </s:PurChk>
                	<input type="button" name="btnReturn" value="<bean:message bundle="public" key="button_return"/>" class="close"
                    	   	onclick="doReturn('/cms/stkpilelmt.do?CMD=LIST')">                    
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html:html>
