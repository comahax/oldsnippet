<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL"; //省级酬金管理令牌
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC"; //市级酬金管理令牌
%>
<html xmlns="http://www.w3.org/1999/xhtml"-->
	<head>
		<title><bean:message bundle="stdrewardut" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">

        function ev_check() {
        	addfield('_ne_rewardid', '<bean:message bundle="stdrewardut" key="rewardid"/>', 'i', true, '18');
            return checkval(window);
        }
        		
		var msgNotSelected="<bean:message bundle="stdrewardut" key="msgNotSelected"/>"
    	var msgAuditConfirm="<bean:message bundle="stdrewardut" key="msgDeleteConfirm"/>"
		function doDelete(){
    		
    		var TO = true;
    		var sis = formList.all("_selectitem");
    		if (forincheck(TO,sis,msgAuditConfirm)){
    			formList.action = "<%=contextPath%>/cms/reward/stdrewardut.do?CMD=DELETE";
    			formList.submit();
    			}  
		}
		function forincheck(TO,sis,msg){
    		if (sis != null) {
       			 if (sis.length != null) {
            		for (var i = 0; i < sis.length; i++) {
               		 	var e = sis[i];
               			if (e.type == 'checkbox') {
                  		 	if (e.checked)
                        		TO = false;
               		 	}
           			}		
       		 	 } else {
            		var e = sis;
            	 	if (e.type == 'checkbox') {
                		if (e.checked)
                    		TO = false;
            		}		
        		 }		
    		}
    		if (TO) {
        		alert(msgNotSelected);
        		return false;
    		}
	
			if(msg.length>0){
    			if (!confirm(msg)) {
        		return false;
    			}
    		}
    	return true;
	}
			
    </script>

	</head>

	<body onload="loadforiframe1();">
		<div class="table_container">
			<html:form action="/cms/reward/stdrewardut.do?CMD=LIST"
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
								<bean:message bundle="stdrewardut" key="titleList" />
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
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="rewardid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_rewardid" />
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="rewardname" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_rewardname" />
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="startdate" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_startdate"
									onclick="this.value=selectDate();"></html:text>
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="stopdate" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_stopdate"
									onclick="this.value=selectDate();"></html:text>
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="region" />
								:
							</td>
							<td class="form_table_left">
							<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
								<html:select property="_se_region">
									<html:option value=""></html:option>
									<s:Options definition="$region" />
								</html:select>
							</s:RewardPurChk>
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="rewardtype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_rewardtype">
									<html:option value=""></html:option>
									<s:Options definition="#CH_PWREWARDTYPE" />
								</html:select>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table width="100%" class="table_button_list" border="0"
						cellspacing="0" cellpadding="0" ID="Table3">
						<tr>
							<td align=right>
								<input type="button" name="btnQuery" class="query"
									value="<bean:message bundle="public" key="button_search"/>"
									onclick="doQuery('/cms/reward/stdrewardut.do?CMD=LIST');" />
								<s:RewardPurChk controlid="<%=ID_1%>">
								<input type="button" name="btnAdd" class="add" value="新增"
									onclick="doNew('/cms/reward/stdrewardut.do?CMD=NEW');" />
								</s:RewardPurChk>
								<s:RewardPurChk controlid="<%=ID_1%>">
								<input type="button" name="btnDelete" class="delete" value="删除"
									onclick="doDelete();" />			
								</s:RewardPurChk>						
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
									<a href="javascript:doOrderby('region')"><bean:message
											bundle="stdrewardut" key="region" />
									</a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="region" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardid')"><bean:message
											bundle="stdrewardut" key="rewardid" />
									</a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="rewardid" />
								</td>
								<td>
									<a href="javascript:doOrderby('rewardname')"><bean:message
											bundle="stdrewardut" key="rewardname" /> </a>
									<s:OrderImg form="/cms/reward/StdrewardutForm"
										field="rewardname" />
								</td>
								<td>
									<a href="javascript:doOrderby('startdate')"><bean:message
											bundle="stdrewardut" key="startdate" /> </a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="startdate" />
								</td>
								<td>
									<a href="javascript:doOrderby('stopdate')"><bean:message
											bundle="stdrewardut" key="stopdate" /> </a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="stopdate" />
								</td>
								<td>
									<bean:message bundle="stdrewardut" key="rewardstd" />
								</td>
								<td>
									<a href="javascript:doOrderby('intvmonth')"><bean:message
											bundle="stdrewardut" key="intvmonth" /> </a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="intvmonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('integralnum')"><bean:message
											bundle="stdrewardut" key="integralnum" /> </a>
									<s:OrderImg form="/cms/reward/StdrewardutForm"
										field="integralnum" />
								</td>
								<td>
									<a href="javascript:doOrderby('unitprice')"><bean:message
											bundle="stdrewardut" key="unitprice" /> </a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="unitprice" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/reward/stdrewardut.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.region}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.region}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
										<a href='<c:out value="${urlContent}"/>'>
											<s:Code2Name code="${item.region}" definition="$region" />
										</a>
									</td>
                    				<td><c:out value="${item.rewardid}"/></td>
                    				<td>
										<c:out value="${item.rewardname}" />
									</td>
									<td>
										<fmt:formatDate value="${item.startdate}" pattern="yyyy-MM-dd"/>
									</td>
									<td>
										<fmt:formatDate value="${item.stopdate}" pattern="yyyy-MM-dd"/>
									</td>
									<td>
										<c:out value="${item.rewardstd}" />
									</td>
									<td>
										<c:out value="${item.intvmonth}" />
									</td>
									<td>
										<c:out value="${item.integralnum}" />
									</td>
									<td>
										<c:out value="${item.unitprice}" />
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





























