<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ taglib prefix="st" uri="/select-tag"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_cityhead.jsp"%>
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_citymenu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
           
         
    <!--������Ϣ��ʼ-->
	
      
     <!--������Ϣ����-->
           
        </div>
	</div>
			<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/common/rnd_code.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/basic/node/list.js"></script> 

<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
//ҳ���������
var errMap = new Array();
<%--���ô�����Ϣ--%>
<c:set var="ferrMap" value ="${fieldErrors}"/>
<c:if test="${fn:length(ferrMap)>0}"><c:forEach items="${ferrMap}" var="fieldError" varStatus="i">
errMap[${i.index}]={feild:'${fieldError.key}',msg:'${fieldError.value}'};
</c:forEach>
</c:if>

var jaacDBBank = "${jqac.DBBank}";
//-->

</SCRIPT>
</html>