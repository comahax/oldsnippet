<%@page contentType="text/html; charset=gbk"%>
<%@page import="com.gmcc.pboss.web.common.login.ILoginCheck"%>
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
	</head>
	<body>
		<form action="login2.do" method="post" name="formList">
			<s:hidden name="form.user.oprcode" />
			<s:hidden name="form.result.userType" />
			<s:hidden name="form.user.RSAStatus" />
			<s:hidden name="form.user.step" />
			<s:hidden name="form.user.ip" />
			<s:hidden name="form.user.macAddr" />
			<s:hidden name="form.user.remoteName" />
			<div class="middle">
				<div class="m-m">
					<table border="0" cellspacing="0" cellpadding="0" class="login">
						<tr>
							<td>
								<div class="enter_m_bid">
									<s:if test="form.result.userType == loginCheck.SIMP_LOGIN">
										<span class="index_main_top_area_xi">固定密码：</span>
										<input name="form.user.password" type="password" class="biaodan_biaodan_denter" value=""/>
									</s:if>
									<s:if test="form.result.userType == loginCheck.DYANMIC_LOGIN">
										<span class="index_main_top_area_xi">动态密码：</span>
										<input name="form.user.password" type="password" class="biaodan_biaodan_denter" value=""/>
									</s:if>
									<s:if test="form.result.userType == loginCheck.SEC_LOGIN">
										<s:if test="form.user.step == 1">
											<span class="index_main_top_area_xi">固定密码：</span>
											<input name="form.user.password" type="password" class="biaodan_biaodan_denter" value=""/>
										</s:if>
										<s:if test="form.user.step == 2">
											<span class="index_main_top_area_xi">短信验证码：</span>
											<input name="form.user.secondPass" type="text" class="biaodan_biaodan_denter" value=""/>
											<s:hidden name="form.user.password"/>
										</s:if>
									</s:if>
									<s:if test="form.result.userType == loginCheck.CHALLENGE_LOGIN">
										<span class="index_main_top_area_xi">挑战码：</span>
										<s:hidden name="form.user.safewordMessage"/>
										<s:hidden name="form.user.safewordCode"/>
										<s:property value="form.user.safewordCode"/>
										<br/>
										<span class="index_main_top_area_xi">挑战码对应值：</span>
										<input name="form.user.password" type="text" class="biaodan_biaodan_denter" value=""/>
									</s:if>
									<s:if test="form.result.userType == loginCheck.RSA_LOGIN">
										<s:if test="form.user.RSAStatus == 3">
											<span class="index_main_top_area_xi">固定密码：</span>
											<input name="form.user.password" type="password" class="biaodan_biaodan_denter" value=""/>
										</s:if>
										<s:if test="form.user.RSAStatus == 8">
											<span class="index_main_top_area_xi">挑战码：</span>
											<s:hidden name="form.user.password"/>
											<input name="form.user.curToken" type="text" class="biaodan_biaodan_denter" value=""/>
										</s:if>
										<s:if test="form.user.RSAStatus == 9">
											<span class="index_main_top_area_xi">输入挑战码：</span>
											<s:hidden name="form.user.password"/>
											<s:hidden name="form.user.curToken"/>
											<s:property value="form.user.curToken"/>
											<br/>
											<span class="index_main_top_area_xi">漂移挑战码：</span>
											<input name="form.user.nextToken" type="text" class="biaodan_biaodan_denter" value=""/>
										</s:if>
									</s:if>
								</div>
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
								<div class="enter_m_bid">
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
</html>