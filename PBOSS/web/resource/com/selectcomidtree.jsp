<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<%
	String filterFlag = (String) request.getAttribute("filterFlag");
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<html>
	<head>
		<base target="_self" />
		<title>ѡ����Ʒ��ʶ</title>
		<script type="text/javascript">
			var contextPath = '<%=contextPath%>';
			
       	function ev_check() {
        	addfield('param._ne_comid','<s:text name="comid"/>', 'd', true, 18);
        	addfield('param._sk_comname','<s:text name="comname"/>', 'c', true, 50);
        	
            return checkval(window);
        }
		</script>
		<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xtree.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xmlextras.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xloadtree.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xloadtree.extend.js"></script>

		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/xtree.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/dtree.css" />
	</head>
	
	<body>
		<s:form action="comtree_list.do" key="formList" method="post"
		theme="simple" onsubmit="return ev_check();">

			<div class="error_text">
				<table class="error_text">
					<s:actionerror />
					<s:actionmessage />
				</table>
			</div>

			<div class="table_div">
				<div class="tree_style" id="tree">
					<script type="text/javascript">
	        		var filterFlag = '<%=filterFlag%>';
	        		if (filterFlag == null || filterFlag == 'null' || filterFlag==undefined){
	        			filterFlag ="";
	        		}
	        		var array = window.dialogArguments;
	        		var condition = array[0];
	        		
	        		if (condition == undefined || condition == null || condition == 'null'){
	        			condition ="";
	        		}
	       			var topChildrenURL = contextPath+"resource/com/comidxml.jsp?filterFlag="+filterFlag+"&condition="+condition+"&function=selectComid&childrenURL=";
					var tree = new WebFXLoadTree('��Ʒ��ʶ',topChildrenURL+contextPath+'/resource/com/comidxml.jsp');		
					document.write(tree); 
					if (filterFlag != "")
						tree.expandAllover();
	        		</script>
				</div>
			</div>

			<div class="table_div">
        		<table class="table_normal">
					<tr>
						<td align="center">
							��Ʒ��ʶ:
						</td>
						<td>
							<s:textfield cssStyle="style_input" name="param._ne_comid" />
						</td>
						<td align="center">
							��Ʒ����:
						</td>
						<td>
							<s:textfield cssStyle="style_input" name="param._sk_comname" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<input type="button" class="button_Query" value="��ѯ"
								onclick="query()" title="��������Ʒ��ʶ����Ʒ���ƽ���ģ����ѯ!" />
							<input type="button" class="button_2" value="ˢ��"
								onclick="fresh()" title="���ˢ����Ʒ��ʶ��!" />
						</td>
					</tr>
				</table>
			</div>
		</s:form>
	</body>
	<script type="text/javascript">	
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
			var comIdName = new Array(1);
			comIdName[0] = nodeId;
			comIdName[1] = nodeName;
			window.returnValue = comIdName;		
			window.close();
		}
	}	
	
	function query(){
		var url = contextPath+"/resource/comtree_comidfilter.do";
		document.formList.action = url;
		document.formList.submit();
	}
	
	function fresh(){
		if (confirm('ע��:ֻ�е�ͨ����̨���ӻ��߸ı�����Ʒ��ʶʱ,����Ҫˢ����Ʒ��ʶ��!\n\r\n\r		  ȷ��ˢ��?\n\r')){
			var url = contextPath+"/resource/comtree_fresh.do";
			document.formList.action = url;
			document.getElementById("tree").innerHTML = "����ˢ��,���Ժ�...";
			document.formList.submit();
		}
	}
</script>
</html>
