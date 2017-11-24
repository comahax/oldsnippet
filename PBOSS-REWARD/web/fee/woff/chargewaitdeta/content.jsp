<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A2BAA" />
</jsp:include>
<%
    String ID_1 = "4D6F1A2BAABT1";
    String ID_2 = "4D6F1A2BAABT2";
    String ID_3 = "4D6F1A2BAABT3";
%>
<html:html>
<head>
    <title><bean:message bundle="chargewait" key="titleList1"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        
        	if( formItem.year.value == "" && formItem.month.value != "") {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else if( formItem.year.value != "" && formItem.month.value == "" ) {
	     		alert("<bean:message bundle="fee" key="selectCyc"/>");	     			
	     		return false;
			}else {
	     		formItem.billcyc.value = formItem.year.value + formItem.month.value;
			}
            addfield('eboxid', '<bean:message bundle="chargewait" key="eboxid"/>', 'l', false, 14);
            addfield('subsid', '<bean:message bundle="chargewait" key="subsid"/>', 'l', false, 14);
            addfield('acctstr', '<bean:message bundle="chargewait" key="acctstr"/>', 'c', false, 255);
            addfield('eboxstr', '<bean:message bundle="chargewait" key="eboxstr"/>', 'c', false, 255);
            addfield('billcyc', '<bean:message bundle="chargewait" key="billcyc"/>', 'l', false, 8);
            addfield('chargetype', '<bean:message bundle="chargewait" key="chargetype"/>', 'l', false, 3);
            addfield('source', '<bean:message bundle="chargewait" key="source"/>', 'l', false, 3);
            addfield('servnumber', '<bean:message bundle="chargewait" key="servnumber"/>', 'l', false, 20);
            addfield('iscredit', '<bean:message bundle="chargewait" key="iscredit"/>', 'l', false, 3);
            addfield('memo', '<bean:message bundle="chargewait" key="memo"/>', 'c', false, 64);   
            
            return checkval(window);
        }
        function setdate() {
        	var billcyc = formItem.billcyc.value;
        	formItem.year.value = billcyc.substring(0,4);
        	formItem.month.value = billcyc.substring(4,billcyc.length);	
        }
    </script>
</head>
<body onload="setdate();loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/chargewaitdeta.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
    <html:hidden property="chargeid"/>
    <html:hidden property="reqtime"/>
	<html:hidden property="billcyc"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    
    <div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="chargewait" key="titleList1"/></td>
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
				<td align=left colspan=6><bean:message bundle="fee" key="redStarExplain"/></td>
			</tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="eboxid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="eboxid" maxlength="14"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="eboxid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
            
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="subsid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="subsid" maxlength="14"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="subsid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td> 
            </tr>
            <tr>              
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="servnumber"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="servnumber" maxlength="20"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="servnumber" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
            
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="billcyc"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
							<html:select property="year" styleClass="form_selects_y">
				                <html:option value=""> </html:option> 
				                <s:DateOptions type="#YY" desc="true" stepNowYear="1"/> 
				                </html:select><bean:message bundle="fee" key="year"/>
				            <html:select property="month" styleClass="form_selects_m">
				                <html:option value=""> </html:option> 
				                <s:DateOptions type="#MM" fillZero="true"/> 
				            </html:select><bean:message bundle="fee" key="month"/> 
                        </c:when>
                        <c:otherwise>
							<html:select property="year" styleClass="form_selects_y" disabled="true">
				                <html:option value=""> </html:option> 
				                <s:DateOptions type="#YY" desc="true" stepNowYear="1"/> 
				                </html:select><bean:message bundle="fee" key="year"/>
				            <html:select property="month" styleClass="form_selects_m" disabled="true">
				                <html:option value=""> </html:option> 
				                <s:DateOptions type="#MM" fillZero="true"/> 
				            </html:select><bean:message bundle="fee" key="month"/> 
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td> 
            </tr>
            <tr>               
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="adjflag"/>:</div></td>
                <td class="form_table_left">
                    <html:select property="adjflag" disabled="true">
                    	<html:option value=""></html:option>
                    	<s:Options definition="$IB_NULLADJSTATE" nameOnly="false"/>
                    </html:select>                                      
                </td>
            
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="chargetype"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="chargetype">
                    			<html:option value=" "></html:option>
                    			<s:Options definition="#CHARGETYPE" nameOnly="false"/>
                    		</html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="chargetype" disabled="true">
                    			<html:option value=" "></html:option>
                    			<s:Options definition="#CHARGETYPE" nameOnly="false"/>
                    		</html:select>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
          	</tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="iscredit"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="iscredit">
                    			<html:option value=" "></html:option>
                    			<s:Options definition="$IM_YESNO10" nameOnly="false"/>
                    		</html:select>
                        </c:when>
                        <c:otherwise> 
                            <html:select property="iscredit" disabled="true">
                    			<html:option value=" "></html:option>
                    			<s:Options definition="$IM_YESNO10" nameOnly="false"/>
                    		</html:select>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
            
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="source"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="source">
                    			<html:option value=" "></html:option>
                    			<s:Options definition="#CHARGE_SOURCE" nameOnly="false"/>
                    		</html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="source" disabled="true">
                    			<html:option value=" "></html:option>
                    			<s:Options definition="#CHARGE_SOURCE" nameOnly="false"/>
                    		</html:select>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="adjchgid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           	<html:text styleClass="form_input_1x" property="adjchgid" />
                        </c:when>
                        <c:otherwise> 
                            <html:text styleClass="form_input_1x" property="adjchgid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
            
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="oprcode"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprcode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="memo"/>:</div></td>
                <td class="form_table_left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="memo" maxlength="64"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="memo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="adjmemo"/>:</div></td>
                <td class="form_table_left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="adjmemo" maxlength="64"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="adjmemo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="eboxstr"/>:</div></td>
                <td class="form_table_left" colspan="3">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:textarea  property="eboxstr" styleClass="form_textarea_on"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea  property="eboxstr" styleClass="form_textarea_on" disabled="true"/>
                        </c:otherwise>
                    </c:choose> <bean:message bundle="fee" key="redStar"/>                  
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="chargewait" key="acctstr"/>:</div></td>
                <td class="form_table_left" colspan="3">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:textarea  property="acctstr" styleClass="form_textarea_on"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea  property="acctstr" styleClass="form_textarea_on" disabled="true"/>
                        </c:otherwise>
                    </c:choose> <bean:message bundle="fee" key="redStar"/>                  
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                	<s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/fee/woff/chargewaitdeta.do?CMD=SAVE')" disabled="true"/>
                    </s:PurChk>                 
                    <s:PurChk controlid="<%=ID_3%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/fee/woff/chargewaitdeta.do?CMD=LIST')">
                	</s:PurChk>
                </td>
            </tr>
        </table>
    </div>
    
</html:form>
</div>
</body>
</html:html>
