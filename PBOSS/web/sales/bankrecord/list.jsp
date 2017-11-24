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
            <tr>
            	<td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                <j:selector definition="#CNTYCOMPANY" name="param._se_countyid" mode="selector" condition="citycompid:${USER.cityid}"/>
                </td>
                
	            <td align="center"><s:text name="retcode"/>:</td>
	            <td align="left">
	            <s:textfield class="style_input" name="param._se_retcode" /><input type="button" class="picker_button" value="..." onClick="doRetcodeSelect();"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="statechgtime"/>>=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnl_statechgtime" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="statechgtime"/><=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._dnm_statechgtime" onclick="selectDatetime();"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="recordstate"/>:</td>
	            <td align="left">
	            <j:selector definition="$FX_RECORDSTATE" name="param._ne_recordstate"/>
                </td>
            </tr>
            
            <tr>
                
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/bankrecord_list.do');">
                	
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
                    <j:orderByImg href="javascript:doOrderby('shopnum')"><s:text name="shopnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctnum')"><s:text name="acctnum"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctname')"><s:text name="acctname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('statechgtime')"><s:text name="statechgtime"/></j:orderByImg>                 
                </td>
                
                <td>
                    <j:orderByImg href="javascript:doOrderby('amount')"><s:text name="amount"/></j:orderByImg>                 
                </td>
               
                <td>
                    <j:orderByImg href="javascript:doOrderby('recordstate')"><s:text name="recordstate"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('retcode')"><s:text name="retcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('errmsg')"><s:text name="errmsg"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('recordinfo')"><s:text name="recordinfo"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     
                     <td><a href='<s:url action="bankrecord_toDetail.do">
	                         <s:param name="param._pk" value="deductid"/>
	                     	</s:url>'>
							<s:property value="deductid"/>
                         </a>
					 </td>
					 <td><s:property value="shopnum" /></td>
					 <td><s:property value="acctnum" /></td>
                     <td><s:property value="acctname" /></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><s:date name="statechgtime" format="yyyy-MM-dd HH:mm:ss"/></td>                     
                     
					 <td><s:property value="amount" /></td>					 
					 <td><j:code2Name definition="$FX_RECORDSTATE" code="recordstate"/></td>
					 <td><j:code2Name definition="$FX_BANKRESPCODE" code="retcode"/></td>
                     <td><s:property value="errmsg" /></td>
					 <td><s:property value="recordinfo" /></td>					 
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
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		return checkval(window);
	}
	
	function doRetcodeSelect(){
       	var url="<%=contextPath%>/sales/bankrecord_retcodeSelect.do";
       	var rtn=window.showModalDialog(url , self , "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
       	if (rtn != null && rtn.length) {
       		document.all('param._se_retcode').value = rtn;
       		return rtn;
       	}
	}
</script>
