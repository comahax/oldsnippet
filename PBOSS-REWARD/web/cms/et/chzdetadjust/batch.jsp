<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>
<% String flag = (String) session.getAttribute("flag"); %>
<html:html>
<head>
	<title><bean:message bundle="custinte" key="batchTransferList" /></title>
	<script language="JavaScript">
		function checkProcess(){
			var filename=formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/cms/et/chzdetadjust/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.et.chzdetadjust.ChZdEtadjustTaskBean";                                                                                        
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/et/chzdetadjust.do?CMD=SHOW";
    	}	
    </script>
</head>
<body  onload=" loadforiframe()">
<div class="table_container">
	<html:form action="/cms/et/chzdetadjust/batch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							��ƽ̨�ն˴�����㱨����������
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
							ѡ���ϴ��ļ�:
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
							�ļ���ʽ :
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>��������</font>|<font color=red>ƽ̨��</font>|<font color=red>�ն��ͺ�</font>|<font color=red>���ڲ�����</font>|<font color=red>������Ч����</font>|����ԭ��|
						��ע����ɫ����Ϊ����¼���ֶΣ�
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<font color=red>KCFLLKJ</font>|<font color=red>����</font>|<font color=red>����-I9268</font>|<font color=red>288.8</font>|<font color=red>20130401</font>|�����ն��ѻ���|
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						1��������Ч���Σ���8λ���֣��޶������λΪ��01����16�����ϰ��£�1��15�ţ����۵��ն������ԡ�01������β���°������۵��ԡ�16������β��<br>
						����20130416��20130430�������ݴ��ڲ��죬��Ҫ��20130501��20130515�ı����н��е������������Ч����Ϊ20130501<br>
						2�����ڲ��������Ϊ��288.8��������Ϊ288.8<br>
					</td>
				</tr>
				<tr class="table_style_content">
					<td align=right height=25>
						��дָ��
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/common/importguide.htm">��дָ��</a></td>
				</tr>
				<tr class="table_style_content">
					<td align=right height=25>
						Excel��дģ��
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/et/chzdetadjust/chzdetadjust.xls">��ƽ̨�ն˴�����㱨����������</a>
						��ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ����룩</td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.et.chzdetadjust.ChZdEtadjustTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload"/>
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
