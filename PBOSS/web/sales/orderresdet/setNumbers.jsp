<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>��ȡ��Դ��ŷ�Χ����</title>
    <script language="JavaScript" type="text/JavaScript">    
    function closeDialoge(){
    	window.close();
    }
    
	var comcategory = "<%=request.getAttribute("comcategory") %>";//��Ʒ����
    var orderamt = <%=request.getAttribute("orderamt") %>;//��������
    var statorderamt = 0;//ͳ����ָ������
    var statNums = "";//���ڼ�¼�趨�Ŀ�ʼ��������Դ��ţ���ʼ��������Դ�����-�ָ���ÿ��֮����<br>�ָ�
    
    function addNumber()
    {
       var number1 = $("#number1").val();//��ʼ��Դ���
       var number2 = $("#number2").val();//������Դ���
       
       if(number1 == "" || null == number1){
	 		alert("��ʼ��ţ�������д");
	 		return ;
 		}
 		if(number2 == "" || null == number2){
	 		alert("������ţ�������д");
	 		return ;
	 	}
	 	
	 	var result = '';
        jQuery.ajax({
			type:"POST",
			url:"<%=contextPath%>"+"/sales/orderresdet_numbers.do",
			async:false, //ͬ��
			data:{'number1':number1,'number2':number2},	
			success:function(msg){
				result=msg;
			}
		});
		
		var results = result.split(',');
			 	
	 	if(results[0] == "error1"){
	 		alert("������ű�����ڵ��ڿ�ʼ���");
	 		return ;
	 	}
	 	
	 	if(results[0] == "error2"){
	 		alert("���뿪ʼ��������ŷ�Χ��������");
	 		return ;
	 	}
	 	
	 	if(results[0] == "error3"){
	 		alert("���뿪ʼ��������ŷ�Χ��������");
	 		return ;
	 	}
	 	
	 	if(results[0] == "error4"){
	 		alert("����Ŀ�ʼ��ŷ����֣�����");
	 		return ;
	 	}
	 	
	 	if(results[0] == "error5"){
	 		alert("����Ľ�����ŷ����֣�����");
	 		return ;
	 	}
	 	
	 	var num = parseInt(results[1]) + 1;//����ָ������
	 	
	 	statorderamt = statorderamt + num;
	 	
	 	var trs = $("#addNumberTable tr");
	 	var str = "";
	 	str = '<tr class="table_style_content">'
	 		+	'<td style="text-align:right">��Χ��</td>'
        	+   '<td>'
			+		'<input cssStyle="style_input" readonly value="'+number1+'"/>'
			+		'--'
			+		'<input cssStyle="style_input" readonly value="'+number2+'"/>'
			+		'<font color="red">*&nbsp;&nbsp;'
			+		'������'+num+'��'
			+		'</font>'
			+	'</td>'
			+	'<td>'
			+	'<input type="button" id="close" class="button_4" value=" ɾ�� " onClick="deleteNumber(this)"/>'
			+	'</td>'
			+  '</tr>';
					 	
	 	trs.eq(trs.length-1).before(str);//������
	 	statNums = statNums + number1 + "-" + number2 + "<br>";
	 	//ˢ�±�ͷ����
	 	var addedCount = '����������' + orderamt + "&nbsp;��&nbsp;&nbsp;" 
	 					+ "��ָ��������" +statorderamt + "&nbsp;��";
	 	document.getElementById("addedCount").innerHTML = addedCount;
	 	
	 	document.getElementById("number1").value = "";//��տ�ʼ��Դ���
	 	document.getElementById("number2").value = "";//��ս�����Դ���
	 	
    }
    
    function deleteNumber(thisTd)
    {
    	var delTr = $("#addNumberTable tr");
    	
    	//��ɾ����ť�����е��������ʼֵ
    	var delInput1 = $(thisTd).parents("tr").children("td:eq(1)").children("input:eq(0)").val();
    	//��ɾ����ť�����е��������ֵֹ
    	var delInput2 = $(thisTd).parents("tr").children("td:eq(1)").children("input:eq(1)").val();
    	statNums = "";
    	$(delTr).each(function(i){
    		//������ÿһ���������ʼֵ
	    	var delInput11 = $(this).children("td:eq(1)").children("input:eq(0)").val();
	    	//������ÿһ���������ֵֹ
	    	var delInput22 = $(this).children("td:eq(1)").children("input:eq(1)").val();
    		
    		//�������������ʼֵ=��ɾ����ť�����е��������ʼֵ
    		//������ÿһ���������ֵֹ=��ɾ����ť�����е��������ֵֹ
    		//������������������ɾ��
    		if((delInput11 == delInput1) && (delInput22 == delInput2)){
    			//ˢ�±�ͷ����
    			
	    		var result = '';
		        jQuery.ajax({
					type:"POST",
					url:"<%=contextPath%>"+"/sales/orderresdet_numbers.do",
					async:false, //ͬ��
					data:{'number1':delInput11,'number2':delInput22},	
					success:function(msg){
						result=msg;
					}
				});				
				var results = result.split(',');
								    			
    			statorderamt = statorderamt - (parseInt(results[1]) + 1);
	 			var addedCount = '����������' + orderamt + "&nbsp;��&nbsp;&nbsp;" 
	 					+ "��ָ��������" +statorderamt + "&nbsp;��";
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
    			alert("����ָ����Դ�������С�ڶ������������ʵ");
    			return ;
    		}else{
    			alert("����ָ����Դ����������ڶ������������ʵ");
    			return ;
    		}
    	}
    	statNums = statNums.substring(0,(statNums.length -4));//ȥ�����һ��<br>
    	
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
	font-family: "����";
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
				<td style="text-align:right">״̬��</td>
				<td style="text-align:left" id="addedCount">
				����������<%=request.getAttribute("orderamt") %>��&nbsp;&nbsp;
				��ָ����������
				</td>
			</tr>
			
			<tr class="table_style_content">
				<td style="text-align:right">��Χ��</td>
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
				<input type="button" id="close" class="button_4" value=" ��� " onClick="addNumber()"/>
				<input type="button" id="close" class="button_4" value=" ȷ�� " onClick="confAddNumber()"/>
				<input type="button" id="close" class="button_4" value=" ���� " onClick="closeDialoge()"/>
			</td>
		</tr>
	</table>
</body>
</html>
