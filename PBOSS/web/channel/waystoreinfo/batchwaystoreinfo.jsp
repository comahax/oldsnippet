<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>门店宣传信息管理</title>
	<script language="JavaScript" type="text/JavaScript">
		function checkProcess(){
			var filename=formItem.path.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/channel/waystoreinfo_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.waystoreinfo.WaystoreinfoTaskBean";                                                                                        
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
   		 	formItem.action ="<%=contextPath%>/channel/waystoreinfo_list.do";
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
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/waystoreinfo_upload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">门店宣传信息管理</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.waystoreinfo.WaystoreinfoCheck">
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
            	<td align="right">选择文件: 	</td>
            	<td align="left"><s:file name="doc" label="File" /></td>
            </tr>
            <tr>
				<td align="right" height=25>文件类型:</td>
				<td align="left">.txt文本文件 (文本里不要留空行和多余的空格)</td>
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
				<td align="right" height=25>文件格式:</td>
				<td align="left"><p><font color=red>门店编码|面积|专区类型|专区面积|专区背板|专区专柜|专区立牌|专区价签|专区展架|</br>专区店内横幅|专区店外横幅|专区堆头|专区地贴|专区桌面台牌点位|专区桌面台卡点位|专区海报|门头类型|外墙广告面积大小|</br>外墙广告大幅宣传画点位|终端专营|业务专营|店内宣传数量|系数|</br></font></p></td>
			</tr>
			<tr>
				<td align="right" height=25>举例说明:</td>
				<td align="left">
						<font color="red">ZS041|80|3|20.5|0|3|2|1|5|1|1|2|2|1|3|1|0|1|12|0|0|2|0.8|</font><br><br>
					
				</td>
			</tr>
			<tr>
				<td align="right" height=25>
					补充说明： 
				</td>
				<td align="left">
					专区类型：3 3G专区 4 4G专区</br>  
					门头类型：3 3G门头 4 4G门头</br>  
					专区背板: 0 有 1 无</br>
					专区店内横幅: 0 有  1 无</br>
					专区点外横幅: 0 有  1 无</br>
					专区堆头: 0 有 1 无</br>
					专区地贴: 0 有 1 无</br> 
					终端专营：0 有 1 无</br>
					业务专营：0 有 1 无</br>
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
	                    <s:i18n name="public">
	                         <input type="button" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_upload"/>" onClick="upload('/channel/waystoreinfo_upload.do')">
	                            
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="处理">
	                            
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn()">
                        </s:i18n>
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.waystoreinfo.WaystoreinfoTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>