<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- ͷ��������
	include file="/common/include/inc_managerhead.jsp"
	inc_head.jsp
	 -->	
	<%@ include file="/common/include/inc_managerhead.jsp" %>	
	<div class="divspan">
			<!--��׼���ݿ�ʼ-->
			<!-- �����û����� -->
			<%@ include file="/common/include/inc_menu.jsp"%>
		<div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>
            <table class="tb02" width="100%">
					  <tr>
					    <td class="input_label">������룺</td>
						<td><input name="parameter.wayid" id="wayid" class="text_01"  size="11"  maxlength="11" />
						<input type="button" value="..." onclick="showSelect(this);" /></td>
						<td class="input_label">�ֹ�˾��</td>
						<td>
							<s:select list="conItem" cssClass="select_3L" name="parameter.countyid" id="countyid"/>
						</td>
					    <!-- 
					    <td><select name="cardsTotalQueryParameter.startoprtime" class="select_3L" id="selMonth" orgval="${cardsTotalQueryParameter.startoprtime}"></select></td>
					     -->
					     
					  </tr>
					  <tr>
					  	<td class="input_label">���۷������ģ�</td>
						<td>
						<input name="parameter.svccode" id="svccode" class="text_01" size="11"  />
						<input type="button" value="..." onclick="showSvccode(this);" />
						</td>
						<td class="input_label">Ʒ�ƣ�</td>
					  	<td>
					  		<s:select list="brandType" cssClass="select_3L" name="parameter.brand" id="brand" ></s:select>
					  	</td>
					  </tr>
					 	<tr>
							<td class="input_label">�Ǽ���ʼʱ�䣺</td>
							<td>
								<s:textfield name="parameter.startoprtime" cssClass="text_01" id="startoprtime">
									<s:param name="value">
										<s:date name="parameter.startoprtime" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
							<td class="input_label">�Ǽǽ���ʱ�䣺</td>
							<td>
								<s:textfield name="parameter.endoprtime" cssClass="text_01" id="endoprtime" >
									<s:param name="value">
										<s:date name="parameter.endoprtime" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
						  </tr>
						  <tr>
							<td class="input_label">������ʼʱ�䣺</td>
							<td>
								<s:textfield name="parameter.startactivedate" cssClass="text_01" id="startactivedate">
									<s:param name="value">
										<s:date name="parameter.startactivedate" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
							<td class="input_label">�������ʱ�䣺</td>
							<td>
								<s:textfield name="parameter.endactivedate" cssClass="text_01" id="endactivedate" >
									<s:param name="value">
										<s:date name="parameter.endactivedate" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
						  </tr>
									  
					  <tr>
					    <td valign="top" class="input_label">&nbsp;</td>
					    <td colspan="5" align="left">
					    <input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75"  />&nbsp;&nbsp;
					    <input name="btnExport" type="button" id="btnExportExcel" value="����" class="btn_blue_75" size="10"/>&nbsp;&nbsp;
					    <!-- <input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" />  -->
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
                 <div class="listboxtitle">����˵���� </div>
                 <div class="reminder">�׿����ۻ��ܡ� </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ� </div>
                 <!-- 
                 <div class="reminder">
                 	 <p>1�� �����ѯʱ��Ϊ��ǰ�£���������Ϊ����1�ŵ���ǰ��ǰһ������ݡ�</p>
					 <p>2�� ����ù���ҳ��ʱϵͳĬ�ϲ�ѯʱ��Ϊ��ǰ�¡�</p> 
					 <p>3�� ��ѯʱ���������ѯʱ�䡣</p>
                  </div>
                   -->
               </div>
          </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<form name="doAction" method="post">
 	<input type="hidden" name="_se_wayid" id="_se_wayid">
 	<input type="hidden" name="_se_countyid" id="_se_countyid">
 	<input type="hidden" name="_se_starlevel" id="_se_starlevel">
 	<input type="hidden" name="_se_startoprtime" id="_se_startoprtime">
 	<input type="hidden" name="_se_endoprtime" id="_se_endoprtime">
 	<input type="hidden" name="_se_startactivedate" id="_se_startactivedate">
 	<input type="hidden" name="_se_endactivedate" id="_se_endactivedate">
 	<input type="hidden" name="_se_svccode" id="_se_svccode">
 	<input type="hidden" name="_se_brand" id="_se_brand">
 </form>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/salesCardsTotal/salesCardsTotal.js"></script>
<SCRIPT type="text/javascript">
<!--
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
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT>
</html>