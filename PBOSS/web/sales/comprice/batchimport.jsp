<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>��������</title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/sales/comprice_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.comprice.CompriceTaskBean";
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
		
		function doReturn() {
   		 	formItem.action ="<%=contextPath%>/sales/comprice_list.do";
   			formItem.submit();
		}
		
		$(document).ready(function(){ 
		        var filename ="<s:property value="fileName" />";// formItem.path.value;
		
		     if(filename == null || filename == '' ){
		    	 $("#buttonProcess").attr('disabled',true);
		     }
		     else{
			     $("#buttonProcess").attr('disabled',false);
		     }
  		});
    </script>
</head>

<body class="list_body" onload="loadforiframe();">
<div class="table_container">
<s:form action="/sales/comprice_upload.do" method="POST" key="formItem"	cssStyle="formList"	enctype="multipart/form-data" theme="simple">
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea">��Ʒ���ۼ۸�����</span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea_h">��������</span>
		</div>
	</div>
    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.comprice.CompriceCheck">
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>
    <aa:zone name="listZone">
    <div class="table_div">
        <table class="table_normal">
            <tr>
            	<td align=right>
            		ѡ���ļ��� 
            	</td align=left>
            	<td>
            		<s:file name="doc" label="File" /> 
            	</td>
             </tr>
               <tr>
            	<td align="right">�ļ�:</td>
            	<td align="left">
            	<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
            	<s:property value="fileName" /> 
            	</a>
            	</td>
            </tr>
              
             <tr>
				<td align=right height=25>
						�ļ�����:
				</td>
				<td align="left">
						.txt�ı��ļ� (�ı��ﲻҪ�����кͶ���Ŀո�)
				</td>
				</tr>
         
			<tr>
				<td align=right height=25>
					�ļ���ʽ:
				</td>
				<td align=left>
					�ۼ����ַ�ʽΪ������ʱ��</br>
					<font color="red">�ֹ�˾|�Ǽ�|��������|��Ʒ����|�ۼ����ַ�ʽ|ͳһ�ۼ�(Ԫ)||</font></br></br>
					�ۼ����ַ�ʽΪ����˽�ʺ�����ʱ��</br>
					<font color="red">�ֹ�˾|�Ǽ�|��������|��Ʒ����|�ۼ����ַ�ʽ|�Թ��ۼ�(Ԫ)|��˽�ۼ�(Ԫ)|</font></br></br>
					�ۼ����ַ�ʽΪ���Ƿ��ӡ��Ʊ����ʱ��</br>
					<font color="red">�ֹ�˾|�Ǽ�|��������|��Ʒ����|�ۼ����ַ�ʽ|��Ʊ�ۼ�(Ԫ)|����Ʊ�ۼ�(Ԫ)|</font>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					����˵��:
				</td>
				<td align=left>
					ʾ��1��<font color="red">ZS0|2|GFX|55DG|NODIF|50||</font></br>
					ʾ��2��<font color="red">ZS0|3|GFX|55DG|ACCOUNT|55|50|</font></br>
					ʾ��3��<font color="red">ZS0|-1|GFX|55DG|INVOICE|55|50|</font>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					����˵�� 
				</td>
				<td align=left>
				  �ļ���ʽ���ú�ɫ��ǵ��ֶ�Ϊ������ļ������ޱ����С�</br>
				  �ֹ�˾:�����������ķֹ�˾����</br>
				  �Ǽ�:0-δ���Ǽ� 1-һ�Ǽ� 2-���Ǽ� 3-���Ǽ� 4-���Ǽ� 5-���Ǽ� 6-���Ǽ� 7-3G����ר���Ǽ� 8-�������������Ǽ� 9-4G����ר���Ǽ� -1-�����Ǽ� </br>
				  �������ͣ�
				    <%
				       java.util.ArrayList custwaytypeList1 = (java.util.ArrayList) request.getSession().getAttribute("custwaytypeList1");
				      for (int i = 0; i < custwaytypeList1.size(); i++) {
									com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO custwaytypevo = 
									(com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO) custwaytypeList1.get(i);
									out.println(custwaytypevo.getCustwaytypecode() + "-" + custwaytypevo.getCustwaytypename()
											+ "&nbsp;&nbsp;");
								}
				    
				     %></br>
				  ��Ʒ���ࣺ				  <j:selector name="comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
				  </br>
				  �ۼ����ַ�ʽ��NODIF-������ ACCOUNT-����˽�˻����� INVOICE-���Ƿ��Ʊ����</br>
				  ͳһ�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0</br>
				  �Թ���˽�ۼۣ�ͬ��</br>
				  �Ƿ��Ʊ�ۼۣ�ͬ��</br>
				  <font color="red">��ʾ����¼������ʱ�������������������ʱ���и��²�����</font>
				</td>
			</tr>
        </table>
    </div>
    </aa:zone>
    <div class="table_div">
		<table class="table_button_list">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                        <input type="button" id="btnBatch" name="btnBatch" class="button_2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="�ϴ�" onClick="upload('/sales/comprice_upload.do')">
	                            
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess('/sales/comprice_import.do')"
	                            value="����" disabled="true"> 
	                            
	                        <input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="����"
										onclick="doReturn()">
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
</s:form>

<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.comprice.CompriceTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</div>
</body>
</html>