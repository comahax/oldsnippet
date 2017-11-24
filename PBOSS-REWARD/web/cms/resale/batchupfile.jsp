<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><bean:message bundle="orderdetailquery" key="orderdetailquerytitle" /></title>
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
	    function doReturn(cmdReturn) {
    	formItem.action = contextPath + cmdReturn;
    	formItem.submit();
		}
    </script>
	<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	</head>

	<body  onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/resale/batchintask.do" enctype="multipart/form-data" styleId="formItem">
   		        <iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								<bean:message bundle="resale" key="title" />
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
								<bean:message bundle="resale" key="resaleexample"/>
							</td> 
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								<bean:message bundle="resale" key="example" />
							</td> 
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="resale" key="exinfos" />:
							</td>
							<td align=left>
								 <bean:message bundle="resale" key="exinfo" /><br>
								 <bean:message bundle="resale" key="exinfo1" /><br>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="resale" key="redirect" />:
							</td>
							<td align=left>
								<a href="<%= contextPath %>/cms/common/importguide.htm"><bean:message bundle="resale" key="redirect" /></a>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="resale" key="excelexample" />:
							</td>
							<td align=left>
								<a href="<%= contextPath %>/cms/resale/resale.xls"><bean:message bundle="resale" key="excel" />.xls</a>&nbsp;&nbsp;
								<bean:message bundle="resale" key="excelinfo" />
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
									ID="buttonUpload" NAME="buttonUpload" onclick="return checkfilename()"/>
								
							<input type="button" value="·µ»Ø" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="doReturn('/cms/resale.do?CMD=LIST')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
