<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_1 = "CH_PW_REWARD || CH_PW_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title><bean:message bundle="busitosmp" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
        	formItem.comprice.value = formItem.comprice_change.value * 100;
            addfield('opnid', '<bean:message bundle="busitosmp" key="opnid"/>', 'c', false, '18');
            addfield('comclassid', '<bean:message bundle="busitosmp" key="comclassid"/>', 'f', false, '6');
            addfield('brand', '<bean:message bundle="busitosmp" key="brand"/>', 'f', false, '1');
            addfield('comprice_change', '<bean:message bundle="busitosmp" key="comprice"/>', 'f', false, '12','2');
            addfield('comid', '商品标识', 'f', false, '18');
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/busitosmp.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="cityid" value="999"/>
    <html:hidden property="comprice" />
    
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/busitosmp/BusitosmpForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="busitosmp" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitosmp" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                        	<html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:text  property="opnid" styleClass="form_input_1x" readonly="true"/>
                   			<input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, 'opnid' , 'busi' )">
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitosmp" key="comclassid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                        	<html:select property="comclassid" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$IM_COMTYPE" />
							</html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                        	<html:select property="comclassid" >
								<html:option value=""></html:option>
								<s:Options definition="$IM_COMTYPE" />
							</html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="comclassid" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="$IM_COMTYPE" />
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitosmp" key="brand"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="brand">
								<html:option value=""></html:option>
								<s:Options definition="#BUSI_BRAND" />
							</html:select>
                        </c:when>
                        <c:otherwise>
                        	<html:select property="brand" disabled="true">
								<html:option value=""></html:option>
								<s:Options definition="#BUSI_BRAND" />
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="busitosmp" key="comprice"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="comprice_change" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="comprice_change" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="comprice_change" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>(单位:元)
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require">商品标识:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="comid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="comid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
	                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doSave('/cms/reward/busitosmp.do?CMD=SAVE')"/>
                    </s:RewardPurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/busitosmp.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
