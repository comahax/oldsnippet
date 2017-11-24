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
    <title><bean:message bundle="zjtycompact" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="zjtycompact" key="wayid"/>', 'c', false, '32');
            addfield('conef', '<bean:message bundle="zjtycompact" key="conef"/>', 'f', false, '1','2');
            //addfield('opertime', '<bean:message bundle="zjtycompact" key="opertime"/>', 't', false, '7');
            addfield('opercode', '<bean:message bundle="zjtycompact" key="opercode"/>', 'c', false, '32');
            addfield('fixednum', '<bean:message bundle="zjtycompact" key="fixednum"/>', 'i', false, '6');
            var fixednum=formItem.fixednum.value;
            var re = /^[1-9]d*$/;
    		//alert(!re.test(arg1[i]));
    		if(fixednum.length > 0 && !re.test(fixednum)){
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="zjtycompact" key="fixednum"/>]必须是大于零的整数</span>');
    			return false;
    		}
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/zjtycompact.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtycompact/ZjtycompactForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtycompact" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtycompact" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
<!--                            <s:zoom definition="#WAY" property="wayid" styleClass="form_input_1x" condition="waytype:${'AG'};waysubtype:${'ZJTY'}" readonly="true"/>-->
							<html:text styleClass="form_input_1x" property="wayid" readonly="true"></html:text><input type="button" value="..." class="clickbutton" 
                    		onclick="showSelectWay3(this,'wayid','','','AG','ZJTY');this.value='...';" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtycompact" key="conef"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="conef" />
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="conef" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="conef" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtycompact" key="fixednum"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="fixednum" />
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="fixednum" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="fixednum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr style="display: none;">
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtycompact" key="opertime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState||errorState}">
                        	<input type='text' class="form_input_1x" name="opertime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.opertime}"/>"
									onclick="this.value = selectDate()" />
                    	<c:out value="${requestScope['/cms/zjty/zjtycompact/ZjtycompactForm'].opertime}" />
                        </c:when>
                        <c:otherwise>
                        <c:out value="${requestScope['/cms/zjty/zjtycompact/ZjtycompactForm'].opertime}" />
                        	<input type='text' class="form_input_1x" name="opertime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.opertime}"/>"
									disabled="disabled" />
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
                           onclick="doSave('/cms/zjty/zjtycompact.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/zjtycompact.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
