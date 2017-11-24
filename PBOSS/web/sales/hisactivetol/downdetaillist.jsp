<%@ page language="java" contentType="application/x-msdownload;charset=GBK" %>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc" %>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=合作商销量.txt";
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
         <table class="table_style">
            <tr class="table_style_head">
                <td>
                    序号
                </td>
                <td>
                    合作商编码     
                </td>
                 <td>
                    合作商名称                 
                </td>
                <td>
                    品牌             
                </td>
                <td>
                     号码                
                </td>
                <td>
                    激活时间                 
                </td>
               
            </tr>
            <s:iterator value="dp.datas" status="status">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
						<s:property value="#status.count" />
					 </td>
					 <td>
                         <s:property value="wayid" />
					 </td>
                     <td>
                         <j:code2Name definition="#WAYIDINFO" code="wayid" />
					 </td>
                     <td>
                        <j:code2Name definition="$FX_SMPBRAND" code="brand"/>
					 </td>
					 <td>
                        <s:property value="comresid" />
					 </td>
					 <td>
                        <s:property value="acttime" />
					 </td>
					 
                 </tr>
             </s:iterator>
        </table>

  </body>
</html>









