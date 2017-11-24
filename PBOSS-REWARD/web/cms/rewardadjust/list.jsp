<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="org.ajaxanywhere.*"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
	String ID_1 = "CH_PW_REWARD_ADJUST||CH_PW_REWARD";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="rewardadjust" key="titleList" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_adjustkind', '<bean:message bundle="rewardadjust" key="adjustkind"/>', 'c', true, '32');
            addfield('_se_wayid', '<bean:message bundle="rewardadjust" key="wayid"/>', 'c', true, '18');
            addfield('_snl_eftmonth', '<bean:message bundle="rewardadjust" key="eftmonth"/>', 'c', true, '6');
            addfield('_snm_eftmonth', '<bean:message bundle="rewardadjust" key="eftmonth"/>', 'c', true, '6');
            addfield('_se_adjusttype', '<bean:message bundle="rewardadjust" key="adjusttype"/>', 'c', true, '32');
            addfield('_se_reasontype', '<bean:message bundle="rewardadjust" key="reasontype"/>', 'c', true, '32');
            addfield('_ne_islock', '<bean:message bundle="rewardadjust" key="islock"/>', 'f', true, '3');
            addfield('_se_srcmonth', '<bean:message bundle="rewardadjust" key="srcmonth"/>', 'c', true, '6');
            return checkval(window);
        }
        
         function loadDataInContent(){
         	var form=document.forms[0];
        	form.submit();
        }
        
        function upload(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/rewardadjust/batchupfile.jsp";
			form.submit();
			form.action="<%=contextPath%>/cms/rewardadjust.do?CMD=LIST";
		}
		
		function doAuditing(){
				var isaudit = "audit";
        		var url = '<%=contextPath%>/cms/waitaudit.do?CMD=LIST&ISAUDIT=' + isaudit;
		    	formList.action = url;
		    	formList.submit();
        }
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/rewardadjust.do?CMD=LIST" styleId="formList"
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
								<bean:message bundle="rewardadjust" key="titleList" />
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
								<bean:message bundle="rewardadjust" key="adjustkind" />:
							</td>
							<td class="form_table_left">
								<html:select property="_se_adjustkind"
									onchange="loadDataInContent();">
									<option />
										<s:Options definition="$CH_RWADJUSTKIND" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardadjust" key="wayid" />:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x"
									onclick="showSelectWay(this,'_se_wayid')" property="_se_wayid" />
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardadjust" key="_snl_eftmonth" />:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_snl_eftmonth"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardadjust" key="_snm_eftmonth" />:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_snm_eftmonth"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardadjust" key="adjusttype" />:
							</td>
							<td class="form_table_left">
								<html:select property="_se_adjusttype">
									<c:if
										test="${('PUNISH' eq requestScope['/cms/RewardadjustForm']._se_adjustkind) or (empty requestScope['/cms/RewardadjustForm']._se_adjustkind)}">
										<option />
									</c:if>
									<s:Options definition="#CH_DICTITEM"
										condition="_sk_dictid:${requestScope['/cms/RewardadjustForm'].dictid2};groupid:CH_RWADJUSTTYPE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardadjust" key="reasontype" />:
							</td>
							<td class="form_table_left">
								<aa:zone name="zone1">
									<html:select property="_sk_reasontype">
										<option />
											<s:Options definition="#CH_DICTITEM"
												condition="_sk_dictid:${requestScope['/cms/RewardadjustForm'].dictid};groupid:CH_RWADJUSTREASON" />
									</html:select>
								</aa:zone>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardadjust" key="rewardtype" />:
							</td>
							<td class="form_table_left">
								<html:select property="_se_rewardtype">
									<option />
										<s:Options definition="$CH_REWARDTYPE" />
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="rewardadjust" key="islock" />:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_islock">
									<option />
										<s:Options definition="#ISLOCK" />
								</html:select>
							</td>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardadjust" key="srcmonth" />:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_srcmonth" onclick="this.value=selectDateYYYYMM();"></html:text>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
									<input type="button" name="btnAuditing" class="button_2"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value='<bean:message bundle="rewardadjust" key="auditing"/>'
										onClick="doAuditing();">
								<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
									<input type="button" name="btnDelete" class="delete"
										onmouseover="buttonover(this);" onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_delete"/>"
										onClick="doDelete('/cms/rewardadjust.do')">
								</s:RewardPurChk>
								<input type="submit" class="query"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />
								<input type="button" name="btnImport" class="button_2"
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="导入"
									onClick="upload();" />
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
									<a href="javascript:doOrderby('seq')"><bean:message
											bundle="rewardadjust" key="seq" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="seq" />
								</td>
								<td>
									<a href="javascript:doOrderby('adjustkind')"><bean:message
											bundle="rewardadjust" key="adjustkind" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="adjustkind" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="rewardadjust" key="wayid" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="wayid" />
								</td>
								<td>
									渠道名称
								</td>
								<td>
									<a href="javascript:doOrderby('eftmonth')"><bean:message
											bundle="rewardadjust" key="eftmonth" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="eftmonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('adjmoney')"><bean:message
											bundle="rewardadjust" key="adjmoney" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="adjmoney" />
								</td>
								<td>
									<a href="javascript:doOrderby('actualmoney')"><bean:message
											bundle="rewardadjust" key="actualmoney" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="actualmoney" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardtype')"><bean:message
											bundle="rewardadjust" key="rewardtype" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="rewardtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('adjusttype')"><bean:message
											bundle="rewardadjust" key="adjusttype" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="adjusttype" />
								</td>
								<td>
									<a href="javascript:doOrderby('reasontype')"><bean:message
											bundle="rewardadjust" key="reasontype" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="reasontype" />
								</td>
								<td>
									<a href="javascript:doOrderby('remark')"><bean:message
											bundle="rewardadjust" key="remark" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="remark" />
								</td>
								<td>
									<a href="javascript:doOrderby('srcmonth')"><bean:message
											bundle="rewardadjust" key="srcmonth" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="srcmonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('relateseq')"><bean:message
											bundle="rewardadjust" key="relateseq" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="relateseq" />
								</td>
								<td>
									<a href="javascript:doOrderby('islock')"><bean:message
											bundle="rewardadjust" key="islock" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="islock" />
								</td>
								<td>
									<a href="javascript:doOrderby('createoprcode')"><bean:message
											bundle="rewardadjust" key="createoprcode" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="createoprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('createtime')"><bean:message
											bundle="rewardadjust" key="createtime" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="createtime" />
								</td>
								<td>
									<a href="javascript:doOrderby('adtoprcode')"><bean:message
											bundle="rewardadjust" key="adtoprcode" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="adtoprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('adttime')"><bean:message
											bundle="rewardadjust" key="adttime" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="adttime" />
								</td>
								<td>
									<a href="javascript:doOrderby('updateoprcode')"><bean:message
											bundle="rewardadjust" key="updateoprcode" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="updateoprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('updatetime')"><bean:message
											bundle="rewardadjust" key="updatetime" /> </a>
									<s:OrderImg form="/cms/rewardadjust/rewardadjustForm"
										field="updatetime" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/rewardadjust.do?CMD=EDIT" var="urlContent">
									<%
									//this param name must "PK"
									%>
									<c:param name="PK" value="${item.seq}" />
									<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
								</c:url>
								<tr class="table_style_content" align="center">
									<td>

										<c:choose>
											<c:when
												test="${item.islock eq '2' or item.createoprcode eq 'REWARD-SYSTEM'}">
												<input type="checkbox" name="_selectitem"
													value="<c:out value='${item.seq}' />" onclick="checkOne();"
													class="table_checkbox" disabled="true">

											</c:when>
											<c:otherwise>
												<input type="checkbox" name="_selectitem"
													value="<c:out value='${item.seq}' />" onclick="checkOne();"
													class="table_checkbox">
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<c:choose>
											<c:when
												test="${item.islock eq '1' or item.islock eq '2' or item.createoprcode eq 'REWARD-SYSTEM'}">
												<c:out value="${item.seq}" />

											</c:when>
											<c:otherwise>
												<a href='<c:out value="${urlContent}"/>'><c:out
														value="${item.seq}" /> </a>
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<s:Code2Name code="${item.adjustkind}"
											definition="$CH_RWADJUSTKIND" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>
									<td>
										<c:out value="${item.eftmonth}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.adjmoney}" />
									</td>
									<td>
										<fmt:formatNumber pattern="0.00" value="${item.actualmoney}" />
									</td>
									<td>
										<s:Code2Name code="${item.rewardtype}"
											definition="$CH_REWARDTYPE" />
									</td>
									<td>
										<s:Code2Name code="${item.adjusttype}"
											definition="$CH_RWADJUSTTYPE" />
									</td>
									<td>
										<s:MoreCode2Name code="${item.reasontype}"
											definition="$CH_RWADJUSTREASON" />
									</td>
									<td>
										<c:out value="${item.remark}" />
									</td>
									<td>
										<c:out value="${item.srcmonth}" />
									</td>
									<td>
										<c:out value="${item.relateseq}" />
									</td>
									<td>
										<s:Code2Name code="${item.islock}" definition="#ISLOCK" />
									</td>
									<td>
										<c:out value="${item.createoprcode}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.createtime}" />
									</td>
									<td>
										<c:out value="${item.adtoprcode}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.adttime}" />
									</td>
									<td>
										<c:out value="${item.updateoprcode}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${item.updatetime}" />
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
