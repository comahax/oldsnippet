<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>门店宣传信息管理</title>
	<script language="JavaScript" type="text/JavaScript">
		function doReturn() {
   		 	formItem.action ="<%=contextPath%>/channel/waystoreinfo_list.do";
   			formItem.submit();
		}

   	 	function doProcess(){ 
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择上传的文件</span> ';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
		
		function addDirect(){
			var directCount = document.getElementById('directCount');
			var rowID = parseInt(directCount.value);
			 
			var directTable = document.getElementById('directTable');
			//添加行
			var newTR = directTable.insertRow(directTable.rows.length);
			newTR.id = "directItem" + rowID;
			
			//添加列:文件上传框
			var newFileTD=newTR.insertCell(0);
			newFileTD.innerHTML = "<input type='file' name='doc' cssClass='form_text edit requiredSel' />";
			
			//添加列:删除按钮
			var newDeleteTD=newTR.insertCell(1);
			newDeleteTD.innerHTML = "<input type='button' value='删除' onclick=\"deleteDirect('directItem" + rowID + "')\" />";
			
			//添加列:空白行
			//var newNullTD=newTR.insertCell(2);
			//newNullTD.innerHTML = "";
			
			//行数+1
			directCount.value = rowID + 1;
		}
		
		//删除指定行
		function deleteDirect(rowid){
			var directTable = document.getElementById('directTable');
			var directItem = document.getElementById(rowid);
			
			//获取将要删除的行的Index
			var rowIndex = directItem.rowIndex;
			
			//删除指定Index的行
			directTable.deleteRow(rowIndex);
		}
		
		//清空列表
		function clearAllDirect(){
			if(confirm('确定要清空吗？')){
				var directTable = document.getElementById('directTable');
				var rowscount = directTable.rows.length;
				
				//循环删除行,从最后一行往前删除
				for(i=rowscount - 1;i > 0; i--){
					directTable.deleteRow(i);
				}
				
				//重置最后行号为1
				document.getElementById('directCount').value = "1";
				
			}
		}

    	
    	
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/waystoreinfo_picbatch.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
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
            	<td align="left">
            	<table id="directTable">
					<tr>
						<input type="hidden" name="directCount" id="directCount" value="1">
						<td><s:file name="doc" id="doc" label="File" /></td>
						<td><input type="button" value="添加" onclick="addDirect();"></td>
						<td><input type="button" value="清空" onclick="clearAllDirect();"><font color=red>*</span>  </td>
					</tr>
				</table>
            	</td>
            </tr>
            <tr>
				<td align="right" height=25>文件类型:</td>
				<td align="left"><font color=red>.jpg文件</font></br>
			</tr>
			<tr>
				<td align="right" height=25>文件命名格式:</td>
				<td align="left">
					门头照片：</br>
					<font color=red>门店编码_门头照片</font></br>
					专区照片：</br>
					<font color=red>门店编码_专区照片</font>
				</td>
			</tr>
			<tr>
				<td align="right" height=25>举例说明:</td>
				<td align="left">
					门头照片：</br>
					GDMDBM1_门头照片</br>
					专区照片：</br>
					GDMDBM1_门头照片
				</td>
			</tr>
			<tr>
				<td align="right" height=25>补充说明:</td>
				<td align="left">
						 图片只支持JPG格式，且上传的门头照片格式必须为（门店编码_门头照片.jpg）、专区照片格式必须为（门店编码_门头照片.jpg）</br>
					</br><font color=red>文件大小不能超过3M。</font>
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
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" 
	                            onclick="doProcess()" value="处理">
	                            
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
</body>
</html>