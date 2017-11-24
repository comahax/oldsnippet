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
			
			<s:form action="/salesDetail/regAjax.do" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>
            <table class="tb02" width="100%">
				  <tr>
					<td class="input_label">������룺</td>
					<td>${_PBOSS_WEB_USER.channel.wayid }</td>
					<td class="input_label">��Ա������</td>
					<c:choose>
						<c:when test="${_PBOSS_WEB_USER.isnet==role.SHOP_ASSISTANT}">
						  <td>${_PBOSS_WEB_USER.employeename }</td>
						</c:when>
						<c:otherwise>
						  <td>
						  <input type="hidden" name="oprcode" id="oprcode"/>
						  <s:textfield cssClass="style_input" id="employeename" disabled="true"/>
						  <input type="button" class=""  value="..." id="btnEmployeeSelect" onclick="f_employeeSelect(this)"/>
						  </td>
						</c:otherwise>					
					</c:choose>
				  </tr>
				  <tr>
					<td class="input_label">�ֹ�˾��</td>
					<td>${strCountyid}</td>
					<td class="input_label">���۷������ģ�</td>
					<td>${_PBOSS_WEB_USER.channel.svccode }</td>
				  </tr>
				  <tr>
					<td class="input_label">ҵ����룺</td>
					<td>
					  <s:textfield cssClass="style_input" name="opnid" id="opnid"/>
					  <input type="button" class="" value="..." id="btnOpnSelect" onclick="f_opnSelect(this)"/>
					</td>
					<td class="input_label">Ʒ�ƣ�</td>
					<td>
					  <s:select list="brandType" name="brand" id="brand"></s:select>
					</td>
				  </tr>
				  <tr>
					<td class="input_label">�Ǽ���ʼʱ�䣺</td>
					<td>
						<s:textfield name="timeFrom" cssClass="text_01" id="timeFrom">
							<s:param name="value">
								<s:date name="timeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">�Ǽǵ���ʱ�䣺</td>
					<td>
						<s:textfield name="timeTo" cssClass="text_01" id="timeTo" >
							<s:param name="value">
								<s:date name="timeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				  </tr>
			
			  <tr>
				<td valign="top" class="input_label">&nbsp;</td>
				<td colspan="5" align="left">
						<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" />&nbsp;&nbsp;
						<input name="btnExport" type="button" id="btnExportTxt" value="�����ı�" class="btn_blue_75" size="10" style="width:80px"/>&nbsp;&nbsp;
						<input name="btnExport" type="button" id="btnExportExcel" value="����Excel" class="btn_blue_75" size="10" style="width:80px"/>&nbsp;&nbsp;
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
                 <p>1.��ҵ��������ϸ��ѯ�����Ե�����ѯ�����Excel���ı��ļ��С�</p>
                   </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
                 <p>1.�Ǽ���ʼʱ��͵Ǽǽ���ʱ�����ͬʱ���ã�����ͬʱΪ�գ���ѯ���޲��ܳ���31�졣</p>
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
<script type="text/javascript" src="${ctx}/js/biz/info/salesDetail/registernewList.js"></script>
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