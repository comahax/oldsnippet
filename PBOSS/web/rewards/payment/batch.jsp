<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>付款数据上传管理</title>
	<script language="JavaScript" type="text/JavaScript">
	function checkProcess(){
		var filename=formItem.path.value;
		if(filename != null || filename != ""){
      		formItem.buttonProcess.disabled=true;
      		window.location.href="<%= contextPath%>/payment/paymentbatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.reward.payment.PaymentTaskBean";                                                                                        
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
<s:form action="/payment/paymentupload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="酬金管理"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">付款数据上传（财务部）管理</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.reward.payment.PaymentCheck">
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
            	<td align="right" width="10%">选择文件: </td>
            	<td align="left" width="90%"><s:file name="doc" label="File" /></td>
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
				<p><font color=red>业务类型|</font>酬金大类|酬金小类|
				   <font color=red>收款单位名称|银行账户名称|银行名称|开户行（XX支行）|银行账号|</font>
				           对应报账单号|分公司|<font color=red>付款月份|实发金额|</font>批次|对公/对私|备注|结算（出账）月份|
				</p>
				</td>
			</tr>
			<tr>
				<td align="right" height=25>举例说明:</td>
				<td align="left">
                <p><font color=red>个人业务|</font>流量卡酬金|30元流量卡酬金|
                   <font color=red>中域|小明|中国银行|中国银行广州分行花城支行|1234567890987654321|</font>
                   112233445566778899|天河分公司|<font color=red>201501|500|</font>201507第一批|对私|备注|201507|
				</p>
				</td>
			</tr>
			<tr>
				<td align="right" height=25>
					补充说明 
				</td>
				<td align="left">
					实发金额单位：元；上传的文字中不要包含竖线
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
					<a href="<%=contextPath%>/rewards/payment/paymentimport.xls">付款数据上传批量导入模板.xls</a>
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
                           		value="<s:text name="button_return"/>" onclick="doReturn('/payment/payment_list.do')">
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
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.reward.payment.PaymentTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>