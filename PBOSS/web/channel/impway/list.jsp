<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" /></title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
		function ev_check() {
            return checkval(window);
        }
		function doImport(){			
			formList.action = "<%=contextPath%>/channel/impway/batchimpway.jsp";
      		formList.submit();
		}
		
		function doExport(url){
			formList.action = contextPath + url;
			formList.submit();
  			formList.action = contextPath + "/channel/impway_list.do";
		}
		
    	function doQuery(cmdQuery){
			trimAllSpaces();
			resetPage();
			if(cmdQuery != null && cmdQuery !="")
			formList.action = contextPath + cmdQuery;
			formList.submit();
		}
		function trimAllSpaces() {
			for(var i=0;i<document.forms[0].elements.length;i++) {
				if(formList.elements[i].type=='text') {
					formList.elements[i].value=trim(formList.elements[i].value);
				}
			}
		}

		function openPicker(control, definition, condition) {
			if(control.name.indexOf('param._se_countyid') > -1 ) {
                if(document.all('param._se_cityid').value == "") {
    	            // 选择“分公司”前要先指定“地市公司” 
    	            alert("请先输入"+'<s:text name="cityid"/>');
    	            return;
                }else {
                    // 查询指定“分公司”下的 “服务销售中心编码”
                	condition = 'citycompid:'+ document.all('param._se_cityid').value;
                }
            }
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
		</script>
	</head>

	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="impway_list.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<s:hidden name="flag"/>
				<aa:zone name="hiddenZone">
					<s:hidden name="param._orderby" />
					<s:hidden name="param._desc" />
					<s:hidden name="param._pageno" />
					<s:hidden name="param._pagesize" />
					<s:hidden name="param.queryAll" />
					<input type="hidden" name="_rowcount"
						value="<s:property value="dp.rowCount" />" />
				</aa:zone>

				<!--##################################添加标题内容，里面可以放置按钮##################################################-->
				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="channel" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpList"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n> </span>
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

				<!--#################################添加标题内容，里面可以放置按钮###################################################-->
				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="center">
								<s:text name="wayid" />:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_wayid" />
								<input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._sk_wayid','','','IMP');this.value='...';" />
							</td>
							<td align="center">
								<s:text name="wayname" />:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_wayname" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="upperwayid" />:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._se_upperwayid"
									readonly="true" />
								<input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._se_upperwayid','','','AG|ET','');this.value='...';" />
							</td>
							<td align="center">
								<s:text name="waystate" />:
							</td>
							<td align="left">
								<j:selector definition="$CH_WAYSTATE" name="param._ne_waystate" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="cityid" />:
							</td>
							<td align="left">
								<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_cityid" /><input type="button" value="..." class="picker_button"
									name="buttn3"
									onclick="showOrgTree(this,'_se_cityid','Citycom');">
									 -->
								<j:selector definition="#CITYCOMPANY" name="param._se_cityid"
									mode="selector" condition="citycompid:${dBAccessUser.cityid }"
									value="${dBAccessUser.cityid }" disabled="true"/>
							</td>
							<td align="center">
								<s:text name="countyid" />:
							</td>
							<td align="left">
								<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_countyid" /><input type="button" name="button2" class="picker_button"value="..."
								onclick="showOrgTree(this,'_se_countyid','Cntycom');">
							-->
								<j:selector definition="#CNTYCOMPANY" name="param._se_countyid" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="_se_svccode" />:
							</td>
							<td align="left">
								<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_svccode" /><input type="button" name="button1" class="picker_button"
									value="..." onclick="showOrgTree(this,'_se_svccode','Svc');">
							 -->
								<j:selector definition="#SERVCENT" name="param._se_svccode" />
							</td>
							<td align="center">
								<s:text name="_se_mareacode" />:
							</td>
							<td align="left">
								<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_mareacode" /><input type="button" name="button" class="picker_button"
									value="..." onclick="showOrgTree(this,'_se_mareacode','Ma');">
							-->
								<j:selector definition="#MICROAREA" name="param._se_mareacode" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:i18n name="public">
									<!--按钮的左中右位置分别为 form_table_left、form_table_center、form_table_right-->
									<input type="button" id="btnQuery" name="btnQuery"
										class="button_Query" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="查询"
										onClick="doQuery('/channel/impway_list.do');">
									<input type="button" id="btnNew" name="btnNew"
										class="button_New" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_new"/>"
										onClick="doNew('/channel/impway_new.do')">
									<input type="button" id="btnDelete" name="btnDelete"
										class="button_Delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_delete"/>"
										onClick="doDelete('/channel/impway_delete.do')">
									<input type="button" id="btnBatch" name="btnBatch"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="批量导入" onClick="doImport();">
									<input type="button" id="btnExport" name="btnExport"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_exportexcel"/>"
										onClick="doExport('/channel/impway_exportExcel.do')">
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
											<input type="checkbox" name="allbox" onclick="checkAll();" />
										</td>
									</s:i18n>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayid')">
											<s:text name="wayid" />
										</j:orderByImg>
									</td>
									<td>
										<j:orderByImg href="javascript:doOrderby('wayname')">
											<s:text name="wayname" />
										</j:orderByImg>
									</td>
									<td>
										<s:text name="upperwayid" />
									</td>
									<td>
										<s:text name="waysubtype" />
									</td>
									<td>
										<s:text name="cityid" />
									</td>
									<td>
										<s:text name="countyid" />
									</td>
									<td>
										<s:text name="svcname" />
									</td>
									<td>
										<s:text name="mareaname" />
									</td>
									<td>
										<s:text name="starlevel" />
									</td>
									<td>
										<s:text name="runmode" />
									</td>
									<td>
										<s:text name="isconnected" />
									</td>
									<td>
										<s:text name="connecttype" />
									</td>
									<td>
										<s:text name="prtsource" />
									</td>
									<td>
										<s:text name="buztypecode" />
									</td>
									<td>
										<s:text name="adtypecode" />
									</td>
									<td>
										<s:text name="buzphoneno" />
									</td>
									<td>
										<s:text name="adacode" />
									</td>
									<td>
										<s:text name="isshare" />
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<td>
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="wayid"/>" onclick="checkOne();">
										</td>
										<td>
											<a href='<s:url action="impway_edit.do">
					                         <s:param name="param._pk" value="wayid"/>
					                     	</s:url>'><s:property value="wayid" /></a>
										</td>
										<td>
											<s:property value="wayname" />
										</td>
										<td>
											<s:property value="upperwayid" />
										</td>
										<td>
											<j:code2Name definition="WAYSUBTYPE" code="waysubtype" />
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
											<j:code2Name code="starlevel" definition="$CH_STARLEVEL" />
										</td>
										<td>
											<j:code2Name code="runmode" definition="$CH_RUNMODE" />
										</td>
										<td>
											<j:code2Name code="isconnected" definition="$CH_ISCONNECTED" />
										</td>
										<td>
											<j:code2Name code="connecttype" definition="$CH_CONNECTTYPE" />
										</td>
										<td>
											<j:code2Name code="prtsource" definition="$CH_PRTSOURCE" />
										</td>
										<td>
											<j:code2Name code="buztypecode" definition="$CH_BUZTYPE" />
										</td>
										<td>
											<j:code2Name code="adtypecode" definition="$CH_ADTYPE" />
										</td>
										<td>
											<s:property value="buzphoneno" />
										</td>
										<td>
											<j:code2Name code="adacode" definition="#CH_ADIMAREA" />
										</td>
										<td>
											<j:code2Name code="isshare" definition="$CH_DSTISKEYSTEP" />
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
