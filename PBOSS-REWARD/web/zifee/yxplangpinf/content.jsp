<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B1A10AAAA" />
</jsp:include>
<%
    String ID_1 = "3C2B1A10AAAABT1";
    String ID_2 = "3C2B1A10AAAABT2";
    
    String AREACODE_A = "AREACODE_A";
    String AREACODE_B = "AREACODE_B";
    String AREACODE_C = "AREACODE_C";
%>


<html:html>
<head>
    <title><bean:message bundle="yxplan" key="titleList"/></title>
    <script language="JavaScript">

         function ev_checkval() {
             <c:if test="${!empty param.CMD and param.CMD eq 'NEW'}">
                 addfield('groupid', '<bean:message bundle="yxplan" key="groupyxplanid"/>', 'i', false, 14);
             </c:if>
             addfield('areacode', '<bean:message bundle="yxplan" key="areacode"/>', 'c', false, 32);
             addfield('groupname', '<bean:message bundle="yxplan" key="groupyxplanname"/>', 'c', false, 128);
             addfield('remark', '<bean:message bundle="yxplan" key="remark"/>', 'c', false, 255);
             return checkval(window);
			  }  
			  
        function doSubmit(cmdStr) {
          if (ev_checkval()) {
              enable();
              formItem.action = contextPath + cmdStr;
              formItem.submit();
          }
          return false;
        } 
        
        function doReturn(cmdStr) {
            formItem.action = contextPath + cmdStr;
            formItem.submit();
        } 
        function getAreacode(){	
			var strUrl;
			var arg = new Array();
			strUrl = "<%=contextPath%>/admin/dictitem.do?CMD=LIST";
			strUrl = strUrl + "&_pagesize=0&_se_groupid=PC_YXPLANAREACODE";            
            <%
            	String pid = "1";  //1  2 3 
            	if(pid.equals("1")) {
            	User user = (User)request.getSession().getAttribute( WebConstant.SESSION_ATTRIBUTE_USER);
            	%>
            		   <s:PurChk controlid="<%=AREACODE_A%>">
            		   	 var strUrl0 = strUrl;
            		   	 strUrl0 = strUrl0;
            		   </s:PurChk>
            		   
            		  <s:PurChk controlid="<%=AREACODE_B%>">
            		   	 var strUrl0 = strUrl;
            		   	 strUrl0 = strUrl0 + "&_sne_dictid=865";
            		   </s:PurChk>
            		   
            		  <s:PurChk controlid="<%=AREACODE_C%>">
            		   	  var strUrl0 = strUrl;
            		   	  strUrl0 = strUrl0 + "&_se_dictid=" + "<%=user.getCityid()%>";
            		   </s:PurChk>					 
            	<%
            	}
            %>
            
            var hWnd = window.showModalDialog(strUrl0,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			if(hWnd != null && hWnd != ""){						
				document.all.areacode.value = hWnd;	
			}else{
				document.all.areacode.value = "";	
			}	
        }

    </script>
</head>
<body>
<div class="table_container">
<html:form action="/zifee/yxplangpinf.do?CMD=SAVE" styleId="formItem" method="post">
    
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>

	<div class="table_div">

		<table class="top_table" border=0>
			<tr> 
				<td>
					<bean:message bundle="yxplan" key="managenew"/>
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
      		<tr >
				<td align=left colspan="2">
					&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/>												
				</td>			
			</tr>
			<c:if test="${param.CMD ne 'NEW'}">
      		<tr>
           		<td  align="right"><div class="field-require"><bean:message bundle="yxplan" key="groupyxplanid"/>:</div></td>
                <td  align="left" colspan="1">
                            <html:text styleClass="form_input_1x" property="groupid" disabled="true"/>
                </td>
             </tr>
             </c:if>
            <tr>	
            <td  align="right"><div class="field-require"><bean:message bundle="yxplan" key="areacode"/>:</div></td>
                <td  align="left" colspan="1">
                    <c:choose>
                        <c:when test="${param.CMD eq 'NEW'}">
                            <html:text styleClass="form_input_1x" property="areacode" readonly="true"  onclick="getAreacode()"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="areacode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
             </tr>
             
            <tr>	
            <td  align="right"><div class="field-require"><bean:message bundle="yxplan" key="groupyxplanname"/>:</div></td>
                <td  align="left" colspan="1">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="groupname" /><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="groupname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
             </tr>

          <tr>
              <td  align="right"><div class="field-require"><bean:message bundle="yxplan" key="remark"/>:</div></td>
               <td  align="left" colspan="5">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea styleClass="form_textarea_on_4" property="remark"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:textarea styleClass="form_textarea_on_4" property="remark" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
               </tr>
       </table>
    </div>
 <div class="table_div">
        <table class="table_button_list">
            <tr>
                 <td >
                 	<s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSubmit('/zifee/yxplangpinf.do?CMD=SAVE')"/>
                      </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                     </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplangpinf.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>`
</body>
</html:html>
