<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ�css -->
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
			<div class="listboxtitle">��ѯ����</div>
			<s:form action="/reward/bbcrewardVerifiedQuery.do" method="POST" id="frmQuery">
			<div class="listboxform">
            <table border="0" width="100%">
              <tr>
			  	<td class="input_label">�������ͣ�</td>
			  	<td colspan="5">
			  		<select id='wayType' onclick="toWayType('wayType',1,'/reward/rewardVerified.do')">
			  			<option value=1 >�������</option>
			  			<option value=2 selected>��վ����</option>
			  		</select>
			  	</td>
  			  </tr>
              <tr>
                <td class="input_label">ҵ�����ƣ�</td>
                <td><input id="opnname" class="text_01" />
                <input type="hidden" name="parameter.opnid" id="opnid"/></td>
                <td class="input_label">������ͣ�</td>
                <td align="left"><s:select list="rewareType" cssClass="select_3L" name="parameter.type" id="realrewardtype" value="9"/></td>
                <td class="input_label">�����·ݣ�</td>
                <td><select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}">
                </select></td>
              </tr>
              <tr>
                <td valign="top" class="input_label">&nbsp;</td>
                <td colspan="5" align="left" style=" padding-top:5px;">
                	<input name="btnQuery" type="button" id="btnQuery" value="�� ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
                	<input name="btnExport" type="button" id="btnExportExcel" value="�� ��" class="btn_blue_75" />&nbsp;&nbsp;
                	<input name="btnRest" type="reset" id="btnQuery" value="�� ��" class="btn_blue_75" />
                </td>
              </tr>
            </table>
			</div>
			</s:form>
          <div class="listboxlist">
          <div class="listboxtitle">��ѯ�����</div>
			<div id="showTbl"></div>
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
                 <div class="reminder">���У��ʧ����Ϣ��ѯ </div>
               </div>
            	<div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
                   <p>1��ÿ����10��14�Ž����ϸ��³��</p>
                   <p>2��ÿ�β�ѯǰӦ��ѡ�������ͺͽ���ʱ�䡣</p>
                  </div>
               </div>    
             </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	</div>
	<iframe name="content" style="display: none;"></iframe>
</body>
<%-- --%>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script> 
<script type="text/javascript" src="${ctx}/js/biz/info/reward/bbcRewardVerified.js"></script>
<SCRIPT type="text/javascript">
<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
var optin = {
	showCols:showCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:10,//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$('#btnQuery'),
	width: "100%",
	queryFrom: $("#frmQuery")//��ѯ��
};
var bbcoperation = "${jqac.BBCOPERATION}";
//-->
</SCRIPT>
</html>