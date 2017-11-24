<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A5E30" />
</jsp:include>

<%
	  String ID_1 = "2B1A5E30" + "BT1";
    String ID_2 = "2B1A5E30" + "BT2";
    
%>

<html>
<head>
	  <base target="_self"/>
    <title><bean:message bundle="employee" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_employeeid', '<bean:message bundle="employee" key="employeeid"/>', 'i', true, 14);
            addfield('_ne_employeename', '<bean:message bundle="employee" key="employeename"/>', 'c', true, 20);
            return checkval(window);
        }
        
	      
	      function doOk(){
	         var strChecks = "";
		       if (document.all._selectitem.length != null) {
		         for(i=0;i<document.all._selectitem.length;i++){
		         	  if(document.all._selectitem[i].checked  == true){
		         	  	strChecks = strChecks + document.all._selectitem[i].id + ",";
		         	  }
		         }
		       }else{
		       	if(document.all._selectitem.checked){
		       		strChecks = document.all._selectitem.id;
		       	}
		       }

	      	 window.returnValue=strChecks;
	      	 window.close();
	      }
	      
	      function doClose(){
	      	 window.returnValue='';
	      	 window.close();
	      }
    </script>
</head>

<body onload="loadforiframe();" >
<div class="table_container">

<html:form action="/cms/employee.do?CMD=SELECT" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="employee" key="titleList"/>
					</td>
				</tr>
			</table>
		</div>	
		
		<div class="table_div">
	     <table width="100%" class="error_text">
       	   <s:Msg />
       </table>	
		</div>	


    <div class="table_div">
        <table class="form_table">
            <tr>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="employee" key="employeename"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_employeename" ></html:text>
                </td>
            </tr>
        </table>
    </div>

		<div class="table_div">
			<table class="table_button_list">
				<tr>
					<td>
             <s:PurChk controlid="<%=ID_1%>">
             <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_search"/>" />
             </s:PurChk>  
             <s:PurChk controlid="<%=ID_2%>">
             <input type="button" class="query"onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_confirm"/>" onclick="doOk()" />
             </s:PurChk>  
             <input type="button" class="query"onmouseover="buttonover(this);"
                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_cancel"/>" onclick="doClose()" />
					</td>
				</tr>
			</table>
		</div>

    <div class="table_div">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode2')"><bean:message bundle="employee" key="oprcode2"/></a>
                    <s:OrderImg form="/cms/employee/AreacenterForm" field="oprcode2"/>
                </td>
                <td><bean:message bundle="employee" key="employeename"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" id="<c:out value='${item.oprcode2}'/>"  name="_selectitem" value="<c:out value='${item.oprcode2}' />" 
                                 class="table_checkbox">
                     </td>
                     <td> <c:out value="${item.oprcode2}"/> </td>
                     <td><c:out value="${item.employeename}"/></td>
                 </tr>
             </c:forEach>
        </table>
    </div>
   <div class="table_div">
       <s:PageNav dpName="LIST"/>
   </div>

</html:form>
</div>
</body>
</html>
