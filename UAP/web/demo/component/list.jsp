<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/inc/head.inc" %>
<script type="text/javascript" src="<%= contextPath %>/lidl/js/init.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>页面标题</title>
</head>

<body>
<s:form name="formList" id="formList" theme="simple">
<div class="widgetL">
	<div class="wCenter"> 
	<div class="content">
	
    <!-- 查询区一 -->
           查询区一:按钮一个时，放在右边。
	<div class="search2">
        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
            <th>标签：</th>
            <td>
 		    <s:textfield name="param._sk_workid" cssClass="textbox"/>
            </td>
            <th>标签：</th>
            <td>
		    <j:selector definition="ACTIONTYPE" name="param._ne_actiontype" cssClass="drawdownlist"/>
            </td>
            <td></td>
            </tr>
            <tr>
            <th>标签：</th>
            <td>
 		    <s:textfield name="param._sk_workid" cssClass="textbox"/>
            </td>
            <th>标签：</th>
            <td>
		    <j:selector definition="ACTIONTYPE" name="param._ne_actiontype" cssClass="drawdownlist"/>
            </td>
            <td></td>
            </tr>
            </tr>
            <tr>
            <th>标签：</th>
            <td>
 		    <s:textfield name="param._sk_workid" cssClass="textbox"/>
            </td>
            <th>标签：</th>
            <td>
		    <j:selector definition="ACTIONTYPE" name="param._ne_actiontype" cssClass="drawdownlist"/>
            </td>
            <td>
            <input type="button" id="btnQuery" name="btnQuery" onmouseover=this.className="bt48" 
             onMouseOut=this.className="bt48_gray" 
            value="查询"  class="bt48_gray" onClick="doQuery();"/>
            </td>
            </tr>
        </table>
	</div>
	
	查询区二:按钮两个以上时，放在下一行，右对齐。
	<div class="search2">
        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
            <th>标签：</th>
            <td>
 		    <s:textfield name="param._sk_workid" cssClass="textbox"/>
            </td>
            <th>标签：</th>
            <td>
		    <j:selector definition="ACTIONTYPE" name="param._ne_actiontype" cssClass="drawdownlist"/>
            </td>
            </tr>
            <tr>
            <th>标签：</th>
            <td>
 		    <s:textfield name="param._sk_workid" cssClass="textbox"/>
            </td>
            <th>标签：</th>
            <td>
		    <j:selector definition="ACTIONTYPE" name="param._ne_actiontype" cssClass="drawdownlist"/>
            </td>
            </tr>
            </tr>
            <tr>
            <th></th>
            <td></td>
            <td align="right" colspan="2">
            <input type="button" id="btnQuery" name="btnQuery"   onmouseover=this.className="bt48" 
             onMouseOut=this.className="bt48_gray" 
            value="查询"  class="bt48_gray" onClick="doQuery();"/>
            <input type="button" id="btnQuery" name="btnQuery"   onmouseover=this.className="bt48" 
             onMouseOut=this.className="bt48_gray" 
            value="清空"  class="bt48_gray" onClick="doQuery();"/>
            </td>
            </tr>
        </table>
	</div>
	
	
	<!-- 查询区二  -->
	查询区三：查询条件全部放在一行。
	<div class="search2">
        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
            <td>
				<s:textfield name="param._sk_workid" cssClass="textbox"/>
	    		<j:selector definition="ACTIONTYPE" name="param._ne_actiontype" cssClass="drawdownlist"/>
				<input style="margin-bottom:5px;" type="button" id="btnQuery" name="btnQuery" onmouseover=this.className="bt48" 
	             onMouseOut=this.className="bt48_gray" 
	            value="<s:text name="button_search"/>"  class="bt48_gray" onClick="doQuery();"/>
            </td>
            </tr>
        </table>
	</div>
	查询区四：查询条件全部放在一行。
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
	
	<!--  -->
	<div class="list_table overflow_scroll"  style="OVERFLOW-Y:HIDDEN; width=100%;">
		<!-- width根据实际的宽度设置如： width=100%、width=2000px -->
        <table width="100%" border="0" cellspacing="0" cellpadding="0" >
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
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
		    <td nowrap align="center">列1值</td>
			<td nowrap align="center">列2值</td>
		    <td nowrap align="center">列3值</td>
		    <td nowrap align="center">列4值</td>
		    <td nowrap align="center">列5值</td>			
			</tr>
			<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
			    <td nowrap align="center">列1值</td>
				<td nowrap align="center">列2值</td>
			    <td nowrap align="center">列3值</td>
			    <td nowrap align="center">列4值</td>
			    <td nowrap align="center">列5值</td>			
			</tr>
        </tbody>
        </table>
                   
    </div>
           没有数据时，需要提示，不能只有标题。引入以下文件即可。
    &lt;script type="text/javascript" src="&lt;%= contextPath %>/lidl/js/init.js"&gt;&lt;/script&gt;
    <div class="list_table overflow_scroll"  style="OVERFLOW-Y:HIDDEN;width:100%;">
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
        </tbody>
        </table>        
    </div>
     多头表格。
     <div class="list_table overflow_scroll"  style="OVERFLOW-Y:HIDDEN;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
          <td rowspan="2" align="center" class="h44">城市</td>
          <td rowspan="2" align="center" class="h44">工单类型</td>
          <td colspan="3" align="center">完成</td>
          <td colspan="3" align="center">未完成</td>
        </tr>
        <tr>
            <td align="center">总计</td>
			<td align="center">超时</td>
		    <td align="center">按时</td>
		    <td align="center">总计</td>
		    <td align="center">超时</td>
		    <td align="center">未超时</td>	
        </tr>
        </thead>
        <tbody>
			<tr align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
		    	<td align="center">全省</td>
                <td align="center">缴费开机</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
			</tr>
			<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
		    	<td align="center">全省</td>
                <td align="center">信用等级调整</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
			</tr>
			<tr align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='';">
		    	<td align="center">全省</td>
                <td align="center">信控停机</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
			</tr>
			<tr class="trbg_2" align="center" onMouseOver="this.className='trbg_1';" onMouseOut="this.className='trbg_2';">
		    	<td align="center">全省</td>
                <td align="center">信用等级调整</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td align="center">&nbsp;</td>
			</tr>
        </tbody>
        </table>        
    </div>
	</div>
	</div>
</div>

</s:form>
</body>
</html>

