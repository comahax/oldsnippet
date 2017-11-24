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
    <title><bean:message bundle="exmnitem" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('exmnid', '<bean:message bundle="exmnitem" key="exmnid"/>', 'f', false, '6');
            addfield('exmnstdid', '<bean:message bundle="exmnitem" key="exmnstdid"/>', 'f', false, '6');
            addfield('isvoted', '<bean:message bundle="exmnitem" key="isvoted"/>', 'c', false, '1');
            addfield('exmnscore', '<bean:message bundle="exmnitem" key="exmnscore"/>', 'f', false, '10','2');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/exmnitem.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="_ne_exmnstdid"/>
    <html:hidden property="_se_isvoted"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnitem/ExmnitemForm']}"/>
	 <input type="hidden" name="exmnid" value="<c:out value='${form._ne_exmnid}' />">
	  <input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
	 <input type="hidden" id="exmncityid" name="exmncityid" value="<c:out value="${exmncityid}"/>">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnitem" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnitem" key="exmnstdid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <s:zoom definition="#EXAMINESTD" property="exmnstdid"
											styleClass="form_input_1x"  disabled="true"/>
							<font color="red">*</font>
                        </c:if>
                        <c:if test="${!updateState}">
                            <s:zoom definition="#EXAMINESTD" property="exmnstdid"
											styleClass="form_input_1x" />
							<font color="red">*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                             <s:zoom definition="#EXAMINESTD" property="exmnstdid"
											styleClass="form_input_1x" disabled="true"/>
							<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnitem" key="isvoted"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                             <html:select property="isvoted">
	                   		    <option/>
	                   		    <s:Options definition="#ISVOTED"/>
                     		</html:select>
                     		<font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                             <html:select property="isvoted" disabled="true">
	                   		    <option/>
	                   		    <s:Options definition="#ISVOTED"/>
                     		</html:select>
                     		<font color="red">*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="exmnitem" key="exmnscore"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="exmnscore" />
                            <font color="red">*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exmnscore" disabled="true"/>
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
                           onclick="doSave('/cms/examine/exmnitem.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/exmnitem.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
 <script language="JavaScript">
	if(document.getElementsByName("isvoted")[0].value=="")
		document.getElementsByName("isvoted")[0].value='0';
	if(document.getElementsByName("cmdState")[0].value=='EDIT'){//编辑的时候
     		var provincialright=document.getElementById("provincialright").value;
     		var exmncityid=document.getElementById("exmncityid").value;
     		if((provincialright!='YES' && exmncityid=='GD') || (provincialright=='YES' && exmncityid!='GD')){//对省公司考核只允许查看
     			document.getElementsByName("exmnstdid")[0].disabled=true;
     			document.getElementsByName("isvoted")[0].disabled=true;
     			document.getElementsByName("exmnscore")[0].disabled=true;
     			document.getElementsByName("btnSave")[0].disabled=true;
     		}
     }
 </script>
</html>
