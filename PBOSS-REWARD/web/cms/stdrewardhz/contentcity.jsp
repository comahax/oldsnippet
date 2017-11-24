<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";
%>
<html>
	<head>
		<title><bean:message bundle="stdrewardhz" key="titleCityList" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/JMpopup.js"></script>
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
            addfield('citystd', '<bean:message bundle="stdrewardhz" key="citystd"/>', 'f', false, '16','4','','0',formItem.lmtstd.value);
        	return checkval(window); 
        }
        function changeStar(str){
        	if(ev_checkstar()){
        		enable(formItem);
        		formItem.action = str;
				formItem.submit();
        	}
        }
        function saveintvmonth(str){
          enable(formItem);
          formItem.action = str;
          formItem.submit();  
		}
        function editStar(str){
          enable(formItem);
          formItem.action = str;
          formItem.submit();  
		}
        function doReturn(url){
    		window.parent.document.location=contextPath + url;
		}
		
		var w_word = 300;
		var h_word = 150; 
		function openword (title,str) {
			newin = new messagePopup(event.screenX+10,event.screenY+10,w_word,h_word,title,str);
			newin.toshow();
		}
   		</script>
	</head>
	<body onload="if(window.loadforiframe) {loadforiframe();}">
		<div class="table_container">
			<html:form action="/cms/stdrewardhz.do?CMD=SAVE" styleId="formItem"	method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="relateitem" />
				
				<html:hidden property="memo" />
				<html:hidden property="slv" />
				<html:hidden property="region" />
				<html:hidden property="years" />
				<html:hidden property="lmtstd" />
				<html:hidden property="health" />
				
				
				<html:hidden property="rewardtype" value="30"/>
				<html:hidden property="rewardproj" value="4"/>
				
				<c:set var="editstarState" scope="request" value="${!empty param.CMD and param.CMD eq 'EDITSTARCITY'}" />
				<c:set var="saveState" scope="request" value="${!empty param.CMD and param.CMD eq 'SAVECITY'}" />
				<c:set var="saveintvmonthState" scope="request" value="${!empty param.CMD and param.CMD eq 'SAVEINTVMONTH'}" />
				
				<c:set var="form" scope="request" value="${requestScope['/cms/stdrewardhz/StdrewardhzForm']}" />
				
				
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="stdrewardhz" key="titleCityList" />
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
									<html:text styleClass="form_input_1x_none" property="rewardid" readonly="true" />
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="rewardname" />
										:
									</div>
								</td>
								<td width="50%" colspan="4">
									<html:text styleClass="form_input_1x_none" property="rewardname" readonly="true" />
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
									<input class="form_input_1x_none" type="text" name="startdate"
											value="<fmt:formatDate value="${form.startdate}" pattern="yyyy-MM-dd" />" readonly="true" />
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="stopdate" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<input class="form_input_1x_none" type="text" name="stopdate"
											value="<fmt:formatDate value="${form.stopdate}" pattern="yyyy-MM-dd" />" readonly="true" />
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
									<c:out value="${form.memo}" />
								</td>
							</tr>
						</table>
					</div>
				</FIELDSET>
				<FIELDSET>
					<legend name="organizeinfo">
						合作年限间隔月份管理
					</legend>
					<div class="table_div">
						<table class="form_table">
						<tr>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
									合作年限间隔月份:
									</div>
								</td>
								<td width="48%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${saveintvmonthState}">
												<c:if test="${form.intvmonth == 0}">
												<input class="form_input_1x" type="text" name="intvmonth"
											disabled="true"	value="<c:out value="" />"  />
												</c:if>
												<c:if test="${form.intvmonth != 0}" >
													<input class="form_input_1x" type="text" name="intvmonth"
												disabled="true"	value="<c:out value="${form.intvmonth}" />"  />
												</c:if>
												<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<c:if test="${form.intvmonth == 0}">
												<input class="form_input_1x" type="text" name="intvmonth"
												value="<c:out value="" />"  />
												</c:if>
												<c:if test="${form.intvmonth != 0}" >
													<input class="form_input_1x" type="text" name="intvmonth"
													value="<c:out value="${form.intvmonth}" />"  />
												</c:if>
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
								<td align="right">
										<input type="button" 
											value="保存"
											class="comfir1" onclick="saveintvmonth('<%=contextPath %>/cms/stdrewardhz.do?CMD=SAVEINTVMONTH')"
											onmouseover="buttonover(this)" onmouseout="buttonout(this)"
											onfocus="buttonover(this)" onblur="buttonout(this)">
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
								<td width="28%" align="left" class="form_table_left">
									<s:Code2Name code="${form.slv}" definition="#CH_STARLEVEL"/>
								</td>

								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="region" />
										:
									</div>
								</td>
								<td width="48%" align="left" class="form_table_left">
									<s:Code2Name code="${form.region}" definition="#CITYIDNUM2NMAME"/>
								</td>
							</tr>
							<tr>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="yearslabel" />
										:
									</div>
								</td>
								<td width="28%" align="left" class="form_table_left">
									<c:out value="${form.years}" />
								</td>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="citystd" />
										:
									</div>
								</td>
								<td width="48%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${editstarState}">
											<html:text styleClass="form_input_1x" property="citystd"
												maxlength="16" />省公司上限:<font color="red"><c:out value="${form.lmtstd}" /></font>元/月
											<font color=red>&nbsp;*</font>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="citystd"
												disabled="true" />元/月
										</c:otherwise>
									</c:choose>
									
								</td>
							</tr>
							<tr>
								<td width="15%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardhz" key="isrelateitem" />
										:
									</div>
								</td>
								<td width="35%" align="left" class="form_table_left">
									<html:checkbox property="isRelateitem" /><span onmouseover="openword('<bean:message bundle="stdrewardhz" key="isRelateitem" />','<bean:message bundle="stdrewardhz" key="isRelateitemcontent" />')" onmouseout="newin.toclose()">关联网点每月套卡销量</span>
								</td>
								<td width="15%" align="right" class="form_table_left" colspan="2">
									<html:checkbox property="isHealth" /><span onmouseover="openword('<bean:message bundle="stdrewardhz" key="isHealth" />','<bean:message bundle="stdrewardhz" key="isHealthcontent" />')" onmouseout="newin.toclose()">健康度大于或等于<fmt:formatNumber pattern="00%" value="${form.health}"></fmt:formatNumber></span>
								</td>
								<td>
								</td>
							</tr>
							
							<tr>
								<td width="100%" colspan="4" align="left" class="form_table_left">
									(关于合作年限的计算,如果网点违规次数不超过3次(点击"网点违规次数"设置违规次数,可点击文件超链接url跳转到"资源管理-系统参数管理"对应系统标识为64,类型为"渠道"的那条记录配置),系统会根据市公司录入"下次计算使用的合作开始时间"(可点击文件超链接url跳转到渠道管理->社会渠道业务管理->酬金管理->合作年限奖管理->计算合作年限的开始时间设置(按钮)),如果不录入,则默认取网点基本资料的"合作开始时间"字段和当前结算的月份比较计算得出,如果因违规3次(次数可配)及以上需要清零(地市公司需要在boss系统及时导入违规信息),系统自动把合作开始时间清零,则取最后一次违规时间和当前结算的月份比较计算得出)
								</td>
							</tr>
						</table>
					</div>

					<div class="table_div">
						<table class="table_button_list">
							<tr>
								<td align="right">
									<c:choose>
										<c:when test="${editstarState}">
											<input type="button"
												value="<bean:message bundle="stdrewardhz" key="tmpsave"/>"
												class="comfir1" onclick="changeStar('<%=contextPath %>/cms/stdrewardhz.do?CMD=SAVESTARCITY')"
												onmouseover="buttonover(this)" onmouseout="buttonout(this)"
												onfocus="buttonover(this)" onblur="buttonout(this)">
										</c:when>
										<c:otherwise>
											<input type="button" disabled="true"
												value="<bean:message bundle="stdrewardhz" key="tmpsave"/>"
												class="comfir1" onclick="changeStar('<%=contextPath %>/cms/stdrewardhz.do?CMD=SAVESTARCITY')"
												onmouseover="buttonover(this)" onmouseout="buttonout(this)"
												onfocus="buttonover(this)" onblur="buttonout(this)">
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</table>
					</div>
				
					<div class="table_div">
						<div class="table_LongTable">
							<table class="table_style" ID="Table2">
								<tr class="table_style_head">
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
									<c:url value="/cms/stdrewardhz.do?CMD=EDITSTARCITY"
										var="urlContent">
										<%
										//this param name must "PK"
										%>
										<c:param name="pks" value="${item.rewardid}|${item.region}|${item.slv}|${item.years}|${item.relateitem}" />
										<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
									</c:url>
									<tr class="table_style_content" align="center">
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
											onclick="doSave('/cms/stdrewardhz.do?CMD=SAVECITY');" />
										</c:when>
										<c:otherwise>
										<input type="button" onmouseover="buttonover(this);" disabled="true"
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