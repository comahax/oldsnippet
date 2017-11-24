<%@ page language="java" contentType="application/x-msdownload;charset=GBK" %>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc" %>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=充值卡库存统计.xls";
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
  
  <body>
 	
 	<table>
 	<tr><td colspan="4"> 导出工号：${USER.oprcode}</td></tr>
 	<tr><td colspan="4"> 导出时间：<%=nowDate%></td></tr>
 	</table>
    <table border=1 bordercolor=#A8A8A8>
            <tr >
               <td>
                    <s:text name="countyid"/>             
                </td>
                <td>
                    <s:text name="wayid"/>                
                </td>
                <td>
                    <s:text name="comcategory"/>                
                </td>
                <td>
                    <s:text name="comstate"/>                
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
					<s:if test="comcategory != ''">
					<td rowspan="<s:property value="comcateCount"/>"> <j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
					</s:if>
					<td> <j:code2Name definition="$FX_COMSTATE" code="comstate"/></td>	
					<td><s:property value="ncount"/> </td>					
                 </tr>
             </s:iterator>   
             <tr class="table_style_content" align="center">
             <td><s:text name="total"/></td><td colspan="3" ></td><td><s:property value="dp.rowCount"/></td>
             </tr>
        </table>
</html>
