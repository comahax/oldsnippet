<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
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
		<title><bean:message bundle="jfopnmap" key="titleList" /></title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="jfopnmap" key="opnid"/>', 'c', true, '18');
            addfield('_se_entid', '<bean:message bundle="jfopnmap" key="entid"/>', 'c', true, '12');
            addfield('_se_busiid', '<bean:message bundle="jfopnmap" key="busiid"/>', 'c', true, '12');
            addfield('_se_cityid', '<bean:message bundle="jfopnmap" key="cityid"/>', 'c', true, '4');
            return checkval(window);
        }
        function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/bbc/jfopnmap.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
								<bean:message bundle="jfopnmap" key="titleList" />
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
				<!--##################################查询条件##################################################-->
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="jfopnmap" key="opnid" />
								:
							</td>
							<td class="form_table_left">
							    <html:text  property="_se_opnid" styleClass="form_input_1x" />
							    <input type="button" value="..." class="clickbutton"
										onclick="_se_opnid.value=getOpnId();">
                 		    </td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="jfopnmap" key="cityid" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_cityid">
									<option />
										<s:Options definition="$region" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="jfopnmap" key="entid" />
								:
							</td>
							<td class="form_table_left">
								<html:text  property="_se_entid" styleClass="form_input_1x" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="jfopnmap" key="busiid" />
								:
							</td>
							<td class="form_table_left">
								<html:text  property="_se_busiid" styleClass="form_input_1x" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
		                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/bbc/jfopnmap.do')">
		                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/bbc/jfopnmap.do')">
		                    	    <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_search"/>" />
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
			                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="jfopnmap" key="opnid"/></a>
			                    <s:OrderImg form="/cms/bbc/jfopnmap/JfopnmapForm" field="opnid"/>
			                </td>
			                 <td nowrap>
			                    <a href="javascript:doOrderby('entid')"><bean:message bundle="jfopnmap" key="entid"/></a>
			                    <s:OrderImg form="/cms/bbc/jfopnmap/JfopnmapForm" field="entid"/>
			                </td>
			                <td nowrap>
			                    <a href="javascript:doOrderby('busiid')"><bean:message bundle="jfopnmap" key="busiid"/></a>
			                    <s:OrderImg form="/cms/bbc/jfopnmap/JfopnmapForm" field="busiid"/>
			                </td>
			                <td nowrap>
			                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="jfopnmap" key="cityid"/></a>
			                    <s:OrderImg form="/cms/bbc/jfopnmap/JfopnmapForm" field="cityid"/>
			                </td>
			            </tr>
			            <c:forEach var="item" items="${requestScope.LIST.datas}">
			                 <c:url value="/cms/bbc/jfopnmap.do?CMD=EDIT" var="urlContent">
			                     <%//this param name must "PK" %>
			                     <c:param name="PK" value="${item.entid}|${item.busiid}|${item.opnid}"/>
			                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
			                 </c:url>
			                 <tr class="table_style_content" align="center">
			                     <td>
			                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.entid}|${item.busiid}|${item.opnid}' />"
			                                onclick="checkOne();" class="table_checkbox">
			                     </td>
			                     <td><c:out value="${item.opnid}"/></td>
			                     <td>
			                     	<a href='<c:out value="${urlContent}"/>'><c:out value="${item.entid}"/></a>
			                     </td>
			                     <td>
			                     	<a href='<c:out value="${urlContent}"/>'><c:out value="${item.busiid}"/></a>
			                     </td>
			                     <td><s:Code2Name code="${item.cityid}" definition="$region" /></td>
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
