<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
<title>待发送短信内容及确认</title>
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
	
	//实际请求中会转换成key1=value1&key2=value2,请求参数也可直接写成这种格式
        	function(data){//Response返回后的回调函数，data为返回值
        		
				var strs=data.split("&&");//返回值可有多个字段如此split
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
				<td>待发送短信接收号码</td>
				<td>待发送短信内容及提示</td>
			</tr>
            <tr class="table_style_content">
            	<td ><%=request.getSession().getAttribute("officetel")%></td>
                <td width="440" style="text-align:left;" nowrap>
                	待发送短信内容为[
                	<%=request.getSession().getAttribute("smsContent")%>
                	]，确认要发送么？”，如果确认则继续，否则终止。
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
                        value="发送" onClick="doNoticeOneSend();"/>
                
                <input type="button" id="noticeOneCancel" name="noticeOneCancel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="关闭" onClick="doNoticeOneCancel();"/>
               </td>
			</tr>
		</table>
	</div>
	<div class="error_text" id="message" />
    

</s:form>
</body>
</html>