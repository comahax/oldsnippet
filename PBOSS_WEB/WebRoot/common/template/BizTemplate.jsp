<%@ page contentType="text/html;charset=GBK"%>
<%@page import="com.gmcc.pboss.common.file.dictionary.*"%>
<%@ include file="/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- ����CSS�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!--ͷ��-->
	<%@ include file="/common/include/inc_head.jsp"%>
	<!--ͷ������-->
	<!--���ݿ�ʼ -->
	<div class="divspan">
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span>
				<span class="font_breadcrumb"> 
					<a href="#">��ҳ</a> > <a href="#">��Ϣ��ѯ</a> > <a href="#">�����ϸ��ѯ</a>
				</span>
			</div>
			<div class="listboxtitle">��ѯ��������������Ӳ�ѯ������</div>
			<div class="listboxform">
				<table border="0" width="100%">
				  <tr>
					<td class="input_label">�Ǽ�ʱ�䣺</td>
					<td><select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></td>
					<td class="input_label">�׿����룺</td>
					<td><input name="parameter.mobile" id="mobile" class="text_01" size="11" maxlength="11" /></td>
					</tr>
				  <tr>
					<td valign="top" class="input_label">&nbsp;</td>
					<td colspan="3" align="left"><input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" />&nbsp;&nbsp;<input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" /></td>
				  </tr>
				</table>
			</div>
			
			<div class="listboxlist">
			<div class="listboxtitle">��ѯ�������������ʾ��ѯ�����</div>
			<table class="tb_comn" width="100%">
                  <thead>
                    <tr>
                      <td>��ͷһ</td>
                      <td>��ͷ��</td>
                      <td>��ͷ��</td>
                      <td>��ͷ��</td>
                      <td>��ͷ��</td>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>GPRS</td>
                      <td>����</td>
                      <td>���ŷ���</td>
                      <td>ʡ�����Σ��޹��ڣ�</td>
                      <td>������ʾ</td>
                    </tr>
                    <tr>
                      <td>GPRS</td>
                      <td>����</td>
                      <td>���ŷ���</td>
                      <td>ʡ�����Σ��޹��ڣ�</td>
                      <td>������ʾ</td>
                    </tr>
                  </tbody>
                </table>
				<table width="96%">
					<tr valign=middle>
						<td align=left height=30>&nbsp;&nbsp;</td>
						<td align=right style="font-size:12px;">
						�ܼ�<font color="red">1</font>ҳ&nbsp;
						��ǰ��<font color="red">1</font>ҳ
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0" src="${ctx}/images/frist.gif" alt="��һҳ" />
						</a> 
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="${ctx}/images/pre.gif" alt="ǰһҳ" />
						</a>
						
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="${ctx}/images/next.gif" alt="��һҳ" />
						</a>
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="${ctx}/images/last.gif" alt="���һҳ" />
						</a>
						&nbsp; ��ת��
						<input name="param.goto_page" type="text" size="2" ID="goto_page" value="1">
						ҳ<a href="#"><img src="${ctx}/images/go.gif" alt="��ת��" width="16" height="14" border="0"></a>
						</td>
					</tr>
				</table>
				
	<!--������Ϣ��ʼ-->
	<div class="column">
         <div class="listboxtitle">����˵��������������ӹ���˵����</div>
         <div class="reminder">
           ��ѯ����Ӧ�������ϸ�� </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ��������������ܰ���ѣ�</div>
         <div class="reminder">
           <p>1�� ÿ�β�ѯʱӦ������ѡ�������͡�</p>
           <p>2�� ÿ�β�ѯ����ѡ��һ�������¶�������в�ѯ�� </p>
          </div>
       </div>
     <!--������Ϣ����-->
        
	</div>
		</div>
	</div>
	<!-- ���ݲ��ֽ��� -->
	<!--β��-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
