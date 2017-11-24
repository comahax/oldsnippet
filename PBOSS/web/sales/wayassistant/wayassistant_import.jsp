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
				document.getElementById("tt").href="<%=contextPath%>/sales/wayassistant_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.wayassistant.WayassistantTaskBean";
	    		document.getElementById("tt").click();
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
		
		function doReturnList(){
    		window.location.href="<%=contextPath%>/sales/wayassistant_list.do";
    	}	
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/sales/wayassistant_upload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" onSubmit="return dataCheck()">
   
   <input type="hidden" name="wayid" id="wayid" value="${USER.wayid}"/>
   <input type="hidden" name="step" id="step" value="${step}"/>
   <input type="hidden" name="delaySeconds" id="delaySeconds" value="${delaySeconds}"/>
   
    <a id="tt" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea">分销管理管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">商品订购辅助信息管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">商品订购辅助信息导入 </span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" id="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" id="filepath" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.sales.wayassistant.WayassistantCheck">

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
					<font color="red">合作商编码|是否可发起订购|是否打印发票|缴费方式|送货方式|是否可订购靓号|</font>
                </td>
            </tr>
            <tr>
                <td align="right">举例说明:&nbsp</td>
                <td align="left">
					<font color="red">KFMM0CC88|1|0|BANK|ARRIVEPAY|1|</font>
                </td>
            </tr>
            <tr>
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					合作商编码:存在的合作商<br>
					是否可发起订购:只能是数字0和1<br>
					是否打印发票:只能是数字0和1<br>
					缴费方式:ADPAY代表配送商垫资、BANK代表银行划扣、CASH代表现金、POS代表POS机<br>
					送货方式:ARRIVEPAY代表货到付款、PAYFIRST代表先收款再送货<br>
					是否可订购靓号:只能是数字0和1<br>
					<font color="red">注：红色部分表示必填项。</font>
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
                           value="上传" onclick="upload('/sales/wayassistant_upload.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/sales/wayassistant_import.do');"/>
					
					 <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturnList()">
					
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>

<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.wayassistant.WayassistantTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</div>
</body>
</html>
