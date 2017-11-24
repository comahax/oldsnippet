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
						<div class="field-require">ѡ���ϴ��ļ�:</div>
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
							�ļ���ʽ :
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>����|Υ���·�|</font>��ע|
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>13570245109|201306|</font>Υ��Ǽ�|
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						Υ���·ݣ�4λ��2λ�£���ʽ:YYYYMM<br/>
						Υ��۷��·���ͼ�ֵ�ͻ�һ�£��۷�����·�Ϊ2<br/>
						���磺Υ���·�201309����201311�۷�
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
