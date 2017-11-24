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
    <title><bean:message bundle="chpdauditdispute" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('isaccepted', '<bean:message bundle="chpdauditdispute" key="isaccepted"/>', 'f', false, '1');
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/provagent/chpdauditdispute.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_cityid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/ChPdAuditdisputeForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdauditdispute" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="disputeid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="disputeid" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="rewardid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="rewardid" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="cityid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="cityid" disabled="true">
                    	<option></option>
						<s:Options definition="#REGIONNAME"/>
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="auditrole"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="auditrole" disabled="true">
                    	<option></option>
						<s:Options definition="$PD_AUDITROLE"/>
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="content"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="content" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="auditeename"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="auditeename" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="telephone"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="telephone" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="isaccepted"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="isaccepted">
                    	<option></option>
						<s:Options definition="#PD_YESORNO"/>
					</html:select>
					<font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="isdealed"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="isdealed" disabled="true">
                    	<option></option>
						<s:Options definition="#PD_YESORNO"/>
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="dealtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="dealtype" disabled="true">
                    	<option></option>
						<s:Options definition="$PD_DEALTYPE"/>
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="suppleseq"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="suppleseq" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="memo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="memo" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chpdauditdispute" key="incomstime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <input class="form_input_1x" name="incomstime" value="<fmt:formatDate value="${form.incomstime}" pattern="yyyy-MM-dd HH:mm:ss"/>" disabled/>
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
                           onclick="doSave('/cms/provagent/chpdauditdispute.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/provagent/chpdauditdispute.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
