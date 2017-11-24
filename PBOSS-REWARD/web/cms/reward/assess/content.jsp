<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.common.base.db.SessionFactoryRouter,com.sunrise.boss.ui.commons.User;"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(((User)request.getSession().getAttribute("_USER")).getCityid()));
%>
<html>
<head>
    <title><bean:message bundle="assess" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            //addfield('seq', '<bean:message bundle="assess" key="seq"/>', 'f', false, '14');
            addfield('wayid', '<bean:message bundle="assess" key="wayid"/>', 'c', false, '20');
            addfield('assesstype', '<bean:message bundle="assess" key="assesstype"/>', 'f', false, '22');
            addfield('value', '<bean:message bundle="assess" key="value"/>', 'f', false, '8', '2');
            addfield('calcmonth', '<bean:message bundle="assess" key="calcmonth"/>', 'c', false, '6');
            //addfield('remark', '<bean:message bundle="assess" key="remark"/>', 'c', false, '256');
            //addfield('opercode', '<bean:message bundle="assess" key="opercode"/>', 'c', false, '20');
            //addfield('opertype', '<bean:message bundle="assess" key="opertype"/>', 'f', false, '22');
            //addfield('oprtime', '<bean:message bundle="assess" key="oprtime"/>', 't', false, '7');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/assess.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_ne_assesstype"/>
    <html:hidden property="_ne_value"/>
    <html:hidden property="_se_opercode"/>
    <html:hidden property="_dnm_oprtime"/>
    <html:hidden property="_dnl_oprtime"/>
    <html:hidden property="_se_calcmonth"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/assess/AssessForm']}"/>
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="assess" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="assess" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:hidden property="seq"/>
                    <c:choose>
                        <c:when test="${edtState}">
	                        <c:if test="${updateState}">
	                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:text styleClass="form_input_1x" property="wayid" />
	                            <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';" />
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="assess" key="assesstype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                        <c:if test="${updateState}">
	                            <html:select property="assesstype" disabled="true">
		                    		<option value=""></option>
		                    		<s:Options definition="#CH_TYPEINFO" condition="facetype:1;cityid:${cityid}"/>
			                    </html:select>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:select property="assesstype">
		                    		<option value=""></option>
		                    		<s:Options definition="#CH_TYPEINFO" condition="facetype:1;cityid:${cityid}"/>
			                    </html:select>
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="assesstype" disabled="true">
	                    		<option value=""></option>
	                    		<s:Options definition="#CH_TYPEINFO" condition="facetype:1;cityid:${cityid}"/>
		                    </html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="assess" key="value"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="value" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="value" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="assess" key="calcmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="calcmonth" onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="calcmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="assess" key="remark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="remark" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="remark" disabled="true"/>
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
                           onclick="doSave('/cms/reward/assess.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/assess.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
