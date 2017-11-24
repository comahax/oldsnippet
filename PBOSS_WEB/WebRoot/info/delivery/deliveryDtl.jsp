<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共CSS文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="constants"  class="com.gmcc.pboss.common.dictionary.ConstantsType" />
<c:if test='${orderDtl.disstate eq constants.DISSTATE_WAITDIS}'><%--待配送时，显示启动配送按钮--%>
<c:set var="final" value="${constants.DISSTATE_DISING}" />
</c:if><c:if test='${orderDtl.disstate eq constants.DISSTATE_DISING}'><%--配送中时，显示完成配送按钮--%>
<c:set var="final" value="${constants.DISSTATE_DISOVER}" /></c:if>
<style type="text/css">
<!--
body {
background-image:none;
padding-left:20px;
}
-->
</style>
</head>
<body>
<form action="ajaxModify.do" method="POST" id="frmModify">
<INPUT TYPE="hidden" NAME="parameter.recids" value="${recid}">
<INPUT TYPE="hidden" NAME="parameter.disstate" value="${final}">
</form>
	<!-- 头部导航条 -->
        <div style="width:100%;text-align:left;">
<form action="ajaxComcateQuery.do" method="POST" id="frmComcatesQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
<form action="ajaxResdetsQuery.do" method="POST" id="frmResdetsQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
				<!-- 订单基本信息 Begin-->
                 <div class="listboxtitle">配送单基本信息</div>
				<table class = "tb02" width="100%">
						<tr>
						  <td class="textRight">配送单号：</td>
						  <td>${orderDtl.recid}</td>
							<td class="textRight">订单编号：</td>
					        <td>${orderDtl.orderid}</td>
						</tr>
   						<tr>
   							<td class="textRight">收货网点：</td>
							<td width="35%" >${orderDtl.datas.wayname}</td>
					      <td width="15%"  class="textRight">收货人姓名</td>
   						    <td >${orderDtl.recename}</td>
   						</tr>
   						<tr>
   						  <td class="textRight">分公司：</td>
   						  <td colspan="3">${orderDtl.datas.countyName}</td>
				  </tr>
   						<tr>
   						  <td class="textRight">收货人电话：</td>
   						  <td>${orderDtl.recetel}</td>
   						  <td  class="textRight">缴费方式：</td>
   						  <td >${orderDtl.paytypeName}</td>
				  </tr>
   						<tr>
   						  <td class="textRight">收货人地址：</td>
   						  <td colspan="3">${orderDtl.receadd}</td>
				  </tr>
   						<tr>
   						  <td class="textRight">创建时间：</td>
   						  <td>${orderDtl.createtime}</td>
   						  <td  class="textRight">要求达到时间：</td>
   						  <td >${orderDtl.arrivetime}</td>
				  </tr>
   						<tr>
   						  <td class="textRight">签收状态：</td>
   						  <td>${orderDtl.signstateName}</td>
   						  <td  class="textRight">配送商单状态：</td>
   						  <td >${orderDtl.disstateName}
						  <c:if test='${orderDtl.disstate eq constants.DISSTATE_WAITDIS}'><%--待配送时，显示启动配送按钮--%>
			<input name="btnsetDis" type="button" id="btnsetDis" value="启动配送" class="btn_blue_75" style="width:75px;" onclick="doAJAXMdf()"/>
			</c:if><c:if test='${orderDtl.disstate eq constants.DISSTATE_DISING}'><%--配送中时，显示完成配送按钮--%>
			<input name="btnsetDis" type="button" id="btnsetDis" value="完成配送" class="btn_blue_75" style="width:75px;" onclick="doAJAXMdf()" />
			</c:if></td>
				  <tr>
				  	<td class="textRight">物流单号：</td>
				  	<td colspan="3">
				  	<form action="ajaxModify.do" method="POST" id="frmModifyLogi">
					<INPUT TYPE="hidden" NAME="parameter.recid" value="${recid}"/>	
					<input type="hidden" name="parameter.modlogi" value="true"/>				
				  	<input name="parameter.logisticsno" value="${orderDtl.logisticsno}" class="text_01" id="logisticsno" style="width:200px" maxlength="32"/>
				  	(注:不超过32位的字母、数字)
				  	</form>
				  	</td>
				  </tr>
   						<tr>
   						  <td class="textRight">备注：</td>
   						  <td colspan="3">${orderDtl.memo}</td>
				  </tr>
					</table>
                 <div class="listboxtitle">订购资源明细：</div>
				<table class = "tb_comn" width="100%">
	              	<thead>
	                    <tr>
	                    	 <td>物品名称</td>
		                     <td>单位</td>
		                     <td>数量</td>
		                     <td>物品编号</td>
		                     <td>金额</td>
		                     <td>备注</td>
	                    </tr>
	                </thead>
                  	<tbody>
					<c:forEach items="${comcates}" var="dtl" varStatus="i">
                 		<tr>
	                		<td class="red_01">${dtl.comcategoryName}</td>
			                <td class="red_01">${dtl.comcateUtil} </td>
			                <td class="red_01">${dtl.orderamt}</td>
			                <td class="red_01">${dtl.odrPackageInfo}</td>
			                <td class="red_01">${dtl.totalprice}</td>
			                <td class="red_01">${dtl.ordercomtypeName}</td>
			            </tr>
					</c:forEach>
		         	</tbody>
              	</table>
				<div style="text-align:center;padding-top:5px;">
				<input type="button" id="btnSubmit" class="btn_blue_75" value="提 交" onClick="doAJAXlogisticsno()">
				<input type="button" id="btnClose" class="btn_blue_75" value="关 闭" onClick="window.parent.closePage();"></div>
		</div>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>

<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript">
// 订购资源明细列信息
var showResdetsCols = ${showResdetsCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin2 = {
	tableID:"tblResdets",
	showCols:showResdetsCols,//显示列
	//fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:5,//页内大小
	navigation:$("#resdetsNavigation"),//翻页位置 jq对象
	width:"100%",
	queryFrom: $("#frmResdetsQuery")//查询表单
};

//页面初始化完成时调用
	$(document).ready(function() {
		//$("#showResdetsTbl").queryTable(optin2);
		window.parent.plsQuery = false;
	});

	
//Ajax提交过程，msg为成功后提示的信息
var doAJAXMdf = function(msg){
	setMdfBtn(true);//屏蔽修改按钮
	//var _o_li = f_showPlan("处理中，请稍候。")
	//AJAX提交
	var fromSuccuss = function(josnObj) {
		//_o_li.close();
		if (josnObj["isSuccess"]) {
			//修改成功
			alert("处理成功!");
			//$("#disstate").val("");
			window.parent.plsQuery = true;
			window.parent.closePage();
			//doQuery();
		}else{
			alert(josnObj["message"]);
			setMdfBtn(false);//恢复屏蔽
		}
	}//fromSuccuss
	//ajaxForm 配置
	var ajaxOpn = {
		dataType:'json',
		//url:formUrl,
		success:fromSuccuss
	}
	$("#frmModify").ajaxSubmit(ajaxOpn);
	//ajax
}

var doAJAXlogisticsno = function(msg){
	setMdfBtn(true);//屏蔽修改按钮
	var fromSuccuss = function(josnObj) {
		//_o_li.close();
		if (josnObj["isSuccess"]) {
			//修改成功
			alert("处理成功!");
			//$("#disstate").val("");
			window.parent.plsQuery = true;
			//window.parent.closePage();
			//doQuery();
			setMdfBtn(false);//恢复屏蔽
		}else{
			alert(josnObj["message"]);
			setMdfBtn(false);//恢复屏蔽
		}
	}//fromSuccuss
	//ajaxForm 配置
	var ajaxOpn = {
		dataType:'json',
		//url:formUrl,
		success:fromSuccuss
	}
	$("#frmModifyLogi").ajaxSubmit(ajaxOpn);
}

//批量修改按钮的属性
var setMdfBtn = function(setBln){
	$("#btnsetDis").attr("disabled",setBln);//屏蔽按钮
	$("#btnClose").attr("disabled",setBln);//屏蔽按钮
	$("#btnSubmit").attr("disabled",setBln);
}
</script>
</html>