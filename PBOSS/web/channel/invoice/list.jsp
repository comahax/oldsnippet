<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
     <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
     <script type="text/javascript">
        function doExcel(){
        	formList.action="<%=contextPath%>/channel/invoice_exportexcel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/channel/invoice_list.do";
        }
     
     </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="invoice_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" /> 
					<input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid');this.value='...';" />
                </td>
                <td align="center">分公司:</td>
              <td align="left">
                  <j:selector definition="#CNTYCOMPANY" mode="picker" name="param._se_countyid" condition="citycompid:${dBAccessUser.cityid}" readonly="true"/>
                </td>
            </tr>    
            <tr>    
                <td align="center"><s:text name="applytime"/>>=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_applytime" onclick="selectDate();" readonly="true" />
                </td> 
                <td align="center"><s:text name="applytime"/><=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_applytime" onclick="selectDate();" readonly="true" />
                </td>
               
            </tr>    
            <tr>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                     <j:selector  name="param._ne_state" definition="$CH_SENDTYPE" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/invoice_list.do');">
                        
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
                    <j:orderByImg href="javascript:doOrderby('seqid')"><s:text name="seqid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayname')"><s:text name="wayname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('applytime')"><s:text name="applytime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('momney')"><s:text name="momney"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('information')"><s:text name="information"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprtime')"><s:text name="oprtime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="seqid"/>" onclick="checkOne();">
                     </td>
                     <td>
                     <j:purChk permid="CH_PW_INVOICE_QUERY">
                     <a href='<s:url action="invoice_edit.do">
	                         <s:param name="param._pk" value="seqid"/>
	                     	</s:url>'>
							<s:property value="seqid"/>
                     </a>
                     </j:purChk>
					 </td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="wayname" /></td>
                     <td><s:date name="applytime" format="yyyy-MM-dd"/></td>
                     <td>￥<s:property value="momney" /></td>
                     <td><s:property value="information" /></td>
                     <td><s:property value="oprcode" /></td>
                     <td><j:code2Name definition="$CH_SENDTYPE" code="state"></j:code2Name></td>
                     <td><s:date name="oprtime" format="yyyy-MM-dd"/></td>
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
		addfield('param._dnm_applytime', '<s:text name="applytime"/>', 't', true, '7');
		addfield('param._dnl_applytime', '<s:text name="applytime"/>', 't', true, '7');
		addfield('param._ne_state', '<s:text name="state"/>', 'f', true, '2');
		return checkval(window);
	}
</script>
