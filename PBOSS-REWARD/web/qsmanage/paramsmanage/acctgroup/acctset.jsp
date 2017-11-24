<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D6F1A3CAA" />
</jsp:include>
<%
	String ID_1 = "4D6F1A3CAABT1";
	String ID_2 = "4D6F1A3CAABT2";
	String ID_3 = "4D6F1A3CAABT3";
%>
<html:html>
<head>
	<title><bean:message bundle="acctset" key="theUpdate" /></title>
	<script language="JavaScript">
        function ev_checkval() {
            addfield('acctsetid', '<bean:message bundle="acctset" key="acctsetid"/>', 'l', false, 14);
            addfield('acctid', '<bean:message bundle="acctset" key="acctid"/>', 'l', false, 14);
            return checkval(window);
        }
        
        function doNext(url){
      		var isnew = document.formItem.cmdState.value ;
      		if(isnew == 'NEW'){
      			if(confirm("本菜单尚未进行参数设置，是否放弃进入下一步？")){
      				formItem.action = contextPath + url;
      				formItem.submit();
      			}
      		}else{
      			formItem.action = contextPath + url;
      			formItem.submit();
      		}
      	}
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/qsmanage/paramsmanage/acctgroup.do?CMD=ACCTSET"
			styleId="formItem" method="post" onsubmit="return ev_checkval();">
			<html:hidden property="cmdState" />

			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="curmenu" />
			<html:hidden property="menulist" />
			<html:hidden property="matchid" />
			<html:hidden property="chgreason" />
			<html:hidden property="accttype" />
			<c:set var="edtState" scope="request"
				value="${!empty CMD and CMD eq 'ACCTSET'}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="acctset" key="custMsg" />
						</td>
				</table>
			</div>
			<div class="table_div">
				<table class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>

			<div class="table_div">
				<table class="form_table">
					<tr>
						<td align=left colspan=6>
							<bean:message bundle="fee" key="redStarExplain" />
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="acctset" key="acctsetid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<s:zoom definition="#WOFF-ACCT" property="acctsetid"
								styleClass="form_input_1x" condition="acctlevel:0" />
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="acctset" key="acctid" />
								:
							</div>
						</td>
						<td class="form_table_left">
						<html:text styleClass="form_input_1x" property="acctid" maxlength="14" />
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td width="100%" class="form_table_center">

							<input type="button" name="btnNew" class="add"
								onmouseover="buttonover(this);" onmouseout="buttonout(this);"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_new"/>"
								onClick="doSave('/qsmanage/paramsmanage/acctgroup.do?CMD=ACCTSETMORE')">
							<c:choose>
								<c:when test="${edtState}">
									<s:PurChk controlid="<%=ID_1%>">
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"
											onclick="doSave('/qsmanage/paramsmanage/acctgroup.do?CMD=ACCTSET')" />
									</s:PurChk>
								</c:when>
								<c:otherwise>
									<s:PurChk controlid="<%=ID_1%>">
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit" disabled="true"
											onclick="doSave('/qsmanage/paramsmanage/acctgroup.do?CMD=ACCTSET')" />
									</s:PurChk>
								</c:otherwise>
							</c:choose>


										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnReturn"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_nextstep"/>"
											class="button_3"
											onclick="doNext('/qsmanage/paramsmanage/acctgroup.do?CMD=NEXT')">

						</td>
					</tr>
				</table>
			</div>

		</html:form>
	</div>
</body>
</html:html>
