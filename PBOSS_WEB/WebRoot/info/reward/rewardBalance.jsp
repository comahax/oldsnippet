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
			<div class="listboxtitle">������������������</div>
				<table class = "tb02" width="100%">
                  <tr>
                    <td class="tableTitle" width="15%">�����·ݣ�</td>
                    <td width="35%">${showTimeName}</td>
                    <td class="tableTitle" width="15%">�����Ǽ���</td>
                    <td>${logMember.channel.strStarLevel}</td>
                  </tr>
                  <tr>
                    <td class="tableTitle">�������ƣ�</td>
                    <td align="left">${logMember.channel.wayname}</td>
                    <td class="tableTitle">�������룺</td>
                    <td align="left">${logMember.channel.wayid}</td>
                  </tr>
                </table>
		<s:if test="%{servResult.success}">
			<c:set var="longVaul" value ="${servResult.retObject}"/>
            <div class="subTitle">δ֧����������ϸ</div>
			<div class="font_orange">�Ǽ�����</div>
            <table class = "tb02 tableTitle" width="100%">
                  <tr>
                    <td width="50%" class="tableTitle">${balanceTime6}+${balanceTime5}+${balanceTime4} �Ǽ��������*30%</td>
                    <td>${longVaul[0]}</td>
                  </tr>
                  <tr>
                    <td width="50%" class="tableTitle">${balanceTime3}+${balanceTime2}+${balanceTime1} �Ǽ��������*60%</td>
                    <td>${longVaul[1]}</td>
                  </tr>
          </table>
            <div class="subTitle">δ��������ϼ�</div>
            <table class = "tb02" width="100%">
                  <tr>
                  	<td class="tableTitle">����֮��<span class="font_orange"><fmt:formatNumber value='${longVaul[0]+longVaul[1]}' pattern='${fmtNumber}'/></span>Ԫ</td>
                  </tr>
          </table>
	</s:if>
	<s:else>
			${message}
	</s:else>
	<!--������Ϣ��ʼ-->
	<div class="column">
         <div class="listboxtitle">����˵����</div>
         <div class="reminder">
          ����������������� </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
           <p>1����ѯ�·ݣ�Ĭ�ϲ�ѯ��ǰ�£�����ѡ��</p>
           <p>2�����ڽ������ܶ���ڽ������ܶ</p>
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