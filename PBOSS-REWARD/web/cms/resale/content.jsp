<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
String ID_1 = "CH_PW_RESALE_SAVE";
%>
<html>
	<head>
		<script language="JavaScript">
        function ev_checkval() { 
        	var form=document.forms[0];
        	//if( form.mobile.value.length != 11){
			//errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="resale" key="mobile"/>]</span><bean:message bundle="resale" key="mobile"/>必须为11位数字字符串</span>');  
        //	return false;
  			//} 
        	var regNum=/^[0-9]+$/; //整数正则表达式
  			if( !regNum.test(form.mobile.value)){
			errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="resale" key="mobile"/>]</span><bean:message bundle="resale" key="mobile"/>必须为数字字符串</span>');  
        	return false;
  			} 
            addfield('wayid', '<bean:message bundle="resale" key="wayid"/>', 'c', false, '18');
            addfield('mobile', '<bean:message bundle="resale" key="mobile"/>', 'c', false, '12');
            addfield('countyid', '<bean:message bundle="resale" key="countyid"/>', 'c', false, '14');
            addfield('brand', '<bean:message bundle="resale" key="brand"/>', 'i', false, '22');
            addfield('daytime', '<bean:message bundle="resale" key="daytime"/>', 't', false, '25');
            return checkval(window);
        }
        
        function del() {
				formItem.wayvl.value= ""; 
			} 
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/resale.do?CMD=SAVE" styleId="formItem"
				method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_se_wayid" />
				<html:hidden property="_se_mobile" />
				<html:hidden property="_dnl_daytime" />
				<html:hidden property="itemid" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="resale" key="titleList" />
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
							<td colspan="4">
								<bean:message bundle="resale" key="tishi" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="resale" key="wayid" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="wayid" readonly="true"></html:text>
								<input type="button" value="..." class="clickbutton" name="wayvl"
									onclick="showSelectWay(this,'wayid');del();" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="wayid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="resale" key="mobile" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="mobile" maxlength="14" disabled="true" />
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="mobile" maxlength="14" />
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="mobile"
											disabled="true" />
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="resale" key="countyid" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="countyid"
											readonly="true" />
										<input type="button" name="button2" value="..."
											onclick="showOrgTree(this,'countyid','Cntycom');">
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="countyid"
											disabled="true" />
									</c:otherwise>
								</c:choose> 
								<font color=red>&nbsp;*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="resale" key="brand" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
											<html:select property="brand">
											<html:option value=""></html:option>
											<s:Options definition="#BUSI_BRAND"></s:Options>	
										</html:select>	
									</c:when>
									<c:otherwise>
										<html:select property="brand" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="#BUSI_BRAND"></s:Options>	
										</html:select>
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
							</td> 
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="resale" key="daytime" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input class="form_input_1x" type="text" name="daytime"
											value="<fmt:formatDate value="${requestScope['/cms/resale/ResaleForm'].daytime}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" readonly="true"/>
									</c:when>
									<c:otherwise>
										<input class="form_input_1x" type="text" name="daytime"
											value="<fmt:formatDate value="${requestScope['/cms/resale/ResaleForm'].daytime}"
											pattern="yyyy-MM-dd" />"
											onclick="this.value=selectDate();" readonly="true" />
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
							</td><td></td><td></td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:PurChk2 controlid="<%=ID_1%>">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit" onclick="doSave('/cms/resale.do?CMD=SAVE')" />
								</s:PurChk2>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/cms/resale.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
