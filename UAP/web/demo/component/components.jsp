<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/head.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><s:text name="组件库" />
		</title>
		<link href="<%=contextPath%>/up/common/css/layout.css" rel="stylesheet" type="text/css" />
		<link href="<%=contextPath%>/up/common/css/css.css" rel="stylesheet" type="text/css" />
	</head>
	<script type="text/javascript">
		function pickedFunc(){
			$dp.$('d523_y').value=$dp.cal.getP('y');
			$dp.$('d523_M').value=$dp.cal.getP('M');
			$dp.$('d523_d').value=$dp.cal.getP('d');
			$dp.$('d523_HH').value=$dp.cal.getP('H');
			$dp.$('d523_mm').value=$dp.cal.getP('m');
			$dp.$('d523_ss').value=$dp.cal.getP('s');
		}
		function clearFunc(){
			$dp.$('d523_y').value='';
			$dp.$('d523_M').value='';
			$dp.$('d523_d').value='';
			$dp.$('d523_HH').value='';
			$dp.$('d523_mm').value='';
			$dp.$('d523_ss').value='';
		}
		
	</script>
	

	
	
	<body>
		<s:form name="formList" id="formList" theme="simple">
			<div class="widgetL">
				<div class="wCenter">
					<div class="content">
						<div class="search2">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th style="width=30%;">
										年月日时分秒格式：
									</th>
									<td style="width=70%;">
										<s:textfield name="param._dnl_actiontime" cssClass="Wdate"
											onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd HH:mm:ss'})"></s:textfield>
									</td>
								</tr>
								<tr>
									<th style="width=30%;">
										调用代码：
									</th>
									<td style="width=70%;">
									WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd HH:mm:ss'})
									</td>
								</tr>
								<tr style="height:20px;">
									<th style="width=30%;">
										&nbsp;
									</th>
									<td style="width=70%;">
										&nbsp;								
									</td>
								</tr>
								<tr>
									<th style="width=30%;">
										年月日格式：
									</th>
									<td style="width=70%;">
										<s:textfield name="param._dnl_actiontime" cssClass="Wdate"
											onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd'})"></s:textfield>
									</td>
								</tr>
								<tr>
									<th style="width=30%;">
										调用代码：
									</th>
									<td style="width=70%;">
									WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd'})
									</td>
								</tr>
								<tr style="height:20px;">
									<th style="width=30%;">
										&nbsp;
									</th>
									<td style="width=70%;">
										&nbsp;								
									</td>
								</tr>
								<tr>
									<th style="width=30%;">
										年月格式：
									</th>
									<td style="width=70%;">
										<s:textfield name="param._dnl_actiontime" cssClass="Wdate"
											onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy年MM月'})"></s:textfield>
									</td>
								</tr>
								<tr>
									<th style="width=30%;">
										调用代码：
									</th>
									<td style="width=70%;">
									WdatePicker({skin:'blue',dateFmt:'yyyy年MM月'})
									</td>
								</tr>
								<tr style="height:20px;">
									<th style="width=30%;">
										&nbsp;
									</th>
									<td style="width=70%;">
										&nbsp;								
									</td>
								</tr>
								
								<tr>
									<th style="width=30%;">
										onpicking与oncleared事件使用 ：
									</th>
									<td style="width=70%;">
									<s:textfield name="param._dnl_actiontime" cssClass="Wdate"
											onfocus="WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:pickedFunc,oncleared:clearFunc})"></s:textfield>
									
									</td>
								</tr>
								<tr>
									<th style="width=30%;">
										
									</th>
									<td style="width=70%;">
									<input type="text" id="d523_y" size="5"/> 年
									<input type="text" id="d523_M" size="3"/> 月
									<input type="text" id="d523_d" size="3"/> 日
								</tr>
								<tr>
									<th style="width=30%;">
										
									</th>
									<td style="width=70%;">
									<input type="text" id="d523_HH" size="3"/> 时
									<input type="text" id="d523_mm" size="3"/> 分
									<input type="text" id="d523_ss" size="3"/> 秒 
																		
									</td>
								</tr>
								<tr>
									<th style="width=30%;">
										调用代码：
									</th>
									<td style="width=70%;">
									WdatePicker({skin:'blue',dateFmt:'yyyy-MM-dd HH:mm:ss',onpicked:pickedFunc,oncleared:clearFunc})
									</td>
								</tr>
								
								
								
								
								
							</table>
						</div>
					</div>
				</div>
			</div>
		</s:form>
	</body>
</html>

