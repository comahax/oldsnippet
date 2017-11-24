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
    <title><bean:message bundle="chzjtyempltotal" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('yearmonth', '<bean:message bundle="chzjtyempltotal" key="yearmonth"/>', 'd', false, '6');
            var yearmonth=document.forms[0].yearmonth.value;
            if(yearmonth!=""){
            	yearmonth=trim(yearmonth);
	            var regex=new RegExp("^(\\d{4}[0][1-9])|(\\d{4}[1][0-2])$");
	            if(!regex.test(yearmonth))
	            {
	            errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[年月]</span>年月格式必须为YYYYMM</span>');
	            return false;
	            }
            }
            addfield('wayid', '<bean:message bundle="chzjtyempltotal" key="wayid"/>', 'c', false, '32');
            addfield('amount', '<bean:message bundle="chzjtyempltotal" key="amount"/>', 'd', true, 4, 2);
            addfield('memo', '<bean:message bundle="chzjtyempltotal" key="memo"/>', 'c', true, '255');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/empltotal.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_snm_yearmonth"/>
    <html:hidden property="_snl_yearmonth"/>
    <html:hidden property="_se_wayid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope.cmdState eq 'EDIT')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/empltotal/ChzjtyempltotalForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyempltotal" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyempltotal" key="yearmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
						<c:when test="${edtState}">
							<c:if test="${updateState}">
								<html:text styleClass="form_input_1x" property="yearmonth"
									maxlength="15" readonly="true" />
								<font color=red>&nbsp;*</font>(格式：YYYYMM)
							</c:if>
							<c:if test="${!updateState}">
								<html:text styleClass="form_input_1x" property="yearmonth"
									maxlength="15" />
								<input type="button" value="..." class="clickbutton" 	onclick="document.all('yearmonth').value=selectDateYYYYMM();" />
								<font color=red>&nbsp;*</font>(格式：YYYYMM)
							</c:if>
						</c:when>
						<c:otherwise>
							<html:text styleClass="form_input_1x" property="yearmonth"
								disabled="true" />
							<font color=red>&nbsp;*</font>(格式：YYYYMM)
						</c:otherwise>
					</c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyempltotal" key="wayid"/>:</div></td>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyempltotal" key="amount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="amount" maxlength="7"/>(个)
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="amount" disabled="true"/>(个)
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyempltotal" key="memo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea  styleClass="form_textarea_on_4" property="memo" />
                        </c:when>
                        <c:otherwise>
                            <html:textarea  styleClass="form_textarea_on_4" property="memo"  disabled="true"/>
                        </c:otherwise>
                    </c:choose>
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
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/zjty/empltotal.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/empltotal.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
