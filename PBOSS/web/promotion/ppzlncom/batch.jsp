<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
String pk = request.getParameter("pk");//==null?"":request.getParameter("pk");
%>
<html>
	<head>
		<title>��������</title>
		<script language="JavaScript" type="text/JavaScript">
	    function checkProcess(str){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/promotion/ppzlncom_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.promotion.ppzlncom.PpzlncomTaskBean&pk="+str;
			}
		}
		
		function doUpload()
		{
			var str='<%=pk%>';
			formItem.action="<%=contextPath%>/promotion/ppzlncom_upload.do?pk="+str;
			formItem.submit();
		}
		
		function doReturn(str) {
   		 	formItem.action ="<%=contextPath%>/promotion/ppzlncom_list.do?param._pk="+str;
   			formItem.submit();
		}
		
		$(document).ready(function(){ 
		        var filename ="<s:property value="fileName" />";// formItem.path.value;
		
		     if(filename == null || filename == '' ){
		    	 $("#buttonProcess").attr('disabled',true);
		     }
		     else{
			     $("#buttonProcess").attr('disabled',false);
		     }
  		});
		
		
    </script>
	</head>

	<body class="list_body" onload="loadforiframe();">
		<div class="table_container">
			<s:form action="/promotion/ppzlncom_upload.do" method="POST"
				key="formItem" cssStyle="formItem" enctype="multipart/form-data"
				theme="simple">
				<div class="table_top">
					<input type="hidden" name="pk" value="<%=pk%>" />
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">&gt;</span>
							<span class="table_toparea"><s:text name="promotion" /> </span>
							<span class="table_toparea_xi">&gt;</span>
						</s:i18n>
						<span class="table_toparea_h">��������</span>
					</div>
				</div>
				<input type="hidden" name="filename"
					value='<s:property value="fileName"/>'>
				<input type="hidden" name="path"
					value='<s:property value="filepath"/>'>
				<input type="hidden" name="iCheckFormat"
					value="com.gmcc.pboss.web.promotion.ppzlncom.PpzlncomCheck">
				<aa:zone name="errorZone">
					<div class="error_text">
						<table class="error_text">
							<s:actionerror />
							<s:actionmessage />
						</table>
					</div>
				</aa:zone>
				<aa:zone name="listZone">
					<div class="table_div">
						<table class="table_normal">
							<tr>
								<td align=right>
									ѡ���ļ�:
								</td align=left>
								<td>
									<s:file name="doc" label="File" cssStyle="button_4"/>
								</td>
							</tr>
							<tr>
								<td align=right height=25>
									�ļ�����:
								</td>
								<td align="left">
									.txt�ı��ļ� (�ı��ﲻҪ�����кͶ���Ŀո�)
								</td>
							</tr>
							<tr>
								<td align="right">
									�ļ�:
								</td>
								<td align="left">
									<a
										href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'>
										<s:property value="fileName" /> </a>
								</td>
							</tr>
							<tr>
								<td align=right height=25>
									�ļ���ʽ:
								</td>
								<td align=left>
									<font color="red">��Ʒ����</font>
								</td>
							</tr>
							<tr>
								<td align=right height=25>
									����˵��:
								</td>
								<td align=left>
									<font color=red>100SZ</font>
								</td>
							</tr>
							<tr>
								<td align=right height=25>
									����˵��
								</td>
								<td align=left>
									��Ʒ���Ͳ�ѯ��<j:selector name="comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
								</td>
							</tr>
						</table>
					</div>
				</aa:zone>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td align=right>
											<input type="button" id="btnBatch" name="btnBatch"
												class="button_New" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)" value="�ϴ�" onClick="doUpload();">
											<input type="button" id="buttonProcess" name="buttonProcess"
												class="button_New" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												onclick="checkProcess(document.all['pk'].value)" value="����">
											<input type="button" id="btnReturn" name="btnReturn"
												class="button_Back" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)" value="����"
												onclick="doReturn(document.all['pk'].value)">

										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>

			</s:form>

			<iframe
				src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.promotion.ppzlncom.PpzlncomTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
