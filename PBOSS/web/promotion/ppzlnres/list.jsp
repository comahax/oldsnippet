<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doDeleteAll(str){
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
    				formList.action="<%=contextPath%>/promotion/ppzlnres_delete.do";
    				formList.submit();
    				formList.action="<%=contextPath%>/promotion/ppzlnres_list.do?param_pk=" + str;
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
    	formList.action="<%=contextPath%>/promotion/ppzlnres/batch.jsp?pk=" + str;
    	formList.submit();
    }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="ppzlnres_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="form.pid"/>
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
            	<td align="center"><s:text name="resid"/></td>
            	<td align="left"><s:textfield cssStyle="style_input" name="param._se_resid" /></td>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/promotion/ppzlnres_list.do');">
                	<s:if test="form.isEnabled == 'isActive'">
                	<input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/promotion/ppzlnres_new.do')" disabled="true">
                        
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/promotion/ppzlnres_delete.do')" disabled="true">
                        
                     <input type="button" id="btnDeleteAll" name="btnDeleteAll" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="全部删除" onClick="doDeleteAll(document.all('form.pid').value)" disabled="true">
                        
                     <input type="button" id="btnBatch" name="btnBatch" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量导入" onClick="doBatch(document.all('form.pid').value)" disabled="true">
                     </s:if>
                     <s:else>
                     	<input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/promotion/ppzlnres_new.do')">
                        
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/promotion/ppzlnres_delete.do')">
                        
                     <input type="button" id="btnDeleteAll" name="btnDeleteAll" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="全部删除" onClick="doDeleteAll(document.all('form.pid').value)">
                        
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
                    <s:text name="resid"/>            
                </td>
                <td>
                    分销商品种类        
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="resid"/>" onclick="checkOne();">
                     </td>
                     <td>
							<s:property value="resid"/>
                        
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
