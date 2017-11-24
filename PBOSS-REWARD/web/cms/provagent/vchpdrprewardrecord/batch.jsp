<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>
<html:html>
<head>
	<title><bean:message bundle="vchpdrprewardrecord" key="titleList"/></title>
	<script language="JavaScript">
		function checkProcess(){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled = true;
	      		window.location.href="<%= contextPath%>/cms/provagent/chpdrprewardimpbatch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.provagent.vchpdrprewardrecord.VChPdRprewardrecordTaskBean ";
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/provagent/vchpdrprewardrecord.do?CMD=LIST";
    	} 
    </script>
</head>
<body  onload＝" loadforiframe()">
<div class="table_container">
	<html:form action="/cms/provagent/chpdrprewardimpbatch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
		<c:set var="form" scope="request" value="${requestScope['/cms/provagent/VChPdRprewardrecordForm']}"/>
		<input type="hidden" name="region" id="region" value="<c:out value='${form.region}'/>">
		 
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							奖罚酬金管理导入
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
						<font color=red>代理商编码|集团产品编号|计酬月份|期数|地市标识|奖罚金额金额|</font>
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
						123|1|201309|1|ZS|900|
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							补充说明:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
					    代理商:代理商必须在【代理商资料管理】菜单存在<br>
					  集团产品编号:集团产品编号必须在【订购关系管理】菜单存在<br>
					    期数：期数为大于0小于等于60整数<br>
					  奖罚金额:奖罚金额最多4位小数、8位整数含符号位<br>
					  计酬月份：必须为6位有效年月（201308）<br> 
					</td>
				</tr>  
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.provagent.vchpdrprewardrecord.VChPdRprewardrecordTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td> 
						   <input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">
								
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
