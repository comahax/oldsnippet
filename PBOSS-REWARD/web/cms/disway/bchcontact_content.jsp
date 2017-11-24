<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "CH_PW_SOTYWAY_EDIT";
    String ID_2 = "CH_PW_SOTYWAY_QUERY";
%>

<html>
<head>
    <title><bean:message bundle="bchcontact" key="distitleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="bchcontact" key="wayid"/>', 'c', false, '18');
            addfield('principal', '<bean:message bundle="bchcontact" key="principal"/>', 'c', false, '64');
            addfield('principaltel', '<bean:message bundle="bchcontact" key="principaltel"/>', 'c', false, '20');
            addfield('linkman', '<bean:message bundle="bchcontact" key="linkman"/>', 'c', false, '64');
            addfield('linkmantel', '<bean:message bundle="bchcontact" key="linkmantel"/>', 'c', false, '20');
            addfield('principalemail', '<bean:message bundle="bchcontact" key="principalemail"/>', 'c', true, '128');
            addfield('linkmanemail', '<bean:message bundle="bchcontact" key="linkmanemail"/>', 'c', true, '128');
            return checkval(window);
        }
        
        function doReturnIndex(){
           var str = self.parent.location.toString();
           if(str.indexOf("subindex.jsp")==-1){
               doReturn('/cms/disbchcontact.do?CMD=LIST&WAYSUBTYPE=DIS');
           }else{
               self.parent.location='<%=contextPath%>/cms/disway/frame.jsp';
           }
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/disbchcontact.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <input type="hidden" name="subtype" value="DIS" />
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_sk_principal"/>
    <html:hidden property="_sk_principaltel"/>
    <html:hidden property="_sk_principalemail"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${(!empty param.CMD and (param.CMD eq 'EDIT')) or (!empty param._se_wayid)}"/>
    <c:choose>
        <c:when test="${empty param._se_wayid}">
            <c:set var="wayid_value" scope="request"  value="${requestScope['/cms/bchcontact/BchcontactForm'].wayid}"/>
        </c:when>
        <c:otherwise>
            <c:set var="wayid_value" scope="request"  value="${param._se_wayid}"/>
        </c:otherwise>
    </c:choose>
    
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="bchcontact" key="distitleList"/>
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
                 <td align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bchcontact" key="wayid"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                        	  <input type="text" name="wayid" maxlength="18" value="<c:out value='${wayid_value}'/>" readonly="readonly" class="form_input_1x">
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18"/><font color=red>&nbsp;*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr> 

            <tr>
                 <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bchcontact" key="principal"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="principal" maxlength="64"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="principal" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="15%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bchcontact" key="principaltel"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="principaltel" maxlength="20"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="principaltel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <tr>
                <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bchcontact" key="linkman"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="linkman" maxlength="64"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="linkman" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="15%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bchcontact" key="linkmantel"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="linkmantel" maxlength="20"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="linkmantel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <tr>
                <td width="12%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bchcontact" key="principalemail"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="principalemail" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="principalemail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                 <td width="15%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="bchcontact" key="linkmanemail"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="linkmanemail" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="linkmanemail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
            	  <s:PurChk2 controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/disbchcontact.do?CMD=SAVE')"/>
                  </s:PurChk2>
                 <s:PurChk2 controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                 </s:PurChk2>

                 <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                        name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_return"/>" class="close"
                        onclick="doReturnIndex()">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
