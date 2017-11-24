<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
<base target="_self">
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._snl_comresid', '<s:text name="comresid"/>', 'c', true, 32);
            addfield('param._snm_comresid', '<s:text name="comresid"/>', 'c', true, 32);
            addfield('param._ne_comid', '<s:text name="comid"/>', 'f', true, 18);
			addfield('param._se_batchno', '<s:text name="batchno"/>', 'c', true, 30);
			addfield('param._ne_comstate', '<s:text name="comstate"/>', 'f', true, 3);
			addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, 18);
			addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, 16);
			addfield('param._se_numbertype', '<s:text name="numbertype"/>', 'c', true, 10);
			addfield('param._se_resuse', '<s:text name="resuse"/>', 'c', true, 20);
            return checkval(window);
        }
         function doExcel(){
        	formList.action="<%=contextPath%>/resource/comressmp_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/comressmp_list.do";
        }
         function exportTxt(actionUrl)
        {
        	var selectitem= document.getElementById('param._selectitem').value;
        	formList.action = actionUrl+"?param._selectitem="+selectitem;
        	formList.submit();
        	formList.action="<%=contextPath%>/resource/resdisform_productDetail.do";
       		//window.open(actionUrl+"?param._selectitem="+selectitem);      	
        }
        
        function goBack(){
        var actionUrl = document.getElementById('actionUrl').value;
        window.location.href=contextPath+actionUrl;
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="resdisform_productDetail.do" key="formList" cssStyle="formList" theme="simple" >
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="param._selectitem"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
    </aa:zone>
    <s:hidden id="actionUrl" name="actionUrl"/>
    
    <s:hidden name="param._se_disid"/>
    <s:hidden name="param._dnl_distime"/>
    <s:hidden name="param._dnm_distime"/>
    <s:hidden name="param._se_discomcode"/>
    <s:hidden name="param._se_storarea"/>
    <s:hidden name="param._se_disformstate"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">

			<span class="table_toparea_h">资源明细</span>
			<span class="button_Help" onclick="exportTxt('/resource/resdisform_exportTxt.do')">导出TXT</span>
			<span class="button_Help" onclick="goBack()">返回</span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	
    
    
	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               <td> 序号</td><td>商品种类</td><td>商品批次</td><td>包号</td><td>号码</td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                    
                     <td><s:property value="#state.count"/></td>
                     <td><j:code2Name code="comcategory" definition="$IM_FXCOMCATEGORY"/></td>
                     <td><s:property value="batchno"/></td>
                     <td><s:property value="boxnum"/></td>
                     <td><s:property value="comresid"/></td>
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
	//ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
	function doExportexcel(url){
	}
	function doExporttxt(url){
	}
</script> 
</body>
</html>
