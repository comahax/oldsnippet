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
    <title><bean:message bundle="chzdplatforminfo" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_productid', '<bean:message bundle="chzdplatforminfo" key="productid"/>', 'f', 'false', '18');
            addfield('_se_producttype', '<bean:message bundle="chzdplatforminfo" key="producttype"/>', 'c', 'false', '32');
            addfield('_se_zdplatform', '<bean:message bundle="chzdplatforminfo" key="zdplatform"/>', 'c', 'false', '32');
            addfield('_dnl_starttime', '<bean:message bundle="chzdplatforminfo" key="starttime"/>', 't', 'false', '7');
            addfield('_dnm_endtime', '<bean:message bundle="chzdplatforminfo" key="endtime"/>', 't', 'false', '7');
            addfield('_se_batchno', '<bean:message bundle="chzdplatforminfo" key="batchno"/>', 'c', 'false', '8');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chzdplatforminfo.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chzdplatforminfo/ChzdplatforminfoForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzdplatforminfo" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdplatforminfo" key="productid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_productid"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdplatforminfo" key="producttype"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_producttype"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdplatforminfo" key="zdplatform"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_zdplatform"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdplatforminfo" key="starttime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_starttime"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdplatforminfo" key="endtime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_endtime"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzdplatforminfo" key="batchno"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_batchno"></html:text>
                </td>
            </tr>
            <tr>
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
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/chzdplatforminfo.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/chzdplatforminfo.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="chzdplatforminfo" key="seq"/></a>
                    <s:OrderImg form="/cms/chzdplatforminfo/ChzdplatforminfoForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('productid')"><bean:message bundle="chzdplatforminfo" key="productid"/></a>
                    <s:OrderImg form="/cms/chzdplatforminfo/ChzdplatforminfoForm" field="productid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('producttype')"><bean:message bundle="chzdplatforminfo" key="producttype"/></a>
                    <s:OrderImg form="/cms/chzdplatforminfo/ChzdplatforminfoForm" field="producttype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('zdplatform')"><bean:message bundle="chzdplatforminfo" key="zdplatform"/></a>
                    <s:OrderImg form="/cms/chzdplatforminfo/ChzdplatforminfoForm" field="zdplatform"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('saleprice')"><bean:message bundle="chzdplatforminfo" key="saleprice"/></a>
                    <s:OrderImg form="/cms/chzdplatforminfo/ChzdplatforminfoForm" field="saleprice"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starttime')"><bean:message bundle="chzdplatforminfo" key="starttime"/></a>
                    <s:OrderImg form="/cms/chzdplatforminfo/ChzdplatforminfoForm" field="starttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('endtime')"><bean:message bundle="chzdplatforminfo" key="endtime"/></a>
                    <s:OrderImg form="/cms/chzdplatforminfo/ChzdplatforminfoForm" field="endtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="chzdplatforminfo" key="batchno"/></a>
                    <s:OrderImg form="/cms/chzdplatforminfo/ChzdplatforminfoForm" field="batchno"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/chzdplatforminfo.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.batchno}|${item.productid}|${item.producttype}|${item.zd_platform}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.batchno}|${item.productid}|${item.producttype}|${item.zd_platform}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><c:out value="${item.seq}"/></td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.productid}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.producttype}"/></a>
                     </td>
                     <td><c:out value="${item.zdplatform}"/></td>
                     <td><c:out value="${item.saleprice}"/></td>
                     <td><c:out value="${item.starttime}"/></td>
                     <td><c:out value="${item.endtime}"/></td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.batchno}"/></a>
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
