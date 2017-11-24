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
    <title><bean:message bundle="vchpdrprewardrecord" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {  
       
            addfield('rpseqid', '<bean:message bundle="vchpdrprewardrecord" key="rpseqid"/>', 'f', true, '14');
            addfield('provagentid', '<bean:message bundle="vchpdrprewardrecord" key="provagentid"/>', 'c', false, '15');
            addfield('prodno', '<bean:message bundle="vchpdrprewardrecord" key="prodno"/>', 'c', false, '18');
            addfield('rewardmonth', '<bean:message bundle="vchpdrprewardrecord" key="rewardmonth"/>', 'c', false, '8');
            addfield('phase', '<bean:message bundle="vchpdrprewardrecord" key="phase"/>', 'f', false, '3');
            addfield('cityid', '<bean:message bundle="vchpdrprewardrecord" key="cityid"/>', 'c', false, '4');
            addfield('rpmoney', '<bean:message bundle="vchpdrprewardrecord" key="rpmoney"/>', 'f', false, '15','4');  
            //return checkval(window);
           return (checkval(window) && checkRpmoney());
         }
        function checkRpmoney(){
            var rpmoney = document.getElementById('rpmoney').value;
            var s=rpmoney.replace(/(^\s*)|(\s*$)/g, ""); 
            var pattern=/^(-?(0{1}|[1-9]{1}\d{0,7}))(\.\d{1,4})?$/gi;
             if(pattern.test(s)==false){ 
              var alertstr = '奖罚金额不合法！规则为：整数部分最多允许8位，最多允许4位小数';
        			errorMessageShow(alertstr);
        	        
			 	   	  return false;
             }
             return true;
        }
   
       
        
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/provagent/vchpdrprewardrecord.do?CMD=SAVE" styleId="formItem" method="post">
	<html:hidden property="rpseqid"/>

    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_se_provagentid"/>
    <html:hidden property="_se_prodno"/>
    <html:hidden property="_se_rewardmonth"/>
    <html:hidden property="_se_cityid"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/VChPdRprewardrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="vchpdrprewardrecord" key="titleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vchpdrprewardrecord" key="provagentid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                         <c:if test="${updateState}">
                            <html:select styleClass="form_input_1x" property="provagentid"  disabled="true">
                    	     <option></option>
						     <s:Options definition="#CH_PD_AGENT"/>
					      </html:select>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select styleClass="form_input_1x" property="provagentid"  >
                    	     <option></option>
						     <s:Options definition="#CH_PD_AGENT"/>
					      </html:select>&nbsp;<font color='red'>*</font>
                        </c:if> 
                        </c:when>
                        <c:otherwise>  
                            <html:select styleClass="form_input_1x" property="provagentid" disabled="true" >
                    	     <option></option>
						     <s:Options definition="#CH_PD_AGENT"/>
					      </html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vchpdrprewardrecord" key="prodno"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           <c:if test="${updateState}">
                           <html:text styleClass="form_input_1x" property="prodno"  readonly="true"/> 
                        </c:if>
                        <c:if test="${!updateState}">
                           <html:text styleClass="form_input_1x" property="prodno"  />&nbsp;<font color='red'>*</font>
                        </c:if>
                            
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prodno"  disabled="true" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vchpdrprewardrecord" key="rewardmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                         <c:if test="${updateState}">
                           <html:text styleClass="form_input_1x" property="rewardmonth" onclick="this.value=selectDateYYYYMM();" disabled="true"></html:text>
                        </c:if>
                        <c:if test="${!updateState}">
                           <html:text styleClass="form_input_1x" property="rewardmonth" onclick="this.value=selectDateYYYYMM();" ></html:text>&nbsp;<font color='red'>*</font>
                        </c:if>
                           
                        </c:when>
                        <c:otherwise>
                           <html:text styleClass="form_input_1x" property="rewardmonth" onclick="this.value=selectDateYYYYMM();" disabled="true"></html:text>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vchpdrprewardrecord" key="phase"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                         <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="phase" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="phase"/>&nbsp;<font color='red'>*</font>
                        </c:if>
                          
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="phase" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vchpdrprewardrecord" key="cityid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                             <html:select styleClass="form_input_1x" property="cityid" disabled="true" >
						          <s:Options definition="#REGIONNAME"/> 
						     </html:select>   
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:select styleClass="form_input_1x" property="cityid"   >
						          <s:Options definition="#REGIONNAME"/> 
						     </html:select>&nbsp;<font color='red'>*</font>
                        </c:if>
                              
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cityid" disabled="true" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="vchpdrprewardrecord" key="rpmoney"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                           
                            <html:text styleClass="form_input_1x" property="rpmoney" />&nbsp;<font color='red'>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="rpmoney" disabled="true" />
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
                           onclick="doSave('/cms/provagent/vchpdrprewardrecord.do?CMD=SAVE')"/>
                    
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/provagent/vchpdrprewardrecord.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
