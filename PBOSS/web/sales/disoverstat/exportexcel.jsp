<%@ page language="java" contentType="application/x-msdownload;charset=GBK" %>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc" %>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=配送单超时预警统计明细.xls";
			response.setHeader("Content-Disposition", new String(
					fn.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("application/x-msdownload");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = format.format(new Date());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base >
    
    
  </head>
  
  <body>
	<table>
 	<tr><td colspan="5"> 导出工号：${USER.oprcode}</td></tr>
 	<tr><td colspan="5"> 导出时间：<%=nowDate%></td></tr>
 	</table>
        <table border=1 bordercolor=#A8A8A8>
            <tr class="table_style_head">
                <td>
                   序号  
                </td>
                <td>
                    分公司                 
                </td>
                <td>
                    微区域                 
                </td>
                <td>
                    统计日期                 
                </td>
                <td>
                    超时时间(小时)                 
                </td>
                <td>
                   订单号                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                   
                     <td>
							<s:property value="seqid"/>
					 </td>
					<td>
						<j:code2Name code="form.countyid" definition="#CNTYCOMPANY" />
					</td>
					<td>
						<j:code2Name code="form.mareacode" definition="#MICROAREA" />
					</td>
					<td>
						<s:date name="form.statdate" format="yyyy-MM-dd" />
					</td>
                     <td><s:property value="overhour" /></td>
                     <td><s:property value="orderid" /></td>
                 </tr>
             </s:iterator>
        </table>

  </body>
</html>
