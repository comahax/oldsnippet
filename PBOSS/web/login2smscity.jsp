<%@page contentType="text/html; charset=gbk"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>广东移动集中渠道管理信息（COMS）系统</title>
		<script type="text/javascript" src="js/base.js"></script>
		<style type="text/css">
<!--
body {
	background-image: url(images/image_enter/left-bj.GIF);
	background-repeat: repeat-x;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	background-color: ebf2f6;
	margin: 0px;
	width: 100%;
	height: 100%;
}
-->
</style>
		<link href="css/other.css" rel="stylesheet" type="text/css">
		<link href="css/table.css" rel="stylesheet" type="text/css">
		<link href="css/form.css" rel="stylesheet" type="text/css">
		<link href="css/enter.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
		var _o_ti = null;
		function getSMSRndCode(){
			var a = {
				dataType:'text',
				success:handleRndSMSCode
			}
			_o_ti = f_showPlan("正在发生短信验证码，请稍候。");
			
			document.formList.action="<%=contextPath%>/resendSms.do";
			$('#formList').ajaxSubmit(a);
			document.formList.action="<%=contextPath%>/login2smscity.do";
		}
		
		function handleRndSMSCode(msg){
			if(_o_ti != null)
				_o_ti.close();
			//alert(msg);
			jSuccess(msg);
		}
		</script>
	</head>
	<body>
		<form action="login2smscity.do" method="post" id="formList" name="formList" >
			<s:hidden name="form.user.oprcode" />			
			<s:hidden name="form.user.ip" />
			<s:hidden name="form.user.macAddr" />
			<s:hidden name="form.user.remoteName" />
			<div class="middle">
				<div class="m-m">
					<table border="0" cellspacing="0" cellpadding="0" class="login" style="table-layout:fixed; width:250px;">
						<tr>
							<td style="padding-left:25px;">
								<span class="index_main_top_area_xi">用户名：</span>
								<input name="form.user.oprcode" type="text" id="form.user.oprcode" value="<s:property value='form.user.oprcode'/>" class="biaodan_biaodan_denter" disabled/>
								<input type="hidden" name="cityno" id="cityno" value="<s:property value='cityno'/>"/>							
							</td>
						</tr>
						<tr>
							<td style="padding-left:25px;">
								<span class="index_main_top_area_xi">短信码：</span>
								<input name="rndsmscode" id="rndsmscode" type="text" class="biaodan_biaodan_denter_0" style="height:18px;border: 1px solid #949492;" size="10" maxlength="6" value=""/>
								<a href="javascript:void(0)" onclick="getSMSRndCode()"><span class="index_main_top_area_xi"><font color='black'>重新获取</font></span></a>
								<input type="hidden" name="form.isCitySms" id="form.isCitySms" value="true"/>
							</td>
						</tr>
						<tr>
							<td class="enter_m_bo">
								<label>
									<input name="Submit" type="submit" class="enter_anniu"
										value="登录" onFocus="this.blur()"/>
								</label>
								<label>
									<input name="button" type="reset" class="enter_anniu"
										value="重置" onFocus="this.blur()" onClick=""/>
								</label>
							</td>
						</tr>
						<tr>
							<td>
								<div class="enter_m_bid1">
									<span class="index_main_top_area_xi">
										<s:actionerror/><s:actionmessage/>
									</span>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</body>
	<script language="JavaScript">
	  window.document.getElementById("rndsmscode").focus();	 
	 </script>
</html>