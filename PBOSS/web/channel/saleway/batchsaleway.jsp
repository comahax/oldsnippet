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
	      		window.location.href="<%= contextPath%>/channel/salewaybatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.saleway.SalewayTaskBean";                                                                                        
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/channel/saleway_list.do";
    	}
    	<%
    	
    	String param75 = (String)request.getSession().getAttribute("param75");
    	
    	%>
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/salewayupload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">���������Ϣ����</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.saleway.SalewayCheck">
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
				<td align="left"><p><font color=red>��������|��������|�����������|�ϼ���������|�Ǽ�|������|״̬|���й�˾|�ֹ�˾</font>|<br>������������|΢����|<font color=red>�Ƿ�ֱ��|��������</font>|��������|<font color=red>ҵ̬����|Ӫҵ���</font>|<br>����������|������������|<font color=red>�ּ�|���������</font>|ҵ��Ԥ����|<font color=red>��ϸ��ַ|����γ��|<br>������|ҵ������|ҵ���绰</font>|ҵ���̶��绰|ҵ����������|�ͻ���ַ|�ջ���ϵ��|<br>�ջ���ϵ����|�ջ���֤������|<font color=red>ǩԼ����|��ͬ����|��ͬЭ������|ǩ���ͬʱ��|��ͬЭ����Чʱ��|��ͬ������</font><br>|Ӫҵִ�ձ��|Ӫҵִ����Ч��|��֤����|��֤��Ѻ��״̬|<font color=red>��֤������</font><br><font color=red>|���֧����������|���֧�������˺�|���֧���ʺ�����|���������֤����|ǩԼ״̬</font>|��֤�𽻸���ʽ<br/>|<font color=red>��Ӫ��Χ</font>|ȫʡ����|���๺�����������ʺ�|���๺�������˺�����|���๺�����ۿ�������|�����̱���|<font color=red>�Ƿ����B2Mģʽ</font>|�˺�����|<br>���๺���������б�ʶ|���๺����������״̬|��������|����ע����|<font color=red>��Ҫҵ��֧�ŷ�ʽ</font>|<font color=red>�Ƿ������г�ֵƽ̨</font>|ȫ��ͳһ��������|����|������������|�Ƿ���������|ǰ̨Ӫҵ������O��|��Ӫ��ISP���뷽ʽ|<font color=red>�Ƿ����ȫԱ����ģʽ</font>|<font color=red>�Ǽ��ֲ�</font>|<font color=red>��Ȧ����</font>|<font color=red>�Ƿ�TOP����</font>|<font color=red>�����������</font>|<font color=red>������Ȧ����</font>|����������������|������������ϵ��|<font color=red>���õȼ�</font>|<font color=red>˰������</font>|<font color=red>�Ƿ���Ȩ����</font><%if("1".equals(param75)){%>|��ע<%} %>|</p></td>
			</tr>
			<tr>
				<td align="right" height=25>����˵��:</td>
				<td align="left">
					����֧�����ָ�ʽ���������£�<br>1��ֱ�ӡ�ȫ�����ݵ��롿<br>2�����Զ����ļ����롿<br>&nbsp;&nbsp;ֻ���ڸ���������Ϣ����1���г��Զ��嵼�������ƣ���1�б���Ϊ��������<br><br>��ȫ�����ݵ��롿������
					<font color="red">
						ZSCS001|��ɽ��Э��ͨѶ�豸���޹�˾|FDS|TDZS04---|4|-1|1|ZS|ZSCQ|||1|2||3|166|||2|15016128189||��ɽ����ĵ�ַ|23.348482|122.007882|test|13899332200|076011223365|1@1.1|��֪��||||2|HT1236541254|����|2009-11-10|2010-11-10|2010-11-10|1122554411|2010-11-10|||1000|11|11|11|441623197810101|1|0|||||||0|0|20000009|1|GTX||7|0|rfd|����|2|1|89|3|0|1|0|1|1|ZS001|A2|1|0|2|N<%if("1".equals(param75)){%>|��ע<%}%>|<br><br>
					</font>
					���Զ����ļ����롿������<br>��������|��ϸ��ַ<br>JMJF88888|�������»����������·56��<br>JMJF88889|�������»����������·108��
				</td>
			</tr>
			<tr>
				<td align="right" height=25>
					����˵�� 
				</td>
				<td align="left">
					ʱ���ʽΪ��YYYY-MM-DD<br/>�����������PSAL ָ��רӪ�� SAGT ��Լ����� FD FD����� FDS FD������ VWAY��������  JMQD������������ 
					<br/>�Ǽ���0 δ���Ǽ� 1 һ�Ǽ� 2 ���Ǽ� 3 ���Ǽ� 4 ���Ǽ� 5 ���Ǽ� 6 ���Ǽ� 7 3G����ר���Ǽ��������������Ϊ3G����ʱ���Ǽ�����Ϊ7��3G����ר���Ǽ��� 8 �������������Ǽ��������������Ϊ������������ʱ���Ǽ�����Ϊ8���������������Ǽ��� 9 4G����ר���Ǽ��������������Ϊ4G����ʱ���Ǽ�����Ϊ9��4G����ר���Ǽ���  60(ֻ��ï������) 6A:����������ͱ���Ϊ2G����,�����������Ϊָ��רӪ��
					<br/>������:0 ���۵����� 1 ������ 2 ���������� -1 ��������˫����<br/>״̬��0 ʧЧ 1 ��Ч <br/>�Ƿ�ֱ����0 ��ֱ�� 1 ֱ�� <br/>�������ͣ�0 ���� 1 ���� 2 һ������ 3 �������� 4 �������� 99 ����<br/>ҵ̬���ͣ�0 ʡ���ҵ�/ͨѶ���� 1 ���м��ҵ�/ͨѶ���� 2 �����ֻ����۵� 3 �ٻ���<br/>4 ���������� 5 ����/���� 6 С������7 �ӻ���/����ͤ/ҩ��8	����,9	KTV,10	�����,11	���ŷ�����,12	�ֻ�����Ա,99 ����<br/>���������������ڡ��������������������������ѯ¼��<br/>�ּ���1 A�� 2 B�� 3 C�� 99 ����<br/>ǩԼ����\:0 ��ȨЭ�� 1 ֱ��Э�� 2 ֱ��˫����Э�� 3 ����Э�� 4 ����Э�� 99 ����<br/>��֤��Ѻ��״̬��0 δ�˻� 1 �����˻� 2 ȫ���˻�<br/>ǩԼ״̬��0 ���� 1 Ԥ��Լ 2 ע��<br/>��֤�𽻸���ʽ��0 ������ͳһ���� 1 ����֧��<br/>��Ӫ��Χ��0 ��Ӫ 1 ����<br/>�Ƿ����B2Mģʽ��0 �� 1 ��<br/>�˺����ͣ�0 �Թ� 1 ��˽����˽����� 2 ��˽���ÿ� 3 ��˽��ǿ� 4 ��� 5 ��˽���� 6 ������˽��ǿ� 7 ������˽��� 8 ����<br/>���๺���������б�ʶ��ѯ:<j:selector name="form.debankid" definition="#BANK" mode="picker" readonly="true"/><br/>���๺����������״̬: 0ʧЧ  1��Ч<br>��������:�й�˾�ڷֹ�˾�Զ����������(ch_pw_custwaytype)�����õ����<br>�Ƿ���Ȩ���㣺Y:��&nbsp;&nbsp;N:��<br>��Ҫҵ��֧�ŷ�ʽ    0������    1��2M����    2��GPRS    3��CSD    4����������    5����������   6��ר�߽���BOSS    7���������BOSS    8�����г�ֵƽ̨    9����վ����    99������ <br/>�Ƿ������г�ֵƽ̨    0����   1����<br/>������������  0��ʵ����   3��������<br/>�Ƿ���������  0����   1����<br/>��Ӫ��ISP���뷽ʽ  0���ƶ��������  1���ƶ����߽���  2��������Ӫ�̷�ʽ����  3��δ����<br/>�Ƿ����ȫԱ����ģʽ  0����  1����<br/>�Ǽ��ֲ�  1��A  2��B  3��C 
					<br/>��Ȧ���� 1: A����Ȧ 5: B����Ȧ 6: C����Ȧ 7: ����Ȧ 99:����<br/>�Ƿ�TOP����  0����  1����<%if("1".equals(param75)){%><br/>��ע�������˳�����������״̬Ϊ��0��ͣӪҵ��-1�ѹص꣩��ʱ����Ҫ��д�˳�ԭ�򣬲��������˳���ʱ�򡾱�ע�������<%} %>
					<br/>����������ͣ�0:2G���� 1:3G���� 2�������������� 3:4G����
					<br/>�����������Ϊ0��2G������ʱ��������Ȧ��������������Ȧ����ͳһ��0000��
					<br/>�����������Ϊ1��3G������ʱ��������Ȧ���롢���������������ԡ�������������ϵ��������д��
					<br/>�����������Ϊ2�������������������Ǽ�����Ϊ8�� �������������Ǽ���
					<br/>�����������Ϊ3��4G������ʱ��������Ȧ���롢���������������ԡ�������������ϵ��������д�������������������ԡ�ֵΪA+1��רӪ��Ҫ��Ȧ��ʱ������������ͱ���Ϊ��4G�������������������Ϊ��4G�������������������������ԡ�����ΪA1\A2\B1\B2\C1\C2\A+1��
					<br/>���õȼ�  0����ͨ����  1����������  2���쳣���� </br>˰�����ʣ�0��һ����˰�� 1��С��ģ��˰�� 2������</br>
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
					<%if("1".equals(param75)){%>
					<td align=left>
						<a href="<%=contextPath%>/channel/saleway/salewayimport1.xls">���������������ģ��.xls</a>
						��ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ����룩</td>
					<%}else{ %>
					<td align=left>
						<a href="<%=contextPath%>/channel/saleway/salewayimport.xls">���������������ģ��.xls</a>
						��ע����д���뽫����ת��Ϊtxt��ʽ��ȥ�������У����ϴ����룩</td>
					<%} %>
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
	                            value="����">
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn('/channel/saleway_list.do')">
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
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.saleway.SalewayTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>