<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/inc/head.inc" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>页面标题</title>
<link href="<%=contextPath%>/up/common/css/innerpage.css" rel="stylesheet" type="text/css" />
<link href="<%=contextPath%>/up/common/css/form.css" rel="stylesheet" type="text/css" />
</head>

<body>
<s:form  name="formList" id="formList" theme="simple">
<div class="widgetN">

    <font color="red">嵌套页面第二层START</font>
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
	
    
    <div class="search2">
        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
            <td>
 		    <div class="form_item">
				<span class="title">账期：</span>
				<s:textfield cssClass="input_field" name="param._ne_validbillcyc" id="validbillcyc" readonly="true" onfocus="WdatePicker({skin:'blue',dateFmt:'yyyyMM'})"></s:textfield>
			</div>
			<!-- 下面手工设置标签的长度<div class="input_div" style="width: 160px;">，默认是150px； -->
			<div class="form_item">
				<input type="checkbox"  class="table_checkbox left" name="param.checkCity" value="1" onclick="doQuery(this.form)"  <s:if test="param.checkCity == 1"> checked </s:if>/>
				<span class="title">对端地市</span>
				<j:selector definition="CITYID" cssClass="select_field" cssStyle="width:70px" name="param._se_city"/>
			</div>
			
			
			<div class="form_item" style="width: 160px;">
				<span class="title">下拉框：</span>
				<j:selector definition="ACTIONTYPE" cssClass="select_field" name="param._ne_actiontype"/>
			</div>
			<input type="button" id="btnQuery" name="btnQuery"   onmouseover=this.className="bt48" 
             onMouseOut=this.className="bt48_gray" 
            value="<s:text name="button_search"/>"  class="bt48_gray" onClick="doQuery();"/>
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
    <font color="red">嵌套页面第二层END</font>
</div>
</s:form>
</body>
</html>

