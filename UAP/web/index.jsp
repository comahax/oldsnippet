<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%@ page  import="com.sunrise.jop.infrastructure.db.DBAccessUser"%>
<%
	String path = request.getContextPath();
	String contextPath = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

	DBAccessUser user = (DBAccessUser) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
	String oprcode = user!=null ? user.getOprcode() : "Invalid User";

%>

<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>广东省统一出账平台</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link  rel="stylesheet" type="text/css" href="<%=basePath %>/new/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/new/css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/new/css/zTreeStyle/zTreeStyle.css"/>
    <script type="text/javascript" src="<%=basePath %>/new/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>/new/js/jq.plugin.autosize.js"></script>
    <script type="text/javascript" src="<%=basePath %>/new/js/component/jquery.ztree.core-3.5.min.js"></script>

    
  </head>
  
  <body class="all_body">
    <!--头部内容-->
    <!--header-->
    <div class="header">
        <div class="header_1">
            <div class="header_right">
                <ul class="clearfix">
                    <li class="header_icon1" style="margin-right:20px;"><span><%=oprcode %>  您好 | <script type="text/javascript">var today =new Date() ; document.write((today.toLocaleString().replace(/年|月/g,'-')).replace(/日/g,''));</script></span></li>
                    <li class="header_icon2"><span>首页</span></li>
                    <li class="header_icon4"><span>帮助</span></li>
                    <li class="header_icon3"><span><a href="<%=basePath%>/logout.do" onclick="return confirm('确定退出系统？');">退出</a></span></li>
                </ul>
            </div>
        </div>
    </div>
    <!--header end-->
    <!--中间内容-->

    <div class="content clearfix" id="content">
        <!--左边菜单-->
        <div class="sidebar c_box">
        	<div class="btn_expand_l"></div>
        	<div class="box_header">
            	<h3 class="box_header_title"><span class="icon_list"></span>功能菜单</h3>
            </div>
            <div class="box_content">
            	<div class="searchbar">
                	<div class="searchbox">
                		<input type="text" name="" class="searchbox-default" onfocus="javascript:if(this.value=='输入关键字......'){this.value='';this.className='searchbox-focus'}" onblur="javascript:if(this.value==''){this.value='输入关键字......';this.className='searchbox-default'}" value="输入关键字......"/>
                        <a class="btn_search" href="#"></a>
                    </div>
                </div>
                <ul id="mainNav" class="ztree"></ul>
            </div>
        </div>
        
        <div class="content_p clearfix" id="content_c">
            <iframe name="mainFrame" frameborder="0" src="tabframe.html"></iframe>
        </div>
    </div>
</body>
<script type="text/javascript">
	var $btnExpand = null, $mainTabs = null;
	function hidesidebar(){
		$(this).unbind("click", hidesidebar);
		$(this).bind("click", showsidebar);
		$btnExpand.removeClass("btn_expand_l").addClass("btn_expand_r");
		$(".sidebar").css("marginLeft", "-260px");
		$(".content_p").css("marginLeft", "0px");
	}
	
	function showsidebar(){
		$(this).unbind("click", showsidebar);
		$(this).bind("click", hidesidebar);
		$btnExpand.removeClass("btn_expand_r").addClass("btn_expand_l");
		$(".sidebar").css("marginLeft", "0px");
		$(".content_p").css("marginLeft", "260px");
	}
	
	
	
	function menuLoading(){
		var zTree;  
		var treeNodes; 	
		$.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: "<%=basePath %>/common/menuitem_queryTreeNodes.do",//请求的action路径  
	        error: function () {//请求失败处理函数  
	            alert('菜单加载失败');  
	        },  
	        success:function(data){ //请求成功后处理函数。
	            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
	            nodeLoading(treeNodes);
	            
	        }  
    	});  
	}
	
	function setFontCss(treeId, treeNode) {   
          return treeNode.level == 1 ? {color:"red"} : {};   
    }; 
	
	function nodeLoading(zNodes){	
			var setting = {  
            	check: {  
                	enable: true  
            		},  
            	data: {  
                	simpleData: {  
                    enable: true 
                	}  
            	},
            	callback:{
            		onClick: treeNodeClickHandle
            	}
            	
        	};  
	
		   var zTreeObj = $.fn.zTree.init($("#mainNav"),setting,zNodes);	
		
		}
		function treeNodeClickHandle(e, treeId, treeNode){
			
			if(treeNode.isParent)
				mainNav.expandNode(treeNode);
			else{				
				openLink(treeNode.name, treeNode.targetUrl);
				}
		}
		
		
		function clickEventHandler(event, treeId, treeNode, clickFlag){
			alert("onClick: " + treeId + "," + treeNode.name + "," + clickFlag+ "," + treeNode.id+ "," + treeNode.url);  
		}
	
	   function init(){
	   		var initFunc = nodeLoading();	   		
	   		var initReq = menuLoading();
	   }
	// 子页面调用
	function openLink(o, url){
	    if(url && url != "") {
		    $mainTabs.addTab({
				title: o,
				src: url		
			});
	    }		
	}
	
    $(document).ready(function () {			
		init();  
		$btnExpand = $(".sidebar .btn_expand_l");
		$btnExpand.bind("click", hidesidebar);
		
		$contentArea = $("#content");
		$sidebar = $(".sidebar");
		$mainNav = $("#mainNav");
		
		//自适应高度
		$contentArea.height($(window).height() - $("body .header").height());
		$mainNav.height($contentArea.height() - $sidebar.children(".box_header").height() - $(".searchbar").height());
									
		
    });
	
	$(window).resize(function(e){
		$contentArea.height($(window).height() - $("body .header").height());
		$mainNav.height($contentArea.height() - $sidebar.children(".box_header").height() - $(".searchbar").height());
							
		
	//	$contentArea.autoHeight();
		// $sidebar.height($contentArea.height());
	});
</script>
</html>
