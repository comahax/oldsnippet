<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>套卡激活管理</title>
	<script language="JavaScript" type="text/JavaScript">
		function checkProcess(){
			var filename=formItem.path.value;
			var filesourcename=formItem.filename.value;

			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/setcard/setcardbatch.do?filename="+filename+"&filesourcename="+filesourcename+"&beanname=com.gmcc.pboss.web.reward.setcard.SetcardTaskBean";                                                                                        
			}
		}
		function upload(){
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				var alertstr = '<span class=\'errorkey\'><li><span style=\'color:#F00; font-size:12px;\'>请选择上传的文件</span></li>';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/setcard/setcardupload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="酬金管理"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">套卡激活管理</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.reward.setcard.SetcardCheck">
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
            	<td align="right">选择文件: 	</td>
            	<td align="left"><s:file name="doc" label="File" /></td>
            </tr>
            <tr>
				<td align="right" height=25>文件类型:</td>
				<td align="left">.txt文本文件 (文本里不要留空行和多余的空格)</td>
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
				<td align="right" height=25>文件格式:</td>
				<td align="left"><p><font color=red>渠道编码|激活日期|号码|地市|渠道类型|</font>品类|</p></td>
			</tr>
			<tr>
				<td align="right" height=25>举例说明:</td>
				<td align="left">
					<font color="red">BBSZ0AZF172|20151130|13711111111|GZ|1|</font>xxxx|
				</td>
			</tr>
			<tr>
				<td align="right" height=25>补充说明:</td>
				<td align="left">
					激活日期：格式 yyyyMMdd（例如：20151130）<br>
					地市：大写拼写首字母（例如：GZ，SZ）<br>
					渠道类型：1-自有渠道，2-社会渠道
				</td>
			</tr>
			
			<tr>
					<td align=right height=25>
						填写指南:
					</td>
					<td align=left>
						<a href="<%=contextPath%>/channel/common/importguide.htm">填写指南</a></td>
			</tr>
			<tr>
					<td align=right height=25>
						Excel填写模板:
					</td>
					<td align=left>
						<a href="<%=contextPath%>/rewards/setcard/setcardimport.xls">套卡激活渠道批量导入模板.xls</a>
						（注：填写后请将数据转换为txt格式，去掉标题行，再上传导入）</td>
					
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
	                            value="<s:text name="button_upload"/>">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="处理">
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn('/setcard/setcard_list.do')">
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
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.reward.setcard.SetcardTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>