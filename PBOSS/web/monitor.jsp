<%@page contentType="text/html; charset=gbk"%>
<%@ include file="/inc/listhead.inc" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<%
			java.util.HashMap<String, Integer> countMap = com.sunrise.jop.ui.interceptor.MonitorInterceptor.countMap;
			java.util.HashMap<String, Long> timeMap = com.sunrise.jop.ui.interceptor.MonitorInterceptor.timeMap;
		%>
		<div>���ʴ���</div>
		<table class="table_style" id="count-Map">
			<%
				for (String key : countMap.keySet()) {
					Integer value = countMap.get(key);
			%>
			<tr class="table_style_content" align="center">
				<td><%=key%></td>
				<td><%=value%></td>
			</tr>
			<%
				}
			%>
		<table>
		<br/><br/>
		<div>�����������ʱ�䣨��λ�����룩</div>
		<table class="table_style" id="time-Map">
			<%
				for (String key : timeMap.keySet()) {
					Long value = timeMap.get(key);
			%>
			<tr class="table_style_content" align="center">
				<td><%=key%></td>
				<td><%=value%></td>
			</tr>
			<%
				}
			%>
		<table>
	</body>
</html>
