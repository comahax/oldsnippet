<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div class="table_container">
			

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/resource/compack_tolist.do','商品包信息查询'); 
				    addmenu('<%=contextPath%>/resource/compack_goConfirmResource.do','套卡打包'); 
				    addmenu('<%=contextPath%>/resource/compack_goUploadresource.do','套卡打包工具'); 
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/resource/compack_tolist.do" height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
