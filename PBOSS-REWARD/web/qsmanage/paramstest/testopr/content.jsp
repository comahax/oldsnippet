<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.common.base.db.SessionFactoryRouter"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="1A2B1AC0AA" />
</jsp:include>
<%
	String ID_1 = "1A2B1AC0AABT1";
	String ID_2 = "1A2B1AC0AABT2";
%>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="testopr" key="titleEdit" /></title>
	<script language="JavaScript">
        function ev_checkval() {
        	addfield('oprcode', '<bean:message bundle="testopr" key="Oprcode"/>', 'c', false, 32);
            addfield('state', '<bean:message bundle="testopr" key="state"/>', 'i', false, 2);
            
          	return checkval(window);
        }
        
        function ignoreSpaces(string) {
			var temp = "";
			string = '' + string;
			splitstring = string.split(" "); 
			for(i = 0; i < splitstring.length; i++)
			temp += splitstring[i];
			return temp;
		} 
    </script>
    
</head>
<body onload="loadforiframe()">
	<div class="table_container">
		<html:form action="/qsmanage/paramstest/testopr.do?CMD=SAVE" styleId="formItem" method="post">
			<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
			<c:set var="newState" scope="request" value="${!empty param.CMD and (param.CMD eq 'NEW')}" />
			<html:hidden property="cmdState" />
			<div class="table_div">
				<table class="top_table" border=0>
					<tr>
						<td>
							<bean:message bundle="testopr" key="titleEdit" />
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
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="testopr" key="Oprcode" />
								:
							</td>
							<td width="30%" align="left" class="form_table_left" >
							<c:choose>
								<c:when test="${newState}">
								
									<s:zoom definition="#OPERATORNAME" property="oprcode"
										condition="orgid:${USER.wayid};_sne_operid:${USER.opercode};status:1"
										nameOnly="false" styleClass="form_input_1x" />
									<bean:message bundle="fee" key="redStar" />
									
								</c:when>
								<c:otherwise>
								
									<s:zoom definition="#OPERATORNAME" property="oprcode"
										condition="orgid:${USER.wayid};_sne_operid:${USER.opercode};status:1"
										nameOnly="false" styleClass="form_input_1x" disabled="true"/>
									<bean:message bundle="fee" key="redStar" />
									
								</c:otherwise>
							</c:choose>
						</td>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="testopr" key="state" />
								:
							</td>
							<td class="form_table_left">
								<c:choose>
									<c:when test="${newState || edtState}">
										<html:select property="state">
											<html:option value=""></html:option>
											<s:Options definition="$QSCS_TESTOPRNOSTATE" />
										</html:select>
										<font color=red>*</font>
									</c:when>
									<c:otherwise>
										<html:select property="state" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="$QSCS_TESTOPRNOSTATE" />
										</html:select>
										<font color=red>*</font>
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
						<s:PurChk controlid="<%=ID_1%>">
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave"
								onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_save"/>"
								class="submit" onclick="doSave('/qsmanage/paramstest/testopr.do?CMD=SAVE')" />
						</s:PurChk>
						<s:PurChk controlid="<%=ID_2%>">
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
								class="close" onclick="doReturn('/qsmanage/paramstest/testopr.do?CMD=LIST')">
						</s:PurChk>
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
