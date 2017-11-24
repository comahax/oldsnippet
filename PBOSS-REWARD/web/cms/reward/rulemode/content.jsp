<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="rulemode" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('rulemodeid', '<bean:message bundle="rulemode" key="rulemodeid"/>', 'f', false, '8');
            addfield('ruleid', '<bean:message bundle="rulemode" key="ruleid"/>', 'c', false, '18');
            addfield('cityid', '<bean:message bundle="rulemode" key="cityid"/>', 'c', false, '4');
            addfield('rulemodename', '<bean:message bundle="rulemode" key="rulemodename"/>', 'c', false, '250');
            addfield('startdate', '<bean:message bundle="rulemode" key="startdate"/>', 'dt', false, '19');
            addfield('enddate', '<bean:message bundle="rulemode" key="enddate"/>', 'dt', false, '19');
            addfield('remark', '<bean:message bundle="rulemode" key="remark"/>', 'c', true, '500');
            if(date_compare("startdate","enddate",'失效时间必须晚于生效时间')) return false;
            return checkval(window);
        }
        function selectDate(paramTime) {
       		var arg = new Object();
        	var valTime = null;
        	if(paramTime == 'start'){
        		valTime = formItem.startdate.value;
        	}else{
        		valTime = formItem.enddate.value;
        	}
        	var strTime = valTime.substring(0,4)+valTime.substring(5,7);
			var rtn = window.showModalDialog(contextPath + "/js/bus/selectmon.html", strTime, "dialogWidth=240px;dialogHeight=170px;status:no;scroll=no;resizable:yes;")
			if (rtn != null) {
				year = rtn.substring(0, 4);
				month = rtn.substring(4, 6);
				if(paramTime == 'start'){
					rtn = year +'-'+ month +'-01 00:00:00';
				}else{
					var flag = false;
					for(var i=31;i>=28;i--){
						var d = new Date(year, month - 1, i);
						if (d.getFullYear() == year && (d.getMonth() + 1) == month && d.getDate() == i) {
							flag = true;
							break;
						}
					}
					if(flag == true){
						rtn = d.getFullYear() +'-'+ month +'-'+ d.getDate() +' 23:59:59';
					}
				}
			}
			return (rtn == null ? "" : rtn);
		}
		function checkDate(){
			if(formItem.startdate.value=='' || formItem.startdate.value==null || formItem.enddate.value=='' || formItem.enddate.value==null){
			}else{
				if(formItem.rulemodeid == undefined){
					ajaxAnywhere.submitByURL('/cms/reward/rulemode.do?CMD=CHECKDATE');
				}else{
					formItem.rulemodeid.disabled = false;
					ajaxAnywhere.submitByURL('/cms/reward/rulemode.do?CMD=CHECKDATE');
					formItem.rulemodeid.disabled = true;
				}
			}
		}
       
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/rulemode.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_ruleid"/>
    <html:hidden property="_se_cityid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/rulemode/RulemodeForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rulemode" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    
    <div class="table_div">	
    	<aa:zone name="errorZone">
	   		<table width="100%" class="error_text">
	    		<html:errors/><s:Msg />
	    	</table>
    	</aa:zone>
    </div>
    

    <div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulemode" key="rulemodeid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="rulemodeid" disabled="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="" value="系统自动生成" disabled="true"/>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rulemodeid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulemode" key="ruleid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="ruleid" disabled="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <input type="text" name="ruleid" class="form_input_1x" disabled="disabled" value="<c:out value='${form._se_ruleid}'/>" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="ruleid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulemode" key="cityid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                        	<input type="hidden" name="cityid" value="<c:out value='${form.cityid}'/>"/>
                            <input type="text" class="form_input_1x" disabled="disabled" value="<s:Code2Name code='${form.cityid}' definition='#CITYIDNUM2NMAME'/>" />
                        </c:if>
                        <c:if test="${!updateState}">
                        	<input type="hidden" name="cityid" value="<c:out value='${form._se_cityid}'/>"/>
                            <input type="text" class="form_input_1x" disabled="disabled" value="<s:Code2Name code='${form._se_cityid}' definition='#CITYIDNUM2NMAME'/>" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                        	<input type="hidden" name="cityid" value="<c:out value='${form.cityid}'/>"/>
                            <input type="text" class="form_input_1x" disabled="disabled" value="<s:Code2Name code='${form.cityid}' definition='#CITYIDNUM2NMAME'/>" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulemode" key="rulemodename"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="rulemodename" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rulemodename" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color='red'>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulemode" key="startdate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                        	<input type='text' class="form_input_1x" name="startdate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.startdate }"/>"	
                        		onclick="this.value=selectDate('start');checkDate();" />
                    	</c:when>
                    	<c:otherwise>
                    		<input type='text' class="form_input_1x" name="startdate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.startdate }"/>" disabled='true' />
                    	</c:otherwise>
                   	</c:choose>
                    <font color='red'>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulemode" key="enddate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                        	<input type='text' class="form_input_1x" name="enddate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.enddate }"/>"	
                        		onclick="this.value=selectDate('end');checkDate();"/>
                    	</c:when>
                    	<c:otherwise>
                    		<input type='text' class="form_input_1x" name="enddate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${form.enddate }"/>" disabled='true' />
                    	</c:otherwise>
                    </c:choose>
                    <font color='red'>*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="rulemode" key="remark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                	<c:choose>
                        <c:when test="${edtState}">
                    		<html:textarea property="remark" styleClass="form_textarea_on" />
                    	</c:when>
                    	<c:otherwise>
                    		<html:textarea property="remark" styleClass="form_textarea_on" disabled="true"/>
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
		                           onclick="doSave('/cms/reward/rulemode.do?CMD=SAVE')"/>
		                </c:when>
		                <c:otherwise>
	                    	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
		                           onclick="doSave('/cms/reward/rulemode.do?CMD=SAVE')" disabled="disabled"/>
	                    </c:otherwise>
                    </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/rulemode.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
