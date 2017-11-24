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
        
        function doFind(url){
        	formList.action=contextPath + url ;
			formList.submit();
		}
        
        function doContent(url){
        	formList.action=contextPath + url ;
			formList.submit();
        }
        
        function doOut(url){
        	formList.action=contextPath + url ;
			formList.submit();
        }
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/creditstd.do?CMD=FIND" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			市公司长期激励酬金标准设置
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
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doFind('/cms/reward/creditstd.do?CMD=FIND');"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doContent('/cms/reward/creditstd.do?CMD=content')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doOut('/cms/reward/creditstd.do?CMD=OUT')">
                        </s:PurChk> 
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td> 
                <td>
                    <a href="javascript:doOrderby('slv')"><bean:message bundle="creditstd" key="slv"/></a>
                    <s:OrderImg form="/cms/reward/creditstd/CreditstdForm" field="slv"/>
                </td>
                <td>
                  间隔月份
                </td>
                <td>
                 酬金标准
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.dp.datas}">
                 <tr class="table_style_content" align="center">
                      <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <!--
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.cityid}"/></a>
                     </td>
                      -->
                     <!-- <td><c:out value="${item.cityid}"/></td> -->
                     <td><s:Code2Name code="${item.slv}" definition="$CH_STARLEVELONLY"/></td>
                     <td>
                    <c:out value="${item.intvmonth}"/>
                     </td>
                     <td>
                     <c:out value="${item.rewardstd}"/>
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
