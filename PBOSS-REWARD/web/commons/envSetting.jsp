<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%
	/*���벿��*/
	String huaweiIP = (String)request.getSession().getServletContext().getAttribute("huaweiIP");
	String huaweiPort = (String)request.getSession().getServletContext().getAttribute("huaweiPort");
	String huaweiWebRoot =( String) request.getSession().getServletContext().getAttribute("huaweiWebRoot");
	
	if(huaweiIP == null) huaweiIP = "";
	if(huaweiPort == null) huaweiPort = "";
	if(huaweiWebRoot == null) huaweiWebRoot = "/boss";
	
	String huaweiIPString = request.getParameter("huaweiIP");
	String huaweiPortString = request.getParameter("huaweiPort");
	String huaweiWebRootString = request.getParameter("huaweiWebRoot");
	
	if(huaweiIPString!=null) huaweiIP = huaweiIPString;
	if(huaweiPortString!=null) huaweiPort = huaweiPortString;
	if(huaweiWebRootString!=null) huaweiWebRoot = huaweiWebRootString;
	
	request.getSession().getServletContext().setAttribute("huaweiIP", huaweiIP);
	request.getSession().getServletContext().setAttribute("huaweiPort", huaweiPort);
	request.getSession().getServletContext().setAttribute("huaweiWebRoot", huaweiWebRoot);
%>
<html>
  <head>
    
    <title>������������</title>
    <base target="_self">
</head>
 
<body>
<div class="table_container">
<form action="<%=contextPath%>/commons/envSetting.jsp" styleId="formList" method="post">
  	
  	  <div class="table_div">
		<table class="top_table">
			<tr>
				<td>
					������������ (Internal User Only) 
				</td>
			</tr>
		</table>
	</div>
   <div class="table_div">       
	<table class="form_table" >
            <tr >                
                <td class="form_table_right" style="width:150px">      
                	����IP(��Ϊ):              
                </td>    
                 <td class="form_table_left">  
                 	<input name="huaweiIP" value="<%=huaweiIP%>" >                  
                </td>                
            </tr> 
            <tr >                
                <td class="form_table_right">     
                	�˿�(��Ϊ):               
                </td>    
                 <td class="form_table_left">   
	                <input name="huaweiPort" value="<%=huaweiPort%>">                       
                </td>                
            </tr> 
             <tr >
                <td class="form_table_right">     
                	�����ĸ�(��Ϊ):               
                </td>    
                 <td class="form_table_left">   
	                <input name="huaweiWebRoot" value="<%=huaweiWebRoot%>">                       
                </td>                
            </tr> 
           
      </table>    
     </div>   	   
     
      <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
					 <input type="submit" class="submit" name="submit" value="�޸�">     
				</td>
			</tr>
		</table>
	</div>       
  </form>       
</div>
</body>
</html>
