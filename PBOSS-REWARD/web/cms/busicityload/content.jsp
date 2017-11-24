<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";
%>
<html>
	<head>
		<title><bean:message bundle="busicityload" key="titleUpdate" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="busicityload" key="opnid"/>', 'c', false, '18');
            addfield('cityid', '<bean:message bundle="busicityload" key="cityid"/>', 'c', false, '4');
            addfield('simcode', '<bean:message bundle="busicityload" key="simcode"/>', 'c', false, '12');
            addfield('showorder', '<bean:message bundle="busicityload" key="showorder"/>', 'i', false, '3');
           // addfield('createtime', '<bean:message bundle="busicityload" key="createtime"/>', 't', true, '25');
            addfield('state', '<bean:message bundle="busicityload" key="state"/>', 'i', false, '2');
            addfield('calcflag', '<bean:message bundle="busicityload" key="calcflag"/>', 'i', false, '2');
            addfield('remark', '<bean:message bundle="busicityload" key="remark"/>', 'c', true, '500');

            return checkval(window);
        }
         function selectCity() {
        	var form=document.forms[0];
	   		 if (form.opnid.value.length > 0 ) {
	      	  form.action = contextPath + "/cms/busicityload.do?CMD=SELCITY"; 
	       	  form.submit();
	  		 }else{
	 		  return false; 
	 		}
        }
    </script> 
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/busicityload.do?CMD=SAVE" styleId="formItem"
				method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_sk_opnid" />
				<html:hidden property="_sk_cityid" />
				<html:hidden property="_dnl_createtime" />
				<html:hidden property="_dnm_createtime" />
				<html:hidden property="_ne_state" />
				<html:hidden property="_ne_calcflag" />

				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'SELCITY')}" />
				<c:set var="State" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'NEW' or param.CMD eq 'SELCITY')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="busicityload" key="titleList" />
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
							<td colspan="2">
								<bean:message bundle="busicityload" key="tishi" />
							</td>
						</tr>
						<tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="opnid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${State}">
											<html:text styleClass="form_input_1x" property="opnid"
											readonly="true"></html:text>
										<input type="button" value="..." class="clickButton"
											onclick="showOpnTree2(this, 'opnid','busi','dishi');selectCity();"> 
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="opnid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="cityid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="cityid" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="#CITYIDNUM2NMAME" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="cityid" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="#CITYIDNUM2NMAME" />
										</html:select>
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="simcode" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									 <c:when test="${param.CMD eq 'NEW' or param.CMD eq 'SELCITY'}">
										<html:text styleClass="form_input_1x" property="simcode"
											maxlength="12" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="simcode"
											disabled="true" />
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
								(采集平台使用，若业务没简码，如服务业务类，填一个默认字符“/”)
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right"> 
								<div class="field-require">
									<bean:message bundle="busicityload" key="showorder" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="showorder"
											maxlength="3" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="showorder"
											disabled="true" />
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
								(采集平台使用，指显示业务的次序，不需要次序，请填“-1”)
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="state" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="state">
											<option />
												<s:Options definition="#CH_STATE" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="state" disabled="true">
											<option />
												<s:Options definition="#CH_STATE" />
										</html:select>
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="calcflag" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="calcflag">
											<option />
												<s:Options definition="#CH_CALCFLAG" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="calcflag" disabled="true">
											<option />
												<s:Options definition="#CH_CALCFLAG" />
										</html:select>
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="waytype" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="waytype">
											<option />
												<s:Options definition="$CH_OPNWAYTYPE" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="waytype" disabled="true">
											<option />
												<s:Options definition="$CH_OPNWAYTYPE" />
										</html:select>
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
								(采集平台使用)
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="inuse" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="inuse">
											<option />
												<s:Options definition="$CH_INUSE" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="inuse" disabled="true">
											<option />
												<s:Options definition="$CH_INUSE" />
										</html:select>
									</c:otherwise>
								</c:choose>
								<font color=red>&nbsp;*</font>
								(采集平台使用)
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="infocustomer" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="infocustomer" />
										(采集平台使用，给客户的短信提示，为空时使用默认提示，为“/”时不提示)
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x"  property="infocustomer" 	disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="infoemployee" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="infoemployee"  />
										(采集平台使用，给店员的短信提示，为空时使用默认提示，为“/”时不提示)
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="infoemployee" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busicityload" key="remark" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:textarea property="remark" rows="3" cols="70" />
									</c:when>
									<c:otherwise>
										<html:textarea property="remark" rows="3" cols="70"
											disabled="true" />
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
								<s:PurChk2 controlid="<%=ID_1%>">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/busicityload.do?CMD=SAVE')" />
								</s:PurChk2> 
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/busicityload.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
