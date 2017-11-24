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
    <title><bean:message bundle="chzjtyterewardstd" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('comid', '<bean:message bundle="chzjtyterewardstd" key="comid"/>', 'c', false, '18');
            addfield('rewardstd', '<bean:message bundle="chzjtyterewardstd" key="rewardstd"/>', 'f', false, '16');
            addfield('rewardtype', '<bean:message bundle="chzjtyterewardstd" key="rewardtype"/>', 'f', false, '2');
            addfield('acctype', '<bean:message bundle="chzjtyterewardstd" key="acctype"/>', 'f', false, '3');
            addfield('standardprice', '基准价', 'f', true, '12','2'); 
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/chzjtyterewardstd.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_rewardtype"/>
    <html:hidden property="_ne_citycode"/>
    <c:set var="edtState" scope="request" value="${!empty cmdState and (cmdState eq 'EDIT' or cmdState eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty cmdState and (cmdState eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtyterewardstd/ChZjtyTerewardstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyterewardstd" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyterewardstd" key="comid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="comid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="comid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="comid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyterewardstd" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rewardstd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rewardstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyterewardstd" key="rewardtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select styleClass="form_input_1x" property="rewardtype" disabled="true">
		                        <s:Options definition="$ZJTY_TERREWARDTYPE"/>
		                    </html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select styleClass="form_input_1x" property="rewardtype">
		                        <s:Options definition="$ZJTY_TERREWARDTYPE"/>
		                    </html:select>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:select styleClass="form_input_1x" property="rewardtype" disabled="true">
		                        <s:Options definition="$ZJTY_TERREWARDTYPE"/>
		                    </html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyterewardstd" key="acctype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                        <html:select styleClass="form_input_1x" property="acctype" >
		                        <s:Options definition="#CH_ACCTYPE"/>
		                    </html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select styleClass="form_input_1x" property="acctype" disabled="true">
		                        <s:Options definition="#CH_ACCTYPE"/>
		                    </html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyterewardstd" key="adtremark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                        <html:textarea property="adtremark" rows="3" cols="30"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea property="adtremark" rows="3" cols="30" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyterewardstd" key="createtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <input type="text" class="form_input_1x" name="createtime" disabled="disabled" 
                        value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.createtime}"/>" />
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyterewardstd" key="citycode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="citycode" disabled="true">
                    	<s:Options definition="#CITYIDNUM2NMAME"/>
                    </html:select>
                </td>
            </tr>
             <tr> 
                <td width="20%" align="right" class="form_table_right"><div class="field-require">基准价:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="standardprice" />
                        <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="standardprice" disabled="true"/>
                        <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
           </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <c:choose>
                        <c:when test="${edtState}">
	                        <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doSave('/cms/zjty/chzjtyterewardstd.do?CMD=SAVE')"/>
                        </c:when>
                        <c:otherwise>
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                           onclick="doSave('/cms/zjty/chzjtyterewardstd.do?CMD=SAVE')" disabled="disabled"/>
                        </c:otherwise>
                    </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                       name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                       value="<bean:message bundle="public" key="button_return"/>" class="close"
                       onclick="doReturn('/cms/zjty/chzjtyterewardstd.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
