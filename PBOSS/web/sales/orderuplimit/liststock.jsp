<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList2"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '10');
            addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
            addfield('param._se_cooptype', '<s:text name="cooptype"/>', 'c', true, '18');
            addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
            addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
            return checkval(window);
        }

        $(document).ready(function(){
       		getCooptypeVal();
		}); 
			
		//回调处理,获取参数列表
        ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
        function nativeCallBack()
        {
        		getCooptypeVal();
        }
        
		//双主键jop标签特殊处理，将代码转为值
		function getCooptypeVal()
		{
			var str;
       		$(".cooptype").each(function(i){
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
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderuplimit_liststock.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList2"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle_stock"/>','<s:text name="helpContent_stock"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="center"><s:text name="cityid"/>:</td>
                <td align="left">
                    <j:selector definition="#CITYCOMPANY" mode="selector" condition="citycompid:${cityid}"  name="param._se_cityid" disabled="true"/>
                </td>
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY" mode="picker" name="param._se_countyid" condition="citycompid:${cityid}" readonly="true"/>
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="cooptype"/>:</td>
                <td align="left">
                	<s:select name="param._se_cooptype" id="cust" list="#request.custwaytypeList" theme="simple" headerKey="" headerValue="" listKey="custwaytypecode" listValue="custwaytypename" />
                </td>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_starlevel" definition="$CH_STARLEVEL" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="of" cssStyle="style_input" />
                </td>
                <td></td>
                <td></td>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/orderuplimit_liststock.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/orderuplimit_newstock.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/orderuplimit_delete.do?forwhat=stock')">
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
                    <a href="javascript:doOrderby('recid')"><s:text name="recid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><s:text name="cityid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('countyid')"><s:text name="countyid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('cooptype')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="cooptype"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><s:text name="brand"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('stdstock')"><s:text name="stdstock"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('maxamtmode')"><s:text name="maxamtmode"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="orderuplimit_editstock.do">
	                         <s:param name="param._pk" value="recid"/>
	                     	</s:url>'>
							<s:property value="recid"/>
                         </a>
					 </td>
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid" /></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid" /></td>
                     <td><input type="hidden" class="cooptype" value="${cooptype}"></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel" /></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand" /></td>
                     <td><s:property value="stdstock" /></td>
                     <td><j:code2Name definition="$FX_MAXORDERAMTMODE" code="maxamtmode" /></td>
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
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
