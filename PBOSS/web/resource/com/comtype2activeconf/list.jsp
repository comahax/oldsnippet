<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "COMTYPE2ACTIVE";
%>
<%-- 商品类型与是否激活属性对应关系管理 --%>
<html>
	<head>
		<title><bean:message bundle="com" key="comtype2activeconf" /></title>
	<script language="JavaScript">
		function ignoreSpaces(string) {
			var temp = "";
			string = '' + string;
			splitstring = string.split(" "); //双引号之间是个空格；
			for(i = 0; i < splitstring.length; i++)
			temp += splitstring[i];
			return temp;
		}
        function ev_check() {
            return checkval(window);
        }
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	</head>

	<body onload="loadforiframe()">
		<div class="table_container">
			<html:form action="/resmanage/com/comtype2activeconf.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="com" key="comtype2activeconf" />
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
								<bean:message bundle="com" key="comtype" />
							</td>
							<td class="form_table_left">
								<html:select property="_ne_comtype">
									<option value=""></option>
									<s:Options definition='$IM_COMTYPE' nameOnly="false" />
								</html:select>
							</td>

							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="com" key="activeconfig" />
							</td>
							<td class="form_table_left">
								<html:select property="_ne_activeconfig" >
									<html:option value="0">0 否(不可配置)</html:option>
								    <html:option value="1">1 是(不可配置)</html:option>
								    <s:FramePurChk pageid="<%=ID_1%>">
								    	<html:option value="2">2 是(可配置)</html:option>
								    	<html:option value="3">3 否(可配置)</html:option>
								    </s:FramePurChk>
								</html:select>
							</td>
						</tr>
					</table>
				</div>
				
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
							
									<input type="button" name="btnNew" class="add" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNew('/resmanage/com/comtype2activeconf.do?CMD=NEW')">
					
									<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/resmanage/com/comtype2activeconf.do')">
					
									<input type="submit" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery('/resmanage/com/comtype2activeconf.do')">
						
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
									<bean:message bundle="com" key="comtype" />
								</td>

								<td>
									<bean:message bundle="com" key="activeconfig" />
								</td>

								<td>
                                    <bean:message bundle="com" key="oprcode" />
								</td>
							</tr>


							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/resmanage/com/comtype2activeconf.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.comtype}" />
								</c:url>

								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem" value="<c:out value='${item.comtype}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>

									<td>
										<a href='<c:out value="${urlContent}"/>'> <c:out value="${item.comtype}" /> 
										<s:Code2Name code='${item.comtype}' definition='$IM_COMTYPE' />
										</a>
									</td>

									<td>
										<c:out value="${item.activeconfig}" />
										<s:Code2Name code='${item.activeconfig}' definition='#COMTYPE2ACTIVECONF' />
									</td>

									<td>
										<c:out value="${item.oprcode}" />
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
