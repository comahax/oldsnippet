<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
    <title><bean:message bundle="directory" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_firstlevel', '<bean:message bundle="directory" key="_se_firstlevel"/>', 'c', 'false', '32');
            addfield('_se_secondlevel', '<bean:message bundle="directory" key="_se_secondlevel"/>', 'c', 'false', '32');
            addfield('_se_thirdlevel', '<bean:message bundle="directory" key="_se_thirdlevel"/>', 'c', 'false', '32');
            addfield('_se_opnid', '<bean:message bundle="directory" key="_se_opnid"/>', 'c', 'false', '32');
            return checkval(window);
        }
        
        function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl, arg, "dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/directory.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/directory/DirectoryForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="directory" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="directory" key="firstlevel"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_firstlevel"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="directory" key="secondlevel"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_secondlevel"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="directory" key="thirdlevel"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_thirdlevel"></html:text>
                </td>
    			<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="directory" key="_se_opnid"/>:</td>
            	<td width="30%" class="form_table_left">
               		<html:text property="_se_opnid" styleClass="form_input_1x"/>
               		<input type="button" value="..." class="clickbutton" onclick="_se_opnid.value=getOpnId();">
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
                    <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/bbc/directory.do')">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/bbc/directory.do')">
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
                <td><bean:message bundle="directory" key="opnid"/></td>
                <td><bean:message bundle="directory" key="firstlevel"/></td>
                <td><bean:message bundle="directory" key="secondlevel"/></td>
                <td><bean:message bundle="directory" key="thirdlevel"/></td>
                <td><bean:message bundle="directory" key="name"/></td>
                <td><bean:message bundle="directory" key="servicecode"/></td>
                <td><bean:message bundle="directory" key="reward"/></td>
                <td><bean:message bundle="directory" key="rewardstd"/></td>
                <td><bean:message bundle="directory" key="rule"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/directory.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.firstlevel}"/></td>
                     <td><c:out value="${item.secondlevel}"/></td>
                     <td><c:out value="${item.thirdlevel}"/></td>
                     <td><s:Code2Name code="${item.opnid}" definition="#BBC_OPERATION" /></td>
                     <td><c:out value="${item.servicecode}"/></td>
                     <td><c:out value="${item.reward}"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><c:out value="${item.rule}"/></td>
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
