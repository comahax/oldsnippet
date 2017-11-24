<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
   String ID_4 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";
   String ID_3 ="CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
	<head>
		<title><bean:message bundle="busicityload" key="titleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="busicityload" key="opnid"/>', 'c', true, '18');
            addfield('_se_cityid', '<bean:message bundle="busicityload" key="cityid"/>', 'c', true, '4');
            addfield('_dnl_createtime', '<bean:message bundle="busicityload" key="createtime"/>', 'dt', true, '25');
            addfield('_dnm_createtime', '<bean:message bundle="busicityload" key="createtime"/>', 'dt', true, '25');
            addfield('_ne_state', '<bean:message bundle="busicityload" key="state"/>', 'f', true, '2');
            addfield('_ne_calcflag', '<bean:message bundle="busicityload" key="calcflag"/>', 'f', true, '2');
            var cityidVal = document.all("cityid").value;
            document.all("_se_cityid").value = cityidVal;
            return checkval(window);
        }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/busicityload.do?CMD=LIST" styleId="formList"
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
								<bean:message bundle="busicityload" key="titleList" />
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
								<bean:message bundle="busicityload" key="opnid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="opnids"></html:text>
								<html:hidden property="_se_opnid"/>
										<input type="button" value="..." class="clickButton"
											onclick="showOpnTree2(this, '_se_opnid','busi','dishi','opnids')"> 
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="busicityload" key="simcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_simcode"></html:text>
							</td> 
							</tr>
							<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="busicityload" key="state" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_state">
									<option />
										<s:Options definition="#CH_STATE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="busicityload" key="createtime" />
								>=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_createtime"
									onclick="this.value=selectDatetime();" readonly="true"></html:text>
							</td>
							</tr>
							<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="busicityload" key="createtime" />
								<=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_createtime"
									onclick="this.value=selectDatetime();" readonly="true"></html:text>
							</td>

							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="busicityload" key="calcflag" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_calcflag">
									<option />
										<s:Options definition="#CH_CALCFLAG" />
								</html:select>
							</td>
						</tr>
						
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="busicityload" key="cityid" />
							</td>
							<td class="form_table_left">
							<s:RewardPurChk controlid="<%=ID_3%>" disableChild="true" >
								<html:select property="cityid" >
									<option />
										<s:Options definition="#CITYIDNUM2NMAME" />
								</html:select>
							</s:RewardPurChk>
							<html:hidden property="_se_cityid" />
							</td>

							<td width="126" height="20" align="right"
								class="form_table_right">
								
							</td>
							<td class="form_table_left">
								
							</td>
						</tr>
						
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
									<s:RewardPurChk controlid="<%=ID_4%>">
									<input type="button" name="btnNew" class="add"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_new"/>"
										onClick="doNew('/cms/busicityload.do')">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="doDelete('/cms/busicityload.do')">
									</s:RewardPurChk>
								
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
								<td
									title="<bean:message bundle="public" key="list_title_select"/>">
									<input type="checkbox" name="allbox" onclick="checkAll();"
										class="table_checkbox">
								</td>
								<td>
								<a href="javascript:doOrderby('opnid')"><bean:message bundle="busicityload" key="opnid"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="opnid"/>
								</td>
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message bundle="busicityload" key="cityid"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="cityid"/>
								</td>
								<td>
									<a href="javascript:doOrderby('simcode')"><bean:message bundle="busicityload" key="simcode"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="simcode"/>

								</td>
								<td>
									<a href="javascript:doOrderby('showorder')"><bean:message bundle="busicityload" key="showorder"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="showorder"/>

								</td>
								<td>
									<a href="javascript:doOrderby('createtime')"><bean:message bundle="busicityload" key="createtime"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="createtime"/>

								</td>
								<td>
									<a href="javascript:doOrderby('state')"><bean:message bundle="busicityload" key="state"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="state"/>

								</td>
								<td>
									<a href="javascript:doOrderby('calcflag')"><bean:message bundle="busicityload" key="calcflag"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="calcflag"/>

								</td>
								<td>
									<a href="javascript:doOrderby('remark')"><bean:message bundle="busicityload" key="remark"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="remark"/>
								</td>
								
								<td>
									<a href="javascript:doOrderby('waytype')"><bean:message bundle="busicityload" key="waytype"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="waytype"/>
								</td>
								<td>
									<a href="javascript:doOrderby('inuse')"><bean:message bundle="busicityload" key="inuse"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="inuse"/>
								</td>
								<td>
									<a href="javascript:doOrderby('infocustomer')"><bean:message bundle="busicityload" key="infocustomer"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="infocustomer"/>
								</td>
								<td>
									<a href="javascript:doOrderby('infoemployee')"><bean:message bundle="busicityload" key="infoemployee"/></a>
                    				<s:OrderImg form="/cms/busicityload/BusicityloadForm" field="infoemployee"/>
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/busicityload.do?CMD=EDIT" var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.cityid}|${item.opnid}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.cityid}|${item.opnid}' />"
											onclick="checkOne(this);" class="table_checkbox">
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out
												value="${item.opnid}" />   <s:Code2Name code="${item.opnid}" definition="#OPERATION" />
										</a>
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'><s:Code2Name code="${item.cityid}" definition="#CITYIDNUM2NMAME" />	</a>
									</td>
									<td>
										<c:out value="${item.simcode}" />
									</td>
									<td>
										<c:out value="${item.showorder}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.createtime}" /> 
									</td>
									<td>
										<s:Code2Name code="${item.state}" definition="#CH_STATE" />
									</td>
									<td>
										<s:Code2Name code="${item.calcflag}" definition="#CH_CALCFLAG" />
									</td>
									<td>
										<c:out value="${item.remark}" />
									</td>
									<td>
										<c:out value="${item.waytype}" />
									</td>
									<td>
										<c:out value="${item.inuse}" />
									</td>
									<td>
										<c:out value="${item.infocustomer}" />
									</td>
									<td>
										<c:out value="${item.infoemployee}" />
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
