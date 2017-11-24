<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_optype', '<s:text name="optype"/>', 'c', true, '16');
		addfield('param._se_ltype', '<s:text name="ltype"/>', 'c', true, '128');
		
		return checkval(window);
	}

	function ev_check2() {
		addfield('form.rate', '<s:text name="rate"/>', 'f', true, 16);
		return checkval(window);
	}

	function doImport(){			
		formList.action = "<%=contextPath%>/rewards/ltype/batch.jsp";
  		formList.submit();
	}

	function doSave2(url){
		formRateList.action = contextPath + url;
		formRateList.submit();
		formList.action = contextPath + "/ltype/ltype_list.do";
	}
	function doQueryltype(url){
		formList.action = contextPath + url;
		formList.submit();
	}
	
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="酬金管理"/> </span>
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
    
  <s:form key="formRateList" cssStyle="formRateList" theme="simple" onsubmit="return ev_check2();">
<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="对私酬金代扣代缴税率"/>:</td>
                <td align="left">
                <s:textfield cssStyle="style_input" name="form.rate" /> %
                </td>
               
                 <td  align="left">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave2('/ltype/ltype_save2.do')" />
                
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    </s:form>
    <s:form action="ltype_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="optype"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_optype" />
                </td>
                <td align="center"><s:text name="ltype"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_ltype" />
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
                        value="<s:text name="button_search"/>" onClick="doQueryltype('/ltype/ltype_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/ltype/ltype_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/ltype/ltype_delete.do')">
                        
                         <input type="button" id="btnExport" name="btnExport"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exportexcel"/>"
										onClick="doExport('/ltype/ltype_exportExcel.do')">
										
                      <input type="button" id="btnBatch" name="btnBatch"
											class="button_2" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="批量导入" onClick="doImport();">
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
                    <j:orderByImg href="javascript:doOrderby('optype')"><s:text name="optype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ltype')"><s:text name="ltype"/></j:orderByImg>                 
                </td>
                <td>
                  <s:text name="酬金小类"/>               
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="stype"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="ltype_edit.do">
	                         <s:param name="param._pk" value="stype"/>
	                     	</s:url>'>
							<s:property value="optype"/>
                         </a>
					 </td>
                     <td>
							<s:property value="ltype"/>
                         
					 </td>
                     <td><s:property value="stype" /></td>
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
