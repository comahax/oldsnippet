<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html:html>
<head>
	<title>自建他营酬金报表导入</title>
	<script language="JavaScript">
		function checkProcess(){
			var filename=formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/cms/zjty/zjtyrewardimpbatch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardimp.ChZjtyRewardImpTaskBean";
			}
		}
		
		function showDiv(select) {
			var rewardzjtyreport = select.value;
			document.getElementById("explain").style.display="none";
			document.getElementById("templet").style.display="none";
			document.getElementById("txttype").style.display="none";
			document.getElementById("xlstype").style.display="none";
			document.getElementById("gotonetemplet").style.display="none";
			document.getElementById("nogotonetemplet").style.display="none";
			
			document.getElementById("REWARDTOTAL").style.display="none";
			document.getElementById("REWARDTOTAL1").style.display="none";
			document.getElementById("GDREWARDTOTAL").style.display="none";
			document.getElementById("GDREWARDTOTAL1").style.display="none";
			document.getElementById("PERCONFIGTOTAL").style.display="none";
			document.getElementById("PERCONFIGTOTAL1").style.display="none";
			document.getElementById("PERCONFIGDETAIL").style.display="none";
			document.getElementById("PERCONFIGDETAIL1").style.display="none";
			document.getElementById("JJREWARDTOTAL").style.display="none";
			document.getElementById("JJREWARDTOTAL1").style.display="none";
			document.getElementById("REWARDBUSINESS").style.display="none";
			document.getElementById("REWARDBUSINESS1").style.display="none";
			document.getElementById("ZDSALEREWARD").style.display="none";
			document.getElementById("ZDSALEREWARD1").style.display="none";
			document.getElementById("GOTONEDETAIL").style.display="none";
			
			if(rewardzjtyreport=='GOTONEDETAIL'){
				document.getElementById("templet").style.display="block";
				document.getElementById("xlstype").style.display="block";
				document.getElementById("gotonetemplet").style.display="block";
				document.getElementById("GOTONEDETAIL").style.display="block";
			} else if (rewardzjtyreport=='NOGOTONEDETAIL') {
				document.getElementById("templet").style.display="block";
				document.getElementById("xlstype").style.display="block";
				document.getElementById("nogotonetemplet").style.display="block";
				document.getElementById("GOTONEDETAIL").style.display="block";
			} else {
				document.getElementById("explain").style.display="block";
				document.getElementById("txttype").style.display="block";
			}
			
			if (rewardzjtyreport=='REWARDTOTAL') {
				document.getElementById("REWARDTOTAL").style.display="block";
				document.getElementById("REWARDTOTAL1").style.display="block";
			} else if (rewardzjtyreport=='GDREWARDTOTAL') {
				document.getElementById("GDREWARDTOTAL").style.display="block";
				document.getElementById("GDREWARDTOTAL1").style.display="block";
			} else if (rewardzjtyreport=='PERCONFIGTOTAL') {
				document.getElementById("PERCONFIGTOTAL").style.display="block";
				document.getElementById("PERCONFIGTOTAL1").style.display="block";
			} else if (rewardzjtyreport=='PERCONFIGDETAIL') {
				document.getElementById("PERCONFIGDETAIL").style.display="block";
				document.getElementById("PERCONFIGDETAIL1").style.display="block";
			} else if (rewardzjtyreport=='JJREWARDTOTAL') {
				document.getElementById("JJREWARDTOTAL").style.display="block";
				document.getElementById("JJREWARDTOTAL1").style.display="block";
			} else if (rewardzjtyreport=='REWARDBUSINESS') {
				document.getElementById("REWARDBUSINESS").style.display="block";
				document.getElementById("REWARDBUSINESS1").style.display="block";
			} else if (rewardzjtyreport=='ZDSALEREWARD') {
				document.getElementById("ZDSALEREWARD").style.display="block";
				document.getElementById("ZDSALEREWARD1").style.display="block";
			}
		}
		
		function uploadSubmit(){
			var reporttime = formItem.rewardreporttime.value;
			if (reporttime == null || reporttime == "") {
				alert("月份不能为空，请输入");
				formItem.rewardreporttime.focus();
				return false;
			}
			document.formItem.submit();
		}
    </script>
</head>
<body onload="loadforiframe();showDiv(document.getElementById('rewardzjtyreport'))">
<div class="table_container">
	<html:form action="/cms/zjty/zjtyrewardimpbatch.do?CMD=UPLOAD" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>自建他营酬金报表导入</td>
					</tr>
				</table>
		    </div>
			<div class="table_div">
			<table width="100%" class="error_text">
	        	<s:Msg />
	   		</table>
	   		</div>
	   		<div class="table_div">
			<table class="form_table">	
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">报表月份:</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:text styleClass="form_input_1x" property="rewardreporttime" styleId="rewardreporttime" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})" readonly="true"></html:text>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">报表类型:</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:select property="rewardzjtyreport" onchange="showDiv(this);">
							<s:Options definition="$REWARD_ZJTYREPORT"/>
						</html:select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">选择上传文件:</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
					</td>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.ITEM.inFile}">
						<tr>
							<td align=right height=25>
								<bean:message bundle="upload" key="existfile" />
							</td>
							<td align=left>
								<a href='<%=contextPath%>/commons/batch/download.jsp?filename=
								<c:out value="${requestScope.ITEM.inFile}" />'>
								<c:out value="${requestScope.ITEM.fileName}" /> </a>
							</td>
						</tr>
					</c:when>
				</c:choose>
				<tr>
					<td align=right height=25>
						<bean:message bundle="upload" key="filetype" />
					</td>
					<td align=left>
						<div id="txttype" style="display: none" class="field-require"><bean:message bundle="upload" key="typevalue" /></div>
						<div id="xlstype" style="display: none" class="field-require">.xls文件&nbsp;<font color="red">(注：仅支持Excel 97-2003的xls文档)</font></div>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							文件格式 :
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<div id="REWARDTOTAL" style="display: none" class="field-require">合作商|公司类别|市公司|自建他营厅名称|BOSS渠道编码|固定酬金总额|计件酬金总额|超额酬金扣减|业务扣减|酬金总计</div>
						<div id="GDREWARDTOTAL" style="display: none" class="field-require">合作商|公司类别|市公司|自建他营厅名称|交接日期|配置人员总计|固定酬金额度|运营管理费用扣除|小计</div>
						<div id="PERCONFIGTOTAL" style="display: none" class="field-require">合作商|公司类别|市公司|自建他营厅|交接日期|配置人员总计</div>
						<div id="PERCONFIGDETAIL" style="display: none" class="field-require">所属合作商|市公司|分公司|渠道编码|渠道名称|姓名|职位|BOSS工号|工号开通时间|认证情况|联系电话</div>
						<div id="JJREWARDTOTAL" style="display: none" class="field-require">
							合作商|公司类别|市公司|自建他营厅名称|全球通新增放号酬金|预付费转全球通酬金|动感地带套卡销售酬金|<br>
							神州行套卡销售酬金|充值业务酬金|定制终端酬金|综合业务酬金|自助业务酬金|动感地带网聊卡、信息机套卡、欢乐在线酬金|<br>
							家庭宽带开户酬金|数据业务酬金|集团业务酬金|地市公司营销重点类业务酬金|全球通放号酬金扣减|合计</div>
						<div id="REWARDBUSINESS" style="display: none" class="field-require">
							合作商|公司类别|市公司|自建他营厅名称|全球通新增放号酬金|预付费转全球通|动感地带套卡销售酬金|神州行套卡销售酬金|<br>
							充值业务酬金|定制终端酬金|综合业务酬金|自助业务酬金|动感地带网聊卡、信息机套卡、欢乐在线酬金|家庭宽带开户酬金|<br>
							数据业务酬金|集团业务酬金|地市公司营销重点类业务酬金|合计</div>
						<div id="ZDSALEREWARD" style="display: none" class="field-require">
							合作商|地市|营业厅名称|定制终端销量合约机|定制终端销量零合约|定制终端销量裸机|定制终端销量合计|<br>
							引商入柜定制终端销量合约机|引商入柜定制终端销量零合约|引商入柜定制终端销量裸机|引商入柜定制终端销量合计|<br>
							定制终端酬金合约机|定制终端酬金零合约|定制终端酬金裸机|定制终端酬金合计|引商入柜定制终端酬金合约机|<br>
							引商入柜定制终端酬金零合约|引商入柜定制终端酬金裸机|引商入柜定制终端酬金合计</div>
						<div id="GOTONEDETAIL" style="display: none" class="field-require">
							<font color="red">文件里不要留空行，且表头保留，不要删除表头</font>
						</div>
					</td>
				</tr>
				<tr style="display: none" id="explain">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							举例说明:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<div id="REWARDTOTAL1" style="display: none" class="field-require">广东骏和|三类公司|肇庆|四会江谷服营厅|ZQ_HAZQ31003|0|0|0|0|0</div>
						<div id="GDREWARDTOTAL1" style="display: none" class="field-require">广东骏和|三类公司|肇庆|四会江谷服营厅|2008-12-9|4|1000|0|4000</div>
						<div id="PERCONFIGTOTAL1" style="display: none" class="field-require">广东骏和|三类公司|肇庆|四会江谷服营厅|2008-12-9|4</div>
						<div id="PERCONFIGDETAIL1" style="display: none" class="field-require">广东骏和|肇庆|高要|HAZQ25113|高要小湘服营厅|张三|店面经理|HZQ2AC0007|2009-6-30|高级|13800000000</div>
						<div id="JJREWARDTOTAL1" style="display: none" class="field-require">广东骏和|三类公司|肇庆|四会江谷服营厅|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0</div>
						<div id="REWARDBUSINESS1" style="display: none" class="field-require">广东骏和|三类公司|肇庆|四会江谷服营厅|1|1|1|1|1|1|1|1|1|1|1|1|1|1</div>
						<div id="ZDSALEREWARD1" style="display: none" class="field-require">广东骏和|肇庆|四会江谷服营厅|1|1|1|1|1|1|1|1|1|1|1|1|1|1|1|1</div>
					</td>
				</tr>
				<tr style="display: none" id="templet">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							Excel填写模板:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left" nowrap="false">
						<div id="gotonetemplet" style="display: none" class="field-require"><a href="<%=contextPath%>/cms/zjty/chzjtylocalrewardimp/gotonedetail.xls">全球通基础酬金明细.xls</a></div>
						<div id="nogotonetemplet" style="display: none" class="field-require"><a href="<%=contextPath%>/cms/zjty/chzjtylocalrewardimp/nogotonedetail.xls">非全球通基础酬金明细.xls</a></div>
					</td>
				</tr>
			</table>
		</div>
		<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.zjty.chzjtylocalrewardimp.ChZjtyRewardImpTaskBean"
				frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" value="<bean:message bundle="upload" key="upload" />" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload" onclick="uploadSubmit();"/>
							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
