<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="�ļ��ϴ�"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(actionUrl){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				formItem.btnDeal.disabled=true;
				document.getElementById("tt").href="<%=contextPath%>/channel/societypeopleimport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.employee.SocietyPeopleTaskBean";
	    		document.getElementById("tt").click();
			}
		}
		
		function upload(actionUrl){
			var param92 = document.getElementById("param92").value;
			if (param92 != null && param92 != "") {
				document.getElementById("paramMap_param92").value = param92;
			}
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
    <script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/societypeopleupload.do" cssStyle="formItem" key="formItem" 
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
			<span class="table_toparea_h"><s:text name="file_upload"/></span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <s:hidden name="param92" id="param92"></s:hidden>
    <s:hidden name="paramMap.param92" id="paramMap_param92"></s:hidden>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.employee.SocietyPeopleCheck">

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
					<FONT color=blue>��ԱID|</FONT><FONT color=red>���������</FONT>|<FONT 
					color=red>����</FONT>|��������|<FONT 
					color=red>�Ա�</FONT>|<FONT color=red>���֤����</FONT>|���˵�������|�Ļ��̶�|<FONT 
					color=red>���й�˾</FONT>|<BR><FONT color=red>�ֹ�˾</FONT>|������������|<FONT 
					color=red>��������</FONT>|<FONT color=red>��ְʱ��</FONT>|<FONT 
					color=red>�Ͷ���ϵ</FONT>|<FONT color=red>�ù�����</FONT>|��֤��|<FONT 
					color=red>�ù�״̬</FONT>|����ѡ���ֻ���|����<s:if test="{param92 == 1 || paramMap.param92 == 1}">|�Ƿ�Ϊ����</s:if><s:elseif test="{#request.parameterMap.param92 == 1}">|�Ƿ�Ϊ����</s:elseif><BR>(ע:��ɫ����Ϊ����¼���ֶ�) 
                </td>
            </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					<FONT color=red>��������ʱ����Աid��ϵͳ�Զ����ɣ�����Ҫ¼����Աid����һ��Ϊ����|��ͷ</FONT><BR>
					����˵����|13888888888|����||0|12346879|134645|1|JM|JMC|JMSVC1|JFJMCSE02|2007-04-02|1|1|100|1|15013335503|JM10054<s:if test="{param92 == 1 || paramMap.param92 == 1}">|0</s:if><s:elseif test="{#request.parameterMap.param92 == 1}">|0</s:elseif><BR>
					<FONT color=red>�����޸�ʱ����ָ����Աid������������������Ա��Ϣ��Ȼ�󲹳�δ��д����Ϣ��</FONT><BR>
					����˵����JM10000185|13888888888|����||0|12346879|134645|1|JM|JMC|JMSVC1|JFJMCSE02|2007-04-02|1|1|100|1|15013335503|JM10054<s:if test="{param92 == 1 || paramMap.param92 == 1}">|0</s:if><s:elseif test="{#request.parameterMap.param92 == 1}">|0</s:elseif>
					<s:if test="{param92 == 1 || paramMap.param92 == 1}">
						<BR><FONT color=red>�Զ��嵼�룺���Ը�����ԱID���޸Ĵ������ݵ������κ���Ϣ</FONT><BR>
						����˵��(�Զ��嵼��)��ʽ��<BR>
						��ԱID|����<BR>
						ZS1002420|��С��
					</s:if>
					<s:elseif test="#request.parameterMap.param92 == 1">
						<BR><FONT color=red>�Զ��嵼�룺���Ը�����ԱID���޸Ĵ������ݵ������κ���Ϣ</FONT><BR>
						����˵��(�Զ��嵼��)��ʽ��<BR>
						��ԱID|����<BR>
						ZS1002420|��С��
					</s:elseif>
                </td>
            </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					�Ա�:0(��),1(Ů)<BR>
					�Ļ��̶�:0(��������),1(����),2(����),3(��ר),4(��ר),5(����),6(˫ѧλ),7(˶ʿ),8(��ʿ),9(��ʿ��),99(����)<BR>
					�Ͷ���ϵ:0(δǩ��ͬ),1(��ǩ��ͬ)<BR>
					�ù�����:0(��ͬ��),1(��Ƹ��),2(����),3(��ʱ��),99(����)<BR>
					�ù�״̬��0(�ڸ�),1(��ְ)<BR>
					�Ƿ�Ϊ������0(��Ա),1(����)<br>
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
                    <input type="button" id="btnUpload" name="btnUpload" class="button_2" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="�ϴ�" onclick="upload('/channel/societypeopleupload.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/channel/societypeopleimport.do');"/>
                    
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/employee_societylist.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.employee.SocietyPeopleTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
<script type="text/javascript">
<!--

 function showDelButton(){
 var filename = formItem.filename.value;
        if(filename == null || filename == '' ){
        $("#btnDeal").attr('disabled',true);
        }
        else{
         $("#btnDeal").attr('disabled',false);
         }
        }
        showDelButton();
        
//-->
</script>
