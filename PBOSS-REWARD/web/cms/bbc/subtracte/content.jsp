<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="subtract" key="titleUpdate2"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
        	var form=document.forms[0];
        	var calcmonth=form.all['calcmonth'].value;
        	if(calcmonth.length>0){
	        	if(!isDateYYYYMM(calcmonth)){
		        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[计酬月份]</span>请输入正确的日期格式:YYYYMM</span>');
		        	return false;
	        	}
        	}
            addfield('calcmonth', '<bean:message bundle="subtract" key="calcmonth"/>', 'c', false, '6');
            addfield('empmobile', '<bean:message bundle="subtract" key="empmobile"/>', 'c', false, '15');
            
            return checkval(window);
        }
        function isDateYYYYMM(str) {
			var reg = /^(\d{1,4})(\d{1,2})/;
			var r = str.match(reg);
			if (r == null) {
				return false;
			} else {
				var d = new Date(r[1], r[2] - 1);
				if (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2]) {
					return true;
				} else {
					return false;
				}
			}
		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/bbc/subtracte.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="seq"/>
    <html:hidden property="_sk_empmobile"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/SubtracteForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="subtract" key="titleUpdate2"/>
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
        		<td colspan=4 align=left>
        			<font color=blue>
        				基本信息
        			</font>
        		</td>
        	</tr>
        	 <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="subtract" key="empmobile"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<c:if test="${!updateState}">
                        		<html:text styleClass="form_input_1x" property="empmobile"/>
                        		<font color=red>&nbsp;*</font>
                        	</c:if>
                        	<c:if test="${updateState}">
                        		<html:text styleClass="form_input_1x" property="empmobile" disabled="true"/>
							<font color=red>&nbsp;*</font>
                        	</c:if>         
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="empmobile" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
           </tr>
           <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="subtract" key="calcmonth"/>:</div></td>
                <td width="30%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="calcmonth" onclick="this.value=selectDateYYYYMM();"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="calcmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
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
                           onclick="doSave('/cms/bbc/subtracte.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/bbc/subtracte.do?CMD=LIST')">  
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
