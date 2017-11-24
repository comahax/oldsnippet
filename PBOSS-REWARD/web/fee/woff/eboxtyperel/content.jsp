<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<html:html>
<head>
    <title><bean:message bundle="eboxunit" key="eboxtypetitle"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('eboxunitid', '<bean:message bundle="eboxunit" key="eboxunitid"/>', 'l', false, 14);
            addfield('eboxtype', '<bean:message bundle="eboxunit" key="eboxtype"/>', 'i', false, 3);
            return checkval(window);
        }
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/eboxtyperel.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_eboxtype"/>
    <html:hidden property="_ne_eboxunitid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    
    <div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="eboxunit" key="eboxtypetitle"/></td>
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
        <table class="form_table">
        	<tr>
				<td align=left colspan=6><bean:message bundle="fee" key="redStarExplain"/></td>
			</tr>
           <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxunit" key="eboxunitid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                         <c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
							<s:zoom definition="#EBOXUNIT" property="eboxunitid" styleClass="form_input_1x"/>
                        </c:when>
                        <c:otherwise>
							<s:zoom definition="#EBOXUNIT" property="eboxunitid" styleClass="form_input_1x"  showonly="true"/>
                        </c:otherwise>
                    </c:choose>
                     <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxunit" key="eboxtype"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
							<html:select property="eboxtype">
                    			<html:option value=" "></html:option>
                    			<s:Options definition="$IB_EBOXTYPEREL" nameOnly="false"/>
                    		</html:select>
						</c:when>
                        <c:otherwise>
							<html:select property="eboxtype" disabled="true">
                    			<html:option value=" "></html:option>
                    			<s:Options definition="$IB_EBOXTYPEREL" nameOnly="false"/>
                    		</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/fee/woff/eboxtyperel.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/fee/woff/eboxtyperel.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
    
</html:form>
</div>
</body>
</html:html>
