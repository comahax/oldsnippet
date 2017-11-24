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
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb"> <a href="#">首页</a> > <a href="#">信息查询</a> > <a href="#">酬金明细查询</a></span>
			</div>
			<div class="listboxtitle">查询条件：</div>
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
			<div class="listboxtitle">查询结果：</div>
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
						<img border="0" src="/images/frist.gif" alt="第一页" />
						</a> 
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="/images/pre.gif" alt="前一页" />
						</a>
						
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="/images/next.gif" alt="下一页" />
						</a>
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="/images/last.gif" alt="最后一页" />
						</a>
						&nbsp; 跳转至
						<input name="param.goto_page" type="text" size="2" ID="goto_page" value="1">
						页<a href="#"><img src="/images/go.gif" alt="跳转至" width="16" height="14" border="0"></a>
						</td>
					</tr>
				</table>
				
	<!--帮助信息开始-->
	<div class="column">
         <div class="listboxtitle">功能说明：</div>
         <div class="reminder">
           查询网点应付酬金明细。 </div>
       </div>
       <div class="column">
         <div class="listboxtitle">温馨提醒：</div>
         <div class="reminder">
           <p>1、 每次查询时应该至少选择酬金类型。</p>
           <p>2、 每次查询可以选择一种类型下多个酬金进行查询。 </p>
          </div>
       </div>
     <!--帮助信息结束-->
        
	<br><br><br>
	<h1>最新样式</h1>
	按钮：<br><hr><br>
	<input type="button" class="btn_blue_75" value="确 定" />
	<input type="button" class="btn_blue" value="获取随机短信密码获取随机短信密码" />
	<br>提示信息<hr><br>
	
	<b class="green"> 尊敬的客户：Success!</b><br>
	<b class="red_01"> 尊敬的客户：Fail!</b>  <br>
	<b class="blue_01"> 尊敬的客户：Warrning!</b>
	
	<br>文本输入框<hr><br>
	TYPE:TEXT:<input type="text" class="text_01"    />
	TYPE:TEXTAREA:
	<textarea name="textarea" class="textarea_01" id="textarea"></textarea>
	<br>
	Select:
	
   	<select class="select_2L">
     <option>类型</option>
   	</select>
   	<select class="select_3L">
     <option>类型类型类型</option>
   	</select>
   	<select class="select_4L">
     <option>类型类型类型型型</option>
   	</select>
	<br><br>表单<hr><br>
	<table class = "tb02" width="96%">
              <tr>
                <td class="blue_01 textRight">手机号码：</td>
                <td  class="red_01"> 13924022454 </td>
              </tr>
              <tr>
                <td class="blue_01 textRight">机主姓名：</td>
                <td  class="red_01">测试测试</td>
              </tr>
              <tr>
                <td class="blue_01 textRight">手机状态：</td>
                <td  class="red_01"><input type="radio" checked="checked" />
                  申请停机 </td>
              </tr>
              <tr>
                <td class="blue_01 textRight"><label for="label">验证码：</label>
                </td>
                <td ><input type="text" class="text_01" id="label" onFocus="shover(this,'text_01_02')" onBlur="shover(this,'text_01')"  />
                    <img src="/v2008/images/public/validateCode.gif" class="validateCode"  /></td>
              </tr>
              <tr>
                <td class="blue_01 textRight" valign="top"><label for="label2">停机原因：</label>
                </td>
                <td ><textarea name="textarea2" class="textarea_01" onFocus="shover(this,'textarea_01_02')" onBlur="shover(this,'textarea_01')" id="label2"></textarea>
                </td>
              </tr>
              <tr>
                <td></td>
                <td ><input type="checkbox" checked="checked" />
                    <span class="red_01">您是否将记录保存到邮箱</span>
                    <input type="text" class="text_01"    value="13924022454@139.com" />
                </td>
              </tr>
            </table>
            <table class = "tb02" width="96%">
              <thead>
                <tr>
                  <td class="blue_01 textRight"> 手机号码： </td>
                  <td class="red_01"> 13929416652</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">机主姓名：</td>
                  <td  class="red_01">某某某某</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">号码状态：</td>
                  <td  class="red_01">已开通</td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="blue_01 textRight">
                    <label for="psw">原密码：</label>
                  </td>
                  <td>
                    <input type="password" id="psw" class="text_01" onFocus="shover(this,'text_01_02')"  onblur="shover(this,'text_01')"  />
                  </td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">
                    <label for="psw2">新密码：</label>
                  </td>
                  <td>
                    <input type="password" id="psw2" class="text_01" onBlur="shover(this,'text_01')" onFocus="shover(this,'text_01_02')"/>
                  </td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">
                    <label for="psw3">确认新密码：</label>
                  </td>
                  <td>
                    <input type="password" id="psw3" class="text_01"  onblur="shover(this,'text_01')" onFocus="shover(this,'text_01_02')"/>
                  </td>
                </tr>
              <tr>
                <td></td>
                <td >
                  <input type="checkbox" checked="checked" />
                  <span class="red_01">您是否将记录保存到邮箱</span>
                  <input type="text" class="text_01"    value="13924022454@139.com" />
                </td>
              </tr>
              </tbody>
            </table>
            <br/>配送单明细：<br/>
            <table class = "tb02" width="96%">
            <thead>
            	<tr>
                  <td colspan="4"><b class="blue_01">配送单明细</b></td>
                </tr>
                <tr>
                  <td class="blue_01 textRight"> 配送单号： </td>
                  <td class="red_01"> GZ200808981243</td>
                  <td class="blue_01 textRight">配送单状态：</td>
                  <td class="red_01">待配送</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">开单时间：</td>
                  <td class="red_01">2009-08-18 13:15:00</td>
                  <td class="blue_01 textRight">要求送达时间：</td>
                  <td class="red_01">2009-08-20 13:15:00</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">收货单位：</td>
                  <td  class="red_01">张三通讯</td>
                  <td class="blue_01 textRight">收货人名称：</td>
                  <td  class="red_01">张三</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">收货人电话：</td>
                  <td class="red_01">15989899898</td>
                  <td class="blue_01 textRight">配送商：</td>
                  <td class="red_01">洪大快递</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">备注：</td>
                  <td class="red_01" COLSPAN=3><textarea name="textarea2" class="textarea_01" onFocus="shover(this,'textarea_01_02')" onBlur="shover(this,'textarea_01')" id="label2"></textarea></td>
                </tr>
                <!-- 订单信息1 -->
                <tr>
                  <td colspan="4"><b class="blue_01">订单信息 GZ2009081923567384</b></td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">订单号：</td>
                  <td class="red_01">GZ2009081923567384</td>
                  <td class="blue_01 textRight">订单生成时间：</td>
                  <td class="red_01">2009-08-17 13:15:00</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">订单状态：</td>
                  <td class="red_01">未关闭</td>
                  <td class="blue_01 textRight">总金额：</td>
                  <td class="red_01">200元</td>
                </tr>
                <tr>
                  <td colspan="4"><b class="blue_01">订单明细 GZ2009081923567384</b></td>
                </tr>
                <tr>
                	<td colspan="4">
		                <table class="tb_comn" width="96%">
		                  <thead>
		                    <tr>
		                      <td>资源编号</td>
		                      <td>商品名称</td>
		                      <td>批次</td>
		                      <td>包号</td>
		                      <td>单位</td>
		                      <td>单价</td>
		                      <td>批发价</td>
		                    </tr>
		                  </thead>
		                  <tbody>
		                    <tr>
		                      <td>8775</td>
		                      <td>神州行55元</td>
		                      <td>7886</td>
		                      <td>P5673</td>
		                      <td>1张</td>
		                      <td>55元</td>
		                      <td>55元</td>
		                    </tr>
		                  </tbody>
		                </table>
	                </td>
                </tr>
		        
		        <!-- 订单信息2 -->
                <tr>
                  <td colspan="4"><b class="blue_01">订单信息 GZ2009081923567323</b></td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">订单号：</td>
                  <td class="red_01">GZ2009081923567323</td>
                  <td class="blue_01 textRight">订单生成时间：</td>
                  <td class="red_01">2009-08-17 14:15:00</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">订单状态：</td>
                  <td class="red_01">未关闭</td>
                  <td class="blue_01 textRight">总金额：</td>
                  <td class="red_01">100元</td>
                </tr>
                <tr>
                  <td colspan="4"><b class="blue_01">订单明细 GZ2009081923567323</b></td>
                </tr>
                <tr>
                	<td colspan="4">
		                <table class="tb_comn" width="96%">
		                  <thead>
		                    <tr>
		                      <td>资源编号</td>
		                      <td>商品名称</td>
		                      <td>批次</td>
		                      <td>包号</td>
		                      <td>单位</td>
		                      <td>单价</td>
		                      <td>批发价</td>
		                    </tr>
		                  </thead>
		                  <tbody>
		                    <tr>
		                      <td>8775</td>
		                      <td>神州行100元</td>
		                      <td>7886</td>
		                      <td>P5673</td>
		                      <td>1张</td>
		                      <td>100元</td>
		                      <td>100元</td>
		                    </tr>
		                  </tbody>
		                </table>
	                </td>
                </tr>
		        
               	<tr>
                  <td class="blue_01 textCenter" COLSPAN=4>
                  <input type="button" class="btn_blue_75" value="打 印" />
                  <input type="button" class="btn_blue_75" value="关 闭" />
                  </td>
                </tr>
                	<!--/td-->
                <!--/tr-->
              </thead>
            </table>
            
             <br/>下载框：<br/>
             <!-- 上传时，Action中operation为UPLOAD；uploadType为配置文件中的Type属性 -->
            <form action="/fileHandle?operation=<%=FileHandleType.UPLOAD %>&uploadType=<%=UploadFileType.INDAGATE_QUESTIONNAIRE %>" 
            	  id="uploadForm" name="uploadForm" enctype="multipart/form-data"  method="post" target="hidden_frame" >
            	<input type="file" id="uploadFile" name="uploadFile" style="width:250">
            	<input type="button" class="btn_blue_75" onClick="f_submitUpload()" value='上 传' >
            	<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
            </form>
            <!-- 引入文件处理JS -->
            <script type="text/javascript" src="${ctx}/js/common/fileHandle.js" ></script>
			</div>
		</div>
	</div>
	<!-- 内容部分结束 -->
	<!--尾部-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript">

//初始化标签，设置默认被选中的标签
//@@初始化工作不应该在JS中处理
//页面初始化完成时调用
$(document).ready(function() {
	$("#tagContent2").show();
	document.getElementById("tags").getElementsByTagName("li")[1].className="selectedTag";
});

function switchTag(tagContent,obj){

	for(var i=1; i<document.getElementById("tags").getElementsByTagName("li").length; i++){
		document.getElementById("tags").getElementsByTagName("li")[i].className="normalTag";
	}
	obj.parentNode.className="selectedTag";
	
	for(var j=0; j<document.getElementById("tagContent").getElementsByTagName("div").length; j++){
		document.getElementById("tagContent").getElementsByTagName("div")[j].style.display="none";
	}
	document.getElementById(tagContent).style.display="block";
}
</script>
</html>
