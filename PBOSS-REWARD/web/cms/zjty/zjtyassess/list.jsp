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
    <title><bean:message bundle="zjtyassess" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	
            addfield('_se_wayid', '<bean:message bundle="zjtyassess" key="wayid"/>', 'c', 'false', '32');
            addfield('_se_calcmonth', '<bean:message bundle="zjtyassess" key="calcmonth"/>', 'c', 'false', '6');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtyassess.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtyassess/ZjtyassessForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtyassess" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyassess" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
<!--                    <s:myzoom definition="#WAY" property="_se_wayid" styleClass="form_input_1x" condition="waytype:${'AG'};waysubtype:${'ZJTY'};cityid:${cityid},GD;"  />-->
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." class="clickbutton" 
                    onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtyassess" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6" readonly="true"></html:text>
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/zjtyassess.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/zjtyassess.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doOther('/cms/zjty/zjtyassess.do?CMD=IMPORT')"/>
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="zjtyassess" key="wayid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyassess/ZjtyassessForm" field="wayid"/>
                </td>
                <td>
                	渠道名称
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="zjtyassess" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyassess/ZjtyassessForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef1')"><bean:message bundle="zjtyassess" key="coef1"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyassess/ZjtyassessForm" field="coef1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef2')"><bean:message bundle="zjtyassess" key="coef2"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyassess/ZjtyassessForm" field="coef2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef3')"><bean:message bundle="zjtyassess" key="coef3"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyassess/ZjtyassessForm" field="coef3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="zjtyassess" key="cityid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyassess/ZjtyassessForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('empnum')"><bean:message bundle="zjtyassess" key="empnum"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyassess/ZjtyassessForm" field="empnum"/>
                </td>                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/zjtyassess.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.calcmonth}|${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.calcmonth}|${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
                     <td><s:Code2Name code="${item.wayid }" definition="#WAY" /></td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.calcmonth}"/></a>
                     </td>
                     <td><c:out value="${item.coef1}"/></td>
                     <td><c:out value="${item.coef2}"/></td>
                     <td><c:out value="${item.coef3}"/></td>
                     <td><c:out value="${item.cityid}"/></td>
                     <td><c:out value="${item.empnum}"/></td>
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
