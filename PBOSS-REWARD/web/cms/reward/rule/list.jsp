<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
    String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="rule" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_se_ruleid', '<bean:message bundle="rule" key="ruleid"/>', 'c', true, '18');
        	addfield('_sk_rulename', '<bean:message bundle="rule" key="rulename"/>', 'c', true, '60');
        	addfield('_dnl_startdate', '<bean:message bundle="rule" key="_dnl_startdate"/>', 'dt', true, '19');
        	addfield('_dnm_startdate', '<bean:message bundle="rule" key="_dnm_startdate"/>', 'dt', true, '19');
            addfield('_dnl_enddate', '<bean:message bundle="rule" key="_dnl_enddate"/>', 'dt', true, '19');
            addfield('_dnm_enddate', '<bean:message bundle="rule" key="_dnm_enddate"/>', 'dt', true, '19');
            return checkval(window);
        }
        
        function doOnBusi() {
        	var sis = formList.all("_selectitem");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox' && sis[i].checked) {
        				checkedNum++;
        				id = sis[i].value;
        			}
        		}
        	}
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	if (checkedNum > 1) {
        		alert('<bean:message bundle="rule" key="remindOnBusi2"/>');
        		return;
        	}
        	
        	formList.action = contextPath + '/cms/reward/ruleonbusi.do?CMD=SHOW&_pageno=1&KEY=' + id;
        	formList.submit();
        }
        function doRuleDetailSet() {
        	var sis = formList.all("_selectitem");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox' && sis[i].checked) {
        				checkedNum++;
        				id = sis[i].value;
        			}
        		}
        	}
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	if (checkedNum > 1) {
        		alert('<bean:message bundle="rule" key="remindOnBusi2"/>');
        		return;
        	}
        	
        	formList.action = contextPath + '/cms/reward/rulerel.do?CMD=LIST&_pageno=1&_se_ruleid=' + id+"&_se_cityid=999";
        	formList.submit();
        }
        function doCityRuleDetailSet() {
        	var sis = formList.all("_selectitem");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			checkedNum = 1;
        			id = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox' && sis[i].checked) {
        				checkedNum++;
        				id = sis[i].value;
        			}
        		}
        	}
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	if (checkedNum > 1) {
        		alert('<bean:message bundle="rule" key="remindOnBusi2"/>');
        		return;
        	}
        	
        	//formList.action = contextPath + '/cms/reward/rulerel.do?CMD=LIST&_pageno=1&_se_ruleid=' + id+"&_se_cityid=<c:out value='${sessionScope.USER.cityid}'/>";
        	formList.action = contextPath + '/cms/reward/rulemode.do?CMD=LIST&_pageno=1&_se_ruleid=' + id+"&_se_cityid=<c:out value='${sessionScope._USER.cityid}'/>"+"&_orderby=startdate&_desc=1";
        	formList.submit();
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/rule.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rule" key="titleList"/>
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
    			<td width="80" height="20" align="right" class="form_table_right" >
                   <bean:message bundle="rule" key="ruleid"/>:
            	</td>
            	<td class="form_table_left">
               	  <html:text styleClass="form_input_1x" property="_se_ruleid" maxlength="18" />
            	</td>
            	<td width="80" height="20" align="right" class="form_table_right" >
                    <bean:message bundle="rule" key="rulename"/>:
            	</td>
            	<td class="form_table_left">
               	  <html:text styleClass="form_input_1x" property="_sk_rulename" maxlength="60" />
            	</td>
         </tr>
         <tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rule" key="_dnl_startdate"/>:
            	</td>
            	<td class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_dnl_startdate" onclick="this.value=selectDatetime();" />
            	</td>
            	<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rule" key="_dnm_startdate"/>:
            	</td>
            	<td class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_dnm_startdate" onclick="this.value=selectDatetime();" />
            	</td>
         </tr>
         <tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rule" key="_dnl_enddate"/>:
            	</td>
            	<td class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_dnl_enddate" onclick="this.value=selectDatetime();" />
            	</td>
            	<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rule" key="_dnm_enddate"/>:
            	</td>
            	<td class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_dnm_enddate" onclick="this.value=selectDatetime();" />
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                	<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true" >
                        <input type="button" name="btnCityRuleDetailSet"  class="button_8" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="rule" key="cityruledetailset"/>" onClick="doCityRuleDetailSet()">
                    </s:RewardPurChk>
	                  <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
                        <input type="button" name="btnRuleDetailSet"  class="button_8" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="rule" key="ruledetailset"/>" onClick="doRuleDetailSet()">
                      </s:RewardPurChk>
                      <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
                        <input type="button" name="btnOnBusi"  class="button_6" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="rule" key="btnOnBusi"/>" onClick="doOnBusi()">
                      </s:RewardPurChk>
                      <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/rule.do')">
                      </s:RewardPurChk>
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
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
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="rule" key="ruleid"/></a>
                    <s:OrderImg form="/cms/reward/rule/ruleForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rulename')"><bean:message bundle="rule" key="rulename"/></a>
                    <s:OrderImg form="/cms/reward/rule/ruleForm" field="rulename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="rule" key="startdate"/></a>
                    <s:OrderImg form="/cms/reward/rule/ruleForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('enddate')"><bean:message bundle="rule" key="enddate"/></a>
                    <s:OrderImg form="/cms/reward/rule/ruleForm" field="enddate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="rule" key="remark"/></a>
                    <s:OrderImg form="/cms/reward/rule/ruleForm" field="remark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/rule.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.ruleid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.ruleid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.ruleid}"/></a>
                     </td>
                     <td><c:out value="${item.rulename}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.startdate}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.enddate}"/></td>
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
