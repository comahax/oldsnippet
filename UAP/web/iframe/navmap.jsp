<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script type="text/javascript" src="<%= contextPath %>/js/cookies.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
#map_box_bg {
	width:100%;
	background:#fbf9fb
}
#map_box {
	width:970px;
	margin:0 auto;
	padding:22px 0 50px 0;
}
#map_box a {
	color:#786670;
	text-decoration:none;
	display:inline-block;
	font-family:Arial, "宋体", "Times New Roman"
}
#map_box h1, h2 {
	margin:0;
	padding:0;
}
#map_box h1 {
	background:#f6f0f6;
	color:#66575f;
	font-size:15px;
	height:20px;
	line-height:20px;
	font-weight:bold;
	padding-left:20px; background:url('<%=currentTheme%>'/images/dtree/2.gif) 7px center no-repeat ;
	width:941px;
}
#map_box h2 {
	font-size:13px;
	font-weight:lighter;
	width:941px;
	line-height:19px;
	color:#000;
	padding-left:20px;
	margin:10px 0 20px 0;
}
.pad5 {
	width:31px;
	text-align:center;
	color:#786670;
	display:inline-block;
	font-family:Arial;
}
	
	
</style>



<title></title>
<script type="text/javascript">

	function showDialog(){
			
	$("#searchbtn").dialog({			
			   title:"事件详情",   
               width:600,   
               height:300,                  
               content:'url:../iframe/t.jsp',               
               max:false,   
               min:false,   
               lock:true 	
	});
	
	}

</script>


</head>

<body>
<div id="map_box_bg">
	<div id="map_box">
	 <!--  <div class="vipmap_title"><imgwidth="126" height="38" />站点地图</div>  --> 
	   
	   
	   <script>
	   	var secordMenu = ['出账进度','出账核查','出账调整','统计分析'];
      	 
      	 var thirdMenu  = ['出账前监控','出账过程监控$/fee/billing/billstatus_set.do','出账后监控','|',
						   '固定费核查$/fee/billing/uapreq_list.do?target=GR','平衡性检查$/fee/billing/billlogdeta_list.do','文件下载$/fee/billing/uapreqfile_list.do','核查记录监控$/fee/billing/checkprocess_list.do','|',
						   '固定费调整$http://10.200.1.230:9086/personboss/fee/billing/fixfee/fixfee.do?secretString=GMCC&staffNo=fsng&staffName=fsng&cityID=757&orgID=123&sourceURL=test&rootTicket=123','无主调整$http://10.200.1.230:9085/czboss/fee/billing/fixfee/fixfee.do?secretString=GMCC&staffNo=fsng&staffName=fsng&cityID=757&orgID=123&sourceURL=test&rootTicket=123','应收调整','|',						   
						   '统计分析$/fee/billing/uapreqfile_list1.do']; 
		var menuArray = new Array();
		
		var tempArray = thirdMenu;
		 var frame = top.mainFrame; 
	
		var temp="";
		var aa="";
		for(var i=0 ; i<secordMenu.length;i++){
			
			var html = '<h1>'+secordMenu[i]+'</h1>';
			
			var content="";
			
			for(var j=0 ;j<tempArray.length ; j++){
			
				if(tempArray[j] == '|'){ 
					
					tempArray = tempArray.slice(j+1);
					
					break;
				}
				if(tempArray[j].length > 1){
					temp = tempArray[j].split('$');
				}			
				var url = '<%=contextPath%>'+temp[1];	
				var href="";
				if(temp[1])	{
					if(url.indexOf('http') != -1) url = url.substring(4,url.length);					
					href = "javascript:setlocation('"+temp[0]+"','"+url+"',frame)";
				}else{				
					href ="javascript:alert('功能构建中...');"
				}
				content += "<a href="+href+">"+temp[0]+"</a><span class='pad5'>|</span>";	
				
			}
			 menuArray.push(html+"<h2>"+content+"</h2>");
		}			   
		document.write(menuArray.join(''));	
	   
	   </script>	   
   
	</div>
</div>
</body>
</html>
