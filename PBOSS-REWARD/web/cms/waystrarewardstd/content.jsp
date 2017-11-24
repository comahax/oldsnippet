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
    <title><bean:message bundle="waystrarewardstd" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seq', '<bean:message bundle="waystrarewardstd" key="seq"/>', 'f', true, '14');
            addfield('wayid', '<bean:message bundle="waystrarewardstd" key="wayid"/>', 'c', false, '18');
            addfield('rewardstd', '<bean:message bundle="waystrarewardstd" key="rewardstd"/>', 'f', false, '10');
            addfield('rewardtype', '<bean:message bundle="waystrarewardstd" key="rewardtype"/>', 'f', false, '22');
            addfield('remark', '<bean:message bundle="waystrarewardstd" key="remark"/>', 'c', false, '256');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/waystrarewardstd.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_cityid"/>
    <html:hidden property="_ne_rewardtype"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/waystrarewardstd/WaystrarewardstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waystrarewardstd" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waystrarewardstd" key="seq"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="seq" readonly="true"/>
                            <font color=red>系统自动生成</font>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="seq" readonly="true" />
                            <font color=red>系统自动生成</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="seq" disabled="true"/>
                            <font color=red>系统自动生成</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waystrarewardstd" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" />
                            <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';" />
                        	<font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                            <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';" />
                        	<font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waystrarewardstd" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waystrarewardstd" key="rewardtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <!--  <html:text styleClass="form_input_1x" property="rewardtype" /> -->
                            <html:select property="rewardtype">
		                    	<option value=""></option>
		                    	<s:Options definition="$CH_REWARDTYPE" />
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="rewardtype" disabled="true" >
		                    	<option value=""></option>
		                    	<s:Options definition="$CH_REWARDTYPE" />
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waystrarewardstd" key="remark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="remark" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="remark" disabled="true"/>
                            <font color=red>&nbsp;*</font>
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
                           onclick="doSave('/cms/waystrarewardstd.do?CMD=SAVE')"/>
                    
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/waystrarewardstd.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
