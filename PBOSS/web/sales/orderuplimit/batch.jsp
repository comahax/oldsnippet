<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title>��������</title>
		<script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/sales/orderuplimitbatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.orderuplimit.OrderuplimitTaskBean";
			}
		}
	    function doReturn(cmdReturn) {
	        formItem.action = contextPath + cmdReturn;
	        formItem.submit();
	    }
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<s:form action="/sales/orderuplimitupload.do" method="POST" key="formItem"
			cssStyle="formItem" enctype="multipart/form-data" theme="simple">
			<div class="table_top">
				<div class="table_topleft"></div>
				<div class="table_toparea_w">
					<s:i18n name="public">
						<span class="table_toparea"><s:text name="currentPos" /> </span>
						<span class="table_toparea_xi">&gt;</span>
						<span class="table_toparea"><s:text name="sales" /> </span>
						<span class="table_toparea_xi">&gt;</span>
					</s:i18n>
					<span class="table_toparea_h">�հ�SIM�����Ԥ������</span>
				</div>
			</div>
			<input type="hidden" name="filename"
				value='<s:property value="fileName"/>'>
			<input type="hidden" name="path"
				value='<s:property value="filepath"/>'>
			<input type="hidden" name="iCheckFormat"
				value="com.gmcc.pboss.web.sales.orderuplimit.OrderuplimitCheck">
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
							<td align="right" width="60px">
								ѡ���ļ�:
							</td>
							<td align="left">
								<s:file name="doc" label="File" />
							</td>
						</tr>
						<tr>
							<td align="right" height=25>
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
							<td align="right" height=25>
								�ļ���ʽ:
							</td>
							<td align="left">
								<FONT color=red>�ֹ�˾|�Ǽ�|��Ʒ����|��߿��|��ɫԤ��|��ɫԤ��|</FONT>
							</td>
						</tr>
						<tr>
							<td align="right" height=25>
								����˵��:
							</td>
							<td align="left">
								<FONT color=red>A01|3|QQTSIM|80|20|40|</FONT>
							</td>
						</tr>
						<tr>
							<td align="right" height=25>
								����˵��
							</td>
							<td align="left">
								�ļ���ʽ���ú�ɫ��ǵ��ֶ�Ϊ������ļ������ޱ����С�
								<br>
								�ֹ�˾�������������ķֹ�˾��
								<br>
								�Ǽ���0-δ���Ǽ� 1-һ�Ǽ� 2-���Ǽ� 3-���Ǽ� 4-���Ǽ� 5-���Ǽ� 6-���Ǽ� 7-3G����ר���Ǽ� 8-�������������Ǽ� 9-4G����ר���Ǽ�
								<br>
								��Ʒ�����ѯ��<j:selector name="comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
								<br>
								��߿�棺���������������󳤶�10λ��
								<br>
								��ɫԤ�������������������󳤶�10λ��
								<br>
								��ɫԤ�������������������󳤶�10λ��
								<br>
								<FONT color=red>��ʾ����¼������ʱ������������������ʱ���и��²�����</FONT><br>
								<br>
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
										<s:i18n name="public">
											<input type="submit" id="btnBatch" name="btnBatch"
												class="button_New" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												value="<s:text name="button_upload"/>">
											<input type="button" id="buttonProcess" name="buttonProcess"
												class="button_New" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)" onclick="checkProcess()" value="����">
											<input type="button" id="btnReturn" name="btnReturn"
												class="button_Back" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												value="<s:text name="button_return"/>"
												onclick="doReturn('/sales/orderuplimit_listforemptysim.do')">
										</s:i18n>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>

		</s:form>
		<iframe
			src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.orderuplimit.OrderuplimitTaskBean"
			frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
	</body>
</html>