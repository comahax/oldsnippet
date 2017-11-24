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
    <title><bean:message bundle="chpwregsiviolation" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_mobile', '<bean:message bundle="chpwregsiviolation" key="mobile"/>', 'c', true, '11');
            addfield('_se_vmonth', '<bean:message bundle="chpwregsiviolation" key="vmonth"/>', 'c', true, '6');
            return checkval(window);
        }
        function doBatch(){
        	var url="<%=contextPath%>/cms/reward/chpwregsiviolation/batch.jsp";
        	formList.action=url;
        	formList.submit();
        	formList.action="<%=contextPath%>/cms/reward/chpwregsiviolation.do?CMD=LIST";
        }
        function doExport(){
			formList.action = "<%=contextPath%>/cms/reward/chpwregsiviolation.do?CMD=EXCEL";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/reward/chpwregsiviolation.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/chpwregsiviolation.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/chpwregsiviolation/ChPwRegsiviolationForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpwregsiviolation" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregsiviolation" key="mobile"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregsiviolation" key="vmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_vmonth" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})" readonly="true"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr>
                <td align=right>
                        <!-- <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" 
                            onClick="doNew('/cms/reward/chpwregsiviolation.do')">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" 
                            onClick="doDelete('/cms/reward/chpwregsiviolation.do')"> -->
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="导出" onclick="doExport();" />
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="导入" onclick="doBatch();" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="chpwregsiviolation" key="mobile"/></a>
                    <s:OrderImg form="/cms/reward/chpwregsiviolation/ChpwregsiviolationForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('vmonth')"><bean:message bundle="chpwregsiviolation" key="vmonth"/></a>
                    <s:OrderImg form="/cms/reward/chpwregsiviolation/ChpwregsiviolationForm" field="vmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="chpwregsiviolation" key="remark"/></a>
                    <s:OrderImg form="/cms/reward/chpwregsiviolation/ChpwregsiviolationForm" field="remark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.vmonth}"/></td>
                     <td><c:out value="${item.remark}"/></td>
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
