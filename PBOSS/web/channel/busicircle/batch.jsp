<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>�ļ��ϴ�</title>
	<script language="JavaScript" type="text/JavaScript"> 
		    
	    function checkProcess(){
			var filename = formItem.path.value;
			
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/channel/busicircle_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.busicircle.BusicircleTaskBean";
			}
		}
		
		 function upload(actionUrl){
			formItem.action=actionUrl;
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>��ѡ���ϴ����ļ�</span> ';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
		
		function doReturn() {
   		 	formItem.action ="<%=contextPath%>/channel/busicircle_list.do";
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
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/busicircle_upload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">�ļ��ϴ�</span>
		</div>
	</div>
 
	<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.busicircle.BusicircleCheck">
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
            	<td align="right">��ѡ���ϴ����ļ�: 	</td>
            	<td align="left"><s:file name="doc" label="File" /></td>
            </tr>
            <tr>
				<td align="right" height=25>�ļ�����:</td>
				<td align="left">.txt�ı��ļ� (�ı��ﲻҪ�����кͶ���Ŀո�)</td>
			</tr>
            <tr>
            	<td align="right">�ļ�:</td>
            	<td align="left">
            	<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
            	<s:property value="fileName" /> 
            	</a>
            	</td>
            </tr>
			<tr>
				<td align="right" height=25>�ļ���ʽ:</td>
				<td align="left"><font color=red>��Ȧ����</font>|��Ȧ����|<font color=red>��Ȧ����</font>|<font color=red>�ֹ�˾</font>|��Ȧ��ַ|</td>
			</tr>
			<tr>
				<td align="right" height=25>����˵��:</td>
				<td align="left"> 
					<font color="red">GZ001</font>|��ӷֹ�˾�μ���Ȧ|<font color="red">B</font>|<font color="red">GZTH</font>|���ݴ����368�ź���|
				</td>
			</tr>
			<tr>
				<td align="right" height=25>
					����˵�� 
				</td>
				<td align="left">
					��Ȧ����A-������Ȧ��B-�μ���Ȧ��C-��Ե��Ȧ<br/> 
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
	                    <s:i18n name="public">
	                        <input type="submit" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_upload"/>" onClick="upload('/channel/busicircle_upload.do')">
	                            
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="����">
	                            
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn()">
                        </s:i18n>
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.busicircle.BusicircleTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>