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
    <title><bean:message bundle="chpdrprewardrecordlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/chpdrprewardrecordlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdrprewardrecordlog" key="titleList"/>
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/chpdrprewardrecordlog.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/provagent/chpdrprewardrecordlog.do')">
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="chpdrprewardrecordlog" key="logid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="chpdrprewardrecordlog" key="optime"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="chpdrprewardrecordlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="chpdrprewardrecordlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="chpdrprewardrecordlog" key="success"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rpseqid')"><bean:message bundle="chpdrprewardrecordlog" key="rpseqid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="rpseqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('provagentid')"><bean:message bundle="chpdrprewardrecordlog" key="provagentid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="provagentid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('prodno')"><bean:message bundle="chpdrprewardrecordlog" key="prodno"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="prodno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="chpdrprewardrecordlog" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase')"><bean:message bundle="chpdrprewardrecordlog" key="phase"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="phase"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chpdrprewardrecordlog" key="cityid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rpmoney')"><bean:message bundle="chpdrprewardrecordlog" key="rpmoney"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="rpmoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adcrewardid')"><bean:message bundle="chpdrprewardrecordlog" key="adcrewardid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecordlog/ChpdrprewardrecordlogForm" field="adcrewardid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/chpdrprewardrecordlog.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.rpseqid}"/></td>
                     <td><c:out value="${item.provagentid}"/></td>
                     <td><c:out value="${item.prodno}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.phase}"/></td>
                     <td><c:out value="${item.cityid}"/></td>
                     <td><c:out value="${item.rpmoney}"/></td>
                     <td><c:out value="${item.adcrewardid}"/></td>
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
