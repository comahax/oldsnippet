<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="busiwayrel" key="titleList" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	
        	return checkval(window);
        }
		
		function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
			
		function upload(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/reward/busiwayrel/batch.jsp";
		form.submit();
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/busiwayrel.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
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
								<bean:message bundle="busiwayrel" key="titleList" />
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
								<bean:message bundle="busiwayrel" key="opnid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_opnid"/><input type="button" value="..." class="clickbutton"
									onclick="showOpnTree2(this, '_se_opnid' , 'busi')">
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="busiwayrel" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid"
								/><input type="button" value="..." class="clickbutton"
								onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button" name="btnNew2" class="button_2"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_import"/>"
									onClick="goTo('/cms/reward/busiwayrel/upload.do')">

								<input type="button" name="btnNew" class="add"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_new"/>"
									onClick="doNew('/cms/reward/busiwayrel.do')">

								<input type="button" name="btnDelete" class="delete"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_delete"/>"
									onClick="doDelete('/cms/reward/busiwayrel.do')">

								<input type="button" class="query"
									onmouseover="buttonover(this);" onclick="doQuery();"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />
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
									<a href="javascript:doOrderby('opnid')"><bean:message
											bundle="busiwayrel" key="opnid" /> </a>
									<s:OrderImg form="/cms/reward/busiwayrel/BusiwayrelForm"
										field="opnid" />
								</td>
								<td>
									<a href="javascript:doOrderby('opnid')"><bean:message
											bundle="busiwayrel" key="opname" /> </a>
									<s:OrderImg form="/cms/reward/busiwayrel/BusiwayrelForm"
										field="opnid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="busiwayrel" key="nwayid" /> </a>
									<s:OrderImg form="/cms/reward/busiwayrel/BusiwayrelForm"
										field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="busiwayrel" key="wayname" /> </a>
									<s:OrderImg form="/cms/reward/busiwayrel/BusiwayrelForm"
										field="wayid" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">

								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.opnid}|${item.wayid}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										<c:out value="${item.opnid}" />
									</td>
									<td>
										<s:Code2Name code="${item.opnid}" definition="#OPERATION" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
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
