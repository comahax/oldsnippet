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
				��ɫ����
			</div>

			<div class="iframemenu">

				<script language="javascript">
					addmenuleft();
					addmenu("<%=contextPath%>/rightmanage/role/list.jsp","��ɫ��ѯ");	
				//    addmenu("<%=contextPath%>/resmanage/comrescard/modifycomrescard/content.jsp","��ֵ��״̬�޸�");
				//    addmenu("<%=contextPath%>/resmanage/comrescard/distributecomrescard/content.jsp","��ֵ������");
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/recyclecomrescard/content.jsp","��ֵ������");
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/batch/batchdistributecomrescard/batchdistributecomrescard.jsp","��ֵ����������");
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/batch/batchrecyclecomrescard/batchrecyclecomrescard.jsp","��ֵ����������");  
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/batch/batchincomrescard/batchincomrescard.jsp","��ֵ���������");
				 //   addmenu("<%=contextPath%>/resmanage/comrescard/batch/batchdeletecomrescard/batchdeletecomrescard.jsp","��ֵ������ɾ��");
				 //   
				    addmenuright();
				    addmenumore();
				</script>


			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" Scrolling="no"
					name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" src="<%=contextPath%>/rightmanage/role/list.jsp"></iframe>
			</div>

		</div>
	</body>
</html>
