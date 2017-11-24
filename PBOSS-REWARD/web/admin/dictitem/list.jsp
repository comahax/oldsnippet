
<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%

    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
	<base target="_self"/>
    <title><bean:message bundle="dictitem" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
      
        function ev_check() {
            //addfield('_se_dictid', '<bean:message bundle="dictitem" key="dictid"/>', 'c', ture, 32);
            //addfield('_se_groupid', '<bean:message bundle="dictitem" key="groupid"/>', 'c', ture, 32);
            return checkval(window);
        }
    </script>
</head>
<body >
<div class="table_container">
<html:form action="/admin/dictitem.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
 <div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="dictitem" key="titleAdd"/>
						</td>
					</tr>
				</table>
	</div>
	 <div class="table_div">
		<table class="error_text">
			<html:errors/>
		</table>
	</div>
	
		<!--###################################################################################-->		
		
		<!--###################################################################################-->
   <div class="table_div">
       <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
              	<td><bean:message bundle="dictitem" key="dictid"/></td>
                <td><bean:message bundle="dictitem" key="dictname"/></td>
             </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/admin/dictitem.do?CMD=EDIT" var="urlContent">
                    <c:param name="PK" value="${item.dictid}|${item.groupid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                      <td>
                         <a href='javascript:selectDictitem("<c:out value="${item.dictid}"/>");'><c:out value="${item.dictid}"/></a>
                     </td>
                   	 <td><c:out value="${item.dictname}"/></td>
                  </tr>
             </c:forEach>
        </table>
        </div>
</html:form>
<script type="text/javascript">
	var args = window.dialogArguments;	
	
	function selectDictitem(dictid,yxplanid) {
	
		window.returnValue = dictid;
		window.close();
	}
</script>
</body>
</html>
