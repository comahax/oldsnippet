<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_DO = "CH_B2M_REWARD_PROVINCIAL||CH_B2M_REWARD_CIVIC";
%>
<html>
<head>
    <title><bean:message bundle="mmopn" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="mmopn" key="opnid"/>', 'c', 'false', '18');
            addfield('_sk_name', '<bean:message bundle="mmopn" key="name"/>', 'c', 'false', '50');
            return checkval(window);
        }
         function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		function doBatch()
		{
			var url="<%=contextPath%>/cms/bbc/music/batchupfile.jsp";
			window.location.href=url;
			
		}function doExcel()
		{
			var url="<%=contextPath%>/cms/bbc/mmopn.do?CMD=EXCEL&MUSIC=TRUE";
			formList.action=url;
			formList.submit();
			formList.action="<%=contextPath%>/cms/bbc/mmopn.do?CMD=LIST&MUSIC=TRUE";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/mmopn.do?CMD=LIST&MUSIC=TRUE" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/mmopn/MmopnForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="mmopn" key="titleMusic"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mmopn" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:text  property="_se_opnid" styleClass="form_input_1x"/>
					 <input type="button" value="..." class="clickbutton"
										onclick="_se_opnid.value=getOpnId();">
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mmopn" key="name"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_name"></html:text>
                </td>
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
                            <s:RewardPurChk controlid="<%=ID_DO%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/bbc/mmopn.do?MUSIC=TRUE')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/bbc/mmopn.do?MUSIC=TRUE')">
                            <input type="button" class="button_2" onmouseover="buttonover(this);" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="导出" onclick="doExcel()"/> 
                             <input type="button" class="button_2" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="导入" onclick="doBatch()"/>   
                           </s:RewardPurChk>      
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
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="mmopn" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')"><bean:message bundle="mmopn" key="name"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('entid')"><bean:message bundle="mmopn" key="entid"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="entid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busiid')"><bean:message bundle="mmopn" key="busiid"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="busiid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="mmopn" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="mmopn" key="state"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="state"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('shortopn')"><bean:message bundle="mmopn" key="shortopn"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="shortopn"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wapurl')"><bean:message bundle="mmopn" key="wapurl"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="wapurl"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="mmopn" key="memo"/></a>
                    <s:OrderImg form="/cms/bbc/mmopn/MmopnForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/mmopn.do?CMD=EDIT&MUSIC=TRUE" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.opnid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/></a>
                     </td>
                     <td><c:out value="${item.name}"/></td>
                     <td><c:out value="${item.entid}"/></td>
                     <td><c:out value="${item.busiid}"/></td>
                     <td>
                     <fmt:formatNumber pattern="#0.0000" value="${item.rewardstd}" />
                     </td>
                     <td>
                     <s:Code2Name definition="#CH_STATE" code="${item.state}" />
                     </td>
                     <td><c:out value="${item.shortopn}"/></td>
                     <td><c:out value="${item.wapurl}"/></td>
                     <td><c:out value="${item.memo}"/></td>
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
