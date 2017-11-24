<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_OPERATOR_ADD";
    String ID_2 = "CH_OPERATOR_DEL";
    String ID_3 = "CH_OPERATOR_IMPORT";
%>
<html>
<head>
    <title><bean:message bundle="operation" key="title"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_name', '<bean:message bundle="operation" key="name"/>', 'c', true, '50');
            return checkval(window);
        }
        
        function doDel(cmdDelete){
        	if(window.confirm("删除业务类型将会把该业务类型的所有子类型一起删除，确定吗？")){
        		formList.action = addParam(contextPath + cmdDelete, 'CMD', 'DELETE');
    			formList.submit();
    		}
        }
        function doImport(url){
			formList.action = contextPath + url + "?CMD=IMPORT";
       		formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/operation.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="operation" key="title"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operation" key="_se_opnid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operation" key="_sk_name"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_name"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operation" key="parentid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_parentid"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/operation.do')">
                        </s:PurChk2>
                        <s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDel('/cms/operation.do')">
                        </s:PurChk2>
						<s:PurChk2 controlid="<%=ID_3%>" disableChild="true">
							<input type="button" name="btnNew" class="query"
								onmouseover="buttonover(this);" onmouseout="buttonout(this);"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="saleway" key="button_imp"/>"
								onClick="doImport('/cms/operation.do')">
						</s:PurChk2>
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="operation" key="opnid"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')"><bean:message bundle="operation" key="name"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('businesstype')"><bean:message bundle="operation" key="businesstype"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="businesstype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="operation" key="state"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="state"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="operation" key="remark"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="remark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/operation.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.opnid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/></a>
                     </td>
                     <td><c:out value="${item.name}"/></td>
                     <td><s:Code2Name code="${item.parentid}" definition="#OPERATION"/></td>
                     <td><s:Code2Name code="${item.state}" definition="$CH_VALIDFLAG"/></td>
                     <td><c:out value="${item.remark}"/></td>
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
