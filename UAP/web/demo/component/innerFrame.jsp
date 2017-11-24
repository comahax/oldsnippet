<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/inc/head.inc" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=contextPath%>/up/common/css/form.css" rel="stylesheet" type="text/css" />
<title>页面标题</title>
</head>

<body>
<s:form  name="formList" id="formList" theme="simple">
<div class="widgetL">
<div class="wCenter"> 
<div class="content">
	<br />
	代码：&lt;iframe src="&lt;%=basePath %>demo/component/innerFrame1-1-1.jsp"  onload="resetAllWinHeight(this)"  width="100%" height="250" frameborder="0" scrolling="no">&lt;iframe&gt;
	<br /><br /><br />
	<font color="green">主界面，START.</font>
	<iframe onload="resetAllWinHeight(this)" src="<%=basePath %>demo/component/innerFrame1-1.jsp" width="100%" height="10" frameborder="0" scrolling="no"></iframe>
	<div class="search2">
        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
            <th>标签：</th>
            <td>
 		    <s:textfield name="param._sk_workid" cssClass="textbox" />
            </td>
            <th>标签：</th>
            <td>
		    <j:selector definition="ACTIONTYPE" cssClass="drawdownlist" name="param._ne_actiontype" theme="simple"/>
            </td>
            <td></td>
            </tr>
            <tr>
            <th>标签：</th>
            <td>
 		    <s:textfield name="param._sk_workid" cssClass="textbox" />
            </td>
            <th>标签：</th>
            <td>
		    <j:selector definition="ACTIONTYPE" cssClass="drawdownlist" name="param._ne_actiontype" theme="simple"/>
            </td>
            <td></td>
            </tr>
            </tr>
            <tr>
            <th>标签：</th>
            <td>
 		    <s:textfield name="param._sk_workid" cssClass="textbox" />
            </td>
            <th>标签：</th>
            <td>
		    <j:selector definition="ACTIONTYPE" cssClass="drawdownlist" name="param._ne_actiontype" theme="simple"/>
            </td>
            <td>
            <input type="button" id="btnQuery" name="btnQuery"   onmouseover=this.className="bt48" 
             onMouseOut=this.className="bt48_gray" 
            value="查询"  class="bt48_gray" onClick="doQuery();"/>
            </td>
            </tr>
        </table>
	</div>
	
	
    
    <div class="list_table overflow_scroll"  style="OVERFLOW-Y:HIDDEN;">
		<!-- width根据实际的宽度设置如： width=100%、width=2000px -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <td nowrap align="center">列1标题</td>
			<td nowrap align="center">列2标题</td>
		    <td nowrap align="center">列3标题</td>
		    <td nowrap align="center">列4标题</td>
		    <td nowrap align="center">列5标题</td>	
        </tr>
        </thead>
        <tbody>
			<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
		    <td nowrap align="center" colspan="5">没有符合查询条件的记录！</td>		
			</tr>
        </tbody>
        </table>
                   
    </div>
   <font color="green">主界面，END.</font>
</div>
</div>
</div>
</s:form>
</body>
</html>

