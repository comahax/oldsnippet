<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
	<head>
		<title><s:text name="titleUpdate" />
		</title>
		<script language="JavaScript">
    function ev_checkval() {
        addfield('form.wayid', '<s:text name="WAYID"/>', 'c', false , 18);
        addfield('form.wayname', '<s:text name="WAYNAME"/>', 'c', false, 256);
        addfield('form.upperwayid', '<s:text name="upperwayid"/>', 'c', false, 18);      
        
        addfield('form.principal', '<s:text name="principal"/>', 'c', false, 20);
        addfield('form.principaltel', '<s:text name="principaltel"/>', 'c', false, 15);
        addfield('form.linkman', '<s:text name="linkman"/>', 'c', false, 32);
        addfield('form.linkmantel', '<s:text name="linkmantel"/>', 'c', false, 15);
        addfield('form.principalemail', '<s:text name="principalemail"/>', 'm', true, 64);
        addfield('form.linkmanemail', '<s:text name="linkmanemail"/>', 'm', true, 64);
        
        addfield('form.compactno', '<s:text name="compactno"/>', 'c', false, 17);
        addfield('form.compactname', '<s:text name="compactname"/>', 'c', false, 32); 
        addfield('form.cmpendtime', '<s:text name="endtime"/>', 't', false, 25);
        addfield('form.signtime', '<s:text name="signtime"/>', 't', false, 25);
        addfield('form.copbound', '<s:text name="copbound"/>', 'c', true, 40);
        addfield('form.licenceno', '<s:text name="licenceno"/>', 'c', false, 32);
        addfield('form.compactpath', '<s:text name="compactpath"/>', 'c', true, 128);
        addfield('form.licencepath', '<s:text name="licencepath"/>', 'c', true, 128);
        addfield('form.runareatype', '<s:text name="runareatype"/>', 'i', true, 2);
        addfield('form.bankname', '<s:text name="bankname"/>', 'c', false, 128);   
        addfield('form.sendaddr', '<s:text name="sendaddr"/>', 'c', true, 128);
    	addfield('form.recpers', '<s:text name="recpers"/>', 'c',true, 32);
    	addfield('form.recconntel', '<s:text name="recconntel"/>', 'c', true, 15);
    	addfield('form.licvalidate', '<s:text name="licvalidate"/>', 't', false, 20);
    	addfield('form.calcumode', '<s:text name="calcumode"/>', 'i', false, 3);
    	if(document.all("form.calcumode").value=='1')
    	{
    		if(document.all("form.uniformtime").value==''){
				alert('选择[统一模式]必须填写[统一模式开始时间]!');
				return false;    		
    		}
    	}
    	addfield('form.baillwrlmt', '<s:text name="baillwrlmt"/>', 'd', false,16,2);
    	addfield('form.intime', '<s:text name="intime"/>', 't', false, 20);
    	addfield('form.buzphoneno', '<s:text name="buzphoneno"/>', 'c', true, 12);
         //way
        addfield('form.adacode', '<s:text name="adacode"/>', 'c', true, 18);
        addfield('form.address', '<s:text name="address"/>', 'c', true, 128);
        addfield('form.latitude', '<s:text name="latitude"/>', 'd', false, 3,6);
        addfield('form.longtitude', '<s:text name="longtitude"/>', 'd', false, 3,6);
        addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
        addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, 14);
        addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
        
        //contact    
        addfield('form.reccertno', '<s:text name="reccertno"/>', 'c', true, 20);
        addfield('form.company', '<s:text name="company"/>', 'c', true, 60);
        addfield('form.coplevel', '<s:text name="coplevel"/>', 'i', true, 3);
        addfield('form.busnum', '<s:text name="busnum"/>', 'c', true, 30);
        addfield('form.certitype', '<s:text name="certitype"/>', 'i', true, 3);
        addfield('form.certinum', '<s:text name="certinum"/>', 'c', true, 30);
        addfield('form.regadress', '<s:text name="regadress"/>', 'c', true, 128);
        addfield('form.regcapital', '<s:text name="regcapital"/>', 'i', true, 14);
        addfield('form.companytype', '<s:text name="companytype"/>', 'c', true, 64);
        addfield('form.brole', '<s:text name="brole"/>', 'c', true, 64);
        //compact
        addfield('form.regcapital', '<s:text name="reccertno"/>', 'c', true, 20);
        addfield('form.begintime', '<s:text name="begintime"/>', 't', false);
        addfield('form.bail', '<s:text name="bail"/>', 'd', true, 18, 2);
        
        //account
        addfield('form.acctno', '<s:text name="acctno"/>', 'c', false, 50);
        addfield('form.acctname', '<s:text name="acctname"/>', 'c', false, 64);
        addfield('form.acctfid', '<s:text name="acctfid"/>', 'c', true, 21);
        return (checkval(window) && Validation() && compareDate());
    }
    
    
    function Validation(){

        var longtitude = document.getElementById('form.longtitude').value;
        if(longtitude !="" ){
        	if ((longtitude*1<100 ||longtitude.value*1>130 )) {
        		alert("经度值必须在100 － 130 之间!");
        		return false;
        	}
        	if (longtitude.length!=10) {
        		alert("经度值小数位必须为6位!");
        		return false;
        	}
        }
        var latitude = document.getElementById('form.latitude').value;
        if(latitude !="" ){
        	if (latitude*1<18 ||latitude*1>26) {
        		alert("纬度值必须在18 － 26 之间!");
        		return false;
        	}
        	if (latitude.length!=9) {
				alert("纬度值小数位必须为6位!");
        		return false;
            }
        }
           return true;
     }
     
     function compareDate(){
        	var begintime = document.getElementById('form.begintime').value;
        	var cmpendtime = document.getElementById('form.cmpendtime').value;
        	
        	if(begintime != '' && cmpendtime != '' && begintime > cmpendtime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[生效时间]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[停用时间]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
     }
    
     function changeWay(obj){
    	var control = document.getElementById("upperwayid");
    	showSelectWay(obj);
			var cmd = '<%=request.getParameter("CMD")%>';
		if(document.getElementById("upperwayid").value == ""){
		if(cmd == "AGEDIT"){
			formItem.action="<%=contextPath%>/cms/disway.do?CMD=AGEDIT&PK="+document.getElementById("wayid").value;
        	formItem.submit();
    		}else{
    		formItem.action="<%=contextPath%>/cms/disway.do?CMD=AGNEW";
    		formItem.submit();
    		}
    	}else{
				formItem.action="<%=contextPath%>/cms/disway.do?CMD=AGUPWAY";
    			formItem.submit();
    	}
    }   
    function doSave(cmdSave) {
    	    //var ret = ev_checkval();   
    	    var ret = ev_checkval();
    	    if (ret) {
    	        enable();
    	        formItem.action = contextPath + cmdSave;
    	        formItem.submit();
    	    }
    	    return false;
    }
    
    function openPicker(control,definition,condition) {
        if(control.name.indexOf('form.svccode') > -1 ) {
            if(document.all('form.countyid').value == "") {
	            // 选择“服务销售中心编码”前要先指定“分公司” 
	            alert("请先输入"+'<s:text name="countyid"/>');
	            return;
            }else {
                // 查询指定“分公司”下的 “服务销售中心编码”
            	condition = '_se_countyid:'+ document.all('form.countyid').value;
            }
        }
        if(control.name.indexOf('form.mareacode') > -1 ) {
            if(document.all('form.svccode').value == "") {
            	// 选择“微区域编码”前要先指定 “服务销售中心编码”
                alert("请先输入"+'<s:text name="svccode"/>');
                return;
            }else {
                // 查询指定 “服务销售中心编码”下的“微区域编码”
                condition = '_se_svccode:' + document.all('form.svccode').value;
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

    // function doGetList(cmdvalue){
	//	ajaxAnywhere.submitByURL("/cms/distribute/cooperator.do?CMD=GETCOUNTID&cmdvalue="+cmdvalue+"&cmdstates=<c:out value="${requestScope['/cms/way/AGWayForm'].cmdState}"/>"); 
	//}
	
    </script>
	</head>
	<body >
		<div class="table_container">
			<s:form action="way_agsave.do" cssStyle="formList" key="formItem"
				enctype="multipart/form-data" method="post" theme="simple"
				onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="flag"/>
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param._sk_wayid" />
				<s:hidden name="param._sk_wayname" />
				<s:hidden name="param._se_upperwayid" />
				<s:hidden name="param._ne_cooperator" />
				<s:hidden name="param._se_cityid" />
				<s:hidden name="param._se_countyid" />
				<s:hidden name="param._se_svccode" />
				<s:hidden name="param._se_mareacode" />
				<s:hidden name="form.waylevel" />
				<s:hidden name="form.waysubtype" value="DIS" />
				<s:hidden name="form.createtime"
					value="%{getText('format.datetime',{form.createtime})}" />

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
						<span class="table_toparea_h">连锁经营合作商管理</span>
						<span class="button_Help"
							onclick="openword('<s:text name="distitleList"/>','<s:text name="helpContent"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n>
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

				<aa:zone name="contentZone">
					<div class="table_div">
						<table class="table_normal">
							<tr>
								<td align="right" width="25%">
									<s:text name="upperwayid" />
									:&nbsp
								</td>
								<td align="left" width="25%">
										<s:textfield cssStyle="style_input" name="form.upperwayid"
											disabled="true" />
									<font color="red">*</font>
								</td>
								<td align="right" width="25%">
									<s:text name="upperwayname" />
									:&nbsp
								</td>
								<td align="left" width="25%">
										<input type="text" class="form_input_1x" name="upperwayname"
											maxlength="18" disabled="true"
											value='<j:code2Name code="form.upperwayid"  definition="#WAY"/>'>
									<j:code2Name code="svccode" definition="#SERVCENT" />
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="WAYID" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD == WEB_CMD_NEW">
										<s:textfield cssStyle="style_input" name="form.wayid"
											maxlength="18" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.wayid"
											disabled="true" maxlength="18" />
									</s:else>
									<font color="red">*</font>
								</td>
								<td align="right" width="25%">
									<s:text name="WAYNAME" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.wayname"
											maxlength="30" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.wayname"
											disabled="true" />
									</s:else>
									<font color="red">*</font>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="cityid" />
									:&nbsp
								</td>
								<td align="left">
									<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_cityid" /><input type="button" value="..." class="picker_button"
									name="buttn3"
									onclick="showOrgTree(this,'_se_cityid','Citycom');">
									 -->

									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector definition="#CITYCOMPANY" name="form.cityid"
											mode="selector"
											condition="citycompid:${dBAccessUser.cityid }"
											disabled="true" readonly="true" />
									</s:if>
									<s:else>
										<j:selector definition="#CITYCOMPANY" name="form.cityid"
											disabled="true" />
									</s:else>
									<font color="red">*</font>
								</td>
								<td align="right" width="25%">
									<s:text name="countyid" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector definition="#CNTYCOMPANY" name="form.countyid"
											condition="citycompid:${dBAccessUser.cityid }"
											readonly="true" />
									</s:if>
									<s:else>
										<j:selector definition="#CNTYCOMPANY" name="form.countyid"
											disabled="true" />
									</s:else>
									<font color="red">*</font>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="svccode" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_svccode" /><input type="button" name="button1" class="picker_button"
									value="..." onclick="showOrgTree(this,'_se_svccode','Svc');">
							 -->
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector definition="#SERVCENT" name="form.svccode"
											readonly="true" />
									</s:if>
									<s:else>
										<j:selector definition="#SERVCENT" name="form.svccode"
											readonly="true" disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="mareacode" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<!-- 可能改为树形式,但尚未有很BOSS移值过来
								<s:textfield cssStyle="style_input" name="param._se_mareacode" /><input type="button" name="button" class="picker_button"
									value="..." onclick="showOrgTree(this,'_se_mareacode','Ma');">
							-->
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector definition="#MICROAREA" name="form.mareacode"
											readonly="true" />
									</s:if>
									<s:else>
										<j:selector definition="#MICROAREA" name="form.mareacode"
											readonly="true" disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="mainlayer" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.mainlayer" definition="$CH_COPLAYER" />
									</s:if>
									<s:else>
										<j:selector name="form.mainlayer" definition="$CH_COPLAYER"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="buzphoneno" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.buzphoneno"
											maxlength="255" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.buzphoneno"
											disabled="true" />
									</s:else>
								</td>

							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="cooperator1" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.cooperator" definition="$CH_COOPERATOR" />
									</s:if>
									<s:else>
										<j:selector name="form.cooperator" definition="$CH_COOPERATOR"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="adacode" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.adacode" mode="picker"
											condition="_se_uppercode:${dBAccessUser.cityid }"
											definition="#CH_ADIMAREA" readonly="true"/>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.adacode"
											condition="_se_uppercode:${dBAccessUser.cityid }"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="latitude" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.latitude"
											maxlength="128" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.latitude"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="longtitude" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.longtitude"
											maxlength="64" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.longtitude"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="waystate" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.waystate" definition="$CH_WAYSTATE" />
									</s:if>
									<s:else>
										<j:selector name="form.waystate" definition="$CH_WAYSTATE"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="signstatus" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.signstatus" definition="$CH_SIGNSTATUS" />
									</s:if>
									<s:else>
										<j:selector name="form.signstatus" definition="$CH_SIGNSTATUS"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="taxtype" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.taxtype" definition="$CH_STTAXTYPE" />
									</s:if>
									<s:else>
										<j:selector name="form.taxtype" definition="$CH_STTAXTYPE"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="chainhead2" />
									:&nbsp;
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.chainhead" definition="#WAY" condition="waytype:AG;waysubtype:DIS;upperwayid:DIS-----;waystate:1" readonly="true"/>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.chainhead"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="address" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.address"
											maxlength="12" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.address"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									 <s:text name="distype" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.distype" definition="$CH_DISTYPE" />
									</s:if>
									<s:else>
										<j:selector name="form.distype" definition="$CH_DISTYPE"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									 <s:text name="starlevel" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.starlevel" definition="$CH_STARLEVEL" />
									</s:if>
									<s:else>
										<j:selector name="form.starlevel" definition="$CH_STARLEVEL"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									&nbsp;
								</td>
								<td align="left" width="25%">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td align="center" colspan="4">
									<font color="blue">经纬度格式例如：纬度23.234534, 经度121.334261，
										单位：度，精确到小数后6位。</font>
								</td>
							</tr>

							<tr>
								<td colspan="4" align="center">
									<font color="blue">合作商沟通信息管理</font>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									负责人 :&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.principal" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.principal"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="principaltel" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.principaltel" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.principaltel"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="linkman" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.linkman" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.linkman"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="linkmantel" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.linkmantel" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.linkmantel"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="principalemail" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.principalemail" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.principalemail"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="linkmanemail" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.linkmanemail" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.linkmanemail"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="recpers" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.recpers" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.recpers"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="reccertno" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.reccertno" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.reccertno"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="recconntel" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.recconntel" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.recconntel"
											disabled="true" />
									</s:else>
								</td>

								<td colspan="2"></td>

							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="sendaddr" />
									:&nbsp
								</td>
								<td align="left" colspan="3">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="width:659px" name="form.sendaddr" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.sendaddr"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="company" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.company" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.company"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="coplevel" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.coplevel" definition="$CH_COPLEVEL" />
									</s:if>
									<s:else>
										<j:selector name="form.coplevel" definition="$CH_COPLEVEL"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="busnum" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.busnum" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.busnum"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="certitype" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.certitype" definition="$IB_CERTITYPE" />
									</s:if>
									<s:else>
										<j:selector name="form.certitype" definition="$IB_CERTITYPE"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="regadress" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.regadress" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.regadress"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="regcapital" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.regcapital" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.regcapital"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="companytype" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.companytype" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.companytype"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="brole" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.brole" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.brole"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="certinum" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.certinum" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.certinum"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">

								</td>
								<td align="left" width="25%">

								</td>
							</tr>


							<tr>
								<td colspan="4" align="center">
									<font color="blue">合作商合同信息管理</font>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="compactname" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.compactname"
											maxlength="40" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.compactname"
											disabled="true" />
									</s:else>
								</td>

								<td align="right" width="25%">
									<s:text name="licenceno" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.licenceno" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.licenceno"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="compactno" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.compactno" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.compactno"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="principal" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:property value="form.principal" />
									&nbsp
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="begintime" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<input class="style_input" name="form.begintime"
											value="<s:property value="form.begintime!=null?getText('format.date',{form.begintime}):''"/>"
											onclick="selectDate();" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<input class="style_input" name="form.begintime"
											value="<s:property value="form.begintime!=null?getText('format.date',{form.begintime}):''"/>"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="endtime" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<input class="style_input" name="form.cmpendtime"
											value="<s:property value="form.cmpendtime!=null?getText('format.date',{form.cmpendtime}):''"/>"
											onclick="selectDate();" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<input class="style_input" name="form.cmpendtime"
											value="<s:property value="form.cmpendtime!=null?getText('format.date',{form.cmpendtime}):''"/>"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="copbound" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.copbound" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.copbound"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="runareatype" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.runareatype" definition="$CH_ORGTYPE" />
									</s:if>
									<s:else>
										<j:selector name="form.runareatype" definition="$CH_ORGTYPE"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="bail" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:i18n name="public">
											<input class="style_input" name="form.bail" value="<s:property value="form.bail!=null?
														getText('format.double',{form.bail}):''"/>"" />
										</s:i18n>
									</s:if>
									<s:else>
										<s:i18n name="public">
											<input class="style_input" name="form.bail" value="<s:property value="form.bail!=null?
														getText('format.double',{form.bail}):''"/>"" disabled="true" />
										</s:i18n>
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="baillwrlmt" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:i18n name="public">
											<input class="style_input" name="form.baillwrlmt" value="<s:property value="form.baillwrlmt!=null?
												getText('format.double',{form.baillwrlmt}):''"/>"" />
										</s:i18n>
									</s:if>
									<s:else>
										<s:i18n name="public">
											<input class="style_input" name="form.baillwrlmt" value="<s:property value="form.baillwrlmt!=null?
												getText('format.double',{form.baillwrlmt}):''"/>"" disabled="true"/>
										</s:i18n>
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="compacttype" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.compacttype"
											definition="$CH_COMPACTTYPE" />
									</s:if>
									<s:else>
										<j:selector name="form.compacttype"
											definition="$CH_COMPACTTYPE" disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="signtime" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<input class="style_input" name="form.signtime"
											value="<s:property value="form.signtime!=null?getText('format.date',{form.signtime}):''"/>"
											onclick="selectDate();" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<input class="style_input" name="form.signtime"
											value="<s:property value="form.signtime!=null?getText('format.date',{form.signtime}):''"/>"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="bailstatus" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<j:selector name="form.bailstatus" definition="$CH_BAILSTATUS" />

									</s:if>
									<s:else>
										<j:selector name="form.bailstatus" definition="$CH_BAILSTATUS"
											disabled="true" />

									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="licvalidate" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<input class="style_input" name="form.licvalidate"
											value="<s:property value="form.licvalidate!=null?getText('format.date',{form.licvalidate}):''"/>"
											onclick="selectDate();" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<input class="style_input" name="form.licvalidate"
											value="<s:property value="form.licvalidate!=null?getText('format.date',{form.licvalidate}):''"/>"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="calcumode" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
									<%-- <s:property value="form.calcumode!=null?
												getText('format.long',{form.calcumode}):0"/> --%>
									 <s:select name="form.calcumode" list="#{0:'星级模式',1:'统一模式'}" ></s:select><font color="red">*</font>
									 	 
										<%--<j:selector name="form.calcumode" definition="$CH_CALCUMODE" condition="_sne_dictid:''"   />
										<font color="red">*</font> 
										<html:select property="form.calcumode"  condition="_sne_dictid:''">
											<s:Options  definition="$CH_CALCUMODE" />
										</html:select><font color=red>&nbsp;*</font> --%>
									</s:if>
									<s:else>
									<s:select name="form.calcumode" list="#{0:'星级模式',1:'统一模式'}" disabled="true"></s:select><font color="red">*</font>
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="uniformtime" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield name="form.uniformtime" onclick="selectDateYYYYMM();"  />
									</s:if>
									<s:else>
										<s:textfield name="form.uniformtime" onclick="selectDateYYYYMM();" 
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right">
									<s:text name="compactpath" />
									:&nbsp
								</td>
								<td align="left" colspan="3">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:file name="compactDoc" label="File" />
										<a
											href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.compactpath"/>'
											target="_blank"> <s:property value="form.compactpath" />
										</a>
									</s:if>
									<s:else>
										<a
											href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.compactpath"/>'
											target="_blank"> <s:property value="form.compactpath" />
										</a>
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right">
									营业执照文件:&nbsp
								</td>
								<td align="left" colspan="3">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:file name="licenceDoc" label="File" />
										<a
											href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.licencepath"/>'
											target="_blank"> <s:property value="form.licencepath" />
										</a>
									</s:if>
									<s:else>
										<a
											href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.licencepath"/>'
											target="_blank"> <s:property value="form.licencepath" />
										</a>
									</s:else>
								</td>
							</tr>

							<tr>
								<td colspan="4" align="center">
									<font color="blue">合作商账户信息管理</font>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="bankname" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.bankname" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.bankname"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="acctname" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.acctname" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.acctname"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="acctno" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.acctno" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.acctno"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
									<s:text name="intime" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<input class="style_input" name="form.intime"
											value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>"
											onclick="selectDate();" />
										<font color="red">*</font>
									</s:if>
									<s:else>
										<input class="style_input" name="form.intime"
											value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>"
											disabled="true" />
									</s:else>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<s:text name="acctfid" />
									:&nbsp
								</td>
								<td align="left" width="25%">
									<s:if test="CMD != WEB_CMD_SAVE">
										<s:textfield cssStyle="style_input" name="form.acctfid" />
									</s:if>
									<s:else>
										<s:textfield cssStyle="style_input" name="form.acctfid"
											disabled="true" />
									</s:else>
								</td>
								<td align="right" width="25%">
								</td>
								<td align="left" width="25%">
								</td>
							</tr>
						</table>
					</div>
				</aa:zone>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" align="center">
								<s:i18n name="public">
									<s:if test="flag == 'yes'">	
										<input type="button" id="btnSave" name="btnSave"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="提交申请"
											onclick="doSave('/channel/way_agapply.do')"
											<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
									</s:if>
									<s:else>
										<input type="button" id="btnSave" name="btnSave"
											class="button_Save" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="<s:text name="button_save"/>"
											onclick="doSave('/channel/way_agsave.do')"
											<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
									</s:else>
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn('/channel/way_aglist.do?WAYSUBTYPE=DIS')">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>
