<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="bbcfaildataquery" key="titleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
		
        function ev_check() {
        	addfield('_se_rewardtype', '<bean:message bundle="faildataquery" key="rewardtype"/>', 'c', true, '255');
        	addfield('_se_opnid', '<bean:message bundle="faildataquery" key="opnid"/>', 'c', true, '18');
        	addfield('_se_wayid', '<bean:message bundle="faildataquery" key="wayid"/>', 'c', true, '18');
            addfield('_dnl_oprtime', '<bean:message bundle="faildataquery" key="oprtime"/>', 'dt', true, '19');
            addfield('_dnm_oprtime', '<bean:message bundle="faildataquery" key="oprtime"/>', 'dt', true, '19');
            addfield('_se_oprcode', '<bean:message bundle="faildataquery" key="oprcode"/>', 'c', true, '15');
            addfield('_se_mobile', '<bean:message bundle="faildataquery" key="mobile"/>', 'l', true, '15');
            addfield('_sk_adtremark', '<bean:message bundle="faildataquery" key="adtremark"/>', 'c', true, '255');
            return checkval(window);
        }
        
        function selectAdtremark(adttype){
        	var strUrl ="<%=contextPath%>/cms/bbc/bbcfaildataquery.do?CMD=SELECT";
        	if(typeof(adttype)!='undefined' && adttype.length>0){
			strUrl = strUrl + "&adttype=" + adttype;
			}
			var arg = new Array();
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		 
		 function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		
		function exports(cmd){
	       	 if(ev_check() == false ) {
	       	 	return ;
	       	 }
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/bbc/bbcfaildataquery.do?CMD="+cmd;
			form.submit();
			form.action="<%=contextPath%>/cms/bbc/bbcfaildataquery.do?CMD=LIST";
		}
		
    </script>
    <style type="text/css">
		<!--
		select {
			width:170px;
			height:18px;
		}
		-->
	</style>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/bbc/bbcfaildataquery.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
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
								<bean:message bundle="bbcfaildataquery" key="titleList" />
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
								<bean:message bundle="bbcfaildataquery" key="rewardtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_se_rewardtype">
									<html:option value="9">销售类基本酬金</html:option>
									<html:option value="10">销售类奖励酬金</html:option>
									<html:option value="11">新增网站活跃客户基本酬金</html:option>
									<html:option value="12">新增网站活跃客户奖励酬金</html:option>
									<html:option value="13">e100活跃客户基本酬金</html:option>
									<html:option value="14">e100活跃客户奖励酬金</html:option>
									<html:option value="88">待校验</html:option>
									<html:option value="99">全部</html:option>
								</html:select>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="oprcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="opnid"/>:
							</td>
							<td class="form_table_left">
								<html:text property="_se_opnid" styleClass="form_input_1x" /><input type="button" value="..." class="clickbutton"
									onclick="_se_opnid.value=getOpnId();">
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="wayid"/>:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid"></html:text>			
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="oprtime" />
								&gt;=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_oprtime"
									onclick="this.value=selectDatetime();"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="oprtime" />
								&lt;=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_oprtime"
									onclick="this.value=selectDatetime();"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="mobile"/>
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="adtremark"/>:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_adtremark"></html:text><input type="button" value="..." class="clickbutton"
									onclick="_sk_adtremark.value=selectAdtremark('BUSI');">
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="ossrc"/>
								:
							</td>
							<td class="form_table_left">
								<html:select  property="_se_ossrc">
			                    	<option/>
			                    	<s:Options definition="#CH_BBC_OSSRC" />
	                    		</html:select> 
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="bbcfaildataquery" key="batchno"/>
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>
								<input type="button" class="button_2" onmouseover="buttonover(this);"
	                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                                value="<bean:message bundle="bbcrewardrecord" key="export"/>" onclick="exports('TXT');"/>
	                            <input type="button" class="button_6" onmouseover="buttonover(this);"
	                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                                value="<bean:message bundle="bbcrewardrecord" key="export"/>EXCEL" onclick="exports('EXCEL');"/>    
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
									<a href="javascript:doOrderby('seq')"><bean:message
											bundle="bbcfaildataquery" key="seq" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm" field="seq" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardtype')"><bean:message
											bundle="bbcfaildataquery" key="rewardtype" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="rewardtype" />
								</td>
								<td>
									<a href="javascript:doOrderby('calcmonth')"><bean:message
											bundle="bbcfaildataquery" key="calcmonth" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="calcmonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('opnid')"><bean:message
											bundle="bbcfaildataquery" key="opnid" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm" field="opnid" />
								</td>
								<td>
									<a href="javascript:doOrderby('name')"><bean:message
											bundle="bbcfaildataquery" key="name" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm" field="name" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="bbcfaildataquery" key="wayid" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm" field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayname')"><bean:message
											bundle="bbcfaildataquery" key="wayname" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="wayname" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprcode')"><bean:message
											bundle="bbcfaildataquery" key="oprcode" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="oprcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('mobile')"><bean:message
											bundle="bbcfaildataquery" key="mobile" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm" field="mobile" />
								</td>
								<td>
									<a href="javascript:doOrderby('oprtime')"><bean:message
											bundle="bbcfaildataquery" key="oprtime" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="oprtime" />
								</td>
								<td>
									<a href="javascript:doOrderby('creattime')"><bean:message
											bundle="bbcfaildataquery" key="creattime" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="creattime" />
								</td>
								<td>
									<a href="javascript:doOrderby('ruleid')"><bean:message
											bundle="bbcfaildataquery" key="ruleid" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm" field="ruleid" />
								</td>
								<td>
									<a href="javascript:doOrderby('adtflag')"><bean:message
											bundle="bbcfaildataquery" key="adtflag" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="adtflag" />
								</td>
								<td>
									<a href="javascript:doOrderby('adtcode')"><bean:message
											bundle="bbcfaildataquery" key="adtcode" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="adtcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('adtremark')"><bean:message
											bundle="bbcfaildataquery" key="adtremark" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="adtremark" />
								</td>
								<td>
									<a href="javascript:doOrderby('ossrc')"><bean:message
											bundle="bbcfaildataquery" key="ossrc" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="ossrc" />
								</td>
								<td>
									<a href="javascript:doOrderby('batchno')"><bean:message
											bundle="bbcfaildataquery" key="batchno" />
									</a>
									<s:OrderImg form="/cms/bbc/BbcFaildataqueryForm"
										field="batchno" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td>
										<c:out value="${item.seq}" />
									</td>
									<td>
										<c:out value="${item.rewardtype}" />
									</td>
									<td>
										<c:out value="${item.calcmonth}" />
									</td>
									<td>
										<c:out value="${item.opnid}" />
									</td>
									<td>
										<!-- <c:out value="${item.name}" /> -->
										<s:Code2Name code="${item.opnid}" definition="#BBC_OPERATION" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<!--<c:out value="${item.wayname}" />-->
										<c:if test="${item.ossrc == 0}">
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
				                        </c:if>
				                        <c:if test="${item.ossrc!=0}">
										<s:Code2Name code="${item.wayid}" definition="#BBCWAY" />
				                        </c:if>
									</td>
									<td>
										<c:out value="${item.oprcode}" />
									</td>
									<td>
										<c:out value="${item.mobile}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd"
											value="${item.oprtime}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd"
											value="${item.creattime}" />
									</td>
									<td>
										<c:out value="${item.ruleid}" />
									</td>
									<td>
										<s:Code2Name code="${item.adtflag}" definition="#CH_ADTFLAG" />
									</td>
									<td>
										<c:out value="${item.adtcode}" />
									</td>
									<td>
										<c:out value="${item.adtremark}" />
									</td>
									<td><s:Code2Name code="${item.ossrc}" definition="#CH_BBC_OSSRC" /></td>
									<td>
										<c:out value="${item.batchno}" />
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="table_div">
						<s:PageNav dpName="LIST" />
					</div>
			</html:form>
		</div>
	</body>
</html>
