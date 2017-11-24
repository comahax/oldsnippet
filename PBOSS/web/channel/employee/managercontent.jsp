<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript">
    var validate = true;
        function ev_checkval() {
        
        if(!validate){
        	validate = true;
        	return true;
        }
			//addfield('form.employeeid', '<s:text name="employeeid"/>', 'c', false, 15);
			addfield('form.oprcode2', '<s:text name="oprcode"/>', 'c', true, 15);
			addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.employeename', '<s:text name="employeename"/>', 'c', false, 30);
			addfield('form.birthday', '<s:text name="birthday"/>', 't', true, 13);
			addfield('form.sex', '<s:text name="sex"/>', 'f', true, 3);
			addfield('form.edulevel', '<s:text name="edulevel"/>', 'f', true, 3);
			addfield('form.nativehome', '<s:text name="nativehome"/>', 'c', true, 20);
			addfield('form.department', '<s:text name="department"/>', 'c', true, 18);
			addfield('form.homeaddr', '<s:text name="homeaddr"/>', 'c', true, 255);
			addfield('form.cardid', '<s:text name="cardid"/>', 'c', false, 18);
			addfield('form.telephone', '<s:text name="telephone"/>', 'c', true, 15);
			addfield('form.pvtemail', '<s:text name="pvtemail"/>', 'c', false, 128);
			addfield('form.ofcphone', '<s:text name="ofcphone"/>', 'c', true, 64);
			addfield('form.speciality', '<s:text name="speciality"/>', 'c', true, 16);
			addfield('form.officetel', '<s:text name="officetel1"/>', 'c', false, 12);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 14);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
			addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
			addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', true, 14);
			addfield('form.gradschool', '<s:text name="gradschool"/>', 'c', true, 40);
			addfield('form.gradtime', '<s:text name="gradtime"/>', 't', true, 13);
			addfield('form.intime', '<s:text name="intime"/>', 't', true, 13);
			addfield('form.contacttype', '<s:text name="contacttype"/>', 'f', true, 2);
			addfield('form.employtype', '<s:text name="employtype"/>', 'f', true, 3);
			addfield('form.empstatus', '<s:text name="empstatus"/>', 'f', false, 2);
			addfield('form.station', '<s:text name="station"/>', 'f', true, 14);
			addfield('form.posittype', '<s:text name="posittype"/>', 'c', true, 16);
			addfield('form.joblevel', '<s:text name="joblevel"/>', 'f', true, 3);
			addfield('form.worktime', '<s:text name="worktime"/>', 'f', true, 3);
			addfield('form.company', '<s:text name="company"/>', 'c', true, 50);
			addfield('form.hereworktime', '<s:text name="hereworktime"/>', 'f', true, 3);
			addfield('form.ismarried', '<s:text name="ismarried"/>', 'f', true, 2);
			//判断邮箱函数，
			var mail = document.getElementById('form.pvtemail').value;
			if (mail != ''){ 
				var regInvalid=/(@.*@)|(\.\.)|(@\.)|(\.@)|(^\.)/; 
				var regValid=/^.+\@(\[?)[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3}|[0-9]{1,3})(\]?)$/; 
				if (!regInvalid.test(mail) && !regValid.test(mail)) {
					errorMessageShow("个人电子邮箱格式不对，请重写。");
					return false;
				}
		    }
			
			var officetel = document.getElementById('form.officetel').value
			if('' != officetel && !checkOfficetel(officetel)){
			return false;
			}
            return (checkval(window) && checkCardid());
        }
        
        function checkCardid() {
        	if(trim(document.getElementById("form.cardid").value).length!=15 && trim(document.getElementById("form.cardid").value).length!=18)
			{
				errorMessageShow("身份证号码为必填，且长度必须为15或18位");
				return false;
			} 
			return true;
        }

        function getCityAndCounty(wayId){
        var url = "/channel/employee_getWayInfo.do";
        document.getElementById('employee_save_do').action = url;
         document.getElementById('employee_save_do').submit();
      validate = false;
       // doSave("/channel/employee_getWayInfo.do");
        	//alert("a********");
        }
        
        // 检查采集平台捆绑手机号,录入的采集平台手机号对于在岗的这些人员是唯一的        
        function checkOfficetel(officetel){
        if(officetel ==''){
        var alertstr = '';
				errorMessageShow(alertstr);
				return true;
        }
        	var reg = /1[0-9]{10}/;
        	if(!reg.test(officetel)){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="officetel2"/> ]</span> 只能为11位的数字的手机号码 <span style=\'color:#F00; font-size:12px;\'></span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	
        	var employeeid  = document.getElementById('form.employeeid').value;
        	  /*   	
        	$.post(
        	contextPath+"/channel/employee_checkOfficetel.do",
     		{ "form.officetel": officetel, "form.employeeid":employeeid  },
     		function(data){

       			if("OK" != data){
       				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="officetel2"/> ]</span> 录入的采集平台手机号对于在岗的这些人员是唯一的 <span style=\'color:#F00; font-size:12px;\'></span>';
					errorMessageShow(alertstr);
					return false;
					}
     			}   
        	);
        	*/
        	var resultFlag = true;
        	$.ajax({
			 type: "POST",
			 url: contextPath+"/channel/employee_checkOfficetel2.do",
			 data:   "form.officetel="+ officetel+"&form.employeeid="+employeeid,
			 async: false,
			 success: function(result){
			 if("NO" == result){
       				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="officetel1"/> ]</span> 录入的公务手机号码对于在岗的这些人员是唯一的 <span style=\'color:#F00; font-size:12px;\'></span>';
					errorMessageShow(alertstr);
					resultFlag = false;
					}
			if("NG" == result){
       				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="officetel1"/> ]</span> 公务手机号码所属地市与登录工号所属地市不一致 <span style=\'color:#F00; font-size:12px;\'></span>';
					errorMessageShow(alertstr);
					resultFlag = false;
					}		
			 } 
			});	
			if(resultFlag){
        	var alertstr = "可以使用";
        	errorMessageShow(alertstr);
        	}
			return resultFlag;
        }
        function pshowSelectWaym(control, idCtlId, showParent, showOfCitycom, waytype, waysubtype,runmode) {
			var url = contextPath + "/channel/way_Selectwaytree.do?nonsense=1";
			if (showParent != null) {
				url = url + "&showParent=" + showParent;
			}
			if (showOfCitycom != null) {
				url = url + "&showOfCitycom=" + showOfCitycom;
			}
			if (waytype != null) {
				url = url + "&waytype=" + waytype;
			}
			if (waysubtype != null) {
				url = url + "&waysubtype=" + waysubtype;
			}
			if(runmode !=null){
				url = url + "&runmode=" + runmode;
			}
			if (control.form.menuTokenId != null && control.form.menuTokenId.value != null) {
				url += "&menuTokenId=" + control.form.menuTokenId.value;
			}			
			var rtn = window.showModalDialog(url, control, "dialogWidth=415px;dialogHeight=435px;status:no;scroll=yes;");
			if (rtn != null && rtn.length) {
				control.value = idCtlId == null ? rtn[0] : rtn[0] + " " + rtn[1];  	//name   	
				if (document.all(idCtlId) != null) {
					document.all(idCtlId).value = rtn[0];
					document.all('form.wayidAndName').value = rtn[0] + " " + rtn[1];
					document.all('form.mareacode').value = "";
				} //id
				return rtn;
			} else {
				if (rtn != null) {
					control.value = rtn;
					document.all('form.mareacode').value = "";
					return rtn;
				}
			}
		}
	  function openPicker(control,definition,condition) {
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
    </script>
</head>
<body>
<s:form action="employee_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_employeeid"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._ne_empstatus"/>
    <s:hidden name="param._ne_isnet"/>
    <s:hidden name="processType" value="MANAGER"/>
    
    
    <s:hidden name="form.servoffice"/>
    <s:hidden name="form.outtime"/>
    <s:hidden name="form.outresult"/>
    <s:hidden name="form.waytype"/>
    <s:hidden name="form.ofcemail"/>
    <s:hidden name="form.actbank"/>
    <s:hidden name="form.actno"/>
    <s:hidden name="form.actname"/>
    <s:hidden name="form.actpid"/>
    <s:hidden name="form.bail"/>
    <s:hidden name="form.outreason"/>
    <s:hidden name="form.trainlevel"/>
    <s:hidden name="form.hobby"/>
	<s:hidden name="form.character"/>
    <s:hidden name="form.asses"/>
    <s:hidden name="form.workhistry"/>
    <s:hidden name="form.prizeorpunish"/>
    <s:hidden name="form.empass"/>
    <s:hidden name="form.right"/>
    <s:hidden name="form.isnet" value="4"/>
    <s:hidden name="form.netpass"/>
    <s:hidden name="form.isopen"/>
    <s:hidden name="form.selectmobile"/>
    <!-- <s:hidden name="form.officetel"/> -->
    <s:hidden name="form.employeeid"/>
    <s:hidden name="form.wayid"/>
    
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">渠道经理管理</span>
			<span class="button_Help" onclick="openword('<s:text name="渠道经理管理"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
	</aa:zone>
	
	<aa:zone name="contentZone">
    <div class="table_div">
        <table class="table_normal">  
            <tr>
                <td align="right"><s:text name="oprcode3"/>:&nbsp</td>
                <td align="left">
                 <!-- <s:if test="CMD == WEB_CMD_NEW">
					<j:selector definition="#OPERATOR" name="form.oprcode2" condition='region:${dBAccessUser.hwcityid }' onclick="document.getElementById('form.employeeid').value=document.getElementById('form.oprcode2').value;"/>
				 </s:if>
				<s:elseif test="CMD == WEB_CMD_SAVE">
					<s:textfield  cssStyle="style_input" name="form.oprcode2" disabled="true"/>
				</s:elseif>	
				<s:elseif test="CMD == WEB_CMD_EDIT">
					<s:textfield  cssStyle="style_input" name="form.oprcode2" disabled="true"/>
				</s:elseif>	 -->
					<s:if test="CMD == WEB_CMD_NEW">
						<j:selector definition="#OPERATOR" name="form.oprcode2" condition='region:${dBAccessUser.hwcityid }' readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield  cssStyle="style_input" name="form.oprcode2" readonly="true"/> 
					</s:else>
                </td>
                
             	<td align="right"><s:text name="wayid2"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayidAndName" maxlength="18"  onclick="pshowSelectWaym(this,'form.wayid',null,null,'ET');getCityAndCounty(this.value);" />
					</s:if>
					<s:else>
						<s:textfield  cssStyle="style_input" name="form.wayidAndName" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="employeename"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.employeename" maxlength="30"/>
					</s:if>
					<s:else>
						<s:textfield  cssStyle="style_input" name="form.employeename" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            	<td align="right"><s:text name="birthday"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
                		<input class="style_input" name="form.birthday" value="<s:property value="form.birthday!=null?getText('format.date',{form.birthday}):''"/>" onclick="selectDate();"/>
                	</s:if>
					<s:else>
						<input class="style_input" name="form.birthday" value="<s:property value="form.birthday!=null?getText('format.date',{form.birthday}):''"/>" onclick="selectDate();" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sex"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_SEX" name="form.sex"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_SEX" name="form.sex" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="edulevel"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_EDULEVEL" name="form.edulevel"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_EDULEVEL" name="form.edulevel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="nativehome"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_NATIVE" name="form.nativehome"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_NATIVE" name="form.nativehome" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="polivisage"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
                		<j:selector definition="$CH_POLIVISAGE" name="form.polivisage"/>
                	</s:if>
					<s:else>
						<j:selector definition="$CH_POLIVISAGE" name="form.polivisage" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="homeaddr"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.homeaddr" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.homeaddr" maxlength="255" disabled="true"/>
					</s:else>
                </td>
             	<td align="right"><s:text name="cardid"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cardid" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cardid" maxlength="18" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>  
            </tr>
            <tr>
                <td align="right"><s:text name="telephone"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.telephone" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.telephone" maxlength="15" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="pvtemail"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.pvtemail" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.pvtemail" maxlength="128" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ofcphone"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.ofcphone" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.ofcphone" maxlength="64" disabled="true"/>
					</s:else>
                </td>
          		<td align="right"><s:text name="speciality"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.speciality" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.speciality" maxlength="16" disabled="true"/>
					</s:else>
                </td>
            </tr>   
          <tr>
               <td align="right"><s:text name="officetel1"/>:&nbsp</td>
               <td align="left">
               		<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.officetel" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.officetel" maxlength="15" disabled="true"/>
					</s:else>
					<font color="red">*</font>
               </td>
               <td align="right"></td>
               <td align="left">
					
               </td>
          </tr>
           
           
           
           <tr>
           <td colspan="4" align="center">组织信息</td>
           </tr>
 			<tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
                <s:hidden name="form.cityid" id="form.cityid"/>
					<input type="text" id="cityName" name="cityName" value="<j:code2Name definition="#CITYCOMPANY" code="form.cityid"/>" disabled="true"/>
					<font color="red">*</font>
                </td>
            
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
                <s:hidden name="form.countyid" id="form.countyid"/>
                <input type="text" id="countyName" name="countyName" value="<j:code2Name definition="#CNTYCOMPANY" code="form.countyid"/>" disabled="true"/>
                <font color="red">*</font>
                </td>
            </tr>
            <tr>
            <td align="right"><s:text name="svccode"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#SERVCENT" name="form.svccode" condition="countyid:${countyid}" mode="selector"/>
					</s:if>
					<s:else>
						<j:selector definition="#SERVCENT" name="form.svccode" condition="countyid:${countyid}" mode="selector" disabled="true"/>
					</s:else>
					<!-- <font color="red">*</font>  -->
                </td>
                <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#MICROAREA" name="form.mareacode"/>
					</s:if>
					<s:else>
						<j:selector definition="#MICROAREA" name="form.mareacode" disabled="true"/>
					</s:else>
                </td>
           	</tr>
           	
           	
           	 <tr>
           <td colspan="4" align="center">劳务信息</td>
           </tr>
           <tr>
                <td align="right"><s:text name="gradschool"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.gradschool" maxlength="40"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.gradschool" maxlength="40" disabled="true"/>
					</s:else>
                </td>
            
                <td align="right"><s:text name="gradtime"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
                		<input class="style_input" name="form.gradtime" value="<s:property value="form.gradtime!=null?getText('format.date',{form.gradtime}):''"/>" onclick="selectDate();"/>
                	</s:if>
					<s:else>
						<input class="style_input" name="form.gradtime" value="<s:property value="form.gradtime!=null?getText('format.date',{form.gradtime}):''"/>" onclick="selectDate();" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="intime"/>:&nbsp</td>
            	<td align="left">
            		<s:if test="CMD != WEB_CMD_SAVE">	
            			<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" onclick="selectDate();"/>
            		</s:if>
					<s:else>
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" onclick="selectDate();" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="contacttype"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_CONTACTTYPE" name="form.contacttype"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_CONTACTTYPE" name="form.contacttype" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr> 
            	<td align="right"><s:text name="employtype"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_EMPLOYTYPE" name="form.employtype"/> 
					</s:if>
					<s:else>
						<j:selector definition="$CH_EMPLOYTYPE" name="form.employtype" disabled="true"/> 
					</s:else>
                </td>
                <td align="right"><s:text name="empstatus"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_EMPSTATUS" name="form.empstatus"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_EMPSTATUS" name="form.empstatus" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
             <tr>          
                <td align="right"><s:text name="station"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="POSTINFO" name="form.station" mode="selector"/>
					</s:if>
					<s:else>
						<j:selector definition="POSTINFO" name="form.station" mode="selector" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="posittype"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:select list="#{'1':'经理'}" name="form.posittype"></s:select>
					</s:if>
					<s:else>
						<s:select list="#{'1':'经理'}" name="form.posittype" disabled="true"></s:select>
					</s:else>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="joblevel"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_JOBLEVEL" name="form.joblevel"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_JOBLEVEL" name="form.joblevel" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="department"/>:&nbsp</td>
	             <td align="left">
	             	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.department" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.department" maxlength="18" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="worktime"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.worktime" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.worktime" maxlength="3" disabled="true"/>
					</s:else>
                </td>
            	<td align="right"><s:text name="company"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.company" maxlength="50"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.company" maxlength="50" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="hereworktime"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.hereworktime" />
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.hereworktime" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="ismarried"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_ISMARRIED" name="form.ismarried"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_ISMARRIED" name="form.ismarried" disabled="true"/>
					</s:else>
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
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/employee_save.do')" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/employee_list.do?processType=MANAGER')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</body>
</html>
