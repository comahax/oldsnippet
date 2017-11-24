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
    <title><bean:message bundle="chpdrewardrule" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_coopertype', '<bean:message bundle="chpdrewardrule" key="coopertype"/>', 'f', 'false', '1');
            addfield('_se_subcategory', '<bean:message bundle="chpdrewardrule" key="subcategory"/>', 'c', 'false', '15');
            return checkval(window);
        }
        
        function doExport(url){
			formList.action = contextPath + url + "?CMD=EXCEL";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/provagent/chpdrewardrule.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/chpdrewardrule.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdrewardrule/ChpdrewardruleForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdrewardrule" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdrewardrule" key="coopertype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_ne_coopertype">
                    	<option></option>
						<s:Options definition="$PD_HZLX"/>
					</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdrewardrule" key="subcategory"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_se_subcategory">
                    	<option></option>
						<s:Options definition="$PD_JTCPZLX"/>
					</html:select>
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
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/chpdrewardrule.do')">
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" 
            			onclick="doExport('/cms/provagent/chpdrewardrule.do')" 
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
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="chpdrewardrule" key="ruleid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coopertype')"><bean:message bundle="chpdrewardrule" key="coopertype"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="coopertype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cooperrate')"><bean:message bundle="chpdrewardrule" key="cooperrate"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="cooperrate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('subcategory')"><bean:message bundle="chpdrewardrule" key="subcategory"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="subcategory"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase1')"><bean:message bundle="chpdrewardrule" key="phase1"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="phase1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase1rate')"><bean:message bundle="chpdrewardrule" key="phase1rate"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="phase1rate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase2')"><bean:message bundle="chpdrewardrule" key="phase2"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="phase2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase2rate')"><bean:message bundle="chpdrewardrule" key="phase2rate"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="phase2rate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase3rate')"><bean:message bundle="chpdrewardrule" key="phase3rate"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="phase3rate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('inusetime')"><bean:message bundle="chpdrewardrule" key="inusetime"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="inusetime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('outusetime')"><bean:message bundle="chpdrewardrule" key="outusetime"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="outusetime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('version')"><bean:message bundle="chpdrewardrule" key="version"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrewardrule/ChpdrewardruleForm" field="version"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/chpdrewardrule.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.ruleid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.ruleid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.ruleid}"/></a>
                     </td>
                     <td><s:Code2Name code="${item.coopertype}" definition="$PD_HZLX"/></td>
                     <td><c:out value="${item.cooperrate}"/></td>
                     <td><s:Code2Name code="${item.subcategory}" definition="$PD_JTCPZLX"/></td>
                     <td><c:out value="${item.phase1}"/></td>
                     <td><c:out value="${item.phase1rate}"/></td>
                     <td><c:out value="${item.phase2}"/></td>
                     <td><c:out value="${item.phase2rate}"/></td>
                     <td><c:out value="${item.phase3rate}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.inusetime}" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.outusetime}" /></td>
                     <td><c:out value="${item.version}"/></td>
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
