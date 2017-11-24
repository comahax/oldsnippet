<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title>批量导入</title>
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
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择上传的文件</span> ';
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
			<span class="table_toparea">商品销售价格设置</span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea_h">批量导入</span>
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
            		选择文件： 
            	</td align=left>
            	<td>
            		<s:file name="doc" label="File" /> 
            	</td>
             </tr>
               <tr>
            	<td align="right">文件:</td>
            	<td align="left">
            	<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
            	<s:property value="fileName" /> 
            	</a>
            	</td>
            </tr>
              
             <tr>
				<td align=right height=25>
						文件类型:
				</td>
				<td align="left">
						.txt文本文件 (文本里不要留空行和多余的空格)
				</td>
				</tr>
         
			<tr>
				<td align=right height=25>
					文件格式:
				</td>
				<td align=left>
					售价区分方式为无区分时：</br>
					<font color="red">分公司|星级|合作类型|商品种类|售价区分方式|统一售价(元)||</font></br></br>
					售价区分方式为按公私帐号区分时：</br>
					<font color="red">分公司|星级|合作类型|商品种类|售价区分方式|对公售价(元)|对私售价(元)|</font></br></br>
					售价区分方式为按是否打印发票区分时：</br>
					<font color="red">分公司|星级|合作类型|商品种类|售价区分方式|打发票售价(元)|不打发票售价(元)|</font>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					举例说明:
				</td>
				<td align=left>
					示例1：<font color="red">ZS0|2|GFX|55DG|NODIF|50||</font></br>
					示例2：<font color="red">ZS0|3|GFX|55DG|ACCOUNT|55|50|</font></br>
					示例3：<font color="red">ZS0|-1|GFX|55DG|INVOICE|55|50|</font>
				</td>
			</tr>
			<tr>
				<td align=right height=25>
					补充说明 
				</td>
				<td align=left>
				  文件格式中用红色标记的字段为必填项，文件内容无标题行。</br>
				  分公司:本地市下属的分公司编码</br>
				  星级:0-未定星级 1-一星级 2-二星级 3-三星级 4-四星级 5-五星级 6-六星级 7-3G渠道专用星级 8-连锁加盟渠道星级 9-4G渠道专用星级 -1-所有星级 </br>
				  合作类型：
				    <%
				       java.util.ArrayList custwaytypeList1 = (java.util.ArrayList) request.getSession().getAttribute("custwaytypeList1");
				      for (int i = 0; i < custwaytypeList1.size(); i++) {
									com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO custwaytypevo = 
									(com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO) custwaytypeList1.get(i);
									out.println(custwaytypevo.getCustwaytypecode() + "-" + custwaytypevo.getCustwaytypename()
											+ "&nbsp;&nbsp;");
								}
				    
				     %></br>
				  商品种类：				  <j:selector name="comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/>
				  </br>
				  售价区分方式：NODIF-无区分 ACCOUNT-按公私账户区分 INVOICE-按是否打发票区分</br>
				  统一售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0</br>
				  对公对私售价：同上</br>
				  是否打发票售价：同上</br>
				  <font color="red">提示：记录不存在时候进行新增操作，存在时进行更新操作。</font>
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
	                            value="上传" onClick="upload('/sales/comprice_upload.do')">
	                            
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_2" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess('/sales/comprice_import.do')"
	                            value="处理" disabled="true"> 
	                            
	                        <input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="返回"
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