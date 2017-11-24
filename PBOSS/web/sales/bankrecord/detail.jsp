<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="bankrecord_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea">银行划扣</span>
			<span class="table_toparea_xi">></span>
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
        	<s:hidden name="brdForm.a_deductid"/>
            <tr>
                <td align="center"></td>
                <td align="center">本地数据</td>
                <td align="center">银联数据</td>
            </tr>
            <tr>
                <td align="center"><s:text name="deductid"/></td>
                <td align="center">
                <s:property value="brdForm.a_deductid"/>
                </td>
                <td align="center">
                <s:property value="brdForm.deductid"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="shopnum"/></td>
                <td align="center">
                <s:property value="brdForm.a_shopnum"/>
                </td>
                <td align="center">
                <s:property value="brdForm.shopnum"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="acctnum"/></td>
                <td align="center">
                <s:property value="brdForm.a_acctnum"/>
                </td>
                <td align="center">
                <s:property value="brdForm.account"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="acctname"/></td>
                <td align="center">
                <s:property value="brdForm.a_acctname"/>
                </td>
                <td align="center">
                <s:property value="brdForm.accountname"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="amount"/></td>
                <td align="center">
                <s:property value="brdForm.a_deductamt"/>
                </td>
                <td align="center">
                <s:property value="brdForm.amount"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="statechgtime"/></td>
                <td align="center">
                <s:date name="brdForm.a_statechgtime" format="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td align="center">
                <s:date name="brdForm.completetime" format="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="retcode"/></td>
                <td align="center">
                <j:code2Name definition="$FX_BANKRESPCODE" code="brdForm.a_respcode"/>
                </td>
                <td align="center">
                <j:code2Name definition="$FX_BANKRESPCODE" code="brdForm.retcode"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="errmsg"/></td>
                <td align="center">
                <s:property value="brdForm.a_errmsg"/>
                </td>
                <td align="center">
                <s:property value="brdForm.errmsg"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="recordstate"/></td>
                <td align="center" colspan="2">
                <j:code2Name definition="$FX_RECORDSTATE" code="brdForm.recordstate"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="recordinfo"/></td>
                <td align="center" colspan="2">
                <s:property value="brdForm.recordinfo"/>
                </td>
            </tr>
        </table>
    </div>
	
	<div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                   	<s:if test="'false' eq disFlag">
                    	<input type="button" id="buttonDeduct" name="buttonDeduct" class="button_4" onmouseover="buttonover(this);" 
		                	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                    value=" 重新划扣 " onclick="doDeduct()" />
                    </s:if>
                    
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/bankrecord_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		
		return checkval(window);
	}
	
	function doDeduct(){
		if (confirm("当前记录为银联与银行之间处理问题，请确认账号的正确性或联系管理员后再操作。是否继续？")) {
			var deductid = $(":hidden[name='brdForm.a_deductid']").val();
			formList.action ="<%=contextPath%>/sales/bankrecord_deduct.do?deductid=" + deductid;
			formList.submit();
		}		
	}
</script>
