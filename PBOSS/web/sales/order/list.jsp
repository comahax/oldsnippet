<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
     <script type="text/javascript" src="/js/pub/json2.js"></script>
    <script language="javascript" src="<%=contextPath%>/js/pub/LodopFuncs.js"></script>
		<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
			
		</object>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
            addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
            addfield('param._se_orderave', '<s:text name="orderave"/>', 'c', true, '16');
            addfield('param._dnm_createtime', '<s:text name="_dnm_createtime"/>', 'dt', true, '7');
            addfield('param._dnl_createtime', '<s:text name="_dnl_createtime"/>', 'dt', true, '7');
            addfield('param._se_orderstate', '<s:text name="orderstate"/>', 'c', true, '16');
            addfield('param._se_alarmlevel', '<s:text name="_se_alarmlevel"/>', 'c', true, '16');
             addfield('param._ne_confirmflag', '<s:text name="_ne_confirmflag"/>', 'i', true, '4');
            addfield('param._se_mareacode', '<s:text name="_se_mareacode"/>', 'c', true, '14');
            addfield('param._se_comcategory', '<s:text name="comcategory"/>', 'c', true, '14');
            return (checkval(window) && compareDate());
        }
        
        //	当前工号有该令牌，可见
        function showOrDisabledDoReview(){
        	if(document.getElementById('buttonBatchReview').disabled){//不可用（用户无令牌）
	        	document.getElementById('buttonBatchReview').style.display = "none";
        	}else{
        		document.getElementById('buttonBatchReview').style.display = "";
        	}
        }
        
        function compareDate(){
	        var startTime = document.getElementById('param._dnl_createtime').value;
	        var endTime = document.getElementById('param._dnm_createtime').value;
	        
	        var paystartTime = document.getElementById('param._dnl_paytime').value;
	        var payendTime = document.getElementById('param._dnm_paytime').value;

	        if(startTime != '' && endTime != '' &&  startTime>endTime){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_createtime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_createtime"/>]</span>';
			errorMessageShow(alertstr);
	        return false;
	       }
	       
	        if(paystartTime != '' && payendTime != '' &&  paystartTime>payendTime){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnl_paytime"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="_dnm_paytime"/>]</span>';
			errorMessageShow(alertstr);
	        return false;
	       }
        	return true;	
        }
      //批量审核通过
     function  doAppPass(){
     	var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
		if(checkedBoxs.length==0){
			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择要审核通过的订单]</span>';
			errorMessageShow(alertstr);
			return false;
		}
		var orderids="";
		checkedBoxs.each(function(i) {
			var key=jQuery(this).val().split("|");
			if(orderids=="")
				orderids=key[0];
			else
				orderids+=","+key[0]
		});
     	if($(":hidden[name='form.param44']").val()=='1'){
			var returnValue=window.showModalDialog('<%=contextPath %>/sales/order_batchAppPassStockInfo.do?orderids='+orderids,window,"dialogWidth=800px;dialogHeight=600px;status:no;scroll=yes;");
			if(returnValue!=undefined){
				formList.action="<%=contextPath%>/sales/order_batchAppPass.do";
       			formList.submit();
			}
		}else{
     		formList.action="<%=contextPath%>/sales/order_batchAppPass.do";
        	formList.submit();
        }
     }
      //作废操作  
      function doRemove(actionUrl){
        var objArray= document.getElementsByName('param._selectitem');
        var issubmit=false;
        var selectitems = '?1=1';
	        for(var i = 0;i<objArray.length;i++){
		        var e = objArray[i];
	                if (e.type == 'checkbox') {
	                    if (e.checked){
	                    	issubmit=true;
		                    var valueArray = e.value.split('|');
		                    	if('CANCEL' == valueArray[1] || 'FINISHED' == valueArray[1]){//。对于订单状态为“已完成”或“作废”的订单不允许作废操作。
		                    		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[ 对于订单状态为“已完成”或“作废”的订单不允许作废操作 ]</span>';
									errorMessageShow(alertstr);
									return false;
		                    	}
		                    selectitems += '&param._selectitem='+valueArray[0];
	                    }     
	                }
	        }
	        if(issubmit){
	        window.showModalDialog(actionUrl+selectitems,window,'"dialogWidth:600px; dialogHeight:200px; status:no;resizable:yes;"');
	        
		    }else{
		    	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择要作废的订单]</span>';
				errorMessageShow(alertstr);
				return false;
		    }
	     }
	     
	     //订单下一步处理
	     function doNext(actionUrl){
	     	var orderid;//选中的订单步骤编号
	       var count = 0;//选中项计数
	       	var sis = document.getElementsByName("param._selectitem");
	           for (var i = 0; i < sis.length; i++) {
	               var e = sis[i];
	               if (e.type == 'checkbox') {
	                   if (e.checked){
	                       	orderid = e.value;
	                       	count++;
	                       	if(count>1)
	                       	{
	                       		//var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>下一步处理只能选择一项</span> ';
								//errorMessageShow(alertstr);
								var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
								var selectitems="";
								checkedBoxs.each(function(i) {
									var key=jQuery(this).val().split("|");
									if(selectitems=="")
										selectitems=key[0];
									else
										selectitems+="|"+key[0]
								});
								var url="<%=contextPath%>" + "/sales/order_nextBatchProcess.do?selectitems="+selectitems;
								var rtn=window.showModalDialog(url , null, "dialogWidth:600px; dialogHeight:450px; status:no; resizable:yes;");
	                       		return false;
	                       	}
	                    }
	               }
	           }
	           if(count<1){
	           var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择修改项</span> ';
				errorMessageShow(alertstr);
				return false;
			}
			
			orderid = orderid.split('|')[0];
			//formList.action="<%=contextPath%>"+actionUrl+"?form.orderid="+orderid;
			//formList.submit();
			
			$.post("<%=contextPath%>"+actionUrl,
	        {'form.orderid':orderid},
			     function(data){
			     var result = data.split(',');
			     if('0' == result[0]){
			     window.location.href ="<%=contextPath%>"+result[1]+"?param._pk="+orderid+"&param._se_orderid="+orderid;
			     	//window.open(result[1]+"?param._pk="+orderid+"&param._se_orderid="+orderid);
			     }else{
				     var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>'+result[1]+'</span> ';
					errorMessageShow(alertstr);
			     }
			       
			     }   
	        );
	         
	     }
	     
	     
	     function goToView(pk){
        var form=document.forms[0];
		form.action="<%=contextPath%>/sales/orderlineframe.jsp?pk="+str;
		form.submit();
		}
		
		 function doExcel(){
        	formList.action="<%=contextPath%>/sales/order_excel.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/order_list.do";
        }
        
        
		 function doExcelRes(){
        	formList.action="<%=contextPath%>/sales/order_excelRes.do";
        	formList.submit();
        	formList.action="<%=contextPath%>/sales/order_list.do";
        }
        
        
        
        function doSecondConfirm(actionUrl){
           if(window.confirm("您要重新发送订购确认短信？请确认。")){
		        var objArray= document.getElementsByName('param._selectitem');
			        var issubmit=false;
			        for(var i = 0;i<objArray.length;i++){
				        var e = objArray[i];
			                if (e.type == 'checkbox') {
			                    if (e.checked){
			                    	issubmit=true;
				                    var valueArray = e.value.split('|');
				                    	if('WAITCON' != valueArray[1] ){//只有待确认状态允许重发订购确认短信
				                    		var alertstr = "<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[ 订单["+valueArray[0]+"]状态错误，只有待确认状态允许重发订购确认短信，请检查。 ]</span>";
											errorMessageShow(alertstr);
											return false;
				                    	}
			                    }     
			                }
			        }
				       
			     if(issubmit){
			        formList.action=actionUrl;
			        formList.submit();
			     }else{
			    	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择要重发订购确认的订单]</span>';
					errorMessageShow(alertstr);
					return false;
			     }
		   }
	     }
	     
	     function putCountyID(countyid){
	     document.getElementById('countyid').value=countyid;
	     }
	     
	     function opendMareacode(aObj,formWhere){
		     var countyid = document.getElementById('countyid').value;
		     if(countyid == ''){
			     openPicker(aObj,formWhere);
		     }else{
			     openPicker(aObj,formWhere,null,'boss.cms.microarea.queryBycountyid','COUNTYID:'+countyid);
		    }
	     }
	     /*
	     *提交审核
	     */
	     function doAudit(){
	     	var checkedBoxs=$(":checkbox[name='param._selectitem']:checked");
			if(checkedBoxs.length==0){
				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[请选择要提交审核的订单]</span>';
				errorMessageShow(alertstr);
				return false;
			}
			var selectitems="";
			checkedBoxs.each(function(i) {
				var key=jQuery(this).val().split("|");
				if(selectitems=="")
					selectitems=key[0];
				else
					selectitems+="|"+key[0]
			});
			var status=false;
			jQuery.ajax({
				type:"POST",
				url:"<%=contextPath %>/sales/audit_checkAudit.do",
				async:false, //同步
				data:"selectitems="+selectitems,			
				success:function(msg){
					if(msg=='yes'){
						status=true;
					}else{
						var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>'+msg+'</span>';
						errorMessageShow(alertstr);
						status= false;
					}
				}
			});
			if(status==true){
		     	var returnValue=getAuditingRoleList();
		     	if(returnValue!=undefined){
		     		var strs=returnValue.split(",");
		     		$("#buttonAudit").attr("disabled","true");
		     		formList.action="<%=contextPath%>/sales/order_batchSubmitAudit.do?operid="+strs[0];
        			formList.submit();
		     	}
			}
	     }
	     //审批人弹出框
	     function getAuditingRoleList(){
	     	var returnValue=window.showModalDialog('<%=contextPath %>/base/operator_auditingRoleList.do',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		    if(returnValue!=undefined){
		    	return returnValue;
			}
	     }
	    //触发划扣
		function doDeduct(){
	    	var valueArray;
	    	var orderid;//选中的订单编号
	 	    var count = 0;//选中项计数
	 	    var paytype;//缴费方式
	 	    var deductstate;//划扣状态
	 	    var sis = document.getElementsByName("param._selectitem");
	 	    for (var i = 0; i < sis.length; i++) {
	 	    	var e = sis[i];
	 	     	if (e.type == 'checkbox') {
	 	        	if (e.checked){
	 	        		valueArray = e.value.split('|');
	 	              	count++;
	 	                if(count>1)
	 	                {
	 	                 	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>银行划扣不支持多选，请每次操作选择一条记录</span> ';
	 						errorMessageShow(alertstr);
	 	                    return false;
	 	                }
	 	           	}
				}
			}
	 	    if(count<1){
				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择要操作的记录(只能一项)</span> ';
				errorMessageShow(alertstr);
				return false;
			}
	 	    if(window.confirm("您要触发该订单的银行划扣？请确认。")){
	 	   		orderid = valueArray[0];
	 	  		paytype = valueArray[2];
	 	 		deductstate = valueArray[3];
	 			if('BANK' != paytype ){
    				var alertstr = "<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[ 缴费方式错误，请检查。]</span>";
					errorMessageShow(alertstr);
					return false;
    			}
	 			if('SUCCESS' == deductstate ){
    				var alertstr = "<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[ 订单划扣状态错误，请检查。]</span>";
					errorMessageShow(alertstr);
					return false;
    			}
	 			formList.action="<%=contextPath%>/sales/order_deduct.do?orderid="+orderid;
    			formList.submit();
	 		}
		}
		//批量复核
		function doBatchReview(){
	    	var valueArray;
	    	var orderid = "";//选中的订单编号
	 	    var count = 0;//选中项计数
	 	    var sis = document.getElementsByName("param._selectitem");
	 	    var allMsg = "";
	 	    for (var i = 0; i < sis.length; i++) {
	 	    	var e = sis[i];
	 	     	if (e.type == 'checkbox') {
	 	        	if (e.checked){
	 	        		valueArray = e.value.split('|');
	 	              	count++;
	 	              	
	 	              	var t1 = valueArray[1];
	 	              	orderid = orderid + valueArray[0] + "|";
	 	              	var reviewstate = valueArray[4];
	 	              	if(t1 != 'FINISHED'){
	 	              		//alert("订单["+valueArray[0]+"]未完成");
	 	              		//return false;
	 	              		allMsg = allMsg + "订单["+valueArray[0]+"]未完成" + "\n";
	 	              	}
	 	                if(reviewstate == 1){
	 	              		//alert("订单["+valueArray[0]+"]已复核");
	 	              		//return false;
	 	              		allMsg = allMsg + "订单["+valueArray[0]+"]已复核" + "\n";
	 	              	}
	 	           	}
				}
			}
			if(allMsg != ""){
				alert(allMsg);
				return false;	
			}
	 	    if(count<1){
				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择要操作的记录</span> ';
				errorMessageShow(alertstr);
				return false;
			}
	 	    if(window.confirm("您要批量复核？请确认。")){
	 			formList.action="<%=contextPath%>/sales/order_batchReview.do?orderid="+orderid;
    			formList.submit();
	 		}
		}
		function openPicker(control,definition,condition) {
        	if(control.name.indexOf('param._se_mareacode') > -1 ) {
                if(document.all('param._se_countyid').value == "") {
                	// 选择“微区域编码”前要先指定 “分公司”  这是一个跨级的查询
                    alert("请先输入分公司");
                    return;
                }else {
                    // 查询指定 “分公司”下的“微区域编码”
                    //condition = '_se_countyid:' + document.all('param._se_countyid').value;
                    condition = '';
                }
                
            }
            
            if(definition == null || definition =="") {	  	    			
    	   		alert("definition is required!");
    	   		return ;
    	    }
    	    
    	    definition = window.encodeURIComponent(definition);	    
    	    var url = contextPath +"/common/picker_list.do?definition=" + definition;
    	    
    	    // 对微区域查询时使用命名查询
    	    if (control.name.indexOf('param._se_mareacode') > -1) {
    	    
	    	    var sqlName = window.encodeURIComponent("boss.cms.microarea.queryBycountyid");
	    	    var url = url + "&sqlName=" + sqlName;
	    	    
	    	    // 查询参数使用分公司ID
	    	    var mapParam = window.encodeURIComponent("COUNTYID:" + document.all('param._se_countyid').value);
	    	    var url = url + "&mapParam=" + mapParam;
    	    }

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
    
    <script language="javascript"> 
	var LODOP; //声明为全局变量
		
	function dealStatus(statuscode,orderid){
		var code = LODOP.GET_VALUE('PRINT_STATUS_OK',statuscode);
		var code2 = LODOP.GET_VALUE('PRINT_STATUS_ID',statuscode);
		
		if(code == 0){//成功
		//增加js方法
		jQuery.ajax({
					type:"POST",
					url:"<%=contextPath %>/sales/order_updatePrintCount.do",
					async:false, //同u27493 
					data:"orderid="+orderid,			
					success:function(msg){
					}
				});
			alert("打印完成!");
		}
	}	
	
	function myDesignBusiness() {	
			var valueArray;
	 	    var count = 0;//选中项计数
	 	    var sis = document.getElementsByName("param._selectitem");
	 	    for (var i = 0; i < sis.length; i++) {
	 	    	var e = sis[i];
	 	     	if (e.type == 'checkbox') {
	 	        	if (e.checked){
	 	        		valueArray = e.value.split('|');
	 	              	count++;
	 	                if(count>1)
	 	                {
	 	                 	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>业务单打印不支持多选，请每次操作选择一条记录</span> ';
	 						errorMessageShow(alertstr);
	 	                    return false;
	 	                }
	 	           	}
				}
			}
	 	    if(count<1){
				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择要操作的记录(只能一项)</span> ';
				errorMessageShow(alertstr);
				return false;
			}
		if(confirm("请确认纸张地否已经正确放入打印机!")){
			var orderid = valueArray[0];
		//增加js方法
		jQuery.ajax({
					type:"POST",
					url:"<%=contextPath %>/sales/order_ajaxPrintBusiness.do",
					async:false, //同u27493 
					data:"orderid="+orderid,			
					success:function(msg){
					var myE = eval(msg); 
						CreatePrintPageBusiness(myE);
					}
				});
			LODOP.SET_PRINT_MODE("CATCH_PRINT_STATUS",true);
			var statuscode = LODOP.PRINT();
			dealStatus(statuscode,orderid);
			}
	};
	

	
	function CreatePrintPageBusiness(msg) {
		LODOP=getLodop(document.getElementById('LODOP_OB'),null);  
		LODOP.SET_LICENSES("广东移动","849716019056235623847190847152","","");
		LODOP.PRINT_INIT("协议书打印");
		LODOP.ADD_PRINT_TEXT(126,50,253,20,msg[0].wayname);
		LODOP.ADD_PRINT_TEXT(126,356,145,20,msg[0].wayid);
		LODOP.ADD_PRINT_HTM(234,95,625,146,msg[0].content);
		LODOP.ADD_PRINT_TEXT(419,219,100,14,msg[0].lowerprice);
		LODOP.ADD_PRINT_TEXT(392,222,18,20,msg[0].shiwan);
		LODOP.ADD_PRINT_TEXT(392,255,18,20,msg[0].wan);
		LODOP.ADD_PRINT_TEXT(392,288,18,20,msg[0].qian);
		LODOP.ADD_PRINT_TEXT(392,320,18,20,msg[0].bai);
		LODOP.ADD_PRINT_TEXT(392,387,18,20,msg[0].yuan);
		LODOP.ADD_PRINT_TEXT(392,421,18,20,msg[0].jiao);
		LODOP.ADD_PRINT_TEXT(392,452,18,20,msg[0].fen);
		LODOP.ADD_PRINT_TEXT(392,354,18,20,msg[0].shiyuan);
	};	
</script>
    
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">

<div class="table_container">
<s:form action="order_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" id ="countyid" value='<s:property value="param._se_countyid"/>'/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    <s:hidden name="form.param44"/>
    <s:hidden name="form.firstDisplay"/>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
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
                <td align="center"><s:text name="orderid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_orderid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                	  <s:textfield cssStyle="style_input" name="param._se_wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_wayid',null,null,'AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="discomcode"/>:</td>
                <td align="left">
                	<j:selector definition="#WAYIDINFO" condition="cityid:${USER.cityid};waytype:AG;waysubtype:LOGS" name="param._se_discomcode" />
                    
                </td>
              </tr>
              <tr>  
              	<td align="center"><s:text name="orderstate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_ORDERFSTATE" name="param._se_orderstate"/>
                </td>
                <td align="center"><s:text name="_dnl_createtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_createtime" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="_dnm_createtime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_createtime" onclick="selectDatetime();"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="deductstate"/>:</td>
                <td align="left">
                   <j:selector definition="$FX_DEDUCTSTATE" name="param._se_deductstate"/>
                </td>
               <td align="center"><s:text name="_dnl_paytime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_paytime" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="_dnm_paytime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_paytime" onclick="selectDatetime();"/>
                </td>
            </tr>
             <tr>
              	<td align="center"><s:text name="orderave"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_ORDERAVE" name="param._se_orderave"/>
                </td>
               <td align="center"><s:text name="paytype"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_PAYTYPE" name="param._se_paytype"/>
                </td>
                <td align="center"><s:text name="_se_alarmlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_STOCKALARMLEVEL" name="param._se_alarmlevel"/>
                </td>
            </tr>
            <tr>
            	 <td align="center"><s:text name="countyid"/></td>
                <td align="left">
                <j:purChk permid="FX_ORDERMG_CITY"> 
                   <j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector" onchange="putCountyID(this.value);"/>
                </j:purChk>
                </td>
                <td align="center"><s:text name="_se_mareacode"/>:</td>
                <td align="left">
                    <s:textfield styleId="order_list_do_param__se_mareacode_text" name="param._se_mareacode" readonly="true"/>
						<INPUT class="picker_button" onclick="javascript:opendMareacode(this,'#MICROAREA'); " type="button" value="..." name="param._se_mareacode_button"/> 
                </td>
               <td align="center"><s:text name="_ne_confirmflag"/>:</td>
                <td align="left">
                    <j:selector definition="$IM_YESNO10" name="param._ne_confirmflag"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="signstate"/>:</td>
                <td align="left">
                    <j:selector definition="$FX_SIGNSTATE" name="param._se_signstate"/>
                </td>
                <td align="center"><s:text name="recordtime"/>&gt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_recordtime" onclick="selectDatetime();"/>
                </td>
                <td align="center"><s:text name="recordtime"/>&lt;=:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_recordtime" onclick="selectDatetime();"/>
                </td>
            </tr>
            <tr>
            	<td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector definition="$CH_STARLEVEL" name="param._ne_starlevel"/>
                </td>
               <td align="center"><s:text name="comcategory"/>:</td>
                <td align="left">
                    <j:selector definition="$IM_FXCOMCATEGORY" name="param._se_comcategory" mode="picker"/>
                </td>
                <td>&nbsp;</td><td>&nbsp;</td>
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/order_list.do');">
                	
                	<input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_exportexcel"/>" onClick="doExcel()">
                        
                  <j:purChk permid="FX_ORDERMGR_COMEXP">
                    	<input type="button" id="btnExportexcel2" name="btnExportexcel2" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="导出统计信息" onClick="doExcelRes()">
                 </j:purChk>
                        
                    <j:purChk permid="FX_ORDERMG_NEXTSTEP">
                    <input type="button" id="btnNew" name="btnNew" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="下一步处理" onClick="doNext('/sales/order_nextProcess.do')">
                    </j:purChk>
                     <j:purChk permid="FX_ORDERMG_CANCEL">
                    <input type="button" id="btnDelete" name="btnDelete" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="订单作废" onClick="doRemove('/sales/order_goRemove.do')">
                     </j:purChk>
                    <input type="button" id="btnSecondConfirm" name="btnSecondConfirm" class="button_6" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="重发订购确认" onClick="doSecondConfirm('/sales/order_secondConfirm.do')">
                    <j:purChk permid="FX_ORDERMGR_SMT">
                    <input type="button" id="buttonAudit" name="buttonAudit" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="提交审核" onclick="doAudit()" />
	               	</j:purChk>
                    <j:purChk permid="FX_ORDERMGR_AUDIT">
                    <input type="button" id="buttonApp" name="buttonApp" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<s:text name="button_appPass"/>" onclick="doAppPass()" />
	                </j:purChk>
	                <j:purChk permid="FX_ORDERMGR_DEDUCT">
                    <input type="button" id="buttonDeduct" name="buttonDeduct" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="触发划扣" onclick="doDeduct()" />
	               </j:purChk>
	               <j:purChk permid="FX_ORDERMG_REVIEW">
                    <input type="button" id="buttonBatchReview" name="buttonBatchReview" class="button_4" onmouseover="buttonover(this);" 
	                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="批量复核" onclick="doBatchReview()" />
	               </j:purChk>
	               
	               
	               <j:purChk permid="FX_ACCEPFORMPRINT" disableChild="false">
	                <input type="button" id="btnSave" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
		                   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                   value="业务单打印" onclick="myDesignBusiness();"/>
	                </j:purChk>
	                <j:purChk permid="FX_BATCH_EXP" disableChild="false">
	                <input type="button" id="btnExportbatch" name="btnExportbatch" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="批量导出" onClick="location.href='<%=contextPath%>/sales/order/batchexport.jsp'">
                    </j:purChk>
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
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderid')"><s:text name="orderid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')">合作商名称</j:orderByImg>               
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="countyid"/></j:orderByImg>               
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('mareacode')"><s:text name="_se_mareacode"/></j:orderByImg>               
                </td>
                <td>
					<j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderave')"><s:text name="orderave"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('orderstate')"><s:text name="orderstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('reviewstate')"><s:text name="reviewstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bossworkfid')"><s:text name="crmstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paytype')"><s:text name="paytype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recamt')"><s:text name="recamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actamt')"><s:text name="actamt"/></j:orderByImg>                 
                </td>
                
				<td>
                    <j:orderByImg href="javascript:doOrderby('paytime')"><s:text name="paytime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('recordtime')"><s:text name="recordtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('deductstate')"><s:text name="deductstate"/></j:orderByImg>                 
                </td>
                <td>
                    <s:text name="orderinfo"/>               
                </td>
                <td>
                    <s:text name="brandinfo"/>               
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('discomcode')"><s:text name="discomcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('disovertime')"><s:text name="disovertime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('alarmlevel')"><s:text name="_se_alarmlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('confirmflag')"><s:text name="_ne_confirmflag"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signstate')"><s:text name="signstate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('signtime')"><s:text name="signtime"/></j:orderByImg>                 
                </td>
                <td>
                	<j:orderByImg href="javascript:doOrderby('signtype')"><s:text name="signtype"/></j:orderByImg>
                </td>
                <td>
                	<j:orderByImg href="javascript:doOrderby('smssignno')"><s:text name="smssignno"/></j:orderByImg>
                </td>
            </tr>
            <s:iterator value="dp.datas">
            	<s:if test="'CANCEL' eq orderstate">
            		<tr class="table_style_content2" align="center" bgColor="#666666" >
            	</s:if>
            	<s:else>
            		<s:if test="'REDALARM' eq alarmlevel">
            			<tr class="table_style_content2" align="center" bgColor="#CC3300" >
            		</s:if>
            		<s:elseif test="'YELALARM' eq alarmlevel">
            			<tr class="table_style_content" align="center" bgColor="#FFFF00" >
            		</s:elseif>
            		<s:else>
            			<tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
            		</s:else>
                </s:else>
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="orderid"/>|<s:property value="orderstate"/>|<s:property value="paytype"/>|<s:property value="deductstate"/>|<s:property value="reviewstate"/>" onclick="checkOne();">
                     </td>
                     <td style="word-break: keep-all">
                     <a href="sales/orderlineframe.jsp?param._pk=<s:property value="orderid"/>">
							<s:property value="orderid"/>
                         </a>
					 </td>
					 <td><s:property value="wayid"/></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel"/></td>
                     <td><j:code2Name definition="$FX_ORDERAVE" code="orderave"/></td>
                     <td><s:date name="createtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="$FX_ORDERFSTATE" code="orderstate"/></td>
                     <td><j:code2Name definition="$FX_REVIEWSTATE" code="reviewstate"/></td>
                     <td><s:property value="crmstate"/></td>
                     <td><j:code2Name definition="$FX_PAYTYPE" code="paytype"/></td>
                     <s:i18n name="public">
                     <td>
                      <s:property value="%{getText('format.double',{recamt})}" />
                     </td>
                     <td>
                     <s:property value="%{getText('format.double',{actamt})}" />
                     </td>
                     </s:i18n>
                     <td><s:date name="paytime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:date name="recordtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="$FX_DEDUCTSTATE" code="deductstate"/></td>
                     <td><s:property value="orderInfo"/></td>
                     <td><s:property value="brandInfo"/></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="discomcode"/></td>
                     <td><s:date name="disovertime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="$FX_STOCKALARMLEVEL" code="alarmlevel"/></td>
                     <td><j:code2Name definition="$IM_YESNO10" code="confirmflag"/></td>
                     <td><j:code2Name definition="$FX_SIGNSTATE" code="signstate"/></td>
                     <td><s:date name="signtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><j:code2Name definition="$FX_SIGNTYPE" code="signtype"/></td>
                     <td><s:property value="smssignno"/></td>
                 </tr>
             </s:iterator>
            
             <!-- 添加汇总信息 -->
             <s:if test="form.allbrand != null">
             <tr class="table_style_content">
             	<td colspan="2" align="center">本页汇总</td>
             	<td colspan="2" align="center">实收总金额：<s:property value="%{getText('format.double',{form.allactamt})}"/> &nbsp;元</td>
             	<td colspan="12" text-align="left"><s:property value="form.allbrand"/></td>
             </tr>
             </s:if>
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
	showOrDisabledDoReview();
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery");
	</script>
</body>
</html>
