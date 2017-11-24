<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="aa" uri="http://ajaxanywhere.sourceforge.net/" %>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<html>
<head>

<script type="text/javascript" src="<%= contextPath %>/js/dtree.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/cookies.js"></script>

<script type="text/javascript" src="<%= contextPath %>/js/jquery-1.7.min.js"></script>
<link href="<%= contextPath %>/css/default/dtree.css" rel="stylesheet" type="text/css">


</head>
<body leftmargin="0" topmargin="0" rightmargin="0">
<s:form name="formList" id="formList" action="/common/menuitem_queryTreeNodes.do" theme="simple">

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td width="100%" height="100%" align='left' valign='top'>   
    <div class="dtree" >
      <script type="text/javascript">      
         tree = new dTree('tree');               
         var target = 'top.maintop'; 
         var frame = top.mainFrame;             
         $.ajax({
				type: "post",
				dataType: "xml", 
				url: "<%= contextPath %>/common/menuitem_queryTreeNodes.do",
				error: function(){
				   alert("加载菜单引发错误..");
				},
				async: false ,//同步方式
				success: function(data){
					$(data).find("node").each(function(){						
					
						var name = $(this).find("menuName").text();
						var pid = $(this).find("menuPid").text();
						var id = $(this).find("menuId").text();
						var url = $(this).find("guiObject").text();
						
						//var name = $(this).attr("menuName");
						//var pid = $(this).attr("menuPid");
						//var id = $(this).attr("menuId");
						//var url = $(this).attr("guiObject");						
						var href = ""; 
				
						if(url && url !=''){						 						 
						 url = '<%=contextPath%>' + url;
						 if(url.indexOf('http') != -1) url = url.substring(4,url.length);// 针对嵌入菜单处理
						 href = "javascript:setlocation('"+name+"','"+url+"',frame)";
						 target ='';
						}						
						//tree.add(id,pid,name,"javascript:setlocation(\'"+name+"\',\'"+url+"\',frame)","",target);	
						tree.add(id,pid,name,href,"",target);						
				
					});					
				}
			}); 			

			document.write(tree);		   

        </script>
        
    </div></td>
  </tr>
</table>
</s:form>
</body>
</html>