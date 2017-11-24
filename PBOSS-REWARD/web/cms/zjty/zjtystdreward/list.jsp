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
    <title><bean:message bundle="zjtystdreward" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seq', '<bean:message bundle="zjtystdreward" key="seq"/>', 'f', 'false', '16');
            addfield('_se_opnid', '<bean:message bundle="zjtystdreward" key="opnid"/>', 'c', 'false', '32');
            addfield('_ne_cityid', '<bean:message bundle="zjtystdreward" key="cityid"/>', 'f', 'false', '3');
            return checkval(window);
        }
        
        function doShowRuleDetail(ruleid){
			//alert(ruleid);
			formList.action ="<%=contextPath%>/cms/zjty/zjtystdreward.do?CMD=SHOWRULEDETAIL&PK="+ruleid;
			formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtystdreward.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtystdreward/ZjtystdrewardForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtystdreward" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtystdreward" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:myzoom definition="#ZJTY_OPERATION" property="_se_opnid" condition="opnid:6501010300001*,6501010300003*;isbusi:1;" styleClass="form_input_1x" readonly="false"/>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="zjtystdreward" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:select property="_ne_cityid" disabled="true">
										<html:option value=""></html:option>
										<s:Options definition="$region" />
									</html:select>
<!--                    <html:text styleClass="form_input_1x" property="_ne_cityid"></html:text>-->
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
<%--                        <s:PurChk controlid="<%=ID_1%>">--%>
<%--                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"--%>
<%--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/zjtystdreward.do')">--%>
<%--                        </s:PurChk>--%>
<%--                        <s:PurChk controlid="<%=ID_2%>">--%>
<%--                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"--%>
<%--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/zjtystdreward.do')">--%>
<%--                        </s:PurChk>--%>
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
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="zjtystdreward" key="seq"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="zjtystdreward" key="opnid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="opnid"/>
                </td>
                <td>
                    业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="zjtystdreward" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('intvmonth')"><bean:message bundle="zjtystdreward" key="intvmonth"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="intvmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="zjtystdreward" key="ruleid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="ruleid"/>
                </td>
                <td>
                    规则名称
                </td>
                <td>
                    规则细项
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="zjtystdreward" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="zjtystdreward" key="startdate"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="zjtystdreward" key="rewardid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="rewardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctype')"><bean:message bundle="zjtystdreward" key="acctype"/></a>
                    <s:OrderImg form="/cms/zjty/zjtystdreward/ZjtystdrewardForm" field="acctype"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/zjtystdreward.do?CMD=EDIT" var="urlContent">
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
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seq}"/></a>
                     </td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td>
                     	 <s:Code2Name code="${item.opnid}" definition="#ZJTY_OPERATION" />
                     </td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><c:out value="${item.intvmonth}"/></td>
                     <td><c:out value="${item.ruleid}"/></td>
                     <td>
                     	 <s:Code2Name code="${item.ruleid}" definition="#CH_ADT_RULE" />
                     </td>
                     <td>
			        	<input type="button" value="设置" class="query" onclick="doShowRuleDetail('<c:out value="${item.ruleid}"/>')" >
                     </td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="#CH_ZJTY_REWARDTYPE"/></td>
                     <td><fmt:formatDate value="${item.startdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><c:out value="${item.rewardid}"/></td>
                     <td><c:out value="${item.acctype}"/></td>
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
