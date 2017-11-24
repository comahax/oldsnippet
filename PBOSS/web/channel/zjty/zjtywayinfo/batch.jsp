<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
	<head>
		<title>自建他营渠道管理</title>
		<script language="JavaScript" type="text/JavaScript">
	function checkProcess(){
		var filename = formItem.path.value;
		if(filename != null || filename != ""){
	        formItem.buttonProcess.disabled=true;
	    	document.getElementById("tt").href="<%=contextPath%>/channel/zjtywayinfobatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.zjty.zjtywayinfo.ZjtywayinfoTaskBean";
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
	function doReturn(cmdReturn) {
	    formItem.action = contextPath + cmdReturn;
	    formItem.submit();
	}
</script>
<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
    <base target="_self">
	</head>
	<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
				<s:form action="/channel/zjtywayinfoupload.do"  method="POST" key="formItem"	cssStyle="formItem"	enctype="multipart/form-data" theme="simple">
				<a id="tt" href="#"></a>
				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
						<span class="table_toparea"><s:text name="currentPos"/> </span>
						<span class="table_toparea_xi">&gt;</span>
						<span class="table_toparea"><s:text name="channel"/> </span>
						<span class="table_toparea_xi">&gt;</span>
						</s:i18n>
						<span class="table_toparea_h">渠道自建他营信息管理批量导入</span>
					</div>
				</div>
				<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
			    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
			    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.zjty.zjtywayinfo.ZjtywayinfoCheck">
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
							<td  align="right">
								选择文件: 
							</td>
							<td align="left">
								<s:file name="doc" label="File" />
							</td>
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
						
						<tr >
							<td align=right height=25>
								文件格式:
							</td>
							<td align=left>
								<font color="red">渠道|渠道名称|上级渠道</font>|服务厅类别|<font color="red">服务厅级别</font>|子类型|分公司|服务销售中心|微区域|星级|是否联网|联网方式|<font color="red">物业来源分类</font>|<br>
								<font color="red">商圈类型|区域类型</font>|店面经理联系电话|行政区划|<font color="red">地理纬度|地理经度|详细地址</font>|渠道状态|是否中心渠道|合作商编码|是否共享|全网统一渠道编码|乡镇|渠道基础类型|<br>
								是否卖场加盟|前台营业面积（㎡）|有无排队叫号机|有无POS机|有无24小时自助营业厅|有无VIP专席|有无VIP室|4G体验区面积|<font color="red">委托方公司名称</font>|<br>
								<font color="red">工商注册号|法人代表</font>|身份证号码|<font color="red">签约编号|协议签署生效时间|协议截止时间|负责人电话|协议名称|签约时间|</font>
						</tr>
						<tr >
							<td align=right height=25>
								举例说明:
							</td>
							<td align=left>
							SQD001289|TESTNAME|SDGDK1---||6||||||||0|1|0|||28.786698|113.878032|中国广东|0|||||||||||||||从兴电子|sa123|法人||123|2012-02-06|2013-02-06|13612362365|协议名称|2012-02-06|</td>
						</tr>
						<tr >
							<td align=right height=25>
								补充说明 
							</td>
							<td align=left>								
									渠道：只能是字母+数字或者'-'<br>服务厅类别：5-沟通100营业厅<br>
									地市公司：DG-东莞市公司 等等<br>
									星级：0-未定星级，1-一星级  等等<br>
									是否联网：0-联网，1-未联网<br>
									联网方式：0-光缆，1-2M电缆，2-GPRS，3-CSD，4-拨号上网，5-无线网桥，6-专线接入BOSS，7-宽带接入BOSS，8-空中充值平台，9-网站接入，99-其他<br>
									物业来源分类：0-租赁,2-上市公司购建,3-社会物业（他建）<br>
									商圈类型：1: A类商圈 5: B类商圈 6: C类商圈 7: 非商圈 99:其他<br>
									区域类型：0-城区,1-郊县,2-一类乡镇,3-二类乡镇,4-三类乡镇,5-行政村,99-其它<br>
									渠道状态：0-失效,1-有效<br>
									是否中心渠道：0-否，1-是<br>
									是否共享：0-否，1-是<br>
									渠道基础类型:0-实体厅,3-虚拟厅<br>
									是否卖场加盟:0-否,1-是<br>
									有无排队叫号机:0-无,1-有<br>
									有无POS机:0-无,1-有<br>
									有无24小时自助营业厅:0-无,1-有<br>
									有无VIP专席:0-无,1-有<br>
									有无VIP室:0-无,1-有<br>
								
								</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								填写指南:
							</td>
							<td align=left>
								<a href="<%=contextPath%>/channel/common/importguide.htm">填写指南</a></td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								Excel填写模板:
							</td>
							<td align=left>
								<a href="<%=contextPath%>/channel/zjty/zjtywayinfo/zitywayinfoimport.xls">渠道自建他营信息管理批量导入模板.xls</a>
								(注:填写后请将数据转换为txt格式,去掉标题行,再上传导入) </td> 
						</tr>
					</table>
				</div>
			</aa:zone>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<s:i18n name="public">
						<td>							
							<input type="submit" id="btnBatch" name="btnBatch" class="button_New" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<s:text name="button_upload"/>">
							<input type="button" id="buttonProcess" name="buttonProcess" class="button_New" onmouseover="buttonover(this);"
	                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)" onclick="checkProcess()"
	                            value="处理">
                            <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                   	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                          		value="<s:text name="button_return"/>" onclick="doReturn('/channel/zjtywayinfo_list.do')">
						</td>
						</s:i18n>
					</tr>
				</table>
			</div>
			</s:form>
			<div class="table_div">
					<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.zjty.zjtywayinfo.ZjtywayinfoTaskBean"  frameborder="0" class="loadframe" id="loadframe"  scrolling="no"></iframe>
			</div>
		</div>
	</body>
</html>
