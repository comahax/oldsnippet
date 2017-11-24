<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%
	String ID_1 = "rttp_2B || CH_PW_REWARD || CH_PW_REWARD_PROVINCIAL";
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
	<head>
		<title><bean:message bundle="operation" key="titleUpdate" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
          
            if(date_compare("startdate","enddate","<bean:message bundle='operation' key='date_compare'/>")) 
           		return false;        
           		
			var selectcity = eval("document.formItem").all("selectcity");
			var selectstar = eval("document.formItem").all("selectstar");
			var selectexesys = eval("document.formItem").all("selectexesys");
			
			var falg = false;
			for(var i = 0 ; i<selectcity.length ; i++){
			if(selectcity[i].checked == true)
			falg = true;
			}
			if(falg == true){
			falg = false;
			for(var i = 0 ; i<selectexesys.length ; i++){
			if(selectexesys[i].checked == true)
			falg = true;
			}
			}else{
			alert("'业务加载地市'不能为空");
			return false;
			}
			
			if(falg == true){
			falg = false;
			for(var i = 0 ; i<selectstar.length ; i++){
			if(selectstar[i].checked == true)
			falg = true;
			}
			}else{
			alert("'业务执行系统'不能为空");
			return false;
			}
			if(falg == false){
			alert("'业务加载渠道星级'不能为空");
			return false;
			}			
			
			addfield('name', '<bean:message bundle="operation" key="name"/>', 'c', false, '50');
            addfield('parentid', '<bean:message bundle="operation" key="parentid"/>', 'c', false, '18');
            addfield('remark', '<bean:message bundle="operation" key="remark"/>', 'c', true, '255');
            addfield('startdate', '<bean:message bundle="operation" key="startdate"/>', 't', false, '25');
            addfield('enddate', '<bean:message bundle="operation" key="enddate"/>', 't', false, '25');
            addfield('busibelong', '<bean:message bundle="operation" key="busibelong"/>', 'c', false, '32');
            addfield('selectexesys', '<bean:message bundle="operation" key="EXESYS" />', 'c', false, '32'); 
            return checkval(window);
            
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
	 function doReturnIndex(){
           var str = self.parent.location.toString();
           if(str.indexOf("frame.jsp")==-1){
               doReturn('/cms/operation.do?CMD=LIST');
           }else{
               self.parent.location='<%=contextPath%>/cms/operation.do?CMD=LIST';
           }
        }

    </script>
	</head>
	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/operation.do?CMD=SAVE" styleId="formItem"
				method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_se_opnid" />
				<html:hidden property="_sk_name" />
				<html:hidden property="_dnl_startdate" />
				<html:hidden property="_dnm_startdate" />
				<html:hidden property="_dnl_enddate" />
				<html:hidden property="_dnm_enddate" />
				<html:hidden property="_se_busibelong" />

				<html:hidden property="opnlevel" />
				<html:hidden property="state" />

				<html:hidden property="isbusi" />

				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<c:set var="form" scope="request"
					value="${requestScope['/cms/operation/OperationForm']}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="operation" key="titleList" />
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
									<bean:message bundle="operation" key="parentid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState and not updateState}">
										<html:text styleClass="form_input_1x" property="parentid"
											readonly="true"></html:text>
										<input type="button" value="..." class="clickButton"
											onclick="showOpnTree2(this, 'parentid','nobusi' )">
										<font color="red">*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="parentid"
											disabled="true"></html:text>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<c:if test="${!edtState or updateState}">
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="operation" key="opnid" />
										:
									</div>
								</td>
								<td width="75%" align="left" class="form_table_left">
									<html:text styleClass="form_input_1x" property="opnid"
										disabled="true" />
								</td>
							</tr>
						</c:if>


						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="operation" key="name" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="name"
											maxlength="50" />
										<font color="red">*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="name"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="operation" key="startdate" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input type='text' class="form_input_1x" name="startdate"
											value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.startdate}"/>"
											onclick="this.value=selectDate()" readonly="true" />
										<font color=red>*</font>
									</c:when>
									<c:otherwise>
										<input type='text' class="form_input_1x" name="startdate"
											value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.startdate }"/>"
											disabled='true' />

									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="operation" key="enddate" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input type='text' class="form_input_1x" name="enddate"
											value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.enddate}"/>"
											onclick="this.value=selectDate()" readonly="true" />
										<font color=red>*</font>
									</c:when>
									<c:otherwise>
										<input type='text' class="form_input_1x" name="enddate"
											value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.enddate }"/>"
											disabled='true' />

									</c:otherwise>
								</c:choose>


							</td>
						</tr>

						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="operation" key="busibelong" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="busibelong">
											<html:option value=""></html:option>
											<s:Options definition="$CH_CBBUSIBELONG" />
										</html:select>
										<font color="red">*</font>
									</c:when>
									<c:otherwise>
										<html:select property="busibelong" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="$CH_CBBUSIBELONG" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="operation" key="EXESYS" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${edtState}">
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${form.exesyss}"
													varStatus="vars">
													<td>
														<html:multibox property="selectexesys">
															<c:out value="${form.exesysvalues[vars.index]}" />
														</html:multibox>

														<c:out value="${item}" />
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

									</c:when>
									<c:otherwise>
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${form.exesyss}"
													varStatus="vars">
													<td>
														<html:multibox property="selectexesys" disabled='true'>
															<c:out value="${form.exesysvalues[vars.index]}" />
														</html:multibox>
														<c:out value="${item}" />
													</td>
													<c:if test="${(vars.index+1)%5==0}">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>



						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="operation" key="CITY" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${edtState}">
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${form.citys}" varStatus="vars">
													<td>
														<html:multibox property="selectcity"
															onclick="checkCity(this);">
															<c:out value="${form.cityvalues[vars.index]}" />
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

									</c:when>
									<c:otherwise>
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${form.citys}" varStatus="vars">
													<td>
														<html:multibox property="selectcity" disabled='true'>
															<c:out value="${form.cityvalues[vars.index]}" />
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
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="operation" key="STAR" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${edtState}">
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${form.stars}" varStatus="vars">
													<td>
														<html:multibox property="selectstar">
															<c:out value="${form.starvalues[vars.index]}" />
														</html:multibox>

														<c:out value="${item}" />
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

									</c:when>
									<c:otherwise>
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${form.stars}" varStatus="vars">
													<td>
														<html:multibox property="selectstar" disabled='true'>
															<c:out value="${form.starvalues[vars.index]}" />
														</html:multibox>
														<c:out value="${item}" />
													</td>
													<c:if test="${(vars.index+1)%5==0}">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="operation" key="remark" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:textarea styleClass="form_textarea_on_4"
											property="remark" />
									</c:when>
									<c:otherwise>
										<html:textarea styleClass="form_textarea_on_4"
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
							<td>
								<s:RewardPurChk controlid="<%=ID_2%>">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit" onclick="doSave('/cms/operation.do?CMD=SAVE')" />
								</s:RewardPurChk>

								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnPrint"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_print"/>"
									class="print" onclick="doPrint()">

								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturnIndex()">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
