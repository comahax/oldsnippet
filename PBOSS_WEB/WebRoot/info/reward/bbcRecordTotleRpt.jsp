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
			<s:form action="/reward/rewardTotal.do" method="POST" id="frmQuery" onsubmit="return doSubmit();">
			<div class="listboxtitle">网点基础信息</div>
				<table class = "tb02" width="100%">
                  <tr>
                    <td class="tableTitle">酬金种类：</td>
                    <td colspan="3">
                        <select id='wayType' name='wayType'>
                            <option value="" >社会渠道</option>
                            <option value="BBC" selected >B2M</option>
                            <option value="UNPB" >创新联盟</option>
                        </select>  	</td>
                  </tr>
                  <tr>
                    <td class="tableTitle" width="15%">结算月份：</td>
                    <td width="35%"><select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></td>
                    <td class="tableTitle" width="15%">渠道星级：</td>
                    <td>${logMember.channel.strStarLevel}</td>
                  </tr>
                  
                  <tr>
                    <td class="tableTitle">渠道名称：</td>
                    <td align="left">${logMember.channel.wayname}</td>
                    <td class="tableTitle">渠道编码：</td>
                    <td align="left">${logMember.channel.wayid}</td>
                  </tr>
                  <tr>
                    <td valign="top" class="tableTitle">&nbsp;</td>
                    <td align="left">
                        <input name="btnQuery" type="submit" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
                        <input name="btnRest" type="reset" id="btnQuery" value="重置" class="btn_blue_75" />    </td>
                    <td align="left">&nbsp;</td>
                    <td align="left">&nbsp;</td>
                  </tr>
                </table>
			</s:form>
		<s:if test="%{servResult.success}">
			<div class="listboxtitle">${showTimeName}应发酬金明细</div>
            <div class="subTitle">酬金明细</div>
            <table class = "tb02" width="100%"><!--
                  <tr>
                    <td width="15%" class="tableTitle">套卡酬金</td>
                    <td width="3%" class="tableTitle">=</td>
                    <td>固定酬金应发金额</td>
                  </tr>//-->
			<s:if test="%{tempReward.size>0}">
				<c:forEach items="${tempReward}" var="tempDtl" varStatus="i">
                  <tr>
                  	<td>
                    <div class="divBBCTitleName">${tempDtl.rewardtypeName}</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${tempDtl.paysum}' pattern='#0.00'/></span>元</div>
                    </td>
                  </tr>
				</c:forEach>
			</s:if>
          </table>
            <div class="subTitle">应发酬金合计</div>
            <table class = "tb02" width="100%">
                  <tr>
                  	<td class="tableTitle">以上应发金额总和：
                  	<span class="font_orange"><fmt:formatNumber value='${sumReward}' pattern='${fmtNumber}'/>
                  	</span>元</td>
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
          网点月产生酬金报表。 </div>
       </div>
       <div class="column">
         <div class="listboxtitle">温馨提醒：</div>
         <div class="reminder">
           <p>1、每个月10到14号结算上个月酬金。</p>
           <p>2、渠道类型：可以查看社会渠道的酬金报表。</p>
           <p>3、结算月份必选。</p>
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