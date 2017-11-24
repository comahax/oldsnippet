<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
String ID_1 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL";
%>
<html>
	<head>
		<title><bean:message bundle="zjtylvlrwd" key="titleUpdate" />
		</title>
		<script language="JavaScript">
        function ev_checkval() {
            addfield('citylevel', '<bean:message bundle="zjtylvlrwd" key="citylevel"/>', 'c', false, 3);
            addfield('checkcoef', '<bean:message bundle="zjtylvlrwd" key="checkcoef"/>', 'f', true, 3, 2);
            addfield('fixedrwd', '<bean:message bundle="zjtylvlrwd" key="fixedrwd"/>', 'f', true, 14, 2);
            addfield('prize', '<bean:message bundle="zjtylvlrwd" key="prize"/>', 'f', true, 14, 2);
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
			<html:form action="/cms/zjty/zjtylvlrwd.do?CMD=SAVE"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtylvlrwd" key="titleList" />
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
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtylvlrwd" key="citylevel" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:select property="citylevel" disabled="true">
												<html:option value=""></html:option>
												<s:Options definition="$CH_CITYCOMPTYPE" />
											</html:select>
											<font color=red>*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:select property="citylevel">
												<html:option value=""></html:option>
												<s:Options definition="$CH_CITYCOMPTYPE" />
											</html:select>
											<font color=red>*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:select property="citylevel" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="$CH_CITYCOMPTYPE" />
										</html:select>
										<font color=red>*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtylvlrwd" key="checkcoef" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="checkcoef" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="checkcoef"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtylvlrwd" key="fixedrwd" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input type="text" Class="form_input_1x" name="fixedrwd" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtylvlrwd/ZjtyLvlrwdForm'].fixedrwd}"/>" maxlength="14" />
									</c:when>
									<c:otherwise>
										<input type="text" Class="form_input_1x" name="fixedrwd" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtylvlrwd/ZjtyLvlrwdForm'].fixedrwd}"/>" disabled="true" />	
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtylvlrwd" key="prize" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input type="text" Class="form_input_1x" name="prize" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtylvlrwd/ZjtyLvlrwdForm'].prize}"/>" maxlength="14" />
									</c:when>
									<c:otherwise>
										<input type="text" Class="form_input_1x" name="prize" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtylvlrwd/ZjtyLvlrwdForm'].prize}"/>" disabled="true" />
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
								<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
									<c:choose>
										<c:when test="${edtState}">
											<input type="button" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" name="btnSave"
												onfocus="buttonover(this)" onblur="buttonout(this)"
												value="<bean:message bundle="public" key="button_save"/>"
												class="submit"
												onclick="doSave('/cms/zjty/zjtylvlrwd.do?CMD=SAVE')" />
										</c:when>
										<c:otherwise>
											<input type="button" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" name="btnSave"
												onfocus="buttonover(this)" onblur="buttonout(this)"
												value="<bean:message bundle="public" key="button_save"/>"
												class="submit"
												onclick="doSave('/cms/zjty/zjtylvlrwd.do?CMD=SAVE')"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</s:RewardPurChk>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/zjty/zjtylvlrwd.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
