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
			
			<s:form action="/lowsalescardstotaldetail/ajaxQuery.do" method="POST" id="frmQuery">
			<table class="tb02" width="100%">
            	<input type="hidden" name="parameter.branddtl" id="branddtl" value="${parameter.branddtl}">
            	<input type="hidden" name="parameter.startoprtimes" id="startoprtimes" value="${parameter.startoprtimes}"/>
            	<input type="hidden" name="parameter.endoprtimes" id="endoprtimes" value="${parameter.endoprtimes}"/>
            	<input type="hidden" name="parameter.startactivedates" id="startactivedates" value="${parameter.startactivedates}"/>
            	<input type="hidden" name="parameter.endactivedates" id="endactivedates" value="${parameter.endactivedates}"/>
            	<input type="hidden" name="parameter.officetel" id="officetel" value="${parameter.officetel}"/>
            	<input type="hidden" name="parameter.employeeid" id="employeeid" value="${parameter.employeeid}"/>            	
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
            <input type="button" class="btn_blue"  onclick="location='/lowsalescardstotal/show.do'" value="�����׿����ۻ��ܲ�ѯ" />
            <!--������Ϣ��ʼ-->
            <div class="column">
                 <div class="listboxtitle">����˵����</div>
                 <div class="reminder">
                   </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
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
<script type="text/javascript" src="${ctx}/js/biz/info/lowsalesCardsTotal/registersimList.js"></script>
<SCRIPT type="text/javascript">
//<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowStCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
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