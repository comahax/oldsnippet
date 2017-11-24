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
    <title><bean:message bundle="terminalrewardstd" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('comid', '<bean:message bundle="terminalrewardstd" key="comid"/>', 'c', false, '18');
            addfield('rewardtype', '<bean:message bundle="terminalrewardstd" key="rewardtype"/>', 'f', false, '2');
            addfield('acctype', '<bean:message bundle="terminalrewardstd" key="acctype"/>', 'f', false, '3');
            addfield('adtremark', '<bean:message bundle="terminalrewardstd" key="adtremark"/>', 'c', true, '128'); 
            addfield('standardprice', '基准价', 'f', true, '12','2'); 
            
              return checkval(window);
        }
        
        function selectDateYYYYMMDD() {
			var arg = new Object();
			strTime = "";
			valTime = event.srcElement.value;
			if (isDateYYYYMMDD(valTime) == false) {
			strTime = "";
			} else {
			strTime = valTime.substring(0, 4) + "-" + valTime.substring(4, 6) + "-01";
			}
			arg.str_datetime = strTime;
			arg.time_comp = false;
			var rtn = window.showModalDialog("<%=contextPath%>/js/pub/calendar.html", arg, "dialogWidth=210px;dialogHeight=240px;status:no;scroll=no;");
			if (rtn != null) {
			rtn = rtn.split("-")[0] + rtn.split("-")[1];
			}
			return (rtn == null ? valTime : rtn);
		}
		
		function isDateYYYYMM(str) {
			var reg = /^(\d{1,4})(\d{1,2})/;
			var r = str.match(reg);
			if (r == null) {
				return false;
			} else {
				var d = new Date(r[1], r[2] - 1);
				if (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2]) {
					return true;
				} else {
					return false;
				}
			}
		}
        
        function doReturn1(url){
       		var region=document.getElementById('region').value;
        	formItem.action=contextPath + url + "&region="+region;
			formItem.submit();
		} 
        
    </script>
</head>
<body>
<div class="table_container"> 
<html:form action="/cms/terminalrewardstd.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
	<html:hidden property="region"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_rewardtype"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/terminalrewardstd/TerminalrewardstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="terminalrewardstd" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="terminalrewardstd" key="comid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="comid" disabled="true"/>
                       		<font color=red>&nbsp;*</font>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="comid" />
                            <font color=red>&nbsp;*</font>
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="comid" disabled="true"/>
                        	<font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="terminalrewardstd" key="rewardtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                           <!--  <html:text styleClass="form_input_1x" property="rewardtype" readonly="true"/>  -->
                        	<html:select styleClass="form_input_1x" property="rewardtype"  disabled="true" >
                            		<s:Options definition="$CH_TERREWARDTYPE"/>
                            </html:select>	
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select styleClass="form_input_1x" property="rewardtype" >
                            		<s:Options definition="$CH_TERREWARDTYPE"/>
                            </html:select>		
                        </c:if>
                        <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select styleClass="form_input_1x" property="rewardtype" disabled="true">
                            	<s:Options definition="$CH_TERREWARDTYPE"/>
                            </html:select>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="terminalrewardstd" key="acctype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select styleClass="form_input_1x" property="acctype" >
                            	<s:Options definition="#CH_ACCTYPE"/>
                            </html:select>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:select styleClass="form_input_1x" property="acctype" disabled="true">
                            	<s:Options definition="#CH_ACCTYPE"/>
                            </html:select>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="terminalrewardstd" key="adtremark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adtremark" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adtremark" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
           
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="terminalrewardstd" key="createtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        	<input type='text' class="form_input_1x" name="createtime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.createtime}"/>"
									onclick="this.value=selectDate()" disabled="disabled"    />
                        	<font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <input type='text' class="form_input_1x" name="createtime"
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${form.createtime}"/>"
									onclick="this.value=selectDate()" disabled="disabled"  />
                        	<font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="terminalrewardstd" key="citycode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:select styleClass="form_input_1x" property="citycode" disabled="true">
                            	<s:Options definition="#CITYIDNUM2NMAME"/>
                            </html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select styleClass="form_input_1x" property="citycode" disabled="true">
                            	<s:Options definition="#CITYIDNUM2NMAME"/>
                            </html:select>
                        </c:if>
                        <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                        	<html:select styleClass="form_input_1x" property="citycode" disabled="true">
                            	<s:Options definition="#CITYIDNUM2NMAME"/>
                            </html:select>
                            <font color=red>&nbsp;*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr> 
                <td width="20%" align="right" class="form_table_right"><div class="field-require">基准价:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="standardprice" />
                        <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="standardprice" disabled="true"/>
                        <font color=red>&nbsp;*</font>
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
                           onclick="doSave('/cms/terminalrewardstd.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn1('/cms/terminalrewardstd.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
 
</body>
</html>
