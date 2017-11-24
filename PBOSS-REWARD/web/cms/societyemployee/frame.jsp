<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>渠道</title>
	</head>

	<c:set var="station" scope="request"
		value="${requestScope.station eq 'G'}" />
	<c:if test="${station}">		
			<frameset rows="*" cols="150,*" framespacing="0" frameborder="NO"
				border="1">			
					<frame src="<%=contextPath%>/cms/societyemployee/leftFrame.jsp?KIND=G"
						name="left">
					<frame
						src="<%=contextPath%>/cms/employee.do?CMD=SOCIETYSHOW&KIND=G"
						name="mainContent">
				</frameset>
		</c:if>
		<c:if test="${!station}">
			<frameset rows="*" cols="150,*" framespacing="0" frameborder="NO"
				border="1">
				<frame src="<%=contextPath%>/cms/societyemployee/leftFrame.jsp?KIND="
						name="left">
				<frame src="<%=contextPath%>/cms/employee.do?CMD=SOCIETYSHOW"
					name="mainContent">
			</frameset>
		</c:if>
		<noframes>
			<body>
				frame is not supoorted by you browser.
			</body>
		</noframes>
</html>
