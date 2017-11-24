<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@page import="com.gmcc.pboss.business.channel.wayapply.AGWayapplyVO"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_ADD";
	String ID_AUDIT="CH_PW_WAYAPPLY_AUDIT";
	AGWayapplyVO vo = (AGWayapplyVO)session.getAttribute("wayapp");
	if (vo == null) vo=new AGWayapplyVO();
%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
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
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.shortname', '<s:text name="shortname"/>', 'c', true, 32);
			addfield('form.svbrchcode', '<s:text name="svbrchcode"/>', 'c', true, 14);
			addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
			addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', true, 14);
			addfield('form.buztypecode', '<s:text name="buztypecode"/>', 'f', false, 2);
			addfield('form.adtypecode', '<s:text name="adtypecode"/>', 'f', false, 2);
			addfield('form.address', '<s:text name="address"/>', 'c', false, 128);
			addfield('form.logiscode', '<s:text name="logiscode"/>', 'c', true, 18);
			addfield('form.latitude', '<s:text name="latitude"/>', 'd', false, 15, 6, null, 18, 26);
			addfield('form.longtitude', '<s:text name="longtitude"/>', 'd', false, 15, 6, null, 100, 130);
			addfield('form.adacode', '<s:text name="adacode"/>', 'c', true, 18);
			addfield('form.waymagcode', '<s:text name="waymagcode"/>', 'c', true, 18);
			addfield('form.catetype', '<s:text name="catetype"/>', 'f', true, 2);
			addfield('form.formtype', '<s:text name="formtype"/>', 'f', false, 2);
			//addfield('form.starttime', '<s:text name="starttime"/>', 't', false, 7);
			addfield('form.buzarea', '<s:text name="buzarea"/>', 'f', false, 5);
			addfield('form.mainlayer', '<s:text name="mainlayer"/>', 'f', false, 2);
			addfield('form.sublayer', '<s:text name="sublayer"/>', 'f', true, 2);
			addfield('form.regid','<s:text name="regid" />','c',true,11);
			addfield('form.checked','是否授权网点','c',false,3);
			addfield('form.buzphoneno', '<s:text name="buzphoneno"/>', 'c', true, 14);
			addfield('form.wayname', '<s:text name="wayname"/>', 'c', false, 256);
			addfield('form.cooperator', '<s:text name="cooperator"/>', 'f', true, 2);
			addfield('form.waytype', '<s:text name="waytype"/>', 'c', true, 4);
			addfield('form.waysubtype', '<s:text name="waysubtype"/>', 'c', false, 4);
			addfield('form.custtype', '<s:text name="custtype"/>', 'c', true, 4);
			addfield('form.upperwayid', '<s:text name="upperwayid"/>', 'c', false, 18);
			addfield('form.busicode', '<s:text name="busicode"/>', 'c', true, 10);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 14);
			addfield('form.centerid', '<s:text name="centerid"/>', 'c', true, 14);
			addfield('form.citylevel', '<s:text name="citylevel"/>', 'f', true, 3);
			addfield('form.waylevel', '<s:text name="waylevel"/>', 'f', true, 3);
			addfield('form.bchlevel', '<s:text name="bchlevel"/>', 'c', false, 4);
			addfield('form.function', '<s:text name="function"/>', 'c', true, 255);
			addfield('form.miscode', '<s:text name="miscode"/>', 'c', true, 12);
			//addfield('form.createtime', '<s:text name="createtime"/>', 't', true, 7);
			addfield('form.disabletime', '<s:text name="disabletime"/>', 't', true, 7);
			addfield('form.waystate', '<s:text name="waystate"/>', 'c', false,3);
			addfield('form.runbyself', '<s:text name="runbyself"/>', 'c', true, 4);
			addfield('form.depotdet', '<s:text name="depotdet"/>', 'c', true, 20);
			addfield('form.isshare', '<s:text name="isshare"/>', 'c', true, 32);
			addfield('form.alarmbizamount', '<s:text name="alarmbizamount"/>', 'f', true, 10);
			addfield('form.prtsource', '<s:text name="prtsource"/>', 'f', true, 2);
			addfield('form.isconnected', '<s:text name="isconnected"/>', 'f', true, 2);
			addfield('form.connecttype', '<s:text name="mainsur"/>', 'f', false, 2);
			addfield('form.runmode', '<s:text name="runmode"/>', 'f', true, 2);
			addfield('form.iscoreway', '<s:text name="iscoreway"/>', 'f', true, 2);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);
			addfield('form.pt', '<s:text name="pt"/>', 'c', false,3);
			addfield('form.chainhead', '<s:text name="chainhead"/>', 'c', true, 18);
			addfield('form.signstatus', '<s:text name="signstatus"/>', 'f', false, 2);
			addfield('form.empnumber', '<s:text name="empnumber"/>', 'f', true, 4);
			addfield('form.magnumber', '<s:text name="magnumber"/>', 'f', true, 4);
			addfield('form.terminumber', '<s:text name="terminumber"/>', 'f', true, 4);
			addfield('form.updatedate', '<s:text name="updatedate"/>', 't', true, 7);
			addfield('form.isstraitprd', '<s:text name="isstraitprd"/>', 'f', false, 2);
			addfield('form.taxtype', '<s:text name="taxtype"/>', 'f', true, 2);
			addfield('form.servbound', '<s:text name="servbound"/>', 'i', false, 2);
			addfield('form.isb2m', '<s:text name="isb2m"/>', 'i', false, 1);
			addfield('form.officetel', '<s:text name="officetel"/>', 'c', false, '12');
			addfield('form.isKzcz', '是否接入空中充值平台', 'i', false, 1);
			addfield('form.istop', '是否TOP网', 'i', false, 1);

          //contact    
            addfield('form.principal', '<s:text name="principal"/>', 'c', false, 64);
			addfield('form.principaltel', '<s:text name="principaltel"/>', 'c', false, 20);
            addfield('form.principalphone', '<s:text name="principalphone"/>', 'c', true, 20);
            addfield('form.principalemail', '<s:text name="principalemail"/>', 'm', true, 128);
            addfield('form.sendaddr', '<s:text name="sendaddr"/>', 'c', true, 128);
            addfield('form.recpers', '<s:text name="recpers"/>', 'c', true, 32);
            addfield('form.recconntel', '<s:text name="recconntel"/>', 'c', true, 15);
            addfield('form.reccertno', '<s:text name="reccertno"/>', 'c', true, 20);
            addfield('form.smsmobileno', '<s:text name="smsmobileno"/>', 'i', true, 12);
            
            
            //compact
            addfield('form.compactno', '<s:text name="compactno"/>', 'c', false, 17);
            addfield('form.compactname', '<s:text name="compactname"/>', 'c', false, 255);
            addfield('form.begintime', '<s:text name="begintime"/>', 't', false);
            addfield('form.endtime', '<s:text name="cmpendtime"/>', 't', false);
            addfield('form.signtime', '<s:text name="signtime"/>', 't', false);
            addfield('form.compacttype', '<s:text name="compacttype"/>', 'i', false, 3);
            addfield('form.licenceno', '<s:text name="licenceno"/>', 'c', true, 64);       
            addfield('form.bail', '<s:text name="bail"/>', 'd', true, 18, 2);
            addfield('form.isunpb', '<s:text name="isunpb"/>', 'i', false, 1);
            addfield('form.compactpath', '<s:text name="compactpath"/>', 'c', true, 128);
            addfield('form.licencepath', '<s:text name="licencepath"/>', 'c', true, 128);
            addfield('form.licvalidate', '<s:text name="licvalidate"/>', 't', true);         
            addfield('form.baillwrlmt', '<s:text name="baillwrlmt"/>', 'd', false, 18, 2);
            
            //account
            addfield('form.bankname', '<s:text name="bankname"/>', 'c', false, 128);
            addfield('form.acctno', '<s:text name="acctno"/>', 'c', false, 30);
            addfield('form.acctname', '<s:text name="acctname"/>', 'c', false, 128);
            addfield('form.acctfid', '<s:text name="acctfid"/>', 'c', false, 18);
            
            addfield('form.uniquewayid', '<s:text name="uniquewayid"/>', 'c', true, 30);
            addfield('form.Town', '<s:text name="Town"/>', 'c', true, 30);
            addfield('form.provtype', '<s:text name="provtype"/>', 'i', true, 2);
            addfield('form.mobilemall', '<s:text name="Mobilemall"/>', 'i', true, 2);
            addfield('form.frontarea', '<s:text name="frontarea"/>', 'd', true, 8, 2);
            addfield('form.ispconntype', '<s:text name="ispconntype"/>', 'i', true, 2);
            
            var acctfid=document.all('form.acctfid').value;
            if(acctfid!='')
            {
            	acctfid= escape(Trim(acctfid));
            	if(acctfid.length!='15' &&  acctfid.length!='18')
            	{
            	  alert('身份证号码必须为15位或者18位');
            	  return false;
            	}
            	
            }
            addfield('form.intime', '<s:text name="intime"/>', 't', true); 
            addfield('form.debankid', '<s:text name="debankid"/>', 'c', true, 32);
            addfield('form.destate', '<s:text name="destate"/>', 'i', true, 1);
            addfield('form.accttype', '<s:text name="accttype"/>', 'i', false, 2);
            addfield('form.starlev', '<s:text name="starlev"/>', 'c', false, 1);
             var aValue=document.all("form.regid").value;
		        if(aValue!=""){
		        var reg = /^[a-z0-9A-Z]{11}$/;
			        if(!reg.test(aValue)){
				        alert('网点注册码必须为11位,只能是数字和字母!');
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
     		if(nameCtrl!=null) nameCtrl.value = rtn[1];   		
     	}
     	/**function doCheckUpper(obj)
     	{ 
     	    pshowSelectUpperway(obj,'form.upperwayid','','','AG|ET','DIS|GMPT|G100');
	     	if(obj.value == null || obj.value == ""){
        		return;
        	}
        	var url = contextPath+"/channel/saleway_Checkupperway.do";
        	formItem.action=url;
        	formItem.submit();
        	formItem.action = contextPath + "/cms/saleway_save.do";
     	}**/
     	function doCheckUpper(obj)
     	{ 
     		var tmpAction=formItem.action;
     	    pshowSelectWay3(obj,'form.upperwayid','','','AG|ET','DIS|GMPT|G100')
	     	if(obj.value == null || obj.value == ""){
        		return;
        	}
        	var url = contextPath+"/channel/wayapply_Checkupperway.do";
        	formItem.action=url;
        	formItem.submit();
        	formItem.action = tmpAction;
     	}
		//审批人弹出框
		function getAuditRoleList(){
			var	url='<%=contextPath %>/base/operator_auditRoleList.do?lastStepid='+document.all("form.lastStepid").value;	    	
		    var returnValue=window.showModalDialog(url,window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
			if(returnValue!=undefined){
			    return returnValue;
			}
		}
		function getValue()
	    {
		    var retValue=getAuditRoleList();
		    if(retValue!=null && typeof(retValue)!="undefined")
		    {
		    	document.all('form.oprcode').value=retValue;
		    }else
		    {
		     document.all('form.oprcode').value='';
		    }
	    }
	    function doSave(cmd)
        {
       	 	var ret = ev_checkval();
       	 	if (ret) {
	        	if(cmd=='CANCEL')
	        	{
	        	 var content=document.all("form.content").value;
	        	 if(content=="")
	        	 {
	        	 	alert('拒绝时[审核意见]为必填项');
	        	 	return false;
	        	 }
	        	}
	        	if(cmd=='PASS')
	        	{
	        	  var hasRight=document.all("form.hasRight").value;
	        	  if("1"==hasRight && document.all("form.oprcode").value=='')
	        	  {
	        	   alert("地市启用了[网点审批角色控制],[下一审批人]不能为空!");
	        	   return false;
	        	  }
	        	}
	            var url="<%=contextPath%>/channel/wayapply_save.do";
	            document.all("saveType").value=cmd;
	            formItem.action=url;
	            formItem.submit();
            }
            return false;
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="saleway_save.do" cssStyle="formList" key="formItem" enctype="multipart/form-data"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="form.waylevel" />
    <s:hidden name="form.centerid" />
    <s:hidden name="hasFlag"/>
    <s:hidden name="form.comefrom" />
	<s:hidden name="form.createtime" value="%{getText('format.datetime',{form.createtime})}"/>
	<s:hidden name="form.seqid" />
	<s:hidden name="form.applyno" />
	<s:hidden name="form.auditstatus" />
	<s:hidden name="form.auditstatus_work" />
	<s:hidden name="form.waytype" value="AG" />
	<s:hidden name="formType"></s:hidden><!-- 表页面从哪里过来 -->
	<s:hidden name="rvcobjid"></s:hidden><!-- 接收对象表标识 -->
	<s:hidden name="form.worktype" />
	<s:hidden name="saveType" />
	<s:hidden name="form.compactpath" />
	<s:hidden name="form.licencepath" />
	
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
                </td>
                <td align="right"><s:text name="wayname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayname" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getWayname()!=null) { %>
					<%=vo.getWayname() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:if test="hasFlag != 'false'">
						  <j:selector name="form.starlevel" definition="$CH_STARLEVEL" />
						</s:if>
						<s:else>
							<j:selector name="form.starlevel" definition="$CH_STARLEVEL" disabled="true"/>
						</s:else>
					</s:if>
					<s:else>
						<j:selector name="form.starlevel" definition="$CH_STARLEVEL" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getStarlevel()!=null) { %>
					<%=vo.getStarlevel() %>
					<%} %>
                </td>
                <td align="right"><s:text name="pt"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.pt" definition="$CH_PT" />
					</s:if>
					<s:else>
						<j:selector name="form.pt" definition="$CH_PT" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getPt()!=null) { %>
					<%=vo.getPt() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waymagcode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#EMPLOYEE" name="form.waymagcode" condition='_ne_isnet:4;_ne_empstatus:0' mode="picker"/>
					</s:if>
					<s:else>
						<j:selector definition="#EMPLOYEE" name="form.waymagcode" condition='_ne_isnet:4;_ne_empstatus:0' mode="picker"  disabled="true"/>
					</s:else>
					<%if (vo.getWaymagcode()!=null) { %>
					<%=vo.getWaymagcode() %>
					<%} %>
                </td>
                <td align="right"><s:text name="isstraitprd"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.isstraitprd" definition="$CH_STRAITPRD" />
					</s:if>
					<s:else>
						<j:selector name="form.isstraitprd" definition="$CH_STRAITPRD" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getIsstraitprd()!=null) { %>
					<%=vo.getIsstraitprd() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="upperwayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.upperwayid" readonly="true" onclick="doCheckUpper(this);"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.upperwayid" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getUpperwayid()!=null) { %>
					<%=vo.getUpperwayid() %>
					<%} %>
                </td>
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
					<%if (vo.getAdacode()!=null) { %>
					<%=vo.getAdacode() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="catetype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.catetype" definition="$CH_CATETYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.catetype" definition="$CH_CATETYPE" disabled="true"/>
					</s:else>
					<%if (vo.getCatetype()!=null) { %>
					<%=vo.getCatetype() %>
					<%} %>
                </td>
                <td align="right"><s:text name="waysubtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="WAYSUBTYPE" name="form.waysubtype" />
					</s:if>
					<s:else>
						<j:selector definition="WAYSUBTYPE" name="form.waysubtype" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getWaysubtype()!=null) { %>
					<%=vo.getWaysubtype() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="formtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.formtype" definition="$CH_FORMTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.formtype" definition="$CH_FORMTYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getFormtype()!=null) { %>
					<%=vo.getFormtype() %>
					<%} %>
                </td>
                <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.starttime" value="<s:property value="form.starttime!=null?getText('format.date',{form.starttime}):''"/>" readonly="true"/>
					</s:if>
					
					<s:else>
						<input class="style_input" name="form.starttime" value="<s:property value="form.starttime!=null?getText('format.date',{form.starttime}):''"/>" readonly="true"/>
					</s:else>
					<%if (vo.getStarttime()!=null) { %>
					<%=vo.getStarttime() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
                	<aa:zone name="getcityid">
						<s:if test="CMD != WEB_CMD_SAVE  and  form.cityid==null ">
							<j:selector definition="#CITYCOMPANY"  name="form.cityid"  cssStyle="style_input"  mode="selector"
							onchange="doGetList('cityid')"/>
						</s:if>
						<s:elseif test="CMD != WEB_CMD_SAVE  and form.cityid!=null ">
							<s:textfield cssStyle="style_input" name="form.cityid" readonly="true"/>
						</s:elseif>
						<s:else>
							<s:textfield cssStyle="style_input" name="form.cityid" disabled="true"/>
						</s:else>
					</aa:zone>	<!-- 
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CITYCOMPANY" name="form.cityid" mode="selector" condition="citycompid:${dBAccessUser.cityid }" disabled="true" />
					</s:if>
					<s:else>
						<j:selector definition="#CITYCOMPANY" name="form.cityid"
											disabled="true" />
					</s:else> -->
					<font color=red>*</font>
					<%if (vo.getCityid()!=null) { %>
					<%=vo.getCityid() %>
					<%} %>
                </td>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY" name="form.countyid" condition="citycompid:${dBAccessUser.cityid }"/>
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY" name="form.countyid"
											disabled="true" />
					</s:else>
					<font color=red>*</font>
					<%if (vo.getCountyid()!=null) { %>
					<%=vo.getCountyid() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svccode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
							<j:selector definition="#SERVCENT" name="form.svccode" />
					</s:if>
					<s:else>
						<j:selector definition="#SERVCENT" name="form.svccode" disabled="true"/>
					</s:else>
					<%if (vo.getSvccode()!=null) { %>
					<%=vo.getSvccode() %>
					<%} %>
                </td>
                <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#MICROAREA" name="form.mareacode"/>
					</s:if>
					<s:else>
						<j:selector definition="#MICROAREA" name="form.mareacode" disabled="true"/>
					</s:else>
					<%if (vo.getMareacode()!=null) { %>
					<%=vo.getMareacode() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bchlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.bchlevel" definition="$CH_BCHLEVEL" />
					</s:if>
					<s:else>
						<j:selector name="form.bchlevel" definition="$CH_BCHLEVEL" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getBchlevel()!=null) { %>
					<%=vo.getBchlevel() %>
					<%} %>
                </td>
                <td align="right"><s:text name="buzarea"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.buzarea" maxlength="5"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.buzarea" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getBuzarea()!=null) { %>
					<%=vo.getBuzarea() %>
					<%} %>
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
					<%if (vo.getWaystate()!=null) { %>
					<%=vo.getWaystate() %>
					<%} %>
                </td>
                <td align="right"><s:text name="logiscode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.logiscode" definition="#WAYIDINFO"
									condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}" />
					<%--	<s:textfield cssStyle="style_input" name="form.logiscode" maxlength="18"/><input type="button" value="..." class="picker_button" onclick="pshowSelectUpperway(this,'form.logiscode','','','AG','LOGS');this.value='...';" />--%>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.logiscode" disabled="true"/>
					</s:else>
					<%if (vo.getLogiscode()!=null) { %>
					<%=vo.getLogiscode() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="alarmbizamount"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.alarmbizamount" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.alarmbizamount" disabled="true"/>
					</s:else>
					<%if (vo.getAlarmbizamount()!=null) { %>
					<%=vo.getAlarmbizamount() %>
					<%} %>
                </td>
                <td align="right"><s:text name="officetel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.officetel" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.officetel" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getOfficetel()!=null) { %>
					<%=vo.getOfficetel() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="address"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.address" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.address" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getAddress()!=null) { %>
					<%=vo.getAddress() %>
					<%} %>
                </td>
                <td align="right"><s:text name="latitude"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.latitude" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.latitude" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getLatitude()!=null) { %>
					<%=vo.getLatitude() %>
					<%} %>
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
					<font color=red>*</font>
					<%if (vo.getLongtitude()!=null) { %>
					<%=vo.getLongtitude() %>
					<%} %>
                </td>
                <td align="right"><s:text name="adtypecode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.adtypecode" definition="$CH_ADTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.adtypecode" definition="$CH_ADTYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getAdtypecode()!=null) { %>
					<%=vo.getAdtypecode() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="signstatus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.signstatus" definition="$CH_SIGNSTATUS" />
					</s:if>
					<s:else>
						<j:selector name="form.signstatus" definition="$CH_SIGNSTATUS" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getSignstatus()!=null) { %>
					<%=vo.getSignstatus() %>
					<%} %>
                </td>
                <td align="right"><s:text name="provcode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.provcode" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.provcode" disabled="true"/>
					</s:else>
					<%if (vo.getProvcode()!=null) { %>
					<%=vo.getProvcode() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="chainhead"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.chainhead" definition="#WAY" condition="waytype:AG;waysubtype:DIS;waystate:1;cityid:${dBAccessUser.cityid}" readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.chainhead" disabled="true"/>
					</s:else>
					<%if (vo.getChainhead()!=null) { %>
					<%=vo.getChainhead() %>
					<%} %>
                </td>
                <td align="right"><s:text name="custtype"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CUSTWAYTYPE"  name="form.custtype" condition="citycompid:${dBAccessUser.cityid};_sne_custwaytypecode:${'ALL'}" cssStyle="style_input"  mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="#CUSTWAYTYPE"  name="form.custtype" condition="citycompid:${dBAccessUser.cityid}" cssStyle="style_input"  mode="selector" disabled="true"/>
					</s:else>
					<%if (vo.getCusttype()!=null) { %>
					<%=vo.getCusttype() %>
					<%} %>
                </td>
            </tr>
            <tr>
              <td align="right"><s:text name="buztypecode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.buztypecode" definition="$CH_BUZTYPE" />
					</s:if>
					<s:else>
						 <j:selector name="form.buztypecode" definition="$CH_BUZTYPE"  disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getBuztypecode()!=null) { %>
					<%=vo.getBuztypecode() %>
					<%} %>
                </td>
                <td align="right"><s:text name="istietong"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
                		<s:select name="form.istietong" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'':'' ,'0':'普通网点', '1':'原铁通网点','2':'G3社会信息服务站'}"	/>
					</s:if>
					<s:else>
						<s:select name="form.istietong" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'':'' ,'0':'普通网点', '1':'原铁通网点','2':'G3社会信息服务站'}"	disabled="true"/>
					</s:else>
					<%if (vo.getIstietong()!=null) { %>
					<%=vo.getIstietong() %>
					<%} %>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="mainsur"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.connecttype" definition="$CH_CONNECTTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.connecttype" definition="$CH_CONNECTTYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getConnecttype()!=null) { %>
					<%=vo.getConnecttype() %>
					<%} %>
                </td>
                <td align="right"><s:text name="secondsur"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.sublayer" definition="$CH_CONNECTTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.sublayer" definition="$CH_CONNECTTYPE"  disabled="true"/>
					</s:else>
					<%if (vo.getSublayer()!=null) { %>
					<%=vo.getSublayer() %>
					<%} %>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="regid"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.regid" maxlength="11"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.regid" maxlength="11" disabled="true"/>
					</s:else>
					<%if (vo.getRegid()!=null) { %>
					<%=vo.getRegid() %>
					<%} %>
                </td>
                <td align="right">是否授权网点:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.checked" definition="$CH_YESNO" />
					</s:if>
					<s:else>
						<j:selector name="form.checked" definition="$CH_YESNO"  disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getChecked()!=null) { %>
					<%=vo.getChecked() %>
					<%} %>
                </td>
            </tr>
            <tr>
            	<td align="right">是否接入空中充值平台:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.isKzcz" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.isKzcz" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getIskzcz()!=null) { %>
					<%=vo.getIskzcz() %>
					<%} %>
                </td>
                <td align="right"><s:text name="starlev"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
                		<s:select name="form.starlev" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'1':'A', '2':'B','3':'C'}"	/>
                	</s:if>
					<s:else>
						<s:select name="form.starlev" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'1':'A', '2':'B','3':'C'}" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getStarlev()!=null) { %>
					<%=vo.getStarlev() %>
					<%} %>
                </td>
            </tr>
             <tr>
            	<td align="right">是否TOP网点:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
                		<s:select name="form.istop" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'0':'否', '1':'是'}"	/>
                	</s:if>
					<s:else>
						<s:select name="form.istop" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'0':'否', '1':'是'}" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getIstop()!=null) { %>
					<%=vo.getIstop() %>
					<%} %>
					</td>
					<td align="right"></td>
                	<td align="left"></td>
			</tr>
			
            <tr>
            	<td align="center" colspan="4"><font color="blue" ><s:text name="exp"/></font></td>
			</tr>
			<tr>
            	<td align="center" colspan="4"><font color="blue" >全省代码只用于国美、苏宁等省市级连锁合作商家下的网点，其它的网点不需要填写全省代码。</font></td>
			</tr>
            <tr><td colspan="4"></td></tr>
            <tr>
                <td align="right"><s:text name="principal"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principal" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principal" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getPrincipal()!=null) { %>
					<%=vo.getPrincipal() %>
					<%} %>
                </td>
                <td align="right"><s:text name="principaltel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principaltel" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principaltel" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getPrincipaltel()!=null) { %>
					<%=vo.getPrincipaltel() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="principalphone"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principalphone" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principalphone" disabled="true"/>
					</s:else>
					<%if (vo.getPrincipalphone()!=null) { %>
					<%=vo.getPrincipalphone() %>
					<%} %>
                </td>
                <td align="right"><s:text name="principalemail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principalemail" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principalemail" disabled="true"/>
					</s:else>
					<%if (vo.getPrincipalemail()!=null) { %>
					<%=vo.getPrincipalemail() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="smsmobileno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.smsmobileno" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.smsmobileno" disabled="true"/>
					</s:else>
					<%if (vo.getSmsmobileno()!=null) { %>
					<%=vo.getSmsmobileno() %>
					<%} %>
                </td>
                <td align="right"><s:text name="recpers"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.recpers" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.recpers" disabled="true"/>
					</s:else>
					<%if (vo.getRecpers()!=null) { %>
					<%=vo.getRecpers() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="recconntel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.recconntel" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.recconntel" disabled="true"/>
					</s:else>
					<%if (vo.getRecconntel()!=null) { %>
					<%=vo.getRecconntel() %>
					<%} %>
                </td>
                <td align="right"><s:text name="reccertno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.reccertno" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.reccertno" disabled="true"/>
					</s:else>
					<%if (vo.getReccertno()!=null) { %>
					<%=vo.getReccertno() %>
					<%} %>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="bailtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.bailtype" definition="$CH_BAILTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.bailtype" definition="$CH_BAILTYPE" disabled="true"/>
					</s:else>
					<%if (vo.getBailtype()!=null) { %>
					<%=vo.getBailtype() %>
					<%} %>
                </td>
                <td align="right"><s:text name="servbound"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.servbound" definition="$CH_SERVBOUND" />
					</s:if>
					<s:else>
						<j:selector name="form.servbound" definition="$CH_SERVBOUND" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getServbound()!=null) { %>
					<%=vo.getServbound() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sendaddr"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.sendaddr" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.sendaddr" disabled="true"/>
					</s:else>
					<%if (vo.getSendaddr()!=null) { %>
					<%=vo.getSendaddr() %>
					<%} %>
                </td>
                <td align="right"><s:text name="accttype"/>:&nbsp</td>
                <td>
                <s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_ACCOUNTTYPE" name="form.accttype" mode="selector"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_ACCOUNTTYPE" name="form.accttype" mode="selector" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getAccttype()!=null) { %>
					<%=vo.getAccttype() %>
					<%} %>
				</td>
            </tr>
            <tr><td colspan="4"></td></tr>
            <tr>
                <td align="right"><s:text name="compactno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.compactno" maxlength="17"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.compactno" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getCompactno()!=null) { %>
					<%=vo.getCompactno() %>
					<%} %>
                </td>
                 <td align="right"><s:text name="isb2m"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.isb2m" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.isb2m" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getIsb2m()!=null) { %>
					<%=vo.getIsb2m() %>
					<%} %>
                </td>
                
            </tr>
            <tr>
                <td align="right"><s:text name="compactname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.compactname" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.compactname" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getCompactname()!=null) { %>
					<%=vo.getCompactname() %>
					<%} %>
                </td>
                <td align="right"><s:text name="begintime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.begintime" value="<s:property value="form.begintime!=null?getText('format.date',{form.begintime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.begintime" value="<s:property value="form.begintime!=null?getText('format.date',{form.begintime}):''"/>" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getBegintime()!=null) { %>
					<%=vo.getBegintime() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cmpendtime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.endtime" value="<s:property value="form.endtime!=null?getText('format.date',{form.endtime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.endtime" value="<s:property value="form.endtime!=null?getText('format.date',{form.endtime}):''"/>" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getEndtime()!=null) { %>
					<%=vo.getEndtime() %>
					<%} %>
                </td>
                <td align="right"><s:text name="signtime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.signtime" value="<s:property value="form.signtime!=null?getText('format.date',{form.signtime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.signtime" value="<s:property value="form.signtime!=null?getText('format.date',{form.signtime}):''"/>"  disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getSigntime()!=null) { %>
					<%=vo.getSigntime() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="compacttype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.compacttype" definition="$CH_COMPACTTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.compacttype" definition="$CH_COMPACTTYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getCompacttype()!=null) { %>
					<%=vo.getCompacttype() %>
					<%} %>
                </td>
                <td align="right"><s:text name="licenceno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.licenceno" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.licenceno" disabled="true"/>
					</s:else>
					<!-- <font color=red>*</font> -->
					<%if (vo.getLicenceno()!=null) { %>
					<%=vo.getLicenceno() %>
					<%} %>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="bail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:i18n name="public">
							<input class="style_input" name="form.bail" value="<s:property value="form.bail!=null?
								getText('format.double',{form.bail}):''"/>"" />
						</s:i18n>
					</s:if>
					<s:else>
						<s:i18n name="public">
							<input class="style_input" name="form.bail" value="<s:property value="form.bail!=null?
								getText('format.double',{form.bail}):''"/>"" disabled="true"/>
						</s:i18n>
					</s:else>
					<%if (vo.getBail()!=null) { %>
					<%=vo.getBail() %>
					<%} %>
                </td>
                <td align="right"><s:text name="baillwrlmt"/>:&nbsp</td>
                <td align="left">
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
					<font color=red>*</font>
					<%if (vo.getBaillwrlmt()!=null) { %>
					<%=vo.getBaillwrlmt() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="licvalidate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.licvalidate" value="<s:property value="form.licvalidate!=null?getText('format.date',{form.licvalidate}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.licvalidate" value="<s:property value="form.licvalidate!=null?getText('format.date',{form.licvalidate}):''"/>" disabled="true"/>
					</s:else>
					<!-- <font color=red>*</font> -->
					<%if (vo.getLicvalidate()!=null) { %>
					<%=vo.getLicvalidate() %>
					<%} %>
                </td>
                <td align="right"><s:text name="bailstatus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.bailstatus" definition="$CH_BAILSTATUS" />
					</s:if>
					<s:else>
						<j:selector name="form.bailstatus" definition="$CH_BAILSTATUS" disabled="true"/>
					</s:else>
					<%if (vo.getBailstatus()!=null) { %>
					<%=vo.getBailstatus() %>
					<%} %>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="isunpb"/>:&nbsp</td>
            	<td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.isunpb" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.isunpb" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getIsunpb()!=null) { %>
					<%=vo.getIsunpb() %>
					<%} %>
                </td>
                <td></td>
                <td></td>
            </tr>
              <tr>
               
                <td align="right"><s:text name="compactpath"/>:&nbsp</td>
                <td align="left" colspan="3">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:file name="compactDoc" label="File" />
						<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.compactpath"/>'
							target="_blank"> <s:property value="form.compactpath" /> </a>
					</s:if>
					<s:else>
						<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.compactpath"/>'
							target="_blank"> <s:property value="form.compactpath" /> </a>
					</s:else>
                </td>
            </tr>
              <tr>
                <td align="right">营业执照文件:&nbsp</td>
                <td align="left" colspan="3">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:file name="licenceDoc" label="File" />
						<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.licencepath"/>'
							target="_blank"> <s:property value="form.licencepath" /> </a>
					</s:if>
					<s:else>
						<a href='<%=contextPath%>/channel/saleway_download.do?file=<s:property value="form.licencepath"/>'
							target="_blank"> <s:property value="form.licencepath" /> </a>
					</s:else>
                </td>
              </tr>
          
            
            <tr><td colspan="4"></td></tr>
            <tr>
                <td align="right"><s:text name="acctno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.acctno" maxlength="30"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.acctno" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getAcctno()!=null) { %>
					<%=vo.getAcctno() %>
					<%} %>
                </td>
                <td align="right"><s:text name="acctname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.acctname" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.acctname" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getAcctname()!=null) { %>
					<%=vo.getAcctname() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bankname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.bankname" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.bankname" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getBankname()!=null) { %>
					<%=vo.getBankname() %>
					<%} %>
                </td>
                <td align="right"><s:text name="acctfid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.acctfid" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.acctfid" disabled="true"/>
					</s:else>
					<font color=red>*</font>
					<%if (vo.getAcctfid()!=null) { %>
					<%=vo.getAcctfid() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right" width="15%"><s:text name="debankid"/>:&nbsp</td>
                <td align="left" width="35%">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.debankid" definition="#BANK" mode="picker" readonly="true"/>
					</s:if>
					<s:else>
						<j:selector name="form.debankid" definition="#BANK" mode="picker" disabled="true"/>
					</s:else>
					<%if (vo.getDebankid()!=null) { %>
					<%=vo.getDebankid() %>
					<%} %>
                </td>
                <td align="right"><s:text name="destate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.destate" definition="$CH_VALIDFLAG" mode="selector"/>
					</s:if>
					<s:else>
						<j:selector name="form.destate" definition="$CH_VALIDFLAG" mode="selector" disabled="true"/>
					</s:else>
					<%if (vo.getDestate()!=null) { %>
					<%=vo.getDestate() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="deacctno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.deacctno" maxlength="50"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.deacctno" disabled="true"/>
					</s:else>
					<%if (vo.getDeacctno()!=null) { %>
					<%=vo.getDeacctno() %>
					<%} %>
                </td>
                <td align="right"><s:text name="deacctname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.deacctname" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.deacctname" disabled="true"/>
					</s:else>
					<%if (vo.getDeacctname()!=null) { %>
					<%=vo.getDeacctname() %>
					<%} %>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="debankname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.debankname" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.debankname" disabled="true"/>
					</s:else>
					<%if (vo.getDebankname()!=null) { %>
					<%=vo.getDebankname() %>
					<%} %>
                </td>
                <td align="right"><s:text name="intime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" disabled="true"/>
					</s:else>
					<%if (vo.getIntime()!=null) { %>
					<%=vo.getIntime() %>
					<%} %>
                </td>
            </tr>
            
            <tr><td colspan="4"></td></tr>
            
            <tr>
                <td align="right"><s:text name="uniquewayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.uniquewayid" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.uniquewayid" disabled="true"/>
					</s:else>
					<%if (vo.getUniquewayid()!=null) { %>
					<%=vo.getUniquewayid() %>
					<%} %>
                </td>
                <td align="right"><s:text name="Town"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.Town" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.Town" disabled="true"/>
					</s:else>
					<%if (vo.getTown()!=null) { %>
					<%=vo.getTown() %>
					<%} %>
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="provtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.provtype" definition="$CH_PROVTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.provtype" definition="$CH_PROVTYPE" disabled="true"/>
					</s:else>
					<%if (vo.getProvtype()!=null) { %>
					<%=vo.getProvtype() %>
					<%} %>
                </td>
                <td align="right"><s:text name="Mobilemall"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.mobilemall" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.mobilemall" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<%if (vo.getMobilemall()!=null) { %>
					<%=vo.getMobilemall() %>
					<%} %>
                </td>
            </tr>
            
            <tr>
            <td align="right"><s:text name="frontarea"/>:&nbsp</td>
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
				<%if (vo.getFrontarea()!=null) { %>
				<%=vo.getFrontarea() %>
				<%} %>
            </td>
            <td align="right"><s:text name="ispconntype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.ispconntype" definition="$CH_ISPCONNTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.ispconntype" definition="$CH_ISPCONNTYPE" disabled="true"/>
					</s:else>
					<%if (vo.getIspconntype()!=null) { %>
					<%=vo.getIspconntype() %>
					<%} %>
                </td>
            </tr>
            <tr>
               <td align="right"><s:text name="content"/>:&nbsp
               <s:hidden name="form.lastStepid" />
               <s:hidden name="form.hasRight" />
               </td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.content"  maxlength="512"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.content"  disabled="true"/>
					</s:else>
                </td>
                <s:if test="form.oprcode!='-1'" >
                 <td align="right"><s:text name="nextstepid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE && worktype!='WAY_ADD_AUDIT'">
						<s:if test="form.worktype!='WAY_ADD_AUDIT'">
							<s:textfield name="form.oprcode" readonly="true"/>
						<input type="button" name="form.oprcode_button" class="picker_button" value="..." onclick="getValue()" />
						</s:if>
						<s:else>
							<j:selector definition="#OPERATOR" name="form.oprcode" condition='region:${dBAccessUser.hwcityid };_ne_status:1' />
						</s:else>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.oprcode" disabled="true"/>
					</s:else>
                </td>
                </s:if>
                <s:else>
                	<td colspan="2">&nbsp;</td>
                	<s:hidden name="form.oprcode"/>
                </s:else>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<j:purChk permid="<%=ID_AUDIT%>" disableChild="true">
                	<input type="button" id="btn" name="btnPass" class="button_Save" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="pass"/>" onclick="doSave('PASS');" 
                           <s:if test="form.auditstatus_work!=0 or CMD == WEB_CMD_SAVE">disabled = "true"</s:if>  
                           />
                    <input type="button" id="btn" name="btnRefuse" class="button_Save" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="refuse"/>" onclick="doSave('CANCEL')"
                           <s:if test="form.auditstatus_work!=0 or CMD == WEB_CMD_SAVE">disabled = "true"</s:if> 
                           />
                     </j:purChk>
                   	<s:i18n name="public">
                   	<j:purChk permid="<%=ID_AUDIT%>" disableChild="true">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('SAVE');"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/auditwork_list2.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
