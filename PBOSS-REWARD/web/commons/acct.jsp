<%@ page language="java" contentType="text/html;charset=GBK"%>

<%@ include file="/inc/listhead.inc" %>
<%
	String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="fee" key="acct"/></title>
    <base target="_self">

    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_acctid', '<bean:message bundle="acct" key="acctid"/>', 'l', true, 14);
            addfield('_sk_acctname', '<bean:message bundle="acct" key="acctname"/>', 'c', true, 128);
            //addfield('_ne_accttype', '<bean:message bundle="acct" key="accttype"/>', 'i', true, 3);
            //addfield('_ne_acctstate', '<bean:message bundle="acct" key="acctstate"/>', 'i', true, 3);
            //addfield('_ne_acctlevel', '<bean:message bundle="acct" key="acctlevel"/>', 'i', true, 3);
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

<body onload="document.formList._sk_acctname.focus()">
<div class="table_container">
<html:form action="/fee/woff/acct.do?CMD=ACCT" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td><bean:message bundle="fee" key="acct"/></td>

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
            	<td class="form_table_right"><bean:message bundle="acct" key="acctid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_acctid"  maxlength="14"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="acct" key="acctname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_acctname"  maxlength="128"></html:text>
                </td>
            </tr>
            <%--<tr>
                <td class="form_table_right"><bean:message bundle="acct" key="acctstate"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_acctstate">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_ACCTSTATE"/>
                    </html:select>
                </td>
                <td class="form_table_right"><bean:message bundle="acct" key="accttype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_accttype">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_FEETYPE"/>
                    </html:select>
                </td>
                <td class="form_table_right"><bean:message bundle="acct" key="acctlevel"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_acctlevel">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_FEELEVEL"/>
                    </html:select>
                </td>
            </tr>
        --%>
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
                <td title="<bean:message bundle="public" key="list_title_select"/>" >

                </td>
                <td>
                    <a href="javascript:doOrderby('acctid')"><bean:message bundle="acct" key="acctid"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctname')"><bean:message bundle="acct" key="acctname"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="acctname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('accttype')"><bean:message bundle="acct" key="accttype"/></a>
                    <s:OrderImg form="/fee/woff/acct/AcctForm" field="accttype"/>
                </td>
                <td><bean:message bundle="acct" key="acctstate"/></td>
                <td><bean:message bundle="acct" key="starttime"/></td>
                <td><bean:message bundle="acct" key="stoptime"/></td>



            </tr>
            
            <c:forEach var="item" items="${requestScope.LIST.datas}">

                 <tr class="table_style_content" onclick="document.all('<c:out value="${item.acctid}|${item.acctname}|${item.accttype}|"/>').checked=true">
                     <td>
                         <input type="radio" name="rdo"  class="table_checkbox" id="<c:out value="${item.acctid}|${item.acctname}|${item.accttype}|"/>">
                     </td>
                     <td>
                         <c:out value="${item.acctid}"/>
                     </td>
                     <td>
                         <c:out value="${item.acctname}"/>
                     </td>
                     <td><s:Code2Name code="${item.accttype}" definition="$IB_FEETYPE"/></td>
                     <td><s:Code2Name code="${item.acctstate}" definition="$IB_ACCTSTATE"/></td>
                     <td><c:out value="${item.starttime}"/></td>
                     <td><c:out value="${item.stoptime}"/></td>

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
