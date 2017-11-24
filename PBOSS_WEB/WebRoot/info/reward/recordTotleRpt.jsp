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
                            <option value="" selected >社会渠道</option>
                            <option value="BBC" >B2M</option>
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
			<s:if test="%{cardReward.size>0}">
                  <tr>
                  	<td>
                    <div class="divTitleName">套卡酬金</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${cardRewardTtl}' pattern='#0.00'/></span>元</div>
                    <!--
				<c:forEach items="${cardReward}" var="cardDtl" varStatus="i">
					<c:if test="${i.index>0}"><div class="divTitleSpan">+</div></c:if>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${cardDtl.paysum}' pattern='#0.00'/></span>元(${cardDtl.rewardtypeshortName})</div>
				</c:forEach>
                    
					<div class="divTitleSpan">+</div>
                    
					<div class="divTitleContext">积分酬金</div>
                    <div class="divTitleSpan">+</div>
                    <div class="divTitleContext">专门津贴</div>//-->
                    </td>
                  </tr>
			</s:if>
			<s:if test="%{servReward.size>0}">
                  <tr>
                  	<td>
                    <div class="divTitleName">服务业务酬金</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${servRewardTtl}' pattern='#0.00'/></span>元</div>
                    <!-- 
				<c:forEach items="${servReward}" var="servDtl" varStatus="i">
					<c:if test="${i.index>0}"><div class="divTitleSpan">+</div></c:if>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${servDtl.paysum}' pattern='#0.00'/></span>元(${servDtl.rewardtypeshortName})</div>
				</c:forEach>
				 -->
                    </td>
                  </tr>
			</s:if>
			<s:if test="%{dateReward.size>0}">
                  <tr>
                  	<td>
                    <div class="divTitleName">数据业务酬金</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${dateRewardTtl}' pattern='#0.00'/></span>元</div>
                    <!-- 
				<c:forEach items="${dateReward}" var="dateDtl" varStatus="i">
					<c:if test="${i.index>0}"><div class="divTitleSpan">+</div></c:if>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${dateDtl.paysum}' pattern='#0.00'/></span>元(${dateDtl.rewardtypeshortName})</div>
				</c:forEach>
				 -->
                    </td>
                  </tr>
			</s:if>
			<s:if test="%{tempReward.size>0}">
				<tr><td>
				<div class="divTitleName">其它酬金</div>
                <div class="divTitleSpan">=</div>
				<div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${tempRewardTtl}' pattern='#0.00'/></span>元</div>
				<!-- 
				<c:forEach items="${tempReward}" var="tempDtl" varStatus="i">
                  <tr>
                  	<td>
                    <div class="divTitleName">${tempDtl.rewardtypeshortName}</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${tempDtl.paysum}' pattern='#0.00'/></span>元</div>
                    </td>
                  </tr>
				</c:forEach>
				 -->
				 </td></tr>
			</s:if>
          </table>
            <div class="subTitle">应发酬金合计</div>
            <table class = "tb02" width="100%">
                  <tr>
                  	<td class="tableTitle">以上应发金额总和：
                  	<span class="font_orange">
                  	<fmt:formatNumber value='${sumReward}' pattern='${fmtNumber}'/>
                  	</span>
                  	元
                  	</td>
                  </tr>
          </table>
	<s:if test="%{tempReward.size>0}"><c:set var="strLink" value =""/>
            <div class="subTitle">酬金支付时间</div>
            <table width="100%" class="tb02 tableTitle" >
		<c:forEach items="${allRewards}" var="rewardDtl" varStatus="i">
            <tr>
              <td width="20%" bgcolor="#FFFFFF" class="tableTitle">${rewardDtl.rewardtypeName}</td>
			  <%--修改成：修改为xx月发放xx元，xx月发放xx元，原来的备份在电子日志中 --%>
			  <td bgcolor="#FFFFFF">
			  <c:if test="${!(rewardDtl.paymonth1 eq null) && fn:trim(rewardDtl.paymonth1) !=''}">
			  <span class="tableMark">${rewardDtl.paymonth1}</span>发放<span class="tableMark">${rewardDtl.paymoney1}</span>元<c:set var="strLink" value ="，"/>
			  </c:if>
			  <c:if test="${!(rewardDtl.paymonth2 eq null) && fn:trim(rewardDtl.paymonth2) !=''}">${strLink}
			  <span class="tableMark">${rewardDtl.paymonth2}</span>发放<span class="tableMark">${rewardDtl.paymoney2}</span>元<c:set var="strLink" value ="，"/>
			  </c:if>
			  <c:if test="${!(rewardDtl.paymonth3 eq null) && fn:trim(rewardDtl.paymonth3) !=''}">${strLink}
			  <span class="tableMark">${rewardDtl.paymonth3}</span>发放<span class="tableMark">${rewardDtl.paymoney3}</span>元</c:if>。</td>
              </tr>
			</c:forEach><!--
				<tr>
				  <td bgcolor="#FFFFFF" class="tableTitle">星级酬金</td>
				  <td bgcolor="#FFFFFF">40%将于<span class="tableMark">一期发放月(PAYMONTH1)</span>发放，30%将于<span class="tableMark">二期发放月(PAYMONTH2)</span>发放，剩余30%将于<span class="tableMark">三期发放月(PAYMONTH3)</span>发放。</td>
				</tr>
				//-->
          </table>  
		</s:if>
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
           <p>2、渠道类型：可以查看网站渠道的酬金报表。</p>
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