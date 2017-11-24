<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头
%>
<%@ include file="/inc/contenthead.inc"%>


<html>
<head>
	<base target="_self">
	<title>导出选项</title>
</head>
<body>
			<div class="table_container">
				<table class="top_table">
					<tr>
						<td>
							导出选项
						</td>
					</tr>
				</table>
			
			   <select style="width:150px;height:150px" ID="oSelect" name="city">
				  <option value='GZ' ID='200'>广州</option>
				  <option value='SZ' ID='755'>深圳</option>
				  <option value='ZH' ID='756'>珠海</option>
				  <option value='FS' ID='757'>佛山</option>
				  <option value='ST' ID='754'>汕头</option>
				  <option value='HZ' ID='752'>惠州</option>
				  <option value='ZJ' ID='759'>湛江</option>
				  <option value='JM' ID='750'>江门</option>
				  <option value='ZQ' ID='758'>肇庆</option>
				  <option value='SG' ID='751'>韶关</option>
				  <option value='MZ' ID='753'>梅州</option>
				  <option value='DG' ID='769'>东莞</option>
				  <option value='ZS' ID='760'>中山</option>
				  <option value='MM' ID='668'>茂名</option>
				  <option value='SW' ID='660'>汕尾</option>
				  <option value='CZ' ID='768'>潮州</option>
				  <option value='JY' ID='663'>揭阳</option>
				  <option value='YJ' ID='662'>阳江</option>
				  <option value='QY' ID='763'>清远</option>
				  <option value='HY' ID='762'>河源</option>
				　<option value='YF' ID='766'>云浮</option>
			</select>
<br>
		<input type="radio" name="filetype" value="total" checked>汇总
		<input type="radio" name="filetype" value="net">分网点
		<br>
			<input type=button class="button_5"  onmouseover="buttonover(this);" 
				onmouseout="buttonout(this);" onfocus="buttonover(this)" 
				onblur="buttonout(this)"  value="确定"
				onclick="getValue()">
				
			<input type=button class="button_5"  onmouseover="buttonover(this);" 
				onmouseout="buttonout(this);" onfocus="buttonover(this)" 
				onblur="buttonout(this)"  value="取消"
				onclick="cancel()">
			</div>
</body>
<SCRIPT>
 function getValue()
 {
 	var ip="";
　　var rPort = document.all.filetype;
　　for(i=0;i<rPort.length;i++)
　　{
     　　if(rPort[i].checked)
       　　ip=rPort[i].value;
　　}
 	var code="";
	code=code+"FILETYPE="+ip+"&CITY="+document.all("city").value;
	self.returnValue = code;
	self.close();
 }
 function cancel()
 {
 	self.close();
 }
</SCRIPT>
	
</html>
