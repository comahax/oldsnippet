<%@ page language="java" contentType="application/x-msdownload;charset=GBK" %>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc" %>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=合作商销量.xls";
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
                    <s:text name="countyid"/>               
                </td>
                <td>
                    <s:text name="mareacode"/>               
                </td>
                <td>
                    <s:text name="starlevel"/>               
                </td>
                <td>
                    <s:text name="wayid"/>               
                </td>
                <td>
                    <s:text name="wayname"/>               
                </td>
                <td>
                   <s:text name="salesstd"/>                
                </td>
                <td>
                    <s:text name="salescount"/>              
                </td> 
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" >
                    <td>
                     <j:code2Name code="countyid" definition="#CNTYCOMPANY" />
                     </td>
                     <td>
                     <j:code2Name code="mareacode" definition="#MICROAREA" />
                     </td>
                     <td>                     
                     <j:code2Name code="starlevel" definition="$CH_STARLEVEL" />
                     </td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="wayname" /></td>
                     <td><s:property value="salesstd" /></td>
                     <td><s:property value="salescount" /></td>	
                 </tr>
             </s:iterator>   
            
        </table>

  </body>
</html>
