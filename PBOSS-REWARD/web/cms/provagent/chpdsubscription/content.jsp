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
    <title><bean:message bundle="chpdsubscription" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('provagentid', '<bean:message bundle="chpdsubscription" key="provagentid"/>', 'c', false, '15');
            addfield('prodno', '<bean:message bundle="chpdsubscription" key="prodno"/>', 'c', false, '18');
            addfield('custid', '<bean:message bundle="chpdsubscription" key="custid"/>', 'c', false, '15');
            addfield('custname', '<bean:message bundle="chpdsubscription" key="custname"/>', 'c', false, '5');
            addfield('prodid', '<bean:message bundle="chpdsubscription" key="prodid"/>', 'c', false, '15');
            addfield('inbosstime', '<bean:message bundle="chpdsubscription" key="inbosstime"/>', 't', true, '7');
            addfield('cityid', '<bean:message bundle="chpdsubscription" key="cityid"/>', 'c', false, '4');
            addfield('salesi', '<bean:message bundle="chpdsubscription" key="salesi"/>', 'c', true, '15');
            addfield('servsi', '<bean:message bundle="chpdsubscription" key="servsi"/>', 'c', true, '15');
            addfield('agenteeid', '<bean:message bundle="chpdsubscription" key="agenteeid"/>', 'c', false, '15');
            addfield('coopertype', '<bean:message bundle="chpdsubscription" key="coopertype"/>', 'f', false, '1');
            addfield('incomstime', '<bean:message bundle="chpdsubscription" key="incomstime"/>', 't', true, '7');
            addfield('validation', '<bean:message bundle="chpdsubscription" key="validation"/>', 'f', false, '1');
            addfield('origin', '<bean:message bundle="chpdsubscription" key="origin"/>', 'f', false, '1');

            return checkval(window);
        }
        
        function doConfirmSave(cmdSave) {
			if (confirm("请确认发展地市是否正确，新增数据后地市标识不允许修改!")) {
				if (ev_checkval()) {
			        enable();
			        formItem.action = contextPath + cmdSave;
			        formItem.submit();
			    }
			    return false;
			}
		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/provagent/chpdsubscription.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_provagentid"/>
    <html:hidden property="_se_prodno"/>
    <html:hidden property="_se_prodid"/>
    <html:hidden property="_se_cityid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdsubscription/ChPdSubscriptionForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdsubscription" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="prodno"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="prodno" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="prodno" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="provagentid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
<%--                            <html:text styleClass="form_input_1x" property="provagentid" readonly="true"/>--%>
							<html:select property="provagentid"  disabled="true">
								<option />
								<s:Options definition="#CH_PD_AGENT"></s:Options>
							</html:select>
                        </c:if>
                        <c:if test="${!updateState}">
<%--                            <html:text styleClass="form_input_1x" property="provagentid" />--%>
                            <html:select property="provagentid" >
								<option />
								<s:Options definition="#CH_PD_AGENT"></s:Options>
							</html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="provagentid" disabled="true"/>--%>
                            <html:select property="provagentid" disabled="true">
								<option />
								<s:Options definition="#CH_PD_AGENT"></s:Options>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="custid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="custid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="custid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="custname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="custname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="custname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="prodid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="prodid" />--%>
                            <html:select property="prodid" >
								<option />
								<s:Options definition="#CH_PD_ENTPRODUCT"></s:Options>
							</html:select>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="prodid" disabled="true"/>--%>
                            <html:select property="prodid" disabled="true">
								<option />
								<s:Options definition="#CH_PD_ENTPRODUCT"></s:Options>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="inbosstime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="inbosstime" onclick="this.value=selectDate()" maxlength="25" />--%>
                            <input class="form_input_1x" name="inbosstime"	value="<fmt:formatDate value="${form.inbosstime}" pattern="yyyy-MM-dd"/>" onclick="this.value=selectDate();"/>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="inbosstime" disabled="true"/>--%>
                            <input class="form_input_1x" name="inbosstime"	value="<fmt:formatDate value="${form.inbosstime}" pattern="yyyy-MM-dd"/>" disabled/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="cityid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
							<html:select property="cityid"  disabled="true">
								<option />
								<s:Options definition="#REGIONNAME"></s:Options>
							</html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select property="cityid" >
								<option />
								<s:Options definition="#REGIONNAME"></s:Options>
							</html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="cityid" disabled="true">
								<option />
								<s:Options definition="#REGIONNAME"></s:Options>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="salesi"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="salesi" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="salesi" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="servsi"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="servsi" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="servsi" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="agenteeid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="agenteeid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="agenteeid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="coopertype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="coopertype" />--%>
                            <html:select property="coopertype">
								<option />
								<s:Options definition="$PD_HZLX"></s:Options>
							</html:select>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="coopertype" disabled="true"/>--%>
                            <html:select property="coopertype" disabled="true">
								<option />
								<s:Options definition="$PD_HZLX"></s:Options>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr style="display:none">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="incomstime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="incomstime" onclick="this.value=selectDate()" maxlength="25" />--%>
                            <input class="form_input_1x" name="incomstime"	value="<fmt:formatDate value="${form.incomstime}" pattern="yyyy-MM-dd"/>" onclick="this.value=selectDate();"/>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="incomstime" disabled="true"/>--%>
                            <input class="form_input_1x" name="incomstime"	value="<fmt:formatDate value="${form.incomstime}" pattern="yyyy-MM-dd"/>" disabled/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="validation"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<%--                            <html:text styleClass="form_input_1x" property="validation" />--%>
                            <html:select property="validation" >
								<option />
								<s:Options definition="#PD_YESORNO"></s:Options>
							</html:select>
                        </c:when>
                        <c:otherwise>
<%--                            <html:text styleClass="form_input_1x" property="validation" disabled="true"/>--%>
                            <html:select property="validation"  disabled="true">
								<option />
								<s:Options definition="#PD_YESORNO"></s:Options>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdsubscription" key="origin"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
							<html:select property="origin"  disabled="true">
								<option />
								<s:Options definition="$PD_ORIGINTYPE"></s:Options>
							</html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select property="origin" disabled="true">
								<option />
								<s:Options definition="$PD_ORIGINTYPE"></s:Options>
							</html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="origin" disabled="true">
								<option />
								<s:Options definition="$PD_ORIGINTYPE"></s:Options>
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
                           onclick="doConfirmSave('/cms/provagent/chpdsubscription.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/provagent/chpdsubscription/list.jsp')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
