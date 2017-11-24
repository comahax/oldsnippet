<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>配送单批量业务</title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){			
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.btnDeal.disabled=true;
	    		document.getElementById("importUrl").href="<%=contextPath%>/sales/disform_smssignImport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.disform.BatchSMSSignTaskBean";
	    		document.getElementById("importUrl").click();				
			}
		}
		
		function doUpload(){
			var discomcode = document.all['discomcode'].value;
			if(discomcode==null || discomcode==""){
				alert("配送商不允许置空!");
				return false;
			}else{			
				formItem.action="<%=contextPath%>/sales/disform_smssignUpload.do?discomcode="+discomcode;
				formItem.submit();
			}
		}
		
		$(document).ready(function(){ 
      		 var filename ="<s:property value="fileName" />";

		     if(filename == null || filename == '' ){
		    	 $("#btnDeal").attr('disabled',true);
		     }
		     else{
			      $("#btnDeal").attr('disabled',false);			      
		     }
		     $(":select[name='discomcode']").val('<s:property value="formMap.discomcode" />');
  		 });
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/sales/disform_smssignUpload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" >
    <a id="importUrl" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea">配送单批量业务</span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea_h">批量补发签收短信</span>
		</div>
	</div>
    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.disform.BatchSMSSignCheck">
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
            		请选择上传文件： 
            	</td align=left>
            	<td>
            		<s:file name="doc" label="File" /> 
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
             	<td align="right">
								配送商
								:
							</td>
							<td align="left">
								<j:selector name="discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/><font color=red>*</font>
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
				<td align=left>文件格式中用红色标记字段为必填项，文件内容无标题行
				</td>
			</tr>
        </table>
    </div>
    </aa:zone>
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnUpload" name="btnUpload" class="button_2" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_upload"/>" onclick="doUpload();"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess();"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
	
</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.disform.BatchSMSSignTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>