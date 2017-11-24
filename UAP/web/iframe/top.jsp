<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%@ page  import="com.sunrise.jop.infrastructure.db.DBAccessUser"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
	
	String refreshTheme = request.getParameter("refreshTheme");
	String oldTheme = request.getParameter("oldTheme");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>top</title>
<script type="text/javascript" src="../js/base.js"></script>

	
<script>	
	 function changeSubFramesTheme( ffm,themeName, depth ) {	
	    if( !ffm || !ffm.document)
	        return ;	
		if( ffm.frames && ffm.frames.length > 0 )  //if it's sub window ,i.e frame
		{
		    depth++;
			 if( depth >6 ) {
				alert("depth too large! exit.");
				return ;
			 }

			for( i=0 ; i< ffm.frames.length  ; i++ )  { 				
			  if( ffm.frames[i] )				    
				 changeCss( ffm.frames[i],themeName, depth);
			}

		}
	
		var iframes = ffm.document.getElementsByTagName("iframe");
		if( iframes && iframes.length >0) {			   
			for( i=0 ; i< iframes.length  ; i++ )  { 				
			  if( iframes[i] ) {						  
				     changeCss( iframes[i],themeName, depth);
			  }
			}
		}
	 }

   	 function changeCss( fm, themeName ) {		  
	    if(!fm || !fm.document )  {
			alert("error : frame or frame.document object is empty ! Can't change style!");
			return ;
		}
		
		var depth =0;
		
		if( fm.frames ) {
			changeSubFramesTheme( fm, themeName, depth );
		}		
		alert("frame " + fm.name);
   	 	var csslinks = fm.document.getElementsByTagName("link");    	
		
        var i=0 ;
   	 	for( i=0 ; i< csslinks.length ; i++ )  {    	 	  
   	 	   var csslink = csslinks[i];

   	 	   if( csslink.type.toLowerCase().indexOf("css") < 0 ) {
   	 	     alert("continue" + csslink.type);
   	 	     continue;
   	 	   }
		
 	       if(csslink.href  && csslink.href != null &&  csslink.href.indexOf(oldTheme) >-1 ) {  //change current 
			   if( csslink.href.indexOf(themeName) > -1) {
				   alert("current css path include new theme name " + themeName);
				   return ;
				}
			    csslink.href = csslink.href.replace( oldTheme, themeName );	 
			
 	   	   	}
   	 	}
   	 }		 
</script>

<script>
		var oldTheme = "<%=oldTheme%>";
		var currentTheme = "<%=currentTheme%>";
		var refreshTheme = "<%=refreshTheme%>";
		
		function changeFrameThemeMain( themeName) {	
		   
		    if(!("true"== refreshTheme )) {
		        //alert();
			    return ;
		    }
		    	
		    		
			changeCss( top.topFrame, themeName);	
			changeCss( top.leftFrame, themeName);
			changeCss( top.mainmenu, themeName);
			changeCss( top.mainFrame, themeName);
			changeCss( top.bottomFrame, themeName);		
			//last, save new as old
			oldTheme = themeName;
		 }	 
</script>


<link href="<%= contextPath %>/css/<%=currentTheme%>/top.css" rel="stylesheet" type="text/css" />
</head>
<%
	DBAccessUser user = (DBAccessUser) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
	String oprcode = user!=null ? user.getOprcode() : "Invalid ExamUser";
	//String ip = user!=null ? user.getIp() : "Unkown IP";
	//String loginTime = user!=null && user.getLogintime() != null ? String.valueOf(user.getLogintime()) : "";
 %>
<body  leftmargin="0" topmargin="0" bottommargin="0" onload="resizwindow()">
<form name="mainForm" method="post">
<div class="bj">
<div class="top_left"></div>
<div>
	<div class="top_yonghu"><%=oprcode%></div>
	<div class="top_yonghu"><a href="<%=contextPath%>/logout.do" target="_top">注销</a> </div>
	
</div>
</form>
<script>
  changeFrameThemeMain(currentTheme);
</script>
</body>
</html>
