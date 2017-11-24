<%@ page language="java" contentType="text/html;charset=utf-8"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A7G04" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<%
    String ID_1 = "4D6F1A7G04BT1";
%>
<html>
<head>
    <title><bean:message bundle="accounting" key="titleList"/></title>
    <script language="JavaScript">
        function ev_check() {
            if( formList.year.value == "" && formList.month.value != "") {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else if( formList.year.value != "" && formList.month.value == "" ) {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else {
	     		formList._ne_validbillcyc.value = formList.year.value + formList.month.value;
			}                       
            addfield('_ne_validbillcyc', '<bean:message bundle="bltouchrule" key="billcyc" />', 'l', false, 8);
		    addfield('_se_batchnum', '<bean:message bundle="bltouchrule" key="batchnum" />', 'c', false, 3);
		    addfield('regiongroup', '<bean:message bundle="bltouchrule" key="region"/>', 'c', false, 200);	         
            return checkval(window);   
        }
        function doSOther(url) { 			    	
    		var url =  contextPath + url;
			var arg = new Array();
    		var hWnd = window.showModalDialog(url, arg, "dialogWidth:700px; dialogHeight:600px; status:no;resizable:yes;");
    		    
        }
        function setBatchNum(){  
	        if(document.all("_se_batchnum") != null && document.all("_se_batchnum").value == ""){
	        	document.all("_se_batchnum").value = "01";
	        }
        }

    </script>
</head>

<body onload="setBatchNum();loadforiframe();">
<div class="table_container">
<html:form action="/fee/accounting.do?CMD=JUSTSET" styleId="formList" method="post" onsubmit="return ev_check();">

    
	<html:hidden property="_ne_validbillcyc" />
    <html:hidden property="_orderby" />
	<html:hidden property="_desc" />
	<html:hidden property="_pageno" />
	<html:hidden property="_pagesize" />
	<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="accounting" key="titleList"/></td>			 
            	
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
                <td width="150" class="form_table_right"><bean:message bundle="bltouchrule" key="region"/>: </td>
                <td class="form_table_left" colspan="3">
                	<c:choose>
						<c:when test="${!empty _PURVIEW}">
							<s:MoreCheck definition="#CITYCOMPANY" property="regiongroup" styleClass="form_input_2x" disabled="true"/>
		                </c:when>
		                <c:otherwise>									
				            <s:MoreCheck definition="#CITYCOMPANY" property="regiongroup" styleClass="form_input_2x"/>
		                </c:otherwise>
		            </c:choose>
                </td>
            </tr>
            <tr>    
                <td class="form_table_right"><bean:message bundle="woffcust" key="validbillcyc" />:</td>
				<td class="form_table_left">
					<html:select property="year" styleClass="form_selects_y">
		                <html:option value=""> </html:option> 
		                <s:DateOptions type="#YY" desc="true" stepNowYear="1"/> 
		                </html:select><bean:message bundle="fee" key="year"/>
		            <html:select property="month" styleClass="form_selects_m">
		                <html:option value=""> </html:option> 
		                <s:DateOptions type="#MM" fillZero="true"/> 
		            </html:select><bean:message bundle="fee" key="month"/> 
				</td> 
				<td class="form_table_right"><bean:message bundle="bltouchrule" key="batchnum" />:</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_batchnum"></html:text>
				</td>        
            </tr>
        </table>
    </div>
	
	<div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td> 
			   		<s:PurChk controlid="<%=ID_1%>">
                 	<input type="button" class="button_6" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="出帐启动日志" onclick="doSOther('/fee/billing/billstartlog.do?CMD=LIST1');"/>
                    </s:PurChk>
			   		<s:PurChk controlid="<%=ID_1%>">
                 	<input type="button" class="button_6" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="有效帐务周期" onclick="doSOther('/fee/billing/validbillcyc.do?CMD=LIST1');"/>
                    </s:PurChk> 
			   		<s:PurChk controlid="<%=ID_1%>">
                 	<input type="button" class="button_6" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="出帐触发规则" onclick="doSOther('/fee/billing/bltouchrule.do?CMD=LIST1');"/>
                    </s:PurChk> 
			   		
			    
                 	<s:PurChk controlid="<%=ID_1%>">
                 	<input type="button" class="query" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();"/>
                    </s:PurChk> 
               </td> 	
			</tr>
		</table>
	</div>

</html:form>
<iframe  frameborder="0" class="loadframe" style="height:200px;" id="loadframe1" scrolling="no"
	src="<%= contextPath%>/fee/accounting.do?CMD=LIST&_ne_validbillcyc=<c:out value="${requestScope._ne_validbillcyc}"/>&_se_batchnum=<c:out value="${requestScope._se_batchnum}"/>&regiongroup=<c:out value="${requestScope.regiongroup}"/>"/>
</div>
</body>
</html>









