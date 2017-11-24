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
				document.getElementById("tt").href="<%=contextPath%>/channel/diswayimport.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.way.DiswayTaskBean";
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
<s:form action="/channel/diswayupload.do" cssStyle="formItem" key="formItem" 
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
			<span class="table_toparea">连锁经营合作商管理 </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h"><s:text name="file_upload"/></span>
			</s:i18n>
		</div>
	</div>

<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.way.DiswayCheck">

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
                <td align="right" width=110px>请选择上传的文件:&nbsp</td>
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

					<FONT 
					color=red>合作商编码|合作商名称|上级渠道编码</FONT>|合作方|地市公司|分公司|服务销售中心|微区域|扣税方式|合作层级|<BR>行政区划|<FONT 
					color=red>地理经度|地理纬度</FONT>|详细地址|<FONT 
					color=red>负责人姓名|负责人联系电话|负责人电子邮箱|业务联系人姓名|</FONT><BR><FONT 
					color=red>业务联系人联系电话|业务联系人电子邮箱|合同编码|合同名称|签署合同时间|合同到期日</FONT>|法人代表|<BR><FONT 
					color=red>营业执照编号</FONT>|经营区域类型编码|经营范围|<FONT 
					color=red>银行帐号|开户银行|开户账号名称|</FONT>开户人身份证号码|<BR>送货地址|收货联系人|收货联系号码 |收货人证件号码|<FONT 
					color=red>营业执照有效期</FONT>|保证金下限|<FONT 
					color=red>开户日期<BR>|生效时间|失效时间</FONT>|合作单位|合作商级别|工商号|证件类别|证件编码|注册地址|注册资金|渠道状态|合作商类型|星级|
                </td>
            </tr>
            <tr>
                <td align="right">举例说明:&nbsp</td>
                <td align="left">
					JFJMXXXXX|测试渠道|JFJM00000|1|JM|JM|||2|0|1|123.234502|18.234502|江门建设路101号|张三|
					020-31647847|abcd@abc.com|李四|0726-98564587|abc@xyz.com|45478|测试合同信息|1990-12-12|2006-01-02|
					王五|abcde12323|1|1|98546|中国银行|公司XX帐户|1234567897894587|广州大道368号|张三|
					13888888888|44052418203202235|2009-01-01|1000|2006-01-01|2006-01-02|2006-01-03|国美|
					0|A1456|1|4310031982....|广州海珠区|500|1|0|1|
                </td>
            </tr>
            <tr>
                <td align="right">补充说明:&nbsp</td>
                <td align="left">
					日期格式:yyyy-mm-dd(例如1999-01-01)
					合作方:0(中国移动)、1(中国联通)、2(中国电信)、3(中国网通)、4(中国铁通)、99(其他)
					经营区域类型编码:0(地市公司)、1(分公司)、2(服务销售中心)、3(微区域)
					扣税方式:0(现场返折)、1(代扣税)、2(酬金发票)
					合作层级:0(一般层)、1(紧密层)、2(松散层)
					经度，纬度格式：度.分，例如：123.234502. 
					合作商级别:0(全国),1(省级),2(地市级)
					证件类别:0(身份证),1(户口簿),2(营业执照),3(护照),4(军官证),5(士兵证),6(港澳身份证),7(台胞证),8(工作证),9(学生证)...99(其它证件)
					合作单位有以下可选项:苏宁、国美、迪信通、青年中心、大地、中域、协亨、恒波、骏和、龙粤
					渠道状态:1(有效),0(失效)  
					合作商类型:0(直销商),1(授权合作商),2(专项合作商),3(跨区连锁),4(FD合作商),5(TD合作商),6(空中选号合作商)
					星级:0(未定星级),1(一星级),2(二星级),3(三星级),4(四星级),5(五星级),6(六星级)
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
                           value="上传" onclick="upload('/channel/diswayupload.do')"/>
                    <input type="button"  id="btnDeal" name="btnDeal" class="button_New" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_deal"/>" onclick="checkProcess('/channel/diswayimport.do');"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<s:text name="button_return"/>" onclick="doReturn('/channel/way_aglist.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
    
</s:form>
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.way.DiswayTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>

</body>
</html>
