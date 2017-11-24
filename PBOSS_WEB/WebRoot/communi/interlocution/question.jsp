<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@page import="com.gmcc.pboss.biz.communi.CPDictionary"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
<!-- 头部 -->
<%@ include file="/common/include/inc_head.jsp"%>	
<!--标准内容开始-->
<div class="divspan">
<!-- 左则功能区-->
<%@ include file="/common/include/inc_menu.jsp"%>
<div class="context">
<div class="listmyposition">
	<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
</div>

<s:form action="questionSumbit" method="POST" id="saveFrm" onsubmit="return doSubmit();">
<div class="listboxtitle">查询条件</div>
<table class="tb02" width="100%" >
	<tr>
	  <td class="input_label" >标题：</td>
	  <td>
	  	<input name="parameter.title" id="title" class="text_01" style="width:300px;"
	  	value="${parameter.title }" maxlength=100/>
	  </td>
	</tr>
	<tr>
		<td class="input_label" >内容：</td>
	  <td>
		<textarea name="parameter.content"  id="content" onkeydown="textdown(event,'content',100)" onkeyup="textup('content',100)" rows="5" cols="100" class="textarea_01" maxlength=10>${parameter.content }</textarea>  	
	  </td>
	</tr>
	<tr>
		<td class="input_label" ></td>
		<td>
			<input type="button" id="btnSave" value="提交" class="btn_blue_75"  />&nbsp;&nbsp;
	  	</td>
	</tr>
</table>
<input type="hidden" value="<%=CPDictionary.INTERLOCUTION %>" name="parameter.type" />
</s:form>
<div class="listboxlist">
   <div class="column">
	<div class="listboxtitle">功能说明：</div>
       <div class="reminder"></div>
	</div>
   <div class="column">
   	<div class="listboxtitle">温馨提醒：</div>
       <div class="reminder"></div>
   </div>
</div>
</div>
</div>
<!--标准内容结束-->
<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="/js/jQuery/validation/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/communi/interlocution/question.js"></script>

</html>