<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A1A" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><bean:message bundle="yxcfincome" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
			addfield('_ne_yxcfid', '<bean:message bundle="yxcfincome" key="yxcfid"/>', 'l', true, 14);
            addfield('_se_acctcode', '<bean:message bundle="yxcfincome" key="acctcode"/>', 'c', true, 32);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/yxcfincome.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="startindex" />
	<html:hidden property="endindex" />
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	
	<div class="table_div">		
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="yxcfincome" key="title"/></td>
				
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
                <td class="form_table_right"><bean:message bundle="yxcfincome" key="yxcfid"/>: </td>
                <td class="form_table_left"> 
                    <s:zoom definition="$PC_YXCHAIFENITEM" property="_ne_yxcfid" styleClass="form_input_1x"/>
                </td>        
               
                       
                <td class="form_table_right"><bean:message bundle="yxcfincome" key="acctcode"/>: </td>
                <td class="form_table_left"> 
                    
                    <html:text styleClass="form_input_1x" property="_se_acctcode"></html:text>
                </td>         
            </tr>    
        </table>
    </div>	
	<div class="table_div">		
		<table class="table_button_list">
			<tr>
			   <td>
                  <s:PurChk2 controlid="YXCFINCOME_NEW" disableChild="true">
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/fee/woff/yxcfincome.do')">
                  </s:PurChk2>
                  <s:PurChk2 controlid="YXCFINCOME_DET" disableChild="true">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/fee/woff/yxcfincome.do')">
                  </s:PurChk2>
                  <input type="button" class="query" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery()"/>
                    <s:PurChk2 controlid="YXCFINCOME_XLS" disableChild="true">
                    <input type="button" class="query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export"/>" onclick="doExcelOut('/fee/woff/yxcfincome.do?CMD=EXCELOUT')"/>
                     </s:PurChk2>
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
                    <a href="javascript:doOrderby('yxcfid')"><bean:message bundle="yxcfincome" key="yxcfid"/></a>
                    <s:OrderImg form="/fee/woff/yxcfincome/YxCfIncomeForm" field="yxcfid"/>
                </td>
                <td>
                     <a href="javascript:doOrderby('yxcfid')"><bean:message bundle="yxcfincome" key="yxcfidname"/></a>
                    <s:OrderImg form="/fee/woff/yxcfincome/YxCfIncomeForm" field="yxcfid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctcode')"><bean:message bundle="yxcfincome" key="acctcode"/></a>
                    <s:OrderImg form="/fee/woff/yxcfincome/YxCfIncomeForm" field="acctcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctcodename')"><bean:message bundle="yxcfincome" key="acctcodename"/></a>
                    <s:OrderImg form="/fee/woff/yxcfincome/YxCfIncomeForm" field="acctcodename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('descri')"><bean:message bundle="yxcfincome" key="descri"/></a>
                    <s:OrderImg form="/fee/woff/yxcfincome/YxCfIncomeForm" field="descri"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/fee/woff/yxcfincome.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.yxcfid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.yxcfid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                      <td>
                        <s:PurChk2 controlid="YXCFINCOME_EDIT" disableChild="true">
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.yxcfid}"/></a>
                         </s:PurChk2>
                     </td>
                       <td><s:Code2Name definition="$PC_YXCHAIFENITEM" code="${item.yxcfid}"></s:Code2Name>
                     </td>
                     
                     
                     <td><c:out value="${item.acctcode}"/></td>
                     <td><c:out value="${item.acctcodename}"/></td>
                     <td><c:out value="${item.descri}"/></td>
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
