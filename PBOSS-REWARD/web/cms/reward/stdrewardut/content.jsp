<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant,java.util.*"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL"; //省级酬金管理令牌
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC"; //市级酬金管理令牌
	String NEW = (String) request
			.getAttribute(WebConstant.COMMAND_STRING_NEW);
%>
<html>
	<head>
		<title><bean:message bundle="stdrewardut" key="titleCard" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
		<script language="JavaScript">
	function ev_checkval() {
		
	       if(date_compare("startdate_51","stopdate_51","<bean:message bundle='stdrewardut' key='date_compare51'/>")) 
           		return false;
           	
           if(date_compare("startdate_52","stopdate_52","<bean:message bundle='stdrewardut' key='date_compare52'/>")) 
           		return false;
           
           if(date_compare("startdate_53","stopdate_53","<bean:message bundle='stdrewardut' key='date_compare53'/>")) 
           		return false;
           		
			var selectcity = eval("document.formItem").all("selectcity");
			var falg = false;
			for(var i = 0 ; i<selectcity.length ; i++){
				if(selectcity[i].checked == true)
				falg = true;
			}
			if(falg == true){
			}else{
				alert("'本标准适用地市'不能为空");
				return false;
			}
		addfield('rewardname_51', '<bean:message bundle="stdrewardut" key="rewardname51"/>', 'c', false, '80');
		addfield('rewardname_52', '<bean:message bundle="stdrewardut" key="rewardname52"/>', 'c', false, '80');
		addfield('rewardname_53', '<bean:message bundle="stdrewardut" key="rewardname53"/>', 'c', false, '80');
		addfield('rewardstd_51', '<bean:message bundle="stdrewardut" key="rewardstd51"/>', 'f', false, '16','2');
		addfield('rewardstd_52', '<bean:message bundle="stdrewardut" key="rewardstd52"/>', 'f', false, '16','2');
		addfield('rewardstd_53', '<bean:message bundle="stdrewardut" key="rewardstd53"/>', 'f', false, '16','2');
		addfield('startdate_51', '<bean:message bundle="stdrewardut" key="startdate51"/>', 't', false, '10');
		addfield('startdate_52', '<bean:message bundle="stdrewardut" key="startdate52"/>', 't', false, '10');
		addfield('startdate_53', '<bean:message bundle="stdrewardut" key="startdate53"/>', 't', false, '10');
		addfield('stopdate_51', '<bean:message bundle="stdrewardut" key="stopdate51"/>', 't', false, '10');
		addfield('stopdate_52', '<bean:message bundle="stdrewardut" key="stopdate52"/>', 't', false, '10');
		addfield('stopdate_53', '<bean:message bundle="stdrewardut" key="stopdate53"/>', 't', false, '10');						
		addfield('intvmonth_51', '<bean:message bundle="stdrewardut" key="intvmonth51"/>', 'i', false, '5');
		addfield('intvmonth_52', '<bean:message bundle="stdrewardut" key="intvmonth52"/>', 'i', false, '5');
		addfield('intvmonth_53', '<bean:message bundle="stdrewardut" key="intvmonth53"/>', 'i', false, '5');				
		addfield('integralnum_52', '<bean:message bundle="stdrewardut" key="integralnum"/>', 'i', false, '8');
		addfield('unitprice_53', '<bean:message bundle="stdrewardut" key="unitprice"/>', 'f', false, '6','2');		
		return checkval(window);
	}

	function doLoad(){
		if ('<%= NEW %>' == 'TRUE') {
			if (typeof formItem.btnSave == 'object') {
				formItem.btnSave.disabled = "";
			}
			//if (typeof formItem.selectcity == 'object') {
				formItem.selectcity.disabled = "";
			//}
		}
	}

		function checkCity(th) {
			var sis = eval("document.formItem").all("selectcity");
			if(th.value =='999' && th.checked == true){
				 for (var i = 0; i < sis.length; i++) {
	 				sis[i].checked = true;
	 			 }
			}
			if(th.value =='999' && th.checked == false){
		 		for (var i = 0; i < sis.length; i++) {
	      			sis[i].checked = false;
	      		}
 			} 
		if(th.value !='999' && th.checked == false){
	 		for (var i = 0; i < sis.length; i++) {
		 		if(sis[i].checked == true && sis[i].value =='999')
		      		sis[i].checked = false;
	     	}
 		}
 		var flag = 0;
 		var index = 00;
 		if(th.value !='999' && th.checked == true){
 		for (var i = 0; i < sis.length; i++) {
		if(sis[i].value =='999'){
 		index = i;
 		}
 		if(sis[i].value !='999' && sis[i].checked == true){
 	 	flag++;
 		}
 	}
  	if( flag == sis.length-1){
	sis[index].checked =true;
	flag = false;
 	}else{
 	sis[index].checked =false;
 	}
 	}
	}
</script>
	</head>
	<body onload="loadforiframe();doLoad();">
		<div class="table_container">
			<html:form action="/cms/reward/stdrewardut.do?CMD=SAVE"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="wayid" value="DIS999" />
				<html:hidden property="rewardtype_51" value="51" />
				<html:hidden property="rewardtype_52" value="52" />
				<html:hidden property="rewardtype_53" value="53" />


				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<c:set var="form" scope="request"
					value="${requestScope['/cms/reward/stdrewardut/StdrewardutForm']}" />
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="stdrewardut" key="titleList" />
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

				<!-- 51  专营补贴酬金 -->
				<div class="table_div" id="51">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardut"
											key="reward_51" /> </font>
											<font color=red>*</font>
									<bean:message bundle="stdrewardut" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardname" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_51"
									maxlength="80" />
									<font color=red>*</font>
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardtype" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
								<s:Code2Name
									code="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].rewardtype_51}"
									definition="$CH_REWARDTYPE" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="startdate" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
										<html:text styleClass="form_input_1x" property="startdate_51"
											onclick="this.value=selectDate();" readonly="true"></html:text>
										<font color=red>*</font>
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="stopdate" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
										<html:text styleClass="form_input_1x" property="stopdate_51"
											onclick="this.value=selectDate();" readonly="true"></html:text>
										<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardstd" />
									:
								</div>
							</td>
							<td width="35%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_51"
									maxlength="16" />
									<font color=red>*</font>
								<br>
								<bean:message bundle="stdrewardut" key="notice" />
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="intvmonth" />
									:
								</div>
							</td>
							<td width="35%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_51"
									maxlength="2" />
									<font color=red>*</font>
								<br>
								<bean:message bundle="stdrewardut" key="invnotice" />
							</td>
						</tr>
					</table>
				</div>

				<!-- 52 销售达标酬金 -->
				<div class="table_div" id="52">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardut"
											key="reward_52" /></font>
									<bean:message bundle="stdrewardut" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardname" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_52"
									maxlength="80" />
									<font color=red>*</font>
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardtype" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
								<s:Code2Name
									code="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].rewardtype_52}"
									definition="$CH_REWARDTYPE" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="startdate" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
										<html:text styleClass="form_input_1x" property="startdate_52"
											onclick="this.value=selectDate();" readonly="true"></html:text>
										<font color=red>*</font>
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="stopdate" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
										<html:text styleClass="form_input_1x" property="stopdate_52"
											onclick="this.value=selectDate();" readonly="true"></html:text>
										<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardstd" />
									:
								</div>
							</td>
							<td width="35%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_52"
									maxlength="16" />
									<font color=red>*</font>
								<br>
								<bean:message bundle="stdrewardut" key="notice" />
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="intvmonth" />
									:
								</div>
							</td>
							<td width="35%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_52"
									maxlength="2" />
									<font color=red>*</font>
								<br>
								<bean:message bundle="stdrewardut" key="invnotice" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="integralnum" />
									:
								</div>
							</td>
							<td width="35%" class="form_table_left" colspan="3">
								<html:text styleClass="form_input_1x" property="integralnum_52"
									maxlength="8" />
									<font color=red>*</font>
							</td>
						</tr>
					</table>
				</div>

				<!-- 53 销售超额酬金 -->
				<div class="table_div" id="53">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardut"
											key="reward_53" /> </font>
									<bean:message bundle="stdrewardut" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardname" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardname_53"
									maxlength="80" />
									<font color=red>*</font>
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardtype" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
								<s:Code2Name
									code="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].rewardtype_53}"
									definition="$CH_REWARDTYPE" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="startdate" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
										<html:text styleClass="form_input_1x" property="startdate_53"
											onclick="this.value=selectDate();" readonly="true"></html:text>
										<font color=red>*</font>
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="stopdate" />
									:
								</div>
							</td>
							<td width="35%" align="left" class="form_table_left">
										<html:text styleClass="form_input_1x" property="stopdate_53"
											onclick="this.value=selectDate();" readonly="true"></html:text>
										<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardstd53" />
									:
								</div>
							</td>
							<td width="35%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstd_53"
									maxlength="16" />
									<font color=red>*</font>
								<br>
								<bean:message bundle="stdrewardut" key="notice" />
							</td>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="intvmonth" />
									:
								</div>
							</td>
							<td width="35%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonth_53"
									maxlength="2" />
									<font color=red>*</font>
								<br>
								<bean:message bundle="stdrewardut" key="invnotice" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="unitprice" />
									:
								</div>
							</td>
							<td width="35%" class="form_table_left" colspan="3">
								<html:text styleClass="form_input_1x" property="unitprice_53"
									maxlength="6" />
									<font color=red>*</font>
							</td>
						</tr>
					</table>
				</div>
				<!-- 地市 -->
				<div class="table_div" id="region">
					<table class="form_table">
						<tr>
							<td align="right" width="15%">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="CITY" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<table class="form_table" border=0>
												<tr>
													<c:forEach var="item"
														items="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].citys}"
														varStatus="vars">
														<td>
															<%if(NEW.equals("TRUE")){ %>
															<html:multibox property="selectcity"
																onclick="checkCity(this);">
																<c:out
																	value="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].cityvalues[vars.index]}" />
															</html:multibox>
															<%}else{ %>
															<html:multibox property="selectcity"
																onclick="checkCity(this);" disabled="true">
																<c:out
																	value="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].cityvalues[vars.index]}" />
															</html:multibox>
															<%} %>
															<c:choose>
																<c:when test="${item eq '广东'}">
														全省
														</c:when>
																<c:otherwise>
																	<c:out value="${item}" />
																</c:otherwise>
															</c:choose>
														</td>
														<c:if test="${(vars.index+1)%5==0}">
												</tr>
												<tr>
													</c:if>
													</c:forEach>
													<td>
														<font color="red">*</font>
													</td>
												</tr>
											</table>
										</c:if>
										<c:if test="${!updateState}">
											<table class="form_table" border=0>
												<tr>
													<c:forEach var="item"
														items="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].citys}"
														varStatus="vars">
														<td>
															<html:multibox property="selectcity"
																onclick="checkCity(this);">
																<c:out
																	value="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].cityvalues[vars.index]}" />
															</html:multibox>
															<c:choose>
																<c:when test="${item eq '广东'}">
														全省
														</c:when>
																<c:otherwise>
																	<c:out value="${item}" />
																</c:otherwise>
															</c:choose>
														</td>
														<c:if test="${(vars.index+1)%5==0}">
												</tr>
												<tr>
													</c:if>
													</c:forEach>
													<td>
														<font color="red">*</font>
													</td>
												</tr>
											</table>
										</c:if>
									</c:when>
									<c:otherwise>
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item"
													items="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].citys}"
													varStatus="vars">
													<td>
														<%if(NEW.equals("TRUE")){ %>
															<html:multibox property="selectcity"
																onclick="checkCity(this);">
																<c:out
																	value="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].cityvalues[vars.index]}" />
															</html:multibox>
															<%}else{ %>
															<html:multibox property="selectcity"
																onclick="checkCity(this);" disabled="true">
																<c:out
																	value="${requestScope['/cms/reward/stdrewardut/StdrewardutForm'].cityvalues[vars.index]}" />
															</html:multibox>
															<%} %>
														<c:choose>
															<c:when test="${item eq '广东'}">
														全省
														</c:when>
															<c:otherwise>
																<c:out value="${item}" />
															</c:otherwise>
														</c:choose>
													</td>
													<c:if test="${(vars.index+1)%5==0}">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
												<td>
													<font color="red">*</font>
												</td>
											</tr>
										</table>
				</c:otherwise>
				</c:choose>
				</td>
				</tr>
				</table>
				</div>

				<!-- button list, NEW and SAVE and DELETE -->
				<table class="table_button_list">
					<tr>
						<td>
						<s:RewardPurChk controlid="<%=ID_1%>">
							<c:choose>
								<c:when test="${edtState}">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="save"
										onclick="doSave('/cms/reward/stdrewardut.do?CMD=SAVE');" />
								</c:when>
								<c:otherwise>
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="save"
										onclick="doSave('/cms/reward/stdrewardut.do?CMD=SAVE')"
										disabled="true" />
								</c:otherwise>
							</c:choose>
							</s:RewardPurChk>
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnDeleteOne"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="back"
								onclick="doReturn('/cms/reward/stdrewardut.do?CMD=LIST')" />
						</td>
					</tr>
				</table>
			</html:form>
		</div>
	</body>
</html>
