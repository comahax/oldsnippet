<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
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
			
			<s:form action="/reward/ajax_cardrewdetStat.do" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>
            <table class="tb02" width="100%">
				  <tr>
					<td class="input_label">�����������룺</td>
					<td>${_PBOSS_WEB_USER.channel.wayid }</td>
					<td class="input_label">&nbsp;</td>
					<td>
					  &nbsp;
					</td>	
				  </tr>
				  <tr>
					<td class="input_label">���ʼʱ�䣺</td>
					<td>
						<s:textfield name="parameter.activeFrom" cssClass="text_01" id="activeFrom">
							<s:param name="value">
								<s:date name="parameter.activeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">�������ʱ�䣺</td>
					<td>
						<s:textfield name="parameter.activeTo" cssClass="text_01" id="activeTo" >
							<s:param name="value">
								<s:date name="parameter.activeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				  </tr>
				  <tr>
					<td class="input_label">��ֵ��ʼʱ�䣺</td>
					<td>
						<s:textfield name="parameter.rechargeFrom" cssClass="text_01" id="rechargeFrom">
							<s:param name="value">
								<s:date name="parameter.rechargeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">��ֵ����ʱ�䣺</td>
					<td>
						<s:textfield name="parameter.rechargeTo" cssClass="text_01" id="rechargeTo" >
							<s:param name="value">
								<s:date name="parameter.rechargeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
			  </tr>
			
			  <tr>
			  	<td colspan="4" align="left">
			  		<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" />&nbsp;&nbsp;
					<input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" />		
			  	</td>
			  </tr>
			</table>
			</s:form>
			<div class="listboxlist">
			<div class="listboxtitle">��ѯ���</div>
			<span id="showTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="navigation"></td>
				</tr>
			</table>
            <br>
            <!--������Ϣ��ʼ-->
            <div class="column">
                 <div class="listboxtitle">����˵����</div>
                 <div class="reminder">
                 <p>1.�Գ�ֵ���ļ������������ͳ�ơ�</p>
                   </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
                 <p>1.�����ѯ����Ӧ�ٶȹ����������ѯ��ʱ���Ȳ�Ҫ����һ���¡�</p>
                  </div>
               </div>
          </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/rewardcard/cardrewdetStat.js"></script>
<SCRIPT type="text/javascript">
//<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin = {
	showCols:showCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:10,//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//��ѯ��
};
//-->
</SCRIPT>
</html>