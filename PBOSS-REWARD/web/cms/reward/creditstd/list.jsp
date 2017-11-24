<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@page import="com.sunrise.boss.ui.commons.User"%>
<%@page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    User user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
%>
<html>
<head>
    <title><bean:message bundle="creditstd" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_slv', '<bean:message bundle="creditstd" key="slv"/>', 'f', 'false', '22');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/creditstd.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/creditstd/CreditstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="creditstd" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="creditstd" key="slv"/>:</td>
                <td width="30%" class="form_table_left">
                    <!-- <html:text styleClass="form_input_1x" property="_ne_slv"></html:text> -->
                    <html:select property="_ne_slv">
                    	<option />
                    	<s:Options definition="$CH_STARLEVELONLY" />
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >星级层次:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_slvlev">
                    	<option />
                    	<s:Options definition="$CH_STARLAV" />
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >城乡标识:</td>
                <td width="30%" class="form_table_left">
                    <!-- <html:text styleClass="form_input_1x" property="_ne_slv"></html:text> -->
                    <html:select property="_ne_adtypecode">
                    	<option />
                    	<s:Options definition="$CH_ACCOUNTREGION" />
                     </html:select>
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
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/creditstd.do')">
                        </s:PurChk>
                        <!-- 
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/creditstd.do')">
                        </s:PurChk> -->
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <!-- <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td> -->
                <td>
                    <a href="javascript:doOrderby('slv')"><bean:message bundle="creditstd" key="slv"/></a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="slv"/>
                </td>
                <td>
                  门店补贴
                </td>
                <td>
                 积分标准补贴
                </td>
                <td>
                    <a href="javascript:doOrderby('adtypecode')"><bean:message bundle="creditstd" key="adtypecode"/></a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="adtypecode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('slvlev')"><bean:message bundle="creditstd" key="slvlev"/></a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="slvlev"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.dp.datas}">
                 <c:url value="/cms/reward/creditstd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.slv}|${item.slvlev}|${item.adtypecode}|54"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <c:url value="/cms/reward/creditstd.do?CMD=EDIT" var="urlContent1">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.slv}|${item.slvlev}|${item.adtypecode}|55"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <!-- <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.cityid}"/></a>
                     </td>
                      -->
                     <!-- <td><c:out value="${item.cityid}"/></td> -->
                     <td><s:Code2Name code="${item.slv}" definition="$CH_STARLEVELONLY"/></td>
                     <td>
                     <c:if test="${item.rewardtype1 == 54}">
                     	<c:if test="${item.nums1 == 0}">
                     	<c:out value="${item.nums1}"/>
                     	</c:if>
                     	<c:if test="${item.nums1 != 0}">
                     	<a href='<c:out value="${urlContent}"/>'><c:out value="${item.nums1}"/></a>
                     	</c:if>
                     </c:if>
                     <!-- <c:out value="${item.rewardtype}"/>  -->
                     </td>
                     <td>
                     <c:if test="${item.rewardtype == 55}">
                     	<c:if test="${item.nums == 0}">
                     	<c:out value="${item.nums}"/>
                     	</c:if>
                     	<c:if test="${item.nums != 0}">
                     	<a href='<c:out value="${urlContent1}"/>'><c:out value="${item.nums}"/></a>
                     	</c:if>
                     </c:if>
                     <!-- <c:out value="${item.rewardtype}"/>  -->
                     </td>
                     <td><s:Code2Name code="${item.adtypecode}" definition="$CH_ACCOUNTREGION"/></td>
                     <td>
                     <s:Code2Name code="${item.slvlev}" definition="$CH_STARLAV"/>
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
