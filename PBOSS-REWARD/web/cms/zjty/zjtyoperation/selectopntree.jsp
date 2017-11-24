<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>

<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";
 
	String rootAdaId = (String) request.getAttribute("rootAdaId");
	String rootName = (String) request.getAttribute("rootName");
	String topChildrenURL = (String) request
			.getAttribute("topChildrenURL");
	String topAction = (String) request.getAttribute("topAction");
	String text = (String) request.getAttribute("text");
	String skname=(String)session.getAttribute("_sk_name");
	String neopnid=(String)session.getAttribute("_ne_opnid");
	
	String style=request.getParameter("style")==null?"":request.getParameter("style");
	String city=request.getParameter("city")==null?"":request.getParameter("city");
%>
<html>
	<head>
		<base target="_self" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<title>ѡ��ҵ������</title>
		<script type="text/javascript">
	var contextPath = '<%=contextPath%>';
</script>
		<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/xloadtree/xtree.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/xloadtree/xmlextras.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/xloadtree/xloadtree.js"></script>

		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/table.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/xtree.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/button.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/dtree.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/form.css" />
	</head>
	<style>
	.waytree_div { 
		width:323px;
		height: 300px;
		overflow: auto;
		padding-left: 20px
	}
</style>
	<body>
		<html:form action="/cms/zjty/operation.do?CMD=Selectopntree" styleId="formList"
			method="post">
			<input type="hidden" name="style" value="<%=style%>">
			<input type="hidden" name="city" value="<%=city%>">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							ѡ��ҵ������
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
				<div class="tree_style">
					<script type="text/javascript">       	
			var topChildrenURL = "<%=topChildrenURL%>";  		
        	var skname="<%=skname%>";
        	var neopnid="<%=neopnid%>";
			<%if(rootAdaId!=null) { 
			%>	
				var tree = new WebFXLoadTree("<%=rootName%>",topChildrenURL,<%=topAction%>);
			<% }else { } 
			%>
				document.write(tree);
        </script>
				</div>
			</div>
			<div class="table_div">	
			<table class="table_button_list">
					<tr>
						<td>
							<nobr>&nbsp;&nbsp;��ʾʧЧҵ��</nobr>
						</td>
						<td>
							<html:checkbox property="showendopn" styleClass="null" title="ѡ�п�����ʾʧЧ��ҵ��" onclick="query();"/> 
						</td>
						<td  width="100%">
							ҵ������:<html:text property="_sk_name" title="������ҵ�����ƽ���ģ����ѯ��"/>           
							<img style="vertical-align:bottom;" src="<%=contextPath%>/images/b_preview.gif" onclick="query();">	
			                
						    ҵ�����:<html:text property="_se_opnid" title="������ҵ�������в�ѯ��"/>           
							<img style="vertical-align:bottom;" src="<%=contextPath%>/images/b_preview.gif" onclick="query();">	
							
							<input type="button" style="display: none" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnCancel" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="����" class="submit" onclick="exportWays();">	
		                           
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnCancel" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="�ر�" class="submit" onclick="cancel();">	
						</td>
					</tr>
			</table>

		</div>
		</html:form>
	</body>
	<script type="text/javascript">
	var inValue = null;
	
	function initParam() {
		var args = window.dialogArguments;	
		if(args==null) return false;
		
		var inputBox = args;		
		inValue = inputBox.value;
	}	
</script>
	<script type="text/javascript">
	initParam();
	//tree.WebFXTree.getFirst().tree.WebFXTree.expand();
	
	
</script>
	<script type="text/javascript">	
	var selectwayid = null;
	
	function selectOpn(nodeId, nodeName, nodeType) {	
		var opnIdName = new Array(2);
		if(nodeId  == null || nodeId =="null" || nodeId =="") {
		   return ;
		} 
		if(nodeType == "operation") {
			if(nodeId  == null || nodeId =="null" || nodeId =="") {			  
			   return ;
			}
			opnIdName[0]=nodeId;
			opnIdName[1]=nodeName;
			window.returnValue = opnIdName;		
			window.close();			
		}else {
			//donothting;
		}
	}
	
	function cancel() {
		window.returnValue = null;		
		window.close();
	}
	
	function query() {	
		document.formList.submit();
	}
</script>

</html>
