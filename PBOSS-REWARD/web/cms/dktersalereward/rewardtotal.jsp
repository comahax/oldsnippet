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
    <title><bean:message bundle="dktersalereward" key="titleTotal"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_month', '<bean:message bundle="dktersalereward" key="month"/>', 'c', 'false', '10');
            addfield('_se_ecpoperator', '<bean:message bundle="dktersalereward" key="ecpoperator"/>', 'c', 'false', '100');
            addfield('_se_wayname', '<bean:message bundle="dktersalereward" key="wayname"/>', 'c', 'false', '256');
            addfield('_ne_cityid', '<bean:message bundle="dktersalereward" key="cityid"/>', 'f', 'false', '3');
            return checkval(window);
        }
        
        function doExport(url){
			formList.action = contextPath + url + "?CMD=EXCELREWARDTOTAL";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/dktersalereward.do?CMD=REWARDTOTAL";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/dktersalereward.do?CMD=REWARDTOTAL" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="query" value="true">
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/dktersalereward/DktersalerewardForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="dktersalereward" key="titleTotal"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="dktersalereward" key="month"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_month" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >&nbsp;</td>
                <td width="30%" class="form_table_left">&nbsp;</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" 
            			onclick="doExport('/cms/dktersalereward.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td><bean:message bundle="dktersalereward" key="recid"/></td>
                <td><bean:message bundle="dktersalereward" key="cityid"/></td>
                <td><bean:message bundle="dktersalereward" key="salesuc"/></td>
                <td><bean:message bundle="dktersalereward" key="examinesuc"/></td>
                <td><bean:message bundle="dktersalereward" key="foundreward"/></td>
                <td><bean:message bundle="dktersalereward" key="examinereward"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.recid}"/></td>
                     <td><s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY_AREA" /></td>
                     <td><c:out value="${item.salesuc}"/></td>
                     <td><c:out value="${item.examinesuc}"/></td>
                     <td><c:out value="${item.foundreward}"/></td>
                     <td><c:out value="${item.examinereward}"/></td>
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
