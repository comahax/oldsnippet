<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
<title>填写网点退出原因</title>
<script language="JavaScript" type="text/JavaScript">

  function doDeleteByMemo(){
    var memo = document.all('memo').value;
 	if(memo == "" || null ==memo){
 		alert("网点退出原因，必需填写");
 		return ;
 	}
 
 	if(window.confirm("确定要删除这些记录吗")){
	 	formList.action="<%=contextPath%>/channel/saleway_deleteByMemo.do";
	 	formList.submit();
	 	window.close();
 	}
 	
 }
</script>

</head>
<body class="list_body">
<s:form action="saleway_deleteByMemo.do" key="formList" cssStyle="formList" theme="simple">
	<br>
	<body class="list_body">	
	<div class="table_container">
	<div class="table_div">
        <table class="table_style">
        	<tr class="table_style_head" align="center">
				<td>网点退出原因</td>
			</tr>
            <tr class="table_style_content">
            	<td ><s:textfield cssStyle="style_input" name="memo"  maxlength="256" /></td>
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
                        value="<s:text name="button_delete"/>" onClick="doDeleteByMemo();"/>
                
                <input type="button" id="noticeOneCancel" name="noticeOneCancel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="关闭" onClick="window.close();"/>
               </td>
			</tr>
		</table>
	</div>
	<div class="error_text" id="message" />
    

</s:form>
</body>
</html>