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
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>��ѡ���ϴ����ļ�</span> ';
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
			<span class="table_toparea">�������� </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">�����������۽������  </span>
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
                <td align="right">��ѡ���ϴ����ļ�:&nbsp</td>
                <td align="left">
					<s:file name="doc" label="File"/>
                </td>
            </tr>
            <tr>
                <td align="right">��������:&nbsp</td>
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
                <td align="right">�ļ�����:&nbsp</td>
                <td align="left">
					.txt�ı��ļ�(�ļ��ﲻҪ�����кͶ���Ŀո�)
                </td>
            </tr>
	        <tr id="cash_div1" style="display:none">
	            <td align="right">�ļ���ʽ:&nbsp</td>
	            <td align="left">
			    <font color="red">�������</font>
	            </td>
	         </tr>
	         <tr id="cash_div2" style="display:none">
	             <td align="right">����˵��:&nbsp</td>
	             <td align="left">
					<font color="red">GZ0908151000001001</font>
	             </td>
	         </tr>
	         <tr id="bank_div1" style="display:none">
	             <td align="right">�ļ���ʽ:&nbsp</td>
	             <td align="left">
					<font color="red">ʧ�ܸ�ʽ���������|�۷ѽ��|���ɹ�ԭ��|</font><br/>
					<font color="red">�ɹ���ʽ���������|�۷ѽ��||</font>
	             </td>
	         </tr>
	         <tr id="bank_div2" style="display:none">
	             <td align="right">����˵��:&nbsp</td>
	             <td align="left">
					<font color="red">ʧ�ܸ�ʽ��GZ0908151000001001|ʧ��|����|</font><br/>
					<font color="red">�ɹ���ʽ��GZ0908151000001001|�ɹ�||</font>
                </td>
	        </tr>
            <tr>
                <td align="right">����˵��:&nbsp</td>
                <td align="left">
					�ļ���ʽ���ú�ɫ����ֶ�Ϊ������ļ������ޱ�����
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
                           value="�ϴ�" onclick="upload('/sales/batchdeduct_upload.do');"/>
                    
                   
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
