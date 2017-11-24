<%@ page contentType="text/html;charset=GBK"%>
<%@include file="/common/jspHead.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
	<%@ include file="/common/meta_allcss.jsp"%>
	</head>
	<body>
      <div id='main'>
		<input name="btnBoxTest" type="button" id="btnBoxTest" value="普通模式窗口（内嵌DIV）" />
		<FORM METHOD=POST ACTION="submit.jsp" id="frmTest" name="frmTest">
			<INPUT type="text" name="txtTest" id="txtTest" value="ABC">
			<input name="btnBoxTest" type="submit" id="btnIfmTest" value="提交表单" />
		</FORM>
		<input name="btnAlertDlg" type="button" id="btnAlertDlg" value="对话框测试" />
		<input name="btnConfirmDlg" type="button" id="btnConfirmDlg" value="确认框测试" />
		<SCRIPT LANGUAGE="JavaScript">
		<!--
		// 查询显示列信息
		//var showCols = ${ShowCols}//取后台列设置类数组，对应如下
		//var showCols = [{"dataKey":"id","key":"id","name":"ID","width":"10%"},{"dataKey":"username","key":"username","name":"用户名","width":"20%"},{"dataKey":"password","key":"password","name":"密码","width":"30%"},{"dataKey":"description","key":"description","name":"描述","width":""}]

			$(document).ready(function() { 
				//普通模式
				$("#btnBoxTest").click(function(){
					//使用对话框原类，详细请看weebox文档
					$.weeboxs.open('The operation failed.<a href="#" id="colseBtn">close</a>',{
							showButton: false,
							showClose: false,
							title: 'Hello World',
							onopen:function(box){
								//alert('opened!');
								$("#colseBtn").click(function(){
										box.close();
								 });
							},
							onclose:function(){
								//alert('closed!');
							},
							onok:function(){
								//alert('ok');
								$.weeboxs.close();
							}
						}
					);
				});
				
				//绑定提交事件
				$("#frmTest").submit(function(){
					//提交对话框(把表单提交到对话框里,在提交后之后可以回调(window.parent.closePage()来关闭对话框,window.parent.refreshPage()可以刷新当前页))
					//@@param(frmObj--表单对象,headerTitle--对话框标题,widthDlg--对话框宽度,heightDlg-对话框高度,isCloseBtn-是否使用关闭按钮)
					saveInDlg(this,"提交测试",500,300,true);
					//return false;
				});
				//对话框模式
				$("#btnAlertDlg").click(function(){
					//普通对话框,只显示一句话
					//@@param(message--显示的内容(支持HTML),headerTitle--标题,isOkBtn--是否使用确定按钮,isCloseBtn--是否使用关闭按钮)
					alertDlg("对话框测试","出错！");
					//return false;
				});

				//确认框模式
				$("#btnConfirmDlg").click(function(){

					//使用确认框模式必须指定返回方法
					var ok = function(){
						alert("OK");
					}

					var cancle = function(){
						alert("Cancle");
					}
					
					//确认对话框,可以手动定位OK和Cancle方法
					//@@param(message--显示的内容(支持HTML),headerTitle--标题,ok--OK方法,cancle--cancle方法(和关闭方法不同))
					confirmDlg("确认框测试","请确认",ok,cancle);
					//return false;
				});
				//btnAlertDlg
			});
			
		//-->
		</SCRIPT>
		</div>
		//显示提示信息,一般在客户端验证出错时调用该方法
		function f_showMsg(m)
		<button type="button" onclick="f_showMsg('test warring')"> Test it </button>
		<hr />
		//显示成功提示信息
		function f_showSMsg(m)
		<button type="button" onclick="f_showSMsg('test success')"> Test it </button>
		<hr />
		//显示失败提示信息
		function f_showEMsg(m)
		<button type="button" onclick="f_showEMsg('test error')"> Test it </button>
		<hr />
		//显示进度信息
		function f_showPlan(m)
		<button type="button" onclick="f_showPlan('test plan')"> Test it </button>
		<hr />
	
	<hr />
	<script type="text/javascript" src="/js/common/rnd_code.js"></script>
    <span class="index_main_top_area_xi">　　　校验码：</span>
   	<input tabindex="8" name="vaildate_code" class="code" type="text" id="vaildate_code" class="input3"  maxlength="4" onBlur="hiddenVerify()" 
	onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value="点击输入"/>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
	</body>
</html>