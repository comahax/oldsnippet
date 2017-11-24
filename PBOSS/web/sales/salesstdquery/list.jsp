<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
        <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._se_mareacode', '<s:text name="mareacode"/>', 'c', true, '14');
		addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
		addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
		return checkval(window);
	}
	function opendMareacode(aObj,formWhere){
	     var countyid = document.getElementById('countyid').value;
	     if(countyid == ''){
		    
		      alert("请先输入分公司");
                    return;
		    // openPicker(aObj,formWhere);
	     }else{
		     openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
	    }
    }
    
     function doExcel(){
        	formList.action="<%=contextPath%>/sales/salesstd_listQueryexcel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/salesstd_listQuery.do";
        }
        
     function doExport(actionUrl){
        	formList.action="<%=contextPath%>"+actionUrl;
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/salesstd_listQuery.do";
        }

     function putCountyID(countyid){
	     document.getElementById('countyid').value=countyid;
	}
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="salesstd_listQuery.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <s:hidden name="form.countyid"/>
    <input type="hidden" id="countyid"/>
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
			<span class="table_toparea">合作商销量提醒 </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">合作商销量查询</span>
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
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                <j:selector definition="#CNTYCOMPANY" name="param._se_countyid" mode="selector" condition="citycompid:${dBAccessUser.cityid }"   onchange="putCountyID(this.value);" />
                </td>
                <td align="center"><s:text name="mareacode"/>:</td>
                <td align="left">
                <s:textfield name="param._se_mareacode"/><input class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA');"  type="button" value="..." name="param._se_mareacode_button"/>                    
                </td>
              </tr>
              <tr>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                	<j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel" />
                </td>
                <td align="center">合作商:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
            </tr>
            <!-- <tr>
            	<td align="center">合作商:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
                <td></td>
                <td></td>
            </tr> -->
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/salesstd_listQuery.do');">
                	
                   
                        
                      <input type="button" id="btnexport" name="btnExport" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_export"/>EXCEL" onClick="doExport('/sales/salesstd_ExportExcel.do')">
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
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="mareacode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <!-- 网点编码 -->
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <!-- 网点名称 -->
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayname')"><s:text name="wayname"/></j:orderByImg>                 
                </td>
                
               <!--  <td>
                    <j:orderByImg href="javascript:doOrderby('brand')"><s:text name="brand"/></j:orderByImg>                 
                </td> -->
                <td>
                    <j:orderByImg href="javascript:doOrderby('salesstd')"><s:text name="salesstd"/></j:orderByImg>                 
                </td>
                <!--当月销量 -->
                <td>
                    <j:orderByImg href="javascript:doOrderby('salescount')"><s:text name="salescount"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					
                   
                     <td>
                     <j:code2Name code="countyid" definition="#CNTYCOMPANY" />
                     </td>
                     <td>
                     <j:code2Name code="mareacode" definition="#MICROAREA" />
                     </td>
                     <td>                     
                     <j:code2Name code="starlevel" definition="$CH_STARLEVEL" />
                     </td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="wayname" /></td>
                    <!-- <td>
                     <j:code2Name code="brand" definition="$FX_SMPBRAND"/>
                     </td> --> 
                     <td><s:property value="salesstd" /></td>
                     <td><s:property value="salescount" /></td>
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
