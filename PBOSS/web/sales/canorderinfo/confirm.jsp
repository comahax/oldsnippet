<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
<title>�����Ͷ������ݼ�ȷ��</title>
<script language="JavaScript" type="text/JavaScript">
 function doNoticeOneCancel() {
	formList.action="<%=contextPath%>/sales/canorderinfo_noticeOneCancel.do";
    formList.submit();
    window.close();
 }
 function doNoticeOneSend() {
	//formList.action="<%=contextPath%>/sales/canorderinfo_noticeOneSend.do";
    //formList.submit();
    $.post("<%=contextPath%>"+"/sales/canorderinfo_noticeOneSend.do",
         //URL
        {},
	
	//ʵ�������л�ת����key1=value1&key2=value2,�������Ҳ��ֱ��д�����ָ�ʽ
        	function(data){//Response���غ�Ļص�������dataΪ����ֵ
        		
				var strs=data.split("&&");//����ֵ���ж���ֶ����split
        		if('noticeOneSendDisable'==strs[0]){
        			formList.noticeOneSend.disabled = true;        			
        		}
        		$("#message").text(strs[1]); 
        		return;
        	}
 	);
 }
 
  function  doNoticeOneSendDisable(){
  <%
  String noticeOneSend = (String)request.getAttribute("noticeOneSend");
        	
  if("noticeOneSendDisable".equals(noticeOneSend)){%>
      formList.noticeOneSend.disabled = true;
  <%}
  %>
}

</script>

</head>
<body class="list_body">
<s:form key="formList" cssStyle="formList" theme="simple" >
	<br>
	<body class="list_body">	
	<div class="table_container">
	<div class="table_div">
        <table class="table_style">
        	<tr class="table_style_head" align="center">
				<td>�����Ͷ��Ž��պ���</td>
				<td>�����Ͷ������ݼ���ʾ</td>
			</tr>
            <tr class="table_style_content">
            	<td ><%=request.getSession().getAttribute("officetel")%></td>
                <td width="440" style="text-align:left;" nowrap>
                	�����Ͷ�������Ϊ[
                	<%=request.getSession().getAttribute("smsContent")%>
                	]��ȷ��Ҫ����ô���������ȷ���������������ֹ��
                </td>
            </tr>            
        </table>
    </div>
    </div>
    <br>
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
    
    <div class="table_div">
		<table >
			<tr>
				<td>
				<input type="button" id="noticeOneSend" name="noticeOneSend" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="����" onClick="doNoticeOneSend();"/>
                
                <input type="button" id="noticeOneCancel" name="noticeOneCancel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="�ر�" onClick="doNoticeOneCancel();"/>
               </td>
			</tr>
		</table>
	</div>
	<div class="error_text" id="message" />
    

</s:form>
</body>
</html>