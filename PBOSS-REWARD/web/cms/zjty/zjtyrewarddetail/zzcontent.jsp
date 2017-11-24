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
		<title><bean:message bundle="zjtyrewarddetail"
				key="titleUpdate" />
		</title>
		<script language="JavaScript">
        function ev_checkval() {
        	addfield('wayid', '<bean:message bundle="zjtyrewarddetail" key="wayid"/>', 'c', false, 18);
        	addfield('paysum', '<bean:message bundle="zjtyrewarddetail" key="paysum"/>', 'f', false, 12, 2);
			addfield('rewardtype', '<bean:message bundle="zjtyrewarddetail" key="rewardtype"/>', 'i', false, 3);
        	addfield('rewardmont', '<bean:message bundle="zjtyrewarddetail" key="rewardmont"/>', 'c', false, 6);
            return checkval(window);
        }
        function resetBtn(){
        	formItem.rwdupper.disabled = false;
        	document.getElementById("btnSave").disabled = false; 
        }
        function selectDateYYYYMMDD() {
			var arg = new Object();
			strTime = "";
			valTime = event.srcElement.value;
			if (isDateYYYYMMDD(valTime) == false) {
			strTime = "";
			} else {
			strTime = valTime.substring(0, 4) + "-" + valTime.substring(4, 6) + "-01";
			}
			arg.str_datetime = strTime;
			arg.time_comp = false;
			var rtn = window.showModalDialog("../../js/pub/calendar.html", arg, "dialogWidth=210px;dialogHeight=240px;status:no;scroll=no;");
			if (rtn != null) {
			rtn = rtn.split("-")[0] + rtn.split("-")[1];
			}
			return (rtn == null ? valTime : rtn);
		}
		
		function isDateYYYYMM(str) {
			var reg = /^(\d{1,4})(\d{1,2})$/;
			var r = str.match(reg);
			if (r == null) {
				return false;
			} else {
				var d = new Date(r[1], r[2] - 1);
				if (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2]) {
					return true;
				} else {
					return false;
				}
			}
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/zjty/zjtyrewarddetail.do?CMD=Zzsave"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="rewardlistid"/>
				<html:hidden property="rewardtype" value="89" />
				
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'Zzedit' or param.CMD eq 'Zznew')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'Zzedit')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtyrewarddetail" key="zztitleListEdit" />
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
									<bean:message bundle="zjtyrewarddetail" key="opnid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<s:myzoom definition="#ZJTY_OPERATION" property="opnid" condition="opnid:6401*,;isbusi:1;" styleClass="form_input_1x" />
									<font color=red>&nbsp;*</font>
								</c:when>
								<c:otherwise>
									<s:myzoom definition="#ZJTY_OPERATION" property="opnid" condition="opnid:6401*,;isbusi:1;" styleClass="form_input_1x" disabled="true"/>
									<font color=red>&nbsp;*</font>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyrewarddetail" key="wayid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="wayid"/><input type="button" value="..." class="clickbutton"
											onclick="showSelectWay3(this,'wayid','','','AG','ZJTY','1');this.value='...';" />
									<font color=red>&nbsp;*</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
									<font color=red>&nbsp;*</font>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyrewarddetail" key="acctype" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
								<html:select property="acctype">
									<html:option value=""></html:option>
									<s:Options definition="$CH_ACCTYPE" />
								</html:select>
								<font color=red>&nbsp;*</font>
								</c:when>
								<c:otherwise>
									<html:select property="acctype" disabled="true">
									<html:option value=""></html:option>
									<s:Options definition="$CH_ACCTYPE" />
								</html:select>
								<font color=red>&nbsp;*</font>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyrewarddetail" key="rewardmont" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="rewardmont" onclick="this.value=selectDateYYYYMMDD();" readonly="true" />
								<font color=red>&nbsp;*</font>&nbsp;格式为:YYYYMM
								</c:when>
								<c:otherwise>
								<html:text styleClass="form_input_1x" property="rewardmont" onclick="this.value=selectDateYYYYMMDD();" readonly="true" disabled="true"/>
								<font color=red>&nbsp;*</font>&nbsp;格式为:YYYYMM
								</c:otherwise>
							</c:choose>
							</td>
							
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyrewarddetail" key="paysum" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
								<input type="text" Class="form_input_1x" name="paysum" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm'].paysum}"/>" maxlength="15" />
								<font color=red>&nbsp;*</font>
								</c:when>
								<c:otherwise>
								<input type="text" Class="form_input_1x" name="paysum" value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtyrewarddetail/ZjtyRewarddetailForm'].paysum}"/>" maxlength="15" disabled="true"/>
								<font color=red>&nbsp;*</font>
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
								<c:choose>
										<c:when test="${edtState}">
										<input id="btnSave" type="button"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										name="btnSave" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/zjty/zjtyrewarddetail.do?CMD=Zzsave')" />
										</c:when>
										<c:otherwise>
										<input id="btnSave" type="button"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										name="btnSave" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/zjty/zjtyrewarddetail.do?CMD=Zzsave')" disabled="true"/>
										</c:otherwise>
									</c:choose>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/zjty/zjtyrewarddetail.do?CMD=Zzlist')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
