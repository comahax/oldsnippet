<%@ page language="java"  contentType="text/html;charset=GBK"%>

<%@ include file="/inc/listhead.inc" %>

<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._sk_filename', '<s:text name="filename"/>', 'c', true, '256');
            addfield('param._dnm_begintime', '<s:text name="_dnm_begintime"/>', 'dt', true, '7');
            addfield('param._dnl_begintime', '<s:text name="_dnl_begintime"/>', 'dt', true, '7');
           return(checkval(window) && compareDate());
           
        }
        
        function compareDate(){
	        var endTime = document.getElementById('param._dnm_begintime').value;
	        var beginTime = document.getElementById('param._dnl_begintime').value;

	        if(beginTime>endTime){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_begintime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_begintime"/>]</span>';
			errorMessageShow(alertstr);
	        return false;
	       }
        	return true;	
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="resimport_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
   
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
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
                <td align="center"><s:text name="filename"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._sk_filename" />
                </td>
                <td align="center"><s:text name="_dnl_begintime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_begintime" onclick="selectDatetime();" readonly="true"/>
                </td>
                <td align="center"><s:text name="_dnm_begintime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_begintime"   onclick="selectDatetime();" readonly="true"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/resource/resimport_list.do');">
                	<!-- 
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/resource/resimport_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/resource/resimport_delete.do')">
                         -->
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
	 <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
               	<!-- 
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                 -->
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recid')"><s:text name="recid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('filename')"><s:text name="filename"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('begintime')"><s:text name="begintime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('overtime')"><s:text name="overtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('amount')"><s:text name="amount"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('successamt')"><s:text name="successamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('failamt')"><s:text name="failamt"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
					 <%--
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="recid"/>" onclick="checkOne();">
                     </td>
                     --%>
                     <td>
							<s:property value="recid"/>
					 </td>
                     <td><s:property value="filename" /></td>
                     <td><s:date name="begintime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:date name="overtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="amount" /></td>
                     <td><s:property value="successamt" /></td>
                     <td><s:property value="failamt" /></td>
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
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDelete");
</script> 
</body>
</html>
