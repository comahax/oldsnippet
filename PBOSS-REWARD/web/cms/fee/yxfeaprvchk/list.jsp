<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="yxfeaprv" key="chktitleList"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function selch()
		{
			if(document.all("formList")._se_state.value == "0"){
				document.all("formList")._se_exoprcode.value = "";
			}
			else{
				document.all("formList")._se_exoprcode.value = document.all("formList").curoprcode.value;				
			}
		}
		
		function init(){
			document.formList._sk_wayid.focus();
		}
    </script>
</head>

<body onload="init()">
<div class="table_container">
<html:form action="/cms/fee/yxfeaprvchk.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
	<html:hidden property="curoprcode"/>
	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxfeaprv" key="chktitleList"/>
						</td>
					</tr>
				</table>
	</div>
	
	<div class="table_div">
		<table width="100%" class="error_text">
	        <html:errors/><s:Msg />
	   	</table>
	</div>

	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxfeaprv" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_wayid"  onclick="showSelectWay(this )"></html:text>                    
                </td>                
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxfeaprv" key="exoprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_exoprcode" readonly="true"></html:text>                    
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxfeaprv" key="state"/>:</td>
                <td class="form_table_left">
                    <html:select property="_se_state" onchange="selch()">
            			<option value=""  ></option>		                		
            			<s:Options  definition="$CH_YXFEESTATE"/>
		        	</html:select>
                </td>
             </tr>
             <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxfeaprv" key="extime"/>>=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_extime" onclick="this.value=selectDate()"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxfeaprv" key="extime"/><=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_extime" onclick="this.value=selectDate()"></html:text>
                </td>
             </tr>
        </table>
      </div>
      
	<div class="table_div">
        <table class="table_button_list">            
			<tr>
	            <td align=right>
	            	<input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
	                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                        value="<bean:message bundle="public" key="button_search"/>" />
	                               
	            </td>
            </tr>				
        </table>
    </div>
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
				<td nowrap><bean:message bundle="yxfeaprv" key="seq"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="wayid"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="apptime"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="appoprcode"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="appfee"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="state"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="extime"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="exoprcode"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="exfee"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="opinion"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="recvfee"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="recvoprcode"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="recvtime"/></td>
                <td nowrap><bean:message bundle="yxfeaprv" key="yxfeeuse"/></td>                	
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/fee/yxfeaprvchk.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">                     
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seq}"/></a>
                     </td>        
					<td><c:out value="${item.wayid}"/> - <s:Code2Name code="${item.wayid}" definition="#WAY"/></td>      
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.apptime}"/></td>    
					<td><c:out value="${item.appoprcode}"/></td> 
					<td><fmt:formatNumber pattern="0.00" value="${item.appfee}"/></td>
					<td><s:Code2Name code="${item.state}" definition="$CH_YXFEESTATE"/></td>     
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.extime}"/></td>     
					<td><c:out value="${item.exoprcode}"/></td>  
					<td><fmt:formatNumber pattern="0.00" value="${item.exfee}"/></td>      
                    <td><c:out value="${item.opinion}"/></td>    
                    <td><fmt:formatNumber pattern="0.00" value="${item.recvfee}"/></td>    
                    <td><c:out value="${item.recvoprcode}"/></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.recvtime}"/></td>   
                    <td><c:out value="${item.yxfeeuse}"/></td>   
                                              
                 </tr>
             </c:forEach>
        </table>
   		</div>
    </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
