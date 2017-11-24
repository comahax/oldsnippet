<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		return checkval(window);
	}
	function doExport(url){
		formList.action = contextPath + url;
		formList.submit();
		formList.action = contextPath + "/setcard/setcard_list.do";
	}

	function doImport(){	
		formList.action = contextPath+ "/rewards/setcard/batch.jsp";
  		formList.submit();
	}

</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="setcard_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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

	<div class="table_div">
        <table class="table_normal">
         
            <tr>
                 <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <j:selector definition="#WAYIDINFO" name="param._se_wayid" />
                </td>
                <td align="center"><s:text name="waytype"/>:</td>
                <td align="left">
                	<select  name="param._se_waytype">
                		<option value="" ></option>
                        <option value="1" >自有渠道</option>
                        <option value="2" >社会渠道</option>
                    </select>
                    <input type="hidden" name="hid_se_waytype" />
                </td>
             </tr>
             
              <tr>
                
                <td align="center"><s:text name="mobile"/>:</td>
                <td align="left">
                    <input type="text" id="param._se_mobile" name="param._se_mobile" value="<s:property value="param._se_mobile"/>" maxlength="128" />
                    <input type="hidden" name="hid_se_mobile" />
                </td>
                <td align="center"><s:text name="actvday"/>:</td>
                <td align="left">
                    <input type="text" id="param._se_actvday" name="param._se_actvday" value="<s:property value="param._se_actvday"/>" maxlength="128" onclick="selectDate();"/>
                    <input type="hidden" name="hid_se_actvday" />
                </td>
            </tr>
             
             <tr>
                <td align="center"><s:text name="_dnl_intime"/>:</td>
                <td align="left">
                    <input type="text" id="param._dnl_intime" name="param._dnl_intime" value="<s:property value="param._dnl_intime"/>" maxlength="128" onclick="selectDatetime();"/>
                    <input type="hidden" name="hid_dnl_intime" />
                </td>
                <td align="center"><s:text name="_dnm_intime"/>:</td>
                <td align="left">
                     <input type="text" id="param._dnm_intime" name="param._dnm_intime" value="<s:property value="param._dnm_intime"/>" maxlength="128" onclick="selectDatetime();"/>
                    <input type="hidden" name="hid_dnm_intime" />
                </td>
            </tr>
             <tr>
                <td align="center"><s:text name="filename"/>:</td>
                <td align="left">
                    <input type="text" id="param._sk_filename" name="param._sk_filename" value="<s:property value="param._sk_filename"/>" maxlength="128" />
                    <input type="hidden" name="hid_sk_filename" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/setcard/setcard_list.do')">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/setcard/setcard_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/setcard/setcard_delete.do')">
                    
                    <input type="button" id="btnExport" name="btnExport"
						class="button_4" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)"
						onblur="buttonout(this)"
						value="<s:text name="button_exportexcel"/>"
						onClick="doExport('/setcard/setcard_exportExcel.do')">
										
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
                    <s:text name="wayid"/>                 
                </td>
                <td>
					<j:orderByImg href="javascript:doOrderby('actvday')"><s:text name="actvday"/></j:orderByImg> 
				</td>
				<td>
                    <s:text name="mobile"/>                 
                </td>
                <td>
					<j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg> 
				</td>
                <td>
					<j:orderByImg href="javascript:doOrderby('waytype')"><s:text name="waytype"/></j:orderByImg> 
				</td>
				<td>
                    <j:orderByImg href="javascript:doOrderby('intime')"><s:text name="intime"/></j:orderByImg>                 
                </td>
                 <td>
                   <s:text name="filename"/>               
                </td>
                <td>
                    <s:text name="comname"/>                
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                      <input type="checkbox" name="param._selectitem" value="<s:property value="seq"/>" onclick="checkOne();">
                     </td>
                     <td>
                       <a href='<s:url action="setcard_edit.do">
                          <s:param name="param._pk" value="seq"/>
					      </s:url>'><s:property value="wayid" /></a>
					 </td>
                     <td><s:property value="actvday"/></td>
					 <td><s:property value="mobile"/></td>
					 <td><j:code2Name definition="CITYNAME" code="cityid"/> </td>
					 <td>
					 	<s:if test="waytype==1">自有渠道</s:if>
						<s:if test="waytype==2">社会渠道</s:if>
					</td>
					 <td><s:date name="intime" format="yyyy-MM-dd HH:mm:ss "/></td>
					 <td><s:property value="filename"/></td>
					 <td><s:property value="comname"/></td>
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
