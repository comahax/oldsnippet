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
    <title><bean:message bundle="chzjtyoprtcost" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('citylevel', '<bean:message bundle="chzjtyoprtcost" key="citylevel"/>', 'f', false, '3');
            addfield('ctype', '<bean:message bundle="chzjtyoprtcost" key="ctype"/>', 'f', false, '3');
            addfield('cost', '<bean:message bundle="chzjtyoprtcost" key="cost"/>', 'd', true, '14','2');
            addfield('memo', '<bean:message bundle="chzjtyoprtcost" key="memo"/>', 'c', true, '255');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/oprtcost.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_citylevel"/>
    <html:hidden property="_ne_ctype"/>
    <html:hidden property="_nnm_cost"/>
    <html:hidden property="_nnl_cost"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or requestScope.cmdState eq 'EDIT')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/OprtcostForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyoprtcost" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyoprtcost" key="citylevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                     <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="citylevel" disabled="true">
		               	 		 <html:option value=""></html:option>  
		                   		  <s:Options definition="$CH_CITYCOMPTYPE"/>
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:if>
                        <c:if test="${!updateState}">
		                   <html:select property="citylevel" >
			               	 	<option />
			                     <s:Options definition="$CH_CITYCOMPTYPE"/>
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <input name="ctype" class="form_input_1x" value="<s:Code2Name  definition='$CH_CITYCOMPTYPE' code='${form.citylevel}'/>" disabled="true"/>
		                    <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyoprtcost" key="ctype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                     <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="ctype" disabled="true">
		               	 		 <option />
		                   		  <s:Options definition="$CH_OPRCOST"/>
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:if>
                        <c:if test="${!updateState}">
		                   <html:select property="ctype" >
			               	 	  <option />
			                     <s:Options definition="$CH_OPRCOST"/>
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                        	<input name="ctype" class="form_input_1x" value="<s:Code2Name  definition='$CH_OPRCOST' code='${form.ctype}'/>" disabled="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyoprtcost" key="cost"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<input type="text" name="cost" class="form_input_1x" value="<fmt:formatNumber pattern="#0.00" value="${form.cost}" />" />
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="cost" class="form_input_1x" disabled="true" value="<fmt:formatNumber pattern="#0.00" value="${form.cost}" />" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chzjtyoprtcost" key="memo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                          <html:textarea  styleClass="form_textarea_on_4" property="memo" />
                        </c:when>
                        <c:otherwise>
                          <html:textarea  styleClass="form_textarea_on_4" property="memo" disabled="true"/>
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
                           onclick="doSave('/cms/zjty/oprtcost.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/oprtcost.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
