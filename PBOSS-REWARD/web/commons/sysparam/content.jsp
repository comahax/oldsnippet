<%@ page language="java" contentType="text/html;charset=GBK"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="1A1A1A2B" />
</jsp:include>
<%@ include file="/inc/contenthead.inc" %>
<html:html>
<head>
    <title><bean:message bundle="sysparam" key="titleUpdate"/></title>
    <script language="JavaScript">
           function ev_checkval() {
            addfield('systemid', '<bean:message bundle="sysparam" key="systemid"/>', 'l', false, 14);
            addfield('paramtype', '<bean:message bundle="sysparam" key="paramtype"/>', 'c', false, 16);
			addfield('strBegintime', '<bean:message bundle="sysparam" key="begintime"/>', 'dt', false, 7);            
			addfield('strEndtime', '<bean:message bundle="sysparam" key="endtime"/>', 'dt', false, 7);  			
            addfield('paramname', '<bean:message bundle="sysparam" key="paramname"/>', 'c', false, 32);
            addfield('paramvalue', '<bean:message bundle="sysparam" key="paramvalue"/>', 'c', false, 256);
            addfield('memo', '<bean:message bundle="sysparam" key="memo"/>', 'c', true, 256);
            if(date_compare("strBegintime","strEndtime",'<bean:message bundle="fee" key="timeCompare_1"/>')) return;
            return checkval(window);
        }
    </script>
</head> 
<body>
<div class="table_container">
<html:form action="/commons/sysparam.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_systemid"/>
    <html:hidden property="_sk_paramtype"/>    
    <html:hidden property="_sk_paramname"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>

	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="sysparam" key="titleView"/></td>
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
				<td colspan="2"><bean:message bundle="fee" key="redStarExplain"/></td>
			</tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="sysparam" key="systemid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
                            <html:text styleClass="form_input_1x" property="systemid" maxlength="14"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="systemid" disabled="true"/>
                        </c:otherwise>
                    </c:choose><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="sysparam" key="paramtype"/>:</div></td>
                <td class="form_table_left">
						<c:choose>
							<c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
									<html:select property="paramtype"> 
										<html:option value=""></html:option>
										<s:Options definition="$IB_PARAMTYPE"/> 
									</html:select>
							</c:when>
							<c:otherwise>
									<html:select property="paramtype" disabled="true"> <s:Options definition="$IB_PARAMTYPE"/> </html:select>
							</c:otherwise>
						</c:choose><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>            
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="sysparam" key="begintime"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="strBegintime" onclick="this.value=selectDatetime()"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="strBegintime" disabled="true"/>
                        </c:otherwise>
                    </c:choose><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="sysparam" key="endtime"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="strEndtime" onclick="this.value=selectDatetime()"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="strEndtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="sysparam" key="paramname"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paramname"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paramname" disabled="true"/>
                        </c:otherwise>
                    </c:choose><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="sysparam" key="paramvalue"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="paramvalue"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="paramvalue" disabled="true"/>
                        </c:otherwise>
                    </c:choose><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>   
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="sysparam" key="memo"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="memo"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="memo" disabled="true"/>
                        </c:otherwise>
                    </c:choose><bean:message bundle="fee" key="redStar"/>
                </td>
            </tr>                                    
        </table>
    </div>



    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this);" onblur="buttonout(this);"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/commons/sysparam.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this);" onblur="buttonout(this);"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this);" onblur="buttonout(this);"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/commons/sysparam.do?CMD=LIST')"/>
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html:html>
