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
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/examine/ajaxQuery.do" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>

            <table class="tb02" width="100%">
  <tr>
    <td class="input_label">��ѯʱ�䣺</td>
    <td>
    <select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select>
    <input type="button" class="btn_blue_75"  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" value="��ѯ" onClick="doQuery();" id="btnQuery"/>
    </td>
    </tr>
</table>

			</s:form>
			<span id="showRtsl" class="listboxlist" style="display:none;">
				<SPAN id="markTbl" style="margin-bottom:5px;">���ݼ�����...</span>
				<span id="allMsg" style="display:none;"><!--
					<table class = "tb02" width="96%" style="margin-bottom:5px;" >
						 <tr>
						  <td id="msgname" class="desc textRight" width="10%">�ܷ�</td>
						  <td id="msgValue" class="red_01"></td>
						</tr>
					</table>//-->
					<div class="listboxtitle">��ѯ�����</div>
				</span>
				<SPAN id="showTbl"></SPAN>
            </span>
			<br>
			<br>
			<div class="listboxlist">
				<!--������Ϣ��ʼ-->
				<div class="column">
          <div class="listboxtitle">����˵����</div>
         <div class="reminder">
           ��ѯ����ÿ�¿�����ϸ�� </div>
       </div>
       			<div class="column">
          <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
           <p>1�� ÿ�β�ѯʱ����ѡ���ѯʱ�䡣</p>
          </div>
       </div>
     			<!--������Ϣ����-->
                </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
    </div>
	<table class="tb_comn" width="100%" id="datas" style="display:none;" >
		 <tr>
		  <td id="exmnname" class="desc textRight" width="10%"></td>
		  <td id="exmnnameValue" class="red_01" colspan="3" width="40%"></td>
		  <td id="exmnmark" class="desc textRight" width="10%"></td>
		  <td id="exmnmarkValue" class="red_01" colspan="3"></td>
		</tr>
		 <tr id="context" style="display:none;">
		  <td id="showName1" class="blue_01 desc textRight" width="10%"></td>
		  <td id="showValue1" class="red_01" width="15%"></td>
		  <td id="showName2" class="blue_01 desc textRight" width="10%"></td>
		  <td id="showValue2" class="red_01" width="15%"></td>
		  <td id="showName3" class="blue_01 desc textRight" width="10%"></td>
		  <td id="showValue3" class="red_01" width="15%"></td>
		  <td id="showName4" class="blue_01 desc textRight" width="10%"></td>
		  <td id="showValue4" class="red_01"></td>
		</tr>
	</table>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/examine/list-min.js"></script>
</html>