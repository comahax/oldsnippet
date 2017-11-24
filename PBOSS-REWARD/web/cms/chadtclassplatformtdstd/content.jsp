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
    <title><bean:message bundle="chadtclassplatformtdstd" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            //addfield('seq', '<bean:message bundle="chadtclassplatformtdstd" key="seq"/>', 'f', false, '14');
            addfield('comid', '<bean:message bundle="chadtclassplatformtdstd" key="comid"/>', 'f', false, '36');
            addfield('rewardtype', '<bean:message bundle="chadtclassplatformtdstd" key="rewardtype"/>', 'f', false, '3');
            addfield('acctype', '<bean:message bundle="chadtclassplatformtdstd" key="acctype"/>', 'f', false, '3');
            addfield('saleslower', '<bean:message bundle="chadtclassplatformtdstd" key="saleslower"/>', 'f', true, '10');
            addfield('salesupper', '<bean:message bundle="chadtclassplatformtdstd" key="salesupper"/>', 'f', true, '10');
            addfield('rewardstd', '<bean:message bundle="chadtclassplatformtdstd" key="rewardstd"/>', 'f', false, '10');
            addfield('citycode', '<bean:message bundle="chadtclassplatformtdstd" key="citycode"/>', 'f', false, '3');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chadtclassplatformtdstd.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_comid"/>
    <html:hidden property="_ne_rewardtype"/>
    <html:hidden property="_ne_citycode"/>
    <html:hidden property="seq"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtclassplatformtdstd" key="titleList"/>
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
        
        <!-- 
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdstd" key="seq"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="seq" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="seq" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="seq" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
             -->
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdstd" key="comid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <s:Comidtree styleClass="form_input_1x" property="comid" condition="comclassid:2;comclassid:5;comclassid:6;comclassid:99;comclassid:1" definition="#COMSYSTEM" nameOnly="false"  readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="comid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdstd" key="rewardtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                          <html:select property="rewardtype">
									<html:option value=""></html:option>
									<s:Options definition="$CH_CPFTDREWARDTYPE" />
							</html:select>
                        </c:when>
                        <c:otherwise>
                         <html:select property="rewardtype"  disabled="true">
									<html:option value=""></html:option>
									<s:Options definition="$CH_CPFTDREWARDTYPE" />
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdstd" key="acctype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        
                         <html:select property="acctype">
									<s:Options definition="#CLASSPLATFORMTDSTD_ACCTYPE" />
							</html:select>
                        </c:when>
                        <c:otherwise>
                        
                         <html:select property="acctype"  disabled="true">
									<s:Options definition="#CLASSPLATFORMTDSTD_ACCTYPE" />
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdstd" key="saleslower"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="saleslower" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="saleslower" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdstd" key="salesupper"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="salesupper" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="salesupper" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdstd" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <!-- 
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdstd" key="citycode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                          <html:select property="citycode">
								<option />
									<s:Options definition="#CITYIDNUM2NMAME" />
							</html:select>
                        </c:when>
                        <c:otherwise>
                         <html:select property="citycode"  disabled="true">
								<option />
									<s:Options definition="#CITYIDNUM2NMAME" />
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
             -->
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/chadtclassplatformtdstd.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/chadtclassplatformtdstd.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
