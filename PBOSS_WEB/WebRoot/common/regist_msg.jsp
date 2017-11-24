<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<script type="text/javascript" src="/js/common.js" ></script>
</head>
<body>
	<!-- 头部导航条 -->
	
    <div class="divspan">
    <table width="910"  border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td width="910px" height="121px" valign="top" background="/images/img/header.jpg"><div class="heade" >
            <div class="font_red"> 欢迎使用广东移动渠道合作伙伴服务平台</div>
          </div></td>
        </tr>
      </table>

		<!--标准内容开始-->		
		<div class="menu">
			<IMG SRC="/images/img/messages.jpg" ALT="信息提示">
		</div>
		<div class="context">
			<div class="listboxtitle">信息提示</div>
			<div class="messageshow">
				<ul>
					<li><s:property value="message"/></li>
				</ul>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="formButton" onClick="window.close()">关闭</button>
			</div>
			
		</div>
			<!--标准内容结束-->
	</div>
	<%@ include file="/common/include/inc_foot.jsp"%>
</body>
</html>