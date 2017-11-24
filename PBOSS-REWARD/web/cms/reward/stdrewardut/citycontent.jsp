<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant,java.util.*"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL"; //省级酬金管理令牌
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC"; //市级酬金管理令牌
	String NEW = (String) request
			.getAttribute(WebConstant.COMMAND_STRING_NEW);
%>
<html>
	<head>
		<title><bean:message bundle="stdrewardut" key="titleCard" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
		<script language="JavaScript">
	function ev_checkval() {
		addfield('rewardstdcity_51', '<bean:message bundle="stdrewardut" key="rewardstd51"/>', 'f', false, '16','2');
		addfield('intvmonthcity_51', '<bean:message bundle="stdrewardut" key="intvmonth51"/>', 'i', false, '5','','','0');
		addfield('rewardstdcity_52', '<bean:message bundle="stdrewardut" key="rewardstd52"/>', 'f', false, '16','2');
		addfield('intvmonthcity_52', '<bean:message bundle="stdrewardut" key="intvmonth52"/>', 'i', false, '5','','','0');
		addfield('integralnumcity_52', '<bean:message bundle="stdrewardut" key="integralnum"/>', 'i', false, '8');
		addfield('rewardstdcity_53', '<bean:message bundle="stdrewardut" key="rewardstd53"/>', 'f', false, '16','2');
		addfield('intvmonthcity_53', '<bean:message bundle="stdrewardut" key="intvmonth53"/>', 'i', false, '5','','','0');				
		addfield('unitpricecity_53', '<bean:message bundle="stdrewardut" key="unitprice"/>', 'f', false, '6','2');
		
		if(!checkMinAndMax(document.all("rewardstdcity_51").value*1,document.all("rewardstd_51").value*1,'专营补贴酬金'))
		{
			return false;
		}
		if(!checkMinAndMax(document.all("rewardstdcity_52").value*1,document.all("rewardstd_52").value*1,'销售达标酬金'))
		{
			return false;
		}
		if(!checkMinAndMax(document.all("integralnumcity_52").value*1,document.all("integralnum_52").value*1,'基准积分'))
		{
			return false;
		}
		if(!checkMinAndMax(document.all("rewardstdcity_53").value*1,document.all("rewardstd_53").value*1,'销售超额酬金'))
		{
			return false;
		}
		if(!checkMinAndMax(document.all("rewardstdcity_53").value*1,document.all("rewardstd_53").value*1,'销售超额酬金'))
		{
			return false;
		}
	 	if(!checkMinAndMax(document.all("unitpricecity_53").value*1,document.all("unitprice_53").value*1,'积分单价'))
	 	{
	 		return false;
	 	}
	 	var cityStd=document.all("rewardstdcity_52").value;
	 	var provStd=document.all("rewardstd_52").value;
	 	var cityInt=document.all("integralnumcity_52").value;
	 	var provInt=document.all("integralnum_52").value;
	 	if(cityStd!="" && provStd!=""  && cityInt!="" && provInt!="" && (cityStd*1-provStd*1>0) )
	 	{
	 		if(cityInt*1-provInt*1<=0)
	 		{
	 			alert("销售达标酬金,基准积分上浮比例必须大于等于积分上浮比例");
	 			return false;
	 		}
	 		var rateStd=((cityStd*1-provStd*1)/provStd*1)-1;
	 		var rateCus=((cityInt*1-provInt*1)/provInt*1)-1;
	 		if(rateCus<rateStd)
	 		{
	 			alert("销售达标酬金,基准积分上浮比例必须大于等于积分上浮比例");
	 			return false;
	 		}
	 	}
		return checkval(window);
	}
	function checkMinAndMax(checkValue,provinceValue,rewardname)
	{
		if(checkValue!="" && provinceValue!=""  &&　(checkValue<provinceValue*0.5 || checkValue>provinceValue*1.5))
		{
		  	   alert(rewardname+",地市标准超出省公司标准上下浮动50%范围");
		  	   return false;
		}else
		{
			return true;
		}
	}
</script>
	</head>
	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/stdrewardut.do?CMD=SAVECITY"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="rewardtype_51" value="51" />
				<html:hidden property="rewardtype_52" value="52" />
				<html:hidden property="rewardtype_53" value="53" />
				<html:hidden property="rewardid_51" />
				<html:hidden property="rewardid_52" />
				<html:hidden property="rewardid_53" />
				<html:hidden property="region" />
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope['cmdState']=='EDIT')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<c:set var="form" scope="request"
					value="${requestScope['/cms/reward/stdrewardut/StdrewardutForm']}" />
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="stdrewardut" key="titleList2" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<!-- 合作商资料 -->
				<div class="table_div" id="51">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardut"
											key="cooper" /> </font>
									<bean:message bundle="stdrewardut" key="remind" />
								
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="wayid" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:hidden property="wayid" />
								<c:out value="${form.wayid}" /> 
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="wayname" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<s:Code2Name
									code="${form.wayid}"
									definition="#WAY" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="calcumode" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:hidden property="calcumode" />
								<s:Code2Name
									code="${form.calcumode}"
									definition="$CH_CALCUMODE" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="uniformtime" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								 <html:hidden property="uniformtime" />
								 <c:out value="${form.uniformtime}" /> 
							</td>
						</tr>
					</table>
				</div>
				
				<!-- 51  专营补贴酬金 -->
				<div class="table_div" id="51">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardut"
											key="reward_51" /> </font>
									<bean:message bundle="stdrewardut" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:hidden property="rewardname_51" />
								<c:out value="${form.rewardname_51}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:hidden property="rewardtype_51" />
								<s:Code2Name
									code="${form.rewardtype_51}"
									definition="$CH_REWARDTYPE" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
										<html:hidden  property="startdate_51" />
										<c:out value="${form.startdate_51 }" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
										<html:hidden  property="stopdate_51" />
										<c:out value="${form.stopdate_51 }" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstdcity_51"
									maxlength="16" />
									<html:hidden property="rewardstd_51" />
									<font color=red>*</font>
								<br>
								(省公司指导酬金标准<c:out value="${form.rewardstd_51}" /> 元,可照此标准上下浮动50%)
								
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="intvmonth" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonthcity_51"
									maxlength="2" />
									<font color=red>*</font>
								<br>
								<html:hidden property="intvmonth_51" />	
								<bean:message bundle="stdrewardut" key="invnotice" />
							</td>
						</tr>
					</table>
				</div>

				<!-- 52 销售达标酬金 -->
				<div class="table_div" id="52">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardut"
											key="reward_52" /></font>
									<bean:message bundle="stdrewardut" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<html:hidden property="rewardname_52" />
								<c:out value="${form.rewardname_52}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<s:Code2Name
									code="${form.rewardtype_52}"
									definition="$CH_REWARDTYPE" />
								<html:hidden  property="rewardtype_52" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
										<html:hidden property="startdate_52" />
										<c:out value="${form.startdate_52}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
										<html:hidden property="stopdate_52" />
										<c:out value="${form.stopdate_52}" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardstd" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstdcity_52"
									maxlength="16" />
								<html:hidden  property="rewardstd_52" />
									<font color=red>*</font>
								<br>
								(省公司指导酬金标准为<c:out value="${form.rewardstd_52 }" />,可照此标准上下浮动50%,不低于酬金标准上浮比例)
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="integralnum" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left" colspan="3">
								<html:text styleClass="form_input_1x" property="integralnumcity_52"
									maxlength="8" />
									<html:hidden  property="integralnum_52" />
									<font color=red>*</font>
									<br>
									(省公司指导基准积分为<c:out value="${form.integralnum_52}" />,可照此标准上下浮动50%,不低于酬金标准上浮比例)
							</td>
						</tr>
						<tr>
							
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="intvmonth" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:hidden property="intvmonth_52" />
								<html:text styleClass="form_input_1x" property="intvmonthcity_52"
									maxlength="2" />
									<font color=red>*</font>
								<br>
							</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</div>

				<!-- 53 销售超额酬金 -->
				<div class="table_div" id="53">
					<table class="form_table">
						<tr>
							<td width="100%" colspan=4 class="form_table_left">
								<div class="field-require">
									<font color=blue><bean:message bundle="stdrewardut"
											key="reward_53" /> </font>
									<bean:message bundle="stdrewardut" key="remind" />
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardname" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
									<html:hidden property="rewardname_53" />
									<c:out value="${form.rewardname_53}" />
									<font color=red>*</font>
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardtype" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
								<s:Code2Name
									code="${form.rewardtype_53}"
									definition="$CH_REWARDTYPE" />
								<html:hidden  property="rewardtype_53" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="startdate" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
										<html:hidden property="startdate_53" />
										<c:out value="${form.startdate_53}" />
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="stopdate" />
									:
								</div>
							</td>
							<td width="30%" align="left" class="form_table_left">
										<html:hidden property="stopdate_53" />
										<c:out value="${form.stopdate_53}" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="rewardstd53" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="rewardstdcity_53"
									maxlength="16" />
								<html:hidden  property="rewardstd_53" />
							    <font color=red>*</font>
								<br>
								(省公司指导酬金标准为<c:out value="${form.rewardstd_53}" />,可照此标准上下浮动50%)
							</td>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="intvmonth" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left">
								<html:text styleClass="form_input_1x" property="intvmonthcity_53"
									maxlength="2" />
								<html:hidden property="intvmonth_53" />	
								<br>
								<font color=red>*</font>
								<bean:message bundle="stdrewardut" key="invnotice" />
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="stdrewardut" key="unitprice" />
									:
								</div>
							</td>
							<td width="30%" class="form_table_left" colspan="3">
								<html:text styleClass="form_input_1x" property="unitpricecity_53"
									maxlength="6" />
								<html:hidden  property="unitprice_53" />
								<font color=red>*</font>
								(省公司指导积分单价为<c:out value="${form.unitprice_53}" />,可照此标准上下浮动50%)
							</td>
						</tr>
					</table>
				</div>
				
				<!-- button list, NEW and SAVE and DELETE -->
				<table class="table_button_list">
					<tr>
						<td>
						<s:RewardPurChk controlid="<%=ID_2%>">
							<c:choose>
								<c:when test="${edtState}">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="save"
										onclick="doSave('/cms/reward/stdrewardut.do?CMD=SAVECITY');" />
								</c:when>
								<c:otherwise>
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="save" disabled="true" />
								</c:otherwise>
							</c:choose>
							</s:RewardPurChk>
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnDeleteOne"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="back"
								onclick="doReturn('/cms/reward/stdrewardut.do?CMD=LISTCITY')" />
						</td>
					</tr>
				</table>
			</html:form>
		</div>
	</body>
</html>
