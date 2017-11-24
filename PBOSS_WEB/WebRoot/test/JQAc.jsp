<%@ page contentType="text/html;charset=GBK"%>
<%@include file="/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<%@include file="/common/include/static_p.jsp"%>
		<link type="text/css" rel="stylesheet" href="main.css"></link>
		<link type="text/css" rel="stylesheet" href="${ctx}/css/ac/jquery.autocomplete.css"></link>
	</head>
	<body>
		<div id="content">
			<form autocomplete="off">
				<p>
					<label>AC”Ú</label>
					<input type="text" id="singleBirdRemote" />
				</p>
				<p>
					<label>Hidden</label>
					<input type="text" id="hiddenId" />
				</p>
			</form>
		</div>

		<script type="text/javascript" src="${ctx}/js/ac/jquery.autocomplete.js"></script>
		<script type="text/javascript" src="${ctx}/js/ac/auto.js"></script>
		<SCRIPT LANGUAGE="JavaScript">
		<!--
	$(document).ready(function() {
		cusAc($("#singleBirdRemote"),$("#hiddenId"),{type:"${jqac.OPERATION}"})
	});
		//-->
		</SCRIPT>
	</body>
</html>