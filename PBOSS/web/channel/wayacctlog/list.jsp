<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
<div class="table_container">
<s:form action="wayacctlog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="logid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_logid" />
                </td>
                <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_oprcode" />
                </td>
             </tr>
             <tr>
                <td align="center"><s:text name="optime"/>>=</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_optime" onclick="selectDatetime()" readonly="true"/>
                </td>
                <td align="center"><s:text name="optime"/><=</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_optime" onclick="selectDatetime()" readonly="true"/>
                </td>
			  </tr>
			  <tr>                
                <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                    <j:selector   name="param._se_oprtype" definition="$OPRTYPE" />
                </td>
                <td align="center"><s:text name="success"/>:</td>
                <td align="left">
                    <j:selector   name="param._se_success" definition="SUCCESS" />
                </td>
            </tr>
            <tr>                
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                  <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                <td align="center">&nbsp;</td>
                <td align="left">
                  &nbsp;
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/wayacctlog_list.do');">
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
                    <j:orderByImg href="javascript:doOrderby('accid')"><s:text name="accid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>渠道名称</td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctno')"><s:text name="acctno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctname')"><s:text name="acctname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bankname')"><s:text name="bankname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('acctfid')"><s:text name="acctfid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('deacctno')"><s:text name="deacctno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('deacctname')"><s:text name="deacctname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('debankname')"><s:text name="debankname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('accttype')"><s:text name="accttype"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                   <td> 
							<s:property value="logid"/>
					 </td>
                     <td>
                     <s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/>
                     </td>
                     <td><s:property value="oprcode" /></td>
                     <td>
                     <j:code2Name code="oprtype" definition="$OPRTYPE"/>
                     </td>
                     <td>
                     <j:code2Name code="success" definition="SUCCESS"/> 
                     </td>
                     <td><s:property value="accid" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><j:code2Name definition="#WAY" code="wayid" /></td>
                     <td><s:property value="acctno" /></td>
                     <td><s:property value="acctname" /></td>
                     <td><s:property value="bankname" /></td>
                     <td><s:property value="acctfid" /></td>
                     <td><s:property value="deacctno" /></td>
                     <td><s:property value="deacctname" /></td>
                     <td><s:property value="debankname" /></td>
                     <td>
                     <j:code2Name definition="$CH_ACCOUNTTYPE" code="accttype" />
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
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._ne_logid', '<s:text name="logid"/>', 'f', true, '14');
		addfield('param._de_optime', '<s:text name="optime"/>', 't', true, '7');
		addfield('param._se_oprcode', '<s:text name="oprcode"/>', 'c', true, '15');
		addfield('param._se_success', '<s:text name="success"/>', 'c', true, '8');
		return checkval(window);
	}
	
</script>
