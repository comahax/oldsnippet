<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%
	String pk = request.getParameter("pk");//==null?"":request.getParameter("pk");
 %>
<html>
<head>
    <title>批量导入</title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(str){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/promotion/ppzlnptnr_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.promotion.ppzlnptnr.PpzlnptnrTaskBean&pk="+str;
			}
		}
		
		function doUpload()
		{
			var str='<%=pk%>';
			formItem.action="<%=contextPath%>/promotion/ppzlnptnr_upload.do?pk="+str;
			formItem.submit();
		}
		
		function doReturn(str) {
   		 	formItem.action ="<%=contextPath%>/promotion/ppzlnptnr_list.do?param._pk="+str;
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
<s:form action="/promotion/ppzlnptnr_upload.do" method="POST" key="formItem"	cssStyle="formItem"	enctype="multipart/form-data" theme="simple">
	<div class="table_top">
		<input type="hidden" name="pk" value="<%=pk%>"/>
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="promotion"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">批量导入</span>
		</div>
	</div>
    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.promotion.ppzlnptnr.PpzlnptnrCheck">
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
    <aa:zone name="listZone">
    <div class="table_div">
        <table class="table_normal">
            <tr>
            	<td align=right>
            		选择文件： 
            	</td align=left>
            	<td>
            		<s:file name="doc" label="File" /> 
            	</td>
             </tr>
             <tr>
				<td align=right height=25>
						文件类型:
				</td>
				<td align="left">
						.txt文本文件 (文本里不要留空行和多余的空格)
				</td>
				</tr>
            <tr>
            	<td align="right">文件:</td>
            	<td align="left">
            	<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
            	<s:property value="fileName" /> 
            	</a>
            	</td>
            </tr>
			<tr>
				<td align=right height=25>
					文件格式:
				</td>
				<td align=left>
					<font color="red">渠道标识</font>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					举例说明:
				</td>
				<td align=left>
					<font color=red>JFJM00000</font>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					补充说明:
				</td>
				<td align=left>
					渠道类型必须为社会渠道类型[AG].
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
	                        <input type="button" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="上传" onClick="doUpload();">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess(document.all['pk'].value)"
	                            value="导入" > 
	                        <input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="返回"
										onclick="doReturn(document.all['pk'].value)">
	                               
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
</s:form>

<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.promotion.ppzlnptnr.PpzlnptnrTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</div>
</body>
</html>