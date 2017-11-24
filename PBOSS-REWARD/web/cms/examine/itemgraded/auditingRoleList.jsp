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
	<base href="<%=basePath%>" target="_self">
    <title><bean:message bundle="itemgraded" key="auditList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_opername', '<bean:message bundle="itemgraded" key="opername"/>', 'c', 'false', '50');
            addfield('_se_operid', '<bean:message bundle="itemgraded" key="operid"/>', 'c', 'false', '32');
            return checkval(window);
        }
        function setValue(operid,opername){
			window.returnValue=operid+","+opername;
			window.close();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/itemgraded.do?CMD=Auditingrolelist" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/itemgraded/ItemgradedForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="itemgraded" key="auditList"/>
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
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="operid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_operid"></html:text>
                    
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="opername"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_opername"></html:text>
                </td>
                
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                      
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                
                <td>
                    <a href="javascript:doOrderby('operid')"><bean:message bundle="itemgraded" key="operid"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="operid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opername')"><bean:message bundle="itemgraded" key="opername"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="opername"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                    
                     <td>
                         <a href='#' onclick="javascript:setValue('<c:out value="${item.operid}"/>','<c:out value="${item.opername}"/>')"><c:out value="${item.operid}"/></a>
                     </td>
                     <td><c:out value="${item.opername}"/></td>
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
