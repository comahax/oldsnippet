<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><bean:message bundle="public" key="changednumtitle" /></title>
		<meta http-equiv="content-type" content="text/html; charset=GBK">
	</head>
	<body>
	<form id="form1">
	<input type="hidden" id="num" value="<c:out value='${requestScope.LIST.rowCount}'/>">
	<div align="center">
		<table class="table_style" ID="Table2">
			<tr class="table_style_head">
				<td>
					<bean:message bundle="public" key="label_servnumber" />
				</td>
				<td>
					<bean:message bundle="public" key="label_custid" />
				</td>
				<td>
					<bean:message bundle="public" key="label_userid" />
				</td>
				<td>
					<bean:message bundle="public" key="label_acctid" />
				</td>
			</tr>
			<c:forEach var="item" items="${requestScope.LIST.datas}">
			<tr class="table_style_content" align="center">
				<td>
					<c:out value="${item.servnumber}"/>
				</td>
				<td name="custid" onclick="javascript:returnSelected(this);" style="cursor:hand;">
					<c:out value="${item.custid}"/>
				</td>
				<td name="subsid" onclick="javascript:returnSelected(this);" style="cursor:hand;">
					<c:out value="${item.subsid}"/>
				</td>
				<td name="acctid" onclick="javascript:returnSelected(this);" style="cursor:hand;">
					<c:out value="${item.acctid}"/>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</form>
	<script type="text/javascript">
		var num = document.getElementById("num").value;
		var target = window.dialogArguments;
		if(num==""||num=="0"){
			window.returnValue= "-1";
			window.close();
		}else if(num=="1"){
			var start = target.lastIndexOf("_");
			var end = target.length;
			var tmpStr = target.substring(start+1,end);
			var tds = document.getElementsByTagName("td");
			var tmpObj;
			for(var i = 0; i < tds.length; i++){
				if(tds[i].name==tmpStr){
					tmpObj = tds[i];
					break;
				}
			}
			window.returnValue= tds[i].innerHTML;
			window.close();
		}
		function returnSelected(obj){
			if(target.indexOf(obj.name)!=-1){
				window.returnValue=obj.innerHTML;
				window.close();
			}else{
				alert('<bean:message bundle="public" key="alert_tips" />');
			}
		}
	</script>
	</body>
</html>
