<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头
%>
<%@ include file="/inc/contenthead.inc"%>


<html>
<head>
	<title>请选择要导出的字段</title>
	<script>
		var str="渠道编码|渠道名称|零售渠道类别|上级渠道编码|星级|排他性|状态|地市公司|分公司|服务销售中心|微区域|是否直供|"+
		"区域类型|行政区划|业态类型|合作开始时间|营业面积|所属物流商|所属渠道经理的人员ID|分级|采集平台捆绑手机号|"+
		"业务预警量|详细地址|地理纬度|地理经度|业主姓名|业主电话|业主固定电话|业主电子信箱|送货地址|收货联系人|"+
		"收货联系号码|收货人证件号码|签约类型|合同编码|合同协议名称|签署合同时间|合同协议生效时间|合同到期日|"+
		"营业执照编号|营业执照有效期|保证金金额|保证金押金状态|保证金下限|酬金支付开户银行|酬金支付银行账号|"+
		"酬金支付帐号名称|开户人身份证号码|签约状态|保证金交付形式|经营范围|全省代码|卡类购销划扣银行帐号|"+
		"卡类购销划扣账号名称|卡类购销划扣开户银行|合作商编码|是否加入B2M模式|特殊网点标识";
    </script>
</head>
<body>
			<div class="table_container">
				<table class="top_table">
					<tr>
						<td>
							选择要导出的字段
						</td>
					</tr>
				</table>
			
			<select style="width:150px;height:450px" ID="oSelect" name="batchButton" size="56" multiple>
				<option value=0>渠道编码</option>
				<option value=1>渠道名称</option>
				<option value=2>零售渠道类别</option>
				<option value=3>上级渠道编码</option>
				<option value=4>星级</option>
				<option value=5>排他性</option>
				<option value=6>状态</option>
				<option value=7>地市公司</option>
				<option value=8>分公司</option>
				<option value=9>服务销售中心</option>
				<option value=10>微区域</option>
				<option value=11>是否直供</option>
				<option value=12>区域类型</option>
				<option value=13>行政区划</option>
				<option value=14>业态类型</option>
				<option value=15>合作开始时间</option>
				<option value=16>营业面积</option>
				<option value=17>所属物流商</option>
				<option value=18>所属渠道经理的人员ID</option>
				<option value=19>分级</option>
				<option value=20>采集平台捆绑手机号</option>
				<option value=21>业务预警量</option>
				<option value=22>详细地址</option>
				<option value=23>地理纬度</option>
				<option value=24>地理经度</option>
				<option value=25>业主姓名</option>
				<option value=26>业主电话</option>
				<option value=27>业主固定电话</option>
				<option value=28>业主电子信箱</option>
				<option value=29>送货地址</option>
				<option value=30>收货联系人</option>
				<option value=31>收货联系号码</option>
				<option value=32>收货人证件号码</option>
				<option value=33>签约类型</option>
				<option value=34>合同编码</option>
				<option value=35>合同协议名称</option>
				<option value=36>签署合同时间</option>
				<option value=37>合同协议生效时间</option>
				<option value=38>合同到期日</option>
				<option value=39>营业执照编号</option>
				<option value=40>营业执照有效期</option>
				<option value=41>保证金金额</option>
				<option value=42>保证金押金状态</option>
				<option value=43>保证金下限</option>
				<option value=44>酬金支付开户银行</option>
				<option value=45>酬金支付银行账号</option>
				<option value=46>酬金支付帐号名称</option>
				<option value=47>开户人身份证号码</option>
				<option value=48>签约状态</option>
				<option value=49>保证金交付形式</option>
				<option value=50>经营范围</option>
				<option value=51>全省代码</option>
				<option value=52>卡类购销划扣银行帐号</option>
				<option value=53>卡类购销划扣账号名称</option>
				<option value=54>卡类购销划扣开户银行</option>
				<option value=55>合作商编码</option>
				<option value=56>是否加入B2M模式</option>
				<option value=57>特殊网点标识</option>
			</select><br>
			<input type=button class="button_5"  onmouseover="buttonover(this);" 
				onmouseout="buttonout(this);" onfocus="buttonover(this)" 
				onblur="buttonout(this)"  value="选择并导出"
				onclick="getValue()">
			</div>
</body>
<SCRIPT>
	 var form=document.getElementById("oSelect");
	 for(var i=0;i<form.options.length;i++){   
	         form.options[i].selected=true;
	 }   
 function getValue()
 {
 	var code="";
 	for(var i=0;i<form.options.length;i++){   
	        if(form.options[i].selected==true)
	        {
	        	code=code+form.options[i].value+",";
	        }
	 }   
	self.returnValue = code;
	self.close();
 }
</SCRIPT>
	
</html>
