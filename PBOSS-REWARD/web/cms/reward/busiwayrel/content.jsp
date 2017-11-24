<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="busiwayrel" key="titleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
			 addfield('opnid', '<bean:message bundle="busiwayrel" key="opnid"/>', 'c', false, '18');
			 addfield('wayid', '<bean:message bundle="busiwayrel" key="wayid"/>', 'c', false, '18');
            return checkval(window);
        }
      
    </script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/reward/busiwayrel.do?CMD=SAVE"
				styleId="formItem" method="post">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and param.CMD eq 'NEW'}" />
				<div class="table_div">
					<table class="top_table" border=0>
						<tr>
							<td>
								<bean:message bundle="busiwayrel" key="titleList" />
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
							<td align=left colspan=2>
								<bean:message bundle="public" key="msgRequired" />
							</td>
						</tr>
						<tr>
							<td align=left colspan=2>
								<bean:message bundle="busiwayrel" key="intro1" />
								<br>
								<bean:message bundle="busiwayrel" key="intro2" />
							</td>
						</tr>
						<tr>
							<td width="26%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busiwayrel" key="opnid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">

								<html:text styleClass="form_input_1x" property="opnid">
								</html:text>
								<font color=red>*</font>
								<input type="button" value="..." class="clickButton"
									onclick="showOpnTree2(this, 'opnid','busi', 'dishi');">
							</td>
						</tr>
						<tr>
							<td width="26%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busiwayrel" key="nwayid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">

								<html:text styleClass="form_input_1x" property="wayid"
								/><font color=red>&nbsp;*</font>
								<input type="button" value="..." class="clickbutton"
								onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" class="form_table_center">
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_save"/>"
									class="submit"
									onclick="doSave('/cms/reward/busiwayrel.do?CMD=SAVE')" />
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnPrint"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_print"/>"
									class="print" onclick="doPrint()">
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/reward/busiwayrel.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</html:form>
	</body>
</html>
