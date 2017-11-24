<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><bean:message bundle="Way" key="titleList"/></title>
    <base target="_self">

    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="Way" key="wayid"/>', 'c', true, '18');
            addfield('_sk_wayname', '<bean:message bundle="Way" key="wayname"/>', 'c', true, '50');
            return checkval(window);
        }
        
       window.returnValue = "";
       function doOK(value) {
	   		window.returnValue = value;
	   		window.close();
	   }

    </script>
</head>

<body onload="loadforiframe();" onclose="javascript:window.returnValue = ''">
<div class="table_container">
<html:form action="/cms/way.do?CMD=SELECTUNVMSGBOX" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td><bean:message bundle="Way" key="titleList" /></td>
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
            	<td class="form_table_right"><bean:message bundle="Way" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"  maxlength="18"></html:text>
                </td>
                <td class="form_table_right"><bean:message bundle="Way" key="wayname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_wayname"  maxlength="50"></html:text>
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
        </td>
			</tr>
		</table>
	</div>
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head"  >
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="Way" key="wayid"/></a>
                    <s:OrderImg form="/cms/way/WayForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')"><bean:message bundle="Way" key="wayname"/></a>
                   	<s:OrderImg form="/cms/way/WayForm" field="wayname"/>
                </td>           
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr style="cursor:hand" class="table_style_content" align="center" onclick="doOK('<c:out value="${item.wayid}"/>');">
                     <td>
                         <c:out value="${item.wayid}"/>
                     </td>
                     <td>
                         <c:out value="${item.wayname}"/>
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
