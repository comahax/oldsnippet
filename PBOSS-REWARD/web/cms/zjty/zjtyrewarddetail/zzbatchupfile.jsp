<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><bean:message bundle="orderdetailquery"
				key="orderdetailquerytitle" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function checkProcess(){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
        		formItem.buttonProcess.disabled=true;
    			window.location.href="<%=contextPath%>/cms/zjty/zjtyrewarddetail/zzupload.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.ZjtyRewarddetailZzTaskBean";
    		}
		}
        function getpath(){
    		var url = formList.file.value;
    		document.getElementById("savePath").value = url.substr(0,url.lastIndexOf("\\")+1);
    	}
    	function doReturn(cmdReturn) {
    	formItem.action = contextPath + cmdReturn;
    	formItem.submit();
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/zjty/zjtyrewarddetail/zzupload.do?CMD=UPLOAD"
				enctype="multipart/form-data" styleId="formItem">

				<input type="hidden" name="filename"
					value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								�����ն�ҵ������������
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text" width="100%">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="selectfile" />
								:
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile"
									ID="File1" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<bean:message bundle="zjtyrewarddetail" key="oprtype" />
								:
							</td>
							<td width="75%" align="left" class="form_table_left">
								<html:select property="oprtype">
									<html:option value="0">
										<bean:message bundle="zjtyrewarddetail" key="add" />
									</html:option>
								</html:select>
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content">
									<td align=right height=25>
										<bean:message bundle="upload" key="existfile" />
									</td>
									<td align=left>
										<a
											href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out
						value="${requestScope.ITEM.inFile}" />'>
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
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								<p>
									<font color=red>ҵ�����</font>|<font color=red>������ʶ</font>|<font color=red>�Ƴ귽ʽ</font>|<font color="red">�����·�</font>|<font color=red>Ӧ�����</font>|<br>
									ע:��ɫ�д�������ɫ��Ϊ��ѡ����ѡ��Ϊ��ʱ���豣�������߷ָ���<br>
									�����ն�ҵ�������鿴���������á�����ҵ����Ϣ����<br>
									�Ƴ귽ʽ��1��ʾ���ʣ�0��ʾ��������<br>
									�����·�¼���ʽΪ��yyyymm������2009��10�£���¼��200910
								</p>
								<p>
									6401010100003|JFJM00000|1|200910|0.08|
								</p>
							</td>
						</tr>
						<tr class="table_style_content">
							<td width="20%" align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td width="75%" align=left>
								85|JFJMDAT10|200907|2000.00|
							</td>
						</tr>
						<tr class="table_style_content">
					<td align=right height=25>
						<bean:message bundle="zjtyrewarddetail" key="model" />
					</td>
					<td align=left>
						<a href="<%=contextPath%>/cms/zjty/zjtyrewarddetail/zjtyrewarddetail.xls"><bean:message bundle="zjtyrewarddetail" key="modelname" /></a>
						<bean:message bundle="zjtyrewarddetail" key="hint" /></td>
					</tr>

					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

								<input type="submit"
									value="<bean:message bundle="upload" key="upload" />"
									class="comfir" onmouseover="buttonover(this)"
									onmouseout="buttonout(this)" onfocus="buttonover(this)"
									onblur="buttonout(this)" ID="buttonUpload" NAME="buttonUpload">

								<input type="button"
									value="<bean:message bundle="upload" key="process"/>"
									class="button_4" onmouseover="buttonover(this)"
									onmouseout="buttonout(this)" onfocus="buttonover(this)"
									onblur="buttonout(this)" ID="buttonProcess"
									NAME="buttonProcess" onClick="checkProcess()" />

								<input type="button" value="����" class="button_4"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonProcess" NAME="buttonProcess"
									onClick="doReturn('/cms/zjty/zjtyrewarddetail.do?CMD=Zzlist')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.ZjtyRewarddetailZzTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
