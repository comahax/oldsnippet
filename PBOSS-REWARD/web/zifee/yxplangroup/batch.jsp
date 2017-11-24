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
          	var cmd="";
          	var select=document.getElementById("batchcmd").value;
          	if(select=='0'){
          		cmd="CMD=BATCHADD";
          	}else if(select=='1'){
				//cmd="CMD=BATCHUPDATE"          		
				cmd="CMD=BATCHQUERYGROUP";
          	}else if(select=='2'){
				cmd="CMD=BATCHDELETE";    		
          	}else if(select=='3'){
          		cmd="CMD=BATCHQUERYMEM";
          	}else {
				cmd="CMD=BATCHQUERYALL";          	
          	}
              enable();
              formItem.action = contextPath + urlStr+cmd;
              formItem.submit();
          }
          return false;
        }
        
    </script>
</head>
<body onload="loadforiframe();">
<div class="table_container">
<html:form action="/zifee/yxplangroup.do?CMD=BATCH" styleId="formItem" method="post" enctype="multipart/form-data">
	<html:hidden property="cmdState"/>
	<html:hidden property="groupyxplan"/>
	 <div class="table_div">
		 <table class="top_table">
				<tr>
					<td>
						<bean:message bundle="yxplan" key="upload"/>
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
			    <td align=left colspan=2>&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/></td>
		    </tr>
            
            <tr>
                <td  align="right" width="18%"><div class="field-require"><bean:message bundle="yxplan" key="inputfile"/>:</div></td>
                <td align="left" class="form_table_left">
                    <html:file property="inputFile" styleClass="form_input_files"></html:file>
                </td>
            </tr>
            <tr>
                <td  align="right" width="18%"><div class="field-require"><bean:message bundle="yxplan" key="inputresult"/>:</div></td>
                <td align="left" class="form_table_left">
                	  <html:textarea property="reInfo" readonly="true" styleClass="form_textarea_on_4"></html:textarea>
                </td>
            </tr>  
            <tr>
                <td  align="right" width="18%"><div class="field-require"><bean:message bundle="yxplan" key="batchOperate"/>:</div></td>
                <td align="left" class="form_table_left">
                	<SELECT NAME="batchaction" ID="batchcmd" SIZE="1" STYLE="width:200px">
						<OPTION VALUE="0" SELECTED><bean:message bundle="yxplan" key="batchAdd"/>
						<OPTION VALUE="1"><bean:message bundle="yxplan" key="batchQuery_group"/>
						<OPTION VALUE="3"><bean:message bundle="yxplan" key="batchQuery_mem"/>
						<OPTION VALUE="4"><bean:message bundle="yxplan" key="batchQuery_all"/>
						<OPTION VALUE="2"><bean:message bundle="yxplan" key="batchDelete"/>
					</SELECT>

                </td>
            </tr>    
            <tr>
                <td  align="right" width="18%"><div class="field-require"><bean:message bundle="yxplan" key="inputhelp"/>:</div></td>
                <td align="left" class="form_table_left">
                       <p>批量新增、批量删除：<font color=red>营销方案组标识|营销方案标识|</font></p>
                       <p>批量查询（根据营销方案组标识）：<font color=red>营销方案组标识|</font></p>
                       <p>批量查询（根据营销方案标识）：<font color=red>营销方案标识|</font></p>
                       <p>全量查询可以不必导入文件</p>
                       <p>(注：红色字体为必须录入字段)</p>
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
		                 			onclick="doUpload('/zifee/yxplangroup.do?')">
	         			</s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplangroup.do?CMD=LIST&PK=<c:out value="${requestScope['/zifee/yxplangroup/YxPlanGroupForm'].groupyxplan}"/>')">
                           

					</td>
					
				</tr>
			</table>
		</div>

</html:form>
</div>
</body>
</html:html>
