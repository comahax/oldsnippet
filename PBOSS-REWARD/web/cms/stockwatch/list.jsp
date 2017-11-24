<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B6F2B" />
</jsp:include>
<%
    //Ò³Ãæ¿ØÖÆµã?
    String ID_1 = "2B6F2BBT1";
    String ID_2 = "2B6F2BBT2";
%>
<html>
<head>
    <title><bean:message bundle="stockwatch" key="title"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('wayid', '<bean:message bundle="stockwatch" key="wayid"/>', 'c', true, 32);
            return checkval(window);
        }
		
		function doQuery(cmdQuery) {
			formList.action = contextPath + cmdQuery;
    		formList.submit();
		}
		
		function doReset() {
			formList.wayid.value = "";
			formList.comtype.value = "";
			formList.beginrptday.value = "";
			formList.endrptday.value = "";
		}
    </script>
</head>

<body onload="document.formList.wayid.focus();">
<div class="table_container">

<html:form action="/cms/stockwatch.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>   
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="stockwatch" key="subtitle"/>
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
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="stockwatch" key="wayid"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_in_1x" property="wayid" onclick="showSelectWay(this)"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="stockwatch" key="comtype"/>:
               	</td>
                <td class="form_table_left">
                    <html:select property="comtype" styleClass="form_select_on">
						<option value=""></option>
                    	<s:Options definition="$IM_RESOURCETYPE"/>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="stockwatch" key="beginrptday"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_in_1x" property="beginrptday" onclick="this.value=selectDate()"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="stockwatch" key="endrptday"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_in_1x" property="endrptday" onclick="this.value=selectDate()" ></html:text>
                </td>
             </tr>
        </table>
    </div>
	
	<div class="table_div">
		<table width="100%" class="table_button_list" border="0" cellspacing="0" cellpadding="0" ID="Table3">
			<tr>
            	<td align=right>
                	<s:PurChk controlid="<%=ID_1%>">
                        <input type="button" name="btnQuery" class="query" value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery('/cms/stockwatch.do?CMD=LIST');" />
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                        <input type="button" name="btnRTQuery" class="button_4" value="<bean:message bundle="stockwatch" key="button_rtquery"/>" onclick="doQuery('/cms/stockwatch.do?CMD=LIST&REARTIME=REARTIME');" />
                    </s:PurChk>
                    <input type="button" name="btnReset" class="button_2" value="<bean:message bundle="stockwatch" key="button_reset"/>" onclick="doReset();" />
               </td>
            </tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td nowrap>
                    <a href="javascript:doOrderby('opertime')"><bean:message bundle="stockwatch" key="opertime"/></a>
                    <s:OrderImg form="/cms/stockwatch/StockwatchForm" field="opertime"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="stockwatch" key="wayid"/></a>
                    <s:OrderImg form="/cms/stockwatch/StockwatchForm" field="wayid"/>
                </td>
                <td nowrap><bean:message bundle="stockwatch" key="resourcetype"/></td>
                <td nowrap><bean:message bundle="stockwatch" key="stockpile"/></td>
                <td nowrap><bean:message bundle="stockwatch" key="leastlimit"/></td>
                <td nowrap><bean:message bundle="stockwatch" key="mostlimit"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
					 <td>
					 	<c:choose>
					 		<c:when test="${param.REARTIME eq 'REARTIME'}">
					 			<fmt:formatDate value="${item.opertime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
					 		</c:when>
					 		<c:otherwise>
					 			<fmt:formatDate value="${item.opertime}" type="date" pattern="yyyy-MM-dd"/>
					 		</c:otherwise>
					 	</c:choose>
					 </td>
                     <td><s:Code2Name code="${item.wayid}" definition="#WAY"/></td>
                     <td><s:Code2Name code="${item.resourcetype}" definition="$IM_RESOURCETYPE"/></td>                    
                     <td><c:out value="${item.stockpile}"/></td>
                     <td><c:out value="${item.leastlimit}"/></td>
                     <td><c:out value="${item.mostlimit}"/></td>
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
