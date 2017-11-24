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
    <title><bean:message bundle="zjtycitylvlrwd" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtycitylvlrwd.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtycitylvlrwd" key="titleList"/>
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
		<table class="table_button_list">
			<tr> 
                <td align=right>
                       		<input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
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
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="zjtycitylvlrwd" key="cityid"/></a>
                    <s:OrderImg form="/cms/zjty/zjtycitylvlrwd/ZjtyCitylvlrwdForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rwdupper')"><bean:message bundle="zjtycitylvlrwd" key="rwdupper"/></a>
                    <s:OrderImg form="/cms/zjty/zjtycitylvlrwd/ZjtyCitylvlrwdForm" field="rwdupper"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/zjtycitylvlrwd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     	<!--  <a href='<c:out value="${urlContent}"/>'><s:Code2Name code="${item.cityid}" definition="#CITYIDNUM2NMAME"/></a>--> 
                     	 <s:Code2Name code="${item.cityid}" definition="#CITYIDNUM2NMAME"/>
                     </td>
                     <td>
                     	<c:out value="${item.rwdupper}"/>
                     </td>
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
