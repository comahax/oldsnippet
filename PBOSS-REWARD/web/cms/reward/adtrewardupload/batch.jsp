<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7F1A1A" />
</jsp:include>

<html:html>
<head>
	<title>市公司酬金明细文件上传</title>
	<script language="JavaScript">
		function checkProcess(){
			var filename=formItem.filename.value;
			if(filename != null || filename != ""){
          		formItem.buttonProcess.disabled=true;
	      		window.location.href="<%= contextPath%>/cms/cityrecord/batch.do?filename="+filename+"&beanname=com.sunrise.boss.ui.cms.cityrecord.CityrecordTaskBean";                                                                                        
			}
		}
		function checkfilename() {
			var filename = document.all.theFile.value;
			if(filename != "") {
				var arrys = filename.split(".");
				var filetype = arrys[arrys.length-1];
				if(filetype.toUpperCase() != "TXT"){
					errorMessageShow('<font color=red><b>提示信息:</b></font>要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!');
					return false;
				}
			}else{
				if(filename == ""){
					errorMessageShow('<font color=red><b>提示信息:</b></font>请选择上传的文件');
					return false;
				}
			}
			var mobile = document.all.mobile.value;
			if(mobile == "" || mobile.length != 11){
				errorMessageShow('<font color=red><b>提示信息:</b></font>短信接收号码必填且必须为11位手机号码.');
				return false;
			}
			return true; 
		}
		function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/reward/adtrewardupload/list.jsp";
    	}	
    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
	<html:form action="/cms/reward/adtrewardupload/batch.do" styleId="formItem" method="post" enctype="multipart/form-data">
		<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">		
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							市公司酬金明细文件上传
						</td>
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
				<tr class="table_style_content_lyl">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							选择上传文件:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:file styleClass="form_input_files" property="theFile"/>
					</td>
				</tr>
				<c:choose>
					<c:when test="${!empty requestScope.ITEM.inFile}">
						<tr class="table_style_content_lyl">
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
				<tr class="table_style_content_lyl">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							短信接收号码:
						</div>
					</td>
					<td width="75%" align="left" class="form_table_left">
						<html:text styleClass="form_input_1x" property="mobile"/><font color=red>*&nbsp;文件处理完成后接收短信通知的手机号码</font>
					</td>
				</tr>
				<tr class="table_style_content_lyl">
					<td align=right height=25>
						<bean:message bundle="upload" key="filetype" />
					</td>
					<td align=left>
						<bean:message bundle="upload" key="typevalue" />
					</td>
				</tr>
				<tr class="table_style_content_lyl">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							文件格式:
						</div>
					</td>
					<td align="left"><font color=red>渠道编码|业务编码|酬金期数|</font>手机、充值卡号码或IMEI号|<font color=red>结算月份|业务发生时间|业务量或业务发生金额|应发酬金合计|</font></td>
				</tr>
				<tr class="table_style_content_lyl">
					<td width="20%" align="right" class="form_table_right">
						<div class="field-require">
							举例说明:
						</div>
					</td>
					<td align="left"><font color=red>TDZS1211002|0101020100002|1|</font>13687569920|<font color=red>201201|2011-11-01 08:04:35|100|10|</font></td>
				</tr>
				<tr class="table_style_content_lyl">
				
					<!--  <td width="20%" align="right" class="form_table_right">-->
					<td align="right">
						<div class="field-require">
							补充说明:
						</div>
					</td>
					<!--  <td width="75%" align="left" class="form_table_left">-->
					<td align="left">
文件格式中用红色标记的字段为必填项,文件内容无标题行.<br>
1、渠道编号：必填，以COMS系统上渠道编号为准。普通网点的编码查询路径:渠道管理->社会网点信息管理；统一管理模式商编码的查询路径：渠道管理->连锁经营合作商管理。<br>
2、业务编码：必填，有效业务编码与审批编码对应关系查询路径: 酬金管理->社会渠道业务管理->数据有效性管理->业务与审批编码关系查询。<br>
3、酬金期数：必填，结算的酬金是第几期酬金，用数字表示，具体说明如下:<br>
&nbsp;(<br>
&nbsp;&nbsp;  1:一期<br>
&nbsp;&nbsp;  2:二期<br>
&nbsp;&nbsp;  3:三期<br>
 )<br>
4、手机号码或IMEI号：计件类业务和终端销售业务必填，其它类业务选填。产生该酬金的手机号码或终端IMEI号，如产生计件酬金的激活套卡号码或充值卡号码，产生维系酬金的<br>
 &nbsp;&nbsp; 全球通开户号码，产生达标奖的激活套卡号码，产生终端酬金的IMEI号；如星级奖励酬金，手机号码可以留空。<br>
5、结算月份：必填，就是酬金出账的帐期。例如，2012年2月5日出酬，则结算月份为201201。<br>
6、业务发生时间：计件类业务必填，其它类业务选填。星级奖励酬金则填写如2011-11-01 00:00:00等格式表示月份，如激活酬金对应的套卡激活时间，话费服务类酬<br>
 &nbsp;&nbsp; 金对应的缴费时间，格式为YYYY-MM-DD HH:MM:SS。<br>
7、业务量或业务发生金额：必填，填写销量或业务发生金额等数据，以套或元为单位。与业务发生金额相关的酬金类型必须填写该项，如充值100元获得1.5元话费服务类酬金，或者<br>
 &nbsp;&nbsp; 是获得充值金额的1.5%作为话费服务类酬金。业务量或业务发生金额整数部分不能超过10位,小数部分不能超过4位。<br>
8、应发酬金合计：必填，指出账的总金额。如果是入酬金池的酬金，第一期“应发酬金合计”应为入酬金池前的酬金总额，其它期数“应发酬金合计”为0元；针对不入酬金池的酬金，“应<br>
 &nbsp;&nbsp; 发酬金合计”与“本期应发酬金”相等，见表格范例说明。应发酬金合计整数部分不能超过10位,小数部分不能超过4位。<br>
				<font color="red">提示:每次进行新增操作</font>
				</td>
				</tr>
			</table>
		</div>
        <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							
							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_4"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload" onclick="return checkfilename()"/>
<!--							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_4"-->
<!--								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"-->
<!--								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />-->
								
							<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturnList()">
						</td>
					</tr>
				</table>
			</div>
	</html:form> 
	<br>
	</div>
</body>
</html:html>
