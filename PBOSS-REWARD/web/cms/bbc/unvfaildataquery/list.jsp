<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
	String ID_1 = "00010701";
	String ID_2 = "00010702";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
	<head>
		<title><bean:message bundle="unvfaildataquery" key="titleList" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
		<script type="text/javascript" src="<%= contextPath%>/js/jquery/jquery-1.3.2.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	var calcmonth = $("input[name='_se_calcmonth']").eq(0).val();
        	var rcmonth = $("input[name='_se_rcmonth']").eq(0).val();
        	if(calcmonth=="" && rcmonth=="")
        	{
        		alert("请输入计酬月份或推荐月份");
        		return false;
        	}
            return checkval(window);
        }
		 function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		function exports(){
        	
	       	var calcmonth = $("input[name='_se_calcmonth']").eq(0).val();
        	var rcmonth = $("input[name='_se_rcmonth']").eq(0).val();
        	var city = $("#citycompid").val();
        	if(city=="ProvAgent" && calcmonth==""){
        		alert("请输入计酬月份");
        		return;
        	}
        	else if(city!="ProvAgent" && rcmonth==""){
        		alert("请输入推荐月份");
        		return;
        	}
        	
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/bbc/unvfaildataquery.do?CMD=DOWNLOAD";
			form.submit();
			form.action="<%=contextPath%>/cms/bbc/unvfaildataquery.do?CMD=LIST";
		}
		
		function selectAdtremark(){
        	var strUrl ="<%=contextPath%>/cms/bbc/unvfaildataquery.do?CMD=SELECT";
			var arg = new Array();
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		 
		 function chooseCity(){
		 	var city = $("#citycompid").val();
		 	if(city.toString()=="ProvAgent"){
		 		//$(".query").attr("disabled","true");
		 		$(".query").hide();		 		
		 	}
		 	else{
		 		//$(".query").attr("disabled","false");
		 		$(".query").show();		 		
		 	}
		 }
		 
		$(document).ready(function(){
			//业务编号无对应名称则翻译为空
			$("#Table2 .opnidTD").each(function(i){
				if($(this).html()==$(this).next().html())
				$(this).next().html("");
			});
			
			//根据是否有全省权限对地市选框进行控制
			var hasPurview = $("#hasPurview").val();
			var hasProvAgentView = $("#hasProvAgentView").val();
			if(hasPurview!="true" && hasProvAgentView!="true")
			{
				$("#citycompid").attr("disabled", true);
			}
		}); 

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
			<html:form action="/cms/bbc/unvfaildataquery.do?CMD=LIST"
				styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="hasPurview" styleId="hasPurview"/>
				<html:hidden property="hasProvAgentView" styleId="hasProvAgentView"/>
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="unvfaildataquery" key="titleList" />
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
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="unvfaildataquery" key="calcmonth"/>:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_calcmonth" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"></html:text>
							</td>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="unvfaildataquery" key="rcmonth"/>:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_rcmonth" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"></html:text>
							</td>
						</tr>
						<tr>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="unvfaildataquery" key="rcno"/>:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_rcno"></html:text>
							</td>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="unvfaildataquery" key="opnid"/>:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_opnid"></html:text><input type="button" value="..." class="clickbutton" onclick="_se_opnid.value=getOpnId();"/>
							</td>
						</tr>
						<tr>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="unvfaildataquery" key="ossrc"/>:
							</td>
							<td class="form_table_left">
								<html:select  property="_se_ossrc">
				                   	<option/>
				                   	<s:Options definition="#CH_UNV_OSSRC" />
				                   	<html:option value="4">新数据业务</html:option>
				                </html:select> 
							</td>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="unvfaildataquery" key="wayid1"/>:
							</td>
							<td class="form_table_left">
								<s:zoom definition="#WAY" property="_se_wayid" condition="waytype:AG;" styleClass="form_input_1x" nameOnly="false" readonly="false"/>
							</td>
						</tr>
						<tr>
							<td width="80" height="20" align="right" class="form_table_right">
								<bean:message bundle="unvfaildataquery" key="batchno"/>:
							</td>
							<td>
								<html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
								
							</td>
				   			<td width="80" height="20" align="right" class="form_table_right" >
				               	<bean:message bundle="Wayproemployee" key="citycompany"/>:
				           	</td>
				           	<td class="form_table_left">
				           		<html:select property="_ne_citycompid" styleId="citycompid" onchange="chooseCity()">
									<option />
									<c:if test="${requestScope.ProvAgent}">
										<option value="ProvAgent"><bean:message bundle="unvfaildataquery" key="provAgent"/></option>
									</c:if>
									<c:if test="${requestScope.ProvAgent && !requestScope.B2MProv}">
										<s:Options definition="#CITYCOMPANY" condition="citycompid:${requestScope.cityid};"/>
									</c:if>
									<c:if test="${!requestScope.ProvAgent || requestScope.B2MProv}">
										<s:Options definition="#CITYCOMPANY" />
									</c:if>																	
								</html:select>
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
		                                value="<bean:message bundle="unvrewardrecord" key="export"/>" onclick="exports();"/>
		                        <input type="submit" class="query" onmouseover="buttonover(this);"
		                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
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
                			<a href="javascript:doOrderby('wayid')"><bean:message bundle="unvrewardrecord" key="wayid1"/></a>
                 		   <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="wayid"/>
                			</td>
               				 <td>	
                			<a href="javascript:doOrderby('wayid')"><bean:message bundle="unvrewardrecord" key="wayid2"/></a>
                			    <s:OrderImg form="/cms/bbc/UnvRewardrecordForm" field="wayid"/>
               				 </td>
               				 	<td>
									<a href="javascript:doOrderby('employeeid')"><bean:message
											bundle="unvfaildataquery" key="employeeid" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm" field="employeeid" />
								</td>
								<td>
									<a href="javascript:doOrderby('rcno')"><bean:message
											bundle="unvfaildataquery" key="rcno" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm" field="rcno" />
								</td>
								<td>
									<a href="javascript:doOrderby('opnid')"><bean:message
											bundle="unvfaildataquery" key="opnid" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm"
										field="opnid" />
								</td>
								<td>
									<bean:message bundle="unvfaildataquery" key="opername" />
								</td>
								<td>
									<a href="javascript:doOrderby('mobileno')"><bean:message
											bundle="unvfaildataquery" key="mobileno" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm" field="mobileno" />
								</td>
								<td>
									<a href="javascript:doOrderby('calcmonth')"><bean:message
											bundle="unvfaildataquery" key="calcmonth" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm" field="calcmonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('rcmonth')"><bean:message
											bundle="unvfaildataquery" key="rcmonth" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm" field="rcmonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('adtcode')"><bean:message
											bundle="unvfaildataquery" key="adtcode" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm" field="adtcode" />
								</td>
								<td>
									<a href="javascript:doOrderby('reason')"><bean:message
											bundle="unvfaildataquery" key="reason" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm"
										field="reason" />
								</td>
								<td>
									<a href="javascript:doOrderby('ossrc')"><bean:message
											bundle="unvfaildataquery" key="ossrc" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm"
										field="ossrc" />
								</td>
								<td>
									<a href="javascript:doOrderby('batchno')"><bean:message
											bundle="unvfaildataquery" key="batchno" />
									</a>
									<s:OrderImg form="/cms/bbc/UnvFaildataqueryForm"
										field="batchno" />
								</td>
								<td>
									<bean:message bundle="unvfaildataquery" key="oprtime" />
								</td>
								<td>
									<bean:message bundle="unvfaildataquery" key="status" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td><c:out value="${item.wayid}"/></td>
                    				<td><s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
                    				<td>
										<c:out value="${item.employeeid}" />
									</td>
									<td>
										<c:out value="${item.rcno}" />
									</td>
									<td class="opnidTD">
										<c:out value="${item.opnid}" />
									</td>
									<td>
										<s:Code2Name code="${item.opnid}" definition="#BBC_OPERATION"/>
									</td>
									<td>
										<c:out value="${item.mobileno}" />
									</td>
									<td>
										<c:out value="${item.calcmonth}" />
									</td>
									<td>
										<c:out value="${item.rcmonth}" />
									</td>
									<td>
										<s:Code2Name code="${item.adtcode}" definition="#ADTCODE" />
									</td>
									<td>
										<c:out value="${item.reason}" />
									</td>
									<td>
										<s:Code2Name code="${item.ossrc}" definition="#CH_UNV_OSSRC" />
									</td>
									<td>
										<c:out value="${item.batchno}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" />
									</td>
									<td>
										<c:out value="${item.status}" />
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
