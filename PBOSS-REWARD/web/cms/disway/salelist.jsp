<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.delegate.cms.way.WayDelegate"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A3C" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_QUERY";
	String ID_2 = "CH_PW_SALEWAY_DELETE";
	String ID_3 = "CH_PW_SALEWAY_BATCHIMPORT";
	String ID_4 = "CH_PW_SALEWAY_EXPORT";
	String ID_5 = "CH_PW_SALEWAYDD";
%>

<html>
	<head>
		<title>
			<bean:message bundle="Way" key="salelistTitle" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<SCRIPT>
			function doQuery(){
			    formList.action = contextPath + "/cms/disway.do?CMD=LISTSALEWAY&wayid=<c:out value='${requestScope.pk}'/>";
			    formList.submit();
			}
			
			function doReturn(cmd){
			    formList.action = contextPath + cmd;
			    formList.submit();
			}
		</SCRIPT>
	</head>

	<body>
		<div class="table_container">

			<html:form action="/cms/disway.do?CMD=LISTSALEWAY" styleId="formList" method="post">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容，里面可以放置按钮##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="Way" key="salelistTitle" />
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

				<!--#################################添加标题内容，里面可以放置按钮###################################################-->
				<div class="table_div">
					<table class="form_table">

						<tr>
							<td width="100" height="20" align="right" class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_sk_wayid" styleClass="form_input_1x" />
							</td>
							<td width="100" height="20" align="right" class="form_table_right" nowrap>
								<bean:message bundle="saleway" key="wayname" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_wayname" />
							</td>
						</tr>

					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:PurChk controlid="<%=ID_1%>">
									<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>"
									 onClick ="doQuery();">
								</s:PurChk>
								
	          <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                 name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                 value="<bean:message bundle="public" key="button_return"/>" class="close"
	                 onclick="doReturn('/cms/disway.do?CMD=LIST&WAYSUBTYPE=DIS')">
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td nowrap>
									<a href="javascript:doOrderby('wayid')">
										<bean:message bundle="saleway" key="wayid" />
									</a>
									<s:OrderImg form="/cms/way/SalewayForm" field="wayid" />
								</td>
								<td nowrap>
									<a href="javascript:doOrderby('wayname')">
										<bean:message bundle="saleway" key="wayname" />
									</a>
									<s:OrderImg form="/cms/way/SalewayForm" field="wayname" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="waysubtype" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="catetype" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="cityid" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="countyid" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="svccode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="mareacode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="adtypecode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="adacode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="formtype" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="starttime" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="logiscode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="waymagcode" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="mainlayer" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="sublayer" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="bchlevel" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="waystate" />
								</td>
								<td nowrap>
									<bean:message bundle="saleway" key="buzphoneno" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td>
											<c:out value="${item.wayid}" />
									</td>
									<td nowrap="nowrap">
										<c:out value="${item.wayname}" />
									</td>
									<td>
										<s:Code2Name code="${item.waysubtype}" definition="#WAYTYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.catetype}" definition="$CH_CATETYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY" />
									</td>
									<td>
										<s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" />
									</td>
									<td>
										<s:Code2Name code="${item.svccode}" definition="#CH_SERVCENT" />
									</td>
									<td>
										<s:Code2Name code="${item.mareacode}" definition="#CH_MICROAREA" />
									</td>
									<td>
										<s:Code2Name code="${item.adtypecode}" definition="$CH_ADTYPE" />
									</td>
									<td>
										<c:out value="${item.adacode}" />
									</td>
									<td>
										<s:Code2Name code="${item.formtype}" definition="$CH_FORMTYPE" />
									</td>
									<td>
										<fmt:formatDate value="${item.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
										<c:out value="${item.logiscode}" />
									</td>
									<td>
										<c:out value="${item.waymagcode}" />
									</td>
									<td>
										<s:Code2Name code="${item.mainlayer}" definition="$CH_MAINLAYER" />
									</td>
									<td>
										<s:Code2Name code="${item.sublayer}" definition="$CH_SUBLAYER" />
									</td>
									<td>
										<s:Code2Name code="${item.bchlevel}" definition="$CH_BCHLEVEL" />
									</td>
									<td>
										<s:Code2Name code="${item.waystate}" definition="$CH_BUZSTATUS" />
									</td>
									<td>
										<c:out value="${item.buzphoneno}" />
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
