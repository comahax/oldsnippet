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
		<input name="btnBoxTest" type="button" id="btnBoxTest" value="��ͨģʽ���ڣ���ǶDIV��" />
		<FORM METHOD=POST ACTION="submit.jsp" id="frmTest" name="frmTest">
			<INPUT type="text" name="txtTest" id="txtTest" value="ABC">
			<input name="btnBoxTest" type="submit" id="btnIfmTest" value="�ύ��" />
		</FORM>
		<input name="btnAlertDlg" type="button" id="btnAlertDlg" value="�Ի������" />
		<input name="btnConfirmDlg" type="button" id="btnConfirmDlg" value="ȷ�Ͽ����" />
		<SCRIPT LANGUAGE="JavaScript">
		<!--
		// ��ѯ��ʾ����Ϣ
		//var showCols = ${ShowCols}//ȡ��̨�����������飬��Ӧ����
		//var showCols = [{"dataKey":"id","key":"id","name":"ID","width":"10%"},{"dataKey":"username","key":"username","name":"�û���","width":"20%"},{"dataKey":"password","key":"password","name":"����","width":"30%"},{"dataKey":"description","key":"description","name":"����","width":""}]

			$(document).ready(function() { 
				//��ͨģʽ
				$("#btnBoxTest").click(function(){
					//ʹ�öԻ���ԭ�࣬��ϸ�뿴weebox�ĵ�
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
				
				//���ύ�¼�
				$("#frmTest").submit(function(){
					//�ύ�Ի���(�ѱ��ύ���Ի�����,���ύ��֮����Իص�(window.parent.closePage()���رնԻ���,window.parent.refreshPage()����ˢ�µ�ǰҳ))
					//@@param(frmObj--������,headerTitle--�Ի������,widthDlg--�Ի�����,heightDlg-�Ի���߶�,isCloseBtn-�Ƿ�ʹ�ùرհ�ť)
					saveInDlg(this,"�ύ����",500,300,true);
					//return false;
				});
				//�Ի���ģʽ
				$("#btnAlertDlg").click(function(){
					//��ͨ�Ի���,ֻ��ʾһ�仰
					//@@param(message--��ʾ������(֧��HTML),headerTitle--����,isOkBtn--�Ƿ�ʹ��ȷ����ť,isCloseBtn--�Ƿ�ʹ�ùرհ�ť)
					alertDlg("�Ի������","����");
					//return false;
				});

				//ȷ�Ͽ�ģʽ
				$("#btnConfirmDlg").click(function(){

					//ʹ��ȷ�Ͽ�ģʽ����ָ�����ط���
					var ok = function(){
						alert("OK");
					}

					var cancle = function(){
						alert("Cancle");
					}
					
					//ȷ�϶Ի���,�����ֶ���λOK��Cancle����
					//@@param(message--��ʾ������(֧��HTML),headerTitle--����,ok--OK����,cancle--cancle����(�͹رշ�����ͬ))
					confirmDlg("ȷ�Ͽ����","��ȷ��",ok,cancle);
					//return false;
				});
				//btnAlertDlg
			});
			
		//-->
		</SCRIPT>
		</div>
		//��ʾ��ʾ��Ϣ,һ���ڿͻ�����֤����ʱ���ø÷���
		function f_showMsg(m)
		<button type="button" onclick="f_showMsg('test warring')"> Test it </button>
		<hr />
		//��ʾ�ɹ���ʾ��Ϣ
		function f_showSMsg(m)
		<button type="button" onclick="f_showSMsg('test success')"> Test it </button>
		<hr />
		//��ʾʧ����ʾ��Ϣ
		function f_showEMsg(m)
		<button type="button" onclick="f_showEMsg('test error')"> Test it </button>
		<hr />
		//��ʾ������Ϣ
		function f_showPlan(m)
		<button type="button" onclick="f_showPlan('test plan')"> Test it </button>
		<hr />
	
	<hr />
	<script type="text/javascript" src="/js/common/rnd_code.js"></script>
    <span class="index_main_top_area_xi">������У���룺</span>
   	<input tabindex="8" name="vaildate_code" class="code" type="text" id="vaildate_code" class="input3"  maxlength="4" onBlur="hiddenVerify()" 
	onFocus="focusGetVerify(this)"  size="4" style="ime-mode:disabled;width:50px" value="�������"/>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
	</body>
</html>