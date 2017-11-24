<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="zjtyemployeedetail"
				key="titleList" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {    	
        	return checkval(window);
        }
		
		function upload(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/zjty/zjtyemployeedetail/batch.jsp";
		form.submit();
		}
		
		function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
		
		
		function exports(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/zjty/zjtyemployeedetail.do?CMD=EXCEL";
			form.submit();
			form.action="<%=contextPath%>/cms/zjty/zjtyemployeedetail.do?CMD=LIST";
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtyemployeedetail.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="zjtyemployeedetail" key="titleList" />
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
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyemployeedetail" key="chainhead" />
								:
							</td>
							<td class="form_table_left">
								<s:zoom definition="#WAY" property="_se_chainhead"
											styleClass="form_input_1x" condition="waytype:${'AG'};waysubtype:${'DIS'}"/>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyemployeedetail" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY','1');this.value='...';" />
							</td>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyemployeedetail" key="oprcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyemployeedetail" key="station" />
								:

							</td>
							<td class="form_table_left">
								<html:select property="_se_station">
									<html:option value=""></html:option>
									<s:Options definition="#CH_POSTINFO" />
								</html:select>
							</td>
						</tr>

					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button" class="query"
									onmouseover="buttonover(this);" onclick="doQuery();"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />

								<input type="button" name="btnNew2" class="button_4"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="zjtyemployeedetail" key="zjtyemployeedetail_export"/>"
									onClick="exports()">
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">


								<td>
									<a href="javascript:doOrderby('chainhead')"><bean:message
											bundle="zjtyemployeedetail" key="chainhead" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyemployeedetail/ZjtyEmployeedetailForm"
										field="chainhead" />
								</td>
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="zjtyemployeedetail" key="cityid" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyemployeedetail/ZjtyEmployeedetailForm"
										field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="zjtyemployeedetail" key="wayid" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyemployeedetail/ZjtyEmployeedetailForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="zjtyemployeedetail" key="wayname" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyemployeedetail/ZjtyEmployeedetailForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('employeename')"><bean:message
											bundle="zjtyemployeedetail" key="employeename" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyemployeedetail/ZjtyEmployeedetailForm"
										field="employeename" />
								</td>
								<td>
									<a href="javascript:doOrderby('employeeid')"><bean:message
											bundle="zjtyemployeedetail" key="position" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyemployeedetail/ZjtyEmployeedetailForm"
										field="employeeid" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprcode')"><bean:message
											bundle="zjtyemployeedetail" key="oprcode" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyemployeedetail/ZjtyEmployeedetailForm"
										field="oprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('start_using_time')"><bean:message
											bundle="zjtyemployeedetail" key="start_using_time" /> </a>
									<s:OrderImg
										form="/cms/zjty/zjtyemployeedetail/ZjtyEmployeedetailForm"
										field="start_using_time" />
								</td>

							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/zjty/zjtyemployeedetail.do?CMD=EDIT"
									var="urlContent">
									<c:param name="PK" value="${item.employeeid}" />
								</c:url>
								<tr class="table_style_content" align="center">

									<td>
										<s:Code2Name code="${item.chainhead}" definition="#WAY"></s:Code2Name>
									</td>
									<td>
										<s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY" />

									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<c:out value="${item.wayname}" />
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.employeename}" />
										</a>
									</td>
									<td>
										<s:Code2Name code="${item.station}" definition="#CH_POSTINFO" />
									</td>
									<td>
										<c:out value="${item.oprcode}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd"
											value="${item.start_using_time}" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="table_div">
					<s:PageNav dpName="LIST" />
				</div>
			</html:form>
		</div>
	</body>
</html>
