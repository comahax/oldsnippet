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
    <title><bean:message bundle="rewardranlog" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="rewardranlog" key="wayid"/>', 'c', 'false', '25');
            addfield('_se_paccount', '<bean:message bundle="rewardranlog" key="paccount"/>', 'c', 'false', '25');
            addfield('_se_raccount', '<bean:message bundle="rewardranlog" key="raccount"/>', 'c', 'false', '25');
            addfield('_se_calcmonth', '<bean:message bundle="rewardranlog" key="calcmonth"/>', 'c', 'false', '6');
            addfield('_se_opercode', '<bean:message bundle="rewardranlog" key="opercode"/>', 'c', 'false', '20');
            addfield('_se_opertype', '<bean:message bundle="rewardranlog" key="opertype"/>', 'c', 'false', '1');
            return checkval(window);
        }
        function upload(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/rewardranlog/batch.jsp";
			form.submit();
		}
		function upload1(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/rewardranlog/batchdelete.jsp";
			form.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/rewardranlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/rewardranlog/RewardranlogForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardranlog" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardranlog" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardranlog" key="paccount"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_paccount"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardranlog" key="raccount"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_raccount"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardranlog" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" onclick="this.value=selectDateYYYYMM(this.value);"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <!-- <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/rewardranlog.do')">
                        </s:PurChk> -->
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/rewardranlog.do')">
                        </s:PurChk>
                        <input type="button" name="btnImport"  class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="批量导入" onClick="upload();">
                        <input type="button" name="btnImport1"  class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="批量删除" onClick="upload1();">
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
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="rewardranlog" key="wayid"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paccount')"><bean:message bundle="rewardranlog" key="paccount"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="paccount"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('raccount')"><bean:message bundle="rewardranlog" key="raccount"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="raccount"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="rewardranlog" key="remark"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="remark"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ptime')"><bean:message bundle="rewardranlog" key="ptime"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="ptime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="rewardranlog" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="rewardranlog" key="memo"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="memo"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opercode')"><bean:message bundle="rewardranlog" key="opercode"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="opercode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opertime')"><bean:message bundle="rewardranlog" key="opertime"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="opertime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opertype')"><bean:message bundle="rewardranlog" key="opertype"/></a>
                    <s:OrderImg form="/cms/rewardranlog/RewardranlogForm" field="opertype"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/rewardranlog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
                     <!-- <td><c:out value="${item.wayid}"/></td> -->
                     <td><c:out value="${item.paccount}"/></td>
                     <td><c:out value="${item.raccount}"/></td>
                     <td><fmt:formatNumber pattern="0.00" value="${item.remark}" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.ptime}" /></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.memo}"/></td>
                     <td><c:out value="${item.opercode}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.opertime}" /></td>
                     <td><s:Code2Name code="${item.opertype}" definition="$Oprtype"/></td>
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
