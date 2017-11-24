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
    <title><bean:message bundle="chpwbroadaccount" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            
            return checkval(window);
        }
        
        function doCancel(cmdDelete) {
        	formList.action = "<%=contextPath%>"+cmdDelete;
    		formList.submit();
        }
        function doToSave(cmdDelete) {
        	formList.action = "<%=contextPath%>"+cmdDelete;
    		formList.submit();
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/kdkhzl/chpwbroadaccount.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/kdkhzl/chpwbroadaccount/ChpwbroadaccountForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpwbroadaccount" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregisterbroad" key="telephone"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_telephone"></html:text>
                </td>
				                
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregisterbroad" key="regdate"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_regdate" onclick="selectDate();" ></html:text>
                	到
                	<html:text styleClass="form_input_1x" property="_dnm_regdate" onclick="selectDate();" ></html:text>
                </td>
            </tr>
            
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregisterbroad" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                
                <td width="20%" height="20" align="right" class="form_table_right" ></td>
                <td width="30%" class="form_table_left">
                    
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        
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
                <td>
                    <a href="javascript:doOrderby('broadid')"><bean:message bundle="chpwregisterbroad" key="broadid"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="broadid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('telephone')"><bean:message bundle="chpwregisterbroad" key="telephone"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="telephone"/>
                </td>
                 <td>
                    <bean:message bundle="chpwregisterbroad" key="opnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="chpwregisterbroad" key="mobile"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('broadnum')"><bean:message bundle="chpwregisterbroad" key="broadnum"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="broadnum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('regdate')"><bean:message bundle="chpwregisterbroad" key="regdate"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="regdate"/>
                </td>
                <td>
                	作废按钮
                </td>
                <td>
                	数据补录
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/kdkhzl/chpwbroadaccount.do?CMD=TOSAVE" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.broadid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.broadid}"/>
                        <%--<a href='<c:out value="${urlContent}"/>'><c:out value="${item.broadid}"/></a>--%>
                     </td>
                     <td><c:out value="${item.telephone}"/></td>
                     <td><c:out value="${item.opnname}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.broadnum}"/></td>
                     <td><fmt:formatDate value="${item.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                     <td>
                     <c:choose>
                     	<c:when test="${item.state == 1}">
	                     	<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" disabled="true" 
	                            value="作废" onClick="doCancel('/cms/kdkhzl/chpwbroadaccount.do?CMD=CANCEL&PK=<c:out value='${item.broadid}'/>')">
                        </c:when>
                        <c:otherwise>
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="作废" onClick="doCancel('/cms/kdkhzl/chpwbroadaccount.do?CMD=CANCEL&PK=<c:out value='${item.broadid}'/>')">
                        </c:otherwise>
                     </c:choose>
                     </td>
                     <td>
                     	<input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="补录" onClick="doToSave('/cms/kdkhzl/chpwbroadaccount.do?CMD=TOSAVE&PK=<c:out value='${item.broadid}'/>')">
                     	
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
