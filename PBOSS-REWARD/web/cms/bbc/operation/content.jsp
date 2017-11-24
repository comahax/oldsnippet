<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%
String ID_1 = "CH_B2M_REWARD||CH_B2M_REWARD_PROVINCIAL"; //省级酬金管理令牌
String ID_2 = "CH_B2M_REWARD||CH_B2M_REWARD_CIVIC";
%>
<html>
	<head>
		<title><bean:message bundle="bbcoper" key="titleUpdate" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js">
		</script>
		<script language="JavaScript">
        function ev_checkval() {
       	 	addfield('opnid', '<bean:message bundle="bbcoper" key="opnid"/>', 'c', false, '18');
        	addfield('name', '<bean:message bundle="bbcoper" key="name"/>', 'c', false, '50');
            addfield('remark', '<bean:message bundle="bbcoper" key="remark"/>', 'c', true, '255');
            addfield('startdate', '<bean:message bundle="bbcoper" key="startdate"/>', 't', false, '25');
            addfield('enddate', '<bean:message bundle="bbcoper" key="enddate"/>', 't', false, '25');
            addfield('busibelong', '<bean:message bundle="bbcoper" key="busibelong"/>', 'c', false, '32');
            if(date_compare("startdate","enddate",'<bean:message bundle="bbcoper" key="timeCompare"/>')) return;
            return checkval(window);
        }
        function doReturnIndex(){
           var str = self.parent.location.toString();
           if(str.indexOf("frame.jsp")==-1){
               doReturn('/cms/bbc/operation.do?CMD=LIST');
           }else{
               self.parent.location='<%=contextPath%>/cms/bbc/operation.do?CMD=LIST';
           }
        }
        function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
  	  </script>
	</head>
	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/bbc/operation.do?CMD=SAVE" styleId="formItem"
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
				<c:set var="interTAB" scope="request"
					value="${empty param.opnid}" />
				<c:set var="form" scope="request"
					value="${requestScope['/cms/bbc/operation/BBCoperationForm']}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="bbcoper" key="titleList" />
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
									<bean:message bundle="bbcoper" key="opnid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState and not updateState}">
										<html:text styleClass="form_input_1x" property="opnid"/>
										<input type="button" value="..." class="clickbutton"
										onclick="opnid.value=getOpnId();">
										<font color="red">*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="opnid"
										disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcoper" key="name" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${interTAB eq false}">
											<html:text styleClass="form_input_1x" property="name"
											maxlength="50" disabled="true"/>
										</c:if>
										<c:if test="${interTAB eq true}">
											<html:text styleClass="form_input_1x" property="name"
											maxlength="50" />
											<font color="red">*</font>
										</c:if>
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
									<bean:message bundle="bbcoper" key="startdate" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${interTAB eq false}">
											<html:text styleClass="form_input_1x" property="startdate" disabled="true"/>
										</c:if>
										<c:if test="${interTAB eq true}">
											<input type='text' class="form_input_1x" name="startdate"
												value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.startdate}"/>"
												onclick="this.value=selectDate()" readonly="true" />
											<font color=red>*</font>
										</c:if>
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
									<bean:message bundle="bbcoper" key="enddate" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${interTAB eq false}">
											<html:text styleClass="form_input_1x" property="enddate" disabled="true"/>
										</c:if>
										<c:if test="${interTAB eq true}">
										<input type='text' class="form_input_1x" name="enddate"
											value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.enddate}"/>"
											onclick="this.value=selectDate()" readonly="true" />
										<font color=red>*</font>
										</c:if>
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
									<bean:message bundle="bbcoper" key="busibelong" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${interTAB eq false}">
										<html:select property="busibelong" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="#CH_BBCCBBUSIBELONG"/>
										</html:select>
										</c:if>
										<c:if test="${interTAB eq true}">
										<html:select property="busibelong">
											<html:option value=""></html:option>
											<s:Options definition="#CH_BBCCBBUSIBELONG" />
										</html:select>
										<font color="red">*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:select property="busibelong" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="#CH_BBCCBBUSIBELONG" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bbcoper" key="remark" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${interTAB eq false}">
										<html:textarea styleClass="form_textarea_on_4"
											property="remark" disabled="true"/>
										</c:if>
										<c:if test="${interTAB eq true}">
										<html:textarea styleClass="form_textarea_on_4"
											property="remark" />
										</c:if>
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
							<c:choose>
									<c:when test="${interTAB}">
										<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
											<input type="button" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" name="btnSave"
												onfocus="buttonover(this)" onblur="buttonout(this)"
												value="<bean:message bundle="public" key="button_save"/>"
												class="submit" onclick="doSave('/cms/bbc/operation.do?CMD=SAVE')" />
										</s:RewardPurChk>
									</c:when>
							</c:choose>
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
		<!-- 下面这个div不能删 用来作为iframe的默认页长度一定要满屏 否则后面页面显示不出数据 长度可以适当删除</br>来调整
		<div></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></div>-->
	</body>
</html>
