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
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb"> <a href="#">��ҳ</a> > <a href="#">��Ϣ��ѯ</a> > <a href="#">�����ϸ��ѯ</a></span>
			</div>
			<div class="listboxtitle">��ѯ������</div>
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
			<div class="listboxtitle">��ѯ�����</div>
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
						<img border="0" src="/images/frist.gif" alt="��һҳ" />
						</a> 
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="/images/pre.gif" alt="ǰһҳ" />
						</a>
						
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="/images/next.gif" alt="��һҳ" />
						</a>
						<a href="javascript:void(0)" style="text-decoration:none" >
						<img border="0"  src="/images/last.gif" alt="���һҳ" />
						</a>
						&nbsp; ��ת��
						<input name="param.goto_page" type="text" size="2" ID="goto_page" value="1">
						ҳ<a href="#"><img src="/images/go.gif" alt="��ת��" width="16" height="14" border="0"></a>
						</td>
					</tr>
				</table>
				
	<!--������Ϣ��ʼ-->
	<div class="column">
         <div class="listboxtitle">����˵����</div>
         <div class="reminder">
           ��ѯ����Ӧ�������ϸ�� </div>
       </div>
       <div class="column">
         <div class="listboxtitle">��ܰ���ѣ�</div>
         <div class="reminder">
           <p>1�� ÿ�β�ѯʱӦ������ѡ�������͡�</p>
           <p>2�� ÿ�β�ѯ����ѡ��һ�������¶�������в�ѯ�� </p>
          </div>
       </div>
     <!--������Ϣ����-->
        
	<br><br><br>
	<h1>������ʽ</h1>
	��ť��<br><hr><br>
	<input type="button" class="btn_blue_75" value="ȷ ��" />
	<input type="button" class="btn_blue" value="��ȡ������������ȡ�����������" />
	<br>��ʾ��Ϣ<hr><br>
	
	<b class="green"> �𾴵Ŀͻ���Success!</b><br>
	<b class="red_01"> �𾴵Ŀͻ���Fail!</b>  <br>
	<b class="blue_01"> �𾴵Ŀͻ���Warrning!</b>
	
	<br>�ı������<hr><br>
	TYPE:TEXT:<input type="text" class="text_01"    />
	TYPE:TEXTAREA:
	<textarea name="textarea" class="textarea_01" id="textarea"></textarea>
	<br>
	Select:
	
   	<select class="select_2L">
     <option>����</option>
   	</select>
   	<select class="select_3L">
     <option>������������</option>
   	</select>
   	<select class="select_4L">
     <option>����������������</option>
   	</select>
	<br><br>��<hr><br>
	<table class = "tb02" width="96%">
              <tr>
                <td class="blue_01 textRight">�ֻ����룺</td>
                <td  class="red_01"> 13924022454 </td>
              </tr>
              <tr>
                <td class="blue_01 textRight">����������</td>
                <td  class="red_01">���Բ���</td>
              </tr>
              <tr>
                <td class="blue_01 textRight">�ֻ�״̬��</td>
                <td  class="red_01"><input type="radio" checked="checked" />
                  ����ͣ�� </td>
              </tr>
              <tr>
                <td class="blue_01 textRight"><label for="label">��֤�룺</label>
                </td>
                <td ><input type="text" class="text_01" id="label" onFocus="shover(this,'text_01_02')" onBlur="shover(this,'text_01')"  />
                    <img src="/v2008/images/public/validateCode.gif" class="validateCode"  /></td>
              </tr>
              <tr>
                <td class="blue_01 textRight" valign="top"><label for="label2">ͣ��ԭ��</label>
                </td>
                <td ><textarea name="textarea2" class="textarea_01" onFocus="shover(this,'textarea_01_02')" onBlur="shover(this,'textarea_01')" id="label2"></textarea>
                </td>
              </tr>
              <tr>
                <td></td>
                <td ><input type="checkbox" checked="checked" />
                    <span class="red_01">���Ƿ񽫼�¼���浽����</span>
                    <input type="text" class="text_01"    value="13924022454@139.com" />
                </td>
              </tr>
            </table>
            <table class = "tb02" width="96%">
              <thead>
                <tr>
                  <td class="blue_01 textRight"> �ֻ����룺 </td>
                  <td class="red_01"> 13929416652</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">����������</td>
                  <td  class="red_01">ĳĳĳĳ</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">����״̬��</td>
                  <td  class="red_01">�ѿ�ͨ</td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="blue_01 textRight">
                    <label for="psw">ԭ���룺</label>
                  </td>
                  <td>
                    <input type="password" id="psw" class="text_01" onFocus="shover(this,'text_01_02')"  onblur="shover(this,'text_01')"  />
                  </td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">
                    <label for="psw2">�����룺</label>
                  </td>
                  <td>
                    <input type="password" id="psw2" class="text_01" onBlur="shover(this,'text_01')" onFocus="shover(this,'text_01_02')"/>
                  </td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">
                    <label for="psw3">ȷ�������룺</label>
                  </td>
                  <td>
                    <input type="password" id="psw3" class="text_01"  onblur="shover(this,'text_01')" onFocus="shover(this,'text_01_02')"/>
                  </td>
                </tr>
              <tr>
                <td></td>
                <td >
                  <input type="checkbox" checked="checked" />
                  <span class="red_01">���Ƿ񽫼�¼���浽����</span>
                  <input type="text" class="text_01"    value="13924022454@139.com" />
                </td>
              </tr>
              </tbody>
            </table>
            <br/>���͵���ϸ��<br/>
            <table class = "tb02" width="96%">
            <thead>
            	<tr>
                  <td colspan="4"><b class="blue_01">���͵���ϸ</b></td>
                </tr>
                <tr>
                  <td class="blue_01 textRight"> ���͵��ţ� </td>
                  <td class="red_01"> GZ200808981243</td>
                  <td class="blue_01 textRight">���͵�״̬��</td>
                  <td class="red_01">������</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">����ʱ�䣺</td>
                  <td class="red_01">2009-08-18 13:15:00</td>
                  <td class="blue_01 textRight">Ҫ���ʹ�ʱ�䣺</td>
                  <td class="red_01">2009-08-20 13:15:00</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">�ջ���λ��</td>
                  <td  class="red_01">����ͨѶ</td>
                  <td class="blue_01 textRight">�ջ������ƣ�</td>
                  <td  class="red_01">����</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">�ջ��˵绰��</td>
                  <td class="red_01">15989899898</td>
                  <td class="blue_01 textRight">�����̣�</td>
                  <td class="red_01">�����</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">��ע��</td>
                  <td class="red_01" COLSPAN=3><textarea name="textarea2" class="textarea_01" onFocus="shover(this,'textarea_01_02')" onBlur="shover(this,'textarea_01')" id="label2"></textarea></td>
                </tr>
                <!-- ������Ϣ1 -->
                <tr>
                  <td colspan="4"><b class="blue_01">������Ϣ GZ2009081923567384</b></td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">�����ţ�</td>
                  <td class="red_01">GZ2009081923567384</td>
                  <td class="blue_01 textRight">��������ʱ�䣺</td>
                  <td class="red_01">2009-08-17 13:15:00</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">����״̬��</td>
                  <td class="red_01">δ�ر�</td>
                  <td class="blue_01 textRight">�ܽ�</td>
                  <td class="red_01">200Ԫ</td>
                </tr>
                <tr>
                  <td colspan="4"><b class="blue_01">������ϸ GZ2009081923567384</b></td>
                </tr>
                <tr>
                	<td colspan="4">
		                <table class="tb_comn" width="96%">
		                  <thead>
		                    <tr>
		                      <td>��Դ���</td>
		                      <td>��Ʒ����</td>
		                      <td>����</td>
		                      <td>����</td>
		                      <td>��λ</td>
		                      <td>����</td>
		                      <td>������</td>
		                    </tr>
		                  </thead>
		                  <tbody>
		                    <tr>
		                      <td>8775</td>
		                      <td>������55Ԫ</td>
		                      <td>7886</td>
		                      <td>P5673</td>
		                      <td>1��</td>
		                      <td>55Ԫ</td>
		                      <td>55Ԫ</td>
		                    </tr>
		                  </tbody>
		                </table>
	                </td>
                </tr>
		        
		        <!-- ������Ϣ2 -->
                <tr>
                  <td colspan="4"><b class="blue_01">������Ϣ GZ2009081923567323</b></td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">�����ţ�</td>
                  <td class="red_01">GZ2009081923567323</td>
                  <td class="blue_01 textRight">��������ʱ�䣺</td>
                  <td class="red_01">2009-08-17 14:15:00</td>
                </tr>
                <tr>
                  <td class="blue_01 textRight">����״̬��</td>
                  <td class="red_01">δ�ر�</td>
                  <td class="blue_01 textRight">�ܽ�</td>
                  <td class="red_01">100Ԫ</td>
                </tr>
                <tr>
                  <td colspan="4"><b class="blue_01">������ϸ GZ2009081923567323</b></td>
                </tr>
                <tr>
                	<td colspan="4">
		                <table class="tb_comn" width="96%">
		                  <thead>
		                    <tr>
		                      <td>��Դ���</td>
		                      <td>��Ʒ����</td>
		                      <td>����</td>
		                      <td>����</td>
		                      <td>��λ</td>
		                      <td>����</td>
		                      <td>������</td>
		                    </tr>
		                  </thead>
		                  <tbody>
		                    <tr>
		                      <td>8775</td>
		                      <td>������100Ԫ</td>
		                      <td>7886</td>
		                      <td>P5673</td>
		                      <td>1��</td>
		                      <td>100Ԫ</td>
		                      <td>100Ԫ</td>
		                    </tr>
		                  </tbody>
		                </table>
	                </td>
                </tr>
		        
               	<tr>
                  <td class="blue_01 textCenter" COLSPAN=4>
                  <input type="button" class="btn_blue_75" value="�� ӡ" />
                  <input type="button" class="btn_blue_75" value="�� ��" />
                  </td>
                </tr>
                	<!--/td-->
                <!--/tr-->
              </thead>
            </table>
            
             <br/>���ؿ�<br/>
             <!-- �ϴ�ʱ��Action��operationΪUPLOAD��uploadTypeΪ�����ļ��е�Type���� -->
            <form action="/fileHandle?operation=<%=FileHandleType.UPLOAD %>&uploadType=<%=UploadFileType.INDAGATE_QUESTIONNAIRE %>" 
            	  id="uploadForm" name="uploadForm" enctype="multipart/form-data"  method="post" target="hidden_frame" >
            	<input type="file" id="uploadFile" name="uploadFile" style="width:250">
            	<input type="button" class="btn_blue_75" onClick="f_submitUpload()" value='�� ��' >
            	<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
            </form>
            <!-- �����ļ�����JS -->
            <script type="text/javascript" src="${ctx}/js/common/fileHandle.js" ></script>
			</div>
		</div>
	</div>
	<!-- ���ݲ��ֽ��� -->
	<!--β��-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript">

//��ʼ����ǩ������Ĭ�ϱ�ѡ�еı�ǩ
//@@��ʼ��������Ӧ����JS�д���
//ҳ���ʼ�����ʱ����
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
