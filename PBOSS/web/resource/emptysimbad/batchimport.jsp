<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript" type="text/JavaScript">
	    function upload(){ 
			formItem.action = "<%=contextPath%>/resource/emptysimbad_import.do?CMD=UPLOAD";
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>&nbsp;请选择要上传的文件</span> ';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
          		formItem.btnDeal.disabled = true;
	      		window.location.href = "<%=contextPath%>/resource/emptysimbad_import.do?filename=" + filename 
	      			+ "&beanname=com.gmcc.pboss.web.resource.emptysimbad.EmptysimbadTaskBean";                                                                                        
			}
		}
		function doReturn() {
   		 	formItem.action ="<%=contextPath%>/resource/emptysimbad_list.do";
   			formItem.submit();
		}
    </script>
    <base target="_self">
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/resource/emptysimbad_import.do" cssStyle="formItem" key="formItem" 
			method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
		  <s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">资源库存统计</span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">空白SIM卡坏卡批量录入</span>
		  </s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.resource.emptysimbad.EmptysimbadCheck">
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
                <td align="right"><s:text name="file_type"/>:&nbsp</td>
                <td align="left">
					<s:text name="file_type_txt_describe"/>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_format"/>:&nbsp</td>
                <td align="left">
                	 <font color=red>
						空白SIM卡序列号|渠道编码|
					</font>
                </td>
            </tr>
            <tr >
                <td align="right"><s:text name="file_example"/>:&nbsp</td>
                <td align="left">
					<font color=red>1908000300001697|FJMHS80221|</font>
                </td>
            </tr>
             <tr >
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					文件格式中用红色标记的字段为必填项，文件内容无标题行<br>
					空白SIM卡序列号：最大长度21位<br>
					渠道编码：最大长度18位<br>
					<font color=red>注意：坏卡导入后将不能再进行修改、删除操作，请确认后再导入</font>
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
                        value="<s:text name="button_upload"/>" onclick="upload()"/>
                    <input type="button" id="btnDeal" name="btnDeal" class="button_2" onmouseover="buttonover(this);" 
                    	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_deal"/>" onclick="checkProcess();"/>
                    <input type="button" id="btnReturn" name="btnReturn"class="button_Back" onmouseover="buttonover(this);"
						onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
						value="返回" onclick="doReturn()">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.resource.emptysimbad.EmptysimbadTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no"></iframe>
</body>
</html>