<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D6F1A6FAA" />
</jsp:include>
<%
	String ID_1 = "4D6F1A6FAABT1";
	String ID_2 = "4D6F1A6FAABT2";
%>
<html:html>
<head>
	<title><bean:message bundle="WoffRule" key="titleUpdate" />
	</title>
	<script language="JavaScript">
        function ev_checkval() {
            addfield('acctid', '<bean:message bundle="WoffRule" key="AcctID"/>', 'c', false, 20);
            addfield('eboxunitid', '<bean:message bundle="WoffRule" key="EBoxUnitID"/>', 'c', false, 20);
            addfield('type', '<bean:message bundle="WoffRule" key="Type"/>', 'c', false, 20);   
            addfield('pri', '<bean:message bundle="WoffRule" key="Pri"/>', 'c', false, 20);
            addfield('memo', '<bean:message bundle="WoffRule" key="Memo"/>', 'c', false, 20);
            addfield('strBegintime', '<bean:message bundle="fee" key="begintime"/>', 'dt', false, 20);    
            addfield('strEndtime', '<bean:message bundle="fee" key="endtime"/>', 'dt', false, 20);  
            if(date_compare("strBegintime","strEndtime",'<bean:message bundle="WoffRule" key="BeginTime" />'+'<bean:message bundle="fee" key="compare_gt" />'+'<bean:message bundle="WoffRule" key="EndTime" />')) return;
            return checkval(window);
        }
      	
      	function doComplete(){
      		var isnew = document.formItem.cmdState.value ;
      		if(isnew == 'NEW'){
      			if(confirm("本菜单尚未进行参数设置，是否结束设置？")){
      				formItem.action = contextPath + "/qsmanage/paramsmanage/eboxgroup/list.jsp";
      				formItem.submit();
      			}
      		}else{
      			formItem.action = contextPath + "/qsmanage/paramsmanage/eboxgroup/list.jsp";
      			formItem.submit();
      		}
      	}
    </script>
</head>
<body>
	<div class="table_container">
		<html:form action="/qsmanage/paramsmanage/eboxgroup.do?CMD=WOFFRULE"
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

			<c:set var="edtState" scope="request"
				value="${!empty CMD and CMD eq 'WOFFRULE'}" />

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="WoffRule" key="title" />
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
					<TBODY>
						<TR>
							<TD class="form_table_left" colSpan=2>
								<bean:message bundle="fee" key="redStarExplain" />
							</TD>
						</TR>

						<TR>

							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="AcctID" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<s:zoom definition="#WOFF-ACCT" property="acctid"
									styleClass="form_input_1x" />
								<bean:message bundle="fee" key="redStar" />
							</td>
						</tr>
						<TR>

							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="EBoxUnitID" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="eboxunitid"
								maxlength="14" />
								<bean:message bundle="fee" key="redStar" />
							</td>
						</tr>

						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="Type" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<html:select property="type">
									<s:Options definition="#WOFF_RUTLTYPE" />
								</html:select>
								<bean:message bundle="fee" key="redStar" />
							</td>
						</tr>
						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="BeginTime" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="strBegintime"
									onclick="this.value=selectDatetime()" />
								<bean:message bundle="fee" key="redStar" />
							</td>
						</tr>

						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="EndTime" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="strEndtime"
									onclick="this.value=selectDatetime()" />
								<bean:message bundle="fee" key="redStar" />
							</td>
						</tr>
						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="Pri" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="pri" />
								<bean:message bundle="fee" key="redStar" />
							</td>
						</tr>
						<TR>
							<td class="form_table_right">
								<div class="field-require">
									<bean:message bundle="WoffRule" key="Memo" />
									:
								</div>
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="memo" />
								<bean:message bundle="fee" key="redStar" />
							</td>
						</tr>
					</TBODY>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" name="btnNew" class="add"
								onmouseover="buttonover(this);" onmouseout="buttonout(this);"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_new"/>"
								onClick="doSave('/qsmanage/paramsmanage/eboxgroup.do?CMD=WOFFRULEMORE')">
							<c:choose>
								<c:when test="${edtState}">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/qsmanage/paramsmanage/eboxgroup.do?CMD=WOFFRULE')" />
								</c:when>
								<c:otherwise>
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit" disabled="true"
										onclick="doSave('/qsmanage/paramsmanage/eboxgroup.do?CMD=WOFFRULE')" />
								</c:otherwise>
							</c:choose>


									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnReturn"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="完成设置" class="button_4" onclick="doComplete()">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
