<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._se_restype', '<s:text name="restype"/>', 'c', true, '32');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '20');
            addfield('param._se_comresid', '<s:text name="comresid"/>', 'c', true, '32');
            addfield('param._ne_comid', '<s:text name="comid"/>', 'f', true, '18');
            addfield('param._se_batchno', '<s:text name="batchno"/>', 'c', true, '30');
            addfield('param._dnm_createtime', '<s:text name="createtime"/>', 't', true, '7');
            addfield('param._dnl_createtime', '<s:text name="createtime"/>', 't', true, '7');
            addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
            addfield('param._ne_isactive', '<s:text name="isactive"/>', 'f', true, '3');
            addfield('param._dnm_acttime', '<s:text name="acttime"/>', 't', true, '7');
            addfield('param._dnl_acttime', '<s:text name="acttime"/>', 't', true, '7');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body">
<div class="table_container">
<s:form action="partnerres_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//����Ŀؼ���Action�ṩ���ݣ�������ҳ%>
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
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" />
                </td>
                <td align="center"><s:text name="restype"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_restype" />
                </td>
                <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_comcategory" />
                </td>
                <td align="center"><s:text name="comresid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_comresid" />
                </td>
                <td align="center"><s:text name="comid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_comid" />
                </td>
                <td align="center"><s:text name="batchno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_batchno" />
                </td>
                <td align="center"><s:text name="createtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_createtime" />
                </td>
                <td align="center"><s:text name="createtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_createtime" />
                </td>
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_brand" />
                </td>
                <td align="center"><s:text name="isactive"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_isactive" />
                </td>
                <td align="center"><s:text name="acttime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_acttime" />
                </td>
                <td align="center"><s:text name="acttime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_acttime" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/partnerres_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/partnerres_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/partnerres_delete.do')">
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
                    <a href="javascript:doOrderby('wayid')"><s:text name="wayid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('restype')"><s:text name="restype"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('comcategory')"><s:text name="comcategory"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('comresid')"><s:text name="comresid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('comid')"><s:text name="comid"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><s:text name="batchno"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('createtime')"><s:text name="createtime"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('brand')"><s:text name="brand"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('isactive')"><s:text name="isactive"/></a>                 
                </td>
                <td>
                    <a href="javascript:doOrderby('acttime')"><s:text name="acttime"/></a>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="partnerres_edit.do">
	                         <s:param name="param._pk" value="recid"/>
	                     	</s:url>'>
							<s:property value="recid"/>
                         </a>
					 </td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="restype" /></td>
                     <td><s:property value="comcategory" /></td>
                     <td><s:property value="comresid" /></td>
                     <td><s:property value="comid" /></td>
                     <td><s:property value="batchno" /></td>
                     <td><s:property value="createtime" /></td>
                     <td><s:property value="brand" /></td>
                     <td><s:property value="isactive" /></td>
                     <td><s:property value="acttime" /></td>
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
