<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String PROVINCE = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL"; //省级酬金管理令牌
	String CITY = "CH_PW_REWARD||CH_PW_REWARD_CIVIC"; //市级酬金管理令牌
%>
<html xmlns="http://www.w3.org/1999/xhtml"-->
	<head>
		<title><bean:message bundle="stdrewardut" key="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">

        function ev_check() {
            return checkval(window);
        }
        
		var msgNotSelected="<bean:message bundle="stdrewardut" key="msgNotSelected"/>"
    	var msgAuditConfirm="<bean:message bundle="stdrewardut" key="msgDeleteConfirm"/>"
		function doDelete(){
    		
    		var TO = true;
    		var sis = formList.all("_selectitem");
    		if (forincheck(TO,sis,msgAuditConfirm)){
    			formList.action = "<%=contextPath%>/cms/reward/stdrewardut.do?CMD=DELETECITY";
    			formList.submit();
    			}  
		}
		function doEdit(){
    		
    		var TO = true;
    		var sis = formList.all("_selectitem");
    		if (checkSingle(TO,sis,msgAuditConfirm)){
    			formList.action = "<%=contextPath%>/cms/reward/stdrewardut.do?CMD=EDITCITY";
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
		function checkSingle(TO,sis,msg){
			var TO = true;
    		var sis = formList.all("_selectitem");
    		var cnt=0;
    		if (sis != null) {
       			 if (sis.length != null) {
            		for (var i = 0; i < sis.length; i++) {
               		 	var e = sis[i];
               			if (e.type == 'checkbox') {
                  		 	if (e.checked)
                  		 	{
                        		TO = false;
                        		cnt++;
                        	}
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
    		if(cnt!=1)
    		{
    			alert('酬金标准设置只能选择一条记录!');
    			return false;
    		}
	
    	return true;
		}	
		
		
		
    </script>

	</head>

	<body onload="loadforiframe1();">
		<div class="table_container">
			<html:form action="/cms/reward/stdrewardut.do?CMD=LISTCITY"
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
								<bean:message bundle="stdrewardut" key="titleList2" />
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
							<td width="30%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_wayid" />
							</td>
							<td width="30%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="wayname" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_wayname" />
							</td>
						</tr>
						<tr>
							<td width="30%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="uniformtime" />>=
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_snl_uniformtime"
									onclick="this.value=selectDateYYYYMM();"></html:text>
							</td>
							<td width="30%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="uniformtime" /><=
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_snm_uniformtime"
									onclick="this.value=selectDateYYYYMM();"></html:text>
							</td>
						</tr>
						<tr>
							<td width="30%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="stdrewardut" key="cityid" />
								:
							</td>
							
							<td class="form_table_left">
							<s:RewardPurChk controlid="<%=PROVINCE%>" disableChild="true">
								<html:select property="_se_cityid">
									<html:option value=""></html:option>
									<s:Options definition="$region" />
								</html:select>
							</s:RewardPurChk>
							</td>
							<td width="30%" height="20" align="right"
								class="form_table_right">
								&nbsp;
							</td>
							<td class="form_table_left">
								&nbsp;
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
									onclick="doQuery('/cms/reward/stdrewardut.do?CMD=LISTCITY');" />
								<s:RewardPurChk controlid="<%=CITY%>" disableChild="true">
								<input type="button" name="btnAdd" class="button_8" value="<bean:message bundle="stdrewardut" key="newreward"/>"
									onclick="doEdit('<c:out value="${urlContent}"/>');" />
								<input type="button" name="btnDelete" class="button_6" value="删除酬金标准"
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
									设置情况
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="stdrewardut" key="wayid" />
									</a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('wayname')"><bean:message
											bundle="stdrewardut" key="wayname" />
									</a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="wayname" />
								</td>
								<td>
									<a href="javascript:doOrderby('cityid')"><bean:message
											bundle="stdrewardut" key="cityid" /> </a>
									<s:OrderImg form="/cms/reward/StdrewardutForm"
										field="cityid" />
								</td>
								<td>
									<a href="javascript:doOrderby('uniformtime')"><bean:message
											bundle="stdrewardut" key="uniformtime" /> </a>
									<s:OrderImg form="/cms/reward/StdrewardutForm" field="uniformtime" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/cms/reward/stdrewardut.do?CMD=EDITCITY" var="urlContent">
									<c:param name="PK" value="${item.wayid}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<input type="checkbox" name="_selectitem"
											value="<c:out value='${item.wayid}' />"
											onclick="checkOne();" class="table_checkbox">
									</td>
									<td>
									<c:choose>
										<c:when test="${item.setflag=='SET'}">
											<a href='<c:out value="${urlContent}"/>'><font color='blue'>已设置酬金标准</font>
											</a>
										</c:when>
										<c:otherwise>
											<a href='<c:out value="${urlContent}"/>'>
											<font color='red'>未设置酬金标准</font>
											</a>
										</c:otherwise>
									</c:choose>
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
                    				<td><c:out value="${item.wayname}"/></td>
                    				<td>
										<c:out value="${item.cityid}" />
									</td>
									<td>
										<c:out value="${item.uniformtime}" />
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





























