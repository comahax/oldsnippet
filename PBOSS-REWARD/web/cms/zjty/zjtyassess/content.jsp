<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    String cityid = request.getParameter("cityid");
%>
<html>
<head>
    <title><bean:message bundle="zjtyassess" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="zjtyassess" key="wayid"/>', 'c', false, '32');
            addfield('calcmonth', '<bean:message bundle="zjtyassess" key="calcmonth"/>', 'c', false, '6');
            addfield('coef1', '<bean:message bundle="zjtyassess" key="coef1"/>', 'f', true, '1', '2');
            addfield('coef2', '<bean:message bundle="zjtyassess" key="coef2"/>', 'f', true, '1', '2');
            addfield('coef3', '<bean:message bundle="zjtyassess" key="coef3"/>', 'f', true, '1', '2');
            addfield('fixednum', '<bean:message bundle="zjtyassess" key="empnum"/>', 'i', true, '6');
            var empnum=formItem.empnum.value;
            var re = /^\d*$/;
    		//alert(!re.test(empnum));
    		if(empnum.length > 0 && !re.test(empnum)){
    			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="zjtyassess" key="empnum"/>]大于等于零的整数，无数据时默认取该厅核定人数。可以留空。</span>');
    			return false;
    		}
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/zjtyassess.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_se_calcmonth"/>
    <html:hidden property="_ne_cityid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtyassess/ZjtyassessForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtyassess" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtyassess" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
<!--                            <s:zoom definition="#WAY" property="wayid" styleClass="form_input_1x" condition="waytype:${'AG'};waysubtype:${'ZJTY'}"/>-->
							<html:text styleClass="form_input_1x" property="wayid"></html:text><input type="button" value="..." class="clickbutton" 
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtyassess" key="calcmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="calcmonth" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="calcmonth" onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="calcmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtyassess" key="coef1"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="coef1" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="coef1" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
					整数位1位，小数位两位。无数据时默认取值1。
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtyassess" key="coef2"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="coef2" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="coef2" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
					整数位1位，小数位两位。无数据时默认取值1。
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtyassess" key="coef3"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="coef3" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="coef3" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                   	 整数位1位，小数位两位。无数据时默认取值1。
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtyassess" key="empnum"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="empnum" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="empnum" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
					无数据时默认取该厅核定人数。
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
                           onclick="doSave('/cms/zjty/zjtyassess.do?CMD=SAVE')"/>
<!--                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"-->
<!--                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"-->
<!--                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">-->
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/zjtyassess.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
