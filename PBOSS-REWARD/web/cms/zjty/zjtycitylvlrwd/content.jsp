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
    <title><bean:message bundle="zjtycitylvlrwd" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('cityid', '<bean:message bundle="zjtycitylvlrwd" key="cityid"/>', 'c', false, '3');
            addfield('rwdupper', '<bean:message bundle="zjtycitylvlrwd" key="rwdupper"/>', 'f', true, '16','2');
            return checkval(window);
        }
        function resetBtn(){
        	formItem.rwdupper.disabled = false;
        	document.getElementById("btnSave").disabled = false; 
        }
    </script>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/zjty/zjtycitylvlrwd.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtycitylvlrwd" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtycitylvlrwd" key="cityid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select property="cityid" disabled="true">
		               	 		 <html:option value=""></html:option>  
		                   		  <s:Options definition="$region"/>
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:if>
                        <c:if test="${!updateState}">
		                   <html:select property="cityid" >
			               	 	 <html:option value=""></html:option>  
			                     <s:Options definition="$region"/>
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                             <html:select property="cityid" disabled="true">
			               	 	 <html:option value=""></html:option>  
			                     <s:Options definition="$region"/>
		                    </html:select>
		                    <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="zjtycitylvlrwd" key="rwdupper"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
               		<c:choose>
                        <c:when test="${edtState}">
                  	 		<html:text styleClass="form_input_1x" property="rwdupper" />
                  	 	</c:when>
                  	 	<c:otherwise>
                  	 		<html:text styleClass="form_input_1x" property="rwdupper" disabled="true"/>
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
                	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_modify"/>" class="submit"
                           onclick="resetBtn()" />
                  	<input id="btnSave" type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/zjty/zjtycitylvlrwd.do?CMD=SAVE')" disabled="true"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/zjty/zjtycitylvlrwd.do?CMD=SET')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
