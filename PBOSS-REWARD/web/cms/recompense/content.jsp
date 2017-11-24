<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B3C1AAA" />
</jsp:include>
<%
	String ID_1 = "2B3C1AAABT1";
%>
<html:html>
<head>
	<title><bean:message bundle="recompense" key="title" /></title>
	<script language="JavaScript">
        function ev_checkval() {
            addfield('target', '<bean:message bundle="recompense" key="target" />', 'l', false, 12);
            addfield('quotiety', '<bean:message bundle="recompense" key="quotiety" />', 'd', false, 14,2);
            addfield('balanceterm', '<bean:message bundle="recompense" key="balanceterm" />', 'c', false, 128);
            addfield('standard', '<bean:message bundle="recompense" key="standard" />', 'd', false, 14,2);
            addfield('comtype', '<bean:message bundle="recompense" key="comtype" />', 'c', false, 4);
            addfield('bchlevel', '<bean:message bundle="recompense" key="bchlevel" />', 'c', false, 4);  
            addfield('integral', '<bean:message bundle="recompense" key="integral" />', 'd', false, 14,2);
            addfield('businesstype', '<bean:message bundle="recompense" key="businesstype" />', 'c', false, 32);
            addfield('prodid', '<bean:message bundle="recompense" key="prodid" />', 'i', false, 8);
            addfield('prosalecode', '<bean:message bundle="recompense" key="prosalecode" />', 'c', false, 15);
            addfield('salseprodid', '<bean:message bundle="recompense" key="salseprodid" />', 'i', false, 8);
            addfield('inyxplanid', '<bean:message bundle="recompense" key="inyxplanid" />', 'l', false, 10);    
            addfield('intime', '<bean:message bundle="recompense" key="intime" />', 'dt', false, 7);
            addfield('custstate', '<bean:message bundle="recompense" key="custstate" />', 'i', false, 3);
            addfield('chargetype', '<bean:message bundle="recompense" key="chargetype" />', 'i', false, 3);
            addfield('moment', '<bean:message bundle="recompense" key="moment" />', 'i', false, 3);
            addfield('fitstation', '<bean:message bundle="recompense" key="fitstation" />', 'i', false,3);
            addfield('fitopr', '<bean:message bundle="recompense" key="fitopr" />', 'c', false, 15);
            addfield('calculatemode', '<bean:message bundle="recompense" key="calculatemode" />', 'c', false, 100);  
            return checkval(window);          
        }
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
		<html:form action="/cms/recompense.do?CMD=SAVE" styleId="formItem" method="post">
			<html:hidden property="cmdState" />
			<html:hidden property="recid" />

			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />

			<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />


			<div class="table_div">
				<table class="top_table" border=0>
					<tr>

						<td>
							<bean:message bundle="recompense" key="title" />
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
						<td colspan=4>
							<bean:message bundle="public" key="msgRequired" />
						</td>
					</tr>


					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="target" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="target" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="target" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="quotiety" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="quotiety" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="quotiety" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="balanceterm" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="balanceterm" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="balanceterm" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="standard" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="standard" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="standard" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="comtype" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="comtype" readonly="true" onclick="this.value=showSelectWayType()"></html:text>
								</c:when>
								<c:otherwise>
								 	<html:text styleClass="form_input_1x" property="comtype" disabled="true"></html:text>
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="bchlevel" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="bchlevel">
										<html:option value=""></html:option>
										<s:Options definition="$CH_BCHLEVEL" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="bchlevel" disabled="true">
										<html:option value=""></html:option>
										<s:Options definition="$CH_BCHLEVEL" />
									</html:select>
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="integral" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="integral" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="integral" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="businesstype" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="businesstype" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="businesstype" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="prodid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="prodid" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="prodid" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="prosalecode" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="prosalecode" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="prosalecode" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="salseprodid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="salseprodid" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="salseprodid" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="inyxplanid" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="inyxplanid" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="inyxplanid" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="intime" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="intime" onclick="this.value=selectDatetime()" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="intime" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="custstate" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="custstate" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="custstate" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="chargetype" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="chargetype">
										<html:option value=""></html:option>
										<s:Options definition="$CH_CHARGETYPE" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="chargetype" disabled="true">
										<html:option value=""></html:option>
										<s:Options definition="$CH_CHARGETYPE" />
									</html:select>
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="moment" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="moment" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="moment" disabled="true" />
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="fitstation" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="fitstation">
										<html:option value=""></html:option>
										<s:Options definition="#CH_PARENTPOST" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="fitstation" disabled="true">
										<html:option value=""></html:option>
										<s:Options definition="#CH_PARENTPOST" />
									</html:select>
								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
						<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="fitopr" />
								:
							</div>
						</td>
						<td class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="fitopr" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="fitopr" disabled="true" />

								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<tr>
					<td class="form_table_right">
							<div class="field-require">
								<bean:message bundle="recompense" key="calculatemode" />
								:
							</div>
						</td>
						<td class="form_table_left"colspan=3>
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="calculatemode" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="calculatemode" disabled="true" />

								</c:otherwise>
							</c:choose>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
				</table>
			</div>



			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<s:PurChk controlid="<%=ID_1%>">
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_submit"/>" class="submit"
										onclick="doSave('/cms/recompense.do?CMD=SAVE')" />
							</s:PurChk>
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>" class="close"
									onclick="doReturn('/cms/recompense.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>


		</html:form>
	</div>
</body>
</html:html>
