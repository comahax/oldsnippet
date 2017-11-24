<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
	<head>
		<title><bean:message bundle="rule" key="titleUpdate" /></title>
		<script language="JavaScript">
        function ev_checkval() {
        	if (!checkRuleid(formItem.ruleid.value)) {
            	return false;
            }
            if(date_compare('startdate', 'enddate' , '<bean:message bundle="rule" key="datacompare"/>')) {
            	return false;
            }
            addfield('ruleid', '<bean:message bundle="rule" key="ruleid"/>', 'c', false, '3');
            addfield('rulename', '<bean:message bundle="rule" key="rulename"/>', 'c', false, '60');
            addfield('startdate', '<bean:message bundle="rule" key="startdate"/>', 't', false, '10');
            addfield('enddate', '<bean:message bundle="rule" key="enddate"/>', 't', false, '10');
            addfield('remark', '<bean:message bundle="rule" key="remark"/>', 'c', true, '200');
            
            return checkval(window);
        }
        
        function checkRuleid(id) {
        	if ('' == id) {
        		alert('<bean:message bundle="rule" key="ruleidremind"/>');
        		return false;
        	}
        	if (id.length != 3) {
        		alert('<bean:message bundle="rule" key="ruleidremind"/>');
        		return false;
        	}
        	
        	var letter = id.substring(0,1);
        	var number = id.substring(2,3);
        	if((letter.charCodeAt(0) < 65) || (letter.charCodeAt(0) > 90)) {
        		alert('<bean:message bundle="rule" key="ruleidremind"/>');
        		return false;
        	}
        	if (isNaN(number)) {
        		alert('<bean:message bundle="rule" key="ruleidremind"/>');
        		return false;
        	}
        	
        	return true;
        }
    </script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/reward/rule.do?CMD=SAVE" styleId="formItem"
				method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope['cmdState'] eq 'EDIT')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="rule" key="titleList" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>

				<div class="table_div">
					<table class="form_table">
						<tr>
							<td colspan="2"><bean:message bundle="rule" key="remind" /></td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rule" key="ruleid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="ruleid"
												maxlength="3" readonly="true" />
											<font color=red>&nbsp;*</font>
											<bean:message bundle="rule" key="ruleidformat" />
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="ruleid"
												maxlength="3" />
											<font color=red>&nbsp;*</font>
											<bean:message bundle="rule" key="ruleidformat" />
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="ruleid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rule" key="rulename" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="rulename"
											maxlength="60" /><font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="rulename"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rule" key="startdate" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
											<input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${requestScope['/cms/reward/rule/RuleForm'].startdate}"
											pattern="yyyy-MM-dd" />" maxlength="10"
											onclick="this.value=selectDate();" /><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <input class="form_input_1x" type="text" name="startdate"
											value="<fmt:formatDate value="${requestScope['/cms/reward/rule/RuleForm'].startdate}"
											pattern="yyyy-MM-dd" />"
											disabled = true/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rule" key="enddate"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input class="form_input_1x" type="text" name="enddate"
											value="<fmt:formatDate value="${requestScope['/cms/reward/rule/RuleForm'].enddate}"
											pattern="yyyy-MM-dd" />" maxlength="10"
											onclick="this.value=selectDate();" /><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <input class="form_input_1x" type="text" name="enddate"
											value="<fmt:formatDate value="${requestScope['/cms/reward/rule/RuleForm'].enddate}"
											pattern="yyyy-MM-dd" />" disabled=true />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right">
                	<div class="field-require"><bean:message bundle="rule" key="remark"/>:</div>
                </td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea property="remark" styleClass="form_textarea_on_4" />
                        </c:when>
                        <c:otherwise>
                        	<html:textarea property="remark" styleClass="form_textarea_on_4" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
            	  <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/rule.do?CMD=SAVE')"/>
                </s:RewardPurChk>
                  <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/rule.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
