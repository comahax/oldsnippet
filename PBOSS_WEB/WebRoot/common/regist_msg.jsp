<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<script type="text/javascript" src="/js/common.js" ></script>
</head>
<body>
	<!-- ͷ�������� -->
	
    <div class="divspan">
    <table width="910"  border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td width="910px" height="121px" valign="top" background="/images/img/header.jpg"><div class="heade" >
            <div class="font_red"> ��ӭʹ�ù㶫�ƶ���������������ƽ̨</div>
          </div></td>
        </tr>
      </table>

		<!--��׼���ݿ�ʼ-->		
		<div class="menu">
			<IMG SRC="/images/img/messages.jpg" ALT="��Ϣ��ʾ">
		</div>
		<div class="context">
			<div class="listboxtitle">��Ϣ��ʾ</div>
			<div class="messageshow">
				<ul>
					<li><s:property value="message"/></li>
				</ul>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="formButton" onClick="window.close()">�ر�</button>
			</div>
			
		</div>
			<!--��׼���ݽ���-->
	</div>
	<%@ include file="/common/include/inc_foot.jsp"%>
</body>
</html>