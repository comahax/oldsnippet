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
    <title><bean:message bundle="chadtwaymod" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="chadtwaymod" key="wayid"/>', 'c', 'false', '18');
            return checkval(window);
        }
        
        function doExcel(){
        	wayid = document.getElementById("_se_wayid").value;
	    	formList.action="<%=contextPath%>/cms/chadtwaymod.do?CMD=EXCEL&_se_wayid="+wayid;
	    	formList.submit();
	    	formList.action="<%=contextPath%>/cms/chadtwaymod.do?CMD=LIST";
	    }
	    
	    function doImp(){
	    	location.href = "<%=contextPath%>/cms/chadtwaymod/batch.jsp";
	    }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtwaymod.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtwaymod/ChadtwaymodForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtwaymod" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtwaymod" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." 
                    	class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
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
	                    value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/chadtwaymod.do')">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
	                    onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                    value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/chadtwaymod.do')">
                	<input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doImp();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_import"/>" />
                	<input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExcel();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chadtwaymod" key="wayid"/></a>
                    <s:OrderImg form="/cms/chadtwaymod/ChadtwaymodForm" field="wayid"/>
                </td>
                <td><bean:message bundle="chadtwaymod" key="wayname"/></td>
                <td><bean:message bundle="chadtwaymod" key="vi"/></td>
                <td><bean:message bundle="chadtwaymod" key="area"/></td>
                <td><bean:message bundle="chadtwaymod" key="doorhead"/></td>
                <td><bean:message bundle="chadtwaymod" key="backboard"/></td>
                <td><bean:message bundle="chadtwaymod" key="propaganda"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/chadtwaymod.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
                     <td><s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
                     <td><c:out value="${item.vi}"/></td>
                     <td><c:out value="${item.area}"/></td>
                     <td><c:out value="${item.doorhead}"/></td>
                     <td><c:out value="${item.backboard}"/></td>
                     <td><c:out value="${item.propaganda}"/></td>
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
