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
    <title><bean:message bundle="chpdreportitem" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_cityid', '<bean:message bundle="chpdreportitem" key="_se_cityid"/>', 'c', false, '15');
            return checkval(window);
        }
        
        function doExport(url){
			if (ev_check()) {
				formList.action = contextPath + url + "?CMD=EXCEL";
	  			formList.submit();
	  			formList.action="<%=contextPath%>/cms/provagent/chpdreportitem.do?CMD=LIST";
	  		}
		}
        
        function doReport(url){
			addfield('_se_provagentid', '<bean:message bundle="chpdreportitem" key="provagentid"/>', 'c', false, '15');
            addfield('_se_rewardmonth', '<bean:message bundle="chpdreportitem" key="rewardmonth"/>', 'c', false, '8');
			if (checkval(window)) {
				formList.action = contextPath + url + "?CMD=REPORT";
	  			formList.submit();
	  			formList.action="<%=contextPath%>/cms/provagent/chpdreportitem.do?CMD=LIST";
			}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/chpdreportitem.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="query" value="true"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdreportitem/ChpdreportitemForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdreportitem" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdreportitem" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_se_cityid">
						<option/>
						<s:Options definition="#REGIONNAME"/>
					</html:select>
					<font color='red'>*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdreportitem" key="provagentid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_se_provagentid">
                    	<option></option>
						<s:Options definition="#CH_PD_AGENT"/>
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpdreportitem" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM();"></html:text>
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
                    <!-- 
                    <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/chpdreportitem.do')">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/provagent/chpdreportitem.do')">
                     -->
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" 
            			onclick="doExport('/cms/provagent/chpdreportitem.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" 
            			onclick="doReport('/cms/provagent/chpdreportitem.do')" onmouseout="buttonout(this);" 
            			onfocus="buttonover(this)" onblur="buttonout(this)" value="报表导出" />
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
                    <a href="javascript:doOrderby('itemid')"><bean:message bundle="chpdreportitem" key="itemid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdreportitem/ChpdreportitemForm" field="itemid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chpdreportitem" key="cityid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdreportitem/ChpdreportitemForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('provagentid')"><bean:message bundle="chpdreportitem" key="provagentid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdreportitem/ChpdreportitemForm" field="provagentid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('provagentid')"><bean:message bundle="chpdreportitem" key="provagentname"/></a>
                    <s:OrderImg form="/cms/provagent/chpdreportitem/ChpdreportitemForm" field="provagentid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="chpdreportitem" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/provagent/chpdreportitem/ChpdreportitemForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('columncode')"><bean:message bundle="chpdreportitem" key="columncode"/></a>
                    <s:OrderImg form="/cms/provagent/chpdreportitem/ChpdreportitemForm" field="columncode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('columnname')"><bean:message bundle="chpdreportitem" key="columnname"/></a>
                    <s:OrderImg form="/cms/provagent/chpdreportitem/ChpdreportitemForm" field="columnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardsum')"><bean:message bundle="chpdreportitem" key="rewardsum"/></a>
                    <s:OrderImg form="/cms/provagent/chpdreportitem/ChpdreportitemForm" field="rewardsum"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/chpdreportitem.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.itemid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.itemid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><c:out value="${item.itemid}"/></td>
                     <td><s:Code2Name code="${item.cityid}" definition="#REGIONNAME"/></td>
                     <td><c:out value="${item.provagentid}"/></td>
                     <td><s:Code2Name code="${item.provagentid}" definition="#CH_PD_AGENT"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.columncode}"/></td>
                     <td><c:out value="${item.columnname}"/></td>
                     <td><c:out value="${item.rewardsum}"/></td>
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
