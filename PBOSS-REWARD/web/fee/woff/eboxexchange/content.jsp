<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<html:html>
<head>
    <title><bean:message bundle="eboxexchange" key="title"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/pub/list.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('newprodid', '<bean:message bundle="eboxexchange" key="newprodid"/>', 'c', false, 32);
            addfield('oldprodid', '<bean:message bundle="eboxexchange" key="oldprodid"/>', 'c', false, 32);
            addfield('neweboxunitid', '<bean:message bundle="eboxexchange" key="neweboxunitid"/>', 'l', false, 14);
            addfield('oldeboxunitid', '<bean:message bundle="eboxexchange" key="oldeboxunitid"/>', 'l', false, 14);
            addfield('sbegindate', '<bean:message bundle="eboxexchange" key="begindate"/>', 'dt', true, 20);
            addfield('senddate', '<bean:message bundle="eboxexchange" key="enddate"/>', 'dt', true, 20);
            addfield('region', '<bean:message bundle="eboxexchange" key="region"/>', 'i', false, 5);     
           if(date_compare("sbegindate","senddate",'<bean:message bundle="eboxexchange" key="begindate"/><bean:message bundle="fee" key="compare_gt"/><bean:message bundle="eboxexchange" key="enddate"/>')) return;  
            return checkval(window);
        }      
    </script> 
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/eboxexchange/eboxexchange.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
	 
	
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    

	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="eboxexchange" key="title"/></td>
		
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
				<td colspan="4"><bean:message bundle="fee" key="redStarExplain"/></td>
			</tr>
            <tr>                
                <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxexchange" key="newprodid"/>:</div></td>
                <td class="form_table_left">                    
                    <c:choose>
                        	<c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
                            <s:zoom definition="#PRODUCT" property="newprodid" styleClass="form_input_1x"  condition="mainprod:${1};"  /><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
                            <s:zoom definition="#PRODUCT" property="newprodid" styleClass="form_input_1x" showonly="true"/><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxexchange" key="neweboxunitid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        	<c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
                            <s:eboxacct type="EBOXUNIT" property="neweboxunitid"  readonly="false" styleClass="form_input_1x" /><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
                             <s:eboxacct type="EBOXUNIT" property="neweboxunitid" styleClass="form_input_1x" disabled="true"/><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>                             
                <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxexchange" key="oldprodid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        	<c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
                            <s:zoom definition="#PRODUCT" property="oldprodid" styleClass="form_input_1x"  condition="mainprod:${1};" /><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
                            <s:zoom definition="#PRODUCT" property="oldprodid" styleClass="form_input_1x" showonly="true"/><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxexchange" key="oldeboxunitid"/>:</div></td>
                <td class="form_table_left">                    
                    <c:choose>
                        	<c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
                             <s:eboxacct type="EBOXUNIT" property="oldeboxunitid" readonly="false" styleClass="form_input_1x" /><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
                             <s:eboxacct type="EBOXUNIT" property="oldeboxunitid" styleClass="form_input_1x"  disabled="true"/><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>                             
                <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxexchange" key="region"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        	<c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
                            <s:zoom definition="#CITYIDNUM2NMAME" property="region" styleClass="form_input_1x" /><bean:message bundle="fee" key="redStar"/>
                        </c:when>
                        <c:otherwise>
                            <s:zoom definition="#CITYIDNUM2NMAME" property="region" styleClass="form_input_1x" showonly="true"/><bean:message bundle="fee" key="redStar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td class="form_table_right"/>
                <td class="form_table_left"/>                    
                   
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxexchange" key="begindate"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="sbegindate" maxlength="24" onclick="this.value=selectDatetime()"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="sbegindate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="eboxexchange" key="enddate"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="senddate" maxlength="24" onclick="this.value=selectDatetime()"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="senddate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>       
              
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
					<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_submit"/>" class="submit"
                           onclick="doSave('/fee/woff/eboxexchange/eboxexchange.do?CMD=SAVE')"/>
                 <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                     <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/fee/woff/eboxexchange/eboxexchange.do?CMD=LIST')">
				</td>		
			</tr>
		</table>
	</div>
    
</html:form>
</div>
</body>
</html:html>
