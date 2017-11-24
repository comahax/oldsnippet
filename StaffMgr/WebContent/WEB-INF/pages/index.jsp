<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<title>广东移动员工通讯管理查询系统</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bill.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/selectdate.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/information.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bills.js"></script>
	<script type="text/JavaScript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/JavaScript" src="<%=request.getContextPath() %>/js/selectdate.js"></script>
	
	<style type="text/css">
		table.gridtable {
			font-family: verdana,arial,sans-serif;
			font-size:11px;
			color:#333333;
			border-width: 1px;
			border-color: #666666;
			border-collapse: collapse;
		}
		table.gridtable th {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #dedede;
			font-size: 12px;
		}
		table.gridtable td {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #ffffff;
			font-size: 11px;
		}
	</style>
	<script type="text/javascript">
	var rootPath = '<%=request.getContextPath()%>';
	
	</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:90px;padding:10px;background-color: #005bac;background-image:url('<%=request.getContextPath() %>/images/top_bg.jpg'); background-repeat: repeat-x;">
	</div>
	
	<div class="logo">
		<div style="padding:0px 100px 0px 0px; float: right">
		<c:if test="${loginperm=='staff'}">
			<c:out value="${names}"></c:out>，欢迎您！
		</c:if>
		<c:if test="${loginperm=='cityadmin'}">
				管理员<c:out value="${names}"></c:out>,欢迎您！
		</c:if>
		<c:if test="${loginperm=='gdadmin'}">
				管理员<c:out value="${names}"></c:out>,欢迎您！
		</c:if>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-large_logout',size:'large',iconAlign:'top'" onclick="logout()">退出登录</a>
		</div>
	</div>
	<div data-options="region:'center'">
	<div id="toptabs" class="easyui-tabs" data-options="fit:true,border:false,onSelect:selectTopTabs" >
	<div title="员工信息查询" data-options="href:'<%=request.getContextPath() %>/information/index.do'"> </div>
	<div title="员工账单" data-options="href:'<%=request.getContextPath() %>/bills/index.do'"></div>
	</div>
	</div>
	
	
</body>
</html>