<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>


<%
	String ID_1 = "CH_PW_SOTYWAY_QUERY";
	String ID_2 = "CH_PW_SOTYWAY_ADD";
	String ID_3 = "CH_PW_SOTYWAY_DELETE";
	String ID_4 = "CH_PW_SOTYWAY_BATCHIMPORT";
	String ID_5 = "CH_PW_SOTYWAY_EXPORT";
	String ID_6 = "CH_PW_SOTYWAY_EDIT";
	String ID_7 = "CH_PW_SOTYWAY_AUDIT";
	String ID_8 = "CH_PW_DISWAY_BATCHIMPORT";
	String ID_10 = "CH_EDITWAYINFO";
%>


<html>
	<head>
		<title><s:text name="distitleList" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<s:text name="wayid"/>', 'c', true, 20);
            addfield('_se_upperwayid', '<s:text name="upperwayid"/>', 'c', true, 20);
            addfield('_sk_wayname', '<s:text name="wayname"/>', 'c', true, 20);
            return checkval(window);
        }
        function ev_check2()
        {
         	var str=addfield('_se_upperwayid', '<s:text name="upperwayid"/>', 'c', false, 20);
         	return checkval(window);	
        }

//     function doNew(cmdNew) {
//     if(document.all("_se_upperwayid").value==""){
//         alert(1);
//   		 ev_check2();
//   		 return false;
//    }
//    var url = addParam(contextPath + cmdNew, 'CMD', 'AGNEW');
//    formList.action = url;
//    formList.submit();
//}
//function doDelete(cmdDelete) {
//    var TO = true;
//    var sis = formList.all("_selectitem");
//    if (forincheck(TO,sis,msgConfirmDelete)){
//    	formList.action = addParam(contextPath + cmdDelete, 'CMD', 'AGDELETE');
//    	formList.submit();
//    	}  
//}


		function doExportTxt(cmd){
 			var actionUrl = formList.action;
			formList.action = contextPath + cmd;
      		formList.submit();
      		formList.action = actionUrl;
		} 
       	function doBatch(cmd){
       		formList.action=contextPath+cmd;
       		formList.submit();
       	}
       	function getCountyid()
    	{
			//alert('333');
    		ajaxAnywhere.submitByURL(contextPath+"/channel/way_getCountyid.do");
    	}
       	function openPicker(control,definition,condition) {
            if(control.name.indexOf('param._se_svccode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
    	            // 选择“服务销售中心编码”前要先指定“分公司” 
    	            alert("请先输入"+'<s:text name="countyid"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = '_se_countyid:'+ document.all('param._se_countyid').value;
                }
            }
            if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_svccode').value == "") {
                	// 选择“微区域编码”前要先指定 “服务销售中心编码”
                    alert("请先输入"+'<s:text name="svccode"/>');
                    return;
                }else {
                    // 查询指定 “服务销售中心编码”下的“微区域编码”
                    condition = '_se_svccode:' + document.all('param._se_svccode').value;
                }
                
            }
    	    if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }

    	    definition = window.encodeURIComponent(definition);	    
    	    var url = contextPath +"/common/picker_list.do?definition=" + definition;	

    	    if(condition!=null) {
    	    	condition = window.encodeURIComponent(condition);
    	    	url = url +"&condition=" + condition;
    	    }
    	    
    	    url = url +"&" + new Date();

    		var rtn = window.showModalDialog(url, control, "dialogWidth:750px; dialogHeight:550px; status:no;resizable:no;");
    		
    		if( rtn == null) 
    			return false;
    			
    		var buttonID = control.name;		
    		if(buttonID == null || buttonID == "") {
    			alert("Must set the name property for this selector control!");
    			return false;
    		} 
    			
    		var selectorID = buttonID.substring(0, buttonID.indexOf("_button"));
    		var selectorTextID = selectorID + "_text";
    		
    		var codeCtrl = document.getElementById( selectorID );
    		var nameCtrl = document.getElementById( selectorTextID ); 
    		 
    		if(codeCtrl!=null) {
    			codeCtrl.value = rtn[0];
    			codeCtrl.focus();
    			}		
    		if(nameCtrl!=null) nameCtrl.value = rtn[1];   		
    	}
    	function doDeleteapply(cmdDelete) {
		    var TO = true;
		    var sis = formList.all("param._selectitem");   
		    if (forincheck(TO,sis,"确认要申请退出这些记录吗？")){    
		    	formList.action = contextPath + cmdDelete;
		    	formList.submit();
		    }  
		}
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
		<s:form action="way_aglist.do" key="formList" cssStyle="formList"
			theme="simple" onsubmit="return ev_check();">
			<input type="hidden" name="_se_waysubtype" value="DIS" />
			
			<%//下面的控件给Action提供数据，用来分页%>
			<s:hidden name="flag"/>
    		<aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
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
						<span class="table_toparea"><s:text name="currentPos" /> </span>
						<span class="table_toparea_xi">></span>
						<span class="table_toparea"><s:text name="channel" /> </span>
						<span class="table_toparea_xi">></span>
					</s:i18n>
					<span class="table_toparea_h"><s:text name="distitleList" />
					<span class="button_Help" onclick="openword('<s:text name="distitleList"/>','<s:text name="helpList"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
					</span>
				</div>
			</div>

			<aa:zone name="errorZone">
				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>
			</aa:zone>

			<div class="table_div">
				<table class="table_normal">
					<tr>
						<td align="center">
							<s:text name="WAYID" />
							:
						</td>
						<td align="left">
							<s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._se_wayid','','','');this.value='...';" />
						</td>
						<td align="center">
							<s:text name="WAYNAME" />
							:
						</td>
						<td align="left">
							<s:textfield cssStyle="style_input" name="param._sk_wayname" />
						</td>
					</tr>
					<tr>
						<td align="center">
							<s:text name="upperwayid" />
							:
						</td>
						<td align="left">
							<s:textfield cssStyle="style_input" name="param._se_upperwayid" /><input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._se_upperwayid','','','');this.value='...';" />
						</td>
						<td align="center">
							<s:text name="cooperator1" />
							:
						</td>
						<td align="left">
							<j:selector name="param._ne_cooperator" definition="$CH_COOPERATOR" />
						</td>
					</tr>

					<tr>
						
						<td align="center">
							<s:text name="cityid" />
							:
						</td>
						<td align="left">
							<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_cityid" /><input type="button" value="..." class="picker_button"
									name="buttn3"
									onclick="showOrgTree(this,'_se_cityid','Citycom');">
									 -->
								<j:selector definition="#CITYCOMPANY" mode="selector" name="param._se_cityid" condition="citycompid:${dBAccessUser.cityid }" value="%{dBAccessUser.cityid}"  disabled="true"/>
						</td>
						<td align="center">
							<s:text name="subcomp" />
							:
						</td>
						
						<td align="left">
							<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_countyid" /><input type="button" name="button2" class="picker_button"value="..."
								onclick="showOrgTree(this,'_se_countyid','Cntycom');">
							-->
							<j:selector definition="#CNTYCOMPANY" name="param._se_countyid" condition="citycompid:${dBAccessUser.cityid }" readonly="true"/>
						</td>
						
					</tr>

					<tr>
						<td align="center">
							<s:text name="svcname" />
							:
						</td>
						<td align="left">
								<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_svccode" /><input type="button" name="button1" class="picker_button"
									value="..." onclick="showOrgTree(this,'_se_svccode','Svc');">
							 -->
								<j:selector definition="#SERVCENT" name="param._se_svccode" readonly="true"/>
						</td>
						<td align="center">
							<s:text name="mareaname" />
							:
						</td>
						<td align="left">
							<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_mareacode" /><input type="button" name="button" class="picker_button"
									value="..." onclick="showOrgTree(this,'_se_mareacode','Ma');">
							-->
								<j:selector definition="#MICROAREA" name="param._se_mareacode" readonly="true"/>
						</td>
					</tr>
					<tr>
						<td align="center">
							<s:text name="mainlayer" />
							:
						</td>
						<td align="left">
							<j:selector name="param._ne_mainlayer" definition="$CH_COPLAYER" />
						</td>
						<td>
							&nbsp;
						</td>
						<td>
							&nbsp;
						</td>
					</tr>

				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align=right>
										<s:i18n name="public">
											<input type="button" id="btnQuery" name="btnQuery"
												class="button_Query" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												value="<s:text name="button_search"/>"
												onClick="doQuery('/channel/way_aglist.do');">

											<j:purChk permid="<%=ID_10%>" disableChild="true">
											<input type="button" id="btnNew" name="btnNew"
												class="button_New" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)" value="<s:text name="button_new"/>"
												onClick="doNew('/channel/way_agnew.do')">
											<s:if test="flag == 'yes'">	
												<j:purChk permid="<%=ID_8%>" disableChild="true">
												<input type="button" id="btnBatch" name="btnBatch"
													class="button_2" onmouseover="buttonover(this);"
													onmouseout="buttonout(this);" onfocus="buttonover(this)"
													onblur="buttonout(this)" value="导入" onClick="doBatch('/channel/disway/import.jsp');">
												</j:purChk>
											</s:if>
											<s:else>
												<input type="button" id="btnBatch" name="btnBatch"
													class="button_2" onmouseover="buttonover(this);"
													onmouseout="buttonout(this);" onfocus="buttonover(this)"
													onblur="buttonout(this)" value="导入" onClick="doBatch('/channel/disway/import.jsp');">
											</s:else>
											<input type="button" id="btnExporttxt" name="btnExporttxt"
												class="button_4" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												value="<s:text name="button_exporttxt"/>" onClick="doExportTxt('/channel/way_diswayExportTxt.do?WAYSUBTYPE=DIS');">

											<s:if test="flag == 'yes'">
												<input type="button" id="btnDelete" name="btnDelete"
												class="button_4" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												value="申请退出"
												onClick="doDeleteapply('/channel/way_agdeleteapply.do')">
											</s:if>
											<s:else>
												<input type="button" id="btnDelete" name="btnDelete"
												class="button_Delete" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												value="<s:text name="button_delete"/>"
												onClick="doDelete('/channel/way_agdelete.do')">
											</s:else>
											</j:purChk>
									</s:i18n>
									</td>
								</tr>
							</table>
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
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="column_operate" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</s:i18n>
									<td title="<s:text name="list_title_select"/>">
										<input type="checkbox" name="allbox" onclick="checkAll();"
											class="table_checkbox">
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayid')">
											<s:text name="WAYID" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayname')">
											<s:text name="WAYNAME" />
										</j:orderByImg>
									</td>
									<td>
										<s:text name="upperwayid" />
									</td>
									<td>
										<s:text name="cooperator1" />
									</td>
									<td>
										<s:text name="cityid" />
									</td>
									<td>
										<s:text name="subcomp" />
									</td>
									<td>
										<s:text name="svccode" />
									</td>
									<td>
										<s:text name="mareacode" />
									</td>
									<td>
										<s:text name="taxtype" />
									</td>
									<td>
										<s:text name="mainlayer" />
									</td>
									<td>
										<s:text name="adacode" />
									</td>
									<td>
										<s:text name="waystate" />
									</td>
							</tr>
							<s:iterator value="dp.datas">
								<tr class="table_style_content" align="center"
									onMouseMove="this.bgColor='F0F5F9'"
									onMouseOut="this.bgColor='#ffffff'">
									<td>
											<a href='<s:url action="way_ListByLink.do">
	                         					<s:param name="param._se_chainhead" value="wayid"/>
	                     						</s:url>'>
											<s:text name="salelist"/></a>
										</td>
									<td>
										<input type="checkbox" name="param._selectitem"
											value="<s:property value="wayid"/>" onclick="checkOne();">
									</td>
									<td>
									<j:purChk permid="<%=ID_10%>" disableChild="true">
										<a href='<s:url action="way_agedit.do">
	                         			<s:param name="param._pk" value="wayid"/>
	                     				</s:url>'>
										<s:property value="wayid"/>
                         				</a>
                         			</j:purChk>
					 				</td>
									<td>
										<s:property value="wayname" />
									</td>
									<td>
										<s:property value="upperwayid" />
									</td>
									<td>
										<j:code2Name code="cooperator" definition="$CH_COOPERATOR" />
									</td>
									<td>
										<j:code2Name code="cityid" definition="#CITYCOMPANY" />
									</td>
									<td>
										<j:code2Name code="countyid" definition="#CNTYCOMPANY" />
									</td>
									<td>
										<j:code2Name code="svccode" definition="#SERVCENT" />
									</td>
									<td>
										<j:code2Name code="mareacode" definition="#MICROAREA" />
									</td>
									<td>
										<j:code2Name code="taxtype" definition="$CH_STTAXTYPE" />
									</td>
									<td>
										<j:code2Name code="mainlayer" definition="$CH_COPLAYER" />
									</td>
									<td>
										<j:code2Name code="adacode" definition="#ADIMAREA" />
									</td>
									<td>
										<j:code2Name code="waystate"
												definition="$CH_WAYSTATE" />
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
		
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
</body>
</html>
