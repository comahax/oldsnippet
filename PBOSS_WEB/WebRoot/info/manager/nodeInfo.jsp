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
	<%@ include file="/common/include/inc_managerhead.jsp"%>
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			<div class="listboxlist">
			<s:if test="%{nodeDetail!=null}"> 
			<div class="listboxtitle">负责人信息</div>
			<table class="tb02" width="100%">
				<tbody>		
					<tr>
						<td class="blue_01 textRight" width="20%">姓名：</td>
						<td class="red_01" width="30%">
						${nodeDetail.contact.principal }
						</td>
						<td class="blue_01 textRight" width="20%">移动电话：</td>
						<td class="red_01" width="30%">
						${nodeDetail.contact.principaltel }
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">固定电话：</td>
						<td class="red_01" width="30%">
						${nodeDetail.contact.principalphone }
						</td>
						<td class="blue_01 textRight" width="20%">电子信箱：</td>
						<td class="red_01" width="30%">
						${nodeDetail.contact.principalemail }
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">渠道信息</div>
			<table class="tb02" width="100%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="20%">渠道编码：</td>
						<td class="red_01" width="30%">${nodeDetail.way.wayid}</td>
						<td class="blue_01 textRight" width="20%">渠道名称：</td>
						<td class="red_01" width="30%">
							${nodeDetail.way.wayname}
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">星级：</td>
						<td class="red_01" width="30%">${fun:getStarlevelName(nodeDetail.way.starlevel)}
						</td>
						<!-- 
						<td class="blue_01 textRight" width="20%">所在服务厅：</td>
						<td class="red_01" width="30%"></td>
						 -->
						 <td class="blue_01 textRight" width="20%">连锁总店编码：</td>
						 <td class="red_01" width="30%">${nodeDetail.way.chainhead}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">所属地市：</td>
						<td class="red_01" width="30%">${fun:getBranchName(nodeDetail.way.cityid)}</td>
						<td class="blue_01 textRight" width="20%">连锁性质：</td>
						<td class="red_01" width="30%">${fun:cateToStr(nodeDetail.way.catetype)}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">服务销售中心编码：</td>
						<td class="red_01" width="30%">${nodeDetail.way.svccode}</td>
						<td class="blue_01 textRight" width="20%">业态类型：</td>
						<td class="red_01" width="30%">${fun:formateToStr(nodeDetail.way.formtype)}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">详细地址：</td>
						<td class="red_01" width="30%" colspan="3">
						<textarea readonly="true" class="textarea_01">${nodeDetail.way.address}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">送货信息</div>
			<table class="tb02" width="100%">
				<tbody>	
					<tr>
						<td class="blue_01 textRight" width="20%">收货联系人：</td>
						<td class="red_01" width="80%">${nodeDetail.cooperator.recpers}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">收货联系号码：</td>
						<td class="red_01" width="80%">${nodeDetail.cooperator.recconntel}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">收货人证件号：</td>
						<td class="red_01" width="80%">${nodeDetail.cooperator.reccertno}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">送货地址：</td>
						<td class="red_01" width="80%">
						<textarea readonly="true" class="textarea_01" >${nodeDetail.cooperator.sendaddr}</textarea>
						</td>
					</tr>
				</tbody>
			</table>

			<div class="listboxtitle">账户信息</div>
			<table class="tb02" width="100%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="22%">开户人身份证号码：</td>
						<td class="red_01" width="80%">${nodeDetail.account.acctfid}</td>
					</tr>	
					<tr>
						<td class="blue_01 textRight" width="22%">酬金支付帐号名称：</td>
						<td class="red_01" width="80%">${nodeDetail.account.acctname}</td>
					</tr>	
					<tr>
						<td class="blue_01 textRight" width="22%">酬金支付开户银行：</td>
						<td class="red_01" width="80%">${nodeDetail.account.bankname}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">酬金支付银行账号：</td>
						<td class="red_01" width="80%">${nodeDetail.account.acctno}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">卡类购销划扣帐号名称：</td>
						<td class="red_01" width="80%">${nodeDetail.account.deacctname}
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">卡类购销划扣开户银行：</td>
						<td class="red_01" width="80%">${nodeDetail.account.debankname}</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="22%">卡类购销划扣银行账号：</td>
						<td class="red_01" width="80%">${nodeDetail.account.deacctno}</td>
					</tr>
				</tbody>
			</table>
            </s:if>
            <s:else>
            </s:else>
            </div>
           
            <div class="registryable">
                <div class="registrytitle">
                	<input type="button" class="btn_blue"  onclick="location='/managerView/nodeList.do'" value="返回网点列表" />
                </div>
            </div>
    <!--帮助信息开始-->
	<div class="column">
         <div class="listboxtitle">功能说明：</div>
         <div class="reminder">
           	<p>查询网点基本资料。</p>
         </div>
       </div>
       <div class="column">
         <div class="listboxtitle">温馨提醒：</div>
         <div class="reminder">
         <p>所有信息仅供查询，不支持修改。</p>
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
//页面初始化完成时调用,使所有select不可编辑
$(document).ready(function() {
	$("table select").attr("disabled",true);
	showMenu("BaseInfo","nodeInfoList");
});
</SCRIPT>
</html>