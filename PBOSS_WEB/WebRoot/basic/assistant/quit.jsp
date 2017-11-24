<%@ page contentType="text/html;charset=GBK"%>
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
			<div class="listboxtitle">请填写退出原因</div>
			<c:if test='${fn:length(message)>0}'>
		<DIV><font color="red">错误提示：${message}</font></DIV></c:if>
			<div class="listboxlist">
	<s:if test="%{result.data.size > 0}">
		<s:set name="emp" value="result.data[0]" />
			<form id="frmSubmit" method="POST" action="doQuit.do" onsubmit="return doSubmit(this);">
				<table class = "tb02" width="100%">
					<tr>
						<td class="blue_01 textRight">店员姓名：</td>
						<td>${emp.employeename}
						<INPUT TYPE="hidden" NAME="apply.employeename" value="${emp.employeename}">
						<INPUT TYPE="hidden" NAME="apply.employeeid" value="${emp.employeeid}">
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight">退出原因：</td>
						<td><textarea name="apply.description" class="textarea_01" id="description">${apply.description}</textarea></td>
					</tr>
					<tr>
						<td class="blue_01 textRight">验证码：</td>
						<td>
							<input tabindex="8" name="vaildateCode" class="code" type="text" id="vaildate_code" class="input3"  maxlength="4" onBlur="hiddenVerify()" 
							onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value=""/>
							<input type="submit" class="btn_blue_75" value="提 交" />
							<input type="button" class="btn_blue_75" onclick="location='/assistant/List.do'" value="返 回" />
						</td>
					</tr>
				</table>
			</form>
    </s:if>
    <s:else>
    	没有些店员的数据。
    </s:else>
			<!--帮助信息开始-->
			<div class="column">
		         <div class="listboxtitle">功能说明：</div>
		         <div class="reminder">提出申请由后台审批通过后才能退出。 </div>
		    </div>
		    <div class="column">
	         	<div class="listboxtitle">温馨提醒：</div>
	        	<div class="reminder"></div>
		    </div>
     		<!--帮助信息结束-->
     	</div>
     	
		</div>
		</div>
		<!--标准内容结束-->
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
//页面变量设置
var errMap = new Array();
<%--设置错误信息--%>
<c:set var="ferrMap" value ="${fieldErrors}"/>
<c:if test="${fn:length(ferrMap)>0}"><c:forEach items="${ferrMap}" var="fieldError" varStatus="i">
errMap[${i.index}]={feild:'${fieldError.key}',msg:'${fieldError.value}'};
</c:forEach>
</c:if>
//-->
</SCRIPT>
</html>