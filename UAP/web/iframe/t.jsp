<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link  href="<%= contextPath %>/css/<%=currentTheme%>/peijian.css"rel="stylesheet" type="text/css">
<title></title>
<script type="text/javascript">	

</script>


</head>

<body>
<div class="index_main_anniubj">
  <div class="index_main_anniu_1">安排工作</div><div class="index_main_anniu_2">待办处理</div><div class="index_main_anniu_3">已完成</div><div class="index_main_anniu_4">所有待办事宜</div>
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
  
</table></div>

<div class="index_main_ye">[ 首页 | 上一页 | 下一页 | 末页 ] 页数：
  <select name="select" class="index_main_ye_biaodan">
    <option>1/1</option>
    <option>1/2</option>
  </select>
</div>

</body>
</html>
