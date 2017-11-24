<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="rewardsendsms_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="base"/> </span>
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
                <td align="center"><s:text name="cityid"/>:</td> 
                <td align="left">
                	 
                    	<j:selector definition="#CITYCOMPANY" name="param._se_cityid"
							mode="selector" condition="citycompid:${dBAccessUser.cityid }"
							value="${dBAccessUser.cityid }" /> 
				 
                <td align="center"><s:text name="type"/>:</td>
                <td align="left">  
                    	<j:selector definition="$CH_REWARDSMSTYPE" name="param._se_type" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/base/rewardsendsms_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/base/rewardsendsms_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/base/rewardsendsms_delete.do')">
                        
                     <input type="button" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                      onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                      value="导入" onClick="doImport();">
	                            
	                  <input type="button" id="btnExportExcel" name="btnExportExcel" class="button_4" onmouseover="buttonover(this);"
                          onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                          value="导出EXCEL" onClick="doExcel('/base/rewardsendsms_exportExcel.do')">
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
                    <j:orderByImg href="javascript:doOrderby('seqid')"><s:text name="seqid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('sendtel')"><s:text name="sendtel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('type')"><s:text name="type"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seqid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="rewardsendsms_edit.do">
	                         <s:param name="param._pk" value="seqid"/>
	                     	</s:url>'>
							<s:property value="seqid"/>
                         </a>
					 </td>
                     <td><j:code2Name code="cityid" definition="#CITYCOMPANY" /></td>
                     <td><s:property value="sendtel" /></td>
                     <td><j:code2Name definition="$CH_REWARDSMSTYPE" code="type"/></td>
                     <td><s:date name="createtime" format="yyyy-MM-dd"/></td>
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
		addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '14');
		addfield('param._ne_type', '<s:text name="type"/>', 'f', true, '2');
		return checkval(window);
	}
	
	function doExcel(url){
		formList.action = contextPath + url; 
		formList.submit();
  		formList.action = contextPath + "/base/rewardsendsms_list.do";
		}
 
 	function doImport(){			
		formList.action = "<%=contextPath%>/base/rewardsendsms/batch.jsp";
      	formList.submit();
		} 
	
	
</script>
