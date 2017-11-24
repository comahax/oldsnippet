<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chpdrewardrule" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('coopertype', '<bean:message bundle="chpdrewardrule" key="coopertype"/>', 'f', false, '1');
            addfield('cooperrate', '<bean:message bundle="chpdrewardrule" key="cooperrate"/>', 'f', true, '3', '2', null, '0', '1');
            addfield('phase1', '<bean:message bundle="chpdrewardrule" key="phase1"/>', 'f', true, '3');
            addfield('phase1rate', '<bean:message bundle="chpdrewardrule" key="phase1rate"/>', 'f', true, '3', '2', null, '0', '1');
            addfield('phase2', '<bean:message bundle="chpdrewardrule" key="phase2"/>', 'f', true, '3');
            addfield('phase2rate', '<bean:message bundle="chpdrewardrule" key="phase2rate"/>', 'f', true, '3', '2', null, '0', '1');
            addfield('phase3rate', '<bean:message bundle="chpdrewardrule" key="phase3rate"/>', 'f', true, '3', '2', null, '0', '1');
            addfield('inusetime', '<bean:message bundle="chpdrewardrule" key="inusetime"/>', 't', false, '7');
            addfield('outusetime', '<bean:message bundle="chpdrewardrule" key="outusetime"/>', 't', false, '7');
            addfield('version', '<bean:message bundle="chpdrewardrule" key="version"/>', 'f', true, '6');

            return checkval(window);
        }
        
        function saveRewardrule() {
        	var coopertype = document.getElementById("coopertype").value;
        	if (coopertype != 3) {
        		addfield('subcategory', '<bean:message bundle="chpdrewardrule" key="subcategory"/>', 'c', false, '15');
        	}
        	if (ev_checkval()) {
        		document.getElementById("coopertype").disabled = false;
        		document.getElementById("subcategory").disabled = false;
        		formItem.submit();
        	}
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/provagent/chpdrewardrule.do?CMD=SAVE" styleId="formItem" method="post">
	<html:hidden property="ruleid"/>
	
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_coopertype"/>
    <html:hidden property="_se_subcategory"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/ChPdRewardruleForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdrewardrule" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="coopertype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select styleClass="form_input_1x" property="coopertype" styleId="coopertype" disabled="true">
		                    	<option></option>
								<s:Options definition="$PD_HZLX"/>
							</html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select styleClass="form_input_1x" property="coopertype" styleId="coopertype">
		                    	<option></option>
								<s:Options definition="$PD_HZLX"/>
							</html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select styleClass="form_input_1x" property="coopertype" styleId="coopertype" disabled="true">
		                    	<option></option>
								<s:Options definition="$PD_HZLX"/>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="cooperrate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="cooperrate" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="cooperrate" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cooperrate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="subcategory"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select styleClass="form_input_1x" property="subcategory" styleId="subcategory" disabled="true">
		                    	<option></option>
								<s:Options definition="$PD_JTCPZLX"/>
							</html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select styleClass="form_input_1x" property="subcategory" styleId="subcategory">
		                    	<option></option>
								<s:Options definition="$PD_JTCPZLX"/>
							</html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select styleClass="form_input_1x" property="subcategory" disabled="true">
		                    	<option></option>
								<s:Options definition="$PD_JTCPZLX"/>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="phase1"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="phase1" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="phase1" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="phase1rate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="phase1rate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="phase1rate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="phase2"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="phase2" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="phase2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="phase2rate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="phase2rate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="phase2rate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="phase3rate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="phase3rate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="phase3rate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="inusetime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input class="form_input_1x" name="inusetime" id="inusetime" value="<fmt:formatDate value="${form.inusetime}" pattern="yyyy-MM-dd"/>" 
                            	onclick="WdatePicker({dateFmt:'yyyy-MM-dd', maxDate:'#F{$dp.$D(\'outusetime\')}'})" readonly="readonly"/>
                        </c:when>
                        <c:otherwise>
                            <input class="form_input_1x" name="inusetime" value="<fmt:formatDate value="${form.inusetime}" pattern="yyyy-MM-dd"/>" disabled/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="outusetime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input class="form_input_1x" name="outusetime" id="outusetime" value="<fmt:formatDate value="${form.outusetime}" pattern="yyyy-MM-dd"/>" 
                            	onclick="WdatePicker({dateFmt:'yyyy-MM-dd', minDate:'#F{$dp.$D(\'inusetime\')}'})" readonly="readonly"/>
                        </c:when>
                        <c:otherwise>
                            <input class="form_input_1x" name="outusetime" value="<fmt:formatDate value="${form.outusetime}" pattern="yyyy-MM-dd"/>" disabled/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdrewardrule" key="version"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="version" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="version" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>&nbsp;版本号自动生成
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
                           onclick="saveRewardrule()"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/provagent/chpdrewardrule.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
