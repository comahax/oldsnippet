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
    <title><bean:message bundle="waitaudit" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('taskstate', '<bean:message bundle="waitaudit" key="taskstate"/>', 'c', false, '2');
            addfield('memo', '<bean:message bundle="waitaudit" key="memo"/>', 'c', true, '200');

            return checkval(window);
        }
        
        function doSubmit() {
        	if (ev_checkval()) {
		        enable();
		        var btnSave = document.getElementById('btnSave');
		        btnSave.disabled = true;
		        formItem.submit();
		    }
		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/waitaudit.do?CMD=AUDIT" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

       <html:hidden property="taskid"/>
       <html:hidden property="filecode"/>
       <html:hidden property="subsystem"/>
       <html:hidden property="logfile"/>
       <html:hidden property="oprcode"/>
       <html:hidden property="wayid"/>
       <input type='hidden' name="createtime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/waitaudit/WaitauditForm'].createtime }"/>"	 />
       <html:hidden property="auditoprcode"/>
       <html:hidden property="auditwayid"/>
       <input type='hidden' name="audittime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${requestScope['/cms/waitaudit/WaitauditForm'].audittime }"/>"	 />
       <html:hidden property="totalcount"/>
       <html:hidden property="currentcount"/>
	   <html:hidden property="successcount"/>
       <html:hidden property="resultfile"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waitaudit" key="titleList"/>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waitaudit" key="taskstate"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                            <html:select property="taskstate">
			                    	<option />
		                    		<option value="1"  selected>已通过</option>
									<option value="-1" >未通过</option>
			                    </html:select>
			                    <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        		<html:select property="taskstate" disabled="true">
			                    	<s:Options definition="$CH_AUDITSTATUS" />
			                    </html:select>
			                    <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waitaudit" key="memo"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea  property="memo" cols="40" rows="5"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea  property="memo" cols="40" rows="5" readonly="true"/>  
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td>
                	<c:choose>
                        <c:when test="${edtState}">
	                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" id="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="waitaudit" key="dealwith"/>" class="submit" onclick="doSubmit()"/>
                        </c:when>
                        <c:otherwise>
                        		<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="waitaudit" key="dealwith"/>" class="submit" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" id="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/waitaudit.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
