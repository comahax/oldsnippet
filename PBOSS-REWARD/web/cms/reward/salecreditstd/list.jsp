<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="salecreditstd" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_busitype', '<bean:message bundle="salecreditstd" key="busitype"/>', 'f', 'false', '22');
            return checkval(window);
        }
        function checkRuleitem(checkvalue){
        	
        	//if (ev_checkval()) {
       	 	//	enable();
       	 	var sis = formList.all("ruleitemids");
       	 	var pv= formList.all("paramervalues");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox'&& sis[i].checked ) {
        				checkedNum++;
        				id = sis[i].value;
        				pv[i].disabled=false;
        			}
        			if (sis[i].type == 'checkbox'&& !(sis[i].checked) ) {
        				pv[i].disabled=true;
        				
        			}
        		}
        		
        		
        	}
        	
  			<%-- 
  			ajaxAnywhere.submitByURL( '/cms/reward/salecreditstd.do?CMD=CANCELRULEITEM&ruleitemid='+checkvalue);  
  			formList.action=contextPath+"/cms/reward/salecreditstd.do?CMD=LIST";
  			--%>
  	
        }
        
        function doSave(cmdSave) {
    		//if (ev_checkval()) {
       	 	//	enable();
       	 	var sis = formList.all("ruleitemids");
       	 	var pv= formList.all("paramervalues");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox'&& sis[i].checked ) {
        				checkedNum++;
        				id = sis[i].value;
        				pv.disabled=false;
        				 
        			}
        			
        		}
        	}
        	/*
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	*/
			
       		 formList.action = contextPath + cmdSave;
       		 formList.submit();
   			// }
   		 //	return false;
		}
		
		function doDetails(){
	    	formList.action="<%=contextPath%>/cms/reward/salecreditstd.do?CMD=DETAILS";
	    	formList.submit();
	    }
		
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/salecreditstd.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/salecreditstd/SalecreditstdForm']}"/>
	<!-- <c:set var="formvalue" scope="request" value="${requestScope['/cms/reward/rulerel/RulerelForm']}"/>
    ##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="salecreditstd" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="salecreditstd" key="busitype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_busitype">
                    	<option />
                    	<s:Options definition="$CH_CREDIT_ACCOUNT" />
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ></td>
                <td width="30%" class="form_table_left">
                    
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_6" onmouseover="buttonover(this);"
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="规则细项设置" onClick="doDetails()">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/salecreditstd.do')">
                        <%-- <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/salecreditstd.do')">
                        </s:PurChk> --%>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <!-- <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>-->
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="salecreditstd" key="cityid"/></a>
                    <s:OrderImg form="/cms/reward/salecreditstd/SalecreditstdForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busitype')"><bean:message bundle="salecreditstd" key="busitype"/></a>
                    <s:OrderImg form="/cms/reward/salecreditstd/SalecreditstdForm" field="busitype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('creditstd')"><bean:message bundle="salecreditstd" key="creditstd"/></a>
                    <s:OrderImg form="/cms/reward/salecreditstd/SalecreditstdForm" field="creditstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('limited')"><bean:message bundle="salecreditstd" key="limited"/></a>
                    <s:OrderImg form="/cms/reward/salecreditstd/SalecreditstdForm" field="limited"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('updatetime')"><bean:message bundle="salecreditstd" key="updatetime"/></a>
                    <s:OrderImg form="/cms/reward/salecreditstd/SalecreditstdForm" field="updatetime"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/salecreditstd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <!-- <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>-->
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.cityid}"/></a>
                     </td>
                     <!-- <td><c:out value="${item.cityid}"/></td> -->
                     <td><s:Code2Name code="${item.busitype}" definition="$CH_CREDIT_ACCOUNT"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.creditstd}" /></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.limited}" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.updatetime}" /></td>
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
