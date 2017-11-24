<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.ui.commons.User" %>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ include file="/inc/listhead.inc" %>

<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="3C3C1AAA50" />
</jsp:include>
<% String PID = "3C3C1AAA50" ;
	String ID_1 = "3C3C1AAA50BT1";
	String ID_2 = "3C3C1AAA50BT2";
	String ID_3 = "3C3C1AAA50BT3";
String areacode = request.getParameter("areacode")==null?"":request.getParameter("areacode").toString().trim();
    User user = (User)request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
     String cityid=user.getCityid();
    boolean isBelong = user.isProvinceUser();      	
	 if(!isBelong){
   	isBelong = areacode.trim().equals(cityid.trim());
   	}
%>
<html>
	<head>
		<title><bean:message bundle="yxplansplitscale" key="titleList" />
		</title>
		<script language="JavaScript">
        function ev_check() {
            addfield('_ne_yxplanid', '<bean:message bundle="yxplansplitscale" key="yxplanid"/>', 'l', true, 20);
            addfield('_ne_yxplantypeid', '<bean:message bundle="yxplansplitscale" key="yxplantypeid"/>', 'l', true, 20);
            addfield('_ne_yxplankindid', '<bean:message bundle="yxplansplitscale" key="yxplankindid"/>', 'l', true, 20);
            addfield('_ne_yxplanitemid', '<bean:message bundle="yxplansplitscale" key="yxplanitemid"/>', 'l', true, 20);
            return checkval(window);
        }
        
        function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/zifee/yxplansplitscale.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="areacode" value="<%=areacode%>"/>
				<c:set var="areacode" scope="request" value="${param.areacode}"/>	
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">
				<input type="hidden" name="yxplanid"
					value='<c:out value="${param._ne_yxplanid}"/>'>
				<input type="hidden" name="lockOject"
					value='<c:out value="${param.lockOject}"/>'>
				<c:set var="lockOject" scope="request"
					value="${!empty param.lockOject}" />

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="yxplansplitscale" key="titleList" />
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
								<bean:message bundle="yxplansplitscale" key="yxplanid" />
								:
							</td>
							<td class="form_table_left">
								<c:if test="${lockOject}">
									<html:text styleClass="form_input_1x" property="_ne_yxplanid"
										readonly="true"></html:text>
								</c:if>

								<c:if test="${!lockOject}">
									<html:text styleClass="form_input_1x" property="_ne_yxplanid"></html:text>
									<input type="button" value="..."
										onclick="_ne_yxplanid.value=selectYxplan()">
								</c:if>

								<!-- html:text styleClass="form_input_1x" property="_ne_yxplanid" /-->
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="yxplansplitscale" key="yxplankindid" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_yxplankindid">
									<option value=""></option>
									<s:Options definition="#ZIFEE-YXPLANKIND" />
								</html:select>
								<!-- html:text styleClass="form_input_1x" property="_ne_yxplankindid" /-->
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="yxplansplitscale" key="yxplantypeid" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_yxplantypeid">
									<option value=""></option>
									<s:Options definition="#ZIFEE-YXPLANTYPE" />
								</html:select>
								<!-- html:text styleClass="form_input_1x"	property="_ne_yxplantypeid" /-->
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="yxplansplitscale" key="yxplanitemid" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_yxplanitemid">
									<option value=""></option>
									<s:Options definition="$PC_YXCHAIFENITEM" />
								</html:select>
								<!-- html:text styleClass="form_input_1x"	property="_ne_yxplanitemid" /-->
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								 <%
                    	if(isBelong){
                     %>
								<s:PurChk controlid="<%=ID_1%>">
									<input type="button" name="btnNew" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNew('/zifee/yxplansplitscale.do')">
								</s:PurChk>
								 <%}
								 %>
								 <%if(isBelong){ %>
								<s:PurChk controlid="<%=ID_2%>">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="doDelete('/zifee/yxplansplitscale.do')">
								</s:PurChk>
								<%
								}
								%>
								<s:PurChk controlid="<%=ID_3%>">
									<input type="button" class="query"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>"
										onClick="doQuery();" />
								</s:PurChk>
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
									<input type="checkbox" name="allbox" onclick="checkAll();"
										class="table_checkbox">
								</td>
								<td>
									<a href="javascript:doOrderby('yxplanid')"><bean:message
											bundle="yxplansplitscale" key="yxplanid" />
									</a>
									<s:OrderImg form="/zifee/yxplansplitscale/yxplansplitscaleForm"
										field="yxplanid" />
								</td>
								<td>
									<a href="javascript:doOrderby('yxplankindid')"><bean:message
											bundle="yxplansplitscale" key="yxplankindid" />
									</a>
									<s:OrderImg form="/zifee/yxplansplitscale/yxplansplitscaleForm"
										field="yxplankindid" />
								</td>
								<td>
									<a href="javascript:doOrderby('yxplantypeid')"><bean:message
											bundle="yxplansplitscale" key="yxplantypeid" />
									</a>
									<s:OrderImg form="/zifee/yxplansplitscale/yxplansplitscaleForm"
										field="yxplantypeid" />
								</td>
								<td>
									<a href="javascript:doOrderby('yxplanitemid')"><bean:message
											bundle="yxplansplitscale" key="yxplanitemid" />
									</a>
									<s:OrderImg
										form="/zifee/yxplansplitscale/yxplansplityxplanitemidForm"
										field="yxplanitemid" />
								</td>
								<td>
									<a href="javascript:doOrderby('endno')"><bean:message
											bundle="yxplansplitscale" key="scale" />
									</a>
									<s:OrderImg
										form="/zifee/yxplansplitscale/yxplansplityxplanitemidForm"
										field="scale" />
								</td>

							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/zifee/yxplansplitscale.do?CMD=EDIT"
									var="urlContent">
									<c:param name="PK"
										value="${item.yxplanid}|${item.yxplantypeid}|${item.yxplankindid}|${item.yxplanitemid}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value="${item.yxplanid}|${item.yxplantypeid}|${item.yxplankindid}|${item.yxplanitemid}" />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.yxplanid}" /> - <s:Code2Name
												code="${item.yxplanid}" definition="#ZIFEE-YXPLAN" />
										</a>
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.yxplankindid}" /> - <s:Code2Name
												code="${item.yxplankindid}" definition="#ZIFEE-YXPLANKIND" />
										</a>
									</td>
									<td>
										<c:out value="${item.yxplantypeid}" />
										-
										<s:Code2Name code="${item.yxplantypeid}"
											definition="#ZIFEE-YXPLANTYPE" />
									</td>
									<td>
										<c:out value="${item.yxplanitemid}" />
										-
										<s:Code2Name code="${item.yxplanitemid}"
											definition="$PC_YXCHAIFENITEM" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.scale}" />
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
	</body>
</html>
