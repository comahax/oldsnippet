<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<%@ page import="com.gmcc.pboss.common.dictionary.ConstantsType" %>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ taglib prefix="st" uri="/select-tag"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- 头部导航条 -->
	<!-- 头部 -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<form id="frmSubmit" method="POST" action="Submit.do" onsubmit="return doSubmit();">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			<c:if test='${fn:length(message)>0}'>
		<DIV><font color="red">错误提示：${message}</font></DIV></c:if>
	<s:if test="%{result.data.size > 0}">
		<s:set name="emp" value="result.data[0]" />
			<div class="listboxlist">
			<div class="listboxtitle">个人信息</div>
			<input type="hidden" name="apply.employeeid" value="${emp.employeeid}"/>
			<table class="tb02" width="96%">
				<tbody>		
					<tr>
						<td class="blue_01 textRight" width="20%">姓名：</td>
						<td class="red_01" width="30%">
						<input name="apply.employeename" type="text" class="text_01" id="apply.employeename" value="${emp.employeename}" maxlength="20"/>&nbsp;<font color="#FF0000">*</font>
						</td>
						<td class="blue_01 textRight" width="20%">性别：</td>
						<td class="red_01" width="30%">
                			<st:st name="apply.sex" className="formSelect_2L" type="<%=ConstantsType.SEX %>" selected="${emp.sex}"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">身份证号：</td>
						<td class="red_01" width="30%">
						<input name="apply.cardid" type="text" class="text_01" id="apply.cardid" value="${emp.cardid}" maxlength="18"/>&nbsp;<font color="#FF0000">*</font></td>
						<td class="blue_01 textRight" width="20%">籍贯：</td>
						<td class="red_01" width="30%">
						<input name="apply.nativehome" type="text" class="text_01" id="apply.nativehome" value="${emp.nativehome }" maxlength="20"/>
						</td>
</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">出生日期：</td>
						<td class="red_01" width="30%">
						<input name="apply.birthday" type="text" class="text_01" style="width:80px;" id="birthday" value="<fmt:formatDate value="${emp.birthday }" type="both" pattern="yyyy-MM-dd"/>" maxlength="18"/>
						</td>
						<td class="blue_01 textRight" width="20%">专业：</td>
						<td class="red_01" width="30%">
						<input name="apply.speciality" type="text" class="text_01" id="apply.speciality" value="${emp.speciality }" maxlength="16"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">文化程度：</td>
						<td class="red_01" width="30%">
							<st:st name="apply.edulevel" className="formSelect_3L" type="<%=ConstantsType.EDULEVEL %>" selected="${emp.edulevel}"/>
						</td>
						<td class="blue_01 textRight" width="20%">毕业院校：</td>
						<td class="red_01" width="30%">
						<input name="apply.gradschool" type="text" class="text_01" id="apply.gradschool" value="${emp.gradschool}" maxlength="40"/>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">联系方式</div>
			<table class="tb02" width="96%">
				<tbody><!--
					<tr>
						<td class="blue_01 textRight" width="20%">联系电话：</td>
						<td class="red_01" width="30%">
						<input name="apply.telephone" type="text" class="text_01" id="apply.telephone" value="${emp.telephone }" maxlength="15"/>
						&nbsp;<font color="#FF0000">*</font>
						</td>
						<td class="blue_01 textRight" width="20%">公司专用联系号码：</td>
						<td class="red_01" width="30%">
							<input name="apply.ofcphone" type="text" class="text_01" id="apply.ofcphone" value="${emp.ofcphone }" maxlength="64"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>//-->
					<tr>
						<td class="blue_01 textRight" width="20%">业务机号码：</td>
						<td class="red_01" width="30%">
						<input name="apply.officetel" type="text" class="text_01" id="apply.officetel" value="${emp.officetel }" maxlength="12"/>
						&nbsp;<font color="#FF0000">*</font>
						</td>
						<td class="blue_01 textRight" width="20%">个人电子信箱：</td>
						<td class="red_01" width="30%">
						<input name="apply.pvtemail" type="text" class="text_01" id="apply.pvtemail" value="${emp.pvtemail }" maxlength="128"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">公司专用电子邮箱：</td>
						<td class="red_01" width="30%" colspan="3">
						<input name="apply.ofcemail" type="text" class="text_01" id="apply.ofcemail" value="${emp.ofcemail }" maxlength="128"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">家庭地址：</td>
						<td class="red_01" width="30%" colspan="3">
						<textarea name="apply.homeaddr" class="textarea_01" id="apply.homeaddr">${emp.homeaddr }</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="listboxtitle">组织信息</div>
  			<table class="tb02" width="96%">
  				<tr>
					<td class="blue_01 textRight" width="20%">渠道编码：</td>
					<td class="red_01" width="30%">
					${_PBOSS_WEB_USER.wayid}
					</td>
					<td class="blue_01 textRight" width="20%">渠道名称：</td>
					<td class="red_01" width="30%">
					${_PBOSS_WEB_USER.channel.wayname}
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">地市公司：</td>
					<td class="red_01" width="30%">
					${fun:getBranchName(_PBOSS_WEB_USER.cityid)}
					</td>
					<td class="blue_01 textRight" width="20%">分公司：</td>
					<td class="red_01" width="30%">
					${fun:getCountyidchName(_PBOSS_WEB_USER.channel.countyid)}
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">服务销售中心编码：</td>
					<td class="red_01" width="30%" colspan="3">
					${_PBOSS_WEB_USER.channel.svccode}
					</td>
				</tr>
  			</table>
  			
			<div class="listboxtitle">组织信息</div>
  			<table class="tb02" width="96%">
  				<tr>
					<td class="blue_01 textRight" width="20%">入职时间：</td>
					<td class="red_01" width="30%">
					<input name="apply.intime" type="text" class="text_01" style="width:80px;" id="intime" value="<fmt:formatDate value="${emp.intime }" type="both" pattern="yyyy-MM-dd"/>"/>
					&nbsp;<font color="#FF0000">*</font>
					</td>
					<td class="blue_01 textRight" width="20%">劳动关系：</td>
					<td class="red_01" width="30%">
					<st:st name="apply.contacttype" className="formSelect_3L" type="<%=ConstantsType.CONTACTTYPE %>" selected="${emp.contacttype}"/>&nbsp;<font color="#FF0000">*</font>
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">用工性质：</td>
					<td class="red_01" width="30%">
					<st:st name="apply.employtype" className="formSelect_3L" type="<%=ConstantsType.EMPLOYTYPE %>" selected="${emp.employtype}"/>&nbsp;<font color="#FF0000">*</font>
					</td>
					<td class="blue_01 textRight" width="20%">用工状态：</td>
					<td class="red_01" width="30%">
					<st:st name="apply.empstatus" className="formSelect_3L" type="<%=ConstantsType.EMPSTATUS %>" selected="${emp.empstatus}"/>&nbsp;<font color="#FF0000">*</font>
					</td>
				</tr>
			</table>
		<div class="registryable">
			<div class="registrytitle">
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			验证码：
	  			<input tabindex="8" name="vaildateCode" type="text" id="vaildate_code" class="code input3"  maxlength="4" onBlur="hiddenVerify()" onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value=""/>
				<input type="submit" class="btn_blue" id="btnSubmit"  value="提交申请" />
				<INPUT TYPE="hidden" NAME="doAction" id="doAction" value="${doAction}">
				<input type="button" class="btn_blue"  onclick="location='/assistant/List.do'" value="返 回" />
	    	</div>
		</div>
			</form>
     
    <!--帮助信息开始-->
	<div class="column">
		<div class="listboxtitle">功能说明：</div>
         <div class="reminder">
           店员资料录入，店员资料通过后台审批通过后才生效。 </div>
       </div>
       <div class="column">
         <div class="listboxtitle">温馨提醒：</div>
         <div class="reminder">
         <p>1、 “<font color="#FF0000">*</font>”为必填项。</p>
         <p>2、 身份证号码为15位或18位有效号码。</p>
         </div>
       </div>
     <!--帮助信息结束-->
            </div>
    </s:if>
    <s:else>
    	暂无数据
    </s:else>
		</div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
	<div id="datepicker"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/common/rnd_code.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/basic/assistant/info.js"></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
//页面变量设置
var errMap = new Array();
<%--设置错误信息--%>
<c:set var="ferrMap" value ="${fieldErrors}"/>
<c:if test="${fn:length(ferrMap)>0}"><c:forEach items="${ferrMap}" var="fieldError" varStatus="i">
errMap[${i.index}]={feild:'${fieldError.key}',msg:'${fieldError.value}'};
</c:forEach>
</c:if>
//-->
</SCRIPT>
</html>