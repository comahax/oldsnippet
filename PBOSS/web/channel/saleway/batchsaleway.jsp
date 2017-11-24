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
	      		window.location.href="<%= contextPath%>/channel/salewaybatch.do?filename="+filename+"&beanname=com.gmcc.pboss.web.channel.saleway.SalewayTaskBean";                                                                                        
			}
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/channel/saleway_list.do";
    	}
    	<%
    	
    	String param75 = (String)request.getSession().getAttribute("param75");
    	
    	%>
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="/channel/salewayupload.do" cssStyle="formItem" key="formItem" method="post" theme="simple" enctype ="multipart/form-data" >
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">&gt;</span>
			</s:i18n>
			<span class="table_toparea_h">社会网点信息管理</span>
		</div>
	</div>
	    <input type="hidden" name="filename" value='<s:property value="fileName"/>'>
    <input type="hidden" name="path" value='<s:property value="filepath"/>'>
    <input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.channel.saleway.SalewayCheck">
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
				<td align="left"><p><font color=red>渠道编码|渠道名称|零售渠道类别|上级渠道编码|星级|排他性|状态|地市公司|分公司</font>|<br>服务销售中心|微区域|<font color=red>是否直供|区域类型</font>|行政区划|<font color=red>业态类型|营业面积</font>|<br>所属物流商|所属渠道经理|<font color=red>分级|公务机号码</font>|业务预警量|<font color=red>详细地址|地理纬度|<br>地理经度|业主姓名|业主电话</font>|业主固定电话|业主电子信箱|送货地址|收货联系人|<br>收货联系号码|收货人证件号码|<font color=red>签约类型|合同编码|合同协议名称|签署合同时间|合同协议生效时间|合同到期日</font><br>|营业执照编号|营业执照有效期|保证金金额|保证金押金状态|<font color=red>保证金下限</font><br><font color=red>|酬金支付开户银行|酬金支付银行账号|酬金支付帐号名称|开户人身份证号码|签约状态</font>|保证金交付形式<br/>|<font color=red>经营范围</font>|全省代码|卡类购销划扣银行帐号|卡类购销划扣账号名称|卡类购销划扣开户银行|合作商编码|<font color=red>是否加入B2M模式</font>|账号类型|<br>卡类购销划扣银行标识|卡类购销划扣银行状态|合作类型|网点注册码|<font color=red>主要业务支撑方式</font>|<font color=red>是否接入空中充值平台</font>|全网统一渠道编码|乡镇|渠道基础类型|是否卖场加盟|前台营业面积（㎡）|运营商ISP接入方式|<font color=red>是否加入全员代理模式</font>|<font color=red>星级分层</font>|<font color=red>商圈类型</font>|<font color=red>是否TOP网点</font>|<font color=red>社会渠道类型</font>|<font color=red>所属商圈编码</font>|连锁加盟渠道属性|连锁加盟渠道系数|<font color=red>信用等级</font>|<font color=red>税务资质</font>|<font color=red>是否授权网点</font><%if("1".equals(param75)){%>|备注<%} %>|</p></td>
			</tr>
			<tr>
				<td align="right" height=25>举例说明:</td>
				<td align="left">
					导入支持两种格式，举例如下：<br>1、直接【全量数据导入】<br>2、【自定义文件导入】<br>&nbsp;&nbsp;只用于更新网点信息，第1行列出自定义导入列名称，第1列必须为渠道编码<br><br>【全量数据导入】举例：
					<font color="red">
						ZSCS001|中山市协新通讯设备有限公司|FDS|TDZS04---|4|-1|1|ZS|ZSCQ|||1|2||3|166|||2|15016128189||中山导入的地址|23.348482|122.007882|test|13899332200|076011223365|1@1.1|不知道||||2|HT1236541254|导入|2009-11-10|2010-11-10|2010-11-10|1122554411|2010-11-10|||1000|11|11|11|441623197810101|1|0|||||||0|0|20000009|1|GTX||7|0|rfd|乡镇|2|1|89|3|0|1|0|1|1|ZS001|A2|1|0|2|N<%if("1".equals(param75)){%>|备注<%}%>|<br><br>
					</font>
					【自定义文件导入】举例：<br>渠道编码|详细地址<br>JMJF88888|江门市新会区会城南隅路56号<br>JMJF88889|江门市新会区会城南隅路108号
				</td>
			</tr>
			<tr>
				<td align="right" height=25>
					补充说明 
				</td>
				<td align="left">
					时间格式为：YYYY-MM-DD<br/>零售渠道类别：PSAL 指定专营店 SAGT 特约代理点 FD FD服务店 FDS FD连锁店 VWAY虚拟渠道  JMQD连锁加盟渠道 
					<br/>星级：0 未定星级 1 一星级 2 二星级 3 三星级 4 四星级 5 五星级 6 六星级 7 3G渠道专用星级：社会渠道类型为3G渠道时，星级必须为7（3G渠道专用星级） 8 连锁加盟渠道星级：社会渠道类型为连锁加盟渠道时，星级必须为8（连锁加盟渠道星级） 9 4G渠道专用星级：社会渠道类型为4G渠道时，星级必须为9（4G渠道专用星级）  60(只对茂名地市) 6A:社会渠道类型必须为2G渠道,零售渠道类别为指定专营店
					<br/>排他性:0 销售单排它 1 非排他 2 宣传单排它 -1 销售宣传双排他<br/>状态：0 失效 1 有效 <br/>是否直供：0 非直供 1 直供 <br/>区域类型：0 城区 1 郊县 2 一类乡镇 3 二类乡镇 4 三类乡镇 99 其它<br/>业态类型：0 省级家电/通讯连锁 1 地市级家电/通讯连锁 2 独立手机销售点 3 百货店<br/>4 连锁便利店 5 银行/邮政 6 小便利店7 杂货铺/报刊亭/药店8	网吧,9	KTV,10	音像店,11	集团分销商,12	手机促销员,99 其它<br/>所属渠道经理：请在【渠道管理】→【渠道经理管理】查询录入<br/>分级：1 A级 2 B级 3 C级 99 其他<br/>签约类型\:0 授权协议 1 直供协议 2 直供双排他协议 3 积分协议 4 附加协议 99 其它<br/>保证金押金状态：0 未退还 1 部分退还 2 全额退还<br/>签约状态：0 正常 1 预解约 2 注销<br/>保证金交付形式：0 合作商统一交付 1 单点支付<br/>经营范围：0 主营 1 其他<br/>是否加入B2M模式：0 否 1 是<br/>账号类型：0 对公 1 对私（对私储蓄卡） 2 对私信用卡 3 对私借记卡 4 外币 5 对私存折 6 记名对私借记卡 7 记名对私储蓄卡 8 存折<br/>卡类购销划扣银行标识查询:<j:selector name="form.debankid" definition="#BANK" mode="picker" readonly="true"/><br/>卡类购销划扣银行状态: 0失效  1有效<br>合作类型:市公司在分公司自定义渠道类别(ch_pw_custwaytype)表设置的类别<br>是否授权网点：Y:是&nbsp;&nbsp;N:否<br>主要业务支撑方式    0：光缆    1：2M电缆    2：GPRS    3：CSD    4：拨号上网    5：无线网桥   6：专线接入BOSS    7：宽带接入BOSS    8：空中充值平台    9：网站接入    99：其他 <br/>是否接入空中充值平台    0：否   1：是<br/>渠道基础类型  0：实体厅   3：虚拟厅<br/>是否卖场加盟  0：否   1：是<br/>运营商ISP接入方式  0：移动宽带接入  1：移动无线接入  2：其他运营商方式接入  3：未接入<br/>是否加入全员代理模式  0：否  1：是<br/>星级分层  1：A  2：B  3：C 
					<br/>商圈类型 1: A类商圈 5: B类商圈 6: C类商圈 7: 非商圈 99:其他<br/>是否TOP网点  0：否  1：是<%if("1".equals(param75)){%><br/>备注：网点退出（渠道网点状态为：0暂停营业、-1已关店）的时候需要填写退出原因，不是网点退出的时候【备注】项填空<%} %>
					<br/>社会渠道类型：0:2G渠道 1:3G渠道 2：连锁加盟渠道 3:4G渠道
					<br/>社会渠道类型为0（2G渠道）时：所属商圈编码必填，无所属商圈网点统一填0000；
					<br/>社会渠道类型为1（3G渠道）时：所属商圈编码、连锁加盟渠道属性、连锁加盟渠道系数必需填写。
					<br/>社会渠道类型为2（连锁加盟渠道），星级必须为8（ 连锁加盟渠道星级）
					<br/>社会渠道类型为3（4G渠道）时，所属商圈编码、连锁加盟渠道属性、连锁加盟渠道系数必需填写。‘连锁加盟渠道属性’值为A+1（专营重要商圈）时，社会渠道类型必须为‘4G渠道’。社会渠道类型为‘4G渠道’，‘连锁加盟渠道属性’可以为A1\A2\B1\B2\C1\C2\A+1。
					<br/>信用等级  0：普通渠道  1：优质渠道  2：异常渠道 </br>税务资质：0：一般纳税人 1：小规模纳税人 2：其他</br>
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
					<%if("1".equals(param75)){%>
					<td align=left>
						<a href="<%=contextPath%>/channel/saleway/salewayimport1.xls">社会网点批量导入模板.xls</a>
						（注：填写后请将数据转换为txt格式，去掉标题行，再上传导入）</td>
					<%}else{ %>
					<td align=left>
						<a href="<%=contextPath%>/channel/saleway/salewayimport.xls">社会网点批量导入模板.xls</a>
						（注：填写后请将数据转换为txt格式，去掉标题行，再上传导入）</td>
					<%} %>
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
                           		value="<s:text name="button_return"/>" onclick="doReturn('/channel/saleway_list.do')">
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
<iframe src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.channel.saleway.SalewayTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
</iframe>
</body>
</html>