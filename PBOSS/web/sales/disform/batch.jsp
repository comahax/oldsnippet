<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>批量导入</title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/sales/disform_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.disform.DisformTaskBean";
			}
		}
		
		function doUpload(optype, discomcode)
		{
			if((optype==null || optype=="") || (discomcode==null || discomcode=="")){
				alert("配送商和操作类型不允许置空!");
				return false;
			}else{
			
			formItem.action="<%=contextPath%>/sales/disform_upload.do?optype="+optype+"&discomcode="+discomcode;
			formItem.submit();
			}
		}
		
		function doReturn() {
   		 	formItem.action ="<%=contextPath%>/sales/disform_show.do";
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
<s:form action="/sales/disform_upload.do" method="POST" key="formItem"	cssStyle="formList"	enctype="multipart/form-data" theme="simple">
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea">配送单管理</span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea_h">批量更新</span>
		</div>
	</div>
    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.disform.DisformCheck">
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
             	<td align="right">
								配送商
								:
							</td>
							<td align="left">
								<j:selector name="disComcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
								<font color="red">*</font>
							</td>
             	</tr>
             	<tr>
             		<td align="right">
								操作类型
								:
							</td>
							<td align="left">
								<j:selector name="optype"
									definition="DISFORMOPERATETYPE" mode="selector" /><font color="red">*</font>
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
					<font color="red">配送单</font>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					举例说明:
				</td>
				<td align=left>
					<font color=red>100234</font>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					补充说明 
				</td>
				<td align=left>
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
	                        <input type="button" id="btnBatch" name="btnBatch" class="button_2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="上传" onClick="doUpload(document.all['optype'].value,document.all['disComcode'].value);">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="导入" disabled="true"> 
	                        <input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="返回"
										onclick="doReturn()">
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
</s:form>

<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.disform.DisformTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</div>
</body>
</html>