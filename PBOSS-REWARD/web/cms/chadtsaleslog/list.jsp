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
    <title><bean:message bundle="chadtsaleslog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtsaleslog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtsaleslog/ChadtsaleslogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtsaleslog" key="titleList"/>
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
                        <s:RewardPurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/chadtsaleslog.do')">
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/chadtsaleslog.do')">
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:RewardPurChk>
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="chadtsaleslog" key="logid"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="chadtsaleslog" key="optime"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="chadtsaleslog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="chadtsaleslog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="chadtsaleslog" key="success"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chadtsaleslog" key="cityid"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="chadtsaleslog" key="opnid"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayattr')"><bean:message bundle="chadtsaleslog" key="wayattr"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="wayattr"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('sales')"><bean:message bundle="chadtsaleslog" key="sales"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="sales"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="chadtsaleslog" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/chadtsaleslog/ChadtsaleslogForm" field="rewardstd"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/chadtsaleslog.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.oprtype}"/></td>
                     <td><c:out value="${item.success}"/></td>
                     <td><c:out value="${item.cityid}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.wayattr}"/></td>
                     <td><c:out value="${item.sales}"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
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
