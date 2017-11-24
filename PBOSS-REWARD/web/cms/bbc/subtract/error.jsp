<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
	<head>
		<title>没有菜单权限</title>
<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
<script language="JavaScript">

function ev_checkval() {
	return checkval(window);
}

</script>
	</head>
	<body onload="loadforiframe();">
		<div class="table_container">
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								没有菜单操作权限！
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
        			<table class="form_table">
		        		<tr>
							
						</tr>
						<tr class="table_error_content">
							<td class="table_error_content_td">
								<div>
									<table width=100% valign=top height=200>
										<tr>
											<td></td>
										</tr>
										<tr>
											提示信息:登录工号不是江门市公司的工号，没有操作权限！
										</tr>
										<tr>
											<td></td>
										</tr>								
									</table>
								</div>
							</td>
						</tr>
        			</table>
        		</div>
		</div>
	</body>
</html>
