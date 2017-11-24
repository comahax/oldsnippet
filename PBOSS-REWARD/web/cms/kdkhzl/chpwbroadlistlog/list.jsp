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
    <title><bean:message bundle="chpwbroadlistlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sn_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_snn_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_sl_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_snm_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_se_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_snl_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_sm_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_sne_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_sin_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_snin_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_sk_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            addfield('_snk_mobile', '<bean:message bundle="chpwbroadlistlog" key="mobile"/>', 'c', 'false', '15');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/kdkhzl/chpwbroadlistlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/kdkhzl/chpwbroadlistlog/ChpwbroadlistlogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpwbroadlistlog" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sn_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snn_mobile"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sl_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snm_mobile"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snl_mobile"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sm_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sne_mobile"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sin_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snin_mobile"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwbroadlistlog" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snk_mobile"></html:text>
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/kdkhzl/chpwbroadlistlog.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/kdkhzl/chpwbroadlistlog.do')">
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="chpwbroadlistlog" key="logid"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwbroadlistlog/ChpwbroadlistlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="chpwbroadlistlog" key="optime"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwbroadlistlog/ChpwbroadlistlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="chpwbroadlistlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwbroadlistlog/ChpwbroadlistlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="chpwbroadlistlog" key="mobile"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwbroadlistlog/ChpwbroadlistlogForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="chpwbroadlistlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwbroadlistlog/ChpwbroadlistlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="chpwbroadlistlog" key="success"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwbroadlistlog/ChpwbroadlistlogForm" field="success"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/kdkhzl/chpwbroadlistlog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.logid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.logid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.logid}"/></a>
                     </td>
                     <td><c:out value="${item.optime}"/></td>
                     <td><c:out value="${item.oprtype}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.success}"/></td>
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
