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
    <title><bean:message bundle="chadtsales" key="titleUpdate"/></title>
     <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="chadtsales" key="opnid"/>', 'c', false, '18');
            addfield('wayattr', '<bean:message bundle="chadtsales" key="wayattr"/>', 'c', false, '2');
            addfield('sales', '<bean:message bundle="chadtsales" key="sales"/>', 'f', false, '10');
            addfield('rewardstd', '<bean:message bundle="chadtsales" key="rewardstd"/>', 'f', false, '16');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chadtsales.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_se_wayattr"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and param.CMD eq 'NEW'}"/>
    <c:set var="edtState2" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtsales/ChAdtSalesForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtsales" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtsales" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opnid" />
                            <input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, 'opnid' , 'busi' )">
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                             <input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, 'opnid' , 'busi' )">
                        </c:otherwise>
                    </c:choose>
                     <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtsales" key="wayattr"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="wayattr">
		                    	<option />
		                    	<s:Options definition="$CH_WAYATTR" />
		                    </html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="wayattr" disabled="true">
		                    	<option />
		                    	<s:Options definition="$CH_WAYATTR" />
		                    </html:select>
                        </c:otherwise>
                    </c:choose>
                      <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtsales" key="sales"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="sales" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="sales" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                      <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtsales" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState2}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
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
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/chadtsales.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/chadtsales.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
