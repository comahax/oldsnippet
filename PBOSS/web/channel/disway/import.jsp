<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="�ļ��ϴ�"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(actionUrl){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				formItem.btnDeal.disabled=true;
				document.getElementById("tt").href="<%=contextPath%>/channel/diswayimport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.way.DiswayTaskBean";
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
		
		function dataCheck(){
			
			return ture;
		}
		
		
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="/channel/diswayupload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" onSubmit="return dataCheck()">
    <a id="tt" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">������Ӫ�����̹��� </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="file_upload"/></span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.way.DiswayCheck">

    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
	
	<aa:zone name="listZone">
    <div class="table_div">
    <s:i18n name="public">
         <table class="table_normal">
            <tr>
                <td align="right" width=110px>��ѡ���ϴ����ļ�:&nbsp</td>
                <td align="left">
					<s:file name="doc" label="File"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="file_file"/>:&nbsp</td>
                <td align="left">
					<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
					<s:property value="fileName" /> 
            	</a>
                </td>
            </tr>

            <tr>
                <td align="right">�ļ�����:&nbsp</td>
                <td align="left">
					.txt�ı��ļ�(�ļ��ﲻҪ�����кͶ���Ŀո�)
                </td>
            </tr>
            <tr>
                <td align="right">�ļ���ʽ:&nbsp</td>
                <td align="left">

					<FONT 
					color=red>�����̱���|����������|�ϼ���������</FONT>|������|���й�˾|�ֹ�˾|������������|΢����|��˰��ʽ|�����㼶|<BR>��������|<FONT 
					color=red>������|����γ��</FONT>|��ϸ��ַ|<FONT 
					color=red>����������|��������ϵ�绰|�����˵�������|ҵ����ϵ������|</FONT><BR><FONT 
					color=red>ҵ����ϵ����ϵ�绰|ҵ����ϵ�˵�������|��ͬ����|��ͬ����|ǩ���ͬʱ��|��ͬ������</FONT>|���˴���|<BR><FONT 
					color=red>Ӫҵִ�ձ��</FONT>|��Ӫ�������ͱ���|��Ӫ��Χ|<FONT 
					color=red>�����ʺ�|��������|�����˺�����|</FONT>���������֤����|<BR>�ͻ���ַ|�ջ���ϵ��|�ջ���ϵ���� |�ջ���֤������|<FONT 
					color=red>Ӫҵִ����Ч��</FONT>|��֤������|<FONT 
					color=red>��������<BR>|��Чʱ��|ʧЧʱ��</FONT>|������λ|�����̼���|���̺�|֤�����|֤������|ע���ַ|ע���ʽ�|����״̬|����������|�Ǽ�|
                </td>
            </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					JFJMXXXXX|��������|JFJM00000|1|JM|JM|||2|0|1|123.234502|18.234502|���Ž���·101��|����|
					020-31647847|abcd@abc.com|����|0726-98564587|abc@xyz.com|45478|���Ժ�ͬ��Ϣ|1990-12-12|2006-01-02|
					����|abcde12323|1|1|98546|�й�����|��˾XX�ʻ�|1234567897894587|���ݴ��368��|����|
					13888888888|44052418203202235|2009-01-01|1000|2006-01-01|2006-01-02|2006-01-03|����|
					0|A1456|1|4310031982....|���ݺ�����|500|1|0|1|
                </td>
            </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					���ڸ�ʽ:yyyy-mm-dd(����1999-01-01)
					������:0(�й��ƶ�)��1(�й���ͨ)��2(�й�����)��3(�й���ͨ)��4(�й���ͨ)��99(����)
					��Ӫ�������ͱ���:0(���й�˾)��1(�ֹ�˾)��2(������������)��3(΢����)
					��˰��ʽ:0(�ֳ�����)��1(����˰)��2(���Ʊ)
					�����㼶:0(һ���)��1(���ܲ�)��2(��ɢ��)
					���ȣ�γ�ȸ�ʽ����.�֣����磺123.234502. 
					�����̼���:0(ȫ��),1(ʡ��),2(���м�)
					֤�����:0(���֤),1(���ڲ�),2(Ӫҵִ��),3(����),4(����֤),5(ʿ��֤),6(�۰����֤),7(̨��֤),8(����֤),9(ѧ��֤)...99(����֤��)
					������λ�����¿�ѡ��:����������������ͨ���������ġ���ء�����Э�ࡢ�㲨�����͡�����
					����״̬:1(��Ч),0(ʧЧ)  
					����������:0(ֱ����),1(��Ȩ������),2(ר�������),3(��������),4(FD������),5(TD������),6(����ѡ�ź�����)
					�Ǽ�:0(δ���Ǽ�),1(һ�Ǽ�),2(���Ǽ�),3(���Ǽ�),4(���Ǽ�),5(���Ǽ�),6(���Ǽ�)
                </td>
            </tr>
        </table>
        </s:i18n>
    </div>
</aa:zone>
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnUpload" name="btnUpload" class="button_New" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="�ϴ�" onclick="upload('/channel/diswayupload.do')"/>
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_New" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/channel/diswayimport.do');"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn('/channel/way_aglist.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.way.DiswayTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
