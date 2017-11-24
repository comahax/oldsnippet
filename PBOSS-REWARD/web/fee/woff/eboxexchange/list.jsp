<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<%
	String ID_1 = "EBOXEXCHANFE_NEW";
	String ID_2 = "EBOXEXCHANFE_DET";
	String ID_3 = "EBOXEXCHANFE_EDIT";
%>
<html>
	<head>
		<title><bean:message bundle="eboxexchange" key="title" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			
			addfield('_se_newprodid', '<bean:message bundle="eboxexchange" key="newprodid"/>', 'c', true, 32);
            addfield('_se_oldprodid', '<bean:message bundle="eboxexchange" key="oldprodid"/>', 'c', true, 32);
            addfield('_se_neweboxunitid', '<bean:message bundle="eboxexchange" key="neweboxunitid"/>', 'l', true, 14);
            addfield('_se_oldeboxunitid', '<bean:message bundle="eboxexchange" key="oldeboxunitid"/>', 'l', true, 14);
			addfield('_ne_region', '<bean:message bundle="eboxexchange" key="region"/>', 'i', true, 5); 
				
            return checkval(window);
        }
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/fee/woff/eboxexchange/eboxexchange.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="eboxexchange" key="title" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">	
				<table class="form_table">
					<tr>
               		 <td class="form_table_right">
						<bean:message bundle="eboxexchange" key="newprodid" />
						:
					</td>
					<td class="form_table_left">
						<s:zoom definition="#PRODUCT" property="_se_newprodid" styleClass="form_input_1x"  condition="mainprod:${1};"  />
					</td>
					<td class="form_table_right">
						<bean:message bundle="eboxexchange" key="oldprodid" />
						:
					</td>
					<td class="form_table_left">
						<s:zoom definition="#PRODUCT" property="_se_oldprodid" styleClass="form_input_1x"  condition="mainprod:${1};" />
					</td>
           		</tr> 
            	<tr>
                <td class="form_table_right">
					<bean:message bundle="eboxexchange" key="neweboxunitid" />
					:
					</td>
					<td class="form_table_left">
						<s:eboxacct type="EBOXUNIT" property="_se_neweboxunitid"  readonly="false" styleClass="form_input_1x" />
					</td>
					<td class="form_table_right">
						<bean:message bundle="eboxexchange" key="oldeboxunitid" />
						:
					</td>
					<td class="form_table_left">
						<s:eboxacct type="EBOXUNIT" property="_se_oldeboxunitid" readonly="false" styleClass="form_input_1x" />
					</td>
            	</tr> 
            	<tr>
                <td class="form_table_right">
					<bean:message bundle="eboxexchange" key="region" />
					:
					</td>
					<td class="form_table_left">
						<s:zoom definition="#CITYIDNUM2NMAME" property="_ne_region" styleClass="form_input_1x" />
					</td>
					<td class="form_table_right"/>
					<td class="form_table_left"/>
            	</tr> 
				</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
							<input type="button" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
							
							<s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
								<input type="button" name="btnNew" class="add" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/fee/woff/eboxexchange/eboxexchange.do')">
							</s:PurChk2>		
							<s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
								<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_delete"/>"
									onClick="doDelete('/fee/woff/eboxexchange/eboxexchange.do')">
							</s:PurChk2>		
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
									<a href="javascript:doOrderby('newprodid')"><bean:message bundle="eboxexchange" key="newprodid" /></a>
									<s:OrderImg form="/fee/woff/eboxexchange/EboxexChangeForm" field="newprodid" />
								</td>
								<td>
									<a href="javascript:doOrderby('neweboxunitid')"><bean:message bundle="eboxexchange" key="neweboxunitid" /></a>
									<s:OrderImg form="/fee/woff/eboxexchange/EboxexChangeForm" field="neweboxunitid" />
								</td>
								<td>
									<a href="javascript:doOrderby('oldprodid')"><bean:message bundle="eboxexchange" key="oldprodid" /></a>
									<s:OrderImg form="/fee/woff/eboxexchange/EboxexChangeForm" field="oldprodid" />
								</td>
								<td>
									<a href="javascript:doOrderby('oldeboxunitid')"><bean:message bundle="eboxexchange" key="oldeboxunitid" /></a>
									<s:OrderImg form="/fee/woff/eboxexchange/EboxexChangeForm" field="oldeboxunitid" />
								</td>
								<td>
									<a href="javascript:doOrderby('region')"><bean:message bundle="eboxexchange" key="region" /></a>
									<s:OrderImg form="/fee/woff/eboxexchange/EboxexChangeForm" field="region" />
								</td>
								<td>
									<a href="javascript:doOrderby('begindate')"><bean:message bundle="eboxexchange" key="begindate" /></a>
									<s:OrderImg form="/fee/woff/eboxexchange/EboxexChangeForm" field="begindate" />
								</td>
								<td>
									<a href="javascript:doOrderby('enddate')"><bean:message bundle="eboxexchange" key="enddate" /></a>
									<s:OrderImg form="/fee/woff/eboxexchange/EboxexChangeForm" field="enddate" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/fee/woff/eboxexchange/eboxexchange.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.neweboxunitid}|${item.newprodid}|${item.oldeboxunitid}|${item.oldprodid}|${item.region}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem" value="<c:out value='${item.neweboxunitid}|${item.newprodid}|${item.oldeboxunitid}|${item.oldprodid}|${item.oldprodid}' />" onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
									<s:PurChk2 controlid="<%=ID_3%>" disableChild="true">
										<a href='<c:out value="${urlContent}"/>'><s:Code2Name code="${item.newprodid}" definition="#PRODUCT" /></a>
									</s:PurChk2>
									</td>
									<td>
										<s:Code2Name code="${item.neweboxunitid}" definition="#EBOXUNIT" />
									</td>
									<td>
										<s:Code2Name code="${item.oldprodid}" definition="#PRODUCT" />
									</td>
									<td>
										<s:Code2Name code="${item.oldeboxunitid}" definition="#EBOXUNIT" />
									</td>
									<td>
										<s:Code2Name code="${item.region}" definition="#CITYIDNUM2NMAME" />
									</td>
									<td>
										<fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.begindate}" />
									</td>
									<td>
										<fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.enddate}" />
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
