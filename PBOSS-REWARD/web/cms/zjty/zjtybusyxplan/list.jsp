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
    <title><bean:message bundle="zjtybusyxplan" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_se_prodid', '<bean:message bundle="zjtybusyxplan" key="prodid"/>', 'd', true, '18');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtybusyxplan.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtybusyxplan/ZjtybusyxplanForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtybusyxplan" key="titleList"/>
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
                	<bean:message bundle="zjtybusyxplan" key="prodid" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_se_prodid"/>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="zjtybusyxplan" key="opnid" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<s:myzoom definition="#ZJTY_OPERATION" property="_se_opnid" condition="opnid:6501010300001*,6501010300003*;isbusi:1;" styleClass="form_input_1x" readonly="false"/>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="zjtybusyxplan" key="_se_cityid" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:select property="_se_cityid">
						<html:option value=""></html:option>
						<s:Options definition="#CITYIDNUM2NMAME" />
					</html:select>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >&nbsp;</td>
            	<td width="30%" class="form_table_left">&nbsp;</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                    <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                    	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                   		value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/zjtybusyxplan.do')">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                    	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                    	value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/zjtybusyxplan.do')">
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doOther('/cms/zjty/zjtybusyxplan.do?CMD=IMPORT')"/>
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
                    <a href="javascript:doOrderby('prodid')"><bean:message bundle="zjtybusyxplan" key="prodid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtybusyxplan/ZjtybusyxplanForm" field="prodid"/>
                </td>
                <td>
                       产品名称
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="zjtybusyxplan" key="opnid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtybusyxplan/ZjtybusyxplanForm" field="opnid"/>
                </td>
                <td>
                	业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('planbusitype')"><bean:message bundle="zjtybusyxplan" key="planbusitype"/></a>
                    <s:OrderImg form="/cms/zjty/zjtybusyxplan/ZjtybusyxplanForm" field="planbusitype"/>
                </td>
                <td>
                	映射名称
                </td>
                <td>
                	套餐值
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/zjtybusyxplan.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.opnid}|${item.prodid}|${item.cityid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}|${item.prodid}|${item.cityid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.prodid}"/>
                     </td>
                     <td>
                     	 <s:Code2Name code="${item.prodid}" definition="#CRMPCPPPRODUCT" />
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/>
                     </td>
                     <td>
                     	 <s:Code2Name code="${item.opnid}" definition="#ZJTY_OPERATION" />
                     </td>
                     <td>
                         <c:out value="${item.planbusitype}"/>
                     </td>
                     <td>
                     	 <s:Code2Name code="${item.planbusitype}" definition="$ZJTY_BUSYXPLANTYPE" />
                     </td>
                     <td>
                         <c:out value="${item.wrapfee}"/>
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
