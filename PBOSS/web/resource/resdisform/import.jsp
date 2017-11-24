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
				document.getElementById("tt").href="<%=contextPath%>/resource/resdisform_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.resource.resdisform.ResdisformTaskBean&disid=<s:property value="formMap.disid"/>&storarea=<s:property value="formMap.storarea"/>";
	    		document.getElementById("tt").click();
			}
		}
		
		function upload(actionUrl){
			formItem.action=actionUrl;
			formItem.submit();
		}
		
		function dataCheck(){
			addfield('storarea', '资源库区', 'c', false,'50');
            addfield('doc', '上传的文件', 'c', false,'500');    
			addfield('disid', '分配单号', 'c', false,'11');     
            return checkval(window);
		}
		
		//自动分配分配单号格式为YYYYMMDDXXX，即日期加三位随机数
		function createDisid(){
		var date = new Date();
		var year = date.getYear();
		var month = date.getMonth()+1;
		if(month<10)
		month="0"+month;
		var day = date.getDate();
		if(day<10)
		day="0"+day;
		var random = ""+parseInt(Math.random()*999);
			if(random.length == 1)
			random = "00"+random;
			if(random.length == 2)
			random = "0"+random;
		var disid = ""+year+month+day+random;
		return disid;
		}
		
		
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="/resource/resdisform_upload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" onSubmit="return dataCheck()">
    <a id="tt" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">套卡资源分配管</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="file_upload"/></span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.resource.resdisform.ResdisFormCheck">

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
                <td align="right">资源库区:&nbsp</td>
                <td align="left">
					<j:selector name="storarea" definition="$IM_FXSTORAREA" />
					<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td align="right">分配单号:&nbsp</td>
                <td align="left">
					<input name="disid"  readonly="true"/>
					<font color="red">*</font>自动分配
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
					<font color="red">配送商编码|商品批次|包号|</font>
                </td>
            </tr>
            <tr>
                <td align="right">举例说明:&nbsp</td>
                <td align="left">
					<font color="red">DIS001|2009123|123-1-1|</font>
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
                    <input type="button" id="btnUpload" name="btnUpload" class="button_New" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="上传" onclick="upload('/resource/resdisform_upload.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_New" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/resource/resdisform_import.do');"/>
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.resource.resdisform.ResdisformTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
<script type="text/javascript">
<!--

var disid = "<s:property value="formMap.disid"/>";
var storarea = "<s:property value="formMap.storarea"/>";

if(storarea != ''){
document.getElementById('storarea').value=storarea;
}else{
document.getElementById('storarea').value = 'ZG'
}
if(disid != ''){
  document.getElementById('disid').value = disid;
}else{
document.getElementById('disid').value = createDisid();
}
 function showDelButton(){
 var filename = formItem.filename.value;
        if(filename == null || filename == '' ){
        $("#btnDeal").attr('disabled',true);
        }
        else{
         $("#btnDeal").attr('disabled',false);
         }
        }
        showDelButton();
        
//-->
</script>
