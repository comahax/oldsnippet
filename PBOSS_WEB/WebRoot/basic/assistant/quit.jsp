<%@ page contentType="text/html;charset=GBK"%>
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
			<div class="listboxtitle">����д�˳�ԭ��</div>
			<c:if test='${fn:length(message)>0}'>
		<DIV><font color="red">������ʾ��${message}</font></DIV></c:if>
			<div class="listboxlist">
	<s:if test="%{result.data.size > 0}">
		<s:set name="emp" value="result.data[0]" />
			<form id="frmSubmit" method="POST" action="doQuit.do" onsubmit="return doSubmit(this);">
				<table class = "tb02" width="100%">
					<tr>
						<td class="blue_01 textRight">��Ա������</td>
						<td>${emp.employeename}
						<INPUT TYPE="hidden" NAME="apply.employeename" value="${emp.employeename}">
						<INPUT TYPE="hidden" NAME="apply.employeeid" value="${emp.employeeid}">
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight">�˳�ԭ��</td>
						<td><textarea name="apply.description" class="textarea_01" id="description">${apply.description}</textarea></td>
					</tr>
					<tr>
						<td class="blue_01 textRight">��֤�룺</td>
						<td>
							<input tabindex="8" name="vaildateCode" class="code" type="text" id="vaildate_code" class="input3"  maxlength="4" onBlur="hiddenVerify()" 
							onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value=""/>
							<input type="submit" class="btn_blue_75" value="�� ��" />
							<input type="button" class="btn_blue_75" onclick="location='/assistant/List.do'" value="�� ��" />
						</td>
					</tr>
				</table>
			</form>
    </s:if>
    <s:else>
    	û��Щ��Ա�����ݡ�
    </s:else>
			<!--������Ϣ��ʼ-->
			<div class="column">
		         <div class="listboxtitle">����˵����</div>
		         <div class="reminder">��������ɺ�̨����ͨ��������˳��� </div>
		    </div>
		    <div class="column">
	         	<div class="listboxtitle">��ܰ���ѣ�</div>
	        	<div class="reminder"></div>
		    </div>
     		<!--������Ϣ����-->
     	</div>
     	
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
<script type="text/javascript" src="${ctx}/js/biz/basic/assistant/quit.js"></script> 
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
//-->
</SCRIPT>
</html>