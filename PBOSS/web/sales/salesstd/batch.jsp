<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page
	import="java.util.ArrayList,com.opensymphony.xwork2.*,com.gmcc.pboss.business.base.dictitem.DictitemVO"%>


<html>
	<head>
		<title>批量导入</title>
		<script language="JavaScript" type="text/JavaScript">
	    function checkProcess(){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/sales/salesstdprocess.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.salesstd.SalesstdTaskBean";
			}
		}
	    function doReturn(cmdReturn) {
	        formItem.action = contextPath + cmdReturn;
	        formItem.submit();
	    }
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<s:form action="/sales/salesstdupload.do" method="POST" key="formItem"
			cssStyle="formItem" enctype="multipart/form-data" theme="simple">
			<div class="table_top">
				<div class="table_topleft"></div>
				<div class="table_toparea_w">
					<s:i18n name="public">
						<span class="table_toparea"><s:text name="currentPos" /> </span>
						<span class="table_toparea_xi">&gt;</span>
						<span class="table_toparea"><s:text name="sales" /> </span>
						<span class="table_toparea_xi">&gt;</span>
						<span class="table_toparea">合作商销量提醒 </span>
						<span class="table_toparea_xi">&gt;</span>
					</s:i18n>
					<span class="table_toparea_h">合作商销量阀值</span>
				</div>
			</div>
			<input type="hidden" name="filename"
				value='<s:property value="fileName"/>'>
			<input type="hidden" name="path"
				value='<s:property value="filepath"/>'>
			<input type="hidden" name="iCheckFormat"
				value="com.gmcc.pboss.web.sales.salesstd.SalesstdCheck">
			<aa:zone name="errorZone">
				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>
			</aa:zone>
			<aa:zone name="listZone">
				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="right" width="60px">
								选择文件:
							</td>
							<td align="left">
								<s:file name="doc" label="File" />
							</td>
						</tr>
						<tr>
							<td align="right" height=25>
								文件类型:
							</td>
							<td align="left">
								.txt文本文件 (文本里不要留空行和多余的空格)
							</td>
						</tr>
						<tr>
							<td align="right">
								文件:
							</td>
							<td align="left">
								<a
									href='<%=contextPath%>/common/download.jsp?filename=<s:property value="filepath" />'>
									<s:property value="fileName" /> </a>
							</td>
						</tr>
						<tr>
							<td align="right" height=25>
								文件格式:
							</td>
							<td align="left">
								<FONT color=red>分公司|微区域|星级|销量阀值|</FONT>
							</td>
						</tr>
						<tr>
							<td align="right" height=25>
								举例说明:
							</td>
							<td align="left">
								<FONT color=red>ZS0|ZS001|1|10|</FONT>
							</td>
						</tr>
						<tr>
							<td align="right" height=25>
								补充说明
							</td>
							<td align="left">
								文件格式中用红色标记的字段为必填项，文件内容无标题行。
								<br>
								分公司：本地市下属的分公司。
								<br>
								星级：0-未定星级 1-一星级 2-二星级 3-三星级 4-四星级 5-五星级 6-六星级
								<br>
								微区域：分公司下辖微区域编码
								<br> 
							
								<!-- BrandMzone-动感地带  BrandMwl-动感网聊卡  BrandSzx-神州行  BrandDzk-神州大众卡 <br>
				最高库存：大于零的整数，最大长度10位。 -->
								<br>
								销量阀值：单位：套，要求大于零的整数，不超过10位
								
								<br>
								<FONT color=red>提示：记录不存在时进行新增操作，存在时进行更新操作。</FONT>
								<br>
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
											<input type="submit" id="btnBatch" name="btnBatch"
												class="button_New" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												value="<s:text name="button_upload"/>">
											<input type="button" id="buttonProcess" name="buttonProcess"
												class="button_New" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)" onclick="checkProcess()" value="处理">
											<input type="button" id="btnReturn" name="btnReturn"
												class="button_Back" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)"
												value="<s:text name="button_return"/>"
												onclick="doReturn('/sales/salesstd_list.do')">
										</s:i18n>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>

		</s:form>
		<iframe
			src="<%=contextPath%>/common/commonStatus.jsp?beanname=com.gmcc.pboss.web.sales.salesstd.SalesstdTaskBean"
			frameborder="0" class="loadframe" id="loadframe" scrolling="no">
		</iframe>
	</body>
</html>