<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="�ļ��ϴ�"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(actionUrl){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				formItem.btnDeal.disabled=true;
				document.getElementById("tt").href="<%=contextPath%>/channel/zjtypeopleimport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.zjty.employee.ZjtyPeopleTaskBean";
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
    <script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/zjtypeopleupload.do" cssStyle="formItem" key="formItem" 
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
			<span class="table_toparea">�Խ���Ӫ��Ա����</span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.zjty.employee.ZjtyPeopleCheck">

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
					color=red>�ù�״̬</FONT>|����ѡ���ֻ���|<FONT color=red>boss����|</FONT><BR>(ע:��ɫ����Ϊ����¼���ֶ�) 
                </td>
            </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					|13888888888|����||0|134645|1346|1|JM|JMC|JMSVC1|JFJMCSE02|2007-04-02|1|1|100|1|15013335503(����)|JM4514|

                </td>
            </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					�Ա�:0(��),1(Ů)
					�Ļ��̶�:0(��������),1(����),2(����),3(��ר),4(��ר),5(����),6(˫ѧλ),7(˶ʿ),8(��ʿ),9(��ʿ��),99(����)
					�Ͷ���ϵ:0(δǩ��ͬ),1(��ǩ��ͬ)
					�ù�����:0(��ͬ��),1(��Ƹ��),2(����),3(��ʱ��),99(����)
					�ù�״̬��0(�ڸ�),1(��ְ)
					��������ʱ����Աid��ϵͳ�Զ����ɣ�����Ҫ¼����Աid����һ��Ϊ����|��ͷ
					����˵����|13888888888|����||0|12346879|134645|1346|1|JM|JMC|JMSVC1|JFJMCSE02|2007-04-02|1|1|100|1|15013335503
					�����޸�ʱ����ָ����Աid������������������Ա��Ϣ��Ȼ�󲹳�δ��д����Ϣ��
					����˵����JM10000185|13888888888|����||0|12346879|134645|1346|1|JM|JMC|JMSVC1|JFJMCSE02|2007-04-02|1|1|100|1|15013335503|JM10054 
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
                           value="�ϴ�" onclick="upload('/channel/zjtypeopleupload.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/channel/zjtypeopleimport.do');"/>
                    
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/employee_zjtylist.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.zjty.employee.ZjtyPeopleTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
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
