<%@ page language="java" contentType="application/x-msdownload;charset=GBK" %>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc" %>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=���͵���ʱԤ��ͳ����ϸ.xls";
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
 	<tr><td colspan="5"> �������ţ�${USER.oprcode}</td></tr>
 	<tr><td colspan="5"> ����ʱ�䣺<%=nowDate%></td></tr>
 	</table>
        <table border=1 bordercolor=#A8A8A8>
            <tr class="table_style_head">
                <td>
                   ���  
                </td>
                <td>
                    �ֹ�˾                 
                </td>
                <td>
                    ΢����                 
                </td>
                <td>
                    ͳ������                 
                </td>
                <td>
                    ��ʱʱ��(Сʱ)                 
                </td>
                <td>
                   ������                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- ���������á�|������� --%>
                   
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
