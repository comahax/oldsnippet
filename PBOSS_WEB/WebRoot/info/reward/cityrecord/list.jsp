<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
	<head>
		<title>�������ϸ</title>
		<!-- ������̬�ļ� -->
		<%@ include file="/common/meta_allcss.jsp"%>
	</head>

	<body>
		<!--��׼���ݿ�ʼ-->
		<div class="divspan">
				<s:form action="/reward/cityrecordAjax.do" method="POST" id="frmQuery">
					<input type="hidden" name="parameter.wayid" value="${parameter.wayid}"/>
					<input type="hidden" name="parameter.opnid2" value="${parameter.opnid2}"/>
					<input type="hidden" name="parameter.rewardtype" value="${parameter.rewardtype}"/>
					<input type="hidden" name="parameter.month" value="${parameter.month}"/>
					<input type="hidden" name="parameter.oprmonth" value="${parameter.oprmonth}"/>
					<input type="hidden" name="parameter.supportPaymonth" value="${parameter.supportPaymonth}"/>
					<input type="hidden" name="parameter.paymonth" value="${parameter.paymonth}"/>
				</s:form>
				<div class="listboxlist">
					<span id="showTbl"></span>
					<table class="page_table">
						<tr valign="middle">
							<td align="left" height="30">
								&nbsp;&nbsp;
							</td>
							<td align="right" style="font-size: 12px;" id="navigation"></td>
						</tr>
					</table>
				</div>
		</div>
	</body>
	<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js"></script>
<SCRIPT LANGUAGE="JavaScript">
	// ��ѯ��ʾ����Ϣ ��ҳ��Ҫ��Action������Action��ʵ�֣�JSONArray.fromObject(getsetCols()).toString();
	var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
	//�趨��ѯ����
	var optin = {
		showCols : showCols,//��ʾ��
		//fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
		pageSize : 10,//ҳ�ڴ�С
		//unableBtu : $('#btnQuery'),
		navigation : $("#navigation"),//��ҳλ�� jq����
		width : "100%",
		queryFrom : $("#frmQuery")
	//��ѯ��
	};
$(document).ready(function() {
	$("#showTbl").queryTable(optin);
});
	//-->
</SCRIPT>
</html>