<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '32');
            return checkval(window);
        }
        
        function goTo(str){
        var form=document.forms[0];
		form.action="<%=contextPath%>/promotion/ppzlncom_new.do?pk="+str;
		form.submit();
        
        }
        function doDeleteAll(){
    	var sis = formList.all("param._selectitem");
 		if(sis==null){
 			alert("无记录可删除!");
 			return false;
 		} 
 		var TO = true;
 		var e = sis[i];
 		
 		for (var i = 0; i < sis.length; i++) {
                var e = sis[i];
                if (e.type == 'checkbox') {
                    if (e.checked)
                        TO = false;
                }
        }
        if(TO){
 		
    		if(confirm("确定删除全部记录吗?")){
   				if(confirm("此操作会删除全部记录, 确定吗?")){
   				
    			formList.action="<%=contextPath%>/promotion/ppzlncom_delete.do";
    			formList.submit();
    			}else{
    				return false;
    			}
    			
    		}else{
    			return false;
    		}
    	}else{
    		alert("全部删除操作不需要选择记录!");
    		return false;
    	}
    }
    
    function doBatch(str){
    	formList.action="<%=contextPath%>/promotion/ppzlncom/batch.jsp?pk=" + str;
    	formList.submit();
    }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="ppzlncom_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="form.pid" />
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
            <td align="center"><s:text name="comcategory"/>:</td>
            <td align="left">
            	<j:selector definition="$IM_FXCOMCATEGORY" name="param._se_comcategory" mode="picker" cssStyle="style_input" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/promotion/ppzlncom_list.do');">
                	<s:if test="form.isEnabled == 'isActive'">
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="goTo(document.all('form.pid').value)" disabled="true">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/promotion/ppzlncom_delete.do')" disabled="true">
                        
                    <input type="button" id="btnDeleteAll" name="btnDeleteAll" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="全部删除" onClick="doDeleteAll()" disabled="true">
                    <input type="button" id="btnBatch" name="btnBatch" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量导入" onClick="doBatch(document.all('form.pid').value)" disabled="true">
                    </s:if>
                    <s:else>
                     <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="goTo(document.all('form.pid').value)">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/promotion/ppzlncom_delete.do')">
                        
                    <input type="button" id="btnDeleteAll" name="btnDeleteAll" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="全部删除" onClick="doDeleteAll()">
                    <input type="button" id="btnBatch" name="btnBatch" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量导入" onClick="doBatch(document.all('form.pid').value)">
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
                <td style="width:15px" title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <s:text name="comcategory"/>                
                </td>
                <td>
                    <s:text name="comcategoryname"/>               
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="comcategory"/>" onclick="checkOne();">
                     </td>
                     <td>
							<s:property value="comcategory"/>
					 </td>
                     <td>
							<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory" />
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
