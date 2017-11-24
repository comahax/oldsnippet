<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chadtbaseprodid" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('prodid', '<bean:message bundle="chadtbaseprodid" key="prodid"/>', 'c', false, '32');
            addfield('cityid', '<bean:message bundle="chadtbaseprodid" key="cityid"/>', 'c', false, '2');
            addfield('type', '<bean:message bundle="chadtbaseprodid" key="type"/>', 'c', false, '2');
            addfield('prodname', '<bean:message bundle="chadtbaseprodid" key="prodname"/>', 'c', true, '128');
            addfield('oprtype', '<bean:message bundle="chadtbaseprodid" key="oprtype"/>', 'c', false, '2');
            addfield('tertype', '<bean:message bundle="chadtbaseprodid" key="tertype"/>', 'c', true, '2');
            addfield('wrapfee', '<bean:message bundle="chadtbaseprodid" key="wrapfee"/>', 'f', false, '14','2'); 
            addfield('createtime', '<bean:message bundle="chadtbaseprodid" key="createtime"/>', 't', true, '7');
            addfield('adtremark', '<bean:message bundle="chadtbaseprodid" key="adtremark"/>', 'c', true, '64');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/chadtbaseprodid.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_prodid"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_se_type"/>
    <html:hidden property="_se_oprtype"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/chadtbaseprodid/ChadtbaseprodidForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtbaseprodid" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbaseprodid" key="prodid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="prodid" readonly="true"/> <font color='red'>*</font>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="prodid" /><font color='red'>*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodid" disabled="true"/><font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbaseprodid" key="cityid"/>:</div></td>
							<td width="80%" align="left" class="form_table_left">

								<html:select property="cityid" disabled="true">
									<s:Options definition="#CITYNAME3" />
								</html:select>

							</td>
						</tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbaseprodid" key="type"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="type">
											<s:Options definition="$BASEPRODID_TYPE" />
										</html:select>
										 
										<font color='red'>*</font>
									</c:when>
									<c:otherwise>
										<html:select property="type" disabled="true">
											<s:Options definition="$BASEPRODID_TYPE" />
										</html:select>
										<font color='red'>*</font>
									</c:otherwise>
								</c:choose>
							</td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbaseprodid" key="prodname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="prodname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbaseprodid" key="oprtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <html:select property="oprtype"> 
								<s:Options definition="$BASEPRODID_OPRTYPE" />
							</html:select>
                             <font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                             <html:select property="oprtype" disabled="true"> 
                             <s:Options definition="$BASEPRODID_OPRTYPE" />
                             </html:select> 
                             <font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbaseprodid" key="tertype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">  
                        <html:select property="tertype"> 
                                 <html:option value=""></html:option>
								<s:Options definition="$BASEPRODID_TERTYPE" />
						</html:select>
                             
                        </c:when>
                        <c:otherwise>
                           <html:select property="tertype" disabled="true"> 
								<s:Options definition="$BASEPRODID_TERTYPE" />
						</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbaseprodid" key="wrapfee"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wrapfee" /><font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wrapfee" disabled="true"/><font color='red'>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr> 
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtbaseprodid" key="adtremark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adtremark" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adtremark" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="80%" align="left" class="form_table_left" colspan="2"> <font color='red'>注意:  所有登录系统的工号，都只能操作（新增、删除、修改）本地市的数据。</font> </td>
                
            </tr>
            
       
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/chadtbaseprodid.do?CMD=SAVE')"/>
                  
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/chadtbaseprodid.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
