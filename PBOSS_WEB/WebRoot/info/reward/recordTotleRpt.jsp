<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<c:set var="fmtNumber" value ="#0.00"/>
</head>
<body>
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			<s:form action="/reward/rewardTotal.do" method="POST" id="frmQuery" onsubmit="return doSubmit();">
			<div class="listboxtitle">���������Ϣ</div>
				<table class = "tb02" width="100%">
                  <tr>
                    <td class="tableTitle">������ࣺ</td>
                    <td colspan="3">
                        <select id='wayType' name='wayType'>
                            <option value="" selected >�������</option>
                            <option value="BBC" >B2M</option>
                            <option value="UNPB" >��������</option>
                        </select>  	</td>
                  </tr>
                  <tr>
                    <td class="tableTitle" width="15%">�����·ݣ�</td>
                    <td width="35%"><select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></td>
                    <td class="tableTitle" width="15%">�����Ǽ���</td>
                    <td>${logMember.channel.strStarLevel}</td>
                  </tr>
                  
                  <tr>
                    <td class="tableTitle">�������ƣ�</td>
                    <td align="left">${logMember.channel.wayname}</td>
                    <td class="tableTitle">�������룺</td>
                    <td align="left">${logMember.channel.wayid}</td>
                  </tr>
                  <tr>
                    <td valign="top" class="tableTitle">&nbsp;</td>
                    <td align="left">
                        <input name="btnQuery" type="submit" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
                        <input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" />    </td>
                    <td align="left">&nbsp;</td>
                    <td align="left">&nbsp;</td>
                  </tr>
                </table>
			</s:form>
		<s:if test="%{servResult.success}">
			<div class="listboxtitle">${showTimeName}Ӧ�������ϸ</div>
            <div class="subTitle">�����ϸ</div>
            <table class = "tb02" width="100%"><!--
                  <tr>
                    <td width="15%" class="tableTitle">�׿����</td>
                    <td width="3%" class="tableTitle">=</td>
                    <td>�̶����Ӧ�����</td>
                  </tr>//-->
			<s:if test="%{cardReward.size>0}">
                  <tr>
                  	<td>
                    <div class="divTitleName">�׿����</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${cardRewardTtl}' pattern='#0.00'/></span>Ԫ</div>
                    <!--
				<c:forEach items="${cardReward}" var="cardDtl" varStatus="i">
					<c:if test="${i.index>0}"><div class="divTitleSpan">+</div></c:if>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${cardDtl.paysum}' pattern='#0.00'/></span>Ԫ(${cardDtl.rewardtypeshortName})</div>
				</c:forEach>
                    
					<div class="divTitleSpan">+</div>
                    
					<div class="divTitleContext">���ֳ��</div>
                    <div class="divTitleSpan">+</div>
                    <div class="divTitleContext">ר�Ž���</div>//-->
                    </td>
                  </tr>
			</s:if>
			<s:if test="%{servReward.size>0}">
                  <tr>
                  	<td>
                    <div class="divTitleName">����ҵ����</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${servRewardTtl}' pattern='#0.00'/></span>Ԫ</div>
                    <!-- 
				<c:forEach items="${servReward}" var="servDtl" varStatus="i">
					<c:if test="${i.index>0}"><div class="divTitleSpan">+</div></c:if>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${servDtl.paysum}' pattern='#0.00'/></span>Ԫ(${servDtl.rewardtypeshortName})</div>
				</c:forEach>
				 -->
                    </td>
                  </tr>
			</s:if>
			<s:if test="%{dateReward.size>0}">
                  <tr>
                  	<td>
                    <div class="divTitleName">����ҵ����</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${dateRewardTtl}' pattern='#0.00'/></span>Ԫ</div>
                    <!-- 
				<c:forEach items="${dateReward}" var="dateDtl" varStatus="i">
					<c:if test="${i.index>0}"><div class="divTitleSpan">+</div></c:if>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${dateDtl.paysum}' pattern='#0.00'/></span>Ԫ(${dateDtl.rewardtypeshortName})</div>
				</c:forEach>
				 -->
                    </td>
                  </tr>
			</s:if>
			<s:if test="%{tempReward.size>0}">
				<tr><td>
				<div class="divTitleName">�������</div>
                <div class="divTitleSpan">=</div>
				<div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${tempRewardTtl}' pattern='#0.00'/></span>Ԫ</div>
				<!-- 
				<c:forEach items="${tempReward}" var="tempDtl" varStatus="i">
                  <tr>
                  	<td>
                    <div class="divTitleName">${tempDtl.rewardtypeshortName}</div>
                    <div class="divTitleSpan">=</div>
                    <div class="divTitleContext"><span class="font_orange"><fmt:formatNumber value='${tempDtl.paysum}' pattern='#0.00'/></span>Ԫ</div>
                    </td>
                  </tr>
				</c:forEach>
				 -->
				 </td></tr>
			</s:if>
          </table>
            <div class="subTitle">Ӧ�����ϼ�</div>
            <table class = "tb02" width="100%">
                  <tr>
                  	<td class="tableTitle">����Ӧ������ܺͣ�
                  	<span class="font_orange">
                  	<fmt:formatNumber value='${sumReward}' pattern='${fmtNumber}'/>
                  	</span>
                  	Ԫ
                  	</td>
                  </tr>
          </table>
	<s:if test="%{tempReward.size>0}"><c:set var="strLink" value =""/>
            <div class="subTitle">���֧��ʱ��</div>
            <table width="100%" class="tb02 tableTitle" >
		<c:forEach items="${allRewards}" var="rewardDtl" varStatus="i">
            <tr>
              <td width="20%" bgcolor="#FFFFFF" class="tableTitle">${rewardDtl.rewardtypeName}</td>
			  <%--�޸ĳɣ��޸�Ϊxx�·���xxԪ��xx�·���xxԪ��ԭ���ı����ڵ�����־�� --%>
			  <td bgcolor="#FFFFFF">
			  <c:if test="${!(rewardDtl.paymonth1 eq null) && fn:trim(rewardDtl.paymonth1) !=''}">
			  <span class="tableMark">${rewardDtl.paymonth1}</span>����<span class="tableMark">${rewardDtl.paymoney1}</span>Ԫ<c:set var="strLink" value ="��"/>
			  </c:if>
			  <c:if test="${!(rewardDtl.paymonth2 eq null) && fn:trim(rewardDtl.paymonth2) !=''}">${strLink}
			  <span class="tableMark">${rewardDtl.paymonth2}</span>����<span class="tableMark">${rewardDtl.paymoney2}</span>Ԫ<c:set var="strLink" value ="��"/>
			  </c:if>
			  <c:if test="${!(rewardDtl.paymonth3 eq null) && fn:trim(rewardDtl.paymonth3) !=''}">${strLink}
			  <span class="tableMark">${rewardDtl.paymonth3}</span>����<span class="tableMark">${rewardDtl.paymoney3}</span>Ԫ</c:if>��</td>
              </tr>
			</c:forEach><!--
				<tr>
				  <td bgcolor="#FFFFFF" class="tableTitle">�Ǽ����</td>
				  <td bgcolor="#FFFFFF">40%����<span class="tableMark">һ�ڷ�����(PAYMONTH1)</span>���ţ�30%����<span class="tableMark">���ڷ�����(PAYMONTH2)</span>���ţ�ʣ��30%����<span class="tableMark">���ڷ�����(PAYMONTH3)</span>���š�</td>
				</tr>
				//-->
          </table>  
		</s:if>
	</s:if>
	<s:else>
			${message}
	</s:else>
	<!--������Ϣ��ʼ-->
	<div class="column">
         <div class="listboxtitle">����˵����</div>
         <div class="reminder">
          �����²�����𱨱� </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
           <p>1��ÿ����10��14�Ž����ϸ��³��</p>
           <p>2���������ͣ����Բ鿴��վ�����ĳ�𱨱�</p>
           <p>3�������·ݱ�ѡ��</p>
          </div>
       </div>
     <!--������Ϣ����-->
	  </div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/total.js"></script> 
</html>