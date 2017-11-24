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
            addfield('operid', '<bean:message bundle="oprnwayid" key="operid"/>', 'c', false, 16);
            addfield('wayid', '<bean:message bundle="oprnwayid" key="wayid"/>', 'c', false, 32);

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
			<html:form action="/cms/examine/oprnwayid.do?CMD=SAVE"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_se_operid" />
				<html:hidden property="_se_wayid" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<c:set var="form" scope="request"
					value="${requestScope['/cms/examine/oprnwayid/OprnwayidForm']}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="oprnwayid" key="titleList" />
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
									<bean:message bundle="oprnwayid" key="operid" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="operid"/>
												<font color=red>*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="operid" />
											<font color=red>*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="operid"
											disabled="true" />
											<font color=red>*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="oprnwayid" key="wayid" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="wayid"
												readonly="true" /><input type="button" value="..." class="clickbutton"
												onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';" />
											<font color=red>*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="wayid"
												readonly="true" /><input type="button" value="..." class="clickbutton"
												onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';" />
												<font color=red>*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="wayid"
											disabled="true" /><input type="button" value="..." class="clickbutton"
											onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';"
											disabled="true" />
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
							<td width="100%" class="form_table_center">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<input type="button" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" name="btnSave"
												onfocus="buttonover(this)" onblur="buttonout(this)"
												value="<bean:message bundle="public" key="button_save"/>"
												class="submit"
												onclick="doSave('/cms/examine/oprnwayid.do?CMD=SAVE')" />
										</c:if>
										<c:if test="${!updateState}">
											<input type="button" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" name="btnSave"
												onfocus="buttonover(this)" onblur="buttonout(this)"
												value="<bean:message bundle="public" key="button_save"/>"
												class="submit"
												onclick="doSave('/cms/examine/oprnwayid.do?CMD=SAVE')" />
										</c:if>
									</c:when>
									<c:otherwise>
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"
											onclick="doSave('/cms/examine/oprnwayid.do?CMD=SAVE')"
											disabled="true" />
									</c:otherwise>
								</c:choose>
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
