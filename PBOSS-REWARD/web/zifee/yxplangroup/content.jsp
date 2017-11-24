<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C2B1A10BBAA" />
</jsp:include>
<%
    String ID_1 = "3C2B1A10BBAABT1";
    String ID_2 = "3C2B1A10BBAABT2";
%>
<html:html>
<head>
    <title><bean:message bundle="yxplangroup" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('memyxplan', '<bean:message bundle="yxplangroup" key="memyxplan"/>', 'c', false, 14);
            addfield('groupyxplan', '<bean:message bundle="yxplangroup" key="groupyxplan"/>', 'c', false, 14);
            return checkval(window);
        }
    
    function selectYxplan(){
			  var arg = new Array();
			  var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			  var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			  return returnValue;
		 }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/zifee/yxplangroup.do?CMD=NEW" styleId="formItem" method="post">
    
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="groupyxplan"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>

	<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplangroup" key="titleList"/>
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
		                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplangroup" key="groupyxplan"/>:</div></td>
		                <td width="75%" align="left" class="form_table_left">		
                         <html:text styleClass="form_input_1x" property="groupyxplan" disabled="true"/>		                        
		                </td>
		            </tr>    
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxplangroup" key="memyxplan"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                	      <html:text styleClass="form_input_1x" property="memyxplan" readonly="true"></html:text>
                	      <input type="button"  value="..."  onclick="memyxplan.value=selectYxplan()">
                </td>
            </tr>        
        </table>
    </div>



    <div class="table_div">
        <table class="table_button_list">
            <tr>               
                <td width="100%" class="form_table_right">
                	<s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/zifee/yxplangroup.do?CMD=SAVE')"/>
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/zifee/yxplangroup.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html:html>
