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
    			window.location.href="<%=contextPath%>/cms/bbc/bbcadjust/unpbupload.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.bbc.bbcadjust.BbcadjustunpbTaskBean";
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
			<html:form action="/cms/bbc/bbcadjust/unpbupload.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">

				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								全员代理酬金调整管理导入
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
								导入类型:
							</td>
							<td align=left>
								<html:select property="oprType">
									<html:option value="0">全员代理渠道酬金调整</html:option>
									<html:option value="1">全员代理个人专员渠道酬金调整</html:option>
								</html:select>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								渠道酬金:
								<p><font color="RED">调整类别|渠道编码|作用结算月份(YYYYMM)|调整金额|调整原因类型|备注|酬金发生月(YYYYMM)|</font></p>
								<p><font color="RED">PUNISH|JFJM000987|200808|200.00|P-YWWG,P-QTYY,|备注，违规扣罚|200807|</font></p>
								个人专员酬金:
								<p><font color="RED">调整类别|渠道编码|手机号码|作用结算月份(YYYYMM)|调整金额|调整原因类型|备注|酬金发生月(YYYYMM)|</font></p>
								<p><font color="RED">EMPPUNISH|JFJM000987|13133434556|200808|200.00|P-YWWG,P-QTYY,|备注，违规扣罚|200807|</font></p>				
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								1.调整类别<br>
									PUNISH:扣减;RETURN:返还;<br>
									EMPPUNISH:个人专员扣减;EMPRETURN:个人专员返还<br>
								2.调整原因类型<br>
									扣减: P-YWWG:业务违规;P-QTYY 其他原因扣减<br>
									返还:R-DKBH:多扣补还;R-LSBG:漏算补给;R-QTYY:其他原因返还<br>
									(可指定多个原因类型,每个原因类型用半角逗号","间隔,最后用半角逗号","结束),举例:P-CH,或者P-CH,P-PTWG,<br>
								3.所有字段必填,涉及内容有字母的均需大写<br>
								4.酬金发生月:不能填正在结算或未结算的结算月，只能填已经结算过的历史结算月<br>
								5.所有字段均必填，涉及内容有字母的均为大写;调整金额均填写正数<br>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="svwayinfoms" key="redirect" />
							</td>
							<td align=left>
								<a href="<%= contextPath %>/cms/common/importguide.htm">填写指南</a>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="svwayinfoms" key="excelexample" />
							</td>
							<td align=left>
								<a href="<%= contextPath %>/cms/bbc/bbcadjust/bbcadjust.xls">全员代理酬金调整导入模版.xls</a>&nbsp;&nbsp;
								<bean:message bundle="svwayinfoms" key="excelinfo" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">
							
							<input type="button" value="返回" class="back"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="doReturn('/cms/bbc/bbcadjust.do?CMD=UNPBLIST')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
