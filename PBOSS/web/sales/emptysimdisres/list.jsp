<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
		function ev_check() {
            return checkval(window);
        }
		
    	function doQuery(cmdQuery){
			if(cmdQuery != null && cmdQuery !="")
			formList.action = contextPath + cmdQuery;
			formList.submit();
		}
		function opendMareacode(aObj,formWhere){
		     var countyid = document.getElementById('EmptysimdisresAction_list_do_param__se_countyid').value;
		     if(countyid == ''){
			     alert("请先输入分公司");
	                    return;
		     }else{
			     openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
		    }
	    }
		function doExportTxt(cmdQuery){
			var url='<%=contextPath%>/sales/emptysimdisres/select.jsp';
    		var rtn=window.showModalDialog(url , 1 , "dialogWidth=300px;dialogHeight=350px;status:no;scroll=yes;");
    		if(rtn=="")
    		{
    		 alert('至少选择一列');
    		 return false;
    		}
    		if(rtn == null) {
        		return false;
    		}
		
			formList.action = contextPath + cmdQuery + "?selectedFields="+rtn;
			formList.submit();
		}
		</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="EmptysimdisresAction_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
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
			</s:i18n>
			<span class="table_toparea">分销管理</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">空白SIM卡分配结果查询</span>
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
            	 <td align="right"><s:text name="countyid"/>:</td>
                <td align="left">
                <j:purChk permid="FX_ORDERMG_CITY"> 
                   <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector" onchange="putCountyID(this.value);"/>
                </j:purChk>
                </td>
                <td align="right"><s:text name="mareacode"/>:</td>
                <td align="left">
                    <s:textfield styleId="order_list_do_param__se_mareacode_text" name="param._se_mareacode" readonly="true"/>
						<INPUT class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA'); " type="button" value="..." name="param._se_mareacode_button"/> 
                </td>
               <td align="right">
								<s:text name="svccode" />
								:
							</td>
							<td align="left">
								<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_svccode" /><input type="button" name="button1" class="picker_button"
									value="..." onclick="showOrgTree(this,'_se_svccode','Svc');">
							 -->
								<j:selector definition="#SERVCENT" name="param._se_svccode" />
							</td>
            </tr>
            
               <tr>
               <td align="right">
								<s:text name="wayid" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._se_wayid" />
								<input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
							</td>
							<td align="right">
								<s:text name="wayname" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_wayname" />
							</td>
            	<td align="right"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel"/>
                </td>
              
            </tr>
            <tr>
              <td align="right"><s:text name="orderid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_orderid" />
                </td>
                <td align="right"><s:text name="orderstate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_ORDERFSTATE" name="param._se_orderstate"/>
                </td>
             <td align="right"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector definition="$IM_FXCOMCATEGORY" name="param._se_comcategory" mode="picker"/>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/EmptysimdisresAction_list.do');">
                	
                   	<input type="button" id="btnExporttxt" name="btnExporttxt"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exporttxt"/>"
										onClick="doExportTxt('/sales/EmptysimdisresAction_exportTxt.do');">

									<input type="button" id="btnExport" name="btnExport"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_exportexcel"/>"
										onClick="doExportTxt('/sales/EmptysimdisresAction_exportExcel.do')">
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
                    <s:text name="emptyno"/>           
                </td>
                <td>
               	 	<s:text name="countyid"/>
                </td>
                <td>
                	<s:text name="svccode"/>
                </td>
                <td>
                	<s:text name="mareacode"/>
                </td>
                <td>
                	<s:text name="orderid"/>
                </td>
                <td>
                	<s:text name="wayid"/>
                </td>
                <td>
                	<s:text name="wayname"/>
                </td>
                <td>
                	<s:text name="starlevel"/>
                </td>
                <td>
                  	<s:text name="orderstate"/>
                </td>
                 <td>
                  	<s:text name="comcategoryy"/>
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td><s:property value="emptyno"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#SERVCENT" code="svccode"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><s:property value="orderid" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><j:code2Name definition="#WAY" code="wayid"/></td>
                     <td><j:code2Name definition="$CH_STARLEVEL2" code="starlevel"/></td>
                     <td><j:code2Name definition="$FX_ORDERFSTATE" code="orderstate"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
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
		return checkval(window);
	}
</script>
