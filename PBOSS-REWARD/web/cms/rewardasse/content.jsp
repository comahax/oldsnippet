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
		<title><bean:message bundle="rewardasse" key="titleUpdate" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
        	var form=document.forms[0];
        	var rewardtype = form.all['rewardtype'].value; 
        	var time1=form.all['assemonth'].value;
        	if(time1.length>0){
	        	if(!isDateYYYYMM(time1)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[发放月份]</span>请输入正确的日期格式:YYYYMM</span>');
		        	return false;
	        	}
        	}     	
            addfield('wayid', '<bean:message bundle="rewardasse" key="wayid"/>', 'c', false, '18');
            addfield('assemonth', '<bean:message bundle="rewardasse" key="assemonth"/>', 'c', false, '6');
            addfield('rewardtype', '<bean:message bundle="rewardasse" key="rewardtype"/>', 'i', false, '5');
            if (rewardtype != null && rewardtype != '') {
            	if (rewardtype == '54' || rewardtype == '55') {
            		addfield('assegrade', '<bean:message bundle="rewardasse" key="assegrade"/>', 'f', false, '1','6','','0.000000','1.000000');
	            } else {
	            	addfield('assegrade', '<bean:message bundle="rewardasse" key="assegrade"/>', 'f', false, '1','6','','0.000000','5.000000');
	            }
            } else {
            	addfield('assegrade', '<bean:message bundle="rewardasse" key="assegrade"/>', 'f', false, '1','6','','0.000000','5.000000');
            }
            addfield('memo', '<bean:message bundle="rewardasse" key="memo"/>', 'c', true, '512');
            
            return checkval(window);
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
			<html:form action="/cms/rewardasse.do?CMD=SAVE" styleId="formItem"
				method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_se_wayid" />
				<html:hidden property="_snl_assemonth" />
				<html:hidden property="_snm_assemonth" />
				<html:hidden property="_ne_rewardtype" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="rewardasse" key="titleList" />
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
									<bean:message bundle="rewardasse" key="wayid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="wayid"
												maxlength="18" readonly="true" />
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="wayid"
												onclick="showSelectWay(this,'wayid')" maxlength="18"
												readonly="true" />
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="wayid"
											disabled="true" />
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardasse" key="assemonth" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="assemonth"
												maxlength="6" readonly="true" />
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="assemonth"
												maxlength="6"
												onclick="this.value=selectDateYYYYMM(this.value);" />
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="assemonth"
											disabled="true" />
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardasse" key="rewardtype" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<!--  <s:Code2Name code="${requestScope['/cms/rewardasse/RewardasseForm'].rewardtype}" definition="$CH_REWARDTYPE"/><font color=red>&nbsp;*</font>
                            <html:hidden property="rewardtype"/>
                            -->
											<html:select property="rewardtype" disabled="true">
												<option />
                    							<s:Options definition="#CH_DICTITEM" condition="_sne_dictid:-1;groupid:CH_REWARDTYPE"/>
												<!-- <html:option value=""></html:option>
												<html:option value="0">标准卡固定酬金</html:option>
												<html:option value="1">标准卡积分酬金</html:option>
												<html:option value="2">标准卡专门津贴</html:option>
												<html:option value="3">数据业务基本酬金</html:option>
												<html:option value="4">数据业务奖励酬金</html:option>
												<html:option value="5">服务业务基本酬金</html:option>
												<html:option value="6">服务业务奖励酬金</html:option>
												<html:option value="7">星级酬金</html:option>
												<html:option value="8">项目启动金</html:option>
												<html:option value="51">合作专营酬金</html:option>
												<html:option value="52">销售达标酬金</html:option>
												<html:option value="53">销售超额酬金</html:option>
												<html:option value="30">合作年限奖</html:option> -->
											</html:select>
										</c:if>
										<c:if test="${!updateState}">
											<html:select property="rewardtype">
												<option />
                    							<s:Options definition="#CH_DICTITEM" condition="_sne_dictid:-1;groupid:CH_REWARDTYPE"/>
												<!-- <html:option value=""></html:option>
												<html:option value="0">标准卡固定酬金</html:option>
												<html:option value="1">标准卡积分酬金</html:option>
												<html:option value="2">标准卡专门津贴</html:option>
												<html:option value="3">数据业务基本酬金</html:option>
												<html:option value="4">数据业务奖励酬金</html:option>
												<html:option value="5">服务业务基本酬金</html:option>
												<html:option value="6">服务业务奖励酬金</html:option>
												<html:option value="7">星级酬金</html:option>
												<html:option value="8">项目启动金</html:option>
												<html:option value="51">合作专营酬金</html:option>
												<html:option value="52">销售达标酬金</html:option>
												<html:option value="53">销售超额酬金</html:option>
												<html:option value="30">合作年限奖</html:option> -->
											</html:select>
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<s:Code2Name
											code="${requestScope['/cms/rewardasse/RewardasseForm'].rewardtype}"
											definition="$CH_REWARDTYPE" />
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardasse" key="assegrade" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="assegrade" />
										<font color=red>&nbsp;*</font>
										<bean:message bundle="rewardasse" key="assegraderange" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="assegrade"
											disabled="true" />
										<font color=red>&nbsp;*</font>
										<bean:message bundle="rewardasse" key="assegraderange" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardasse" key="memo" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:textarea styleClass="form_textarea_on_2" property="memo" />
									</c:when>
									<c:otherwise>
										<html:textarea styleClass="form_textarea_on_2" property="memo"
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
								<c:choose>
									<c:when test="${edtState}">
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"
											onclick="doSave('/cms/rewardasse.do?CMD=SAVE')" />
									</c:when>
									<c:otherwise>
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" name="btnSave"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="public" key="button_save"/>"
											class="submit"
											onclick="doSave('/cms/rewardasse.do?CMD=SAVE')"
											disabled="true" />
									</c:otherwise>
								</c:choose>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/cms/rewardasse.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
