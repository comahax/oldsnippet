<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="mobchargebak" key="title" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('mobilenum', '<bean:message bundle="fee" key="mobileno"/>', 'l', true, 14);
            addfield('_ne_recid', '<bean:message bundle="mobchargebak" key="recid"/>', 'c', true, 32);
            addfield('_ne_status', '<bean:message bundle="mobchargebak" key="status"/>', 'i', true, 3);
            addfield('_dnl_crttime', '<bean:message bundle="mobchargebak" key="crttime"/>', 'dt', true, 20);  
            addfield('_dnm_crttime', '<bean:message bundle="mobchargebak" key="crttime"/>', 'dt', true, 20);  
            if(date_compare("_dnl_crttime","_dnm_crttime",'<bean:message bundle="fee" key="timeCompare"/>')) return; 
            return checkval(window);
        }
        
        function getCustData(){
    		if(!ev_check()) return false;
    		var servernum = document.all.mobilenum.value;
    		if( servernum!=null && servernum!="" ){
    			url = "<%=contextPath%>/commons/subscriber.do?CMD=SELECT&mobileno="+servernum;
    			custData = window.showModalDialog( url, "", "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
    			if( custData!=null && custData!="" ){
    				dataStr = custData.split("|");
    				document.formList._ne_eboxid.value = dataStr[4];    				 			    				
    			}else{
    			 return false;
    			}
    		}else
    			document.formList._ne_eboxid.value = "";    
    		doQuery();
    		return true;
    	}        
    </script>
	</head>

	<body onload="document.formList._ne_recid.focus();loadforiframe();">
		<div class="table_container">
			<html:form action="/fee/woff/mobchargebak.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_ne_eboxid" />
				<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="mobchargebak" key="title" />
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
							<td class="form_table_right">
								<bean:message bundle="mobchargebak" key="recid" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_ne_recid" maxlength="32"></html:text>
							</td>
							<td class="form_table_right">
								<bean:message bundle="fee" key="mobileno" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="mobilenum"></html:text>
							</td>
						</tr>
						<tr>
							<td class="form_table_right">
								<bean:message bundle="mobchargebak" key="status" />
								:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_status">
									<html:option value=""></html:option>
									<s:Options definition="#CHRSTATUS" nameOnly="false" />
								</html:select>
							</td>
							<td class="form_table_right"></td>
							<td class="form_table_left"></td>
						</tr>
						<tr>
							<td class="form_table_right">
								<bean:message bundle="mobchargebak" key="crttime" />
								>=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_crttime" onclick="this.value=selectDatetime()"></html:text>
							</td>
							<td class="form_table_right">
								<bean:message bundle="mobchargebak" key="crttime" />
								<=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_crttime" onclick="this.value=selectDatetime()"></html:text>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_search"/>" onclick="getCustData()" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<a href="javascript:doOrderby('recid')"><bean:message bundle="mobchargebak" key="recid" /></a>
									<s:OrderImg form="/fee/woff/mobchargebak/MobChargeBakForm" field="recid" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="eboxid" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="yxplanid" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="crttime" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="opercode" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="requesttime" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="cztype" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="sumamt" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="eboxdeta" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="falsereason" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="status" />
								</td>
								<td>
									<bean:message bundle="mobchargebak" key="dealtime" />
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<c:url value="/fee/woff/mobchargebak.do?CMD=EDIT" var="urlContent">
									<c:param name="PK" value="${item.recid}" />
									<c:param name="STATUS" value="${item.status}" />
								</c:url>
								<tr class="table_style_content" align="center">
									<td>
										<a href='<c:out value="${urlContent}"/>'><c:out value="${item.recid}" /></a>
									</td>
									<td>
										<c:out value="${item.eboxid}" />
									</td>
									<td>
										<s:Code2Name code="${item.yxplanid}" definition="#ZIFEE-YXPLAN" />
									</td>
									<td>
										<fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.crttime}" />
									</td>
									<td>
										<c:out value="${item.opercode}" />
									</td>
									<td>
										<fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.requesttime}" />
									</td>
									<td>
										<s:Code2Name code="${item.cztype}" definition="#CHR_CZTYPE" />
									</td>
									<td>
										<fmt:formatNumber type="currency" value="${item.sumamt}" />
									</td>
									<td>
										<c:out value="${item.eboxdeta}" />
									</td>
									<td>
										<c:out value="${item.falsereason}" />
									</td>
									<td>
										<s:Code2Name code="${item.status}" definition="#CHRSTATUS" />
									</td>
									<td>
										<fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.dealtime}" />
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
