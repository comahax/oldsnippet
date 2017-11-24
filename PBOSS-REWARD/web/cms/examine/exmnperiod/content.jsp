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
    <title><bean:message bundle="exmnperiod" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seqid', '<bean:message bundle="exmnperiod" key="seqid"/>', 'f', true, '6');
            addfield('exmnid', '<bean:message bundle="exmnperiod" key="exmnid"/>', 'f', false, '6');
            addfield('beginmonth', '<bean:message bundle="exmnperiod" key="beginmonth"/>', 'f', false, '2');
            addfield('endmonth', '<bean:message bundle="exmnperiod" key="endmonth"/>', 'f', false, '2');
            return (checkval(window) && checkMonth()) ;
        }
        function checkMonth(){
        	var beginmonth=document.getElementsByName("beginmonth")[0].value;
        	var endmonth=document.getElementsByName("endmonth")[0].value;
        	if(beginmonth<1 || beginmonth>12){
        		var alertstr="<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="exmnperiod" key="beginmonth"/>]</span>应在1-12范围内</span>";
				errorMessageShow(alertstr);
				return false;
        	}
        	if(endmonth<1 || endmonth>12){
        		var alertstr="<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="exmnperiod" key="endmonth"/>]</span>应在1-12范围内</span>";
				errorMessageShow(alertstr);
				return false;
        	}
        	/*if(beginmonth>=endmonth){
        		var alertstr="<span class=\'errorkey\'><bean:message bundle="exmnperiod" key="beginmonth"/>不能大于等于<bean:message bundle="exmnperiod" key="endmonth"/></span>";
				errorMessageShow(alertstr);
				return false;
        	}*/
        	return true;
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/exmnperiod.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="seqid"/>
    
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnperiod/ExmnperiodForm']}"/>
	 <input type="hidden" name="exmnid" value="<c:out value='${form._ne_exmnid}' />">
	 <input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
	 <input type="hidden" id="exmncityid" name="exmncityid" value="<c:out value="${exmncityid}"/>">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnperiod" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnperiod" key="beginmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="beginmonth" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="beginmonth" disabled="true"/>
                            <font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnperiod" key="endmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="endmonth" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="endmonth" disabled="true"/>
                            <font color="red">*</font>
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
                           onclick="doSave('/cms/examine/exmnperiod.do?CMD=SAVE')"/>
                   
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/exmnperiod.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
<script language="JavaScript">
     	if(document.getElementsByName("cmdState")[0].value=='EDIT'){//编辑的时候
     		var provincialright=document.getElementById("provincialright").value;
     		var exmncityid=document.getElementById("exmncityid").value;
     		if((provincialright!='YES' && exmncityid=='GD') || (provincialright=='YES' && exmncityid!='GD')){//对省公司考核只允许查看
     			document.getElementsByName("beginmonth")[0].disabled=true;
     			document.getElementsByName("endmonth")[0].disabled=true;
     			document.getElementsByName("btnSave")[0].disabled=true;
     		}
     	}
     	
 </script>
</html>
