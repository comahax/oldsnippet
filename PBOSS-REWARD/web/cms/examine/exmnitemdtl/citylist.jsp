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
    <title><bean:message bundle="exmnitemdtl" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seqid', '<bean:message bundle="exmnitemdtl" key="seqid"/>', 'f', 'false', '10');
            addfield('_ne_exmnid', '<bean:message bundle="exmnitemdtl" key="exmnid"/>', 'f', 'false', '6');
            addfield('_ne_exmnstdid', '<bean:message bundle="exmnitemdtl" key="exmnstdid"/>', 'f', 'false', '6');
            addfield('_se_cityid', '<bean:message bundle="exmnitemdtl" key="cityid"/>', 'c', 'false', '3');
            return checkval(window);
        }
         function doReturn(cmdReturn) {
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/exmnitemdtl.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="_ne_exmnstdid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnitemdtl/ExmnitemdtlForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnitemdtl" key="titleList"/>
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
                          <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                            name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_return"/>" class="close"
                            onclick="doReturn('/cms/examine/exmnitemdtl.do?CMD=LIST')">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('marktype')"><bean:message bundle="exmnitemdtl" key="cityid"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="cityid"/>
                </td>
                
                <td>
                    <a href="javascript:doOrderby('leastcrtcl')"><bean:message bundle="exmnitemdtl" key="leastcrtcl"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="leastcrtcl"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('largestcrtcl')"><bean:message bundle="exmnitemdtl" key="largestcrtcl"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="largestcrtcl"/>
                </td>
               <td>
                    <a href="javascript:doOrderby('marktype')"><bean:message bundle="exmnitemdtl" key="cityid"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="cityid"/>
                </td>
                
                <td>
                    <a href="javascript:doOrderby('leastcrtcl')"><bean:message bundle="exmnitemdtl" key="leastcrtcl"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="leastcrtcl"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('largestcrtcl')"><bean:message bundle="exmnitemdtl" key="largestcrtcl"/></a>
                    <s:OrderImg form="/cms/examine/exmnitemdtl/ExmnitemdtlForm" field="largestcrtcl"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}" varStatus="vs">
                 <c:if test="${(vs.index+1)%2==1}">
	                 <tr class="table_style_content" align="center">
	                     <td><s:Code2Name definition="#CITYNAME" code="${item.cityid}"/></td>
	                    <td><c:out value="${item.leastcrtcl}"/></td>
	                     <td><c:out value="${item.largestcrtcl}"/></td>
	                 </tr>
                  </c:if>
                  <c:if test="${(vs.index+1)%2==0}">
                  	  <tr class="table_style_content" align="center">
                  		<td><s:Code2Name definition="#CITYNAME" code="${item.cityid}"/></td>
	                    <td><c:out value="${item.leastcrtcl}"/></td>
	                     <td><c:out value="${item.largestcrtcl}"/></td>
	                  </tr>
                  </c:if>
                  <c:if test="${requestScope.LIST.rowCount==(vs.index+1)}">
                  <c:if test="${requestScope.LIST.rowCount%2==1}">
                  		<tr class="table_style_content" align="center">
                  		<td>&nbsp;</td>
	                    <td>&nbsp;</td>
	                     <td>&nbsp;</td>
	                  </tr>
                  </c:if>
                  </c:if>
                 
             </c:forEach>
        </table>
     </div>
   </div>
</html:form>
</div>
</body>
</html>
