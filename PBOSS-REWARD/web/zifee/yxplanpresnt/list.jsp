<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%
			String areacode = request.getParameter("areacode") == null ? ""
			: request.getParameter("areacode").toString();
	User user = (User) request.getSession().getAttribute(
			WebConstant.SESSION_ATTRIBUTE_USER);
	String cityid = user.getCityid();
	boolean isBelong = user.isProvinceUser();
	if (!isBelong) {
		isBelong = areacode.trim().equals(cityid.trim());
	}
%>
<%
	String ID_LIST = "3C3C1AAA60";
	String ID_ADD = "3C3C1AAA60ADD";
	String ID_DEL = "3C3C1AAA60DEL";
	String ID_QUY = "3C3C1AAA60QUY";
	
%>
<html>
	<head>
		<title><bean:message bundle="yxplanpresnt" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_yxplanid', '<bean:message bundle="yxplanpresnt" key="yxplanid"/>', 'i', true, '14');
            addfield('_ne_acctid', '<bean:message bundle="yxplanpresnt" key="acctid"/>', 'i', true, '14');
            addfield('_ne_presentinterval', '<bean:message bundle="yxplanpresnt" key="presentinterval"/>', 'i', true, '5');
            addfield('_ne_presentcycles', '<bean:message bundle="yxplanpresnt" key="presentcycles"/>', 'i', true, '5');
            addfield('_ne_presentrate', '<bean:message bundle="yxplanpresnt" key="presentrate"/>', 'd', true, '6','2');
            addfield('_ne_eboxunitid', '<bean:message bundle="yxplanpresnt" key="eboxunitid"/>', 'i', true, '14');
            return checkval(window);
        }
          function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var ret = window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			if(ret == null) return "";
			else return ret;
		 }
		 function getAcctId() {
			var strUrl;
			var arg = new Array();
			strUrl ="<%=contextPath%>/fee/woff/acct.do?CMD=SELECT";
			var rtn = window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return (rtn == null ? '' : rtn);
		}
		 function getRetAcctID(){
		    var retValue = getAcctId();
		    if(retValue!=null && retValue!='' && retValue!='null' ) 
		    	document.all("formList")._ne_acctid.value=retValue;
		 }  
		 function doCheckDelete(cmd)
		 {
		   var TO = true;
	   	 	var sis = formList.all("_selectitem");
	     	if(forincheck(TO,sis,msgConfirmDelete)){
			 var strUrl ="<%=contextPath%>"+cmd+"?CMD=CHECKFORDELETE";
			 formList.action=strUrl;
			 formList.submit();
	       }
	     }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/zifee/yxplanpresnt.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
				<input type="hidden" name="areacode" value="<c:out value='${param.areacode}' />">
				<input type="hidden" name="yxplanid" value='<c:out value="${param._ne_yxplanid}"/>'>
				<input type="hidden" name="lockOject" value='<c:out value="${param.lockOject}"/>'>
				<c:set var="lockOject" scope="request" value="${!empty param.lockOject}" />
				<c:set var="areacode" scope="request" value="${param.areacode}" />
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="yxplanpresnt" key="titleList" />
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
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="yxplanpresnt" key="yxplanid" />
								:
							</td>
							<td class="form_table_left">
								<c:if test="${lockOject}">
									<html:text styleClass="form_input_1x" property="_ne_yxplanid" readonly="true"></html:text>
								</c:if>
								<c:if test="${!lockOject}">
									<html:text styleClass="form_input_1x" property="_ne_yxplanid"></html:text>
									<input type="button" value="..." onclick="_ne_yxplanid.value=selectYxplan()">
								</c:if>
							</td>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="yxplanpresnt" key="acctid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_acctid" onclick="this.value=getAcctId()" />
								<input type="button" value="..." onclick="getRetAcctID()" />
							</td>
						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<bean:message bundle="yxplanpresnt" key="presentinterval" />
								:
							</td>
							<td align="right" class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_presentinterval" />
							</td>
							<td align="right" class="form_table_right">
								<bean:message bundle="yxplanpresnt" key="presentcycles" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_presentcycles" />
							</td>
						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<bean:message bundle="yxplanpresnt" key="presentrate" />
								:
							</td>
							<td class="form_table_left">
								<html:text property="_ne_presentrate" styleClass="form_input_1x" />
							</td>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="yxplanpresnt" key="eboxunitid" />
								:
							</td>
							<td class="form_table_left">
								<s:zoom definition="#EBOXUNIT" property="_ne_eboxunitid" readonly="false" styleClass="form_input_1x" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<%
								if (isBelong) {
								%>
								<s:PurChk controlid="<%=ID_ADD%>">
									<input type="button" name="btnNew" class="add" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNew('/zifee/yxplanpresnt.do')">
								</s:PurChk>
								<s:PurChk controlid="<%=ID_DEL%>">
									<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>" onClick="doCheckDelete('/zifee/yxplanpresnt.do')">
								</s:PurChk>
								<%
								}
								%>
								<s:PurChk controlid="<%=ID_QUY%>">
									<input type="submit" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>" />
								</s:PurChk>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td title="<bean:message bundle="public" key="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
								</td>
								<td>
									<bean:message bundle="yxplanpresnt" key="yxplanid" />
								</td>
								<td>
									<a href="javascript:doOrderby('acctid')"><bean:message bundle="yxplanpresnt" key="acctid" /> </a>
									<s:OrderImg form="/zifee/yxplanpresnt/YxplanpresntForm" field="acctid" />
								</td>
								<td>
									<a href="javascript:doOrderby('presentinterval')"><bean:message bundle="yxplanpresnt" key="presentinterval" />
									</a>
									<s:OrderImg form="/zifee/yxplanpresnt/YxplanpresntForm" field="presentinterval" />
								</td>
								<td>
									<bean:message bundle="yxplanpresnt" key="presentcycles" />
								</td>
								<td>
									<bean:message bundle="yxplanpresnt" key="presentrate" />
								</td>
								<td>
									<bean:message bundle="yxplanpresnt" key="eboxunitid" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/zifee/yxplanpresnt.do?CMD=EDIT" var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.yxplanid}|${item.acctid}|${item.presentinterval}" />
									<c:param name="areacode" value="${areacode}"/>
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.yxplanid}|${item.acctid}|${item.presentinterval}' />" onclick="checkOne();"
											class="table_checkbox">
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out value="${item.yxplanid}" /> </a>
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out value="${item.acctid}" />-<s:Code2Name
												code="${item.acctid}" definition="#ZIFEE-ACCTNAME" /> </a>
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out value="${item.presentinterval}" /> </a>
									</td>
									<td>
										<c:out value="${item.presentcycles}" />
									</td>
									<td>
										<fmt:formatNumber value="${item.presentrate}" pattern="#0.00"/> 
									</td>
									<td>
										<c:out value="${item.eboxunitid}" />
										-
										<s:Code2Name code="${item.eboxunitid}" definition="#EBOXUNIT" />
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
