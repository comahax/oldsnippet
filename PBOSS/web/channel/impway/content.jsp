<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_ADD";
%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
        	addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
            addfield('form.wayname', '<s:text name="wayname"/>', 'c', false, 256);
            addfield('form.upperwayid', '<s:text name="upperwayid"/>', 'c', false, 18);
            addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 14);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
			addfield('form.svccode', '<s:text name="svcname"/>', 'c', true, 14);
			addfield('form.mareacode', '<s:text name="mareaname"/>', 'c', true, 14);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', true, 2);
			addfield('form.runmode', '<s:text name="runmode"/>', 'f', false, 2);
			addfield('form.isconnected', '<s:text name="isconnected"/>', 'f', true, 2);
			addfield('form.connecttype', '<s:text name="connecttype"/>', 'f', true, 2);
			addfield('form.prtsource', '<s:text name="prtsource"/>', 'f', false, 2);
			addfield('form.buztypecode', '<s:text name="buztypecode"/>', 'f', true, 2);
			addfield('form.adtypecode', '<s:text name="adtypecode"/>', 'f', true, 2);
			addfield('form.buzphoneno', '<s:text name="conntel"/>', 'c', true, 14);
			addfield('form.adacode', '<s:text name="adacode"/>', 'c', true, 18);
			addfield('form.latitude', '<s:text name="latitude"/>', 'd', false, 15, 6, null, 18, 26);
			addfield('form.longtitude', '<s:text name="longtitude"/>', 'd', false, 15, 6, null, 100, 130);
			addfield('form.address', '<s:text name="address"/>', 'c', true, 128);
			addfield('form.waystate', '<s:text name="waystate"/>', 'c', false,3);
			addfield('form.iscoreway', '<s:text name="iscoreway"/>', 'f', true, 2);
			addfield('form.chainhead', '<s:text name="WAYID"/>', 'c', true, 18);
			addfield('form.isshare', '<s:text name="isshare"/>', 'c', true, 32);
			
			var upperwayid = document.all("form.upperwayid").value;
			var wayid = document.all("form.wayid").value;
			if(upperwayid!="" && wayid!="" && upperwayid==wayid){
       			var alertstr = '<span class=\'errorkey\'><li>上级渠道编码与该渠道编码相同,上级渠道不能是该渠道本身</li></span>';
       			errorMessageShow(alertstr);
           		return false;
            }
			
        	if(document.all("form.longtitude").value!=""){
        		if(document.all("form.longtitude").value*1<100 ||document.all("form.longtitude").value*1>130 || !document.all("form.longtitude").value.match("[0-9]{2}(.?)[0-9]{6}")){
        			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[地理经度]</span>' + '经度值必须在100 － 130 之间并且精确到小数后6位!' + '</span>';
        			errorMessageShow(alertstr);
            		return false;
            	}
            }
            if(document.all("form.latitude").value!=""){
            	if(document.all("form.latitude").value*1<18 ||document.all("form.latitude").value*1>26 || !document.all("form.latitude").value.match("[0-9]{1}(.?)[0-9]{6}")){
            		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[地理纬度]</span>' + '纬度值必须在18 － 26 之间并且精确到小数后6位!' + '</span>';
            		errorMessageShow(alertstr);
            		return false;
            	}
            }
            return checkval(window);
        }
         function pshowSelectUpperway(control, idCtlId, showParent, showOfCitycom, waytype, waysubtype,runmode) {
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
					jQuery.ajax({
						type:"POST",
						url:"<%=contextPath %>/channel/way_doGetwayinfo.do",
						async:false, //同步
						data:"selectType=logsway&wayid="+rtn[0],			
						success:function(msg){
							if(msg!="NO" && msg!="noAdtyOrStarlevel"){
								var strs=msg.split(",");
								if(strs[2]!="null")
				        			$(":text[name='form.cityid']").val(strs[2]);
				        		if(strs[3]!="null")
				        			$(":text[name='form.countyid']").val(strs[3]);
				        		if(strs[4]!="null")
				        			$(":text[name='form.svccode']").val(strs[4]);
				        		if(strs[5]!="null")
				        			$(":text[name='form.mareacode']").val(strs[5]);
				        		if(strs[6]!="null")
				        			$(":hidden[name='form.centerid']").val(strs[6]);
				        	}
						}
					});
				} //id
				return rtn;
			} else {
				if (rtn != null) {
					control.value = rtn;
					return rtn;
				}
			}
	}

         function openPicker(control,definition,condition) {
 			if(control.name.indexOf('form.countyid') > -1 ) {
                 if(document.all('form.cityid').value == "") {
     	            // 选择“分公司”前要先指定“地市公司” 
     	            alert("请先输入"+'<s:text name="cityid"/>');
     	            return;
                 }else {
                     // 查询指定“分公司”下的 “服务销售中心编码”
                 	condition = 'citycompid:'+ document.all('form.cityid').value;
                 }
             }
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
     		if(codeCtrl!=null) {
     			if(rtn[0] == ""){
     				codeCtrl.value = "0000";
     			}
     		}
     		if(nameCtrl!=null) nameCtrl.value = rtn[1];   		
     	}
     	function doCheckUpper(obj) { 
     	    pshowSelectUpperway(obj,'form.upperwayid','','','AG|ET','');
	     	if(obj.value == null || obj.value == ""){
        		return;
        	}
        	var upperwayid = document.all("form.upperwayid").value;
        	if (upperwayid == null || upperwayid == "") {
        		return;
        	}
        	var url = contextPath+"/channel/impway_Checkupperway.do";
        	formItem.action = url;
        	formItem.submit();
        	formItem.action = contextPath + "/channel/impway_save.do";
     	}
     	var param75 = <%=request.getAttribute("param75")%>;
     	function checkMemo(){
     		var waystate = document.all('form.waystate').value;
     		
     		if(1 == param75){
	     		if(waystate != 1){
	     			document.getElementById("memoDiv").style.display="";//显示
	     		}else{
	     			document.getElementById("memoDiv").style.display="none";//隐藏
	     		}
     		}
     	}
     	
     	function displayMemo(){
     		var waystate = document.all('form.waystate').value;
     		
     		if(param75 == 1){
     			if(waystate != 1){
     				document.getElementById("memoDiv").style.display="";//显示
     			}
     		}
     		
     	}
     	
     	function showdiv(select){
			var oDiv = select.value;
			
			if(oDiv == "1"){
				document.getElementById("g3_div1").style.display="";
				document.getElementById("g3_div2").style.display="";
				document.getElementById("g3_div3").style.display="";
				document.getElementById('form.starlevel').value="7";
			}else{
				document.getElementById("g3_div1").style.display="none";
				document.getElementById("g3_div2").style.display="none";
				document.getElementById("g3_div3").style.display="none";
			}
		}
		
		function selectCheck() {
			var seleval = "<s:property value='form.starlevel'/>";
			var seleoptions = document.getElementById("_starlevel").options;
			for (var i = 0; i < seleoptions.length; i++) {
				if (seleoptions[i].value == seleval) {
					seleoptions[i].selected = true;
					return;
				}
			}
		}
    </script>
</head>
<body onload="displayMemo();selectCheck();">
<div class="table_container">
<s:form action="impway_save.do" cssStyle="formList" key="formItem" method="post" theme="simple" onsubmit="return ev_checkval();">
    <s:hidden name="CMD"/>
    <s:hidden name="flag"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="form.createtime" value="%{getText('format.datetime',{form.createtime})}"/>
	<s:hidden name="form.waytype"/>
	
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

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
                        <font color="red">*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.wayid" readonly="true"/>
						<font color="red">*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
						<font color="red">*</font>
			        </s:else>
                </td>
                <td align="right"><s:text name="wayname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayname" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="upperwayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.upperwayid" maxlength="18" readonly="true"/><input type="button" value="..." class="picker_button" onclick="doCheckUpper(this);this.value='...';" />
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.upperwayid" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
                <td align="right"><s:text name="WAYID"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.chainhead" definition="#WAY" readonly="true" 
							condition="waytype:AG;waysubtype:DIS;waystate:1;cityid:${dBAccessUser.cityid}"/>
						<font color="blue">这里可以填入省级合作商的编码</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.chainhead" disabled="true"/>
						<font color="blue">这里可以填入省级合作商的编码</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CITYCOMPANY" name="form.cityid" mode="selector" disabled="true"
							condition="citycompid:${dBAccessUser.cityid }" value="${dBAccessUser.cityid }"/>
					</s:if>
					<s:else>
						<j:selector definition="#CITYCOMPANY" name="form.cityid" disabled="true" />
					</s:else>
					<font color="red">*</font>
                </td>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY" name="form.countyid" 
							condition="citycompid:${dBAccessUser.cityid }" readonly="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY" name="form.countyid" disabled="true" />
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svcname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
							<j:selector definition="#SERVCENT" name="form.svccode" readonly="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#SERVCENT" name="form.svccode" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="mareaname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#MICROAREA" name="form.mareacode" readonly="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#MICROAREA" name="form.mareacode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<select name="form.starlevel" id="_starlevel">
						    <option value=""></option>
						    <option value="0">未定星级</option>
						    <option value="1">一星级</option>
						    <option value="2">二星级</option>
						    <option value="3">三星级</option>
						    <option value="4">四星级</option>
						    <option value="5">五星级</option>
						    <option value="6">六星级</option>
						</select>
					</s:if>
					<s:else>
						<j:selector name="form.starlevel" definition="$CH_STARLEVEL" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="runmode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.runmode" definition="$CH_RUNMODE" />
					</s:if>
					<s:else>
						<j:selector name="form.runmode" definition="$CH_RUNMODE" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isconnected"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.isconnected" definition="$CH_ISCONNECTED" />
					</s:if>
					<s:else>
						<j:selector name="form.isconnected" definition="$CH_ISCONNECTED" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="connecttype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.connecttype" definition="$CH_CONNECTTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.connecttype" definition="$CH_CONNECTTYPE" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="prtsource"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.prtsource" definition="$CH_PRTSOURCE" />
					</s:if>
					<s:else>
						<j:selector name="form.prtsource" definition="$CH_PRTSOURCE" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
                <td align="right"><s:text name="buztypecode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.buztypecode" definition="$CH_BUZTYPE" />
					</s:if>
					<s:else>
						 <j:selector name="form.buztypecode" definition="$CH_BUZTYPE"  disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="adtypecode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.adtypecode" definition="$CH_ADTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.adtypecode" definition="$CH_ADTYPE" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="conntel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.buzphoneno" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.buzphoneno" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="adacode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.adacode" mode="picker"
											condition="_se_uppercode:${dBAccessUser.cityid }"
											definition="#CH_ADIMAREA" readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.adacode" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="address"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.address" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.address" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="longtitude"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.longtitude" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.longtitude" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
                <td align="right"><s:text name="latitude"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.latitude" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.latitude" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waystate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector onchange="checkMemo();" name="form.waystate" definition="$CH_WAYSTATE" />
						<font color="red">*</font>
					</s:if>
					<s:else>
						<j:selector onchange="checkMemo();" name="form.waystate" definition="$CH_WAYSTATE" disabled="true"/>
						<font color="red">*</font>
					</s:else>
                </td>
                <td align="right"><s:text name="iscoreway"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector onchange="checkMemo();" name="form.iscoreway" definition="$CH_DSTISKEYSTEP" />
					</s:if>
					<s:else>
						<j:selector onchange="checkMemo();" name="form.iscoreway" definition="$CH_DSTISKEYSTEP" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isshare"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector onchange="checkMemo();" name="form.isshare" definition="$CH_DSTISKEYSTEP" />
					</s:if>
					<s:else>
						<j:selector onchange="checkMemo();" name="form.isshare" definition="$CH_DSTISKEYSTEP" disabled="true"/>
					</s:else>
                </td>
                <td align="right">&nbsp</td>
                <td align="left">&nbsp</td>
            </tr>
            <tr>
            	<td align="center" colspan="4"><font color="blue" ><s:text name="exp"/></font></td>
			</tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
					<j:purChk permid="<%=ID_1%>" disableChild="true">
                    	<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/impway_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                   	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       value="<s:text name="button_return"/>" onclick="doReturn('/channel/impway_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
