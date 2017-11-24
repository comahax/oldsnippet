<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A6F" />
</jsp:include>
<%
	String ID_1 = "4D6F1A6FBT1";
	String ID_2 = "4D6F1A6FBT2";
	String ID_3 = "4D6F1A6FBT3";
	String ID_4 = "WOFFRULE_NEW";
	String ID_5 = "WOFFRULE_DET";
	String ID_6 = "WOFFRULE_EDIT";
%>
<html>
	<head>
		<title><bean:message bundle="WoffRule" key="titleList" /></title>
		<script language="JavaScript">
        function ev_check() {
        <% //change%>
            addfield('_ne_acctid', '<bean:message bundle="WoffRule" key="AcctID"/>', 'c', true, 20);
        <% //change%>
            addfield('_ne_eboxunitid', '<bean:message bundle="WoffRule" key="EBoxUnitID"/>', 'c', true, 20);
            return checkval(window);
        }
        function openCreditExplain(){
        	var url;
			url ="<%=contextPath%>/fee/credit/credstatechg/creditexplain.jsp";
			window.open(url,'<bean:message bundle="credstatechg" key="explain"/>',"width=600px, height=390px, status=no, scrollbars=yes, resizable=yes");
        }
    </script>
	</head>

<body>
	<div class="table_container">
		<html:form action="/fee/woff/woffrule.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

<div class="table_div">
<table class="top_table">
     <tr>
      <td>
      <bean:message bundle="WoffRule" key="title" />
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
							<bean:message bundle="WoffRule" key="AcctName" />
							<%
							//change
							%>
							:
						</td>
						<td class="form_table_left">
							 <s:zoom definition="#WOFF-ACCT" property="_ne_acctid" styleClass="form_input_1x"/>
						</td>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="WoffRule" key="EBoxUnitName" />
							:
						</td>
						<td class="form_table_left">
							<s:zoom definition="#EBOXUNIT" property="_ne_eboxunitid" styleClass="form_input_1x"/>
						</td>
					</tr>

					<tr>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="fee" key="begintimeBiggerThen" />
							<%
							//change
							%>
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_dnl_begintime" onclick="this.value=selectDatetime()" />

						</td>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="fee" key="endtimesmallerThen" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_dnm_endtime" onclick="this.value=selectDatetime()" />
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
                         <s:PurChk2 controlid="<%=ID_4%>" disableChild="true">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/woffrule.do')">
                        </s:PurChk2>
                        <s:PurChk2 controlid="<%=ID_5%>" disableChild="true">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/woffrule.do')">
                        </s:PurChk2>
	                        <s:PurChk controlid="<%=ID_3%>">
			                 	<input type="button" class="query" onmouseover="buttonover(this);"
			                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();"/>
			                 </s:PurChk>
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
			<div class="table_LongTable">
				<table class="table_style" ID="Table2">
					<THEAD>
						<tr class="table_style_head">
							<td   title="<bean:message bundle="public" key="list_title_select"/>">
								<input type="checkbox" class="table_checkbox" name="allbox" onclick="checkAll();">
							</td>
							<td >
								<a href="javascript:doOrderby('acctid')"><bean:message bundle="WoffRule" key="AcctName" /> </a>
								<s:OrderImg form="/fee/writeoff/IbRuWoffruleForm" field="acctid" />
							</td>
							<td >
								<a href="javascript:doOrderby('eboxunitid')"><bean:message bundle="WoffRule" key="EBoxUnitName" /> </a>
								<s:OrderImg form="/fee/writeoff/IbRuWoffruleForm" field="eboxunitid" />
							</td>
							<td >
								<a href="javascript:doOrderby('type')"><bean:message bundle="WoffRule" key="Type" /> </a>
								<s:OrderImg form="/fee/writeoff/IbRuWoffruleForm" field="type" />							
							</td>
							<td   >
								<bean:message bundle="WoffRule" key="BeginTime" />
							</td>
							<td   >
								<bean:message bundle="WoffRule" key="EndTime" />
							</td>
							<td >
								<bean:message bundle="WoffRule" key="Memo" />
							</td>
							<td >
								<bean:message bundle="WoffRule" key="Pri" />
							</td>
 
						</tr>
					<THEAD>
					<TBODY>
						<c:forEach var="item" items="${requestScope.LIST.datas}">
							<c:url value="/fee/woff/woffrule.do?CMD=EDIT" var="urlContent">
							</c:url>
							<tr class="table_style_content" >
								<td>
									<input type="checkbox" class="table_checkbox" name="_selectitem"
										value="<c:out value='${item.acctid}|${item.eboxunitid}'/>" onclick="checkOne(this);">
								</td>
								<td>
								<s:PurChk2 controlid="<%=ID_6%>" disableChild="true">
									<a href='<c:out value="${urlContent}"/>&PK=<c:out value='${item.acctid}|${item.eboxunitid}'/>'> 
									<s:Code2Name code="${item.acctid}" definition="#ACCTNAME" /> </a>
								</s:PurChk2>
								</td>
								<td>
									<s:Code2Name code="${item.eboxunitid}" definition="#EBOXUNIT" />
								</td>
								<td>
									<s:Code2Name code="${item.type}" definition="#WOFF_RUTLTYPE" />
								</td>
								<td>
									<c:out value="${item.strBegintime}" />
								</td>
								<td>
									<c:out value="${item.strEndtime}" />
								</td>
								<td>
									<c:out value="${item.memo}" />
								</td>
								<td>
									<c:out value="${item.pri}" />
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
