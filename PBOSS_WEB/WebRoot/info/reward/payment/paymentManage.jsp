<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<title>酬金一体化管理</title>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_gdhead.jsp"%>
	<!--标准内容开始-->
	<div class="divspan">
		<!-- 左则功能区-->
		<%@ include file="/common/include/inc_citymenu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
           
			<form action="/gdView/paymentManageAjax.do" method="POST" id="frmQuery"> 
			  <div class="listboxtitle">查询条件</div>
			  <input type="hidden" name="_switchflag" value="<s:property value="#request.switchflag" />"/>
			  <table class="tb02" width="100%">
			      <tr>
					<td class="input_label" align="right">地市：</td>
					<td><s:select list="cityMap" name="cityid" id="cityid"/></td>
					<td class="input_label" align="right">业务类型：</td>
					<td><s:select list="optypeMap" name="optype" id="optype"/></td>
				  </tr>
				  <tr>
					<td class="input_label" align="right">对公/对私：</td>
					<td>
					  <select id="pubpri" name="pubpri">
                         <option VALUE="" selected="selected"></option>
                         <option VALUE="对私">对私</option>
                         <option VALUE="对公">对公</option>
                      </select>
					</td>
					<td class="input_label" align="right">审核标识：</td>
					<td>
					  <select id="checkedflag" name="checkedflag">
					     <option VALUE="" selected="selected"></option>
                         <option VALUE="ischecked">已审核</option>
                         <option VALUE="notchecked">未审核</option>
                      </select>
					</td>
				  </tr>
				  
				  <tr>
					<td class="input_label" align="right">收款单位：</td>
					<td>
					  <s:textfield cssClass="style_input" name="payee" id="payee"/>
					  <input type="button" class="" value="..." id="btnPayeeSelect" onclick="f_payeeSelect(this)"/>
					</td>
					<td class="input_label" align="right">渠道编码：</td>
					<td>
					  <s:textfield cssClass="style_input" name="wayid" id="wayid"/>
					  <input type="button" class="" value="..." id="btnWayidSelect" onclick="f_wayidSelect(this)"/>
					</td>
				  </tr>
				  
				  <tr>
					<td class="input_label" align="right">酬金大类：</td>
					<td>
					   <s:textfield cssClass="style_input" name="ltype" id="ltype"/>
					  <input type="button" class="" value="..." id="btnLtypeSelect" onclick="f_ltypeSelect(this)"/>
					</td>
					<td class="input_label" align="right">酬金小类：</td>
					<td>
					  <s:textfield cssClass="style_input" name="stype" id="stype"/>
					  <input type="button" class="" value="..." id="btnStypeSelect" onclick="f_stypeSelect(this)"/>
					</td>
				  </tr>
				  
				  <tr>
					<td class="input_label" align="right">付款月份：</td>
					<td><select name="paymonth" class="select_3L" id="paymonth" orgval="${rewardmonth}"></select></td>
					<td class="input_label" align="right">批次：</td>
					<td>
					  <s:textfield cssClass="style_input" name="batch" id="batch"/>
					</td>
				  </tr>
			  <tr>
				<td class="input_label">&nbsp;</td>
				<td colspan="2" align="center">
				    <input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnCheck" type="button" id="btnCheck" value="审核" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnBatchCheck" type="button" id="btnBatchCheck" value="批量审核" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnRollback" type="button" id="btnRollback" value="回退" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnBatchRollback" type="button" id="btnBatchRollback" value="批量回退" class="btn_blue_75" >
				</td>
				<td class="input_label">&nbsp;</td>
			  </tr>
			</table>
			</form>
			
            <!--帮助信息开始-->
            <div class="listboxlist">
			    <div class="listboxtitle">查询结果</div>
			    <span id="showTbl"></span>
			    <table class="page_table">
				    <tr valign="middle">
					    <td align="left" height="30">&nbsp;&nbsp;</td>
					    <td align="right" style="font-size:12px;" id="navigation"></td>
				    </tr>
			    </table>
			</div>    
            <!--帮助信息结束-->

	    </div>
	
	<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/payment/paymentManage.js"></script> 
<SCRIPT type="text/javascript">
<!--
// 查询显示列信息
var showCols = ${ShowCols};//取后台列设置类数组，对应如下 
// 业务类型、 酬金小类、 收款单位、 银行名称 、开户行 、银行账号、 对应报账单号 、分公司、
// 付款月份 、实发金额 、批次、 对公对私 、对私酬金代扣代缴税率、扣减金额
// 渠道编码 、上传工号、 审核标识

//表格配置数组
var optin = {
	showCols:showCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:10,//页内大小
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$("#btnQuery"),
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};
var jaacOPERATION = "${jqac.OPERATION}";

var switchflag = document.getElementById("_switchflag").value;
// 未开启审核标识，则按钮除查询外均置为灰色
if(switchflag=="0"){
	setBtnDisabled("btnCheck",true);
	setBtnDisabled("btnBatchCheck",true);
	setBtnDisabled("btnRollback",true);
	setBtnDisabled("btnBatchRollback",true);
}
//-->
</SCRIPT> 

</html>