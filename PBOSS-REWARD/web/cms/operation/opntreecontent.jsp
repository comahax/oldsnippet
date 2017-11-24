<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%
String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
	<head>
		<title><bean:message bundle="operation" key="title" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
        	addfield('name', '<bean:message bundle="operation" key="name"/>', 'c', false, '50');
			addfield('parentid', '<bean:message bundle="operation" key="parentid"/>', 'c', false, '50');
			addfield('opnid', '<bean:message bundle="operation" key="opnid"/>', 'c', false, '50');
			var approveid=formItem.approveid.value;
			//alert(approveid);
			if(approveid.length > 0 && approveid.length != 28){
				//alert("1");
				errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="operation" key="approveid"/>]如果有输入则必须为28位数字</span>');
    			return false;
			}
            var result = checkval(window);
            return result;
        }
        function dochangeopnid(){
	        //showOpnTree(this, 'parentid', 'opn');
	        ajaxAnywhere.submitByURL("/cms/operation.do?CMD=Getopnid"); 
        }
        function operation(){
        	var opnid=formItem.opnid.value;
        	window.parent.location.href="<%=contextPath%>/cms/reward/operation/frame.jsp?PK="+opnid+"&_se_opnid="+opnid;
			//formItem.action="<%=contextPath%>/cms/reward/operation/frame.jsp?PK="+opnid+"&_se_opnid="+opnid;
			//formItem.submit();
		}
    </script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/operation.do?CMD=queryallsubopn"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_sk_name" />
				<html:hidden property="_se_opnid" />
				<input type="hidden" name="isbusi" value="0" />
				<input type="hidden" name=state value="1" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'Edittopntree' or param.CMD eq 'Newtopntree')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'Edittopntree')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								全省统一业务分类树管理
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
							<td align=left colspan="4">
								&nbsp;&nbsp;
								<bean:message bundle="public" key="msgRequired" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="operation" key="parentid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState and not updateState}">
										<html:text styleClass="form_input_1x" property="parentid"
											readonly="true"></html:text>
										<!-- <input type="button" value="..." class="clickButton"
											onclick="dochangeopnid()"> -->
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="parentid"
											readonly="true"></html:text>
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="operation" key="opnid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
							<aa:zone name="getopnid">
							<div><html:text styleClass="form_input_1x" property="opnid"
											maxlength="18" readonly="true"/>
										<font color=red>&nbsp;*</font>
							</div>
							</aa:zone>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="operation" key="name" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="name"
											maxlength="50" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="name"
											readonly="true" />
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<c:if test="${opnlevel eq '5'}">
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="operation" key="approveid" />
										:
									</div>
								</td>
								<c:choose>
									<c:when test="${edtState and not updateState}">
										<td width="75%" align="left" class="form_table_left">
											<html:text styleClass="form_input_1x" property="approveid" maxlength="28" />
										</td>
									</c:when>
									<c:otherwise>
										<td width="75%" align="left" class="form_table_left">
											<html:text styleClass="form_input_1x" property="approveid" maxlength="28" readonly="true" />
										</td>
									</c:otherwise>
								</c:choose>
								
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="operation" key="busibelong" />
										:
									</div>
								</td>
								<td width="75%" align="left" class="form_table_left">
									<html:select property="busibelong">
										<html:option value=""></html:option>
										<s:Options definition="$CH_CBBUSIBELONG" />
									</html:select>
								</td>										
							</tr>
						</c:if>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<c:if test="${opnlevel eq '5'}">
									<c:choose>
									<c:when test="${!(param.CMD eq 'Newtopntree')}">
										<input type="button" value="业务配置" 
										class="button_4" onclick="operation();" onmouseover="buttonover(this)"
										onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"/>
									</c:when>
									<c:otherwise>
										<input type="button" value="业务配置" 
										class="button_4" onclick="operation();" onmouseover="buttonover(this)"
										onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)" disabled="disabled"/>
										</c:otherwise>
									</c:choose>
								</c:if>
								<c:choose>
								<c:when test="${edtState}">
								<s:RewardPurChk controlid="<%=ID_1%>">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/operation.do?CMD=Saveopntree')" />
								</s:RewardPurChk>
								</c:when>
								<c:otherwise>
										<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/operation.do?CMD=Saveopntree')" disabled="disabled"/>
									</c:otherwise>
								</c:choose>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/operation.do?CMD=Listopntree1')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
								<c:choose>
									<c:when test="${edtState and not updateState}">
										<script type="text/javascript">
       										 ajaxAnywhere.submitByURL("/cms/operation.do?CMD=Getopnid"); 
										</script>
									</c:when>
								</c:choose>
	
</html>
