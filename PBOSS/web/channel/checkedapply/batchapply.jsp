<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>文件上传</title>
	<script language="JavaScript" type="text/JavaScript">
		function checkProcess(){
			var filename=formItem.path.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/channel/checkedapply_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.checkedapply.CheckedapplyTaskBean";                                                                                        
			}
		}
		function doReturn() {
	     	formItem.action = "<%=contextPath%>/channel/checkedapply_retrunfrombatch.do"; 
		    formItem.submit();
		}
		
		function upload(){
			formItem.action="<%=contextPath%>/channel/checkedapply_upload.do";
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){ 
				 var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>请选择上传的文件</span> ';
				errorMessageShow(alertstr); 
				return false;
			}
			return true;
		}
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/checkedapply_upload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" onSubmit="return upload();" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">文件上传</span>
		</div>
	</div>
	<aa:zone name="hiddenZone">
		<s:hidden name="param._orderby" />
		<s:hidden name="param._desc" />
		<s:hidden name="param._pageno" />
		<s:hidden name="param._pagesize" />
		<s:hidden name="param.queryAll" />
		<input type="hidden" name="_rowcount"
			value="<s:property value="dp.rowCount" />" /> 
		<input type="hidden" name="applywayid"/>	
		<input type="hidden" name="param.applyeno" value="<s:property value="param.applyeno" />"/>
		<input type="hidden" name="param.applytype" value="<s:property value="param.applytype" />"/>
		<input type="hidden" name="param.oprcode2" value="<s:property value="param.oprcode2" />"/>
		<input type="hidden" name="param.aptime" value="<s:date name="param.aptime" format="yyyy-MM-dd HH:mm:ss" />"/>
		<input type="hidden" name="param.mobileno" value="<s:property value="param.mobileno" />"/>
		<input type="hidden" name="param.memo" value="<s:property value="param.memo" />"/>
		<input type="hidden" name="param.appath" value="<s:property value="param.appath" />"/>
		<input type="hidden" name="param.pptpath" value="<s:property value="param.pptpath" />"/>
	</aa:zone>
	<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.checkedapply.CheckedapplyCheck">
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
            	<td align="right">请选择上传的文件: 	</td>
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
				<td align="left"><font color=red>渠道编码</font>|<font color=red>考核方式</font>|<font color=red>申请类型</font>|调整内容(退出处理还是延缓退出)|</td>
			</tr>
			<tr>
				<td align="right" height=25>举例说明:</td>
				<td align="left"> 
				<font color="red">JMJF88888</font>|<font color="red">0</font>|<font color="red">1</font>|1|
				</td>
			</tr>
			<tr>
				<td align="right" height=25>
					补充说明 
				</td>
				<td align="left">
					 考核方式：0-单点考核，1-统一管理模式考核<br/>
					 申请类型：0-准入申请，1-退出申请<br/>
					 调整内容：0-退出处理，1-延缓退出<br/>
					 注：申请类型为【退出申请】时，【调整内容】必填
				</td>
			</tr>
			<tr>
					<td align=right height=25>
						填写指南:
					</td>
					<td align=left>
						<a href="<%=contextPath%>/channel/common/importguide.htm">填写指南</a></td>
            </tr>
            <tr>
                  <td align=right height=25>Excel填写模板：</td>
                  <td> <a href="<%=contextPath%>/channel/checkedapply/batchimportmodel.xls"/>授权网点批量导入模版.xls</a>(注：填写后请将数据转换为txt格式，去掉标题行，再上传导入)
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
	                        <input type="submit" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="<s:text name="button_upload"/>">
	                            
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
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.checkedapply.CheckedapplyTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>