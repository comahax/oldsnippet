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
    <title><bean:message bundle="exmnrslt" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="exmnrslt" key="wayid"/>', 'c', 'false', '32');
            addfield('_ne_exmnid', '<bean:message bundle="exmnrslt" key="exmnid"/>', 'f', 'false', '6');
            addfield('_snm_exmnperiod', '<bean:message bundle="exmnrslt" key="exmnperiod"/>', 'c', 'false', '6');
            addfield('_snl_exmnperiod', '<bean:message bundle="exmnrslt" key="exmnperiod"/>', 'c', 'false', '6');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/exmnrslt.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnrslt/ExmnrsltForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnrslt" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnrslt" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton"
								onclick="showSelectWay3(this,'_se_wayid','','','');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnrslt" key="exmnid"/>:</td>
                <td width="30%" class="form_table_left">
                     <s:zoom definition="#EXAMINE" property="_ne_exmnid" styleClass="form_input_1x" />
                </td>
            </tr>
            <tr>
            	 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnrslt" key="_snl_exmnperiod"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snl_exmnperiod"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnrslt" key="_snm_exmnperiod"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snm_exmnperiod"></html:text>
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="exmnrslt" key="wayid"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="wayid"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="exmnrslt" key="wayname"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnid')"><bean:message bundle="exmnrslt" key="exmnname"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="exmnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnperiod')"><bean:message bundle="exmnrslt" key="exmnperiod"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="exmnperiod"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnmark')"><bean:message bundle="exmnrslt" key="exmnmark"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="exmnmark"/>
                </td>
                 <td>
                    <bean:message bundle="exmnrslt" key="look"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/exmnrslt.do?CMD=Infolist" var="urlInfoList">
                     <c:param name="_ne_exmnid" value="${item.exmnid}"/>
                     <c:param name="_se_wayid" value="${item.wayid}"/>
                     <c:param name="_se_exmnperiod" value="${item.exmnperiod}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.exmnid}|${item.exmnperiod}|${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     	<c:out value="${item.wayid}"/>
                     </td>
                     <td>
                         <s:Code2Name definition="#WAY" code="${item.wayid}"/>
                     </td>
                     <td>
                         <s:Code2Name definition="#EXAMINE" code="${item.exmnid}"/>
                     </td>
                     <td>
                         <c:out value="${item.exmnperiod}"/>
                     </td>
                     <td><c:out value="${item.exmnmark}"/></td>
                     <td><a href='<c:out value="${urlInfoList}"/>'><bean:message bundle="exmnrslt" key="info"/></a></td>
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
