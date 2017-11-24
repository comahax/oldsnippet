<%@ page language="java" contentType="text/html;charset=GBK"%>
<!--Added by GeAiping on 08-Oct-2006-->
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="4D4D2B1A" />
</jsp:include>
<!--Added End-->
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="forwardpnwoff" key="title" /></title>
		<script language="JavaScript" type="text/JavaScript">

        function ev_check() {
            addfield('servnumber', '<bean:message bundle="subscriber" key="servnumber"/>', 'l', false, 20);
            return checkval(window);
        }
         function doSearch() {
          if(ev_check()){
			var strUrl;
			var arg = new Array(); 
			arg.mobile_no = Trim(document.all.servnumber.value);
			strUrl =contextPath+"/commons/subscriber.do?CMD=SELECT&mobileno="+arg.mobile_no;			
			var hWnd = window.showModalDialog(strUrl,arg,"dialogWidth=35; dialogHeight=19; status=no");
			if(hWnd != null && hWnd != ""){
			    dataStr = hWnd.split("|");
				document.formList.eboxid.value=dataStr[4];
				document.formList.subsid.value=dataStr[0];
			}else{
			     return;
			}
			   document.formList._pageno.value = '1';
	           if(document.formList.onsubmit == null || document.formList.onsubmit())
	           document.formList.submit();			
		}
	}
	 function clickURL(url,cyc){
	   truthBeTold = window.confirm("<bean:message bundle="forwardpnwoff" key="delmsg"/>"+cyc+"<bean:message bundle="forwardpnwoff" key="delmsg1"/>");
          if (!truthBeTold) return false;
	      document.formList.action = url;
          document.formList.submit(); 
	 }
    </script>
	</head>

	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/fee/woff/forwardpnwoff.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="eboxid" />
				<html:hidden property="subsid" />
				
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="forwardpnwoff" key="title" />
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
								<bean:message bundle="subscriber" key="servnumber" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="servnumber"></html:text>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
									<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" onClick="doSearch();" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<bean:message bundle="subscriber" key="acctid" />
								</td>					
								<td>
									<a href="javascript:doOrderby('billcyc')"><bean:message bundle="forwardpnwoff" key="billcyc" /></a>
									<s:OrderImg form="/fee/woff/forwardpnwoff/ForwardpnWoffForm" field="billcyc" />
								</td>
								<td>
									<bean:message bundle="forwardpnwoff" key="amt" />
								</td>								
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/fee/woff/forwardpnwoff.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.acctid}|${item.billcyc}|" />
								</c:url>
								<tr class="table_style_content" align="center" onclick="clickURL('<c:out value="${urlContent}"/>','<c:out value="${item.billcyc}" />')">										
									<td>
										<c:out value="${item.acctid}" />
									</td>
									<td>
										<c:out value="${item.billcyc}" />
									</td>
									<td>
										<fmt:formatNumber type="currency" value="${item.amt}" />
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
