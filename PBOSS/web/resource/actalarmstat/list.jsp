<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script type="text/javascript">
    	function getMarea()
       	{
       		var countyid = $("#countyid").val();
	       	$.post(contextPath+"/resource/actalarmstat_getMarea.do", 
	       	{ countyid: countyid},
			function(data){
				$("#marea").remove();
				
				var str = '<select id="marea" name="param.mareacode"><option></option>';
				if(data.length>0)
				{
					var mareaArray = data.split(";");
					var mareaInfoArray;
					
					for(var i=0; i<mareaArray.length; i++)
					{
						mareaInfoArray = mareaArray[i].split(",");
						str = str + '<option value="' + mareaInfoArray[0] + '">' + mareaInfoArray[1] + '</option>';
					}
				}
				str = str + '</select>';
				$("#mareaTd").html(str);
			});
       	}
        	
    	ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
        function nativeCallBack()
        {
        	getRate();
        }
        
        function getRate()
        {
        	var rate = "";
    		$(".rate").each(function(i){
    			rate = parseFloat($(this).val()*100).toFixed(2);
    			$(this).after(rate + "%");
    		});
        }
        
        function doExcel(){
        	formList.action="<%=contextPath%>/resource/actalarmstat_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/actalarmstat_list.do";
        }

        function doTxt()
        {
        	formList.action="<%=contextPath%>/resource/actalarmstat_txt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/actalarmstat_list.do";
        }
        
    	$(document).ready(function(){
    		getRate();
    	});
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="actalarmstat_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    <s:hidden name="form.macodeStr" id="macodeStr"/>
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
            	<td align="center"><s:text name="countycompname"/>:</td>
                <td align="left">
	                <input type="text" name="param.countyid" id="countyid" readonly="true" onpropertychange="getMarea()"/><input type="button" name="param.countyid_button" class="picker_button"
					 value="..." onclick="javascript:openPicker(this,'#CNTYCOMPANY','citycompid:${form.cityid}');"/>
                </td>
            	<td align="center"><s:text name="maname"/>:</td>
                <td align="left" id="mareaTd">
                	<select id="marea" name="param.mareacode">
                		<option></option>
                	</select>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="def" cssStyle="style_input"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="stattype"/>:</td>
                <td align="left">
                	<s:select name="param._se_stattype" list="form.stattypeMap" >
                	</s:select>
                </td>
                <td align="center">&nbsp;</td>
                <td align="left">&nbsp;</td>
            </tr>
            <tr>
            	<td align="center"><s:text name="rate"/>（%）&gt;=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._nnl_rate"/>
                </td>
            	<td align="center"><s:text name="rate"/>（%）&lt;=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._nnm_rate"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="stattime"/>&gt;=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._snl_yearmonth" onclick="selectDateYYYYMM();"/>
                </td>
            	<td align="center"><s:text name="stattime"/>&lt;=:</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="param._snm_yearmonth" onclick="selectDateYYYYMM();"/>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnExcel" name="btnExcel" class="button_4" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="导出EXCEL" onClick="doExcel();">
	                            
                	<input type="button" id="btntxt" name="btntxt" class="button_2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="导出TXT" onClick="doTxt();">  
                    
                    <input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/actalarmstat_list.do');">
                        
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
                    <s:text name="id"/>              
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('yearmonth')"><s:text name="yearmonth"/></j:orderByImg>                 
                </td>
                <td>
                    <s:text name="countycompname"/>                
                </td>
                <td>
                    <s:text name="maname"/>              
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <s:text name="wayname"/>             
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('brand')"><s:text name="brand"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('stattype')"><s:text name="stattype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('lhamount')"><s:text name="lhamount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('jhamount')"><s:text name="jhamount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('rate')"><s:text name="rate"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><s:property value="id"/></td>
                     <td><s:property value="yearmonth"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><s:property value="wayid"/></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid"/></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
                     <td>
                     	最近<s:property value="stattype"/>个月
                     </td>
                     <td><s:property value="lhamount" /></td>
                     <td><s:property value="jhamount" /></td>
                     <td>
                     	<input type="hidden" class="rate" value="<s:property value="rate" />">
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
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		return checkval(window);
	}
</script>
