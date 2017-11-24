<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._dnm_statdate', '<s:text name="statdate"/>', 'dt', true, '7');
		addfield('param._de_statdate', '<s:text name="statdate"/>', 't', true, '7');
		addfield('param._dnl_statdate', '<s:text name="statdate"/>', 'dt', true, '7');
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._ne_kcamount', '<s:text name="kcamount"/>', 'f', true, '10');
		addfield('param._ne_stocklimit', '<s:text name="stocklimit"/>', 'f', true, '10');
		addfield('param._ne_realstock', '<s:text name="realstock"/>', 'f', true, '10');
		addfield('param._se_isalarm', '<s:text name="isalarm"/>', 'c', true, '32');
		return checkval(window);
	}
	
	function doExcel(){
        formList.action="<%=contextPath%>/resource/stkalarmct_excel.do";
        formList.submit();
        formList.action="<%=contextPath%>/resource/stkalarmct_list.do";
    }
    
    function doTxt(){
        formList.action="<%=contextPath%>/resource/stkalarmct_txt.do";
        formList.submit();
        formList.action="<%=contextPath%>/resource/stkalarmct_list.do";
    }
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="stkalarmct_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="resource"/> </span>
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
                <td align="right"><s:text name="statdate"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_statdate" onclick="selectDatetime();" readonly="true"/>&nbsp;&nbsp;<font color="red">*</font>
                </td>
                <td align="right"><s:text name="statdate"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_statdate" onclick="selectDatetime();" readonly="true"/>&nbsp;&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY" value="${requestScope.countyidd}"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector" />
                </td>
                <td align="right"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="def" cssStyle="style_input" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/stkalarmct_list.do');">
                	
                    <input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)" value="导出EXCEL" onClick="doExcel();">
                    <input type="button" id="btnTxt" name="btnTxt" class="button_4" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)" value="导出TXT" onClick="doTxt();">
					
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style" height="100%">
            <tr class="table_style_head">
                <td>
                    <j:orderByImg href="javascript:doOrderby('seqid')"><s:text name="seqid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('statdate')"><s:text name="statdate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('brand')"><s:text name="brand"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('kcamount')"><s:text name="kcamount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('realstock')"><s:text name="realstock"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('greenstock')"><s:text name="greenstock"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('yellowstock')"><s:text name="yellowstock"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('redstock')"><s:text name="redstock"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('greengap')"><s:text name="greengap"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('yellowgap')"><s:text name="yellowgap"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('redgap')"><s:text name="redgap"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('saleamt')">前${requestScope.paramvalue}天<s:text name="saleamt"/></j:orderByImg>                 
                </td>
                
                 <td>
                    <j:orderByImg href="javascript:doOrderby('supportday')"><s:text name="supportday"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isalarm')"><s:text name="isalarm"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                <tr class="table_style_content" align="center"
									onMouseMove="this.bgColor='F0F5F9'"
									onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
						<s:property value="seqid"/>
					 </td>
                     <td><s:date name="statdate" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
                     <td><s:property value="kcamount" /></td>
                     <td><s:property value="realstock" /></td>                     
                     <td><s:property value="greenstock" /></td>
                     <td><s:property value="yellowstock" /></td>
                     <td><s:property value="redstock" /></td>
                     <td><s:property value="greengap" /></td>
                     <td><s:property value="yellowgap" /></td>
                     <td><s:property value="redgap" /></td>
                     <td><s:property value="saleamt" /></td>
                     <td><s:property value="supportday" /></td>
                     <td><j:code2Name definition="$IM_YESNO10" code="isalarm" /></td>
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

