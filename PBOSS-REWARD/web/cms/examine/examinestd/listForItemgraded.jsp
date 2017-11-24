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
	<base href="<%=basePath%>" target="_self">
    <title><bean:message bundle="examinestd" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_exmnstdname', '<bean:message bundle="examinestd" key="exmnstdname"/>', 'c', 'false', '50');
            addfield('_ne_exmnstdid', '<bean:message bundle="examinestd" key="exmnstdid"/>', 'c', 'false', '32');
            return checkval(window);
        }
        function setValue(exmnstdid,exmnstdname){
			window.returnValue=exmnstdid+","+exmnstdname;
			window.close();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/examinestd.do?CMD=Examinestdlist" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
     <html:hidden property="exmnid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/examinestd/ExaminestdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="examinestd" key="titleList"/>
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
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="examinestd" key="exmnstdid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_exmnstdid"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="examinestd" key="exmnstdname"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_exmnstdname"></html:text>
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
                
                <td>
                    <a href="javascript:doOrderby('exmnstdid')"><bean:message bundle="examinestd" key="exmnstdid"/></a>
                    <s:OrderImg form="/cms/examine/examinestd/ExaminestdForm" field="exmnstdid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnstdname')"><bean:message bundle="examinestd" key="exmnstdname"/></a>
                    <s:OrderImg form="/cms/examine/examinestd/ExaminestdForm" field="exmnstdname"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/examinestd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.exmnstdid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                    
                     <td>
                         <a href='#' onclick="javascript:setValue('<c:out value="${item.exmnstdid}"/>','<c:out value="${item.exmnstdname}"/>')"><c:out value="${item.exmnstdid}"/></a>
                     </td>
                     <td><c:out value="${item.exmnstdname}"/></td>
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
