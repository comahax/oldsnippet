<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="com.sunrise.boss.common.base.db.SessionFactoryRouter,com.sunrise.boss.ui.commons.User;"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_WAITAUDIT_AUDIT"; //省级酬金管理令牌
	String ID_2 = "CH_PW_DISINTEGRALEXPORT"; //市级酬金管理令牌
	    request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(((User)request.getSession().getAttribute("_USER")).getCityid()));
%>
<html xmlns="http://www.w3.org/1999/xhtml"-->
	<head>
		<title><bean:message bundle="disintegral" key="titleList" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
		<script language="JavaScript" type="text/JavaScript">

        function ev_check() {
            return checkval(window);
        }
        
 //       function doDelete() {
//		    formList.action = "<%=contextPath%>/cms/reward/disintegral.do?CMD=DELETE";
//		    formList.submit();
//		    formList.action = "<%=contextPath%>/cms/reward/disintegral.do?CMD=LIST";
//		}
		
		var msgNotSelected="<bean:message bundle="disintegral" key="msgNotSelected"/>"
    	var msgAuditConfirm="<bean:message bundle="disintegral" key="msgDeleteConfirm"/>"
		function doDelete(){
    		
    		var TO = true;
    		var sis = formList.all("_selectitem");
    		if (forincheck(TO,sis,msgAuditConfirm)){
    			formList.action = "<%=contextPath%>/cms/reward/disintegral.do?CMD=DELETE";
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
			
		function doImport(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/reward/disintegral/batch.jsp";
			form.submit();
		}
				function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
    </script>

	</head>

	<body onload="loadforiframe1();">
		<div class="table_container">
			<html:form action="/cms/reward/disintegral.do?CMD=LIST"
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
								<bean:message bundle="disintegral" key="titleList" />
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
								<bean:message bundle="disintegral" key="wayid" />
								:
							</td>
							<td class="form_table_left">
								<s:zoom definition="#WAY" property="_se_wayid" condition="waytype:AG;waysubtype:DIS;cityid:${cityid};waystate:1;" styleClass="form_input_1x" nameOnly="false" readonly="false"/>
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="disintegral" key="integraltype" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_integraltype">
									<html:option value=""></html:option>
									<s:Options definition="$CH_INTEGRALTYPE" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="disintegral" key="calmonth" />
								>=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_nnl_calmonth"
									onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
							</td>
							<td width="20%" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="disintegral" key="calmonth" />
								<=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_nnm_calmonth"
									onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
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
									onclick="doQuery('/cms/reward/disintegral.do?CMD=LIST');" />
									<s:RewardPurChk controlid="<%=ID_2%>">
									<input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doImport()"
                                		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                		value='<bean:message bundle="public" key="button_import"/>' />
                                	</s:RewardPurChk>
                                	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                                	<input type="button" name="btnAuditing" class="button_2" value='审核' onClick="doReturnInFrame('/cms/waitaudit.do?CMD=LIST&ISAUDIT=DISINTEGRAL')">
                                	</s:RewardPurChk>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message
											bundle="disintegral" key="wayid" />
									</a>
									<s:OrderImg form="/cms/reward/DisintegralForm" field="wayid" />
								</td>
								<td>
									<a href="javascript:doOrderby('calmonth')"><bean:message
											bundle="disintegral" key="calmonth" />
									</a>
									<s:OrderImg form="/cms/reward/DisintegralForm" field="calmonth" />
								</td>
								<td>
									<a href="javascript:doOrderby('integraltype')"><bean:message
											bundle="disintegral" key="integraltype" /> </a>
									<s:OrderImg form="/cms/reward/DisintegralForm"
										field="integraltype" />
								</td>
								<td>
									<a href="javascript:doOrderby('integralnum')"><bean:message
											bundle="disintegral" key="integralnum" /> </a>
									<s:OrderImg form="/cms/reward/DisintegralForm" field="integralnum" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td>
										<s:Code2Name code="${item.wayid}" definition="#WAY" />
									</td>
                    				<td><c:out value="${item.calmonth}"/></td>
                    				<td>
                    					<s:Code2Name code="${item.integraltype}" definition="$CH_INTEGRALTYPE" />
									</td>
									<td>
										<c:out value="${item.integralnum}" />
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





























