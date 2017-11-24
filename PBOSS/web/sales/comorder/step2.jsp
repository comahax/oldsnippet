<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
	    <title><s:text name="titleList"/></title>
	    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
	    <script type="text/javascript" src="<%= contextPath %>/js/pub/list.js"></script>
	    <script language="JavaScript" type="text/JavaScript">
	        function ev_checkval() {
            	addfield('form.recid', '<s:text name="recid"/>', 'f', false, 14);
            	return checkval(window);
        	}
        	
        	function getOrderInfo()
        	{
        		$("#unitage").val("");
        		$("#unitprice").val("");
        		$("#orderamount").val("");
        		$("#form_unitprice").html("");
        		$("#form_unitage").html("");
        		$("#button_New").attr("disabled",true);
        		ajaxAnywhere.submitByURL(contextPath+"/sales/comorder_getOrderInfo.do");
        	}
        	function getOrderInfo1()
        	{
        		$("#unitage").val("");
        		$("#unitprice").val("");
        		$("#orderamount").val("");
        		$("#form_unitprice").html("");
        		$("#form_unitage").html("");
        		$("#button_New").attr("disabled",true);
        		ajaxAnywhere.submitByURL(contextPath+"/sales/comorder_getOrderInfo1.do");
        		AjaxAnywhere.prototype.onAfterResponseProcessing = getOrderInfo1After;
        		
        	}
        	
        	function getOrderInfo1After() {
				var form = this.findForm();
				var ajax = AjaxAnywhere.findInstance("default");
				if(typeof ajax.formURL != "undefined" && ajax.formURL != "" ) {
			    	form.action = ajax.formURL;
			    }
			     calOrderInfo1();
			};
        	
        	
        	
        	AjaxAnywhere.prototype.onAfterResponseProcessing = function () {
				var form = this.findForm();
				var ajax = AjaxAnywhere.findInstance("default");
				if(typeof ajax.formURL != "undefined" && ajax.formURL != "" ) {
			    	form.action = ajax.formURL;
			    }
			     $("#button_New").attr("disabled",false);
			};
			
			function calOrderInfo1()
        	{
        		 $("#button_New").attr("disabled",true);
        		ajaxAnywhere.submitByURL(contextPath+"/sales/comorder_calOrderInfo1.do");
        		AjaxAnywhere.prototype.onAfterResponseProcessing = calOrderInfo1After;
        	}
        	function calOrderInfo1After() {
				var form = this.findForm();
				var ajax = AjaxAnywhere.findInstance("default");
				if(typeof ajax.formURL != "undefined" && ajax.formURL != "" ) {
			    	form.action = ajax.formURL;
			    }
			     
			};
        	
        	
        	//增加订单
        	function orderAdd()
        	{
        		var orderamount = $("#orderamount").val();
        		var unitage = $("#unitage").val();
        		var comcategory = $("#comcategory").val();
        		var comcategoryStr = $("#comcategory_text").val();//mapSelect("comcategory",comcategory);
        		var unitprice = parseFloat($("#unitprice").val()).toFixed(2);
        		var mixOrder = $("#mixOrder").val();

        		if(null==orderamount || orderamount=="") {
        			alert("订购量不能为空");
        			return;
        		}
        		if(orderamount.length>8) {
        			alert("订购量长度不得超过8位");
        			return;
        		}
        		if (!unitprice || unitprice == null || unitprice == "" || unitprice == "NaN") {
        			alert("商品单价为空，请重新选择商品种类！");
        			return;
        		}
        		if (!unitage || unitage == null || unitage == "") {
        			alert("订购基数为空，请重新选择商品种类！");
        			return;
        		}
        		
        		if(mixOrder=="false"){//不允许订购混合订单
        			if($("#orderTable tr").length>2){
        				var comcate = $(".comc")[0].value;
        				//if(comcate!=comcategory){
        				//	alert("不能订购混合资源类别的订单");
        				//	return;
        				//}
        				
        				//不能使用POST，因为其是异步的，这里需同步
        				//$.post("<%=contextPath%>"+"/sales/comorder_checkRestypeEquality.do",
        				//	{'comcate1':comcate,'comcate2':comcategory},
        				//	function(data){
        				//	    alert(data)
        				//		if('YES'!=data){
        				//			alert("不能订购混合资源类别的订单");
        				//			return;
        				//		}
        				//	}
        				//);
        				var result = '';
        				jQuery.ajax({
							type:"POST",
							url:"<%=contextPath%>"+"/sales/comorder_checkRestypeEquality.do",
							async:false, //同步
							data:{'comcate1':comcate,'comcate2':comcategory},	
							success:function(msg){
								result=msg;
							}
						});
						if(result!='YES'){
							alert("不能订购混合资源类别的订单");
							return;
						}
        			}
        		}
        		
        		if(unitage!=null&&unitage!="0")
        		{
        			if(orderamount%unitage!=0)
	        		{
	        			alert("订购量必须是" + unitage + "的整数倍，请重新填写");
	        			return;
	        		}
        		}
        		
        		var flag = true;
        		$(".comc").each(function(i){
					if(comcategory==this.value)flag = false;
				});
        		if(!flag)
        		{
        			alert(comcategoryStr + "已经存在，不允许重复");
        			return;
        		}
        		
        		var trs = $("#orderTable tr");
        		var spePrice = $("#spePrice").val();
        		
        		var totalprice = parseFloat(parseFloat(unitprice) * parseFloat(orderamount)).toFixed(2);
        		var str = "";
        		if(spePrice == 'SALEPLAN'){
        		var planCode = $("#planCode").val();
        		var planName = mapSelect("planCode",planCode);
        		str = '<tr><td><input type="checkbox" class="order" name="param._selectitem" onclick="checkOne();"></td>'
        			+ '<td align="center" class="indexTd">&nbsp;</td>'
        			+ '<td align="center"><input type="hidden" class="comorder comc" value="' + comcategory + '">' + comcategoryStr + '</td>'
        			+ '<td align="center"><input type="hidden" class="comorder amount" value="' + orderamount + '">' + orderamount + '</td>'
        			+ '<td align="center"><input type="hidden" class="comorder planCode" value="' + planCode + '">' + planName + '</td>'
        			+ '<td align="center"><input type="hidden" class="comorder" value="' + unitprice + '">' + unitprice + '</td>'
        			+ '<td align="center"><input type="hidden" class="comorder price" value="' + totalprice + '">' + totalprice + '</td></tr>';
        		}else{
        		str = '<tr><td><input type="checkbox" class="order" name="param._selectitem" onclick="checkOne();"></td>'
        			+ '<td align="center" class="indexTd">&nbsp;</td>'
        			+ '<td align="center"><input type="hidden" class="comorder comc" value="' + comcategory + '">' + comcategoryStr + '</td>'
        			+ '<td align="center"><input type="hidden" class="comorder amount" value="' + orderamount + '">' + orderamount + '</td>'
        			+ '<td align="center"><input type="hidden" class="comorder" value="' + unitprice + '">' + unitprice + '</td>'
        			+ '<td align="center"><input type="hidden" class="comorder price" value="' + totalprice + '">' + totalprice + '</td></tr>';
        		}
        		
        		trs.eq(trs.length-1).before(str);
        		
        		//调整table
        		resetTable();
        	}
        	
        	//删除订单
        	function orderDel()
        	{
        		$(".order").each(function(i){
					if(this.checked)
					{
						$(this).parents("tr").eq(0).remove();
					}
				});
				//调整table
				resetTable();
        	}
        	
        	//增加删除项时调整table
        	function resetTable()
        	{
        		//调整序号
        		$(".indexTd").each(function(i){
					$(this).html(i+1);
				});
				
				//调整总套数
				var allamount = 0;
				$(".amount").each(function(i){
					allamount = allamount + parseInt($(this).val());
				});  
        		$("#allamountTd").html(allamount);
        		$("#allamount").val(allamount);
        		
        		
        		//调整总价格
        		var allprice = 0;
				$(".price").each(function(i){
					allprice = parseFloat(parseFloat(allprice) + parseFloat($(this).val())).toFixed(2);
				});  
        		$("#allpriceTd").html(allprice);
        		$("#allprice").val(allprice);
        	}
        	
			$(document).ready(function(){
	       		//双主键jop标签特殊处理，将代码转为值
	       		var str;
	       		str = mapSelect("cust",$("#cust").val());
	       		$("#custTd").append(str);
				$("#cust").remove();
				
				//月可订购量为负数时，显示0
				if($(".orderRemainMonthSpan").length>0)
				{
					var orderRemainMonth;
					$(".orderRemainMonthSpan").each(function(i){
						orderRemainMonth = $(this).html();
						if(parseInt(orderRemainMonth)<0)$(this).html("0");
					});
				}
				
				//日可订购量为负数时，显示0
				if($(".orderRemainDaySpan").length>0)
				{
					var orderRemainDay;
					$(".orderRemainDaySpan").each(function(i){
						orderRemainDay = $(this).html();
						if(parseInt(orderRemainDay)<0)$(this).html("0");
					});
				}
				
				//基准库存可订购量为负数时，显示0
				if($(".orderMaxSpan").length>0)
				{
					var orderMax;
					$(".orderMaxSpan").each(function(i){
						orderMax = $(this).html();
						if(parseInt(orderMax)<0)$(this).html("0");
					});
				}
				
				//订购列表商品种类编码转换
				var comcategoryStr = "";
				$(".comc").each(function(i){
					comcategoryStr = mapSelect("comcategory",this.value);
					$(this).after(comcategoryStr);
				});
				
				var planName = "";
				$(".planCode").each(function(i){
					planName = mapSelect("planCode",this.value);
					$(this).after(planName);
				});
				
				//激活率小数转换为百分数
				var rate = "";
				$(".rate").each(function(i){
					rate = parseFloat(this.value)*100 + "%";
					$(this).after(rate);
				});
				
				//调整table
				resetTable();
			}); 
				
			//从选择框的值获取选择的显示内容
			function mapSelect(objid,val)
			{
				var str = "";
				$("#"+objid).children().each(function(i){
					if(this.value == val)
					{
						str = this.innerText;
					}
				});
				return str;
			}
			
			function doStep3()
			{
				if($(".comorder").length==0)
				{
					alert("商品订购列表为空");
					return;
				}
				if(confirm("确认提交订购？"))
				{
					setComorderNames();
					$("#formList").attr("action","/sales/comorder_step3.do");
					$("#formList").submit();
				}
			}
			
			function setComorderNames()
			{
				var spePrice = $("#spePrice").val();
        		var j;
        		if(spePrice == 'SALEPLAN'){
        			$(".comorder").each(function(i){
						j=i/5;
						if(i%5==0)this.name = "form.comorderList[" + j + "].comcategory";
						if(i%5==1)this.name = "form.comorderList[" + j + "].orderamount";
						if(i%5==2)this.name = "form.comorderList[" + j + "].planCode";
						if(i%5==3)this.name = "form.comorderList[" + j + "].unitprice";
						if(i%5==4)this.name = "form.comorderList[" + j + "].totalprice";
					}); 
        		}else{
        			$(".comorder").each(function(i){
						j=i/4;
						if(i%4==0)this.name = "form.comorderList[" + j + "].comcategory";
						if(i%4==1)this.name = "form.comorderList[" + j + "].orderamount";
						if(i%4==2)this.name = "form.comorderList[" + j + "].unitprice";
						if(i%4==3)this.name = "form.comorderList[" + j + "].totalprice";
					}); 
        		
        		}				
			}
	    </script>
	</head>

	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="comorder_step3.do" id="formList" name="formItem" method="post" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_checkval();">
				<s:hidden name="form.wayid"/>
				<s:hidden name="form.wayname"/>
				<s:hidden name="form.cityid"/>
				<s:hidden name="form.countyid"/>
				<s:hidden name="form.paytype"/>
				<s:hidden name="form.custtype"/>
				<s:hidden name="form.starlevel"/>
				<s:hidden name="form.delitype"/>
				<s:hidden name="form.hint"/>
				<s:hidden name="form.mixOrderEnable" id="mixOrder"/>
				<s:hidden name="spePrice" id="spePrice"/>
				<s:hidden name="isurgent"/>
				
				<s:hidden name="form.allamount" id="allamount"/>
				<s:hidden name="form.allprice" id="allprice"/>
				
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
			                <td align="center" width="11%"><s:text name="wayid"/>：</td>
			                <td align="left" width="10%">
			                	<s:property value="form.wayid"/>
			                </td>
			                <td align="center" width="11%"><s:text name="wayname"/>：</td>
			                <td align="left" width="20%">
			                	<s:property value="form.wayname"/>
			                </td>
			                <td align="center" width="11%"><s:text name="custtype"/>：</td>
			                <td align="left" width="16%" id="custTd">
			                	<s:select name="form.custtype" id="cust" list="#request.custwaytypeList" theme="simple" headerKey="" headerValue="" listKey="custwaytypecode" listValue="custwaytypename" />
			                </td>
			                <td align="center" width="11%"><s:text name="starlevel"/>：</td>
			                <td align="left" width="10%">
			                	<j:code2Name definition="$CH_STARLEVEL" code="form.starlevel"/>
			                </td>
			            </tr>
			        </table>
			        
			        <table class="table_normal">
			        	<tr>
			                <td align="left" colspan="4"><s:text name="info1"/></td>
			            </tr>
			        	<tr>
			                <td align="center" width="25%"><s:text name="brand"/></td>
							<td align="center" width="25%"><s:text name="rate"/></td>
							<td align="center" width="25%"><s:text name="isachieve"/></td>
							<td align="center" width="25%"><s:text name="difamt"/></td>
			            </tr>
			            <s:iterator value="form.activeList" status="status">
			            	<tr>
								<td align="center"><j:code2Name definition="$FX_SMPBRAND" code="brand" /><s:hidden name="form.activeList[%{#status.index}].brand"/></td>
								<td align="center"><s:hidden cssClass="rate" name="form.activeList[%{#status.index}].rate"/></td>
								<td align="center"><j:code2Name definition="ISACHIEVE" code="isachieve"/><s:hidden name="form.activeList[%{#status.index}].isachieve"/></td>
								<td align="center"><s:property value="difamt"/><s:hidden name="form.activeList[%{#status.index}].difamt"/></td>
							</tr>
			            </s:iterator>
			        </table>
			        
			        <s:if test="form.orderMonthdayList.size()>0">
				        <table class="table_normal">
				        	<tr>
				                <td align="left" colspan="7"><s:text name="info2"/>&nbsp;<s:text name="unit"/></td>
				            </tr>
				        	<tr>
				        		<td align="center" width="16%"><s:text name="brand"/></td>
				                <td align="center" width="14%"><s:text name="orderMaxMonth"/></td>
								<td align="center" width="14%"><s:text name="orderedMonth"/></td>
								<td align="center" width="14%"><s:text name="orderRemainMonth"/></td>
								<td align="center" width="14%"><s:text name="orderMaxDay"/></td>
								<td align="center" width="14%"><s:text name="orderedDay"/></td>
								<td align="center" width="14%"><s:text name="orderRemainDay"/></td>
				            </tr>
				            <s:iterator value="form.orderMonthdayList" status="status">
				            	<tr>
				            		<td align="center"><j:code2Name definition="$FX_SMPBRAND" code="brand"/><s:hidden name="form.orderMonthdayList[%{#status.index}].brand"/></td>
									<td align="center"><s:property value="orderMaxMonth"/><s:hidden name="form.orderMonthdayList[%{#status.index}].orderMaxMonth"/></td>
									<td align="center"><s:property value="orderedMonth"/><s:hidden name="form.orderMonthdayList[%{#status.index}].orderedMonth"/></td>
									<td align="center"><span class="orderRemainMonthSpan"><s:property value="orderRemainMonth"/></span><s:hidden name="form.orderMonthdayList[%{#status.index}].orderRemainMonth"/></td>
									<td align="center"><s:property value="orderMaxDay"/><s:hidden name="form.orderMonthdayList[%{#status.index}].orderMaxDay"/></td>
									<td align="center"><s:property value="orderedDay"/><s:hidden name="form.orderMonthdayList[%{#status.index}].orderedDay"/></td>
									<td align="center"><span class="orderRemainDaySpan"><s:property value="orderRemainDay"/></span><s:hidden name="form.orderMonthdayList[%{#status.index}].orderRemainDay"/></td>
								</tr>
				            </s:iterator>
				        </table>
			        </s:if>
			        
			        <s:if test="form.orderStdstockList.size()>0">
			        	<table class="table_normal">
				        	<tr>
				                <td align="left" colspan="6"><s:text name="info2"/>&nbsp;<s:text name="unit"/></td>
				            </tr>
				        	<tr>
				                <td align="center" width="25%"><s:text name="brand"/></td>
								<td align="center" width="25%"><s:text name="orderUp"/></td>
								<td align="center" width="25%"><s:text name="orderHas"/></td>
								<td align="center" width="25%"><s:text name="orderMax"/></td>
				            </tr>
				            <s:iterator value="form.orderStdstockList" status="status">
				            	<tr>
									<td align="center"><j:code2Name definition="$FX_SMPBRAND" code="brand"/><s:hidden name="form.orderStdstockList[%{#status.index}].brand"/></td>
									<td align="center"><s:property value="stdstock"/><s:hidden name="form.orderStdstockList[%{#status.index}].stdstock"/></td>
									<td align="center"><s:property value="nowstock"/><s:hidden name="form.orderStdstockList[%{#status.index}].nowstock"/></td>
									<td align="center"><span class="orderMaxSpan"><s:property value="orderMax"/><s:hidden name="form.orderStdstockList[%{#status.index}].orderMax"/></span></td>
								</tr>
				            </s:iterator>
			        	</table>
			        </s:if>
			        
			        <s:if test="form.orderStockalarmList.size()>0">
			        	<table class="table_normal">
				        	<tr>
				                <td align="left" colspan="6"><s:text name="info2"/>&nbsp;<s:text name="unit"/></td>
				            </tr>
				        	<tr>
				                <td align="center" width="20%"><s:text name="brand"/></td>
								<td align="center" width="20%"><s:text name="alarmValue"/></td>
								<td align="center" width="20%"><s:text name="maxStock"/></td>
								<td align="center" width="20%"><s:text name="nowstock"/></td>
								<td align="center" width="20%"><s:text name="orderMax"/></td>
				            </tr>
				            <s:iterator value="form.orderStockalarmList" status="status">
				            	<tr>
									<td align="center"><s:property value="brandsName"/><s:hidden name="form.orderStockalarmList[%{#status.index}].brandsName"/></td>
									<td align="center"><s:property value="alarmValue"/><s:hidden name="form.orderStockalarmList[%{#status.index}].alarmValue"/></td>
									<td align="center"><s:property value="maxStock"/><s:hidden name="form.orderStockalarmList[%{#status.index}].maxStock"/></td>
									<td align="center"><s:property value="nowstock"/><s:hidden name="form.orderStockalarmList[%{#status.index}].nowstock"/></td>
									<td align="center"><span class="orderMaxSpan"><s:property value="orderMax"/><s:hidden name="form.orderStockalarmList[%{#status.index}].orderMax"/></span></td>
								</tr>
				            </s:iterator>
			        	</table>
			        </s:if>
			        
			        <s:if test="form.orderMonthdayStockList.size()>0">
			        	<table class="table_normal">
				        	<tr>
				                <td align="left" colspan="6"><s:text name="info2"/>&nbsp;<s:text name="unit"/></td>
				            </tr>
				        	<tr>
				                <td align="center" width="20%"><s:text name="brand"/></td>
								<td align="center" width="23%"><s:text name="monthdayStock-month"/></td>
								<td align="center" width="23%"><s:text name="monthdayStock-day"/></td>
								<td align="center" width="17%"><s:text name="monthdayStock-stockReal"/></td>
								<td align="center" width="17%"><s:text name="monthdayStock-reference"/></td>
				            </tr>
				            <s:iterator value="form.orderMonthdayStockList" status="status">
				            	<tr>
									<td align="center"><j:code2Name definition="$FX_SMPBRAND" code="brand"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].brand"/></td>
									<td align="center">
										<s:property value="orderMaxMonth"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].orderMaxMonth"/>
										/<s:property value="orderedMonth"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].orderedMonth"/>
										/<s:property value="orderRemainMonth"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].orderRemainMonth"/>
									</td>
									<td align="center">
										<s:property value="orderMaxDay"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].orderMaxDay"/>
										/<s:property value="orderedDay"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].orderedDay"/>
										/<s:property value="orderRemainDay"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].orderRemainDay"/>
									</td>
									<td align="center">
										<s:property value="stdstock"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].stdstock"/>
										/<s:property value="nowstock"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].nowstock"/>
									</td>
									<td align="center">
										<s:property value="referData"/><s:hidden name="form.orderMonthdayStockList[%{#status.index}].referData"/>
									</td>
								</tr>
				            </s:iterator>
			        	</table>
			        </s:if>
			        
			        <!-- 日月预警库存模式 -->
			        <s:if test="form.orderMonthdayStockalarmList.size()>0">
			        	<table class="table_normal">
				        	<tr>
				                <td align="left" colspan="7"><s:text name="info2"/>&nbsp;<s:text name="unit"/></td>
				            </tr>
				        	<tr>
				                <td align="center" width="25%"><s:text name="brand"/></td>				                
								<td align="center" width="15%"><s:text name="monthdayStockalarm-month"/></td>
								<td align="center" width="15%"><s:text name="monthdayStockalarm-day"/></td>
								<td align="center" width="20%"><s:text name="alarmValue"/></td>
								<td align="center" width="7%"><s:text name="maxStock"/></td>
								<td align="center" width="7%"><s:text name="nowstock"/></td>
								<td align="center" width="15%"><s:text name="orderMax"/></td>
				            </tr>
				            <s:iterator value="form.orderMonthdayStockalarmList" status="status">
				            	<tr>
									<td align="center"><s:property value="brandsName"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].brandsName"/></td>
									<td align="center">
										<s:property value="orderMaxMonth"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].orderMaxMonth"/>/<s:property value="orderedMonth"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].orderedMonth"/>/<s:property value="orderRemainMonth"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].orderRemainMonth"/>
									</td>
									<td align="center">
										<s:property value="orderMaxDay"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].orderMaxDay"/>/<s:property value="orderedDay"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].orderedDay"/>/<s:property value="orderRemainDay"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].orderRemainDay"/>
									</td>
									<td align="center"><s:property value="alarmValue"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].alarmValue"/></td>
									<td align="center"><s:property value="maxStock"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].maxStock"/></td>
									<td align="center"><s:property value="nowstock"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].nowstock"/></td>
									<td align="center"><span class="orderMaxSpan"><s:property value="orderMax"/><s:hidden name="form.orderMonthdayStockalarmList[%{#status.index}].orderMax"/></span></td>
								</tr>
				            </s:iterator>
			        	</table>
			        </s:if>
			        
			        
			        <s:if test="form.orderCardList.size()>0">
				        <table class="table_normal">
				        	<tr>
				                <td align="left" colspan="8"><s:text name="info4"/>&nbsp;<s:text name="unit2"/></td>
				            </tr>
				        	<tr>
				        		<td align="center" width="16%"><s:text name="comcategory"/></td>
				                <td align="center" width="12%"><s:text name="orderMaxMonth"/></td>
								<td align="center" width="12%"><s:text name="orderedMonth"/></td>
								<td align="center" width="12%"><s:text name="orderRemainMonth"/></td>
								<td align="center" width="12%"><s:text name="orderMaxDay"/></td>
								<td align="center" width="12%"><s:text name="orderedDay"/></td>
								<td align="center" width="12%"><s:text name="orderRemainDay"/></td>
								<td align="center" width="12%"><s:text name="oncelimit"/></td>
				            </tr>
				            <s:iterator value="form.orderCardList" status="status">
				            	<tr>
				            		<td align="center"><j:code2Name definition="$CARDCOMCATEGORY" code="comcategory"/><s:hidden name="form.orderCardList[%{#status.index}].comcategory"/></td>
									<td align="center"><s:property value="orderMaxMonth"/><s:hidden name="form.orderCardList[%{#status.index}].orderMaxMonth"/></td>
									<td align="center"><s:property value="orderedMonth"/><s:hidden name="form.orderCardList[%{#status.index}].orderedMonth"/></td>
									<td align="center"><span class="orderRemainMonthSpan"><s:property value="orderRemainMonth"/></span><s:hidden name="form.orderCardList[%{#status.index}].orderRemainMonth"/></td>
									<td align="center"><s:property value="orderMaxDay"/><s:hidden name="form.orderCardList[%{#status.index}].orderMaxDay"/></td>
									<td align="center"><s:property value="orderedDay"/><s:hidden name="form.orderCardList[%{#status.index}].orderedDay"/></td>
									<td align="center"><span class="orderRemainDaySpan"><s:property value="orderRemainDay"/></span><s:hidden name="form.orderCardList[%{#status.index}].orderRemainDay"/></td>
									<td align="center"><s:property value="oncelimit"/><s:hidden name="form.orderCardList[%{#status.index}].oncelimit"/></td>
								</tr>
				            </s:iterator>
				        </table>
			        </s:if>
			        
			          <s:if test="form.orderEmptyCardVOList.size()>0">
			        	<table class="table_normal">
				        	<tr>
				                <td align="left" colspan="7"><s:text name="info5"/>&nbsp;<s:text name="unit"/></td>
				            </tr>
				        	<tr>
				                <td align="center" width="14%"><s:text name="comcategory"/></td>
								<td align="center" width="14%"><s:text name="curmaxstock"/></td>
								<td align="center" width="14%"><s:text name="maxStock"/></td>
								<td align="center" width="14%"><s:text name="curstock"/></td>
								<td align="center" width="14%"><s:text name="usecount"/></td>
								<td align="center" width="14%"><s:text name="badcount"/></td>
								<td align="center" width="14%"><s:text name="orderedMonth"/></td>
				            </tr>
				            <s:iterator value="form.orderEmptyCardVOList" status="status">
				            	<tr>
									<td align="center"><j:code2Name definition="$IM_FXCOMCATEGORY" code="restype"/><s:hidden name="form.orderEmptyCardVOList[%{#status.index}].restype"/></td>
									<td align="center"><span class="orderMaxSpan"><s:property value="curmaxstock"/><s:hidden name="form.orderEmptyCardVOList[%{#status.index}].curmaxstock"/></span></td>
									<td align="center"><s:property value="maxstock"/><s:hidden name="form.orderEmptyCardVOList[%{#status.index}].maxstock"/></td>
									<td align="center"><s:property value="curstock"/><s:hidden name="form.orderEmptyCardVOList[%{#status.index}].curstock"/></td>
									<td align="center"><s:property value="usecount"/><s:hidden name="form.orderEmptyCardVOList[%{#status.index}].usecount"/></td>
									<td align="center"><s:property value="badcount"/><s:hidden name="form.orderEmptyCardVOList[%{#status.index}].badcount"/></td>
									<td align="center"><s:property value="orderedMonth"/><s:hidden name="form.orderEmptyCardVOList[%{#status.index}].orderedMonth"/></td>
								</tr>
				            </s:iterator>
			        	</table>
			        </s:if>
			        
			        <table class="table_normal">
			        	<tr>
			                <td align="left">
			                	<s:text name="info3"/>：<br>
				                <s:property value="form.hint"/>
			                </td>
			            </tr>
			        </table>
			        
			        <s:if test="spePrice == 'SALEPLAN'" >
				    	<aa:zone name="refreshTable">
					        <table class="table_normal">
					        	<tr>
					                <td align="center" width="25%"><s:text name="comcategory"/>：</td>
					                <td align="left" width="25%">
					                <s:if test="form.buttonflag == 'disable'" >
					                <input type="text" name="form.comcategory" id="comcategory_text" value="<s:property value="form.comcategory"/>" disabled="disabled"/><input type="button" 
					                	name="form.comcategory_button" class="picker_button" value="..." disabled="disabled"/>
					                </s:if>
					                <s:else>
					                <input type="text" name="form.comcategory" id="comcategory_text" value="<s:property value="form.comcategory"/>"/><input type="button" 
					                	name="form.comcategory_button" class="picker_button" value="..." onclick="javascript:openPicker(this,'$IM_FXCOMCATEGORY','');getOrderInfo1();"/>
					                </s:else>
					                </td>
					                
					                <td align="center" width="25%">
					                	<s:text name="unitprice"/>：
					                	<a id="form_unitprice">
					                	<s:i18n name="public">
					                		<s:if test="null!=form.unitprice">
					                			<s:property value="%{getText('format.double',{form.unitprice})}"/>
					                		</s:if>
	                     				</s:i18n>
	                     				</a>
					                	<s:hidden name="form.unitprice" id="unitprice"></s:hidden>
					                </td>
					                <td align="center" width="25%">
						                <s:text name="orderbase"/>：
						                <a id="form_unitage">
						                <s:if test="form.unitage!=0">
						                	<s:property value="form.unitage"/>
						                </s:if>
						                </a>
					                	<s:hidden name="form.unitage" id="unitage"></s:hidden>
					                </td>
					            </tr>
					            <tr>
					            	<td align="center" width="25%">优惠方案：</td>
					                <td align="left" width="25%" colspan='3'>
					                	<s:if test="form.buttonflag == 'disable'" >
					                		<s:select list="salePlanType" name="form.planCode" id="planCode" onchange="calOrderInfo1()" disabled = "true"></s:select>
						                </s:if>
						                <s:else>
						                	<s:select list="salePlanType" name="form.planCode" id="planCode" onchange="calOrderInfo1()"></s:select>
						                </s:else>
					                </td>
					            </tr>
					            <tr>
					                <td align="center"><s:text name="orderamount"/>：</td>
					                <td align="left"><s:textfield cssStyle="style_input" name="orderamount" id="orderamount"/></td>
					                <td align="left" colspan="2">
					                	<input id="button_New" type="button" value="添加" class="button_New" onclick="orderAdd()" <s:if test="form.buttonflag == 'disable'" >disabled = "true"</s:if>/>
					                	<input type="button" value="删除" class="button_Delete" onclick="orderDel()" <s:if test="form.buttonflag == 'disable'" >disabled = "true"</s:if>/>
					                </td>
					            </tr>
					        </table>
				        </aa:zone>
				    </s:if>
				    <s:else>				    			        
				        <aa:zone name="refreshTable">
					        <table class="table_normal">
					        	<tr>
					                <td align="center" width="25%"><s:text name="comcategory"/>：</td>
					                <td align="center" width="25%">
					                <s:if test="form.buttonflag == 'disable'" >
					                <input type="text" name="form.comcategory" id="comcategory_text" value="<s:property value="form.comcategory"/>" disabled="disabled"/><input type="button" 
					                	name="form.comcategory_button" class="picker_button" value="..." disabled="disabled"/>
					                </s:if>
					                <s:else>
					                <input type="hidden" name="form.comcategory" id="comcategory" value="<s:property value="form.comcategory"/>"/>
					                <input type="text" name="form.comcategory_text" id="comcategory_text" value="<s:property value="form.comcategory_text"/>"/><input 
					                	type="button" name="form.comcategory_button" class="picker_button" value="..." onclick="javascript:openPicker(this,'$IM_FXCOMCATEGORY','');getOrderInfo();"/>
					                </s:else>
					                </td>
					                <td align="center" width="25%">
					                	<s:text name="unitprice"/>：
					                	<a id="form_unitprice">
					                	<s:i18n name="public">
					                		<s:if test="null!=form.unitprice">
					                			<s:property value="%{getText('format.double',{form.unitprice})}"/>
					                		</s:if>
	                     				</s:i18n>
	                     				</a>
					                	<s:hidden name="form.unitprice" id="unitprice"></s:hidden>
					                </td>
					                <td align="center" width="25%">
						                <s:text name="orderbase"/>：
						                <a id="form_unitage">
						                <s:if test="form.unitage!=0">
						                	<s:property value="form.unitage"/>
						                </s:if>
						                </a>
					                	<s:hidden name="form.unitage" id="unitage"></s:hidden>
					                </td>
					            </tr>
					            <tr>
					                <td align="center"><s:text name="orderamount"/>：</td>
					                <td align="center"><s:textfield cssStyle="style_input" name="orderamount" id="orderamount"/></td>
					                <td align="left" colspan="2">
					                	<input id="button_New" type="button" value="添加" class="button_New" onclick="orderAdd()" <s:if test="form.buttonflag == 'disable'" >disabled = "true"</s:if>/>
					                	<input type="button" value="删除" class="button_Delete" onclick="orderDel()" <s:if test="form.buttonflag == 'disable'" >disabled = "true"</s:if>/>
					                </td>
					            </tr>
					        </table>
				        </aa:zone>
			        </s:else>
			        <s:if test="spePrice == 'SALEPLAN'" >
			        	<table class="table_normal" id="orderTable">
			        	<tr>
			        		<td title="<s:text name="list_title_select"/>" width="4%">
			                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
			                </td>
			                <td align="center" width="8%"><s:text name="index"/></td>
			                <td align="center" width="18%"><s:text name="comcategory"/></td>
			                <td align="center" width="15%"><s:text name="orderamount"/></td>
			                <td align="center" width="31%">优惠方案</td>
			                <td align="center" width="12%"><s:text name="unitprice"/></td>
			                <td align="center" width="12%"><s:text name="totalprice"/></td>
			            </tr>
			            <s:iterator value="form.comorderList" status="status">
			            	<tr>
			            		<td><input type="checkbox" class="order" name="param._selectitem" onclick="checkOne();"></td>
			            		<td align="center" class="indexTd">&nbsp;</td>
								<td align="center"><s:hidden name="form.comorderList[%{#status.index}].comcategory" cssClass="comorder comc"/></td>
								<td align="center"><s:property value="orderamount"/><s:hidden name="form.comorderList[%{#status.index}].orderamount" cssClass="comorder amount"/></td>
								<td align="center"><s:hidden name="form.comorderList[%{#status.index}].planCode" cssClass="comorder planCode"/></td>
								<td align="center"><s:property value="unitprice"/><s:hidden name="form.comorderList[%{#status.index}].unitprice" cssClass="comorder"/></td>
								<td align="center"><s:property value="totalprice"/><s:hidden name="form.comorderList[%{#status.index}].totalprice" cssClass="comorder price"/></td>
							</tr>
			            </s:iterator>
			            <tr>
			                <td align="center">&nbsp;</td>
							<td align="center"><s:text name="total"/></td>
							<td align="center">&nbsp;</td>
							<td align="center" id="allamountTd">0</td>
							<td align="center">&nbsp;</td>
							<td align="center">&nbsp;</td>
							<td align="center" id="allpriceTd">0</td>
			            </tr>
			        	</table>
			        </s:if>
				    <s:else>
				        <table class="table_normal" id="orderTable">
				        	<tr>
				        		<td title="<s:text name="list_title_select"/>" width="4%">
				                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
				                </td>
				                <td align="center" width="10%"><s:text name="index"/></td>
				                <td align="center" width="36%"><s:text name="comcategory"/></td>
				                <td align="center" width="15%"><s:text name="orderamount"/></td>
				                <td align="center" width="15%"><s:text name="unitprice"/></td>
				                <td align="center" width="20%"><s:text name="totalprice"/></td>
				            </tr>
				            <s:iterator value="form.comorderList" status="status">
				            	<tr>
				            		<td><input type="checkbox" class="order" name="param._selectitem" onclick="checkOne();"></td>
				            		<td align="center" class="indexTd">&nbsp;</td>
									<td align="center"><s:hidden name="form.comorderList[%{#status.index}].comcategory" cssClass="comorder comc"/></td>
									<td align="center"><s:property value="orderamount"/><s:hidden name="form.comorderList[%{#status.index}].orderamount" cssClass="comorder amount"/></td>
									<td align="center"><s:property value="unitprice"/><s:hidden name="form.comorderList[%{#status.index}].unitprice" cssClass="comorder"/></td>
									<td align="center"><s:property value="totalprice"/><s:hidden name="form.comorderList[%{#status.index}].totalprice" cssClass="comorder price"/></td>
								</tr>
				            </s:iterator>
				            <tr>
				                <td align="center">&nbsp;</td>
								<td align="center"><s:text name="total"/></td>
								<td align="center">&nbsp;</td>
								<td align="center" id="allamountTd">0</td>
								<td align="center">&nbsp;</td>
								<td align="center" id="allpriceTd">0</td>
				            </tr>
				        </table>
			        </s:else>
			    </div>
			    
			    <div class="table_div">
				        <table class="table_button_list">
				            <tr>
				                <td width="100%" align="center">
				                   	<s:i18n name="public">
				                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
				                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
				                           value="<s:text name="button_submit"/>" onclick="doStep3()"
				                           <s:if test="CMD == WEB_CMD_SAVE || form.buttonflag == 'disable'" >disabled = "true"</s:if>
				                           />
				                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
				                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
				                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/comorder_step1.do')">
									</s:i18n>
				                </td>
				            </tr>
				        </table>
				    </div>
			    
			</s:form>
		</div>
	</body>
</html>
