<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>


<%
	String contextPath = request.getContextPath();	
	String filterFlag = (String)request.getAttribute("filterFlag");
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
	//String filterFlag = request.getParameter("filterFlag");
%>
<html>
<head>
<base target="_self"/>
<title><bean:message bundle="Comrescard" key="selectcomid"/></title>
<script type="text/javascript" >
	var contextPath = '<%=contextPath%>';

</script>
<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xtree.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xmlextras.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xloadtree.js"></script>

<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/table.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/xtree.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/button.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/dtree.css" />
</head>
<style>
	.waytree_div {
		width:323px;
		height: 300px;
		overflow: auto;
		padding-left: 20px
	}
	.button_11 {
	border:#000 solid 0px;
	cursor:hand;
	background:url(<%=contextPath%>/images/btnUnify/button_B_2.gif) no-repeat;
	width:40px;
	height:22px;
	text-align:center;
	font-size:12px;
	color:#FFF;
	font-weight:100;
	filter:progid:DXImageTransform.Microsoft.Glow(enabled=false,color=#ffffff,strength=0);
}
</style>
<body>
<html:form action="/resmanage/comidtreefilter.do" styleId="formList" method="post">
<div class="table_div">
			<table class="top_table">
				<tr>
					<td>
						<bean:message bundle="Comrescard" key="selectcomid"/>
					</td>
				</tr>
			</table>
		</div>
	
<div class="table_div">
	     <table width="100%" class="error_text">
       	   <s:Msg />
       </table>	
</div>	
			
<div class="table_div">
			<div class="tree_style" id="tree">
        <script type="text/javascript">
        		var filterFlag = '<%=filterFlag%>';
        		if (filterFlag == null || filterFlag == 'null' || filterFlag==undefined){
        			filterFlag ="";
        		}
        		//filterFlag = encodeURIComponent(filterFlag);
        		//alert(filterFlag);
        		var array = window.dialogArguments;
        		var condition = array[0];
        		if (condition == undefined || condition == null || condition == 'null'){
        			condition ="";
        		}
       			var topChildrenURL = contextPath+"/resmanage/com/comidxml.jsp?filterFlag="+filterFlag+"&condition="+condition+"&function=selectComid&childrenURL=";       			       				
				var tree = new WebFXLoadTree('<bean:message bundle="Comrescard" key="comid"/>',topChildrenURL+contextPath+'/resmanage/com/comidxml.jsp');		
				document.write(tree); 
				if (filterFlag != "")
					tree.expandAllover();
				
        </script>
  </div>
 </div>
 


	<div class="table_div">
			<table class=form_table>
					<tr class="table_style_content">
						<td class="form_table_left">商品标识:</td>
						<td><html:text property="_sk_comid" styleClass="form_input_1x"/></td>
						<td class="form_table_left">商品名称:</td>
						<td><html:text property="_sk_comname" styleClass="form_input_1x"/></td>
						<td class="form_table_left"> 
							<input type="button" class="button_2" value="查询" onclick="query()" title="请输入商品标识或商品名称进行模糊查询!"/> 
						</td>
						<td class="form_table_left"> 
							<input type="button" class="button_2" value="刷新" onclick="fresh()" title="点击刷新商品标识树!"/> 
						</td>
						<td>    
						<%-- <img style="vertical-align:bottom;" src="<%=contextPath%>/images/b_preview.gif" onclick="query();">	--%>	
								<input type="button"
		                           name="btnCancel" 
		                           value="取消" class="button_2" onclick="cancel();">	
						</td>
					</tr>
			</table>
	</div>
</html:form>
</body>	
<script  type="text/javascript">	
	var selecComid = null;
	
	function selectComid(nodeId, nodeName, nodeType) {	
		if (nodeType != "comid" ){
			return ;
		}else {
			if(nodeId  == null || nodeId =="null" || nodeId =="") {			  
			   return ;
			}
			if (nodeId == " "){
				nodeId = "";
				nodeName = "";
			}
			var comIdName = new Array(2);
			comIdName[0] = nodeId;
			comIdName[1] = nodeName;
			window.returnValue = comIdName;		
			window.close();
		}
	}	
	
	function cancel() {
		window.returnValue = null;		
		window.close();
	}
	
	function query(){
		var url = contextPath+"/resmanage/comidtreefilter.do?CMD=comidfilter";
		document.formList.action = url;
		document.formList.submit();
	}
	
	function fresh(){
		if (confirm('注意:只有当通过后台增加或者改变了商品标识时,才需要刷新商品标识树!\n\r\n\r		  确定刷新?\n\r')){
			var url = contextPath+"/resmanage/comidtreefilter.do?CMD=FRESH";
			document.formList.action = url;
			document.getElementById("tree").innerHTML = "正在刷新,请稍候...";
			document.formList.submit();
		}
	}
</script>
</html>