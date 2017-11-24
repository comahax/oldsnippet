<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="3C4D3CAA" />
</jsp:include>
<%
    String ID_1 = "3C4D3CAABT1";
    String ID_2 = "3C4D3CAABT2";
    String ID_3 = "3C4D3CAABT3";
    String ID_4 = "3C4D3CAABT4";
%>
<html:html>
<head>
    <title><bean:message bundle="yxfeaprv" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        	if(ev_checkval_1())
        	{	           
	            if(document.all("formItem").state.value == "1")//批准
	            {
		            if(parseFloat(document.all("formItem").exfee.value)<=0){
		            	alert('<bean:message bundle="yxfeaprv" key="checkfeeupzero"/>');
		            	return false;
		            }		            
		            if(parseFloat(document.all("formItem").exfee.value)>parseFloat(formItem.appfee.value))
		            {
		            	alert('<bean:message bundle="yxfeaprv" key="checkfee"/>');
		            	return false;
		            }else{	            
		            	return true;
		            }
		       }else{//拒绝
		       	  return true;
		       }
            }            
            return false;
        }
        
        function ev_checkval_1() {
            addfield('wayid', '<bean:message bundle="yxfeaprv" key="wayid"/>', 'c', false, 18);
            addfield('exoprcode', '<bean:message bundle="yxfeaprv" key="exoprcode"/>', 'c', false, 15);
            addfield('state', '<bean:message bundle="yxfeaprv" key="state"/>', 'c', false, 18);
            addfield('exfee', '<bean:message bundle="yxfeaprv" key="exfee"/>', 'd', false, 16,2,'0.00',0.00,999999999999.99);
            addfield('opinion', '<bean:message bundle="yxfeaprv" key="opinion"/>', 'c', false, 255);
            return checkval(window); 
        }
        
        function selch()
		{
			if(document.all("formItem").state.value == "2"){
				document.all("formItem").exfee.disabled = true;
				document.all("formItem").exfee.value = "0.00";
				if(document.all("formItem").opinion.value == ""){
				   alert("您拒绝了该申请单，请继续填写拒绝的审批意见！");
				}else{
					alert("您拒绝了该申请单，请确认继续！");
				}
				document.formItem.opinion.focus();
			}else{
				document.all("formItem").exfee.disabled = false;
				document.all("formItem").exfee.value = "";
				document.formItem.exfee.focus();
			}
			
		}
		
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/fee/yxfeaprvchk.do?CMD=SAVE" styleId="formItem" method="post">
    
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${empty param.CMD or (!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope['cmdState'] eq 'EDIT'))}"/>
    
    <html:hidden property="apptime"/>
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
        	<c:if test="${param.CMD ne 'NEW'}">
	            <tr>
	                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="seq"/>:</div></td>
	                <td width="75%" align="left" class="form_table_left">
	                            <html:text styleClass="form_input_1x" property="seq" disabled="true"/>
	                </td>
	            </tr>
            </c:if>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="wayid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                     <html:text styleClass="form_input_1x" property="wayid"  disabled="true"/>       
                </td>
            </tr>
        	<tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="appoprcode"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                     <html:text styleClass="form_input_1x" property="appoprcode"  disabled="true"/>       
                </td>
            </tr>
                       
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="appfee"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                            <html:text styleClass="form_input_1x" property="appfee" readonly="true"/>
                </td>
            </tr>            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="yxfeeuse"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                            <html:textarea styleClass="form_textarea_on" property="yxfeeuse" disabled="true"/>
                </td>
            </tr> 
            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="exoprcode"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                     <html:text styleClass="form_input_1x" property="exoprcode"  disabled="true"/>       
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="state"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                	<c:choose>
	                	<c:when test="${param.CMD eq 'EDIT' and requestScope['/cms/fee/yxfeaprvchk/YxfeaprvchkForm'].state eq '0'}">
		                     <html:select property="state"  onchange="selch()">         		
		            			<option value="1">批准</option>
		            			<option value="2">拒绝</option>                     		
				        	</html:select>
			        	</c:when>
                        <c:otherwise>
                           <html:select property="state" disabled="true">         		
		            			<option value="1" <c:if test="${requestScope['/cms/fee/yxfeaprvchk/YxfeaprvchkForm'].state eq '1'}">selected</c:if>>批准</option>
		            			<option value="2" <c:if test="${requestScope['/cms/fee/yxfeaprvchk/YxfeaprvchkForm'].state eq '2'}">selected</c:if>>拒绝</option>                     		
				        	</html:select>
                        </c:otherwise>
                     </c:choose>
                </td>
            </tr>            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="exfee"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${param.CMD eq 'NEW' or ( param.CMD eq 'EDIT' and requestScope['/cms/fee/yxfeaprvchk/YxfeaprvchkForm'].state eq '0')}">
                            <html:text styleClass="form_input_1x" property="exfee"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exfee" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="yxfeaprv" key="opinion"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${param.CMD eq 'EDIT' and requestScope['/cms/fee/yxfeaprvchk/YxfeaprvchkForm'].state eq '0'}">
                        	<html:textarea styleClass="form_textarea_on" property="opinion"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea styleClass="form_textarea_on" property="opinion" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>            
        </table>
    </div>

    

    <div class="table_div">
        <table class="table_button_list">
            <tr>                
                <td width="100%" class="form_table_right">
                	<c:if test="${param.CMD eq 'EDIT' and requestScope['/cms/fee/yxfeaprvchk/YxfeaprvchkForm'].state eq '0'}">
                    <s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="yxfeaprv" key="chk"/>" class="submit"
                           onclick="doSave('/cms/fee/yxfeaprvchk.do?CMD=SAVE')"/>
                    </s:PurChk>
                    </c:if>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/fee/yxfeaprvchk.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html:html>
