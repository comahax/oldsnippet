<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="logistitleList"/></title>
    <script language="JavaScript">
    function ev_checkval() {
        if(document.all("form.longtitude").value !="" ){
            	if ((document.all("form.longtitude").value*1<100 ||document.all("form.longtitude").value*1>130 )) {
            		alert("经度值必须在100 － 130 之间!");
            		return false;
            	}
            	var str = document.all("form.longtitude").value;
            	var substr = str.substring(4);
            	if (substr.length!=6) {
            		alert("经度值小数位必须为6位!");
            		return false;
            	}
            }
            if(document.all("form.latitude").value !="" ){
            	if (document.all("form.latitude").value*1<18 ||document.all("form.latitude").value*1>26) {
            		alert("纬度值必须在18 － 26 之间!");
            		return false;
            	}

            	var str = document.all("form.latitude").value;
            	var substr = str.substring(3);
            	if (substr.length!=6) {
            		alert("纬度值小数位必须为6位!");
            		return false;
            	}
            }
            if(document.all("form.officetel").value !="" ){
            	var str = document.all("form.officetel").value;
            	if (str.length!=11) {
            		alert("手机号必须为11位!");
            		return false;
            	}
            	if (str.substring(0,1)!=1){
                	alert("手机号必须以1开头");
                	return false;
            	}
            	//var pattern = /^1(34|35|36|37|38|39|50|51|57|58|59|88)[0-9]{8}$/;
            	//var result = pattern.exec(str);
            	//if(result==null){
            	//	alert("手机号不正确!");
            	//	return false;
            	//}
            }
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false , 18);
            addfield('form.wayname', '<s:text name="wayname"/>', 'c', false, 256);
            addfield('form.upperwayid', '<s:text name="upperwayid"/>', 'c', false, 18);
            addfield('form.latitude', '<s:text name="latitude"/>', 'd', true, 2,6);
            addfield('form.longtitude', '<s:text name="longtitude"/>', 'd', true, 3,6);
            addfield('form.waystate', '<s:text name="waystate"/>', 'f', false, 2);
            addfield('form.officetel', '<s:text name="officetel2"/>', 'i', false, 11);
            addfield('form.employeename', '<s:text name="employeename"/>', 'c', false, 30);      
            return checkval(window);
        }
        
        function doSthWithWay(obj) {
        	showSelectWay(obj);
			ajaxAnywhere.submitByURL("/cms/disway.do?CMD=GETSTHWITHWAY"); 
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
        function pshowSelectWay3(control, idCtlId, showParent, showOfCitycom, waytype, waysubtype,runmode) {
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
					document.all("form.wayname").value = rtn[1];
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

            if(control.name.indexOf('form.countyid') > -1) {
            	if(document.all('form.cityid').value == "") {
    	            // 选择“分公司”前要先指定“地市公司” 
    	            alert("请先输入"+'<s:text name="cityid"/>');
    	            return;
                }else {
                    // 查询指定“地市公司”下的 “分公司”
                	condition = '_se_citycompid:'+ document.all('form.cityid').value;
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
    		if(nameCtrl!=null) nameCtrl.value = rtn[1];   		
    	}
    	
    </script>
</head>
<body>
<div class="table_container">
<s:form action="way_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._sk_wayid"/>
    <s:hidden name="param._sk_wayname"/>
    <s:hidden name="param._se_upperwayid"/>
    <s:hidden name="param._ne_cooperator"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_svccode"/>
    <s:hidden name="param._se_mareacode"/>
    <s:hidden name="processType" value="editLogsway"/>
    <s:hidden name="form.waysubtype" value="LOGS" />
    <s:hidden name="form.waylevel" />
    <s:hidden name="form.createtime" value="%{getText('format.datetime',{form.createtime})}"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="logistitleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="logistitleList"/>','<s:text name="helpContentLOGS"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="right"><s:text name="upperwayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD == WEB_CMD_NEW">
						<s:textfield cssStyle="style_input" name="form.upperwayid" maxlength="16" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectUpperway(this,'form.upperwayid','','','');this.value='...';" />
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.upperwayid" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD == WEB_CMD_NEW">
						<s:textfield cssStyle="style_input" name="form.wayid" maxlength="16" />
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="wayname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayname" maxlength="24" />
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayname" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid2"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cityid" maxlength="16" readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cityid" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="subcomp"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY" name="form.countyid" readonly="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY" name="form.countyid"
											disabled="true" />
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svcname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#SERVCENT" name="form.svccode" readonly="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#SERVCENT" name="form.svccode" readonly="true" 
							disabled="true" />
					</s:else>
                </td>
                <td align="right"><s:text name="mareaname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#MICROAREA" name="form.mareacode" readonly="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#MICROAREA" name="form.mareacode" readonly="true"
							disabled="true" />
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cooperator1"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.cooperator" definition="$CH_COOPERATOR" />
					</s:if>
					<s:else>
						<j:selector name="form.cooperator" definition="$CH_COOPERATOR" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="adacode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.adacode" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.adacode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="latitude"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.latitude" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.latitude" disabled="true"/>
					</s:else>
                </td>
                <td align="right"><s:text name="longtitude"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.longtitude" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.longtitude" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waystate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.waystate" definition="$CH_WAYSTATE" />
					</s:if>
					<s:else>
						<j:selector name="form.waystate" definition="$CH_WAYSTATE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="officetel2"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.officetel" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.officetel" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="employeename"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.employeename" maxlength="30"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.employeename" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td></td><td></td>
            </tr>
            <tr>
                <td align="right"><s:text name="address"/>:&nbsp</td>
                <td align="left" colspan="3">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield style="width:503px" name="form.address" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.address" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="left" colspan="4">
					<s:text name="exp" />
				</td>
            </tr>
            
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/way_logssave.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/way_logslist.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
