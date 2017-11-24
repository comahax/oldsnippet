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
		function doSubmit(){
			var oprcode = $.trim( document.getElementById('form.user.oprcode').value );
			if(oprcode.length==11){
				var regExp = /1[0-9]{10}/g;
				var matchs = oprcode.match(regExp);
				if(matchs!=null){//Province officers login
					try{
						openDlg('<%=contextPath%>/cityselect.do', '选择地市', 400, 220, true);
						//return true;
					}catch(ex){
						alert(ex.message);
					}
				}else{
					return true;
				}
			}else{
				return true;
			}
			return false;
		}
		
		function doAfterCitynoReady(){
			formList.action="<%=contextPath%>/loginprov.do";
			formList.submit();
		}
		</script>
	</head>
	<body>
		<form action="login.do" method="post" name="formList" onsubmit="return(doSubmit());">
			<div class="middle">
				<div class="m-m">
					<table border="0" cellspacing="0" cellpadding="0" class="login" style="table-layout:fixed; width:250px;">
						<tr>
							<td style="padding-left:25px;">
									<span class="index_main_top_area_xi">用户名：</span>
									<input name="form.user.oprcode" type="text" id="form.user.oprcode" class="biaodan_biaodan_denter" value=""/>
									<input type="hidden" name="cityno" id="cityno" onpropertychange="doAfterCitynoReady()"/>							
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
	  window.document.getElementById("form.user.oprcode").focus();	 
	 </script>
</html>