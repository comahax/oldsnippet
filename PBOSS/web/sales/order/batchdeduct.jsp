<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			
			if(filename != null || filename != ""){
	    		formItem.btnDeal.disabled=true;
				window.location.href="<%=contextPath%>/sales/batchdeduct_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.order.OrderBatchDeductTaskBean";
	    		 
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
		$(document).ready(function(){ 
		        var filename ="<s:property value="fileName" />";// formItem.path.value;
		
		     if(filename == null || filename == '' ){
		    	 $("#btnDeal").attr('disabled',true);
		     }
		     else{
			     $("#btnDeal").attr('disabled',false);
		     }
		     $("#optype").attr('disabled',false);
  		});
  		
  		function showdiv(select){
			var oDiv = select.value;
			
			if(oDiv != ""){
				if(oDiv == "CASH"){
					
					document.getElementById("cash_div1").style.display="none";
					document.getElementById("cash_div2").style.display="none";
					
					document.getElementById("bank_div1").style.display="";
					document.getElementById("bank_div2").style.display="";
				}
				else{
					
					document.getElementById("cash_div1").style.display="";
					document.getElementById("cash_div2").style.display="";
					
					document.getElementById("bank_div1").style.display="none";
					document.getElementById("bank_div2").style.display="none";
				}
			}
		}
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/sales/batchdeduct_upload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" theme="simple"> 

   
    <a id="tt" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">订单管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">批量触发划扣结果短信  </span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" id="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" id="filepath" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.order.OrderBatchDeductCheck">

    <aa:zone name="errorZone">
		<div class="error_text" id="msg">
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
                <td align="right">请选择上传的文件:&nbsp</td>
                <td align="left">
					<s:file name="doc" label="File"/>
                </td>
            </tr>
            <tr>
                <td align="right">处理类型:&nbsp</td>
                <td align="left">
					<j:selector id="optype" name="optype" onchange="showdiv(this)"
									definition="BATCHDEDUCT" mode="selector" />
					<font color="red">*</font>
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
                <td align="right">文件类型:&nbsp</td>
                <td align="left">
					.txt文本文件(文件里不要留空行和多余的空格)
                </td>
            </tr>
	        <tr id="cash_div1" style="display:none">
	            <td align="right">文件格式:&nbsp</td>
	            <td align="left">
			    <font color="red">订单编号</font>
	            </td>
	         </tr>
	         <tr id="cash_div2" style="display:none">
	             <td align="right">举例说明:&nbsp</td>
	             <td align="left">
					<font color="red">GZ0908151000001001</font>
	             </td>
	         </tr>
	         <tr id="bank_div1" style="display:none">
	             <td align="right">文件格式:&nbsp</td>
	             <td align="left">
					<font color="red">失败格式：订单编号|扣费结果|不成功原因|</font><br/>
					<font color="red">成功格式：订单编号|扣费结果||</font>
	             </td>
	         </tr>
	         <tr id="bank_div2" style="display:none">
	             <td align="right">举例说明:&nbsp</td>
	             <td align="left">
					<font color="red">失败格式：GZ0908151000001001|失败|余额不足|</font><br/>
					<font color="red">成功格式：GZ0908151000001001|成功||</font>
                </td>
	        </tr>
            <tr>
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					文件格式中用红色标记字段为必填项，文件内容无标题行
                </td>
            </tr>
        </table>
        </s:i18n>
    </div>
</aa:zone>
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnUpload" name="btnUpload" class="button_2" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="上传" onclick="upload('/sales/batchdeduct_upload.do');"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/sales/batchdeduct_import.do');"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>

<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.order.OrderBatchDeductTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</div>
</body>
</html>
