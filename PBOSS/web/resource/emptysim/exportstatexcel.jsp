<%@ page language="java" contentType="application/x-msdownload;charset=GBK" %>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc" %> 
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=空白SIM卡资源查询.xls";
			response.setHeader("Content-Disposition", new String(
					fn.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("application/x-msdownload");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = format.format(new Date());
		
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body >
 	   
 	
 	<table  style="font-size:13;">
 	<tr><td colspan="4"> 导出工号：${USER.oprcode}</td></tr>
 	<tr><td colspan="4"> 导出时间：<%=nowDate%></td></tr>
 	</table>
    <table border=1  style="font-size:13;">
            <tr >
               <td>
                    <s:text name="countyid"/>             
                </td>
                <td>
                    <s:text name="wayid"/>                
                </td> 
                <td>
                    <s:text name="usestate"/>                
                </td>
                <td>
                    <s:text name="ncount"/>                
                </td>              
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" >					
					<s:if test="countyid != ''">
					<td rowspan="<s:property value="countyCount"/>"> <j:code2Name definition="#CNTYCOMPANY" code="countyid"/> </td>
					</s:if>
					<s:if test="wayid != ''">
					<td rowspan="<s:property value="wayCount"/>"> <j:code2Name definition="#WAYIDINFO" code="wayid"/> </td>
					</s:if> 
					<td> <j:code2Name definition="$FX_COMSTATE" code="usestate"/></td>	
					<td><s:property value="ncount"/> </td>					
                 </tr>
             </s:iterator>   
             <tr class="table_style_content" align="center">
             <td colspan="3"><s:text name="total"/></td><td><s:property value="dp.rowCount"/></td>
             </tr>
        </table>
        </body>
        
</html>
