<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头
%>
<%@ include file="/inc/contenthead.inc"%>


<html>
<head>
	<title>请选择要导出的字段</title>
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
			
			<select style="width:200px;height:450px" ID="oSelect" name="batchButton" size="56" multiple>
				<option value=0>渠道编码</option>
				<option value=1>渠道名称</option>
				<option value=2>零售渠道类别</option>
				<option value=3>上级渠道编码</option>
				<option value=4>上级渠道名称</option>
				<option value=5>星级</option>
				<option value=6>排他性</option>
				<option value=7>状态</option>
				<option value=8>地市公司</option>
				<option value=9>分公司</option>
				<option value=10>服务销售中心</option>
				<option value=11>微区域</option>
				<option value=12>是否直供</option>
				<option value=13>区域类型</option>
				<option value=14>行政区划</option>
				<option value=15>业态类型</option>
				<option value=16>合作开始时间</option>
				<option value=17>营业面积</option>
				<option value=18>所属物流商</option>
				<option value=19>所属渠道经理的人员ID</option>
				<option value=20>分级</option>
				<option value=21>采集平台捆绑手机号</option>
				<option value=22>业务预警量</option>
				<option value=23>详细地址</option>
				<option value=24>地理纬度</option>
				<option value=25>地理经度</option>
				<!-- 增加 是否授权网点 的导出  -->
				<option value=26>是否授权网点</option>
				<option value=27>业主姓名</option>
				<option value=28>业主电话</option>
				<option value=29>业主固定电话</option>
				<option value=30>业主电子信箱</option>
				<option value=31>送货地址</option>
				<option value=32>收货联系人</option>
				<option value=33>收货联系号码</option>
				<option value=34>收货人证件号码</option>
				<option value=35>签约类型</option>
				<option value=36>合同编码</option>
				<option value=37>合同协议名称</option>
				<option value=38>签署合同时间</option>
				<option value=39>合同协议生效时间</option>
				<option value=40>合同到期日</option>
				<option value=41>营业执照编号</option>
				<option value=42>营业执照有效期</option>
				<option value=43>保证金金额</option>
				<option value=44>保证金押金状态</option>
				<option value=45>保证金下限</option>
				<option value=46>酬金支付开户银行</option>
				<option value=47>酬金支付银行账号</option>
				<option value=48>酬金支付帐号名称</option>
				<option value=49>开户人身份证号码</option>
				<option value=50>签约状态</option>
				<option value=51>保证金交付形式</option>
				<option value=52>经营范围</option>
				<option value=53>全省代码</option>
				<option value=54>卡类购销划扣银行帐号</option>
				<option value=55>卡类购销划扣账号名称</option>
				<option value=56>卡类购销划扣开户银行</option>
				<option value=57>合作商编码</option>
				<option value=58>是否加入B2M模式</option>
				<option value=59>账号类型</option>
				<option value=60>卡类购销划扣银行标识</option>
				<option value=61>卡类购销划扣银行状态</option>
				<option value=62>合作类型</option>
				<option value=63>星级分层</option>
				<option value=64>是否TOP网点</option>
				<option value=65>商圈类型</option>
				<option value=66>社会渠道类型</option>
				<option value=67>所属商圈编码</option>
				<option value=68>连锁加盟渠道属性</option>
				<option value=69>连锁加盟渠道系数</option>
				<option value=70>信用等级</option>
				<option value=71>税务资质</option>
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
