<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="com.sunrise.jop.ui.User"%>
<%@ page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%
			User user = (User) request.getSession().getAttribute(
			WebConstant.SESSION_ATTRIBUTE_USER);
	String cityid = com.sunrise.jop.infrastructure.db.CityMappingUtil
			.getCityNo(user.getCityid());
%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
		<script language="JavaScript">
        function ev_check() {
        	addfield('param._de_createtime', '创建日期>=', 'c', false, '32');
        	addfield('param._de_createtime1', '创建日期<=', 'c', false, '32');
        	addfield('param._se_discomcode', '配送商', 'c', false, '32');
           	return (checkval(window) && compareDate());
        }
        
        function compareDate(){
        	var dnmOptime = document.getElementById('param._de_createtime1').value;
        	var dnlOptime = document.getElementById('param._de_createtime').value;
        	
        	if(dnmOptime != '' && dnlOptime != '' && dnlOptime>dnmOptime){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[创建日期>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[创建日期<=]</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        
		function doPrint(){
			if($(":select[name='param._se_countyid']").attr("disabled")){
				var countyid=$(":select[name='param._se_countyid']").val();
				formList.action = "<%=contextPath%>/sales/disform_gatherprint.do?param._se_countyid="+countyid;
			}else{
				formList.action = "<%=contextPath%>/sales/disform_gatherprint.do";
			}
			if(document.formList.onsubmit == null || document.formList.onsubmit())
				document.formList.submit();
		}
		
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="disform_list.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<aa:zone name="hiddenZone">
					<s:hidden name="CMD" />
					<s:hidden name="param._orderby" />
					<s:hidden name="param._desc" />
					<s:hidden name="param._pageno" />
					<s:hidden name="param._pagesize" />
					<s:hidden name="param.queryAll" />
					<input type="hidden" name="_rowcount"
						value="<s:property value="dp.rowCount" />" />
				</aa:zone>

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="sales" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h">配送单汇总打印
						</span>
					</div>
				</div>

				<aa:zone name="errorZone">
					<div class="error_text">
						<table class="error_text">
							<s:actionerror />
							<s:actionmessage />
						</table>
					</div>
				</aa:zone>

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="center">
								创建时间>=
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._de_createtime"
									onclick="selectDatetime();" readonly="true" />
									<font color=red>*</font>
							</td>
							<td align="center">
								创建时间<=
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._de_createtime1"
									onclick="selectDatetime();" readonly="true" />
									<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="countyid" />
								:
							</td>
							<td align="left">
								<j:purChk permid="FX_DISFORGATHER_CITY"> 
                   					<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="param._se_countyid" mode="selector" />
                   					<font color=red>*</font>
               	 				</j:purChk>
							</td>
							<td align="center">
								<s:text name="discomcode" />
								:
							</td>
							<td align="left">
								<j:selector name="param._se_discomcode" definition="#WAYIDINFO"
									condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}" />
									<font color=red>*</font>
							</td>
						</tr>
						</table>
						</div>
						<div class="table_div">
						<table class="table_button_list">
						<tr>
							<td>
									<input type="button" id="btnPrint" name="btnPrint"
										class="button_4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="汇总打印"
										onClick="doPrint();">
							</td>
						</tr>
					</table>
				</div>
			</s:form>
	</body>
</html>
