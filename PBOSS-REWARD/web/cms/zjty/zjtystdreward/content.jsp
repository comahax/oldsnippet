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
    <title><bean:message bundle="zjtystdreward" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seq', '<bean:message bundle="zjtystdreward" key="seq"/>', 'f', true, '16');
            addfield('opnid', '<bean:message bundle="zjtystdreward" key="opnid"/>', 'c', false, '32');
            addfield('cityid', '<bean:message bundle="zjtystdreward" key="cityid"/>', 'f', false, '3');
            addfield('rewardstd', '<bean:message bundle="zjtystdreward" key="rewardstd"/>', 'f', false, '16');
            addfield('intvmonth', '<bean:message bundle="zjtystdreward" key="intvmonth"/>', 'f', false, '3');
            addfield('ruleid', '<bean:message bundle="zjtystdreward" key="ruleid"/>', 'c', false, '64');
            addfield('rewardtype', '<bean:message bundle="zjtystdreward" key="rewardtype"/>', 'f', false, '3');
            addfield('startdate', '<bean:message bundle="zjtystdreward" key="startdate"/>', 't', false, '7');
            addfield('enddate', '<bean:message bundle="zjtystdreward" key="enddate"/>', 't', false, '7');

            return checkval(window);
        }
        function doShowRule(id) {
			var urlForPrint = contextPath + '/cms/reward/rule2.do?CMD=SELECTZJTYRULE&PK=' + formItem.opnid.value;
			var returnValue = window.showModalDialog(urlForPrint, "", "dialogWidth=550px;dialogHeight=450px;status=no;resizable:yes;");
			returnValue = returnValue==null?"":returnValue;
			if (returnValue != "") {
				document.all(id).value = returnValue;
			}
		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/zjtystdreward.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_seq"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_ne_cityid"/>
    <html:hidden property="seq"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtystdreward/ZjtyStdrewardForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtystdreward" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtystdreward" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<s:myzoom definition="#ZJTY_OPERATION" property="opnid" condition="opnid:6501010300001*,6501010300003*;isbusi:1;" styleClass="form_input_1x"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtystdreward" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtystdreward" key="intvmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="intvmonth" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="intvmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtystdreward" key="ruleid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="ruleid" /><input type="button" value="..." class="clickButton" onclick="doShowRule('ruleid')" >
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ruleid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtystdreward" key="rewardtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
<!--                            <html:text styleClass="form_input_1x" property="rewardtype" />-->
<!--                            <s:Code2Name code="${rewardtype}" definition="#CH_ZJTY_REWARDTYPE"/>-->
							<html:select property="rewardtype">
										<html:option value=""></html:option>
										<s:Options definition="#CH_ZJTY_REWARDTYPE" />
							</html:select>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtystdreward" key="startdate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${form.startdate}"
											pattern="yyyy-MM-dd" />" maxlength="10"
											onclick="this.value=selectDate();"  readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${form.startdate}"
											pattern="yyyy-MM-dd" />" disabled=true />
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtystdreward" key="enddate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input class="form_input_1x" type="text" name="enddate"
											value="<fmt:formatDate value="${form.enddate}"
											pattern="yyyy-MM-dd" />" maxlength="10"
											onclick="this.value=selectDate();"  readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <input class="form_input_1x" type="text" name="enddate"
											value="<fmt:formatDate value="${form.enddate}"
											pattern="yyyy-MM-dd" />" disabled=true />
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
<%--                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"--%>
<%--                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                           value="<bean:message bundle="public" key="button_save"/>" class="submit"--%>
<%--                           onclick="doSave('/cms/zjty/zjtystdreward.do?CMD=SAVE')"/>--%>
<!--                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"-->
<!--                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"-->
<!--                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">-->
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/zjtystdreward.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
