<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_missionerhead.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/missioner/unvrcfaildayAjax.do" method="POST" id="frmQuery">
				<div class="listboxtitle">��ѯ����</div>
            	<table class="tb02" width="100%">
            	
            	<tr>
					<td class="input_label">���������̱��룺</td>
					<td>
						<s:textfield cssClass="style_input" name="parameter.wayid" id="wayid"/>
					</td>
					<td class="input_label">�������������ƣ�</td>
					<td>
						<s:textfield cssClass="style_input" name="parameter.wayname" id="wayname"/>
					</td>
				</tr>
				
				<tr>
					<td class="input_label">ҵ����룺</td>
					<td>
						<s:textfield cssClass="style_input" name="parameter.opnid" id="opnid"/>
					</td>
					<td class="input_label">ҵ�����ƣ�</td>
					<td>
						<s:textfield cssClass="style_input" name="parameter.opnname" id="opnname"/>
					</td>
				</tr>
				
				<tr>
					<td class="input_label">ҵ����ʱ��>=��</td>
					<td>
						<s:textfield name="parameter.oprtimeFrom" cssClass="text_01" id="oprtimeFrom">
							<s:param name="value">
								<s:date name="parameter.oprtimeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">ҵ����ʱ��<=��</td>
					<td>
						<s:textfield name="parameter.oprtimeTo" cssClass="text_01" id="oprtimeTo" >
							<s:param name="value">
								<s:date name="parameter.oprtimeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				  </tr>
            		
            	<tr>
            		<td>&nbsp;</td>
				 	<td colspan="3"  align="left">
				 		<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" />&nbsp;&nbsp;
						<input name="btnRest" type="reset" id="btnRest" value="����" class="btn_blue_75" />
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
			</div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/missioner/recommend/unvrcfailday.js"></script>
<SCRIPT type="text/javascript">
//<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin = {
	showCols:showCols,//��ʾ��
	//fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:10,//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//��ѯ��
};
//-->
</SCRIPT>
</html>