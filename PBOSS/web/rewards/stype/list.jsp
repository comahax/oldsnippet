<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
    function getElementByTabId(tabName){
	    return document.getElementById(tabName);
	}
    
    function ev_check() {
		addfield('param._sk_optype', '<s:text name="optype"/>', 'c', true, '16');
		addfield('param._sk_ltype', '<s:text name="ltype"/>', 'c', true, '128');
		
		return checkval(window);
	}
    
	function doQueryList(url){
		getElementByTabId("btnBatchDelete").disabled = false;
		getElementByTabId("hid_se_optype").value=getElementByTabId("param._se_optype").value;
		getElementByTabId("hid_sk_ltype").value=getElementByTabId("param._sk_ltype").value;
		getElementByTabId("hid_sk_stype").value=getElementByTabId("param._sk_stype").value;
		
		doQuery(url);
	}

	function doExport(url){
		formList.action = contextPath + url;
		formList.submit();
		formList.action = contextPath + "/stype/stype_list.do";
	}
	
	function doImport(){			
		formList.action = "<%=contextPath%>/rewards/stype/batch.jsp";
  		formList.submit();
	}

	function doSave2(url){
		formRateList.action = contextPath + url;
		formRateList.submit();
		formList.action = contextPath + "/stype/stype_list.do";
	}
	
	function doQuerystype(url){
		//getElementByTabId("isCheck").value = "1";
		formList.action = contextPath + url;
		formList.submit();
	}
	
	function checkQryParams(){
		var msg = "";
		if(getElementByTabId("param._se_optype").value != getElementByTabId("hid_se_optype").value){
			msg="【业务类型】条件已改变，请重新点击【查询】获得结果";
		}
		if(getElementByTabId("param._sk_ltype").value != getElementByTabId("hid_sk_ltype").value){
			msg="【酬金大类】条件已改变，请重新点击【查询】获得结果";
		}
		if(getElementByTabId("param._sk_stype").value != getElementByTabId("hid_sk_stype").value){
			msg="【酬金小类】条件已改变，请重新点击【查询】获得结果";
		}
		
		return msg;
	}
	
	function doBatchDelete(cmdDelete) {
		// 校验查询条件是否改变
		var msg = checkQryParams();
		if(msg!=""){
			alert(msg);
			return;
		}
			
		var rowcount = getElementByTabId("_rowcount").value;
		if(rowcount == 0){
			alert("查询结果为空，请重新点击【查询】");
			return;
		}
		
		var optype = getElementByTabId("param._se_optype").value;
		var ltype = getElementByTabId("param._sk_ltype").value;
		var stype = getElementByTabId("param._sk_stype").value;
		
		// 不允许不选择条件做整表删除
		if(optype==""&&ltype==""&&stype==""){
			alert("查询条件不能都为空，请先选择查询条件做查询");
			return;
		}
		
		var send = new Object();
        send.optype = optype;
        send.ltype = ltype;
        send.stype = stype;
        send.rowcount = rowcount;

        var dirurl = "<%=contextPath%>/rewards/stype/batchDelDialog.jsp";
        var ret = window.showModalDialog(dirurl,send,"dialogHeight:250px;dialogWidth:550px;status:no;help:no");
        //alert("ret=" + ret );
		if(ret == "ok"){
			getElementByTabId("btnBatchDelete").disabled= true;
			formList.action = contextPath + cmdDelete;
		    formList.submit();
		}	
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
 
<s:form action="stype_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                    <j:selector definition="LTYPEOPTYPE" name="param._se_optype" />
                    <input type="hidden" name="hid_se_optype" />
                </td>
                <td align="center"><s:text name="ltype"/>:</td>
                <td align="left">
                    <j:selector name="param._sk_ltype" definition="#LTYPE" />
                    <input type="hidden" name="hid_sk_ltype" />
                </td>
                 <td align="center"><s:text name="stype"/>:</td>
                <td align="left">
                    <j:selector name="param._sk_stype" definition="#STYPE" />
                    <input type="hidden" name="hid_sk_stype" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
				    <input type="hidden" name="isCheck" value="0" />
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQueryList('/stype/stype_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/stype/stype_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/stype/stype_delete.do')">
                     
                    <input type="button" id="btnBatchDelete" name="btnBatchDelete" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_batchdelete"/>" onClick="doBatchDelete('/stype/stype_batchDelete.do')">
                                           
                    <input type="button" id="btnExport" name="btnExport"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exportexcel"/>"
										onClick="doExport('/stype/stype_exportExcel.do')">
										
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
                    <s:text name="optype"/>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ltype')"><s:text name="ltype"/></j:orderByImg>                 
                </td>
                <td>
                   <j:orderByImg href="javascript:doOrderby('stype')"><s:text name="stype"/></j:orderByImg>               
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seq"/>" onclick="checkOne();">
                     </td>
                     <td>
							 <a href='<s:url action="stype_edit.do">
					                         <s:param name="param._pk" value="seq"/>
					                     	</s:url>'><s:property value="optype" /></a>
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
