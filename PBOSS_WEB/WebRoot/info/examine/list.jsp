<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/examine/ajaxQuery.do" method="POST" id="frmQuery">
			<div class="listboxtitle">查询条件</div>

            <table class="tb02" width="100%">
  <tr>
    <td class="input_label">查询时间：</td>
    <td>
    <select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select>
    <input type="button" class="btn_blue_75"  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" value="查询" onClick="doQuery();" id="btnQuery"/>
    </td>
    </tr>
</table>

			</s:form>
			<span id="showRtsl" class="listboxlist" style="display:none;">
				<SPAN id="markTbl" style="margin-bottom:5px;">数据加载中...</span>
				<span id="allMsg" style="display:none;"><!--
					<table class = "tb02" width="96%" style="margin-bottom:5px;" >
						 <tr>
						  <td id="msgname" class="desc textRight" width="10%">总分</td>
						  <td id="msgValue" class="red_01"></td>
						</tr>
					</table>//-->
					<div class="listboxtitle">查询结果：</div>
				</span>
				<SPAN id="showTbl"></SPAN>
            </span>
			<br>
			<br>
			<div class="listboxlist">
				<!--帮助信息开始-->
				<div class="column">
          <div class="listboxtitle">功能说明：</div>
         <div class="reminder">
           查询网点每月考核明细。 </div>
       </div>
       			<div class="column">
          <div class="listboxtitle">温馨提醒：</div>
         <div class="reminder">
           <p>1、 每次查询时必须选择查询时间。</p>
          </div>
       </div>
     			<!--帮助信息结束-->
                </div>
		</div>
		<!--标准内容结束-->
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