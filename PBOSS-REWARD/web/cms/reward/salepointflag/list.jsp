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
    <title><bean:message bundle="salepointflag" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_flag', '<bean:message bundle="salepointflag" key="flag"/>', 'c', 'false', '8');
            addfield('_se_cityid', '<bean:message bundle="salepointflag" key="cityid"/>', 'c', 'false', '3');
            return checkval(window);
        }
        
        
        window.returnValue = "";
        
        function doSavevalues(){
        	var a="|";
	        var selectedseqs = document.getElementsByName("_selectitem");
	       
	        for (var i=0; i<selectedseqs.length; i++) {
	        			
	   			if (selectedseqs[i].type == 'checkbox'&& selectedseqs[i].checked ) {
	   			
	   				a= a+selectedseqs[i].value+"|";
	   		//		alert(a);
	   			}
	   		}
	   		
        	window.returnValue = a;
        //	alert("555");
        //	alert(a[0]+a[1]);
        //	alert(a);
	   		window.close();
        }
   		
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/salepointflag.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/salepointflag/SalepointflagForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="salepointflag" key="titleList"/>
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
    </div>
	<div class="table_div">
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('flag')"><bean:message bundle="salepointflag" key="flag"/></a>
                    <s:OrderImg form="/cms/reward/salepointflag/SalepointflagForm" field="flag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('flagname')"><bean:message bundle="salepointflag" key="flagname"/></a>
                    <s:OrderImg form="/cms/reward/salepointflag/SalepointflagForm" field="flagname"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}" varStatus="rowid">
                 <c:url value="/cms/reward/salepointflag.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.flag}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                 
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.flagname}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><c:out value="${item.flag}"/></td>
                     <td><c:out value="${item.flagname}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>


   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="确定" class="submit"
                           onclick="doSavevalues()"/>            
</html:form>
</div>
</body>
</html>
