<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
    <title><bean:message bundle="chzjtylocaljjrewardtotal" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            var rewardreporttime = document.getElementById('_se_rewardreporttime').value;
            if (rewardreporttime==null || rewardreporttime=='') {
            	var alertstr = '<span class=\'errorkey\'><strong style=\'color:#F00; font-size:12px;\'>[月份]</strong> 不能为空 ';
            	errorMessageShow(alertstr);
            	return false;
            }
            return true;
        }
        
        function doExport(url){
			if (ev_check()) {
        		errorobj.innerHTML = "";
				formList.action = contextPath + url + "?CMD=EXCEL";
	  			formList.submit();
	  			formList.action="<%=contextPath%>/cms/zjty/chzjtylocaljjrewardtotal.do?CMD=LIST";
	  		}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/chzjtylocaljjrewardtotal.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize" value="20"/>
    <input type="hidden" name="query" value="true">
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtylocaljjrewardtotal/ChzjtylocaljjrewardtotalForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtylocaljjrewardtotal" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtylocaljjrewardtotal" key="_se_rewardreporttime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardreporttime" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})"></html:text>
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
            			onclick="doExport('/cms/zjty/chzjtylocaljjrewardtotal.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                    <c:if test="${!protoken}">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" 
                        onClick="doDelete('/cms/zjty/chzjtylocaljjrewardtotal.do')">
                    </c:if>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <c:if test="${!protoken}">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                </c:if>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="recid"/></td>
                <c:if test="${!protoken}">
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="wayname"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="companytype"/></td>
                </c:if>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="cityid"/></td>
                <c:if test="${!protoken}">
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="zjtywayname"/></td>
                </c:if>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="qqtxzfhcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="yffzqqtcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="dgddtkxscj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="szxtkxscj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="czywcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="dzzdcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="zhywcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="zzywcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="dgddwlk"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="jtkdkhcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="sjywcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="jtywcj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="dsgsyxzd"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="qqtffcjkj"/></td>
                <td><bean:message bundle="chzjtylocaljjrewardtotal" key="total"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/chzjtylocaljjrewardtotal.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.recid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <c:if test="${!protoken}">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.recid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     </c:if>
                     <td><c:out value="${item.recid}"/></td>
                     <c:if test="${!protoken}">
                     <td><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.companytype}"/></td>
                     </c:if>
                     <td><c:out value="${item.cityid}"/></td>
                     <c:if test="${!protoken}">
                     <td><c:out value="${item.zjtywayname}"/></td>
                     </c:if>
                     <td><c:out value="${item.qqtxzfhcj}"/></td>
                     <td><c:out value="${item.yffzqqtcj}"/></td>
                     <td><c:out value="${item.dgddtkxscj}"/></td>
                     <td><c:out value="${item.szxtkxscj}"/></td>
                     <td><c:out value="${item.czywcj}"/></td>
                     <td><c:out value="${item.dzzdcj}"/></td>
                     <td><c:out value="${item.zhywcj}"/></td>
                     <td><c:out value="${item.zzywcj}"/></td>
                     <td><c:out value="${item.dgddwlk}"/></td>
                     <td><c:out value="${item.jtkdkhcj}"/></td>
                     <td><c:out value="${item.sjywcj}"/></td>
                     <td><c:out value="${item.jtywcj}"/></td>
                     <td><c:out value="${item.dsgsyxzd}"/></td>
                     <td><c:out value="${item.qqtffcjkj}"/></td>
                     <td><c:out value="${item.total}"/></td>
                 </tr>
             </c:forEach>
             <c:if test="${protoken && LIST != null}">
             	<tr class="table_style_content" align="center">
                     <td colspan="2">合计</td>
                     <td><c:out value="${queryTotal[0]}"/></td>
                     <td><c:out value="${queryTotal[1]}"/></td>
                     <td><c:out value="${queryTotal[2]}"/></td>
                     <td><c:out value="${queryTotal[3]}"/></td>
                     <td><c:out value="${queryTotal[4]}"/></td>
                     <td><c:out value="${queryTotal[5]}"/></td>
                     <td><c:out value="${queryTotal[6]}"/></td>
                     <td><c:out value="${queryTotal[7]}"/></td>
                     <td><c:out value="${queryTotal[8]}"/></td>
                     <td><c:out value="${queryTotal[9]}"/></td>
                     <td><c:out value="${queryTotal[10]}"/></td>
                     <td><c:out value="${queryTotal[11]}"/></td>
                     <td><c:out value="${queryTotal[12]}"/></td>
                     <td><c:out value="${queryTotal[13]}"/></td>
                     <td><c:out value="${queryTotal[14]}"/></td>
                 </tr>
             </c:if>
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
