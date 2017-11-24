<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_DO = "CH_B2M_REWARD_PROVINCIAL||CH_B2M_REWARD_CIVIC";
%>
<html>
<head>
    <title><bean:message bundle="mmopn" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        	var acctype=document.all("acctype").value;
            addfield('opnid', '<bean:message bundle="mmopn" key="opnid"/>', 'c', false, '18');
            addfield('name', '<bean:message bundle="mmopn" key="name"/>', 'c', false, '22');
            addfield('entid', '<bean:message bundle="mmopn" key="entid"/>', 'c', false, '6');
            addfield('busiid', '<bean:message bundle="mmopn" key="busiid"/>', 'c', false, '10');
            addfield('acctype', '<bean:message bundle="mmopn" key="acctype"/>', 'f', false, '3');
            if(acctype==1)
            {
           		addfield('rewardstd', '<bean:message bundle="mmopn" key="rewardstd"/>', 'f', false, '10','4');
            }
            else if(acctype==2)
            {
            	addfield('rewardstd', '<bean:message bundle="mmopn" key="rewardstd"/>', 'f', false, '10','4','','0','1');
            }
            addfield('state', '<bean:message bundle="mmopn" key="state"/>', 'f', false, '1');
            addfield('ossrc', '<bean:message bundle="mmopn" key="ossrc"/>', 'f', true, '2');
            addfield('shortopn', '<bean:message bundle="mmopn" key="shortopn"/>', 'c', false, '12');
            addfield('wapurl', '<bean:message bundle="mmopn" key="wapurl"/>', 'c', true, '128');
            addfield('memo', '<bean:message bundle="mmopn" key="memo"/>', 'c', true, '512');
            addfield('opnmon', '<bean:message bundle="mmopn" key="opnmon"/>', 'c', true, '256');

            return checkval(window);
        }
         function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/bbc/mmopn.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_opnid"/>
    <html:hidden property="_sk_name"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope.cmdState eq 'EDIT')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/MmopnForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="mmopn" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="opnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="opnid" readonly="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="opnid"/>
                          	<font color=red>&nbsp;*</font>			
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnid" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="name"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="name" />
                            <font color=red>&nbsp;*</font>		
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="name" disabled="true"/>
                            <font color=red>&nbsp;*</font>		
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="entid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="entid" />
                            <font color=red>&nbsp;*</font>		
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="entid" disabled="true"/>
                            <font color=red>&nbsp;*</font>		
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="busiid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="busiid" />
                            <font color=red>&nbsp;*</font>		
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="busiid" disabled="true"/>
                            <font color=red>&nbsp;*</font>		
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="acctype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select  property="acctype" >
                            	<option />
                            	<s:Options definition="$CH_ACCTYPE" />
                            </html:select>
                            <font color=red>&nbsp;*</font>		
                        </c:when>
                        <c:otherwise>
                             <html:select  property="acctype" disabled="true">
                            	<option />
                            	<s:Options definition="$CH_ACCTYPE" />
                            </html:select>
                            <font color=red>&nbsp;*</font>		
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="rewardstd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input type="text" name="rewardstd" value="<fmt:formatNumber pattern="0.0000" value='${form.rewardstd}'/>" class="form_input_1x" />
                            <font color=red>&nbsp;*</font>		
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="rewardstd" value="<fmt:formatNumber pattern="0.0000" value='${form.rewardstd}'/>" class="form_input_1x" disabled="true"/>
                            <font color=red>&nbsp;*</font>		
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="state"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select  property="state">
                            	<option />
								<s:Options definition="#CH_STATE" />
                            </html:select>
                            <font color=red>&nbsp;*</font>		
                        </c:when>
                        <c:otherwise>
                           	<input type="text" name="rewardstd" value="<s:Code2Name definition='$CH_VALIDFLAG' code='${form.state}' />" class="form_input_1x" disabled="true"/>
                            <font color=red>&nbsp;*</font>		
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="ossrc"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select  property="ossrc" >
                            	<option />
                            	<s:Options definition="$CH_MMOSSRC" />
                            </html:select>
                        </c:when>
                        <c:otherwise>
                            <html:select  property="ossrc" disabled="true">
                            	<option />
                            	<s:Options definition="$CH_MMOSSRC" />
                            </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="shortopn"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="shortopn" />
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="shortopn" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="wapurl"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wapurl" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wapurl" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="memo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="memo" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="memo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="mmopn" key="opnmon"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opnmon" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opnmon" disabled="true"/>
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
                	<s:RewardPurChk controlid="<%=ID_DO%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/bbc/mmopn.do?CMD=SAVE')"/>
                     </s:RewardPurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/bbc/mmopn.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
