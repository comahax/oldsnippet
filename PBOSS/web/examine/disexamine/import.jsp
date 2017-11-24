 <%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>配送商考核管理</title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				 $("#btnDeal").attr('disabled',true);
	    		formItem.btnDeal.disabled=true;
	    		document.getElementById("importUrl").href="<%=contextPath%>/examine/disexamine_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.examine.disexamine.DisexamineTaskBean";
	    		document.getElementById("importUrl").click();
				
			}
		}
		
		 function upload(actionUrl){
			formItem.action=actionUrl;
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择上传的文件</span> ';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
		
		function doReturn() {
   		 	formItem.action ="<%=contextPath%>/examine/disexamine_list.do";
   			formItem.submit();
		}
	 
  $(document).ready(function(){ 
       var filename ="<s:property value="fileName" />";

	     if(filename == null || filename == '' ){
	    	 $("#btnDeal").attr('disabled',true);
	     }
	     else{
		      $("#btnDeal").attr('disabled',false);
		      
	      }
        var typeid='${param.typeid}';
        if(typeid==""){
        	$(":hidden[name='typeid']").val('${parameterMap.typeid}');
        	$(":hidden[name='typecode']").val('${parameterMap.typecode}');
        	$(":hidden[name='typename']").val('${parameterMap.typename}');
        	$("#typeidTD").text('${parameterMap.typeid}');
        	$("#typecodeTD").text('${parameterMap.typecode}');
        	$("#typenameTD").text('${parameterMap.typename}');
        }
   });
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="/examine/disexamine_upload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" >
    <a id="importUrl" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="examine"/></span>
			<span class="table_toparea_xi">></span>
			 
			</s:i18n>
		<span class="table_toparea_h">配送商考核管理</span>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="typeid" value='${param.typeid}'>
    <input type="hidden" name="typecode" value='${param.typecode}'>
    <input type="hidden" name="typename" value='${param.typename}'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.examine.disexamine.DisexamineCheck">
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
         	 
            <tr >
                <td align="right">请选择上传文件:&nbsp</td>
                <td align="left">
					<s:file name="doc" label="File"/>
                </td>
            </tr>
            
            <tr >
                <td align="right"><s:text name="file_file"/>:&nbsp</td>
                <td align="left">
					<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
					<s:property value="fileName" /> 
            	</a>
                </td>
            </tr>
            
             <tr>
                <td align="right">文件类型:&nbsp</td>
                <td align="left">
					.txt文本文件(文件里不要留空行和多余的空格)
                </td>
            </tr> 
              <tr>
                <td align="right">文件格式:&nbsp</td>
                <td align="left">

					<FONT color=red>配送商编码|考核周期|扣罚金额|原因</FONT>
                </td>
            </tr>
           
            <tr >
                <td align="right"><s:text name="file_format"/>:&nbsp</td>
                <td align="left">
                	 <font color=red>
						举例说明:
					</font>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_example"/>:&nbsp</td>
                <td align="left">
					<font color=red>
						 TDZS04D1D1000|201112|20.5|违规
					</font>
                </td>
            </tr>
             <tr >
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
                	 文件格式中用红色标记的字段为必须填项，文件内容无标题行
                	 考核周期为yyyyMM格式，例如2011年2月，则是201102
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
                    <input type="submit" id="btnUpload" name="btnUpload" class="button_New" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_upload"/>" onclick="upload('/examine/disexamine_upload.do');"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_New" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess();"/>
                           
                    <input type="button" id="btnReturn" name="btnReturn"class="button_Back" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
						value="返回" onclick="doReturn()">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
 <iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.examine.disexamine.DisexamineTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
 