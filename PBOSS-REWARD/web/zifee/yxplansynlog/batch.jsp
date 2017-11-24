<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C3C1ACC" />
</jsp:include>

<%
    String ID_1 = "3C3C1ACCBT1";
%>

<html:html>
<head>
    <title><bean:message bundle="yxplan" key="upload"/></title>

    <script language="JavaScript">
        function ev_checkval() {
            //addfield('compactno', '<bean:message bundle="yxplan" key="compactno"/>', 'c', false, 17);
            return checkval(window);
        }
        
		function doUpload(urlStr) {
          if (ev_checkval()) {
	         var filename=formItem.inputFile.value;
	         if(filename=="" || filename==null)
	         {
	         	alert('上传文件不能为空');
	         	return false;
	         }
	         var regex=/^.*[\.][tT][xX][tT]$/;
	        if (!regex.exec(filename))
	        {
	       		alert('必须是.txt文本文件');
	       		return false;
	        }
            enable();
            var url=contextPath + urlStr+"CMD=UPLOAD";
            formItem.action = url;
            formItem.submit();
          }
          return false;
        }        
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/zifee/yxplansynlog.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
	<hidden property="cmdState"/>

	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="yxplan" key="batchPlan"/>
					</td>
				</tr>
			</table>
		</div>	
		
		<div class="table_div">
	     <table width="100%" class="error_text">
       	   <s:Msg />
       </table>	
		</div>	
	
	<div class="table_div">
        <table class="form_table">
        	<tr>
			    <td align=left colspan=4>&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/></td>
		    </tr>
            
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="inputfile"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                    <html:file property="inputFile" styleClass="form_input_files"></html:file>
                </td>
            </tr>
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="inputresult"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                	  <html:textarea property="reInfo" readonly="true" styleClass="form_textarea_on"></html:textarea>
                </td>
            </tr>
            <tr>
                <td  align="right" width="14%"><div class="field-require"><bean:message bundle="yxplan" key="batchOperate"/>:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                	<html:select  property="batchaction">
						<html:option value="0">批量同步</html:option>
					</html:select>
                </td>
            </tr>    
  
            <tr>
                <td  align="right" width="14%"><div class="field-require">文件格式:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                       <p><font color=red>营销方案标识</font></p>
                </td>
            </tr>    
            <tr>
                <td  align="right" width="14%"><div class="field-require">举例:</div></td>
                <td colspan="3" align="left" class="form_table_left">
                       75012345678914
                </td>
            </tr>    
        </table>
    </div>
    
		<div class="table_div">
			<table class="table_button_list">
				<tr>
					<td>
						<s:PurChk controlid="<%=ID_1%>">
		          			<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                 			name="btnHelp" onfocus="buttonover(this)" onblur="buttonout(this)"
		                 			value="<bean:message bundle="yxplan" key="batch"/>" class="button_4"
		                 			onclick="doUpload('/zifee/yxplansynlog.do?')">
	         </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplan.do?CMD=LIST')">
					</td>
				</tr>
			</table>
		</div>

</html:form>
</div>
</body>
</html:html>
