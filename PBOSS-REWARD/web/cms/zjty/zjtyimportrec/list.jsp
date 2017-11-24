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
    <title><bean:message bundle="zjtyimportrec" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seq', '<bean:message bundle="zjtyimportrec" key="seq"/>', 'f', 'false', '14');
            addfield('_se_calcmonth', '<bean:message bundle="zjtyimportrec" key="calcmonth"/>', 'c', 'false', '8');
            addfield('_se_opnid', '<bean:message bundle="zjtyimportrec" key="opnid"/>', 'c', 'false', '18');
            addfield('_se_wayid', '<bean:message bundle="zjtyimportrec" key="wayid"/>', 'c', 'false', '18');
            addfield('_se_mobile', '<bean:message bundle="zjtyimportrec" key="mobile"/>', 'c', 'false', '15');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtyimportrec.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtyimportrec/ZjtyImportrecForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtyimportrec" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyimportrec" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text><input type="button" value="..." class="clickButton"
					onclick="showZjtyOpnTree(this, '_se_opnid','busi')">
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyimportrec" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." class="clickbutton" 
                    onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY');this.value='...';" />
                </td>
            </tr>
            <tr>
               <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyimportrec" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
            	</td>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
<!--                        <s:PurChk controlid="<%=ID_1%>">-->
<!--                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"-->
<!--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"-->
<!--                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/zjtyimportrec.do')">-->
<!--                        </s:PurChk>-->
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/zjtyimportrec.do')">
                        </s:PurChk>
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doOther('/cms/zjty/zjtyimportrec.do?CMD=IMPORT')"/>
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
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="zjtyimportrec" key="seq"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="zjtyimportrec" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="zjtyimportrec" key="opnid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="opnid"/>
                </td>
                <td>
                	业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="zjtyimportrec" key="wayid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="wayid"/>
                </td>
                <td>
                	渠道名称
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="zjtyimportrec" key="oprtime"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="zjtyimportrec" key="oprcode"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="zjtyimportrec" key="mobile"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busivalue')"><bean:message bundle="zjtyimportrec" key="busivalue"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="busivalue"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><bean:message bundle="zjtyimportrec" key="brand"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="brand"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('datasource')"><bean:message bundle="zjtyimportrec" key="datasource"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="datasource"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('validflag')"><bean:message bundle="zjtyimportrec" key="validflag"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="validflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="zjtyimportrec" key="remark"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyimportrec/ZjtyimportrecForm" field="remark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/zjtyimportrec.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
<!--                         <a href='<c:out value="${urlContent}"/>'>-->
                         <c:out value="${item.seq}"/>
<!--                         </a>-->
                     </td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.opnid }" definition="#ZJTY_OPERATION" /></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.wayid }" definition="#WAY" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" /></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td><c:out value="${item.brand}"/></td>
                     <td><c:out value="${item.datasource}"/></td>
                     <td><c:out value="${item.validflag}"/></td>
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
