<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
	<head>
		<title>û�в˵�Ȩ��</title>
<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
<script language="JavaScript">

function ev_checkval() {
	return checkval(window);
}

</script>
	</head>
	<body onload="loadforiframe();">
		<div class="table_container">
				<!--##################################��ӱ�������##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								û�в˵�����Ȩ�ޣ�
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
											��ʾ��Ϣ:��¼���Ų��ǽ����й�˾�Ĺ��ţ�û�в���Ȩ�ޣ�
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
