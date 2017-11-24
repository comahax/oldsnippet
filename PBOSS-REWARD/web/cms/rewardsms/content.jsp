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
    <title><bean:message bundle="rewardsms" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('countyid', '<bean:message bundle="rewardsms" key="countyid"/>', 'c', true, '14');
            addfield('sendtime', '<bean:message bundle="rewardsms" key="sendtime"/>', 'dt', false, '7');
            addfield('calcmonth', '<bean:message bundle="rewardsms" key="calcmonth"/>', 'c', false, '6');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/rewardsms.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_countyid"/>
    <html:hidden property="_se_calcmonth"/>
    <html:hidden property="_se_opercode"/>
    <html:hidden property="_se_opertype"/>
    <html:hidden property="seq"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/rewardsms/RewardsmsForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardsms" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardsms" key="countyid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<c:if test="${updateState}">
	                            <html:select property="countyid" disabled="true">
			                    	<option />
			                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
			                    </html:select>
		                    </c:if>
							<c:if test="${!updateState}">
								<html:select property="countyid">
			                    	<option />
			                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
			                    </html:select>
							</c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="countyid" disabled="true">
		                    	<option />
		                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
		                    </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardsms" key="calcmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<c:if test="${updateState}">
                            	<html:text styleClass="form_input_1x" property="calcmonth" disabled="true"/>
                            </c:if>
							<c:if test="${!updateState}">
								<html:text styleClass="form_input_1x" property="calcmonth" onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
							</c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="calcmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rewardsms" key="sendtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input type="text" class="form_input_1x" name="sendtime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.sendtime }"/>"  onclick="this.value=selectDatetime()"/>
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="form_input_1x" name="sendtime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.sendtime }"/>" readonly="readonly" />
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>&nbsp;*</font>
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
                           onclick="doSave('/cms/rewardsms.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/rewardsms.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
