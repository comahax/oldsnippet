<%@ page language="java" contentType="text/html;charset=GBK"%>
<%//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头%>
<%@ include file="/inc/contenthead.inc"%>

<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A3CBB70" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_EDIT";
%>

<html:html>
<head>
	<title>
		<bean:message bundle="saleway" key="titleUpdate" />
	</title>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script language="JavaScript">
        <%//录入数据的校检%>
        function ev_checkval() {
            //way
            addfield('wayid', '<bean:message bundle="saleway" key="wayid"/>', 'c', false , 18);
            
            //account
            addfield('bankname', '<bean:message bundle="saleway" key="bankname"/>', 'c', false, 128);
            addfield('acctno', '<bean:message bundle="saleway" key="acctno"/>', 'c', false, 50);
            addfield('acctname', '<bean:message bundle="saleway" key="acctname"/>', 'c', false, 128);
            addfield('acctfid', '<bean:message bundle="saleway" key="acctfid"/>', 'c', false, 32);
            
            return checkval(window);
        }
        
        function bodyOnload(){
        	if(window.loadforiframe){
        		loadforiframe();
        	}
        }
        
        function doReturnList(cmdReturn) {
    		formItem.action =contextPath + cmdReturn;
    		formItem.target = "_parent";
    		formItem.submit();
		}
    </script>
</head>
<body onload="bodyOnload()">
	<div class="table_container">
		<html:form action="/cms/saleway/account.do?CMD=SAVE" styleId="formItem" method="post">
			<html:hidden property="cmdState" />
			<%//查询页面的参数，有了这些就能在增加，编辑时返回编辑前的正确页面%>
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'EDITNEW')}" />
			<c:set var="item" scope="request" value="${requestScope['/cms/wayaccount/WayaccountForm']}"/>
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="saleway" key="titleList" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table width="100%" class="error_text">
					<s:Msg />
				</table>
			</div>
			<div>
				<table class="form_table">
					<tr>
						<td align=left colspan="4">
							&nbsp;&nbsp;
							<bean:message bundle="public" key="msgRequired" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table class="form_table">
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="wayid" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="wayid" maxlength="18" readonly="true"/>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="wayid" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="wayname" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<s:Code2Name code="${item.wayid}" definition="#WAY"/>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="acctno" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="acctno" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="acctno" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="acctname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="acctname" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="acctname" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="bankname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="bankname" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="bankname" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="acctfid" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="acctfid" />
									<font color=red>
										&nbsp;*
									</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="acctfid" disabled="true" />
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
							<s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>" class="submit"
									onclick="doSave('/cms/saleway/account.do?CMD=SAVE')" />
							</s:PurChk2>
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>" class="close"
								onclick="doReturnList('/cms/saleway/saleway.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>

