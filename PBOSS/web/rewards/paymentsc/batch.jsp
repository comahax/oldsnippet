<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>出账数据上传（市场部）管理</title>
	<script language="JavaScript" type="text/JavaScript">
	function checkProcess(){
		var filename=formItem.path.value;
		if(filename != null || filename != ""){
      		formItem.buttonProcess.disabled=true;
      		window.location.href="<%= contextPath%>/paymentsc/paymentscbatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.reward.paymentsc.PaymentscTaskBean";                                                                                        
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
<s:form action="/paymentsc/paymentscupload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="酬金管理"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">出账数据上传（市场部）管理</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.reward.paymentsc.PaymentscCheck">
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
            	<td align="right">选择文件: </td>
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
				<td align="left">
				<p><font color=red>渠道编码|结算月份（出账月份）|业务月份（办理月份）|业务类型|酬金大类|酬金小类|</font>手机号码|IMEI号|<font color=red>酬金金额（出账金额）|结算期数（第*期）|</font>备注|</p>
				</td>
			</tr>
			<tr>
				<td align="right" height=25>举例说明:</td>
				<td align="left">
                    <font color=red>ZJLTS0136|201603|201512|个人业务|全球通开户|全球通开户58元|13800138000|355065053311001|88.88|第1期|备注1|</font>
				</td>
			</tr>
			<tr>
				<td align="right" height=25>
					补充说明 
				</td>
				<td align="left">
					酬金金额单位：元；上传的文字中不要包含竖线
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					填写指南:
				</td>
				<td align=left>
					<a href="<%=contextPath%>/channel/common/importguide.htm">填写指南</a>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					Excel填写模板:
				</td>
				<td align=left>
					<a href="<%=contextPath%>/rewards/paymentsc/paymentscimport.xls">出账数据上传（市场部）批量导入模板.xls</a>
					（注：填写后请将数据转换为txt格式，去掉标题行，再上传导入）
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
	                            value="<s:text name="button_upload"/>">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="处理">
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn('/paymentsc/paymentsc_list.do')">
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
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.reward.paymentsc.PaymentscTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>