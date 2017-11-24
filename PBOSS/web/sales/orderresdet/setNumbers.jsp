<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>抽取资源编号范围设置</title>
    <script language="JavaScript" type="text/JavaScript">    
    function closeDialoge(){
    	window.close();
    }
    
	var comcategory = "<%=request.getAttribute("comcategory") %>";//商品种类
    var orderamt = <%=request.getAttribute("orderamt") %>;//订购数量
    var statorderamt = 0;//统计已指定数量
    var statNums = "";//用于记录设定的开始、结束资源编号，开始、结束资源编号用-分隔，每组之间用<br>分隔
    
    function addNumber()
    {
       var number1 = $("#number1").val();//开始资源编号
       var number2 = $("#number2").val();//结束资源编号
       
       if(number1 == "" || null == number1){
	 		alert("开始编号，必需填写");
	 		return ;
 		}
 		if(number2 == "" || null == number2){
	 		alert("结束编号，必需填写");
	 		return ;
	 	}
	 	
	 	var result = '';
        jQuery.ajax({
			type:"POST",
			url:"<%=contextPath%>"+"/sales/orderresdet_numbers.do",
			async:false, //同步
			data:{'number1':number1,'number2':number2},	
			success:function(msg){
				result=msg;
			}
		});
		
		var results = result.split(',');
			 	
	 	if(results[0] == "error1"){
	 		alert("结束编号必须大于等于开始编号");
	 		return ;
	 	}
	 	
	 	if(results[0] == "error2"){
	 		alert("输入开始、结束编号范围过大，请检查");
	 		return ;
	 	}
	 	
	 	if(results[0] == "error3"){
	 		alert("输入开始、结束编号范围过大，请检查");
	 		return ;
	 	}
	 	
	 	if(results[0] == "error4"){
	 		alert("输入的开始编号非数字，请检查");
	 		return ;
	 	}
	 	
	 	if(results[0] == "error5"){
	 		alert("输入的结束编号非数字，请检查");
	 		return ;
	 	}
	 	
	 	var num = parseInt(results[1]) + 1;//计算指定数量
	 	
	 	statorderamt = statorderamt + num;
	 	
	 	var trs = $("#addNumberTable tr");
	 	var str = "";
	 	str = '<tr class="table_style_content">'
	 		+	'<td style="text-align:right">范围：</td>'
        	+   '<td>'
			+		'<input cssStyle="style_input" readonly value="'+number1+'"/>'
			+		'--'
			+		'<input cssStyle="style_input" readonly value="'+number2+'"/>'
			+		'<font color="red">*&nbsp;&nbsp;'
			+		'数量：'+num+'张'
			+		'</font>'
			+	'</td>'
			+	'<td>'
			+	'<input type="button" id="close" class="button_4" value=" 删除 " onClick="deleteNumber(this)"/>'
			+	'</td>'
			+  '</tr>';
					 	
	 	trs.eq(trs.length-1).before(str);//增加行
	 	statNums = statNums + number1 + "-" + number2 + "<br>";
	 	//刷新表头区域
	 	var addedCount = '订购数量：' + orderamt + "&nbsp;张&nbsp;&nbsp;" 
	 					+ "已指定数量：" +statorderamt + "&nbsp;张";
	 	document.getElementById("addedCount").innerHTML = addedCount;
	 	
	 	document.getElementById("number1").value = "";//清空开始资源编号
	 	document.getElementById("number2").value = "";//清空结束资源编号
	 	
    }
    
    function deleteNumber(thisTd)
    {
    	var delTr = $("#addNumberTable tr");
    	
    	//待删除按钮所在行的输入框起始值
    	var delInput1 = $(thisTd).parents("tr").children("td:eq(1)").children("input:eq(0)").val();
    	//待删除按钮所在行的输入框终止值
    	var delInput2 = $(thisTd).parents("tr").children("td:eq(1)").children("input:eq(1)").val();
    	statNums = "";
    	$(delTr).each(function(i){
    		//遍历中每一行输入框起始值
	    	var delInput11 = $(this).children("td:eq(1)").children("input:eq(0)").val();
	    	//遍历中每一行输入框终止值
	    	var delInput22 = $(this).children("td:eq(1)").children("input:eq(1)").val();
    		
    		//遍历中输入框起始值=待删除按钮所在行的输入框起始值
    		//遍历中每一行输入框终止值=待删除按钮所在行的输入框终止值
    		//满足上面两个条件才删除
    		if((delInput11 == delInput1) && (delInput22 == delInput2)){
    			//刷新表头区域
    			
	    		var result = '';
		        jQuery.ajax({
					type:"POST",
					url:"<%=contextPath%>"+"/sales/orderresdet_numbers.do",
					async:false, //同步
					data:{'number1':delInput11,'number2':delInput22},	
					success:function(msg){
						result=msg;
					}
				});				
				var results = result.split(',');
								    			
    			statorderamt = statorderamt - (parseInt(results[1]) + 1);
	 			var addedCount = '订购数量：' + orderamt + "&nbsp;张&nbsp;&nbsp;" 
	 					+ "已指定数量：" +statorderamt + "&nbsp;张";
    			$("#addNumberTable tr").children("td:eq(1)").html(addedCount);
    			
				$(this).remove();
			}else{
				if((delInput11 != undefined && delInput11 != "")
					&& (delInput22 != undefined && delInput22 != "")){
					statNums = statNums + delInput11 + "-" + delInput22 + "<br>";	
				}
			}
			
		});
    }
    
    function confAddNumber(){
    	
    	if(parseInt(orderamt) != parseInt(statorderamt)){
    		if(parseInt(orderamt) > parseInt(statorderamt)){
    			alert("你所指定资源编号数量小于订购数量，请核实");
    			return ;
    		}else{
    			alert("你所指定资源编号数量大于订购数量，请核实");
    			return ;
    		}
    	}
    	statNums = statNums.substring(0,(statNums.length -4));//去掉最后一个<br>
    	
		window.returnValue = comcategory + "," + statNums;		
		window.close();
    }
    
    </script>
    <style type="text/css">
    .table_style_head td {
	font-size: 12px;
	font-weight: normal;
	color: #2F3732;
	height: 22px;
	border:#000 solid 0px;
	<!--text-align:right;-->
	border-right:#FFFFFF inset 2px;
	border-bottom:#CDCDCD solid 1px;
	padding:2px 10px 0px 10px;
	background:url(../images/image_peijian/index_main_xinxi_bj.GIF) repeat-x;
	font-family: Geneva, Arial, Helvetica, sans-serif;	
	word-break:break-all;
	white-space:nowrap;
	vertical-align:middle;
}

.table_style_content td {
	border-right:#FFFFFF inset 2px;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #D7D7D7;
	font-family: "宋体";
	font-size: 12px;
	font-weight: normal;
	color: #666666;
	height: 24px;
	<!--vertical-align: left;-->
	<!--text-align:left;-->
	padding:0px 2px 0px 2px;
	word-break:break-all;
	white-space:nowrap;
}
    </style>
</head>

<body class="list_body">
	<div class="table_container">
		<s:form action="orderresdet_addNumbers.do" id="formList" name="formItem" method="post" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_checkval();">
		<table class="table_normal"  id="addNumberTable">
			<tr class="table_style_head">
				<td style="text-align:right">状态：</td>
				<td style="text-align:left" id="addedCount">
				订购数量：<%=request.getAttribute("orderamt") %>张&nbsp;&nbsp;
				已指定数量：张
				</td>
			</tr>
			
			<tr class="table_style_content">
				<td style="text-align:right">范围：</td>
				<td>
					<s:textfield cssStyle="style_input" id="number1"/>
					--
					<s:textfield cssStyle="style_input" id="number2"/>
					
				</td>
			</tr>
		</table>
		</s:form>
	</div>
	<table class="table_button_list">
		<tr>
			<td>
				<input type="button" id="close" class="button_4" value=" 添加 " onClick="addNumber()"/>
				<input type="button" id="close" class="button_4" value=" 确定 " onClick="confAddNumber()"/>
				<input type="button" id="close" class="button_4" value=" 返回 " onClick="closeDialoge()"/>
			</td>
		</tr>
	</table>
</body>
</html>
