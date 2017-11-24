<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/contenthead.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base target="_self">
	<title><s:text name="titleUpdate" /></title>
	<style>
.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity =               80);
}

.white_content {
	display: none;
	position: absolute;
	top: 20%;
	left: 10%;
	width: 80%;
	height: 80%;
	border: 16px solid lightblue;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}

.white_content_small {
	display: none;
	position: absolute;
	top: 20%;
	left: 30%;
	width: 40%;
	height: 30%;
	border: 12px solid lightblue;
	background-color: white;
	z-index: 1002;
	overflow: auto;
	text-align: center;
}
</style>
	<script language="JavaScript">
		function ev_checkval() {
			addfield('form.validbillcyc', '<s:text name="validbillcyc"/>', 'l',
					false, 8);
			return checkval(window);
		}
		// 获取出账状态        
		function doFetchStatus() {
			var validbillcyc = document.getElementById("validbillcyc").value;
			formItem.action = "fee/billing/uapreqfile_newUpload.do?validbillcyc="
					+ validbillcyc;
			formItem.submit();
		}
		function checkStatus() {
			if ($("input[id='status_A102']").val() == 3) {
				$("input[value='1101']").attr("disabled", true);
				$("input[value='1102']").attr("disabled", true);
			} else if ($("input[id='status_A101']").val() == 3) {
				$("input[value='1103']").attr("disabled", true);
				$("input[value='1104']").attr("disabled", true);
			} else if ($("input[id='status_A102']").val() != 3
					&& $("input[id='status_A101']").val() != 3) {
				$("input[value='1101']").attr("disabled", true);
				$("input[value='1102']").attr("disabled", true);
				$("input[value='1103']").attr("disabled", true);
				$("input[value='1104']").attr("disabled", true);
			}

			if ($("input[id='status_A105']").val() == 3) {
				$("input[value='1105']").attr("disabled", true);
				$("input[value='1106']").attr("disabled", true);
				$("input[value='1107']").attr("disabled", true);
				$("input[value='1108']").attr("disabled", true);
				$("input[value='1109']").attr("disabled", true);
				$("input[value='1110']").attr("disabled", true);
				$("input[value='1111']").attr("disabled", true);
				$("input[value='1112']").attr("disabled", true);
			} else if ($("input[id='status_A104']").val() == 3) {
				$("input[value='1105']").attr("disabled", true);
				$("input[value='1106']").attr("disabled", true);
				$("input[value='1107']").attr("disabled", true);
				$("input[value='1108']").attr("disabled", true);
				$("input[value='1113']").attr("disabled", true);
				$("input[value='1114']").attr("disabled", true);
				$("input[value='1115']").attr("disabled", true);
				$("input[value='1116']").attr("disabled", true);
			} else if ($("input[id='status_A103']").val() == 3) {
				$("input[value='1109']").attr("disabled", true);
				$("input[value='1110']").attr("disabled", true);
				$("input[value='1111']").attr("disabled", true);
				$("input[value='1112']").attr("disabled", true);
				$("input[value='1113']").attr("disabled", true);
				$("input[value='1114']").attr("disabled", true);
				$("input[value='1115']").attr("disabled", true);
				$("input[value='1116']").attr("disabled", true);
			} else if ($("input[id='status_A103']").val() != 3
					&& $("input[id='status_A104']").val() != 3
					&& $("input[id='status_A105']").val() != 3) {
				$("input[value='1105']").attr("disabled", true);
				$("input[value='1106']").attr("disabled", true);
				$("input[value='1107']").attr("disabled", true);
				$("input[value='1108']").attr("disabled", true);
				$("input[value='1109']").attr("disabled", true);
				$("input[value='1110']").attr("disabled", true);
				$("input[value='1111']").attr("disabled", true);
				$("input[value='1112']").attr("disabled", true);
				$("input[value='1113']").attr("disabled", true);
				$("input[value='1114']").attr("disabled", true);
				$("input[value='1115']").attr("disabled", true);
				$("input[value='1116']").attr("disabled", true);
			}
		}

    	$(document).ready(function()
    	    	  {
    	    	  	//$("input[name='form.validbillcyc']").val(getCurrBillCyc());
    	    	  	
    	    	  	$("input[name='allbox']:checkbox").click(function(){
    	    	  		$("input[name='param._selectitem']").each(function(){
    	            		if($(this).attr("disabled") == undefined && $(this).attr("checked") == undefined){//未选中返回undefined，选中则返回checked
    	            			$(this).attr("checked",true);
    	            		}
    	            		else{
    	            			$(this).attr("checked",false);
    	            		}
    	            	});
    	    	  	});
    	    	  	
    	    	  });  

	  	function checkboxsl() {
	  		if(ev_checkval()){
	  			var flg = false;
	  			$("input[name='param._selectitem']").each(function(){
	  				if($(this).attr("checked") == "checked"){
	  					flg = true;
	  				}
	  			});
	  			if(!flg){
	  				alert('请选择文件类型!');
	  				return false;
	  			}
	  			return true;
	  		}
	  		return false;
	  	}  	
    	
		//加载文件路径
		function loadPath() {
			
			if(!checkboxsl()) return;
			$.ajax({
			  type: "POST",
			  url: "<%= contextPath %>/fee/billing/uapreqfile_loadUploadPath.do",
			  data: "",
			  success: function(data){
				  var arr = data.split(";;");
				  $("#ruleId").val(arr[0]);
				  $("#uploadfile").val(arr[1]);
				  ShowDiv("uploadpath", "fade");
			  }
			});
		}

		//弹出隐藏层
		function ShowDiv(show_div, bg_div) {
			document.getElementById(show_div).style.display = 'block';
			document.getElementById(bg_div).style.display = 'block';
			var bgdiv = document.getElementById(bg_div);
			bgdiv.style.width = document.body.scrollWidth;
			// bgdiv.style.height = $(document).height();
			$("#" + bg_div).height($(document).height());
		};

		//关闭弹出层
		function CloseDiv(show_div, bg_div) {
			document.getElementById(show_div).style.display = 'none';
			document.getElementById(bg_div).style.display = 'none';
		};
	</script>
</head>
<body onload="checkStatus();">
	<s:form action="uapreqfile_saveReqAndRu.do" key="formItem" method="post"
		theme="simple">
		<s:hidden name="CMD" />

		<div class="widgetL">
			<div class="wCenter">
				<div class="content">
					<div class="title_name">发起上传请求</div>
					<aa:zone name="errorZone">
						<div class="error_text">
							<s:actionerror />
							<s:actionmessage />
						</div>
					</aa:zone>
					<div class="search2">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th><s:text name="validbillcyc" />:</th>
								<td width="75%" align="left"><s:textfield cssClass="Wdate"
										name="form.validbillcyc" id="validbillcyc" readonly="true"
										onchange="doFetchStatus();"
										onfocus="WdatePicker({skin:'default',dateFmt:'yyyyMM00'})"></s:textfield>
									<aa:zone name="rhbillstatus">
										<s:hidden name="#request.status_A101" id="status_A101" />
										<s:hidden name="#request.status_A102" id="status_A102" />
										<s:hidden name="#request.status_A103" id="status_A103" />
										<s:hidden name="#request.status_A104" id="status_A104" />
										<s:hidden name="#request.status_A105" id="status_A105" />
									</aa:zone></td>
							</tr>
							<tr>
								<th><s:text name="reqtype" />:</th>
								<td width="75%" align="left"><s:checkbox name="allbox"
										cssClass="table_checkbox" /> <s:text name="chooseall" /></td>
							</tr>
							<tr>
								<th>预付费低销:</th>
								<td width="75%" align="left" class="form_table_left">
									<table>
										<tr>
											<td style="border:1px dashed #ccc">
												<table>
													<tr>
														<s:iterator value="#request.PREFEE.datas" var="item"
															status="status">
															<s:if test="#status.count > 4">
																<s:if test="#status.index%4==0">
													</tr>
													</s:if>
													</s:if>
													<td><input type="checkbox" class="table_checkbox"
														name="param._selectitem" value="${ item.dictid }" /> <s:text
															name="#item.dictname" /></td>
													</s:iterator>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<th></th>
								<td width="75%" align="left" class="form_table_left"><s:i18n
										name="public">
										<s:if test="#request.SUCCEED=='SUCCEED'">
											<input type="submit" name="btnSave"
												onmouseover="this.className='bt48'"
												onMouseOut="this.className='bt48_gray'"
												value="<s:text name="button_yes"/>" class="bt48_gray"
												disabled="disabled" />
										</s:if>
										<s:else>
											<input type="button" name="btnSave"
												onmouseover="this.className='bt48'"
												onMouseOut="this.className='bt48_gray'" onclick="loadPath()"
												value="<s:text name="button_yes"/>" class="bt48_gray" />
										</s:else>
										<input type="button" value="<s:text name="button_return"/>"
											onmouseover="this.className='bt48'"
											onMouseOut="this.className='bt48_gray'" class="bt48_gray"
											onclick="doReturn('/fee/billing/uapreqfile_listUpload.do')" />
									</s:i18n></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!--弹出层时背景层DIV-->
		<div id="fade" class="black_overlay"></div>
		<div id="uploadpath" class="white_content_small" style="">
			<div style="text-align: right; cursor: default; height: 40px;">
				<span style="font-size: 12px;"
					onclick="CloseDiv('uploadpath','fade')"></span>
			</div>
			<input type="hidden" name="ruleId" id="ruleId" value=""/>
			上传文件路径： <input type="text" id="uploadfile" name="uploadfile" /> </br> </br> </br> <input
				type="submit" name="btnSave2" onmouseover="this.className='bt48'"
				onMouseOut="this.className='bt48_gray'"
				value="<s:text name="button_yes"/>" class="bt48_gray" /> <input
				type="button" name="btnSave2" onmouseover="this.className='bt48'"
				onMouseOut="this.className='bt48_gray'"
				onclick="CloseDiv('uploadpath','fade')"
				value="<s:text name="button_return"/>" class="bt48_gray" />
		</div>
	</s:form>
</body>
</html>
