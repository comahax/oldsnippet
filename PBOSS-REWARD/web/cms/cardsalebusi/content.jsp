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
    <title><bean:message bundle="cardsalebusi" key="titleUpdate"/></title>
	<script type="text/javascript"
		src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('opntime', '<bean:message bundle="cardsalebusi" key="opntime"/>', 'dt', false, '25');
            addfield('mobile', '<bean:message bundle="cardsalebusi" key="mobile"/>', 'i', false, '11');
            addfield('brand', '<bean:message bundle="cardsalebusi" key="brand"/>', 'i', false, '22');
            addfield('opntype', '<bean:message bundle="cardsalebusi" key="opntype"/>', 'c', false, '18');
            addfield('wayid', '<bean:message bundle="cardsalebusi" key="wayid"/>', 'c', false, '18');
            addfield('retailprice', '<bean:message bundle="cardsalebusi" key="retailprice"/>', 'd', true, '16','2');
            addfield('buyprice', '<bean:message bundle="cardsalebusi" key="buyprice"/>', 'd', true, '16','2');
            addfield('discount', '<bean:message bundle="cardsalebusi" key="discount"/>', 'd', true, '16','2');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/cardsalebusi.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_itemid"/>
    <html:hidden property="itemid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
	<c:set var="item" scope="request" value="${requestScope['/cms/cardsalebusi/CardsalebusiForm']}" />
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="cardsalebusi" key="titleList"/>
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
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cardsalebusi" key="opntime"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <input class="form_input_1x" name="opntime"
										value="<fmt:formatDate value="${item.opntime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
										readonly onclick="this.value=selectDatetime();"><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <input class="form_input_1x" name="opntime"
										value="<fmt:formatDate value="${item.opntime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
										disabled>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cardsalebusi" key="mobile"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mobile" maxlength="11"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mobile" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cardsalebusi" key="brand"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="brand">
                        		<option />
                        		<s:Options  definition="#BUSI_BRAND"/>
                        	</html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select property="brand" disabled="true">
                        		<option />
                        		<s:Options  definition="#BUSI_BRAND"/>
                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cardsalebusi" key="opntype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="opntype" readonly="true"></html:text>
                    		<input type="button" value="..." class="clickButton" onclick="showOpnfifthTree(this, 'opntype', 'opn5')"><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="opntype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cardsalebusi" key="wayid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18" onclick="showSelectWay(wayid)" readonly="true"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cardsalebusi" key="retailprice"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="retailprice" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="retailprice" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cardsalebusi" key="buyprice"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="buyprice" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="buyprice" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="cardsalebusi" key="discount"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="discount" maxlength="18"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="discount" disabled="true"/>
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
            	  <s:PurChk controlid="<%=ID_1%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/cardsalebusi.do?CMD=SAVE')"/>
                  </s:PurChk>
                 <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                 </s:PurChk>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/cardsalebusi.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
