<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<html>
<head>
<title>广东移动渠道管理系统</title>
<script type="text/javascript" src="../js/dtree.js"></script>
<script type="text/javascript" src="../js/cookies.js"></script>
<link href="<%= contextPath %>/css/<%=currentTheme%>/link.css" rel="stylesheet" type="text/css">
<link href="<%= contextPath %>/css/<%=currentTheme%>/dtree.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" >
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align='left' valign='top' width="100%" height="100%">
 <!--    <div  class="dtree" style="font-size:12px;width:100%;padding-left:35px;background:url(//..images/dtree/base.gif) no-repeat 20px 0px;color:#666666;">最近浏览</div>
      <div id="use">
      		
      	</div>
      	<script>
      		getlocation();
      	</script>
		<p>
 -->
      <div class="dtree">
        <script type="text/javascript">
          d = new dTree('d');
          d.add('1', -1, '您收藏的菜单', '', '综合业务支撑系统', 'tbody' );                      
          d.add('10000', 1, '一级菜单', '', '12hhhhh345', 'tbody'); 
              d.add('10001', 10000, '受理方式', '', '在干什么', 'tbody');
              d.add('10002', 10000, '受理方式', '', '受理方式', 'tbody');
              d.add('10003', 10000, '受理方式', '', '受理方式', 'tbody');
              d.add('10004', 10000, '受方式', '', '受理方式', 'tbody');
                  d.add('20004', 10004, '受    式', '', '受理方式', 'tbody');
                  d.add('20005', 10004, '受理方式', '', '受理方式', 'tbody');
                  d.add('20006', 10004, '受理方式', '', '受理方式', 'tbody');                     
          d.add('10030', 1, '缴费方式', '', '缴费方式', 'tbody');                      
          d.add('10040', 1, '号码状态', '', '号码状态', 'tbody');                      
          d.add('10060', 1, '消费等级', 'javascript:a();', '1234', '');
          //这里的内容通过struts生成
          //具体形式可以例如： d.add(<bean:write name="treeList" property="id"/>,<bean:write name="treeList" property="superId"/>,'<bean:write name="treeList" property="name"/>','http://www.urlHere.com','','mainFrame','','');
          //d.add的全部参数形式是：d.add(id, pid, name, url, title, target, icon, iconOpen, open, checked, disabled)
          //ID：主键
	  //PID：父类ID
	  //NAME：结点名称
	  //URL：结点连接的URL
	  //TITLE：类似ALT的一种结点显示内容
	  //TARGET：连接打开的目标
	  //ICON：图片文件，没有指定将使用默认的图片
	  //ICONOPEN：打开结点后的图片文件，没有指定将使用默认的图片
	  //OPEN：boolean类型，结点是否打开。

		document.write(d);
        </script>
        <script>
        	top.leftFrame.lefttopFrame.menuname.innerHTML=document.title;
        </script>
      </div>
    </td>
  </tr>
</table>
</body>
</html>