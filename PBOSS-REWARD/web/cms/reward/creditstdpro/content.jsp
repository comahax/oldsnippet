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
    <title>省公司酬金标准管理</title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('slv', '<bean:message bundle="creditstd" key="slv"/>', 'f', false, '22');
            addfield('creditstd', '<bean:message bundle="creditstd" key="creditstd"/>', 'f', false, '8', '2', '', '0');
            addfield('cardstd', '<bean:message bundle="creditstd" key="cardstd"/>', 'f', false, '8', '2', '', '0');
            addfield('adtypecode', '<bean:message bundle="creditstd" key="adtypecode"/>', 'f', false, '22');
            addfield('coreward', '<bean:message bundle="creditstd" key="coreward"/>', 'f', false, '8', '2', '', '0');
            addfield('rewardstd', '星级奖励标准上限', 'f', false, '8', '2', '', '0');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/creditstdpro.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_cityid"/>
    <html:hidden property="_ne_slv"/>
    <html:hidden property="cityid"/>
    <html:hidden property="seq"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd/CreditstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			省公司酬金标准管理
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd" key="slv"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="slv" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLEVEL" />
							</html:select>
							<font color='red'>*</font>
					    </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="slv">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLEVEL" />
							</html:select>
							<font color='red'>*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="slv" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_STARLEVEL" />
							</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="creditstd" key="adtypecode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="adtypecode" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_COUNTYCOMPTYPE" />
							</html:select>
                            <font color='red'>*</font>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="adtypecode" >
								<html:option value=""></html:option>
								<s:Options definition="$CH_COUNTYCOMPTYPE" />
							</html:select>
                            <font color='red'>*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="adtypecode" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$CH_COUNTYCOMPTYPE" />
							</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">销售积分标准下限:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="creditstd" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="creditstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">套卡标准下限:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cardstd" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cardstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">长期激励标准上限:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="coreward" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="coreward" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">星级酬金标准上限:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                            <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
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
                           onclick="doSave('/cms/reward/creditstdpro.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/creditstdpro.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
