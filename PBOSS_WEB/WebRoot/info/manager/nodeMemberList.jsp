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
			
			<s:form action="/managerView/Ajax_nodeMemberList.do" method="POST" id="frmQuery">	
 			<input type="hidden" name="wayid" value="${wayid }" id="wayid">
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
            
            <div class="registryable">
			<div class="registrytitle">
				<input type="button" align="middle"  class="btn_blue"  onclick="location='/managerView/nodeList.do'" value="���������б�" />
	    	</div>
			</div>
            <!--������Ϣ��ʼ-->
            <div class="column">
                 <div class="listboxtitle">����˵����</div>
                 <div class="reminder">
                 	 <p>�����Ա��Ϣչʾ��</p>
                 </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
                 <p>������Ϣ������ѯ����֧���޸ġ�</p>
                 </div>
               </div>
          </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<!-- 
<form name="doLoad" action="/assistant/Load.do" method="post">
	<input type="hidden" name="officeTel" id="load_officeTel">
</form>
<form name="doQuit" action="/assistant/Quit.do" method="post">
	<input type="hidden" name="officeTel" id="load_officeTel">
</form>
 -->
 <!-- ��ʱ����Ҫ��ѯ��ϸ��Ա��Ϣ 
 <form name="doAction" method="post">
 	<input type="hidden" name="employeeid" id="employeeidid">
 </form>
 -->
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script> 
<script type="text/javascript" src="${ctx}/js/info/manager/assistantList.js"></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
	// ��ѯ��ʾ����Ϣ ��ҳ��Ҫ��Action������Action��ʵ�֣�JSONArray.fromObject(getsetCols()).toString();
	var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
	//�趨��ѯ����
	var optin = {
		showCols:showCols,//��ʾ��
		fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
		pageSize:10,//ҳ�ڴ�С
		unableBtu:$('#btnQuery'),
		navigation:$("#navigation"),//��ҳλ�� jq����
		width:"100%",
		queryFrom: $("#frmQuery")//��ѯ��
	};
//-->
</SCRIPT>
</html>