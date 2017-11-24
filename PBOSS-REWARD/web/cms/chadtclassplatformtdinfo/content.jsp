<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sunrise.boss.common.base.db.DataPackage"%>
<%@ page
	import="com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoVO"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chadtclassplatformtdinfo" key="titleUpdate"/></title>
       <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            //addfield('seq', '<bean:message bundle="chadtclassplatformtdinfo" key="seq"/>', 'f', true, '14');
            addfield('tdbrandid', '<bean:message bundle="chadtclassplatformtdinfo" key="tdbrandid"/>', 'f', false, '8');
            addfield('productid', '<bean:message bundle="chadtclassplatformtdinfo" key="productid"/>', 'c', true, '16');
            addfield('comid', '<bean:message bundle="chadtclassplatformtdinfo" key="comid"/>', 'c', false, '36');
           // addfield('comname', '<bean:message bundle="chadtclassplatformtdinfo" key="comname"/>', 'f', true, '128');
            addfield('startdatestr', '<bean:message bundle="chadtclassplatformtdinfo" key="startdate"/>', 'c', false, '10');
            addfield('enddatestr', '<bean:message bundle="chadtclassplatformtdinfo" key="enddate"/>', 'c', false, '10');
            addfield('citycode', '<bean:message bundle="chadtclassplatformtdinfo" key="citycode"/>', 'f', false, '3');
            addfield('adtremark', '<bean:message bundle="chadtclassplatformtdinfo" key="adtremark"/>', 'c', true, '256');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/chadtclassplatformtdinfo.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>
	<html:hidden property="region"/>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_tdbrandid"/>
    <html:hidden property="_dnl_startdate"/>
    <html:hidden property="_ne_citycode"/>
    <html:hidden property="seq"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtclassplatformtdinfo/ChadtclassplatformtdinfoForm']}"/>
    
    

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtclassplatformtdinfo" key="titleList"/>
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
        <!-- 
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="seq"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="seq" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="seq" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="seq" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             -->
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="tdbrandid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        
                        <select name="tdbrandid">
								<option value=""></option>
									<% DataPackage dpp = (DataPackage)request.getAttribute("CH_ADT_CLASSPLATFORMBRAND"); 
                	if (dpp != null && dpp.getDatas() != null && dpp.getDatas().size()>0) {
						for (int i = 0; i < dpp.getDatas().size(); i++) {
						List list = (ArrayList)dpp.getDatas();
						ChAdtClassplatformbrandinfoVO chAdtClassplatformbrandinfoVO = (ChAdtClassplatformbrandinfoVO)list.get(i);
						
						%>
						<option value="<% out.print(chAdtClassplatformbrandinfoVO.getBrandid()); %>" <% if(request.getAttribute("tdbrandid") != null && (request.getAttribute("tdbrandid").toString().trim()).equals(chAdtClassplatformbrandinfoVO.getBrandid().toString().trim())){out.print("selected='true'");}%>>
										<% out.print(chAdtClassplatformbrandinfoVO.getBrandname()); %>
									</option>
						<%
						}
					}
                %>
								</select>
                        </c:when>
                        <c:otherwise>
                        <select name="tdbrandid" disabled="true">
								<option value=""></option>
									<% DataPackage dpp2 = (DataPackage)request.getAttribute("CH_ADT_CLASSPLATFORMBRAND"); 
                	if (dpp2 != null && dpp2.getDatas() != null && dpp2.getDatas().size()>0) {
						for (int j = 0; j < dpp2.getDatas().size(); j++) {
						List lists = (ArrayList)dpp2.getDatas();
						ChAdtClassplatformbrandinfoVO chAdtClassplatformbrandinfoVO2 = (ChAdtClassplatformbrandinfoVO)lists.get(j);
						
						%>
						<option value="<% out.print(chAdtClassplatformbrandinfoVO2.getBrandid()); %>" <% if(request.getAttribute("tdbrandid") != null && (request.getAttribute("tdbrandid").toString().trim()).equals(chAdtClassplatformbrandinfoVO2.getBrandid().toString().trim())){out.print("selected='true'");}%>>
										<% out.print(chAdtClassplatformbrandinfoVO2.getBrandname()); %>
									</option>
						<%
						}
					}
                %>
								</select>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="productid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="productid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="productid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="comid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <s:Comidtree styleClass="form_input_1x" property="comid" condition="comclassid:2;comclassid:5;comclassid:6;comclassid:99;comclassid:1" definition="#COMSYSTEM" nameOnly="false" readonly="true"/>
                           <!-- <html:text styleClass="form_input_1x" property="comid" /> --> 
                        </c:when>
                        <c:otherwise>
                        <!--<s:Comidtree styleClass="form_input_1x" property="comid" condition="comclassid:2;comclassid:5;comclassid:6;comclassid:99;comclassid:1" definition="#COMSYSTEM" nameOnly="false" disabled="true"/> -->
                             <html:text styleClass="form_input_1x" property="comid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
           <!-- <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="comname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="comname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="comname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
             --> 
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="startdate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <!-- <input type='text' class="form_input_1x" name="startdate"
									value='<fmt:formatDate pattern="yyyy-MM-dd" value="${form.startdate}"/>'
								onclick="this.value = selectDate()"	readonly="true"/> -->
                       
                         <html:text styleClass="form_input_1x" property="startdatestr"
									onclick="this.value=selectDate();" readonly="true"></html:text>
									
                        </c:when>
                        <c:otherwise>
                        <!--  <input type='text' class="form_input_1x" name="startdate"
									value="<fmt:formatDate pattern='yyyy-MM-dd' value='${form.startdate}'/>"
									disabled="true"/> -->
                     <html:text styleClass="form_input_1x" property="startdatestr" disabled="true"></html:text> 
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="enddate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                       <!--  <input type='text' class="form_input_1x" name="enddate"
									value="<fmt:formatDate pattern='yyyy-MM-dd' value='${form.enddate}'/>"
								onclick="this.value = selectDate()"	readonly="true"/> -->
                       <html:text styleClass="form_input_1x" property="enddatestr"
									onclick="this.value=selectDate();" readonly="true"></html:text>
                        </c:when>
                        <c:otherwise>
                        <!--  <input type='text' class="form_input_1x" name="enddate"
									value="<fmt:formatDate pattern='yyyy-MM-dd' value='${form.enddate}'/>"
								    disabled="true"/> -->
                         <html:text styleClass="form_input_1x" property="enddatestr" disabled="true"></html:text>
                        </c:otherwise>
                    </c:choose>
                    <font color="red">*</font>
                </td>
            </tr>
            
            <!-- 
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="citycode"/>:</div></td>
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
                    
                    <font color="red">*</font>
                </td>
            </tr>
            
             -->
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="chadtclassplatformtdinfo" key="adtremark"/>:</div></td>
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
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/chadtclassplatformtdinfo.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/chadtclassplatformtdinfo.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
