<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
	<head>
		<title>�Խ���Ӫ��������</title>
		<script language="JavaScript" type="text/JavaScript">
	function checkProcess(){
		var filename = formItem.path.value;
		if(filename != null || filename != ""){
	        formItem.buttonProcess.disabled=true;
	    	document.getElementById("tt").href="<%=contextPath%>/channel/zjtywayinfobatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.zjty.zjtywayinfo.ZjtywayinfoTaskBean";
	    	document.getElementById("tt").click();
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
	function doReturn(cmdReturn) {
	    formItem.action = contextPath + cmdReturn;
	    formItem.submit();
	}
</script>
<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
    <base target="_self">
	</head>
	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
				<s:form action="/channel/zjtywayinfoupload.do"  method="POST" key="formItem"	cssStyle="formItem"	enctype="multipart/form-data" theme="simple">
				<a id="tt" href="#"></a>
				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
						<span class="table_toparea"><s:text name="currentPos"/> </span>
						<span class="table_toparea_xi">&gt;</span>
						<span class="table_toparea"><s:text name="channel"/> </span>
						<span class="table_toparea_xi">&gt;</span>
						</s:i18n>
						<span class="table_toparea_h">�����Խ���Ӫ��Ϣ������������</span>
					</div>
				</div>
				<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
			    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
			    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.zjty.zjtywayinfo.ZjtywayinfoCheck">
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
							<td  align="right">
								ѡ���ļ�: 
							</td>
							<td align="left">
								<s:file name="doc" label="File" />
							</td>
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
						
						<tr >
							<td align=right height=25>
								�ļ���ʽ:
							</td>
							<td align=left>
								<font color="red">����|��������|�ϼ�����</font>|���������|<font color="red">����������</font>|������|�ֹ�˾|������������|΢����|�Ǽ�|�Ƿ�����|������ʽ|<font color="red">��ҵ��Դ����</font>|<br>
								<font color="red">��Ȧ����|��������</font>|���澭����ϵ�绰|��������|<font color="red">����γ��|������|��ϸ��ַ</font>|����״̬|�Ƿ���������|�����̱���|�Ƿ���|ȫ��ͳһ��������|����|������������|<br>
								�Ƿ���������|ǰ̨Ӫҵ������O��|�����ŶӽкŻ�|����POS��|����24Сʱ����Ӫҵ��|����VIPרϯ|����VIP��|4G���������|<font color="red">ί�з���˾����</font>|<br>
								<font color="red">����ע���|���˴���</font>|���֤����|<font color="red">ǩԼ���|Э��ǩ����Чʱ��|Э���ֹʱ��|�����˵绰|Э������|ǩԼʱ��|</font>
						</tr>
						<tr >
							<td align=right height=25>
								����˵��:
							</td>
							<td align=left>
							SQD001289|TESTNAME|SDGDK1---||6||||||||0|1|0|||28.786698|113.878032|�й��㶫|0|||||||||||||||���˵���|sa123|����||123|2012-02-06|2013-02-06|13612362365|Э������|2012-02-06|</td>
						</tr>
						<tr >
							<td align=right height=25>
								����˵�� 
							</td>
							<td align=left>								
									������ֻ������ĸ+���ֻ���'-'<br>���������5-��ͨ100Ӫҵ��<br>
									���й�˾��DG-��ݸ�й�˾ �ȵ�<br>
									�Ǽ���0-δ���Ǽ���1-һ�Ǽ�  �ȵ�<br>
									�Ƿ�������0-������1-δ����<br>
									������ʽ��0-���£�1-2M���£�2-GPRS��3-CSD��4-����������5-�������ţ�6-ר�߽���BOSS��7-�������BOSS��8-���г�ֵƽ̨��9-��վ���룬99-����<br>
									��ҵ��Դ���ࣺ0-����,2-���й�˾����,3-�����ҵ��������<br>
									��Ȧ���ͣ�1: A����Ȧ 5: B����Ȧ 6: C����Ȧ 7: ����Ȧ 99:����<br>
									�������ͣ�0-����,1-����,2-һ������,3-��������,4-��������,5-������,99-����<br>
									����״̬��0-ʧЧ,1-��Ч<br>
									�Ƿ�����������0-��1-��<br>
									�Ƿ���0-��1-��<br>
									������������:0-ʵ����,3-������<br>
									�Ƿ���������:0-��,1-��<br>
									�����ŶӽкŻ�:0-��,1-��<br>
									����POS��:0-��,1-��<br>
									����24Сʱ����Ӫҵ��:0-��,1-��<br>
									����VIPרϯ:0-��,1-��<br>
									����VIP��:0-��,1-��<br>
								
								</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								��дָ��:
							</td>
							<td align=left>
								<a href="<%=contextPath%>/channel/common/importguide.htm">��дָ��</a></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								Excel��дģ��:
							</td>
							<td align=left>
								<a href="<%=contextPath%>/channel/zjty/zjtywayinfo/zitywayinfoimport.xls">�����Խ���Ӫ��Ϣ������������ģ��.xls</a>
								(ע:��д���뽫����ת��Ϊtxt��ʽ,ȥ��������,���ϴ�����) </td> 
						</tr>
					</table>
				</div>
			</aa:zone>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<s:i18n name="public">
						<td>							
							<input type="submit" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<s:text name="button_upload"/>">
							<input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="����">
                            <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                   	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                          		value="<s:text name="button_return"/>" onclick="doReturn('/channel/zjtywayinfo_list.do')">
						</td>
						</s:i18n>
					</tr>
				</table>
			</div>
			</s:form>
			<div class="table_div">
					<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.zjty.zjtywayinfo.ZjtywayinfoTaskBean"  frameborder="0" class="loadframe" id="loadframe"  scrolling="no"></iframe>
			</div>
		</div>
	</body>
</html>
