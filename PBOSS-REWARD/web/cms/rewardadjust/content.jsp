<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="org.ajaxanywhere.*"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="rewardadjust" key="titleUpdate" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
        	var iscorrect = true;
        	var str;
            addfield('seq', '<bean:message bundle="rewardadjust" key="seq"/>', 'i', false, '14');
            addfield('adjustkind', '<bean:message bundle="rewardadjust" key="adjustkind"/>', 'c', true, '32');
            addfield('wayid', '<bean:message bundle="rewardadjust" key="wayid"/>', 'c', true, '18');
            addfield('eftmonth', '<bean:message bundle="rewardadjust" key="eftmonth"/>', 'i', false, '6');
            addfield('adjmoney', '<bean:message bundle="rewardadjust" key="adjmoney"/>', 'd', false, '12','2');
            addfield('adjusttype', '<bean:message bundle="rewardadjust" key="adjusttype"/>', 'c', false, '32');
            addfield('reasontype', '<bean:message bundle="rewardadjust" key="reasontype"/>', 'c', true, '32');
            addfield('remark', '<bean:message bundle="rewardadjust" key="remark"/>', 'c', false, '500');
            addfield('createoprcode', '<bean:message bundle="rewardadjust" key="createoprcode"/>', 'c', true, '15');
            addfield('createtime', '<bean:message bundle="rewardadjust" key="createtime"/>', 'dt', true, '25');
            addfield('updateoprcode', '<bean:message bundle="rewardadjust" key="updateoprcode"/>', 'c', true, '15');
            addfield('updatetime', '<bean:message bundle="rewardadjust" key="updatetime"/>', 'dt', true, '25');
            addfield('relateseq', '<bean:message bundle="rewardadjust" key="relateseq"/>', 'i', true, '14');
            addfield('actualmoney', '<bean:message bundle="rewardadjust" key="actualmoney"/>', 'd', true, '12','2');
            addfield('rewardtype', '<bean:message bundle="rewardadjust" key="rewardtype"/>', 'i', true, '3');
            addfield('islock', '<bean:message bundle="rewardadjust" key="islock"/>', 'i', true, '3');
            addfield('srcmonth', '<bean:message bundle="rewardadjust" key="srcmonth"/>', 'c', false, '6');
            addfield('adtoprcode', '<bean:message bundle="rewardadjust" key="adtoprcode"/>', 'c', true, '15');
            addfield('adttime', '<bean:message bundle="rewardadjust" key="adttime"/>', 'dt', true, '25');
            if(formItem.srcmonth.value > formItem.eftmonth.value){
				str = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[酬金发生月]</span>'+':酬金发生月只能小于等于作用结算月！'+'</span>';
				errorMessageShow(str);
				iscorrect= false;
			}
			if(!checkDateByMask(formItem.srcmonth.value,'yyyyMM')){
				str = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[酬金发生月]</span>'+':日期无效！'+'</span>';
				errorMessageShow(str);
				iscorrect= false;
			}
			
			var maincheck = checkval(window);
			if (maincheck==false) {
				return false;
			}
			if (document.all("adjmoney").value<0.00) {
				str = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[调整金额]</span>'+':不允许为负数！'+'</span>';
				errorMessageShow(str);
				iscorrect= false;
			}
			var eftmonth = document.all("eftmonth").value;
			var yyyy = eftmonth.substr(0,4);
			var mm = eftmonth.substr(4,6);
			if (yyyy<1950 || yyyy>2100 || mm>12 || mm<1) {
				str = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[作用结算月份]</span>'+':日期无效！'+'</span>';
				errorMessageShow(str);
				iscorrect= false;
			}

			return iscorrect;
        }
        function loadnew(){
        	var form=document.forms[0];
        	form.action="<%=contextPath%>/cms/rewardadjust.do?CMD=LOADNEW";
        	form.submit();
        	form.action="<%=contextPath%>/cms/rewardadjust.do?CMD=SAVE";
        }
        function loadedit(){
        	var form=document.forms[0];
        	form.action="<%=contextPath%>/cms/rewardadjust.do?CMD=LOADEDIT";
        	form.submit();
        	form.action="<%=contextPath%>/cms/rewardadjust.do?CMD=SAVE";
        }
        
        
    </script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/rewardadjust.do?CMD=SAVE" styleId="formItem"
				method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="reasontype" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'LOADNEW' or param.CMD eq 'LOADEDIT')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'LOADEDIT')}" />


				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="rewardadjust" key="titleList" />
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
									<c:choose>
										<c:when test="${edtState}">
											<c:if test="${updateState}">
												<bean:message bundle="rewardadjust" key="seq" />
												:
											</c:if>
										</c:when>
										<c:otherwise>
											<bean:message bundle="rewardadjust" key="seq" />
											:
										</c:otherwise>
									</c:choose>
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="seq"
												maxlength="14" disabled="true" /><font color=red>&nbsp;*</font>
										</c:if>

									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="seq"
											disabled="true" /><font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="adjustkind" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:select property="adjustkind" onchange="loadedit();"
												disabled="true">
												<option />
													<s:Options definition="$CH_RWADJUSTKIND" />
											</html:select><font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:select property="adjustkind" onchange="loadnew();">

												<s:Options definition="$CH_RWADJUSTKIND" />
											</html:select>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:select property="adjustkind" disabled="true">
											<option />
												<s:Options definition="$CH_RWADJUSTKIND" />
										</html:select><font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="wayid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="wayid"
												maxlength="18" disabled="true" /><font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="wayid"
												maxlength="18"  /><input type="button" value="..." class="clickbutton"
										onclick="showSelectWay(this,'wayid');this.value='...';"/><font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="wayid"
											disabled="true" /><font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="eftmonth" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="eftmonth"
											maxlength="6" onclick="this.value=selectDateYYYYMM();"/><font color=red>&nbsp;*</font>(不能填已经结算过的历史结算月份，只能填正在结算或未结算的结算月)
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="eftmonth"
											disabled="true" /><font color=red>&nbsp;*</font>(不能填已经结算过的历史结算月份，只能填正在结算或未结算的结算月)
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="adjmoney" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">

								<c:choose>
									<c:when test="${edtState}">
										<input type="text" Class="form_input_1x" name="adjmoney"
											value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/RewardadjustForm'].adjmoney }"/>" /><font color=red>&nbsp;*</font>(只能填正数，支持2位小数)
									</c:when>
									<c:otherwise>
										<input type="text" Class="form_input_1x" name="adjmoney"
											value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/RewardadjustForm'].adjmoney }"/>"
											disabled="true" /><font color=red>&nbsp;*</font>(只能填正数，支持2位小数)
									</c:otherwise>
								</c:choose>

							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="adjusttype" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">

								<c:choose>
									<c:when test="${edtState}">
										<html:select property="adjusttype">
											<c:if test="${'PUNISH' eq requestScope['/cms/RewardadjustForm'].adjustkind}">
												<option />
											</c:if>
											<s:Options definition="#CH_DICTITEM"
												condition="_sk_dictid:${requestScope['/cms/RewardadjustForm'].dictid2};groupid:CH_RWADJUSTTYPE" />
										</html:select><font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:select property="adjusttype" disabled="true">
											<s:Options definition="#CH_DICTITEM"
												condition="_sk_dictid:${requestScope['/cms/RewardadjustForm'].dictid2};groupid:CH_RWADJUSTTYPE" />
										</html:select><font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>

							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="reasontype" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:forEach var="item" items="${requestScope.LIST.datas}">

											
											<c:set var="doneLoop" value="true" />
											<c:if test="${empty requestScope.SEL}">
												<input type="checkbox" name="_selecttype"
													value="<c:out value="${item.dictid}"/>"
													class="table_checkbox" />
													<c:set var="doneLoop" value="false" />
											</c:if>

											<c:forEach var="itemb" items="${requestScope.SEL}">
												<c:if test="${item.dictid eq itemb}">
													<input type="checkbox" name="_selecttype"
														value="<c:out value="${item.dictid}"/>" checked="true"
														class="table_checkbox" />
													<c:set var="doneLoop" value="false" />
												</c:if>
											</c:forEach>
											<c:if test="${doneLoop}">
												<input type="checkbox" name="_selecttype"
													value="<c:out value="${item.dictid}"/>"
													class="table_checkbox" />
											</c:if>
											<c:out value="${item.dictname}" />
										</c:forEach>
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${requestScope.LIST.datas}">

											
											<c:set var="doneLoop" value="true" />
											<c:if test="${empty requestScope.SEL}">
												<input type="checkbox" name="_selecttype"
													value="<c:out value="${item.dictid}"/>"
													class="table_checkbox" disabled="true"/>
													<c:set var="doneLoop" value="false" />
											</c:if>

											<c:forEach var="itemb" items="${requestScope.SEL}">
												<c:if test="${item.dictid eq itemb}">
													<input type="checkbox" name="_selecttype"
														value="<c:out value="${item.dictid}"/>" checked="true"
														class="table_checkbox" disabled="true"/>
													<c:set var="doneLoop" value="false" />
												</c:if>
											</c:forEach>
											<c:if test="${doneLoop}">
												<input type="checkbox" name="_selecttype"
													value="<c:out value="${item.dictid}"/>"
													class="table_checkbox" disabled="true"/>
											</c:if>
											<c:out value="${item.dictname}" />
										</c:forEach><font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="srcmonth" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="srcmonth"
											maxlength="6" onclick="this.value=selectDateYYYYMM();"/>
										<font color='red'>*</font>(不能填正在结算或未结算的结算月，只能填已经结算过的历史结算月) 
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="srcmonth"
											disabled="true"/>
										<font color='red'>*</font>(不能填正在结算或未结算的结算月，只能填已经结算过的历史结算月) 
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="remark" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:textarea style="width:300px;height:70px;" property="remark" rows="70" cols="30"/><font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:textarea style="width:300px;height:70px;" property="remark" rows="70" cols="30" disabled="true"/><font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="createoprcode" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="createoprcode"
											maxlength="15" disabled="true" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="createoprcode"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="createtime" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input type="text" Class="form_input_1x" name="createtime"
											value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/RewardadjustForm'].createtime }"/>"
											disabled="true" />
									</c:when>
									<c:otherwise>
										<input type="text" Class="form_input_1x" name="createtime"
											value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/RewardadjustForm'].createtime }"/>"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="updateoprcode" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x"
												property="updateoprcode" maxlength="15" disabled="true"/>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x"
												property="updateoprcode" maxlength="15" disabled="true" />
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="updateoprcode"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="updatetime" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<input type="text" Class="form_input_1x" name="updatetime"
												value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/RewardadjustForm'].updatetime }"/>"
												 disabled="true" />
										</c:if>
										<c:if test="${!updateState}">
											<input type="text" Class="form_input_1x" name="updatetime"
												value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/RewardadjustForm'].updatetime }"/>"
												disabled="true" />
										</c:if>
									</c:when>
									<c:otherwise>
										<input type="text" Class="form_input_1x" name="updatetime"
											value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/RewardadjustForm'].updatetime }"/>"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="relateseq" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="relateseq"
											maxlength="14" disabled="true"/>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="relateseq"
											disabled="true"/>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="actualmoney" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input type="text" Class="form_input_1x" name="actualmoney"
											value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/RewardadjustForm'].actualmoney }"/>" disabled="true"/>
									</c:when>
									<c:otherwise>
										<input type="text" Class="form_input_1x" name="actualmoney"
											value="<fmt:formatNumber pattern="0.00" value="${requestScope['/cms/RewardadjustForm'].actualmoney }"/>"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="rewardtype" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="rewardtype" disabled="true">
											<option />
												<s:Options definition="$CH_REWARDTYPE" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="rewardtype" disabled="true">
											<option />
												<s:Options definition="$CH_REWARDTYPE" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="islock" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
										<html:select property="islock" disabled="true">
											<option />
												<s:Options definition="#ISLOCK" />
										</html:select>
							</td>
						</tr>
						
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="adtoprcode" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<html:text styleClass="form_input_1x" property="adtoprcode" disabled="true"/>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="rewardadjust" key="adttime" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<input type="text" Class="form_input_1x" name="adttime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
									value="${requestScope['/cms/RewardadjustForm'].adttime }"/>" disabled="true" />
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
									<c:if test="${!updateState}">
										<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/rewardadjust.do?CMD=SAVE')" />
									</c:if>
									<c:if test="${updateState}">
										<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/rewardadjust.do?CMD=SAVE')" />
									</c:if>
									</c:when>
									<c:otherwise>
										
									</c:otherwise>
								</c:choose>
								
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/rewardadjust.do?CMD=LIST')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
