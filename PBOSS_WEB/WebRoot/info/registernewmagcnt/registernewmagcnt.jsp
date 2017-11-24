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
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
				<div class="listboxtitle">��ѯ����</div>
	            <table class="tb02" width="100%">
				  <tr>
				    <td class="input_label">��Ա������</td>
				    <td>
				    	<s:if test="parameter.flg=='show'">
				    		<input name="parameter.employeename" id="employeename" class="text_01" value="${parameter.employeename}" size="30"  maxlength="30" />
				    		<input type="button" value="..." onclick="showName(this);" />
				    	</s:if>
				    	<s:else>
				    		<input name="parameter.employeename" id="employeename" class="text_01" value="${parameter.employeename}" size="30"  maxlength="30" disabled="true"/>
				    	</s:else>
				    </td>
				    <td class="input_label">ҵ����룺</td>
				    <td>
				    	<input name="parameter.opnid" id="opnid" class="text_01" value="${parameter.opnid}" size="15"  maxlength="15" />
				    	<input type="button" value="..." onclick="showOpnid(this);" />
				    </td>
				 </tr>
				 <tr>
				    <td class="input_label">�Ǽ���ʼʱ�䣺</td>
				    <td>
				    	<s:textfield name="parameter.startoprtime" id="startoprtime" cssClass="text_01" >
							<s:param name="value">
								<s:date name="parameter.startoprtime" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				    <td class="input_label">�Ǽǽ���ʱ�䣺</td>
				    <td>
				    	<s:textfield name="parameter.endoprtime" id="endoprtime" cssClass="text_01" >
							<s:param name="value">
								<s:date name="parameter.endoprtime" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				 </tr>
				 <tr>
				    <td class="input_label">Ʒ�ƣ�</td>
				    <td>
				    	<s:select list="brandType" cssClass="select_3L" name="parameter.brand" id="brand"></s:select>
				    </td>
				    <td class="input_label"></td>
				    <td></td>
				 </tr>
				  <tr>
				    <td valign="top" class="input_label">&nbsp;</td>
				    <td colspan="3" align="left"><input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
				    <input name="btnExport" type="button" id="btnExport" value="����" class="btn_blue_75" />
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
                   ��ҵ�����ۻ��ܲ�ѯ�� </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <!-- <div class="reminder">
                 	 <p>1�� ����Ǽ�ʱ��Ϊ��ǰ�£���������Ϊ����1�ŵ���ǰ��ǰһ������ݡ�</p>
					 <p>2�� ����ù���ҳ��ʱϵͳĬ�ϲ�ѯʱ��Ϊ��ǰ�¡�</p> 
					 <p>3�� ��ѯʱ��������Ǽ�ʱ�䡣</p>
                  </div> -->
               </div>
          </div>
		</div>
    </div>
	<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
<!--/div-->
 <form name="doAction" method="post">
 	<input type="hidden" name="_se_employeename" id="_se_employeename">
 	<input type="hidden" name="_se_officetel" id="_se_officetel">
 	<input type="hidden" name="_se_brand" id="_se_brand">
 	<input type="hidden" name="_se_opnid" id="_se_opnid">
 	<input type="hidden" name="_se_startoprtime" id="_se_startoprtime">
 	<input type="hidden" name="_se_endoprtime" id="_se_endoprtime">
 </form>
 <iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/registernewmagcnt/registernewmagcnt.js"></script>
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