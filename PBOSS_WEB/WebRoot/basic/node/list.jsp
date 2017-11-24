<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ taglib prefix="st" uri="/select-tag"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<form id="frmSubmit" method="POST" action="submit.do" onSubmit="return doSubmit();">
			<input type="hidden" name="parameter.employeeId" value="${_PBOSS_WEB_USER.employeeid}"/>
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			<c:if test='${fn:length(message)>0}'>
		<DIV><font color="red">错误提示：${message}</font></DIV></c:if>
			<div class="listboxlist">
			<s:if test="%{apply!=null}">
			<div class="listboxtitle">负责人信息</div>
			<table class="tb02" width="100%">
				<tbody>		
					<tr>
						<td class="blue_01 textRight" width="20%">姓名：</td>
						<td class="red_01" width="30%">
						<input name="apply.principal" type="text" class="text_01" id="apply.principal" value="${apply.principal}" maxlength="10"/>
						&nbsp;<font color="#FF0000">*</font>
						</td>
						<td class="blue_01 textRight" width="20%">移动电话：</td>
						<td class="red_01" width="30%">
						<input name="apply.principaltel" type="text" class="text_01" id="apply.principaltel" value="${apply.principaltel}" maxlength="11"/>
						&nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">固定电话：</td>
						<td class="red_01" width="30%">
						<input name="apply.principalphone" type="text" class="text_01" id="apply.principalphone" value="${apply.principalphone}" maxlength="20"/>
						</td>
						<td class="blue_01 textRight" width="20%">电子信箱：</td>
						<td class="red_01" width="30%">
						<input name="apply.principalemail" type="text" class="text_01" id="apply.principalemail" value="${apply.principalemail}" maxlength="100"/>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">渠道信息</div>
			<table class="tb02" width="100%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="20%">渠道编码：</td>
						<td class="red_01" width="30%">${apply.wayid}</td>
						<td class="blue_01 textRight" width="20%">渠道名称：</td>
						<td class="red_01" width="30%">
							<input name="apply.wayname" type="text" class="text_01" id="apply.wayname" value="${apply.wayname}" maxlength="100"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">星级：</td>
						<td class="red_01" width="30%">${temWay.strStarlevel}<INPUT TYPE="hidden" NAME="temWay.starlevel" value="${temWay.starlevel}"/></td>
						<!-- 
						<td class="blue_01 textRight" width="20%">所在服务厅：</td>
						<td class="red_01" width="30%"></td>
						 -->
						 <td class="blue_01 textRight" width="20%">连锁总店编码：</td>
						 <td class="red_01" width="30%">${temWay.chainhead}<INPUT TYPE="hidden" NAME="temWay.chainhead" value="${temWay.chainhead}"/></td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">所属地市：</td>
						<td class="red_01" width="30%">${fun:getBranchName(apply.cityid)}</td>
						<td class="blue_01 textRight" width="20%">连锁性质：</td>
						<td class="red_01" width="30%">${fun:cateToStr(temWay.catetype)}<INPUT TYPE="hidden" NAME="temWay.catetype" value="${temWay.catetype}"/></td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">服务销售中心编码：</td>
						<td class="red_01" width="30%">${temWay.svccode}<INPUT TYPE="hidden" NAME="temWay.svccode" value="${temWay.svccode}"/></td>
						<td class="blue_01 textRight" width="20%">业态类型：</td>
						<td class="red_01" width="30%">${fun:formateToStr(temWay.formtype)}<INPUT TYPE="hidden" NAME="temWay.formtype" value="${temWay.formtype}"/></td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">详细地址：</td>
						<td class="red_01" width="30%" colspan="3">
						<textarea name="apply.address" class="textarea_01" id="apply.address">${apply.address}</textarea>
&nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">送货信息</div>
			<table class="tb02" width="100%">
				<tbody>	
					<tr>
						<td class="blue_01 textRight" width="20%">收货联系人：</td>
						<td class="red_01" width="80%">
							<input name="apply.recpers" type="text" class="text_01" id="apply.recpers" value="${apply.recpers}" maxlength="50"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">收货联系号码：</td>
						<td class="red_01" width="80%">
							<input name="apply.recconntel" type="text" class="text_01" id="apply.recconntel" value="${apply.recconntel}" maxlength="20"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">收货人证件号：</td>
						<td class="red_01" width="80%">
							<input name="apply.reccertno" type="text" class="text_01" id="apply.reccertno" value="${apply.reccertno}" maxlength="50"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">送货地址：</td>
						<td class="red_01" width="80%">
						<textarea name="apply.sendaddr" class="textarea_01" id="apply.sendaddr">${apply.sendaddr}</textarea>
&nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
				</tbody>
			</table>

			<div class="listboxtitle">账户信息</div>
			<table class="tb02" width="100%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="22%">开户人身份证号码：</td>
						<td class="red_01" width="80%">
							<input name="apply.acctfid" type="text" class="text_01" id="apply.acctfid" value="${apply.acctfid}" maxlength="18"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>	
					<tr>
						<td class="blue_01 textRight" width="22%">酬金支付帐号名称：</td>
						<td class="red_01" width="80%">
							<input name="apply.acctname" type="text" class="text_01" id="apply.acctname" value="${apply.acctname}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>	
					<tr>
						<td class="blue_01 textRight" width="22%">酬金支付开户银行：</td>
						<td class="red_01" width="80%">
							<input name="apply.bankname" type="text" class="text_01" id="apply.bankname" value="${apply.bankname}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">酬金支付银行账号：</td>
						<td class="red_01" width="80%">
							<input name="apply.acctno" type="text" class="text_01" id="apply.acctno" value="${apply.acctno}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">卡类购销划扣帐号名称：</td>
						<td class="red_01" width="80%">
							<input name="apply.deacctname" type="text" class="text_01" id="apply.deacctname" value="${apply.deacctname}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">卡类购销划扣开户银行：</td>
						<td class="red_01" width="80%">
							<input name="apply.debankname" type="text" class="text_01" id="apply.debankname" value="${apply.debankname}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">卡类购销划扣银行账号：</td>
						<td class="red_01" width="80%">
							<input name="apply.deacctno" type="text" class="text_01" id="apply.deacctno" value="${apply.deacctno}" maxlength="80"/>
						  &nbsp;<font color="#FF0000">*</font>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">卡类购销划扣银行标识：</td>
						<td class="red_01" width="80%">
							<input id="bankname" class="text_01" value="${apply.debankidName}"/>
							<input type="hidden" name="apply.debankid" id="debankid" value="${apply.debankid}"/>
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">卡类购销划扣银行状态：</td>
						<td class="red_01" width="80%">
							<st:st name="destate" className="formSelect_3L" type="<%=ConstantsType.VALIDFLAG %>" selected="${destate}"/>
						</td>
					</tr>
				</tbody>
			</table>
            <div class="registryable">
                <div class="registrytitle">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                验证码：
                    <input tabindex="8" name="vaildateCode" type="text" id="vaildate_code" class="input3"  maxlength="4" onBlur="hiddenVerify()" 
                    onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value=""/>
                    <input type="button" class="btn_blue"  onclick="clickSubmit();" value="提交修改申请" />
                </div>
            </div>
            </div>
            </s:if>
			</form>
    <!--帮助信息开始-->
	<div class="column">
         <div class="listboxtitle">功能说明：</div>
         <div class="reminder">
           查询网点基本资料，并对有误项可以提出修改申请。 </div>
       </div>
       <div class="column">
         <div class="listboxtitle">温馨提醒：</div>
         <div class="reminder">
         <p>1、 修改时，“<font color="#FF0000">*</font>”为必填项。</p>
         <p>2、 身份证号码为15位或18位有效号码。</p>
         </div>
       </div>
     <!--帮助信息结束-->
           
           </div>
		</div>
			<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/common/rnd_code.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/basic/node/list.js"></script> 

<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script> 
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

var jaacDBBank = "${jqac.DBBank}";
//-->
</SCRIPT>
</html>