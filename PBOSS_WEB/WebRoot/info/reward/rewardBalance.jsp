<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<c:set var="fmtNumber" value ="#0.00"/>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			<div class="listboxtitle">社会渠道网点基础资料</div>
				<table class = "tb02" width="100%">
                  <tr>
                    <td class="tableTitle" width="15%">结算月份：</td>
                    <td width="35%">${showTimeName}</td>
                    <td class="tableTitle" width="15%">渠道星级：</td>
                    <td>${logMember.channel.strStarLevel}</td>
                  </tr>
                  <tr>
                    <td class="tableTitle">渠道名称：</td>
                    <td align="left">${logMember.channel.wayname}</td>
                    <td class="tableTitle">渠道编码：</td>
                    <td align="left">${logMember.channel.wayid}</td>
                  </tr>
                </table>
		<s:if test="%{servResult.success}">
			<c:set var="longVaul" value ="${servResult.retObject}"/>
            <div class="subTitle">未支付酬金余额明细</div>
			<div class="font_orange">星级奖励</div>
            <table class = "tb02 tableTitle" width="100%">
                  <tr>
                    <td width="50%" class="tableTitle">${balanceTime6}+${balanceTime5}+${balanceTime4} 星级奖励酬金*30%</td>
                    <td>${longVaul[0]}</td>
                  </tr>
                  <tr>
                    <td width="50%" class="tableTitle">${balanceTime3}+${balanceTime2}+${balanceTime1} 星级奖励酬金*60%</td>
                    <td>${longVaul[1]}</td>
                  </tr>
          </table>
            <div class="subTitle">未发酬金余额合计</div>
            <table class = "tb02" width="100%">
                  <tr>
                  	<td class="tableTitle">以上之和<span class="font_orange"><fmt:formatNumber value='${longVaul[0]+longVaul[1]}' pattern='${fmtNumber}'/></span>元</td>
                  </tr>
          </table>
	</s:if>
	<s:else>
			${message}
	</s:else>
	<!--帮助信息开始-->
	<div class="column">
         <div class="listboxtitle">功能说明：</div>
         <div class="reminder">
          社会渠道网点酬金池余额 </div>
       </div>
       <div class="column">
         <div class="listboxtitle">温馨提醒：</div>
         <div class="reminder">
           <p>1、查询月份：默认查询当前月，不能选择。</p>
           <p>2、二期结算金额总额，三期结算金额总额。</p>
          </div>
       </div>
     <!--帮助信息结束-->
	  </div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/total.js"></script> 
</html>