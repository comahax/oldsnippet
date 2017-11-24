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
    <title><bean:message bundle="mendregister" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        	addfield('mobile', '<bean:message bundle="mendregister" key="mobile"/>', 'c', false, '11');
            addfield('officetel', '<bean:message bundle="mendregister" key="officetel"/>', 'c', false, '11');
            addfield('selltime', '<bean:message bundle="mendregister" key="selltime"/>', 't', false, '7');
            
        	if(formItem.mobile.value.length != 11){
        		errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>套卡号码必须满足11位!</span>');
        		return false;
        	}
        	if(formItem.officetel.value.length != 11){
        		errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>公务机号码必须满足11位!</span>');
        		return false;
        	}
        	var now=new Date();
        	var dnow=now.getUTCFullYear()+""+now.getUTCMonth();
        	var newdate =new Date(formItem.selltime.value.substring(0,4),formItem.selltime.value.substring(5,7)-1,formItem.selltime.value.substring(8,10));
        	var dd=newdate.getUTCFullYear()+""+newdate.getUTCMonth();
        	if(!(dnow==dd)){
        		errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>不能补登记往月销售数据!</span>');
        		return false;
        	}
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/mendregister.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_mobile"/>
    <html:hidden property="_se_officetel"/>
    <html:hidden property="_de_selltime"/>
    <html:hidden property="_de_optime"/>
    <html:hidden property="_se_success"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/mendregister/MendregisterForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="mendregister" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mendregister" key="mobile"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mobile" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mobile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mendregister" key="officetel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="officetel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="officetel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mendregister" key="selltime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                    	<c:when test="${edtState}">
							<input type='text' class="form_input_1x" name="selltime"
								value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.selltime}"/>"
								onclick="this.value=selectDate()" readonly="true" />
						</c:when>
						<c:otherwise>
							<input type='text' class="form_input_1x" name="selltime"
								value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.selltime }"/>"
								disabled='true' />
						</c:otherwise>
					</c:choose>
					<font color=red>*</font>
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
                           onclick="doSave('/cms/mendregister.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/mendregister.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
