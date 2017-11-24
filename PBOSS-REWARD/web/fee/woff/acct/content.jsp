<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="4D6F1A1AAA" />
</jsp:include>
<%
	String ID_1 = "4D6F1A1AAABT1";
    String ID_2 = "4D6F1A1AAABT2";
    String ID_3 = "4D6F1A1AAABT3";
%>
<html:html>
<head>
    <title><bean:message bundle="acct" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('acctid', '<bean:message bundle="acct" key="acctid"/>', 'l', false, 14);
            addfield('acctname', '<bean:message bundle="acct" key="acctname"/>', 'c', false, 128);
            addfield('accttype', '<bean:message bundle="acct" key="accttype"/>', 'i', false, 3);
            addfield('acctstate', '<bean:message bundle="acct" key="acctstate"/>', 'i', false, 3);
            addfield('starttime', '<bean:message bundle="acct" key="starttime"/>', 't', false, 10);
            addfield('stoptime', '<bean:message bundle="acct" key="stoptime"/>', 't', false, 10);
            addfield('acctlevel', '<bean:message bundle="acct" key="acctlevel"/>', 'i', false, 3);
            addfield('limitflag', '<bean:message bundle="acct" key="limitflag"/>', 'c', true, 10);
            addfield('woffpri', '<bean:message bundle="acct" key="woffpri"/>', 'i', false, 10);
            addfield('acctcode', '<bean:message bundle="acct" key="acctcode"/>', 'c', false, 12);
            addfield('printname', '<bean:message bundle="acct" key="printname"/>', 'c', false, 128);
            if(date_compare('starttime','stoptime','<bean:message bundle="acct" key="condition"/>')) return;
            makeLimitFlag();
            return checkval(window);
        }
        //make limitflag
      	function makeLimitFlag(){
      		var limitfg = '';
      		for( i=0; i<document.formItem.limitbox.length; i++ ){
      			limitfg += document.formItem.limitbox[i].checked ? '1':'0';
      		}
      		document.all.limitflag.value = limitfg;
      		//alert(limitfg);
      	}
      	//limitflag split
      	function init_limitflag(){
      		var limitfg = document.all.limitflag.value;
      		if( limitfg!="" ){
      			for( i=0; i<document.formItem.limitbox.length; i++ ){
      				if( limitfg.charAt(i)=='1' ) document.formItem.limitbox[i].checked = true;
      			}
      		}
      		checkAcctSet( true );
      	}
      	// acctset
      	function checkAcctSet( bInit ){
      		var zoom = document.all("acctsetid_zoom");
      		var acctset = document.all("acctsetid");
      		
      		if( acctset!=null && zoom!=null ) {
      			if( !bInit ){
      				acctset.value = "";
      				zoom.value = "";
      			}
	      		if( document.formItem.acctlevel.value=='1' ) {
	      			zoom.disabled = false;
	      		} else {
	      			zoom.disabled = true;
	      		}
      		}
      	} 
      	// load old acctlevel
      	function loadOldAcctLev(){
      		document.formItem.oldAcctlev.value = document.formItem.acctlevel.value;
      	}
    </script>
</head>
<body onload="init_limitflag();loadOldAcctLev();loadforiframe();">
<div class="table_container">
<html:form action="/fee/woff/acct.do?CMD=SAVE" styleId="formItem" method="post" onsubmit="return ev_check();">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_sk_acctname"/>
    <html:hidden property="_ne_accttype"/>
    <html:hidden property="_ne_acctstate"/>
    <html:hidden property="oldAcctlev"/>
    <input type="hidden" name="_rowcount"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    
    <div class="table_div">	
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="acct" key="custMsg"/></td>
		</table>
	</div>	
	<div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>
    
	<div class="table_div">	
        <table class="form_table">
        	<tr>
				<td colspan="2"><bean:message bundle="fee" key="redStarExplain"/></td>
			</tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="acctid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${!empty param.CMD and param.CMD eq 'NEW'}">
                            <html:text styleClass="form_input_1x" property="acctid" maxlength="14"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="acctname"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="acctname" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="accttype"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
							<html:select property="accttype">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_FEETYPE" nameOnly="false"/>
							</html:select>
                        </c:when>
                        <c:otherwise>
							<html:select property="accttype" disabled="true">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_FEETYPE" nameOnly="false"/>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="acctstate"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
							<html:select property="acctstate">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_ACCTSTATE" nameOnly="false"/>
							</html:select>
                        </c:when>
                        <c:otherwise>
							<html:select property="acctstate" disabled="true">
								<html:option value=" "></html:option>
								<s:Options definition="$IB_ACCTSTATE" nameOnly="false"/>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="starttime"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="starttime" onclick="this.value=selectDate()" maxlength="10"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="starttime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="stoptime"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="stoptime" onclick="this.value=selectDate()" maxlength="10"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="stoptime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="acctlevel"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
							<html:select property="acctlevel" onchange="checkAcctSet(false)">
								<s:Options definition="$IB_FEELEVEL" nameOnly="false"/>
							</html:select>
                        </c:when>
                        <c:otherwise>
							<html:select property="acctlevel" disabled="true">
								<s:Options definition="$IB_FEELEVEL" nameOnly="false"/>
							</html:select>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="limitflag"/>:</div></td>
                <td class="form_table_left">
                	<html:hidden property="limitflag"/>
                    <c:choose>
                        <c:when test="${edtState}">
                            <span>
						        <input type="checkbox" name="limitbox" class="table_checkbox" value="0">
                        		<bean:message bundle="acct" key="limitflag1"/>
                      			<input type="checkbox" name="limitbox" class="table_checkbox" value="1">
                        		<bean:message bundle="acct" key="limitflag2"/>
                        		<input type="checkbox" name="limitbox" class="table_checkbox" value="2">
                        		<bean:message bundle="acct" key="limitflag3"/>
                        		<input type="checkbox" name="limitbox" class="table_checkbox" value="3">
                        		<bean:message bundle="acct" key="limitflag4"/>
                      		</span>
                        </c:when>
                        <c:otherwise>
                            <span>
						        <input type="checkbox" name="limitbox" class="table_checkbox" value="0" disabled="disabled">
                        		<bean:message bundle="acct" key="limitflag1"/>
                      			<input type="checkbox" name="limitbox" class="table_checkbox" value="1" disabled="disabled">
                        		<bean:message bundle="acct" key="limitflag2"/>
                        		<input type="checkbox" name="limitbox" class="table_checkbox" value="2" disabled="disabled">
                        		<bean:message bundle="acct" key="limitflag3"/>
                        		<input type="checkbox" name="limitbox" class="table_checkbox" value="3" disabled="disabled">
                        		<bean:message bundle="acct" key="limitflag4"/>
                      		</span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="woffpri"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="woffpri" maxlength="10"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="woffpri" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="acctcode"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="acctcode" maxlength="12"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="acctcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="printname"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="printname" maxlength="128"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="printname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color=red>&nbsp;*</font>
                </td>
            </tr>
            <tr>
                <td class="form_table_right"><div class="field-require"><bean:message bundle="acct" key="acctsetid"/>:</div></td>
                <td class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <s:zoom definition="#WOFF-ACCT" property="acctsetid" styleClass="form_input_1x" condition="acctlevel:0"/>
                        </c:when>
                        <c:otherwise>
                    		<s:zoom definition="#WOFF-ACCT" property="acctsetid" styleClass="form_input_1x" condition="acctlevel:0" showonly="true"/>
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
                	<s:PurChk controlid="<%=ID_1%>">
                	<c:choose>
                        <c:when test="${edtState}">
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" 
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/fee/woff/acct.do?CMD=SAVE')"/>
                        </c:when>
                        <c:otherwise>
                    		<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" 
                    	   disabled="disabled"                  
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/fee/woff/acct.do?CMD=SAVE')"/>
                        </c:otherwise>
                    </c:choose>
                    
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_2%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    </s:PurChk>
                    <s:PurChk controlid="<%=ID_3%>">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/fee/woff/acct.do?CMD=LIST')">
                	</s:PurChk>
                </td>
            </tr>
        </table>
    </div>
    
</html:form>
</div>
</body>
</html:html>
