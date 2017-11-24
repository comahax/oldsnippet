<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._nk_logid', '<s:text name="logid"/>', 'l', true, '14');
		addfield('param._dnm_optime', '<s:text name="optime"/>', 'dt', true, '7');
		addfield('param._dnl_optime', '<s:text name="optime"/>', 'dt', true, '7');
		addfield('param._sk_oprcode', '<s:text name="oprcode"/>', 'c', true, '15');
		addfield('param._sk_oprtype', '<s:text name="oprtype"/>', 'c', true, '8');
		addfield('param._sk_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._ne_changetype', '<s:text name="changetype"/>', 'f', true, '3');
		return checkval(window);
	}
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="changelog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="channelloghelpTitle"/>','<s:text name="channelloghelpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                    <s:textfield cssStyle="style_input" name="param._sk_oprcode" />
                </td>
                
                
                </tr>
                 <tr>
                <td align="center"><s:text name="_dnl_optime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_optime"  onclick="selectDatetime()" readonly="true"/>
                </td>
               
                <td align="center"><s:text name="_dnm_optime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_optime"  onclick="selectDatetime()" readonly="true"/>
                </td>
                 </tr>
                  <tr>
                <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                <j:selector name="param._sk_oprtype"
									definition="OPTYPE2" mode="selector" />
              
                  <!--  <s:textfield cssStyle="style_input" name="param._sk_oprtype" /> -->
                </td>
                              <td align="center"><s:text name="changetype"/>:</td>
                <td align="left">
                  <j:selector definition="$CH_CHANGETYPE" theme="simple" name="param._ne_changetype"/>
                  <!--     <s:textfield cssStyle="style_input" name="param._ne_changetype" />-->
                </td>
                 </tr>
                  <tr>

                  <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                
                    <s:textfield cssStyle="style_input" name="param._sk_wayid" />
                    <input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._sk_wayid','','','AG');this.value='...';" />
                </td>
                
                 <td align="left">
                  
                </td>
                <td align="left">
                  
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/changelog_list.do');">
                
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
                </s:i18n>
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
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('changetype')"><s:text name="changetype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oldvalue')"><s:text name="oldvalue"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('nowvalue')"><s:text name="nowvalue"/></j:orderByImg>                 
                </td>
                <s:if test="param75 == 1">
                   <td>
                      <s:text name="备注"/>                 
                   </td> 
                </s:if>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 
                     <td><a href='<s:url action="changelog_edit.do">
	                         <s:param name="param._pk" value="logid"/>
	                     	</s:url>'>
							<s:property value="logid"/>
                         </a>
					 </td>--%>
					 <td>
							<s:property value="logid"/>
                         
					 </td>
                     <td><s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="oprcode" /></td>
                     <td><j:code2Name code="oprtype" definition="OPTYPE2"/></td>
                     <td><s:property value="wayid" /></td>
                     <td><j:code2Name definition="$CH_CHANGETYPE" code="changetype" /></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="oldvalue" /></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="nowvalue" /></td>
                     <s:if test="param75 == 1"> 
                      <td><s:property value="memo" /></td>
                     </s:if>
                      
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
