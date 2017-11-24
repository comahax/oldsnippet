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
		<title><bean:message bundle="zjtyddtreward" key="titleUpdate" />
		</title>
		<script language="JavaScript">
        function ev_checkval() {
            addfield('ddttype', '<bean:message bundle="zjtyddtreward" key="ddttype"/>', 'i', false, 3);
            addfield('wayid', '<bean:message bundle="zjtyddtreward" key="wayid"/>', 'c', false, 32);
            addfield('rewardmont', '<bean:message bundle="zjtyddtreward" key="rewardmont"/>', 'c', false, 6);
            addfield('amount', '<bean:message bundle="zjtyddtreward" key="amount"/>', 'f', false, 14, 2);
			addfield('remark', '<bean:message bundle="zjtyddtreward" key="remark"/>', 'c', true, 255);
            return checkval(window);
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
			<html:form action="/cms/zjty/zjtyddtreward.do?CMD=SAVE"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="seqid" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtyddtreward" key="titleAdd" />
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
									<bean:message bundle="zjtyddtreward" key="ddttype" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">

								<html:select property="ddttype">
									<html:option value=""></html:option>
									<html:option value="1">全球通扣减</html:option>
								</html:select>
								<font color=red>&nbsp;*</font>


							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyddtreward" key="wayid" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'wayid','','','AG','ZJTY','1');this.value='...';" />
								<font color=red>&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyddtreward" key="rewardmont" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardmont"
									onclick="this.value=selectDateYYYYMMDD();" readonly="true" />
								<font color=red>&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyddtreward" key="amount" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<input type="text" Class="form_input_1x" name="amount" 
									value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/zjty/zjtyddtreward/ZjtyDdtrewardForm'].amount}"/>" maxlength="17" />
								<font color=red>&nbsp;*</font>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyddtreward" key="remark" />
									:
								</div>
							</td>
							<td width="80%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:textarea styleClass="form_textarea_on_2"
											property="remark" />
									</c:when>
									<c:otherwise>
										<html:textarea styleClass="form_textarea_on_2"
											property="remark" disabled="true" />
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
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"
											onclick="doSave('/cms/zjty/zjtyddtreward.do?CMD=SAVE')" />
									</c:when>
									<c:otherwise>
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"
											onclick="doSave('/cms/zjty/zjtyddtreward.do?CMD=SAVE')"
											disabled="true" />
									</c:otherwise>
								</c:choose>
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
									onclick="doReturn('/cms/zjty/zjtyddtreward.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
