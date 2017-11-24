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
    <title><bean:message bundle="coefrevision" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('exmnid', '<bean:message bundle="coefrevision" key="exmnid"/>', 'i', false, 6);
            addfield('wayid', '<bean:message bundle="coefrevision" key="wayid"/>', 'c', false, 32);
            addfield('exmnperiod', '<bean:message bundle="coefrevision" key="exmnperiod"/>', 'c', false, 6);
            addfield('coefficient', '<bean:message bundle="coefrevision" key="coefficient"/>', 'f', false, 10);

            return checkval(window);
        }
        
        function showExamineInfo(){
        	var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/examine.do?CMD=examinelist',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
        	if(returnValue!=undefined){
        		var strs=returnValue.split(",");
        		document.getElementsByName("exmnid")[0].value=strs[0];
  			}
  		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/coefrevision.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_seqid"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_snm_exmnperiod"/>
    <html:hidden property="_se_exmnperiod"/>
    <html:hidden property="_snl_exmnperiod"/>
    <html:hidden property="_ne_coefficient"/>
    <html:hidden property="seqid" />
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/coefrevision/CoefrevisionForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="coefrevision" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="coefrevision" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'wayid','','','AG');this.value='...';" />
									<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="coefrevision" key="exmnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="exmnid" readonly="true"/><input type="button" value="..." class="clickbutton"
								onclick="showExamineInfo();this.value='...';" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exmnid" disabled="true"/><input type="button" value="..." class="clickbutton"
								onclick="showExamineInfo();this.value='...';" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="coefrevision" key="exmnperiod"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="exmnperiod" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"/>
                            <font color="red">*</font>&nbsp;（格式：201002）
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exmnperiod" disabled="true"/>&nbsp;（格式：201002）
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="coefrevision" key="coefficient"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="coefficient" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="coefficient" disabled="true"/>
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
                           onclick="doSave('/cms/examine/coefrevision.do?CMD=SAVE')"/>
                        </c:when>
                        <c:otherwise>
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/examine/coefrevision.do?CMD=SAVE')" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/coefrevision.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
