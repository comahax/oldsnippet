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
			
			
			<s:form action="/reward/ajaxQuery.do" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>
			<%--<div class="listboxform"> --%>

<table class = "tb02" width="100%">
  <tr>
  	<td class="input_label">������ࣺ</td>
  	<td colspan="4">
  		<select id='wayType' onchange="changeView()">
  			<option value="1" selected >�������</option>
  			<option value="2" >B2M</option>
  			<option value="3" >��������</option>
  		</select>	
  	</td>
  </tr>
  <tr>
    <td class="input_label">ҵ�����ƣ�</td>
    <td>
    	<input id="opnname" class="text_01" />
    	<input type="hidden" name="parameter.opnid" id="opnid" />    
    </td>
    <td class="input_label">�����·ݣ�</td>
    <td>
    	<select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select>    </td>
    <td>
    	<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
    	<input name="btnQuery" type="button" id="btnExportExcel" value="����" class="btn_blue_75"  />&nbsp;&nbsp;
    	<input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" />
    	
    </td>
  </tr>
  
  <tr>
    <td valign="top" class="input_label">������ͣ�</td>
    <td colspan="4" align="left">
    	<table border="0" cellspacing="0" cellpadding="0" width="100%" class="tb02">
          <tr>
            <td width="20%" class="blue_01 textRight">�׿����
            <input type="hidden" name="parameter.rewardtype" id="realrewardtype"/></td>
            <td>
                <label><input type="checkbox" class="suit rewardtype" value="0" title="�̶����" />�̶����</label>
                <label><input type="checkbox" class="suit rewardtype" value="1" title="���ֳ��" />���ֳ��</label>
                <label><input type="checkbox" class="suit rewardtype" value="2" title="ר�Ž���" />ר�Ž���</label></td>
          </tr>
          <tr>
            <td class="blue_01 textRight"> ����ҵ����</td>
            <td>
                <label><input type="checkbox" class="service rewardtype" value="5" title="�������" />�������</label>
                <label><input type="checkbox" class="service rewardtype" value="6" title="�������"/>�������</label></td>
          </tr><%--@@������,ɾ������ҵ����		  
          <tr>
            <td class="blue_01 textRight"> ����ҵ����</td>
            <td>
                 <label><input type="checkbox" class="data rewardtype" value="3" title="�������" />�������</label>
                 <label><input type="checkbox" class="data rewardtype" value="4" title="�������" />�������</label></td>
          </tr>
		  --%>
          <tr>
            <td class="blue_01 textRight">�������</td>
            <td><label><input type="checkbox" class="other rewardtype" value="7" title="�Ǽ����" />�Ǽ����</label>
              <label><input type="checkbox" class="other rewardtype" value="8" title="��Ŀ������" />��Ŀ������</label>
              <label><input type="checkbox" class="other rewardtype" value="30" title="�������޽�" />�������޽�</label></td>
          </tr>
        </table></td>
    </tr>
</table>
			<%--</div> --%>
			</s:form>
			<div class="listboxlist">
			<div class="listboxtitle">��ѯ�����</div>
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
                   ��ѯ����Ӧ�������ϸ�� </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
                   <p>1��ÿ����10��14�Ž����ϸ��³��</p>
                   <p>2��ÿ�β�ѯ����ѡ��һ�������¶�������в�ѯ��</p>
                   <p>3������λΪ��Ԫ��</p>
                  </div>
               </div>
          </div>
		</div>
			<!--��׼���ݽ���-->
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script> 
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/reward.js"></script>
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