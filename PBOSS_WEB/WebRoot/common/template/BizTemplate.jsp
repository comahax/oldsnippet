<%@ page contentType="text/html;charset=GBK"%>
<%@page import="com.gmcc.pboss.common.file.dictionary.*"%>
<%@ include file="/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- 公共CSS文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!--头部-->
	<%@ include file="/common/include/inc_head.jsp"%>
	<!--头部结束-->
	<!--内容开始 -->
	<div class="divspan">
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span>
				<span class="font_breadcrumb"> 
					<a href="#">首页</a> > <a href="#">信息查询</a> > <a href="#">酬金明细查询</a>
				</span>
			</div>
			<div class="listboxtitle">查询条件（在这里添加查询条件）</div>
			<div class="listboxform">
				<table border="0" width="100%">
				  <tr>
					<td class="input_label">登记时间：</td>
					<td><select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></td>
					<td class="input_label">套卡号码：</td>
					<td><input name="parameter.mobile" id="mobile" class="text_01" size="11" maxlength="11" /></td>
					</tr>
				  <tr>
					<td valign="top" class="input_label">&nbsp;</td>
					<td colspan="3" align="left"><input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" />&nbsp;&nbsp;<input name="btnRest" type="reset" id="btnQuery" value="重置" class="btn_blue_75" /></td>
				  </tr>
				</table>
			</div>
			
			<div class="listboxlist">
			<div class="listboxtitle">查询结果（在这里显示查询结果）</div>
			<table class="tb_comn" width="100%">
                  <thead>
                    <tr>
                      <td>表头一</td>
                      <td>表头二</td>
                      <td>表头三</td>
                      <td>表头四</td>
                      <td>表头五</td>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>GPRS</td>
                      <td>彩铃</td>
                      <td>短信服务</td>
                      <td>省际漫游（限国内）</td>
                      <td>主叫显示</td>
                    </tr>
                    <tr>
                      <td>GPRS</td>
                      <td>彩铃</td>
                      <td>短信服务</td>
                      <td>省际漫游（限国内）</td>
                      <td>主叫显示</td>
                    </tr>
                  </tbody>
                </table>
				<table width="96%">
					<tr valign=middle>
						<td align=left height=30>&nbsp;&nbsp;</td>
						<td align=right style="font-size:12px;">
						总计<font color="red">1</font>页&nbsp;
						当前第<font color="red">1</font>页
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0" src="${ctx}/images/frist.gif" alt="第一页" />
						</a> 
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="${ctx}/images/pre.gif" alt="前一页" />
						</a>
						
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="${ctx}/images/next.gif" alt="下一页" />
						</a>
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="${ctx}/images/last.gif" alt="最后一页" />
						</a>
						&nbsp; 跳转至
						<input name="param.goto_page" type="text" size="2" ID="goto_page" value="1">
						页<a href="#"><img src="${ctx}/images/go.gif" alt="跳转至" width="16" height="14" border="0"></a>
						</td>
					</tr>
				</table>
				
	<!--帮助信息开始-->
	<div class="column">
         <div class="listboxtitle">功能说明：（在这里添加功能说明）</div>
         <div class="reminder">
           查询网点应付酬金明细。 </div>
       </div>
       <div class="column">
         <div class="listboxtitle">温馨提醒：（在这里添加温馨提醒）</div>
         <div class="reminder">
           <p>1、 每次查询时应该至少选择酬金类型。</p>
           <p>2、 每次查询可以选择一种类型下多个酬金进行查询。 </p>
          </div>
       </div>
     <!--帮助信息结束-->
        
	</div>
		</div>
	</div>
	<!-- 内容部分结束 -->
	<!--尾部-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
