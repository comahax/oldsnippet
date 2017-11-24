<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_MENDREGISTER_VIEW";
    String ID_2 = "CH_PW_MENDREGISTER_DEL";
    String ID_3 = "CH_PW_MENDREGISTER_EXPORT";
%>
<html>
<head>
    <title><bean:message bundle="mendregister" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_mobile', '<bean:message bundle="mendregister" key="mobile"/>', 'c', 'false', '15');
            addfield('_se_officetel', '<bean:message bundle="mendregister" key="officetel"/>', 'c', 'false', '15');
            addfield('_dml_selltime', '<bean:message bundle="mendregister" key="selltime"/>', 'dt', 'false', '7');
            addfield('_dnl_selltime', '<bean:message bundle="mendregister" key="selltime"/>', 'dt', 'false', '7');
            addfield('_dml_optime', '<bean:message bundle="mendregister" key="optime"/>', 'dt', 'false', '7');
            addfield('_dnl_optime', '<bean:message bundle="mendregister" key="optime"/>', 'dt', 'false', '7');
            addfield('_se_success', '<bean:message bundle="mendregister" key="success"/>', 'c', 'false', '8');
            return checkval(window);
        }
        function upload(){
    		var form=document.forms[0];
    		form.action="<%=contextPath%>/cms/mendregister/batchupfile.jsp";
    		form.submit();
    	}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/mendregister.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/mendregister/MendregisterForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="mendregister" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mendregister" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mendregister" key="officetel"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_officetel"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mendregister" key="selltime"/>&gt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_selltime" onclick="selectDatetime();" ></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mendregister" key="selltime"/>&lt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_selltime" onclick="selectDatetime();" ></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mendregister" key="optime"/>&gt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="selectDatetime();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mendregister" key="optime"/>&lt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="selectDatetime();"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mendregister" key="success"/>:</td>
                <td width="30%" class="form_table_left">
                   <!--   <html:text styleClass="form_input_1x" property="_se_success"></html:text>  -->
                   <html:select property="_se_success">
						<option></option>
						<s:Options definition="#ISSUCCESS" />
					</html:select>
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
                        <s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk2>
                        <s:PurChk2 controlid="<%=ID_3%>" disableChild="true">
                        <input type="button" name="btnImport"  class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="导入" onClick="upload();">
                        </s:PurChk2>
                        <s:PurChk2 controlid="<%=ID_2%>" disableChild="true">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/mendregister.do')">
                        </s:PurChk2>
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
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="mendregister" key="seqid"/></a>
                    <s:OrderImg form="/cms/mendregister/MendregisterForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="mendregister" key="mobile"/></a>
                    <s:OrderImg form="/cms/mendregister/MendregisterForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('officetel')"><bean:message bundle="mendregister" key="officetel"/></a>
                    <s:OrderImg form="/cms/mendregister/MendregisterForm" field="officetel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('selltime')"><bean:message bundle="mendregister" key="selltime"/></a>
                    <s:OrderImg form="/cms/mendregister/MendregisterForm" field="selltime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="mendregister" key="optime"/></a>
                    <s:OrderImg form="/cms/mendregister/MendregisterForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="mendregister" key="oprcode"/></a>
                    <s:OrderImg form="/cms/mendregister/MendregisterForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="mendregister" key="success"/></a>
                    <s:OrderImg form="/cms/mendregister/MendregisterForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtremark')"><bean:message bundle="mendregister" key="adtremark"/></a>
                    <s:OrderImg form="/cms/mendregister/MendregisterForm" field="adtremark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seqid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.seqid}"/>
                     </td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.officetel}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.selltime}" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.optime}" /></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><s:Code2Name code="${item.success}" definition="#ISSUCCESS"/></td>
                     <td><c:out value="${item.adtremark}"/></td>
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
