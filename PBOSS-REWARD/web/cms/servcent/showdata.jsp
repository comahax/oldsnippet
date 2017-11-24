<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title>销售服务中心查询</title>
    <base target="_self">

    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_svccode', '销售服务中心', 'i', true, 14);
            addfield('_sk_svcname', '销售服务中心名称', 'c', true, 20);
            return checkval(window);
        }
        
       window.returnValue = "";
       function doOK(code) {
	   		window.returnValue = code;
	   		window.close();
	   }

    </script>
</head>

<body onload="loadforiframe();" onclose="javascript:window.returnValue = ''">
<div class="table_container">
<html:form action="/cms/servcent.do?CMD=SHOWDATA" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_countyid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td>销售服务中心查询</td>
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
    			<td width="80" height="20" align="right" class="form_table_right" >
                	销售服务中心:
            	</td>
            	<td class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_se_svccode" ></html:text>
            	</td>
                <td width="126" height="20" align="right" class="form_table_right">
                	销售服务中心名称:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_svcname" ></html:text>
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
                    <a href="javascript:doOrderby('svccode')">销售服务中心</a>
                    <s:OrderImg form="/cms/servcent/ServcentForm" field="svccode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('svcname')">销售服务中心名称</a>
                    <s:OrderImg form="/cms/servcent/ServcentForm" field="svcname"/>
                </td>           
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr style="cursor:hand" class="table_style_content" align="center" onclick="doOK('<c:out value="${item.svccode}"/>');">
                     <td>
                         <c:out value="${item.svccode}"/>
                     </td>
                     <td>
                         <c:out value="${item.svcname}"/>
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
