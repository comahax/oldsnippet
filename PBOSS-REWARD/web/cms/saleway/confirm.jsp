<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html:html>
<head>
<title>��ѡ��</title>
<script type="text/javascript">
	function doClose(type){
		if (type == 0){
			window.returnValue = "";
		}else {
			var ret = "";
			if (document.formItem.print.checked){
				ret += "1|";
			}else {
				ret += "0|";
			}
			if (document.formItem.sendmsg.checked){
				ret += "1";
			}else {
				ret += "0";
			}
			window.returnValue = ret;
		}
		window.close();
	}
</script>
</head>
<body>
<html:form action="/cms/saleway/saleway.do?CMD=SAVE" styleId="formItem" method="post">
<div class="table_div">
	<table class="form_table">
		<tr>
			<td align="right">
				<div class="field-require">
					<input type="checkbox" name="print"/>
				</div>
			</td>
			<td nowrap width="25%" align="left" class="form_table_left">
				�Ƿ��ӡ����
			</td>
			<td align="right">
				<div class="field-require">
					<input type="checkbox" name="sendmsg"/>
				</div>
			</td>
			<td nowrap width="25%" align="left" class="form_table_left">
				�Ƿ��Ͷ���֪ͨ
			</td>
		</tr>
	</table>
</div>
<div class="table_div">
	<table class="table_button_list">
		<tr>
			<td>
				<input type="button" onmouseover="buttonover(this);"
					onmouseout="buttonout(this);" name="btnSave"
					onfocus="buttonover(this)" onblur="buttonout(this)"
					value="ȷ��"
					class="button_2"
					onclick="doClose(1)" />
				<input type="button" onmouseover="buttonover(this);"
					onmouseout="buttonout(this);" name="btnReturn"
					onfocus="buttonover(this)" onblur="buttonout(this)"
					value="ȡ��"
					class="button_2"
					onclick="doClose(0)">
			</td>
		</tr>
	</table>
</div>
</html:form>
</body>
</html:html>