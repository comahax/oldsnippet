<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="文件上传"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function checkProcess(actionUrl){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
				formItem.btnDeal.disabled=true;
				document.getElementById("tt").href="<%=contextPath%>/channel/logiswayimport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.way.LogiswayTaskBean";
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
		
		
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="/channel/logisupload.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" onSubmit="return dataCheck()">
    <a id="tt" href="#"></a>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">配送商管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="file_upload"/></span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.way.LogiswayCheck">

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
                <td align="right">文件类型:&nbsp</td>
                <td align="left">
					.txt文本文件(文件里不要留空行和多余的空格)
                </td>
            </tr>
            <tr>
                <td align="right">文件格式:&nbsp</td>
                <td align="left">

					<FONT color=red>渠道编码|渠道名称|上级渠道编码</FONT>|合作方|地市公司|分公司|服务销售中心|微区域|行政区划|<BR><FONT 
					color=red>地理经度|地理纬度</FONT>|详细地址|<FONT 
					color=red>负责人姓名|负责人联系电话</FONT>|负责人电子邮箱|
                </td>
            </tr>
            <tr>
                <td align="right">举例说明:&nbsp</td>
                <td align="left">
					JFJMXXXXX|测试渠道|JFJM00000|1|JM|JM|||1|123.234511|23.234502|江门建设路101号|张三|
					020-31647847|abcd@abc.com|
                </td>
            </tr>
            <tr>
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					日期格式:yyyy-mm-dd(例如1999-01-01)
					合作方:0(中国移动)、1(中国联通)、2(中国电信)、3(中国网通)、4(中国铁通)、99(其他)
					经营区域类型编码:0(地市公司)、1(分公司)、2(服务销售中心)、3(微区域)
					经度，纬度格式：度.分，例如：123.234502. 
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
                           value="上传" onclick="upload('/channel/logiswayupload.do')"/>
                    
                   
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_New" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/channel/logiswayimport.do');"/>
                           
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn('/channel/way_logslist.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.way.LogiswayTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
<script type="text/javascript">
<!--

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
