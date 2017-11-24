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
    <title><bean:message bundle="registersucc" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="registersucc" key="opnid"/>', 'c', 'false', '12');
            addfield('_se_wayid', '<bean:message bundle="registersucc" key="wayid"/>', 'c', 'false', '15');
            addfield('_se_officetel', '<bean:message bundle="registersucc" key="officetel"/>', 'c', 'false', '15');
            return checkval(window);
        }
        function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/registersucc.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/registersucc/RegistersuccForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="registersucc" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="registersucc" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                    <input type="button" value="..." class="clickbutton"
										onclick="_se_opnid.value=getOpnId();">
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="registersucc" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:zoom definition="#WAY" property="_se_wayid" condition="waytype:AG;" styleClass="form_input_1x" nameOnly="false" readonly="false"/>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="registersucc" key="officetel"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_officetel"></html:text>
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
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="registersucc" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbc/registersucc/RegistersuccForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="registersucc" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/bbc/registersucc/RegistersuccForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="registersucc" key="wayid"/></a>
                    <s:OrderImg form="/cms/bbc/registersucc/RegistersuccForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="registersucc" key="oprtime"/></a>
                    <s:OrderImg form="/cms/bbc/registersucc/RegistersuccForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('officetel')"><bean:message bundle="registersucc" key="officetel"/></a>
                    <s:OrderImg form="/cms/bbc/registersucc/RegistersuccForm" field="officetel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="registersucc" key="mobile"/></a>
                    <s:OrderImg form="/cms/bbc/registersucc/RegistersuccForm" field="mobile"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/registersucc.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.oprtime}" />
                     </td>
                     <td><c:out value="${item.officetel}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
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
