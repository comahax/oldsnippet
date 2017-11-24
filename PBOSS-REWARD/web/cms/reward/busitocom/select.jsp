<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><bean:message bundle="busitocom" key="titleList"/></title>
    <base target="_self">

    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
       window.returnValue = "";
       function doOK(value) {
	   		window.returnValue = value;
	   		window.close();
	   }
	   function doQuery() {
		    for (var i = 0; i < formList.elements.length; i++) {
		        if (formList.elements(i).disabled == true && formList.elements(i).name != 'DNPTS')
		            formList.elements(i).disabled = false;
		    }
			resetPage();
			if(document.formList.onsubmit == null || document.formList.onsubmit())
			document.formList.submit();
	   }
    </script>
</head>

<body onload="loadforiframe();" onclose="javascript:window.returnValue = ''">
<div class="table_container">
<html:form action="/cms/reward/busitocom.do?CMD=SELECT" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_comid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/busitocom/BusitocomForm']}"/>

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td><bean:message bundle="busitocom" key="titleList" /></td>
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
            	<td class="form_table_right"><bean:message bundle="busitocom" key="comid"/>:</td>
                <td class="form_table_left">
                	<input type="text" value="<c:out value="${form._ne_comid}" />" class="form_input_1x" disabled="disabled">
                </td>
                <td class="form_table_right"><bean:message bundle="busitocom" key="comresid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_comresid" />
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
                                value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();"/>
        </td>
			</tr>
		</table>
	</div>
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head"  >
                <td>
                    <a href="javascript:doOrderby('comid')"><bean:message bundle="busitocom" key="comid"/></a>
                    <s:OrderImg form="/cms/reward/busitocom/BusitocomForm" field="comid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('comresid')"><bean:message bundle="busitocom" key="comresid"/></a>
                    <s:OrderImg form="/cms/reward/busitocom/BusitocomForm" field="comresid"/>
                </td>           
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr style="cursor:hand" class="table_style_content" align="center" onclick="doOK('<c:out value="${item.comresid}"/>');">
                     <td>
                         <c:out value="${item.comid}"/>
                     </td>
                     <td>
                         <c:out value="${item.comresid}"/>
                     </td>
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
