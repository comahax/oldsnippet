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
	<%@ include file="/common/include/inc_managerhead.jsp"%>	
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			<c:if test='${fn:length(message)>0}'>
		<DIV><font color="red">错误提示：${message}</font></DIV></c:if>
	<s:if test="%{result.data.size > 0}">
		<s:set name="emp" value="result.data[0]" />
			<div class="listboxlist">
			<div class="listboxtitle">个人信息</div>
			<table class="tb02" width="96%">
				<tbody>		
					<tr>
						<td class="blue_01 textRight" width="20%">姓名：</td>
						<td class="red_01" width="30%">
						${emp.employeename}
						</td>
						<td class="blue_01 textRight" width="20%">性别：</td>
						<td class="red_01" width="30%">
                			<st:st className="formSelect_2L" type="<%=ConstantsType.SEX %>" selected="${emp.sex}" />
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">身份证号：</td>
						<td class="red_01" width="30%">
						${emp.cardid}
						<td class="blue_01 textRight" width="20%">籍贯：</td>
						<td class="red_01" width="30%">
						${emp.nativehome }
						</td>
</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">出生日期：</td>
						<td class="red_01" width="30%">
						<fmt:formatDate value="${emp.birthday }" type="both" pattern="yyyy-MM-dd"/>
						</td>
						<td class="blue_01 textRight" width="20%">专业：</td>
						<td class="red_01" width="30%">
						${emp.speciality }
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">文化程度：</td>
						<td class="red_01" width="30%">
							<st:st className="formSelect_3L" type="<%=ConstantsType.EDULEVEL %>" selected="${emp.edulevel}"/>
						</td>
						<td class="blue_01 textRight" width="20%">毕业院校：</td>
						<td class="red_01" width="30%">
						${emp.gradschool}
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="listboxtitle">联系方式</div>
			<table class="tb02" width="96%">
				<tbody>
					<tr>
						<td class="blue_01 textRight" width="20%">业务机号码：</td>
						<td class="red_01" width="30%">
						${emp.officetel }
						</td>
						<td class="blue_01 textRight" width="20%">个人电子信箱：</td>
						<td class="red_01" width="30%">
						${emp.pvtemail }
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">公司专用电子邮箱：</td>
						<td class="red_01" width="30%" colspan="3">
						${emp.ofcemail }
						</td>
					</tr>
					<tr>
						<td class="blue_01 textRight" width="20%">家庭地址：</td>
						<td class="red_01" width="30%" colspan="3">
						<textarea  readonly="true" class="textarea_01" >${emp.homeaddr }</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="listboxtitle">组织信息</div>
  			<table class="tb02" width="96%">
  				<tr>
					<td class="blue_01 textRight" width="20%">渠道编码：</td>
					<td class="red_01" width="30%">
					${empChannel.wayid}
					</td>
					<td class="blue_01 textRight" width="20%">渠道名称：</td>
					<td class="red_01" width="30%">
					${empChannel.wayname}
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">地市公司：</td>
					<td class="red_01" width="30%">
					${fun:getBranchName(empChannel.cityid)}
					</td>
					<td class="blue_01 textRight" width="20%">分公司：</td>
					<td class="red_01" width="30%">
					${fun:getCountyidchName(empChannel.countyid)}
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">服务销售中心编码：</td>
					<td class="red_01" width="30%" colspan="3">
					${empChannel.svccode}
					</td>
				</tr>
  			</table>
  			
			<div class="listboxtitle">用工信息</div>
  			<table class="tb02" width="96%">
  				<tr>
					<td class="blue_01 textRight" width="20%">入职时间：</td>
					<td class="red_01" width="30%">
					<fmt:formatDate value="${emp.intime }" type="both" pattern="yyyy-MM-dd"/>
					</td>
					<td class="blue_01 textRight" width="20%">劳动关系：</td>
					<td class="red_01" width="30%">
					<st:st className="formSelect_3L" type="<%=ConstantsType.CONTACTTYPE %>" selected="${emp.contacttype}"/>
					</td>
				</tr>
				<tr>
					<td class="blue_01 textRight" width="20%">用工性质：</td>
					<td class="red_01" width="30%">
					<st:st className="formSelect_3L" type="<%=ConstantsType.EMPLOYTYPE %>" selected="${emp.employtype}"/>
					</td>
					<td class="blue_01 textRight" width="20%">用工状态：</td>
					<td class="red_01" width="30%">
					<st:st className="formSelect_3L" type="<%=ConstantsType.EMPSTATUS %>" selected="${emp.empstatus}"/>
					</td>
				</tr>
			</table>
		<div class="registryable">
			<div class="registrytitle">
				<input type="button" align="middle"  class="btn_blue"  onclick="location='/managerView/assistantList.do'" value="返回店员列表" />
	    	</div>
		</div>
     
    <!--帮助信息开始-->
	<div class="column">
		<div class="listboxtitle">功能说明：</div>
         <div class="reminder">
            <p>店员详细信息展示，单击“返回”按钮，返回店员列表。</p>
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
//页面初始化完成时调用,使所有select不可编辑
$(document).ready(function() {
	$("table select").attr("disabled",true);
	showMenu("BaseInfo","assistantInfoList");
});
</SCRIPT>
</html>