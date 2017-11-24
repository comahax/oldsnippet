<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_B2M_REWARD||CH_B2M_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title><bean:message bundle="yxplanbbc" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="yxplanbbc" key="opnid"/>', 'c', 'false', '18');
            addfield('_ne_yxplanid', '<bean:message bundle="yxplanbbc" key="yxplanid"/>', 'f', 'false', '14');
            return checkval(window);
        }
        function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		  function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/yxplan.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/YxplanForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="yxplanbbc" key="titleList"/>
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
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="yxplanbbc" key="_se_opnid" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               	  <html:text  property="_se_opnid" styleClass="form_input_1x"/>
					<input type="button" value="..." class="clickbutton" onclick="_se_opnid.value=getOpnId();">
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="yxplanbbc" key="_sk_opnname" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               	  <html:text  property="_sk_opnname" styleClass="form_input_1x"/>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="yxplanbbc" key="_ne_yxplanid" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:text  property="_ne_yxplanid" styleClass="form_input_1x"/>
               		<input type="button" value="..." class="clickbutton"
								onclick="_ne_yxplanid.value=selectYxplan()">
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="yxplanbbc" key="_sk_yxplanname" />
					:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:text  property="_sk_yxplanname" styleClass="form_input_1x"/>
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/bbc/yxplan.do')">
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/bbc/yxplan.do')">
                        </s:RewardPurChk>
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
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
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="yxplanbbc" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbc/yxplan/YxplanForm" field="opnid"/>
                </td>
                 <td>
                    <bean:message bundle="yxplanbbc" key="opnname" />
                </td>
                <td>
                    <a href="javascript:doOrderby('yxplanid')"><bean:message bundle="yxplanbbc" key="yxplanid"/></a>
                    <s:OrderImg form="/cms/bbc/yxplan/YxplanForm" field="yxplanid"/>
                </td>
                 <td>
                    <bean:message bundle="yxplanbbc" key="yxplanname" />
                </td>
                <td>
                    <a href="javascript:doOrderby('wrapfee')"><bean:message bundle="yxplanbbc" key="wrapfee"/></a>
                    <s:OrderImg form="/cms/bbc/yxplan/YxplanForm" field="wrapfee"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/bbc/yxplan.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.opnid}|${item.yxplanid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}|${item.yxplanid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     <c:out value="${item.opnid}"/>
                     </td>
                     <td>
		                    <s:Code2Name definition="#BBC_OPERATION" code="${item.opnid}" />
                     </td>
                     <td><c:out value="${item.yxplanid}"/></td>
                     <td><s:Code2Name definition="#ZIFEE-YXPLAN" code="${item.yxplanid}" /></td>
                     <td><c:out value="${item.wrapfee}"/></td>
                 </tr>
             </c:forEach>
        </table>
   </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
