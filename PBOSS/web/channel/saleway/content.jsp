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
            
            var nologiscode = document.all("form.cityid").value != 'JM';
            
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.shortname', '<s:text name="shortname"/>', 'c', true, 32);
			addfield('form.svbrchcode', '<s:text name="svbrchcode"/>', 'c', true, 14);
			addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
			addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', true, 14);
			addfield('form.buztypecode', '<s:text name="buztypecode"/>', 'f', false, 2);
			addfield('form.adtypecode', '<s:text name="adtypecode"/>', 'f', false, 2);
			addfield('form.address', '<s:text name="address"/>', 'c', false, 128);
			addfield('form.logiscode', '<s:text name="logiscode"/>', 'c', nologiscode, 18);
			addfield('form.latitude', '<s:text name="latitude"/>', 'd', false, 15, 6, null, 18, 26);
			addfield('form.longtitude', '<s:text name="longtitude"/>', 'd', false, 15, 6, null, 100, 130);
			addfield('form.adacode', '<s:text name="adacode"/>', 'c', true, 18);
			addfield('form.waymagcode', '<s:text name="waymagcode"/>', 'c', true, 18);
			addfield('form.catetype', '<s:text name="catetype"/>', 'f', true, 2);
			addfield('form.formtype', '<s:text name="formtype"/>', 'f', false, 2);
			
			var formtypecity=document.all('form.cityid').value;//地市
			var formtype=document.all('form.formtype').value;//业态类型
			if(formtypecity != 'ZJ'){
				if (formtype == '16') {
					alert('此【卖场加盟厅】业态类型为湛江地市专用，请选择其他业态类型');
	      			return false;
				}
			}
			
			addfield('form.starttime', '<s:text name="starttime"/>', 't', true, 7);
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
			addfield('form.isKzcz', '<s:text name="isKzcz"/>', 'i', false, 1);
			addfield('form.taxcertificate', '<s:text name="taxcertificate"/>', 'f', false, 3);
			addfield('form.creditlevel', '<s:text name="creditlevel"/>', 'f', false, 3);
			addfield('form.istop', '是否TOP网点', 'c', false, 1);
			
			var rewardkind=document.all('form.rewardkind').value;
			if(rewardkind == ''){
				alert('社会渠道类型，不能为空');
            	return false;
			}
			
			var buscno=document.all('form.buscno').value;//商圈编码
			if(buscno == ''){
				alert('商圈编码，不能为空');
	           	return false;
			}
			
			var starlevel=document.all('form.starlevel').value;
			if(rewardkind == '1')
            {//3G，商圈编码、连锁加盟渠道系数，星级只能为7
            	var wayattr=document.all('form.wayattr').value;//连锁加盟渠道属性            	
            	var waymod=document.all('form.waymod').value;//连锁加盟渠道系数
            	var city=document.all('form.cityid').value;//地市
            	if(wayattr == ''){
					alert('连锁加盟渠道属性，不能为空');
	            	return false;
				}
            	if(wayattr == 'A+1'){
                	//连锁渠道加盟属性为A+1（专营重要商圈）时，社会渠道类型必须为‘4G渠道’
					alert('连锁渠道加盟属性为A+1（专营重要商圈）时，社会渠道类型必须为‘4G渠道’');
	            	return false;
				}
				if(city != 'DG'){
					if(wayattr == '2Q' || wayattr == '3Q' || wayattr == '4Q' || wayattr == 'A3' || wayattr == 'B3' ||wayattr == 'C3'){
	                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
						alert('此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性');
		            	return false;
					}
				}
				if(waymod == ''){
					alert('连锁加盟渠道系数，不能为空');
	            	return false;
				}
            	
            	if(starlevel != '7'){
            		alert('社会渠道类型为3G渠道，星级必须为3G渠道专用星级，请检查');
            		return false;
            	}
            }else{//2G，星级不能为7
            	if(starlevel == '7'){
            		alert('社会渠道类型为2G渠道，星级不能为3G渠道专用星级，请检查');
            		return false;
            	}
            }
            
            if(rewardkind == '2')
            {//3G，商圈编码、连锁加盟渠道系数，星级只能为8
            	if(starlevel != '8'){
            		alert('社会渠道类型为连锁加盟渠道，星级必须为 8(连锁加盟渠道星级)，请检查');
            		return false;
            	}
            }else{//2G，星级不能为8
            	if(starlevel == '8'){
            		alert('社会渠道类型为2G、3G渠道，星级不能为8(连锁加盟渠道星级)，请检查');
            		return false;
            	}
            }

            if(rewardkind == '3')
            {//4G，商圈编码、连锁加盟渠道系数，星级只能为9
            	var wayattr=document.all('form.wayattr').value;//连锁加盟渠道属性            	
            	var waymod=document.all('form.waymod').value;//连锁加盟渠道系数
            	var city=document.all('form.cityid').value;//地市
            	if(wayattr == ''){
                	//社会渠道类型为‘4G渠道’时，‘连锁加盟渠道属性’必须为A+1（专营重要商圈）
					alert('连锁加盟渠道属性，不能为空');
	            	return false;
				}
            	if(city != 'DG'){
					if(wayattr == '2Q' || wayattr == '3Q' || wayattr == '4Q' || wayattr == 'A3' || wayattr == 'B3' ||wayattr == 'C3'){
	                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
						alert('此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性');
		            	return false;
					}
				}
            	//if(wayattr != 'A+1'){
                	//社会渠道类型为‘4G渠道’时，‘连锁加盟渠道属性’必须为A+1（专营重要商圈）
					//alert('社会渠道类型为4G渠道时，连锁加盟渠道属性必须为A+1（专营重要商圈）');
	            	//return false;
				//}
				if(waymod == ''){
					alert('连锁加盟渠道系数，不能为空');
	            	return false;
				}
            	
            	if(starlevel != '9'){
            		alert('星级必须为9（4G渠道专用星级）');
            		return false;
            	}
            }else{//社会渠道类型为2G渠道、3G渠道或连锁加盟渠道，星级不能为9（4G渠道专用星级）
            	if(starlevel == '9'){
            		alert('社会渠道类型为2G渠道、3G渠道或连锁加盟渠道，星级不能为9（4G渠道专用星级），请检查');
            		return false;
            	}
            }
			
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
            addfield('form.compactno', '<s:text name="compactno"/>', 'c', false, 40);
            addfield('form.compactname', '<s:text name="compactname"/>', 'c', false, 255);
            addfield('form.begintime', '<s:text name="begintime"/>', 't', false);
            addfield('form.cmpendtime', '<s:text name="cmpendtime"/>', 't', false);
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
            addfield('form.provtype', '<s:text name="provtype"/>', 'i', false, 2);
            addfield('form.Mobilemall', '<s:text name="Mobilemall"/>', 'i', true, 2);
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
     		if(codeCtrl!=null) {
     			if(rtn[0] == ""){
     				codeCtrl.value = "0000";
     			}
     		}
     		if(nameCtrl!=null) nameCtrl.value = rtn[1];   		
     	}
     	function doCheckUpper(obj)
     	{ 
     	    pshowSelectUpperway(obj,'form.upperwayid','','','AG|ET','DIS|GMPT|G100');
	     	if(obj.value == null || obj.value == ""){
        		return;
        	}
        	var url = contextPath+"/channel/saleway_Checkupperway.do";
        	formItem.action=url;
        	formItem.submit();
        	formItem.action = contextPath + "/cms/saleway_save.do";
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
			var obj = document.getElementById("form.waysubtype");
			if(oDiv == "1"){
				document.getElementById("g3_div1").style.display="";
				document.getElementById("g3_div2").style.display="";
				document.getElementById("g3_div3").style.display="";
				//document.getElementById('form.waysubtype').value="7";
			}else if(oDiv == "2"){
			
				document.getElementById("g3_div1").style.display="none";
				document.getElementById("g3_div2").style.display="none";
				document.getElementById("g3_div3").style.display="none";
				//document.getElementById('form.starlevel').value="8";
				
				//obj.options.length = 0;
            	//obj.options.add(new Option("",""));
            	//obj.options.add(new Option("连锁加盟渠道","JMQD"));
            	//obj.options[1].selected = true;
			}else if(oDiv == "3"){
				//4G渠道
				document.getElementById("g3_div1").style.display="";
				document.getElementById("g3_div2").style.display="";
				document.getElementById("g3_div3").style.display="";
				//document.getElementById('form.waysubtype').value="9";
			}else{
				document.getElementById("g3_div1").style.display="none";
				document.getElementById("g3_div2").style.display="none";
				document.getElementById("g3_div3").style.display="none";
				
			}
		}

     	/* start for BR201306180003_关于渠道子类别星级取值范围需求概要设计  by feng */
     	function changeWaysubtype(select){
            var starlevel = select.value;
            //alert(starlevel);
            var obj = document.getElementById("form.waysubtype");
             var rewardkind = document.getElementById("form.rewardkind");
            //alert(obj.selectedIndex);
            if(starlevel == "1" || starlevel == "2" || starlevel == "3"){
            	obj.options.length = 0;
            	obj.options.add(new Option("",""));
            	obj.options.add(new Option("特约代理点","SAGT"));
            	obj.options[1].selected = true;
            	
            	rewardkind.options.length = 0;
            	rewardkind.options.add(new Option("",""));
            	rewardkind.options.add(new Option("2G渠道","0"));
            	//rewardkind.options[1].selected = true;
            }else if(starlevel == "4" || starlevel == "5" || starlevel == "6" || starlevel == "60"){
            	obj.options.length = 0;
            	obj.options.add(new Option("",""));
            	obj.options.add(new Option("指定专营店","PSAL"));
            	obj.options[1].selected = true;
            	
            	rewardkind.options.length = 0;
            	rewardkind.options.add(new Option("",""));
            	rewardkind.options.add(new Option("2G渠道","0"));
            	//rewardkind.options[1].selected = true;
            	
            }else if(starlevel == "7"){
            	obj.options.length = 0;
            	obj.options.add(new Option("",""));
            	obj.options.add(new Option("指定专营店","PSAL"));
            	obj.options[1].selected = true;
            	
            	rewardkind.options.length = 0;
            	rewardkind.options.add(new Option("",""));
            	rewardkind.options.add(new Option("3G渠道","1"));
            	//rewardkind.options[1].selected = true;
            }else if(starlevel == "8"){
            	obj.options.length = 0;
            	obj.options.add(new Option("",""));
            	obj.options.add(new Option("连锁加盟渠道","JMQD"));
            	obj.options[1].selected = true;
            	
            	rewardkind.options.length = 0;
            	rewardkind.options.add(new Option("",""));
            	rewardkind.options.add(new Option("连锁加盟渠道","2"));
            	//rewardkind.options[1].selected = true;
            }else if(starlevel == "9"){
            	obj.options.length = 0;
            	obj.options.add(new Option("",""));
            	obj.options.add(new Option("指定专营店","PSAL"));
            	obj.options[1].selected = true;
            	
            	rewardkind.options.length = 0;
            	rewardkind.options.add(new Option("",""));
            	rewardkind.options.add(new Option("4G渠道","3"));
            	//rewardkind.options[1].selected = true;
            }else{
            	obj.options.length = 0;
            	obj.options.add(new Option("",""));
            	obj.options.add(new Option("特约代理点","SAGT"));
            	obj.options.add(new Option("指定专营店","PSAL"));
            	obj.options.add(new Option("FD服务店","FD"));
            	obj.options.add(new Option("FD连锁店","FDS"));
            	obj.options.add(new Option("虚拟渠道","VWAY"));
            	obj.options.add(new Option("连锁加盟渠道","JMQD"));
            	//obj.options[0].selected = true;
            	rewardkind.options.length = 0;
            	rewardkind.options.add(new Option("",""));
            	rewardkind.options.add(new Option("2G渠道","0"));
            	rewardkind.options.add(new Option("3G渠道","1"));
            	rewardkind.options.add(new Option("连锁加盟渠道","2"));
            	rewardkind.options.add(new Option("4G渠道","3"));
            }
     	}
     	
     	function filterStarLevel() {
     		 var obj = document.getElementById("form.starLevel");
     		var city=document.all('form.cityid').value;
     		
     		if (city != 'MM') {
     			for (var i = 0; i < obj.options.length; i++) {
     				if (obj.options[i].value == '60') {
     					obj.options.remove(i);
     					
     					break;
     				}
     				
     			}
     		}
     		
     	}
     	
     	/* end for BR201306180003_关于渠道子类别星级取值范围需求概要设计  by feng */
    </script>
</head>
<body  onload="displayMemo();">
<div class="table_container">
<s:form action="saleway_save.do" cssStyle="formList" key="formItem" enctype="multipart/form-data"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="flag"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="form.waylevel" />
    <s:hidden name="form.centerid" />
    <s:hidden name="hasFlag"/>
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
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:if test="hasFlag != 'false'">
						  <j:selector name="form.starlevel" definition="$CH_STARLEVEL" onchange="changeWaysubtype(this);" onclick="filterStarLevel();"/>
						</s:if>
						<s:else>
							<j:selector name="form.starlevel" definition="$CH_STARLEVEL" disabled="true"/>
						</s:else>
					</s:if>
					<s:else>
						<j:selector name="form.starlevel" definition="$CH_STARLEVEL" disabled="true"/>
					</s:else>
					<font color=red>*</font>
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
					<font color=red>*</font>
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
                </td>
                <td align="right"><s:text name="waysubtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="WAYSUBTYPE" name="form.waysubtype" onchange="changeRewardkind(this);"/>
					</s:if>
					<s:else>
						<j:selector definition="WAYSUBTYPE" name="form.waysubtype" disabled="true"/>
					</s:else>
					<font color=red>*</font>
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
                </td>
                <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.starttime" value="<s:property value="form.starttime!=null?getText('format.date',{form.starttime}):''"/>" onclick="selectDate();"/>
					</s:if>
					
					<s:else>
						<input class="style_input" name="form.starttime" value="<s:property value="form.starttime!=null?getText('format.date',{form.starttime}):''"/>" readonly="true"/>
					</s:else>
					
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
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
                <td align="right"><s:text name="bchlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.bchlevel" definition="$CH_BCHLEVEL" />
					</s:if>
					<s:else>
						<j:selector name="form.bchlevel" definition="$CH_BCHLEVEL" disabled="true"/>
					</s:else>
					<font color=red>*</font>
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
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waystate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector onchange="checkMemo();" name="form.waystate" definition="$CH_WAYSTATE" />
					</s:if>
					<s:else>
						<j:selector onchange="checkMemo();" name="form.waystate" definition="$CH_WAYSTATE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
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
					<s:if test="form.cityid == 'JM'">
						<font color=red>*</font>
					</s:if>
					
                </td>
            </tr>
            <tr id="memoDiv" style="display:none">
            	<td align="right">备注:&nbsp</td>
            	<td ><s:textfield cssStyle="style_input" name="memo" maxlength="256" /><font color=red>*</font></td>
            	<td align="right"></td>
            	<td align="right"></td>
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
                </td>
                <td align="right"><s:text name="provcode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.provcode" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.provcode" disabled="true"/>
					</s:else>
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
                </td>
                <td align="right"><s:text name="custtype"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CUSTWAYTYPE"  name="form.custtype" condition="citycompid:${dBAccessUser.cityid};_sne_custwaytypecode:${'ALL'}" cssStyle="style_input"  mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="#CUSTWAYTYPE"  name="form.custtype" condition="citycompid:${dBAccessUser.cityid}" cssStyle="style_input"  mode="selector" disabled="true"/>
					</s:else>
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
                </td>
                <td align="right"><s:text name="secondsur"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.sublayer" definition="$CH_CONNECTTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.sublayer" definition="$CH_CONNECTTYPE"  disabled="true"/>
					</s:else>
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
                </td>
                <td align="right">是否授权网点</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.checked" definition="$CH_YESNO"/>
					</s:if>
					<s:else>
						<j:selector name="form.checked" definition="$CH_YESNO" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
            	<td align="right">是否接入空中充值平台</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.isKzcz" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.isKzcz" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<font color=red>*</font>
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
                </td>
            </tr>
            <tr>
                <td align="right">是否TOP网点：</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.istop" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.istop" definition="$IM_YESNO10"  disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="rewardkind" />：</td>
                <td align="left">
	                <s:if test="CMD != WEB_CMD_SAVE">
	                	<j:selector definition="$CH_REWARDKIND" name="form.rewardkind" 
	                	onchange="showdiv(this)"/>
                	</s:if>
					<s:else>
						<j:selector definition="$CH_REWARDKIND" name="form.rewardkind"  disabled="true"
	                	onchange="showdiv(this)"/>
					</s:else>
                	<font color=red>*</font>
                </td>
            </tr> 
            <tr>
                <td align="right"><s:text name="buscno" />：</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.buscno" mode="picker"
											condition="_se_cityid:${dBAccessUser.cityid }"
											definition="#CH_BUSICIRCLE" readonly="true"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.buscno" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="creditlevel" />：</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.creditlevel" definition="$CH_CREDITLEVEL"/>
					</s:if>
					<s:else>
						<j:selector name="form.creditlevel" definition="$CH_CREDITLEVEL" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>              
            
            <tr id="g3_div3" <s:if test="has3Gright == 'true'">style="display:none"</s:if>>
                <td align="right"><s:text name="waymod" />：</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.waymod" maxlength="6"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.waymod" maxlength="6" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right" id="g3_div1"  <s:if test="has3Gright == 'true'">style="display:none"</s:if>><s:text name="wayattr" />：</td>
                <td align="left" id="g3_div2" <s:if test="has3Gright == 'true'">style="display:none"</s:if>>
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.wayattr" definition="$CH_WAYATTR"/>
					</s:if>
					<s:else>
						<j:selector name="form.wayattr" definition="$CH_WAYATTR" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="taxcertificate" />：</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.taxcertificate" definition="$CH_TAXCERTIFICATE" />
					</s:if>
					<s:else>
						<j:selector name="form.taxcertificate" definition="$CH_TAXCERTIFICATE"  disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right">&nbsp;</td>
                <td align="left">&nbsp;</td>
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
                </td>
                <td align="right"><s:text name="principalemail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.principalemail" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.principalemail" disabled="true"/>
					</s:else>
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
                </td>
                <td align="right"><s:text name="recpers"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.recpers" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.recpers" disabled="true"/>
					</s:else>
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
                </td>
                <td align="right"><s:text name="reccertno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.reccertno" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.reccertno" disabled="true"/>
					</s:else>
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
				</td>
            </tr>
            <tr><td colspan="4"></td></tr>
            <tr>
                <td align="right"><s:text name="compactno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.compactno" maxlength="40"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.compactno" disabled="true"/>
					</s:else>
					<font color=red>*</font>
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
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cmpendtime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.cmpendtime" value="<s:property value="form.cmpendtime!=null?getText('format.date',{form.cmpendtime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.cmpendtime" value="<s:property value="form.cmpendtime!=null?getText('format.date',{form.cmpendtime}):''"/>" disabled="true"/>
					</s:else>
					<font color=red>*</font>
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
                </td>
                <td align="right"><s:text name="licenceno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.licenceno" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.licenceno" disabled="true"/>
					</s:else>
					
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
                </td>
                <td align="right"><s:text name="bailstatus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.bailstatus" definition="$CH_BAILSTATUS" />
					</s:if>
					<s:else>
						<j:selector name="form.bailstatus" definition="$CH_BAILSTATUS" disabled="true"/>
					</s:else>
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
                </td>
                <td align="right"><s:text name="destate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.destate" definition="$CH_VALIDFLAG" mode="selector"/>
					</s:if>
					<s:else>
						<j:selector name="form.destate" definition="$CH_VALIDFLAG" mode="selector" disabled="true"/>
					</s:else>
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
                </td>
                <td align="right"><s:text name="deacctname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.deacctname" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.deacctname" disabled="true"/>
					</s:else>
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
                </td>
                <td align="right"><s:text name="intime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.intime" value="<s:property value="form.intime!=null?getText('format.date',{form.intime}):''"/>" disabled="true"/>
					</s:else>
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
                </td>
                <td align="right"><s:text name="Town"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.Town" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.Town" disabled="true"/>
					</s:else>
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
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="Mobilemall"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.Mobilemall" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.Mobilemall" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
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
            </td>
            <td align="right"><s:text name="ispconntype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.ispconntype" definition="$CH_ISPCONNTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.ispconntype" definition="$CH_ISPCONNTYPE" disabled="true"/>
					</s:else>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <s:if test="flag == 'yes'">
                    	<j:purChk permid="<%=ID_1%>" disableChild="true">
	                    <input type="button" id="btnSave" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="提交申请" onclick="doSave('/channel/saleway_agapply.do')"
	                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
	                           />
	                    </j:purChk>
                    </s:if>
					<s:else>
						<j:purChk permid="<%=ID_1%>" disableChild="true">
	                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_save"/>" onclick="doSave('/channel/saleway_save.do')"
	                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
	                           />
	                    </j:purChk>
					</s:else>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/saleway_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
