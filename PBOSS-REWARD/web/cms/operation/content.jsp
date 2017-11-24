<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "rttp_2B||CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title><bean:message bundle="operation" key="title"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('businesstype', '<bean:message bundle="operation" key="businesstype"/>', 'c', true, '18');
            addfield('name', '<bean:message bundle="operation" key="name"/>', 'c', false, '50');
            addfield('state', '<bean:message bundle="operation" key="state"/>', 'i', false, '2');
            addfield('remark', '<bean:message bundle="operation" key="remark"/>', 'c', true, '255');
            var result = checkval(window);
            if(result){
            	if(formItem.state.value == 0){
            		if(!confirm("如果状态设置为失效，所有子类型的状态也会设置为失效，确定吗？")){
            			result = false;
            		}
            	}
            }
            return result;
        }
        function removeOption(){
        	var obj = formItem.state;
        	if(obj != null){
        		var s = obj.options;
        		for(var i=0; i<s.length; i++){
        			if(s[i].value == "-1")
						s.remove(i);
				}
        	}
        }
    </script>
</head>
<body onload="removeOption()">
<div class="table_container">
<html:form action="/cms/operation.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_sk_name"/>
    <html:hidden property="_se_opnid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="operation" key="title"/>
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
        	<tr >
				<td align=left colspan="4">&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/>
				</td>
			</tr>
			<tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operation" key="opnid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opnid" maxlength="18" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        	<tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operation" key="name"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="name" maxlength="50"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="name" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        	<tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operation" key="parentid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState and not updateState}">
        	                <html:text styleClass="form_input_1x" property="parentid" readonly="true"></html:text>
                    		<input type="button" value="..." class="clickButton" onclick="showOpnTree(this, 'parentid', 'opn')">
                   		</c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="parentid" disabled="true"></html:text> 
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operation" key="state"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="state">
                        		    <option/>
                        		    <s:Options definition="$CH_VALIDFLAG"/>
                        	  </html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="state" disabled="true">
                        		    <option/>
                        		    <s:Options definition="$CH_VALIDFLAG"/>
                        	  </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="operation" key="remark"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea styleClass="form_textarea_on_4" property="remark"/>
                        </c:when>
                        <c:otherwise>
                            <html:textarea styleClass="form_textarea_on_4" property="remark" disabled="true"/>
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
            	  <s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/operation.do?CMD=SAVE')"/>
                  </s:PurChk2>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/operation.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
