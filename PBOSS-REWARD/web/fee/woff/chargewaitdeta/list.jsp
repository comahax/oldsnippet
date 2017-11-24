<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%

%>
<html>
<head>
    <title><bean:message bundle="chargewait" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	if( formList.year.value == "" && formList.month.value != "") {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else if( formList.year.value != "" && formList.month.value == "" ) {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else {
	     		formList._ne_billcyc.value = formList.year.value + formList.month.value;
			}
        
        	addfield('_ne_eboxid', '<bean:message bundle="chargewait" key="eboxid"/>', 'l', true, 14);
            addfield('_ne_billcyc', '<bean:message bundle="chargewait" key="billcyc"/>', 'i', true, 8);
            addfield('_se_servnumber', '<bean:message bundle="chargewait" key="servnumber"/>', 'i', true, 20);
           
            return checkval(window);
        }
        function doAdj(url){
        	var TO = true;
    		var sis = formList.all("_selectitem");

    		if (forincheck(TO,sis,'确定要调整？')){
    			formList.action = addParam(contextPath + url, 'CMD', 'ADJ');
    			formList.submit();
    		}         
        }
        function doExcelOut() {
        	if(ev_check()){
        		setExcelOutPage('/fee/woff/chargewaitdeta.do?CMD=EXCELOUT');	        	
        	}
        }
        
    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/chargewaitdeta.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <html:hidden property="_ne_billcyc"/>
    <html:hidden property="startindex"/>
    <html:hidden property="endindex"/>
    
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="chargewait" key="titleList"/></td>
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
                <td class="form_table_right"><bean:message bundle="chargewait" key="eboxid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_eboxid" maxlength="14"></html:text>
                </td>                          
            	<td class="form_table_right"><bean:message bundle="chargewait" key="servnumber"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="servnumber" maxlength="20"></html:text>
                </td>	
               	<td class="form_table_right"><bean:message bundle="chargewait" key="billcyc"/>:</td>
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
                 	
                 <input type="button" class="query" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="调整" onclick="doAdj('/fee/woff/chargewaitdeta.do');"/>	
                 </td> 	
			</tr>
		</table>
	</div>
	
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('chargeid')"><bean:message bundle="chargewait" key="chargeid"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="chargeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('eboxid')"><bean:message bundle="chargewait" key="eboxid"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="eboxid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('subsid')"><bean:message bundle="chargewait" key="subsid"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="subsid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('servnumber')"><bean:message bundle="chargewait" key="servnumber"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="servnumber"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('billcyc')"><bean:message bundle="chargewait" key="billcyc"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="billcyc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adjflag')"><bean:message bundle="chargewait" key="adjflag"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="adjflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chargetype')"><bean:message bundle="chargewait" key="chargetype"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="chargetype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('iscredit')"><bean:message bundle="chargewait" key="iscredit"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="iscredit"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('reqtime')"><bean:message bundle="chargewait" key="reqtime"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="reqtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('source')"><bean:message bundle="chargewait" key="source"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="source"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="chargewait" key="memo"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargewaitdetaForm" field="memo"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adjchgid')"><bean:message bundle="chargewait" key="adjchgid"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargewaitdetaForm" field="adjchgid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="chargewait" key="oprcode"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargewaitdetaForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adjmemo')"><bean:message bundle="chargewait" key="adjmemo"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargewaitdetaForm" field="adjmemo"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('eboxstr')"><bean:message bundle="chargewait" key="eboxstr"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="eboxstr"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctstr')"><bean:message bundle="chargewait" key="acctstr"/></a>
                    <s:OrderImg form="/fee/woff/chargewaitdeta/chargeWaitDetaForm" field="acctstr"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/chargewaitdeta.do?CMD=VIEW" var="urlContent">
                     <c:param name="PK" value="${item.chargeid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.chargeid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><a href='<c:out value="${urlContent}"/>'><c:out value="${item.chargeid}"/></a></td>
                     <td><a href='<c:out value="${urlContent}"/>'><c:out value="${item.eboxid}"/></a></td>
                     <td><a href='<c:out value="${urlContent}"/>'><c:out value="${item.subsid}"/></a></td>
                     <td><c:out value="${item.servnumber}"/></td>
                     <td><c:out value="${item.billcyc}"/></td>
                     <td><s:Code2Name code="${item.adjflag}" definition="$IB_NULLADJSTATE"/></td>
                     <td><s:Code2Name code="${item.chargetype}" definition="#CHARGETYPE"/></td>
                     <td><s:Code2Name code="${item.iscredit}" definition="$IM_YESNO10"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.reqtime}" /></td>
                     <td><s:Code2Name code="${item.source}" definition="#CHARGE_SOURCE"/></td>
                     <td><c:out value="${item.memo}"/></td>
                     <td><c:out value="${item.adjchgid}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.adjmemo}"/></td>   
                     <td><c:out value="${item.eboxstr}"/></td>
                     <td><c:out value="${item.acctstr}"/></td>                     
                     
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
