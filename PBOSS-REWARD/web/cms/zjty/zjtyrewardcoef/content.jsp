
<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_1 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL";
	String ID_2 = "CH_ZJTY_REWARD||CH_ZJTY_PROVINCIAL||CH_ZJTY_CIVIC";
%>
<html>
	<head>
		<title><bean:message bundle="zjtyrewardcoef" key="titleUpdate" />
		</title>
		<script language="JavaScript">
        function ev_checkval() { 
            switch(parseInt(formItem.coefid.value)){
            	case 0: 
            		if( parseFloat(formItem.providecoef.value)>1.2 || parseFloat(formItem.providecoef.value)<0){	
            		alert('管理考核系数区间为0－1.2');
            		return false;
            		}
            		break;
            	case 1:
            		if( parseFloat(formItem.providecoef.value)>1.3 || parseFloat(formItem.providecoef.value)<1){	
            		alert('综合排名系数区间为1－1.3');
            		return false;
            		}
            		break;
            	case 2:
            		if( parseFloat(formItem.providecoef.value)==0 || parseFloat(formItem.providecoef.value)==1){	
            		}else{
            			alert('否决系数区间为0或1');
            			return false;
            		}
            		break;
            	case 3:
            		if( parseFloat(formItem.providecoef.value)>1 || parseFloat(formItem.providecoef.value)<0.5){	
            		alert('竞标系数区间为0.5-1');
            		return false;
            		}
            		break;				
            	default:
            	break;
            	return true;
            }
            addfield('coefid', '<bean:message bundle="zjtyrewardcoef" key="coefid"/>', 'c', false, '3');
            addfield('wayid', '<bean:message bundle="zjtyrewardcoef" key="wayid"/>', 'c', false, '32');
            addfield('providecoef', '<bean:message bundle="zjtyrewardcoef" key="providecoef"/>', 'f', false, 1, 2);
            addfield('effectiblemonth', '<bean:message bundle="zjtyrewardcoef" key="effectiblemonth"/>', 'c', false, '6');
            addfield('result', '<bean:message bundle="zjtyrewardcoef" key="result"/>', 'c', true, '255');

			var form=document.forms[0];
        	var time1=form.all['effectiblemonth'].value;
        	
        	if(time1.length>0){
	        	if(!isDateYYYYMM(time1)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[作用月]</span>请输入正确的日期格式:YYYYMM</span>');
		        	return false;
        		}
        	}
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
			var reg = /^(\d{1,4})(\d{1,2})/;
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
			<html:form action="/cms/zjty/zjtyrewardcoef.do?CMD=SAVE"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="cityid" />

				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<c:set var="isRight" scope="request"
					value="${!empty param.ISRIGHT and (param.ISRIGHT eq 'true')}" />
				<c:set var="isPass" scope="request"
					value="${!empty param.ISPASS and (param.ISPASS eq '1')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtyrewardcoef" key="titleList" />
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
									<bean:message bundle="zjtyrewardcoef" key="coefid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:select property="coefid" disabled="true">
												<html:option value=""></html:option>
												<s:Options definition="#CH_ZJTY_EXAMINECOEF2" />
											</html:select>
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<c:if test="${isRight}">
												<html:select property="coefid">
													<html:option value=""></html:option>

													<s:Options definition="#CH_ZJTY_EXAMINECOEF2" />
												</html:select>
												<font color=red>&nbsp;*</font>
											</c:if>
											<c:if test="${!isRight}">
												<html:select property="coefid">
													<html:option value=""></html:option>
													<s:Options definition="#CH_ZJTY_EXAMINECOEF2" />
												</html:select>
												<font color=red>&nbsp;*</font>
											</c:if>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:select property="coefid" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="#CH_ZJTY_EXAMINECOEF2" />
										</html:select>
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyrewardcoef" key="wayid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when
										test="${(param.CMD eq 'NEW'||(requestScope['cmdState'] eq 'EDIT'))&&!(param.CMD eq 'EDIT')}">
										<html:text styleClass="form_input_1x" property="wayid"
											/><input type="button" value="..." class="clickbutton"
											onclick="showSelectWay3(this,'wayid','','','AG','ZJTY','1');this.value='...';" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="wayid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyrewardcoef" key="effectiblemonth" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x"
												property="effectiblemonth" maxlength="6" disabled="true"
												readonly="true" />
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x"
												property="effectiblemonth" maxlength="6"
												onclick="effectiblemonth.value=selectDateYYYYMMDD()"
												readonly="true" />
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x"
											property="effectiblemonth" disabled="true" />
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyrewardcoef" key="providecoef" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="providecoef"
											maxlength="6" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="providecoef"
											disabled="true" />
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="zjtyrewardcoef" key="result" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:textarea styleClass="form_textarea_on_2"
											property="result" />
									</c:when>
									<c:otherwise>
										<html:textarea styleClass="form_textarea_on_2"
											property="result" disabled="true" />
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
								<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">
									<c:choose>
										<c:when test="${edtState}">
											<input type="button" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" name="btnSave"
												onfocus="buttonover(this)" onblur="buttonout(this)"
												value="<bean:message bundle="public" key="button_save"/>"
												class="submit"
												onclick="doSave('/cms/zjty/zjtyrewardcoef.do?CMD=SAVE')" />
										</c:when>
										<c:otherwise>
											<input type="button" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" name="btnSave"
												onfocus="buttonover(this)" onblur="buttonout(this)"
												value="<bean:message bundle="public" key="button_save"/>"
												class="submit"
												onclick="doSave('/cms/zjty/zjtyrewardcoef.do?CMD=SAVE')"
												disabled="true" />
										</c:otherwise>
									</c:choose>
								</s:RewardPurChk>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/zjty/zjtyrewardcoef.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
