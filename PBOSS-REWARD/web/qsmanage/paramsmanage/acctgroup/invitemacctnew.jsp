<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D4D3C2BAA" />
</jsp:include>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_1 = "4D4D3C2BAABT1";
	String ID_2 = "4D4D3C2BAABT2";
	String ID_3 = "4D4D3C2BAABT3";
%>
<html:html>
<head>
	<title>新<bean:message bundle="invitemacct" key="title" />
	</title>
	<script language="JavaScript">
           function ev_checkval() {
            addfield('feeid', '<bean:message bundle="invitemacct" key="feeid"/>', 'l', false, 14);
            addfield('invitemid', '<bean:message bundle="invitemacct" key="invitemid"/>', 'l', false, 10);
            addfield('feekind', '<bean:message bundle="invitemacct" key="feekind"/>', 'i', false, 3);
              addfield('type', '<bean:message bundle="invitemacct" key="type"/>', 'i', false, 3);
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
		<html:form
			action="/qsmanage/paramsmanage/acctgroup.do?CMD=INVITEMACCTNEW"
			styleId="formItem" method="post">

			<html:hidden property="cmdState" />
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="curmenu" />
			<html:hidden property="menulist" />
			<html:hidden property="matchid" />
			<html:hidden property="chgreason" />
			<html:hidden property="acctid" />
			<html:hidden property="accttype" />

			<c:set var="edtState" scope="request"
				value="${!empty CMD and CMD eq 'INVITEMACCTNEW'}" />


			<div class="table_div">

				<table class="top_table">
					<tr>

						<td>
							新
							<bean:message bundle="invitemacct" key="title" />
						</td>

					</tr>
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
						<td colspan="6">

							<bean:message bundle="public" key="msgRequired" />
						</td>
					</tr>

					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="invitemacct" key="invitemid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<s:zoom definition="#PRINT-INVITEMNAMENEW" property="invitemid"
								styleClass="form_input_1x" />
							<font color=red>&nbsp;*</font>
						</td>
					</tr>

					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="invitemacct" key="feeid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="acctid" maxlength="14" />

							<font color=red>&nbsp;*</font>
						</td>
					</tr>


					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="invitemacct" key="type" />
								:
							</div>
						</td>
						<td class="form_table_left">

							<html:select property="type">
								<html:option value=""></html:option>
								<s:Options definition="$IB_INVITEMTYPE" nameOnly="false" />

							</html:select>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>

				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>

							<c:choose>
								<c:when test="${edtState}">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/qsmanage/paramsmanage/acctgroup.do?CMD=INVITEMACCTNEW')" />
								</c:when>
								<c:otherwise>
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit" disabled="true"
										onclick="doSave('/qsmanage/paramsmanage/acctgroup.do?CMD=INVITEMACCTNEW')" />
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
