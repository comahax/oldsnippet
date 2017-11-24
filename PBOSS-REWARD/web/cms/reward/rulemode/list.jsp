<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "00010703";
	String ID_2 = "00010704";
	String ID_3 = "00010703";
	String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="rulemode" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_ruleid', '<bean:message bundle="rulemode" key="ruleid"/>', 'c', 'false', '18');
            addfield('_se_cityid', '<bean:message bundle="rulemode" key="cityid"/>', 'c', 'false', '4');
            addfield('_sk_rulemodename', '<bean:message bundle="rulemode" key="rulemodename"/>', 'c', 'false', '250');
            return checkval(window);
        }
        function retrievePage(){
        	var sis = formList.all("_selectitem");
        	if(sis == null){
        		alert('请选择一条记录!');
        		return;
        	}
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.checked) {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox' && sis[i].checked) {
        				checkedNum++;
        				id = sis[i].value;
        			}
        		}
        	}
        	if (checkedNum != 1) {
        		alert('请选择一条记录!');
        		return;
        	}
        	formList.action = contextPath + '/cms/reward/rulerel.do?CMD=LIST&_pageno=1&_se_ruleid='+formList._se_ruleid.value+'&_se_cityid='+formList._se_cityid.value+'&rulemodeid='+id;
        	formList.submit();
        }
        function doReturn(){
        	formList.action = contextPath + '/cms/reward/rule.do?CMD=LIST';
        	formList.submit();
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/rulemode.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby" value=""/>
    <html:hidden property="_desc" value=""/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <html:hidden property="_se_ruleid"/>
    <html:hidden property="_se_cityid"/>
    
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/rulemode/RulemodeForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rulemode" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rulemode" key="ruleid"/>:</td>
                <td width="30%" class="form_table_left">
                	<c:out value="${form._se_ruleid}"/>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rulemode" key="rulename"/>:</td>
                <td width="30%" class="form_table_left">
                	<s:Code2Name code='${form._se_ruleid}' definition="#CH_ADT_RULE"/>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rulemode" key="rulemodename"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_rulemodename"></html:text>
                </td>
    			<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rulemode" key="cityid"/>:</td>
            	<td width="30%" class="form_table_left">
                	<s:Code2Name code="${form._se_cityid}" definition="#CITYIDNUM2NMAME"/>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                            <input type="button" name="btnRetrieve" class="button_6" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="rulemode" key="ruledetail"/>" onClick="retrievePage()">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/rulemode.do')">
	                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
	                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                                value="<bean:message bundle="public" key="button_search"/>" />
                        	<input type="button" class="back" onmouseover="buttonover(this);"
	                                onmouseout="buttonout(this);" onfocus="buttonover(this)" 
	                                onblur="buttonout(this)" onclick="doReturn();"
	                                value="<bean:message bundle="public" key="button_return"/>" />
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
                    <a href="javascript:doOrderby('rulemodeid')"><bean:message bundle="rulemode" key="rulemodeid"/></a>
                    <s:OrderImg form="/cms/reward/rulemode/RulemodeForm" field="rulemodeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="rulemode" key="ruleid"/></a>
                    <s:OrderImg form="/cms/reward/rulemode/RulemodeForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rulemodename')"><bean:message bundle="rulemode" key="rulemodename"/></a>
                    <s:OrderImg form="/cms/reward/rulemode/RulemodeForm" field="rulemodename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="rulemode" key="startdate"/></a>
                    <s:OrderImg form="/cms/reward/rulemode/RulemodeForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('enddate')"><bean:message bundle="rulemode" key="enddate"/></a>
                    <s:OrderImg form="/cms/reward/rulemode/RulemodeForm" field="enddate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="rulemode" key="remark"/></a>
                    <s:OrderImg form="/cms/reward/rulemode/RulemodeForm" field="remark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/rulemode.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.rulemodeid}"/>
                     <c:param name="_se_ruleid" value="${form._se_ruleid}"/>
                     <c:param name="_se_cityid" value="${form._se_cityid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.rulemodeid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.rulemodeid}"/></a>
                     </td>
                     <td><c:out value="${item.ruleid}"/></td>
                     <td><c:out value="${item.rulemodename}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.startdate}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.enddate}"/></td>
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
