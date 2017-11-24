<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
	//String filterFlag = request.getParameter("filterFlag");
%>
<html:html>
<script language="JavaScript" type="text/JavaScript">
	window.moveTo(300,200);
</script>
<head>
	<base target="_self"/>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	<title></title>
    <!-- 插入打印控件 -->

	<script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
    <script language="JavaScript" type="text/JavaScript">
	function doClose(){
		if (confirm("请确认已进行打印操作,然后关闭窗口!\n\r          确定关闭?")){
			window.close();
		}
		if (!window.closed){
			var we = document.all["WebBrowser"];
			we.ExecWB(45,1);
		}
	}
	function doPrint1(how)
	{
		var we = document.all["WebBrowser"];
		if(how =='打印预览'){
			we.ExecWB(7,1);
		}else if (how =='打印'){
			we.ExecWB(6,1);
		}else if (how =='打印设置'){
			we.ExecWB(8,1);
		}
		doUpdateSheetstate();
	}
	
	function loadComplete(){
		var btPrint = document.formList.bt_print;
		if (btPrint){
			btPrint.disabled = false;
			document.formList.bt_preview.disabled = false;
			document.formList.bt_set.disabled = false;
		}
	}

	//此处需要注意，此时父窗口不能已刷新，否则取值会出错
	var preMsg = window.opener.preMsg;
	var newMsg =  window.opener.newMsg;
	var wayid = window.opener.preObj['wayid'];
	var wayname = window.opener.preObj['wayname'];
	window.opener.submitFlag = true;
	
    </script>
    <style media="print" type="text/css"> 
		.table_div{display:none;} 
		.PageNext{page-break-after: always;padding-top:2.5cm;} 
	</style> 
	
	 <style type="text/css"> 
		.PageNext{padding-top:2.5cm;} 
		.PageNext2{padding-top:2.5cm;} 
	</style> 
</head>

<body onload="loadforiframe();loadComplete();">
<html:form action="/resmanage/oprresmanage/sheet.do?CMD=LIST" styleId="formList">
<OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height="0" id="WebBrowser" width="0"></OBJECT> 
    <div class="table_div">
	<table width="100%" class="error_text">
		<s:Msg />
	</table>
	</div>
	<div class="table_div">
		<table class="table_button_list" id="bttb">
			<tr>
			
				<td>
					<input type="button" name="bt_set" class="Button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					onfocus="buttonover(this)" onblur="buttonout(this)" disabled="true" value="打印设置"
					onClick="doPrint1(this.value)" />
					<input type="button" name="bt_preview" class="Button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					onfocus="buttonover(this)" onblur="buttonout(this)"disabled="true" value="打印预览"
					onClick="doPrint1(this.value)"/>
					<input type="button" name="bt_print" class="Button_2" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					onfocus="buttonover(this)" onblur="buttonout(this)" disabled="true" value="打印"
					onClick="doPrint1(this.value)"/>	
					<input type="button" class="Button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
					onfocus="buttonover(this)" onblur="buttonout(this)" value="关闭窗口"
					onClick="doClose()" />						
				</td>
			</tr>
		</table>
	</div>
	<div class="PageNext">
   		 <table class="table_style" width="98%">
   		 <tr class="table_style_content">
          	<td align="center" colspan="4"><b>网点信息变更单</b></td>
		</tr>
        <tr class="table_style_content">
        <script type="text/javascript">
        	var text = "<td align='left'>网点编码：" + wayid + "       网点名称： " + wayname + "</td>";
			document.writeln(text);
			var d = new Date();
			d = d.getYear() + "-" + (d.getMonth()+1) + "-" + d.getDate();
			text = '<td align="right">受理日期：' + d + '</td>'
			document.writeln(text);
        </script>
		</tr>
		 <tr class="table_style_content">
             <td align="left"><b><font color="red">变更前信息:</font></b></td>
             <td align="left"><b><font color="red">变更后信息:</font></b></td>
         </tr>
         
             <script type="text/javascript">
	        	if (preMsg && newMsg){
	        		preMsg = preMsg.slice(0,-1).split(";");
	        		newMsg = newMsg.slice(0,-1).split(";");
	        		for (var i = 0; i < preMsg.length; i++){
	        			document.writeln("<tr class='table_style_content'><td align='left'>" + preMsg[i] + "</td>");
	        			document.writeln("<td align='left'>" + newMsg[i] + "</td></tr>");
	        		}
	        	}
	        </script>
         
         </table>
	</div>
</html:form>

</body>
</html:html>
