<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    String cityid = request.getParameter("cityid");
%>
<html>
<head>
    <title><bean:message bundle="zjtybusitosmp" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_comid', '<bean:message bundle="zjtybusitosmp" key="comid"/>', 'd', true, '18');
            return checkval(window);
        }
        
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtybusitosmp.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_sort" />
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtybusitosmp/ZjtyBusitosmpForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtybusitosmp" key="titleList"/>
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
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="zjtybusitosmp" key="opnid" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
            		<s:myzoom definition="#ZJTY_OPERATION" property="_se_opnid" condition="opnid:65*,;isbusi:1;" styleClass="form_input_1x" readonly="true"/>
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="zjtybusitosmp" key="comid" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
            		<s:myzoom definition="#COMSYSTEM" property="_ne_comid" condition="cityid:${cityid};" styleClass="form_input_1x" readonly="true"/>
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/zjtybusitosmp.do')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/zjtybusitosmp.do')">
                        	<input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" />
                            <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doOther('/cms/zjty/zjtybusitosmp.do?CMD=IMPORT')"/>
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
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="zjtybusitosmp" key="opnid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtybusitosmp/ZjtybusitosmpForm" field="opnid"/>
                </td>
                	
                <td>
                	<bean:message bundle="zjtybusitosmp" key="opname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('comid')"><bean:message bundle="zjtybusitosmp" key="comid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtybusitosmp/ZjtybusitosmpForm" field="comid"/>
                </td>
                <td>
                	<bean:message bundle="zjtybusitosmp" key="comname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('sort')"><bean:message bundle="zjtybusitosmp" key="sort"/></a>
                    <s:OrderImg form="/cms/zjty/zjtybusitosmp/ZjtybusitosmpForm" field="sort"/>
                </td>
                <td>
                	映射名称
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/zjtybusitosmp.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.comid}|${item.opnid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}|${item.comid}|${item.opnid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/>
                     </td>
                     <td>
                         <s:Code2Name code="${item.opnid}" definition="#ZJTY_OPERATION" />
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.comid}"/>
                     </td>
                      <td>
                         <s:Code2Name code="${item.comid}" definition="#COMSYSTEM" />
                     </td>
                     <td>
                         <c:out value="${item.sort}"/>
                     </td>
                      <td>
                         <s:Code2Name code="${item.sort}" definition="$ZJTY_BUSITOSMPTYPE" />
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
