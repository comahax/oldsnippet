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
    <title><bean:message bundle="operationlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
           
            addfield('_se_oprcode', '<bean:message bundle="operationlog" key="oprcode"/>', 'c', true, '16');
            addfield('_se_oprtype', '<bean:message bundle="operationlog" key="oprtype"/>', 'c', true, '6');
            addfield('_se_success', '<bean:message bundle="operationlog" key="success"/>', 'c', true, '6');
            addfield('_sk_name', '<bean:message bundle="operationlog" key="name"/>', 'c', true, '50');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/operationlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="operationlog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operationlog" key="_dnl_optime"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operationlog" key="_dnm_optime"/>:</td>
                <td class="form_table_left">
                     <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operationlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operationlog" key="oprtype"/>:</td>
                <td class="form_table_left">
                    <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operationlog" key="success"/>:</td>
                <td class="form_table_left">
                    <html:select property="_se_success">  <option></option>	 <s:Options  definition="$OPRRESULT"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operationlog" key="name"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_name"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operationlog" key="opnid"/>:</td>
                <td class="form_table_left" colspan="5">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
               <td>
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="operationlog" key="logid"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="operationlog" key="optime"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="operationlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="operationlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="operationlog" key="success"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="operationlog" key="opnid"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('businesstype')"><bean:message bundle="operationlog" key="businesstype"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="businesstype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')"><bean:message bundle="operationlog" key="name"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="operationlog" key="state"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="state"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="operationlog" key="remark"/></a>
                    <s:OrderImg form="/cms/operationlog/operationlogForm" field="remark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/operationlog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value=""/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.logid}"/></td>
                      <td> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.optime}"/> </td>
                     <td><c:out value="${item.oprcode}"/></td>
                      <td> <s:Code2Name code="${item.oprtype}" definition="$OPRTYPE"/> </td>
                     <td> <s:Code2Name code="${item.success}" definition="$OPRRESULT"/> </td> 
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.parentid}" definition="#OPERATION"/></td>
                     <td><c:out value="${item.name}"/></td>
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
