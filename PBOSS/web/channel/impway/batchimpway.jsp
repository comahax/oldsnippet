<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>���������Ϣ����</title>
	<script language="JavaScript" type="text/JavaScript">
		function checkProcess(){
			var filename=formItem.path.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/channel/impwaybatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.impway.ImpWayTaskBean";                                                                                        
			}
		}
		function upload(){
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				var alertstr = '<span class=\'errorkey\'><li><span style=\'color:#F00; font-size:12px;\'>��ѡ���ϴ����ļ�</span></li>';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/impwayupload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">����������ļ��ϴ�</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.impway.ImpWayCheck">
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
            	<td align="right">ѡ���ļ�: 	</td>
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
				<td align="left"><p><font color=red>��������|��������|�ϼ���������</font>|��������|����������|<font color=red>���й�˾����<br>
					|�ֹ�˾����</font>|�����������ı���|΢�������|�Ǽ�|��Ȧ���ͱ���|<font color=red>�������ͱ���</font>|���澭����ϵ�绰|������������<br>
					|��ϸ��ַ|<font color=red>����γ��|������|��Ӫģʽ</font>|�Ƿ�����|������ʽ|<font color=red>��ҵ��Դ����</font>|�Ƿ���������|�����̱���|�Ƿ���|<br>
					(ע:��ɫ�ֶ�Ϊ������)</p></td>
			</tr>
			<tr>
				<td align="right" height=25>����˵��:</td>
				<td align="left">ZSCS001|��������|TDZS-----|||ZS|ZS0|||||3||||19.261233|123.236133|2|||3||||</td>
			</tr>
			<tr>
				<td align="right" height=25>
					����˵�� 
				</td>
				<td align="left">
					ʱ���ʽΪ:YYYY-MM-DD(��:2007-04-18)<br>
					����������:IMP,���������; <br>
					�Ǽ�:0,δ���Ǽ�;1,һ�Ǽ�;2,���Ǽ�;3,���Ǽ�;4,���Ǽ�;5,���Ǽ�;6,���Ǽ�<br>
					��Ȧ����:1: A����Ȧ 5: B����Ȧ 6: C����Ȧ 7: ����Ȧ 99:����<br>
					��������:0,����;1,����;2,һ������;3,��������;4,��������;99,����<br>
					��Ӫģʽ:0,ֱӪ��;1,���˵�;<br>
					������ʽ:0,����;1,2M����;2,GPRS;3,CSD;4,��������;5,��������<br>
					��ҵ��Դ:0,����;1,������ҵ����;2,���й�˾����;3,�����ҵ��������;<br>
					�Ƿ�����:0,����;1,������;�Ƿ���������:0,��;1,��;�Ƿ���:0,��1,��
				</td>
			</tr>
			<tr>
					<td align=right height=25>
						��дָ��:
					</td>
					<td align=left>
						<a href="<%=contextPath%>/channel/common/importguide.htm">��дָ��</a></td>
			</tr>
			<tr>
					<td align=right height=25>
						Excel��дģ��:
					</td>
					<td align=left>
						<a href="<%=contextPath%>/channel/impway/impwaybatch.xls">�����������������ģ��.xls</a>
						��ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ����룩</td>
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
	                        <input type="button" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_upload"/>" onclick="upload();">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="����">
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn('/channel/impway_list.do')">
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
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.impway.ImpWayTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>