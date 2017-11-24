<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
	<head>
		<title><bean:message bundle="stdrewardhz" key="titleUpdate" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
		<script type="text/javascript" language="javascript">
		var msgNoSelected="<bean:message bundle="public" key="msgNoSelected"/>"
    	var msgConfirmDelete="<bean:message bundle="public" key="msgConfirmDelete"/>"
        function ev_checkval() {
        	addfield('rewardname', '<bean:message bundle="stdreward" key="rewardname"/>', 'c', false, '40');
            addfield('rewardproj', '<bean:message bundle="stdreward" key="rewardproj"/>', 'i', true, '3');
            addfield('startdate', '<bean:message bundle="stdreward" key="startdate"/>', 't', false, '25');
            addfield('stopdate', '<bean:message bundle="stdreward" key="stopdate"/>', 't', false, '25');
            addfield('memo', '<bean:message bundle="stdreward" key="memo"/>', 'c', true, '512');
            return checkval(window); 
        }
        function ev_checkstar() {
        	addfield('slv', '<bean:message bundle="stdrewardhz" key="slv"/>', 'i', false, '3');
            addfield('region', '<bean:message bundle="stdrewardhz" key="region"/>', 'c', false, '10');
            addfield('years', '<bean:message bundle="stdrewardhz" key="years"/>', 'i', false, '4');
            addfield('lmtstd', '<bean:message bundle="stdrewardhz" key="lmtstd"/>', 'f', false, '16','4');
        	return checkval(window); 
        }
        function changeStar(str){
        	if(ev_checkstar()){
        		enable(formItem);
        		formItem.action = str;
				formItem.submit();
        	}
        }
        function editStar(str){
          enable(formItem);
          formItem.action = str;
          formItem.submit();  
		}
		function deleteStar(str){
			var TO = true;
			var sis = formItem.all("_selectitem");
			if (forincheck(TO,sis,msgConfirmDelete)){
				enable(formItem);
				formItem.action = str;
				formItem.submit();
			}
		}
		
        function doReturn(url){
    		window.parent.document.location=contextPath + url;
		}
   		</script>
	</head>
	<body onload="if(window.loadforiframe) {loadforiframe();}">
		<div class="table_container">
			<html:form action="/cms/stdrewardhz.do?CMD=SAVE" styleId="formItem"
				method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="relateitem" />
				
				<html:hidden property="citystd" />
				<html:hidden property="rewardtype" value="30"/>
				<html:hidden property="rewardproj" value="4"/>
				
				<c:set var="edtState" scope="request" value="${(!empty param.PK and param.PK ne '') or param.CMD eq 'ADDSTAR' or param.CMD eq 'EDITSTAR' or param.CMD eq 'DELETESTAR' or param.CMD eq 'SAVESTAR'}" />
				<c:set var="newState" scope="request" value="${(empty param.PK or param.PK eq 'null' or param.PK eq '') or param.CMD eq 'ADDSTAR' or param.CMD eq 'EDITSTAR' or param.CMD eq 'DELETESTAR' or param.CMD eq 'SAVESTAR'}" />
				<c:set var="editstarState" scope="request" value="${param.CMD eq 'EDITSTAR'}" />
				<c:set var="nocmdState" scope="request" value="${empty param.PK or param.PK eq 'null' or param.PK eq ''}" />
				<c:set var="saveState" scope="request" value="${!empty param.CMD and param.CMD eq 'SAVE'}" />
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="stdrewardhz" key="titleList" />
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
				<FIELDSET>
					<legend name="organizeinfo">
						<bean:message bundle="stdreward" key="titleList1" />
					</legend>
					<div class="table_div">
						<table class="form_table">
							<tr>
								<td colspan="4">
									<bean:message bundle="stdrewardhz" key="tishi" />
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="rewardid" />
										:
									</div>
								</td>
								<td width="30%" colspan="4">
									<html:text styleClass="form_input_1x" property="rewardid" disabled="true" />
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="rewardname" />
										:
									</div>
								</td>
								<td width="30%" colspan="4">
									<c:choose>
										<c:when test="${edtState or newState}">
											<html:text styleClass="form_input_1x" property="rewardname"
												maxlength="40" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="rewardname"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="startdate" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState or newState}">
											<input class="form_input_1x" type="text" name="startdate"
												value="<fmt:formatDate value="${requestScope['/cms/stdrewardhz/StdrewardhzForm'].startdate}"
											pattern="yyyy-MM-dd" />"
												onclick="this.value=selectDate();" readonly="true" />
										</c:when>
										<c:otherwise>
											<input class="form_input_1x" type="text" name="startdate"
												value="<fmt:formatDate value="${requestScope['/cms/stdrewardhz/StdrewardhzForm'].startdate}"
											pattern="yyyy-MM-dd" />"
												onclick="this.value=selectDate();" disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="stopdate" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState or newState}">
											<input class="form_input_1x" type="text" name="stopdate"
												value="<fmt:formatDate value="${requestScope['/cms/stdrewardhz/StdrewardhzForm'].stopdate}"
											pattern="yyyy-MM-dd" />"
												onclick="this.value=selectDate();" readonly="true" />
										</c:when>
										<c:otherwise>

											<input class="form_input_1x" type="text" name="stopdate"
												value="<fmt:formatDate value="${requestScope['/cms/stdrewardhz/StdrewardhzForm'].stopdate}"
											pattern="yyyy-MM-dd" />"
												onclick="this.value=selectDate();" disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="memo" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left" colspan="4">
									<c:choose>
										<c:when test="${edtState or newState}">
											<html:textarea property="memo" styleClass="form_textarea_on" />
										</c:when>
										<c:otherwise>
											<html:textarea property="memo" styleClass="form_textarea_on" readonly="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</table>
					</div>
				</FIELDSET>
				<!--##################################添加标题内容##################################################-->
				<FIELDSET>
					<legend name="organizeinfo">
						<bean:message bundle="stdrewardhz" key="titleList" />
					</legend>
					<div class="table_div">
						<table class="form_table">
							<tr>
								<td colspan="4">
									<bean:message bundle="stdrewardhz" key="tishi" />
								</td>
							</tr>
							<tr>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="slv" />
										:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${(edtState or newState) and !editstarState}">
											<html:select property="slv">
												<html:option value=" "></html:option>
												<s:Options definition="#CH_STARLEVEL" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="slv" disabled="true">
												<html:option value=" "></html:option>
												<s:Options definition="#CH_STARLEVEL" />
											</html:select>
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>

								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="region" />
										:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${(edtState or newState) and !editstarState}">
											<html:select property="region">
												<html:option value=""></html:option>
												<s:Options definition="#CITYIDNUM2NMAME" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="region" disabled="true">
												<html:option value=""></html:option>
												<s:Options definition="#CITYIDNUM2NMAME" />
											</html:select>
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
							</tr>
							<tr>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="yearslabel" />
										:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${(edtState or newState) and !editstarState}">
											<html:text styleClass="form_input_1x" property="years"
												maxlength="16" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="years"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="lmtstd" />
										:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState or newState}">
											<html:text styleClass="form_input_1x" property="lmtstd"
												maxlength="16" />元/月
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="lmtstd"
												disabled="true" />元/月
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
								<td align=right>
									<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
									<c:choose>
										<c:when test="${(edtState or newState) and !editstarState}">
											<input type="button"
												value="<bean:message bundle="stdrewardhz" key="tmpadd"/>"
												class="comfir1" onclick="changeStar('<%=contextPath %>/cms/stdrewardhz.do?CMD=ADDSTAR')" onmouseover="buttonover(this)"
												onmouseout="buttonout(this)" onfocus="buttonover(this)"
												onblur="buttonout(this)">
										</c:when>
										<c:otherwise>
											<input type="button" disabled="true"
												value="<bean:message bundle="stdrewardhz" key="tmpadd"/>"
												class="comfir1" onclick="changeStar('<%=contextPath %>/cms/stdrewardhz.do?CMD=ADDSTAR')" onmouseover="buttonover(this)"
												onmouseout="buttonout(this)" onfocus="buttonover(this)"
												onblur="buttonout(this)">
										</c:otherwise>
									</c:choose>
									</s:RewardPurChk>
									<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
									<c:choose>
										<c:when test="${editstarState}">
											<input type="button"
												value="<bean:message bundle="stdrewardhz" key="tmpsave"/>"
												class="comfir1" onclick="changeStar('<%=contextPath %>/cms/stdrewardhz.do?CMD=SAVESTAR')"
												onmouseover="buttonover(this)" onmouseout="buttonout(this)"
												onfocus="buttonover(this)" onblur="buttonout(this)">
										</c:when>
										<c:otherwise>
											<input type="button" disabled="true"
												value="<bean:message bundle="stdrewardhz" key="tmpsave"/>"
												class="comfir1" onclick="changeStar('<%=contextPath %>/cms/stdrewardhz.do?CMD=SAVESTAR')"
												onmouseover="buttonover(this)" onmouseout="buttonout(this)"
												onfocus="buttonover(this)" onblur="buttonout(this)">
										</c:otherwise>
									</c:choose>
									</s:RewardPurChk>
									<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
										<input type="button"
											value="<bean:message bundle="stdrewardhz" key="tmpdelete"/>"
											class="comfir1" onclick="deleteStar('<%=contextPath %>/cms/stdrewardhz.do?CMD=DELETESTAR')"
											onmouseover="buttonover(this)" onmouseout="buttonout(this)"
											onfocus="buttonover(this)" onblur="buttonout(this)">
									</s:RewardPurChk>
								</td>
							</tr>
						</table>
					</div>
				
					<div class="table_div">
						<div class="table_LongTable">
							<table class="table_style" ID="Table2">
								<tr class="table_style_head">
									<td
										title="<bean:message bundle="public" key="list_title_select"/>">
										<input type="checkbox" name="allbox" onclick="checkAll('formItem');" class="table_checkbox">
									</td>
									<td>
										<bean:message bundle="stdrewardhz" key="slv" />
									</td>
									<td>
										<bean:message bundle="stdrewardhz" key="region" />
									</td>
									<td>
										<bean:message bundle="stdrewardhz" key="years" />
									</td>
									<td>
										<bean:message bundle="stdrewardhz" key="lmtstd" />
									</td>
									<td>
										<bean:message bundle="stdrewardhz" key="citystd" />
									</td>
									<td>
										<bean:message bundle="stdrewardhz" key="op" />
									</td>
								</tr>
								<c:forEach var="item" items="${requestScope.STARLIST}">
									<c:url value="/cms/stdrewardhz.do?CMD=EDITSTAR"
										var="urlContent">
										<%
										//this param name must "PK"
										%>
										<c:param name="pks" value="${item.rewardid}|${item.region}|${item.slv}|${item.years}|${item.relateitem}" />
										<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
									</c:url>
									<tr class="table_style_content" align="center">
										<td>
											<input type="checkbox" name="_selectitem"
												value="<c:out value='${item.rewardid}|${item.region}|${item.slv}|${item.years}' />"
												onclick="checkOne('formItem');" class="table_checkbox">
										</td>
										<td>
											<s:Code2Name code="${item.slv}" definition="#CH_STARLEVEL" />
										</td>
										<td>
											<s:Code2Name code="${item.region}" definition="$RegionList" />
										</td>
										<td>
											<c:out value="${item.years}" />
										</td>
										<td>
											<c:out value="${item.lmtstd}" />
										</td>
										<td>
											<c:if test="${item.citystd eq '' or (empty item.citystd)}">
												未指定
											</c:if>
											<c:if test="${item.citystd ne ''}">
												<c:out value="${item.citystd}" />
											</c:if>
										</td>
										<td>
											<a href='#'	onclick="editStar('<c:out value="${urlContent}"/>');return false;" target="_self"><bean:message bundle="stdrewardhz" key="op_edit" /></a>
											<!-- <a href='#' onclick="changeStar(<c:out value="${urlContent}"/>);return false;"  target="_self"><bean:message bundle="stdrewardhz" key="edit" /></a>  -->
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<div class="table_div">
						<s:PageNav dpName="LIST" />
					</div>
				</FIELDSET>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
									<c:choose>
										<c:when test="${!saveState}">
										<input type="button" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="stdrewardhz" key="savebutton"/>"
											class="submit1"
											onclick="doSave('/cms/stdrewardhz.do?CMD=SAVE');" />
										</c:when>
										<c:otherwise>
										<input type="button" onmouseover="buttonover(this);" disabled="disabled"
											onmouseout="buttonout(this);"
											onfocus="buttonover(this)" onblur="buttonout(this)"
											value="<bean:message bundle="stdrewardhz" key="savebutton"/>"
											class="submit1"
											/>
										</c:otherwise>
									</c:choose>
								</s:RewardPurChk>

								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/stdrewardhz.do?CMD=LIST')">
							</td>
							<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>

