<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>

<%
	String definition = (String) request.getAttribute("DEFINITION");
	String splitChar = (String) request.getAttribute("SPLITCHAR");
%>
<html>
	<head>
		<title>多项选择框</title>
		<base target="_self" />
		<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function addItem() {
			var elm1 = document.all("s1");  
			var elm2 = document.all("s2");
	
			var addValue = '';
			var addHtml = '';
			for (var i=elm1.length-1;i>-1;i--) {
				op = elm1.options[i];
				if (op.selected)  {
					addValue = op.value;
					addHtml = op.innerHTML;
					break;
				}
			}
	
			var repeat = false;
			for (var i = 0; i < elm2.length; i++) {
				if(elm2.options[i].value == addValue) {
					repeat = true;
					break;
				}
			}
	
			if (!repeat && addValue != '') {
				elm2.options[elm2.length] = new Option(addHtml, addValue);
			}
        }
        
        function addAllItem() {
			var elm1 = document.all("s1");  
			var addValue = '';
			var addHtml = '';
			for (var i=0; i<elm1.length; i++) {
				addValue = elm1.options[i].value;
				addHtml = elm1.options[i].innerHTML;
				var elm2 = document.all("s2");
				var repeat = false;
				for (var j=0; j<elm2.length; j++) {
					if(elm2.options[j].value == addValue) {
						repeat = true;
						break;
					}
				}
				if (!repeat && addValue != '' && addValue != '...') {
					elm2.options[elm2.length] = new Option(addHtml, addValue);
				}
			}
        }
        
        function outItem() {
			var elm2 = document.all("s2");
			for (var i=elm2.length-1;i>-1;i--) {
				opo = elm2.options[i];  
				if (opo.selected)  {
					elm2.options[i]=null; 
				}
			}
        }
        
        function outAllItem() {
			var elm2 = document.all("s2");
			for (var i=elm2.length-1;i>-1;i--) {
				elm2.options[i] = null;
			}
        }
        
        function doQuery() {
			var theURL = '/commons/multiselect.do?CMD=LIST' + 
				'&DEFINITION=' + '<%=definition%>';
        	ajaxAnywhere.submitByURL(theURL);
        }
		
		window.returnValue = '';
		function doConfirm() {
			var ret = '';
			elm2 = document.all("s2");
			
			//代理商多选特殊处理
			if ('AgentMultiselect' == '<%=definition%>') {
				for (var i=0; i<elm2.length; i++) {
					if (i == 0) { //开头补逗号
						ret = '<%=splitChar%>';
					}
					if ('0' == elm2.options[i].value) {
						ret = '<%=splitChar%>' + '0' + '<%=splitChar%>';
						break;
					} else {
						ret = ret + elm2.options[i].value + '<%=splitChar%>';
					}
				}
			} else {
				for (var i=0; i<elm2.length; i++) {
					ret = ret + elm2.options[i].value + '<%=splitChar%>';
				}
			}
			
			if (ret.length == 0) {
				ret = 'BLANK';
			}
			window.returnValue = ret;
			window.close();
		}
    	</script>
	</head>

	<body>
		<html:form action="/commons/multiselect.do?CMD=SHOW" styleId="formItem" method="post" target="hidden_frame"
			enctype="multipart/form-data">
			<iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
			<div class="table_div">
				<table width="100%" class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>
			<div class="table_container">
				<div class="table_div">
					<table class="table_style">
						<tr class="table_style_content">
							<td align="left" width="30%">
								编码:
								<html:text styleClass="form_input_1x" property="code" />
							</td>
							<td align="left" width="30%">
								名称:
								<html:text styleClass="form_input_1x" property="name" />
							</td>
							<td align="left" width="40%">
								<input type="button" value="查询" style="width:50px;height:20px;background-color:#ffffff" " onclick="doQuery()" />
							</td>
						</tr>
					</table>
					<table class="table_style">
						<tr class="table_style_content">
							<td align="left" width="40%" colspan="4">
								可选项
							</td>
							<td align="left" width="20%" colspan="2">
								&nbsp;
							</td>
							<td align="left" width="40%" colspan="4">
								已选项
							</td>
						</tr>
						<tr class="table_style_content">
							<td align="left" width="40%" colspan="4">
								<aa:zone name="zoneSource">
									<select name=s1 id=s1 class="multi" size=20 style="width:280px;height:180px;">
										<c:forEach var="item" items="${requestScope.COLLECTION_SOURCE}" varStatus="id">
											<option value=<c:out value="${item.code}"/>>
												<c:out value="${item.name}" />
											</option>
										</c:forEach>
									</select>
								</aa:zone>
							</td>
							<td align="left" width="20%" colspan="2">
								<br />
								<input type="button" value=">" style="width:50px;height:20px;background-color:#ffffff" onclick="addItem()" />
								<br />
								<input type="button" value=">>" style="width:50px;height:20px;background-color:#ffffff" onclick="addAllItem()" />
								<br />
								<br />
								<input type="button" value="<" style="width:50px;height:20px;background-color:#ffffff" onclick="outItem()" />
								<br />
								<input type="button" value="<<" style="width:50px;height:20px;background-color:#ffffff" onclick="outAllItem()" />
								<br />
							</td>
							<td align="left" width="40%" colspan="4">
								<aa:zone name="zoneExist">
									<select name=s2 id=s2 class="multi" size=20 style="width:280px;height:180px;">
										<c:forEach var="item" items="${requestScope.COLLECTION_EXIST}" varStatus="id">
											<option value=<c:out value="${item.code}"/>>
												<c:out value="${item.name}" />
											</option>
										</c:forEach>
									</select>
								</aa:zone>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align="center" width="100%" colspan="10">
								<input type=button value="确定" onclick="doConfirm()" class="comfir">
								<input type=button value="关闭" onclick="window.close();" class="comfir">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</html:form>
	</body>
</html>
