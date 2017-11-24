<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chbbcmarketact" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/pub/list.js"></script>
    <script type="text/javascript" src="<%= contextPath %>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="chbbcmarketact" key="opnid"/>', 'c', false, '18');
            addfield('rewardmonth', '<bean:message bundle="chbbcmarketact" key="rewardmonth"/>', 'c', false, '6');
            addfield('acttype', '<bean:message bundle="chbbcmarketact" key="acttype"/>', 'c', false, '32');

            return checkval(window);
        }
        
        function showOpnid(v) {
        	var arg = new Array();
        	var strUrl = contextPath + "/cms/bbc/operation.do?CMD=SELECT&_se_busibelong=LL_V2&_ne_state=1&_ne_isbusi=1";
			var retValue = window.showModalDialog(strUrl, arg, "dialogWidth:600px;dialogHeight:390px;status:no;resizable:yes;");
			if (retValue && retValue != null && retValue != "") {
				v.value = retValue;
			} else {
				v.value = "";
			}
        }
        
        function batchsave() {
        	 var selectopnid = $("[name='_selectopnid'][checked]");
        	 var acttype = $("[name='acttype'][checked]");
        	 if (!selectopnid || selectopnid.length==0) {
        	 	alert("请选择业务编码！");
        	 	return;
        	 }
        	 if (!acttype || acttype.length==0) {
        	 	alert("请选择营销活动类型！");
        	 	return;
        	 }
        	 
        	 doSave('/cms/chbbcmarketact.do?CMD=BATCHSAVE');
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chbbcmarketact.do?CMD=BATCHSAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="rewardmonth"/>
    <html:hidden property="_se_rewardmonth"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chbbcmarketact/ChbbcmarketactForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chbbcmarketact" key="titleList"/>
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
    	<table class="table_style">
            <tr class="table_style_head">
                <td width="50%"><bean:message bundle="chbbcmarketact" key="opnid"/></td>
                <td width="50%"><bean:message bundle="chbbcmarketact" key="acttype"/></td>
            </tr>
            <tr>
                <td>
                	<table class="table_style">
			            <tr class="table_style_head">
			                <td title="<bean:message bundle="public" key="list_title_select"/>">
			                	<input type="checkbox" name="allbox" onclick="checkAll('formItem', '_selectopnid');" class="table_checkbox">
			                </td>
			                <td><bean:message bundle="chbbcmarketact" key="opnid"/></td>
			                <td><bean:message bundle="chbbcmarketact" key="opnname"/></td>
			            </tr>
			            <c:forEach var="item" items="${requestScope.opnDp.datas}" varStatus="status">
			            <tr class="table_style_content" align="center">
			                <td><input type="checkbox" name="_selectopnid" value="<c:out value='${item.opnid}' />"
                                onclick="checkOne('formItem', '_selectopnid');" class="table_checkbox"></td>
			                <td><c:out value="${item.opnid}"/></td>
			                <td><c:out value="${item.name}"/></td>
			            </tr>
			            </c:forEach>
			        </table>
                </td>
                <td style="vertical-align: top;">
                	<table class="table_style">
			            <tr class="table_style_head">
			                <td></td>
			                <td>营销活动编码</td>
			                <td>营销活动名称</td>
			            </tr>
			            <c:forEach var="item" items="${requestScope.dicDp.datas}" varStatus="status">
			            <tr class="table_style_content" align="center">
			                <td><input type="radio" name="acttype" value="<c:out value='${item.dictid}'/>"></td>
			                <td><c:out value="${item.dictid}"/></td>
			                <td><c:out value="${item.dictname}"/></td>
			            </tr>
			            </c:forEach>
			        </table>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_save"/>" class="submit"
						onclick="batchsave()"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_return"/>" class="close"
						onclick="doReturn('/cms/chbbcmarketact.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
