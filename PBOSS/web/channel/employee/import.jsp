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
				document.getElementById("tt").href="<%=contextPath%>/channel/employeeimport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.employee.EmployeeTaskBean";
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
<s:form action="/channel/employeeupload.do" cssStyle="formItem" key="formItem" 
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
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.employee.EmployeeCheck">

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

					BOSS����|<FONT color=red>����</FONT>|��������|�Ա�|����|������ò|��ͥסַ|<FONT color=red>���֤����</FONT>|�ֻ���|<FONT color=red>���˵�������</FONT>|<BR>��˾ר����ϵ��ʽ|�Ļ��̶�|רҵ|<FONT 
color=red>���й�˾</FONT>|<FONT color=red>�ֹ�˾</FONT>|������������|΢����|<FONT color=red>������������������</FONT>|��������˾|<FONT 
color=red>��λ</FONT>|<BR>��λ����|ְ��|���ڲ���|��ҵʱ��|��ҵԺУ|��ְʱ��|�Ͷ���ϵ|�ù�����|<FONT color=red>�ù�״̬</FONT>|�μӹ�������|<BR>����˾��������|����״��|<FONT color=red>�����ֻ�����</FONT>|
                </td>
            </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					testcode|test|1980-01-01|1|1|0|0|440524198002202437|13666666666|test@163.com|020-88888888|
					8| |JM|JMA| | |JFJMAAA00| |60|1|3| |2004-06-30|���ݴ�ѧ|2006-01-01|0|1|1|2|1|1|13635548143|
                </td>
            </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					��λ:60-��������,64-ս�Բ���������,65-���ܲ���������
					������ò:0-�й���Ա,1-�й�Ԥ����Ա,2-������Ա,3-����Ա,4-������Ա,5-�񽨻�Ա,6-�����Ա,
					7-ũ������Ա,8-�¹�����Ա,9-����ѧ����Ա,10-̨����Ա,11-�޵�����ʿ,99-Ⱥ��
					�Ļ��̶�:0-��������,1-����,2-����,3-��ר,4-��ר,5-����,6-˫ѧλ,7-˶ʿ,8-��ʿ,9-��ʿ��
					�ù�����:0-��ͬ��,1-��Ƹ��,2-����,3-��ʱ��,99-����
					ְ��:0-����,1-�м�,2-���߼�,3-���߼�,4-����
					���᣺1-�㶫��2-������99-����
					�Ͷ���ϵ:0-δǩ��ͬ,1-��ǩ��ͬ
					�ù�״̬:0-�ڸ�,1-��ְ
					�Ա�:0-��,1-Ů
					��λ����:1-����
					����״��:0-δ��,1-�ѻ� 
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
                           value="�ϴ�" onclick="upload('/channel/employeeupload.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_New" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/channel/employeeimport.do');"/>
                           
                           <input type="button"  id="btnBack" name="btnBack" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="window.location.href='/channel/employee_list.do?processType=MANAGER';"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.employee.EmployeeTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
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
