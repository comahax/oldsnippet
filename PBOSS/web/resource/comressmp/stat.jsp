<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
            return checkval(window);
        }
        
        function doExport(actionUrl){
        	formList.action="<%=contextPath%>"+actionUrl;
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/comressmp_stat.do";
        }
        
        function doPrint() //打印函数   
		{  		
			if(confirm('确认打印')){ 
				var bodyHtml  = window.document.body.innerHTML;
				var prnhtml=document.getElementById('printPart').innerHTML;
				window.document.body.innerHTML=prnhtml; 
				window.print();
				window.document.body.innerHTML = bodyHtml;
			}
		}
		
		function printPreview(){
		var OLECMDID = 7;   
		var PROMPT = 1;   
		var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';   
		document.body.insertAdjacentHTML('beforeEnd', WebBrowser);   
		WebBrowser1.ExecWB(OLECMDID, PROMPT);   
		WebBrowser1.outerHTML = "";   
		}
    </script>
    <style type="text/css">
    .table_style2 {
	width:100%;
	border:#CDCDCD solid 0px;
	border-collapse:collapse;

}
    </style>
    <script type="text/javascript" src="<%= contextPath %>/js/pub/print.js"></script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<!-- 
<OBJECT ID="factory" WIDTH=0 HEIGHT=0 CLASSID="CLSID:1663ed6a-23eb-11d2-b92f-008048fdd814" BaseHref="http://localhost/js/pub/ScriptX.cab"></OBJECT>
 -->
<div class="table_container">
<s:form action="comressmp_stat.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="isQuery" value="true"></s:hidden>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea"><s:text name="resstockstat"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle_stat"/>','<s:text name="helpContent_stat"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                 <j:selector name="param._se_countyid" definition="#CNTYCOMPANY" condition="citycompid:${USER.cityid}"  mode="selector"/>
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
              </tr>
              <tr>
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="def" cssStyle="style_input" />
                </td>
                <td align="center"><s:text name="comcatgory"/>:</td>
                <td align="left">
                     <j:selector name="param._se_comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="comstate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_COMSTATE" name="param._ne_comstate" condition="_sne_dictid:2" mode="selector"/>
                </td>
                <td align="center"></td>
                <td align="left">
                     
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/comressmp_stat.do');">
                        
                         <input type="button" id="btnPrint" name="btnPrint" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_print"/>" onClick="doPrint()">
                    
                    <input type="button" id="btnexport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_export"/>EXCEL" onClick="doExport('/resource/comressmp_statExportExcel.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div id="printPart">
    	<div>
        <table class="table_style" id="tt">
            <tr class="table_style_head">
               <td>
                    <a href="javascript:doOrderby('countyid')"><s:text name="countyid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><s:text name="wayid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><s:text name="brand"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('comcategory')"><s:text name="comcatgory"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('comstate')"><s:text name="comstate"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('ncount')"><s:text name="ncount"/></a>                 
                </td>              
            </tr>
            

             <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" >					
					<s:if test="countyid != ''">
					<td rowspan="<s:property value="countyCount"/>"> <j:code2Name definition="#CNTYCOMPANY" code="countyid"/> </td>
					</s:if>
					<s:if test="wayid != ''">
					<td rowspan="<s:property value="wayCount"/>"> <j:code2Name definition="#WAYIDINFO" code="wayid"/> </td>
					</s:if>
					<s:if test="brand != ''">
					<td rowspan="<s:property value="brandCount"/>"><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
					</s:if>
					<s:if test="comcategory != ''">
					<td rowspan="<s:property value="comcateCount"/>"> <j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
					</s:if>
					<td> <j:code2Name definition="$FX_COMSTATE" code="comstate"/></td>
					<td><s:property value="ncount"/> </td>					
                 </tr>
             </s:iterator>   
               
               
             <tr class="table_style_content" align="center">
             <td><s:text name="total"/></td><td >&nbsp;</td><td >&nbsp;</td><td >&nbsp;</td><td >&nbsp;</td><td><s:property value="dp.rowCount"/></td>
             </tr>
        </table>
        </div>
    </div>

    </aa:zone>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete");
</script> 
</body>
</html>
