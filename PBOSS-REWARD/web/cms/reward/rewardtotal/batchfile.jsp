<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="7F1A1A" />
</jsp:include>

<html>
	<head>
		<title><bean:message bundle="citydata" key="titleList" />
		</title>
		<script language="JavaScript">
		function checkfilename() {
	   	  var filename = document.all.theFile.value;
	   	  if(filename != "") {
	   	   	var arrys = filename.split(".");
		    var filetype = arrys[arrys.length-1];
		    if(filetype.toUpperCase() != "TXT" && filetype.toUpperCase() != "DOC"){
		      errorMessageShow('<bean:message bundle="citydata" key="invalidFileCompose"/>');
		      return false;
		    }
		   }else{
		   	if(filename == ""){
		   		errorMessageShow('<bean:message bundle="citydata" key="selectfile"/>');
		   		return false;
		   	}
		   }
		   return true; 
	   }
	   
		
		
		function upload(){
			formItem.target = '';
			document.all("buttonUpload").disabled = true;
			formItem.submit();
		}
		
    </script>
	</head>
	<body onload="loadforiframe()">
		<div class="table_container">
			<html:form action="/cms/rewardtotalbatch.do" styleId="formItem" method="post" target="hidden_frame" enctype="multipart/form-data">
				<iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								���������ܱ���
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>

				<div class="table_div">
					<table class="form_table" width="95%">
						<tr>
							<td width=12% align=right height=25>
								<div class="field-require">
									<bean:message bundle="citydata" key="dataFile" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left" colspan=3>
								<html:file styleClass="form_input_files" property="theFile" />
							</td>
						</tr>
						<tr>
							<td align=right height=25>
								<bean:message bundle="upload" key="filetype" />
							</td>
							<td align=left colspan=3>
								<bean:message bundle="upload" key="typevalue" />
							</td>
						</tr>
						<tr>
							<td align=right height=25>
								<bean:message bundle="citydata" key="fielFmt" />
							</td>
							<td align=left colspan=3>
								<font color="red">����|�������|�����·�|���</font>
							</td>
						</tr>
						
						<tr>
							<td align=right height=25>
								<bean:message bundle="citydata" key="example" />
							</td>
							<td align=left colspan=3>
								<font color="red">JFJM00001|0|200806|100.21</font>
							</td>
						</tr>
						<tr class="table_style_content">
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="citydata" key="ps" />
									:
								</div>
							</td>
							<td width="75%" align="left" colspan=3>
								�������:<br>
								0,��׼���̶����<br>
								1,��׼�����ֳ��<br>
								2,��׼��ר�Ž���<br>
								3,����ҵ��������<br>
								4,����ҵ�������<br>
								5,����ҵ��������<br>
								6,����ҵ�������<br>
								7,�Ǽ����<br>
								8,��Ŀ������<br>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="citydata" key="guide" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/common/importguide.htm"><bean:message bundle="citydata" key="guide" />
								</a>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="citydata" key="model" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/reward/rewardtotal/rewardtotal2.xls">���������ܱ���.xls
								</a>
								<bean:message bundle="citydata" key="hint" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button" value="<bean:message bundle="upload" key="upload" />" class="comfir"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonUpload" NAME="buttonUpload" onClick="upload()" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
