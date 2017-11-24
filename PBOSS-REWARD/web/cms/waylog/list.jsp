<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A6FBT1" />
</jsp:include>
<html>
	<head>
		<title><bean:message bundle="waylog" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
            return checkval(window);
        }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/waylog.do?CMD=LIST" styleId="formList"
				method="post" onsubmit="return ev_check();">
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
								<bean:message bundle="waylog" key="titleList" />
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
								<bean:message bundle="waylog" key="optime" />
								&gt;=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_optime"
									onclick="this.value=selectDatetime();" readonly="true" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="waylog" key="optime" />
								&lt;=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_optime"
									onclick="this.value=selectDatetime();" readonly="true" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="waylog" key="oprcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="waylog" key="oprtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_oprtype">
									<option></option>
									<s:Options definition="$OPRTYPE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="waylog" key="success" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_success">
									<option></option>
									<s:Options definition="$OPRRESULT" />
								</html:select>
							</td>
							<td width="80" height="20" align="right" class="form_table_right">
								&nbsp;
							</td>
							<td class="form_table_left">
								&nbsp;
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button" class="query" onclick="doQuery();" 
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />

							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<a href="javascript:doOrderby('logid')"><bean:message
											bundle="waylog" key="logid" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="logid" />
								</td>
								<td>
									<a href="javascript:doOrderby('optime')"><bean:message
											bundle="waylog" key="optime" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="optime" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprcode')"><bean:message
											bundle="waylog" key="oprcode" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="oprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprtype')"><bean:message
											bundle="waylog" key="oprtype" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="oprtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('success')"><bean:message
											bundle="waylog" key="success" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="success" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="waylog" key="wayid" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayname')"><bean:message
											bundle="waylog" key="wayname" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="wayname" />
								</td>
								<td>
									<a href="javascript:doOrderby('waytype')"><bean:message
											bundle="waylog" key="waytype" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="waytype" />
								</td>
								<td>
									<a href="javascript:doOrderby('waysubtype')"><bean:message
											bundle="waylog" key="waysubtype" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="waysubtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('custtype')"><bean:message
											bundle="waylog" key="custtype" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="custtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('upperwayid')"><bean:message
											bundle="waylog" key="upperwayid" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="upperwayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('countyid')"><bean:message
											bundle="waylog" key="countyid" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="countyid" />
								</td>
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="waylog" key="cityid" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('centerid')"><bean:message
											bundle="waylog" key="centerid" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="centerid" />
								</td>
								<td>
									<a href="javascript:doOrderby('citylevel')"><bean:message
											bundle="waylog" key="citylevel" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="citylevel" />
								</td>
								<td>
									<a href="javascript:doOrderby('waylevel')"><bean:message
											bundle="waylog" key="waylevel" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="waylevel" />
								</td>
								<td>
									<a href="javascript:doOrderby('bchlevel')"><bean:message
											bundle="waylog" key="bchlevel" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="bchlevel" />
								</td>
								<td>
									<a href="javascript:doOrderby('function')"><bean:message
											bundle="waylog" key="function" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="function" />
								</td>
								<td>
									<a href="javascript:doOrderby('miscode')"><bean:message
											bundle="waylog" key="miscode" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="miscode" />
								</td>
								<td>
									<a href="javascript:doOrderby('waystate')"><bean:message
											bundle="waylog" key="waystate" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="waystate" />
								</td>
								<td>
									<a href="javascript:doOrderby('isshare')"><bean:message
											bundle="Way" key="isshare" />
									</a>
									<s:OrderImg form="/cms/waylog/waylogForm" field="isshare" />
								</td>

								<td>
									<bean:message bundle="Way" key="shortname" />
								</td>
								<td>
									<bean:message bundle="Way" key="svbrchcode" />
								</td>
								<td>
									<bean:message bundle="Way" key="cooperator2" />
								</td>
								<td>
									<bean:message bundle="Way" key="svccode" />
								</td>
								<td>
									<bean:message bundle="Way" key="mareacode" />
								</td>
								<td>
									<bean:message bundle="Way" key="buztypecode" />
								</td>
								<td>
									<bean:message bundle="Way" key="adtypecode" />
								</td>
								<td>
									<bean:message bundle="Way" key="address" />
								</td>
								<td>
									<bean:message bundle="Way" key="latitude" />
								</td>
								<td>
									<bean:message bundle="Way" key="longtitude" />
								</td>
								<td>
									<bean:message bundle="waylog" key="prtsource" />
								</td>
								<td>
									<bean:message bundle="waylog" key="isconnected" />
								</td>
								<td>
									<bean:message bundle="waylog" key="connecttype" />
								</td>
								<td>
									<bean:message bundle="waylog" key="runmode" />
								</td>
								<td>
									<bean:message bundle="waylog" key="iscoreway" />
								</td>
								<td>
									<bean:message bundle="waylog" key="starlevel" />
								</td>
								<td>
									<bean:message bundle="waylog" key="pt" />
								</td>
								<td>
									<bean:message bundle="waylog" key="chainhead" />
								</td>
								<td>
									<bean:message bundle="waylog" key="signstatus" />
								</td>
								<td>
									<bean:message bundle="waylog" key="empnumber" />
								</td>
								<td>
									<bean:message bundle="waylog" key="magnumber" />
								</td>
								<td>
									<bean:message bundle="waylog" key="terminumber" />
								</td>
								<td>
									<bean:message bundle="waylog" key="updatedate" />
								</td>
								<td>
									<bean:message bundle="waylog" key="isstraitprd" />
								</td>
								<td>
									<bean:message bundle="waylog" key="taxtype" />
								</td>

							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/waylog.do?CMD=EDIT" var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.logid}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<c:out value="${item.logid}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.optime}" />
									</td>
									<td>
										<c:out value="${item.oprcode}" />
									</td>
									<td>
										<s:Code2Name code="${item.oprtype}" definition="$OPRTYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.success}" definition="$OPRRESULT" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<c:out value="${item.wayname}" />
									</td>
									<td>
										<s:Code2Name code="${item.waytype}" definition="#WAYTYPE" />
									</td>
									<td>
										<c:out value="${item.waysubtype}" />
									</td>
									<td>
										<c:out value="${item.custtype}" />
									</td>
									<td>
										<c:out value="${item.upperwayid}" />
									</td>
									<td>
										<s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" />
									</td>
									<td>
										<s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY" />
									</td>
									<td>
										<c:out value="${item.centerid}" />
									</td>
									<td>
										<s:Code2Name code="${item.citylevel}"
											definition="$CH_CITYLEVEL" />
									</td>
									<td>
										<c:out value="${item.waylevel}" />
									</td>
									<td>
										<c:out value="${item.bchlevel}" />
									</td>
									<td>
										<c:out value="${item.function}" />
									</td>
									<td>
										<c:out value="${item.miscode}" />
									</td>
									<td>
										<s:Code2Name code="${item.waystate}"
											definition="$CH_VALIDFLAG" />
									</td>
									<td>
										<s:Code2Name code="${item.isshare}"
											definition="$CH_DSTISKEYSTEP" />
									</td>

									<td>
										<c:out value="${item.shortname}" />
									</td>
									<td>
										<s:Code2Name code="${item.svbrchcode}"
											definition="$CH_SVBRCHTYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.cooperator}"
											definition="$CH_COOPERATOR" />
									</td>
									<td>
										<c:out value="${item.svccode}" />
									</td>
									<td>
										<c:out value="${item.mareacode}" />
									</td>
									<td>
										<s:Code2Name code="${item.buztypecode}"
											definition="$CH_BUZTYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.adtypecode}" definition="$CH_ADTYPE" />
									</td>
									<td>
										<c:out value="${item.address}" />
									</td>
									<td>
										<c:out value="${item.latitude}" />
									</td>
									<td>
										<c:out value="${item.longtitude}" />
									</td>

									<td>
										<s:Code2Name code="${item.prtsource}"
											definition="$CH_PRTSOURCE" />
									</td>
									<td>
										<s:Code2Name code="${item.isconnected}"
											definition="$CH_ISCONNECTED" />
									</td>
									<td>
										<s:Code2Name code="${item.connecttype}"
											definition="$CH_CONNECTTYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.runmode}" definition="$CH_RUNMODE" />
									</td>
									<td>
										<s:Code2Name code="${item.iscoreway}"
											definition="$CH_ISCOREWAY" />
									</td>
									<td>
										<s:Code2Name code="${item.starlevel}"
											definition="$CH_STARLEVEL" />
									</td>
									<td>
										<s:Code2Name code="${item.pt}" definition="$CH_PT" />
									</td>
									<td>
										<c:out value="${item.chainhead}" />
									</td>
									<td>
										<c:out value="${item.signstatus}" />
									</td>
									<td>
										<c:out value="${item.empnumber}" />
									</td>
									<td>
										<c:out value="${item.magnumber}" />
									</td>
									<td>
										<c:out value="${item.terminumber}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.updatedate}" />
									</td>
									<td>
										<s:Code2Name code="${item.isstraitprd}"
											definition="$CH_STRAITPRD" />
									</td>
									<td>
										<s:Code2Name code="${item.taxtype}" definition="$CH_STTAXTYPE" />
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
