<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="rulerel" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('ruleitemid', '<bean:message bundle="rulerel" key="ruleitemid"/>', 'c', false, '18');
            addfield('ruleid', '<bean:message bundle="rulerel" key="ruleid"/>', 'c', false, '18');
            addfield('cityid', '<bean:message bundle="rulerel" key="cityid"/>', 'c', false, '4');
            addfield('state', '<bean:message bundle="rulerel" key="state"/>', 'i', false, '2');
            //addfield('isdefault', '<bean:message bundle="rulerel" key="isdefault"/>', 'i', true, '2');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/rulerel.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_ruleitemid"/>
    <html:hidden property="_se_ruleid"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_ne_state"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="formvalue" scope="request" value="${requestScope['/cms/reward/rulerel/RulerelForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rulerel" key="titleList"/>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulerel" key="ruleitemid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    	<html:hidden property="ruleitemid"/>
                    	<html:hidden property="ruleid"/>
                    	<html:hidden property="cityid"/>
                    	<c:out value="${formvalue.ruleitemid}"/>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulerel" key="ruleitemname"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
					<s:Code2Name code="${formvalue.ruleitemid}" definition="#CHADTRULEITEM"/>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulerel" key="state"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                	<html:select property="state">
                    	<s:Options definition="#CH_ADT_RULEREL_VALID"/>
                    </html:select> <FONT color=red>*</FONT>
                </td>
            </tr>
            
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
            	  <s:RewardPurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/rulerel.do?CMD=SAVE')"/>
                  </s:RewardPurChk>
                 <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                 </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/rulerel.do?CMD=LIST&_se_ruleid=' + '<c:out value='${formvalue.ruleid}'/>'+'&_se_cityid='+'<c:out value="${formvalue.cityid}"/>')"/>
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
