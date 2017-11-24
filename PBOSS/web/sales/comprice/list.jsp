<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        $(document).ready(function(){
       		getCooptypeVal();
		}); 
			
		//回调处理
        ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
        function nativeCallBack()
        {
        	getCooptypeVal();
        }
        
		//双主键jop标签特殊处理，将代码转为值
		function getCooptypeVal()
		{
			var str="";
       		//$(".cooptype").each(function(i){
       		$(":hidden[name='cooptype']").each(function(i){
       			str = mapSelect("cust",this.value);
       			$(this).after(str);
       			
			});
		}
		//从选择框的值获取选择的显示内容
		function mapSelect(objid,val)
		{
			var str = "";
			$("#"+objid).children().each(function(i){
			
				if(this.value == val)
				{
					str = this.innerText;
				}
			});
			return str;
		}
		
		function doTxt(){
        	formList.action="<%=contextPath%>/sales/comprice_txt.do";
        	formList.submit();
       
        }
        
        function doBatch(){
        	formList.action= "<%=contextPath%>/sales/comprice/batchimport.jsp";
        	formList.submit();
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="comprice_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%--下面的控件给Action提供数据，用来分页--%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
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
                <td align="center"><s:text name="city"/>:</td>
                <td align="left">
                	<j:selector definition="#CITYCOMPANY" mode="selector" name="param._se_cityid" condition="citycompid:${cityid}" value="${cityid}" disabled="true"/>
                </td>
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                	<j:selector definition="#CNTYCOMPANY" mode="picker" name="param._se_countyid" condition="citycompid:${cityid}" readonly="true"/>
                </td>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                	<j:selector definition="$CH_STARLEVEL2" mode="selector" name="param._ne_starlevel"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="cooptype"/>:</td>
                <td align="left">
                	<s:select name="param._se_cooptype" id="cust" list="#request.custwaytypeList" theme="simple" headerKey="" headerValue="" listKey="custwaytypecode" listValue="custwaytypename" />
                </td>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                	<j:selector definition="$IM_FXCOMCATEGORY" name="param._se_comcategory" mode="picker"/>
                </td>
                <td colspan="2">&nbsp;</td> 
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/comprice_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/comprice_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/comprice_delete.do')"> 
                        
                          <input type="button" id="btnBatch" name="btnBatch"
							class="button_4" onmouseover="buttonover(this);"
							onmouseout="buttonout(this);" onfocus="buttonover(this)"
						 onblur="buttonout(this)" value="<s:text name="button_batchimport"/>" onClick="doBatch();">
                        
                     <input type="button" id="btnExporttxt" name="btnExporttxt" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exporttxt"/>" onClick="doTxt();">    
                        
                              
                  
                        
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
                    <j:orderByImg href="javascript:doOrderby('recid')"><s:text name="recid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="city"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cooptype')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="cooptype"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pricediftype')"><s:text name="pricediftype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('price1')"><s:text name="price1"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('price2')"><s:text name="price2"/></j:orderByImg>                 
                </td>
                <td>
                  <s:text name="price3"/>               
                </td>
                <td>
                   <s:text name="price4"/>               
                </td>
                <td>
                    <s:text name="price5"/>             
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="comprice_edit.do">
	                         <s:param name="param._pk" value="recid"/>
	                     	</s:url>'>
							<s:property value="recid"/>
                         </a>
					 </td>
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="$CH_STARLEVEL2" code="starlevel"/></td>
                     <td><s:hidden  name="cooptype"/></td>
                     
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><j:code2Name definition="$FX_PRICEDIFTYPE" code="pricediftype"/></td>
                     
                     <s:if test="pricediftype=='NODIF'">
                     	 <td><s:property value="price1" /></td>
                     	 <td>&nbsp;</td>
	                     <td>&nbsp;</td>
	                     <td>&nbsp;</td>
	                     <td>&nbsp;</td>
                     </s:if>
                     <s:if test="pricediftype=='ACCOUNT'">
                     	 <td>&nbsp;</td>
                     	 <td><s:property value="price1" /></td>
	                     <td><s:property value="price2" /></td>
	                     <td>&nbsp;</td>
	                     <td>&nbsp;</td>
                     </s:if>
                     <s:if test="pricediftype=='INVOICE'">
                     	 <td>&nbsp;</td>
                     	 <td>&nbsp;</td>
	                     <td>&nbsp;</td>
	                     <td><s:property value="price1" /></td>
	                     <td><s:property value="price2" /></td>
                     </s:if>
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
