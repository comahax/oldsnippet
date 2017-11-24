<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="Waypro" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        	if(formItem.principaltel.value.length != 11){
        		errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>手机号码必须满足11位!</span>');
        		return false;
        	}
            addfield('wayid', '<bean:message bundle="Waypro" key="wayid"/>', 'c', false, '18');
            addfield('wayname', '<bean:message bundle="Waypro" key="wayname"/>', 'c', false, '256');
            addfield('address', '<bean:message bundle="Waypro" key="address"/>', 'c', false, '128');
            addfield('waystate', '<bean:message bundle="Waypro" key="waystate"/>', 'i', false, '3');
            addfield('signstatus', '<bean:message bundle="Waypro" key="signstatus"/>', 'i', false, '3');
			addfield('starttime', '<bean:message bundle="Waypro" key="starttime"/>', 't', false, '25');            
            addfield('disabletime', '<bean:message bundle="Waypro" key="disabletime"/>', 't', false, '25');
            addfield('waysubtype', '<bean:message bundle="Waypro" key="waysubtype"/>', 'c', false, '25');
            if(date_compare("starttime","disabletime",'启用日期不得晚于停用日期')) return;
            addfield('principal', '<bean:message bundle="Waypro" key="principal"/>', 'c', false, '64');
			addfield('linkmanemail', '<bean:message bundle="Waypro" key="linkmanemail"/>', 'c', true, '128');            
            addfield('principaltel', '<bean:message bundle="Waypro" key="principaltel"/>', 'i', false, '20');
            addfield('fax', '<bean:message bundle="Waypro" key="fax"/>', 'i', true, '20');
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/waypro.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/waypro/WayproForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="Waypro" key="titleList"/>
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
				<td width="100%" colspan="4" class="form_table_left">
					<div class="field-require">
						<font color=blue><bean:message bundle="Waypro" key="wayinfo" /></font>
					</div>
				</td>
			</tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="wayid"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
	                        <c:if test="${updateState}">
	                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18" disabled="true"/>
	                            <font color="red">*</font>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18"/>
	                            <font color="red">*</font>
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="wayname"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayname"/>
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayname" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="address"/>:</div></td>
                <td width="80%" colspan="3" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="address"/>
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="address" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="waystate"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:select property="waystate">
		               	    	<option />
		                    	<s:Options definition="$CH_VALIDFLAG"/>
		                    </html:select>
		                    <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="waystate" disabled="true">
		               	    	<option />
		                    	<s:Options definition="$CH_VALIDFLAG"/>
		                    </html:select>
		                    <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="signstatus"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="signstatus">
		               	    	<option />
		                    	<s:Options definition="$CH_SIGNSTATUS"/>
		                    </html:select>
		                    <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="signstatus" disabled="true">
		               	    	<option />
		                    	<s:Options definition="$CH_SIGNSTATUS"/>
		                    </html:select>
		                    <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="starttime"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                        	<input type='text' class="form_input_1x" name="starttime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.starttime}"/>"
									onclick="this.value = selectDate()" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <input type='text' class="form_input_1x" name="starttime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.starttime}"/>"
									disabled="disabled" />
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="disabletime"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<input type='text' class="form_input_1x" name="disabletime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.disabletime}"/>"
									onclick="this.value = selectDate()" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                        	<input type='text' class="form_input_1x" name="disabletime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.disabletime}"/>"
									disabled="disabled" />
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="waysubtype"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <c:if test="${updateState}">
	                            <html:select property="waysubtype" disabled="true">
									<option />
									<s:Options definition="#UNV_REWARDKIND" />
								</html:select>
                            	<font color="red">*</font>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                            <html:select property="waysubtype">
									<option />
									<s:Options definition="#UNV_REWARDKIND" />
								</html:select>
								<font color="red">*</font>
	                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select property="waysubtype" disabled="true">
								<option />
								<s:Options definition="#UNV_REWARDKIND" />
							</html:select>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"></td>
                <td width="30%" align="left" class="form_table_left">
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
        <table class="form_table">
        	<tr>
				<td width="100%" colspan="4" class="form_table_left">
					<div class="field-require">
						<font color=blue><bean:message bundle="Waypro" key="waypersoninfo" /></font>
					</div>
				</td>
			</tr>
			<tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="principal"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="principal"/>
		                    <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="principal" disabled="true"/>
		                    <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="linkmanemail"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="linkmanemail"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="linkmanemail" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="principaltel"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="principaltel"/>
		                    <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="principaltel" disabled="true"/>
		                    <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="Waypro" key="fax"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="fax"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="fax" disabled="true"/>
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
                	<c:choose>
                        <c:when test="${edtState}">
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doSave('/cms/waypro.do?CMD=SAVE')"/>
                        </c:when>
                        <c:otherwise>
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
		                           onclick="doSave('/cms/waypro.do?CMD=SAVE')" disabled="disabled"/>
                        </c:otherwise>
                    </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/waypro.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
