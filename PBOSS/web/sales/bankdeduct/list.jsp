<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._ne_deductid', '<s:text name="deductid"/>', 'f', true, '14');
		addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
		addfield('param._se_bankid', '<s:text name="bankid"/>', 'c', true, '16');
		addfield('param._se_acctnum', '<s:text name="acctnum"/>', 'c', true, '64');
		addfield('param._dnm_creatdate', '<s:text name="creatdate"/>', 'dt', true, '7');
		addfield('param._dnl_creatdate', '<s:text name="creatdate"/>', 'dt', true, '7');
		addfield('param._se_shopnum', '<s:text name="shopnum"/>', 'c', true, '32');
		addfield('param._se_terminalnum', '<s:text name="terminalnum"/>', 'c', true, '32');
		return (checkval(window) && compareDate());
	}
	function compareDate(){
        var startTime = document.getElementById('param._dnl_creatdate').value;
        var endTime = document.getElementById('param._dnm_creatdate').value;
        if(startTime != '' && endTime != '' &&  startTime>endTime){
        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[创建时间>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[创建时间<=]</span>';
		errorMessageShow(alertstr);
        return false;
       }
    	return true;	
    }
	function doBankSelect(){
    	var url="<%=contextPath%>/channel/bank_bankselect.do";
    	var rtn=window.showModalDialog(url , self , "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
    	if (rtn != null && rtn.length) {
    		document.all('param._se_bankid').value = rtn;
    		return rtn;
    	}
	}
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="bankdeduct_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
            <tr>
                <td align="center"><s:text name="deductid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_deductid" />
                </td>
                <td align="center"><s:text name="orderid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_orderid" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="bankid"/>:</td>
                <td align="left">
                    <s:textfield class="style_input" name="param._se_bankid" /><input type="button" class="picker_button" value="..." onClick="doBankSelect();"/>
                </td>
                <td align="center"><s:text name="acctnum"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_acctnum" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="shopnum"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_shopnum" />
                </td>
                <td align="center"><s:text name="terminalnum"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_terminalnum" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="creatdate"/>&gt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_creatdate" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="creatdate"/>&lt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_creatdate" onclick="selectDatetime();"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/bankdeduct_list.do');">
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
                <td>
                    <j:orderByImg href="javascript:doOrderby('deductid')"><s:text name="deductid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderid')"><s:text name="orderid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bankid')"><s:text name="bankid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctnum')"><s:text name="acctnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('accttype')"><s:text name="accttype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctname')"><s:text name="acctname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('deductamt')"><s:text name="deductamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('shopnum')"><s:text name="shopnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('terminalnum')"><s:text name="terminalnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('creatdate')"><s:text name="creatdate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('respcode')"><s:text name="respcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('errmsg')"><s:text name="errmsg"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><s:property value="deductid"/></td>
                     <td><s:property value="orderid" /></td>
                     <td><j:code2Name definition="#BANK" code="bankid" /></td>
                     <td><s:property value="acctnum" /></td>
                     <td><j:code2Name definition="$CH_ACCOUNTTYPE" code="accttype" /></td>
                     <td><s:property value="acctname" /></td>
                     <td><s:property value="deductamt" /></td>
                     <td><s:property value="shopnum" /></td>
                     <td><s:property value="terminalnum" /></td>
                     <td><s:date name="creatdate" format="yyyy-MM-dd HH:mm:ss "/></td>
                     <td><j:code2Name definition="$FX_PROCSTATE" code="state" /></td>
                     <td><j:code2Name definition="$FX_BANKRESPCODE" code="respcode" /></td>
                     <td><s:property value="errmsg" /></td>
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