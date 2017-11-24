<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
      <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
      <script type="text/javascript">
            function doExcel(){
        	formList.action="<%=contextPath%>/sales/orderlog_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/orderlog_list.do";
        }

        function doTxt()
        {
        	formList.action="<%=contextPath%>/sales/orderlog_txt.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/orderlog_list.do";
        }
      
      
      </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderlog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
              
                  <td align="center"><s:text name="oprcode"/>:</td>
                <td align="left">
                      <j:purChk permid="FX_ORDERMG_ORDERLOG"> 
                        <j:selector definition="#OPERATOR" name="param._se_oprcode" condition='region:${dBAccessUser.hwcityid };status:1'/>
                         </j:purChk>
                </td>
                
                <td align="center"><s:text name="optime"/>&gt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_optime" onclick="selectDate();" readonly="true"/>
                </td>
                <td align="center"><s:text name="optime"/>&lt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_optime" onclick="selectDate();" readonly="true"/>
                </td>
            </tr>
            <tr>
             <td align="center"><s:text name="oprtype"/>:</td>
                <td align="left">
                     <j:selector definition="$OPRTYPE" name="param._se_oprtype" />
                </td>
             <td align="center"><s:text name="orderid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_orderid" />
                </td>
                <td align="center"><s:text name="orderstate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_ORDERFSTATE" name="param._se_orderstate"  />
                </td>
            </tr>
            <tr>
             <td align="center"><s:text name="countyid"/></td>
              <td align="left"> 
                <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector" onchange="putCountyID(this.value);"/>
             </td>
              <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                	  <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid',null,null,'AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="discomcode"/>:</td>
                <td align="left">
                	<j:selector definition="#WAYIDINFO" condition="cityid:${USER.cityid};waytype:AG;waysubtype:LOGS" name="param._se_discomcode" />
                    
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/orderlog_list.do');"> 
                        
                        <input type="button" id="btnExporttxt" name="btnExporttxt"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exporttxt"/>"
										onClick="doTxt('/sales/orderlog_txt.do');">
                        
                        	
                	<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel('/sales/orderlog_excel.do');">
                        
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
                    <j:orderByImg href="javascript:doOrderby('orderid')"><s:text name="orderid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('flowid')"><s:text name="flowid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td> 
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderave')"><s:text name="orderave"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('storarea')"><s:text name="storarea"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderstate')"><s:text name="orderstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('statechgtime')"><s:text name="statechgtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paytype')"><s:text name="paytype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('delitype')"><s:text name="delitype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recamt')"><s:text name="recamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actamt')"><s:text name="actamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('posstream')"><s:text name="posstream"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bossworkfid')"><s:text name="bossworkfid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('memo')"><s:text name="memo"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('discomcode')"><s:text name="discomcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paytime')"><s:text name="paytime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('deductstate')"><s:text name="deductstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signstate')"><s:text name="signstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('alarmlevel')"><s:text name="alarmlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('confirmflag')"><s:text name="confirmflag"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signtime')"><s:text name="signtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recordtime')"><s:text name="recordtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('disovertime')"><s:text name="disovertime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signtype')"><s:text name="signtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smssignno')"><s:text name="smssignno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('reviewstate')"><s:text name="reviewstate"/></j:orderByImg>                 
                </td>
            </tr>
                <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%> 
                     <td><s:property value="logid"/></td>
                     <td><s:date name="optime" format="yyyy-MM-dd HH:mm:ss" /></td>
                     <td><s:property value="oprcode" /></td>
                     <td><j:code2Name definition="$OPRTYPE" code="oprtype"/></td>
                     <td><j:code2Name definition="SUCCESS" code="success"/></td>
                     <td><s:property value="orderid" /></td>
                     <td><s:property value="flowid" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td> 
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel" /></td>
                     <td><j:code2Name definition="$FX_ORDERAVE" code="orderave" /></td>
                     <td><j:code2Name definition="$IM_FXSTORAREA" code="storarea" /></td>
                     <td><s:date name="createtime" format="yyyy-MM-dd HH:mm:ss" /></td>
                     <td><j:code2Name definition="$FX_ORDERFSTATE" code="orderstate" /></td>
                     <td><s:date name="statechgtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="$FX_PAYTYPE" code="paytype" /></td>
                     <td><j:code2Name  definition="$FX_DELITYPE" code="delitype" /></td>
                     <td><s:property value="recamt" /></td>
                     <td><s:property value="actamt" /></td>
                     <td><s:property value="posstream" /></td>
                     <td><s:property value="bossworkfid" /></td>
                     <td><s:property value="memo" /></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="discomcode"/></td>
                     <td><s:date name="paytime" format="yyyy-MM-dd HH:mm:ss" /></td>
                      <td><j:code2Name definition="$FX_DEDUCTSTATE" code="deductstate"/></td>
                     <td><j:code2Name definition="$FX_SIGNSTATE" code="signstate"/></td>
                     <td><j:code2Name definition="$FX_STOCKALARMLEVEL" code="alarmlevel"/></td>
                      <td><j:code2Name definition="$IM_YESNO10" code="confirmflag"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><s:date name="signtime" format="yyyy-MM-dd HH:mm:ss" /></td>
                     <td><s:date name="recordtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:date name="disovertime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="$FX_SIGNTYPE" code="signtype"/></td>
                     <td><s:property value="smssignno" /></td>
                     <td><j:code2Name definition="$FX_REVIEWSTATE" code="reviewstate"/></td>
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
		addfield('param._dnm_optime', '<s:text name="optime"/>', 't', true, '7');
		addfield('param._dnl_optime', '<s:text name="optime"/>', 't', true, '7');
		addfield('param._se_oprcode', '<s:text name="oprcode"/>', 'c', true, '16');
		addfield('param._se_oprtype', '<s:text name="oprtype"/>', 'c', true, '8');
		addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_orderstate', '<s:text name="orderstate"/>', 'c', true, '16');
		addfield('param._se_discomcode', '<s:text name="discomcode"/>', 'c', true, '18');
		return checkval(window);
	}
</script>
