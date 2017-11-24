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
    <title><bean:message bundle="chadtrulerel" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('ruleitemid', '<bean:message bundle="chadtrulerel" key="ruleitemid"/>', 'c', false, '50');
            addfield('paramer', '<bean:message bundle="chadtrulerel" key="paramer"/>', 'c', false, '500');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/fee/chadtrulerel.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_ruleitemid"/>
    <html:hidden property="_se_ruleid"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="_ne_state"/>
    <html:hidden property="_ne_isdefault"/>
    <html:hidden property="_ne_rulemodeid"/>
    <html:hidden property="_se_paramer"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/fee/chadtrulerel/ChadtrulerelForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtrulerel" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrulerel" key="ruleitemid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                    
                    	<c:when test="${edtState}">
                            <!--  <html:text styleClass="form_input_1x" property="ruleitemid" /> -->
                            <html:select property="ruleitemid">
		                    	<s:Options definition="#ZJ_CZHY" />
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="ruleitemid" disabled="true" >
		                    	<s:Options definition="#ZJ_CZHY" />
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtrulerel" key="paramer"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <html:textarea property="paramer" styleClass="form_textarea_on"
										/>
                        </c:when>
                        <c:otherwise>
                        <html:textarea property="paramer" styleClass="form_textarea_on"
										disabled="true" />
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
	                           onclick="doSave('/fee/chadtrulerel.do?CMD=SAVE')"/>
                        </c:when>
                        <c:otherwise>
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
		                           onclick="doSave('/fee/chadtrulerel.do?CMD=SAVE')" disabled="disabled"/>
                        </c:otherwise>
                    </c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/fee/chadtrulerel.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
    
<div style="text-align:left">
全球通和预付费都是20个参数，填写格式为：参数1|参数1|。。。。。。<br>
例如：1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|
</div>

</html:form>
</div>
</body>
</html>
