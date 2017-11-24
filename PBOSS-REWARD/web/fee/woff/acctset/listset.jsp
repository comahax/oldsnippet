<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
  <head>
    <title><bean:message bundle="acctset" key="titlelist"/></title>
    <script language="JavaScript">
    	function doCMD( cmd ){
    		window.close();
    	}
    </script>
	<base target="_self">
</head>
 
<body>
<div class="table_container">
<html:form action="/fee/woff/acctset.do?CMD=LISTACCTSET" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_que_acctid" value='<c:out value="${_que_acctid}"/>'/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="acctset" key="msg"/></td>				 
            </tr>
        </table>
    </div>   
    <div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>

	<div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td>
                  <input type="button" name="btnSure" class="submit" onmouseover="buttonover(this);"
                   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                      	value="<bean:message bundle="acctset" key="sure"/>" onclick="doCMD('true');">
                 </td> 	
			</tr>
		</table>
	</div>

    <div class="table_div">
    	<div class="table_LongTable"> 
        <table class="table_style" ID="Table2" align="center">
           <tr class="table_style_head">
                <td><bean:message bundle="acctset" key="acctsetid"/></td>
                <td><bean:message bundle="acctset" key="acctsetname"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.acctSetDp.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.acctsetid}"/></td>
                     <td><s:Code2Name code="${item.acctsetid}" definition="#WOFF-ACCT"/></td>
                 </tr>
             </c:forEach>
        </table>
    </div>
    </div>
    <div class="table_div">
		<s:PageNav dpName="acctSetDp" />
	</div>  
</html:form>
</div>  
</body>
</html>
