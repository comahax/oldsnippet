<%@ page language="java" contentType="text/html;charset=utf-8"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D1A2B" />
</jsp:include>
<%@ include file="/inc/listhead.inc" %>
<% 
    String ID_1 = "4D1A2BBT1";
    String ID_2 = "4D1A2BBT2";
    String ID_3 = "4D1A2BBT3";

%>
<html>
<head>
    <title><bean:message bundle="accounting" key="titleList1"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            if( formList.year.value == "" && formList.month.value != "") {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else if( formList.year.value != "" && formList.month.value == "" ) {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else {
	     		formList._ne_validbillcyc.value = formList.year.value + formList.month.value;
			}                       
            addfield('_ne_validbillcyc', '<bean:message bundle="bltouchrule" key="billcyc" />', 'l', false, 8);
		    addfield('_se_batchnum', '<bean:message bundle="bltouchrule" key="batchnum" />', 'c', false, 3);
		    addfield('regiongroup', '<bean:message bundle="bltouchrule" key="region"/>', 'c', false, 200);	         
            return checkval(window);   
        } 
        function setBatchNum(){  
	        if(document.all("_se_batchnum") != null && document.all("_se_batchnum").value == ""){
	        	document.all("_se_batchnum").value = "01";
	        }
        }
  
	
		
    </script>
</head>

<body onload="setBatchNum();loadforiframe1();">
<div class="table_container">
<html:form action="/fee/accounting.do?CMD=TJLIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>	
	<html:hidden property="_ne_validbillcyc"/>	
	
	
	<div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="accounting" key="titleList1"/></td>            	
            </tr>
        </table>
    </div>   
    <div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div> 
    <div class="table_div">        
        <table class="form_table">   
            <tr>
                <td width="150" class="form_table_right"><bean:message bundle="bltouchrule" key="region"/>: </td>
                <td class="form_table_left" colspan="3">
                	<c:choose>
						<c:when test="${!empty _PURVIEW}">
							<s:MoreCheck definition="#CITYCOMPANY" property="regiongroup" styleClass="form_input_2x" disabled="true"/>
		                </c:when>
		                <c:otherwise>									
				            <s:MoreCheck definition="#CITYCOMPANY" property="regiongroup" styleClass="form_input_2x"/>
		                </c:otherwise>
		            </c:choose>
                </td>
            </tr>
            <tr>    
                <td class="form_table_right"><bean:message bundle="woffcust" key="validbillcyc" />:</td>
				<td class="form_table_left">
					<html:select property="year" styleClass="form_selects_y">
		                <html:option value=""> </html:option> 
		                <s:DateOptions type="#YY" desc="true" stepNowYear="1"/> 
		                </html:select><bean:message bundle="fee" key="year"/>
		            <html:select property="month" styleClass="form_selects_m">
		                <html:option value=""> </html:option> 
		                <s:DateOptions type="#MM" fillZero="true"/> 
		            </html:select><bean:message bundle="fee" key="month"/> 
				</td> 
				<td class="form_table_right"><bean:message bundle="bltouchrule" key="batchnum" />:</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_se_batchnum"></html:text>
				</td>        
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
			   <td> 			    
                 	<s:PurChk controlid="<%=ID_1%>">
                 	<input type="button" class="query" onmouseover="buttonover(this);" 
                 			onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_search"/>" onclick="doQuery();"/>
                    </s:PurChk> 
               </td> 	
			</tr>
		</table>
	</div>
	<div class="table_div">
		<span class="color0" style="padding:3px 0 0 0;margin: 5px 5px 5px 5px;width:60px;height:20px;">未启动</span>
		<span class="color1" style="padding:3px 0 0 0;margin: 5px 5px 5px 5px;width:60px;height:20px;">可启动</span>
		<span class="color2" style="padding:3px 0 0 0;margin: 5px 5px 5px 5px;width:60px;height:20px;">启动中</span>
		<span class="color3" style="padding:3px 0 0 0;margin: 5px 5px 5px 5px;width:60px;height:20px;">已完成</span>
		<span class="color4" style="padding:3px 0 0 0;margin: 5px 5px 5px 5px;width:60px;height:20px;">出  错</span>
		<span style="color:red;padding:3px 0 0 0;margin: 5px 5px 5px 5px;width:300px;height:20px;">注:黑色时间为开始时间,红色时间为完成时间</span>
	</div>
	
    <div class="table_div">
    <div class="xxtable_LongTable">
        <table class="table_account" ID="Table2">   
        	<tr align="center" class="table_head">	
				<td width="80px"></td>		
				<td>固 定 费</td>	
				<td>预处理确认</td>
				<td>用户出帐</td>
				<td>帐户出帐</td>
				<td>出帐确认</td>
				<td>销帐信控</td>
				<td width="20px"></td>
			</tr>
			<tr  class="table_content" align="center" height="0px">	
				<td class="city"></td>		
				<td class="city"></td>
				<td class="city"></td>
				<td class="city"></td>
				<td class="city"></td>
				<td class="city"></td>
				<td class="city"></td>
				<td class="city" width="20px"></td>
			</tr>			
		       	
            <c:forEach var="item" items="${requestScope.LIST}">            
            	<tr class="table_content">	
					<td class="city">
					<c:out value='${item.cityname}'/>
					</td>				
					<td class="bodytd1 color<c:out value="${item.btrvo.fixstate + 0}"/>">				
						<div class="stime1"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.fixstime}" /> 																			
						<span class="colortime"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.fixetime}" /></span>&nbsp;</div>
					</td>
					<td class="bodytd1 color<c:out value="${item.btrvo.prmcfmstate + 0}"/>">				
						<div class="stime1"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.prmcfmtime}" />  										
						<span class="colortime"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.prmcfmtime}" /></span>&nbsp;</div>
					</td>
					<td class="bodytd1 color<c:out value="${item.btrvo.usrbillstate + 0}"/>">										
						<div class="stime1"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.usrbillstime}" />  
						<span class="colortime"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.usrbilletime}" /></span>&nbsp;</div>
					</td>
					<td class="bodytd1 color<c:out value="${item.btrvo.accbillstate + 0}"/>">				
						<div class="stime1"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.accbillstime}" />  
						<span class="colortime"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.accbilletime}" /></span>&nbsp;</div>
					</td>
					<td class="bodytd1 color<c:out value="${item.btrvo.cfmbillstate + 0}"/>">				
						<div class="stime1"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.cfmbillstime}" />  
						<span class="colortime"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.cfmbilletime}" /></span>&nbsp;</div>
					</td>
					<td class="bodytd1 color<c:out value="${item.btrvo.woffstate + 0}"/>">				
						<div class="stime1"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.wofftime}" />  
						<span class="colortime"><fmt:formatDate type="date" pattern="dd号HH时" value="${item.btrvo.woffetime}" /></span>&nbsp;</div>
					</td>	
					<td class="city" width="20px"></td>				
				</tr>
				<tr class="table_content">
					<td class="city" colspan="8" height="2px"></td>				
				</tr>                
            </c:forEach>
            
        </table>
    </div>
    </div>
    <br><br>
</html:form>
</div>
<script type="text/javascript">
	setInterval("autoRefresh()",1000*60*3);
</script>
</body>
</html>





























