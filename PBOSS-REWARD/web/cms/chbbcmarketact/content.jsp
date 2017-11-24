<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chbbcmarketact" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="chbbcmarketact" key="opnid"/>', 'c', false, '18');
            addfield('rewardmonth', '<bean:message bundle="chbbcmarketact" key="rewardmonth"/>', 'c', false, '6');
            addfield('acttype', '<bean:message bundle="chbbcmarketact" key="acttype"/>', 'c', false, '32');

            return checkval(window);
        }
        
        function showOpnid(v) {
        	var arg = new Array();
        	var strUrl = contextPath + "/cms/bbc/operation.do?CMD=SELECT&_se_busibelong=LL_V2&_ne_state=1&_ne_isbusi=1";
			var retValue = window.showModalDialog(strUrl, arg, "dialogWidth:600px;dialogHeight:390px;status:no;resizable:yes;");
			if (retValue && retValue != null && retValue != "") {
				v.value = retValue;
			} else {
				v.value = "";
			}
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chbbcmarketact.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_sne_opnid"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_se_rewardmonth"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chbbcmarketact/ChbbcmarketactForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chbbcmarketact" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chbbcmarketact" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" onclick="showOpnid(this)"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chbbcmarketact" key="rewardmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="rewardmonth" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="rewardmonth"  readonly="true"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chbbcmarketact" key="acttype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select styleClass="form_input_1x" property="acttype">
                          		<option/>
                        		<s:Options definition="$BBC_MARKETACT" />
                        	</html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select styleClass="form_input_1x" property="acttype" disabled="true">
                          		<option/>
                        		<s:Options definition="$BBC_MARKETACT" />
                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chbbcmarketact" key="actprofile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="actprofile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="actprofile" disabled="true"/>
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
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_save"/>" class="submit"
						onclick="doSave('/cms/chbbcmarketact.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_return"/>" class="close"
						onclick="doReturn('/cms/chbbcmarketact.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
