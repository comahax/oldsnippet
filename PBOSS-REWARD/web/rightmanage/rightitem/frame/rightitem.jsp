<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<link href="<%= contextPath %>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="table_iframe">

			<div class="iframetop">
				特权编码管理
			</div>

			<div class="iframemenu">

				<script language="javascript">
					addmenuleft();
					addmenu("<%=contextPath%>/rightmanage/rightitem/list.jsp","特权编码查询");	
					addmenu("<%=contextPath%>/rightmanage/rightitem/batchin/batchin.jsp","特权编码入库");	
				//    addmenu("<%=contextPath%>/resmanage/comrescard/modifycomrescard/content.jsp","充值卡状态修改");
				//    addmenu("<%=contextPath%>/resmanage/comrescard/distributecomrescard/content.jsp","充值卡发放");
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/recyclecomrescard/content.jsp","充值卡回收");
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/batch/batchdistributecomrescard/batchdistributecomrescard.jsp","充值卡批量发放");
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/batch/batchrecyclecomrescard/batchrecyclecomrescard.jsp","充值卡批量回收");  
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/batch/batchincomrescard/batchincomrescard.jsp","充值卡批量入库");
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/batch/batchdeletecomrescard/batchdeletecomrescard.jsp","充值卡批量删除");
				 //   
				    addmenuright();
				    addmenumore();
				</script>


			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" Scrolling="no"
					name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" src="<%=contextPath%>/rightmanage/rightitem/list.jsp"></iframe>
			</div>

		</div>
	</body>
</html>
