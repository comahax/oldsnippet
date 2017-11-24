<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
	<title><s:text name="titleUpdate"/></title>
	<script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
	<script type="text/javascript"
		src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript"
		src="<%=contextPath%>/js/bus/rescommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
	<script language="JavaScript">
        function ev_checkval() {
        	if(document.all("form.longtitude").value!=""){
        		if(document.all("form.longtitude").value*1<100 ||document.all("form.longtitude").value*1>130 || !document.all("form.longtitude").value.match("[0-9]{2}(.?)[0-9]{6}")){
        			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[办公地点经度]</span>' + '经度值必须在100 － 130 之间并且精确到小数后6位!' + '</span>';
        			errorMessageShow(alertstr);
            		return false;
            	}
            }
            if(document.all("form.latitude").value!=""){
            	if(document.all("form.latitude").value*1<18 ||document.all("form.latitude").value*1>26 || !document.all("form.latitude").value.match("[0-9]{1}(.?)[0-9]{6}")){
            		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[办公地点纬度]</span>' + '纬度值必须在18 － 26 之间并且精确到小数后6位!' + '</span>';
            		errorMessageShow(alertstr);
            		return false;
            	}
            }
    
        	 addfield('form.compactname', '合同协议名称', 'c', false, '255');
        	 addfield('form.signtime', '签约时间', 't', false);
        	 addfield('form.endtime', '协议截止时间', 't', false);
        	 addfield('form.begintime', '协议签署生效时间', 't', false);
        	 addfield('form.compactno', '签约编号', 'c', false, '17');
        	 addfield('form.principaltel', '负责人电话', 'c', false, '20');
        	 addfield('form.company', '委托方公司名称', 'c', true, '60');
        	 addfield('form.certinum', '身份证号码', 'c', true, '18');
        	 addfield('form.principal', '法人代表', 'c', false, '64');
        	 addfield('form.busnum', '工商注册号', 'c', true, '30');
        	addfield('form.uniquewayid', '全网统一渠道编码', 'c', true, '30');            
            addfield('form.town', '乡镇', 'c', true, '30');
            addfield('form.provtype', '渠道基础类型', 'i', false, '3');
            addfield('form.mobilemall', '是否卖场加盟', 'i', true, '3');
            addfield('form.frontarea', '前台营业面积（㎡）', 'f', true, '8', '2');
            addfield('form.haswaitmach', '有无排队叫号机', 'i', true, '3');
            addfield('form.hasposmach', '有无POS机', 'i', true, '3');
            addfield('form.has24mall', '有无24小时自助营业厅', 'i', true, '3');
            addfield('form.hasvipseat', '有无VIP专席', 'i', true, '3');
            addfield('form.hasviproom', '有无VIP室', 'i', true, '3');
            addfield('form.g3area', 'G3体验区面积', 'f', true, '14', '2');
            
            addfield('form.buztypecode', '<s:text name="buztypecode"/>', 'i', false,2);
            addfield('form.wayid', '渠道编码', 'c', false, 18);
            addfield('form.upperwayid', '上级渠道', 'c', false, 18);
            addfield('form.bchlevel', '<s:text name="bchlevel"/>', 'c', false, 2);
            addfield('form.prtsource', '<s:text name="prtsource"/>', 'i', false, 2);            
			addfield('form.adtypecode', '<s:text name="adtypecode"/>', 'i', false, 2);            
            addfield('form.wayname', '渠道名称', 'c', false, 256);
            addfield('form.latitude', '<s:text name="latitude"/>', 'd', false, 15, 6, null, 18, 26);
            addfield('form.buzphoneno', '<s:text name="buzphoneno"/>', 'c', true, 14);
            addfield('form.longtitude', '<s:text name="longtitude"/>', 'd', false, 15, 6, null, 100, 130);
            addfield('form.address', '<s:text name="address"/>', 'c', true, 128);
            return checkval(window);
        }
        function checkischar(levels){
        var form=document.forms[0];
        var str=/[a-zA-Z]/;
        if(!str.test(levels)){
         errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<s:text name="bchlevel"/>]</span><s:text name="bchlevel"/>必须为字母</span>');
         return true;
        }
        if(levels.length>1){
        errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<s:text name="bchlevel"/>]</span><s:text name="bchlevel" />长度不能大于1</span>');
         return true;
        }
        }
        <%--
        function doAjaxsubmit(obj){
        
        showSelectWay(obj);
		ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=Changeupwayid&cmdvalue=citycompid&cmdstates=<c:out value="${requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].cmdState}"/>"); 
		}
		
		function isExistedWid(){
		var form=document.forms[0];
		ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=Existedwid"); 
		}
		
		function isCheckada(){
		var form=document.forms[0];
		ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=Checkada"); 
		}
		
		function doGetList(cmdvalue){
			ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=GETCOUNTID&cmdvalue="+cmdvalue+"&cmdstates=<c:out value="${requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].cmdState}"/>"); 
		}
		function selectSv(){
        	ajaxAnywhere.submitByURL("/cms/zjtywayinfo/zjtywayinfo.do?CMD=SELECTSV"); 
        }
         --%>
         
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
     		if(nameCtrl!=null) nameCtrl.value = rtn[1];   		
     	}
         
        function doCheckUpper(obj)
     	{ 
     	    pshowSelectUpperway(obj,'form.upperwayid','','','AG|ET');
	     	if(obj.value == null || obj.value == ""){
        		return;
        	}
        	var url = contextPath+"/channel/zjtywayinfo_Checkupperway.do";
        	formItem.action=url;
        	formItem.submit();
        	formItem.action = contextPath + "/cms/zjtywayinfo_save.do";
     	} 
    </script>
</head>
<body >
	<div class="table_container">
		<s:form action="zjtywayinfo_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			<s:hidden name="CMD" />
			<s:hidden name="param._orderby" />
			<s:hidden name="param._desc" />
			<s:hidden name="param._pageno" />
			<s:hidden name="param._pagesize" />
			<s:hidden name="form.waysubtype" value="ZJTY" />
			<s:hidden name="form.runmode" value="1" />
			
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
						<td align="right">渠道编码:&nbsp</td>
						<td align="left">
							<s:if test="CMD == WEB_CMD_NEW">
		                        <s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
		                        <font color=red>*</font>
					        </s:if>
					        <s:elseif test="CMD == WEB_CMD_EDIT">
					        	<s:textfield cssStyle="style_input" name="form.wayid" readonly="true"/>
								<font color=red>*</font>
							</s:elseif>
					        <s:else>
								<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
								<font color=red>*</font>
					        </s:else>
							<%-- 
							<c:choose>
								<c:when test="${edtvalue eq 'NEW'}">
									<input type="text" name="wayid" class="form_input_1x"
										onBlur="isExistedWid()" />
									<font color=red>&nbsp;*</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="wayid"
										readonly="true" />
								</c:otherwise>
							</c:choose>
							--%>
						</td>

						<td align="right">
							渠道名称::&nbsp
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.wayname" maxlength="256"/>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.wayname" disabled="true"/>
							</s:else>
							<font color=red>*</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							<s:text name="upperwayid"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.upperwayid" maxlength="18" readonly="true"/>
								<input type="button" value="..." class="picker_button" onclick="doCheckUpper(this);this.value='...';" />
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.upperwayid" disabled="true"/>
							</s:else>
							<font color=red>*</font>
								<%-- 
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="upperwayid"
										readonly="true" onclick="doAjaxsubmit(this)" />
									<font color=red>&nbsp;*</font>
								</c:when>
								--%>
						</td>

						<td align="right">
							<s:text name="svbrchcode"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.svbrchcode" definition="$CH_SVBRCHTYPE" />
							</s:if>
							<s:else>
								<j:selector name="form.svbrchcode" definition="$CH_SVBRCHTYPE" disabled="true"/>
							</s:else>
							<font color=red>*</font>
						</td>
					</tr>
					<tr>
						<td align="right">
						<s:text name="bchlevel"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.bchlevel" definition="$CH_BCHLEVEL" />
							</s:if>
							<s:else>
								<j:selector name="form.bchlevel" definition="$CH_BCHLEVEL" disabled="true"/>
							</s:else>
							<font color=red>*</font>
						</td>
						<td align="right">
						<s:text name="waysubtype"/>
							:
						</td>
						<td align="left">
							自建他营厅
						</td>
					</tr>
					<tr>
						<td align="right">
						<s:text name="cityid"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector definition="#CITYCOMPANY" name="form.cityid" mode="selector" condition="citycompid:${dBAccessUser.cityid }"   disabled="true" readonly="true"/>
							</s:if>
							<s:else>
								<j:selector definition="#CITYCOMPANY" name="form.cityid"
													disabled="true" />
							</s:else>
							<font color=red>*</font>
						</td>
						<td align="right">
						<s:text name="countyid"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector definition="#CNTYCOMPANY" name="form.countyid" condition="citycompid:${dBAccessUser.cityid }"/>
							</s:if>
							<s:else>
								<j:selector definition="#CNTYCOMPANY" name="form.countyid"
													disabled="true" />
							</s:else>
							<font color=red>*</font>
						</td>
					</tr>
					<tr>
						<td align="right">
						<s:text name="svccode"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector definition="#SERVCENT" name="form.svccode" />
							</s:if>
							<s:else>
								<j:selector definition="#SERVCENT" name="form.svccode" disabled="true"/>
							</s:else>
						</td>
						<td align="right">
						<s:text name="mareacode"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector definition="#MICROAREA" name="form.mareacode"/>
							</s:if>
							<s:else>
								<j:selector definition="#MICROAREA" name="form.mareacode" disabled="true"/>
							</s:else>
						</td>
					</tr>
					<!-- 新增的字段 -->
					<tr>
						<td align="right">
							<s:text name="starlevel"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.starlevel" definition="$CH_STARLEVEL" />
							</s:if>
							<s:else>
								<j:selector name="form.starlevel" definition="$CH_STARLEVEL"
									disabled="true" />
							</s:else>
						</td>

						<td align="right">
						<s:text name="runmode"/>
							:
						</td>
						<td align="left">
							加盟店
						</td>

					</tr>

					<tr>
						<td align="right">
						<s:text name="isconnected"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.isconnected" definition="$CH_ISCONNECTED" />
							</s:if>
							<s:else>
								<j:selector name="form.isconnected" definition="$CH_ISCONNECTED"
									disabled="true" />
							</s:else>
						</td>
						<td align="right">
						<s:text name="connecttype"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.connecttype" definition="$CH_CONNECTTYPE" />
							</s:if>
							<s:else>
								<j:selector name="form.connecttype" definition="$CH_CONNECTTYPE"
									disabled="true" />
							</s:else>
						</td>

					</tr>
					<!-- 结束 -->
					<tr>
						<td align="right">
						<s:text name="prtsource"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.prtsource" definition="$CH_PRTSOURCE" />
							</s:if>
							<s:else>
								<j:selector name="form.prtsource" definition="$CH_PRTSOURCE"
									disabled="true" />
							</s:else>
							<font color=red>&nbsp;*</font>
						</td>
						<td align="right">
						<s:text name="buztypecode"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.buztypecode" definition="$CH_BUZTYPE" />
							</s:if>
							<s:else>
								 <j:selector name="form.buztypecode" definition="$CH_BUZTYPE"  disabled="true"/>
							</s:else>
							<font color=red>&nbsp;*</font>
						</td>

					</tr>

					<tr>
						<td align="right">
							<s:text name="adtypecode"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.adtypecode" definition="$CH_ADTYPE" />
							</s:if>
							<s:else>
								<j:selector name="form.adtypecode" definition="$CH_ADTYPE" disabled="true"/>
							</s:else>
							<font color=red>*</font>
						</td>
						<td align="right">
						<s:text name="buzphoneno"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.buzphoneno" maxlength="14"/>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.buzphoneno" disabled="true"/>
							</s:else>
						</td>

					</tr>

					<tr>
						<td align="right">
						<s:text name="adacode"/>
							:
						</td>
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
						<td align="right">
							<s:text name="latitude"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.latitude" maxlength="15"/>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.latitude" disabled="true"/>
							</s:else>
							<font color=red>*</font>
						</td>

					</tr>

					<tr>
						<td align="right">
							<s:text name="longtitude"/>
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.longtitude" maxlength="15"/>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.longtitude" disabled="true"/>
							</s:else>
							<font color=red>*</font>
						</td>
						<td align="right">
							<s:text name="address"/>
							:
						</td>
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
						<td align="right">
							<s:text name="waystate"/>:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.waystate" definition="$CH_WAYSTATE" />
							</s:if>
							<s:else>
								<j:selector name="form.waystate" definition="$CH_WAYSTATE"
									disabled="true" />
							</s:else>
						</td>
						<td align="right">
							是否中心渠道:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.iscoreway" definition="$CH_ISCOREWAY" />
							</s:if>
							<s:else>
								<j:selector name="form.iscoreway" definition="$CH_ISCOREWAY"
									disabled="true" />
							</s:else>
						</td>
					</tr>


					<tr>

						<td align="right">
							所属合作商
							:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.chainhead" definition="#WAY" condition="waytype:AG;waysubtype:DIS;waystate:1;cityid:GD" readonly="true"/>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.chainhead" disabled="true"/>
							</s:else>
						</td>

						<td colspan="2">
							<font color=red>（自建他营的服务厅可输入对应的合作商编码）</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							是否共享
							:
						</td>
						<td>
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.isshare" definition="$CH_DSTISKEYSTEP" />
							</s:if>
							<s:else>
								<j:selector name="form.isshare" definition="$CH_DSTISKEYSTEP"
									disabled="true" />
							</s:else>

						</td>
						<td align="right">
							合同协议名称 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.compactname"
									maxlength="40" />
								<font color="red">*</font>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.compactname"
									disabled="true" /><font color=red>&nbsp;*</font>
							</s:else>
						</td>
					</tr>




					<!-- start -->
					<tr>
						<td align="right">
							委托方公司名称 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.company"
									maxlength="40" />
								<font color="red">*</font>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.company"
									disabled="true" />
							</s:else>
						</td>
						<td align="right">
							工商注册号 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.busnum"
									maxlength="40" />
								<font color="red">*</font>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.busnum"
									disabled="true" />
							</s:else>
						</td>
					</tr>
					<tr>
						<td align="right">
							法人代表 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.principal"
									maxlength="40" />
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.principal"
									disabled="true" />
							</s:else>
							<font color=red>&nbsp;*</font>
						</td>
						<td align="right">
							身份证号码 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.certinum"
									maxlength="18" />
								<font color="red">*</font>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.certinum"
									disabled="true" />
							</s:else>
						</td>

					</tr>
					<tr>
						<td align="right">
							签约编号 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.compactno"
									 />
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.compactno"
									disabled="true" />
							</s:else>
							<font color=red>&nbsp;*</font>
						</td>
						<td align="right">
							协议签署生效时间
							<br>
							（YYYY-MM-DD）:
						</td>
						<td align="left">
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

					</tr>
					<tr>
						<td align="right">
							协议截止时间
							<br>
							（YYYY-MM-DD）:
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<input class="style_input" name="form.endtime"
									value="<s:property value="form.endtime!=null?getText('format.date',{form.endtime}):''"/>"
									onclick="selectDate();" />
								<font color="red">*</font>
							</s:if>
							<s:else>
								<input class="style_input" name="form.endtime"
									value="<s:property value="form.endtime!=null?getText('format.date',{form.endtime}):''"/>"
									disabled="true" />
							</s:else>
						</td>
						<td align="right">
							全网统一渠道编码 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.uniquewayid" maxlength="32"/>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.uniquewayid" disabled="true"/>
							</s:else>
						</td>

					</tr>

					<tr>
						<td align="right">
							乡镇 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.town" maxlength="32"/>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.town" disabled="true"/>
							</s:else>
						</td>
						<td align="right">
							渠道基础类型 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.provtype" definition="$CH_PROVTYPE" />
							</s:if>
							<s:else>
								<j:selector name="form.provtype" definition="$CH_PROVTYPE" disabled="true"/>
							</s:else>
							<font color=red>*</font>
						</td>

					</tr>

					<tr>
						<td align="right">
							是否卖场加盟 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.mobilemall" definition="$YesOrNo" />
							</s:if>
							<s:else>
								<j:selector name="form.mobilemall" definition="$YesOrNo" disabled="true"/>
							</s:else>
						</td>
						<td align="right">
							前台营业面积（㎡） :
						</td>
						<td align="left">
							<s:if test="('' != form.frontarea) && (null != form.frontarea)">
								<s:if test="CMD != WEB_CMD_SAVE">						
									<s:textfield cssStyle="style_input" name="form.frontarea" value="%{getText('format.double',{form.frontarea})}" maxlength="11"/>						
								</s:if>
								<s:else>						
									<s:textfield cssStyle="style_input" name="form.frontarea" value="%{getText('format.double',{form.frontarea})}" disabled="true"/>
								</s:else>
							</s:if>
							<s:else>
								<s:if test="CMD != WEB_CMD_SAVE">						
									<s:textfield cssStyle="style_input" name="form.frontarea" maxlength="11"/>						
								</s:if>
								<s:else>						
									<s:textfield cssStyle="style_input" name="form.frontarea" disabled="true"/>
								</s:else>
							</s:else>
						</td>

					</tr>
					<tr>
						<td align="right">
							有无排队叫号机 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.haswaitmach" definition="$CH_COMMONHAS" />
							</s:if>
							<s:else>
								<j:selector name="form.haswaitmach" definition="$CH_COMMONHAS" disabled="true"/>
							</s:else>
						</td>
						<td align="right">
							有无POS机 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.hasposmach" definition="$CH_COMMONHAS" />
							</s:if>
							<s:else>
								<j:selector name="form.hasposmach" definition="$CH_COMMONHAS" disabled="true"/>
							</s:else>
						</td>

					</tr>
					<tr>
						<td align="right">
							有无24小时自助营业厅 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.has24mall" definition="$CH_COMMONHAS" />
							</s:if>
							<s:else>
								<j:selector name="form.has24mall" definition="$CH_COMMONHAS" disabled="true"/>
							</s:else>
						</td>
						<td align="right">
							有无VIP专席 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.hasvipseat" definition="$CH_COMMONHAS" />
							</s:if>
							<s:else>
								<j:selector name="form.hasvipseat" definition="$CH_COMMONHAS" disabled="true"/>
							</s:else>
						</td>

					</tr>
					<tr>
						<td align="right">
							有无VIP室 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<j:selector name="form.hasviproom" definition="$CH_COMMONHAS" />
							</s:if>
							<s:else>
								<j:selector name="form.hasviproom" definition="$CH_COMMONHAS" disabled="true"/>
							</s:else>
						</td>
						<td align="right">
							4G体验区面积 :
						</td>
						<td align="left">
							<%-- 
							<input type="text" name="g3area"
								value="<fmt:formatNumber pattern="0.00" value='${form.g3area}'/>"
								class="form_input_1x" />
							--%>
							<s:if test="('' != form.g3area) && (null != form.g3area)">
								<s:if test="CMD != WEB_CMD_SAVE">						
									<s:textfield cssStyle="style_input" name="form.g3area" value="%{getText('format.double',{form.g3area})}" maxlength="11"/>						
								</s:if>
								<s:else>						
									<s:textfield cssStyle="style_input" name="form.g3area" value="%{getText('format.double',{form.g3area})}" disabled="true"/>
								</s:else>
							</s:if>
							<s:else>
								<s:if test="CMD != WEB_CMD_SAVE">						
									<s:textfield cssStyle="style_input" name="form.g3area" maxlength="11"/>						
								</s:if>
								<s:else>						
									<s:textfield cssStyle="style_input" name="form.g3area" disabled="true"/>
								</s:else>
							</s:else>
						</td>

					</tr>
					<tr>
						<td align="right">
							负责人电话 :
						</td>
						<td align="left">
							<s:if test="CMD != WEB_CMD_SAVE">
								<s:textfield cssStyle="style_input" name="form.principaltel" maxlength="32"/>
							</s:if>
							<s:else>
								<s:textfield cssStyle="style_input" name="form.principaltel" disabled="true"/>
							</s:else>
							<font color=red>&nbsp;*</font>
						</td>
						<td align="right">
							签约时间 :
						</td>
						<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<input class="style_input" name="form.signtime" value="<s:property value="form.signtime!=null?getText('format.date',{form.signtime}):''"/>" onclick="selectDate();"/>
								</s:if>
								<s:else>
									<input class="style_input" name="form.signtime" value="<s:property value="form.signtime!=null?getText('format.date',{form.signtime}):''"/>"  disabled="true"/>
								</s:else>
							<font color=red>&nbsp;*</font>
						</td>
					</tr>
					<s:if test='CMD == "EDIT" || CMD == "SAVE"'>
					<tr>
						<td align="right">
							渠道经理工号:
						</td>
						<td align="left" colspan="3">
							<s:textfield cssStyle="style_input" name="form.waymagcode" disabled="true"/>
							<font color=red>(自建他营渠道没有渠道经理，如有值，保存时将自动清空)</font>
						</td>
					</tr>
					</s:if>
					<tr>
						<td align="right" colspan="8">
							<s:text name="note"/>
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
	                           value="<s:text name="button_save"/>" onclick="doSave('/channel/zjtywayinfo_save.do')"
	                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
	                           />
							
							<input type="button" id="btnReturn" name="btnReturn"
									class="button_Back" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)"
									value="<s:text name="button_return"/>"
									onclick="doReturn('/channel/zjtywayinfo_list.do')"/>
							</s:i18n>
						</td>
					</tr>
				</table>
			</div>
		</s:form>
	</div>
</body>
</html>
