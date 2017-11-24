<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="资源回收"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.btnDeal.disabled=true;
	    		document.getElementById("importUrl").href="<%=contextPath%>/resource/comressmp_rescallback.do?filename="+filename+"&beanname=com.gmcc.pboss.web.resource.comressmp.RescallbackTaskBean";
	    		document.getElementById("importUrl").click();
				
			}
		}
	$(document).ready(function(){ 
		var filename ="<s:property value="fileName" />";
	     if(filename == null || filename == '' ){
	   	 	$("#btnDeal").attr('disabled',true);
	     }
	     else{
		      $("#btnDeal").attr('disabled',false);
		      
	      }
        $(":select[name='callbacktype']").val('<s:property value="formMap.callbacktype" />');
   });
   
   
   function disablediv(select){
			var oDiv = select.value;
			
			if(oDiv == "EMPTYSIM" ){
				document.getElementById("emptysim_div").innerHTML = "<font color=red>空白卡序列号|商品标识|</font>";
			}else{
				document.getElementById("emptysim_div").innerHTML = "<font color=red>商品资源编号|商品标识|</font>";
			} 
		} 
   
   
   
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/resource/comressmp_rescallbackupload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" >
    <a id="importUrl" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">资源回收</span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.resource.comressmp.RescallbackCheck">
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
            <tr >
                <td align="right">资源类别:&nbsp</td>
                <td align="left">
					 <j:selector definition="CALLBACKTYPE" name="callbacktype" onchange="disablediv(this)"/><font color=red>*</font>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_type"/>:&nbsp</td>
                <td align="left">
					<s:text name="file_type_txt_describe"/>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_format"/>:&nbsp</td>
                <td align="left"  id="emptysim_div" >
                	
                </td>
            </tr>
            <tr >
                <td align="right" ><s:text name="file_example"/>:&nbsp</td>
                <td align="left" >
                	套卡<font color=red>13800138000|75701400000294|</font><br>
                	充值卡<font color=red>09421195011430190|66002100001175|</font><br>
                                        空白SIM卡<font color=red>9421195011430190|310008000000077|</font>
                </td>
            </tr>
             <tr >
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					文件格式中用红色标记的字段为必填项，文件内容无标题行<br>
					资源类别：支持充值卡、套卡和空白SIM卡三种资源<br/>
					商品资源编号：充值卡的序列号或套卡的号码，数字类型，最大长度32位<br/>
					空白卡序列号：空白卡的序列号，数字类型，最大长度21位<br/>
					商品标识：数字类型，最大长度18位<br/>
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
                    <input type="submit" id="btnUpload" name="btnUpload" class="button_2" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_upload"/>" />
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess();"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.resource.comressmp.RescallbackTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
