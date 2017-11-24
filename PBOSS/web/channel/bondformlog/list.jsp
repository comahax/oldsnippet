<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
     <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
     <script type="text/javascript">
        function doExcel(){
        	formList.action="<%=contextPath%>/channel/bondformlog_exportexcel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/channel/bondformlog_list.do";
        }
     
     </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="bondformlog_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="opntime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_opntime" onclick="selectDatetime();" readonly="true" />
                </td>
                <td align="center"><s:text name="opntime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_opntime" onclick="selectDatetime();" readonly="true" />
                </td>
             
            </tr>
            <tr>    
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left"> 
                     <s:textfield cssStyle="style_input" name="param._se_wayid" /> 
					<input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                <td align="center"><s:text name="bondtype"/>:</td>
                <td align="left"> 
                      <j:selector  name="param._se_bondtype" definition="$CH_BONDTYPE" />
                </td>
            </tr>
            <tr>    
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                    <j:selector definition="#CNTYCOMPANY" mode="picker" name="param._se_countyid" condition="citycompid:${dBAccessUser.cityid}" readonly="true"/>
                </td>
                <td align="center"><s:text name="receiptno"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_receiptno" />
                </td>
             </tr>
             <tr>   
                <td align="center"><s:text name="bailtype"/>:</td>
                <td align="left">  
                    <j:selector  name="param._ne_bailtype" definition="$CH_NEWBAILTYPE" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/bondformlog_list.do');">  
                        
                    <input type="button" id="btnExport" name="btnExport"class="button_4" onmouseover="buttonover(this);"
					   onmouseout="buttonout(this);" onfocus="buttonover(this)"onblur="buttonout(this)"
					   value="<s:text name="button_exportexcel"/>"onClick="doExcel();">
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
                    <j:orderByImg href="javascript:doOrderby('opntime')"><s:text name="opntime"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('wayname')"><s:text name="wayname"/></j:orderByImg>                 
                </td>
                 <td>
                     <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>   
                <td>
                    <j:orderByImg href="javascript:doOrderby('bailtype')"><s:text name="bailtype"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('bondtype')"><s:text name="bondtype"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('payamt')"><s:text name="payamt"/></j:orderByImg>                 
                </td> 
                 <td>
                    <j:orderByImg href="javascript:doOrderby('receiptno')"><s:text name="receiptno"/></j:orderByImg>                 
                </td> 
                
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%> 
					  <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seqid"/>" onclick="checkOne();">
                     </td>
                     <td><s:date name="opntime" format="yyyy-MM-dd hh:mm:ss"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><s:property value="wayid"/></td>
                     <td><s:property value="wayname"/></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel"/></td>  
                     <td><j:code2Name definition="$CH_NEWBAILTYPE" code="bailtype"/></td>
                     <td><j:code2Name definition="$CH_BONDTYPE" code="bondtype"/></td> 
                     <s:if test="bondtype=='BACKFORM'">       
                     <td style="mso-number-format:'\@';"><s:property value="receiptamt"/></td>
                     </s:if>
                     <s:if test="bondtype=='PAYFORM'">
                     <td style="mso-number-format:'\@';"><s:property value="payamt"/></td>
                     </s:if>
                     <td><s:property value="receiptno"/></td>                                             
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
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._se_bondtype', '<s:text name="bondtype"/>', 'c', true, '16');
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_receiptno', '<s:text name="receiptno"/>', 'c', true, '32');
		addfield('param._ne_bailtype', '<s:text name="bailtype"/>', 'f', true, '2');
		return checkval(window);
	}
</script>
