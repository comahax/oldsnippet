<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(actionUrl){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				formItem.btnDeal.disabled=true;
				var ajaxRetValue = doAjax(filename);
				var param44 = ajaxRetValue[0];
				var orderids = ajaxRetValue[1];
				//document.getElementById("tt").href="<%=contextPath%>/sales/importOrderAudit.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.order.OrderAuditTaskBean";
	    		//document.getElementById("tt").click();return
				if(param44 == '1'){
					var returnValue=window.showModalDialog('<%=contextPath %>/sales/order_batchAppPassStockInfo.do?orderids='+orderids,window,"dialogWidth=800px;dialogHeight=600px;status:no;scroll=yes;");
					if(returnValue!=undefined){
						//formItem.action="<%=contextPath%>/sales/order_batchAppPass.do";
		       			//formItem.submit();
		       			document.getElementById("tt").href="<%=contextPath%>/sales/importOrderAudit.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.order.OrderAuditTaskBean";
	    				document.getElementById("tt").click();
					}
				}else{
		     		//formItem.action="<%=contextPath%>/sales/order_batchAppPass.do?orderids=" + orderids;
		        	//formItem.submit();
		        	document.getElementById("tt").href="<%=contextPath%>/sales/importOrderAudit.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.order.OrderAuditTaskBean";
	    			document.getElementById("tt").click();
		        }
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
		
		function dataCheck(){
			
			return ture;
		}
		
		function doAjax(obj){
			var returnArray = new Array(2);
			$.ajax({
				type:"POST",
				url: "<%=contextPath%>/sales/importOrderAudit_getSysParam.do",
				async:false, //同步
				data:"filename=" + obj,			
				success:function(msg){
					var tmpArr = msg.split(";");
					returnArray[0] = tmpArr[0];
					returnArray[1] = tmpArr[1];
				}
			});
			return returnArray;
		}
		
		
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/sales/uploadOrderAudit.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" onSubmit="return dataCheck()">
   
   <input type="hidden" name="wayid" id="wayid" value="${USER.wayid}"/>
   
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
			<span class="table_toparea_h">订单批量审核  </span>
			</s:i18n>
		</div>
	</div>

	<input type="hidden" name="filename" id="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" id="filepath" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.order.OrderAuditCheck">

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
					<font color="red">订单编号</font>
                </td>
            </tr>
            <tr>
                <td align="right">举例说明:&nbsp</td>
                <td align="left">
					<font color="red">GZ0908151000001001</font>
                </td>
            </tr>
            <tr>
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
                	文件格式中用红色标识的字段为必填项，文件内容无标题行。<br/>
					订单编号最大长度为18位的字符。
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
                           value="上传" onclick="upload('/sales/uploadOrderAudit.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/sales/importOrderAudit.do');"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>

<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.order.OrderAuditTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</div>
</body>
</html>

<script type="text/javascript">
<!--

 function showDelButton(){
	var filename = formItem.filename.value;
    if(filename == null || filename == '' ){
    	$("#btnDeal").attr('disabled',true);
    }else{
     	$("#btnDeal").attr('disabled',false);
    }
 }
 showDelButton();
        
//-->
</script>
