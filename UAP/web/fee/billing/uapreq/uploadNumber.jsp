<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/contenthead.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>导入文件</title>
<script language="JavaScript" type="text/JavaScript">
function checkFileType(){
	var file = document.getElementsByName("upload")[0];
    if (file != null) {   	 
 		if(file.value != ""){
 			var exName = file.value.substring(file.value.lastIndexOf("."));
 	        if(exName != '.txt'&&exName != '.TXT'){
 	        	var str='<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[' +'上传文件:' + ']</span>' + '请选择.txt文件' + '</span>';
 	        	errorMessageShow (str);
 	        	return false;
 	        }else{
 	           	return true;
 	 	    }
 	    } 	 
    }
}
function ev_checkval() {
	addfield('upload', '上传文件', 'c',false, 200);
	return checkval(window);
}
function doSave(cmdSave) {
	var ret=ev_checkval();
	var reg=checkFileType();
	if (ret && reg) {
	    formItem.action = contextPath + cmdSave;
	    formItem.submit();
	 }
}

function frmSubmit(){
	var infile = document.all.infile.value;
    var filename = document.all.filename.value;
	if(infile == "" || filename == ""){
		alert('请先导入文件');
	}
	else{
		window.returnValue=infile+"|"+filename;
		window.close();
	}
}
</script>
<base target="_self" />
</head>
<body style="background: #ebf2f8;">
<s:form action="/fee/billing/uapreq_upNumber.do" key="formItem" method="post" theme="simple" enctype="multipart/form-data">
<input type="hidden" id="infile" name="infile" value="${requestScope.infile}">
<input type="hidden" id="filename" name="filename" value="${requestScope.filename}">
<div class="widgetL">
<div class="wCenter">
<div class="content">
<div class="search2">
<div class="title_name">导入文件</div>
<aa:zone name="errorZone">	
	   <div class="error_text"><s:actionerror/><s:actionmessage/></div>
</aa:zone> 
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
	<tr>
    	<th>上传文件：</th>
        <td width="80%">
			<input type="file" name="upload" style="width:300px;" onkeypress="return false;"/>
			<s:if test="%{#request.filename != null }">
			已上传文件：<a style="color:red" href='<%=contextPath%>/common/batch/download.jsp?filename=${requestScope.infile}'>${requestScope.filename}</a>
			</s:if>
        </td>
	</tr>
	
	<tr>
        <th>文件类型：</th>
        <td width="80%">txt文本文件（文本里不要留空行和多余的空格）</td>
    </tr>
    <tr>
        <th>文件格式：</th>
        <td width="80%"><font color="red">用户号码</font></td>
    </tr>
    <tr>
        <th>举例说明：</th>
        <td width="80%"><font color="red">13800138000</font></td>
    </tr>
    
    
</table>
<div class="mt30"></div>
<div style="float: right;">
	<input type="button" id="btnSave" onmouseover=this.className="bt48" onMouseOut=this.className="bt48_gray"
           name="btnSave" value="<s:text name="button_upload"/>" class="bt48_gray" onclick="return doSave('/fee/billing/uapreq_upNumber.do')"/>
    <input type="button" id="btnSave" onmouseover=this.className="bt48" onMouseOut=this.className="bt48_gray"
           name="btnSave" value="<s:text name="button_complete"/>" class="bt48_gray" onclick="frmSubmit();"/>                   
</div>
</div>
</div>
</div>
</div>
</s:form>
</body>
</html>
