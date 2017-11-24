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
			<s:form action="/reward/realPayTotal.do" method="POST" id="frmQuery" onsubmit="return doSubmit();">
			<div class="listboxtitle">�����������</div>
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
                    <td width="35%"><s:if test="%{!confirmAction}">
					<select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></s:if><s:else>
						${parameter.month}
					</s:else>
					</td>
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
                    <td align="left"><s:if test="%{!confirmAction}">
                        <input name="btnQuery" type="submit" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
                        <input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" /></s:if><s:else><s:if test='confirm'>
                        <input name="btnRest" type="button" id="btnConfirm" value="ȷ��" class="btn_blue_75"/></s:if><s:else>
                        <input name="none" type="button" id="none" value="ȷ��" class="btn_blue_75" disabled/></s:else>
					</s:else>
						</td>
                    <td align="left">&nbsp;</td>
                    <td align="left">&nbsp;</td>
                  </tr>
                </table>
			</s:form>
		<s:if test="%{servResult.success}">
            <div class="subTitle">��ʵ�������ϸ</div>
            <table class = "tb02 tableTitle" width="100%"><!--
                  <tr>
                    <td width="15%" class="tableTitle">�׿����</td>
                    <td width="3%" class="tableTitle">=</td>
                    <td>�̶����Ӧ�����</td>
                  </tr>//-->
		<s:if test="%{result.data.size > 0}">
				<c:set var="sumReward" value ="0"/>
				<c:forEach items="${result.data}" var="rewardTotal" varStatus="i">
                  <tr>
              <td width="25%" bgcolor="#FFFFFF" class="tableTitle">${rewardTotal.rewardtypeName}</td>
				<td bgcolor="#FFFFFF"><span class="tableMark"><fmt:formatNumber value='${rewardTotal.paymoney}' pattern='${fmtNumber}'/></span>Ԫ</td>
                  </tr>
				<c:set var="sumReward" value ="${sumReward+rewardTotal.paymoney}"/>
				</c:forEach>
			</s:if>
          </table>
            <div class="subTitle">��ʵ�����ϼ�</div>
            <table class = "tb02" width="100%">
                  <tr>
                  	<td class="tableTitle">${showTimeName}ʵ�����ϼƣ�
                  	<span class="font_orange"><fmt:formatNumber value='${sumReward}' pattern='${fmtNumber}'/></span>Ԫ</td>
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
          ������ʵ��֧����𱨱� </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
           <p>1��ÿ����10��14�Ž����ϸ��³��</p>
           <p>2�������·ݱ�ѡ��</p>
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
<SCRIPT LANGUAGE="JavaScript">
<!--
	var taskId='${taskID}'//������ϢID
//-->
</SCRIPT>
</html>