<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@page import="com.gmcc.pboss.biz.communi.CPDictionary"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
<!-- ͷ�� -->
<%@ include file="/common/include/inc_head.jsp"%>	
<!--��׼���ݿ�ʼ-->
<div class="divspan">
<!-- ��������-->
<%@ include file="/common/include/inc_menu.jsp"%>
<div class="context">
<div class="listmyposition">
	<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
</div>

<s:form action="questionSumbit" method="POST" id="saveFrm" onsubmit="return doSubmit();">
<div class="listboxtitle">��ѯ����</div>
<table class="tb02" width="100%" >
	<tr>
	  <td class="input_label" >���⣺</td>
	  <td>
	  	<input name="parameter.title" id="title" class="text_01" style="width:300px;"
	  	value="${parameter.title }" maxlength=100/>
	  </td>
	</tr>
	<tr>
		<td class="input_label" >���ݣ�</td>
	  <td>
		<textarea name="parameter.content"  id="content" onkeydown="textdown(event,'content',100)" onkeyup="textup('content',100)" rows="5" cols="100" class="textarea_01" maxlength=10>${parameter.content }</textarea>  	
	  </td>
	</tr>
	<tr>
		<td class="input_label" ></td>
		<td>
			<input type="button" id="btnSave" value="�ύ" class="btn_blue_75"  />&nbsp;&nbsp;
	  	</td>
	</tr>
</table>
<input type="hidden" value="<%=CPDictionary.INTERLOCUTION %>" name="parameter.type" />
</s:form>
<div class="listboxlist">
   <div class="column">
	<div class="listboxtitle">����˵����</div>
       <div class="reminder"></div>
	</div>
   <div class="column">
   	<div class="listboxtitle">��ܰ���ѣ�</div>
       <div class="reminder"></div>
   </div>
</div>
</div>
</div>
<!--��׼���ݽ���-->
<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="/js/jQuery/validation/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/communi/interlocution/question.js"></script>

</html>