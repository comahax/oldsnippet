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
    <title><bean:message bundle="hpolregistersucc" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="hpolregistersucc" key="wayid"/>', 'c', 'false', '15');
            addfield('_se_officetel', '<bean:message bundle="hpolregistersucc" key="officetel"/>', 'c', 'false', '15');
            addfield('_se_mobile', '<bean:message bundle="hpolregistersucc" key="mobile"/>', 'c', 'false', '15');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/hpolregistersucc.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/hpolregistersucc/HpolregistersuccForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="hpolregistersucc" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="hpolregistersucc" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:zoom definition="#WAY" property="_se_wayid" condition="waytype:AG;" styleClass="form_input_1x" nameOnly="false" readonly="false"/>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="hpolregistersucc" key="officetel"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_officetel"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="hpolregistersucc" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="hpolregistersucc" key="wayid"/></a>
                    <s:OrderImg form="/cms/bbc/hpolregistersucc/HpolregistersuccForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="hpolregistersucc" key="wayname"/></a>
                    <s:OrderImg form="/cms/bbc/hpolregistersucc/HpolregistersuccForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="hpolregistersucc" key="starlevel"/></a>
                    <s:OrderImg form="/cms/bbc/hpolregistersucc/HpolregistersuccForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('officetel')"><bean:message bundle="hpolregistersucc" key="officetel"/></a>
                    <s:OrderImg form="/cms/bbc/hpolregistersucc/HpolregistersuccForm" field="officetel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="hpolregistersucc" key="oprtime"/></a>
                    <s:OrderImg form="/cms/bbc/hpolregistersucc/HpolregistersuccForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="hpolregistersucc" key="mobile"/></a>
                    <s:OrderImg form="/cms/bbc/hpolregistersucc/HpolregistersuccForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="hpolregistersucc" key="startdate"/></a>
                    <s:OrderImg form="/cms/bbc/hpolregistersucc/HpolregistersuccForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('subnumber')"><bean:message bundle="hpolregistersucc" key="subnumber"/></a>
                    <s:OrderImg form="/cms/bbc/hpolregistersucc/HpolregistersuccForm" field="subnumber"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/hpolregistersucc.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td>
                     <s:Code2Name code="${item.starlevel}" definition="$CH_STARLEVEL"/>
                     </td>
                     <td><c:out value="${item.officetel}"/></td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.oprtime}" />
                     </td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}" />
                     </td>
                     <td><c:out value="${item.subnumber}"/></td>
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
