<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<style type="text/css">
<!--
label {
	float: left;
	width: 30%;
	text-align:left;
}
-->
</style>
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
			<s:form action="/reward/bbcrewardRecordQuery.do" method="POST" id="frmQuery"> 
			<div class="listboxform">
            
            <table class = "tb02" width="100%">
            	<tr>
				  	<td class="input_label" width="15%">������ࣺ</td>
				  	<td colspan="3">
				  		<select id='wayType' name="wayType" onchange="changeView()">
				  			<option value="1" >�������</option>
				  			<option value="2" >B2M</option>
				  			<option value="3" selected>��������</option>
				  		</select>
				  	</td>
  				</tr>
  				
              <tr>
                <td class="input_label">ҵ�����ƣ�</td>
                <td>
                	<input id="opnname" class="text_01" />
                	<input type="hidden" name="parameter.opnid" id="opnid"/>
                
                <td class="input_label" width="15%">�����·ݣ�</td>
                <td>
                	<select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select>
                </td>
              </tr>
              
              <tr>
                <td class="input_label">������ͣ�<input type="hidden" name="parameter.rewardtype" id="realrewardtype"/></td>
                <td align="left" colspan="3">
					<div style="width:100%;">
				<c:forEach items="${rewareType}" var="type" varStatus="i">
						<label><input type="checkbox" class="suit rewardtype" value="${type.key}" title="${type.value}" />${type.value}</label>
				</c:forEach>
					</div>
                </td>
              </tr>
              <tr>
                <td class="input_label"></td>
				<td align="left" colspan="3">
	                <input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
	                  <input name="btnQuery" type="button" id="btnBbcExportExcel" value="����" class="btn_blue_75"  />&nbsp;&nbsp;
	                <input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" />
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
                 <div class="reminder">�������˳����ϸ��ѯ </div>
               </div>
            	<div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
                   <p>1��ÿ����14�Ž����ϸ��³��</p>
                   <p>2������λΪ��Ԫ��</p>
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
<%-- --%>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script> 
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/bbcReward.js"></script>
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