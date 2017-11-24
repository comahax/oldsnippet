<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
    <title><bean:message bundle="ruleonbusi" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_se_ruleid', '<bean:message bundle="ruleonbusi" key="ruleid"/>', 'c', true, '18');
        	addfield('_se_opnid', '<bean:message bundle="ruleonbusi" key="opnid"/>', 'c', true, '18');
            return checkval(window);
        }
        
        function doNew() {
        	var url = contextPath + '/cms/reward/ruleonbusi.do?CMD=NEW';
        	formList.ruleid.value = formList._se_ruleid.value;
        	formList.action = url;
        	formList.submit();
        }
        
        function doReturn() {
        	var url = contextPath + '/cms/reward/rule.do?CMD=LIST&_pageno=1';
        	formList.action = url;
        	formList._se_ruleid.value = '';
        	formList.submit();
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/ruleonbusi.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="ruleid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="ruleonbusi" key="titleList"/>
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
    			<td width="80" height="20" align="right" class="form_table_right" >
                   <bean:message bundle="ruleonbusi" key="ruleid"/>:
            	</td>
            	<td class="form_table_left">
               	  <html:text styleClass="form_input_1x" property="_se_ruleid" readonly="true" />
            	</td>
            	<td width="80" height="20" align="right" class="form_table_right" >
                    <bean:message bundle="ruleonbusi" key="opnid"/>:
            	</td>
            	<td class="form_table_left">
               	  <html:text styleClass="form_input_1x" property="_se_opnid" maxlength="60" />
               	  <input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, '_se_opnid' , 'busi' )">
            	</td>
         </tr>
         <tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                   <bean:message bundle="ruleonbusi" key="rulename"/>
            	</td>
            	<td class="form_table_left">
               	  <html:text styleClass="form_input_1x" property="_sk_name"/>
            	</td>
            	<td width="80" height="20" align="right" class="form_table_right" >
                    
            	</td>
            	<td class="form_table_left">
            	</td>
         </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew()">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/ruleonbusi.do')">
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn()">
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
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="ruleonbusi" key="ruleid"/></a>
                    <s:OrderImg form="/cms/reward/ruleonbusi/ruleonbusiForm" field="ruleid"/>
                </td>
                <td>
                    <bean:message bundle="ruleonbusi" key="rulename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="ruleonbusi" key="opnid"/></a>
                    <s:OrderImg form="/cms/reward/ruleonbusi/ruleonbusiForm" field="opnid"/>
                </td>
                <td>
                    <bean:message bundle="ruleonbusi" key="opnname"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}|${item.ruleid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.ruleid}"/>
                     </td>
                     <td>
                         <s:Code2Name definition="#CH_ADT_RULE" code="${item.ruleid}" />
                     </td>
                     <td>
                         <c:out value="${item.opnid}"/>
                     </td>
                     <td>
                         <s:Code2Name definition="#OPERATION" code="${item.opnid}" />
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
