<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="org.ajaxanywhere.AAUtils"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
			String areacode = request.getParameter("areacode") == null ? ""
			: request.getParameter("areacode").toString();
	User user = (User) request.getSession().getAttribute(
			WebConstant.SESSION_ATTRIBUTE_USER);
	String cityid = user.getCityid();
	boolean isBelong = user.isProvinceUser();
	if (!isBelong) {
		isBelong = areacode.trim().equals(cityid.trim());
	}
%>

<%
	String ID_CONTENT = "3C3C1AAA60AA";
	String ID_SAVE = "3C3C1AAA60AASAVE";
	String ID_PRINT = "3C3C1AAA60AAPRINT";
%>
<html>
	<head>
		<title><bean:message bundle="yxplanpresnt" key="titleUpdate" /></title>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
            addfield('yxplanid', '<bean:message bundle="yxplanpresnt" key="yxplanid"/>', 'i', false, '14');
            addfield('acctid', '<bean:message bundle="yxplanpresnt" key="acctid"/>', 'i', false, '14');
            addfield('presentinterval', '<bean:message bundle="yxplanpresnt" key="presentinterval"/>', 'i', false, '5');
            addfield('presentcycles', '<bean:message bundle="yxplanpresnt" key="presentcycles"/>', 'i', false, '5');
            addfield('presentrate', '<bean:message bundle="yxplanpresnt" key="presentrate"/>', 'd', false, '8','2');
            addfield('eboxunitid', '<bean:message bundle="yxplanpresnt" key="eboxunitid"/>', 'i', false, '14');
            return checkval(window);
        }
        function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		 	function getAcctId() {
			var strUrl;
			var arg = new Array();
			strUrl ="<%=contextPath%>/fee/woff/acct.do?CMD=SELECT";
			var rtn = window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return (rtn == null ? '' : rtn);
		}
		 var retUrl="";
		 function getRetUrl(){
		 	retUrl = "/zifee/yxplanpresnt.do?CMD=LIST&lockOject=true&_ne_yxplanid="+formItem.yxplanid.value;
		 }
		 function getRetAcctID(){
		    var retValue = getAcctId();
		    if(retValue!=null && retValue!='' && retValue!='null' ) document.all("formItem").acctid.value=retValue;
		 }  
		 AjaxAnywhere.prototype.onAfterResponseProcessing = function(){
		  	loadforiframe();
		  }
		  //键盘输入检查:
		function type_num() {
		  if(event.keyCode <48 || event.keyCode >57)event.keyCode=0;
		}
		function onBlur()
		{
			if(!document.all("acctid").value=="")
			{
			ajaxAnywhere.submitByURL('/zifee/yxplanpresnt.do?CMD=SELECT');
			}
		}
    </script>
	</head>
	<body onload="getRetUrl();loadforiframe();">
		<div class="table_container">
			<html:form action="/zifee/yxplanpresnt.do?CMD=SAVE" styleId="formItem" method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="areacode" value="<c:out value='${param.areacode}' />">
				<input type="hidden" name="_ne_yxplanid" value='<c:out value="${param.yxplanid}"/>' >
				<input type="hidden" name="lockOject" value='<c:out value="${param.lockOject}"/>' >
				<c:set var="lockOject" scope="request" value="${!empty param.lockOject}"/>	
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope['cmdState'] eq 'EDIT')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="yxplanpresnt" key="titleList" />
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
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="yxplanpresnt" key="yxplanid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="yxplanid" maxlength="14" readonly="true" />
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="yxplanid" maxlength="14" readonly="true" />
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="yxplanid" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="yxplanpresnt" key="acctid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="acctid" maxlength="14" readonly="true" />&nbsp;<font
												color=red>*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="acctid" onkeypress="type_num()"
												onblur="onBlur()" maxlength="14" />
											<input type="button" value="..." onclick="getRetAcctID()"
												onblur="onBlur()" />&nbsp;<font color=red>*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="acctid" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="yxplanpresnt" key="presentinterval" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<aa:zone name="zonePresentcycles">
									<c:choose>
										<c:when test="${not empty requestScope.DATA}">
											 <input class="form_input_1x" name="presentinterval" maxlength="5" readonly="true"
												value="<c:out value='${requestScope.DATA }'/>" />&nbsp;<font color=red>*</font>
										</c:when>
										<c:when test="${not empty requestScope.VALUE}">
											 <input class="form_input_1x" name="presentinterval" maxlength="5"
												value="<c:out value='${requestScope.VALUE }'/>"  >&nbsp;<font color=red>*</font>
										</c:when>
										<c:when test="${empty requestScope.VALUE and edtState and (param.CMD != 'EDIT')}">
											<html:text styleClass="form_input_1x" property="presentinterval" maxlength="5" />&nbsp;<font color=red>*</font><br>
											(填0表示生效月起间隔0月开始返还,即生效当月马上返还,填1表示生效月起间隔1个月开始返还,即生效月的下月开始返还,依次递延)
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="presentinterval" readonly="true" />&nbsp;<font color=red>*</font>
										</c:otherwise>
									</c:choose>
								</aa:zone>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="yxplanpresnt" key="presentcycles" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="presentcycles" maxlength="5" readonly="true" />&nbsp;<font
												color=red>*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="presentcycles" maxlength="5" />&nbsp;<font color=red>*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="presentcycles" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="yxplanpresnt" key="presentrate" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="presentrate" maxlength="10" />&nbsp;<font color=red>*</font>（如果赠送比例为1：0.75，则填0.75即可）
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="presentrate" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="yxplanpresnt" key="eboxunitid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<s:zoom definition="#EBOXUNIT" property="eboxunitid" readonly="false" styleClass="form_input_1x" /><font color=red>*</font>
									</c:when>
									<c:otherwise>
										<input type="text" name="eboxunitid"
											value="<c:out value='${requestScope["/zifee/yxplanpresnt/YxplanpresntForm"].eboxunitid}' /> <s:Code2Name code='${requestScope["/zifee/yxplanpresnt/YxplanpresntForm"].eboxunitid}' definition='#EBOXUNIT'/>"
											disabled="true" class="form_input_1x">&nbsp;
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
								<%
								if (isBelong) {
								%>
								<s:PurChk controlid="<%=ID_SAVE%>">
									<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
										class="submit" onclick="doSave('/zifee/yxplanpresnt.do?CMD=SAVE')" />
								</s:PurChk>
								<%
								}
								%>
								<s:PurChk controlid="<%=ID_PRINT%>">
									<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnPrint"
										onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_print"/>"
										class="print" onclick="doPrint()">
								</s:PurChk>
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn(retUrl)">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
