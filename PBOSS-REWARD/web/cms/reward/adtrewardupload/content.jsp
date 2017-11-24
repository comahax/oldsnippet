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
    <title><bean:message bundle="adtrewardupload" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('taskid', '<bean:message bundle="adtrewardupload" key="taskid"/>', 'f', false, '10');
            addfield('uploadfile', '<bean:message bundle="adtrewardupload" key="uploadfile"/>', 'c', false, '200');
            addfield('taskstate', '<bean:message bundle="adtrewardupload" key="taskstate"/>', 'f', false, '1');
            addfield('resultfile', '<bean:message bundle="adtrewardupload" key="resultfile"/>', 'c', false, '200');
            addfield('oprcode', '<bean:message bundle="adtrewardupload" key="oprcode"/>', 'c', false, '15');
            addfield('uploadtime', '<bean:message bundle="adtrewardupload" key="uploadtime"/>', 't', false, '7');
            addfield('endtime', '<bean:message bundle="adtrewardupload" key="endtime"/>', 't', false, '7');
            addfield('totalcount', '<bean:message bundle="adtrewardupload" key="totalcount"/>', 'f', false, '7');
            addfield('currentcount', '<bean:message bundle="adtrewardupload" key="currentcount"/>', 'f', false, '7');
            addfield('successcount', '<bean:message bundle="adtrewardupload" key="successcount"/>', 'f', false, '7');
            addfield('failcount', '<bean:message bundle="adtrewardupload" key="failcount"/>', 'f', false, '7');
            addfield('mobile', '<bean:message bundle="adtrewardupload" key="mobile"/>', 'c', false, '13');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/adtrewardupload.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_taskid"/>
    <html:hidden property="_ne_taskstate"/>
    <html:hidden property="_se_oprcode"/>
    <html:hidden property="_dnm_uploadtime"/>
    <html:hidden property="_dnl_uploadtime"/>
    <html:hidden property="_se_mobile"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/adtrewardupload/AdtrewarduploadForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="adtrewardupload" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="taskid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="taskid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="taskid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="taskid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="uploadfile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="uploadfile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="uploadfile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="taskstate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="taskstate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="taskstate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="resultfile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="resultfile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="resultfile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="oprcode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="oprcode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="oprcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="uploadtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="uploadtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="uploadtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="endtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="endtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="endtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="totalcount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="totalcount" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="totalcount" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="currentcount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="currentcount" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="currentcount" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="successcount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="successcount" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="successcount" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="failcount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="failcount" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="failcount" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="adtrewardupload" key="mobile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mobile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mobile" disabled="true"/>
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
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/adtrewardupload.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/adtrewardupload.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
