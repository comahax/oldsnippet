<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html:html>
<head>
	<title><bean:message bundle="chpwregsiviolation" key="titleList"/></title>
	<script language="JavaScript">
		function checkProcess(){
			var filename=formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/cms/reward/chpwregsiviolationbatch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.reward.chpwregsiviolation.ChPwRegsiviolationTaskBean";
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/reward/chpwregsiviolation.do?CMD=LIST";
    	}
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
	<html:form action="/cms/reward/chpwregsiviolationbatch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td><bean:message bundle="chpwregsiviolation" key="titleList"/></td>
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
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">选择上传文件:</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
					</td>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.ITEM.inFile}">
						<tr>
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
				<tr>
					<td align=right height=25>
						<bean:message bundle="upload" key="filetype" />
					</td>
					<td align=left>
						<bean:message bundle="upload" key="typevalue" />
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							文件格式 :
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>号码|违规月份|</font>备注|
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							举例说明:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>13570245109|201306|</font>违规登记|
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							补充说明:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						违规月份：4位年2位月，格式:YYYYMM<br/>
						违规扣罚月份与低价值客户一致，扣罚间隔月份为2<br/>
						比如：违规月份201309，在201311扣罚
					</td>
				</tr>
			</table>
		</div>
		<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.reward.chpwregsiviolation.ChPwRegsiviolationTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no"></iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" 
								onblur="buttonout(this)" ID="buttonUpload" NAME="buttonUpload"/>
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" 
								onblur="buttonout(this)" ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
							<input type="button" value="<bean:message bundle="public" key="button_return"/>" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" 
								onblur="buttonout(this)" ID="buttonReturn" NAME="buttonReturn" onclick="doReturnList()">
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
