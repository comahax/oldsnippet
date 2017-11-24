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
    <title><bean:message bundle="blacklist" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('name', '<bean:message bundle="blacklist" key="name"/>', 'c', false, '20');
            addfield('mobile', '<bean:message bundle="blacklist" key="mobile"/>', 'c', false, '15');
            addfield('filtertype', '<bean:message bundle="blacklist" key="filtertype"/>', 'c', false, '20');
            addfield('starttime', '<bean:message bundle="blacklist" key="starttime"/>', 't', false, '7');
            addfield('endtime', '<bean:message bundle="blacklist" key="endtime"/>', 't', false, '7');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/bbc/blacklist.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_mobile"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/blacklist/BlacklistForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="blacklist" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="blacklist" key="name"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:if test="${updateState}">
	                            <html:text styleClass="form_input_1x" property="name" readonly="true"/>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:text styleClass="form_input_1x" property="name" />
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="name" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="blacklist" key="mobile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="mobile" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="mobile" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mobile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="blacklist" key="filtertype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <c:if test="${updateState}">
	                            <html:text styleClass="form_input_1x" property="filtertype" readonly="true"/>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:text styleClass="form_input_1x" property="filtertype" />
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="filtertype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="blacklist" key="starttime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <!-- <html:text styleClass="form_input_1x" property="starttime" />  -->
                            <input type='text' class="form_input_1x" name="starttime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.starttime}"/>"
								onclick="this.value = selectDate()"	/>
                        </c:when>
                        <c:otherwise>
                            <input type='text' class="form_input_1x" name="starttime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.starttime}"/>"
									disabled="true" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="blacklist" key="endtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <!-- <html:text styleClass="form_input_1x" property="endtime" />   -->
                            <input type='text' class="form_input_1x" name="endtime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.endtime}"/>"
								onclick="this.value = selectDate()"	/>
                        </c:when>
                        <c:otherwise>
                            <input type='text' class="form_input_1x" name="endtime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.endtime}"/>"
									disabled="true" />
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
                           onclick="doSave('/cms/bbc/blacklist.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/bbc/blacklist.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
