<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>

<html:html>
<head>
	<title><bean:message bundle="custinte" key="batchTransferList" /></title>
	<script language="JavaScript">
		function checkProcess(){
			var filename=formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/cms/chadtwaymod/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.chadtwaymod.ChAdtWaymodTaskBean";                                                                                        
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/chadtwaymod.do?CMD=LIST";
    	}	
    </script>
</head>
<body  onload��" loadforiframe()">
<div class="table_container">
	<html:form action="/cms/chadtwaymod/batch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							��Ȧ�ŵ겹������ϵ������
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
						<font color=red>��������|VI����|���|��ͷ��棨������|�ֻ����壨������|���������ࣨ������|</font>
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
						JFJMCS22|0.6|0.5|0.2|0.1|0|
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<table class="form_table">
						  <tr class="table_style_content">
							<td>���</td><td>��Ŀ</td><td>רӪ</td><td>��Ӫ</td>
						  </tr>
						  <tr class="table_style_content">
							<td rowspan=4>VI����</td><td>ȫ��ͷ</td><td>0.6</td><td>--</td>
						  </tr>
						  <tr class="table_style_content">
							<td>������ͷ</td><td>0.5</td><td>0.3</td>
						  </tr>
						  <tr>
							<td>ר��</td><td>0.4</td><td>0.2</td>
						  </tr>
						  <tr>
							<td>ר���������</td><td>0.1</td><td>--</td>
						  </tr>
						  <tr>
							<td rowspan=5>���</td><td>300ƽ������</td><td>0.6</td><td>0.3</td>
						  </tr>
						  <tr>
							<td>120ƽ��-300ƽ��</td><td>0.5</td><td>0.2</td>
						  </tr>
						  <tr>
							<td>60ƽ��-120ƽ��</td><td>0.4</td><td>0.1</td>
						  </tr>
						  <tr>
							<td>30ƽ��-60ƽ��</td><td>0.3</td><td>--</td>
						  </tr>
						  <tr>
							<td>10ƽ��-30ƽ��</td><td>0.2</td><td>--</td>
						  </tr>
						  <tr>
							<td rowspan=3>����</td><td>��ͷ���</td><td>0.2</td><td>0.2</td>
						  </tr>
						  <tr>
							<td>�ֻ�����</td><td>0.1</td><td>0.1</td>
						  </tr>
						  <tr>
							<td>����������</td><td>0.1</td><td>0.1</td>
						  </tr>
						</table>
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
						<a href="<%=contextPath%>/cms/chadtwaymod/chadtwaymod.xls">��Ȧ�ŵ겹������ϵ������</a>
						��ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ����룩</td>
				</tr>
			</table>
		</div>
		<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.chadtwaymod.ChAdtWaymodTaskBean"
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
