<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title>��½����..</title>
	</head>
	<body onload="fun()" style=" background:url(images/Left_Menu3_Bg.jpg);">
		<br />
		<br />
		<td>
			�����ֻ��չʾҳ������û���õ����ʻ������ע������ʽҳ����Ҫ�ù��ʻ���д����
		</td>
		<br />
		<br />
		<td>
			�õ�½������������һ��User,����User���浽session���档�ܼ򵥣���ҵ��½�Ϳ����ˡ�
		</td>
		<br />
		<br />
		<form action="<%=contextPath%>/login.do" method="post">
			<table>
				<tr>
					<td>
						����Ա��
					</td>
					<td>
						<input type="text" maxlength="20" value="pboss" name="opercode">
					</td>
				</tr>
				<tr>
					<td>
						����:
					</td>
					<td>
						<input type="text" maxlength="20" value="TDZS-----" name="wayid">
					</td>
				</tr>
				<tr>
					<td>
						�б�ʶ:
					</td>
					<td>
						<input type="text" maxlength="20" value="760" name="cityid">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="��½" name="login">
						<a href="admin/logincase.do?CMD=LIST">���ٵ�¼</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
