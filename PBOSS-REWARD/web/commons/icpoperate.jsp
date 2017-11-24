<%@ page language="java" contentType="text/html;charset=GBK"%>

<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><bean:message bundle="icpoperate" key="selectTitle"/></title>
    <base target="_self">

    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_icpid', '<bean:message bundle="icpoperate" key="icpid"/>', 'c', true, 8);
            addfield('_se_operateid', '<bean:message bundle="icpoperate" key="operateid"/>', 'c', true, 5);
            addfield('_se_type', '<bean:message bundle="icpoperate" key="type"/>', 'l', true, 3);
            addfield('_sk_name', '<bean:message bundle="icpoperate" key="name"/>', 'c', true, 20);
            return checkval(window);
        }

        function frmSubmit(){
		if(document.all.rdo != null){
		
			var strChecks = "";
			var isnull = true;
			if (document.all.rdo.length != null) {
				for(var i=0;i<document.all.rdo.length;i++){
	
					if(document.all.rdo[i].checked){
						strChecks = document.all.rdo[i].id;
						isnull = false;
						break;
					}
				}
			}else{
				if(document.all.rdo.checked){
					strChecks = document.all.rdo.id;
					isnull = false;
				}
			}
	
			if(isnull){
				alert('<bean:message bundle="subscriber" key="selectmsg"/>');
			}
			else{
				window.returnValue=strChecks;
				window.close();
			}
		}	
	}

    </script>
</head>

<body>
<div class="table_container">
<html:form action="/fee/billing/icpoperate.do?CMD=ICPOPERATE" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td><bean:message bundle="icpoperate" key="selectTitle"/></td>
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
            	<td class="form_table_right"><bean:message bundle="icpoperate" key="icpid" />:</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_icpid"></html:text>
				</td>
				<td class="form_table_right"><bean:message bundle="icpoperate" key="operateid" />:</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_operateid"></html:text>
				</td>
			</tr>
			<tr>
            	<td class="form_table_right"><bean:message bundle="icpoperate" key="name" />:</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_sk_name"></html:text>
				</td>
				<td class="form_table_right"><bean:message bundle="icpoperate" key="type" />:</td>
				<td class="form_table_left">
					<html:select property="_se_type">
						<html:option value=""> </html:option>
						<s:Options definition="$IB_ICPBTYPE"></s:Options>
					</html:select>
				</td>
			</tr>
        </table>
    </div>

	<div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td>
                  <input type="button" class="query" onmouseover="buttonover(this);"
                         onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                         value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
                    <c:choose>
	                    <c:when test="${!empty requestScope.LIST.datas}">
		                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
		                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_submit"/>" onClick="frmSubmit();">
	                    </c:when>
	                    <c:otherwise>
	                    	<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
		                   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                      	value="<bean:message bundle="public" key="button_close"/>" onClick="window.close();">
	                    </c:otherwise>
                    </c:choose>

                 </td>
			</tr>
		</table>
	</div>			
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head"  >
                <td title="<bean:message bundle="public" key="list_title_select"/>" ></td>
                <td>
					<a href="javascript:doOrderby('icpid')"><bean:message bundle="icpoperate" key="icpid" /> </a>
					<s:OrderImg form="/fee/billing/icpoperate/IcpOperateForm" field="icpid" />
				</td>
                <td>
					<a href="javascript:doOrderby('operateid')"><bean:message bundle="icpoperate" key="operateid" /> </a>
					<s:OrderImg form="/fee/billing/icpoperate/IcpOperateForm" field="operateid" />
				</td>
				<td>
					<a href="javascript:doOrderby('type')"><bean:message bundle="icpoperate" key="type" /></a>
					<s:OrderImg form="/fee/billing/icpoperate/IcpOperateForm" field="type" />								
				</td>
				<td>
					<a href="javascript:doOrderby('name')"><bean:message bundle="icpoperate" key="name" /></a>
					<s:OrderImg form="/fee/billing/icpoperate/IcpOperateForm" field="name" />								
				</td>
            </tr>            
            <c:forEach var="item" items="${requestScope.LIST.datas}">

                 <tr class="table_style_content" onclick="document.all('<c:out value="${item.icpid}|${item.operateid}|"/>').checked=true">
                     <td>
                         <input type="radio" name="rdo"  class="table_checkbox" id="<c:out value="${item.icpid}|${item.operateid}|"/>">
                     </td>
                     <td><c:out value="${item.icpid}" /></td>
					<td><c:out value="${item.operateid}" /></td>
					<td><s:Code2Name code="${item.type}" definition="$IB_ICPBTYPE"/></td>					
					<td><c:out value="${item.name}" /></td>
                 </tr>
             </c:forEach>
        </table>
    </div>
    </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>

</html:form>
</div>
</body>
</html>
