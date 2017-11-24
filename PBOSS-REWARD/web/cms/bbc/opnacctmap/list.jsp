<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%
	String ID_1 = "4D1A1ABT1";
    String ID_2 = "4D1A1ABT2";
    String ID_3 = "4D1A1ABT3";
%>
<html>
	<head>
		<title><bean:message bundle="opnacctmap" key="titleList" /></title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_opnid', '<bean:message bundle="opnacctmap" key="opnid"/>', 'c', true, '18');
            addfield('_sk_acctid', '<bean:message bundle="opnacctmap" key="acctid"/>', 'c', true, '14');
            return checkval(window);
        }
		 function getAcctId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/opnacctmap.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		 function showOpnname(){
		 	ajaxAnywhere.submitByURL('/cms/bbc/opnacctmap.do?CMD=LIST');
		 }
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/bbc/opnacctmap.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
								<bean:message bundle="opnacctmap" key="titleList" />
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
				<aa:zone name="showopnname">
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="opnacctmap" key="opnid" />
								:
							</td>
							<td class="form_table_left">
							    <html:text  property="_sk_opnid" styleClass="form_input_1x" />
							    <input type="button" value="..." class="clickbutton"
										onclick="_sk_opnid.value=getOpnId();showOpnname();">
                 		    </td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="opnacctmap" key="opnname" />
								:
							</td>
							<td class="form_table_left">
									<div>
										<html:text styleClass="form_input_1x" property="_sk_opnname" readonly="true" />
									</div>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="opnacctmap" key="acctid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_acctid" />
								<input type="button" value="..." class="clickbutton"
								onclick="_sk_acctid.value=getAcctId();showOpnname();">
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="opnacctmap" key="acctname" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_acctname" readonly="true" />
							</td>
						</tr>
					</table>
				</div>
				</aa:zone>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<s:PurChk controlid="<%=ID_1%>">
		                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/bbc/opnacctmap.do')">
    	                        </s:PurChk>
    	                        <s:PurChk controlid="<%=ID_2%>">
		                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/bbc/opnacctmap.do')">
		                        </s:PurChk>
		                        <s:PurChk controlid="<%=ID_3%>">
		                    	    <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
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
			                 <td nowrap title="<bean:message bundle="public" key="list_title_select"/>">
			                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
			                </td>
			                 <td nowrap>
			                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="opnacctmap" key="opnid"/></a>
			                    <s:OrderImg form="/cms/bbc/opnacctmap/OpnacctmapForm" field="opnid"/>
			                </td>
			                 <td nowrap>
			                    <a href="javascript:doOrderby('opnname')"><bean:message bundle="opnacctmap" key="opnname"/></a>
			                    <s:OrderImg form="/cms/bbc/opnacctmap/OpnacctmapForm" field="opnname"/>
			                </td>
			                <td nowrap>
			                    <a href="javascript:doOrderby('acctid')"><bean:message bundle="opnacctmap" key="acctid"/></a>
			                    <s:OrderImg form="/cms/bbc/opnacctmap/OpnacctmapForm" field="acctid"/>
			                </td>
			                <td nowrap>
			                    <a href="javascript:doOrderby('acctname')"><bean:message bundle="opnacctmap" key="acctname"/></a>
			                    <s:OrderImg form="/cms/bbc/opnacctmap/OpnacctmapForm" field="acctname"/>
			                </td>
			            </tr>
			            <c:forEach var="item" items="${requestScope.LIST.datas}">
			                 <c:url value="/cms/bbc/opnacctmap.do?CMD=EDIT" var="urlContent">
			                     <%//this param name must "PK" %>
			                     <c:param name="PK" value="${item.opnid}|${item.acctid}"/>
			                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
			                 </c:url>
			                 <tr class="table_style_content" align="center">
			                     <td>
			                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}|${item.acctid}' />"
			                                onclick="checkOne();" class="table_checkbox">
			                     </td>
			                     <td>
			                     	<c:out value="${item.opnid}"/>
			                     </td>
			                     <td><c:out value="${item.opnname}"/></td>
			 					 <td><c:out value="${item.acctid}"/></td>
			                     <td><s:Code2Name definition="#ACCTNAME" code="${item.acctid}" dbFlag="DB_COMMON"/></td>
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
