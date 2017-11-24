<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><bean:message bundle="personalbusi" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('itemid', '<bean:message bundle="personalbusi" key="itemid"/>', 'i', true, '14');
            addfield('mobile', '<bean:message bundle="personalbusi" key="mobile"/>', 'i', false, 11);
            addfield('opntime', '<bean:message bundle="personalbusi" key="opntime"/>', 'dt', false, '25'); 
            addfield('brand', '<bean:message bundle="personalbusi" key="brand"/>', 'i', false, '22');
            addfield('opntype', '<bean:message bundle="personalbusi" key="opntype"/>', 'c', false, '18');
            addfield('wayid', '<bean:message bundle="personalbusi" key="wayid"/>', 'c', false, '18');
            addfield('oprtype', '<bean:message bundle="personalbusi" key="oprtype"/>', 'c', false, '1');
            if(document.all("mobile").value.length!=11)
            {
            	alert("号码必须是11位");
            	return false;
            }
            return checkval(window);
            
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/personalbusi.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="personalbusi" key="titleList"/>
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
                 <td width="20%" align="right" class="form_table_right">
                  <div class="field-require">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <bean:message bundle="personalbusi" key="itemid"/>:
                        </c:if>
                        <c:if test="${!updateState}">
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <bean:message bundle="personalbusi" key="itemid"/>:
                        </c:otherwise>
                    </c:choose>
                  </div>
                 </td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="itemid" maxlength="14" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="itemid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="personalbusi" key="opntime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input type="text" class="form_input_1x" name="opntime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/personalbusi/PersonalbusiForm'].opntime }"/>"  onclick="this.value=selectDatetime()"/><font color='red'>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="form_input_1x" name="opntime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/personalbusi/PersonalbusiForm'].opntime }"/>" readonly="readonly" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="personalbusi" key="mobile"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mobile" maxlength="11"/><font color='red'>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mobile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="personalbusi" key="brand"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="brand">
								<option />
									<s:Options definition="#BUSI_BRAND"></s:Options>
							</html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select property="brand" disabled="true">
                        		<option />
                        		<s:Options  definition="#BUSI_BRAND"/>
                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>*</font>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="personalbusi" key="opntype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opntype" readonly="true"></html:text><input type="button" value="..." class="clickButton" onclick="showOpnfifthTree(this, 'opntype', 'opn5')"><font color='red'>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opntype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="personalbusi" key="wayid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                             <s:AuditPurChk controlid="2B7G1A1A_JHQUERYRGT" type="WAY1">
								<html:text styleClass="form_input_1x" property="wayid"></html:text>
							 </s:AuditPurChk>
							 <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="personalbusi" key="oprtype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <html:select property="oprtype">
								<option />
									<s:Options definition="#BUSI_OPRTYPE"></s:Options>
							</html:select>
							<font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="oprtype" disabled="true">
								<option />
									<s:Options definition="#BUSI_OPRTYPE"></s:Options>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/personalbusi.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/personalbusi.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
