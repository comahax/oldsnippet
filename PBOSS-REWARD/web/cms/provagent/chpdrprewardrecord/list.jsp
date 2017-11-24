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
    <title><bean:message bundle="chpdrprewardrecord" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/chpdrprewardrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpdrprewardrecord" key="titleList"/>
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/chpdrprewardrecord.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/provagent/chpdrprewardrecord.do')">
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
                    <a href="javascript:doOrderby('rpseqid')"><bean:message bundle="chpdrprewardrecord" key="rpseqid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm" field="rpseqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('provagentid')"><bean:message bundle="chpdrprewardrecord" key="provagentid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm" field="provagentid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('prodno')"><bean:message bundle="chpdrprewardrecord" key="prodno"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm" field="prodno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="chpdrprewardrecord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase')"><bean:message bundle="chpdrprewardrecord" key="phase"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm" field="phase"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chpdrprewardrecord" key="cityid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rpmoney')"><bean:message bundle="chpdrprewardrecord" key="rpmoney"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm" field="rpmoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adcrewardid')"><bean:message bundle="chpdrprewardrecord" key="adcrewardid"/></a>
                    <s:OrderImg form="/cms/provagent/chpdrprewardrecord/ChpdrprewardrecordForm" field="adcrewardid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/chpdrprewardrecord.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.rpseqid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.rpseqid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.rpseqid}"/></a>
                     </td>
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
