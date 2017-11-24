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
    <title><bean:message bundle="chpwregisterbroad" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
			addfield('telephone', '<bean:message bundle="chpwregisterbroad" key="telephone"/>', 'c', true, 15);
			addfield('mobile', '<bean:message bundle="chpwregisterbroad" key="mobile"/>', 'c', true, 15);
			addfield('broadnum', '<bean:message bundle="chpwregisterbroad" key="broadnum"/>', 'i', true, 3);
			addfield('opnid', '<bean:message bundle="chpwregisterbroad" key="opnid"/>', 'c', true, 18);
			addfield('wayid', '<bean:message bundle="chpwregisterbroad" key="wayid"/>', 'c', true, 15);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/kdkhzl/chpwregisterbroad.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
	    
    
    
    <c:set var="form" scope="request" value="${requestScope['/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm']}"/>
    <c:set var="edtState" scope="request" value="${!empty form.isEdit and (form.isEdit eq 'EDIT')}"/>
	<c:set var="updateState" scope="request" value="${!empty form.isNew and (form.isNew eq 'EDIT')}"/>
	
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpwregisterbroad" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwregisterbroad" key="broadid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="broadid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="broadid" disabled="true"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="broadid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>系统自动生成</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwregisterbroad" key="telephone"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:if test="${updateState}">
	                            <html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:text styleClass="form_input_1x" property="telephone" />
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwregisterbroad" key="mobile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mobile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mobile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwregisterbroad" key="broadnum"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="broadnum" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="broadnum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwregisterbroad" key="state"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="state">
								<html:option value="0">登记</html:option>
								<html:option value="1">作废</html:option>
								<html:option value="2">已补录</html:option>
							</html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="state">
								<html:option value="0">登记</html:option>
								<html:option value="1">作废</html:option>
								<html:option value="2">已补录</html:option>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwregisterbroad" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                        <html:text styleClass="form_input_1x" property="opnid" disabled="true" value="0502010100009"/>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwregisterbroad" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:if test="${updateState}">
	                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:text styleClass="form_input_1x" property="wayid" />
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpwregisterbroad" key="regdate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="regdate" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="regdate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>默认取系统当前时间</font>
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
                           onclick="doSave('/cms/kdkhzl/chpwregisterbroad.do?CMD=SAVE')"/>
                    
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/kdkhzl/chpwregisterbroad.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
