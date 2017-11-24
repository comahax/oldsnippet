<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>
<html:html>
<head>
	<title><bean:message bundle="chzjtyterewardstd" key="titleList"/></title>
	<script language="JavaScript">
		function checkProcess(){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled = true;
	      		window.location.href="<%= contextPath%>/cms/zjty/chzjtyterewardstd/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.chzjtyterewardstd.ChZjtyTerewardstdTaskBean";
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/zjty/chzjtyterewardstd.do?CMD=LIST";
    	}
    	function uploadSubmit(){
			var region = document.getElementById("region").value;
			if (region != null && region != "") {
				document.getElementById("_region").value = region;
			}
			document.formItem.submit();
		}
    </script>
</head>
<body  onload＝" loadforiframe()">
<div class="table_container">
	<html:form action="/cms/zjty/chzjtyterewardstd/batch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
		<c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtyterewardstd/ChZjtyTerewardstdForm']}"/>
		<input type="hidden" name="region" id="region" value="<c:out value='${form.region}'/>">
		<html:hidden property="_region" styleId="_region"/>
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							终端酬金标准参数导入
						</td>
					</tr>
				</table>
		    </div>
			<div class="table_div">
			<table width="100%" class="error_text">
	        	<s:Msg />
	   		</table>
	   		</div>
	   		<div class="table_div">
			<table class="form_table">	
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							选择上传文件:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
					</td>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.ITEM.inFile}">
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="existfile" />
							</td>
							<td align=left>
								<a href='<%=contextPath%>/commons/batch/download.jsp?filename=
								<c:out value="${requestScope.ITEM.inFile}" />'>
								<c:out value="${requestScope.ITEM.fileName}" /> </a>
							</td>
						</tr>
					</c:when>
				</c:choose>
				<tr class="table_style_content">
					<td align=right height=25>
						<bean:message bundle="upload" key="filetype" />
					</td>
					<td align=left>
						<bean:message bundle="upload" key="typevalue" />
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							文件格式 :
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>终端商品ID</font>|<font color=red>基准价</font>|<font color=red>酬金标准</font>|
						<font color=red>酬金类型</font>|<font color=red>计酬类型</font>|备注|
						（注：红色字体为必须录入字段）
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							举例说明:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						10001100002877|1290|0.1|11|2|备注|
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							补充说明:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						酬金类型:<br>
						1.合约终端酬金;2.零合约终端酬金;3.裸机终端基础酬金;<br>
						4.裸机终端省激励酬金;5.裸机终端市激励酬金;6.地市个性化裸机酬金;
						11.2014新终端基础酬金;12.2014新终端基准价酬金;13.2014新终端厂家达量酬金;14.裸机终端4G叠加酬金;<br>
						计酬类型:<br>
						1、按笔;2、按比例<br> 
						酬金标准:<br> 
						1.2014新终端基础酬金、基准价酬金、厂家达量酬金、4G叠加酬金默认按比例计酬（计酬类型=2），酬金标准设置相关酬金点数（小数，酬金比例）即可。。
					</td>
				</tr>
				<tr class="table_style_content">
					<td align=right height=25>
						填写指南
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/common/importguide.htm">填写指南</a></td>
				</tr>
				<tr class="table_style_content">
					<td align=right height=25>
						Excel填写模板
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/zjty/chzjtyterewardstd/chzjtyterewardstd.xls">终端酬金标准参数导入</a>
						（注：填写后请将数据转换为txt格式，去掉标题行，再上传导入）</td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.chzjtyterewardstd.ChZjtyTerewardstdTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" value="<bean:message bundle="upload" key="upload" />" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload" onclick="uploadSubmit();"/>
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturnList()">
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
