<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
		
		function doExport(){
			formList.action="<%=contextPath%>/sales/hisactivetol_exportExcel.do";
    		formList.submit();
    		formList.action="<%=contextPath%>/sales/hisactivetol_list.do";
		}
		</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="hisactivetol_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">订购量查询 </span>
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
                    <j:selector name="param._se_wayid" definition="#WAYIDINFO"
									condition="waytype:AG;cityid:${USER.cityid}" />
                </td>
                
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="def" cssStyle="style_input"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/hisactivetol_list.do');">
                	
                	<input type="button" class="button_4" onmouseover="buttonover(this);"
			            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			            value="导出EXCEL" onClick="doExport();"/>
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
                    序号
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('wayname')"><s:text name="wayname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('brand')"><s:text name="brand"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hisactive01')"><s:text name="hisactive01"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hisactive03')"><s:text name="hisactive03"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hisactive06')"><s:text name="hisactive06"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('memo')"><s:text name="memo"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas" status="status">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
						<s:property value="#status.count" />
					 </td>
					 <td>
                         <s:property value="wayid" />
					 </td>
                     <td>
                         <j:code2Name definition="#WAYIDINFO" code="wayid" />
					 </td>
                     <td>
                     	<j:code2Name definition="$FX_SMPBRAND" code="brand"/>
					 </td>
                     <td>
	                    <s:if test = "hisactive01 != 0">
		                    <s:if test = "hisactive01 != null">
		                    	 <a href = "javascript:window.showModalDialog('/sales/hisactivetol_showDetail.do?wayid=<s:property value="wayid"/>&&brand=<s:property value="brand"/>&&month=1', self, 'dialogWidth:800px; dialogHeight:400px; status:no; resizable:no;');"><s:property value="hisactive01" /></a> 
							<!--<a href = "javascript:formList.action='/sales/hisactivetol_showDetail.do?wayid=<s:property value="wayid"/>&&brand=<s:property value="brand"/>&&month=1';formList.submit();"><s:property value="hisactive01" /></a>-->
							
							</s:if>
							<s:else>
								0
							</s:else>
						</s:if>
						<s:else>
							<s:property value="hisactive01" />
						</s:else>
                     </td>
                     <td>
 						<s:if test = "hisactive03 != 0">
	 						<s:if test = "hisactive03 != null">
		                    	<a href = "javascript:window.showModalDialog('/sales/hisactivetol_showDetail.do?wayid=<s:property value="wayid"/>&&brand=<s:property value="brand"/>&&month=3', self, 'dialogWidth:800px; dialogHeight:400px; status:no; resizable:no;');"><s:property value="hisactive03" /></a>
							</s:if>
							<s:else>
								0
							</s:else>
						</s:if>
						<s:else>
							<s:property value="hisactive03" />
						</s:else>
					</td>
                     <td>
                     <s:if test = "hisactive06 != 0">
	                     	<s:if test = "hisactive06 != null">
		                    	<a href = "javascript:window.showModalDialog('/sales/hisactivetol_showDetail.do?wayid=<s:property value="wayid"/>&&brand=<s:property value="brand"/>&&month=6', self, 'dialogWidth:800px; dialogHeight:400px; status:no; resizable:no;');"><s:property value="hisactive06" /></a>
							</s:if>
							<s:else>
								0
							</s:else>
						</s:if>
						<s:else>
							<s:property value="hisactive06" />
						</s:else>
                     </td>
                     <td><s:property value="memo" /></td>
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
		addfield('param._sn_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snn_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sl_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snm_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snl_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sm_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sne_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sin_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snin_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sk_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._snk_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._sn_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._snn_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._sl_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._snm_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._snl_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._sm_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._sne_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._sin_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._snin_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._sk_brand', '<s:text name="brand"/>', 'c', true, '16');
		addfield('param._snk_brand', '<s:text name="brand"/>', 'c', true, '16');
		return checkval(window);
	}
</script>
