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
		<title><bean:message bundle="oprnwayid" key="titleUpdate" />
		</title>
		<script language="JavaScript">
        function ev_checkval() {
            addfield('oldoperid', '<bean:message bundle="oprnwayid" key="oldoperid"/>', 'c', false, 16);
            addfield('newoperid', '<bean:message bundle="oprnwayid" key="newoperid"/>', 'c', false, 32);
            return checkval(window);
        }
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/examine/oprnwayid.do?CMD=Transf" onsubmit="return ev_checkval();" styleId="formItem" method="post">
				<c:set var="form" scope="request"
					value="${requestScope['/cms/examine/oprnwayid/OprnwayidForm']}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="oprnwayid" key="transftitle" />
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
									<bean:message bundle="oprnwayid" key="oldoperid" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<input type="text" class="form_input_1x" name="oldoperid" id="oldoperid">
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="oprnwayid" key="newoperid" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<input type="text" class="form_input_1x" name="newoperid" id="newoperid">
								<font color=red>*</font>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" class="form_table_center">
								<input type="submit" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"/>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/examine/oprnwayid.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
