<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/head.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<%=contextPath%>/up/common/css/form.css" rel="stylesheet" type="text/css" />
		<title><s:text name="组件库" />
		</title>
		
	</head>

	
	
	<body style="background: #ebf2f8;">
		<s:form name="formList" id="formList" theme="simple">
			
		<div class="widgetL">
			<label class="form_item">
				<span class="title">账期：</span>
				<input class="field" type="text" onClick="WdatePicker({skin:'blue',dateFmt:'yyyy年MM月'})">
			</label>
			<label class="form_item">
				<span class="title">账期：</span>
				<select name="" class="field">
					<option value="">dddddd</option>
					<option value="">dddddd</option>
				</select>
			</label>
		</div>
		
		</s:form>
	</body>
</html>

