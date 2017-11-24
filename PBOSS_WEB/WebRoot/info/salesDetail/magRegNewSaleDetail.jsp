<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_managerhead.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition"> 
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/magSaleDetail/regAjax.do" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>
            <table class="tb02" width="100%">
				  <tr>
					<td class="input_label">������룺</td>
					<td>
					<s:textfield cssClass="style_input" name="parameter.wayid" id="wayid"/>
					<input type="button" class="" value="..." id="btnWaySelect" onclick="f_waySelect(this)"/>
					</td>
					<td class="input_label">��Ա������</td>
					<td>
					  <input type="hidden" name="parameter.oprcode" id="oprcode"/>
					  <s:textfield cssClass="style_input" id="employeename" disabled="true"/>
					  <input type="button" class=""  value="..." id="btnEmployeeSelect" onclick="f_employeeSelect(this)"/>
					</td>
				  </tr>
				  <tr>
					<td class="input_label">�ֹ�˾��</td>
					<!--td>${_PBOSS_WEB_USER.channel.countyid }</td-->
					<td><s:select list="cntyComd" cssClass="select_3L" name="parameter.countyid" cssStyle="width:132px" id="countyid" onchange="f_clearSvccode()" /></td>
					<td class="input_label">���۷������ģ�</td>
					<td>
						<input name="parameter.svccode" id="svccode" class="text_01" value="${parameter.svccode}" disabled="true" style="width:132px"/>
				    	<input type="button" value="..." onclick="showSvccode(this);" />
					</td>
				  </tr>
				  <tr>
					<td class="input_label">ҵ����룺</td>
					<td>
					  <s:textfield cssClass="style_input" name="parameter.opnid" id="opnid"/>
					  <input type="button" class="" value="..." id="btnOpnSelect" onclick="f_opnSelect(this)"/>
					</td>
					<td class="input_label">Ʒ�ƣ�</td>
					<td>
					  <s:select list="brandType" name="parameter.brand" id="brand"></s:select>
					</td>
				  </tr>
				  <tr>
					<td class="input_label">�Ǽ���ʼʱ�䣺</td>
					<td>
						<s:textfield name="parameter.timeFrom" cssClass="text_01" id="timeFrom">
							<s:param name="value">
								<s:date name="parameter.timeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">�Ǽǵ���ʱ�䣺</td>
					<td>
						<s:textfield name="parameter.timeTo" cssClass="text_01" id="timeTo" >
							<s:param name="value">
								<s:date name="parameter.timeTo" format="yyyy-MM-dd"/>
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
<script type="text/javascript" src="${ctx}/js/biz/info/salesDetail/magRegisternewList.js"></script>
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