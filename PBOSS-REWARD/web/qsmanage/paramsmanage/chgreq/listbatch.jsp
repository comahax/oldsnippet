<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B7G1A4D" />
</jsp:include>


<html:html>
<head>
	<title><bean:message bundle="accmon" key="title" /></title>
	<script language="JavaScript" type="text/JavaScript">
	
	
	function ev_check() {
        return checkval(window);
    }
    function doListbatch(condition){
    	var url=contextPath + "/qsmanage/paramsmanage/chgreq.do?CMD=SHOWBATCHDETA" + condition;
    	window.showModalDialog(url,"","dialogWidth:610px; dialogHeight:290px; status:no;resizable:yes;");
    }
    
</script>
</head>
<body onload="loadforiframe()">
	<div class="table_container">
		<html:form action="/qsmanage/paramsmanage/chgreq.do?CMD=SHOWBATCH" styleId="formList"
			method="post" onsubmit="return ev_check();">
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<input type="hidden" name="_rowcount"
				value="<c:out value='${requestScope.LIST.rowCount}' />">

			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="chgreq" key="title" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table width="100%" class="error_text">
					<s:Msg />
					<html:errors />
				</table>
			</div>
			<div class="table_div">
				<div class="table_LongTable">
					<table class="table_style">
						<THEAD>
							<tr class="table_style_head">
								<td>
									<bean:message bundle="chgreq" key="tabname" /> 
								</td>
								<td >
									<bean:message bundle="chgreq" key="oprtype" /> 
								</td>
								<td>
									<bean:message bundle="chgreq" key="count" /> 
								</td>
								<td>
								</td>
								</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td>
										<s:Code2Name definition="#QS_TABLENAME" code="${item.tabcode}" />
									</td>
									<td>
										<s:Code2Name definition="$QSCS_OPRTYPE" code="${item.oprtype}" />
									</td>
									<td>
										<c:out value="${item.count}" />
									</td>
									<td onclick="doListbatch(this.condition);" condition="<c:out value="&tabcode=${item.tabcode}&matchid=${item.matchid}"/> " style="cursor:hand;">
										<font color="blue"><bean:message bundle="chgreq" key="deta"/> </font>
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
</html:html>
