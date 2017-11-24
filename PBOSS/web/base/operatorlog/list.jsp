<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._dnm_optime', '<s:text name="optime"/>', 't', true, '7');
            addfield('param._dnl_optime', '<s:text name="optime"/>', 't', true, '7');
            addfield('param._se_oprcode', '<s:text name="oprcode"/>', 'c', true, '16');
            addfield('param._se_oprtype', '<s:text name="oprtype"/>', 'c', true, '8');
            addfield('param._se_success', '<s:text name="success"/>', 'c', true, '8');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="operatorlog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="optime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_optime" />
                </td>
                <td align="center"><s:text name="optime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_optime" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprcode" />
                </td>
                <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprtype" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="success"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_success" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/base/operatorlog_list.do');">
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
                <td>
                    <j:orderByImg href="javascript:doOrderby('logid')"><s:text name="logid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('optime')"><s:text name="optime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprtype')"><s:text name="oprtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('success')"><s:text name="success"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('operid')"><s:text name="operid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('region')"><s:text name="region"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('opername')"><s:text name="opername"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('password')"><s:text name="password"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('passchgdate')"><s:text name="passchgdate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('opergroup')"><s:text name="opergroup"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('opertype')"><s:text name="opertype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('operlevel')"><s:text name="operlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ismanager')"><s:text name="ismanager"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('contactphone')"><s:text name="contactphone"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orgid')"><s:text name="orgid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isrestrict')"><s:text name="isrestrict"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starttime')"><s:text name="starttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('endtime')"><s:text name="endtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('enablegprs')"><s:text name="enablegprs"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('gprsstarttime')"><s:text name="gprsstarttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('gprsendtime')"><s:text name="gprsendtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ischkmac')"><s:text name="ischkmac"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mac')"><s:text name="mac"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('notes')"><s:text name="notes"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createdate')"><s:text name="createdate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('status')"><s:text name="status"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('statusdate')"><s:text name="statusdate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('releStaffId')"><s:text name="releStaffId"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('checkMac')"><s:text name="checkMac"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('gprsEndtime')"><s:text name="gprsEndtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('gprsStarttime')"><s:text name="gprsStarttime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('enableGprs')"><s:text name="enableGprs"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('restrictTime')"><s:text name="restrictTime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('startTime')"><s:text name="startTime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('endTime')"><s:text name="endTime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hrStatus')"><s:text name="hrStatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('assessrec')"><s:text name="assessrec"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><s:property value="logid"/></td>
                     <td><s:property value="optime" /></td>
                     <td><s:property value="oprcode" /></td>
                     <td><s:property value="oprtype" /></td>
                     <td><s:property value="success" /></td>
                     <td><s:property value="operid" /></td>
                     <td><s:property value="region" /></td>
                     <td><s:property value="opername" /></td>
                     <td><s:property value="password" /></td>
                     <td><s:property value="passchgdate" /></td>
                     <td><s:property value="opergroup" /></td>
                     <td><s:property value="opertype" /></td>
                     <td><s:property value="operlevel" /></td>
                     <td><s:property value="ismanager" /></td>
                     <td><s:property value="contactphone" /></td>
                     <td><s:property value="orgid" /></td>
                     <td><s:property value="isrestrict" /></td>
                     <td><s:property value="starttime" /></td>
                     <td><s:property value="endtime" /></td>
                     <td><s:property value="enablegprs" /></td>
                     <td><s:property value="gprsstarttime" /></td>
                     <td><s:property value="gprsendtime" /></td>
                     <td><s:property value="ischkmac" /></td>
                     <td><s:property value="mac" /></td>
                     <td><s:property value="notes" /></td>
                     <td><s:property value="createdate" /></td>
                     <td><s:property value="status" /></td>
                     <td><s:property value="statusdate" /></td>
                     <td><s:property value="releStaffId" /></td>
                     <td><s:property value="checkMac" /></td>
                     <td><s:property value="gprsEndtime" /></td>
                     <td><s:property value="gprsStarttime" /></td>
                     <td><s:property value="enableGprs" /></td>
                     <td><s:property value="restrictTime" /></td>
                     <td><s:property value="startTime" /></td>
                     <td><s:property value="endTime" /></td>
                     <td><s:property value="hrStatus" /></td>
                     <td><s:property value="assessrec" /></td>
                     <td><s:property value="starlevel" /></td>
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
