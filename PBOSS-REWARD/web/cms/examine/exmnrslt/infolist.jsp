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
    <title><bean:message bundle="itemgraded" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
         function doReturn(cmdReturn) {
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/exmnrslt.do?CMD=Infolist" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnrslt/ExmnrsltForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="itemgraded" key="titleList"/>
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
                            onclick="doReturn('/cms/examine/exmnrslt.do?CMD=LIST')">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
               
                <td>
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="exmnrslt" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="seqid"/>
                </td>
               
                <td>
                    <a href="javascript:doOrderby('exmnid')"><bean:message bundle="exmnrslt" key="exmnid"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="exmnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnstdid')"><bean:message bundle="exmnrslt" key="isvoted"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="isvoted"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnperiod')"><bean:message bundle="exmnrslt" key="exmnscore"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="exmnscore"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('penalmark')"><bean:message bundle="exmnrslt" key="marktype"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="marktype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="exmnrslt" key="stcrtcl"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="stcrtcl"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('registercode')"><bean:message bundle="exmnrslt" key="score"/></a>
                    <s:OrderImg form="/cms/examine/exmnrslt/ExmnrsltForm" field="score"/>
                </td>
             
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}" varStatus="vs">
              
                 <tr class="table_style_content" align="center">
                 	  <td><c:out value="${vs.index+1}"/></td>
                     <td><c:out value="${item.exmnid}"/></td>
                     <td><s:Code2Name definition="#ISVOTED" code="${item.isvoted}"/></td>
                     <td><c:out value="${item.exmnscore}"/></td>
                     <td>
                     	<c:if test="${item.marktype=='9'}">
                     		<bean:message bundle="exmnrslt" key="hasnot"/>
                     	</c:if>
                     	 <c:if test="${item.marktype!='9'}">
                     		<c:out value="${item.marktype}"/>
                     	</c:if>
                    </td>
                     <td>
                     	 <c:if test="${item.stcrtcl=='0'}">
                     		<bean:message bundle="exmnrslt" key="hasnot"/>
                     	 </c:if>
                     	  <c:if test="${item.stcrtcl!='0'}">
                     		<c:out value="${item.stcrtcl}"/>
                     	 </c:if>
                     </td>
                     <td><c:out value="${item.score}"/></td>
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
