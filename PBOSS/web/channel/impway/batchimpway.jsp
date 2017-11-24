<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
	<title>社会网点信息管理</title>
	<script language="JavaScript" type="text/JavaScript">
		function checkProcess(){
			var filename=formItem.path.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/channel/impwaybatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.impway.ImpWayTaskBean";                                                                                        
			}
		}
		function upload(){
			var fileName = document.getElementById('doc').value;
			if(fileName == ''){
				var alertstr = '<span class=\'errorkey\'><li><span style=\'color:#F00; font-size:12px;\'>请选择上传的文件</span></li>';
				errorMessageShow(alertstr);
				return false;
			}
			formItem.submit();
		}
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/impwayupload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">入柜商渠道文件上传</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.impway.ImpWayCheck">
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
				<td align="left"><p><font color=red>渠道编码|渠道名称|上级渠道编码</font>|渠道类型|渠道子类型|<font color=red>地市公司编码<br>
					|分公司编码</font>|服务销售中心编码|微区域编码|星级|商圈类型编码|<font color=red>区域类型编码</font>|店面经理联系电话|行政区划编码<br>
					|详细地址|<font color=red>地理纬度|地理经度|经营模式</font>|是否联网|联网方式|<font color=red>物业来源分类</font>|是否中心渠道|合作商编码|是否共享|<br>
					(注:红色字段为必填项)</p></td>
			</tr>
			<tr>
				<td align="right" height=25>举例说明:</td>
				<td align="left">ZSCS001|测试渠道|TDZS-----|||ZS|ZS0|||||3||||19.261233|123.236133|2|||3||||</td>
			</tr>
			<tr>
				<td align="right" height=25>
					补充说明 
				</td>
				<td align="left">
					时间格式为:YYYY-MM-DD(如:2007-04-18)<br>
					渠道类别编码:IMP,入柜商渠道; <br>
					星级:0,未定星级;1,一星级;2,二星级;3,三星级;4,四星级;5,五星级;6,六星级<br>
					商圈类型:1: A类商圈 5: B类商圈 6: C类商圈 7: 非商圈 99:其他<br>
					区域类型:0,城区;1,郊县;2,一类乡镇;3,二类乡镇;4,三类乡镇;99,其他<br>
					经营模式:0,直营店;1,加盟店;<br>
					联网方式:0,光缆;1,2M电缆;2,GPRS;3,CSD;4,拨号上网;5,无线网桥<br>
					物业来源:0,租赁;1,存续企业购建;2,上市公司购建;3,社会物业（他建）;<br>
					是否联网:0,联网;1,非联网;是否中心渠道:0,否;1,是;是否共享:0,否1,是
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
					<td align=right height=25>
						Excel填写模板:
					</td>
					<td align=left>
						<a href="<%=contextPath%>/channel/impway/impwaybatch.xls">入柜商渠道批量导入模板.xls</a>
						（注：填写后请将数据转换为txt格式，去掉标题行，再上传导入）</td>
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
	                            value="<s:text name="button_upload"/>" onclick="upload();">
	                        <input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="处理">
	                        <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn('/channel/impway_list.do')">
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
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.impway.ImpWayTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>