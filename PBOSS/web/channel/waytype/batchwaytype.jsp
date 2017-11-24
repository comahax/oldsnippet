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
				window.location.href="<%=contextPath%>/channel/waytypebatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.waytype.WaytypeTaskBean";
			}
		}
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<s:form action="/channel/waytypeupload.do" method="POST" key="formItem"	cssStyle="formItem"	enctype="multipart/form-data" theme="simple">
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">批量导入</span>
		</div>
	</div>
    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>"
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.waytype.WaytypeCheck">
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
            <tr class="table_normal_head">
            	<td align=right>
            		选择文件： 
            	</td align=left>
            	<td>
            		<s:file name="doc" label="File" /> 
            	</td>
             </tr>
             <tr class="table_normal_head">
				<td align=right height=25>
						文件类型:
				</td>
				<td align="left">
						.txt文本文件 (文本里不要留空行和多余的空格)
				</td>
				</tr>
            <tr class="table_normal_head">
            	<td align="right">文件:</td>
            	<td align="left">
            	<a href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'> 
            	<s:property value="fileName" /> 
            	</a>
            	</td>
            </tr>
			<tr class="table_normal_head">
				<td align=right height=25>
					文件格式:
				</td>
				<td align=left>
					<font color="red">渠道类型编码|渠道类型编码名称|上级类型编码</font>|描述
				</td>
			</tr>
			<tr class="table_normal_head">
				<td align=right height=25>
					举例说明:
				</td>
				<td align=left>
					<font color=red>KF|客服渠道|-1|</font>广东移动BOSS客服子系统渠道类别
				</td>
			</tr>
			<tr class="table_normal_head">
				<td align=right height=25>
					补充说明 
				</td>
				<td align=left>
					&nbsp;上级类型编码为-1表示是顶级渠道类型编码
				</td>
			</tr>
        </table>
    </div>
    </aa:zone>
    <div class="table_div">
		<table class="table_normal">
			<tr> 
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
	                    <td align=right>
	                        <input type="submit" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                            value="上传">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="导入">        
	                    </td>
	                    </tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.waytype.WaytypeTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>