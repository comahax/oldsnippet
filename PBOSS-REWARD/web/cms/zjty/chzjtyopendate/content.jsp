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
    <title><bean:message bundle="chzjtyopendate" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('wayid', '<bean:message bundle="chzjtyopendate" key="wayid"/>', 'c', false, '32');
            addfield('opendate', '<bean:message bundle="chzjtyopendate" key="opendate"/>', 't', false, '7');
            addfield('memo', '<bean:message bundle="chzjtyopendate" key="memo"/>', 'c', true, '255');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/opendate.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_dnm_opendate"/>
    <html:hidden property="_dnl_opendate"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope.cmdState eq 'EDIT')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/OpendateForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyopendate" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyopendate" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
						<c:when test="${edtState}">
							<c:if test="${updateState}">
								<html:text styleClass="form_input_1x" property="wayid"
									readonly="true" />
								<font color=red>&nbsp;*</font>
							</c:if>
							<c:if test="${!updateState}">
							<html:text styleClass="form_input_1x" property="wayid" readonly="true"/>
							<input type="button" value="..." class="clickbutton"
								onclick="showSelectWay3(this,'wayid','','','AG','ZJTY','1');this.value='...';" />
								<font color=red>&nbsp;*</font>
							</c:if>
						</c:when>
						<c:otherwise>
							 <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                           	<font color=red>&nbsp;*</font>
						</c:otherwise>
					</c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyopendate" key="opendate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input type=text name='opendate'  class="form_input_1x" value='<fmt:formatDate value="${form.opendate}" type="date" pattern="yyyy-MM-dd"/>'/>
                            <input type="button" class="clickbutton" value="..." onclick="document.all('opendate').value=selectDate()" >
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <input name="opendate" class="form_input_1x" value="<fmt:formatDate  pattern="yyyy-MM-dd" value='${form.opendate}'/>" disabled="true"/>
                             <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyopendate" key="memo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <html:textarea  styleClass="form_textarea_on_4" property="memo" />
                        </c:when>
                        <c:otherwise>
                           <html:textarea  styleClass="form_textarea_on_4" property="memo" disabled="true"/>
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
                           onclick="doSave('/cms/zjty/opendate.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/opendate.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
