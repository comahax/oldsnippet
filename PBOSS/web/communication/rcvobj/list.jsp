<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_rvcobjid', '<s:text name="rvcobjid"/>', 'f', true, '14');
            addfield('param._ne_advinfoid', '<s:text name="advinfoid"/>', 'f', true, '14');
            addfield('param._se_objid', '<s:text name="objid"/>', 'c', true, '18');
            addfield('param._ne_state', '<s:text name="state"/>', 'f', true, '3');
            addfield('param._dnm_checktime', '<s:text name="checktime"/>', 't', true, '7');
            addfield('param._de_checktime', '<s:text name="checktime"/>', 't', true, '7');
            addfield('param._dnl_checktime', '<s:text name="checktime"/>', 't', true, '7');
            addfield('param._dnm_statetime', '<s:text name="statetime"/>', 't', true, '7');
            addfield('param._de_statetime', '<s:text name="statetime"/>', 't', true, '7');
            addfield('param._dnl_statetime', '<s:text name="statetime"/>', 't', true, '7');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="rcvobj_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
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
			<span class="table_toparea"><s:text name="communication"/> </span>
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
                <td align="center" width="20%"><s:text name="advinfoid"/>:</td>
                <td align="left" width="30%">
                    <s:textfield cssStyle="style_input" name="param._ne_advinfoid" />
                </td>
                <td align="center" width="20%"><s:text name="title"/>:</td>
                <td align="left" width="30%">
                    <s:textfield cssStyle="style_input" name="param.title" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="objid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_objid" />
                </td>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                	<j:selector definition="$CH_ADVRVCTYPE" name="param._ne_state"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/communication/rcvobj_list.do');">
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
                    <j:orderByImg href="javascript:doOrderby('rvcobjid')"><s:text name="rvcobjid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('advinfoid')"><s:text name="advinfoid"/></j:orderByImg>                 
                </td>
                <td>
                    <s:text name="title"/>             
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('objid')"><s:text name="objid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('checktime')"><s:text name="checktime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('statetime')"><s:text name="statetime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="rvcobjid"/>" onclick="checkOne();">
                     </td>
                     <td><s:property value="rvcobjid"/></td>
                     <td><s:property value="advinfoid" /></td>
                     <td>
                     	<span STYLE="overflow:hidden; text-overflow:ellipsis; white-space:nowrap;width:200px" title="<s:property value="title"/>"/>
                     		<s:property value="title" />
                     	</span>
                     </td>
                     <td><s:property value="objid" /></td>
                     <td>
                     	<j:code2Name definition="$CH_ADVRVCTYPE" code="state" />
                     </td>
                     <td>
	                     <s:i18n name="public">
	                		<s:property value="checktime!=null?getText('format.datetime',{checktime}):''"/>
						 </s:i18n>
                     </td>
                     <td>
                     	<s:i18n name="public">
	                		<s:property value="statetime!=null?getText('format.datetime',{statetime}):''"/>
						</s:i18n>
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
