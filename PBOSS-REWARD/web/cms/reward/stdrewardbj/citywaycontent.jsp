<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<base target="_self"/>
<head>
    <title><bean:message bundle="stdrewardbj" key="waytitleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('s_cityrewardstd', '<bean:message bundle="stdrewardbj" key="cityrewardstd_scale"/>', 'f', false, '14','4','','0',formItem.s_rewardstd.value);
            addfield('s_wayid', '<bean:message bundle="stdrewardbj" key="wayid"/>', 'c', false, '18');
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/stdrewardbj.do?CMD=SAVECITYWAY" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDITCITYWAY' or param.CMD eq 'NEWCITYWAY')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDITCITYWAY')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/stdrewardbj/StdrewardbjForm']}"/>
    
    <html:hidden property="s_opnid" />
    <html:hidden property="s_rewardid" />
    <html:hidden property="s_acctype" />
    <html:hidden property="s_ruleid" />
    <html:hidden property="s_rewardstd" />

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="stdrewardbj" key="waytitleList"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
	                        <c:if test="${updateState}">
	                            <html:text styleClass="form_input_1x" property="s_wayid" disabled="true"/>
	                        </c:if>
	                        <c:if test="${!updateState}">
	                        	<html:text styleClass="form_input_1x" property="s_wayid" readonly="true"/>
               	 				<input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'s_wayid','','','AG');this.value='...';" />
	                        </c:if>
	                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="s_wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="stdrewardbj" key="cityrewardstd_scale"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="s_cityrewardstd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="s_cityrewardstd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                    (省公司酬金上限:<font color="red"><c:out value="${form.s_rewardstd}" /></font>元/百分比)
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
		                           onclick="doSave('/cms/reward/stdrewardbj.do?CMD=SAVECITYWAY&NEWCMD=<c:out value="${form.cmdState}" />')"/>
		                </c:when>
		                <c:otherwise>
		                	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
		                           disabled="disabled"/>
		                </c:otherwise>
		           	</c:choose>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/stdrewardbj.do?CMD=SHOWCITYWAY&s_cityrewardstd=&s_wayid=')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
