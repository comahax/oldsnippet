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
	      		window.location.href="<%= contextPath%>/cms/zjty/zjtyassess/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.zjtyassess.ZjtyAssessTaskBean";                                                                                        
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/zjty/zjtyassess/list.jsp";
    	}	
    </script>
</head>
<body  onload��" loadforiframe()">
<div class="table_container">
	<html:form action="/cms/zjty/zjtyassess/batch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							�Խ���Ӫ�������˹�����
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
						<font color=red>��������</font>|<font color=red>�Ƴ��·�</font>|������ϵ��|�ۺ�����ϵ��|���ϵ��|��Ա����|
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
						<font color=red>TDZS03E2A</font>|<font color=red>201201</font>|0.95|1.05|1|5|
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						��ÿ���Խ���Ӫ����������ǰ����Ҫ����ÿ�����Ŀ���ϵ������Ա���������û�е�������ݣ�����ϵ��Ĭ��ȡֵ1����Ա����Ĭ��ȡ�����˶�������<br>
						�������룺�Խ���Ӫ����������<br>
						�Ƴ��·ݣ���ʽyyyyMM<br>
						������ϵ��������λ1λ��С��λ��λ��������ʱĬ��ȡֵ1��<br>
						�ۺ�����ϵ��������λ1λ��С��λ��λ��������ʱĬ��ȡֵ1��<br>
						���ϵ��������λ1λ��С��λ��λ��������ʱĬ��ȡֵ1��<br>
						��Ա���������ڵ������������������ʱĬ��ȡ�����˶��������������ա���������ϵ�������˵���<br>
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
						<a href="<%=contextPath%>/cms/zjty/zjtyassess/zjtyassess.xls">�Խ���Ӫ�������˹�����</a>
						��ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ����룩</td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.zjtyassess.ZjtyAssessTaskBean"
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
