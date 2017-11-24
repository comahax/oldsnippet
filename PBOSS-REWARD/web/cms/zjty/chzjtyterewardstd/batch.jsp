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
<body  onload��" loadforiframe()">
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
							�ն˳���׼��������
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
						<font color=red>�ն���ƷID</font>|<font color=red>��׼��</font>|<font color=red>����׼</font>|
						<font color=red>�������</font>|<font color=red>�Ƴ�����</font>|��ע|
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
						10001100002877|1290|0.1|11|2|��ע|
					</td>
				</tr>
				<tr class="table_style_content">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							����˵��:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						�������:<br>
						1.��Լ�ն˳��;2.���Լ�ն˳��;3.����ն˻������;<br>
						4.����ն�ʡ�������;5.����ն��м������;6.���и��Ի�������;
						11.2014���ն˻������;12.2014���ն˻�׼�۳��;13.2014���ն˳��Ҵ������;14.����ն�4G���ӳ��;<br>
						�Ƴ�����:<br>
						1������;2��������<br> 
						����׼:<br> 
						1.2014���ն˻�����𡢻�׼�۳�𡢳��Ҵ������4G���ӳ��Ĭ�ϰ������Ƴ꣨�Ƴ�����=2��������׼������س�������С���������������ɡ���
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
						<a href="<%=contextPath%>/cms/zjty/chzjtyterewardstd/chzjtyterewardstd.xls">�ն˳���׼��������</a>
						��ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ����룩</td>
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
