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
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			
			<s:form action="/reward/ajaxQuery.do" method="POST" id="frmQuery">
			<div class="listboxtitle">查询条件</div>
			<%--<div class="listboxform"> --%>

<table class = "tb02" width="100%">
  <tr>
  	<td class="input_label">酬金种类：</td>
  	<td colspan="4">
  		<select id='wayType' onchange="changeView()">
  			<option value="1" selected >社会渠道</option>
  			<option value="2" >B2M</option>
  			<option value="3" >创新联盟</option>
  		</select>	
  	</td>
  </tr>
  <tr>
    <td class="input_label">业务名称：</td>
    <td>
    	<input id="opnname" class="text_01" />
    	<input type="hidden" name="parameter.opnid" id="opnid" />    
    </td>
    <td class="input_label">结算月份：</td>
    <td>
    	<select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select>    </td>
    <td>
    	<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
    	<input name="btnQuery" type="button" id="btnExportExcel" value="导出" class="btn_blue_75"  />&nbsp;&nbsp;
    	<input name="btnRest" type="reset" id="btnQuery" value="重置" class="btn_blue_75" />
    	
    </td>
  </tr>
  
  <tr>
    <td valign="top" class="input_label">酬金类型：</td>
    <td colspan="4" align="left">
    	<table border="0" cellspacing="0" cellpadding="0" width="100%" class="tb02">
          <tr>
            <td width="20%" class="blue_01 textRight">套卡酬金：
            <input type="hidden" name="parameter.rewardtype" id="realrewardtype"/></td>
            <td>
                <label><input type="checkbox" class="suit rewardtype" value="0" title="固定酬金" />固定酬金</label>
                <label><input type="checkbox" class="suit rewardtype" value="1" title="积分酬金" />积分酬金</label>
                <label><input type="checkbox" class="suit rewardtype" value="2" title="专门津贴" />专门津贴</label></td>
          </tr>
          <tr>
            <td class="blue_01 textRight"> 服务业务酬金：</td>
            <td>
                <label><input type="checkbox" class="service rewardtype" value="5" title="基本酬金" />基本酬金</label>
                <label><input type="checkbox" class="service rewardtype" value="6" title="奖励酬金"/>奖励酬金</label></td>
          </tr><%--@@新需求,删除数据业务酬金		  
          <tr>
            <td class="blue_01 textRight"> 数据业务酬金：</td>
            <td>
                 <label><input type="checkbox" class="data rewardtype" value="3" title="基本酬金" />基本酬金</label>
                 <label><input type="checkbox" class="data rewardtype" value="4" title="奖励酬金" />奖励酬金</label></td>
          </tr>
		  --%>
          <tr>
            <td class="blue_01 textRight">其他酬金：</td>
            <td><label><input type="checkbox" class="other rewardtype" value="7" title="星级酬金" />星级酬金</label>
              <label><input type="checkbox" class="other rewardtype" value="8" title="项目启动金" />项目启动金</label>
              <label><input type="checkbox" class="other rewardtype" value="30" title="合作年限奖" />合作年限奖</label></td>
          </tr>
        </table></td>
    </tr>
</table>
			<%--</div> --%>
			</s:form>
			<div class="listboxlist">
			<div class="listboxtitle">查询结果：</div>
			<span id="showTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="navigation"></td>
				</tr>
			</table>
            <br>
            <!--帮助信息开始-->
            <div class="column">
                 <div class="listboxtitle">功能说明：</div>
                 <div class="reminder">
                   查询网点应付酬金明细。 </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <div class="reminder">
                   <p>1、每个月10到14号结算上个月酬金。</p>
                   <p>2、每次查询可以选择一种类型下多个酬金进行查询。</p>
                   <p>3、酬金金额单位为：元。</p>
                  </div>
               </div>
          </div>
		</div>
			<!--标准内容结束-->
		<!--标准内容结束-->
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
// 查询显示列信息
var showCols = ${ShowCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin = {
	showCols:showCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:10,//页内大小
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT>
</html>