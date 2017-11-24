<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><bean:message bundle="orderdetailquery" key="orderdetailquerytitle" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function checkProcess(){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
        		formItem.buttonProcess.disabled=true;
    			window.location.href="<%=contextPath%>/cms/way/process.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.way.BatchWayTaskBean";
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
		<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	</head>

	<body  onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/way/upload.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">

				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								�������Ϲ�����������
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
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="batchimportorder" key="selectfile" />
								:
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile" ID="File1" />
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content">
									<td align=right height=25>
										<bean:message bundle="upload" key="existfile" />
									</td>
									<td align=left>
										<a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out
						value="${requestScope.ITEM.inFile}" />'> <c:out value="${requestScope.ITEM.fileName}" /> </a>
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
								<p><font color=red>��������|��������|�ϼ�����|</font>Ӫҵ���ʶ|<font color=red>�Ƿ���|�������|</font>���������|</p>
								<p>�ֹ�˾�Զ�������������|���м���|�����ȼ�|</p>
								<p>����MIS����|��ҵ��Դ����|�Ƿ�����|������ʽ|��Ӫģʽ|�Ƿ���������|�Ǽ�|������|</p>
								<p>�����ܵ����|ǩԼ״̬|Ӫҵ��Ա����|������Ա����|�ն�����|<font color=red>γ��|����|����״̬|</font></p>
								<p>�����м����|<font color=red>��Ӫ��־</font></p>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<font color=red> JMTEST|�����ƶ�|JFJMAA00|002|0|AV|AVAG|0|1|2|002|0|1|1|0|1|2|2|123|1|10|8|12|23.234534|121.334261|1|20|FZY </font>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="svwayinfoms" key="exinfos" />
							</td>
							<td align=left>
								<p>�Ƿ���:0,��1,��; �������:AV,��ֵ��������;RIVL,������������;SA,ֱ������; </p> 
								<p>AG,�������;���������:TEMI �ն˳���; IT���� ITF; ECF ���ӳ�ֵȯ������</p>
								<p>,AVAG ��ֵ������;VTAG ������Ӫ��  </P>
								<p>RVOW ����������Ӫ����;RVST ��������������� </p> 
								<p>SMAG ���۾���;CMAG �ͻ�����</p> 
								<p>�ֹ�˾�Զ�������������:0,����;11,����ǰ̨                                            </p> 
								<p>���м���:1,ֱϽ��;2,��ʡ��;3,�ؼ���;4,�ؼ���;99,����;-1,�˻�;                          </p> 
								<p>�����ȼ�:1,A��;2,B��;3,C��;99,����                                                     </p> 
								<p>��ҵ��Դ����:0,����;1,������ҵ����;2,���й�˾����;3,�����ҵ��������                   </p> 
								<p>�Ƿ�����:0,����;������,1  ������ʽ:0,����;1,2M����;2,GPRS;3,CSD;4,��������;5,��������  </p> 
								<p>��Ӫģʽ:0,�Խ���Ӫ;1,�Խ���Ӫ;2,������Ӫ  �Ƿ���������:0,��;1,��                     </p> 
								<p>�Ǽ�:0,δ���Ǽ�;1,һ�Ǽ�;2,���Ǽ�;3,���Ǽ�;4,���Ǽ�;5,���Ǽ�;6,���Ǽ�;                 </p> 
								<p>������:-1,˫����;1,������;0,������;  ǩԼ״̬:0,����;1,Ԥ��Լ;2,ע��;                  </p> 
								<p>����״̬:1,��Ч,0,��Ч; ��Ӫ��־:FZY,����Ӫ;ZY,��Ӫ                           </p> 

							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="svwayinfoms" key="redirect" />
							</td>
							<td align=left>
								<a href="<%=contextPath %>/cms/common/importguide.htm">��дָ��</a>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="svwayinfoms" key="excelexample" />
							</td>
							<td align=left>
								<a href="<%= contextPath %>/cms/way/waybatch.xls">�������Ϲ�����������ģ��.xls</a>&nbsp;&nbsp;
								<bean:message bundle="svwayinfoms" key="excelinfo" />
							</td>
						</tr>
						
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="comfir"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">

							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								
							<input type="button" value="����" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="doReturn('/cms/way.do?CMD=LIST')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.way.BatchWayTaskBean" 
			frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
