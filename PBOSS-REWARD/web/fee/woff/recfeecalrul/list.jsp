<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A5E" />
</jsp:include>
<%
			String ID_1 = "4D6F1A5EBT1";
			String ID_2 = "4D6F1A5EBT2";
			String ID_3 = "4D6F1A5EBT3";

%>
<html>
	<head>
		<title><bean:message bundle="RecfeeCalRul" key="titleList" /></title>		
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function openCreditExplain(){
        	var url;
			url ="<%=contextPath%>/fee/credit/credstatechg/creditexplain.jsp";
			window.open(url,'<bean:message bundle="credstatechg" key="explain"/>',"width=600px, height=390px, status=no, scrollbars=yes, resizable=yes");
        }        
    </script>
</head>

	<body onload="document.formList._sk_rulecondition.focus()">
		<div class="table_container">
		<html:form action="/fee/woff/recfeecalrule.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

<div class="table_div">
<table class="top_table">
     <tr>
      <td>
       <bean:message bundle="RecfeeCalRul" key="title" />
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
							<bean:message bundle="RecfeeCalRul" key="rulecondition" />
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_sk_rulecondition"></html:text>
						</td>
						<td width="126" height="20" align="right" class="form_table_right">
							<bean:message bundle="RecfeeCalRul" key="rulecontent" />
							<%//change%>
							:
						</td>
						<td class="form_table_left">
							<html:text styleClass="form_input_1x" property="_sk_rulecontent"></html:text>
							<%//change%>
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
						
					    <tr>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="RecfeeCalRul" key="paymodetype" />
								<%
								//change
								%>
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_paymodetype">
									<html:option value=""><bean:message bundle="WoffRule" key="selectAll" /></html:option>
									<s:Options definition="$IB_PAYMODETYPE" />
								</html:select>						
								</td>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="RecfeeCalRul" key="paytype" />
								:
							</td>
							<td class="form_table_left">								
								<html:select property="_ne_paytype">
									<html:option value=""><bean:message bundle="WoffRule" key="selectAll" /></html:option>
									<s:Options definition="#RECFEECALRUL_PATYPE" />
								</html:select>							
							</td>
						</tr>										
				</table>
			</div>
	
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/recfeecalrule.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/recfeecalrule.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
		                 	<input type="button" class="query" onmouseover="buttonover(this);"
		                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();"/>
                        </s:PurChk>
                        <input type="button" class="button_6" onmouseover="buttonover(this);" onmouseout="buttonout(this);" 
								onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="credstatechg" 
								key="explain"/>" onclick="openCreditExplain();"/>
						</td>
						
					</tr>
				</table>
			</div>


			<div class="table_div">
			<div class="table_LongTable">
				<table class="table_style" ID="Table2">
				<THEAD>
					<tr class="table_style_head">
						<td    title="<bean:message bundle="public" key="list_title_select"/>">
							<input type="checkbox" class="table_checkbox" name="allbox" onclick="checkAll();">
						</td>
						<td >
							<a href="javascript:doOrderby('ruleid')"><bean:message bundle="RecfeeCalRul" key="ruleid" /> </a>
							<s:OrderImg form="/fee/woff/RecfeeCalRulForm" field="ruleid" />
						</td>
						<td >
							<bean:message bundle="RecfeeCalRul" key="rulepri" />
						</td>
						<td   >
							<bean:message bundle="RecfeeCalRul" key="begintime" />
						</td>						
						<td   >
							<bean:message bundle="RecfeeCalRul" key="endtime" />
						</td>						
						<td >
							<bean:message bundle="RecfeeCalRul" key="paymodetype" />
						</td>
						<td >
							<bean:message bundle="RecfeeCalRul" key="paytype" />
						</td>
						<td   >
							<bean:message bundle="RecfeeCalRul" key="rulecondition" />
						</td>
						<td   >
							<bean:message bundle="RecfeeCalRul" key="rulecontent" />
						</td>
 											
					</tr>
					</THEAD>
					<c:forEach var="item" items="${requestScope.LIST.datas}">
						<c:url value="/fee/woff/recfeecalrule.do?CMD=EDIT" var="urlContent">
							<c:param name="PK" value="${item.ruleid}" />
						</c:url>
						<tr class="table_style_content"  >
							<td>
								<input type="checkbox" class="table_checkbox" name="_selectitem" value="<c:out value='${item.ruleid}'/>" onclick="checkOne(this);">
							</td>
							<td>
								<a href='<c:out value="${urlContent}"/>&PK=<c:out value='${item.ruleid}'/>'><c:out value='${item.ruleid}'/></a>
							</td>
							<td>
								<c:out value="${item.rulepri}" />
							</td>						
							<td>
								<c:out value="${item.strBegintime}" />
							</td>							
							<td>
								<c:out value="${item.strEndtime}" />
							</td>
							<td>
								<s:Code2Name code="${item.paymodetype}" definition="$IB_PAYMODETYPE" />
							</td>														
							<td>
								<s:Code2Name code="${item.paytype}" definition="#RECFEECALRUL_PATYPE" />
							</td>
							<td>
								<c:out value="${item.rulecondition}" />
							</td>
							<td>
								<c:out value="${item.rulecontent}" />
							</td>							
 
						</tr>
					</c:forEach>
				</table>
				</div>
			</div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>

		</html:form>
		</div>
	</body>
</html>
