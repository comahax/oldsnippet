<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A1A40" />
</jsp:include>

<html:html>
<head>
    <title><bean:message bundle="citycompany" key="titleUpdate"/></title>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
        	if(document.all("longitude").value!=""){
        		if(document.all("longitude").value*1<100 ||document.all("longitude").value*1>130 || !document.all("longitude").value.match("[0-9]{2}(.?)[0-9]{6}")){
        			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[办公地点经度]</span>' + '经度值必须在100 － 130 之间并且精确到小数后6位!' + '</span>';
        			errorMessageShow(alertstr);
            		return false;
            	}
            }
            if(document.all("latitude").value!=""){
            	if(document.all("latitude").value*1<18 ||document.all("latitude").value*1>26 || !document.all("latitude").value.match("[0-9]{1}(.?)[0-9]{6}")){
            		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[办公地点纬度]</span>' + '纬度值必须在18 － 26 之间并且精确到小数后6位!' + '</span>';
            		errorMessageShow(alertstr);
            		return false;
            	}
            }
            addfield('citycompid', '<bean:message bundle="citycompany" key="citycompid"/>', 'c', false, 14);
            addfield('citycompname', '<bean:message bundle="citycompany" key="citycompname"/>', 'c', false, 64);
            addfield('centerid', '<bean:message bundle="citycompany" key="centerid"/>', 'c', false, 14);
            addfield('citycomptype', '<bean:message bundle="citycompany" key="citycomptype"/>', 'i', true, 3);
            addfield('agent', '<bean:message bundle="citycompany" key="agent"/>', 'c', false, 64);
            addfield('billingcode', '<bean:message bundle="citycompany" key="billingcode"/>', 'c', false, 5);
            addfield('adacode', '<bean:message bundle="citycompany" key="adacode"/>', 'c', true, '18');
            addfield('longitude', '<bean:message bundle="citycompany" key="longitude"/>', 'c', true, '10');
            addfield('latitude', '<bean:message bundle="citycompany" key="latitude"/>', 'c', true, '9');
            return checkval(window);
        }
        function doSave(){
        	if (ev_checkval()) {
        	enable();
  			formItem.action = contextPath + "/cms/citycompany.do?CMD=SAVE";
  		    formItem.submit();
  		    <%
  		    String affirm = request.getAttribute("affirm")==null?"":request.getAttribute("affirm").toString();
  		    String adacode = request.getAttribute("adacode")==null?"":request.getAttribute("adacode").toString();
  		    String confirmorgcode = request.getAttribute("confirmorgcode")==null?"":request.getAttribute("confirmorgcode").toString();
  		    %>
  		    
  		    }
  			return false;
		}
		function alertAffirm(){
			var affirm = "<%=affirm%>";
  		    //alert( "affirm" + affirm);
  		    if("false"==affirm) {
  		    	var msg = "本记录保存成功! 行政区划编码"+" "+"<%=adacode%>"+" "+"已经指定到组织"+" "+"<%=confirmorgcode%>"+" "+"，如确认继续，请点击\"确定\"";
				if (confirm(msg)){
				formItem.action = contextPath + "/cms/citycompany.do?CMD=CHANGEORG";
  		    	formItem.submit();
				}
  		    }
		}        
    </script>
</head>
<body onload="loadforiframe();" >
<div class="table_container">
<html:form action="/cms/citycompany.do?CMD=SAVE" styleId="formItem" method="post">
  <html:hidden property="cmdState"/>
  <html:hidden property="_orderby"/>
  <html:hidden property="_desc"/>
  <html:hidden property="_pageno"/>
  <html:hidden property="_pagesize"/>
  <html:hidden property="_sk_citycompid"/> 
  <html:hidden property="_sk_citycompname"/>    
  <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    
	<div class="table_div">
		<table class="top_table">
			<tr>
				<td>
					<bean:message bundle="citycompany" key="titleList"/>
				</td>
			</tr>
		</table>
	</div>	
	
	<div class="table_div">
	  <table width="100%" class="error_text">
    	<s:Msg />
    </table>	
  </div>
    
   <div class="table_div">
        <table class="form_table">
        	<tr>
				      <td align=left colspan=2>&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/></td>
			    </tr>
            
          <tr>
                <td width="15%" align="right"><div class="field-require"><bean:message bundle="citycompany" key="citycompid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${param.CMD eq 'NEW'}">
                            <html:text styleClass="form_input_1x" property="citycompid" maxlength="24"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citycompid" readonly="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="citycompany" key="citycompname"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="citycompname" maxlength="24"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citycompname" readonly="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="citycompany" key="centerid"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                          <html:select property="centerid">
	                          		<option/>
	                        		<s:Options definition="#AREACENTER" />
	                        	</html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
	                          <html:select property="centerid" disabled="true">
	                        		 <option/>
	                        		 <s:Options definition="#AREACENTER" />
	                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>             
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="citycompany" key="citycomptype"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	  <html:select property="citycomptype">
                        		 <option/>
                        		 <s:Options definition="$CH_CITYCOMPTYPE"/>
                        	  </html:select>  
                        </c:when>
                        <c:otherwise>
                        	  <html:select property="citycomptype" disabled="true">
                        		 <option/>
                        		 <s:Options definition="$CH_CITYCOMPTYPE"/>
                        	  </html:select>  
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="citycompany" key="agent"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="agent"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="agent" readonly="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="citycompany" key="billingcode"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="billingcode"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="billingcode" readonly="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="citycompany" key="areacode"/>:</div></td>
                <td width="75%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="areacode"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="areacode" readonly="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="citycompany" key="adacode"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adacode" maxlength="18" readonly="true" onclick="showAdaTree(this,'adacode');"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adacode" readonly="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="citycompany" key="longitude"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="longitude" maxlength="10"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="longitude" readonly="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                 <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="citycompany" key="latitude"/>:</div></td>
                <td width="75%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="latitude" maxlength="9"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="latitude" readonly="true"/>
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
                     name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                     value="<bean:message bundle="public" key="button_save"/>" class="submit"
                     onclick="doSave()"/>
	            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                   name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
	                   value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                   name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                   value="<bean:message bundle="public" key="button_return"/>" class="close"
	                   onclick="doReturn('/cms/citycompany.do?CMD=LIST')">
					</td>
				</tr>
			</table>
		</div>
    
</html:form>
</div>
</body>
	<script>
	alertAffirm();
	</script>
</html:html>
