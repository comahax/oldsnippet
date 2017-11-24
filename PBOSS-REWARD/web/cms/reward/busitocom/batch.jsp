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
    			window.location.href="<%=contextPath%>/cms/reward/busitocom/upload.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.reward.busitocom.BusitocomTaskBean";
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
		
		function showdiv(select){
			var oDiv = select.value;
			var noDiv=(select.value=='0'?'1':'0');
			for(var i=0;i<4;i++){
				document.getElementById(oDiv+i).style.display="block";
				document.getElementById(noDiv+i).style.display="none";
			}
//			if(oDiv=='BatchDel'){
//				document.getElementById('BatchDel4').style.display="block";
//			}else{
//				document.getElementById('BatchDel4').style.display="none";
//			}
		}
    </script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
	</head>

	<body onload="loadforiframe();showdiv(document.getElementById('oprtype'));">
		<div class="table_container">
			<html:form action="/cms/reward/busitocom/upload.do?CMD=UPLOAD"
				enctype="multipart/form-data" styleId="formItem">
			<iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
				<input type="hidden" name="filename"
					value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								业务与商品资源关联导入
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
								<bean:message bundle="busitocom" key="selectfile" />
								:
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile"
									ID="File1" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<bean:message bundle="busitocom" key="oprtype" />
								:
							</td>
							<td width="75%" align="left" class="form_table_left">
								<html:select property="oprtype" onchange="showdiv(this)">
									<html:option value="0">
										<bean:message bundle="busitocom" key="add" />
									</html:option>
									<html:option value="1">
										<bean:message bundle="busitocom" key="del" />
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
						<tr class="table_style_content" id="00">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
								<td align=left>
									<p>
										<font color="red">商品标识|业务编码|业务编码起始价格(元)|业务编码结束价格(元)|业务组编码|</font>
									</p>
								</td>
						</tr>
						<tr class="table_style_content" id="10" style="display:none">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
								<td align=left>
									<p>
										<font color="red">商品标识|</font>
									</p>
								</td>
						</tr>
						<tr class="table_style_content" id="01">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<font color="red">75501800000685|0403020100011|100|1000|MOBILE|</font>
							</td>
						</tr>
						<tr class="table_style_content" id="11" style="display:none">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<font color="red">75501800000685|</font>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="busitocom" key="guide" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/common/importguide.htm"><bean:message bundle="busitocom" key="guide" />
								</a>
							</td>
						</tr>
						<tr class="table_style_content" id="02">
							<td align=right height=25>
								<bean:message bundle="upload" key="memo" />
							</td>
							<td align=left>
								批量新增:<br>
								1. 所有字段为必填.<br>
								2. 商品价格必须存在业务编码起始价格与业务编码结束价格之间.<br>
								3. 业务编码为'0403'开头的业务, 只有省级权限的工号才能导入.<br>
								4. 业务组编码格式:<br>
									- MOBILE 手机<br>
									- TDNOTEBOOK TD上网本<br>
									- TDDATACARD TD数据卡<br>
									- HOMEGW 家庭网关<br>
									- WIRESSPHONE 无线固话
							</td>
						</tr>
						<tr class="table_style_content" id="12" style="display:none">
						</tr>
						<tr class="table_style_content" id="03">
							<td align=right height=25>
								<bean:message bundle="busitocom" key="model" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/reward/busitocom/BusitocomBatchAdd.xls"><bean:message bundle="busitocom"
										key="modelname" />
								</a>
								<bean:message bundle="busitocom" key="hint" />
							</td>
						</tr>
						<tr class="table_style_content" id="13" style="display:none">
							<td align=right height=25>
								<bean:message bundle="busitocom" key="model" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/reward/busitocom/BusitocomBatchDel.xls"><bean:message bundle="busitocom"
										key="modelname1" />
								</a>
								<bean:message bundle="busitocom" key="hint" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

								<input type="submit"
									value="<bean:message bundle="upload" key="upload" />"
									class="button_2" onmouseover="buttonover(this)"
									onmouseout="buttonout(this)" onfocus="buttonover(this)"
									onblur="buttonout(this)" ID="buttonUpload" NAME="buttonUpload">

								<input type="button"
									value="<bean:message bundle="upload" key="process"/>"
									class="button_2" onmouseover="buttonover(this)"
									onmouseout="buttonout(this)" onfocus="buttonover(this)"
									onblur="buttonout(this)" ID="buttonProcess"
									NAME="buttonProcess" onClick="checkProcess()" />

								<input type="button" value="返回" class="button_2"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonProcess" NAME="buttonProcess"
									onClick="doReturn('/cms/reward/busitocom.do?CMD=LIST')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe
				src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.reward.busitocom.BusitocomTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>
