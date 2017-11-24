<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function goTo(str){
	        var form=document.forms[0];
			form.action="<%=contextPath%>/promotion/ppzlnrule_delete.do";
			form.submit();
        }
        
        function goToRuleitem(str, str1, str2){
        	formList.action = "<%=contextPath%>/promotion/ruleitem_list.do?pk="+str+"&pk1=" + str1 + "&isActive="+str2;
        	formList.submit();
        }
        
        function goToRewardstd(str, str1, str2){
        	
        	formList.action = "<%=contextPath%>/promotion/rewardstd_list.do?pk="+str+"&pk1=" + str1 + "&isActive=" + str2;
        	formList.submit();
        }
        
        function goToQuantity(str, str1, str2){
        	formList.action = "<%=contextPath%>/promotion/pquantity_list.do?pk="+str+"&pk1=" + str1 + "&isActive=" + str2;
        	formList.submit();
        }
        
        function goToTieinsale(str, str1, str2){
        	formList.action = "<%=contextPath%>/promotion/tieinsale_list.do?pk="+str +"&pk1=" + str1 + "&isActive=" + str2;
        	formList.submit();
        }
        
        function goToPresentingb(str, str1, str2){
        	formList.action = "<%=contextPath%>/promotion/presentingb_list.do?pk="+str+"&pk1=" + str1 + "&isActive=" + str2;
        	formList.submit();
        }
        
        function goToPresentinga(str, str1, str2){
        	formList.action = "<%=contextPath%>/promotion/presentinga_list.do?pk="+str+"&pk1=" + str1 + "&isActive=" + str2;
        	formList.submit();
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="ppzlnrule_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="form.pid" />
    <s:hidden name="form.ptype" />
    <s:hidden name="form.ruleid" />
    <s:hidden name="form.pfrtmode" />
    <s:hidden name="form.isEnabled" />
    
    
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="promotion"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	<div class="table_div">
        <table class="table_normal">
            <tr>
            	<td align="center"><s:text name="ruleid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param.queryRuleid" />
                </td>
                <td align="center"><s:text name="rulename"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_rulename" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/promotion/ppzlnrule_list.do');">
                	<s:if test="form.isEnabled == 'isActive'">
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/promotion/ppzlnrule_new.do')" disabled="true">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/promotion/ppzlnrule_delete.do')" disabled="true">
                    </s:if>
                    <s:else>
                    	<input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/promotion/ppzlnrule_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/promotion/ppzlnrule_delete.do')">
                    </s:else>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="返回方案首页" onClick="doReturnInFrame('/promotion/spproposal_list.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>
	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <s:text name="ruleid"/>
                </td>
                <td>
                    <s:text name="rulename"/>                
                </td>
                <td>
                    <s:text name="pri"/>           
                </td>
                <td>
                	规则明细
                </td>
                <td>
                	规则类型
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" >
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="ruleid"/>" onclick="checkOne();">
                     </td>
                     <td>
							<s:property value="ruleid"/>
					 </td>
					 <td><s:property value="rulename" /></td>
                     <td><j:code2Name definition="$CH_PRI" code="pri" /></td>
                     <td width="90px">
                     	<input type="button" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="规则明细" onClick="goToRuleitem(<s:property value="ruleid"/>, document.all['form.pid'].value, document.all['form.isEnabled'].value)"></td>
                     <td width="90px">
                     	<s:if test="form.ptype==0">
                     		<input type="button" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="酬金设置" onClick="goToRewardstd(<s:property value="ruleid"/>, document.all['form.pid'].value, document.all['form.isEnabled'].value);">
                       	</s:if>
                       	<s:if test="form.ptype==1">
                       		<input type="button" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="订货量设置" onClick="goToQuantity(<s:property value="ruleid"/>, document.all['form.pid'].value, document.all['form.isEnabled'].value);">
                        </s:if>
                        <s:if test="form.ptype==2">
                       		<input type="button" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="搭售设置" onClick="goToTieinsale(<s:property value="ruleid"/>, document.all['form.pid'].value, document.all['form.isEnabled'].value);">
                        </s:if>
                        <s:if test="form.ptype==3">
                       		<input type="button" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="赠送(售前)设置" onClick="goToPresentingb(<s:property value="ruleid"/>, document.all['form.pid'].value, document.all['form.isEnabled'].value);">
                        </s:if>
                        <s:if test="form.ptype==4">
                       		<input type="button" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="赠送(售后)设置" onClick="goToPresentinga(<s:property value="ruleid"/>, document.all['form.pid'].value, document.all['form.isEnabled'].value);">
                        </s:if>
                     </td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
   	 </aa:zone>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
