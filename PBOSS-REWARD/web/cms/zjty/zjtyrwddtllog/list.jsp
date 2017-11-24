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
    <title><bean:message bundle="zjtyrwddtllog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtyrwddtllog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtyrwddtllog" key="titleList"/>
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
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
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
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/zjtyrwddtllog.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/zjtyrwddtllog.do')">
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="zjtyrwddtllog" key="logid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="zjtyrwddtllog" key="optime"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="zjtyrwddtllog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="zjtyrwddtllog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="zjtyrwddtllog" key="success"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardlistid')"><bean:message bundle="zjtyrwddtllog" key="rewardlistid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="rewardlistid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('operseq')"><bean:message bundle="zjtyrwddtllog" key="operseq"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="operseq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="zjtyrwddtllog" key="opnid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="zjtyrwddtllog" key="wayid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayopercode')"><bean:message bundle="zjtyrwddtllog" key="wayopercode"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="wayopercode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="zjtyrwddtllog" key="rewardid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="rewardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="zjtyrwddtllog" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="zjtyrwddtllog" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctype')"><bean:message bundle="zjtyrwddtllog" key="acctype"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="acctype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef1')"><bean:message bundle="zjtyrwddtllog" key="coef1"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="coef1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef2')"><bean:message bundle="zjtyrwddtllog" key="coef2"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="coef2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef3')"><bean:message bundle="zjtyrwddtllog" key="coef3"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="coef3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coef4')"><bean:message bundle="zjtyrwddtllog" key="coef4"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="coef4"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmont')"><bean:message bundle="zjtyrwddtllog" key="rewardmont"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="rewardmont"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('totalsum')"><bean:message bundle="zjtyrwddtllog" key="totalsum"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="totalsum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paysum')"><bean:message bundle="zjtyrwddtllog" key="paysum"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="paysum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchnum')"><bean:message bundle="zjtyrwddtllog" key="batchnum"/></a>
                    <s:OrderImg form="/cms/zjty/zjtyrwddtllog/ZjtyrwddtllogForm" field="batchnum"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/zjtyrwddtllog.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.rewardlistid}"/></td>
                     <td><c:out value="${item.operseq}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayopercode}"/></td>
                     <td><c:out value="${item.rewardid}"/></td>
                     <td><c:out value="${item.rewardtype}"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><c:out value="${item.acctype}"/></td>
                     <td><c:out value="${item.coef1}"/></td>
                     <td><c:out value="${item.coef2}"/></td>
                     <td><c:out value="${item.coef3}"/></td>
                     <td><c:out value="${item.coef4}"/></td>
                     <td><c:out value="${item.rewardmont}"/></td>
                     <td><c:out value="${item.totalsum}"/></td>
                     <td><c:out value="${item.paysum}"/></td>
                     <td><c:out value="${item.batchnum}"/></td>
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
