<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<html >
<head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style type="text/css">
<!--
a:hover {
	color: #FF0000;
	text-decoration: none;
}
a:link {
	text-decoration: none;
	color: #949896;
}
a:visited {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
-->
</style>
<link  href="<%= contextPath %>/css/<%=currentTheme%>/peijian.css"rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/lhgdialog/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../js/lhgdialog/lhgdialog.min.js"></script>

<script type="text/javascript">

	function showDialog(){
			
	$("#searchbtn").dialog({			
			   title:"事件详情",   
               width:600,   
               height:300,                  
               content:'url:../checkout/a.jsp',               
               max:false,   
               min:false,   
               lock:true 	
	});
	
	}

</script>


</head>

<body leftmargin="0" topmargin="0" bottommargin="0">
	<div class="index_main_topbj">
		<div class="index_main_topleft"></div>
		<div class="index_main_top_area_w">
			<span class="index_main_top_area">当前位置 </span>
			<span class="index_main_top_area_xi">></span> 
			<span class="index_main_top_area_h">待办事宜</span></div>
		</div>
		<div class="index_main_anniubj">
		  <div class="index_main_anniu_1">安排工作</div>
		  <div class="index_main_anniu_2">待办处理</div>
		  <div class="index_main_anniu_3">已完成</div>
		  <div class="index_main_anniu_4">所有待办事宜</div>
	</div>
	<div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr class="index_main_xinxi_bj">
		    <td><div class="index_main_xinxi_leftbt"></div>
		    <div class="index_main_xinxi_zi">序号</div></td>
		    <td ><div class="index_main_xinxi_left"></div>
		    <div class="index_main_xinxi_zi">任务名称</div></td>
		    <td><div class="index_main_xinxi_left"></div>
		    <div class="index_main_xinxi_zi">指派人</div></td>
		    <td ><div class="index_main_xinxi_left"></div>
		    <div class="index_main_xinxi_zi">指派时间</div></td>
		    <td ><div class="index_main_xinxi_left"></div>
		    <div class="index_main_xinxi_zi">任务状态</div></td>
		    <td><div class="index_main_xinxi_righttime"></div>
		    <div class="index_main_xinxi_zi">修改时间</div>
			</td>
		  </tr>
		 <tr onMouseMove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
		    <td class="table_xia_qh" >00001</td>
		    <td class="table_xia"><a href="Details/Details_a.jsp" target="mainFrame" >具体事项名称</a> </td>
		    <td class="table_xia"><a id="cs" href="javascript:showDialog();" >某某人指派</a></td>
		    <td class="table_xia">2006-11-15 10:45</td>
		    <td class="table_xia">已完成</td>
		    <td class="table_xia_qh">2006-11-15 10:45</td>
		  </tr>
		 <tr onMouseMove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
		    <td class="table_xia_qh" >00001</td>
		    <td class="table_xia">具体事项名称 </td>
		    <td class="table_xia">某某人指派</td>
		    <td class="table_xia">2006-11-15 10:45</td>
		    <td class="table_xia">已完成</td>
		    <td class="table_xia_qh">2006-11-15 10:45</td>
		  </tr>
		 <tr onMouseMove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
		    <td class="table_xia_qh" >00001</td>
		    <td class="table_xia">具体事项名称 </td>
		    <td class="table_xia">某某人指派</td>
		    <td class="table_xia">2006-11-15 10:45</td>
		    <td class="table_xia">已完成</td>
		    <td class="table_xia_qh">2006-11-15 10:45</td>
		  </tr>
		 <tr onMouseMove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
		    <td class="table_xia_qh" >00001</td>
		    <td class="table_xia">具体事项名称 </td>
		    <td class="table_xia">某某人指派</td>
		    <td class="table_xia">2006-11-15 10:45</td>
		    <td class="table_xia">已完成</td>
		    <td class="table_xia_qh">2006-11-15 10:45</td>
		  </tr>
		 <tr onMouseMove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
		    <td class="table_xia_qh" >00001</td>
		    <td class="table_xia">具体事项名称 </td>
		    <td class="table_xia">某某人指派</td>
		    <td class="table_xia">2006-11-15 10:45</td>
		    <td class="table_xia">已完成</td>
		    <td class="table_xia_qh">2006-11-15 10:45</td>
		  </tr>
		  
		</table>
	</div>

<div class="index_main_ye">[ 首页 | 上一页 | 下一页 | 末页 ] 页数：
  <select name="select" class="index_main_ye_biaodan">
    <option>1/1</option>
    <option>1/2</option>
  </select>
</div>
<div class="index_main_middowbj">
<div class="index_main_middowleft"></div>
<div class="index_main_top_area_w"><span class="index_main_top_area">当前位置 </span><span class="index_main_top_area_xi">&gt; 系统管理子系统 &gt;</span> <span class="index_main_top_area_h">系统公告</span></div>
<div class="index_main_yesousuo">标题：
  
  <label>
  <input name="textfield" type="text" class="index_main_ye_biaodan_k" size="20" />
  </label>
  <label  >
  <input class="index_main_anniu" id="searchbtn" name="Submit" type="submit" value="搜索"  onclick="showDialog();" onfocus="this.blur()"/>
  </label>
</div>
</div>
<div class="index_main_anniubj"> <div class="index_main_anniu_5">增加</div><div class="index_main_anniu_6">修改</div><div class="index_main_anniu_7">删除</div>
<div class="index_main_anniu_8">全选</div>
</div>
<div>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr class="index_main_xinxi_bj" >
    <td>&nbsp;</td>
    <td ><div class="index_main_xinxi_leftbt"></div>
	
    <div class="index_main_xinxi_zi">标题</div></td>
	<td ><div class="index_main_xinxi_left"></div>
    <div class="index_main_xinxi_zi">起始显示时间</div></td>
    <td><div class="index_main_xinxi_left"></div>
    <div class="index_main_xinxi_zi">截止显示时间</div></td>
    <td ><div class="index_main_xinxi_left"></div>
    <div class="index_main_xinxi_zi">创建人</div></td>
    <td ><div class="index_main_xinxi_left"></div>
    <div class="index_main_xinxi_zi">修改人</div></td>
    <td><div class="index_main_xinxi_left"></div>
    <div class="index_main_xinxi_zi">创建时间</div>
	</td>
	<td><div class="index_main_xinxi_righttime"></div>
    <div class="index_main_xinxi_zi">修改时间</div>
	</td>
  </tr>
  <tr  onmousemove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
    <td class="table_xia" ><label>
      <input type="checkbox" name="checkbox" value="checkbox" />
    </label></td>
    <td class="table_xia_qh"><a href="Details/Details_b.jsp" target="mainFrame">食堂停餐</a> </td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">默默</td>
    <td class="table_xia">美丽</td>
	<td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia_qh">2006-11-15 10:45</td>
  </tr>
  <tr  onmousemove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
    <td class="table_xia" ><label>
      <input type="checkbox" name="checkbox" value="checkbox" />
    </label></td>
    <td class="table_xia_qh">食堂停餐 </td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">默默</td>
    <td class="table_xia">美丽</td>
	<td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia_qh">2006-11-15 10:45</td>
  </tr>
  <tr  onmousemove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
    <td class="table_xia" ><label>
      <input type="checkbox" name="checkbox" value="checkbox" />
    </label></td>
    <td class="table_xia_qh">食堂停餐 </td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">默默</td>
    <td class="table_xia">美丽</td>
	<td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia_qh">2006-11-15 10:45</td>
  </tr>
   <tr  onmousemove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
    <td class="table_xia" ><label>
      <input type="checkbox" name="checkbox" value="checkbox" />
    </label></td>
    <td class="table_xia_qh">食堂停餐 </td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">默默</td>
    <td class="table_xia">美丽</td>
	<td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia_qh">2006-11-15 10:45</td>
  </tr>
  <tr  onmousemove="this.bgColor='E2F1DF'" onMouseOut="this.bgColor='#ffffff'">
    <td class="table_xia" ><label>
      <input type="checkbox" name="checkbox" value="checkbox" />
    </label></td>
    <td class="table_xia_qh">食堂停餐 </td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia">默默</td>
    <td class="table_xia">美丽</td>
	<td class="table_xia">2006-11-15 10:45</td>
    <td class="table_xia_qh">2006-11-15 10:45</td>
  </tr>
  
</table></div>

<div class="index_main_ye">[ 首页 | 上一页 | 下一页 | 末页 ] 页数：
  <select name="select" class="index_main_ye_biaodan">
    <option>1/1</option>
    <option>1/2</option>
  </select>
</div>

</body>
</html>
